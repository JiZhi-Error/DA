package com.tencent.mm.compatible.deviceinfo;

import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;

final class j implements d.a {
    j() {
    }

    public static d.a.C0301a d(Looper looper) {
        int i2;
        AppMethodBeat.i(155653);
        d.a.C0301a aVar = new d.a.C0301a();
        try {
            aVar.gGr = w.e(looper);
            aVar.dYT = 0;
            if (aVar.gGr == null) {
                AppMethodBeat.o(155653);
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                aVar.dYT = 90;
                aVar.gGr.setDisplayOrientation(90);
            } else {
                if (!Build.MODEL.equals("M9")) {
                    i2 = -1;
                } else {
                    String str = Build.DISPLAY;
                    if (str.substring(0, 0).equals("1")) {
                        i2 = -1;
                    } else {
                        String[] split = str.split("-");
                        if (split == null || split.length < 2) {
                            i2 = -1;
                        } else {
                            i2 = Util.getInt(split[1], 0);
                        }
                    }
                }
                if (i2 >= 7093) {
                    aVar.dYT = 90;
                    aVar.gGr.setDisplayOrientation(TXLiveConstants.RENDER_ROTATION_180);
                }
            }
            AppMethodBeat.o(155653);
            return aVar;
        } catch (Exception e2) {
            AppMethodBeat.o(155653);
            return null;
        }
    }
}
