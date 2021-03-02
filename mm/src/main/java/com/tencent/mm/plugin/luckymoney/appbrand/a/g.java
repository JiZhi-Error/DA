package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;
import java.util.List;

public enum g {
    GLOBAL;
    
    public String yPA = "¥";
    public String yPB = MMApplicationContext.getContext().getString(R.string.eo0);
    private List<Object> yPC = new LinkedList();
    public int yPv = 100;
    public double yPw = 200.0d;
    public double yPx = 0.01d;
    public double yPy = 2000.0d;
    public double yPz = 200.0d;

    private g(String str) {
        AppMethodBeat.i(64884);
        AppMethodBeat.o(64884);
    }

    public static g valueOf(String str) {
        AppMethodBeat.i(64883);
        g gVar = (g) Enum.valueOf(g.class, str);
        AppMethodBeat.o(64883);
        return gVar;
    }

    static {
        AppMethodBeat.i(64886);
        AppMethodBeat.o(64886);
    }

    public final String toString() {
        AppMethodBeat.i(64885);
        String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.yPv + ", perPersonMaxValue=" + this.yPw + ", perMinValue=" + this.yPx + ", maxTotalAmount=" + this.yPy + ", mListener=" + this.yPC + '}';
        AppMethodBeat.o(64885);
        return str;
    }
}
