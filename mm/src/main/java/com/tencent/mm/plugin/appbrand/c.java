package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.a.a;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Locale;

public class c implements f.b {
    private final AppBrandRuntime kzp;
    private final d kzq;
    final f kzr;

    public c(AppBrandRuntime appBrandRuntime, f fVar, d dVar) {
        this.kzp = appBrandRuntime;
        this.kzr = fVar;
        this.kzq = dVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f.b
    public void V(int i2, String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f.b
    public boolean a(final p pVar, String str, int i2, final f.a aVar) {
        d.a aVar2;
        AppMethodBeat.i(146923);
        d dVar = this.kzq;
        f fVar = this.kzr;
        AnonymousClass1 r3 = new d.b() {
            /* class com.tencent.mm.plugin.appbrand.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.permission.d.b
            public final void a(d.a aVar) {
                String str;
                AppMethodBeat.i(146922);
                if (c.this.kzr == null || !c.this.kzr.isRunning()) {
                    AppMethodBeat.o(146922);
                } else if (aVar.ret == 0) {
                    aVar.proceed();
                    AppMethodBeat.o(146922);
                } else {
                    if (TextUtils.isEmpty(aVar.msg)) {
                        str = "fail:internal error";
                    } else {
                        str = aVar.msg;
                    }
                    aVar.Zb(pVar.h(str, null));
                    AppMethodBeat.o(146922);
                }
            }
        };
        if (pVar == null || fVar == null) {
            aVar2 = d.a.nxD;
        } else {
            b bwY = dVar.kEc.kAH.kQM.bwY();
            int a2 = dVar.a(fVar, pVar, str, true);
            String appId = fVar.getAppId();
            if (a2 == 6) {
                d.l(fVar, pVar.getName());
            } else if (a2 == 1) {
                if (!(fVar instanceof s) || bwY != b.SUSPEND || !a.contains(d.nxx, pVar.getName())) {
                    aVar2 = d.a.nxE;
                } else {
                    aVar2 = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", pVar.getName(), bwY.name().toLowerCase(), "permission ok", "network api interrupted in suspend state"));
                }
            } else if (a2 == 4) {
                if (com.tencent.mm.plugin.appbrand.permission.a.a.eG(appId, pVar.getName())) {
                    aVar2 = d.a.nxE;
                } else if (com.tencent.mm.plugin.appbrand.permission.a.a.a((k) fVar, pVar.getName())) {
                    aVar2 = d.a.nxE;
                } else {
                    com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((d) fVar, pVar.getName(), str, i2), new a.c(r3) {
                        /* class com.tencent.mm.plugin.appbrand.permission.d.AnonymousClass1 */
                        final /* synthetic */ b nxy;

                        {
                            this.nxy = r2;
                        }

                        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
                        public final void bOI() {
                            AppMethodBeat.i(147640);
                            if (this.nxy != null) {
                                this.nxy.a(a.nxE);
                            }
                            AppMethodBeat.o(147640);
                        }

                        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
                        public final void acx(String str) {
                            AppMethodBeat.i(147641);
                            if (this.nxy != null) {
                                if (TextUtils.isEmpty(str)) {
                                    this.nxy.a(a.nxB);
                                    AppMethodBeat.o(147641);
                                    return;
                                }
                                this.nxy.a(new a(-1, "fail ".concat(String.valueOf(str))));
                            }
                            AppMethodBeat.o(147641);
                        }

                        @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
                        public final void onCancel() {
                            AppMethodBeat.i(147642);
                            if (this.nxy != null) {
                                this.nxy.a(a.nxA);
                            }
                            AppMethodBeat.o(147642);
                        }
                    });
                    aVar2 = d.a.nxC;
                }
            } else if (a2 == 7) {
                if (dVar.kEc.kAH.kQM.bwZ()) {
                    aVar2 = d.a.nxE;
                } else {
                    aVar2 = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", pVar.getName(), bwY.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state"));
                }
            } else if (a2 == 8) {
                synchronized (dVar.nxr) {
                    try {
                        dVar.nxr.addLast(r3);
                    } catch (Throwable th) {
                        AppMethodBeat.o(146923);
                        throw th;
                    }
                }
                aVar2 = d.a.nxC;
            }
            aVar2 = d.a.nxD;
        }
        if (-2 == aVar2.ret) {
            AppMethodBeat.o(146923);
            return true;
        } else if (aVar2.ret != 0) {
            aVar.Zb(pVar.h(aVar2.msg, null));
            AppMethodBeat.o(146923);
            return true;
        } else {
            AppMethodBeat.o(146923);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f.b
    public void a(p pVar, String str, int i2, String str2) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.tencent.mm.plugin.appbrand.permission.d */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.f.b
    public final void a(bc bcVar, f.a aVar) {
        boolean z;
        com.tencent.mm.plugin.appbrand.a.c cVar;
        boolean z2;
        AppMethodBeat.i(146924);
        com.tencent.mm.plugin.appbrand.a.c cVar2 = null;
        try {
            if (this.kzp == null || (cVar2 = this.kzp.kAH) == null || cVar2.kQM.kQW.get()) {
                z = false;
                cVar = cVar2;
            } else {
                z = true;
                cVar = cVar2;
            }
            if (!z) {
                aVar.Zb("fail:interrupted");
                AppMethodBeat.o(146924);
                return;
            }
            if (!this.kzr.isRunning() && !this.kzr.bsV()) {
                Log.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", bcVar.getName(), this.kzr.getAppId());
                aVar.Zb("fail:interrupted");
                AppMethodBeat.o(146924);
                return;
            }
            b bwY = cVar.kQM.bwY();
            boolean a2 = this.kzq.a(this.kzr, (Class<? extends e>) bcVar.getClass());
            boolean z3 = b.SUSPEND == bwY || a2;
            com.tencent.mm.plugin.appbrand.permission.k kVar = (com.tencent.mm.plugin.appbrand.permission.k) this.kzr.M(com.tencent.mm.plugin.appbrand.permission.k.class);
            if (kVar == null || !kVar.a(bcVar)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Log.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", Boolean.valueOf(z3), bcVar.getName(), bwY, Boolean.valueOf(a2));
                if (WeChatEnvironment.hasDebugger()) {
                    if (bcVar.getName().equals(com.tencent.mm.plugin.appbrand.jsapi.v.a.NAME)) {
                        Log.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", bcVar.getName(), Integer.valueOf(bcVar.getData().length()));
                    } else {
                        Log.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", bcVar.getName(), bcVar.getData());
                    }
                }
            }
            if (!z3) {
                aVar.Zb("fail:access denied");
                AppMethodBeat.o(146924);
                return;
            }
            aVar.proceed();
            AppMethodBeat.o(146924);
        } catch (NullPointerException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", e2, "onDispatchImpl %s", bcVar.getName());
            AppMethodBeat.o(146924);
        }
    }
}
