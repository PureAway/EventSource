# EventSource
A nice library for android to use eventSource based on okhttp
## 如何使用
```
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

    EventSource eventSource = new EventSource.Builder(eventHandler)
                                          .url("http://localhost:8123/api/stream")
                                          .build();
    eventSource.start()
```
停止时调用：
```
    eventSource.close();
```
## 接入：
```
 implementation 'com.zcy:eventsource-android:0.0.1' // gradle.version > 3

 compile 'com.zcy:eventsource-android:0.0.1' // gradle.version < 3