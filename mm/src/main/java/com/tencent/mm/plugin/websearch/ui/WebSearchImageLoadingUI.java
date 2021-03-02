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
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.mu;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0017H\u0014J\b\u0010!\u001a\u00020\u0017H\u0002J4\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\tH\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u000bH\u0002J \u0010)\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "downloadImageCallback", "com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1", "Lcom/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1;", "imgLocalId", "", "isDownloading", "", "lastRequestSession", "getLastRequestSession", "()J", "setLastRequestSession", "(J)V", "mSessionId", "mSessionIdString", "msgId", "type", "", "cancelDownloadImage", "", "checkCanDownloadImage", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onError", "reportAction", NativeProtocol.WEB_DIALOG_ACTION, "imagePath", "sessionId", "cgiRet", AppMeasurement.Param.TIMESTAMP, "showLoading", "startImageSearch", "tryDownloadImage", "ui-websearch_release"})
public final class WebSearchImageLoadingUI extends MMActivity {
    private boolean Doc;
    private String IGG = "";
    private final a IGH = new a(this);
    long IGI;
    private final String TAG = "MicroMsg.WebSearch.WebSearchImageLoadingUI";
    private long hmj;
    private long mSessionId;
    private long msgId;
    private int type;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebSearchImageLoadingUI() {
        AppMethodBeat.i(198011);
        AppMethodBeat.o(198011);
    }

    public static final /* synthetic */ void a(WebSearchImageLoadingUI webSearchImageLoadingUI) {
        AppMethodBeat.i(198012);
        webSearchImageLoadingUI.fYJ();
        AppMethodBeat.o(198012);
    }

    public static final /* synthetic */ void a(WebSearchImageLoadingUI webSearchImageLoadingUI, int i2, String str, String str2, int i3, long j2) {
        AppMethodBeat.i(198013);
        webSearchImageLoadingUI.a(i2, str, str2, i3, j2);
        AppMethodBeat.o(198013);
    }

    public static final /* synthetic */ void a(WebSearchImageLoadingUI webSearchImageLoadingUI, long j2, int i2, String str) {
        AppMethodBeat.i(198014);
        webSearchImageLoadingUI.m(j2, i2, str);
        AppMethodBeat.o(198014);
    }

    public static final /* synthetic */ void h(WebSearchImageLoadingUI webSearchImageLoadingUI) {
        AppMethodBeat.i(198016);
        webSearchImageLoadingUI.onError();
        AppMethodBeat.o(198016);
    }

    public static final /* synthetic */ void i(WebSearchImageLoadingUI webSearchImageLoadingUI) {
        AppMethodBeat.i(198017);
        webSearchImageLoadingUI.showLoading();
        AppMethodBeat.o(198017);
    }

    public static final /* synthetic */ void j(WebSearchImageLoadingUI webSearchImageLoadingUI) {
        AppMethodBeat.i(198018);
        webSearchImageLoadingUI.yP(false);
        AppMethodBeat.o(198018);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JV\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JL\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0016"}, hxF = {"com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1", "Lcom/tencent/mm/modelimage/DownloadImgService$IOnImgTaskListener;", "onImgTaskCanceled", "", "imgLocalId", "", "msgLocalId", "compressType", "", "resId", "data", "", "onImgTaskEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onImgTaskProgress", "offset", "totalLen", "ui-websearch_release"})
    public static final class a implements e.a {
        final /* synthetic */ WebSearchImageLoadingUI IGJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(WebSearchImageLoadingUI webSearchImageLoadingUI) {
            this.IGJ = webSearchImageLoadingUI;
        }

        @Override // com.tencent.mm.av.e.a
        public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, q qVar) {
            AppMethodBeat.i(197988);
            Log.i(this.IGJ.TAG, "onImgTaskEnd msgId: %d, imgLocalId: %d, compressType: %d, errType %d, errCode: %d", Long.valueOf(j3), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5));
            this.IGJ.Doc = false;
            WebSearchImageLoadingUI.j(this.IGJ);
            AppMethodBeat.o(197988);
        }

        @Override // com.tencent.mm.av.e.a
        public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, q qVar) {
            AppMethodBeat.i(197989);
            Log.d(this.IGJ.TAG, "onImgTaskProgress msgId: %d, imgLocalId: %d, compressType: %d, offset: %d, totalLen: %d", Long.valueOf(j3), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5));
            AppMethodBeat.o(197989);
        }

        @Override // com.tencent.mm.av.e.a
        public final void a(long j2, long j3, int i2, int i3, Object obj) {
            AppMethodBeat.i(197990);
            Log.i(this.IGJ.TAG, "onImgTaskCanceled msgId: %d, imgLocalId: %d", Long.valueOf(j3), Long.valueOf(j2));
            this.IGJ.Doc = false;
            AppMethodBeat.o(197990);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(198001);
        super.onCreate(bundle);
        setBackBtn(new b(this), R.raw.icons_outlined_close);
        setMMTitle("");
        this.msgId = getIntent().getLongExtra("key_msg_id", 0);
        this.mSessionId = getIntent().getLongExtra("key_session_id", 0);
        this.type = getIntent().getIntExtra("key_scan_goods_request_type", 0);
        String GD = com.tencent.mm.plugin.fts.a.e.GD(this.mSessionId);
        p.g(GD, "FTSReportApiLogic.getUnsignedLong(mSessionId)");
        this.IGG = GD;
        yP(true);
        AppMethodBeat.o(198001);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WebSearchImageLoadingUI IGJ;

        b(WebSearchImageLoadingUI webSearchImageLoadingUI) {
            this.IGJ = webSearchImageLoadingUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(197991);
            WebSearchImageLoadingUI.a(this.IGJ);
            this.IGJ.finish();
            WebSearchImageLoadingUI.a(this.IGJ, 11, "", this.IGJ.IGG, 0, System.currentTimeMillis());
            AppMethodBeat.o(197991);
            return false;
        }
    }

    private final void yP(boolean z) {
        AppMethodBeat.i(198002);
        if (this.msgId == 0) {
            onError();
            AppMethodBeat.o(198002);
            return;
        }
        String Iq = ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).Iq(this.msgId);
        if (s.YS(Iq)) {
            showLoading();
            long j2 = this.msgId;
            int i2 = this.type;
            p.g(Iq, "imagePath");
            m(j2, i2, Iq);
            ((Button) findViewById(R.id.c4l)).setOnClickListener(new e(this, Iq));
            AppMethodBeat.o(198002);
        } else if (z) {
            Ma(this.msgId);
            AppMethodBeat.o(198002);
        } else {
            onError();
            AppMethodBeat.o(198002);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ WebSearchImageLoadingUI IGJ;
        final /* synthetic */ String lbx;

        e(WebSearchImageLoadingUI webSearchImageLoadingUI, String str) {
            this.IGJ = webSearchImageLoadingUI;
            this.lbx = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(197994);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$startImageSearch$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View findViewById = this.IGJ.findViewById(R.id.epk);
            p.g(findViewById, "findViewById<MMAnimateView>(R.id.loading_iv)");
            ((MMAnimateView) findViewById).setVisibility(0);
            View findViewById2 = this.IGJ.findViewById(R.id.epw);
            p.g(findViewById2, "findViewById<TextView>(R.id.loading_tv)");
            ((TextView) findViewById2).setVisibility(0);
            View findViewById3 = this.IGJ.findViewById(R.id.c4s);
            p.g(findViewById3, "findViewById<TextView>(R.id.error_tv)");
            ((TextView) findViewById3).setVisibility(8);
            View findViewById4 = this.IGJ.findViewById(R.id.c4l);
            p.g(findViewById4, "findViewById<Button>(R.id.error_btn)");
            ((Button) findViewById4).setVisibility(8);
            WebSearchImageLoadingUI webSearchImageLoadingUI = this.IGJ;
            long j2 = this.IGJ.msgId;
            int i2 = this.IGJ.type;
            String str = this.lbx;
            p.g(str, "imagePath");
            WebSearchImageLoadingUI.a(webSearchImageLoadingUI, j2, i2, str);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$startImageSearch$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(197994);
        }
    }

    private final void showLoading() {
        AppMethodBeat.i(198003);
        if (ao.isDarkMode()) {
            ((MMAnimateView) findViewById(R.id.epk)).setImageResource(R.raw.websearch_dark_loading);
            AppMethodBeat.o(198003);
            return;
        }
        ((MMAnimateView) findViewById(R.id.epk)).setImageResource(R.raw.websearch_light_loading);
        AppMethodBeat.o(198003);
    }

    private final void onError() {
        AppMethodBeat.i(198004);
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
        AppMethodBeat.o(198004);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ WebSearchImageLoadingUI IGJ;

        c(WebSearchImageLoadingUI webSearchImageLoadingUI) {
            this.IGJ = webSearchImageLoadingUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(197992);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$onError$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.IGJ.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$onError$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(197992);
        }
    }

    private final void m(long j2, int i2, String str) {
        AppMethodBeat.i(198005);
        com.tencent.mm.plugin.scanner.api.e eVar = new com.tencent.mm.plugin.scanner.api.e();
        eVar.msgId = j2;
        eVar.sessionId = this.mSessionId;
        eVar.type = i2;
        eVar.mode = 4;
        eVar.CAU = new nd();
        eVar.CAU.KRN = ai.aft(0);
        chl clJ = ai.clJ();
        if (clJ != null) {
            eVar.CAV = new mu();
            eVar.CAV.dTj = clJ.LbC;
            eVar.CAV.latitude = clJ.LbD;
            eVar.CAV.KRb = (float) clJ.LuT;
        }
        a(2, str, this.IGG, 0, System.currentTimeMillis());
        this.IGI = ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).a(eVar, new f(this, str));
        if (this.IGI != 0) {
            a(4, str, this.IGG, 0, System.currentTimeMillis());
        }
        AppMethodBeat.o(198005);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
    public static final class f implements com.tencent.mm.plugin.scanner.api.g {
        final /* synthetic */ WebSearchImageLoadingUI IGJ;
        final /* synthetic */ String lbx;

        f(WebSearchImageLoadingUI webSearchImageLoadingUI, String str) {
            this.IGJ = webSearchImageLoadingUI;
            this.lbx = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // com.tencent.mm.plugin.scanner.api.a
        public final /* synthetic */ void c(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            AppMethodBeat.i(197997);
            a(j2, fVar);
            AppMethodBeat.o(197997);
        }

        @Override // com.tencent.mm.plugin.scanner.api.g
        public final void a(long j2, com.tencent.mm.plugin.scanner.api.f fVar) {
            AppMethodBeat.i(197998);
            p.h(fVar, "result");
            Log.i(this.IGJ.TAG, "uploadImageForSearch callback %s filePath:%s isSucess:%b, session: %s, %s", fVar.dDL, fVar.imagePath, Boolean.valueOf(fVar.success), Long.valueOf(j2), com.tencent.mm.plugin.fts.a.e.GD(j2));
            this.IGJ.IGI = 0;
            if (fVar.success) {
                if (fVar.jumpType == 3) {
                    ag agVar = new ag();
                    agVar.context = this.IGJ;
                    agVar.scene = 67;
                    agVar.query = fVar.CBa;
                    agVar.sessionId = this.IGJ.IGG;
                    agVar.IEk = true;
                    ((h) com.tencent.mm.kernel.g.af(h.class)).a(agVar);
                } else {
                    ag agVar2 = new ag();
                    agVar2.context = this.IGJ;
                    agVar2.scene = 67;
                    agVar2.query = "";
                    agVar2.sessionId = this.IGJ.IGG;
                    agVar2.IEk = true;
                    agVar2.IEl = true;
                    agVar2.IEm = true;
                    agVar2.IEn = 1;
                    agVar2.statusBarColor = com.tencent.mm.cb.a.n(this.IGJ, R.color.afz);
                    agVar2.IEo = true;
                    Map<String, String> map = agVar2.dVU;
                    p.g(map, "params.extParams");
                    map.put("chatSearch", "2");
                    try {
                        Map<String, String> map2 = agVar2.dVU;
                        p.g(map2, "params.extParams");
                        map2.put("reqKey", com.tencent.mm.compatible.util.q.encode(fVar.dDL, "utf8"));
                    } catch (Exception e2) {
                    }
                    String str = "weixin://fts/image?path=" + s.k(fVar.imagePath, false);
                    try {
                        Map<String, String> map3 = agVar2.dVU;
                        p.g(map3, "params.extParams");
                        map3.put("cacheImageSrc", com.tencent.mm.compatible.util.q.encode(str, "utf8"));
                    } catch (Exception e3) {
                    }
                    ((h) com.tencent.mm.kernel.g.af(h.class)).a(agVar2);
                    WebSearchImageLoadingUI webSearchImageLoadingUI = this.IGJ;
                    String str2 = fVar.imagePath;
                    p.g(str2, "result.imagePath");
                    WebSearchImageLoadingUI.a(webSearchImageLoadingUI, 8, str2, this.IGJ.IGG, 0, System.currentTimeMillis());
                }
                com.tencent.f.h.RTc.n(new Runnable(this) {
                    /* class com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI.f.AnonymousClass1 */
                    final /* synthetic */ f IGL;

                    {
                        this.IGL = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(197995);
                        this.IGL.IGJ.finish();
                        AppMethodBeat.o(197995);
                    }
                }, 500);
            } else {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI.f.AnonymousClass2 */
                    final /* synthetic */ f IGL;

                    {
                        this.IGL = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(197996);
                        View findViewById = this.IGL.IGJ.findViewById(R.id.epk);
                        p.g(findViewById, "findViewById<MMAnimateView>(R.id.loading_iv)");
                        ((MMAnimateView) findViewById).setVisibility(8);
                        View findViewById2 = this.IGL.IGJ.findViewById(R.id.epw);
                        p.g(findViewById2, "findViewById<TextView>(R.id.loading_tv)");
                        ((TextView) findViewById2).setVisibility(8);
                        View findViewById3 = this.IGL.IGJ.findViewById(R.id.c4s);
                        p.g(findViewById3, "findViewById<TextView>(R.id.error_tv)");
                        ((TextView) findViewById3).setVisibility(0);
                        View findViewById4 = this.IGL.IGJ.findViewById(R.id.c4l);
                        p.g(findViewById4, "findViewById<TextView>(R.id.error_btn)");
                        ((TextView) findViewById4).setVisibility(0);
                        x xVar = x.SXb;
                        AppMethodBeat.o(197996);
                        return xVar;
                    }
                });
            }
            WebSearchImageLoadingUI.a(this.IGJ, 5, this.lbx, this.IGJ.IGG, fVar.errCode, System.currentTimeMillis());
            AppMethodBeat.o(197998);
        }
    }

    private final void a(int i2, String str, String str2, int i3, long j2) {
        AppMethodBeat.i(198006);
        com.tencent.mm.ac.d.i(new d(this, str, i2, str2, i3, j2));
        AppMethodBeat.o(198006);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(198007);
        if (this.IGI != 0) {
            ((com.tencent.mm.plugin.scanner.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.scanner.api.c.class)).Ir(this.IGI);
        }
        super.onDestroy();
        AppMethodBeat.o(198007);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.cbe;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(198008);
        super.onBackPressed();
        fYJ();
        a(11, "", this.IGG, 0, System.currentTimeMillis());
        AppMethodBeat.o(198008);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ WebSearchImageLoadingUI IGJ;
        final /* synthetic */ long pwg;

        g(WebSearchImageLoadingUI webSearchImageLoadingUI, long j2) {
            this.IGJ = webSearchImageLoadingUI;
            this.pwg = j2;
        }

        public final void run() {
            AppMethodBeat.i(198000);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().Hb(this.pwg);
            boolean aQ = WebSearchImageLoadingUI.aQ(Hb);
            Log.i(this.IGJ.TAG, "tryDownloadImage msgId: %s, msgSvrId: %s, talker: %s, canDownload: %b", Long.valueOf(this.pwg), Long.valueOf(Hb.ajM()), Hb.ajO(), Boolean.valueOf(aQ));
            if (aQ) {
                com.tencent.mm.av.g G = com.tencent.mm.av.q.bcR().G(Hb.ajO(), Hb.ajM());
                this.IGJ.hmj = G.getLocalId();
                if (com.tencent.mm.av.q.bcS().a(this.IGJ.hmj, this.pwg, 0, Long.valueOf(this.pwg), R.drawable.c3h, this.IGJ.IGH, 0, true) != 0) {
                    WebSearchImageLoadingUI.h(this.IGJ);
                    AppMethodBeat.o(198000);
                    return;
                }
                this.IGJ.Doc = true;
                com.tencent.f.h.RTc.aV(new Runnable(this) {
                    /* class com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI.g.AnonymousClass1 */
                    final /* synthetic */ g IGM;

                    {
                        this.IGM = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(197999);
                        WebSearchImageLoadingUI.i(this.IGM.IGJ);
                        AppMethodBeat.o(197999);
                    }
                });
            }
            AppMethodBeat.o(198000);
        }
    }

    private final void Ma(long j2) {
        AppMethodBeat.i(198009);
        com.tencent.f.h.RTc.aZ(new g(this, j2));
        AppMethodBeat.o(198009);
    }

    private final void fYJ() {
        AppMethodBeat.i(198010);
        Log.i(this.TAG, "cancelDownloadImage isDownloading: %b, imgLocalId: %d, msgId: %d", Boolean.valueOf(this.Doc), Long.valueOf(this.hmj), Long.valueOf(this.msgId));
        if (this.Doc || this.hmj != 0) {
            com.tencent.mm.av.q.bcS().a(this.hmj, this.msgId, 0, this.IGH);
        }
        AppMethodBeat.o(198010);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ String $sessionId;
        final /* synthetic */ WebSearchImageLoadingUI IGJ;
        final /* synthetic */ int IGK;
        final /* synthetic */ int jAd;
        final /* synthetic */ long kPc;
        final /* synthetic */ String lbx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(WebSearchImageLoadingUI webSearchImageLoadingUI, String str, int i2, String str2, int i3, long j2) {
            super(0);
            this.IGJ = webSearchImageLoadingUI;
            this.lbx = str;
            this.jAd = i2;
            this.$sessionId = str2;
            this.IGK = i3;
            this.kPc = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(197993);
            String str = this.lbx;
            long longExtra = this.IGJ.getIntent().getLongExtra("key_msg_id", 0);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().Hb(longExtra);
            p.g(Hb, "MMKernel.service(IMessen…msgInfoStg.getById(msgId)");
            ab abVar = new ab();
            ab jK = abVar.m7if(String.valueOf(Hb.ajM())).jL(this.IGJ.getIntent().getIntExtra("key_source", 0)).jK(this.jAd);
            p.g(jK, "struct.setMsgId(msg.msgS…CE, 0)).setAction(action)");
            jK.jM(67);
            abVar.ig("");
            abVar.ih("");
            if (com.tencent.mm.model.ab.Eq(Hb.ajO())) {
                abVar.jN(2);
            } else {
                abVar.jN(1);
            }
            abVar.ie(this.$sessionId);
            abVar.ii(com.tencent.mm.b.g.getMD5(str));
            abVar.jO(this.IGK);
            abVar.bW(this.kPc);
            abVar.bfK();
            ar.a(abVar);
            x xVar = x.SXb;
            AppMethodBeat.o(197993);
            return xVar;
        }
    }

    public static final /* synthetic */ boolean aQ(ca caVar) {
        AppMethodBeat.i(198015);
        if (caVar == null) {
            AppMethodBeat.o(198015);
            return false;
        }
        if (caVar.ajN() == 1) {
            if (caVar.gDB()) {
                AppMethodBeat.o(198015);
                return false;
            }
        } else if (caVar.gDB()) {
            AppMethodBeat.o(198015);
            return false;
        }
        AppMethodBeat.o(198015);
        return true;
    }
}
