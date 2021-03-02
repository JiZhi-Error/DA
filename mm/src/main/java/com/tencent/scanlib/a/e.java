package com.tencent.scanlib.a;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.scanlib.a;
import com.tencent.scanlib.a.g;

final class e implements g.a {
    e() {
    }

    public static g.a.C2186a hla() {
        int i2;
        AppMethodBeat.i(3545);
        g.a.C2186a aVar = new g.a.C2186a();
        try {
            aVar.gII = Camera.open();
            aVar.dYT = 0;
            if (aVar.gII == null) {
                AppMethodBeat.o(3545);
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                aVar.dYT = 90;
                aVar.gII.setDisplayOrientation(90);
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
                            i2 = a.cL(split[1]);
                        }
                    }
                }
                if (i2 >= 7093) {
                    aVar.dYT = 90;
                    aVar.gII.setDisplayOrientation(TXLiveConstants.RENDER_ROTATION_180);
                }
            }
            AppMethodBeat.o(3545);
            return aVar;
        } catch (Exception e2) {
            AppMethodBeat.o(3545);
            return null;
        }
    }
}
