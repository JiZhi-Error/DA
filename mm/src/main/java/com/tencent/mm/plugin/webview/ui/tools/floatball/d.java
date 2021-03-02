package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.content.Intent;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u0004J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010#\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010$\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"J\u0016\u0010%\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u00020\t8FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallMgr;", "", "()V", "TAG", "", "floatBallInfoEventListener", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListener;", "removedMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getRemovedMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "useNewFloatBall", "useNewFloatBall$annotations", "getUseNewFloatBall", "()Z", "useNewFloatBall$delegate", "Lkotlin/Lazy;", "webViewCtlMap", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "getWebViewCtlMap", "addFloatBallInfoEventListener", "", "doOnFloatBallInfoExposed", "ballInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallMgr$WebViewFloatBallDataObject;", "doOnFloatBallInfoRemoved", "getController", "id", "onBallRemove", "intent", "Landroid/content/Intent;", "onFloatBallInfoClick", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "setController", "controller", "WebViewFloatBallDataObject", "plugin-webview_release"})
public final class d {
    private static final kotlin.f JmN = kotlin.g.ah(g.Jna);
    private static final ConcurrentHashMap<String, i> JmO = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Boolean> JmP = new ConcurrentHashMap<>();
    public static final d JmQ = new d();
    private static final com.tencent.mm.plugin.ball.c.e lqt = new e();

    public static final boolean ggy() {
        AppMethodBeat.i(210512);
        boolean booleanValue = ((Boolean) JmN.getValue()).booleanValue();
        AppMethodBeat.o(210512);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(210521);
        AppMethodBeat.o(210521);
    }

    private d() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallMgr$WebViewFloatBallDataObject;", "", "rawUrl", "", "currentProcess", "key", "activeTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getActiveTime", "()J", "getCurrentProcess", "()Ljava/lang/String;", "getKey", "getRawUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-webview_release"})
    public static final class a {
        final String JmR;
        final String edo;
        final String key;
        final long oWp;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
            if (r5.oWp == r6.oWp) goto L_0x0034;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 210495(0x3363f, float:2.94966E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0034
                boolean r0 = r6 instanceof com.tencent.mm.plugin.webview.ui.tools.floatball.d.a
                if (r0 == 0) goto L_0x0039
                com.tencent.mm.plugin.webview.ui.tools.floatball.d$a r6 = (com.tencent.mm.plugin.webview.ui.tools.floatball.d.a) r6
                java.lang.String r0 = r5.edo
                java.lang.String r1 = r6.edo
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0039
                java.lang.String r0 = r5.JmR
                java.lang.String r1 = r6.JmR
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0039
                java.lang.String r0 = r5.key
                java.lang.String r1 = r6.key
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0039
                long r0 = r5.oWp
                long r2 = r6.oWp
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0039
            L_0x0034:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0038:
                return r0
            L_0x0039:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0038
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.floatball.d.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(210494);
            String str = this.edo;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.JmR;
            int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
            String str3 = this.key;
            if (str3 != null) {
                i2 = str3.hashCode();
            }
            long j2 = this.oWp;
            int i3 = ((hashCode2 + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)));
            AppMethodBeat.o(210494);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(210493);
            String str = "WebViewFloatBallDataObject(rawUrl=" + this.edo + ", currentProcess=" + this.JmR + ", key=" + this.key + ", activeTime=" + this.oWp + ")";
            AppMethodBeat.o(210493);
            return str;
        }

        public a(String str, String str2, String str3, long j2) {
            p.h(str, "rawUrl");
            p.h(str3, "key");
            AppMethodBeat.i(210492);
            this.edo = str;
            this.JmR = str2;
            this.key = str3;
            this.oWp = j2;
            AppMethodBeat.o(210492);
        }
    }

    public static ConcurrentHashMap<String, i> ggz() {
        return JmO;
    }

    public static ConcurrentHashMap<String, Boolean> ggA() {
        return JmP;
    }

    public static i baD(String str) {
        AppMethodBeat.i(210513);
        p.h(str, "id");
        i iVar = JmO.get(str);
        AppMethodBeat.o(210513);
        return iVar;
    }

    public static void a(String str, i iVar) {
        AppMethodBeat.i(210514);
        p.h(str, "id");
        p.h(iVar, "controller");
        JmO.put(str, iVar);
        AppMethodBeat.o(210514);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b JmS = new b();

        static {
            AppMethodBeat.i(210497);
            AppMethodBeat.o(210497);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(210496);
            com.tencent.mm.plugin.ball.c.b bVar = (com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class);
            if (bVar != null) {
                d dVar = d.JmQ;
                bVar.a(2, d.lqt);
                AppMethodBeat.o(210496);
                return;
            }
            AppMethodBeat.o(210496);
        }
    }

    public static void gcb() {
        AppMethodBeat.i(210515);
        h.RTc.n(b.JmS, 8000);
        AppMethodBeat.o(210515);
    }

    public static void q(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(210516);
        if (multiTaskInfo == null) {
            AppMethodBeat.o(210516);
            return;
        }
        fah fah = new fah();
        try {
            fah.parseFrom(multiTaskInfo.field_data);
            String str = fah.edo;
            if (str == null) {
                AppMethodBeat.o(210516);
                return;
            }
            String str2 = fah.NwB;
            String str3 = multiTaskInfo.field_id;
            if (str3 == null) {
                AppMethodBeat.o(210516);
                return;
            }
            a(new a(str, str2, str3, multiTaskInfo.field_updateTime));
            AppMethodBeat.o(210516);
        } catch (Throwable th) {
            Log.e("MicroMsg.WebViewFloatBallManager", "WebMultiTaskData parse fail", th);
            AppMethodBeat.o(210516);
        }
    }

    public static void r(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(210517);
        if (multiTaskInfo == null) {
            AppMethodBeat.o(210517);
            return;
        }
        fah fah = new fah();
        try {
            fah.parseFrom(multiTaskInfo.field_data);
            String str = fah.edo;
            if (str == null) {
                AppMethodBeat.o(210517);
                return;
            }
            String str2 = fah.NwB;
            String str3 = multiTaskInfo.field_id;
            if (str3 == null) {
                AppMethodBeat.o(210517);
                return;
            }
            b(new a(str, str2, str3, multiTaskInfo.field_updateTime));
            AppMethodBeat.o(210517);
        } catch (Throwable th) {
            Log.e("MicroMsg.WebViewFloatBallManager", "WebMultiTaskData parse fail", th);
            AppMethodBeat.o(210517);
        }
    }

    public static void s(MultiTaskInfo multiTaskInfo) {
        AppMethodBeat.i(210518);
        if (multiTaskInfo == null) {
            AppMethodBeat.o(210518);
            return;
        }
        JmP.remove(multiTaskInfo.field_id);
        AppMethodBeat.o(210518);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.floatball.d$d  reason: collision with other inner class name */
    public static final class RunnableC1986d implements Runnable {
        final /* synthetic */ a JmT;

        RunnableC1986d(a aVar) {
            this.JmT = aVar;
        }

        public final void run() {
            AppMethodBeat.i(210506);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.JmT.edo);
            if (Util.isNullOrNil(this.JmT.key)) {
                AppMethodBeat.o(210506);
                return;
            }
            intent.putExtra("float_ball_key", this.JmT.key);
            String str = this.JmT.JmR;
            if (str == null) {
                AppMethodBeat.o(210506);
            } else if (n.I("com.tencent.mm:toolsmp", str, true)) {
                String str2 = ToolsMpProcessIPCService.dkO;
                p.g(str2, "ToolsMpProcessIPCService.PROCESS_NAME");
                com.tencent.mm.ipcinvoker.a.a(str2, intent, AnonymousClass1.JmW, null);
                AppMethodBeat.o(210506);
            } else {
                String str3 = ToolsProcessIPCService.dkO;
                p.g(str3, "ToolsProcessIPCService.PROCESS_NAME");
                com.tencent.mm.ipcinvoker.a.a(str3, intent, AnonymousClass2.JmX, null);
                AppMethodBeat.o(210506);
            }
        }
    }

    public static void a(a aVar) {
        AppMethodBeat.i(210519);
        h.RTc.b(new RunnableC1986d(aVar), "WebViewFloatBallThread");
        AppMethodBeat.o(210519);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(210520);
        if (Math.abs(System.currentTimeMillis() - aVar.oWp) < 1800000) {
            AppMethodBeat.o(210520);
            return;
        }
        h.RTc.b(new c(aVar), "WebViewFloatBallThread");
        AppMethodBeat.o(210520);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ a JmT;

        c(a aVar) {
            this.JmT = aVar;
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(210501);
            String str = this.JmT.edo;
            if (str == null || n.aL(str)) {
                z = true;
            } else {
                z = false;
            }
            if (!z && !Util.isNullOrNil(this.JmT.key)) {
                d dVar = d.JmQ;
                if (!d.ggA().containsKey(this.JmT.key)) {
                    String str2 = this.JmT.edo;
                    com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
                    if (bVar != null) {
                        if (bVar.ahv(str2)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", this.JmT.edo);
                            intent.putExtra("float_ball_key", this.JmT.key);
                            String str3 = ToolsMpProcessIPCService.dkO;
                            p.g(str3, "ToolsMpProcessIPCService.PROCESS_NAME");
                            com.tencent.mm.ipcinvoker.a.a(str3, intent, AnonymousClass1.JmU, new kotlin.g.a.b<IPCVoid, x>(this) {
                                /* class com.tencent.mm.plugin.webview.ui.tools.floatball.d.c.AnonymousClass2 */
                                final /* synthetic */ c JmV;

                                {
                                    this.JmV = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // kotlin.g.a.b
                                public final /* synthetic */ x invoke(IPCVoid iPCVoid) {
                                    AppMethodBeat.i(210500);
                                    p.h(iPCVoid, LocaleUtil.ITALIAN);
                                    d dVar = d.JmQ;
                                    d.ggA().put(this.JmV.JmT.key, Boolean.TRUE);
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(210500);
                                    return xVar;
                                }
                            });
                        }
                        AppMethodBeat.o(210501);
                        return;
                    }
                    AppMethodBeat.o(210501);
                    return;
                }
            }
            AppMethodBeat.o(210501);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ String JmY;
        final /* synthetic */ i JmZ;

        f(String str, i iVar) {
            this.JmY = str;
            this.JmZ = iVar;
        }

        public final void run() {
            AppMethodBeat.i(210509);
            d dVar = d.JmQ;
            d.ggz().remove(this.JmY);
            if (this.JmZ.IJT) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1553, 11, 1, false);
                this.JmZ.fZY();
            }
            AppMethodBeat.o(210509);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallMgr$floatBallInfoEventListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallInfoEventListenerAdapter;", "onFloatBallInfoClicked", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "onFloatBallInfoExposed", "onFloatBallInfoRemoved", "plugin-webview_release"})
    public static final class e extends com.tencent.mm.plugin.ball.c.f {
        e() {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
            AppMethodBeat.i(210507);
            if (ballInfo == null) {
                AppMethodBeat.o(210507);
                return;
            }
            String string = ballInfo.jkf.getString("rawUrl");
            if (string == null) {
                AppMethodBeat.o(210507);
                return;
            }
            p.g(string, "ballInfo.extra.getString…ViewUI.KRawUrl) ?: return");
            String string2 = ballInfo.jkf.getString("webviewCurrentProcess");
            String string3 = ballInfo.jkf.getString("float_ball_key");
            if (string3 == null) {
                AppMethodBeat.o(210507);
                return;
            }
            p.g(string3, "ballInfo.extra.getString…FLOAT_BALL_KEY) ?: return");
            d dVar = d.JmQ;
            d.a(new a(string, string2, string3, ballInfo.oWp));
            AppMethodBeat.o(210507);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
            AppMethodBeat.i(210508);
            if (ballInfo == null) {
                AppMethodBeat.o(210508);
                return;
            }
            String string = ballInfo.jkf.getString("rawUrl");
            if (string == null) {
                AppMethodBeat.o(210508);
                return;
            }
            p.g(string, "ballInfo.extra.getString…ViewUI.KRawUrl) ?: return");
            String string2 = ballInfo.jkf.getString("webviewCurrentProcess");
            String string3 = ballInfo.jkf.getString("float_ball_key");
            if (string3 == null) {
                AppMethodBeat.o(210508);
                return;
            }
            p.g(string3, "ballInfo.extra.getString…FLOAT_BALL_KEY) ?: return");
            d dVar = d.JmQ;
            d.b(new a(string, string2, string3, ballInfo.oWp));
            AppMethodBeat.o(210508);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<Boolean> {
        public static final g Jna = new g();

        static {
            AppMethodBeat.i(210511);
            AppMethodBeat.o(210511);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(210510);
            com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
            if (bVar == null || bVar.a(b.a.clicfg_weview_new_float_ball, 1) != 1) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(210510);
            return valueOf;
        }
    }

    public static final /* synthetic */ void bn(Intent intent) {
        AppMethodBeat.i(210522);
        try {
            String stringExtra = intent.getStringExtra("float_ball_key");
            if (!Util.isNullOrNil(stringExtra)) {
                p.g(stringExtra, "floatBallKey");
                i baD = baD(stringExtra);
                if (baD != null) {
                    Log.i("MicroMsg.WebViewFloatBallManager", "onBallRemove ".concat(String.valueOf(intent.getStringExtra("rawUrl"))));
                    h.RTc.aV(new f(stringExtra, baD));
                    AppMethodBeat.o(210522);
                    return;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewFloatBallManager", "onRemove is null, " + e2.getMessage());
        }
        AppMethodBeat.o(210522);
    }
}
