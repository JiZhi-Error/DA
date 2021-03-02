package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.live.widget.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0014J\b\u0010\u0019\u001a\u00020\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "exception", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "faceVerifyUrl", "", "progressBar", "Landroid/widget/ProgressBar;", "finishWithoutTransition", "", "getLayoutId", "", "gotoFaceVerify", "verifyUrl", "initIntent", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderLivePostHelperUI extends MMFinderUI {
    public static final a vLa = new a((byte) 0);
    private HashMap _$_findViewCache;
    private ProgressBar progressBar;
    private f uho;
    private String vKZ = "";

    static {
        AppMethodBeat.i(252492);
        AppMethodBeat.o(252492);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252496);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252496);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252495);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252495);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "verify", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ String umU;
        final /* synthetic */ FinderLivePostHelperUI vLb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderLivePostHelperUI finderLivePostHelperUI, String str) {
            super(1);
            this.vLb = finderLivePostHelperUI;
            this.umU = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(252485);
            if (bool.booleanValue()) {
                FinderLivePostHelperUI.b(this.vLb).setVisibility(0);
                Intent intent = new Intent();
                intent.putExtra("open_custom_style_url", true);
                intent.putExtra("forceHideShare", true);
                intent.putExtra("show_native_web_view", true);
                intent.putExtra("rawUrl", this.umU);
                intent.putExtra("screen_orientation", 1);
                com.tencent.mm.br.c.b(this.vLb.getContext(), "webview", ".ui.tools.WebViewUI", intent, 10000);
            } else {
                this.vLb.setResult(-1, new Intent());
                FinderLivePostHelperUI.a(this.vLb);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252485);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ok", "", "invoke"})
    static final class c extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ FinderLivePostHelperUI vLb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLivePostHelperUI finderLivePostHelperUI) {
            super(1);
            this.vLb = finderLivePostHelperUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(252486);
            bool.booleanValue();
            this.vLb.setResult(-1);
            FinderLivePostHelperUI.a(this.vLb);
            x xVar = x.SXb;
            AppMethodBeat.o(252486);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderLivePostHelperUI finderLivePostHelperUI) {
        AppMethodBeat.i(252493);
        finderLivePostHelperUI.dzF();
        AppMethodBeat.o(252493);
    }

    public static final /* synthetic */ ProgressBar b(FinderLivePostHelperUI finderLivePostHelperUI) {
        AppMethodBeat.i(252494);
        ProgressBar progressBar2 = finderLivePostHelperUI.progressBar;
        if (progressBar2 == null) {
            p.btv("progressBar");
        }
        AppMethodBeat.o(252494);
        return progressBar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostHelperUI$Companion;", "", "()V", "DEFAULT", "", "ENTER_LIVE_FACE_VERIFY", "FACE_VERIFY", "FACE_VERIFY_OK", "FACE_VERIFY_RESULT", "", "FACE_VERIFY_URL", "LIVE_CANNOT_USE", "LIVE_FORBIDDEN", "LIVE_HELP_TYPE", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252487);
        super.onCreate(bundle);
        hideTitleView();
        View findViewById = findViewById(R.id.cwh);
        p.g(findViewById, "findViewById(R.id.finder_live_post_forbidden)");
        this.uho = new f(findViewById);
        View findViewById2 = findViewById(R.id.cr7);
        p.g(findViewById2, "findViewById(R.id.finder…per_loading_progress_bar)");
        this.progressBar = (ProgressBar) findViewById2;
        int intExtra = getIntent().getIntExtra("LIVE_HELP_TYPE", 0);
        Log.i("Finder.FinderLivePostHelperUI", "type:".concat(String.valueOf(intExtra)));
        switch (intExtra) {
            case 1:
                String stringExtra = getIntent().getStringExtra("FACE_VERIFY_URL");
                p.g(stringExtra, "intent.getStringExtra(FACE_VERIFY_URL)");
                this.vKZ = stringExtra;
                String str = this.vKZ;
                f fVar = this.uho;
                if (fVar == null) {
                    p.btv("exception");
                }
                f.c cVar = f.uGx;
                f.a(fVar, f.djF(), null, new b(this, str), 6);
                AppMethodBeat.o(252487);
                return;
            case 2:
            case 3:
                f fVar2 = this.uho;
                if (fVar2 == null) {
                    p.btv("exception");
                }
                f.c cVar2 = f.uGx;
                f.a(fVar2, f.djE(), null, new c(this), 6);
                break;
        }
        AppMethodBeat.o(252487);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(252488);
        super.onResume();
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            p.btv("progressBar");
        }
        progressBar2.setVisibility(8);
        AppMethodBeat.o(252488);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(252489);
        super.onPause();
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 == null) {
            p.btv("progressBar");
        }
        progressBar2.setVisibility(8);
        AppMethodBeat.o(252489);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.af5;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(252490);
        if (i2 == 10000) {
            Intent intent2 = new Intent();
            Bundle bundleExtra = intent != null ? intent.getBundleExtra("result_data") : null;
            if (i3 == -1 && bundleExtra != null) {
                String string = bundleExtra.getString("go_next", "");
                String string2 = bundleExtra.getString("result_json");
                if (!Util.isNullOrNil(string2)) {
                    int i4 = new i(string2).getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                    Log.i("Finder.FinderLivePostHelperUI", "onActivityResult, nextStep:" + string + ", code:" + i4);
                    if (p.j(string, "roomlive_verify") && i4 == 0) {
                        e aAh = g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_VERIFY_BOOLEAN_SYNC, Boolean.TRUE);
                        intent2.putExtra("FACE_VERIFY_RESULT", 1);
                    }
                }
            }
            setResult(-1, intent2);
            dzF();
        }
        AppMethodBeat.o(252490);
    }

    private final void dzF() {
        AppMethodBeat.i(252491);
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(252491);
    }
}
