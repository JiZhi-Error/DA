package com.tencent.mm.plugin.appbrand.p;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.plugin.appbrand.p.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g implements a {
    private final Map<String, Boolean> cAY = new HashMap();
    private final Set<String> ngQ = new HashSet();
    final h<String, b> ngR = new h<>();
    final d ngS;

    static final class a {
        boolean nhj;
        boolean nhk;

        private a() {
            this.nhj = false;
            this.nhk = true;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(229937);
            String str = "LoadModuleOptions{showPrompt=" + this.nhj + ", injectModuleJS=" + this.nhk + '}';
            AppMethodBeat.o(229937);
            return str;
        }
    }

    public g(d dVar) {
        AppMethodBeat.i(147355);
        this.ngS = dVar;
        AppMethodBeat.o(147355);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.a
    public final boolean bPn() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean bPo() {
        AppMethodBeat.i(147356);
        boolean a2 = a(this.ngS.OM().leE);
        AppMethodBeat.o(147356);
        return a2;
    }

    private boolean a(ModulePkgInfo modulePkgInfo) {
        AppMethodBeat.i(147357);
        boolean z = !Util.isNullOrNil(modulePkgInfo.pkgPath) && s.YS(modulePkgInfo.pkgPath);
        if (z) {
            if (!modulePkgInfo.independent) {
                ex(ModulePkgInfo.MAIN_MODULE_NAME, "checkModuleLoaded");
            }
            ex(modulePkgInfo.name, "checkModuleLoaded");
        }
        AppMethodBeat.o(147357);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void ex(String str, String str2) {
        AppMethodBeat.i(229938);
        Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "injectServiceScriptSafe appId:%s, module:%s, reason:%s ret:%b", this.ngS.mAppId, str, str2, Boolean.valueOf(((f) this.ngS.NY()).dt(str)));
        AppMethodBeat.o(229938);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.a
    public final void a(String str, final a.b bVar) {
        AppMethodBeat.i(169498);
        final a aVar = new a((byte) 0);
        aVar.nhj = true;
        aVar.nhk = true;
        if (this.ngS.isDestroyed()) {
            Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", str, this.ngS.mAppId);
            if (bVar != null) {
                bVar.a(a.d.FAIL);
            }
            AppMethodBeat.o(169498);
            return;
        }
        final i iVar = new i();
        T t = Util.isNullOrNil(str) ? (T) this.ngS.OM().leE : (T) acO(str);
        iVar.value = t;
        if (a(t)) {
            Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule appId:%s path:%s, module:%s, options:%b, [loaded]", this.ngS.mAppId, str, iVar.value.name, aVar);
            if (bVar != null) {
                if (aVar.nhk) {
                    ex(iVar.value.name, "options.injectModuleJS");
                }
                bVar.a(a.d.OK);
                AppMethodBeat.o(169498);
                return;
            }
        }
        final i iVar2 = new i();
        final PBool pBool = new PBool();
        if (aVar.nhj) {
            this.ngS.i(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(229926);
                    if (!pBool.value) {
                        T t = (T) new d().a(new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass1.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(229924);
                                dialogInterface.dismiss();
                                g.a(g.this, iVar.value.name, a.d.CANCEL);
                                AppMethodBeat.o(229924);
                            }
                        });
                        t.ngL = new android.arch.a.c.a<Context, k.a>() {
                            /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass1.AnonymousClass2 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // android.arch.a.c.a
                            public final /* synthetic */ k.a apply(Context context) {
                                AppMethodBeat.i(229925);
                                Context castActivityOrNull = AndroidContextUtil.castActivityOrNull(g.this.ngS.mContext);
                                if (castActivityOrNull == null) {
                                    castActivityOrNull = g.this.ngS.mContext;
                                }
                                com.tencent.mm.plugin.appbrand.widget.dialog.g gVar = new com.tencent.mm.plugin.appbrand.widget.dialog.g(castActivityOrNull);
                                gVar.setMessage(AndroidContextUtil.castActivityOrNull(g.this.ngS.mContext).getString(R.string.et4));
                                AppMethodBeat.o(229925);
                                return gVar;
                            }
                        };
                        t.ab(g.this.ngS);
                        iVar2.value = t;
                    }
                    AppMethodBeat.o(229926);
                }
            }, 0);
        }
        Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, appId:%s path:%s, module:%s, options:%b [do loadOrAddPendingCallback]", this.ngS.mAppId, str, iVar.value.name, aVar);
        a((ModulePkgInfo) iVar.value, (a.b) new a.b() {
            /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.p.a.b
            public final void a(a.d dVar) {
                AppMethodBeat.i(229928);
                pBool.value = true;
                if (a.d.OK == dVar && aVar != null && aVar.nhk) {
                    if (!iVar.value.independent) {
                        g.this.ex(ModulePkgInfo.MAIN_MODULE_NAME, "options.injectModuleJS");
                    }
                    g.this.ex(iVar.value.name, "options.injectModuleJS");
                }
                g.this.ngS.i(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(229927);
                        if (iVar2.value != null) {
                            iVar2.value.dismiss();
                        }
                        AppMethodBeat.o(229927);
                    }
                }, 0);
                if (bVar != null) {
                    bVar.a(dVar);
                }
                AppMethodBeat.o(229928);
            }
        }, (a.AbstractC0766a) new a.AbstractC0766a() {
            /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass3 */
            final /* synthetic */ a.AbstractC0766a nhb = null;

            @Override // com.tencent.mm.plugin.appbrand.p.a.AbstractC0766a
            public final void b(c cVar) {
                AppMethodBeat.i(229929);
                if (Log.getLogLevel() <= 1) {
                    Log.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoadProgress, appId:%s, module:%s, progress:%s", g.this.ngS.mAppId, iVar.value.name, cVar);
                }
                if (this.nhb != null) {
                    this.nhb.b(cVar);
                }
                T t = iVar2.value;
                if (t != null) {
                    int max = Math.max(Math.min(cVar.getProgress(), 100), 0);
                    t.ngN = max;
                    if (t.ngM instanceof com.tencent.mm.plugin.appbrand.widget.dialog.g) {
                        ((com.tencent.mm.plugin.appbrand.widget.dialog.g) t.ngM).setProgress(max);
                    }
                }
                AppMethodBeat.o(229929);
            }
        });
        AppMethodBeat.o(169498);
    }

    private void a(ModulePkgInfo modulePkgInfo, a.b bVar, a.AbstractC0766a aVar) {
        boolean contains;
        AppMethodBeat.i(229940);
        final String str = modulePkgInfo.name;
        final boolean z = !ModulePkgInfo.MAIN_MODULE_NAME.equals(str) && !modulePkgInfo.independent && !bPo();
        if (z) {
            a(this.ngS.OM().leE, (a.b) null, (a.AbstractC0766a) null);
        }
        Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", modulePkgInfo.name, Boolean.valueOf(modulePkgInfo.independent), Boolean.valueOf(z));
        b(str, bVar, aVar);
        synchronized (this.ngQ) {
            try {
                contains = this.ngQ.contains(str);
                if (!contains) {
                    this.ngQ.add(str);
                }
            } finally {
                AppMethodBeat.o(229940);
            }
        }
        if (!contains) {
            final b bVar2 = new b();
            if (z) {
                b(ModulePkgInfo.MAIN_MODULE_NAME, new a.b() {
                    /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass5 */

                    @Override // com.tencent.mm.plugin.appbrand.p.a.b
                    public final void a(a.d dVar) {
                        AppMethodBeat.i(229931);
                        bVar2.ad(null);
                        AppMethodBeat.o(229931);
                    }
                }, null);
            } else {
                bVar2.ad(null);
            }
            e j2 = e.c.ngP.j(this.ngS, this.ngS.OM().leE.cv(this.ngS.mAppId, str));
            j2.a(new e.b() {
                /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.appbrand.p.e.a
                public final void YR(final String str) {
                    AppMethodBeat.i(229934);
                    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", str, str);
                    bVar2.ad(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(229932);
                            if (g.this.ngS.isDestroyed()) {
                                Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) destroyed", str, g.this.ngS.toString());
                                AppMethodBeat.o(229932);
                                return;
                            }
                            boolean z = !Util.isNullOrNil(str) && (!z || g.this.bPo());
                            if (z) {
                                if (!ModulePkgInfo.MAIN_MODULE_NAME.equals(str)) {
                                    Iterator<ModulePkgInfo> it = g.this.ngS.OM().leE.kNZ.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        ModulePkgInfo next = it.next();
                                        if (str.equals(next.name)) {
                                            next.pkgPath = str;
                                            break;
                                        }
                                    }
                                } else {
                                    g.this.ngS.OM().leE.pkgPath = str;
                                    try {
                                        g.this.ngS.OM().leE.md5 = com.tencent.mm.b.g.b(s.openRead(str), 4096);
                                    } catch (FileNotFoundException e2) {
                                        Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", g.this.ngS.mAppId);
                                    }
                                }
                                bg.L(g.this.ngS);
                            }
                            g.a(g.this, str, z ? a.d.OK : a.d.FAIL);
                            AppMethodBeat.o(229932);
                        }
                    });
                    AppMethodBeat.o(229934);
                }

                @Override // com.tencent.mm.plugin.appbrand.p.e.a
                public final void a(c cVar) {
                    AppMethodBeat.i(229935);
                    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", cVar);
                    g gVar = g.this;
                    Set<b> cM = gVar.ngR.cM(str);
                    if (cM == null) {
                        AppMethodBeat.o(229935);
                        return;
                    }
                    for (b bVar : cM) {
                        if (bVar.nhm != null) {
                            bVar.nhm.b(cVar);
                        }
                    }
                    AppMethodBeat.o(229935);
                }

                @Override // com.tencent.mm.plugin.appbrand.p.e.b
                public final void a(final android.arch.a.c.a<AppBrandRuntime, Boolean> aVar) {
                    AppMethodBeat.i(229936);
                    bVar2.ad(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.p.g.AnonymousClass6.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(229933);
                            boolean isDestroyed = g.this.ngS.isDestroyed();
                            boolean booleanValue = isDestroyed ? false : ((Boolean) aVar.apply(g.this.ngS)).booleanValue();
                            Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%b) loaded(%b)", g.this.ngS.toString(), str, Boolean.valueOf(isDestroyed), Boolean.valueOf(booleanValue));
                            if (isDestroyed) {
                                AppMethodBeat.o(229933);
                                return;
                            }
                            if (booleanValue && !g.this.ngS.getAppConfig().lbR.booleanValue()) {
                                g.this.ngS.brk();
                            }
                            g.a(g.this, str, booleanValue ? a.d.OK : a.d.FAIL);
                            AppMethodBeat.o(229933);
                        }
                    });
                    AppMethodBeat.o(229936);
                }
            });
            j2.start();
        }
    }

    private void b(String str, a.b bVar, a.AbstractC0766a aVar) {
        AppMethodBeat.i(147362);
        if (bVar == null && aVar == null) {
            AppMethodBeat.o(147362);
            return;
        }
        this.ngR.r(str, new b(bVar, aVar));
        AppMethodBeat.o(147362);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.a
    public final String acN(String str) {
        AppMethodBeat.i(147363);
        String str2 = acO(str).name;
        AppMethodBeat.o(147363);
        return str2;
    }

    public final ModulePkgInfo acO(String str) {
        AppMethodBeat.i(147364);
        WxaPkgWrappingInfo wxaPkgWrappingInfo = this.ngS.OM().leE;
        if (Util.isNullOrNil(str) || ModulePkgInfo.MAIN_MODULE_NAME.equals(str)) {
            AppMethodBeat.o(147364);
            return wxaPkgWrappingInfo;
        }
        bg.L(this.ngS);
        ModulePkgInfo modulePkgInfo = (ModulePkgInfo) h.e(wxaPkgWrappingInfo.kNZ, str, "findModuleInfoByResourcePath");
        if (modulePkgInfo != null) {
            AppMethodBeat.o(147364);
            return modulePkgInfo;
        }
        AppMethodBeat.o(147364);
        return wxaPkgWrappingInfo;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        final a.b nhl;
        final a.AbstractC0766a nhm;

        public b(a.b bVar, a.AbstractC0766a aVar) {
            this.nhl = bVar;
            this.nhm = aVar;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0021 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.tencent.mm.plugin.appbrand.p.g] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object, com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0023  */
    @Override // com.tencent.mm.plugin.appbrand.p.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r10, final com.tencent.mm.plugin.appbrand.p.a.b r11, com.tencent.mm.plugin.appbrand.p.a.AbstractC0766a r12) {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.p.g.a(java.lang.String, com.tencent.mm.plugin.appbrand.p.a$b, com.tencent.mm.plugin.appbrand.p.a$a):void");
    }

    static /* synthetic */ void a(g gVar, String str, a.d dVar) {
        AppMethodBeat.i(147365);
        synchronized (gVar.ngQ) {
            try {
                gVar.ngQ.remove(str);
            } finally {
                AppMethodBeat.o(147365);
            }
        }
        Set<b> cN = gVar.ngR.cN(str);
        if (cN == null) {
            Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "markLoadingFinished %s, result %s, get null callbackSet, maybe canceled by user before", str, dVar.name());
            AppMethodBeat.o(147365);
            return;
        }
        for (b bVar : cN) {
            if (bVar.nhl != null) {
                bVar.nhl.a(dVar);
            }
        }
    }
}
