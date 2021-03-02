package com.tencent.mm.plugin.eggspring.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.eggspring.c;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\"\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0013H\u0014J\b\u0010$\u001a\u00020\u0013H\u0014J\b\u0010%\u001a\u00020\u0013H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "appForegroundLis", "Lcom/tencent/mm/app/IAppForegroundListener;", "clicked", "", "delayShowLoading", "Ljava/lang/Runnable;", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "luckyBagLoadingImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "luckyBagLoop", "rootLayout", "Landroid/view/ViewGroup;", "uiHandler", "Landroid/os/Handler;", "adjustCloseBtnColor", "", "color", "", "boundView", "finish", "getForceOrientation", "getLayoutId", "initBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onStop", "Companion", "plugin-eggspring_release"})
public final class SpringCardActivity extends MMActivity {
    public static final a qVs = new a((byte) 0);
    private Handler cPw;
    private boolean hau;
    private ViewGroup qVm;
    private MMAnimateView qVn;
    private MMAnimateView qVo;
    private o qVp;
    private q qVq;
    private final Runnable qVr = new c(this);

    static {
        AppMethodBeat.i(108208);
        AppMethodBeat.o(108208);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity$Companion;", "", "()V", "CARD_ANIM_DURATION", "", "FIREWORKS_NUM_EVERY_SIDE", "LOADING_ANIM_MAX_DURATION", "LOADING_ANIM_MIN_DURATION", "REQ_WEB_VIEW", "TAG", "", "blessing_btm_img", "blessing_top_img", "plugin-eggspring_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public SpringCardActivity() {
        AppMethodBeat.i(108207);
        AppMethodBeat.o(108207);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.byp;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ SpringCardActivity qVt;

        c(SpringCardActivity springCardActivity) {
            this.qVt = springCardActivity;
        }

        public final void run() {
            AppMethodBeat.i(194575);
            q qVar = this.qVt.qVq;
            if (qVar != null) {
                qVar.dismiss();
            }
            this.qVt.qVq = q.a(this.qVt, this.qVt.getString(R.string.bqo), true, 0, null);
            AppMethodBeat.o(194575);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(108179);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        this.cPw = new Handler(getMainLooper());
        setMMTitle("");
        setBackBtn(new d(this), R.raw.icons_outlined_close);
        AppCompatActivity context = getContext();
        p.g(context, "context");
        int color = context.getResources().getColor(R.color.a_2);
        setActionbarColor(color);
        if (ar.aln(color)) {
            updateBackBtn(ar.m(this, R.raw.icons_outlined_close, -1));
        } else {
            updateBackBtn(ar.m(this, R.raw.icons_outlined_close, WebView.NIGHT_MODE_COLOR));
        }
        hideActionbarLine();
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(2050);
        supportLightStatusBar();
        View findViewById = findViewById(R.id.h93);
        p.g(findViewById, "findViewById(R.id.root_layout)");
        this.qVm = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.exv);
        p.g(findViewById2, "findViewById(R.id.lucky_bag_loading_img)");
        this.qVn = (MMAnimateView) findViewById2;
        View findViewById3 = findViewById(R.id.exw);
        p.g(findViewById3, "findViewById(R.id.lucky_bag_loading_loop)");
        this.qVo = (MMAnimateView) findViewById3;
        b bVar = new b(this);
        MMAnimateView mMAnimateView = this.qVn;
        if (mMAnimateView == null) {
            p.btv("luckyBagLoadingImg");
        }
        mMAnimateView.setOnClickListener(bVar);
        MMAnimateView mMAnimateView2 = this.qVo;
        if (mMAnimateView2 == null) {
            p.btv("luckyBagLoop");
        }
        mMAnimateView2.setOnClickListener(bVar);
        this.qVp = new e();
        AppForegroundDelegate appForegroundDelegate = AppForegroundDelegate.INSTANCE;
        o oVar = this.qVp;
        if (oVar == null) {
            p.btv("appForegroundLis");
        }
        appForegroundDelegate.a(oVar);
        AppMethodBeat.o(108179);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "", "onAppForeground", "plugin-eggspring_release"})
    public static final class e implements o {
        e() {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(194576);
            Log.d("MicroMsg.SpringCardActivity", "onAppForeground");
            AppMethodBeat.o(194576);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(194577);
            Log.d("MicroMsg.SpringCardActivity", "onAppBackground");
            AppMethodBeat.o(194577);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getForceOrientation() {
        return 1;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ SpringCardActivity qVt;

        d(SpringCardActivity springCardActivity) {
            this.qVt = springCardActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(162211);
            this.qVt.finish();
            AppMethodBeat.o(162211);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ SpringCardActivity qVt;

        b(SpringCardActivity springCardActivity) {
            this.qVt = springCardActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(194574);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.SpringCardActivity", "onClick: " + this.qVt.hau);
            if (this.qVt.hau) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194574);
                return;
            }
            this.qVt.hau = true;
            com.tencent.mm.ac.d.C(this.qVt.qVr);
            com.tencent.mm.ac.d.a(1000, this.qVt.qVr);
            AppCompatActivity context = this.qVt.getContext();
            p.g(context, "context");
            int color = context.getResources().getColor(R.color.a_2);
            Intent intent = new Intent();
            intent.putExtra("customize_status_bar_color", color);
            intent.putExtra("webview_bg_color_rsID", R.color.a_2);
            intent.putExtra("from_shortcut", true);
            intent.putExtra("disable_minimize", true);
            intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
            intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
            com.tencent.mm.br.c.b(this.qVt, "webview", ".ui.tools.WebViewUI", intent, 1001);
            this.qVt.overridePendingTransition(R.anim.dq, R.anim.s);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194574);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(194578);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1001) {
            finish();
        }
        AppMethodBeat.o(194578);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(108181);
        super.onResume();
        Log.i("MicroMsg.SpringCardActivity", "onResume: ");
        c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
        com.tencent.mm.plugin.eggspring.c.cEH().FF(1);
        AppMethodBeat.o(108181);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(194579);
        super.onStop();
        Log.i("MicroMsg.SpringCardActivity", "onStop: " + this.hau);
        if (this.hau) {
            finish();
        }
        AppMethodBeat.o(194579);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(194580);
        q qVar = this.qVq;
        if (qVar != null) {
            qVar.dismiss();
        }
        super.finish();
        AppMethodBeat.o(194580);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(108183);
        super.onDestroy();
        Log.i("MicroMsg.SpringCardActivity", "onDestroy: ");
        c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
        com.tencent.mm.plugin.eggspring.c.cEH().FF(16);
        AppForegroundDelegate appForegroundDelegate = AppForegroundDelegate.INSTANCE;
        o oVar = this.qVp;
        if (oVar == null) {
            p.btv("appForegroundLis");
        }
        appForegroundDelegate.b(oVar);
        AppMethodBeat.o(108183);
    }
}
