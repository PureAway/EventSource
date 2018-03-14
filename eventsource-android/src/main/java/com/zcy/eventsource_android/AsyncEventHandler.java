package com.zcy.eventsource_android;


import java.util.concurrent.Executor;


class AsyncEventHandler implements EventHandler {
    private final Executor executor;
    private final EventHandler eventSourceHandler;

    AsyncEventHandler(Executor executor, EventHandler eventSourceHandler) {
        this.executor = executor;
        this.eventSourceHandler = eventSourceHandler;
    }

    public void onOpen() {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    eventSourceHandler.onOpen();
                } catch (Exception e) {
                    onError(e);
                }
            }
        });
    }

    public void onClosed() {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    eventSourceHandler.onClosed();
                } catch (Exception e) {
                    onError(e);
                }
            }
        });
    }

    public void onComment(final String comment) {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    eventSourceHandler.onComment(comment);
                } catch (Exception e) {
                    onError(e);
                }
            }
        });
    }

    public void onMessage(final String event, final MessageEvent messageEvent) {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    eventSourceHandler.onMessage(event, messageEvent);
                } catch (Exception e) {
                    onError(e);
                }
            }
        });
    }

    public void onError(final Throwable error) {
        executor.execute(new Runnable() {
            public void run() {
                try {
                    eventSourceHandler.onError(error);
                } catch (Throwable ignored) {
                }
            }
        });
    }
}