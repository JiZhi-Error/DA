package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    public double cik;
    public double cil;
    public String dPI;
    public String mName;
    public int type;
    public String yMN;
    public String yMO;
    public String yMP;
    public String yMQ;
    public String yMR;
    public String yMS;
    public String yMT;
    public String yMU;
    public String yMV;
    public String yMW;
    public Addr yMX;
    public String yMY;
    public int yMZ = -1;

    public f() {
    }

    public f(cxt cxt, String str) {
        AppMethodBeat.i(56098);
        this.mName = cxt.Name;
        this.yMN = cxt.MCE;
        this.cil = cxt.KUt;
        this.cik = cxt.KUu;
        this.yMO = cxt.MCF;
        this.yMP = cxt.AAN;
        this.yMQ = cxt.MCG;
        this.yMR = cxt.kdZ;
        this.yMS = cxt.kea;
        this.yMT = cxt.LpJ;
        this.yMU = cxt.LpK;
        this.yMV = cxt.MCH;
        this.yMY = str;
        this.yMX = new Addr();
        this.yMX.iUO = this.yMN;
        this.yMX.iUQ = this.yMS;
        this.yMX.iUR = this.yMS;
        this.yMX.iUS = this.yMT;
        this.yMX.iUU = this.yMV;
        this.yMX.iUX = this.mName;
        this.yMX.iUP = this.yMR;
        this.yMX.iUZ = (float) cxt.KUt;
        this.yMX.iUY = (float) cxt.KUu;
        this.type = 0;
        AppMethodBeat.o(56098);
    }

    public final boolean c(Addr addr) {
        AppMethodBeat.i(56099);
        this.yMX = addr;
        if (!Util.isNullOrNil(addr.iUO)) {
            this.mName = addr.iUO;
        }
        if (!Util.isNullOrNil(addr.iUS)) {
            this.yMN = addr.iUS;
        }
        if (!Util.isNullOrNil(addr.iUT)) {
            this.yMN += addr.iUT;
        }
        if (!Util.isNullOrNil(addr.iUU)) {
            this.yMN += addr.iUU;
        }
        if (!Util.isNullOrNil(addr.iUV)) {
            this.yMN += addr.iUV;
        }
        this.cik = (double) addr.iUY;
        this.cil = (double) addr.iUZ;
        this.yMR = addr.iUP;
        this.yMS = addr.iUQ;
        this.yMT = addr.iUS;
        this.yMU = addr.iUU;
        this.yMW = addr.iUW;
        this.yMV = addr.iUV;
        this.dPI = addr.request_id;
        if (!Util.isNullOrNil(this.mName) || !Util.isNullOrNil(this.yMN)) {
            AppMethodBeat.o(56099);
            return true;
        }
        AppMethodBeat.o(56099);
        return false;
    }
}
