package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.widget.FrameLayout;
import com.facebook.device.yearclass.YearClass;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.q;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.game.d;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c;
import com.tencent.mm.plugin.wepkg.e;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameWebViewUI extends GameBaseWebViewUI implements e {
    private static String Jrn = "wx_fullscreen";
    private e JpX;
    private boolean JrA = false;
    private boolean JrB = false;
    private boolean Jrm = false;
    private HashMap<String, String> Jro = new HashMap<>();
    private Drawable Jrp;
    private Drawable Jrq;
    private String Jrr = null;
    private Map<Integer, coq> Jrs = new HashMap();
    private String Jrt;
    private GameMenuImageButton Jru;
    private boolean Jrv;
    private boolean Jrw = false;
    private boolean Jrx;
    private ViewGroup Jry;
    private c Jrz = new c(this, (byte) 0);
    private boolean xvW = false;
    private long xyL;
    private g xyM;
    private GameWebPerformanceInfo xyv;
    private boolean xyw = false;
    private Object xyx = new Object();

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameWebViewUI() {
        AppMethodBeat.i(80915);
        AppMethodBeat.o(80915);
    }

    static /* synthetic */ void a(GameWebViewUI gameWebViewUI, String str) {
        AppMethodBeat.i(211332);
        gameWebViewUI.loadUrl(str);
        AppMethodBeat.o(211332);
    }

    static /* synthetic */ boolean m(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(211333);
        boolean gbB = gameWebViewUI.gbB();
        AppMethodBeat.o(211333);
        return gbB;
    }

    static /* synthetic */ void n(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(211334);
        gameWebViewUI.agO(0);
        AppMethodBeat.o(211334);
    }

    static /* synthetic */ void o(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(211335);
        gameWebViewUI.geP();
        AppMethodBeat.o(211335);
    }

    static /* synthetic */ void r(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(211336);
        gameWebViewUI.cjP();
        AppMethodBeat.o(211336);
    }

    static /* synthetic */ void s(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(211337);
        gameWebViewUI.ban(null);
        AppMethodBeat.o(211337);
    }

    static /* synthetic */ m t(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(211338);
        m ghh = gameWebViewUI.ghh();
        AppMethodBeat.o(211338);
        return ghh;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        final String str;
        AppMethodBeat.i(80916);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        if (((q) g.af(q.class)).Vt()) {
            str = "http://mp.weixin.qq.com/mp/readtemplate?t=appmsg/childmode";
            getIntent().putExtra("rawUrl", str);
        } else {
            str = stringExtra;
        }
        if (!Util.isNullOrNil(str)) {
            String queryParameter = Uri.parse(str).getQueryParameter("nav_color");
            if (!Util.isNullOrNil(queryParameter)) {
                try {
                    getIntent().putExtra("customize_status_bar_color", Color.parseColor("#".concat(String.valueOf(queryParameter))));
                } catch (IllegalArgumentException e2) {
                }
            }
        }
        Log.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", d.bcQ(str), d.bcO(str));
        if (getIntent().getLongExtra("gamecenterui_createtime", 0) > 0) {
            this.xyv = GameWebPerformanceInfo.Fd(str);
        } else {
            this.xyv = GameWebPerformanceInfo.Fe(str);
        }
        this.xyv.url = str;
        this.xyv.hhu = ghj();
        this.xyv.hhE = getIntent().getLongExtra("gamecenterui_createtime", 0);
        this.xyv.hhF = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        this.xyv.startTime = getIntent().getLongExtra("start_time", this.xyv.hhF);
        this.xyv.hhK = System.currentTimeMillis();
        this.xyv.hhy = 1;
        Log.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", Long.valueOf(this.xyv.startTime), Long.valueOf(this.xyv.hhE), Long.valueOf(this.xyv.hhF), Long.valueOf(this.xyv.hhK));
        this.xyM = g.baJ(str);
        this.xyM.startTime = System.currentTimeMillis();
        this.JpX = new e();
        super.onCreate(bundle);
        if (this.pGj != null) {
            this.pGj.getSettings().setForceDarkBehavior(1);
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("disable_progress_bar", false)) {
            this.JhV.olx = false;
            ghi();
        }
        if (this.pGj.getIsX5Kernel()) {
            this.pGj.setWebViewClientExtension(new a(this));
        }
        this.JpX.JLI = new com.tencent.mm.plugin.wepkg.event.b() {
            /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wepkg.event.b
            public final void dTT() {
                AppMethodBeat.i(80897);
                Log.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
                GameWebViewUI.this.JrB = true;
                if (GameWebViewUI.this.JrA) {
                    GameWebViewUI.c(GameWebViewUI.this);
                }
                AppMethodBeat.o(80897);
            }

            @Override // com.tencent.mm.plugin.wepkg.event.b
            public final void dTU() {
                AppMethodBeat.i(80898);
                if (!GameWebViewUI.this.xyw) {
                    GameWebViewUI.this.xyw = true;
                    GameWebViewUI.this.handler.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(80895);
                            if (GameWebViewUI.this.xyw) {
                                GameWebViewUI.e(GameWebViewUI.this);
                            }
                            AppMethodBeat.o(80895);
                        }
                    }, 1000);
                }
                AppMethodBeat.o(80898);
            }

            @Override // com.tencent.mm.plugin.wepkg.event.b
            public final void pL(final boolean z) {
                AppMethodBeat.i(80899);
                GameWebViewUI.this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        boolean z;
                        AppMethodBeat.i(80896);
                        if (GameWebViewUI.this.xyw) {
                            GameWebViewUI.this.xyw = false;
                            GameWebViewUI.g(GameWebViewUI.this);
                            if (z) {
                                GameWebViewUI.this.pGj.stopLoading();
                                e eVar = GameWebViewUI.this.JpX;
                                String str = str;
                                if (!GameWebViewUI.this.Jrx) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                eVar.m(str, z, false);
                                GameWebViewUI.a(GameWebViewUI.this, str);
                            }
                        }
                        AppMethodBeat.o(80896);
                    }
                });
                AppMethodBeat.o(80899);
            }
        };
        this.Jrx = getIntent().getBooleanExtra("open_game_float", false);
        if (this.JpX.m(str, !this.Jrx, false)) {
            Log.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.Jrw = true;
            ghi();
        }
        this.Jru = new GameMenuImageButton(getContext());
        AppMethodBeat.o(80916);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final i cpO() {
        AppMethodBeat.i(211324);
        i cpO = super.cpO();
        if (cpO != null) {
            cpO.a(this.Jrz);
        }
        AppMethodBeat.o(211324);
        return cpO;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final synchronized x gfC() {
        x xVar;
        AppMethodBeat.i(80917);
        if (this.JiG == null) {
            this.JiG = new b();
        }
        xVar = this.JiG;
        AppMethodBeat.o(80917);
        return xVar;
    }

    private m ghh() {
        AppMethodBeat.i(80918);
        try {
            List<coq> list = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.JrL;
            new Bundle().putString("game_hv_menu_appid", this.Jrt);
            this.Jrs.clear();
            for (coq coq : list) {
                this.Jrs.put(Integer.valueOf(coq.MuO), coq);
            }
            m c2 = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, list);
            AppMethodBeat.o(80918);
            return c2;
        } catch (Exception e2) {
            Log.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", e2.getMessage());
            AppMethodBeat.o(80918);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void cpD() {
        AppMethodBeat.i(80919);
        if (this.Jjm.Jgr) {
            this.Jjm.geN();
        }
        if (this.Jru == null || !this.Jru.pKn) {
            super.cpD();
            AppMethodBeat.o(80919);
            return;
        }
        final com.tencent.mm.plugin.webview.ui.tools.game.menu.d dVar = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(getContext());
        dVar.a(new b.c() {
            /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c
            public final void c(MenuItem menuItem) {
                AppMethodBeat.i(80900);
                coq coq = (coq) GameWebViewUI.this.Jrs.get(Integer.valueOf(menuItem.getItemId()));
                if (coq == null) {
                    AppMethodBeat.o(80900);
                    return;
                }
                switch (AnonymousClass8.JrF[c.a.agZ(coq.KWb).ordinal()]) {
                    case 1:
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", coq.LPS);
                        com.tencent.mm.br.c.b(GameWebViewUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(80900);
                        return;
                    case 2:
                        GameWebViewUI.this.IMs.gdh().C(GameWebViewUI.this.coX(), 32, 1).report();
                        if (!GameWebViewUI.m(GameWebViewUI.this)) {
                            GameWebViewUI.this.finish();
                            AppMethodBeat.o(80900);
                            return;
                        }
                        break;
                    case 3:
                        String stringExtra = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
                        String stringExtra2 = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
                        String stringExtra3 = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
                        GameWebViewUI.this.IMs.gdh().C(GameWebViewUI.this.coX(), 1, 1, stringExtra, stringExtra2, stringExtra3).report();
                        GameWebViewUI.n(GameWebViewUI.this);
                        AppMethodBeat.o(80900);
                        return;
                    case 4:
                        GameWebViewUI.this.IMs.gdh().C(GameWebViewUI.this.coX(), 3, 1).report();
                        h.INSTANCE.idkeyStat(157, 6, 1, false);
                        GameWebViewUI.o(GameWebViewUI.this);
                        AppMethodBeat.o(80900);
                        return;
                    case 5:
                        GameWebViewUI.this.IMs.gdh().C(GameWebViewUI.this.coX(), 10, 1).report();
                        if (GameWebViewUI.this.pGj != null) {
                            GameWebViewUI.this.pGj.reload();
                            AppMethodBeat.o(80900);
                            return;
                        }
                        break;
                    case 6:
                        GameWebViewUI.this.IMs.gdh().C(GameWebViewUI.this.coX(), 31, 1).report();
                        GameWebViewUI.r(GameWebViewUI.this);
                        AppMethodBeat.o(80900);
                        return;
                    case 7:
                        GameWebViewUI.this.IMs.gdh().C(GameWebViewUI.this.coX(), 11, 1).report();
                        GameWebViewUI.s(GameWebViewUI.this);
                        AppMethodBeat.o(80900);
                        return;
                    case 8:
                        if (GameWebViewUI.this.IBw != null) {
                            com.tencent.mm.plugin.webview.d.h hVar = GameWebViewUI.this.IBw;
                            int i2 = coq.MuO;
                            if (hVar.GBl) {
                                Log.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                                HashMap hashMap = new HashMap();
                                hashMap.put("itemId", Integer.valueOf(i2));
                                MMHandlerThread.postToMainThread(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x020f: INVOKE  
                                      (wrap: com.tencent.mm.plugin.webview.d.h$79 : 0x020c: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.webview.d.h$79) = 
                                      (r1v7 'hVar' com.tencent.mm.plugin.webview.d.h)
                                      (wrap: java.lang.String : 0x0206: INVOKE  (r0v7 java.lang.String) = 
                                      ("onCustomGameMenuClicked")
                                      (r2v5 'hashMap' java.util.HashMap)
                                      (wrap: boolean : 0x0202: IGET  (r3v2 boolean) = (r1v7 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                      (wrap: java.lang.String : 0x0204: IGET  (r4v0 java.lang.String) = (r1v7 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                     call: com.tencent.mm.plugin.webview.d.h.79.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.2.c(android.view.MenuItem):void, file: classes.dex
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
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x020c: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.webview.d.h$79) = 
                                      (r1v7 'hVar' com.tencent.mm.plugin.webview.d.h)
                                      (wrap: java.lang.String : 0x0206: INVOKE  (r0v7 java.lang.String) = 
                                      ("onCustomGameMenuClicked")
                                      (r2v5 'hashMap' java.util.HashMap)
                                      (wrap: boolean : 0x0202: IGET  (r3v2 boolean) = (r1v7 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                      (wrap: java.lang.String : 0x0204: IGET  (r4v0 java.lang.String) = (r1v7 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                     call: com.tencent.mm.plugin.webview.d.h.79.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.2.c(android.view.MenuItem):void, file: classes.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 33 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 39 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 552
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass2.c(android.view.MenuItem):void");
                            }
                        });
                        dVar.Jsa = new b.AbstractC1995b() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass3 */

                            @Override // com.tencent.mm.plugin.webview.ui.tools.game.menu.b.AbstractC1995b
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(80901);
                                h.INSTANCE.idkeyStat(480, 0, 1, false);
                                m t = GameWebViewUI.t(GameWebViewUI.this);
                                if (t != null) {
                                    mVar.ORD.addAll(t.ORD);
                                }
                                AppMethodBeat.o(80901);
                            }
                        };
                        if (this.Jig) {
                            dVar.mLN = true;
                            dVar.mLO = true;
                        } else {
                            dVar.mLN = false;
                            dVar.mLO = false;
                        }
                        if (this.Jik == null || !this.Jik.isShown()) {
                            hideVKB();
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass5 */

                                public final void run() {
                                    AppMethodBeat.i(80903);
                                    if (GameWebViewUI.this.isFinishing() || GameWebViewUI.this.Jjd) {
                                        Log.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                                        AppMethodBeat.o(80903);
                                        return;
                                    }
                                    dVar.dGm();
                                    AppMethodBeat.o(80903);
                                }
                            }, 100);
                            AppMethodBeat.o(80919);
                            return;
                        }
                        this.Jik.hide();
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass4 */

                            public final void run() {
                                AppMethodBeat.i(80902);
                                if (GameWebViewUI.this.isFinishing() || GameWebViewUI.this.Jjd) {
                                    Log.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                                    AppMethodBeat.o(80902);
                                    return;
                                }
                                dVar.dGm();
                                AppMethodBeat.o(80902);
                            }
                        }, 100);
                        AppMethodBeat.o(80919);
                    }

                    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$8  reason: invalid class name */
                    static /* synthetic */ class AnonymousClass8 {
                        static final /* synthetic */ int[] JrF = new int[c.a.values().length];

                        static {
                            AppMethodBeat.i(80906);
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_JUMP_H5.ordinal()] = 1;
                            } catch (NoSuchFieldError e2) {
                            }
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_EXIT.ordinal()] = 2;
                            } catch (NoSuchFieldError e3) {
                            }
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_SHARE_TO_FRIEND.ordinal()] = 3;
                            } catch (NoSuchFieldError e4) {
                            }
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_COLLECT.ordinal()] = 4;
                            } catch (NoSuchFieldError e5) {
                            }
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_REFRESH.ordinal()] = 5;
                            } catch (NoSuchFieldError e6) {
                            }
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_ADD_TO_DESKTOP.ordinal()] = 6;
                            } catch (NoSuchFieldError e7) {
                            }
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_COMPLAINT.ordinal()] = 7;
                            } catch (NoSuchFieldError e8) {
                            }
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_CUSTOM.ordinal()] = 8;
                            } catch (NoSuchFieldError e9) {
                            }
                            try {
                                JrF[c.a.HVGAME_MENU_ACTION_DEFAULT.ordinal()] = 9;
                                AppMethodBeat.o(80906);
                            } catch (NoSuchFieldError e10) {
                                AppMethodBeat.o(80906);
                            }
                        }
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                    public final void aG(String str, int i2, int i3) {
                        AppMethodBeat.i(211325);
                        super.aG(str, i2, i3);
                        AppMethodBeat.o(211325);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                    public final int gfz() {
                        AppMethodBeat.i(80921);
                        int gfz = super.gfz();
                        AppMethodBeat.o(80921);
                        return gfz;
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                    public final void bb(Bundle bundle) {
                        AppMethodBeat.i(80922);
                        super.bb(bundle);
                        AppMethodBeat.o(80922);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                    public final void bXg() {
                        boolean z;
                        dv dSU;
                        AppMethodBeat.i(80923);
                        super.bXg();
                        this.Jrv = true;
                        if (!this.xvW && this.xPq == null && this.xPp == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && (dSU = com.tencent.mm.plugin.game.commlib.a.dSU()) != null && !Util.isNullOrNil(dSU.ixw) && !Util.isNullOrNil(dSU.xNo)) {
                            try {
                                if (ao.isDarkMode()) {
                                    this.xPp = Color.parseColor(dSU.xNo);
                                } else {
                                    this.xPp = Color.parseColor(dSU.ixw);
                                }
                            } catch (IllegalArgumentException e2) {
                                Log.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + e2.getMessage());
                            }
                            this.xPq = dSU.xHA;
                            gfs();
                            zj(true);
                        }
                        Intent intent = getIntent();
                        if (intent != null && intent.getBooleanExtra("game_check_float", false)) {
                            int intExtra = intent.getIntExtra("game_sourceScene", 0);
                            this.Jrr = intent.getStringExtra("game_transparent_float_url");
                            if (Util.isNullOrNil(this.Jrr)) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("game_check_float", true);
                                intent2.putExtra("game_sourceScene", intExtra);
                                com.tencent.mm.br.c.b(this, "game", ".ui.GameCenterUI", intent2);
                                AppMethodBeat.o(80923);
                                return;
                            }
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putInt("game_sourceScene", intExtra);
                                if (this.mHh != null) {
                                    this.mHh.j(91, bundle);
                                }
                                if (this.JpK == null) {
                                    this.JpK = new a(this, this.Jie, this.Jrr);
                                }
                                a aVar = this.JpK;
                                String str = this.Jrr;
                                aVar.xyo = str;
                                aVar.JpX.m(str, false, false);
                                if (aVar.iGY != null && aVar.iGY.getParent() == null) {
                                    aVar.WN.addView(aVar.iGY, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (!(aVar.iGY == null || aVar.JpY == null)) {
                                    aVar.iGY.post(new Runnable(str) {
                                        /* class com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass3 */
                                        final /* synthetic */ String val$url;

                                        {
                                            this.val$url = r2;
                                        }

                                        public final void run() {
                                            AppMethodBeat.i(80820);
                                            a.this.iGY.setVisibility(8);
                                            a.this.JpY.baG(this.val$url);
                                            AppMethodBeat.o(80820);
                                        }
                                    });
                                }
                                this.Jrr = null;
                                AppMethodBeat.o(80923);
                                return;
                            } catch (RemoteException e3) {
                            }
                        }
                        AppMethodBeat.o(80923);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                    public final void zj(boolean z) {
                        AppMethodBeat.i(80924);
                        super.zj(z);
                        zl(false);
                        AppMethodBeat.o(80924);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
                    public void addIconOptionMenu(int i2, int i3, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
                        AppMethodBeat.i(80925);
                        if (this.Jrv) {
                            super.addIconOptionMenu(i2, i3, onMenuItemClickListener);
                        }
                        AppMethodBeat.o(80925);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                    public void onResume() {
                        AppMethodBeat.i(80926);
                        super.onResume();
                        if (this.xyv.hhL == 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            Log.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(currentTimeMillis)));
                            this.xyv.hhL = currentTimeMillis;
                        }
                        this.xyL = System.currentTimeMillis();
                        AppMethodBeat.o(80926);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                    public void onPause() {
                        AppMethodBeat.i(80927);
                        super.onPause();
                        this.xyv.hhU += System.currentTimeMillis() - this.xyL;
                        AppMethodBeat.o(80927);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                    public void onDestroy() {
                        AppMethodBeat.i(80928);
                        this.IMH.b(this.Jrz);
                        this.IMH.b(this.Jrz.JrG);
                        super.onDestroy();
                        this.JpX.zE(this.Jrx);
                        this.xyv.hhV = System.currentTimeMillis();
                        com.tencent.mm.game.report.api.a.hhr.a(this.xyv);
                        GameWebPerformanceInfo.Ff(coX());
                        d.a(ghj(), this);
                        g.baM(coX());
                        AppMethodBeat.o(80928);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
                    public int getLayoutId() {
                        AppMethodBeat.i(80929);
                        this.xyv.hhM = System.currentTimeMillis();
                        int layoutId = super.getLayoutId();
                        AppMethodBeat.o(80929);
                        return layoutId;
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
                    public void initView() {
                        AppMethodBeat.i(80930);
                        super.initView();
                        this.Jrp = new ColorDrawable(android.support.v4.content.b.n(this, R.color.bp));
                        this.Jrq = new ColorDrawable(android.support.v4.content.b.n(this, R.color.bp));
                        this.xyv.hhN = System.currentTimeMillis();
                        this.xyM.JqV = System.currentTimeMillis();
                        AppMethodBeat.o(80930);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                    public final void gfA() {
                        AppMethodBeat.i(80931);
                        super.gfA();
                        this.Jrt = getIntent().getStringExtra("game_hv_menu_appid");
                        if (this.Jig && !Util.isNullOrNil(this.Jrt)) {
                            if (this.Jif != null) {
                                this.Jif.setVisibility(8);
                            }
                            this.Jru.a(this.Jid, new GameMenuImageButton.a() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass6 */

                                @Override // com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a
                                public final void dlk() {
                                    AppMethodBeat.i(80904);
                                    GameWebViewUI.this.cpD();
                                    AppMethodBeat.o(80904);
                                }
                            });
                        }
                        AppMethodBeat.o(80931);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                    public final void loadUrl(String str, Map<String, String> map, boolean z) {
                        AppMethodBeat.i(80933);
                        if (this.xyv.hhP == 0) {
                            this.xyv.hhP = System.currentTimeMillis();
                        }
                        if (this.JpX.gkw()) {
                            super.loadUrl(str, map, false);
                            AppMethodBeat.o(80933);
                            return;
                        }
                        super.loadUrl(str, map, z);
                        AppMethodBeat.o(80933);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
                    public void setMMOrientation() {
                        AppMethodBeat.i(80934);
                        if (Build.VERSION.SDK_INT <= 10) {
                            super.setMMOrientation();
                            AppMethodBeat.o(80934);
                        } else if (getForceOrientation() == -1) {
                            this.landscapeMode = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getBoolean("settings_landscape_mode", false);
                            if (this.landscapeMode) {
                                setRequestedOrientation(2);
                                AppMethodBeat.o(80934);
                                return;
                            }
                            setRequestedOrientation(1);
                            AppMethodBeat.o(80934);
                        } else {
                            setRequestedOrientation(getForceOrientation());
                            AppMethodBeat.o(80934);
                        }
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.game.e
                    public final Map<Integer, Object> dTR() {
                        AppMethodBeat.i(211326);
                        HashMap hashMap = new HashMap();
                        hashMap.put(Integer.valueOf(d.a.Jqn), ghj());
                        hashMap.put(Integer.valueOf(d.a.Jqo), NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
                        hashMap.put(Integer.valueOf(d.a.Jqp), String.valueOf(YearClass.get(MMApplicationContext.getContext())));
                        String coX = coX();
                        try {
                            hashMap.put(Integer.valueOf(d.a.Jqq), com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(coX), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                        } catch (UnsupportedEncodingException e2) {
                        }
                        hashMap.put(Integer.valueOf(d.a.Jqr), Boolean.valueOf(this.JpX.bci(coX)));
                        hashMap.put(Integer.valueOf(d.a.Jqs), 0);
                        hashMap.put(Integer.valueOf(d.a.Jqt), 0);
                        hashMap.put(Integer.valueOf(d.a.Jqu), this.JpX.gkx());
                        hashMap.put(Integer.valueOf(d.a.Jqv), e.gky());
                        AppMethodBeat.o(211326);
                        return hashMap;
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.game.e
                    public final Map<Integer, Object> dTS() {
                        AppMethodBeat.i(211327);
                        HashMap hashMap = new HashMap();
                        g baL = g.baL(coX());
                        if (baL != null) {
                            hashMap.put(Integer.valueOf(d.b.Jqy), Long.valueOf(baL.JqV - baL.startTime));
                            hashMap.put(Integer.valueOf(d.b.Jqz), Long.valueOf(baL.JqW - baL.startTime));
                            hashMap.put(Integer.valueOf(d.b.JqA), Long.valueOf(baL.JqX - baL.JqW));
                            hashMap.put(Integer.valueOf(d.b.JqB), Long.valueOf(baL.JqZ - baL.JqY));
                            hashMap.put(Integer.valueOf(d.b.JqC), Long.valueOf(baL.Jrb - baL.Jra));
                            hashMap.put(Integer.valueOf(d.b.JqK), Long.valueOf(baL.Jrc));
                        }
                        hashMap.put(Integer.valueOf(d.b.JqL), 0);
                        AppMethodBeat.o(211327);
                        return hashMap;
                    }

                    class c extends k {
                        a JrG;

                        private c() {
                            AppMethodBeat.i(211321);
                            this.JrG = new a(this, (byte) 0);
                            AppMethodBeat.o(211321);
                        }

                        /* synthetic */ c(GameWebViewUI gameWebViewUI, byte b2) {
                            this();
                        }

                        class b extends j {
                            private b() {
                            }

                            /* synthetic */ b(c cVar, byte b2) {
                                this();
                            }

                            @Override // com.tencent.mm.plugin.webview.core.j
                            public final void by(int i2, String str) {
                                AppMethodBeat.i(211319);
                                if (GameWebViewUI.this.xyv.hhS == 0) {
                                    GameWebViewUI.this.xyv.hhS = System.currentTimeMillis();
                                }
                                if (GameWebViewUI.this.xyM.JqY == 0) {
                                    GameWebViewUI.this.xyM.JqY = System.currentTimeMillis();
                                }
                                AppMethodBeat.o(211319);
                            }

                            @Override // com.tencent.mm.plugin.webview.core.j
                            public final void aXN(String str) {
                                AppMethodBeat.i(211320);
                                if (GameWebViewUI.this.xyv.hhT == 0) {
                                    GameWebViewUI.this.xyv.hhT = System.currentTimeMillis();
                                }
                                if (GameWebViewUI.this.xyM.JqZ == 0) {
                                    GameWebViewUI.this.xyM.JqZ = System.currentTimeMillis();
                                }
                                GameWebViewUI.this.JrA = true;
                                if (GameWebViewUI.this.JrB) {
                                    GameWebViewUI.c(GameWebViewUI.this);
                                }
                                AppMethodBeat.o(211320);
                            }
                        }

                        class a extends GameBaseWebViewUI.a {
                            private a() {
                                super();
                            }

                            /* synthetic */ a(c cVar, byte b2) {
                                this();
                            }

                            @Override // com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI.a, com.tencent.mm.plugin.webview.core.f
                            public final void i(WebView webView, String str) {
                                AppMethodBeat.i(211316);
                                if (GameWebViewUI.this.xyv.hhQ == 0) {
                                    GameWebViewUI.this.xyv.hhQ = System.currentTimeMillis();
                                }
                                if (GameWebViewUI.this.xyM.JqW == 0) {
                                    GameWebViewUI.this.xyM.JqW = System.currentTimeMillis();
                                }
                                GameWebViewUI.this.JpX.bcg(str);
                                AppMethodBeat.o(211316);
                            }

                            @Override // com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI.a, com.tencent.mm.plugin.webview.core.f
                            public final void b(WebView webView, String str) {
                                AppMethodBeat.i(211317);
                                if (GameWebViewUI.this.xyv.hhR == 0) {
                                    GameWebViewUI.this.xyv.hhR = System.currentTimeMillis();
                                }
                                if (GameWebViewUI.this.xyM.JqX == 0) {
                                    GameWebViewUI.this.xyM.JqX = System.currentTimeMillis();
                                }
                                GameWebViewUI.A(GameWebViewUI.this);
                                GameWebViewUI.this.JpX.bch(str);
                                super.b(webView, str);
                                AppMethodBeat.o(211317);
                            }

                            @Override // com.tencent.mm.plugin.webview.core.f
                            public final void a(WebView webView, int i2, String str, String str2) {
                                AppMethodBeat.i(211318);
                                GameWebViewUI.A(GameWebViewUI.this);
                                super.a(webView, i2, str, str2);
                                AppMethodBeat.o(211318);
                            }
                        }

                        @Override // com.tencent.mm.plugin.webview.core.k
                        public final f gai() {
                            return this.JrG;
                        }

                        @Override // com.tencent.mm.plugin.webview.core.k
                        public final j gaj() {
                            AppMethodBeat.i(211322);
                            b bVar = new b(this, (byte) 0);
                            AppMethodBeat.o(211322);
                            return bVar;
                        }

                        @Override // com.tencent.mm.plugin.webview.core.k
                        public final WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
                            AppMethodBeat.i(211323);
                            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                                AppMethodBeat.o(211323);
                                return null;
                            }
                            WebResourceResponse p = GameWebViewUI.this.JpX.p(webView, webResourceRequest.getUrl().toString());
                            AppMethodBeat.o(211323);
                            return p;
                        }
                    }

                    class a extends com.tencent.mm.plugin.webview.ui.tools.b {
                        public a(WebViewUI webViewUI) {
                            super(webViewUI);
                        }

                        @Override // com.tencent.mm.plugin.webview.ui.tools.b, com.tencent.xweb.x5.export.external.extension.proxy.a
                        public final Object onMiscCallBack(String str, Bundle bundle) {
                            AppMethodBeat.i(80907);
                            Object onMiscCallBack = GameWebViewUI.this.JpX.onMiscCallBack(str, bundle);
                            if (onMiscCallBack != null) {
                                AppMethodBeat.o(80907);
                                return onMiscCallBack;
                            }
                            Object onMiscCallBack2 = super.onMiscCallBack(str, bundle);
                            AppMethodBeat.o(80907);
                            return onMiscCallBack2;
                        }
                    }

                    private void ghi() {
                        AppMethodBeat.i(80937);
                        if (this.JhW != null) {
                            this.JhW.setVisibility(0);
                        }
                        AppMethodBeat.o(80937);
                    }

                    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                    public boolean cpz() {
                        AppMethodBeat.i(80938);
                        getIntent().putExtra("minimize_secene", 2);
                        AppMethodBeat.o(80938);
                        return true;
                    }

                    protected class b extends WebViewUI.b {
                        protected b() {
                            super();
                        }

                        @Override // com.tencent.xweb.x
                        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                            AppMethodBeat.i(80908);
                            if (GameWebViewUI.this.JpX != null) {
                                GameWebViewUI.this.JpX.a(consoleMessage);
                            }
                            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                            AppMethodBeat.o(80908);
                            return onConsoleMessage;
                        }
                    }

                    public final e getWePkgPlugin() {
                        return this.JpX;
                    }

                    public final void hXR() {
                        AppMethodBeat.i(259673);
                        this.xyM.Jra = System.currentTimeMillis();
                        this.xyv.hhB = 1;
                        AppMethodBeat.o(259673);
                    }

                    public final void hXS() {
                        AppMethodBeat.i(259674);
                        this.xyM.Jrb = System.currentTimeMillis();
                        AppMethodBeat.o(259674);
                    }

                    public final String ghj() {
                        AppMethodBeat.i(211328);
                        String str = (hashCode() & Integer.MAX_VALUE) + "_" + (coX().hashCode() & Integer.MAX_VALUE);
                        AppMethodBeat.o(211328);
                        return str;
                    }

                    static /* synthetic */ void c(GameWebViewUI gameWebViewUI) {
                        AppMethodBeat.i(211329);
                        gameWebViewUI.JrA = false;
                        gameWebViewUI.JrB = false;
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI.AnonymousClass7 */

                            public final void run() {
                                AppMethodBeat.i(80905);
                                if (GameWebViewUI.this.pGj != null) {
                                    Log.i("MicroMsg.Wepkg.GameWebViewUI", "home page, reload url:%s from net", GameWebViewUI.this.pFJ);
                                    GameWebViewUI.this.pGj.stopLoading();
                                    GameWebViewUI.this.pGj.loadUrl(GameWebViewUI.this.pFJ);
                                }
                                AppMethodBeat.o(80905);
                            }
                        }, 100);
                        AppMethodBeat.o(211329);
                    }

                    static /* synthetic */ void e(GameWebViewUI gameWebViewUI) {
                        AppMethodBeat.i(211330);
                        synchronized (gameWebViewUI.xyx) {
                            try {
                                if (gameWebViewUI.Jie != null && gameWebViewUI.xyw) {
                                    gameWebViewUI.Jry = new FrameLayout(gameWebViewUI);
                                    gameWebViewUI.Jry.setClickable(true);
                                    gameWebViewUI.Jie.addView(gameWebViewUI.Jry, new FrameLayout.LayoutParams(-1, -1));
                                    gameWebViewUI.Jry.addView(LayoutInflater.from(gameWebViewUI).inflate(R.layout.b28, (ViewGroup) gameWebViewUI.Jie, false), new FrameLayout.LayoutParams(-2, -2, 17));
                                }
                            } finally {
                                AppMethodBeat.o(211330);
                            }
                        }
                    }

                    static /* synthetic */ void g(GameWebViewUI gameWebViewUI) {
                        AppMethodBeat.i(211331);
                        synchronized (gameWebViewUI.xyx) {
                            try {
                                if (!(gameWebViewUI.Jie == null || gameWebViewUI.Jry == null)) {
                                    gameWebViewUI.Jie.removeView(gameWebViewUI.Jry);
                                }
                            } finally {
                                AppMethodBeat.o(211331);
                            }
                        }
                    }

                    static /* synthetic */ void A(GameWebViewUI gameWebViewUI) {
                        AppMethodBeat.i(211339);
                        if (gameWebViewUI.JhW != null) {
                            gameWebViewUI.JhW.setVisibility(8);
                        }
                        AppMethodBeat.o(211339);
                    }
                }
