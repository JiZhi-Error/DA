package com.tencent.mm.plugin.festival.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0004J\u001c\u0010\u000f\u001a\u00020\u00072\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\b\u0010\u0015\u001a\u00020\u0007H\u0002¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/FestivalActivityBase;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getContentLayoutId", "", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setActionBarDesc", "desc", "", "setActionBarIcon", "iconResId", "setActionBarIconOnClick", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "setActionBarTitle", "title", "setWindowStyle", "plugin-festival_release"})
public abstract class FestivalActivityBase extends MMActivity {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<View, x> {
        final /* synthetic */ FestivalActivityBase UBl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FestivalActivityBase festivalActivityBase) {
            super(1);
            this.UBl = festivalActivityBase;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(View view) {
            AppMethodBeat.i(263184);
            p.h(view, LocaleUtil.ITALIAN);
            this.UBl.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(263184);
            return xVar;
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            Window window = getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setSystemUiVisibility(1792);
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getWindow();
            p.g(window2, "window");
            window2.setStatusBarColor(0);
            Window window3 = getWindow();
            p.g(window3, "window");
            window3.setNavigationBarColor(0);
        }
        getWindow().setFormat(-3);
        getWindow().setSoftInputMode(51);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.juu);
        relativeLayout.setOnApplyWindowInsetsListener(new a(relativeLayout));
        ((FrameLayout) _$_findCachedViewById(R.id.be3)).addView(LayoutInflater.from(this).inflate(R.layout.ce3, (ViewGroup) null));
        ((WeImageView) _$_findCachedViewById(R.id.jut)).setOnClickListener(new c(new b(this)));
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Landroid/view/WindowInsets;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "insets", "onApplyWindowInsets"})
    public static final class a implements View.OnApplyWindowInsetsListener {
        final /* synthetic */ RelativeLayout UBk;

        a(RelativeLayout relativeLayout) {
            this.UBk = relativeLayout;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            AppMethodBeat.i(263183);
            RelativeLayout relativeLayout = this.UBk;
            p.g(relativeLayout, "this");
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(263183);
                throw tVar;
            }
            p.g(windowInsets, "insets");
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = windowInsets.getSystemWindowInsetTop();
            AppMethodBeat.o(263183);
            return windowInsets;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cdf;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b UBm;

        c(kotlin.g.a.b bVar) {
            this.UBm = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(263185);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/FestivalActivityBase$setActionBarIconOnClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b bVar2 = this.UBm;
            if (bVar2 != null) {
                p.g(view, LocaleUtil.ITALIAN);
                bVar2.invoke(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/ui/FestivalActivityBase$setActionBarIconOnClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(263185);
        }
    }
}
