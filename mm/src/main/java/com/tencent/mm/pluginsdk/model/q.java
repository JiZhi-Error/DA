package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q {
    private int JVm;
    public String JVn;
    public String JVo;
    public String JVp;
    public int JVq;
    public String productId;

    q(int i2, String str, String str2, String str3, String str4, int i3) {
        this.JVm = i2;
        this.productId = str;
        this.JVn = str2;
        this.JVq = i3;
        this.JVo = str3;
        this.JVp = str4;
    }

    public final String toString() {
        AppMethodBeat.i(151646);
        String str = "id:" + this.JVm + ";productId:" + this.productId + ";full:" + this.JVn + ";productState:" + this.JVq + ";priceCurrencyCode:" + this.JVo + ";priceAmountMicros:" + this.JVp;
        AppMethodBeat.o(151646);
        return str;
    }
}
