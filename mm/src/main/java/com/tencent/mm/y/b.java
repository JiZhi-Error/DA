package com.tencent.mm.y;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class b {
    SparseArray<a> hlX = new SparseArray<>();
    HashMap<ar.a, a> hlY = new HashMap<>();
    SparseArray<C2177b> hlZ = new SparseArray<>();
    HashMap<ar.a, C2177b> hma = new HashMap<>();
    private Random hmb = new Random();
    ao hmc = null;

    public b() {
        AppMethodBeat.i(150060);
        AppMethodBeat.o(150060);
    }

    public class a {
        String dHx;
        int hlT;
        ar.a hlU;
        int type;
        public String value;

        public a() {
        }
    }

    /* renamed from: com.tencent.mm.y.b$b  reason: collision with other inner class name */
    public class C2177b {
        ar.a hlW;
        int hme;
        SparseArray<String> hmf = new SparseArray<>();
        HashMap<String, String> hmg = new HashMap<>();

        public C2177b() {
            AppMethodBeat.i(150059);
            AppMethodBeat.o(150059);
        }
    }

    private static String Fl(String str) {
        AppMethodBeat.i(150061);
        String replaceAll = str.replaceAll("\\|", "%7C");
        AppMethodBeat.o(150061);
        return replaceAll;
    }

    private static String unescape(String str) {
        AppMethodBeat.i(150062);
        String replaceAll = str.replaceAll("%7C", "|");
        AppMethodBeat.o(150062);
        return replaceAll;
    }

    private void a(a aVar) {
        AppMethodBeat.i(150063);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.type);
        stringBuffer.append("|");
        stringBuffer.append(Fl(aVar.value));
        stringBuffer.append("|");
        stringBuffer.append(Fl(aVar.dHx));
        if (aVar.hlU != null) {
            this.hmc.set(aVar.hlU, stringBuffer.toString());
            AppMethodBeat.o(150063);
            return;
        }
        this.hmc.set(aVar.hlT, stringBuffer.toString());
        AppMethodBeat.o(150063);
    }

    /* access modifiers changed from: package-private */
    public final void a(C2177b bVar) {
        AppMethodBeat.i(150064);
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        for (Map.Entry<String, String> entry : bVar.hmg.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(key);
            stringBuffer.append("|");
            stringBuffer.append(Fl(value));
            i2++;
        }
        for (int i3 = 0; i3 < bVar.hmf.size(); i3++) {
            int keyAt = bVar.hmf.keyAt(i3);
            String str = bVar.hmf.get(keyAt);
            if (i2 != 0) {
                stringBuffer.append("|");
            }
            stringBuffer.append(keyAt);
            stringBuffer.append("|");
            stringBuffer.append(Fl(str));
            i2++;
        }
        if (bVar.hlW != null) {
            this.hmc.set(bVar.hlW, stringBuffer.toString());
            AppMethodBeat.o(150064);
            return;
        }
        this.hmc.set(bVar.hme, stringBuffer.toString());
        AppMethodBeat.o(150064);
    }

    private a pI(int i2) {
        AppMethodBeat.i(150065);
        String str = (String) this.hmc.get(i2, (Object) null);
        if (str == null) {
            AppMethodBeat.o(150065);
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            AppMethodBeat.o(150065);
            return null;
        }
        try {
            a a2 = a(i2, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
            AppMethodBeat.o(150065);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            AppMethodBeat.o(150065);
            return null;
        }
    }

    private a c(ar.a aVar) {
        AppMethodBeat.i(150066);
        String str = (String) this.hmc.get(aVar, (Object) null);
        if (str == null) {
            AppMethodBeat.o(150066);
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", str);
            AppMethodBeat.o(150066);
            return null;
        }
        try {
            a a2 = a(aVar, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
            AppMethodBeat.o(150066);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", str);
            AppMethodBeat.o(150066);
            return null;
        }
    }

    private static boolean Fm(String str) {
        AppMethodBeat.i(150067);
        if (Util.isNullOrNil(str) || !str.matches("^[\\d]+$")) {
            AppMethodBeat.o(150067);
            return false;
        }
        AppMethodBeat.o(150067);
        return true;
    }

    private C2177b pJ(int i2) {
        AppMethodBeat.i(150068);
        String str = (String) this.hmc.get(i2, (Object) null);
        if (str == null) {
            C2177b pK = pK(i2);
            AppMethodBeat.o(150068);
            return pK;
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            AppMethodBeat.o(150068);
            return null;
        }
        try {
            C2177b pK2 = pK(i2);
            for (int i3 = 0; i3 < split.length; i3 += 2) {
                if (Fm(split[i3])) {
                    pK2.hmf.put(Integer.valueOf(split[i3]).intValue(), unescape(split[i3 + 1]));
                } else {
                    pK2.hmg.put(split[i3], unescape(split[i3 + 1]));
                }
            }
            AppMethodBeat.o(150068);
            return pK2;
        } catch (Exception e2) {
            Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            AppMethodBeat.o(150068);
            return null;
        }
    }

    private C2177b d(ar.a aVar) {
        AppMethodBeat.i(150069);
        String str = (String) this.hmc.get(aVar, (Object) null);
        if (str == null) {
            C2177b e2 = e(aVar);
            AppMethodBeat.o(150069);
            return e2;
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", str);
            AppMethodBeat.o(150069);
            return null;
        }
        try {
            C2177b e3 = e(aVar);
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                if (Fm(split[i2])) {
                    e3.hmf.put(Integer.valueOf(split[i2]).intValue(), unescape(split[i2 + 1]));
                } else {
                    e3.hmg.put(split[i2], unescape(split[i2 + 1]));
                }
            }
            AppMethodBeat.o(150069);
            return e3;
        } catch (Exception e4) {
            Log.e("MicroMsg.NewBadgeDecoder", "exception:%s", Util.stackTraceToString(e4));
            Log.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", str);
            AppMethodBeat.o(150069);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String axT() {
        AppMethodBeat.i(150070);
        String format = String.format("%d%04d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.hmb.nextInt(Math.abs(this.hmb.nextInt(Integer.MAX_VALUE))) % 10000));
        AppMethodBeat.o(150070);
        return format;
    }

    /* access modifiers changed from: package-private */
    public final C2177b pK(int i2) {
        AppMethodBeat.i(150071);
        C2177b bVar = new C2177b();
        bVar.hme = i2;
        AppMethodBeat.o(150071);
        return bVar;
    }

    private C2177b e(ar.a aVar) {
        AppMethodBeat.i(150072);
        C2177b bVar = new C2177b();
        bVar.hlW = aVar;
        AppMethodBeat.o(150072);
        return bVar;
    }

    private a a(int i2, int i3, String str, String str2) {
        AppMethodBeat.i(150073);
        a aVar = new a();
        aVar.hlT = i2;
        aVar.type = i3;
        aVar.value = str;
        aVar.dHx = str2;
        AppMethodBeat.o(150073);
        return aVar;
    }

    private a a(ar.a aVar, int i2, String str, String str2) {
        AppMethodBeat.i(150074);
        a aVar2 = new a();
        aVar2.hlU = aVar;
        aVar2.type = i2;
        aVar2.value = str;
        aVar2.dHx = str2;
        AppMethodBeat.o(150074);
        return aVar2;
    }

    private a cR(int i2, int i3) {
        AppMethodBeat.i(150075);
        a pL = pL(i2);
        if (pL == null) {
            pL = a(i2, i3, "", "");
            this.hlX.put(i2, pL);
            a(pL);
        }
        AppMethodBeat.o(150075);
        return pL;
    }

    private a c(ar.a aVar, int i2) {
        AppMethodBeat.i(150076);
        a f2 = f(aVar);
        if (f2 == null) {
            f2 = a(aVar, i2, "", "");
            this.hlY.put(aVar, f2);
            a(f2);
        }
        AppMethodBeat.o(150076);
        return f2;
    }

    public final a pL(int i2) {
        AppMethodBeat.i(150077);
        a aVar = this.hlX.get(i2);
        if (aVar == null && (aVar = pI(i2)) != null) {
            this.hlX.put(i2, aVar);
        }
        AppMethodBeat.o(150077);
        return aVar;
    }

    public final a f(ar.a aVar) {
        AppMethodBeat.i(150078);
        a aVar2 = this.hlY.get(aVar);
        if (aVar2 == null && (aVar2 = c(aVar)) != null) {
            this.hlY.put(aVar, aVar2);
        }
        AppMethodBeat.o(150078);
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public final C2177b pM(int i2) {
        AppMethodBeat.i(150079);
        C2177b bVar = this.hlZ.get(i2);
        if (bVar == null) {
            bVar = pJ(i2);
            if (bVar == null) {
                Log.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
                AppMethodBeat.o(150079);
                return null;
            }
            this.hlZ.put(i2, bVar);
        }
        AppMethodBeat.o(150079);
        return bVar;
    }

    private C2177b g(ar.a aVar) {
        AppMethodBeat.i(150080);
        C2177b bVar = this.hma.get(aVar);
        if (bVar == null) {
            bVar = d(aVar);
            if (bVar == null) {
                Log.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
                AppMethodBeat.o(150080);
                return null;
            }
            this.hma.put(aVar, bVar);
        }
        AppMethodBeat.o(150080);
        return bVar;
    }

    public final void g(int i2, int i3, String str) {
        AppMethodBeat.i(150081);
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        a cR = cR(i2, i3);
        cR.value = str;
        cR.type = i3;
        cR.dHx = axT();
        a(cR);
        AppMethodBeat.o(150081);
    }

    public final void b(ar.a aVar, int i2, String str) {
        AppMethodBeat.i(150082);
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", aVar, Integer.valueOf(i2), str);
        a c2 = c(aVar, i2);
        c2.value = str;
        c2.type = i2;
        c2.dHx = axT();
        a(c2);
        AppMethodBeat.o(150082);
    }

    public final a K(int i2, int i3, int i4) {
        AppMethodBeat.i(150083);
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        a pL = pL(i2);
        if (pL == null) {
            Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            AppMethodBeat.o(150083);
            return null;
        } else if ((pL.type & i4) == 0) {
            Log.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            AppMethodBeat.o(150083);
            return null;
        } else {
            C2177b pM = pM(i3);
            if (pM != null) {
                String str = pM.hmf.get(i2);
                if (str == null || !str.equals(pL.dHx)) {
                    if (str == null) {
                        pM.hmf.put(i2, axT());
                        a(pM);
                    }
                    AppMethodBeat.o(150083);
                    return pL;
                }
                AppMethodBeat.o(150083);
                return null;
            }
            Log.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            AppMethodBeat.o(150083);
            return null;
        }
    }

    public final a a(ar.a aVar, ar.a aVar2, int i2) {
        AppMethodBeat.i(150084);
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", aVar, aVar2, Integer.valueOf(i2));
        a f2 = f(aVar);
        if (f2 == null) {
            Log.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            AppMethodBeat.o(150084);
            return null;
        } else if ((f2.type & i2) == 0) {
            Log.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            AppMethodBeat.o(150084);
            return null;
        } else {
            C2177b g2 = g(aVar2);
            if (g2 != null) {
                String str = g2.hmg.get(aVar.name());
                if (str == null || !str.equals(f2.dHx)) {
                    if (str == null) {
                        g2.hmg.put(aVar.name(), axT());
                        a(g2);
                    }
                    AppMethodBeat.o(150084);
                    return f2;
                }
                AppMethodBeat.o(150084);
                return null;
            }
            Log.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            AppMethodBeat.o(150084);
            return null;
        }
    }

    public final void d(ar.a aVar, ar.a aVar2) {
        AppMethodBeat.i(150085);
        Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", aVar, aVar2);
        a f2 = f(aVar);
        if (f2 == null) {
            Log.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            AppMethodBeat.o(150085);
            return;
        }
        C2177b g2 = g(aVar2);
        if (g2 == null) {
            Log.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
            g2 = e(aVar2);
            this.hma.put(aVar2, g2);
        }
        g2.hmg.put(aVar.name(), f2.dHx);
        a(g2);
        AppMethodBeat.o(150085);
    }
}
