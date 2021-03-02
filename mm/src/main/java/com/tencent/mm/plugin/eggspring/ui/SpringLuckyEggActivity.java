package com.tencent.mm.plugin.eggspring.ui;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.StateSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.eggspring.c;
import com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggViewModel;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.WebView;
import kotlin.ResultKt;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.ba;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0013H\u0014J\b\u0010'\u001a\u00020\u0013H\u0014J\b\u0010(\u001a\u00020\u0013H\u0014J\u0012\u0010)\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u001c\u0010,\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u001b2\b\b\u0001\u0010-\u001a\u00020\u0018H\u0002J\u0018\u0010.\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\u0013H\u0002J\b\u00103\u001a\u00020\u0013H\u0002J9\u00104\u001a\u00020\u0013\"\u0004\b\u0000\u00105*\b\u0012\u0004\u0012\u0002H5062\u0006\u00107\u001a\u0002082\u0016\b\u0004\u00109\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H5\u0012\u0004\u0012\u00020\u00130:H\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R!\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "startTime", "", "videoController", "Lcom/tencent/mm/plugin/eggspring/ui/VideoController;", "viewBinding", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewBinding;", "viewModel", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "viewModel$annotations", "getViewModel", "()Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "animateCardToShow", "", "bindViewModel", "createShapeDrawable", "Landroid/graphics/drawable/Drawable;", "color", "", "getLayoutId", "getSavePath", "", "url", "makeButtonBackground", "normalColor", "makeStatefulBottomTextColor", "Landroid/content/res/ColorStateList;", "alpha", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "redirect", "target", "", "safeColor", "fallback", "setCoverImage", "vertical", "", "setupBars", "setupViews", "setupWindow", "observe", "T", "Landroid/arch/lifecycle/LiveData;", "owner", "Landroid/arch/lifecycle/LifecycleOwner;", "observer", "Lkotlin/Function1;", "Companion", "plugin-eggspring_release"})
public final class SpringLuckyEggActivity extends MMActivity {
    public static final a qVx = new a((byte) 0);
    private final ai qUR = aj.hMI();
    private final kotlin.f qVu = kotlin.g.ah(new n(this));
    private c qVv;
    private d qVw;
    private long startTime;

    static {
        AppMethodBeat.i(194613);
        AppMethodBeat.o(194613);
    }

    private final SpringLuckyEggViewModel cEJ() {
        AppMethodBeat.i(194604);
        SpringLuckyEggViewModel springLuckyEggViewModel = (SpringLuckyEggViewModel) this.qVu.getValue();
        AppMethodBeat.o(194604);
        return springLuckyEggViewModel;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SpringLuckyEggActivity() {
        AppMethodBeat.i(194612);
        AppMethodBeat.o(194612);
    }

    public static final /* synthetic */ int a(SpringLuckyEggActivity springLuckyEggActivity, String str, int i2) {
        AppMethodBeat.i(194617);
        int da = springLuckyEggActivity.da(str, i2);
        AppMethodBeat.o(194617);
        return da;
    }

    public static final /* synthetic */ c a(SpringLuckyEggActivity springLuckyEggActivity) {
        AppMethodBeat.i(194614);
        c cVar = springLuckyEggActivity.qVv;
        if (cVar == null) {
            p.btv("viewBinding");
        }
        AppMethodBeat.o(194614);
        return cVar;
    }

    public static final /* synthetic */ SpringLuckyEggViewModel b(SpringLuckyEggActivity springLuckyEggActivity) {
        AppMethodBeat.i(194615);
        SpringLuckyEggViewModel cEJ = springLuckyEggActivity.cEJ();
        AppMethodBeat.o(194615);
        return cEJ;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.byq;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(194605);
        super.onCreate(bundle);
        this.startTime = Util.nowMilliSecond();
        c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
        com.tencent.mm.plugin.eggspring.c.qUN.appId = getIntent().getStringExtra("app_id");
        c.a aVar2 = com.tencent.mm.plugin.eggspring.c.qUO;
        com.tencent.mm.plugin.eggspring.c.qUN.FF(1);
        setMMTitle("");
        setBackBtn(new j(this), R.raw.icons_outlined_close);
        hideActionbarLine();
        getWindow().addFlags(128);
        getWindow().clearFlags(67108864);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1792);
        getWindow().addFlags(Integer.MIN_VALUE);
        setActionbarColor(0);
        Window window2 = getWindow();
        p.g(window2, "window");
        window2.setStatusBarColor(0);
        Window window3 = getWindow();
        p.g(window3, "window");
        window3.setNavigationBarColor(0);
        getWindow().setFormat(-3);
        View findViewById = findViewById(R.id.h8v);
        p.g(findViewById, "findViewById(R.id.root)");
        View findViewById2 = findViewById(R.id.ep8);
        p.g(findViewById2, "findViewById(R.id.loading_animator)");
        View findViewById3 = findViewById(R.id.aaa);
        p.g(findViewById3, "findViewById(R.id.bottom…itle_clickable_indicator)");
        View findViewById4 = findViewById(R.id.aa_);
        p.g(findViewById4, "findViewById(R.id.bottom_brand_title)");
        View findViewById5 = findViewById(R.id.aa9);
        p.g(findViewById5, "findViewById(R.id.bottom_brand_subtitle)");
        View findViewById6 = findViewById(R.id.aa6);
        p.g(findViewById6, "findViewById(R.id.bottom_background_image)");
        View findViewById7 = findViewById(R.id.aov);
        p.g(findViewById7, "findViewById(R.id.card_root)");
        View findViewById8 = findViewById(R.id.ake);
        p.g(findViewById8, "findViewById(R.id.card_bag_container)");
        View findViewById9 = findViewById(R.id.akt);
        p.g(findViewById9, "findViewById(R.id.card_brand_logo)");
        View findViewById10 = findViewById(R.id.aku);
        p.g(findViewById10, "findViewById(R.id.card_brand_name)");
        TextView textView = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.aki);
        p.g(findViewById11, "findViewById(R.id.card_bag_title)");
        View findViewById12 = findViewById(R.id.akh);
        p.g(findViewById12, "findViewById(R.id.card_bag_subtitle)");
        View findViewById13 = findViewById(R.id.akd);
        p.g(findViewById13, "findViewById(R.id.card_bag_accept_btn)");
        View findViewById14 = findViewById(R.id.akf);
        p.g(findViewById14, "findViewById(R.id.card_bag_cover)");
        View findViewById15 = findViewById(R.id.akg);
        p.g(findViewById15, "findViewById(R.id.card_bag_media_container)");
        View findViewById16 = findViewById(R.id.bh1);
        p.g(findViewById16, "findViewById(R.id.cover_container)");
        View findViewById17 = findViewById(R.id.fjj);
        p.g(findViewById17, "findViewById(R.id.money_value)");
        View findViewById18 = findViewById(R.id.fjc);
        p.g(findViewById18, "findViewById(R.id.money_container)");
        View findViewById19 = findViewById(R.id.akj);
        p.g(findViewById19, "findViewById(R.id.card_bag_video)");
        View findViewById20 = findViewById(R.id.akk);
        p.g(findViewById20, "findViewById(R.id.card_bag_volume_switch)");
        this.qVv = new c((ViewGroup) findViewById, (MMAnimateView) findViewById2, (WeImageView) findViewById3, (TextView) findViewById4, (TextView) findViewById5, (ImageView) findViewById6, textView, (MMAnimateView) findViewById9, (ViewGroup) findViewById7, (ViewGroup) findViewById8, (TextView) findViewById11, (TextView) findViewById12, (Button) findViewById13, (ViewGroup) findViewById15, (MMAnimateView) findViewById14, (ViewGroup) findViewById16, (TextView) findViewById17, (ViewGroup) findViewById18, (SpringEggVideoView) findViewById19, (WeImageView) findViewById20);
        c cVar = this.qVv;
        if (cVar == null) {
            p.btv("viewBinding");
        }
        cVar.hwr.getViewTreeObserver().addOnGlobalLayoutListener(new k(this));
        if (s.YS(PluginEggSpring.qUG)) {
            c cVar2 = this.qVv;
            if (cVar2 == null) {
                p.btv("viewBinding");
            }
            cVar2.qVF.setImageFilePath(PluginEggSpring.qUG);
        } else {
            c cVar3 = this.qVv;
            if (cVar3 == null) {
                p.btv("viewBinding");
            }
            cVar3.qVF.setImageResource(R.drawable.cav);
        }
        c cVar4 = this.qVv;
        if (cVar4 == null) {
            p.btv("viewBinding");
        }
        cVar4.qVO.setOnClickListener(new l(this));
        findViewById(R.id.aab).setOnClickListener(new m(this));
        cEJ().qVY.observe(this, new c(this));
        cEJ().qVW.observe(this, new d(this));
        cEJ().qWb.observe(this, new e(this));
        cEJ().qWc.observe(this, new f(this));
        cEJ().qVX.observe(this, new g(this));
        cEJ().qWd.observe(this, new h(this));
        AppMethodBeat.o(194605);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class j implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        j(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(194598);
            this.qVy.finish();
            AppMethodBeat.o(194598);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-eggspring_release"})
    public static final class k implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(194599);
            SpringLuckyEggActivity.a(this.qVy).hwr.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int statusBarHeight = com.tencent.mm.compatible.util.n.getStatusBarHeight(this.qVy.getContext());
            int E = com.tencent.mm.cb.a.E(this.qVy.getContext(), SpringLuckyEggActivity.a(this.qVy).hwr.getMeasuredHeight() + statusBarHeight);
            if (E > 812) {
                ViewGroup.LayoutParams layoutParams = SpringLuckyEggActivity.a(this.qVy).qVL.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(194599);
                    throw tVar;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) this.qVy.getContext(), ((E - 812) / 2) + 128) - statusBarHeight;
                SpringLuckyEggActivity.a(this.qVy).qVL.requestLayout();
            }
            AppMethodBeat.o(194599);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        l(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(194600);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (a.c(SpringLuckyEggActivity.b(this.qVy).qWb.getValue())) {
                c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
                com.tencent.mm.plugin.eggspring.c.qUN.FF(11);
            } else if (a.d(SpringLuckyEggActivity.b(this.qVy).qWb.getValue())) {
                c.a aVar2 = com.tencent.mm.plugin.eggspring.c.qUO;
                com.tencent.mm.plugin.eggspring.c.qUN.FF(20);
            }
            SpringLuckyEggActivity.a(this.qVy, SpringLuckyEggActivity.b(this.qVy).qWa.getValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194600);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        m(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(194601);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.SpringLuckyEggActivity", "clicked bottom title");
            if (SpringLuckyEggActivity.b(this.qVy).qVZ.getValue() == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(194601);
                return;
            }
            SpringLuckyEggActivity.a(this.qVy, SpringLuckyEggActivity.b(this.qVy).qVZ.getValue());
            c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
            com.tencent.mm.plugin.eggspring.c.qUN.FF(10);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$setupViews$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194601);
        }
    }

    private final Drawable FG(int i2) {
        AppMethodBeat.i(194607);
        PaintDrawable paintDrawable = new PaintDrawable(i2);
        paintDrawable.setCornerRadius((float) com.tencent.mm.cb.a.fromDPToPix((Context) this, 4.0f));
        PaintDrawable paintDrawable2 = paintDrawable;
        AppMethodBeat.o(194607);
        return paintDrawable2;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\b2,\u0010\t\u001a(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u000b0\u000b \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\nH\n¢\u0006\u0004\b\f\u0010\r"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "<anonymous parameter 3>", "", "", "onImageLoadComplete", "(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;[Ljava/lang/Object;)V"})
    public static final class i implements com.tencent.mm.av.a.c.k {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        i(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        @Override // com.tencent.mm.av.a.c.k
        public final void a(String str, View view, Bitmap bitmap, Object[] objArr) {
            com.tencent.mm.bb.k value;
            AppMethodBeat.i(194597);
            if (bitmap == null && (value = SpringLuckyEggActivity.b(this.qVy).qWc.getValue()) != null) {
                String str2 = value.jhl;
                if (!(str2 == null || str2.length() == 0)) {
                    String str3 = (com.tencent.mm.plugin.emoji.e.h.getDataEmojiPath() + "/egg/") + '/' + value.jhl;
                    if (s.YS(str3)) {
                        SpringLuckyEggActivity.a(this.qVy).qVQ.setImageFilePath(str3);
                    }
                }
            }
            AppMethodBeat.o(194597);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$animateCardToShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-eggspring_release"})
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ SpringLuckyEggActivity qVy;
        final /* synthetic */ long qVz;

        b(SpringLuckyEggActivity springLuckyEggActivity, long j2) {
            this.qVy = springLuckyEggActivity;
            this.qVz = j2;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            boolean z;
            String str;
            boolean z2;
            AppMethodBeat.i(194582);
            Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationEnd");
            SpringLuckyEggActivity.a(this.qVy).qVF.setVisibility(8);
            SpringLuckyEggActivity.a(this.qVy).qVF.stop();
            SpringLuckyEggActivity.a(this.qVy).qVF.setVisibility(8);
            com.tencent.mm.t.a.j value = SpringLuckyEggActivity.b(this.qVy).qWb.getValue();
            if (a.a(value)) {
                c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
                com.tencent.mm.plugin.eggspring.c.qUN.FF(4);
            } else if (a.c(value)) {
                c.a aVar2 = com.tencent.mm.plugin.eggspring.c.qUO;
                com.tencent.mm.plugin.eggspring.c.qUN.FF(3);
            } else if (a.d(value)) {
                c.a aVar3 = com.tencent.mm.plugin.eggspring.c.qUO;
                com.tencent.mm.plugin.eggspring.c.qUN.FF(19);
            } else {
                if (value == null || value.gTr != 5) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (value != null && value.gTz == 2) {
                        c.a aVar4 = com.tencent.mm.plugin.eggspring.c.qUO;
                        com.tencent.mm.plugin.eggspring.c.qUN.FF(5);
                    } else if (value != null && value.gTz == 1) {
                        c.a aVar5 = com.tencent.mm.plugin.eggspring.c.qUO;
                        com.tencent.mm.plugin.eggspring.c.qUN.FF(7);
                    }
                } else if (a.b(value)) {
                    c.a aVar6 = com.tencent.mm.plugin.eggspring.c.qUO;
                    com.tencent.mm.plugin.eggspring.c.qUN.FF(21);
                }
            }
            if (!(value == null || (str = value.gTw) == null)) {
                if (str.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    SpringLuckyEggActivity.a(this.qVy).qVH.setText(str);
                }
            }
            if (SpringLuckyEggActivity.b(this.qVy).qVZ.getValue() != null) {
                SpringLuckyEggActivity.a(this.qVy).qVG.setVisibility(0);
                c.a aVar7 = com.tencent.mm.plugin.eggspring.c.qUO;
                com.tencent.mm.plugin.eggspring.c.qUN.FF(2);
                AppMethodBeat.o(194582);
                return;
            }
            SpringLuckyEggActivity.a(this.qVy).qVG.setVisibility(4);
            AppMethodBeat.o(194582);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(194583);
            Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationCancel");
            SpringLuckyEggActivity.a(this.qVy).qVF.setVisibility(8);
            SpringLuckyEggActivity.a(this.qVy).qVF.stop();
            SpringLuckyEggActivity.a(this.qVy).qVF.setVisibility(8);
            AppMethodBeat.o(194583);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(194584);
            Log.d("MicroMsg.SpringLuckyEggActivity", "onAnimationStart");
            SpringLuckyEggActivity.a(this.qVy).qVM.setVisibility(0);
            c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
            com.tencent.mm.plugin.eggspring.c cVar = com.tencent.mm.plugin.eggspring.c.qUN;
            long milliSecondsToNow = Util.milliSecondsToNow(this.qVz);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(18916, cVar.qUL, "", 15, Long.valueOf(milliSecondsToNow), "", "", "", "", cVar.appId);
            AppMethodBeat.o(194584);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(194608);
        super.onPause();
        Log.i("MicroMsg.SpringLuckyEggActivity", "onPause");
        d dVar = this.qVw;
        if (dVar != null) {
            Log.i("MicroMsg.VideoController", "pause");
            dVar.qVU.onUIPause();
            dVar.playDuration += Util.milliSecondsToNow(dVar.qWp);
            dVar.qWp = 0;
            AppMethodBeat.o(194608);
            return;
        }
        AppMethodBeat.o(194608);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(194609);
        super.onResume();
        Log.i("MicroMsg.SpringLuckyEggActivity", "onResume");
        d dVar = this.qVw;
        if (dVar != null) {
            Log.i("MicroMsg.VideoController", "resume");
            dVar.count--;
            dVar.qVU.onUIResume();
            dVar.qWp = Util.nowMilliSecond();
            AppMethodBeat.o(194609);
            return;
        }
        AppMethodBeat.o(194609);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        long j2;
        int i2;
        long j3;
        AppMethodBeat.i(194610);
        super.onDestroy();
        c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
        com.tencent.mm.plugin.eggspring.c cVar = com.tencent.mm.plugin.eggspring.c.qUN;
        d dVar = this.qVw;
        if (dVar != null) {
            j2 = dVar.pLQ;
        } else {
            j2 = 0;
        }
        d dVar2 = this.qVw;
        if (dVar2 != null) {
            i2 = dVar2.count;
        } else {
            i2 = 0;
        }
        d dVar3 = this.qVw;
        if (dVar3 == null) {
            j3 = 0;
        } else if (dVar3.qWp > 0) {
            j3 = Util.milliSecondsToNow(dVar3.qWp) + dVar3.playDuration;
        } else {
            j3 = dVar3.playDuration;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(18916, cVar.qUL, "", 16, "", Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), "", cVar.appId);
        d dVar4 = this.qVw;
        if (dVar4 != null) {
            Log.i("MicroMsg.VideoController", "release");
            String str = dVar4.qWo;
            if (str != null) {
                o.bhk().m(str, null);
            }
            dVar4.qVU.onUIDestroy();
            dVar4.qWp = 0;
        }
        c cVar2 = this.qVv;
        if (cVar2 == null) {
            p.btv("viewBinding");
        }
        cVar2.qVF.stop();
        aj.b(this.qUR);
        AppMethodBeat.o(194610);
    }

    private final int da(String str, int i2) {
        int n2;
        AppMethodBeat.i(194611);
        if (str == null) {
            int n3 = android.support.v4.content.b.n(this, i2);
            AppMethodBeat.o(194611);
            return n3;
        }
        try {
            n2 = Color.parseColor(str);
        } catch (Exception e2) {
            Log.w("MicroMsg.SpringLuckyEggActivity", "Illegal color value: ".concat(String.valueOf(str)));
            n2 = android.support.v4.content.b.n(this, i2);
        }
        AppMethodBeat.o(194611);
        return n2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "T", LocaleUtil.ITALIAN, "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
    public static final class c<T> implements Observer<T> {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        public c(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        @Override // android.arch.lifecycle.Observer
        public final void onChanged(T t) {
            AppMethodBeat.i(194585);
            int a2 = SpringLuckyEggActivity.a(this.qVy, t, (int) R.color.a_2);
            SpringLuckyEggActivity.a(this.qVy).hwr.setBackgroundColor(a2);
            this.qVy.setActionbarColor(a2);
            Window window = this.qVy.getWindow();
            p.g(window, "window");
            window.setStatusBarColor(0);
            Window window2 = this.qVy.getWindow();
            p.g(window2, "window");
            window2.setNavigationBarColor(0);
            AppMethodBeat.o(194585);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "T", LocaleUtil.ITALIAN, "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
    public static final class d<T> implements Observer<T> {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        public d(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        @Override // android.arch.lifecycle.Observer
        public final void onChanged(T t) {
            AppMethodBeat.i(194586);
            if (p.j(t, Boolean.TRUE)) {
                SpringLuckyEggActivity.a(this.qVy).qVM.setVisibility(4);
                SpringLuckyEggActivity.a(this.qVy).qVF.start();
                SpringLuckyEggActivity.a(this.qVy).qVF.setVisibility(0);
                AppMethodBeat.o(194586);
                return;
            }
            SpringLuckyEggActivity.a(this.qVy, this.qVy.startTime);
            AppMethodBeat.o(194586);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "T", LocaleUtil.ITALIAN, "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
    public static final class e<T> implements Observer<T> {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        public e(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        @Override // android.arch.lifecycle.Observer
        public final void onChanged(T t) {
            AppMethodBeat.i(194587);
            T t2 = t;
            if (t2 == null) {
                AppMethodBeat.o(194587);
                return;
            }
            SpringLuckyEggActivity.a(this.qVy).qVN.setText(t2.title);
            SpringLuckyEggActivity.a(this.qVy).pYo.setText(t2.desc);
            if ((!p.j(SpringLuckyEggActivity.b(this.qVy).qWd.getValue(), Boolean.TRUE)) || !a.a(t2)) {
                SpringLuckyEggActivity.a(this.qVy).qVO.setText(t2.gTt);
            }
            com.tencent.mm.t.a.m mVar = t2.gTD.gTN;
            if (mVar != null) {
                SpringLuckyEggActivity.a(this.qVy).qVS.setText(mVar.gTS);
            }
            String str = t2.gTA;
            if (!(str == null || str.length() == 0)) {
                if (t2.gTz == 2) {
                    SpringLuckyEggActivity springLuckyEggActivity = this.qVy;
                    SpringEggVideoView springEggVideoView = SpringLuckyEggActivity.a(this.qVy).qVU;
                    c a2 = SpringLuckyEggActivity.a(this.qVy);
                    String str2 = t2.gTA;
                    p.g(str2, "material.creative_url");
                    springLuckyEggActivity.qVw = new d(springEggVideoView, a2, str2);
                    d dVar = this.qVy.qVw;
                    if (dVar != null) {
                        Log.i("MicroMsg.VideoController", "start");
                        dVar.qVU.start();
                        Object systemService = dVar.qVU.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                        if (systemService == null) {
                            t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
                            AppMethodBeat.o(194587);
                            throw tVar;
                        }
                        AudioManager audioManager = (AudioManager) systemService;
                        Log.i("MicroMsg.VideoController", "init: rangerMode=" + audioManager.getRingerMode());
                        dVar.setMute(audioManager.getRingerMode() != 2);
                        dVar.qVv.qVV.setVisibility(0);
                        dVar.qVU.setVisibility(0);
                    }
                    ViewGroup.LayoutParams layoutParams = SpringLuckyEggActivity.a(this.qVy).qVP.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                        AppMethodBeat.o(194587);
                        throw tVar2;
                    }
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.width = -1;
                    layoutParams2.height = this.qVy.getResources().getDimensionPixelSize(R.dimen.ub);
                    layoutParams2.topMargin = 0;
                    layoutParams2.gravity = 17;
                    SpringLuckyEggActivity.a(this.qVy).qVP.requestLayout();
                    SpringLuckyEggActivity springLuckyEggActivity2 = this.qVy;
                    String str3 = t2.gTB;
                    p.g(str3, "material.thumb_url");
                    SpringLuckyEggActivity.a(springLuckyEggActivity2, str3, false);
                } else if (t2.gTz == 1) {
                    SpringLuckyEggActivity springLuckyEggActivity3 = this.qVy;
                    String str4 = t2.gTA;
                    p.g(str4, "material.creative_url");
                    SpringLuckyEggActivity.a(springLuckyEggActivity3, str4, a.c(t2));
                }
            }
            if (a.b(t2)) {
                SpringLuckyEggActivity.a(this.qVy).qVO.setVisibility(8);
                SpringLuckyEggActivity.a(this.qVy).qVT.setVisibility(0);
                SpringLuckyEggActivity.a(this.qVy).qVR.setVisibility(8);
                SpringLuckyEggActivity.a(this.qVy).qVO.setVisibility(8);
                AppMethodBeat.o(194587);
                return;
            }
            SpringLuckyEggActivity.a(this.qVy).qVO.setVisibility(0);
            SpringLuckyEggActivity.a(this.qVy).qVT.setVisibility(8);
            SpringLuckyEggActivity.a(this.qVy).qVR.setVisibility(0);
            SpringLuckyEggActivity.a(this.qVy).qVO.setVisibility(0);
            AppMethodBeat.o(194587);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "T", LocaleUtil.ITALIAN, "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
    public static final class f<T> implements Observer<T> {
        final /* synthetic */ SpringLuckyEggActivity qVy;

        public f(SpringLuckyEggActivity springLuckyEggActivity) {
            this.qVy = springLuckyEggActivity;
        }

        @Override // android.arch.lifecycle.Observer
        public final void onChanged(T t) {
            int i2;
            AppMethodBeat.i(194594);
            T t2 = t;
            if (t2 == null) {
                AppMethodBeat.o(194594);
                return;
            }
            String str = com.tencent.mm.plugin.emoji.e.h.getDataEmojiPath() + "/egg/";
            boolean z = t2.zpS == 0;
            Window window = this.qVy.getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            if (!z || Build.VERSION.SDK_INT < 23) {
                i2 = 1792;
            } else {
                i2 = 9984;
            }
            decorView.setSystemUiVisibility(i2);
            this.qVy.setBackBtnColorFilter(z ? WebView.NIGHT_MODE_COLOR : -1);
            SpringLuckyEggActivity.a(this.qVy).pYm.setText(t2.brandName);
            SpringLuckyEggActivity.a(this.qVy).qVK.setImageFilePath(str + '/' + t2.jhb);
            SpringLuckyEggActivity.a(this.qVy).qVH.setText(t2.jgX);
            SpringLuckyEggActivity.a(this.qVy).qVI.setText(t2.jgZ);
            int a2 = SpringLuckyEggActivity.a(this.qVy, t2.jgY, (int) R.color.a_3);
            int a3 = SpringLuckyEggActivity.a(this.qVy, t2.jha, (int) R.color.a_1);
            SpringLuckyEggActivity.a(this.qVy).qVH.setTextColor(SpringLuckyEggActivity.o(a2, 0.6f));
            SpringLuckyEggActivity.a(this.qVy).qVG.C(a2, 0.6f);
            SpringLuckyEggActivity.a(this.qVy).qVI.setTextColor(SpringLuckyEggActivity.a(this.qVy, t2.jha, (int) R.color.a_1));
            SpringLuckyEggActivity.a(this.qVy).qVI.setTextColor(SpringLuckyEggActivity.o(a3, 0.3f));
            if (t2.jhd == null) {
                SpringLuckyEggActivity.a(this.qVy).qVJ.setImageBitmap(null);
            } else {
                kotlinx.coroutines.f.b(this.qVy.qUR, (kotlin.d.f) null, new a(str, t2, null, this), 3);
            }
            String str2 = str + '/' + t2.jhi;
            if (s.YS(str2)) {
                SpringLuckyEggActivity.a(this.qVy).qVF.setImageFilePath(str2);
            } else if (s.YS(PluginEggSpring.qUG)) {
                SpringLuckyEggActivity.a(this.qVy).qVF.setImageFilePath(PluginEggSpring.qUG);
            } else {
                SpringLuckyEggActivity.a(this.qVy).qVF.setImageResource(R.drawable.cav);
            }
            SpringLuckyEggActivity.a(this.qVy).qVO.setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, StateSet.WILD_CARD}, new int[]{android.support.v4.content.b.n(this.qVy, R.color.ac), SpringLuckyEggActivity.a(this.qVy, t2.jhk, (int) R.color.am)}));
            SpringLuckyEggActivity.a(this.qVy).qVO.setBackground(SpringLuckyEggActivity.a(this.qVy, SpringLuckyEggActivity.a(this.qVy, t2.jhj, (int) R.color.Red_90)));
            AppMethodBeat.o(194594);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$bindViewModel$4$1"})
        public static final class a extends kotlin.d.b.a.j implements kotlin.g.a.m<ai, kotlin.d.d<? super x>, Object> {
            Object L$0;
            int label;
            private ai p$;
            final /* synthetic */ String qVA;
            final /* synthetic */ com.tencent.mm.bb.k qVB;
            final /* synthetic */ f qVC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, com.tencent.mm.bb.k kVar, kotlin.d.d dVar, f fVar) {
                super(2, dVar);
                this.qVA = str;
                this.qVB = kVar;
                this.qVC = fVar;
            }

            @Override // kotlin.d.b.a.a
            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                AppMethodBeat.i(194592);
                p.h(dVar, "completion");
                a aVar = new a(this.qVA, this.qVB, dVar, this.qVC);
                aVar.p$ = (ai) obj;
                AppMethodBeat.o(194592);
                return aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
                AppMethodBeat.i(194593);
                Object invokeSuspend = ((a) create(aiVar, dVar)).invokeSuspend(x.SXb);
                AppMethodBeat.o(194593);
                return invokeSuspend;
            }

            @Override // kotlin.d.b.a.a
            public final Object invokeSuspend(Object obj) {
                Object obj2;
                AppMethodBeat.i(194591);
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        this.L$0 = this.p$;
                        this.label = 1;
                        obj2 = kotlinx.coroutines.g.a(ba.hMW(), new kotlin.g.a.m<ai, kotlin.d.d<? super Bitmap>, Object>(this, null) {
                            /* class com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity.f.a.AnonymousClass1 */
                            int label;
                            private ai p$;
                            final /* synthetic */ a qVD;

                            {
                                this.qVD = r2;
                            }

                            @Override // kotlin.d.b.a.a
                            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                                AppMethodBeat.i(194589);
                                p.h(dVar, "completion");
                                AnonymousClass1 r0 = 
                            }

                            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "T", LocaleUtil.ITALIAN, "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
                            public static final class g<T> implements Observer<T> {
                                final /* synthetic */ SpringLuckyEggActivity qVy;

                                public g(SpringLuckyEggActivity springLuckyEggActivity) {
                                    this.qVy = springLuckyEggActivity;
                                }

                                @Override // android.arch.lifecycle.Observer
                                public final void onChanged(T t) {
                                    AppMethodBeat.i(194595);
                                    T t2 = t;
                                    if (t2 != null) {
                                        switch (b.$EnumSwitchMapping$0[t2.ordinal()]) {
                                            case 1:
                                                AppCompatActivity context = this.qVy.getContext();
                                                p.g(context, "context");
                                                u.cG(this.qVy.getContext(), context.getResources().getString(R.string.he6));
                                                break;
                                            case 2:
                                                AppCompatActivity context2 = this.qVy.getContext();
                                                p.g(context2, "context");
                                                u.cH(this.qVy.getContext(), context2.getResources().getString(R.string.he5));
                                                break;
                                            case 3:
                                                AppCompatActivity context3 = this.qVy.getContext();
                                                p.g(context3, "context");
                                                u.cH(this.qVy.getContext(), context3.getResources().getString(R.string.he4));
                                                break;
                                            case 4:
                                                AppCompatActivity context4 = this.qVy.getContext();
                                                p.g(context4, "context");
                                                u.cH(this.qVy.getContext(), context4.getResources().getString(R.string.he5));
                                                break;
                                        }
                                        SpringLuckyEggActivity.b(this.qVy).qVX.setValue(null);
                                    }
                                    AppMethodBeat.o(194595);
                                }
                            }

                            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "T", LocaleUtil.ITALIAN, "onChanged", "(Ljava/lang/Object;)V", "com/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$observe$1"})
                            public static final class h<T> implements Observer<T> {
                                final /* synthetic */ SpringLuckyEggActivity qVy;

                                public h(SpringLuckyEggActivity springLuckyEggActivity) {
                                    this.qVy = springLuckyEggActivity;
                                }

                                @Override // android.arch.lifecycle.Observer
                                public final void onChanged(T t) {
                                    AppMethodBeat.i(194596);
                                    T t2 = t;
                                    if (t2 != null && !p.j(t2, Boolean.FALSE) && a.a(SpringLuckyEggActivity.b(this.qVy).qWb.getValue())) {
                                        SpringLuckyEggActivity.a(this.qVy).qVO.setText(this.qVy.getString(R.string.he7));
                                        SpringLuckyEggActivity.a(this.qVy).qVO.setEnabled(false);
                                    }
                                    AppMethodBeat.o(194596);
                                }
                            }

                            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggActivity$Companion;", "", "()V", "ARG_APP_ID", "", "ARG_BACKGROUND", "ARG_EGG_NAME", "ARG_KEYWORD", "ARG_TRACE_ID", "CARD_ANIM_DURATION", "", "CREATIVE_TYPE_IMAGE", "CREATIVE_TYPE_VIDEO", "DEFAULT_SYSTEM_UI_FLAGS", "MIN_LOADING_TIME", "TAG", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "egg", "Lcom/tencent/mm/modelpackage/EggInfo;", "keyword", "appId", "traceId", "plugin-eggspring_release"})
                            public static final class a {
                                private a() {
                                }

                                public /* synthetic */ a(byte b2) {
                                    this();
                                }
                            }

                            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/eggspring/ui/SpringLuckyEggViewModel;", "invoke"})
                            static final class n extends q implements kotlin.g.a.a<SpringLuckyEggViewModel> {
                                final /* synthetic */ SpringLuckyEggActivity qVy;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                n(SpringLuckyEggActivity springLuckyEggActivity) {
                                    super(0);
                                    this.qVy = springLuckyEggActivity;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ SpringLuckyEggViewModel invoke() {
                                    AppMethodBeat.i(194603);
                                    SpringLuckyEggViewModel springLuckyEggViewModel = (SpringLuckyEggViewModel) ViewModelProviders.of(this.qVy, new ViewModelProvider.Factory(this) {
                                        /* class com.tencent.mm.plugin.eggspring.ui.SpringLuckyEggActivity.n.AnonymousClass1 */
                                        final /* synthetic */ n qVE;

                                        /* JADX WARN: Incorrect args count in method signature: ()V */
                                        {
                                            this.qVE = r1;
                                        }

                                        @Override // android.arch.lifecycle.ViewModelProvider.Factory
                                        public final <T extends ViewModel> T create(Class<T> cls) {
                                            AppMethodBeat.i(194602);
                                            p.h(cls, "modelClass");
                                            Intent intent = this.qVE.qVy.getIntent();
                                            p.g(intent, "intent");
                                            Bundle extras = intent.getExtras();
                                            if (extras == null) {
                                                IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
                                                AppMethodBeat.o(194602);
                                                throw illegalStateException;
                                            }
                                            String string = extras.getString("egg_name");
                                            if (string == null) {
                                                p.hyc();
                                            }
                                            p.g(string, "bundle.getString(ARG_EGG_NAME)!!");
                                            String string2 = extras.getString("keyword");
                                            if (string2 == null) {
                                                p.hyc();
                                            }
                                            p.g(string2, "bundle.getString(ARG_KEYWORD)!!");
                                            SpringLuckyEggViewModel springLuckyEggViewModel = new SpringLuckyEggViewModel(string, string2, extras.getString("app_id"), extras.getString("trace_id"), extras.getString("background"));
                                            AppMethodBeat.o(194602);
                                            return springLuckyEggViewModel;
                                        }
                                    }).get(SpringLuckyEggViewModel.class);
                                    AppMethodBeat.o(194603);
                                    return springLuckyEggViewModel;
                                }
                            }

                            public static final /* synthetic */ void a(SpringLuckyEggActivity springLuckyEggActivity, Object obj) {
                                String str;
                                String str2;
                                AppMethodBeat.i(194616);
                                Log.i("MicroMsg.SpringLuckyEggActivity", "redirect: target=".concat(String.valueOf(obj)));
                                if (obj instanceof com.tencent.mm.t.a.a) {
                                    Intent intent = new Intent();
                                    String str3 = ((com.tencent.mm.t.a.a) obj).gTh;
                                    p.g(str3, "target.ad_xml");
                                    intent.putExtra("sns_landing_pages_xml", kotlin.n.n.a(str3, "<adxml", 0, false, 6) >= 0 ? ((com.tencent.mm.t.a.a) obj).gTh : "<adxml>" + ((com.tencent.mm.t.a.a) obj).gTh + "</adxml>");
                                    intent.putExtra("sns_landig_pages_from_source", 14);
                                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                                    com.tencent.mm.br.c.b(springLuckyEggActivity.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                                    AppMethodBeat.o(194616);
                                } else if (obj instanceof com.tencent.mm.t.a.p) {
                                    com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                                    String str4 = ((com.tencent.mm.t.a.p) obj).gTT;
                                    p.g(str4, "target.app_user_name");
                                    gVar.username = kotlin.n.n.nm(str4, "@app") ? ((com.tencent.mm.t.a.p) obj).gTT : ((com.tencent.mm.t.a.p) obj).gTT + "@app";
                                    gVar.kHw = ((com.tencent.mm.t.a.p) obj).gTU;
                                    gVar.scene = 1189;
                                    gVar.iOo = 0;
                                    ((r) com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), gVar);
                                    AppMethodBeat.o(194616);
                                } else if (obj instanceof com.tencent.mm.t.a.i) {
                                    String str5 = ((com.tencent.mm.t.a.i) obj).url;
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("rawUrl", str5);
                                    intent2.putExtra("from_shortcut", true);
                                    intent2.putExtra("disable_minimize", true);
                                    intent2.putExtra("MMActivity.OverrideEnterAnimation", R.anim.s);
                                    intent2.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
                                    com.tencent.mm.br.c.b(springLuckyEggActivity, "webview", ".ui.tools.WebViewUI", intent2, 3001);
                                    springLuckyEggActivity.overridePendingTransition(R.anim.dq, R.anim.s);
                                    AppMethodBeat.o(194616);
                                } else if (obj instanceof com.tencent.mm.t.a.b) {
                                    SpringLuckyEggViewModel cEJ = springLuckyEggActivity.cEJ();
                                    String str6 = ((com.tencent.mm.t.a.b) obj).dNI;
                                    if (str6 == null) {
                                        str = "";
                                    } else {
                                        str = str6;
                                    }
                                    String str7 = ((com.tencent.mm.t.a.b) obj).gTi;
                                    if (str7 == null) {
                                        str2 = "";
                                    } else {
                                        str2 = str7;
                                    }
                                    p.h(str, "appId");
                                    p.h(str2, "stockId");
                                    Log.i("MicroMsg.SpringLuckyEggViewModel", "accept coupon: appId=" + str + ", stockId=" + str2 + ", traceId=" + cEJ.kZe);
                                    kotlinx.coroutines.f.b(cEJ.qUR, (kotlin.d.f) null, new SpringLuckyEggViewModel.b(cEJ, str, str2, null), 3);
                                    c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
                                    com.tencent.mm.plugin.eggspring.c.qUN.FF(12);
                                    AppMethodBeat.o(194616);
                                } else {
                                    springLuckyEggActivity.finish();
                                    AppMethodBeat.o(194616);
                                }
                            }

                            public static final /* synthetic */ void a(SpringLuckyEggActivity springLuckyEggActivity, long j2) {
                                AppMethodBeat.i(194619);
                                Keyframe ofFloat = Keyframe.ofFloat(0.0f, 90.0f);
                                Keyframe ofFloat2 = Keyframe.ofFloat(1.0f, 0.0f);
                                PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION_X, ofFloat, ofFloat2);
                                Keyframe ofFloat3 = Keyframe.ofFloat(0.0f, 0.0f);
                                Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
                                PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(View.SCALE_X, ofFloat3, ofFloat4);
                                PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, ofFloat3, ofFloat4);
                                Keyframe ofFloat5 = Keyframe.ofFloat(0.0f, 0.0f);
                                Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
                                PropertyValuesHolder ofKeyframe4 = PropertyValuesHolder.ofKeyframe(View.ALPHA, ofFloat5, ofFloat6);
                                Keyframe ofFloat7 = Keyframe.ofFloat(0.0f, -50.0f);
                                Keyframe ofFloat8 = Keyframe.ofFloat(0.5f, -610.0f);
                                Keyframe ofFloat9 = Keyframe.ofFloat(1.0f, 0.0f);
                                PropertyValuesHolder ofKeyframe5 = PropertyValuesHolder.ofKeyframe(View.Y, ofFloat7, ofFloat8, ofFloat9);
                                c cVar = springLuckyEggActivity.qVv;
                                if (cVar == null) {
                                    p.btv("viewBinding");
                                }
                                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(cVar.qVM, ofKeyframe, ofKeyframe2, ofKeyframe3, ofKeyframe4, ofKeyframe5);
                                p.g(ofPropertyValuesHolder, "ObjectAnimator.ofPropert…scaleX, scaleY, alpha, y)");
                                ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
                                long milliSecondsToNow = Util.milliSecondsToNow(j2);
                                if (milliSecondsToNow < 2000) {
                                    ofPropertyValuesHolder.setStartDelay(2000 - milliSecondsToNow);
                                    Log.w("MicroMsg.SpringLuckyEggActivity", "animator start delay " + ofPropertyValuesHolder.getStartDelay());
                                }
                                ofPropertyValuesHolder.setDuration(550L).start();
                                ofPropertyValuesHolder.addListener(new b(springLuckyEggActivity, j2));
                                ofPropertyValuesHolder.start();
                                AppMethodBeat.o(194619);
                            }

                            public static final /* synthetic */ void a(SpringLuckyEggActivity springLuckyEggActivity, String str, boolean z) {
                                Drawable drawable;
                                AppMethodBeat.i(194620);
                                c cVar = springLuckyEggActivity.qVv;
                                if (cVar == null) {
                                    p.btv("viewBinding");
                                }
                                ViewGroup.LayoutParams layoutParams = cVar.qVP.getLayoutParams();
                                if (layoutParams == null) {
                                    t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                                    AppMethodBeat.o(194620);
                                    throw tVar;
                                }
                                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                                if (z) {
                                    layoutParams2.width = springLuckyEggActivity.getResources().getDimensionPixelSize(R.dimen.ui);
                                    layoutParams2.height = springLuckyEggActivity.getResources().getDimensionPixelSize(R.dimen.ug);
                                    layoutParams2.topMargin = springLuckyEggActivity.getResources().getDimensionPixelSize(R.dimen.uh);
                                    layoutParams2.gravity = 1;
                                    drawable = android.support.v4.content.b.l(springLuckyEggActivity, R.drawable.coh);
                                    if (drawable == null) {
                                        p.hyc();
                                    }
                                } else {
                                    layoutParams2.width = springLuckyEggActivity.getResources().getDimensionPixelSize(R.dimen.uc);
                                    layoutParams2.height = springLuckyEggActivity.getResources().getDimensionPixelSize(R.dimen.ub);
                                    layoutParams2.topMargin = 0;
                                    layoutParams2.gravity = 17;
                                    drawable = null;
                                }
                                c cVar2 = springLuckyEggActivity.qVv;
                                if (cVar2 == null) {
                                    p.btv("viewBinding");
                                }
                                cVar2.qVP.requestLayout();
                                com.tencent.mm.av.a.a.c bdv = new c.a().bdp().bdu().OS(PluginEggSpring.qUF + '/' + str.hashCode()).x(drawable).aw((float) springLuckyEggActivity.getResources().getDimensionPixelSize(R.dimen.uj)).bdv();
                                com.tencent.mm.av.a.a bdb = com.tencent.mm.av.a.a.bdb();
                                c cVar3 = springLuckyEggActivity.qVv;
                                if (cVar3 == null) {
                                    p.btv("viewBinding");
                                }
                                bdb.a(str, cVar3.qVQ, bdv, new i(springLuckyEggActivity));
                                AppMethodBeat.o(194620);
                            }

                            public static final /* synthetic */ ColorStateList o(int i2, float f2) {
                                AppMethodBeat.i(194621);
                                int argb = Color.argb((int) (255.0f * f2), Color.red(i2), Color.green(i2), Color.blue(i2));
                                int argb2 = Color.argb((int) (Math.min(f2 - 0.2f, 1.0f) * 255.0f), Color.red(i2), Color.green(i2), Color.blue(i2));
                                ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{16842919}, StateSet.WILD_CARD}, new int[]{argb2, argb});
                                AppMethodBeat.o(194621);
                                return colorStateList;
                            }

                            public static final /* synthetic */ Drawable a(SpringLuckyEggActivity springLuckyEggActivity, int i2) {
                                AppMethodBeat.i(194622);
                                int n2 = android.support.v4.content.b.n(springLuckyEggActivity, R.color.a_);
                                StateListDrawable stateListDrawable = new StateListDrawable();
                                stateListDrawable.addState(new int[]{-16842910}, springLuckyEggActivity.FG(n2));
                                stateListDrawable.addState(StateSet.WILD_CARD, springLuckyEggActivity.FG(i2));
                                StateListDrawable stateListDrawable2 = new StateListDrawable();
                                stateListDrawable2.addState(new int[]{16842919}, springLuckyEggActivity.FG(android.support.v4.content.b.n(springLuckyEggActivity, R.color.aa)));
                                stateListDrawable2.addState(StateSet.WILD_CARD, springLuckyEggActivity.FG(0));
                                LayerDrawable layerDrawable = new LayerDrawable(new StateListDrawable[]{stateListDrawable, stateListDrawable2});
                                AppMethodBeat.o(194622);
                                return layerDrawable;
                            }

                            public static final Intent a(Context context, com.tencent.mm.bb.e eVar, String str, String str2, String str3) {
                                AppMethodBeat.i(194623);
                                p.h(context, "context");
                                p.h(eVar, "egg");
                                p.h(str, "keyword");
                                Intent intent = new Intent(context, SpringLuckyEggActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("keyword", str);
                                bundle.putString("trace_id", str3);
                                bundle.putString("app_id", str2);
                                bundle.putString("egg_name", eVar.name);
                                bundle.putString("background", eVar.gXT.jhc);
                                intent.putExtras(bundle);
                                AppMethodBeat.o(194623);
                                return intent;
                            }
                        }
