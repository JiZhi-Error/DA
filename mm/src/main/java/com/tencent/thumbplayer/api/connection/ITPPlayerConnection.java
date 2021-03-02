package com.tencent.thumbplayer.api.connection;

public interface ITPPlayerConnection {
    int activeAllConnections();

    int activeConnection(int i2);

    int addConnection(long j2, TPPlayerConnectionNode tPPlayerConnectionNode, long j3, TPPlayerConnectionNode tPPlayerConnectionNode2);

    void deactiveAllConnections();

    void deactiveConnection(int i2);

    void init();

    void removeConnection(int i2);

    void uninit();
}
