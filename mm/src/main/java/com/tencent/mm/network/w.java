package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class w {
    public static void aL(List<String> list) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(132848);
        Log.i("MicroMsg.MMDisasterInfoHandle", "compareDisasterHost");
        if (list.size() == 0) {
            AppMethodBeat.o(132848);
            return;
        }
        v bkl = af.bkl();
        if (bkl == null) {
            Log.w("MicroMsg.MMDisasterInfoHandle", "autoAuth is null");
            AppMethodBeat.o(132848);
            return;
        }
        a aVar = bkl.jEj;
        if (aVar == null) {
            Log.w("MicroMsg.MMDisasterInfoHandle", "accinfo is null");
            AppMethodBeat.o(132848);
            return;
        }
        if (!aVar.RM("main")) {
            Iterator<String> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (aVar.ay(it.next().getBytes())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            String[] strArr = new String[20];
            MMLogic.getLocalHostList(strArr, "main");
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                boolean z3 = false;
                for (String str : list) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        if (arrayList.get(i2) != null && ((String) arrayList.get(i2)).equals(str)) {
                            z3 = true;
                            break;
                        }
                        i2++;
                    }
                }
                z = z3;
            } else {
                z = false;
            }
        }
        if (z) {
            aVar.bjp();
            try {
                af.bkj().post(new Runnable() {
                    /* class com.tencent.mm.network.w.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(132847);
                        af.bkn().j(3941, null);
                        AppMethodBeat.o(132847);
                    }
                });
            } catch (Exception e2) {
                Log.e("MicroMsg.MMDisasterInfoHandle", "exception:%s", Util.stackTraceToString(e2));
            }
            Log.w("MicroMsg.MMDisasterInfoHandle", "main disaster disasterOccur ");
            e.INSTANCE.idkeyStat(148, 124, 1, false);
            AppMethodBeat.o(132848);
            return;
        }
        if (!aVar.RM("axhost")) {
            Iterator<String> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (aVar.MG(it2.next())) {
                        break;
                    }
                } else {
                    z2 = z;
                    break;
                }
            }
        } else {
            String[] strArr2 = new String[20];
            MMLogic.getLocalHostList(strArr2, "axhost");
            ArrayList arrayList2 = new ArrayList(Arrays.asList(strArr2));
            int size2 = arrayList2.size();
            boolean z4 = z;
            for (String str2 : list) {
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        break;
                    }
                    if (arrayList2.get(i3) != null && ((String) arrayList2.get(i3)).equals(str2)) {
                        z4 = true;
                        break;
                    }
                    i3++;
                }
            }
            z2 = z4;
        }
        if (z2) {
            aVar.bjp();
            af.bkl().RT("");
            e.INSTANCE.idkeyStat(148, 125, 1, false);
            Log.w("MicroMsg.MMDisasterInfoHandle", "ax disaster disasterOccur ");
            AppMethodBeat.o(132848);
            return;
        }
        AppMethodBeat.o(132848);
    }
}
