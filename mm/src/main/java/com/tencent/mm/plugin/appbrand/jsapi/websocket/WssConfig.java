package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import android.support.annotation.Keep;

public class WssConfig {
    @Keep
    int bz_type;
    @Keep
    int handshake_timeout;
    @Keep
    boolean per_message_deflate;
    @Keep
    int pong_timeout;
    @Keep
    boolean skip_domain_check;
    @Keep
    boolean tcp_no_delay;

    public WssConfig(int i2, int i3, boolean z, boolean z2, int i4, boolean z3) {
        this.pong_timeout = i2;
        this.handshake_timeout = i3;
        this.tcp_no_delay = z;
        this.skip_domain_check = z2;
        this.bz_type = i4;
        this.per_message_deflate = z3;
    }
}
