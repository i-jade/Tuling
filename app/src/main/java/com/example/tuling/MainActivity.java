package com.example.tuling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //聊天消息列表 ， 输入框 ， 发送按钮
    private RecyclerView recyclerView ;
    private EditText editText ;
    private Button btn_dend ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        recyclerView = findViewById(R.id.recycle);
        editText = findViewById(R.id.et_test);
        btn_dend = findViewById(R.id.btn_send);
        btn_dend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_send:
                        /**
                         *1.获取输入框内容
                         * 2.判断是否为空
                         * 发送后清空当前的输入框
                         */
                        String text = editText.getText().toString();
                        if (!TextUtils.isEmpty(text)) {

                            editText.setText("");
                        }
                        break;
                }
            }
        });
    }
}
