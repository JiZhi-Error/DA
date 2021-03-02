package com.tencent.mm.plugin.expt.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c {
    private static String TAG = "MicroMsg.ExptMMKV";
    private static c sLq;
    private static HashSet<String> sLr = new HashSet<>();

    static {
        AppMethodBeat.i(122460);
        long currentTicks = Util.currentTicks();
        for (b.EnumC1008b bVar : b.EnumC1008b.values()) {
            sLr.add(bVar.name());
        }
        Log.i(TAG, "get mulit expt enum cost time [%d]", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(122460);
    }

    public static c cSa() {
        AppMethodBeat.i(122453);
        if (sLq == null) {
            sLq = new c();
        }
        c cVar = sLq;
        AppMethodBeat.o(122453);
        return cVar;
    }

    protected c() {
    }

    public static MultiProcessMMKV aTI() {
        AppMethodBeat.i(122454);
        MultiProcessMMKV aTI = d.cRY().aTI();
        AppMethodBeat.o(122454);
        return aTI;
    }

    public static String c(b.a aVar, String str) {
        AppMethodBeat.i(220641);
        String b2 = d.cRY().b(aVar.name(), str, false, true);
        AppMethodBeat.o(220641);
        return b2;
    }

    public final boolean dz(List<com.tencent.mm.plugin.expt.h.c> list) {
        int i2;
        AppMethodBeat.i(184400);
        if (!cSb()) {
            AppMethodBeat.o(184400);
            return false;
        } else if (list == null || list.isEmpty()) {
            Log.w(TAG, "%s replace expt but item is null!", info());
            AppMethodBeat.o(184400);
            return false;
        } else {
            long currentTicks = Util.currentTicks();
            MultiProcessMMKV aTI = d.cRY().aTI();
            if (aTI == null) {
                Log.w(TAG, "%s replace expt but mmkv is null!", info());
                AppMethodBeat.o(184400);
                return false;
            }
            int i3 = 0;
            int i4 = 0;
            for (com.tencent.mm.plugin.expt.h.c cVar : list) {
                if (cVar != null) {
                    HashMap<String, String> cRH = cVar.cRH();
                    if (cRH != null) {
                        boolean z = false;
                        for (String str : cRH.keySet()) {
                            aTI.putInt(str, cVar.field_exptId);
                            i4++;
                            z = true;
                        }
                        if (z) {
                            aTI.putString(new StringBuilder().append(cVar.field_exptId).toString(), cVar.field_exptContent);
                            i2 = i3 + 1;
                            i4 = i4;
                        } else {
                            i2 = i3;
                            i4 = i4;
                        }
                    } else {
                        i2 = i3;
                    }
                    i3 = i2;
                }
            }
            boolean commit = aTI.commit();
            Log.i(TAG, "%s replace expt param[%d] [%d %d] cost[%d] flag[%b]", info(), Integer.valueOf(list.size()), Integer.valueOf(i4), Integer.valueOf(i3), Long.valueOf(Util.ticksToNow(currentTicks)), Boolean.valueOf(commit));
            AppMethodBeat.o(184400);
            return commit;
        }
    }

    public final void dA(List<Integer> list) {
        int i2;
        AppMethodBeat.i(122457);
        if (!cSb()) {
            AppMethodBeat.o(122457);
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.o(122457);
        } else {
            long currentTicks = Util.currentTicks();
            MultiProcessMMKV aTI = d.cRY().aTI();
            if (aTI == null) {
                AppMethodBeat.o(122457);
                return;
            }
            HashSet hashSet = new HashSet();
            int i3 = 0;
            for (Integer num : list) {
                int intValue = num.intValue();
                if (aTI.contains(String.valueOf(intValue))) {
                    aTI.remove(String.valueOf(intValue));
                    hashSet.add(Integer.valueOf(intValue));
                    i2 = i3 + 1;
                } else {
                    i2 = i3;
                }
                i3 = i2;
            }
            Iterator<String> it = sLr.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                String next = it.next();
                int i5 = aTI.getInt(next, 0);
                if (i5 > 0 && hashSet.contains(Integer.valueOf(i5))) {
                    aTI.remove(next);
                    i4++;
                }
                i4 = i4;
            }
            Log.i(TAG, "%s delete expt params[%d] delete [%d %d] cost[%d] flag [%b]", info(), Integer.valueOf(list.size()), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(Util.ticksToNow(currentTicks)), Boolean.valueOf(aTI.commit()));
            AppMethodBeat.o(122457);
        }
    }

    public final boolean cSb() {
        AppMethodBeat.i(122458);
        if (MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(122458);
            return true;
        }
        Log.printInfoStack(TAG, "%s only mm process can write expt info", info());
        AppMethodBeat.o(122458);
        return false;
    }

    private String info() {
        AppMethodBeat.i(122459);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(122459);
        return sb;
    }
}
