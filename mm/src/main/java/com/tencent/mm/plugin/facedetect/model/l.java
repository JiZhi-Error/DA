package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class l {
    public static int HL(int i2) {
        AppMethodBeat.i(103771);
        if (i2 < 90000 && i2 != 0) {
            Log.i("MicroMsg.FaceJSAPITranslateCenter", "hy: server error. not translate");
            AppMethodBeat.o(103771);
            return i2;
        } else if (i2 > 90099) {
            Log.i("MicroMsg.FaceJSAPITranslateCenter", "hy: already translated");
            AppMethodBeat.o(103771);
            return i2;
        } else {
            switch (i2) {
                case 0:
                    AppMethodBeat.o(103771);
                    return 0;
                case 90001:
                    AppMethodBeat.o(103771);
                    return 90109;
                case 90002:
                case 90003:
                case 90004:
                case 90005:
                case 90006:
                case 90024:
                case 90025:
                    AppMethodBeat.o(103771);
                    return 90100;
                case 90008:
                case 90009:
                case 90010:
                    AppMethodBeat.o(103771);
                    return 90101;
                case 90011:
                case 90013:
                    AppMethodBeat.o(103771);
                    return 90102;
                case 90015:
                    AppMethodBeat.o(103771);
                    return 90104;
                case 90016:
                    AppMethodBeat.o(103771);
                    return 90106;
                case 90017:
                    AppMethodBeat.o(103771);
                    return 90107;
                case 90019:
                case 90020:
                case 90021:
                    AppMethodBeat.o(103771);
                    return 90103;
                case 90022:
                    AppMethodBeat.o(103771);
                    return 90105;
                case 90023:
                    AppMethodBeat.o(103771);
                    return 90108;
                default:
                    AppMethodBeat.o(103771);
                    return 90199;
            }
        }
    }
}
