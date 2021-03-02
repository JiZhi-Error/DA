package com.tencent.mm.plugin.websearch.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0014J\b\u0010!\u001a\u00020\u001cH\u0002J4\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0006H\u0002J\b\u0010(\u001a\u00020\u001cH\u0002J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "lastRequestSession", "", "getLastRequestSession", "()J", "setLastRequestSession", "(J)V", "mSessionId", "mSessionIdString", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "snsId", "snsImageDownloadListener", "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$snsImageDownloadListener$2$1", "getSnsImageDownloadListener", "()Lcom/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$snsImageDownloadListener$2$1;", "snsImageDownloadListener$delegate", "Lkotlin/Lazy;", "snsImagePath", "snsUsername", "type", "", "getLayoutId", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onError", "reportAction", NativeProtocol.WEB_DIALOG_ACTION, "imagePath", "sessionId", "cgiRet", AppMeasurement.Param.TIMESTAMP, "showLoading", "startImageSearch", "ui-websearch_release"})
public final class WebSearchSnsImageLoadingUI extends MMActivity {
    private cnb DIq;
    private String IDs = "";
    private String IGG = "";
    long IGI;
    private final kotlin.f IGQ = g.ah(new e(this));
    private final String TAG = "MicroMsg.WebSearch.WebSearchSnsImageLoadingUI";
    private String dHq = "";
    private String dRS = "";
    private long mSessionId;
    private int type;

    private final e.AnonymousClass1 fYK() {
        AppMethodBeat.i(198031);
        e.AnonymousClass1 r0 = (e.AnonymousClass1) this.IGQ.getValue();
        AppMethodBeat.o(198031);
        return r0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebSearchSnsImageLoadingUI() {
        AppMethodBeat.i(198038);
        AppMethodBeat.o(198038);
    }

    public static final /* synthetic */ void a(WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI, int i2, String str, String str2, int i3, long j2) {
        AppMethodBeat.i(198039);
        webSearchSnsImageLoadingUI.a(i2, str, str2, i3, j2);
        AppMethodBeat.o(198039);
    }

    public static final /* synthetic */ void f(WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI) {
        AppMethodBeat.i(198040);
        webSearchSnsImageLoadingUI.onError();
        AppMethodBeat.o(198040);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(198030);
        super.onCreate(bundle);
        this.mSessionId = getIntent().getLongExtra("key_session_id", 0);
        String stringExtra = getIntent().getStringExtra("key_sns_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.dRS = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("key_sns_username");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.IDs = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("key_sns_image_path");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.dHq = stringExtra3;
        this.type = getIntent().getIntExtra("key_scan_goods_request_type", 0);
        String GD = com.tencent.mm.plugin.fts.a.e.GD(this.mSessionId);
        p.g(GD, "FTSReportApiLogic.getUnsignedLong(mSessionId)");
        this.IGG = GD;
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_sns_media");
        if (byteArrayExtra != null) {
            cnb cnb = new cnb();
            try {
                cnb.parseFrom(byteArrayExtra);
            } catch (Exception e2) {
            }
            this.DIq = cnb;
        }
        setBackBtn(new a(this), R.raw.icons_outlined_close);
        setMMTitle("");
        if (s.YS(this.dHq)) {
            showLoading();
            aXp(this.dHq);
            ((Button) findViewById(R.id.c4l)).setOnClickListener(new b(this));
            AppMethodBeat.o(198030);
            return;
        }
        cnb cnb2 = this.DIq;
        if (cnb2 != null) {
            fYK().alive();
            showLoading();
            vr vrVar = new vr();
            vrVar.ebQ.ebR = cnb2;
            vrVar.ebQ.mediaId = cnb2.Id;
            vrVar.ebQ.dDe = 4;
            EventCenter.instance.publish(vrVar);
            AppMethodBeat.o(198030);
            return;
        }
        onError();
        AppMethodBeat.o(198030);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WebSearchSnsImageLoadingUI IGR;

        a(WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI) {
            this.IGR = webSearchSnsImageLoadingUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(198019);
            this.IGR.finish();
            WebSearchSnsImageLoadingUI.a(this.IGR, 11, "", this.IGR.IGG, 0, System.currentTimeMillis());
            AppMethodBeat.o(198019);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ WebSearchSnsImageLoadingUI IGR;

        b(WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI) {
            this.IGR = webSearchSnsImageLoadingUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(198020);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View findViewById = this.IGR.findViewById(R.id.epk);
            p.g(findViewById, "findViewById<MMAnimateView>(R.id.loading_iv)");
            ((MMAnimateView) findViewById).setVisibility(0);
            View findViewById2 = this.IGR.findViewById(R.id.epw);
            p.g(findViewById2, "findViewById<TextView>(R.id.loading_tv)");
            ((TextView) findViewById2).setVisibility(0);
            View findViewById3 = this.IGR.findViewById(R.id.c4s);
            p.g(findViewById3, "findViewById<TextView>(R.id.error_tv)");
            ((TextView) findViewById3).setVisibility(8);
            View findViewById4 = this.IGR.findViewById(R.id.c4l);
            p.g(findViewById4, "findViewById<Button>(R.id.error_btn)");
            ((Button) findViewById4).setVisibility(8);
            this.IGR.aXp(this.IGR.dHq);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198020);
        }
    }

    private final void showLoading() {
        AppMethodBeat.i(198032);
        if (ao.isDarkMode()) {
            ((MMAnimateView) findViewById(R.id.epk)).setImageResource(R.raw.websearch_dark_loading);
            AppMethodBeat.o(198032);
            return;
        }
        ((MMAnimateView) findViewById(R.id.epk)).setImageResource(R.raw.websearch_light_loading);
        AppMethodBeat.o(198032);
    }

    private final void onError() {
        AppMethodBeat.i(198033);
        View findViewById = findViewById(R.id.epk);
        p.g(findViewById, "findViewById<MMAnimateView>(R.id.loading_iv)");
        ((MMAnimateView) findViewById).setVisibility(8);
        View findViewById2 = findViewById(R.id.epw);
        p.g(findViewById2, "findViewById<TextView>(R.id.loading_tv)");
        ((TextView) findViewById2).setVisibility(8);
        View findViewById3 = findViewById(R.id.c4s);
        p.g(findViewById3, "findViewById<TextView>(R.id.error_tv)");
        ((TextView) findViewById3).setVisibility(8);
        View findViewById4 = findViewById(R.id.c4l);
        p.g(findViewById4, "findViewById<Button>(R.id.error_btn)");
        ((Button) findViewById4).setVisibility(8);
        View findViewById5 = findViewById(R.id.c6r);
        p.g(findViewById5, "findViewById<TextView>(R.id.expire_tv)");
        ((TextView) findViewById5).setVisibility(0);
        View findViewById6 = findViewById(R.id.c6q);
        p.g(findViewById6, "findViewById<Button>(R.id.expire_btn)");
        ((Button) findViewById6).setVisibility(0);
        ((Button) findViewById(R.id.c6q)).setOnClickListener(new c(this));
        AppMethodBeat.o(198033);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ WebSearchSnsImageLoadingUI IGR;

        c(WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI) {
            this.IGR = webSearchSnsImageLoadingUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(198021);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$onError$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.IGR.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$onError$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198021);
        }
    }

    public final void aXp(String str) {
        AppMethodBeat.i(198034);
        p.h(str, "imagePath");
        com.tencent.mm.plugin.scanner.api.e eVar = new com.tencent.mm.plugin.scanner.api.e();
        eVar.type = this.type;
        eVar.imagePath = str;
        eVar.mode = 4;
        eVar.CAU = new nd();
        eVar.CAU.KRN = ai.aft(0);
        chl clJ = ai.clJ();
        if (clJ != null) {
            eVar.CAV = new mu();
            eVar.CAV.dTj = clJ.LbC;
            eVar.CAV.latitude = clJ.LbD;
            eVar.CAV.KRb = (float) clJ.LuT;
            eVar.sessionId = this.mSessionId;
        }
        a(2, str, this.IGG, 0, System.currentTimeMillis());
        this.IGI = ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).a(eVar, new f(this, str));
        if (this.IGI != 0) {
            a(4, str, this.IGG, 0, System.currentTimeMillis());
        }
        AppMethodBeat.o(198034);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
    public static final class f implements com.tencent.mm.plugin.scanner.api.g {
        final /* synthetic */ WebSearchSnsImageLoadingUI IGR;
        final /* synthetic */ String lbx;

        f(WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI, String str) {
            this.IGR = webSearchSnsImageLoadingUI;
            this.lbx = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // com.tencent.mm.plugin.scanner.api.a
        public final /* synthetic */ void c(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            AppMethodBeat.i(198028);
            a(j2, fVar);
            AppMethodBeat.o(198028);
        }

        @Override // com.tencent.mm.plugin.scanner.api.g
        public final void a(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            AppMethodBeat.i(198029);
            p.h(fVar, "result");
            Log.i(this.IGR.TAG, "uploadImageForSearch callback %s filePath:%s isSucess:%b, session: %s", fVar.dDL, fVar.imagePath, Boolean.valueOf(fVar.success), Long.valueOf(j2));
            this.IGR.IGI = 0;
            if (fVar.success) {
                ag agVar = new ag();
                agVar.context = this.IGR;
                agVar.scene = 81;
                agVar.sessionId = this.IGR.IGG;
                agVar.IEk = true;
                if (fVar.jumpType == 3) {
                    agVar.query = fVar.CBa;
                    ((h) com.tencent.mm.kernel.g.af(h.class)).a(agVar);
                } else {
                    Map<String, String> map = agVar.dVU;
                    p.g(map, "params.extParams");
                    map.put("chatSearch", "2");
                    try {
                        Map<String, String> map2 = agVar.dVU;
                        p.g(map2, "params.extParams");
                        map2.put("reqKey", q.encode(fVar.dDL, "utf8"));
                    } catch (Exception e2) {
                    }
                    String str = "weixin://fts/image?path=" + s.k(fVar.imagePath, false);
                    try {
                        Map<String, String> map3 = agVar.dVU;
                        p.g(map3, "params.extParams");
                        map3.put("cacheImageSrc", q.encode(str, "utf8"));
                    } catch (Exception e3) {
                    }
                    agVar.IEl = true;
                    agVar.IEm = true;
                    agVar.IEn = 1;
                    agVar.statusBarColor = com.tencent.mm.cb.a.n(this.IGR, R.color.afz);
                    agVar.IEo = true;
                    ((h) com.tencent.mm.kernel.g.af(h.class)).a(agVar);
                    WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI = this.IGR;
                    String str2 = fVar.imagePath;
                    p.g(str2, "result.imagePath");
                    WebSearchSnsImageLoadingUI.a(webSearchSnsImageLoadingUI, 8, str2, this.IGR.IGG, 0, System.currentTimeMillis());
                }
                com.tencent.f.h.RTc.n(new Runnable(this) {
                    /* class com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.f.AnonymousClass1 */
                    final /* synthetic */ f IGU;

                    {
                        this.IGU = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(198026);
                        this.IGU.IGR.finish();
                        AppMethodBeat.o(198026);
                    }
                }, 500);
            } else {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.f.AnonymousClass2 */
                    final /* synthetic */ f IGU;

                    {
                        this.IGU = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(198027);
                        View findViewById = this.IGU.IGR.findViewById(R.id.epk);
                        p.g(findViewById, "findViewById<MMAnimateView>(R.id.loading_iv)");
                        ((MMAnimateView) findViewById).setVisibility(8);
                        View findViewById2 = this.IGU.IGR.findViewById(R.id.epw);
                        p.g(findViewById2, "findViewById<TextView>(R.id.loading_tv)");
                        ((TextView) findViewById2).setVisibility(8);
                        View findViewById3 = this.IGU.IGR.findViewById(R.id.c4s);
                        p.g(findViewById3, "findViewById<TextView>(R.id.error_tv)");
                        ((TextView) findViewById3).setVisibility(0);
                        View findViewById4 = this.IGU.IGR.findViewById(R.id.c4l);
                        p.g(findViewById4, "findViewById<TextView>(R.id.error_btn)");
                        ((TextView) findViewById4).setVisibility(0);
                        x xVar = x.SXb;
                        AppMethodBeat.o(198027);
                        return xVar;
                    }
                });
            }
            WebSearchSnsImageLoadingUI.a(this.IGR, 5, this.lbx, this.IGR.IGG, fVar.errCode, System.currentTimeMillis());
            AppMethodBeat.o(198029);
        }
    }

    private final void a(int i2, String str, String str2, int i3, long j2) {
        AppMethodBeat.i(198035);
        com.tencent.mm.ac.d.i(new d(this, i2, str2, str, i3, j2));
        AppMethodBeat.o(198035);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(198036);
        fYK().dead();
        if (this.IGI != 0) {
            ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).Ir(this.IGI);
        }
        super.onDestroy();
        AppMethodBeat.o(198036);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cbe;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(198037);
        super.onBackPressed();
        a(11, "", this.IGG, 0, System.currentTimeMillis());
        AppMethodBeat.o(198037);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<anonymous>", "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$snsImageDownloadListener$2$1", "invoke", "()Lcom/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$snsImageDownloadListener$2$1;"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<AnonymousClass1> {
        final /* synthetic */ WebSearchSnsImageLoadingUI IGR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI) {
            super(0);
            this.IGR = webSearchSnsImageLoadingUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AnonymousClass1 invoke() {
            AppMethodBeat.i(198025);
            AnonymousClass1 r0 = new IListener<vr>(this) {
                /* class com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.e.AnonymousClass1 */
                final /* synthetic */ e IGS;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.IGS = r1;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
                /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
                @Override // com.tencent.mm.sdk.event.IListener
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final /* synthetic */ boolean callback(com.tencent.mm.g.a.vr r6) {
                    /*
                        r5 = this;
                        r1 = 0
                        r4 = 198024(0x30588, float:2.77491E-40)
                        r2 = 0
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                        com.tencent.mm.g.a.vr r6 = (com.tencent.mm.g.a.vr) r6
                        if (r6 == 0) goto L_0x004b
                        com.tencent.mm.g.a.vr$a r0 = r6.ebQ
                        int r0 = r0.dDe
                        r3 = 5
                        if (r0 != r3) goto L_0x0051
                        com.tencent.mm.g.a.vr$a r0 = r6.ebQ
                        java.lang.String r3 = r0.mediaId
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI$e r0 = r5.IGS
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI r0 = r0.IGR
                        com.tencent.mm.protocal.protobuf.cnb r0 = com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.e(r0)
                        if (r0 == 0) goto L_0x004f
                        java.lang.String r0 = r0.Id
                    L_0x0023:
                        boolean r0 = kotlin.g.b.p.j(r3, r0)
                        if (r0 == 0) goto L_0x0051
                        r0 = 1
                    L_0x002a:
                        if (r0 == 0) goto L_0x0053
                    L_0x002c:
                        if (r6 == 0) goto L_0x004b
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI$e r0 = r5.IGS
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI r0 = r0.IGR
                        java.lang.String r0 = com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.b(r0)
                        boolean r0 = com.tencent.mm.vfs.s.YS(r0)
                        if (r0 == 0) goto L_0x0055
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI$e r0 = r5.IGS
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI r0 = r0.IGR
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI$e r1 = r5.IGS
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI r1 = r1.IGR
                        java.lang.String r1 = com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.b(r1)
                        r0.aXp(r1)
                    L_0x004b:
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                        return r2
                    L_0x004f:
                        r0 = r1
                        goto L_0x0023
                    L_0x0051:
                        r0 = r2
                        goto L_0x002a
                    L_0x0053:
                        r6 = r1
                        goto L_0x002c
                    L_0x0055:
                        com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI$e$1$a r0 = new com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI$e$1$a
                        r0.<init>(r5)
                        kotlin.g.a.a r0 = (kotlin.g.a.a) r0
                        com.tencent.mm.ac.d.h(r0)
                        goto L_0x004b
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI.e.AnonymousClass1.callback(com.tencent.mm.sdk.event.IEvent):boolean");
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/websearch/ui/WebSearchSnsImageLoadingUI$snsImageDownloadListener$2$1$callback$2$1"})
                /* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchSnsImageLoadingUI$e$1$a */
                static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                    final /* synthetic */ AnonymousClass1 IGT;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    a(AnonymousClass1 r2) {
                        super(0);
                        this.IGT = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(198023);
                        WebSearchSnsImageLoadingUI.f(this.IGT.IGS.IGR);
                        x xVar = x.SXb;
                        AppMethodBeat.o(198023);
                        return xVar;
                    }
                }
            };
            AppMethodBeat.o(198025);
            return r0;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ String $sessionId;
        final /* synthetic */ int IGK;
        final /* synthetic */ WebSearchSnsImageLoadingUI IGR;
        final /* synthetic */ int jAd;
        final /* synthetic */ long kPc;
        final /* synthetic */ String lbx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(WebSearchSnsImageLoadingUI webSearchSnsImageLoadingUI, int i2, String str, String str2, int i3, long j2) {
            super(0);
            this.IGR = webSearchSnsImageLoadingUI;
            this.jAd = i2;
            this.$sessionId = str;
            this.lbx = str2;
            this.IGK = i3;
            this.kPc = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(198022);
            int intExtra = this.IGR.getIntent().getIntExtra("key_source", 0);
            ab abVar = new ab();
            ab jK = abVar.m7if(this.IGR.dRS).jL(intExtra).jK(this.jAd);
            p.g(jK, "struct.setMsgId(snsId).s…source).setAction(action)");
            jK.jM(81);
            abVar.ig("");
            abVar.ih("");
            abVar.ie(this.$sessionId);
            abVar.ii(com.tencent.mm.b.g.getMD5(this.lbx));
            abVar.jO(this.IGK);
            abVar.bW(this.kPc);
            abVar.bfK();
            ar.a(abVar);
            x xVar = x.SXb;
            AppMethodBeat.o(198022);
            return xVar;
        }
    }
}
