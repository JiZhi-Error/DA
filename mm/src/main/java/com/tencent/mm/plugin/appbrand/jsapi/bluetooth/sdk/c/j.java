package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;

public final class j {
    public static final j lNA = new j((int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, "fail:no service");
    public static final j lNB = new j(10005, "fail:no characteristic");
    public static final j lNC = new j(10006, "fail:no connection");
    public static final j lND = new j((int) CdnLogic.kMediaTypeFavoriteBigFile, "fail:property not support");
    public static final j lNE = new j(10008, "fail:system error");
    public static final j lNF = new j(10009, "fail:system not support");
    public static final j lNG = new j(10008, "fail:no descriptor");
    public static final j lNH = new j(10008, "fail:fail to set descriptor");
    public static final j lNI = new j(10008, "fail:fail to write descriptor");
    public static final j lNJ = new j(10012, "fail:operate time out");
    public static final j lNK = new j(-1, "fail:already connect");
    public static final j lNL = new j(10013, "fail:invalid data");
    public static final j lNM = new j(10008, "fail:not found service");
    public static final j lNN = new j(10014, "fail:need pin");
    public static final j lNu = new j(0, "");
    public static final j lNv = new j(-1, "fail:internal error");
    public static final j lNw = new j(10000, "fail:not init");
    public static final j lNx = new j(10001, "fail:not available");
    public static final j lNy = new j(10002, "fail:no device");
    public static final j lNz = new j((int) ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, "fail:connection fail");
    public int errCode;
    public String errMsg;
    public final Object lNO;

    static {
        AppMethodBeat.i(144596);
        AppMethodBeat.o(144596);
    }

    public static j cF(Object obj) {
        AppMethodBeat.i(175631);
        j jVar = new j("", obj);
        AppMethodBeat.o(175631);
        return jVar;
    }

    public j(int i2, String str) {
        this.errCode = i2;
        this.errMsg = str;
        this.lNO = null;
    }

    private j(String str, Object obj) {
        this.errCode = 0;
        this.errMsg = str;
        this.lNO = obj;
    }

    public final String toString() {
        AppMethodBeat.i(144595);
        String str = "Result{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", retObj=" + this.lNO + '}';
        AppMethodBeat.o(144595);
        return str;
    }
}
