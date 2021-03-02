package com.tencent.mm.plugin.websearch.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.g.b.a.ni;
import com.tencent.mm.g.b.a.nl;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.ad;
import com.tencent.mm.modelappbrand.ae;
import com.tencent.mm.modelappbrand.af;
import com.tencent.mm.modelappbrand.ag;
import com.tencent.mm.modelappbrand.ah;
import com.tencent.mm.modelappbrand.ai;
import com.tencent.mm.modelappbrand.aj;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ugc.TXRecordCommon;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public final class a implements com.tencent.mm.plugin.websearch.api.d {
    private static u IHy = new u();
    private Runnable IHA;
    private String IHB;
    private volatile String IHC = null;
    private HashMap<String, Object> IHn = new HashMap<>();
    private HashMap<String, Object> IHo = new HashMap<>();
    private HashMap<String, Object> IHp = new HashMap<>();
    private Map<String, String> IHq = new HashMap();
    private int IHr = -1;
    private g IHs;
    private Map<String, e> IHt = new HashMap();
    private Map<String, d> IHu = new HashMap();
    private Map<String, WidgetData> IHv = new HashMap();
    public boolean IHw = true;
    private n IHx;
    private WidgetData IHz;
    private Context context;

    static /* synthetic */ void a(a aVar, View view, View view2, int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(116626);
        aVar.a(view, view2, i2, i3, i4, i5, str);
        AppMethodBeat.o(116626);
    }

    static {
        AppMethodBeat.i(116627);
        AppMethodBeat.o(116627);
    }

    /* access modifiers changed from: package-private */
    public class e {
        int IFS;
        int IIe;

        private e() {
        }

        /* synthetic */ e(a aVar, byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(116607);
            String format = String.format("minH %d, maxH %d", Integer.valueOf(this.IIe), Integer.valueOf(this.IFS));
            AppMethodBeat.o(116607);
            return format;
        }
    }

    public static u fYT() {
        return IHy;
    }

    /* access modifiers changed from: package-private */
    public class d {
        boolean IId;
        int dMe;
        String dNI;
        boolean isLoading;
        String lmc;
        int pkgVersion;

        private d() {
        }

        /* synthetic */ d(a aVar, byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(116606);
            String format = String.format("WidgetInfo appid %s, widgetId %s, pkgType %d, pkgVer %d", this.dNI, this.lmc, Integer.valueOf(this.dMe), Integer.valueOf(this.pkgVersion));
            AppMethodBeat.o(116606);
            return format;
        }
    }

    public a(Context context2, final n nVar) {
        AppMethodBeat.i(116608);
        this.context = context2;
        this.IHx = nVar;
        this.IHs = (g) com.tencent.mm.kernel.g.af(g.class);
        if (this.IHw && new o(com.tencent.mm.loader.j.b.aKJ(), "websearch-widget-not-use-tools").exists()) {
            this.IHw = false;
        }
        if (MMApplicationContext.isMMProcess()) {
            h.a(SupportProcessIPCService.dkO, new com.tencent.mm.ipcinvoker.n() {
                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.n
                public final void onDisconnect() {
                    AppMethodBeat.i(116577);
                    if (SupportProcessIPCService.dkO.equals(a.this.IHB)) {
                        u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "support process dead", new Object[0]);
                        if (a.this.IHz != null) {
                            hr vt = new hr().vt(a.this.IHz.IFG.iIA);
                            vt.eBS = (long) a.this.IHz.IFG.serviceType;
                            vt.eMi = 21;
                            vt.eMj = System.currentTimeMillis();
                            vt.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                            v.pl(30);
                            nVar.fXJ();
                        }
                    }
                    AppMethodBeat.o(116577);
                }
            });
        }
        AppMethodBeat.o(116608);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void aWY(String str) {
        AppMethodBeat.i(116609);
        d dVar = this.IHu.get(str);
        if (dVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", dVar.dNI);
            bundle.putString("msg_id", dVar.lmc);
            bundle.putInt("pkg_type", dVar.dMe);
            bundle.putInt("pkg_version", dVar.pkgVersion);
            ((g) com.tencent.mm.kernel.g.af(g.class)).aXI().d(this.context, bundle);
        }
        AppMethodBeat.o(116609);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void a(final WidgetData widgetData, final String str, final int i2, final int i3) {
        AppMethodBeat.i(116610);
        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s", Float.valueOf(com.tencent.mm.cc.a.gvp()), Float.valueOf(com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()));
        p.A(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(116591);
                if (widgetData == null || widgetData.IFG == null || widgetData.IFH == null) {
                    AppMethodBeat.o(116591);
                    return;
                }
                d.fYU();
                if (!d.a(widgetData)) {
                    u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "local forbidden widget %s", widgetData.IFG.iIA);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(116578);
                            a.this.IHx.gd(str, 3);
                            AppMethodBeat.o(116578);
                        }
                    });
                    AppMethodBeat.o(116591);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2 */

                    public final void run() {
                        d dVar;
                        long j2;
                        int i2;
                        AppMethodBeat.i(116590);
                        a.this.IHz = widgetData;
                        a.this.IHv.put(str, widgetData);
                        v.pl(0);
                        final String str = "sessionid_" + System.currentTimeMillis();
                        u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget: serviceType %d widgetId %s, sessionId %s, jsonData %s ", Integer.valueOf(widgetData.IFG.serviceType), str, str, widgetData.toString());
                        d dVar2 = (d) a.this.IHu.get(str);
                        if (dVar2 == null) {
                            d dVar3 = new d(a.this, (byte) 0);
                            a.this.IHu.put(str, dVar3);
                            dVar = dVar3;
                        } else {
                            dVar = dVar2;
                        }
                        dVar.isLoading = true;
                        try {
                            d.fYU();
                            d.b(widgetData);
                            e eVar = (e) a.this.IHt.get(str);
                            if (eVar == null) {
                                eVar = new e(a.this, (byte) 0);
                                a.this.IHt.put(str, eVar);
                            }
                            eVar.IIe = (int) widgetData.IFH.IFR;
                            eVar.IFS = widgetData.IFH.IFS;
                            Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "update widgetSize %s", eVar.toString());
                            a.fYT();
                            u.Lx(widgetData.IFG.iIA);
                            final boolean z = !TextUtils.isEmpty(l.dN(widgetData.IFG.dCx).get("widgetData"));
                            if (z) {
                                a.fYT();
                                u.aXS();
                            }
                            hr vt = new hr().vt(widgetData.IFG.iIA);
                            if (z) {
                                j2 = 1;
                            } else {
                                j2 = 2;
                            }
                            vt.eMl = j2;
                            vt.eBS = (long) widgetData.IFG.serviceType;
                            vt.eMi = 1;
                            hr vs = vt.vs(str);
                            vs.eMj = System.currentTimeMillis();
                            vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
                            final View cU = a.this.IHs.cU(a.this.context);
                            AbsoluteLayout absoluteLayout = (AbsoluteLayout) aa.jQ(a.this.context).inflate(R.layout.ao7, (ViewGroup) null);
                            absoluteLayout.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, -2, as.zE(widgetData.IFH.maZ), as.zE(widgetData.IFH.mba)));
                            AbsoluteLayout.LayoutParams layoutParams = new AbsoluteLayout.LayoutParams(as.zE(widgetData.IFH.width), as.zE(widgetData.IFH.height), 0, 0);
                            cU.setLayoutParams(layoutParams);
                            absoluteLayout.addView(cU);
                            FrameLayout frameLayout = (FrameLayout) absoluteLayout.findViewById(R.id.epz);
                            frameLayout.setLayoutParams(layoutParams);
                            absoluteLayout.removeView(frameLayout);
                            absoluteLayout.addView(frameLayout);
                            cU.setTag(str);
                            a.this.IHn.put(str, cU);
                            a.this.IHo.put(str, absoluteLayout);
                            a.this.IHp.put(str, frameLayout);
                            final ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) absoluteLayout.findViewById(R.id.epy);
                            final ImageView imageView = (ImageView) absoluteLayout.findViewById(R.id.bh7);
                            String str2 = widgetData.IFG.iIA + "_" + widgetData.IFG.IFK.hashCode();
                            Bundle bundle = new Bundle();
                            if (a.this.IHw) {
                                a.this.IHB = ToolsMpProcessIPCService.dkO;
                            } else {
                                a.this.IHB = SupportProcessIPCService.dkO;
                            }
                            bundle.putString("exec_process_name", a.this.IHB);
                            bundle.putString("app_id", widgetData.IFG.dNI);
                            bundle.putString("src_app_id", widgetData.IFG.iIA);
                            bundle.putString("wxa_unique_id", str);
                            bundle.putString("msg_id", str2);
                            bundle.putString("search_id", widgetData.IFG.hes);
                            bundle.putString("cache_key", widgetData.IFG.IFK);
                            bundle.putString("msg_title", widgetData.IFG.nickName);
                            bundle.putString("msg_path", widgetData.IFG.dCx);
                            bundle.putInt("pkg_version", widgetData.IFG.version);
                            bundle.putInt("msg_pkg_type", widgetData.IFG.nbf);
                            bundle.putString("init_data", widgetData.IFG.IFJ);
                            bundle.putInt("widget_type", 1);
                            bundle.putInt("service_type", widgetData.IFG.serviceType);
                            int i3 = i3;
                            if (i3 == 201) {
                                i2 = 1006;
                            } else if (i3 == 3) {
                                i2 = 1005;
                            } else if (i3 == 16) {
                                i2 = 1042;
                            } else if (i3 == 20) {
                                i2 = 1053;
                            } else {
                                i2 = 1000;
                            }
                            bundle.putInt("scene", i2);
                            bundle.putInt("view_init_width", as.zE(widgetData.IFH.width));
                            bundle.putInt("view_init_height", as.zE(widgetData.IFH.height));
                            bundle.putString(SearchIntents.EXTRA_QUERY, widgetData.IFG.IFK);
                            bundle.putString("preload_launch_data", widgetData.IFG.IFL);
                            bundle.putString("preload_download_data", widgetData.IFG.downloadUrl);
                            bundle.putInt("draw_strategy", i2);
                            bundle.putBoolean("use_predraw", ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_pre_draw, 0) == 1);
                            threeDotsLoadingView.setVisibility(0);
                            imageView.setVisibility(4);
                            threeDotsLoadingView.gZh();
                            dVar.dNI = widgetData.IFG.dNI;
                            dVar.dMe = widgetData.IFG.nbf;
                            dVar.pkgVersion = widgetData.IFG.version;
                            dVar.lmc = str2;
                            Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "inserting widget %s", dVar.toString());
                            final long currentTimeMillis = System.currentTimeMillis();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(867, 0, 1, false);
                            ac acVar = new ac(new com.tencent.mm.modelappbrand.h() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass9 */

                                @Override // com.tencent.mm.modelappbrand.h
                                public final void L(View view, int i2) {
                                    long j2;
                                    long j3;
                                    AppMethodBeat.i(116584);
                                    u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetStateChanged sessionId %s, state %d", str, Integer.valueOf(i2));
                                    a.this.IHr = i2;
                                    switch (i2) {
                                        case 0:
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(867, 1, 1, false);
                                            if (a.this.IHu.get(str) != null) {
                                                if (((d) a.this.IHu.get(str)).IId) {
                                                    threeDotsLoadingView.setVisibility(8);
                                                } else {
                                                    threeDotsLoadingView.setVisibility(0);
                                                }
                                            }
                                            imageView.setVisibility(4);
                                            a.this.IHx.gd(str, 1);
                                            AppMethodBeat.o(116584);
                                            return;
                                        case 1:
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(867, 3, 1, false);
                                            threeDotsLoadingView.gZi();
                                            threeDotsLoadingView.setVisibility(4);
                                            a.this.IHx.gd(str, 3);
                                            a.fYT();
                                            u.J(widgetData.IFG.dNI, false);
                                            ((d) a.this.IHu.get(str)).isLoading = false;
                                            AppMethodBeat.o(116584);
                                            return;
                                        case 2:
                                        case 3:
                                        default:
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(867, 4, 1, false);
                                            a.fYT();
                                            u.J(widgetData.IFG.dNI, false);
                                            threeDotsLoadingView.gZi();
                                            threeDotsLoadingView.setVisibility(4);
                                            ((d) a.this.IHu.get(str)).isLoading = false;
                                            if (i2 == 2) {
                                                a.this.IHx.gd(str, 4);
                                                AppMethodBeat.o(116584);
                                                return;
                                            }
                                            a.this.IHx.gd(str, 3);
                                            AppMethodBeat.o(116584);
                                            return;
                                        case 4:
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(867, 2, 1, false);
                                            threeDotsLoadingView.setVisibility(4);
                                            imageView.setVisibility(4);
                                            threeDotsLoadingView.gZi();
                                            a.fYT();
                                            u.J(widgetData.IFG.dNI, true);
                                            ((d) a.this.IHu.get(str)).isLoading = false;
                                            a.this.IHx.gd(str, 2);
                                            u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "widget display timecost %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                            ni niVar = new ni();
                                            niVar.enR = niVar.x("appid", widgetData.IFG.iIA, true);
                                            niVar.eMp = System.currentTimeMillis() - currentTimeMillis;
                                            if (z) {
                                                j2 = 1;
                                            } else {
                                                j2 = 2;
                                            }
                                            niVar.eMl = j2;
                                            niVar.bfK();
                                            nl nlVar = new nl();
                                            nlVar.ejW = 4;
                                            nl AA = nlVar.AA(widgetData.IFG.iIA);
                                            AA.eMp = System.currentTimeMillis() - currentTimeMillis;
                                            if (z) {
                                                j3 = 1;
                                            } else {
                                                j3 = 2;
                                            }
                                            AA.eMl = j3;
                                            AA.fgF = (long) i2;
                                            AA.bfK();
                                            d.fYU();
                                            d.d(widgetData);
                                            AppMethodBeat.o(116584);
                                            return;
                                    }
                                }
                            });
                            acVar.a(new w() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass10 */

                                @Override // com.tencent.mm.modelappbrand.w
                                public final void aXT() {
                                    AppMethodBeat.i(116585);
                                    d dVar = (d) a.this.IHu.get(str);
                                    if (dVar != null) {
                                        dVar.IId = true;
                                        dVar.isLoading = false;
                                    }
                                    v.pl(33);
                                    AppMethodBeat.o(116585);
                                }
                            });
                            acVar.a(new g(a.this.context));
                            acVar.a(new aj() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass11 */

                                @Override // com.tencent.mm.modelappbrand.aj
                                public final void a(int i2, t tVar) {
                                    AppMethodBeat.i(116586);
                                    a.a(a.this, str, i2, tVar);
                                    AppMethodBeat.o(116586);
                                }
                            });
                            acVar.a(new af() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass12 */

                                @Override // com.tencent.mm.modelappbrand.af
                                public final void b(boolean z, String str, boolean z2) {
                                    AppMethodBeat.i(116587);
                                    Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", "onSearchWAWidgetOnTapCallback");
                                    Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", "onSearchWAWidgetOnTapCallback", Boolean.valueOf(z), str, Boolean.valueOf(z2));
                                    if (str.equals(a.this.IHC)) {
                                        a.this.IHC = null;
                                        n nVar = a.this.IHx;
                                        if (!z) {
                                            z2 = false;
                                        }
                                        nVar.i(str, z2, str);
                                    }
                                    AppMethodBeat.o(116587);
                                }
                            });
                            acVar.a(new ag() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass13 */

                                @Override // com.tencent.mm.modelappbrand.ag
                                public final void aXW() {
                                    AppMethodBeat.i(116588);
                                    a.a(a.this, str, cU);
                                    AppMethodBeat.o(116588);
                                }
                            });
                            acVar.a(new ah() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass14 */

                                @Override // com.tencent.mm.modelappbrand.ah
                                public final void LC(String str) {
                                    AppMethodBeat.i(116589);
                                    Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", "onOpenApp");
                                    a.a(a.this, str, str);
                                    AppMethodBeat.o(116589);
                                }
                            });
                            acVar.a(new ad() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass2 */

                                @Override // com.tencent.mm.modelappbrand.ad
                                public final void LB(String str) {
                                    AppMethodBeat.i(116579);
                                    Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget call %s ", "onMakePhoneCall");
                                    if (!TextUtils.isEmpty(str)) {
                                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
                                        intent.addFlags(268435456);
                                        if (Util.isIntentAvailable(a.this.context, intent)) {
                                            Context context = a.this.context;
                                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            context.startActivity((Intent) bl.pG(0));
                                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/websearch/widget/FTSSearchWidgetMgr$3$2$10", "onMakePhoneCall", "(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/OnResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        }
                                        AppMethodBeat.o(116579);
                                        return;
                                    }
                                    Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onMakePhone null number");
                                    AppMethodBeat.o(116579);
                                }
                            });
                            acVar.a(new ai() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass3 */

                                @Override // com.tencent.mm.modelappbrand.ai
                                public final void LD(String str) {
                                    AppMethodBeat.i(116580);
                                    Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", str);
                                    String c2 = a.c(a.this, str);
                                    if (!Util.isNullOrNil(c2)) {
                                        a.this.IHx.aXa(c2);
                                        AppMethodBeat.o(116580);
                                        return;
                                    }
                                    Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
                                    AppMethodBeat.o(116580);
                                }
                            });
                            acVar.a(new ae() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass4 */

                                @Override // com.tencent.mm.modelappbrand.ae
                                public final void aX(String str, String str2) {
                                    AppMethodBeat.i(116581);
                                    Log.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", str, str2);
                                    String c2 = a.c(a.this, str);
                                    if (!Util.isNullOrNil(c2)) {
                                        a.this.IHx.lH(c2, str2);
                                        AppMethodBeat.o(116581);
                                        return;
                                    }
                                    Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
                                    AppMethodBeat.o(116581);
                                }
                            });
                            acVar.a(new com.tencent.mm.modelappbrand.aa() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass5 */

                                @Override // com.tencent.mm.modelappbrand.aa
                                public final void Lz(String str) {
                                    AppMethodBeat.i(116582);
                                    d.fYU();
                                    d.b(widgetData, str);
                                    AppMethodBeat.o(116582);
                                }
                            });
                            acVar.a(new z() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass6 */

                                @Override // com.tencent.mm.modelappbrand.z
                                public final void Ly(String str) {
                                    AppMethodBeat.i(116583);
                                    d.fYU();
                                    d.c(widgetData, str);
                                    AppMethodBeat.o(116583);
                                }
                            });
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("id", str);
                            bundle2.putString("appid", widgetData.IFG.dNI);
                            bundle2.putInt("serviceType", widgetData.IFG.serviceType);
                            bundle2.putInt("drawStrategy", i2);
                            bundle2.putString("srcAppid", widgetData.IFG.iIA);
                            u.a(str, widgetData.IFG.serviceType, widgetData.IFG.dNI, widgetData.IFG.iIA, i2);
                            a.this.IHq.put(a.this.IHs.a(str, cU, bundle, acVar), str);
                            h.a(MainProcessIPCService.dkO, bundle2, b.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass1 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // com.tencent.mm.ipcinvoker.d
                                public final /* bridge */ /* synthetic */ void bn(Bundle bundle) {
                                }
                            });
                            h.a(a.this.IHB, bundle2, b.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass7 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // com.tencent.mm.ipcinvoker.d
                                public final /* bridge */ /* synthetic */ void bn(Bundle bundle) {
                                }
                            });
                            h.a(com.tencent.mm.ipcinvoker.g.axZ(), bundle2, b.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass2.AnonymousClass2.AnonymousClass8 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // com.tencent.mm.ipcinvoker.d
                                public final /* bridge */ /* synthetic */ void bn(Bundle bundle) {
                                }
                            });
                            a.a(a.this, widgetData, str, str, cU, absoluteLayout, threeDotsLoadingView);
                            a.this.IHx.addView(absoluteLayout);
                            AppMethodBeat.o(116590);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", e2, "", new Object[0]);
                            AppMethodBeat.o(116590);
                        }
                    }
                });
                AppMethodBeat.o(116591);
            }
        });
        AppMethodBeat.o(116610);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void s(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(116611);
        a(WidgetData.aXl(str), str2, i2, i3);
        AppMethodBeat.o(116611);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void aWZ(String str) {
        AppMethodBeat.i(116612);
        aXs(str);
        d.fYU();
        d.c(this.IHz);
        AppMethodBeat.o(116612);
    }

    private void aXs(String str) {
        AppMethodBeat.i(116613);
        if (str != null && str.length() > 0) {
            WidgetData widgetData = this.IHv.get(str);
            d dVar = this.IHu.get(str);
            if (!(widgetData == null || dVar == null || !dVar.isLoading)) {
                hr vt = new hr().vt(widgetData.IFG.iIA);
                vt.eBS = (long) widgetData.IFG.serviceType;
                vt.eMi = 24;
                hr vs = vt.vs(str);
                vs.eMj = System.currentTimeMillis();
                vs.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
            }
            View view = (View) this.IHn.get(str);
            if (view == null) {
                Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removeWidget cacheKey %s, can not find view", str);
                AppMethodBeat.o(116613);
                return;
            }
            Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "removing widget sessionId %s", view.getTag().toString());
            if (this.IHs != null) {
                this.IHs.a((String) view.getTag(), view);
            }
            this.IHn.remove(str);
            this.IHp.remove(str);
            View view2 = (View) this.IHo.get(str);
            if (view2 != null) {
                this.IHx.removeView(view2);
                this.IHo.remove(str);
            }
        }
        AppMethodBeat.o(116613);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void lG(String str, String str2) {
        AppMethodBeat.i(116614);
        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "originDensity %s currentDensity %s useCustom %s updating widget: widgetId %s, jsonData %s", Float.valueOf(com.tencent.mm.cc.a.gvp()), Float.valueOf(com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext())), Boolean.valueOf(XWalkEnvironment.getUsingCustomContext()), str2, str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (str2 != null && str2.length() > 0) {
                View view = (View) this.IHn.get(str2);
                View view2 = (View) this.IHo.get(str2);
                if (view != null) {
                    AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
                    AbsoluteLayout.LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) view2.getLayoutParams();
                    if (jSONObject.has("width") || jSONObject.has("height")) {
                        a(view, (View) this.IHp.get(str2), layoutParams.height, as.zE(jSONObject.optInt("height")), layoutParams.width, as.zE(jSONObject.optInt("width")), str2);
                    }
                    if (jSONObject.has("offsetX")) {
                        layoutParams2.x = as.zE(jSONObject.optInt("offsetX"));
                    }
                    if (jSONObject.has("offsetY")) {
                        layoutParams2.y = as.zE(jSONObject.optInt("offsetY"));
                    }
                    view2.setLayoutParams(layoutParams2);
                    if (jSONObject.has("show")) {
                        if (jSONObject.has("show") ? jSONObject.optBoolean("show") : false) {
                            view.setVisibility(0);
                            view2.setVisibility(0);
                            AppMethodBeat.o(116614);
                            return;
                        }
                        view.setVisibility(8);
                        view2.setVisibility(8);
                    }
                }
            }
            AppMethodBeat.o(116614);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", "the error is e");
            AppMethodBeat.o(116614);
        }
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void a(final WidgetData widgetData, final String str) {
        AppMethodBeat.i(116615);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass6 */

                        public final void run() {
                            AppMethodBeat.i(116597);
                            View view = (View) a.this.IHn.get(str);
                            View view2 = (View) a.this.IHo.get(str);
                            if (view != null) {
                                AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) view.getLayoutParams();
                                a.a(a.this, view, (View) a.this.IHp.get(str), layoutParams.height, as.zE(widgetData.IFH.height), layoutParams.width, as.zE(widgetData.IFH.width), str);
                                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                                if (layoutParams2 instanceof AbsoluteLayout.LayoutParams) {
                                    AbsoluteLayout.LayoutParams layoutParams3 = (AbsoluteLayout.LayoutParams) layoutParams2;
                                    layoutParams3.x = as.zE(widgetData.IFH.maZ);
                                    layoutParams3.y = as.zE(widgetData.IFH.mba);
                                    view2.setLayoutParams(layoutParams3);
                                } else if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                                    marginLayoutParams.leftMargin = as.zE(widgetData.IFH.maZ);
                                    marginLayoutParams.topMargin = as.zE(widgetData.IFH.mba);
                                    view2.setLayoutParams(marginLayoutParams);
                                }
                                if (widgetData.IFH.eco) {
                                    view.setVisibility(0);
                                    view2.setVisibility(0);
                                    AppMethodBeat.o(116597);
                                    return;
                                }
                                view.setVisibility(8);
                                view2.setVisibility(8);
                            }
                            AppMethodBeat.o(116597);
                        }
                    });
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", e2, "", new Object[0]);
                AppMethodBeat.o(116615);
                return;
            }
        }
        AppMethodBeat.o(116615);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void onResume() {
        AppMethodBeat.i(116616);
        if (this.IHs != null) {
            for (String str : this.IHn.keySet()) {
                if (str != null && str.length() > 0) {
                    ((g) com.tencent.mm.kernel.g.af(g.class)).aXH().Lo((String) ((View) this.IHn.get(str)).getTag());
                }
            }
        }
        AppMethodBeat.o(116616);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void onPause() {
        AppMethodBeat.i(116617);
        if (this.IHs != null) {
            for (String str : this.IHn.keySet()) {
                if (str != null && str.length() > 0) {
                    ((g) com.tencent.mm.kernel.g.af(g.class)).aXH().Ln((String) ((View) this.IHn.get(str)).getTag());
                }
            }
        }
        AppMethodBeat.o(116617);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void onDestroy() {
        AppMethodBeat.i(116618);
        try {
            o[] a2 = new o(com.tencent.mm.loader.j.b.aKC().replace("/data/user/0", "/data/data") + "/fts_cache").a(new q("") {
                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass4 */

                @Override // com.tencent.mm.vfs.q
                public final boolean accept(o oVar) {
                    AppMethodBeat.i(177342);
                    if (com.tencent.mm.vfs.aa.z(oVar.her()).equals("")) {
                        AppMethodBeat.o(177342);
                        return false;
                    }
                    AppMethodBeat.o(177342);
                    return true;
                }
            });
            if (a2 != null) {
                for (o oVar : a2) {
                    u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "deleting %s", oVar.hes());
                    oVar.delete();
                }
            }
            if (this.IHs != null) {
                Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "remove all widget count %d", Integer.valueOf(this.IHn.size()));
                for (String str : new HashMap(this.IHn).keySet()) {
                    if (str != null && str.length() > 0) {
                        this.IHs.Lp((String) ((View) this.IHn.get(str)).getTag());
                        if (((View) this.IHo.get(str)) != null) {
                            aXs(str);
                            this.IHo.remove(str);
                        }
                    }
                }
                this.IHn.clear();
                this.IHp.clear();
            }
            this.IHz = null;
            AppMethodBeat.o(116618);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebSearch.FTSSearchWidgetMgr", Util.stackTraceToString(e2));
            AppMethodBeat.o(116618);
        }
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void g(final int i2, final int i3, final String str, final String str2) {
        AppMethodBeat.i(116619);
        u.v("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tapSearchWAWidgetView x %d, y %d, widgetId %s, eventId %s", Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
        View view = (View) this.IHn.get(str);
        if (view != null) {
            final com.tencent.mm.modelappbrand.p cr = this.IHs.cr(view);
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass7 */

                public final void run() {
                    boolean aW;
                    AppMethodBeat.i(116599);
                    com.tencent.mm.plugin.websearch.widget.c.b bVar = new com.tencent.mm.plugin.websearch.widget.c.b(i2, i3, str2);
                    com.tencent.mm.modelappbrand.p pVar = cr;
                    if (pVar == null) {
                        Log.e("BaseJsapiEvent", "null JSBridgeAccessible ");
                        aW = false;
                    } else {
                        aW = pVar.aW(bVar.getName(), bVar.fYY());
                    }
                    if (!aW) {
                        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: execute js event %s ", str);
                        a.this.IHx.b(str2, false, "onTap fail: execute js event  " + str, str);
                        AppMethodBeat.o(116599);
                        return;
                    }
                    a.this.IHC = str2;
                    com.tencent.mm.ch.a.x(new Runnable() {
                        /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(116598);
                            if (str2.equals(a.this.IHC)) {
                                Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "tap event timeout id %s", str2);
                                a.this.IHC = null;
                                a.this.IHx.b(str2, false, "timeout", str);
                            }
                            AppMethodBeat.o(116598);
                        }
                    });
                    AppMethodBeat.o(116599);
                }
            }, "tapSearchWAWidgetView");
            AppMethodBeat.o(116619);
            return;
        }
        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onTap fail: can not find Widget by widgetId %s", str);
        this.IHx.b(str2, false, "onTap fail: can not find Widget by widgetId ".concat(String.valueOf(str)), str);
        AppMethodBeat.o(116619);
    }

    @Override // com.tencent.mm.plugin.websearch.api.d
    public final void fXF() {
        this.IHw = false;
    }

    private void a(final View view, final View view2, final int i2, final int i3, final int i4, final int i5, final String str) {
        AppMethodBeat.i(116620);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(116602);
                Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "animating  size beginH %d, endH %d, beginW %d, endW %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
                if (i2 == i3 && i4 == i5) {
                    AppMethodBeat.o(116602);
                    return;
                }
                final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                final ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
                ofInt.setDuration(300L);
                ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass8.AnonymousClass1 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(116600);
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        layoutParams.height = intValue;
                        view.setLayoutParams(layoutParams);
                        layoutParams2.height = intValue;
                        view2.setLayoutParams(layoutParams2);
                        AppMethodBeat.o(116600);
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass8.AnonymousClass2 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(116601);
                        a.a(a.this, str, view);
                        AppMethodBeat.o(116601);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                ofInt.start();
                AppMethodBeat.o(116602);
            }
        });
        AppMethodBeat.o(116620);
    }

    static class b implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(116604);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("id");
            String string2 = bundle2.getString("srcAppid");
            u.a(string, bundle2.getInt("serviceType"), bundle2.getString("appid"), string2, bundle2.getInt("drawStrategy"));
            AppMethodBeat.o(116604);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.a$a  reason: collision with other inner class name */
    static class C1940a implements k<Bundle, Bundle> {
        private C1940a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            int i2;
            AppMethodBeat.i(116603);
            com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100266");
            if (Fu.isValid()) {
                i2 = Util.getInt(Fu.gzz().get("search_wa_widget_init_out_time"), TXRecordCommon.AUDIO_SAMPLERATE_8000);
            } else {
                i2 = 8000;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("search_wa_widget_init_out_time", i2);
            AppMethodBeat.o(116603);
            return bundle2;
        }
    }

    static class c implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        private c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
            AppMethodBeat.i(116605);
            Bundle bundle2 = bundle;
            ((j) com.tencent.mm.kernel.g.af(j.class)).lF(bundle2.getString("widgetId"), bundle2.getString("path"));
            AppMethodBeat.o(116605);
        }
    }

    static /* synthetic */ void a(a aVar, String str, int i2, t tVar) {
        AppMethodBeat.i(116621);
        Log.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "onSetWidgetSize widgetId %s, height %d", str, Integer.valueOf(i2));
        e eVar = aVar.IHt.get(str);
        Bundle bundle = new Bundle();
        if (eVar == null || (i2 <= eVar.IFS && i2 >= eVar.IIe)) {
            if (aVar.IHx != null) {
                aVar.IHx.ge(str, i2);
                if (tVar != null) {
                    bundle.putInt("errCode", 0);
                    tVar.b(true, "", bundle);
                    AppMethodBeat.o(116621);
                    return;
                }
            } else if (tVar != null) {
                bundle.putInt("errCode", -1);
                tVar.b(false, "jsapi is null", bundle);
            }
            AppMethodBeat.o(116621);
            return;
        }
        Log.w("MicroMsg.WebSearch.FTSSearchWidgetMgr", "invalid widget size, should in range %s", eVar.toString());
        if (tVar != null) {
            bundle.putInt("errCode", -2);
            tVar.b(false, "invalid widget size, should in range " + eVar.toString(), bundle);
        }
        AppMethodBeat.o(116621);
    }

    static /* synthetic */ void a(a aVar, final WidgetData widgetData, final String str, final String str2, final View view, final AbsoluteLayout absoluteLayout, final ThreeDotsLoadingView threeDotsLoadingView) {
        AppMethodBeat.i(116622);
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass5 */

            /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 174
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.widget.a.AnonymousClass5.run():void");
            }
        });
        AppMethodBeat.o(116622);
    }

    static /* synthetic */ void a(a aVar, final String str, final View view) {
        AppMethodBeat.i(116623);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(116593);
                try {
                    final Bitmap bitmapFromView = BitmapUtil.getBitmapFromView(view);
                    if (bitmapFromView != null) {
                        ThreadPool.post(new Runnable() {
                            /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(116592);
                                try {
                                    u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "saving widget preview", new Object[0]);
                                    String str = com.tencent.mm.vfs.aa.z(new o((com.tencent.mm.loader.j.b.aKC().replace("/data/user/0", "/data/data") + "/fts_cache") + FilePathGenerator.ANDROID_DIR_SEP, "widget_frame_" + str + "_" + System.currentTimeMillis()).her()) + ".jpg";
                                    BitmapUtil.saveBitmapToImage(bitmapFromView, 100, Bitmap.CompressFormat.JPEG, str, true);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("widgetId", str);
                                    bundle.putString("path", str);
                                    h.a(MainProcessIPCService.dkO, bundle, c.class, new com.tencent.mm.ipcinvoker.d<Bundle>() {
                                        /* class com.tencent.mm.plugin.websearch.widget.a.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.ipcinvoker.d
                                        public final /* bridge */ /* synthetic */ void bn(Bundle bundle) {
                                        }
                                    });
                                    AppMethodBeat.o(116592);
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", e2, "", new Object[0]);
                                    AppMethodBeat.o(116592);
                                }
                            }
                        }, "saveWidgetPreview");
                    }
                    AppMethodBeat.o(116593);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", th, "", new Object[0]);
                    AppMethodBeat.o(116593);
                }
            }
        });
        AppMethodBeat.o(116623);
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        AppMethodBeat.i(116624);
        com.tencent.mm.plugin.websearch.widget.c.a.b.a(str, aVar.IHx, str2, aVar.IHz);
        AppMethodBeat.o(116624);
    }

    static /* synthetic */ String c(a aVar, String str) {
        AppMethodBeat.i(116625);
        String str2 = aVar.IHq.get(str);
        AppMethodBeat.o(116625);
        return str2;
    }
}
