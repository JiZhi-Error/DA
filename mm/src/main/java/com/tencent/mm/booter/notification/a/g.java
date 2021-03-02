package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.f;

public final class g {
    public b goI;
    public c goJ;
    public d goK;
    public h goL;
    private f goM;
    public a goN;
    public int goO;
    public int goP;
    public int goQ;
    public int goR;
    public boolean goS;
    private int goT = -1;
    private int goU = -1;
    public boolean goV;
    public boolean goW;
    public Context mContext;

    public g(Context context) {
        AppMethodBeat.i(20067);
        this.mContext = context;
        this.goI = new b();
        this.goJ = new c();
        this.goK = new d();
        this.goL = new h();
        this.goN = new a();
        this.goM = f.a.alu();
        AppMethodBeat.o(20067);
    }

    public final int alv() {
        AppMethodBeat.i(231503);
        if (this.goP == -1) {
            this.goP = com.tencent.mm.n.g.aqF();
        }
        int i2 = this.goP;
        AppMethodBeat.o(231503);
        return i2;
    }

    public final int alw() {
        AppMethodBeat.i(231504);
        if (this.goQ == -1) {
            this.goQ = com.tencent.mm.n.g.aqG();
        }
        int i2 = this.goQ;
        AppMethodBeat.o(231504);
        return i2;
    }

    public final void Df(String str) {
        AppMethodBeat.i(20068);
        this.goM.De(str);
        AppMethodBeat.o(20068);
    }

    public static String a(long[] jArr) {
        AppMethodBeat.i(20069);
        if (jArr == null) {
            AppMethodBeat.o(20069);
            return null;
        }
        String str = "";
        for (int i2 = 0; i2 < jArr.length; i2++) {
            str = str + String.valueOf(jArr[i2]) + ",";
        }
        if (str.isEmpty()) {
            AppMethodBeat.o(20069);
            return str;
        }
        String substring = str.substring(0, str.length() - 1);
        AppMethodBeat.o(20069);
        return substring;
    }
}
