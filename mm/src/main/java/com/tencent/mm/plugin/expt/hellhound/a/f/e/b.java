package com.tencent.mm.plugin.expt.hellhound.a.f.e;

import android.annotation.SuppressLint;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class b {
    static void a(Object obj, cyk cyk, bgb bgb, boolean z) {
        String str;
        AppMethodBeat.i(169357);
        if (obj == null || TextUtils.isEmpty(cyk.className) || TextUtils.isEmpty(cyk.dataPath)) {
            AppMethodBeat.o(169357);
            return;
        }
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(cyk.action)) {
            if (!z) {
                AppMethodBeat.o(169357);
                return;
            }
        } else if ("2".equals(cyk.action) && z) {
            AppMethodBeat.o(169357);
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (cyk.MDk == null) {
            str = cyk.dataPath;
        } else {
            str = cyk.MDk.iFF;
        }
        cbn a2 = a(obj, cyk.MDj, str, cyk.dataPath);
        if (a2 == null) {
            if (cyk.MDk != null && !TextUtils.isEmpty(cyk.MDk.iFF)) {
                l.Bt(158);
            }
            a2 = a(obj, cyk.className, cyk.dataPath, cyk.dataPath);
            if (a2 == null) {
                AppMethodBeat.o(169357);
                return;
            }
        }
        l.Bt(135);
        for (int size = bgb.LPK.size() - 1; size >= 0; size--) {
            bga bga = bgb.LPK.get(size);
            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(bga.name);
            if (aoE != null && aoE.equals(simpleName)) {
                a(a2, bga);
                AppMethodBeat.o(169357);
                return;
            }
        }
        AppMethodBeat.o(169357);
    }

    private static void a(cbn cbn, bga bga) {
        AppMethodBeat.i(220575);
        int size = bga.LPG.size();
        int i2 = 0;
        while (i2 < size) {
            cbn cbn2 = bga.LPG.get(i2);
            if (cbn2.dataPath != null && cbn2.dataPath.equals(cbn.dataPath)) {
                break;
            }
            i2++;
        }
        if (i2 < size) {
            bga.LPG.set(i2, cbn);
            AppMethodBeat.o(220575);
            return;
        }
        bga.LPG.add(cbn);
        AppMethodBeat.o(220575);
    }

    @SuppressLint({"NewApi"})
    static void a(Object obj, cyk cyk, long j2, erd erd) {
        String str;
        boolean z;
        AppMethodBeat.i(220576);
        if (obj == null || TextUtils.isEmpty(cyk.className) || TextUtils.isEmpty(cyk.dataPath) || erd == null) {
            AppMethodBeat.o(220576);
            return;
        }
        if (cyk.MDk == null) {
            str = cyk.dataPath;
        } else {
            str = cyk.MDk.iFF;
        }
        cbn a2 = a(obj, cyk.MDj, str, cyk.dataPath);
        if (a2 == null) {
            l.Bt(129);
            a2 = a(obj, cyk.className, cyk.dataPath, cyk.dataPath);
            if (a2 == null) {
                l.Bt(133);
                AppMethodBeat.o(220576);
                return;
            }
        }
        l.Bt(132);
        Iterator<pd> it = erd.KVY.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            pd next = it.next();
            if (j2 == next.KVX) {
                next.KVY.add(a2);
                z = true;
                break;
            }
        }
        if (!z) {
            pd pdVar = new pd();
            pdVar.KVX = j2;
            pdVar.KVY.add(a2);
            erd.KVY.add(pdVar);
            Log.i("HABBYGE-MALI.HellSessionParamUtil", "catchParamsWhenViewOp, add pathId=%s, dataPath=%s, value=%s", Long.valueOf(j2), a2.dataPath, a2.value);
        }
        AppMethodBeat.o(220576);
    }

    @SuppressLint({"NewApi"})
    static void a(Object obj, cyk cyk, cbm cbm, boolean z, boolean z2) {
        String str;
        AppMethodBeat.i(122195);
        if (obj == null || TextUtils.isEmpty(cyk.className) || TextUtils.isEmpty(cyk.dataPath)) {
            AppMethodBeat.o(122195);
            return;
        }
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(cyk.action)) {
            if (!z2) {
                AppMethodBeat.o(122195);
                return;
            }
        } else if ("2".equals(cyk.action) && z2) {
            AppMethodBeat.o(122195);
            return;
        }
        if (cyk.MDk == null) {
            str = cyk.dataPath;
        } else {
            str = cyk.MDk.iFF;
        }
        cbn a2 = a(obj, cyk.MDj, str, cyk.dataPath);
        if (a2 == null) {
            if (!z && cyk.MDk != null && !TextUtils.isEmpty(cyk.MDk.iFF)) {
                l.Bt(158);
            }
            a2 = a(obj, cyk.className, cyk.dataPath, cyk.dataPath);
            if (a2 == null) {
                AppMethodBeat.o(122195);
                return;
            }
        }
        if (z) {
            cbm.Mho.add(a2);
            AppMethodBeat.o(122195);
            return;
        }
        cbm.LPG.add(a2);
        l.Bt(135);
        AppMethodBeat.o(122195);
    }

    private static cbn a(Object obj, String str, String str2, String str3) {
        AppMethodBeat.i(220577);
        List<k<String, String>> aqR = aqR(str2);
        if (aqR == null) {
            AppMethodBeat.o(220577);
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            Class<?> cls2 = cls;
            for (k<String, String> kVar : aqR) {
                if (kVar != null) {
                    F f2 = kVar.first;
                    S s = kVar.second;
                    if (f2 != null && !f2.isEmpty() && s != null && !s.isEmpty()) {
                        Field declaredField = cls2.getDeclaredField(f2);
                        declaredField.setAccessible(true);
                        Object obj2 = declaredField.get(obj);
                        if (s.startsWith("[")) {
                            c<String, Integer> aqS = aqS(s);
                            if (aqS != null) {
                                int intValue = ((Integer) aqS.get(1)).intValue();
                                Object[] objArr = (Object[]) obj2;
                                if (objArr == null || objArr.length <= 0 || intValue >= objArr.length) {
                                    Log.e("HABBYGE-MALI.HellSessionParamUtil", "array == null || array.length <= 0");
                                    AppMethodBeat.o(220577);
                                    return null;
                                }
                                Object obj3 = objArr[intValue];
                                cls2 = Class.forName((String) aqS.get(0));
                                obj = obj3;
                            }
                        } else if (s.startsWith("Ljava/util/List;")) {
                            c<String, String> gx = gx(s, "Ljava/util/List;");
                            if (gx != null) {
                                List list = (List) obj2;
                                try {
                                    int parseInt = Integer.parseInt((String) gx.get(1));
                                    if (list == null || list.isEmpty() || parseInt >= list.size()) {
                                        Log.e("HABBYGE-MALI.HellSessionParamUtil", "list.isEmpty");
                                        AppMethodBeat.o(220577);
                                        return null;
                                    }
                                    Object obj4 = list.get(parseInt);
                                    cls2 = Class.forName((String) gx.get(0));
                                    obj = obj4;
                                } catch (NumberFormatException e2) {
                                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", e2, "SessionParam, Ljava/util/List;, crash", new Object[0]);
                                    AppMethodBeat.o(220577);
                                    return null;
                                }
                            }
                        } else if (s.startsWith("Ljava/util/ArrayList;")) {
                            c<String, String> gx2 = gx(s, "Ljava/util/ArrayList;");
                            if (gx2 != null) {
                                ArrayList arrayList = (ArrayList) obj2;
                                try {
                                    int parseInt2 = Integer.parseInt((String) gx2.get(1));
                                    if (arrayList == null || arrayList.isEmpty() || parseInt2 >= arrayList.size()) {
                                        AppMethodBeat.o(220577);
                                        return null;
                                    }
                                    Object obj5 = arrayList.get(parseInt2);
                                    cls2 = Class.forName((String) gx2.get(0));
                                    obj = obj5;
                                } catch (NumberFormatException e3) {
                                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", e3, "SessionParam, Ljava/util/ArrayList;, crash", new Object[0]);
                                    AppMethodBeat.o(220577);
                                    return null;
                                }
                            }
                        } else if (s.startsWith("Ljava/util/LinkedList;")) {
                            c<String, String> gx3 = gx(s, "Ljava/util/LinkedList;");
                            if (gx3 != null) {
                                LinkedList linkedList = (LinkedList) obj2;
                                try {
                                    int parseInt3 = Integer.parseInt((String) gx3.get(1));
                                    if (linkedList == null || linkedList.isEmpty() || parseInt3 >= linkedList.size()) {
                                        AppMethodBeat.o(220577);
                                        return null;
                                    }
                                    Object obj6 = linkedList.get(parseInt3);
                                    cls2 = Class.forName((String) gx3.get(0));
                                    obj = obj6;
                                } catch (NumberFormatException e4) {
                                    Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", e4, "_doParse, Ljava/util/LinkedList;, crash", new Object[0]);
                                    AppMethodBeat.o(220577);
                                    return null;
                                }
                            }
                        } else if (s.startsWith("Ljava/util/Map;")) {
                            c<String, String> gx4 = gx(s, "Ljava/util/Map;");
                            if (gx4 != null) {
                                Map map = (Map) obj2;
                                if (map == null || map.isEmpty()) {
                                    AppMethodBeat.o(220577);
                                    return null;
                                }
                                Object obj7 = map.get(gx4.get(1));
                                if (obj7 == null) {
                                    AppMethodBeat.o(220577);
                                    return null;
                                }
                                cls2 = Class.forName((String) gx4.get(0));
                                obj = obj7;
                            }
                        } else if (s.startsWith("Ljava/util/HashMap;")) {
                            c<String, String> gx5 = gx(s, "Ljava/util/HashMap;");
                            if (gx5 != null) {
                                HashMap hashMap = (HashMap) obj2;
                                if (hashMap == null || hashMap.isEmpty()) {
                                    AppMethodBeat.o(220577);
                                    return null;
                                }
                                Object obj8 = hashMap.get(gx5.get(1));
                                if (obj8 == null) {
                                    AppMethodBeat.o(220577);
                                    return null;
                                }
                                cls2 = Class.forName((String) gx5.get(0));
                                obj = obj8;
                            }
                        } else {
                            cls2 = Class.forName(s);
                            obj = obj2;
                        }
                        obj = obj2;
                    }
                }
            }
            if (obj == null) {
                Log.e("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, object == NULL !!");
                AppMethodBeat.o(220577);
                return null;
            }
            cbn cbn = new cbn();
            String valueOf = String.valueOf(obj);
            if (obj instanceof Long) {
                valueOf = com.tencent.mm.plugin.expt.hellhound.core.b.zs(Util.getLong(valueOf, 0));
            }
            Log.i("HABBYGE-MALI.HellSessionParamUtil", "SessionParams, value: %s, %s", valueOf, str3);
            cbn.value = valueOf;
            cbn.dataPath = str3;
            AppMethodBeat.o(220577);
            return cbn;
        } catch (Exception e5) {
            AppMethodBeat.o(220577);
            return null;
        }
    }

    private static List<k<String, String>> aqR(String str) {
        AppMethodBeat.i(122197);
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : str.split(",")) {
                String[] split = str2.split("\\|");
                arrayList.add(new k(split[0], split[1]));
            }
            AppMethodBeat.o(122197);
            return arrayList;
        } catch (Exception e2) {
            AppMethodBeat.o(122197);
            return null;
        }
    }

    private static c<String, Integer> aqS(String str) {
        AppMethodBeat.i(122198);
        c<String, Integer> aqT = aqT(str);
        if (aqT == null) {
            AppMethodBeat.o(122198);
            return null;
        }
        try {
            c<String, Integer> Q = a.Q(str.substring(str.indexOf("[") + 1, ((Integer) aqT.get(1)).intValue()), Integer.valueOf(Integer.parseInt((String) aqT.get(0))));
            AppMethodBeat.o(122198);
            return Q;
        } catch (NumberFormatException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellSessionParamUtil", e2, "HellPageParamsCatcher, getClassNameAndIndexOfArray", new Object[0]);
            AppMethodBeat.o(122198);
            return null;
        }
    }

    private static c<String, String> gx(String str, String str2) {
        AppMethodBeat.i(122199);
        c<String, Integer> aqT = aqT(str);
        if (aqT == null) {
            AppMethodBeat.o(122199);
            return null;
        }
        c<String, String> Q = a.Q(str.substring(str2.length(), ((Integer) aqT.get(1)).intValue()), aqT.get(0));
        AppMethodBeat.o(122199);
        return Q;
    }

    private static c<String, Integer> aqT(String str) {
        AppMethodBeat.i(122200);
        int lastIndexOf = str.lastIndexOf("@");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) {
            AppMethodBeat.o(122200);
            return null;
        }
        c<String, Integer> Q = a.Q(str.substring(lastIndexOf + 1), Integer.valueOf(lastIndexOf));
        AppMethodBeat.o(122200);
        return Q;
    }
}
