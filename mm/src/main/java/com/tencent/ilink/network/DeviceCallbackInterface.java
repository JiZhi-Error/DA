package com.tencent.ilink.network;

public interface DeviceCallbackInterface {
    void OnFinishGetStrategy();

    void OnLonglinkConnected();

    void OnLonglinkDisconnected();

    void OnSessionTimeout();
}
