package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public final class f {
    public static String wR(int i2) {
        AppMethodBeat.i(144593);
        switch (i2) {
            case 1:
                AppMethodBeat.o(144593);
                return "GATT CONN L2C FAILURE";
            case 8:
                AppMethodBeat.o(144593);
                return "GATT CONN TIMEOUT";
            case 19:
                AppMethodBeat.o(144593);
                return "GATT CONN TERMINATE PEER USER";
            case 22:
                AppMethodBeat.o(144593);
                return "GATT CONN TERMINATE LOCAL HOST";
            case 34:
                AppMethodBeat.o(144593);
                return "GATT CONN LMP TIMEOUT";
            case 62:
                AppMethodBeat.o(144593);
                return "GATT CONN FAIL ESTABLISH";
            case 133:
                AppMethodBeat.o(144593);
                return "GATT ERROR";
            case 256:
                AppMethodBeat.o(144593);
                return "GATT CONN CANCEL ";
            default:
                String wS = wS(i2);
                AppMethodBeat.o(144593);
                return wS;
        }
    }

    private static String wS(int i2) {
        AppMethodBeat.i(144594);
        switch (i2) {
            case 0:
                AppMethodBeat.o(144594);
                return "GATT SUCCESS";
            case 1:
                AppMethodBeat.o(144594);
                return "GATT INVALID HANDLE";
            case 2:
                AppMethodBeat.o(144594);
                return "GATT READ NOT PERMIT";
            case 3:
                AppMethodBeat.o(144594);
                return "GATT WRITE NOT PERMIT";
            case 4:
                AppMethodBeat.o(144594);
                return "GATT INVALID PDU";
            case 5:
                AppMethodBeat.o(144594);
                return "GATT INSUF AUTHENTICATION";
            case 6:
                AppMethodBeat.o(144594);
                return "GATT REQ NOT SUPPORTED";
            case 7:
                AppMethodBeat.o(144594);
                return "GATT INVALID OFFSET";
            case 8:
                AppMethodBeat.o(144594);
                return "GATT INSUF AUTHORIZATION";
            case 9:
                AppMethodBeat.o(144594);
                return "GATT PREPARE Q FULL";
            case 10:
                AppMethodBeat.o(144594);
                return "GATT NOT FOUND";
            case 11:
                AppMethodBeat.o(144594);
                return "GATT NOT LONG";
            case 12:
                AppMethodBeat.o(144594);
                return "GATT INSUF KEY SIZE";
            case 13:
                AppMethodBeat.o(144594);
                return "GATT INVALID ATTR LEN";
            case 14:
                AppMethodBeat.o(144594);
                return "GATT ERR UNLIKELY";
            case 15:
                AppMethodBeat.o(144594);
                return "GATT INSUF ENCRYPTION";
            case 16:
                AppMethodBeat.o(144594);
                return "GATT UNSUPPORT GRP TYPE";
            case 17:
                AppMethodBeat.o(144594);
                return "GATT INSUF RESOURCE";
            case 128:
                AppMethodBeat.o(144594);
                return "GATT NO RESOURCES";
            case 129:
                AppMethodBeat.o(144594);
                return "GATT INTERNAL ERROR";
            case 130:
                AppMethodBeat.o(144594);
                return "GATT WRONG STATE";
            case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
                AppMethodBeat.o(144594);
                return "GATT DB FULL";
            case 132:
                AppMethodBeat.o(144594);
                return "GATT BUSY";
            case 133:
                AppMethodBeat.o(144594);
                return "GATT ERROR";
            case g.CTRL_INDEX /*{ENCODED_INT: 134}*/:
                AppMethodBeat.o(144594);
                return "GATT CMD STARTED";
            case c.CTRL_INDEX /*{ENCODED_INT: 135}*/:
                AppMethodBeat.o(144594);
                return "GATT ILLEGAL PARAMETER";
            case r.CTRL_INDEX /*{ENCODED_INT: 136}*/:
                AppMethodBeat.o(144594);
                return "GATT PENDING";
            case 137:
                AppMethodBeat.o(144594);
                return "GATT AUTH FAIL";
            case 138:
                AppMethodBeat.o(144594);
                return "GATT MORE";
            case b.CTRL_INDEX /*{ENCODED_INT: 139}*/:
                AppMethodBeat.o(144594);
                return "GATT INVALID CFG";
            case 140:
                AppMethodBeat.o(144594);
                return "GATT SERVICE STARTED";
            case 141:
                AppMethodBeat.o(144594);
                return "GATT ENCRYPTED NO MITM";
            case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                AppMethodBeat.o(144594);
                return "GATT NOT ENCRYPTED";
            case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                AppMethodBeat.o(144594);
                return "GATT CONGESTED";
            case 253:
                AppMethodBeat.o(144594);
                return "GATT CCCD CFG ERROR";
            case 254:
                AppMethodBeat.o(144594);
                return "GATT PROCEDURE IN PROGRESS";
            case 255:
                AppMethodBeat.o(144594);
                return "GATT VALUE OUT OF RANGE";
            case CdnLogic.kAppTypeFestivalImage:
                AppMethodBeat.o(144594);
                return "GATT FAILURE, TOO MANY OPEN CONNECTIONS";
            default:
                String str = "UNKNOWN (" + i2 + ")";
                AppMethodBeat.o(144594);
                return str;
        }
    }
}
