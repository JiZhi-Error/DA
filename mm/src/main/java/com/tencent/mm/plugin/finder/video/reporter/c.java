package com.tencent.mm.plugin.finder.video.reporter;

import com.facebook.appevents.AppEventsConstants;

public final class c {
    private int wiD = -1;
    private int wiE = -1;
    private int wiF = -1;
    private String wiG = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private int wiH = -1;

    public c(int i2) {
        this.wiD = i2;
    }

    public final int dGa() {
        return this.wiD;
    }

    public final int dGb() {
        return this.wiE;
    }

    public final void Mi(int i2) {
        this.wiE = i2;
    }

    public final int dGc() {
        return this.wiF;
    }

    public final void Mj(int i2) {
        this.wiF = i2;
    }

    public final String dGd() {
        return this.wiG;
    }

    public final void awO(String str) {
        this.wiG = str;
    }

    public final int dGe() {
        return this.wiH;
    }

    public final void Mk(int i2) {
        this.wiH = i2;
    }
}
