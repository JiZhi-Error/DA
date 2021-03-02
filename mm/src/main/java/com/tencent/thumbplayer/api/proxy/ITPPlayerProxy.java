package com.tencent.thumbplayer.api.proxy;

public interface ITPPlayerProxy {
    void pushEvent(int i2);

    void setIsActive(boolean z);

    void setProxyServiceType(int i2);

    void setTPPlayerProxyListener(ITPPlayerProxyListener iTPPlayerProxyListener);
}
