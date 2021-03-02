package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.id;

public final class a {
    public static a CWN = null;
    public id CWO;
    public int CWP;
    public int CWQ;
    public int CWR;
    public int CWS;
    public int CWT;
    public int CWU;
    public int CWV;
    public long CWW;
    public int CWX;
    public int CWY;
    public int CWZ;
    public int CXa;
    public int CXb;
    public long CXc;
    public long CXd;

    public static a eSu() {
        AppMethodBeat.i(187911);
        if (CWN == null) {
            eSv();
        }
        a aVar = CWN;
        AppMethodBeat.o(187911);
        return aVar;
    }

    public static void eSv() {
        AppMethodBeat.i(187912);
        CWN = new a();
        AppMethodBeat.o(187912);
    }

    public a() {
        AppMethodBeat.i(187913);
        this.CWO = null;
        this.CWP = 0;
        this.CWQ = 0;
        this.CWR = 0;
        this.CWS = 0;
        this.CWT = 0;
        this.CWU = 0;
        this.CWV = 0;
        this.CWW = 0;
        this.CWX = 0;
        this.CWY = 0;
        this.CWZ = 0;
        this.CXa = 0;
        this.CXb = 0;
        this.CXc = 0;
        this.CXd = 0;
        this.CWO = new id();
        AppMethodBeat.o(187913);
    }

    public final void un(boolean z) {
        int i2;
        id idVar = this.CWO;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        idVar.eMW = i2;
    }

    public final void IF(long j2) {
        this.CWO.eMZ = j2;
    }

    public final void eSw() {
        this.CWS++;
    }

    public final void eSx() {
        this.CWT++;
    }

    public final void IG(long j2) {
        if (j2 > this.CWW) {
            this.CWO.eNi = j2 - this.CWW;
        }
    }

    public final void eSy() {
        this.CWZ++;
    }
}
