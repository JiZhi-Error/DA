package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0014J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010*\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView;", "Lme/imid/swipebacklayout/lib/SwipeBackLayout;", "Landroid/content/DialogInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "appearAnimation", "Landroid/view/animation/Animation;", "dismissAnimation", "drawStatusBarLayout", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "iconImageView", "Landroid/widget/ImageView;", "negativeButton", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeButton", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeButton", "(Landroid/content/DialogInterface$OnClickListener;)V", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "positiveButton", "getPositiveButton", "setPositiveButton", "cancel", "", "cleanup", "dismiss", "dismissWithoutAnimation", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "resetStyle", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "show", "endAction", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
public final class l extends SwipeBackLayout implements DialogInterface {
    w cAt;
    com.tencent.mm.plugin.appbrand.widget.actionbar.b kGn;
    private DialogInterface.OnClickListener nof;
    private DialogInterface.OnClickListener nog;
    private Animation noh;
    Animation noi;
    private com.tencent.mm.ui.statusbar.b noj;
    ImageView nok;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(50928);
        cb.cE(this);
        a(new SwipeBackLayout.b(this) {
            /* class com.tencent.mm.plugin.appbrand.page.l.AnonymousClass1 */
            final /* synthetic */ l nol;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.nol = r1;
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
            public final void i(int i2, float f2) {
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
            public final void LN() {
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
            public final void n(MotionEvent motionEvent) {
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.a
            public final int bS(boolean z) {
                return 1;
            }

            @Override // me.imid.swipebacklayout.lib.SwipeBackLayout.b
            public final void bQF() {
                AppMethodBeat.i(50916);
                this.nol.setVisibility(8);
                this.nol.post(new a(this));
                AppMethodBeat.o(50916);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.appbrand.page.l$1$a */
            static final class a implements Runnable {
                final /* synthetic */ AnonymousClass1 nom;

                a(AnonymousClass1 r1) {
                    this.nom = r1;
                }

                public final void run() {
                    AppMethodBeat.i(50915);
                    ViewParent parent = this.nom.nol.getParent();
                    if (!(parent instanceof ViewGroup)) {
                        parent = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    if (viewGroup != null) {
                        viewGroup.removeView(this.nom.nol);
                        AppMethodBeat.o(50915);
                        return;
                    }
                    AppMethodBeat.o(50915);
                }
            }
        });
        com.tencent.mm.ui.statusbar.b bVar = new com.tencent.mm.ui.statusbar.b(context);
        bVar.setClickable(true);
        bVar.setBackgroundColor(-1);
        bVar.setWillNotDraw(false);
        bVar.CF(false);
        bVar.S(0, true);
        this.noj = bVar;
        addView(this.noj, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.noj);
        com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar2 = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(context);
        bVar2.setFullscreenMode(false);
        bVar2.setBackButtonClickListener(new a(this, context));
        bVar2.setCloseButtonClickListener(new b(this, context));
        com.tencent.mm.ui.statusbar.b bVar3 = this.noj;
        if (bVar3 == null) {
            p.hyc();
        }
        bVar3.addView(bVar2, new FrameLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.eu(context)));
        this.kGn = bVar2;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ec, (ViewGroup) this.noj, false);
        ((TextView) inflate.findViewById(R.id.nx)).setText(R.string.np);
        ((TextView) inflate.findViewById(R.id.nv)).setText(R.string.no);
        com.tencent.mm.ui.statusbar.b bVar4 = this.noj;
        if (bVar4 == null) {
            p.hyc();
        }
        bVar4.addView(inflate);
        p.g(inflate, "this");
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (!(layoutParams instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams);
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = com.tencent.mm.plugin.appbrand.widget.b.eu(context);
        }
        this.nok = (ImageView) findViewById(R.id.nw);
        findViewById(R.id.nv).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.appbrand.page.l.AnonymousClass2 */
            final /* synthetic */ l nol;

            {
                this.nol = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(50917);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                DialogInterface.OnClickListener positiveButton = this.nol.getPositiveButton();
                if (positiveButton != null) {
                    positiveButton.onClick(this.nol, -1);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(50917);
            }
        });
        AppMethodBeat.o(50928);
    }

    public final DialogInterface.OnClickListener getPositiveButton() {
        return this.nof;
    }

    public final void setPositiveButton(DialogInterface.OnClickListener onClickListener) {
        this.nof = onClickListener;
    }

    public final DialogInterface.OnClickListener getNegativeButton() {
        return this.nog;
    }

    public final void setNegativeButton(DialogInterface.OnClickListener onClickListener) {
        this.nog = onClickListener;
    }

    public final void cleanup() {
        ViewGroup viewGroup = null;
        AppMethodBeat.i(50921);
        Animation animation = getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = getAnimation();
        if (animation2 != null) {
            animation2.setAnimationListener(null);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = parent;
        }
        ViewGroup viewGroup2 = viewGroup;
        if (viewGroup2 != null) {
            viewGroup2.removeView(this);
            AppMethodBeat.o(50921);
            return;
        }
        AppMethodBeat.o(50921);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$show$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
    public static final class d extends com.tencent.mm.ui.widget.c {
        final /* synthetic */ l nol;
        final /* synthetic */ Runnable noo;

        d(l lVar, Runnable runnable) {
            this.nol = lVar;
            this.noo = runnable;
        }

        @Override // com.tencent.mm.ui.widget.c
        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(50920);
            this.nol.noi = null;
            Runnable runnable = this.noo;
            if (runnable != null) {
                runnable.run();
                AppMethodBeat.o(50920);
                return;
            }
            AppMethodBeat.o(50920);
        }
    }

    public final void dismiss() {
        AppMethodBeat.i(50922);
        Animation animation = this.noh;
        if (animation != null) {
            animation.cancel();
        }
        this.noh = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.ogp);
        Animation animation2 = this.noh;
        if (animation2 == null) {
            p.hyc();
        }
        animation2.setAnimationListener(new c(this));
        Animation animation3 = this.noh;
        if (animation3 == null) {
            p.hyc();
        }
        startAnimation(animation3);
        AppMethodBeat.o(50922);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$dismiss$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
    public static final class c extends com.tencent.mm.ui.widget.c {
        final /* synthetic */ l nol;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(l lVar) {
            this.nol = lVar;
        }

        @Override // com.tencent.mm.ui.widget.c
        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(50919);
            this.nol.setVisibility(8);
            MMHandlerThread.postToMainThread(new a(this));
            AppMethodBeat.o(50919);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ c non;

            a(c cVar) {
                this.non = cVar;
            }

            public final void run() {
                AppMethodBeat.i(50918);
                this.non.nol.cleanup();
                AppMethodBeat.o(50918);
            }
        }
    }

    public final void bQE() {
        AppMethodBeat.i(50923);
        setVisibility(8);
        cleanup();
        AppMethodBeat.o(50923);
    }

    public final void cancel() {
        AppMethodBeat.i(50924);
        dismiss();
        DialogInterface.OnClickListener onClickListener = this.nog;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
            AppMethodBeat.o(50924);
            return;
        }
        AppMethodBeat.o(50924);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(50925);
        super.onDetachedFromWindow();
        this.nof = null;
        this.nog = null;
        this.noh = null;
        this.noi = null;
        this.cAt = null;
        AppMethodBeat.o(50925);
    }

    @Override // me.imid.swipebacklayout.lib.SwipeBackLayout
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(50926);
        if (this.noh == null && this.noi == null) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(50926);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(50926);
        return true;
    }

    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        AppMethodBeat.i(50927);
        if (this.noh != null || this.noi != null) {
            AppMethodBeat.o(50927);
            return true;
        } else if (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4) {
            g.aM(getContext());
            dismiss();
            AppMethodBeat.o(50927);
            return true;
        } else {
            boolean dispatchKeyEventPreIme = super.dispatchKeyEventPreIme(keyEvent);
            AppMethodBeat.o(50927);
            return dispatchKeyEventPreIme;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ l nol;

        a(l lVar, Context context) {
            this.nol = lVar;
            this.$context$inlined = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(50913);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.nol.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(50913);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$2"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ l nol;

        b(l lVar, Context context) {
            this.nol = lVar;
            this.$context$inlined = context;
        }

        public final void onClick(View view) {
            AppBrandRuntime runtime;
            AppMethodBeat.i(50914);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            w wVar = this.nol.cAt;
            if (!(wVar == null || (runtime = wVar.getRuntime()) == null)) {
                h.a(runtime.getAppId(), h.d.CLOSE);
                runtime.close();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(50914);
        }
    }
}
