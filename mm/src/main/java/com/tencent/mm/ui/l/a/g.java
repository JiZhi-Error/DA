package com.tencent.mm.ui.l.a;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.game.a.d;
import com.tencent.luggage.game.b.a.c;
import com.tencent.luggage.sdk.b.a.c.a;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJniParams;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.appbrand.jsapi.file.aa;
import com.tencent.mm.plugin.appbrand.jsapi.file.ab;
import com.tencent.mm.plugin.appbrand.jsapi.file.ae;
import com.tencent.mm.plugin.appbrand.jsapi.file.af;
import com.tencent.mm.plugin.appbrand.jsapi.file.ag;
import com.tencent.mm.plugin.appbrand.jsapi.file.ah;
import com.tencent.mm.plugin.appbrand.jsapi.file.ai;
import com.tencent.mm.plugin.appbrand.jsapi.file.aj;
import com.tencent.mm.plugin.appbrand.jsapi.file.ak;
import com.tencent.mm.plugin.appbrand.jsapi.file.al;
import com.tencent.mm.plugin.appbrand.jsapi.file.am;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.jsapi.file.ap;
import com.tencent.mm.plugin.appbrand.jsapi.file.aq;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.jsapi.file.as;
import com.tencent.mm.plugin.appbrand.jsapi.file.k;
import com.tencent.mm.plugin.appbrand.jsapi.file.l;
import com.tencent.mm.plugin.appbrand.jsapi.file.n;
import com.tencent.mm.plugin.appbrand.jsapi.file.o;
import com.tencent.mm.plugin.appbrand.jsapi.file.r;
import com.tencent.mm.plugin.appbrand.jsapi.file.s;
import com.tencent.mm.plugin.appbrand.jsapi.file.t;
import com.tencent.mm.plugin.appbrand.jsapi.file.u;
import com.tencent.mm.plugin.appbrand.jsapi.file.v;
import com.tencent.mm.plugin.appbrand.jsapi.file.z;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.w.e;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.w;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.m.y;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.l.a.b.a.a.b;
import com.tencent.mm.ui.l.a.b.a.c;
import com.tencent.mm.ui.l.a.b.a.f;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public final class g extends com.tencent.mm.plugin.appbrand.jsapi.g implements a {
    private static final byte[] Qme;
    final List<c> QlJ = new ArrayList(5);
    public e QlN = null;
    private boolean Qmc = false;
    d Qmf = null;
    private final a cBl;
    final String mAppId;
    private boolean mIsRunning = false;

    static /* synthetic */ j a(g gVar, Class cls) {
        AppMethodBeat.i(234426);
        j U = gVar.U(cls);
        AppMethodBeat.o(234426);
        return U;
    }

    static {
        AppMethodBeat.i(234428);
        w.bMH();
        if (!((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_j2v8_disable_snapshot, false)) {
            Qme = null;
            AppMethodBeat.o(234428);
        } else if (q.is64BitRuntime()) {
            Qme = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot64.bin");
            AppMethodBeat.o(234428);
        } else {
            Qme = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot.bin");
            AppMethodBeat.o(234428);
        }
    }

    public g(String str) {
        AppMethodBeat.i(259041);
        Log.i("MicroMsg.MagicEmojiService", "hy: establish magic emoji service %s", str);
        this.mAppId = str;
        this.cBl = new a(new a.AbstractC0181a(this) {
            /* class com.tencent.mm.ui.l.a.g.AnonymousClass1 */

            @Override // com.tencent.mm.appbrand.commonjni.a.a.b
            public final void resumeLoopTasks() {
                AppMethodBeat.i(234391);
                com.tencent.mm.plugin.appbrand.m.q b2 = g.b(g.this);
                if (b2 == null) {
                    Log.e("MicroMsg.MagicEmojiService", "hy: js thread handler not installed");
                    AppMethodBeat.o(234391);
                    return;
                }
                b2.resumeLoopTasks();
                AppMethodBeat.o(234391);
            }

            @Override // com.tencent.mm.appbrand.commonjni.a.a.b
            public final boolean doInnerLoopTask() {
                AppMethodBeat.i(234392);
                com.tencent.mm.plugin.appbrand.m.q b2 = g.b(g.this);
                if (b2 == null) {
                    Log.e("MicroMsg.MagicEmojiService", "hy: js thread handler not installed");
                    AppMethodBeat.o(234392);
                    return false;
                }
                boolean doInnerLoopTask = b2.doInnerLoopTask();
                AppMethodBeat.o(234392);
                return doInnerLoopTask;
            }

            @Override // com.tencent.mm.appbrand.commonjni.a.a.b, com.tencent.luggage.sdk.b.a.c.a.AbstractC0181a
            public final String nativeInvokeHandler(String str, String str2, int i2, boolean z) {
                AppMethodBeat.i(234393);
                String nativeInvokeHandler = super.nativeInvokeHandler(str, str2, i2, z);
                Log.v("MicroMsg.MagicEmojiService", "hy: call with jsapi: %s, %s, %d, %b, ret %s", str, str2, Integer.valueOf(i2), Boolean.valueOf(z), nativeInvokeHandler);
                AppMethodBeat.o(234393);
                return nativeInvokeHandler;
            }
        });
        AppMethodBeat.o(259041);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final boolean bsV() {
        return true;
    }

    @Override // com.tencent.mm.ui.l.a.a
    public final void CB(boolean z) {
        AppMethodBeat.i(234410);
        Log.i("MicroMsg.MagicEmojiService", "hy: change running state %b", Boolean.valueOf(z));
        if (this.mIsRunning != z) {
            this.mIsRunning = z;
            if (this.mIsRunning) {
                onResume();
                AppMethodBeat.o(234410);
                return;
            }
            onPause();
            AppMethodBeat.o(234410);
            return;
        }
        Log.i("MicroMsg.MagicEmojiService", "hy: runtime state same!");
        AppMethodBeat.o(234410);
    }

    private void onPause() {
        AppMethodBeat.i(259042);
        CD(false);
        if (this.Qmf != null) {
            this.Qmf.getMagicBrush();
            this.Qmf.getMagicBrush().Rd();
        }
        this.QlJ.clear();
        b(new Runnable() {
            /* class com.tencent.mm.ui.l.a.g.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(234402);
                synchronized (g.this) {
                    try {
                        if (g.this.getJsRuntime() != null) {
                            Log.i("MicroMsg.MagicEmojiService", "hy: service pause from js thread");
                            g.this.gWH();
                            g.this.cBl.cAE.notifyPause();
                        }
                    } finally {
                        AppMethodBeat.o(234402);
                    }
                }
            }
        }, true);
        ((x) getJsRuntime()).pause();
        ((com.tencent.mm.plugin.emoji.magicemoji.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).dij();
        AppMethodBeat.o(259042);
    }

    public final void gWH() {
        AppMethodBeat.i(234411);
        new com.tencent.mm.ui.l.a.b.a.a.b(new b.C2118b()).L(this);
        AppMethodBeat.o(234411);
    }

    private void onResume() {
        AppMethodBeat.i(259043);
        CD(true);
        ((x) getJsRuntime()).resume();
        b(new Runnable() {
            /* class com.tencent.mm.ui.l.a.g.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(234403);
                g.this.cBl.cAE.notifyResume();
                AppMethodBeat.o(234403);
            }
        }, false);
        if (this.Qmf != null) {
            this.Qmf.getMagicBrush();
            this.Qmf.getMagicBrush().Rc();
        }
        ((com.tencent.mm.plugin.emoji.magicemoji.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).dhT();
        AppMethodBeat.o(259043);
    }

    @Override // com.tencent.mm.ui.l.a.a
    public final void notifyDestroy() {
        AppMethodBeat.i(234412);
        if (!this.Qmc) {
            Log.i("MicroMsg.MagicEmojiService", "hy: service not inited");
            AppMethodBeat.o(234412);
            return;
        }
        ((com.tencent.mm.plugin.emoji.magicemoji.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFv();
        Log.i("MicroMsg.MagicEmojiService", "hy: destroy the service");
        if (this.Qmf != null) {
            this.Qmf.destroy();
        }
        m mVar = (m) U(m.class);
        if (mVar != null) {
            Log.i("MicroMsg.MagicEmojiService", "hy: has addon");
            mVar.a(new m.a() {
                /* class com.tencent.mm.ui.l.a.g.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.appbrand.m.m.a
                public final void onDestroy() {
                    AppMethodBeat.i(234404);
                    g.this.cBl.cAE.notifyDestroy();
                    AppMethodBeat.o(234404);
                }
            });
        }
        synchronized (this) {
            try {
                Log.i("MicroMsg.MagicEmojiService", "hy: cleanup");
                cleanup();
            } catch (Throwable th) {
                AppMethodBeat.o(234412);
                throw th;
            }
        }
        this.Qmc = false;
        AppMethodBeat.o(234412);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final String getAppId() {
        return this.mAppId;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Context getContext() {
        AppMethodBeat.i(234413);
        Context context = MMApplicationContext.getContext();
        AppMethodBeat.o(234413);
        return context;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final i Oo() {
        AppMethodBeat.i(234414);
        IJSRuntime.Config config = new IJSRuntime.Config();
        config.dpj = ad.bDt();
        config.dpk = Qme;
        config.dpl = "1";
        config.dpm = true;
        config.dpo = true;
        config.dpp = false;
        config.dpr = "RuntimeME";
        config.dps = new WeakReference<>(this);
        Log.d("MicroMsg.MagicEmojiService", "hy: test config instance is %d", Integer.valueOf(config.hashCode()));
        x xVar = new x(config);
        xVar.setJsExceptionHandler(new h() {
            /* class com.tencent.mm.ui.l.a.g.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.appbrand.m.h
            public final void u(String str, String str2) {
                AppMethodBeat.i(234405);
                Log.w("MicroMsg.MagicEmojiService", "hy: js exception: %s, %s", str, str2);
                com.tencent.mm.ui.l.b.a.bnK(String.format("magic emoji js exception: %s, %s", str, str2));
                AppMethodBeat.o(234405);
            }
        });
        AppMethodBeat.o(234414);
        return xVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final void init() {
        AppMethodBeat.i(234416);
        super.init();
        HashMap hashMap = new HashMap(5);
        hashMap.put(TPDownloadProxyEnum.USER_PLATFORM, "android");
        hashMap.put("isIsolateContext", Boolean.FALSE);
        hashMap.put("nativeBufferEnabled", Boolean.TRUE);
        hashMap.put("JSEngineName", "NodeJS");
        hashMap.put("clientVersion", Integer.valueOf(BuildInfo.CLIENT_VERSION_INT));
        hashMap.put("isDarkMode", Boolean.valueOf(ao.isDarkMode()));
        String format = String.format("var __wxConfig = %s;", new JSONObject(hashMap).toString());
        Log.d("MicroMsg.MagicEmojiService", "hy: injected wxconfig is %s", format);
        getJsRuntime().evaluateJavascript(format, null);
        getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/shared_buffer.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/lazy_load.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/node_jsapi.js") + com.tencent.mm.plugin.appbrand.ac.d.afA("magic_emoji/basic_common_lib.js"), new ValueCallback<String>() {
            /* class com.tencent.mm.ui.l.a.g.AnonymousClass11 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(234406);
                Log.i("MicroMsg.MagicEmojiService", "hy: eval basic libs done: %s", str);
                AppMethodBeat.o(234406);
            }
        });
        getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.afA("magic_emoji/magic_emoji_common_lib.js"), new ValueCallback<String>() {
            /* class com.tencent.mm.ui.l.a.g.AnonymousClass12 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
            }
        });
        ((com.tencent.mm.plugin.emoji.magicemoji.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).dRk();
        this.Qmc = true;
        AppMethodBeat.o(234416);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final com.tencent.mm.plugin.appbrand.a.b getAppState() {
        return this.mIsRunning ? com.tencent.mm.plugin.appbrand.a.b.kQH : com.tencent.mm.plugin.appbrand.a.b.BACKGROUND;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f
    public final Map<String, p> Op() {
        AppMethodBeat.i(234417);
        com.tencent.mm.ui.l.a.b.d dVar = com.tencent.mm.ui.l.a.b.d.INSTANCE;
        HashMap hashMap = new HashMap(10);
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new am());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new an());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new r());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new s());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new t());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new ah());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new ag());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new as());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new aa());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new ae());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new al());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new k());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new ap());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new v());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.plugin.appbrand.jsapi.file.q());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new ab());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new af());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new ar());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new z());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.plugin.appbrand.jsapi.file.ad());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new ak());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.plugin.appbrand.jsapi.file.j());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.plugin.appbrand.jsapi.file.ao());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new u());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.plugin.appbrand.jsapi.file.p());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new aq());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new n());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new o());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new ai());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new aj());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new l());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.plugin.appbrand.jsapi.file.m());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.ui.l.a.b.a());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.ui.l.a.b.b());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new JsApiGetABTestConfig());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.plugin.appbrand.jsapi.finder.d());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new e());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.ui.l.a.b.a.d());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.ui.l.a.b.a.a());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.ui.l.a.b.a.b());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new c());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new f());
        com.tencent.mm.ui.l.a.b.d.a(hashMap, new com.tencent.mm.ui.l.a.b.c());
        AppMethodBeat.o(234417);
        return hashMap;
    }

    private <T extends j> T U(Class<T> cls) {
        AppMethodBeat.i(234418);
        if (getJsRuntime() == null) {
            Log.w("MicroMsg.MagicEmojiService", "hy: js runtime not ready");
            com.tencent.mm.ui.l.b.a.bnK("magic emoji js engine not ready");
            AppMethodBeat.o(234418);
            return null;
        }
        T t = (T) ((j) Objects.requireNonNull(getJsRuntime().R(cls)));
        AppMethodBeat.o(234418);
        return t;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(234419);
        Log.i("MicroMsg.MagicEmojiService", "hy: msg come %d, at time %d", Long.valueOf(cVar.msgId), Long.valueOf(cVar.QlM));
        if (this.QlN == null || this.QlN.QlV == null || !this.QlN.QlV.QlR) {
            Log.i("MicroMsg.MagicEmojiService", "hy: surface not ready. put to pending list");
            this.QlJ.add(cVar);
            AppMethodBeat.o(234419);
            return;
        }
        b(cVar);
        AppMethodBeat.o(234419);
    }

    /* access modifiers changed from: package-private */
    public final void b(c cVar) {
        AppMethodBeat.i(234420);
        Log.i("MicroMsg.MagicEmojiService", "hy: send msg come event: %d", Long.valueOf(cVar.msgId));
        if (this.QlN == null) {
            Log.e("MicroMsg.MagicEmojiService", "hy: runtime released!");
            AppMethodBeat.o(234420);
            return;
        }
        com.tencent.mm.ui.chatting.e.a gWI = gWI();
        if (gWI == null) {
            Log.e("MicroMsg.MagicEmojiService", "hy: publish message with no chatting context");
            com.tencent.mm.ui.l.b.a.bnK("publish message with no chatting context");
            AppMethodBeat.o(234420);
        } else if (cVar.QlK.get() != gWI) {
            Log.e("MicroMsg.MagicEmojiService", "hy: current msg does not belong to current context!");
            AppMethodBeat.o(234420);
        } else {
            ((com.tencent.mm.plugin.emoji.magicemoji.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFw();
            new com.tencent.mm.ui.l.a.b.a.a.a().a(cVar.msgId, cVar.QlM, gWI.bul(), this);
            AppMethodBeat.o(234420);
        }
    }

    private void CD(boolean z) {
        AppMethodBeat.i(234422);
        Log.i("MicroMsg.MagicEmojiService", "hy: set thread priority to %b", Boolean.valueOf(z));
        com.tencent.mm.plugin.appbrand.m.q qVar = (com.tencent.mm.plugin.appbrand.m.q) getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.q.class);
        if (qVar != null) {
            Log.i("MicroMsg.MagicEmojiService", "hy: set Priority succ");
            if (z) {
                qVar.setThreadPriority(-4);
                AppMethodBeat.o(234422);
                return;
            }
            qVar.setThreadPriority(10);
        }
        AppMethodBeat.o(234422);
    }

    public final void b(Runnable runnable, boolean z) {
        AppMethodBeat.i(234423);
        com.tencent.mm.plugin.appbrand.m.q qVar = (com.tencent.mm.plugin.appbrand.m.q) U(com.tencent.mm.plugin.appbrand.m.q.class);
        if (qVar == null) {
            Log.w("MicroMsg.MagicEmojiService", "hy: no js thread addon. may be remote debug env");
            AppMethodBeat.o(234423);
            return;
        }
        qVar.a(runnable, z);
        AppMethodBeat.o(234423);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final void On() {
        AppMethodBeat.i(234424);
        super.On();
        b(new Runnable() {
            /* class com.tencent.mm.ui.l.a.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(234395);
                Log.i("MicroMsg.MagicEmojiService", "hy: base service js runtime post created run");
                com.tencent.mm.plugin.appbrand.m.v vVar = (com.tencent.mm.plugin.appbrand.m.v) g.a(g.this, com.tencent.mm.plugin.appbrand.m.v.class);
                if (vVar == null) {
                    Log.e("MicroMsg.MagicEmojiService", "hy: v8 not ready or released!");
                    AppMethodBeat.o(234395);
                    return;
                }
                g.this.cBl.cAE.notifyCreate(g.f(g.this));
                g.this.cBl.cAF.bindTo(vVar.getIsolatePtr(), vVar.XK());
                com.tencent.mm.plugin.appbrand.m.k kVar = (com.tencent.mm.plugin.appbrand.m.k) g.a(g.this, com.tencent.mm.plugin.appbrand.m.k.class);
                if (kVar != null) {
                    kVar.a(new y() {
                        /* class com.tencent.mm.ui.l.a.g.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.m.y
                        public final ByteBuffer dI(String str) {
                            AppMethodBeat.i(234394);
                            ByteBuffer dI = g.this.cBl.cAF.dI(str);
                            AppMethodBeat.o(234394);
                            return dI;
                        }
                    });
                    AppMethodBeat.o(234395);
                    return;
                }
                Log.w("MicroMsg.MagicEmojiService", "hy: buffer url addon not exist!");
                AppMethodBeat.o(234395);
            }
        }, false);
        if (this.Qmf == null) {
            Log.i("MicroMsg.MagicEmojiService", "hy: prepare me magic brush");
            com.tencent.magicbrush.a.b.a(new b.a() {
                /* class com.tencent.mm.ui.l.a.g.AnonymousClass3 */

                @Override // com.tencent.magicbrush.a.b.a
                public final void loadLibrary(String str) {
                    AppMethodBeat.i(234396);
                    com.tencent.mm.compatible.util.j.load(str);
                    AppMethodBeat.o(234396);
                }

                @Override // com.tencent.magicbrush.a.b.a
                public final String dZ(String str) {
                    AppMethodBeat.i(234397);
                    String dZ = com.tencent.mm.compatible.util.j.dZ(str);
                    AppMethodBeat.o(234397);
                    return dZ;
                }
            });
            com.tencent.magicbrush.a.b.loadLibraries();
            new com.tencent.luggage.game.b.d() {
                /* class com.tencent.mm.ui.l.a.g.AnonymousClass4 */

                @Override // com.tencent.luggage.game.b.d
                public final void LX() {
                    AppMethodBeat.i(234398);
                    super.LX();
                    com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
                    AppMethodBeat.o(234398);
                }
            }.LW();
            this.Qmf = new com.tencent.luggage.game.a.b(MMApplicationContext.getContext(), getJsRuntime()) {
                /* class com.tencent.mm.ui.l.a.g.AnonymousClass5 */

                @Override // com.tencent.luggage.game.a.d, com.tencent.luggage.game.a.b
                public final void a(com.tencent.magicbrush.f fVar) {
                    AppMethodBeat.i(234399);
                    super.a(fVar);
                    fVar.cq(true);
                    kotlin.g.b.p.h("ME.GLThread", "<set-?>");
                    fVar.cMq.a(com.tencent.magicbrush.g.cLI[27], "ME.GLThread");
                    fVar.b(a.b.NativeLocker);
                    fVar.ct(false);
                    AppMethodBeat.o(234399);
                }
            };
            this.Qmf.LQ().Rg().addImageStreamFetcher(new com.tencent.luggage.game.b.a.a(new c.b() {
                /* class com.tencent.mm.ui.l.a.g.AnonymousClass6 */

                @Override // com.tencent.luggage.game.b.a.c.b
                public final com.tencent.mm.plugin.appbrand.appstorage.q getFileSystem() {
                    AppMethodBeat.i(234400);
                    com.tencent.mm.plugin.appbrand.appstorage.q fileSystem = g.this.getFileSystem();
                    AppMethodBeat.o(234400);
                    return fileSystem;
                }

                @Override // com.tencent.luggage.game.b.a.c.a
                public final String LR() {
                    AppMethodBeat.i(234401);
                    String str = g.this.mAppId;
                    AppMethodBeat.o(234401);
                    return str;
                }
            }), true);
            AppMethodBeat.o(234424);
            return;
        }
        Log.i("MicroMsg.MagicEmojiService", "hy: already has magicbrush");
        AppMethodBeat.o(234424);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final com.tencent.mm.plugin.appbrand.appstorage.q getFileSystem() {
        AppMethodBeat.i(234415);
        if (this.QlN == null) {
            Log.e("MicroMsg.MagicEmojiService", "hy: file system lost! use default");
            com.tencent.mm.plugin.appbrand.appstorage.q fileSystem = super.getFileSystem();
            AppMethodBeat.o(234415);
            return fileSystem;
        }
        com.tencent.mm.plugin.appbrand.appstorage.q fileSystem2 = this.QlN.getFileSystem();
        AppMethodBeat.o(234415);
        return fileSystem2;
    }

    private com.tencent.mm.ui.chatting.e.a gWI() {
        AppMethodBeat.i(234421);
        if (this.QlN == null) {
            AppMethodBeat.o(234421);
            return null;
        } else if (this.QlN.gWG() == null) {
            AppMethodBeat.o(234421);
            return null;
        } else {
            com.tencent.mm.ui.chatting.e.a gWG = this.QlN.gWG();
            AppMethodBeat.o(234421);
            return gWG;
        }
    }

    static /* synthetic */ com.tencent.mm.plugin.appbrand.m.q b(g gVar) {
        AppMethodBeat.i(234425);
        i jsRuntime = gVar.getJsRuntime();
        if (jsRuntime == null) {
            Log.e("MicroMsg.MagicEmojiService", "hy: js runtime not installed");
            com.tencent.mm.ui.l.b.a.bnK("js runtime not installed");
            AppMethodBeat.o(234425);
            return null;
        }
        com.tencent.mm.plugin.appbrand.m.q qVar = (com.tencent.mm.plugin.appbrand.m.q) jsRuntime.R(com.tencent.mm.plugin.appbrand.m.q.class);
        AppMethodBeat.o(234425);
        return qVar;
    }

    static /* synthetic */ AppBrandCommonBindingJniParams f(g gVar) {
        AppMethodBeat.i(234427);
        com.tencent.mm.plugin.appbrand.m.v vVar = (com.tencent.mm.plugin.appbrand.m.v) gVar.U(com.tencent.mm.plugin.appbrand.m.v.class);
        if (vVar == null) {
            RuntimeException runtimeException = new RuntimeException("add on v8 not ready!");
            AppMethodBeat.o(234427);
            throw runtimeException;
        }
        AppBrandCommonBindingJniParams appBrandCommonBindingJniParams = new AppBrandCommonBindingJniParams();
        appBrandCommonBindingJniParams.jsContext = vVar.XK();
        appBrandCommonBindingJniParams.jsEngine = vVar.getIsolatePtr();
        appBrandCommonBindingJniParams.uvLoop = vVar.getUVLoopPtr();
        appBrandCommonBindingJniParams.wasmCachePath = com.tencent.mm.plugin.appbrand.m.af.bDt();
        AppMethodBeat.o(234427);
        return appBrandCommonBindingJniParams;
    }
}
