package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum b {
    IML;

    public static b valueOf(String str) {
        AppMethodBeat.i(103643);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(103643);
        return bVar;
    }

    static {
        AppMethodBeat.i(103645);
        AppMethodBeat.o(103645);
    }

    public static a a(Context context, f fVar, int i2, Bundle bundle) {
        AppMethodBeat.i(186362);
        Log.i("MicroMsg.FaceDetectControllerFactory", "alvinluo getController serverScene: %d", Integer.valueOf(i2));
        switch (i2) {
            case 0:
            case 1:
            case 3:
            case 4:
                c cVar = new c(context, fVar, i2);
                AppMethodBeat.o(186362);
                return cVar;
            case 2:
            case 5:
                d dVar = new d(context, fVar, i2, bundle);
                AppMethodBeat.o(186362);
                return dVar;
            case 6:
                e eVar = new e(context, fVar, i2);
                AppMethodBeat.o(186362);
                return eVar;
            default:
                AppMethodBeat.o(186362);
                return null;
        }
    }
}
