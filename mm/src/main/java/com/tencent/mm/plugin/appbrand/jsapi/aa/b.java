package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;

public final class b {
    public static final b muA = new b(10104, "The card is issuing, can not retry issuing");
    public static final b muB = new b(10105, "Huawei Pay unsupported by this ROM");
    public static final b muC = new b(10106, "The wallet version too low");
    public static final b muD = new b(10107, "The card can not issued");
    public static final b muE = new b(10108, "The issue card service is unavailable");
    public static final b muF = new b(10109, "The recharge service is unavailable");
    public static final b muG = new b(10110, "Check traffic card conditions failed");
    public static final b muH = new b(10201, "Query traffic card info failed");
    public static final b muI = new b(10202, "The card is not issued");
    public static final b muJ = new b(10203, "The card is issuing, can retry issuing");
    public static final b muK = new b(10204, "Huawei account is not correct");
    public static final b muL = new b(10301, "Issue card failed");
    public static final b muM = new b(10302, "The orderNo is used");
    public static final b muN = new b(10401, "Recharge traffic card failed");
    public static final b muO = new b(10501, "Set default card failed");
    public static final b muP = new b(10502, "Traffic card already set to default");
    public static final b muQ = new b(99999, "Undefined error");
    public static final b mun = new b(0, "ok");
    public static final b muo = new b(10001, "Invalid parameters");
    public static final b mup = new b(10002, "Network unavailable");
    public static final b muq = new b(ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, "NFC not open");
    public static final b mur = new b(ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, "eSE unsupported");
    public static final b mus = new b(10005, "Internal system error");
    public static final b mut = new b(10006, "Permission not granted");
    public static final b muu = new b(CdnLogic.kMediaTypeFavoriteBigFile, "Huawei account is not logined");
    public static final b muv = new b(10008, "The card is not supported");
    public static final b muw = new b(10009, "Huawei pay is not default payment application");
    public static final b mux = new b(10101, "Query CPLC failed");
    public static final b muy = new b(10102, "Total number of card out of max bounds");
    public static final b muz = new b(10103, "The card already issued");
    int errorCode;
    String errorMsg;

    static {
        AppMethodBeat.i(226994);
        AppMethodBeat.o(226994);
    }

    private b(int i2, String str) {
        this.errorCode = i2;
        this.errorMsg = str;
    }

    public static b xq(int i2) {
        switch (i2) {
            case 10001:
                return muo;
            case 10002:
                return mup;
            case ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL /*{ENCODED_INT: 10003}*/:
                return muq;
            case ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL /*{ENCODED_INT: 10004}*/:
            case 10005:
            case 10008:
            case 10205:
            case 10804:
                return mut;
            case 10006:
                return muu;
            case CdnLogic.kMediaTypeFavoriteBigFile:
                return mur;
            case 10009:
                return muv;
            case 10010:
                return muw;
            case 10099:
                return mus;
            case 10101:
                return mux;
            case 10201:
            case 10801:
            case 10901:
                return muI;
            case 10202:
                return muJ;
            case 10203:
            case 10299:
                return muH;
            case 10204:
            case 10602:
            case 10803:
                return muK;
            case 10301:
                return muE;
            case 10302:
                return muF;
            case 10401:
                return muB;
            case 10402:
                return muC;
            case 10403:
                return muD;
            case 10404:
            case 10405:
                return muy;
            case 10406:
            case 10408:
                return muz;
            case 10407:
            case 10502:
                return muA;
            case 10501:
                return muL;
            case 10503:
            case 10603:
                return muM;
            case 10601:
            case 10604:
            case 10605:
            case 10606:
            case 10607:
                return muN;
            case 10802:
                return muP;
            case 10805:
                return muO;
            default:
                return muQ;
        }
    }
}
