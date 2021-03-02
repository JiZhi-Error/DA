package com.tencent.mm.network;

import com.tencent.mm.protocal.l;

public interface s {
    boolean getIsLongPolling();

    boolean getIsUserCmd();

    int getLongPollingTimeout();

    int getNewExtFlags();

    int getOptions();

    l.d getReqObj();

    l.e getRespObj();

    int getTimeOut();

    byte[] getTransHeader();

    int getType();

    String getUri();

    boolean isSingleSession();

    boolean keepAlive();

    void setConnectionInfo(String str);
}
