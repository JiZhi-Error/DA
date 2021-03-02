package com.tencent.mm.plugin.sns.ad.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class e {
    private static HashSet<String> DsI = new HashSet<>();

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d A[Catch:{ Throwable -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce A[Catch:{ Throwable -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f6 A[Catch:{ Throwable -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(com.tencent.mm.plugin.sns.storage.SnsInfo r15) {
        /*
        // Method dump skipped, instructions count: 399
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ad.e.e.f(com.tencent.mm.plugin.sns.storage.SnsInfo):boolean");
    }

    public static boolean g(ArrayList<a> arrayList, boolean z) {
        boolean z2;
        AppMethodBeat.i(201909);
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<a> it = arrayList.iterator();
            boolean z3 = false;
            boolean z4 = false;
            while (it.hasNext()) {
                a next = it.next();
                if (TextUtils.isEmpty(next.DsJ) || arrayList2.contains(next.DsJ)) {
                    z2 = z3;
                } else {
                    arrayList2.add(next.DsJ);
                    if (next.weAppType == 2) {
                        z4 = true;
                    } else {
                        z2 = true;
                    }
                }
                z3 = z2;
            }
            if (!arrayList2.isEmpty()) {
                Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForNativeLandingPage, preloadWeAppPkg=" + z + ", hasWeApp=" + z3 + ", hasWeGame=" + z4);
                b(arrayList2, z, z4, z3);
            } else {
                Log.i("AdWeAppPreloader", "checkPreloadWeAppEnvForNativeLandingPage, preloadWeAppPkg=" + z + ", no weAppUserName");
            }
            AppMethodBeat.o(201909);
            return true;
        }
        AppMethodBeat.o(201909);
        return false;
    }

    public static class a {
        public String DsJ;
        public int weAppType;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(201906);
            if (this == obj) {
                AppMethodBeat.o(201906);
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.weAppType == aVar.weAppType && this.DsJ != null && this.DsJ.equals(aVar.DsJ)) {
                    AppMethodBeat.o(201906);
                    return true;
                }
            }
            AppMethodBeat.o(201906);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(201907);
            String str = this.DsJ + "|" + this.weAppType;
            AppMethodBeat.o(201907);
            return str;
        }
    }

    public static void a(z zVar, ArrayList<a> arrayList) {
        a a2;
        AppMethodBeat.i(201910);
        try {
            if (i.Zi(zVar.type)) {
                List<z> eXg = zVar.eXg();
                if (eXg != null) {
                    for (z zVar2 : eXg) {
                        a(zVar2, arrayList);
                    }
                }
                a2 = null;
            } else if (zVar instanceof ad) {
                a2 = a(((ad) zVar).DZH);
            } else if (zVar instanceof d) {
                a2 = a(((d) zVar).DtV);
            } else {
                a2 = a(zVar);
            }
            if (a2 != null && !arrayList.contains(a2)) {
                arrayList.add(a2);
            }
            Log.d("AdWeAppPreloader", "parseComponentWeAppInfo, type=" + zVar.type + ", subType=" + zVar.subType + ", size=" + arrayList.size());
            AppMethodBeat.o(201910);
        } catch (Throwable th) {
            Log.e("AdWeAppPreloader", "parseComponentWeAppInfo exp=" + th.toString());
            AppMethodBeat.o(201910);
        }
    }

    private static a a(z zVar) {
        k kVar;
        AppMethodBeat.i(201911);
        if (!(zVar instanceof k) || (kVar = (k) zVar) == null || TextUtils.isEmpty(kVar.username)) {
            AppMethodBeat.o(201911);
            return null;
        }
        a aVar = new a();
        aVar.DsJ = kVar.username;
        aVar.weAppType = kVar.weAppType;
        AppMethodBeat.o(201911);
        return aVar;
    }

    private static void b(List<String> list, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(201912);
        Log.i("AdWeAppPreloader", "startPreloadWeApp, preloadWeAppPkg=" + z + ", hasWeGame=" + z2 + ", hasWeApp=" + z3 + ", weAppUserName=" + gM(list));
        if (z3) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                ((f) g.af(f.class)).b(com.tencent.mm.plugin.appbrand.service.z.SNS_AD);
                Log.i("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniProgram, timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th) {
                Log.e("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniProgram, exp=" + th.toString());
            }
        }
        if (z2) {
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                ((f) g.af(f.class)).c(com.tencent.mm.plugin.appbrand.service.z.SNS_AD);
                Log.i("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniGame, timeCost=" + (System.currentTimeMillis() - currentTimeMillis2));
            } catch (Throwable th2) {
                Log.e("AdWeAppPreloader", "startPreloadWeApp->preloadEnvForMiniGame, exp=" + th2.toString());
            }
        }
        try {
            long currentTimeMillis3 = System.currentTimeMillis();
            ((j) g.af(j.class)).bc(list);
            Log.i("AdWeAppPreloader", "startPreloadWeApp->batchSyncWxaAttr, timeCost=" + (System.currentTimeMillis() - currentTimeMillis3));
        } catch (Throwable th3) {
            Log.e("AdWeAppPreloader", "startPreloadWeApp->batchSyncWxaAttr, exp=" + th3.toString());
        }
        if (z) {
            try {
                long currentTimeMillis4 = System.currentTimeMillis();
                for (String str : list) {
                    aNG(str);
                }
                Log.i("AdWeAppPreloader", "startPreloadWeApp->preloadWeAppPkg, timeCost=" + (System.currentTimeMillis() - currentTimeMillis4));
                AppMethodBeat.o(201912);
                return;
            } catch (Throwable th4) {
                Log.e("AdWeAppPreloader", "startPreloadWeApp->preloadWeAppPkg, exp=" + th4.toString());
            }
        }
        AppMethodBeat.o(201912);
    }

    static {
        AppMethodBeat.i(201915);
        AppMethodBeat.o(201915);
    }

    private static synchronized void aNG(String str) {
        synchronized (e.class) {
            AppMethodBeat.i(201913);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(201913);
            } else if (DsI.contains(str)) {
                Log.w("AdWeAppPreloader", "doPreloadWeAppPkg, already preloaded, userName=".concat(String.valueOf(str)));
                AppMethodBeat.o(201913);
            } else {
                Log.i("AdWeAppPreloader", "doPreloadWeAppPkg, userName=".concat(String.valueOf(str)));
                DsI.add(str);
                ((w) g.af(w.class)).bb(str, 5);
                AppMethodBeat.o(201913);
            }
        }
    }

    private static String gM(List<String> list) {
        AppMethodBeat.i(201914);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(201914);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2));
            if (i2 != list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        String sb2 = sb.toString();
        AppMethodBeat.o(201914);
        return sb2;
    }
}
