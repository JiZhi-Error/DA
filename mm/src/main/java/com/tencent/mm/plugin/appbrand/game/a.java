package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.luggage.game.d.a.a.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.game.a.h;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.appbrand.game.a.k;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.u;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.p;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.w;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.m;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.protocal.protobuf.fdh;
import com.tencent.mm.protocal.protobuf.fdi;
import com.tencent.mm.protocal.protobuf.fdj;
import com.tencent.mm.protocal.protobuf.fdm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends com.tencent.luggage.game.d.a.a.a<c> implements b {
    private com.tencent.mm.plugin.appbrand.u.a lri = null;
    private b lrj = new b();
    private boolean lrk = false;
    private long lrl = -1;

    static /* synthetic */ boolean bCW() {
        AppMethodBeat.i(180195);
        boolean bCU = bCU();
        AppMethodBeat.o(180195);
        return bCU;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.luggage.sdk.b.a.c.d, com.tencent.mm.plugin.appbrand.m.t] */
    @Override // com.tencent.luggage.game.d.a.a.a
    public final /* synthetic */ e a(c cVar, t tVar) {
        AppMethodBeat.i(45074);
        e eVar = new e(cVar, tVar);
        AppMethodBeat.o(45074);
        return eVar;
    }

    public a(c cVar) {
        super(cVar);
        AppMethodBeat.i(45054);
        AppMethodBeat.o(45054);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void d(JSONObject jSONObject) {
        AppMethodBeat.i(226609);
        super.d(jSONObject);
        try {
            jSONObject.put("clientVersion", d.KyO);
            jSONObject.put("JSEngineName", w.c(((c) NN()).getJsRuntime()));
            AppMethodBeat.o(226609);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandGameServiceLogicImpWC", e2, "attachCommonConfig error", new Object[0]);
            AppMethodBeat.o(226609);
        }
    }

    @Override // com.tencent.luggage.game.d.a.a.a, com.tencent.luggage.sdk.b.a.c.f
    public final i Mk() {
        AppMethodBeat.i(45055);
        this.lrl = System.currentTimeMillis();
        i Mk = super.Mk();
        p pVar = (p) Mk.R(p.class);
        if (pVar != null) {
            this.lrk = true;
            final boolean bsW = ((c) NN()).bsW();
            final String appId = ((c) NN()).getAppId();
            pVar.a(new p.a() {
                /* class com.tencent.mm.plugin.appbrand.game.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.m.p.a
                public final void onInitialized() {
                    AppMethodBeat.i(45048);
                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                    com.tencent.mm.plugin.appbrand.report.quality.c.a(bsW ? g.WAGAME : null, appId, a.this.lrl, com.tencent.mm.plugin.appbrand.report.e.MMV8);
                    AppMethodBeat.o(45048);
                }
            });
        }
        AppMethodBeat.o(45055);
        return Mk;
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final i d(String str, byte[] bArr) {
        i bVar;
        AppMethodBeat.i(45056);
        IJSRuntime.Config config = new IJSRuntime.Config();
        config.dpj = str;
        config.dpk = bArr;
        String str2 = (String) h.lrE.aLT();
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use native buffer type: %s", str2);
        config.dpl = str2;
        config.dpm = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_jsbridge_function_direct_evaluate, true);
        config.dpo = ((Boolean) o.lrP.aLT()).booleanValue();
        config.dpp = !((Boolean) m.lrN.aLT()).booleanValue();
        config.dps = new WeakReference<>(NN());
        boolean bCU = bCU();
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: should use node: %b, config is %s", Boolean.valueOf(bCU), config.toString());
        if (bCU) {
            bVar = new x(config);
        } else {
            bVar = new com.tencent.mm.plugin.appbrand.m.b(config);
        }
        if (bVar instanceof x) {
            this.lri = new com.tencent.mm.plugin.appbrand.u.a();
            this.lri.a((s) NN(), bVar);
        }
        q qVar = (q) bVar.R(q.class);
        if (qVar != null) {
            boolean booleanValue = ((Boolean) j.YI("tracejstask").aLT()).booleanValue();
            Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: Trace Task Name in JSThread: ".concat(String.valueOf(booleanValue)));
            qVar.cS(booleanValue);
        }
        AppMethodBeat.o(45056);
        return bVar;
    }

    private static boolean bCU() {
        AppMethodBeat.i(45057);
        boolean booleanValue = ((Boolean) r.lrS.aLT()).booleanValue();
        boolean booleanValue2 = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.s.lrT.aLT()).booleanValue();
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: isUseNodeFromConfig: %b, isUseSurfaceFromConfig: %b", Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2));
        if (!booleanValue || booleanValue2) {
            AppMethodBeat.o(45057);
            return false;
        }
        AppMethodBeat.o(45057);
        return true;
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final String My() {
        AppMethodBeat.i(45058);
        String My = super.My();
        if (this.lri != null) {
            My = My + this.lri.bPX();
        }
        AppMethodBeat.o(45058);
        return My;
    }

    @Override // com.tencent.luggage.game.d.a.a.a, com.tencent.luggage.sdk.b.a.c.f
    public final void Mn() {
        AppMethodBeat.i(45059);
        super.Mn();
        if (this.lri != null) {
            this.lri.bPW();
        }
        AppMethodBeat.o(45059);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nf() {
        AppMethodBeat.i(45060);
        Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> map = (Map) com.tencent.luggage.sdk.g.c.a("AppBrandGameServiceLogicImpWC.onCreateJsApiPool()", new kotlin.g.a.a<Map<String, com.tencent.mm.plugin.appbrand.jsapi.p>>() {
            /* class com.tencent.mm.plugin.appbrand.game.a.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> invoke() {
                AppMethodBeat.i(45049);
                Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> bDi = com.tencent.mm.plugin.appbrand.game.e.c.bDi();
                AppMethodBeat.o(45049);
                return bDi;
            }
        });
        AppMethodBeat.o(45060);
        return map;
    }

    @Override // com.tencent.luggage.game.d.a.a.a, com.tencent.luggage.sdk.b.a.c.f
    public final void Ml() {
        AppMethodBeat.i(45061);
        super.Ml();
        if (!this.lrk) {
            this.lrk = true;
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            com.tencent.mm.plugin.appbrand.report.quality.c.a(((c) NN()).bsW() ? g.WAGAME : null, ((c) NN()).getAppId(), this.lrl, com.tencent.mm.plugin.appbrand.report.e.MMV8);
        }
        AppMethodBeat.o(45061);
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final String Mo() {
        AppMethodBeat.i(45062);
        if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_j2v8_disable_codecache, false)) {
            String bDt = ad.bDt();
            AppMethodBeat.o(45062);
            return bDt;
        }
        AppMethodBeat.o(45062);
        return null;
    }

    @Override // com.tencent.luggage.game.d.a.a.a, com.tencent.luggage.sdk.b.a.c.f
    public final void c(final AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(45063);
        super.c(appBrandRuntime);
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
        com.tencent.mm.plugin.appbrand.report.b bVar = this.lrj;
        bVar.luO.post(new Runnable(appBrandRuntime, new b.a() {
            /* class com.tencent.mm.plugin.appbrand.game.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.report.b.a
            public final void dW(int i2, int i3) {
                AppMethodBeat.i(45050);
                if (appBrandRuntime == null) {
                    Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
                    AppMethodBeat.o(45050);
                } else if (appBrandRuntime.isDestroyed() || appBrandRuntime.SO) {
                    Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
                    AppMethodBeat.o(45050);
                } else if (i2 == 0 && i3 == 0) {
                    String str = appBrandRuntime.mAppId;
                    com.tencent.mm.plugin.appbrand.report.b bVar = a.this.lrj;
                    appBrandRuntime.OT();
                    com.tencent.mm.plugin.appbrand.report.quality.b.a(str, bVar);
                    ag bsz = ((c) a.this.NN()).bsz();
                    if (bsz == null) {
                        Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: no game renderer!");
                        AppMethodBeat.o(45050);
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.game.f.a aVar = (com.tencent.mm.plugin.appbrand.game.f.a) bsz.S(com.tencent.mm.plugin.appbrand.game.f.a.class);
                    if (aVar != null) {
                        aVar.a(a.this.lrj);
                    } else {
                        Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: not game renderer!");
                    }
                    fdm fdm = a.this.lrj.nGd;
                    if (fdm == null || fdm.Nza == 0 || fdm.Nzc == 0 || fdm.Nzd == 0 || fdm.Nze == 0 || fdm.Nzb == 0) {
                        if (DebuggerShell.bAx()) {
                            a.this.cwa.getMagicBrush().cxx.a(5, 10, 10.0f, 60, true);
                        }
                        AppMethodBeat.o(45050);
                        return;
                    }
                    a.this.cwa.getMagicBrush().cxx.a(fdm.Nzc, fdm.Nzd, (float) fdm.Nze, fdm.Nzb, false);
                    AppMethodBeat.o(45050);
                } else {
                    Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: get sampling failed!");
                    AppMethodBeat.o(45050);
                }
            }
        }) {
            /* class com.tencent.mm.plugin.appbrand.report.b.AnonymousClass1 */
            final /* synthetic */ AppBrandRuntime kTg;
            final /* synthetic */ a nGh;

            {
                this.kTg = r2;
                this.nGh = r3;
            }

            public final void run() {
                AppMethodBeat.i(48012);
                if (this.kTg == null || this.kTg.NY() == null) {
                    Log.w("MicroMsg.AppBrandGameExtraConfigMgr", "hy: runtime is null!");
                    if (this.nGh != null) {
                        this.nGh.dW(-1, -1);
                    }
                    AppMethodBeat.o(48012);
                    return;
                }
                Log.i("MicroMsg.AppBrandGameExtraConfigMgr", "hy: trigger wxa game config update");
                b.this.nGd = null;
                b.this.nGe = null;
                b.this.nGf = null;
                b.this.nGg = null;
                b bVar = b.this;
                AppBrandRuntime appBrandRuntime = this.kTg;
                d.a aVar = new d.a();
                aVar.iLN = new bzd();
                aVar.iLO = new bze();
                aVar.funcId = 2955;
                aVar.uri = "/cgi-bin/mmgame-bin/getwxagameconfig";
                aVar.iLP = 0;
                aVar.respCmdId = 0;
                if (!(appBrandRuntime.NY().bqZ() == null || appBrandRuntime.NY().bqZ().bve() == null)) {
                    IPkgInfo bve = appBrandRuntime.NY().bqZ().bve();
                    bVar.nGb = new fdi();
                    bVar.nGb.MqF = bve.pkgVersion();
                    bVar.nGb.NyT = bve.lastModified();
                    bVar.nGb.NyM = 0;
                }
                if (!(appBrandRuntime.OT() == null || appBrandRuntime.OT().leE == null)) {
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = appBrandRuntime.OT().leE;
                    bVar.nGc = new fdh();
                    bVar.nGc.MjZ = wxaPkgWrappingInfo.kNW;
                    bVar.nGc.KSa = wxaPkgWrappingInfo.pkgVersion;
                    AppBrandStatObject appBrandStatObject = ((com.tencent.mm.plugin.appbrand.q) appBrandRuntime).ON().cyA;
                    if (appBrandStatObject != null) {
                        bVar.nGc.Scene = appBrandStatObject.scene;
                        bVar.nGc.MqC = appBrandStatObject.ecU;
                        bVar.nGc.MqD = 0;
                    }
                }
                int streamVolume = ((AudioManager) appBrandRuntime.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                fdj fdj = new fdj();
                fdj.NyU = streamVolume == 0;
                com.tencent.mm.ak.d aXF = aVar.aXF();
                bzd bzd = (bzd) aXF.iLK.iLR;
                bzd.jfi = appBrandRuntime.mAppId;
                bzd.MeL = bVar.nGb;
                bzd.MeK = bVar.nGc;
                bzd.MeM = fdj;
                IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                    /* class com.tencent.mm.plugin.appbrand.report.b.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                    public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                        AppMethodBeat.i(48011);
                        Log.i("MicroMsg.AppBrandGameExtraConfigMgr", "hy: on get wxa game config resp: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                            bze bze = (bze) dVar.iLL.iLR;
                            b.this.nGd = bze.MeN;
                            b.this.nGe = bze.MeO;
                            b.this.nGf = bze.MeP;
                            b.this.nGg = bze.MeQ;
                        }
                        if (AnonymousClass1.this.nGh != null) {
                            AnonymousClass1.this.nGh.dW(i2, i3);
                        }
                        AppMethodBeat.o(48011);
                    }
                });
                AppMethodBeat.o(48012);
            }
        });
        AppMethodBeat.o(45063);
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final boolean Mp() {
        AppMethodBeat.i(45064);
        if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_j2v8_disable_snapshot, false)) {
            AppMethodBeat.o(45064);
            return true;
        }
        AppMethodBeat.o(45064);
        return false;
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final boolean Mr() {
        int i2;
        AppMethodBeat.i(45065);
        if (MMApplicationContext.getToolsProcesstPreference() == null || (i2 = MMApplicationContext.getToolsProcesstPreference().getInt("appbrandgame_use_commandbuffer", -1)) == -1) {
            if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_disable_commandbuffer, false)) {
                AppMethodBeat.o(45065);
                return true;
            }
            AppMethodBeat.o(45065);
            return false;
        } else if (i2 != 0) {
            AppMethodBeat.o(45065);
            return true;
        } else {
            AppMethodBeat.o(45065);
            return false;
        }
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final boolean Ms() {
        AppMethodBeat.i(45066);
        if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_disable_gfx, false)) {
            AppMethodBeat.o(45066);
            return true;
        }
        AppMethodBeat.o(45066);
        return false;
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final int Mt() {
        int i2;
        AppMethodBeat.i(45067);
        if (MMApplicationContext.getToolsProcesstPreference() != null && (i2 = MMApplicationContext.getToolsProcesstPreference().getInt("appbrandgame_cmd_pool_type", -1)) != -1) {
            AppMethodBeat.o(45067);
            return i2;
        } else if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
            AppMethodBeat.o(45067);
            return 1;
        } else {
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_cmd_pool_type, 1);
            AppMethodBeat.o(45067);
            return a2;
        }
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final boolean Mu() {
        AppMethodBeat.i(226610);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_revert_cpu_optimizer_test, false);
        AppMethodBeat.o(226610);
        return a2;
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final int Mz() {
        AppMethodBeat.i(45068);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_common_lib_code_cache_type, 0);
        AppMethodBeat.o(45068);
        return a2;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final String OB() {
        AppMethodBeat.i(226611);
        String bDt = af.bDt();
        AppMethodBeat.o(226611);
        return bDt;
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final void hH(int i2) {
        AppMethodBeat.i(45069);
        super.hH(i2);
        QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(((c) NN()).getAppId());
        if (aeU == null) {
            AppMethodBeat.o(45069);
        } else if (i2 == 1) {
            aeU.nLy.nLJ = m.a._2D;
            AppMethodBeat.o(45069);
        } else if (i2 == 2) {
            aeU.nLy.nLJ = m.a.WEBGL;
            AppMethodBeat.o(45069);
        } else if (i2 == 3) {
            aeU.nLy.nLJ = m.a.GFX;
            AppMethodBeat.o(45069);
        } else {
            RuntimeException runtimeException = new RuntimeException("MainCanvasType invalid type == ".concat(String.valueOf(i2)));
            AppMethodBeat.o(45069);
            throw runtimeException;
        }
    }

    @Override // com.tencent.luggage.game.d.a.a.a, com.tencent.luggage.sdk.b.a.c.f
    public final void Mm() {
        AppMethodBeat.i(45071);
        super.Mm();
        com.tencent.mm.plugin.appbrand.report.b bVar = this.lrj;
        bVar.luO.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.report.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(48013);
                b.this.nGd = null;
                b.this.nGe = null;
                AppMethodBeat.o(48013);
            }
        });
        AppMethodBeat.o(45071);
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final void Mi() {
        AppMethodBeat.i(45072);
        new com.tencent.mm.plugin.appbrand.game.c.c().LW();
        AppMethodBeat.o(45072);
    }

    @Override // com.tencent.luggage.game.d.a.a.a
    public final com.tencent.luggage.game.a.b a(boolean z, boolean z2, int i2, boolean z3) {
        AppMethodBeat.i(226612);
        C0583a aVar = new C0583a(((c) NN()).getContext(), ((c) NN()).getJsRuntime(), z, z2, i2, z3);
        AppMethodBeat.o(226612);
        return aVar;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.a$a  reason: collision with other inner class name */
    final class C0583a extends com.tencent.luggage.game.a.b {
        public C0583a(Context context, i iVar, boolean z, boolean z2, int i2, boolean z3) {
            super(context, iVar, z, z2, i2, z3);
        }

        @Override // com.tencent.luggage.game.a.d, com.tencent.luggage.game.a.b
        public final void a(f fVar) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(45051);
            super.a(fVar);
            fVar.cLT.a(com.tencent.magicbrush.g.cLI[6], Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_magicbrush_allow_antialias, false)));
            fVar.af(com.tencent.mm.plugin.appbrand.game.a.e.lry.dJ(((c) a.this.NN()).getContext()));
            fVar.cp(u.bDe());
            fVar.cLU.a(com.tencent.magicbrush.g.cLI[7], Boolean.valueOf(((Boolean) com.tencent.mm.plugin.appbrand.game.a.b.lrq.aLT()).booleanValue()));
            boolean booleanValue = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.s.lrT.aLT()).booleanValue();
            if (a.bCW() && ((Boolean) com.tencent.mm.plugin.appbrand.game.a.t.lrU.aLT()).booleanValue()) {
                fVar.b(a.b.NativeLocker);
            } else if (!booleanValue) {
                fVar.b(a.b.EglSurfaceSwapLocker);
            } else if (a.bCW()) {
                fVar.b(a.b.ChoreographerInMainThread);
            } else {
                fVar.b(a.b.ChoreographerInJsThread);
            }
            boolean booleanValue2 = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.f.lrC.aLT()).booleanValue();
            boolean booleanValue3 = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.p.lrQ.aLT()).booleanValue();
            boolean booleanValue4 = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.q.lrR.aLT()).booleanValue();
            Object[] objArr = new Object[3];
            objArr[0] = booleanValue2 ? "yes" : "no";
            objArr[1] = booleanValue3 ? "yes" : "no";
            objArr[2] = booleanValue4 ? "yes" : "no";
            Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", objArr);
            if (!booleanValue2 || !booleanValue3) {
                z = false;
            } else {
                z = true;
            }
            fVar.cw(z);
            if (!booleanValue2 || !booleanValue4) {
                z2 = false;
            } else {
                z2 = true;
            }
            fVar.cv(z2);
            Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use animation handler: %s", fVar.Rq().toString());
            fVar.cs(((Boolean) com.tencent.mm.plugin.appbrand.game.a.c.lrr.aLT()).booleanValue());
            fVar.ct(((Boolean) com.tencent.mm.plugin.appbrand.game.a.m.lrN.aLT()).booleanValue());
            fVar.cu(((Boolean) k.lrL.aLT()).booleanValue());
            fVar.cx(((Boolean) com.tencent.mm.plugin.appbrand.game.a.d.lrs.aLT()).booleanValue());
            AppMethodBeat.o(45051);
        }

        @Override // com.tencent.luggage.game.a.d
        public final void a(com.tencent.magicbrush.e eVar, long j2) {
            AppMethodBeat.i(45052);
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            com.tencent.mm.plugin.appbrand.report.quality.c.a(((c) a.this.NN()).bsW(), ((c) a.this.NN()).getAppId(), j2);
            AppMethodBeat.o(45052);
        }

        @Override // com.tencent.luggage.game.a.d
        public final void a(AppBrandRuntime appBrandRuntime) {
            AppMethodBeat.i(45053);
            super.a(appBrandRuntime);
            com.tencent.mm.plugin.appbrand.game.c.a.lsc.a(getMagicBrush(), appBrandRuntime);
            a.c(a.this);
            AppMethodBeat.o(45053);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.game.b
    public final com.tencent.mm.plugin.appbrand.report.b bCV() {
        return this.lrj;
    }

    @Override // com.tencent.luggage.game.d.a.a.a, com.tencent.luggage.sdk.b.a.c.f
    public final void c(JSONObject jSONObject) {
        AppMethodBeat.i(226613);
        super.c(jSONObject);
        ((c) NN()).c(jSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.game.g.a.b((com.tencent.luggage.sdk.b.a.c.d) NN())));
        HashMap hashMap = new HashMap(6);
        int[] f2 = ai.f((com.tencent.mm.plugin.appbrand.jsapi.k) NN());
        int i2 = f2[0];
        int i3 = f2[1];
        Rect safeAreaInsets = ((c) NN()).kEb.getSafeAreaInsets();
        if (safeAreaInsets != null) {
            int zB = com.tencent.mm.plugin.appbrand.ac.g.zB(safeAreaInsets.left);
            int zB2 = com.tencent.mm.plugin.appbrand.ac.g.zB(safeAreaInsets.top);
            int zB3 = com.tencent.mm.plugin.appbrand.ac.g.zB(Math.min(safeAreaInsets.right, i2));
            int zB4 = com.tencent.mm.plugin.appbrand.ac.g.zB(Math.min(safeAreaInsets.bottom, i3));
            hashMap.put("left", Integer.valueOf(zB));
            hashMap.put("top", Integer.valueOf(zB2));
            hashMap.put("right", Integer.valueOf(zB3));
            hashMap.put("bottom", Integer.valueOf(zB4));
            hashMap.put("width", Integer.valueOf(zB3 - zB));
            hashMap.put("height", Integer.valueOf(zB4 - zB2));
            ((c) NN()).c(jSONObject, "safeArea", hashMap);
        }
        AppMethodBeat.o(226613);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final String dH(String str) {
        boolean z;
        AppMethodBeat.i(45070);
        if (((c) NN()).getRuntime() == null || !((c) NN()).getRuntime().OQ()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            String a2 = v.a(str, ((c) NN()).getRuntime());
            AppMethodBeat.o(45070);
            return a2;
        }
        AppMethodBeat.o(45070);
        return "";
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(180196);
        QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(((c) aVar.NN()).getAppId());
        if (aeU != null && aeU.nLw.bVb()) {
            aVar.cwa.getMagicBrush().cxx.QU();
        }
        AppMethodBeat.o(180196);
    }
}
