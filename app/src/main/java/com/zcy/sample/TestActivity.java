package com.zcy.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zcy.eventsource.R;
import com.zcy.eventsource_android.EventHandler;
import com.zcy.eventsource_android.EventSource;
import com.zcy.eventsource_android.MessageEvent;

/**
 * Created by zcy on 2018/3/20.
 */

public class TestActivity extends AppCompatActivity {

    private EventSource eventSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        eventSource = new EventSource.Builder(eventHandler)
                .url("http://localhost:8123/api/stream")
                .build();
    }


    @Override
    protected void onStart() {
        super.onStart();
        eventSource.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eventSource.close();
    }

    private EventHandler eventHandler = new EventHandler() {
        @Override
        public void onOpen() throws Exception {

        }

        @Override
        public void onClosed() throws Exception {

        }

        @Override
        public void onMessage(String event, MessageEvent messageEvent) throws Exception {
            // 在这里接收服务端发出的消息
            // pass
            // 该回调运行在子线程
        }

        @Override
        public void onComment(String comment) throws Exception {

        }

        @Override
        public void onError(Throwable t) {

        }
    };

}
