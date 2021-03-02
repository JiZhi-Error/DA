package com.tencent.mm.plugin.game.luggage.g;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import android.widget.FrameLayout;
import com.facebook.device.yearclass.YearClass;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.luggage.i.d;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.ipc.ActiveMainProcessTask;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.plugin.webview.ui.tools.game.d;
import com.tencent.mm.plugin.webview.ui.tools.game.e;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.wepkg.event.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.ao;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends g implements e {
    private View xyD;
    private GameMenuImageButton xyE;
    private boolean xyF = false;
    private boolean xyG = false;
    public boolean xyH = false;
    private boolean xyI = false;
    private String xyJ;
    public c xyK = new c() {
        /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.webview.ui.tools.game.c
        public final void an(Bundle bundle) {
            AppMethodBeat.i(83172);
            h.a(MainProcessIPCService.dkO, bundle, com.tencent.mm.plugin.game.luggage.h.a.class, null);
            AppMethodBeat.o(83172);
        }
    };
    private long xyL;
    public com.tencent.mm.plugin.webview.ui.tools.game.g xyM;
    public long xyN = 0;
    private Map<String, b> xyO = new HashMap();
    private ViewGroup xyP;
    private boolean xyQ;
    boolean xyR = false;
    private boolean xyS = false;
    public f xyT;
    public boolean xyU = false;
    private boolean xyV = true;
    public boolean xyW = false;
    private long xyX = 0;
    private long xyY = 0;
    private long xyZ = 0;
    protected GameWebPerformanceInfo xyv;
    a xza;

    public interface a {
        void dTD();
    }

    static /* synthetic */ void a(i iVar, Runnable runnable) {
        AppMethodBeat.i(186983);
        iVar.aC(runnable);
        AppMethodBeat.o(186983);
    }

    static /* synthetic */ void a(i iVar, String str, Bundle bundle) {
        AppMethodBeat.i(186982);
        super.g(str, bundle);
        AppMethodBeat.o(186982);
    }

    static /* synthetic */ boolean azQ(String str) {
        AppMethodBeat.i(186985);
        boolean azP = azP(str);
        AppMethodBeat.o(186985);
        return azP;
    }

    static /* synthetic */ void e(i iVar) {
        AppMethodBeat.i(186981);
        super.LM();
        AppMethodBeat.o(186981);
    }

    public i(j jVar, p pVar, Bundle bundle) {
        super(jVar, pVar, bundle);
        AppMethodBeat.i(83183);
        Log.i("MicroMsg.GameWebPage", "initWebPageEnd, __Time__， time: %d", Long.valueOf(System.currentTimeMillis()));
        String string = bundle.getString("rawUrl");
        this.xyv = GameWebPerformanceInfo.Fd(string);
        this.xyv.hhu = dTQ();
        this.xyv.hhN = System.currentTimeMillis();
        this.xyM = azK(string);
        String string2 = this.mParams.getString("rawUrl");
        if (!Util.isNullOrNil(string2)) {
            Uri parse = Uri.parse(string2);
            String queryParameter = ao.isDarkMode() ? parse.getQueryParameter("darkmode_nav_color") : parse.getQueryParameter("nav_color");
            if (!Util.isNullOrNil(queryParameter)) {
                try {
                    this.mParams.putInt("customize_status_bar_color", Color.parseColor("#".concat(String.valueOf(queryParameter))));
                } catch (IllegalArgumentException e2) {
                }
            }
        }
        String host = Util.getHost(string);
        if (host != null && host.equals(WeChatHosts.domainString(R.string.e1h))) {
            this.ctS.ctB = com.tencent.luggage.d.a.a.ctX;
        }
        dTP().JLI = new b() {
            /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.wepkg.event.b
            public final void dTT() {
                AppMethodBeat.i(186962);
                h hVar = (h) i.this.ctS.LG();
                if (!Util.isNullOrNil(hVar.xwe)) {
                    hVar.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: INVOKE  
                          (r0v3 'hVar' com.tencent.mm.plugin.game.luggage.g.h)
                          (wrap: com.tencent.mm.plugin.game.luggage.g.h$3 : 0x001a: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.game.luggage.g.h$3) = (r0v3 'hVar' com.tencent.mm.plugin.game.luggage.g.h) call: com.tencent.mm.plugin.game.luggage.g.h.3.<init>(com.tencent.mm.plugin.game.luggage.g.h):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.mm.plugin.game.luggage.g.h.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.game.luggage.g.i.5.dTT():void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.game.luggage.g.h$3) = (r0v3 'hVar' com.tencent.mm.plugin.game.luggage.g.h) call: com.tencent.mm.plugin.game.luggage.g.h.3.<init>(com.tencent.mm.plugin.game.luggage.g.h):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.game.luggage.g.i.5.dTT():void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 19 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.game.luggage.g.h, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 25 more
                        */
                    /*
                        this = this;
                        r2 = 186962(0x2da52, float:2.6199E-40)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                        com.tencent.mm.plugin.game.luggage.g.i r0 = com.tencent.mm.plugin.game.luggage.g.i.this
                        com.tencent.luggage.d.p r0 = r0.ctS
                        java.lang.Object r0 = r0.LG()
                        com.tencent.mm.plugin.game.luggage.g.h r0 = (com.tencent.mm.plugin.game.luggage.g.h) r0
                        java.lang.String r1 = r0.xwe
                        boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r1)
                        if (r1 != 0) goto L_0x0020
                        com.tencent.mm.plugin.game.luggage.g.h$3 r1 = new com.tencent.mm.plugin.game.luggage.g.h$3
                        r1.<init>()
                        r0.post(r1)
                    L_0x0020:
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass5.dTT():void");
                }

                @Override // com.tencent.mm.plugin.wepkg.event.b
                public final void dTU() {
                    AppMethodBeat.i(186963);
                    i.this.xyQ = true;
                    i.this.mHandler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(186960);
                            i.o(i.this);
                            AppMethodBeat.o(186960);
                        }
                    }, 500);
                    AppMethodBeat.o(186963);
                }

                @Override // com.tencent.mm.plugin.wepkg.event.b
                public final void pL(boolean z) {
                    AppMethodBeat.i(186964);
                    Log.i("MicroMsg.GameWebPage", "onPkgReady");
                    i.this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass5.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(186961);
                            if (i.this.xyQ) {
                                i.this.xyQ = false;
                                if (!((Activity) i.this.mContext).isFinishing()) {
                                    i.this.xyR = true;
                                    i.this.ctg.Ly().j(i.this.coX(), i.this.mParams);
                                }
                            }
                            AppMethodBeat.o(186961);
                        }
                    });
                    AppMethodBeat.o(186964);
                }
            };
            ((h) this.ctS.LG()).setRawUrl(string);
            this.ITd.addJavascriptInterface(new d(com.tencent.mm.plugin.webview.luggage.j.d(this)), "WxGameJsCoreNative");
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_game_create_jscore_android, false)) {
                com.tencent.mm.plugin.game.luggage.i.a.create();
                aq("created", com.tencent.mm.plugin.webview.luggage.j.d(this), string);
            }
            AppMethodBeat.o(83183);
        }

        @Override // com.tencent.luggage.d.h, com.tencent.luggage.d.s, com.tencent.mm.plugin.webview.luggage.g
        public View Lf() {
            AppMethodBeat.i(83184);
            View Lf = super.Lf();
            this.xyD = LayoutInflater.from(this.mContext).inflate(R.layout.are, (ViewGroup) this.ITm, false);
            this.xyD.setVisibility(8);
            this.ITm.addView(this.xyD, new FrameLayout.LayoutParams(-2, -2, 17));
            Log.i("MicroMsg.GameWebPage", "create vie end, time: %d", Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(83184);
            return Lf;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final View dTM() {
            AppMethodBeat.i(83185);
            this.ISN = new g(this);
            m mVar = this.ISN;
            AppMethodBeat.o(83185);
            return mVar;
        }

        /* access modifiers changed from: protected */
        public com.tencent.mm.plugin.webview.ui.tools.game.g azK(String str) {
            AppMethodBeat.i(83186);
            com.tencent.mm.plugin.webview.ui.tools.game.g baK = com.tencent.mm.plugin.webview.ui.tools.game.g.baK(str);
            AppMethodBeat.o(83186);
            return baK;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public boolean azL(String str) {
            AppMethodBeat.i(83187);
            if (str.equals(coX()) && this.xyv.hhS == 0) {
                this.xyv.hhS = System.currentTimeMillis();
                Log.i("MicroMsg.GameWebPage", "startGetA8Key, url: %s, time: %d", str, Long.valueOf(this.xyv.hhS));
            }
            boolean azL = super.azL(str);
            AppMethodBeat.o(83187);
            return azL;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final void dTH() {
            AppMethodBeat.i(83188);
            this.ISN.dTH();
            AppMethodBeat.o(83188);
        }

        @Override // com.tencent.luggage.d.h, com.tencent.mm.plugin.webview.luggage.g
        public void onForeground() {
            AppMethodBeat.i(83189);
            Log.i("MicroMsg.GameWebPage", "onForeground, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            if (this.xyv.hhL == 0) {
                this.xyv.hhL = System.currentTimeMillis();
            }
            this.xyL = System.currentTimeMillis();
            this.xyK.Jqh.onResume();
            super.onForeground();
            this.xyZ = System.currentTimeMillis();
            for (b bVar : this.xyO.values()) {
                bVar.onForeground();
            }
            aq("foreground", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
            this.xyV = false;
            AppMethodBeat.o(83189);
        }

        @Override // com.tencent.luggage.d.h, com.tencent.mm.plugin.webview.luggage.g
        public void onBackground() {
            AppMethodBeat.i(83190);
            Log.i("MicroMsg.GameWebPage", "onBackground, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            at(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(186966);
                    i.c(i.this);
                    AppMethodBeat.o(186966);
                }
            });
            AppMethodBeat.o(83190);
        }

        @Override // com.tencent.luggage.d.s
        public final void LM() {
            AppMethodBeat.i(186971);
            if (this.mIsForeground) {
                this.xyY += System.currentTimeMillis() - this.xyZ;
            }
            at(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(83174);
                    i.d(i.this);
                    AppMethodBeat.o(83174);
                }
            });
            AppMethodBeat.o(186971);
        }

        public final void at(final Runnable runnable) {
            AppMethodBeat.i(186972);
            if (!this.xyW) {
                this.xyW = true;
                this.ITd.evaluateJavascript("window.performance.getEntriesByName('first-contentful-paint')[0].startTime", new ValueCallback<String>() {
                    /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass10 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(186969);
                        String str2 = str;
                        try {
                            i.this.xyX = (long) Double.parseDouble(str2);
                        } catch (NumberFormatException e2) {
                            i.this.xyX = 0;
                        }
                        Log.i("MicroMsg.GameWebPage", "FCP_Content:%s, FCP_Value:%d", str2, Long.valueOf(i.this.xyX));
                        if (runnable != null) {
                            runnable.run();
                        }
                        AppMethodBeat.o(186969);
                    }
                });
                AppMethodBeat.o(186972);
                return;
            }
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.o(186972);
        }

        @Override // com.tencent.luggage.d.h, com.tencent.mm.plugin.webview.luggage.g
        public void onDestroy() {
            AppMethodBeat.i(83191);
            Log.i("MicroMsg.GameWebPage", "onDestroy, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            super.onDestroy();
            c.a(c.this);
            this.xyv.hhU += System.currentTimeMillis() - this.xyL;
            this.xyv.hhV = System.currentTimeMillis();
            if (!this.mParams.getBoolean("from_bag", false)) {
                com.tencent.mm.game.report.api.a aVar = com.tencent.mm.game.report.api.a.hhr;
                if (aVar != null) {
                    aVar.a(this.xyv);
                }
                try {
                    if (!this.xyG) {
                        this.xyG = true;
                        JSONObject jSONObject = new JSONObject();
                        if (this.xyN == 0) {
                            jSONObject.put("render_duration", 0);
                        } else {
                            jSONObject.put("render_duration", this.xyN - this.xyM.JqU);
                        }
                        com.tencent.mm.game.report.api.a.hhr.a(9, URLEncoder.encode(coX()), URLEncoder.encode(jSONObject.toString()), System.currentTimeMillis() - this.xyM.JqU);
                    }
                } catch (Exception e2) {
                }
            }
            GameWebPerformanceInfo.Ff(coX());
            Collection<b> values = this.xyO.values();
            if (values != null && values.size() > 0) {
                for (b bVar : values) {
                    bVar.onDestroy();
                }
                if (this.ITq.eqW()) {
                    r.aYw(this.ITq.bjl());
                }
            }
            aq("destroyed", com.tencent.mm.plugin.webview.luggage.j.d(this), null);
            AppMethodBeat.o(83191);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final void reload() {
            AppMethodBeat.i(83192);
            super.reload();
            this.xyS = false;
            dTP().JLO = false;
            if (this.xyT != null) {
                f fVar = this.xyT;
                String b2 = fVar.b(fVar.xxV);
                if (!Util.isNullOrNil(b2)) {
                    fVar.xxR.remove(b2);
                    fVar.ed(b2, 1);
                }
            }
            AppMethodBeat.o(83192);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public void pJ(boolean z) {
            AppMethodBeat.i(83193);
            super.pJ(z);
            if (isFullScreen()) {
                this.xyJ = this.mParams.getString("game_hv_menu_appid");
                if (!Util.isNullOrNil(this.xyJ)) {
                    if (this.xyE == null) {
                        this.xyE = new GameMenuImageButton(this.mContext);
                        this.xyE.a(this.mRootView, new GameMenuImageButton.a() {
                            /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass11 */

                            @Override // com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a
                            public final void dlk() {
                                AppMethodBeat.i(186970);
                                i.this.dTH();
                                AppMethodBeat.o(186970);
                            }
                        });
                    }
                    this.ITl.setVisibility(8);
                    AppMethodBeat.o(83193);
                    return;
                }
                this.ITl.setVisibility(0);
            }
            AppMethodBeat.o(83193);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final void dTN() {
            dv dSU;
            boolean z = true;
            AppMethodBeat.i(83194);
            if (!this.ITA) {
                this.ITB = this.mParams.getInt("customize_status_bar_color");
                if (this.ITB == 0 && (dSU = com.tencent.mm.plugin.game.commlib.a.dSU()) != null && !Util.isNullOrNil(dSU.ixw) && !Util.isNullOrNil(dSU.xNo)) {
                    try {
                        if (ao.isDarkMode()) {
                            this.ITB = Color.parseColor(dSU.xNo);
                        } else {
                            this.ITB = Color.parseColor(dSU.ixw);
                        }
                    } catch (IllegalArgumentException e2) {
                        Log.e("MicroMsg.GameWebPage", "parse color: " + e2.getMessage());
                    }
                    if (this.ITB == 0) {
                        this.ITB = android.support.v4.content.b.n(this.mContext, R.color.bj);
                    }
                }
            }
            if (!this.xyI) {
                this.xyI = true;
                gbA();
            }
            m mVar = this.ISN;
            if (mVar.IUx != null) {
                com.tencent.mm.ui.statusbar.b bVar = mVar.IUh;
                int intValue = mVar.IUx.intValue();
                if (mVar.IUy) {
                    z = false;
                }
                com.tencent.mm.ui.statusbar.a.e(bVar, intValue, z);
            }
            AppMethodBeat.o(83194);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final boolean azJ(String str) {
            AppMethodBeat.i(83195);
            boolean azJ = ((h) this.ITd).azJ(str);
            AppMethodBeat.o(83195);
            return azJ;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public void dTA() {
            AppMethodBeat.i(83196);
            aC(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(83180);
                    i.this.xyD.setVisibility(0);
                    AppMethodBeat.o(83180);
                }
            });
            AppMethodBeat.o(83196);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final void dTO() {
            AppMethodBeat.i(83197);
            this.xyD.setVisibility(8);
            AppMethodBeat.o(83197);
        }

        @Override // com.tencent.luggage.d.h, com.tencent.luggage.d.s, com.tencent.mm.plugin.webview.luggage.g
        public void g(final String str, final Bundle bundle) {
            AppMethodBeat.i(83198);
            Log.i("MicroMsg.GameWebPage", "load url, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            if (this.xyM.JqV == 0) {
                this.xyM.JqV = System.currentTimeMillis();
            }
            final AnonymousClass13 r6 = new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(83181);
                    i.a(i.this, str, bundle);
                    AppMethodBeat.o(83181);
                }
            };
            if (AppBrandMainProcessService.isLive()) {
                Log.i("MicroMsg.GameWebPage", "activeIpcTask, service is alive");
                r6.run();
                AppMethodBeat.o(83198);
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            final PBool pBool = new PBool();
            final ActiveMainProcessTask activeMainProcessTask = new ActiveMainProcessTask();
            activeMainProcessTask.callback = new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(83182);
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    Log.i("MicroMsg.GameWebPage", "activeIpcTask, callback");
                    activeMainProcessTask.bDK();
                    synchronized (pBool) {
                        try {
                            if (!pBool.value) {
                                pBool.value = true;
                                r6.run();
                                com.tencent.mm.plugin.wepkg.utils.a.b("ipcServiceStartTime", str, com.tencent.mm.plugin.wepkg.utils.d.bcO(str), null, 0, currentTimeMillis, null);
                                AppMethodBeat.o(83182);
                            }
                        } finally {
                            AppMethodBeat.o(83182);
                        }
                    }
                }
            };
            activeMainProcessTask.bDJ();
            AppBrandMainProcessService.a(activeMainProcessTask);
            com.tencent.f.h.RTc.o(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(186957);
                    synchronized (pBool) {
                        try {
                            if (!pBool.value) {
                                Log.i("MicroMsg.GameWebPage", "activeIpcTask, time out, callback");
                                pBool.value = true;
                                i.a(i.this, new Runnable() {
                                    /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass2.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(170129);
                                        r6.run();
                                        AppMethodBeat.o(170129);
                                    }
                                });
                                AppMethodBeat.o(186957);
                            }
                        } finally {
                            AppMethodBeat.o(186957);
                        }
                    }
                }
            }, 1000);
            AppMethodBeat.o(83198);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final void azM(String str) {
            AppMethodBeat.i(83199);
            super.azM(str);
            if (this.xyv.hhP == 0) {
                this.xyv.hhP = System.currentTimeMillis();
            }
            AppMethodBeat.o(83199);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final void cV(String str) {
            AppMethodBeat.i(83200);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, __Time__, time = %d", str, Long.valueOf(currentTimeMillis));
            super.cV(str);
            if (this.xyv.hhQ == 0) {
                this.xyv.hhQ = currentTimeMillis;
            }
            if (this.xyM.JqW == 0) {
                this.xyM.JqW = currentTimeMillis;
            }
            String host = Util.getHost(str);
            if (host == null || !host.equals(WeChatHosts.domainString(R.string.e1h))) {
                this.ctS.ctB = this.ITx;
            } else {
                this.ctS.ctB = com.tencent.luggage.d.a.a.ctX;
            }
            this.xyK.Jqh.ghf();
            AppMethodBeat.o(83200);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public void cW(String str) {
            AppMethodBeat.i(83201);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, __Time__, time = %d", str, Long.valueOf(currentTimeMillis));
            super.cW(str);
            if (this.xyv.hhR == 0) {
                this.xyv.hhR = currentTimeMillis;
            }
            if (this.xyM.JqX == 0) {
                this.xyM.JqX = currentTimeMillis;
            }
            try {
                if (!this.xyF) {
                    this.xyF = true;
                    com.tencent.mm.game.report.api.a.hhr.a(7, URLEncoder.encode(coX()), "", currentTimeMillis - this.xyM.JqU);
                }
            } catch (Exception e2) {
            }
            com.tencent.mm.plugin.game.luggage.g.b(this.ctS, this.xwe);
            this.xyK.Jqh.LZ();
            AppMethodBeat.o(83201);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public void D(int i2, String str, String str2) {
            AppMethodBeat.i(180146);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.GameWebPage", "onReceivedError, errorCode: %d, description: %s, failingUrl: %s , time: %d", Integer.valueOf(i2), str, str2, Long.valueOf(currentTimeMillis));
            super.D(i2, str, str2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errcode", i2);
                jSONObject.put("errurl", str2);
                com.tencent.mm.game.report.api.a.hhr.a(8, URLEncoder.encode(coX()), URLEncoder.encode(jSONObject.toString()), currentTimeMillis - this.xyM.JqU);
                AppMethodBeat.o(180146);
            } catch (Exception e2) {
                AppMethodBeat.o(180146);
            }
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final void azO(String str) {
            AppMethodBeat.i(83202);
            super.azO(str);
            if (this.xyM.JqY == 0) {
                this.xyM.JqY = System.currentTimeMillis();
            }
            AppMethodBeat.o(83202);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public void c(String str, String str2, Map<String, String> map) {
            AppMethodBeat.i(83203);
            super.c(str, str2, map);
            h hVar = (h) this.ctS.LG();
            hVar.xwe = str2;
            hVar.xyn = map;
            if (Util.isNullOrNil(str2)) {
                Log.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, fullUrl is null");
            } else if (!Uri.parse(str2).getHost().equals(WeChatHosts.domainString(R.string.e1h))) {
                Log.i("MicroMsg.LuggageGameUinKeyHolder", "setFullUrlAndHeaders, host is not wxgame");
            } else {
                com.tencent.mm.plugin.game.luggage.e.xwe = str2;
                com.tencent.mm.plugin.game.luggage.e.mHeaders = map;
                com.tencent.mm.plugin.game.luggage.e.Nh = System.currentTimeMillis() / 1000;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (str.equals(coX())) {
                Log.i("MicroMsg.GameWebPage", "getA8Key end, __Time__, time: %d", Long.valueOf(currentTimeMillis));
                this.xyv.hhT = currentTimeMillis;
            }
            if (this.xyv.hhP == 0) {
                this.xyv.hhP = currentTimeMillis;
            }
            if (this.xyM.JqZ == 0) {
                this.xyM.JqZ = System.currentTimeMillis();
            }
            com.tencent.mm.plugin.game.luggage.g.a(this.ITd, str2, map);
            com.tencent.mm.plugin.game.luggage.g.b(this.ctS, str2);
            this.xyH = true;
            AppMethodBeat.o(83203);
        }

        public final com.tencent.mm.plugin.wepkg.e dTP() {
            AppMethodBeat.i(83205);
            com.tencent.mm.plugin.wepkg.e wePkgPlugin = ((h) this.ITd).getWePkgPlugin();
            AppMethodBeat.o(83205);
            return wePkgPlugin;
        }

        public final String dTQ() {
            AppMethodBeat.i(83206);
            String str = (hashCode() & Integer.MAX_VALUE) + "_" + (coX().hashCode() & Integer.MAX_VALUE);
            AppMethodBeat.o(83206);
            return str;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.game.e
        public final Map<Integer, Object> dTR() {
            AppMethodBeat.i(186974);
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(d.a.Jqn), dTQ());
            hashMap.put(Integer.valueOf(d.a.Jqo), NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
            hashMap.put(Integer.valueOf(d.a.Jqp), String.valueOf(YearClass.get(MMApplicationContext.getContext())));
            String coX = coX();
            try {
                hashMap.put(Integer.valueOf(d.a.Jqq), q.encode(Util.nullAsNil(coX), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e2) {
            }
            hashMap.put(Integer.valueOf(d.a.Jqr), Integer.valueOf(azJ(coX) ? 1 : 0));
            hashMap.put(Integer.valueOf(d.a.Jqs), 1);
            if (this instanceof j) {
                hashMap.put(Integer.valueOf(d.a.Jqt), 1);
            } else {
                hashMap.put(Integer.valueOf(d.a.Jqt), 0);
            }
            hashMap.put(Integer.valueOf(d.a.Jqu), dTP().gkx());
            Integer valueOf = Integer.valueOf(d.a.Jqv);
            dTP();
            hashMap.put(valueOf, com.tencent.mm.plugin.wepkg.e.gky());
            AppMethodBeat.o(186974);
            return hashMap;
        }

        @Override // com.tencent.mm.plugin.webview.ui.tools.game.e
        public final Map<Integer, Object> dTS() {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(186975);
            HashMap hashMap = new HashMap();
            com.tencent.mm.plugin.webview.ui.tools.game.g baL = com.tencent.mm.plugin.webview.ui.tools.game.g.baL(coX());
            if (baL != null) {
                hashMap.put(Integer.valueOf(d.b.Jqy), Long.valueOf(baL.JqV - baL.startTime));
                hashMap.put(Integer.valueOf(d.b.Jqz), Long.valueOf(baL.JqW - baL.startTime));
                hashMap.put(Integer.valueOf(d.b.JqA), Long.valueOf(baL.JqX - baL.JqW));
                hashMap.put(Integer.valueOf(d.b.JqB), Long.valueOf(baL.JqZ - baL.JqY));
                hashMap.put(Integer.valueOf(d.b.JqC), Long.valueOf(baL.Jrb - baL.Jra));
                hashMap.put(Integer.valueOf(d.b.JqK), Long.valueOf(baL.Jrc));
                hashMap.put(Integer.valueOf(d.b.JqM), Long.valueOf(baL.Jrd));
                hashMap.put(Integer.valueOf(d.b.JqD), Long.valueOf(baL.Jre));
                hashMap.put(Integer.valueOf(d.b.JqE), Long.valueOf(baL.Jrf));
                hashMap.put(Integer.valueOf(d.b.JqF), Long.valueOf(baL.nOC));
                hashMap.put(Integer.valueOf(d.b.JqG), Long.valueOf(baL.Jrg));
                hashMap.put(Integer.valueOf(d.b.JqH), Long.valueOf(baL.Jrh));
                hashMap.put(Integer.valueOf(d.b.JqI), Long.valueOf(baL.Jri));
                hashMap.put(Integer.valueOf(d.b.JqJ), Long.valueOf(baL.Jrj));
                hashMap.put(Integer.valueOf(d.b.JqN), Long.valueOf(System.currentTimeMillis()));
                hashMap.put(Integer.valueOf(d.b.JqO), Long.valueOf(baL.Jrk));
            }
            hashMap.put(Integer.valueOf(d.b.JqL), Integer.valueOf(Util.isNullOrNil(dTP().gkv()) ? 0 : 1));
            Integer valueOf = Integer.valueOf(d.b.JqP);
            if (this.xyV) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            hashMap.put(valueOf, Integer.valueOf(i2));
            Integer valueOf2 = Integer.valueOf(d.b.JqQ);
            if (!this.xyU) {
                i3 = 0;
            }
            hashMap.put(valueOf2, Integer.valueOf(i3));
            hashMap.put(Integer.valueOf(d.b.JqR), Long.valueOf(this.xyX));
            hashMap.put(Integer.valueOf(d.b.JqS), Long.valueOf(this.xyY));
            AppMethodBeat.o(186975);
            return hashMap;
        }

        private static void aq(String str, String str2, String str3) {
            AppMethodBeat.i(186976);
            if (com.tencent.mm.plugin.game.luggage.i.a.dTW() != null) {
                com.tencent.mm.plugin.game.luggage.i.a.dTW().ar(str, str2, str3);
            }
            AppMethodBeat.o(186976);
        }

        private static boolean azP(String str) {
            AppMethodBeat.i(186977);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(186977);
                return false;
            }
            try {
                new JSONObject(str);
                AppMethodBeat.o(186977);
                return true;
            } catch (JSONException e2) {
                AppMethodBeat.o(186977);
                return false;
            }
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final WebResourceResponse azN(String str) {
            String path;
            boolean z = false;
            AppMethodBeat.i(186973);
            if (!(str == null || str.length() == 0 || (path = Uri.parse(str).getPath()) == null || !path.trim().endsWith("html"))) {
                z = true;
            }
            if (!z && !this.xyS) {
                this.xyS = true;
                if (this.xza != null) {
                    this.xza.dTD();
                }
                this.mHandler.postUI(new Runnable() {
                    /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(186965);
                        if (i.this.gbC() != null) {
                            String format = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gameTopBarHeight__= %d; })()", Integer.valueOf(com.tencent.mm.plugin.appbrand.ac.g.zB(i.this.gbC().getTopBarHeight())));
                            Log.i("MicroMsg.GameWebPage", "gameTopHeight:%s", format);
                            i.this.cT(format);
                        }
                        String dTC = i.this.dTC();
                        if (i.azQ(dTC)) {
                            String format2 = String.format("javascript:(function(){ window.wgclient = window.wgclient || {}; window.wgclient.__gamePreInjectData__= %s; })()", dTC);
                            Log.i("MicroMsg.GameWebPage", "preInjectData, size:%d", Integer.valueOf(dTC.getBytes().length));
                            i.this.cT(format2);
                        }
                        AppMethodBeat.o(186965);
                    }
                });
            }
            WebResourceResponse azN = super.azN(str);
            AppMethodBeat.o(186973);
            return azN;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.g
        public final boolean Oc(int i2) {
            AppMethodBeat.i(83207);
            if (this.ctS.LC() == com.tencent.luggage.d.a.a.ctX) {
                AppMethodBeat.o(83207);
                return true;
            } else if (this.ctS.LC() == com.tencent.luggage.d.a.a.ctY) {
                AppMethodBeat.o(83207);
                return false;
            } else {
                boolean Oc = super.Oc(i2);
                AppMethodBeat.o(83207);
                return Oc;
            }
        }

        /* access modifiers changed from: protected */
        public String dTC() {
            AppMethodBeat.i(186978);
            String string = this.mParams.getString("game_pre_inject_data");
            AppMethodBeat.o(186978);
            return string;
        }

        static /* synthetic */ void c(i iVar) {
            AppMethodBeat.i(186979);
            Log.i("MicroMsg.GameWebPage", "continueBackground, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            iVar.xyv.hhU += System.currentTimeMillis() - iVar.xyL;
            iVar.xyL = System.currentTimeMillis();
            iVar.xyK.Jqh.onPause();
            int indexOf = iVar.ctg.Lx().indexOf(iVar);
            if (indexOf <= 1 || !(iVar.ctg.Lx().get(indexOf - 1) instanceof a)) {
                super.onBackground();
                iVar.xyY += System.currentTimeMillis() - iVar.xyZ;
                iVar.xyZ = System.currentTimeMillis();
                for (b bVar : iVar.xyO.values()) {
                    bVar.onBackground();
                }
                aq("background", com.tencent.mm.plugin.webview.luggage.j.d(iVar), null);
            }
            AppMethodBeat.o(186979);
        }

        static /* synthetic */ void d(i iVar) {
            AppMethodBeat.i(186980);
            String afA = com.tencent.mm.plugin.appbrand.ac.d.afA("game_performance.js");
            final long currentTimeMillis = System.currentTimeMillis();
            iVar.ITd.evaluateJavascript(afA, new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass9 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(186968);
                    Log.i("MicroMsg.GameWebPage", "execute game_performance.js costtime:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    i.this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(186967);
                            i.e(i.this);
                            i iVar = i.this;
                            if (!iVar.mParams.getBoolean("from_bag", false) && !iVar.xyR) {
                                com.tencent.mm.plugin.webview.ui.tools.game.d.a(iVar.dTQ(), iVar);
                            }
                            if (!iVar.xyR) {
                                com.tencent.mm.plugin.webview.ui.tools.game.g.baM(iVar.coX());
                            }
                            AppMethodBeat.o(186967);
                        }
                    });
                    AppMethodBeat.o(186968);
                }
            });
            AppMethodBeat.o(186980);
        }

        static /* synthetic */ void o(i iVar) {
            AppMethodBeat.i(186984);
            iVar.xyP = new FrameLayout(iVar.mContext);
            iVar.xyP.setBackgroundColor(0);
            iVar.xyP.setClickable(true);
            iVar.mRootView.addView(iVar.xyP, new FrameLayout.LayoutParams(-1, -1));
            iVar.xyP.addView(LayoutInflater.from(iVar.mContext).inflate(R.layout.b28, (ViewGroup) iVar.mRootView, false), new FrameLayout.LayoutParams(-2, -2, 17));
            AppMethodBeat.o(186984);
        }
    }
