package com.tencent.mm.plugin.newtips.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public String ADR = "";
    public boolean ADS = false;
    public int path;

    public e(int i2) {
        this.path = i2;
        this.ADS = false;
    }

    public e(String str) {
        this.ADR = str;
        this.ADS = true;
    }

    public final String toString() {
        AppMethodBeat.i(188570);
        String str = "NewTipsPath{dynamicPath='" + this.ADR + '\'' + ", path=" + this.path + ", isDynamicPtch=" + this.ADS + '}';
        AppMethodBeat.o(188570);
        return str;
    }
}
