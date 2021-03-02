package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\tJ\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0012\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;)V", "mAnimator", "Landroid/animation/Animator;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "applyStatus", "status", "", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pauseAnimation", "resumeAnimation", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "setDescription", "resId", "setLogo", "drawable", "setStatus", "luggage-wxa-app_release"})
public final class h extends f implements i.a {
    private Animator Fj;
    private final AppBrandOptionButton nvw;

    public h(AppBrandOptionButton appBrandOptionButton) {
        p.h(appBrandOptionButton, "mButton");
        AppMethodBeat.i(219729);
        this.nvw = appBrandOptionButton;
        AppMethodBeat.o(219729);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
    public final void setStatus(int i2) {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final void yS(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
    public final void setLogo(Drawable drawable) {
        AppMethodBeat.i(219721);
        y(drawable);
        AppMethodBeat.o(219721);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
    public final void setLogo(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
    public final void setDescription(CharSequence charSequence) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
    public final void yT(int i2) {
    }

    public final void bSz() {
        AppMethodBeat.i(219723);
        Animator animator = this.Fj;
        if (animator != null) {
            animator.resume();
            AppMethodBeat.o(219723);
            return;
        }
        AppMethodBeat.o(219723);
    }

    public final void bSA() {
        AppMethodBeat.i(219724);
        Animator animator = this.Fj;
        if (animator != null) {
            animator.pause();
            AppMethodBeat.o(219724);
            return;
        }
        AppMethodBeat.o(219724);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final void y(Drawable drawable) {
        Animator animator;
        AppMethodBeat.i(219725);
        AppBrandOptionButton appBrandOptionButton = this.nvw;
        clearAnimation();
        if (drawable == null) {
            appBrandOptionButton.reset();
            AppMethodBeat.o(219725);
            return;
        }
        appBrandOptionButton.getButtonImage().setImageDrawable(drawable);
        Animator cF = cF(appBrandOptionButton.getButtonImage());
        if (!(cF instanceof ValueAnimator)) {
            animator = null;
        } else {
            animator = cF;
        }
        ValueAnimator valueAnimator = (ValueAnimator) animator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new a(appBrandOptionButton, drawable));
        }
        cF.start();
        this.Fj = cF;
        AppMethodBeat.o(219725);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper$applyLogo$1$1"})
    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ AppBrandOptionButton nvx;
        final /* synthetic */ Drawable nvy;

        a(AppBrandOptionButton appBrandOptionButton, Drawable drawable) {
            this.nvx = appBrandOptionButton;
            this.nvy = drawable;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(219720);
            this.nvx.getButtonImage().setImageDrawable(this.nvy);
            AppMethodBeat.o(219720);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final void E(CharSequence charSequence) {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final Context getContext() {
        AppMethodBeat.i(219726);
        Context context = this.nvw.getContext();
        p.g(context, "mButton.context");
        AppMethodBeat.o(219726);
        return context;
    }

    public final void clearAnimation() {
        AppMethodBeat.i(219727);
        Animator animator = this.Fj;
        if (animator != null) {
            animator.cancel();
        }
        ImageView buttonImage = this.nvw.getButtonImage();
        if (buttonImage != null) {
            buttonImage.clearAnimation();
            AppMethodBeat.o(219727);
            return;
        }
        AppMethodBeat.o(219727);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.f
    public final void P(Runnable runnable) {
        AppMethodBeat.i(219728);
        this.nvw.post(runnable);
        AppMethodBeat.o(219728);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.capsulebar.i.a
    public final void dismiss() {
        AppMethodBeat.i(219722);
        y(null);
        AppMethodBeat.o(219722);
    }
}
