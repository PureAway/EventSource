package com.zcy.eventsource_android;

interface ConnectionHandler {

    void setReconnectionTimeMs(long reconnectionTimeMs);

    void setLastEventId(String lastEventId);
}