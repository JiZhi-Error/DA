package com.tencent.mm.plugin.appbrand.permission.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.permission.a.b;
import com.tencent.mm.plugin.appbrand.permission.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public final class a {
    private static final LinkedList<Runnable> nxZ = new LinkedList<>();
    private static final C0779a nya = new C0779a((byte) 0);
    private static boolean nyb = false;
    private static final Set<String> nyc = new HashSet();
    private final int dMe;
    private final c nxX;
    private final c nxY;

    public interface c {
        void acx(String str);

        void bOI();

        void onCancel();
    }

    private a(c cVar, final c cVar2) {
        AppMethodBeat.i(229995);
        this.nxX = new b(cVar) {
            /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.permission.a.a.b, com.tencent.mm.plugin.appbrand.permission.a.a.c
            public final void bOI() {
                AppMethodBeat.i(229969);
                super.bOI();
                Log.i("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + bTi());
                AppMethodBeat.o(229969);
            }

            @Override // com.tencent.mm.plugin.appbrand.permission.a.a.b, com.tencent.mm.plugin.appbrand.permission.a.a.c
            public final void acx(String str) {
                AppMethodBeat.i(229970);
                super.acx(str);
                Log.i("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", str, bTi());
                AppMethodBeat.o(229970);
            }

            @Override // com.tencent.mm.plugin.appbrand.permission.a.a.b, com.tencent.mm.plugin.appbrand.permission.a.a.c
            public final void onCancel() {
                AppMethodBeat.i(229971);
                super.onCancel();
                Log.i("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + bTi());
                AppMethodBeat.o(229971);
            }

            private String bTi() {
                AppMethodBeat.i(229972);
                com.tencent.mm.plugin.appbrand.d dVar = cVar2.nyB;
                String str = cVar2.nyC;
                String format = String.format(Locale.ENGLISH, "component[%s %s], api[%s]", dVar.getAppId(), dVar.getClass().getSimpleName(), str);
                AppMethodBeat.o(229972);
                return format;
            }
        };
        this.nxY = cVar2;
        this.dMe = cVar2.nyB.getRuntime().kAq.eix;
        AppMethodBeat.o(229995);
    }

    static {
        AppMethodBeat.i(230003);
        AppMethodBeat.o(230003);
    }

    public static boolean eG(String str, String str2) {
        AppMethodBeat.i(229996);
        boolean eH = nya.eH(str, str2);
        AppMethodBeat.o(229996);
        return eH;
    }

    public static boolean a(k kVar, String str) {
        boolean z;
        AppMethodBeat.i(229997);
        if (str.equals(com.tencent.mm.plugin.appbrand.jsapi.wifi.c.NAME)) {
            l OT = kVar.getRuntime().OT();
            Object[] objArr = new Object[1];
            if (!OT.leB) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.i("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", objArr);
            if (!OT.leB) {
                AppMethodBeat.o(229997);
                return true;
            }
            AppMethodBeat.o(229997);
            return false;
        }
        AppMethodBeat.o(229997);
        return false;
    }

    public static void aer(String str) {
        AppMethodBeat.i(229999);
        C0779a aVar = nya;
        if (!Util.isNullOrNil(str)) {
            synchronized (aVar) {
                try {
                    aVar.nyu.remove(str);
                } finally {
                    AppMethodBeat.o(229999);
                }
            }
            return;
        }
        AppMethodBeat.o(229999);
    }

    static final class d extends b {
        /* synthetic */ d(c cVar, byte b2) {
            this(cVar);
        }

        private d(c cVar) {
            super(cVar, (byte) 0);
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.b, com.tencent.mm.plugin.appbrand.permission.a.a.c
        public final void bOI() {
            AppMethodBeat.i(229991);
            super.bOI();
            bTj();
            AppMethodBeat.o(229991);
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.b, com.tencent.mm.plugin.appbrand.permission.a.a.c
        public final void acx(String str) {
            AppMethodBeat.i(229992);
            super.acx(str);
            bTj();
            AppMethodBeat.o(229992);
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.b, com.tencent.mm.plugin.appbrand.permission.a.a.c
        public final void onCancel() {
            AppMethodBeat.i(229993);
            super.onCancel();
            bTj();
            AppMethodBeat.o(229993);
        }

        private void bTj() {
            AppMethodBeat.i(229994);
            m.bZn().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.permission.a.a.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(229990);
                    Runnable runnable = (Runnable) a.nxZ.pollFirst();
                    if (runnable != null) {
                        runnable.run();
                        AppMethodBeat.o(229990);
                        return;
                    }
                    Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
                    boolean unused = a.nyb = false;
                    AppMethodBeat.o(229990);
                }
            });
            AppMethodBeat.o(229994);
        }
    }

    static class b implements c {
        private final c nyv;

        /* synthetic */ b(c cVar, byte b2) {
            this(cVar);
        }

        private b(c cVar) {
            this.nyv = cVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
        public void bOI() {
            AppMethodBeat.i(229987);
            if (this.nyv != null) {
                this.nyv.bOI();
            }
            AppMethodBeat.o(229987);
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
        public void acx(String str) {
            AppMethodBeat.i(229988);
            if (this.nyv != null) {
                this.nyv.acx(str);
            }
            AppMethodBeat.o(229988);
        }

        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
        public void onCancel() {
            AppMethodBeat.i(229989);
            if (this.nyv != null) {
                this.nyv.onCancel();
            }
            AppMethodBeat.o(229989);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.permission.a.a$a  reason: collision with other inner class name */
    public static final class C0779a {
        final HashMap<String, HashSet<String>> nyu;

        private C0779a() {
            AppMethodBeat.i(229983);
            this.nyu = new HashMap<>();
            AppMethodBeat.o(229983);
        }

        /* synthetic */ C0779a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final boolean eH(String str, String str2) {
            boolean z;
            AppMethodBeat.i(229984);
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                AppMethodBeat.o(229984);
                return false;
            }
            synchronized (this) {
                try {
                    HashSet<String> hashSet = this.nyu.get(str);
                    z = hashSet != null && hashSet.contains(str2);
                } finally {
                    AppMethodBeat.o(229984);
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public final void put(String str, String str2) {
            AppMethodBeat.i(229985);
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                AppMethodBeat.o(229985);
                return;
            }
            synchronized (this) {
                try {
                    HashSet<String> hashSet = this.nyu.get(str);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        this.nyu.put(str, hashSet);
                    }
                    hashSet.add(str2);
                } finally {
                    AppMethodBeat.o(229985);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void Y(String str, String str2) {
            AppMethodBeat.i(229986);
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                AppMethodBeat.o(229986);
                return;
            }
            synchronized (this) {
                try {
                    HashSet<String> hashSet = this.nyu.get(str);
                    if (hashSet != null) {
                        hashSet.remove(str2);
                    }
                } finally {
                    AppMethodBeat.o(229986);
                }
            }
        }
    }

    public static void a(final c cVar, final c cVar2) {
        AppMethodBeat.i(229998);
        final String appId = cVar.nyB.getAppId();
        if (Util.isNullOrNil(appId) || Util.isNullOrNil(cVar.nyC)) {
            AppMethodBeat.o(229998);
            return;
        }
        synchronized (nyc) {
            try {
                if (!nyc.contains(appId)) {
                    h.a(appId, new h.c() {
                        /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass7 */

                        @Override // com.tencent.mm.plugin.appbrand.h.c
                        public final void onDestroy() {
                            AppMethodBeat.i(229980);
                            a.aer(appId);
                            a.nyc.remove(appId);
                            AppMethodBeat.o(229980);
                        }
                    });
                }
            } catch (Throwable th) {
                AppMethodBeat.o(229998);
                throw th;
            }
        }
        final AnonymousClass8 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(229981);
                a.b(cVar, new d(cVar2, (byte) 0));
                AppMethodBeat.o(229981);
            }
        };
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(229982);
                if (a.nyb) {
                    a.nxZ.add(r1);
                    Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", appId, cVar.nyC);
                    AppMethodBeat.o(229982);
                    return;
                }
                boolean unused = a.nyb = true;
                r1.run();
                AppMethodBeat.o(229982);
            }
        });
        AppMethodBeat.o(229998);
    }

    static /* synthetic */ void a(a aVar, final cep cep) {
        AppMethodBeat.i(230000);
        final com.tencent.mm.plugin.appbrand.d dVar = aVar.nxY.nyB;
        final String appId = dVar.getAppId();
        final String str = aVar.nxY.nyC;
        final AppBrandRuntime runtime = dVar.getRuntime();
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, appId %s, api %s, checkAuth Response.errcode %d", appId, str, Integer.valueOf(cep.Mkb.dIZ));
        if (cep.Mkb.dIZ == 0) {
            nya.put(appId, str);
            aVar.nxX.bOI();
            AppMethodBeat.o(230000);
        } else if (cep.Mkb.dIZ != -12000) {
            aVar.nxX.acx(cep.Mkb.dJa);
            AppMethodBeat.o(230000);
        } else {
            final drb drb = cep.LRN.get(0);
            if (drb == null) {
                aVar.nxX.acx(null);
                AppMethodBeat.o(230000);
                return;
            }
            final String str2 = cep.Mkg;
            final String str3 = cep.Mkf;
            final String str4 = cep.Mke;
            final String str5 = drb.KWK;
            final boolean a2 = q.a(str5, runtime.OT());
            final String a3 = q.a(str5, runtime);
            if (!a2 || !TextUtils.isEmpty(a3)) {
                dVar.P(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(229979);
                        if (runtime.brh() == null) {
                            AppMethodBeat.o(229979);
                            return;
                        }
                        b a2 = b.a.a(dVar, new h.b() {
                            /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass6.AnonymousClass1 */

                            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                            @Override // com.tencent.mm.plugin.appbrand.permission.a.b.c
                            public final void a(int i2, ArrayList<String> arrayList, int i3) {
                                boolean z;
                                AppMethodBeat.i(229978);
                                String str = str5;
                                if (cep.LRN.size() > 1) {
                                    str = com.tencent.luggage.h.b.G(arrayList).size() > 0 ? arrayList.get(0) : str5;
                                    if (cep.Mkj == null) {
                                        Log.i("MicroMsg.AppBrandJsApiUserAuth", "response.jsapi_scope null , appId %s, api %s", appId, str);
                                        a.this.nxX.onCancel();
                                        AppMethodBeat.o(229978);
                                        return;
                                    }
                                    z = cep.Mkj.equals(str);
                                } else {
                                    z = true;
                                }
                                switch (i2) {
                                    case 1:
                                        a.a(a.this, str, 1, z);
                                        if (!z) {
                                            Log.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth appId %s, api %s , target scope:%s, accept scope:%s, deny!", appId, str, str5, str);
                                            a.this.nxX.acx(null);
                                            AppMethodBeat.o(229978);
                                            return;
                                        }
                                        a.nya.put(appId, str);
                                        Log.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", appId, str);
                                        a.this.nxX.bOI();
                                        AppMethodBeat.o(229978);
                                        return;
                                    case 2:
                                        a.a(a.this, str, 2, z);
                                        a.nya.Y(appId, str);
                                        Log.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user deny, appId %s, api %s", appId, str);
                                        a.this.nxX.acx(null);
                                        AppMethodBeat.o(229978);
                                        return;
                                    case 3:
                                        a.nya.Y(appId, str);
                                        Log.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", appId, str);
                                        a.this.nxX.onCancel();
                                        break;
                                }
                                AppMethodBeat.o(229978);
                            }
                        });
                        a2.setAppBrandName(runtime.OT().brandName);
                        a2.setApplyWording(str2);
                        a2.setRequestDesc(drb.Desc);
                        a2.setNegativeButtonText(str4);
                        a2.setPositiveButtonText(str3);
                        a2.setIconUrl(cep.KFs);
                        if (a2) {
                            a2.setSimpleDetailDesc(a3);
                        }
                        if (cep.LRN.size() > 1) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new i.a(cep.LRN.get(0).MTK, cep.LRN.get(0).KWK, true));
                            for (int i2 = 1; i2 < cep.LRN.size(); i2++) {
                                arrayList.add(new i.a(cep.LRN.get(i2).MTK, cep.LRN.get(i2).KWK, false));
                            }
                            a2.setFunctionButtonVisibility(8);
                            a2.setSelectListItem(arrayList);
                        }
                        a2.h(dVar);
                        AppMethodBeat.o(229979);
                    }
                });
                AppMethodBeat.o(230000);
                return;
            }
            aVar.nxX.acx("fail:require permission desc");
            Log.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, error = fail:require permission desc");
            AppMethodBeat.o(230000);
        }
    }

    static /* synthetic */ void a(a aVar, final String str, final int i2, final boolean z) {
        AppMethodBeat.i(230001);
        cem cem = new cem();
        cem.jfi = aVar.nxY.nyB.getAppId();
        cem.MjX.add(str);
        cem.MjY = i2;
        final String appId = aVar.nxY.nyB.getAppId();
        final String str2 = aVar.nxY.nyC;
        ((com.tencent.mm.plugin.appbrand.networking.c) Objects.requireNonNull(aVar.nxY.nyB.M(com.tencent.mm.plugin.appbrand.networking.c.class))).a("/cgi-bin/mmbiz-bin/js-authorize-confirm", cem, cen.class).c(new com.tencent.mm.vending.c.a<Void, cen>() {
            /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(cen cen) {
                AppMethodBeat.i(229974);
                Void a2 = a(cen);
                AppMethodBeat.o(229974);
                return a2;
            }

            private Void a(cen cen) {
                AppMethodBeat.i(229973);
                if (cen.Mkb.dIZ == 0 && 1 == i2) {
                    Log.i("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s  scope=%s", appId, str2, str);
                    if (z) {
                        a.nya.put(appId, str2);
                    }
                }
                AppMethodBeat.o(229973);
                return null;
            }
        });
        AppMethodBeat.o(230001);
    }

    static /* synthetic */ void b(c cVar, c cVar2) {
        AppMethodBeat.i(230002);
        if (!cVar.nyB.isRunning()) {
            cVar2.onCancel();
            AppMethodBeat.o(230002);
            return;
        }
        String appId = cVar.nyB.getAppId();
        String str = cVar.nyC;
        if (nya.eH(appId, str)) {
            Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", appId, str);
            cVar2.bOI();
            AppMethodBeat.o(230002);
            return;
        }
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", appId, str);
        a aVar = new a(cVar2, cVar);
        com.tencent.mm.plugin.appbrand.d dVar = aVar.nxY.nyB;
        final String appId2 = dVar.getAppId();
        final String str2 = aVar.nxY.nyC;
        AppBrandRuntime runtime = dVar.getRuntime();
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "checkAuth appId = %s,mApi = %s", appId2, str2);
        ceo ceo = new ceo();
        ceo.jfi = appId2;
        ceo.Mkd = str2;
        ceo.MjZ = aVar.dMe;
        ceo.Mka = new fdg();
        if (runtime instanceof com.tencent.luggage.sdk.d.d) {
            ceo.Mka.scene = ((com.tencent.luggage.sdk.d.d) runtime).ON().cyA.scene;
        }
        if (dVar instanceof s) {
            ceo.Mka.NyS = 1;
        } else if (dVar instanceof ac) {
            ceo.Mka.NyS = 2;
        }
        ((com.tencent.mm.plugin.appbrand.networking.c) Objects.requireNonNull(dVar.M(com.tencent.mm.plugin.appbrand.networking.c.class))).a("/cgi-bin/mmbiz-bin/js-authorize", ceo, cep.class).c(new com.tencent.mm.vending.c.a<Void, cep>() {
            /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(cep cep) {
                AppMethodBeat.i(229977);
                Void b2 = b(cep);
                AppMethodBeat.o(229977);
                return b2;
            }

            private Void b(cep cep) {
                AppMethodBeat.i(229976);
                try {
                    a.a(a.this, cep);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth appId = %s, e = %s", appId2, e2);
                    g.hdx().ej(e2);
                }
                AppMethodBeat.o(229976);
                return null;
            }
        }).a(new d.b<Void>() {
            /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.g.d.b
            public final /* bridge */ /* synthetic */ void bz(Void r1) {
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.appbrand.permission.a.a.AnonymousClass3 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(229975);
                a.nya.Y(appId2, str2);
                a.this.nxX.acx(null);
                AppMethodBeat.o(229975);
            }
        });
        AppMethodBeat.o(230002);
    }
}
