package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public class av extends IListener<nr> {
    private static volatile String edo;
    private static volatile long xHQ;
    private static volatile long xHR;
    private static Set<String> xHS = new HashSet();
    private static Set<String> xHT = new HashSet();
    private long xHU;
    private b xHV;

    public av() {
        AppMethodBeat.i(161130);
        this.__eventId = nr.class.getName().hashCode();
        AppMethodBeat.o(161130);
    }

    static /* synthetic */ void a(av avVar, nr nrVar, Bundle bundle) {
        AppMethodBeat.i(41647);
        avVar.a(nrVar, bundle);
        AppMethodBeat.o(41647);
    }

    static /* synthetic */ void b(Bundle bundle, boolean z, d dVar) {
        AppMethodBeat.i(41648);
        a(bundle, z, dVar);
        AppMethodBeat.o(41648);
    }

    static /* synthetic */ void b(d dVar, Bundle bundle) {
        AppMethodBeat.i(41649);
        a(dVar, bundle);
        AppMethodBeat.o(41649);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public /* synthetic */ boolean callback(nr nrVar) {
        AppMethodBeat.i(41646);
        boolean a2 = a(nrVar);
        AppMethodBeat.o(41646);
        return a2;
    }

    static {
        AppMethodBeat.i(41650);
        AppMethodBeat.o(41650);
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private final nr xIg;

        public b(nr nrVar) {
            this.xIg = nrVar;
        }

        public final void run() {
            AppMethodBeat.i(41640);
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "time out, turn page");
            av.a(av.this, this.xIg, (Bundle) null);
            h.INSTANCE.n(939, 2, 1);
            AppMethodBeat.o(41640);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean a(final nr nrVar) {
        AppMethodBeat.i(41641);
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "callback, type = %d", Integer.valueOf(nrVar.dTO.type));
        if (nrVar.dTO.intent != null) {
            if (nrVar.dTO.type == 3) {
                Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval: %d, lastActionTime: %d", Long.valueOf(System.currentTimeMillis() - this.xHU), Long.valueOf(this.xHU));
                if (System.currentTimeMillis() - this.xHU < 500) {
                    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval smaller than 500 ms, return");
                    AppMethodBeat.o(41641);
                }
            }
            this.xHU = System.currentTimeMillis();
            switch (nrVar.dTO.type) {
                case 0:
                case 1:
                case 2:
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(nrVar.dTO.type);
                    objArr[1] = Integer.valueOf(hashCode());
                    objArr[2] = Integer.valueOf(nrVar.hashCode());
                    objArr[3] = Long.valueOf(Thread.currentThread().getId());
                    objArr[4] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s", objArr);
                    String str = "";
                    try {
                        str = nrVar.dTO.intent.getStringExtra("rawUrl");
                    } catch (Exception e2) {
                    }
                    String stringExtra = nrVar.dTO.intent.getStringExtra("game_float_layer_url");
                    synchronized (av.class) {
                        try {
                            if (!Util.nullAsNil(edo).equalsIgnoreCase(str)) {
                                edo = str;
                                xHQ = System.currentTimeMillis();
                                xHR = System.currentTimeMillis();
                                if (com.tencent.mm.plugin.wepkg.utils.d.bcR(str)) {
                                    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", com.tencent.mm.plugin.wepkg.utils.d.bcO(str));
                                    nrVar.dTO.group = g.getMessageDigest(Util.nullAsNil(str).getBytes()) + "_" + System.currentTimeMillis();
                                    this.xHV = new b(nrVar);
                                    MMHandlerThread.postToMainThreadDelayed(this.xHV, 500);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("call_raw_url", str);
                                    if (!Util.isNullOrNil(stringExtra)) {
                                        bundle.putString("float_layer_url", stringExtra);
                                    }
                                    if (nrVar.dTO.type == 2) {
                                        bundle.putBoolean("is_luggage", true);
                                    }
                                    com.tencent.mm.plugin.game.luggage.b.b(bundle, a.class, new d<Bundle>() {
                                        /* class com.tencent.mm.plugin.game.model.av.AnonymousClass1 */

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.ipcinvoker.d
                                        public final /* synthetic */ void bn(Bundle bundle) {
                                            AppMethodBeat.i(41628);
                                            Bundle bundle2 = bundle;
                                            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload complete. total time:%d", Long.valueOf(System.currentTimeMillis() - av.xHR));
                                            if (bundle2 != null) {
                                                av.a(av.this, nrVar, bundle2);
                                            }
                                            AppMethodBeat.o(41628);
                                        }
                                    });
                                } else {
                                    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page.");
                                    a(nrVar, (Bundle) null);
                                }
                                AppMethodBeat.o(41641);
                                break;
                            } else {
                                Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
                                break;
                            }
                        } finally {
                            AppMethodBeat.o(41641);
                        }
                    }
                case 3:
                    final String stringExtra2 = nrVar.dTO.intent.getStringExtra("rawUrl");
                    if (!xHT.contains(stringExtra2) && com.tencent.mm.plugin.wepkg.utils.d.bcR(stringExtra2)) {
                        xHT.add(stringExtra2);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("call_raw_url", stringExtra2);
                        bundle2.putBoolean("preload_webcore", true);
                        bundle2.putBoolean("is_luggage", true);
                        com.tencent.mm.plugin.game.luggage.b.b(bundle2, a.class, new d<Bundle>() {
                            /* class com.tencent.mm.plugin.game.model.av.AnonymousClass2 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.ipcinvoker.d
                            public final /* synthetic */ void bn(Bundle bundle) {
                                AppMethodBeat.i(41629);
                                av.xHT.remove(stringExtra2);
                                AppMethodBeat.o(41629);
                            }
                        });
                        p.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.game.model.av.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(41630);
                                if (av.xHT.contains(stringExtra2)) {
                                    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore, time out");
                                    av.xHT.remove(stringExtra2);
                                    h.INSTANCE.n(939, 3, 1);
                                }
                                AppMethodBeat.o(41630);
                            }
                        }, 10000);
                    }
                    AppMethodBeat.o(41641);
                    break;
                default:
                    AppMethodBeat.o(41641);
                    break;
            }
        } else {
            AppMethodBeat.o(41641);
        }
        return false;
    }

    private synchronized void a(final nr nrVar, Bundle bundle) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(41642);
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turnPage");
            MMHandlerThread.removeRunnable(this.xHV);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.game.model.av.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(41631);
                    Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "interval:%sms, allow enter url:%s", 1000, av.edo);
                    String unused = av.edo = "";
                    AppMethodBeat.o(41631);
                }
            }, 1000);
            if (nrVar == null) {
                AppMethodBeat.o(41642);
            } else {
                if (!Util.isNullOrNil(nrVar.dTO.group)) {
                    if (xHS.contains(nrVar.dTO.group)) {
                        xHS.remove(nrVar.dTO.group);
                        AppMethodBeat.o(41642);
                    } else {
                        xHS.add(nrVar.dTO.group);
                    }
                }
                final Context context = nrVar.dTO.context != null ? nrVar.dTO.context : MMApplicationContext.getContext();
                if (nrVar.dTO.intent == null) {
                    nrVar.dTO.intent = new Intent();
                }
                String stringExtra = nrVar.dTO.intent.getStringExtra("rawUrl");
                Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn page, start web ui, time: " + System.currentTimeMillis());
                nrVar.dTO.intent.putExtra("start_activity_time", System.currentTimeMillis());
                switch (nrVar.dTO.type) {
                    case 0:
                        c.b(context, "webview", ".ui.tools.WebViewUI", nrVar.dTO.intent);
                        break;
                    case 1:
                        c.b(context, "webview", ".ui.tools.TransparentWebViewUI", nrVar.dTO.intent);
                        break;
                    case 2:
                        if (bundle != null) {
                            z = bundle.getBoolean("has_preload_webcore", false);
                        }
                        p.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.game.model.av.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(41632);
                                c.b(context, "webview", ".ui.tools.WebViewUI", nrVar.dTO.intent);
                                AppMethodBeat.o(41632);
                            }
                        }, z ? 100 : 0);
                        break;
                }
                long currentTimeMillis = System.currentTimeMillis() - xHQ;
                Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", Long.valueOf(currentTimeMillis));
                try {
                    nrVar.dTO.context = null;
                } catch (Exception e2) {
                }
                com.tencent.mm.plugin.wepkg.utils.a.b("preloadWebTime", stringExtra, com.tencent.mm.plugin.wepkg.utils.d.bcO(stringExtra), null, -1, currentTimeMillis, null);
                AppMethodBeat.o(41642);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, final d<Bundle> dVar) {
            AppMethodBeat.i(41639);
            final Bundle bundle2 = bundle;
            if (bundle2 == null) {
                if (dVar != null) {
                    dVar.bn(bundle2);
                }
                AppMethodBeat.o(41639);
                return;
            }
            String string = bundle2.getString("call_raw_url");
            final boolean z = bundle2.getBoolean("preload_webcore", false);
            if (z) {
                Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload webcore");
            }
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload entrance url:%s, isToolsProcess:%b, isToolsMpProcess:%b", string, Boolean.valueOf(MMApplicationContext.isToolsProcess()), Boolean.valueOf(MMApplicationContext.isToolsMpProcess()));
            if (AppBrandMainProcessService.isLive()) {
                Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload wepkg");
                com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.game.model.av.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(41636);
                        av.b(bundle2, z, dVar);
                        AppMethodBeat.o(41636);
                    }
                });
                AppMethodBeat.o(41639);
                return;
            }
            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "prestart WepkgMainProcessService and preload wepkg");
            com.tencent.mm.plugin.wepkg.utils.d.b(string, new com.tencent.mm.plugin.wepkg.model.a() {
                /* class com.tencent.mm.plugin.game.model.av.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.wepkg.model.a
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    AppMethodBeat.i(41638);
                    if ((baseWepkgProcessTask instanceof WepkgCrossProcessTask) && baseWepkgProcessTask.result) {
                        com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable() {
                            /* class com.tencent.mm.plugin.game.model.av.a.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(41637);
                                av.b(bundle2, z, dVar);
                                AppMethodBeat.o(41637);
                            }
                        });
                    }
                    AppMethodBeat.o(41638);
                }
            });
            AppMethodBeat.o(41639);
        }
    }

    private static synchronized void a(final Bundle bundle, boolean z, final d dVar) {
        synchronized (av.class) {
            AppMethodBeat.i(41643);
            Log.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore, preload: %b", Boolean.valueOf(z));
            boolean z2 = bundle.getBoolean("is_luggage", false);
            final String string = bundle.getString("call_raw_url");
            String string2 = bundle.getString("float_layer_url");
            final GameWebPerformanceInfo Fd = GameWebPerformanceInfo.Fd(string);
            if (z2) {
                final com.tencent.luggage.d.p azD = com.tencent.mm.plugin.game.luggage.h.azD(string);
                if (azD != null) {
                    if (z) {
                        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "has preloaded webcore, return");
                    } else {
                        p.y(new Runnable() {
                            /* class com.tencent.mm.plugin.game.model.av.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(41633);
                                ((com.tencent.mm.plugin.game.luggage.g.h) azD.LG()).onResume();
                                ((com.tencent.mm.plugin.game.luggage.g.h) azD.LG()).setBlockNetworkImage(false);
                                AppMethodBeat.o(41633);
                            }
                        });
                        com.tencent.mm.plugin.game.luggage.g.a(azD, string);
                    }
                    bundle.putBoolean("has_preload_webcore", true);
                    a(dVar, bundle);
                    AppMethodBeat.o(41643);
                } else if (!z) {
                    aAm(string2);
                    aAm(string);
                    a(dVar, bundle);
                    AppMethodBeat.o(41643);
                } else if (Fd.hhF != 0) {
                    dVar.bn(bundle);
                    AppMethodBeat.o(41643);
                } else if (!aAm(string)) {
                    Log.d("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "wepkg is not exists, return");
                    GameWebPerformanceInfo.Ff(string);
                    a(dVar, bundle);
                    AppMethodBeat.o(41643);
                } else {
                    aAm(string2);
                    Fd.hhx = 1;
                    Fd.hhI = System.currentTimeMillis();
                    h.INSTANCE.n(939, 0, 1);
                    com.tencent.mm.plugin.game.luggage.h.a(i.class, string, new h.a() {
                        /* class com.tencent.mm.plugin.game.model.av.AnonymousClass7 */

                        @Override // com.tencent.mm.plugin.game.luggage.h.a
                        public final void callback() {
                            AppMethodBeat.i(41635);
                            Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preLoadWePkgAndWebCore end, time = %d", Long.valueOf(System.currentTimeMillis()));
                            p.y(new Runnable() {
                                /* class com.tencent.mm.plugin.game.model.av.AnonymousClass7.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(41634);
                                    com.tencent.luggage.d.p azD = com.tencent.mm.plugin.game.luggage.h.azD(string);
                                    if (azD != null) {
                                        ((com.tencent.mm.plugin.game.luggage.g.h) azD.LG()).setBlockNetworkImage(true);
                                        ((com.tencent.mm.plugin.game.luggage.g.h) azD.LG()).onPause();
                                    }
                                    Fd.hhJ = System.currentTimeMillis();
                                    av.b(dVar, bundle);
                                    AppMethodBeat.o(41634);
                                }
                            });
                            AppMethodBeat.o(41635);
                        }
                    });
                    AppMethodBeat.o(41643);
                }
            } else {
                aAm(string2);
                aAm(string);
                a(dVar, bundle);
                AppMethodBeat.o(41643);
            }
        }
    }

    private static boolean aAm(String str) {
        AppMethodBeat.i(41644);
        if (Util.isNullOrNil(str) || !com.tencent.mm.plugin.wepkg.utils.d.bcR(str)) {
            AppMethodBeat.o(41644);
            return false;
        }
        Log.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preloadWePkg, url: %s", str);
        GameWebPerformanceInfo Fd = GameWebPerformanceInfo.Fd(str);
        Fd.hhG = System.currentTimeMillis();
        com.tencent.mm.plugin.wepkg.model.h bcd = com.tencent.mm.plugin.wepkg.d.bcd(str);
        Fd.hhH = System.currentTimeMillis();
        if (bcd == null || !bcd.dTL()) {
            AppMethodBeat.o(41644);
            return false;
        }
        AppMethodBeat.o(41644);
        return true;
    }

    private static void a(d dVar, Bundle bundle) {
        AppMethodBeat.i(41645);
        if (dVar != null) {
            dVar.bn(bundle);
        }
        AppMethodBeat.o(41645);
    }
}
