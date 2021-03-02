package com.tencent.mm.plugin.performance.watchdogs;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class e {

    public static class a {
        private static List<String> AXL = new ArrayList();
        private static List<Integer> AXM = new ArrayList();
        private static List<String> AXN = new ArrayList();

        static {
            AppMethodBeat.i(201207);
            AXL.add("OnePlus");
            AXM.add(29);
            AXN.add("audio_mix_threa");
            AXN.add("com.tencent.mm");
            AXN.add("[GT]VideoPlayer");
            AXN.add("AudioTrack");
            AppMethodBeat.o(201207);
        }

        static /* synthetic */ boolean gi(String str) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            AppMethodBeat.i(201206);
            Iterator<String> it = AXL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (Build.BRAND.equalsIgnoreCase(it.next())) {
                    z = true;
                    break;
                }
            }
            Iterator<Integer> it2 = AXM.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().intValue() == Build.VERSION.SDK_INT) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            Iterator<String> it3 = AXN.iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (str.contains(it3.next())) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            Object[] objArr = new Object[4];
            if (!z || !z2 || !z3) {
                z4 = false;
            } else {
                z4 = true;
            }
            objArr[0] = Boolean.valueOf(z4);
            objArr[1] = Build.BRAND;
            objArr[2] = Integer.valueOf(Build.VERSION.SDK_INT);
            objArr[3] = str;
            Log.i("MicroMsg.ThreadWhiteList", "OnePlus_Q_AudioLeak: matchWhiteThread? %s, brand = %s, API = %s, threadName = %s", objArr);
            if (!z || !z2 || !z3) {
                AppMethodBeat.o(201206);
                return false;
            }
            AppMethodBeat.o(201206);
            return true;
        }
    }
}
