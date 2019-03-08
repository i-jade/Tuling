package com.example.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tuling.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {


    //    上下文
    private Context context;

    //    对话列表
    private List<chat> mlist;

    public RecycleViewAdapter() {

    }

    public RecycleViewAdapter(Context context, List<chat> list) {
        this.context = context;
        this.mlist = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        chat chat = mlist.get(position);
        if (chat.getType() == chat.TYPE_RECEIVED) {
//           如果收的的数据是左边，就显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftChat.setText(chat.getText());
//
        } else if (chat.getType() == chat.TYPE_SENT) {
//           如果发出的消息是右边，就显示右边的消息布局，将左边的消息布局隐藏
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightChat.setText(chat.getText());
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    /**
     * 声明控件
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftChat;
        TextView rightChat;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.left_layout);
            rightLayout = itemView.findViewById(R.id.right_layout);
            leftChat = itemView.findViewById(R.id.tv_left_text);
            rightChat = itemView.findViewById(R.id.tv_right_text);
        }
    }
}

