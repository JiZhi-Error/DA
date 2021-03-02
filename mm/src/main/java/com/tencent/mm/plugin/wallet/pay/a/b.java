package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static Map<String, Integer> HFA = new ConcurrentHashMap();
    private static Map<String, List<Integer>> HFy = new ConcurrentHashMap();
    private static Map<String, Boolean> HFz = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(69261);
        AppMethodBeat.o(69261);
    }

    public static void aUR(String str) {
        int i2;
        Integer num;
        AppMethodBeat.i(69253);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(69253);
            return;
        }
        if (!HFA.containsKey(str) || (num = HFA.get(str)) == null) {
            i2 = 1;
        } else {
            i2 = Integer.valueOf(num.intValue() + 1);
        }
        HFA.put(str, i2);
        AppMethodBeat.o(69253);
    }

    public static void aUS(String str) {
        AppMethodBeat.i(69254);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(69254);
            return;
        }
        HFA.remove(str);
        AppMethodBeat.o(69254);
    }

    public static void fY(String str, int i2) {
        AppMethodBeat.i(69255);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(69255);
        } else if (!HFy.containsKey(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i2));
            HFy.put(str, arrayList);
            AppMethodBeat.o(69255);
        } else {
            List<Integer> list = HFy.get(str);
            list.add(Integer.valueOf(i2));
            HFy.put(str, list);
            AppMethodBeat.o(69255);
        }
    }

    private static boolean aUT(String str) {
        AppMethodBeat.i(69256);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(69256);
            return false;
        }
        if (HFA.containsKey(str)) {
            Integer num = HFA.get(str);
            if (num == null) {
                AppMethodBeat.o(69256);
                return false;
            } else if (num.intValue() > 1) {
                AppMethodBeat.o(69256);
                return true;
            }
        }
        AppMethodBeat.o(69256);
        return false;
    }

    public static void u(String str, int i2, boolean z) {
        Boolean bool;
        AppMethodBeat.i(69257);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(69257);
            return;
        }
        if (HFy.containsKey(str) && HFy.get(str).size() > 0) {
            if (i2 == 1) {
                h.INSTANCE.n(965, 10, 1);
                h.INSTANCE.n(965, 30, 1);
                if (aUT(str)) {
                    h.INSTANCE.n(965, 25, 1);
                }
            } else if (i2 == 2) {
                h.INSTANCE.n(965, 11, 1);
                h.INSTANCE.n(965, 31, 1);
                if (aUT(str)) {
                    h.INSTANCE.n(965, 26, 1);
                }
            }
            if (aUT(str)) {
                h.INSTANCE.n(965, 24, 1);
            }
            h.INSTANCE.n(965, 29, 1);
            if (z) {
                h.INSTANCE.n(965, 20, 1);
            } else {
                h.INSTANCE.n(965, 21, 1);
            }
        }
        if (HFz.containsKey(str) && (bool = HFz.get(str)) != null) {
            if (bool.booleanValue()) {
                h.INSTANCE.n(965, 18, 1);
                AppMethodBeat.o(69257);
                return;
            }
            h.INSTANCE.n(965, 19, 1);
        }
        AppMethodBeat.o(69257);
    }

    public static void cD(String str, boolean z) {
        AppMethodBeat.i(69258);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(69258);
            return;
        }
        HFz.put(str, Boolean.valueOf(z));
        AppMethodBeat.o(69258);
    }

    public static void aUU(String str) {
        AppMethodBeat.i(69259);
        if (!Util.isNullOrNil(str) && !HFy.containsKey(str)) {
            HFy.put(str, new ArrayList());
        }
        AppMethodBeat.o(69259);
    }

    public static void aUV(String str) {
        AppMethodBeat.i(69260);
        if (!Util.isNullOrNil(str)) {
            HFy.remove(str);
            HFz.remove(str);
        }
        AppMethodBeat.o(69260);
    }
}
