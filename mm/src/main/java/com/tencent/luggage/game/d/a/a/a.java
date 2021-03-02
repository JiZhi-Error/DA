package com.tencent.luggage.game.d.a.a;

import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.b.a.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.luggage.sdk.b.a.c.f;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.j;
import com.tencent.mm.plugin.appbrand.aa.b;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.debugger.m;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.protocal.protobuf.evi;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import org.json.JSONObject;

public class a<Service extends com.tencent.luggage.sdk.b.a.c.d> extends f<Service> implements b {
    private volatile boolean cvU = false;
    private boolean cvV = false;
    private o cvW = null;
    private boolean cvX = false;
    private boolean cvY = false;
    private int cvZ = 0;
    public com.tencent.luggage.game.a.b cwa = null;
    private com.tencent.luggage.sdk.b.a.a.c cwb;
    private com.tencent.luggage.sdk.b.a.a.a cwc;
    private com.tencent.luggage.sdk.b.a.a.d cwd;
    private com.tencent.luggage.game.c.e cwe = null;
    private m cwf = null;

    public static class b implements b.a {
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(178035);
        aVar.Om();
        AppMethodBeat.o(178035);
    }

    @Override // com.tencent.luggage.game.d.a.a.b
    public final com.tencent.luggage.game.c.e Mg() {
        AppMethodBeat.i(130558);
        if (this.cwe == null) {
            synchronized (this) {
                try {
                    if (this.cwe == null) {
                        this.cwe = new com.tencent.luggage.game.c.e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(130558);
                    throw th;
                }
            }
        }
        com.tencent.luggage.game.c.e eVar = this.cwe;
        AppMethodBeat.o(130558);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.j
    public final void ds(String str) {
        AppMethodBeat.i(178033);
        Log.d("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", str);
        evi evi = new evi();
        evi.Ntn = ((com.tencent.luggage.sdk.b.a.c.d) NN()).Oq().getComponentId();
        evi.Ntm = str;
        this.cvW.a(v.a(evi, this.cwf, "domEvent"));
        AppMethodBeat.o(178033);
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.j
    public final String Mh() {
        AppMethodBeat.i(130559);
        JSONObject Or = ((com.tencent.luggage.sdk.b.a.c.d) NN()).Or();
        String format = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", Or.toString(), ((com.tencent.luggage.sdk.b.a.c.d) NN()).NP().getAppConfig().lcc);
        AppMethodBeat.o(130559);
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c9  */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(org.json.JSONObject r12) {
        /*
        // Method dump skipped, instructions count: 356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.game.d.a.a.a.c(org.json.JSONObject):void");
    }

    public a(Service service) {
        super(service);
        AppMethodBeat.i(130561);
        b(b.class, this);
        Mi();
        AppMethodBeat.o(130561);
    }

    /* access modifiers changed from: protected */
    public void Mi() {
        AppMethodBeat.i(130562);
        new com.tencent.luggage.game.b.d().LW();
        AppMethodBeat.o(130562);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean d(String str, JSONObject jSONObject) {
        AppMethodBeat.i(222880);
        if ("Image".equals(str)) {
            AppMethodBeat.o(222880);
            return true;
        } else if ("OffscreenCanvas".equals(str)) {
            AppMethodBeat.o(222880);
            return true;
        } else if ("MediaToolKit".equals(str)) {
            AppMethodBeat.o(222880);
            return true;
        } else if ("CpuProfiler".equals(str)) {
            AppMethodBeat.o(222880);
            return true;
        } else if ("HeapProfiler".equals(str)) {
            AppMethodBeat.o(222880);
            return true;
        } else if ("Box2D".equals(str)) {
            this.cwa.getMagicBrush().dX("mmbox2d");
            AppMethodBeat.o(222880);
            return true;
        } else if ("Phys3D".equals(str)) {
            this.cwa.getMagicBrush().dX("mmphysx");
            AppMethodBeat.o(222880);
            return true;
        } else {
            boolean d2 = super.d(str, jSONObject);
            AppMethodBeat.o(222880);
            return d2;
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean Mj() {
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.tencent.luggage.game.d.a.a.a<Service extends com.tencent.luggage.sdk.b.a.c.d> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public i Mk() {
        AppMethodBeat.i(130563);
        Log.i("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
        long currentTimeMillis = System.currentTimeMillis();
        String Mo = Mo();
        byte[] bArr = null;
        if (Mp()) {
            if (q.is64BitRuntime()) {
                bArr = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot64.bin");
            } else {
                bArr = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot.bin");
            }
        }
        i d2 = d(Mo, bArr);
        e a2 = a((com.tencent.luggage.sdk.b.a.c.d) NN(), (t) d2.R(t.class));
        d2.setJsExceptionHandler(new h() {
            /* class com.tencent.luggage.game.d.a.a.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.m.h
            public final void u(String str, String str2) {
                AppMethodBeat.i(130540);
                com.tencent.luggage.sdk.b.a.c.d dVar = (com.tencent.luggage.sdk.b.a.c.d) a.this.NN();
                i jsRuntime = dVar == null ? null : dVar.getJsRuntime();
                if (jsRuntime == null) {
                    AppMethodBeat.o(130540);
                    return;
                }
                Log.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", str, str2);
                cx.a(jsRuntime, "onError", String.format("{'message':'%s', 'stack': '%s'}", r.afJ(str), r.afJ(str2)), 0);
                com.tencent.mm.plugin.appbrand.aa.b unused = b.a.nOf;
                com.tencent.mm.plugin.appbrand.aa.b.N(KSProcessWeAppLaunch.NAME, str, str2);
                AppMethodBeat.o(130540);
            }
        });
        d2.addJavascriptInterface(a2, "WeixinJSContext");
        s.a(d2, com.tencent.luggage.sdk.b.a.c.h.cBq, new s.a() {
            /* class com.tencent.luggage.game.d.a.a.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(130600);
                Log.i("MicroMsg.WAGameJsContextInterfaceLU", "Interface port loadJsFiles success");
                AppMethodBeat.o(130600);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(130601);
                Log.e("MicroMsg.WAGameJsContextInterfaceLU", "Interface port loadJsFiles fail");
                AppMethodBeat.o(130601);
            }
        });
        s.a(d2, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", "WeixinJSContext"), new s.a() {
            /* class com.tencent.luggage.game.d.a.a.e.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(222884);
                Log.i("MicroMsg.WAGameJsContextInterfaceLU", "Interface dl: success");
                AppMethodBeat.o(222884);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(222885);
                Log.i("MicroMsg.WAGameJsContextInterfaceLU", "Interface dl: fail");
                AppMethodBeat.o(222885);
            }
        });
        a2.MJ();
        Log.i("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(130563);
        return d2;
    }

    /* access modifiers changed from: protected */
    public i d(String str, byte[] bArr) {
        AppMethodBeat.i(130564);
        IJSRuntime.Config config = new IJSRuntime.Config(str, bArr);
        config.dpm = true;
        config.dpl = "1";
        config.dpo = true;
        config.dps = new WeakReference<>(NN());
        com.tencent.mm.plugin.appbrand.m.b bVar = new com.tencent.mm.plugin.appbrand.m.b(config);
        AppMethodBeat.o(130564);
        return bVar;
    }

    /* access modifiers changed from: protected */
    public e a(Service service, t tVar) {
        AppMethodBeat.i(130565);
        e eVar = new e(service, tVar);
        AppMethodBeat.o(130565);
        return eVar;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void Ml() {
        AppMethodBeat.i(130566);
        super.Ml();
        this.cwb = new com.tencent.luggage.sdk.b.a.a.c();
        this.cwb.a(((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime(), NN());
        this.cwc = new com.tencent.luggage.sdk.b.a.a.a();
        com.tencent.luggage.sdk.b.a.a.a aVar = this.cwc;
        i jsRuntime = ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime();
        com.tencent.mm.plugin.appbrand.jsapi.f NN = NN();
        Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding");
        if (jsRuntime == null) {
            Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsruntime is null");
        } else {
            aVar.czC = "1004";
            com.tencent.mm.game.a.a.loadLibraries();
            com.tencent.mm.plugin.appbrand.m.q qVar = (com.tencent.mm.plugin.appbrand.m.q) jsRuntime.R(com.tencent.mm.plugin.appbrand.m.q.class);
            if (qVar == null) {
                Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding jsThreadHandler is null");
            } else {
                com.tencent.luggage.sdk.b.a.a.b bVar = (com.tencent.luggage.sdk.b.a.a.b) NN.M(com.tencent.luggage.sdk.b.a.a.b.class);
                if (bVar != null) {
                    aVar.czD = bVar.Oa();
                    Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding xLibUVSwitch:%b ", Boolean.valueOf(aVar.czD));
                }
                qVar.post(new Runnable(jsRuntime, new LockStepNative.ILockStepListener(new WeakReference(qVar)) {
                    /* class com.tencent.luggage.sdk.b.a.a.a.AnonymousClass1 */
                    final /* synthetic */ WeakReference czF;

                    {
                        this.czF = r2;
                    }

                    @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener
                    public final void onCallBack(final long j2, final String str) {
                        AppMethodBeat.i(146742);
                        ((com.tencent.mm.plugin.appbrand.m.q) this.czF.get()).post(new Runnable() {
                            /* class com.tencent.luggage.sdk.b.a.a.a.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(146741);
                                Log.d("Luggage.LockStepNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,locksteplogicId:%d", str, Long.valueOf(j2));
                                a.this.czB.updateNativeInterface(j2);
                                AppMethodBeat.o(146741);
                            }
                        });
                        AppMethodBeat.o(146742);
                    }
                }, new LockStepNative.ILockStepReportListener() {
                    /* class com.tencent.luggage.sdk.b.a.a.a.AnonymousClass2 */

                    @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
                    public final int getNetworkType() {
                        AppMethodBeat.i(146743);
                        int statisticsNetType = a.getStatisticsNetType();
                        AppMethodBeat.o(146743);
                        return statisticsNetType;
                    }

                    @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
                    public final void onKvStat(int i2, String str) {
                        AppMethodBeat.i(146744);
                        Log.d("Luggage.LockStepNativeInstallHelper", "mmudp onKvStat logId:%d", Integer.valueOf(i2));
                        ((com.tencent.mm.plugin.appbrand.w.b) e.N(com.tencent.mm.plugin.appbrand.w.b.class)).kvStat(i2, str);
                        AppMethodBeat.o(146744);
                    }

                    @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
                    public final void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
                        AppMethodBeat.i(146745);
                        Log.d("Luggage.LockStepNativeInstallHelper", "mmudp onIdKeyStat");
                        ArrayList<IDKey> arrayList = new ArrayList<>();
                        for (int i2 = 0; i2 < iArr.length; i2++) {
                            arrayList.add(new IDKey(iArr[i2], iArr2[i2], iArr3[i2]));
                        }
                        ((com.tencent.mm.plugin.appbrand.w.a) e.N(com.tencent.mm.plugin.appbrand.w.a.class)).b(arrayList, false);
                        AppMethodBeat.o(146745);
                    }
                }) {
                    /* class com.tencent.luggage.sdk.b.a.a.a.AnonymousClass3 */
                    final /* synthetic */ i czK;
                    final /* synthetic */ LockStepNative.ILockStepListener czL;
                    final /* synthetic */ LockStepNative.ILockStepReportListener czM;

                    {
                        this.czK = r2;
                        this.czL = r3;
                        this.czM = r4;
                    }

                    public final void run() {
                        AppMethodBeat.i(146746);
                        Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding setCallback ");
                        if (a.this.czB != null) {
                            Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding lockStepNative != null");
                            AppMethodBeat.o(146746);
                            return;
                        }
                        com.tencent.mm.plugin.appbrand.m.v vVar = (com.tencent.mm.plugin.appbrand.m.v) this.czK.R(com.tencent.mm.plugin.appbrand.m.v.class);
                        if (vVar == null) {
                            Log.e("Luggage.LockStepNativeInstallHelper", "createLockStepBinding v8Addon is null");
                            AppMethodBeat.o(146746);
                            return;
                        }
                        if (a.this.czD) {
                            a.this.czB = new LockStepNative(vVar.getIsolatePtr(), vVar.XK(), vVar.getUVLoopPtr());
                        } else {
                            a.this.czB = new LockStepNative(vVar.getIsolatePtr(), vVar.XK(), 0);
                        }
                        Log.i("Luggage.LockStepNativeInstallHelper", "createLockStepBinding setCallback ret:%d", Integer.valueOf(a.this.czB.setCallback(this.czL, this.czM)));
                        AppMethodBeat.o(146746);
                    }
                });
            }
        }
        this.cwd = new com.tencent.luggage.sdk.b.a.a.d();
        this.cwd.a(((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime(), NN(), 1);
        AppMethodBeat.o(130566);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void Mm() {
        AppMethodBeat.i(130567);
        super.Mm();
        if (this.cwa != null) {
            this.cwa.destroy();
        }
        if (this.cwb != null) {
            this.cwb.a(((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime());
        }
        if (this.cwc != null) {
            com.tencent.luggage.sdk.b.a.a.a aVar = this.cwc;
            i jsRuntime = ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime();
            Log.i("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding");
            if (jsRuntime == null) {
                Log.e("Luggage.LockStepNativeInstallHelper", "destroyLockStepBinding jsruntime is null");
            } else {
                ((com.tencent.mm.plugin.appbrand.m.m) jsRuntime.R(com.tencent.mm.plugin.appbrand.m.m.class)).a(aVar.czE);
            }
        }
        if (this.cwd != null) {
            this.cwd.b(((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime());
        }
        AppMethodBeat.o(130567);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void Mn() {
        AppMethodBeat.i(130568);
        super.Mn();
        if (this.cwa != null) {
            com.tencent.luggage.game.a.b bVar = this.cwa;
            Log.i("MicroMsg.MagicBrush", "awaitDestroyDone");
            if (!bVar.cuk.aZ(5000) && BuildInfo.DEBUG) {
                IllegalStateException illegalStateException = new IllegalStateException("WAGame destroy timeout");
                AppMethodBeat.o(130568);
                throw illegalStateException;
            }
        }
        if (this.cvW != null) {
            this.cvW.destroy();
        }
        AppMethodBeat.o(130568);
    }

    /* access modifiers changed from: protected */
    public String Mo() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean Mp() {
        return true;
    }

    private void Mq() {
        AppMethodBeat.i(130569);
        try {
            i jsRuntime = ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime();
            if (jsRuntime == null) {
                AppMethodBeat.o(130569);
                return;
            }
            com.tencent.mm.plugin.appbrand.m.q qVar = (com.tencent.mm.plugin.appbrand.m.q) jsRuntime.R(com.tencent.mm.plugin.appbrand.m.q.class);
            if (qVar != null) {
                qVar.setThreadPriority(-8);
            }
            AppMethodBeat.o(130569);
        } catch (Throwable th) {
            Log.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", th, "[CAPTURED CRASH]", new Object[0]);
            AppMethodBeat.o(130569);
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void c(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(130570);
        super.c(appBrandRuntime);
        Mv();
        if (this.cwa != null) {
            this.cwa.b(appBrandRuntime);
        }
        if (this.cwd != null) {
            this.cwd.a(((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime(), (k) NN());
        }
        if (this.cwc != null) {
            com.tencent.luggage.sdk.b.a.a.a aVar = this.cwc;
            i jsRuntime = ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime();
            com.tencent.mm.plugin.appbrand.jsapi.f NN = NN();
            Log.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep");
            if (jsRuntime == null) {
                Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsruntime is null");
            } else {
                com.tencent.mm.plugin.appbrand.m.q qVar = (com.tencent.mm.plugin.appbrand.m.q) jsRuntime.R(com.tencent.mm.plugin.appbrand.m.q.class);
                if (qVar == null) {
                    Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep jsThreadHandler is null");
                } else {
                    qVar.post(new Runnable(NN) {
                        /* class com.tencent.luggage.sdk.b.a.a.a.AnonymousClass4 */
                        final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.f czN;

                        {
                            this.czN = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(146747);
                            Log.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep initConfig ");
                            if (a.this.czB == null) {
                                Log.i("Luggage.LockStepNativeInstallHelper", "initConfigLockStep lockStepNative is null");
                                AppMethodBeat.o(146747);
                                return;
                            }
                            l lVar = (l) this.czN.av(l.class);
                            if (lVar != null) {
                                Log.i("Luggage.LockStepNativeInstallHelper", "lockstep appId:%s,pkgDebugType:%d,pkgVersion:%d,mbzType:%s", lVar.appId, Integer.valueOf(lVar.leE.kNW + 1), Integer.valueOf(lVar.leE.pkgVersion), a.this.czC);
                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put("appid", lVar.appId);
                                hashMap.put("appstate", String.valueOf(lVar.leE.kNW + 1));
                                hashMap.put("appversion", String.valueOf(lVar.leE.pkgVersion));
                                hashMap.put("apptype", a.this.czC);
                                a.this.czB.initConfig(hashMap);
                                AppMethodBeat.o(146747);
                                return;
                            }
                            Log.e("Luggage.LockStepNativeInstallHelper", "initConfigLockStep sysConfig is null");
                            AppMethodBeat.o(146747);
                        }
                    });
                }
            }
        }
        Mq();
        appBrandRuntime.b(ag.class, new com.tencent.luggage.game.f.a(appBrandRuntime));
        this.cwa.getMagicBrush().cLz.addSurfaceListenerForAllViews(new MagicBrushView.d() {
            /* class com.tencent.luggage.game.d.a.a.a.AnonymousClass2 */

            @Override // com.tencent.magicbrush.ui.MagicBrushView.e, com.tencent.magicbrush.ui.MagicBrushView.d
            public final void aJ(Object obj) {
                AppMethodBeat.i(162096);
                com.tencent.luggage.sdk.d.d NP = a.this.NP();
                if (!(NP == null || NP.kAH == null)) {
                    NP.kAH.gK(true);
                    com.tencent.mm.plugin.appbrand.a.d dVar = NP.kAH.kQM;
                    LinkedList linkedList = new LinkedList(dVar.kRa);
                    dVar.kRa.clear();
                    while (!linkedList.isEmpty()) {
                        j jVar = (j) linkedList.poll();
                        MMHandler mMHandler = jVar.mHandler;
                        if (mMHandler != null) {
                            jVar.mHandler.removeCallbacks(jVar.task);
                            if (Looper.myLooper() == mMHandler.getLooper()) {
                                jVar.task.run();
                            } else {
                                jVar.setResultFinish(jVar.result);
                            }
                        }
                    }
                }
                AppMethodBeat.o(162096);
            }

            @Override // com.tencent.magicbrush.ui.MagicBrushView.d, com.tencent.magicbrush.ui.MagicBrushView.c
            public final void a(Object obj, boolean z) {
                AppMethodBeat.i(222877);
                com.tencent.luggage.sdk.d.d NP = a.this.NP();
                if (!(NP == null || NP.kAH == null)) {
                    NP.kAH.gK(false);
                }
                AppMethodBeat.o(222877);
            }
        });
        AppMethodBeat.o(130570);
    }

    /* access modifiers changed from: protected */
    public boolean Mr() {
        AppMethodBeat.i(130571);
        if (((com.tencent.luggage.sdk.b.a.c.d) NN()).NP() != null) {
            com.tencent.mm.plugin.appbrand.config.b appConfig = ((com.tencent.luggage.sdk.b.a.c.d) NN()).NP().getAppConfig();
            if (appConfig.lbQ != null) {
                boolean booleanValue = appConfig.lbQ.booleanValue();
                AppMethodBeat.o(130571);
                return booleanValue;
            }
        }
        AppMethodBeat.o(130571);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean Ms() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int Mt() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public boolean Mu() {
        return false;
    }

    /* access modifiers changed from: protected */
    public com.tencent.luggage.game.a.b a(boolean z, boolean z2, int i2, boolean z3) {
        AppMethodBeat.i(222881);
        AnonymousClass3 r0 = new com.tencent.luggage.game.a.b(((com.tencent.luggage.sdk.b.a.c.d) NN()).getContext(), ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime(), z, z2, i2, z3) {
            /* class com.tencent.luggage.game.d.a.a.a.AnonymousClass3 */

            @Override // com.tencent.luggage.game.a.d, com.tencent.luggage.game.a.b
            public final void a(com.tencent.magicbrush.f fVar) {
                AppMethodBeat.i(222878);
                super.a(fVar);
                fVar.b(a.b.EglSurfaceSwapLocker);
                fVar.cs(true);
                fVar.cu(true);
                AppMethodBeat.o(222878);
            }
        };
        AppMethodBeat.o(222881);
        return r0;
    }

    private void Mv() {
        boolean z = true;
        AppMethodBeat.i(130573);
        Object[] objArr = new Object[1];
        if (this.cwa == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", objArr);
        if (this.cwa != null) {
            AppMethodBeat.o(130573);
            return;
        }
        ((com.tencent.luggage.sdk.b.a.c.d) NN()).bEb();
        this.cvX = Mr();
        this.cvY = Ms();
        this.cvZ = Mt();
        this.cwa = a(this.cvX, this.cvY, this.cvZ, Mu());
        this.cwa.LQ();
        c cVar = new c(this, (byte) 0);
        this.cwa.getMagicBrush().cLy.add(cVar);
        this.cwa.getMagicBrush().cLx.add(cVar);
        this.cwa.getMagicBrush().cLz.addListener(new MBViewManager.a() {
            /* class com.tencent.luggage.game.d.a.a.a.AnonymousClass4 */

            @Override // com.tencent.magicbrush.ui.MBViewManager.a
            public final void a(MagicBrushView magicBrushView) {
            }

            @Override // com.tencent.magicbrush.ui.MBViewManager.a
            public final void b(MagicBrushView magicBrushView) {
                AppMethodBeat.i(222879);
                e eVar = new e(a.this, (byte) 0);
                p.h(eVar, "l");
                magicBrushView.cOU.add(eVar);
                magicBrushView.a(new d(a.this, (byte) 0));
                AppMethodBeat.o(222879);
            }
        });
        AppMethodBeat.o(130573);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void Mw() {
        AppMethodBeat.i(130574);
        Log.i("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
        super.Mw();
        Mq();
        if (this.cvW != null) {
            this.cvW.lix.bringToFront();
        }
        AppMethodBeat.o(130574);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void Mx() {
        AppMethodBeat.i(130575);
        super.Mx();
        try {
            i jsRuntime = ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime();
            if (jsRuntime == null) {
                AppMethodBeat.o(130575);
                return;
            }
            com.tencent.mm.plugin.appbrand.m.q qVar = (com.tencent.mm.plugin.appbrand.m.q) jsRuntime.R(com.tencent.mm.plugin.appbrand.m.q.class);
            if (qVar != null) {
                qVar.setThreadPriority(10);
            }
            AppMethodBeat.o(130575);
        } catch (Throwable th) {
            Log.printErrStackTrace("Luggage.AppBrandGameServiceLogicImp", th, "[CAPTURED CRASH]", new Object[0]);
            AppMethodBeat.o(130575);
        }
    }

    @Override // com.tencent.luggage.game.d.a.a.c
    public final com.tencent.magicbrush.e getMagicBrush() {
        AppMethodBeat.i(263557);
        com.tencent.magicbrush.e magicBrush = this.cwa.getMagicBrush();
        AppMethodBeat.o(263557);
        return magicBrush;
    }

    /* access modifiers changed from: protected */
    public String My() {
        AppMethodBeat.i(130577);
        String str = com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/lazy_load.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/NativeGlobal-WAGame.js");
        AppMethodBeat.o(130577);
        return str;
    }

    /* access modifiers changed from: protected */
    public int Mz() {
        return 0;
    }

    private void MA() {
        int length;
        AppMethodBeat.i(130578);
        if (this.cvV) {
            AppMethodBeat.o(130578);
            return;
        }
        this.cvV = true;
        Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
        s.a(((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime(), My(), new s.a() {
            /* class com.tencent.luggage.game.d.a.a.a.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(162101);
                Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script suc: %s", str);
                AppMethodBeat.o(162101);
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.s.a
            public final void du(String str) {
                AppMethodBeat.i(162102);
                Log.e("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame Library Script Failed: %s", str);
                AppMethodBeat.o(162102);
            }
        });
        String UM = ((com.tencent.luggage.sdk.b.a.c.d) NN()).bqZ().UM("WAGame.js");
        String str = "v" + ((com.tencent.luggage.sdk.b.a.c.d) NN()).bqZ().bvd();
        bc.a((com.tencent.mm.plugin.appbrand.d) NN(), ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime());
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(778, 13, 1, false);
        long currentTimeMillis = System.currentTimeMillis();
        boolean bsW = ((com.tencent.luggage.sdk.b.a.c.d) NN()).bsW();
        if (UM == null) {
            length = 0;
        } else {
            length = UM.length();
        }
        C0171a aVar = new C0171a("WAGame.js", UM, currentTimeMillis, length, bsW);
        if (((com.tencent.luggage.sdk.b.a.c.d) NN()).NP() == null || !((com.tencent.luggage.sdk.b.a.c.d) NN()).NP().OQ()) {
            com.tencent.mm.plugin.appbrand.utils.t.a((com.tencent.mm.plugin.appbrand.s) NN(), ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime(), "WAGame.js", "WAGame.js", str, Mz(), UM, t.a.LIB, aVar);
            AppMethodBeat.o(130578);
            return;
        }
        String concat = ";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);".concat(String.valueOf(UM));
        com.tencent.mm.plugin.appbrand.s sVar = (com.tencent.mm.plugin.appbrand.s) NN();
        i jsRuntime = ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime();
        t.a aVar2 = t.a.LIB;
        if (Util.isNullOrNil(concat)) {
            aVar.du("isNullOrNil script");
            AppMethodBeat.o(130578);
            return;
        }
        com.tencent.mm.plugin.appbrand.m.l lVar = (com.tencent.mm.plugin.appbrand.m.l) jsRuntime.R(com.tencent.mm.plugin.appbrand.m.l.class);
        if (lVar != null) {
            try {
                lVar.a(concat + String.format(Locale.ENGLISH, ";(function(){return %d;})();", 11111), new URL(com.tencent.mm.plugin.appbrand.utils.t.a(sVar, aVar2) + "WAGame.js").toString(), new ValueCallback<String>(aVar) {
                    /* class com.tencent.mm.plugin.appbrand.utils.t.AnonymousClass1 */
                    final /* synthetic */ s.a ogY;

                    {
                        this.ogY = r1;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(147719);
                        String str2 = str;
                        if (str2 == null || !str2.contains("11111")) {
                            if (this.ogY != null) {
                                this.ogY.du(str2);
                                AppMethodBeat.o(147719);
                                return;
                            }
                        } else if (this.ogY != null) {
                            this.ogY.onSuccess(str2);
                        }
                        AppMethodBeat.o(147719);
                    }
                });
            } catch (MalformedURLException e2) {
                AppMethodBeat.o(130578);
                return;
            }
        }
        AppMethodBeat.o(130578);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.luggage.game.d.a.a.a$a  reason: collision with other inner class name */
    public class C0171a implements s.b {
        private final String cwh;
        private final String cwi;
        private final long cwj = this.cwn;
        private boolean cwk = false;
        private m.c cwl = null;
        private final AtomicInteger cwm = new AtomicInteger(2);
        final /* synthetic */ long cwn;
        final /* synthetic */ int cwo;
        final /* synthetic */ boolean cwp;

        /* JADX WARN: Incorrect args count in method signature: (Ljava/lang/String;Ljava/lang/String;)V */
        C0171a(String str, String str2, long j2, int i2, boolean z) {
            this.cwn = j2;
            this.cwo = i2;
            this.cwp = z;
            AppMethodBeat.i(130541);
            this.cwh = str;
            this.cwi = str2;
            AppMethodBeat.o(130541);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.b
        public final void a(m.c cVar) {
            AppMethodBeat.i(130542);
            this.cwl = cVar;
            MG();
            AppMethodBeat.o(130542);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.a
        public final void onSuccess(String str) {
            AppMethodBeat.i(130543);
            Log.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", str, Integer.valueOf(this.cwo));
            a.ME();
            this.cwk = true;
            MG();
            AppMethodBeat.o(130543);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.a
        public final void du(String str) {
            AppMethodBeat.i(130544);
            Log.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", str);
            a.MF();
            this.cwk = false;
            MG();
            AppMethodBeat.o(130544);
        }

        private void MG() {
            AppMethodBeat.i(130545);
            if (this.cwm.decrementAndGet() == 0) {
                long j2 = this.cwl == null ? this.cwj : this.cwl.dqk;
                long currentTimeMillis = this.cwl == null ? System.currentTimeMillis() : this.cwl.dql;
                d.a aVar = new d.a();
                aVar.scriptName = this.cwh;
                aVar.czz = this.cwi;
                aVar.czA = Util.nullAsNil(this.cwi).length();
                ((com.tencent.luggage.sdk.b.a.c.d) a.this.NN()).a(aVar, this.cwk, j2, currentTimeMillis, this.cwl);
            }
            AppMethodBeat.o(130545);
        }
    }

    /* access modifiers changed from: protected */
    public void hH(int i2) {
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void MB() {
        AppMethodBeat.i(130579);
        super.MB();
        if (((com.tencent.luggage.sdk.b.a.c.d) NN()).NP() != null && ((com.tencent.luggage.sdk.b.a.c.d) NN()).NP().OQ()) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.luggage.game.d.a.a.a.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(162103);
                    a.this.cvW = new o();
                    a.this.cwf = new com.tencent.mm.plugin.appbrand.debugger.m();
                    a.this.cwf.a((com.tencent.luggage.sdk.b.a.c.d) a.this.NN(), ((com.tencent.luggage.sdk.b.a.c.d) a.this.NN()).NP().ON().extInfo);
                    a.this.cvW.a(a.this.cwf);
                    AppMethodBeat.o(162103);
                }
            });
            com.tencent.mm.plugin.appbrand.m.l lVar = (com.tencent.mm.plugin.appbrand.m.l) ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.l.class);
            if (lVar != null) {
                lVar.abQ("xdebug");
            }
            if (((com.tencent.luggage.sdk.b.a.c.d) NN()).bsX()) {
                try {
                    ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime().a(new URL("https://usr/" + "break.js"), "breakprogram();", null);
                } catch (MalformedURLException e2) {
                    AppMethodBeat.o(130579);
                    return;
                }
            }
        }
        AppMethodBeat.o(130579);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void MC() {
        AppMethodBeat.i(130580);
        Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
        this.cvU = true;
        Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", Boolean.valueOf(this.cvU), Boolean.valueOf(((com.tencent.luggage.sdk.b.a.c.d) NN()).isRunning()));
        if (!this.cvU || !((com.tencent.luggage.sdk.b.a.c.d) NN()).isRunning()) {
            AppMethodBeat.o(130580);
            return;
        }
        try {
            Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
            if (!this.cvV) {
                ((com.tencent.luggage.sdk.b.a.c.d) NN()).getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js"), null);
            }
            ((com.tencent.luggage.sdk.b.a.c.d) NN()).Os();
            MA();
            ((com.tencent.luggage.sdk.b.a.c.d) NN()).P(new Runnable() {
                /* class com.tencent.luggage.game.d.a.a.a.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(162100);
                    a.a(a.this);
                    AppMethodBeat.o(162100);
                }
            });
            AppMethodBeat.o(130580);
        } catch (NullPointerException e2) {
            if (((com.tencent.luggage.sdk.b.a.c.d) NN()).isRunning()) {
                AppMethodBeat.o(130580);
                throw e2;
            } else {
                AppMethodBeat.o(130580);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.p.f
    public final boolean dt(String str) {
        AppMethodBeat.i(222883);
        Log.i("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
        AppMethodBeat.o(222883);
        return false;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void MD() {
        AppMethodBeat.i(130582);
        Log.i("Luggage.AppBrandGameServiceLogicImp", "start preload");
        Mv();
        MA();
        ((com.tencent.luggage.sdk.b.a.c.d) NN()).bEc();
        Log.i("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
        AppMethodBeat.o(130582);
    }

    class e implements MagicBrushView.g {
        private e() {
        }

        /* synthetic */ e(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.g
        public final void hI(int i2) {
            AppMethodBeat.i(130557);
            if (i2 != 1 && i2 != 2 && i2 != 3) {
                IllegalStateException illegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + i2 + "]");
                AppMethodBeat.o(130557);
                throw illegalStateException;
            } else if (((com.tencent.luggage.sdk.b.a.c.d) a.this.NN()).bsW() || ((com.tencent.luggage.sdk.b.a.c.d) a.this.NN()).isRunning()) {
                a.this.hH(i2);
                AppMethodBeat.o(130557);
            } else {
                AppMethodBeat.o(130557);
            }
        }
    }

    class d implements MagicBrushView.c {
        private boolean firstTime;

        private d() {
            this.firstTime = true;
        }

        /* synthetic */ d(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void a(Object obj, int i2, int i3, boolean z) {
            AppMethodBeat.i(178032);
            if (this.firstTime) {
                this.firstTime = false;
                com.tencent.mm.plugin.appbrand.keylogger.c.b(a.this.getAppId(), KSProcessWeAppLaunch.stepSurfaceAvailable);
                AppMethodBeat.o(178032);
                return;
            }
            MH();
            AppMethodBeat.o(178032);
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void a(Object obj, boolean z) {
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void c(Object obj, int i2, int i3) {
            AppMethodBeat.i(130556);
            MH();
            AppMethodBeat.o(130556);
        }

        private void MH() {
            AppMethodBeat.i(177433);
            com.tencent.luggage.sdk.b.a.c.d dVar = (com.tencent.luggage.sdk.b.a.c.d) a.this.NN();
            if (dVar != null) {
                Log.i("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
                dVar.a(new com.tencent.mm.plugin.appbrand.page.s());
            }
            AppMethodBeat.o(177433);
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements e.b, e.d {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.magicbrush.e.d
        public final void onConsole(String str) {
            AppMethodBeat.i(130552);
            Log.i("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", str);
            com.tencent.luggage.sdk.d.d NP = ((com.tencent.luggage.sdk.b.a.c.d) a.this.NN()).NP();
            if (NP == null || NP.OM() == null || NP.OM().cyC) {
                a.a(a.this, str);
            }
            AppMethodBeat.o(130552);
        }

        @Override // com.tencent.magicbrush.e.b
        public final void onFirstFrame() {
            AppMethodBeat.i(130553);
            a.d(a.this);
            AppMethodBeat.o(130553);
        }

        @Override // com.tencent.magicbrush.e.d
        public final void onJSError(String str, String str2, int i2) {
            AppMethodBeat.i(130554);
            Log.e("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", str, str2);
            com.tencent.mm.plugin.appbrand.m.t tVar = (com.tencent.mm.plugin.appbrand.m.t) ((com.tencent.luggage.sdk.b.a.c.d) a.this.NN()).getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.t.class);
            if (i2 == tVar.bMD().bMC()) {
                cx.a(((com.tencent.luggage.sdk.b.a.c.d) a.this.NN()).getJsRuntime(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", r.afJ(str), r.afJ(str2)), 0);
                AppMethodBeat.o(130554);
                return;
            }
            g xX = tVar.xX(i2);
            if (xX == null) {
                IllegalStateException illegalStateException = new IllegalStateException("j2v8 not follow the pattern");
                AppMethodBeat.o(130554);
                throw illegalStateException;
            }
            cy.a(xX, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", r.afJ(str), r.afJ(str2)));
            AppMethodBeat.o(130554);
        }
    }

    static /* synthetic */ void ME() {
        AppMethodBeat.i(178036);
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(778, 15, 1, false);
        AppMethodBeat.o(178036);
    }

    static /* synthetic */ void MF() {
        AppMethodBeat.i(178037);
        ((com.tencent.mm.plugin.appbrand.w.a) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(778, 14, 1, false);
        AppMethodBeat.o(178037);
    }

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(178038);
        aVar.Mg().dq(str);
        AppMethodBeat.o(178038);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(178039);
        if (((com.tencent.luggage.sdk.b.a.c.d) aVar.NN()).bsW() || ((com.tencent.luggage.sdk.b.a.c.d) aVar.NN()).isRunning()) {
            com.tencent.luggage.game.e.a Nn = com.tencent.luggage.game.e.a.Nn();
            com.tencent.magicbrush.e magicBrush = aVar.cwa.getMagicBrush();
            Nn.cxv = Util.currentTicks();
            try {
                Nn.cxx = magicBrush.cxx;
            } catch (NullPointerException e2) {
                Log.printErrStackTrace("MicroMsg.MBNiReporter", e2, "inspector null pointer!", new Object[0]);
            }
            if (Nn.cxx != null) {
                com.tencent.magicbrush.d dVar = Nn.cxx;
                int QV = dVar.QV();
                dVar.cKL.put(QV, com.tencent.magicbrush.utils.h.currentTicks());
                Nn.cxy = QV;
            }
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.luggage.game.e.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(130687);
                    a.this.cxt = a.this.cxF.size();
                    Log.i("MicroMsg.MBNiReporter", "hy: onFirstFrameRendered picnum:%d", Integer.valueOf(a.this.cxt));
                    AppMethodBeat.o(130687);
                }
            });
            com.tencent.f.h.RTc.o(new Runnable() {
                /* class com.tencent.luggage.game.e.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(130688);
                    com.tencent.magicbrush.d dVar = a.this.cxx;
                    if (dVar != null) {
                        a.this.cxz = dVar.ii(a.this.cxy);
                    }
                    AppMethodBeat.o(130688);
                }
            }, 10);
        }
        AppMethodBeat.o(178039);
    }
}
