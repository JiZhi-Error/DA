package com.tencent.mm.plugin.festival.finder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.live.c.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.finder.w;
import com.tencent.mm.plugin.festival.model.ParcelableFestivalWish;
import com.tencent.mm.plugin.festival.model.ab;
import com.tencent.mm.plugin.festival.ui.view.FestivalAvatarPopupSparkleWrapperLayout;
import com.tencent.mm.plugin.festival.ui.view.FestivalCdnImageView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020\u001dH\u0016J\b\u0010+\u001a\u00020#H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001dH\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\nH\u0016J&\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u00182\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\b\b\u0002\u00104\u001a\u00020\u001dH\u0002J\u001a\u00105\u001a\u00020#2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020#H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "presenter", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveContract$Presenter;)V", "CLOSE_BUTTON_MARGIN_TOP", "", "avatarIv", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCdnImageView;", "cardLayout", "Landroid/view/View;", "closeButton", "contentTv", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "currentDetailsItem", "Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish;", "enterAnimator", "Landroid/animation/Animator;", "exitAnimator", "isShown", "", "nicknameTv", "onLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "regionTv", "adjustCloseButtonBottomBoundary", "", "adjustWishCardPosition", "canClearScreen", "deleteWish", "wishModel", "dismissWishDetails", "goFriendContactProfile", "onBackPress", "onEnterAnimationComplete", "resetCloseButton", "enabled", "setVisible", "visible", "showWishDetails", "item", "clickPointF", "Landroid/graphics/PointF;", "canJumpContactProfile", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "plugin-festival_release"})
public final class bb extends p {
    final View CBl;
    private final View.OnLayoutChangeListener UqG;
    final FestivalCdnImageView Uqn;
    Animator UrM;
    Animator UrN;
    private final w.a UtL;
    final int Uvv;
    final View Uvw;
    private final TextView Uvx;
    private ParcelableFestivalWish Uvy;
    private boolean cuS;
    final com.tencent.mm.live.c.b hOp;
    private final TextView hXC;
    private final TextView pIN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bb(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, w.a aVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(aVar, "presenter");
        AppMethodBeat.i(262690);
        this.hOp = bVar;
        this.UtL = aVar;
        Context context = this.hwr.getContext();
        p.g(context, "context");
        this.Uvv = context.getResources().getDimensionPixelSize(R.dimen.bw);
        View findViewById = viewGroup.findViewById(R.id.jv4);
        if (findViewById == null) {
            p.hyc();
        }
        this.Uvw = findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.x1);
        if (findViewById2 == null) {
            p.hyc();
        }
        this.Uqn = (FestivalCdnImageView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.fzg);
        if (findViewById3 == null) {
            p.hyc();
        }
        this.pIN = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.k23);
        if (findViewById4 == null) {
            p.hyc();
        }
        this.Uvx = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.k3r);
        if (findViewById5 == null) {
            p.hyc();
        }
        this.hXC = (TextView) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.b46);
        if (findViewById6 == null) {
            p.hyc();
        }
        this.CBl = findViewById6;
        this.UqG = new g(this);
        viewGroup.setVisibility(8);
        AppMethodBeat.o(262690);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/util/FestivalViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-festival_release"})
    public static final class j implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ PointF UvF;
        final /* synthetic */ bb Uvz;
        final /* synthetic */ View nca;

        public j(View view, bb bbVar, PointF pointF) {
            this.nca = view;
            this.Uvz = bbVar;
            this.UvF = pointF;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(262680);
            this.nca.getViewTreeObserver().removeOnPreDrawListener(this);
            bb.a(this.Uvz);
            if (this.UvF != null) {
                this.Uvz.Uvw.setPivotX(android.support.v4.b.a.p(this.UvF.x - this.Uvz.Uvw.getX(), 0.0f, (float) this.Uvz.Uvw.getWidth()));
                this.Uvz.Uvw.setPivotY(android.support.v4.b.a.p(this.UvF.y - this.Uvz.Uvw.getY(), 0.0f, (float) this.Uvz.Uvw.getHeight()));
            } else {
                this.Uvz.Uvw.setPivotX(((float) this.Uvz.Uvw.getWidth()) / 2.0f);
                this.Uvz.Uvw.setPivotY(((float) this.Uvz.Uvw.getHeight()) / 2.0f);
            }
            AppMethodBeat.o(262680);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0002\b\u000e"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "<anonymous parameter 8>", "onLayoutChange"})
    static final class g implements View.OnLayoutChangeListener {
        final /* synthetic */ bb Uvz;

        g(bb bbVar) {
            this.Uvz = bbVar;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(262677);
            bb.a(this.Uvz);
            bb bbVar = this.Uvz;
            if (bbVar.CBl.isLaidOut() && bbVar.Uvw.isLaidOut()) {
                View view2 = bbVar.CBl;
                float y = bbVar.Uvw.getY() + ((float) bbVar.Uvw.getHeight()) + ((float) bbVar.Uvv);
                float y2 = bbVar.Uvw.getY() + ((float) bbVar.Uvw.getHeight());
                int height = bbVar.hwr.getHeight();
                com.tencent.mm.plugin.festival.c.j jVar = com.tencent.mm.plugin.festival.c.j.UGJ;
                Context context = bbVar.hwr.getContext();
                p.g(context, "context");
                view2.setY(android.support.v4.b.a.p(y, y2, ((float) (height - com.tencent.mm.plugin.festival.c.j.aD(context))) - ((float) bbVar.CBl.getHeight())));
            }
            AppMethodBeat.o(262677);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ bb Uvz;

        e(bb bbVar) {
            this.Uvz = bbVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262675);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$onEnterAnimationComplete$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Uvz.gEW();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$onEnterAnimationComplete$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262675);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ bb Uvz;

        f(bb bbVar) {
            this.Uvz = bbVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262676);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$onEnterAnimationComplete$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Uvz.gEW();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$onEnterAnimationComplete$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262676);
        }
    }

    private final void Fj(boolean z) {
        AppMethodBeat.i(262684);
        this.CBl.setPressed(false);
        this.CBl.setEnabled(z);
        this.CBl.setFocusable(z);
        this.CBl.setClickable(z);
        this.CBl.refreshDrawableState();
        AppMethodBeat.o(262684);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$2$1"})
    static final class h implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ bb Uvz;

        h(bb bbVar) {
            this.Uvz = bbVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(262678);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(262678);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            this.Uvz.hwr.setAlpha(floatValue);
            this.Uvz.Uvw.setScaleX(floatValue);
            this.Uvz.Uvw.setScaleY(floatValue);
            AppMethodBeat.o(262678);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$2$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
    public static final class i extends AnimatorListenerAdapter {
        final /* synthetic */ bb Uvz;

        i(bb bbVar) {
            this.Uvz = bbVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262679);
            this.Uvz.hwr.setVisibility(0);
            this.Uvz.hwr.setAlpha(1.0f);
            this.Uvz.UrM = null;
            bb bbVar = this.Uvz;
            bbVar.hwr.setOnClickListener(new e(bbVar));
            bbVar.Uvw.setClickable(true);
            bbVar.CBl.setOnClickListener(new f(bbVar));
            bbVar.Uqn.setClickable(true);
            ViewParent parent = bbVar.Uqn.getParent();
            if (!(parent instanceof FestivalAvatarPopupSparkleWrapperLayout)) {
                parent = null;
            }
            FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout = (FestivalAvatarPopupSparkleWrapperLayout) parent;
            if (festivalAvatarPopupSparkleWrapperLayout != null) {
                festivalAvatarPopupSparkleWrapperLayout.setClickable(true);
                AppMethodBeat.o(262679);
                return;
            }
            AppMethodBeat.o(262679);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$4$1$1", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$$special$$inlined$run$lambda$1"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ ParcelableFestivalWish UvG;
        final /* synthetic */ boolean UvH;
        final /* synthetic */ bb Uvz;

        l(bb bbVar, boolean z, ParcelableFestivalWish parcelableFestivalWish) {
            this.Uvz = bbVar;
            this.UvH = z;
            this.UvG = parcelableFestivalWish;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262682);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$$inlined$with$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.UvH) {
                bb.b(this.Uvz);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$$inlined$with$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262682);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$4$2"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ ParcelableFestivalWish UvG;
        final /* synthetic */ boolean UvH;
        final /* synthetic */ bb Uvz;

        m(bb bbVar, boolean z, ParcelableFestivalWish parcelableFestivalWish) {
            this.Uvz = bbVar;
            this.UvH = z;
            this.UvG = parcelableFestivalWish;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262683);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$$inlined$with$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.UvH) {
                bb.b(this.Uvz);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$$inlined$with$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262683);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$5$1"})
    static final class k implements View.OnClickListener {
        final /* synthetic */ ParcelableFestivalWish UvG;
        final /* synthetic */ bb Uvz;

        k(bb bbVar, ParcelableFestivalWish parcelableFestivalWish) {
            this.Uvz = bbVar;
            this.UvG = parcelableFestivalWish;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(262681);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bb bbVar = this.Uvz;
            ParcelableFestivalWish parcelableFestivalWish = this.UvG;
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(bbVar.hwr.getContext(), false, 1);
            eVar.hbr();
            eVar.a(new a(bbVar, parcelableFestivalWish));
            eVar.a(new b(bbVar, parcelableFestivalWish));
            eVar.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$showWishDetails$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262681);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$deleteWish$1$1"})
    static final class a implements o.f {
        final /* synthetic */ ParcelableFestivalWish UvA;
        final /* synthetic */ bb Uvz;

        a(bb bbVar, ParcelableFestivalWish parcelableFestivalWish) {
            this.Uvz = bbVar;
            this.UvA = parcelableFestivalWish;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(262669);
            mVar.a(0, Color.parseColor("#FA6262"), this.Uvz.hwr.getContext().getString(R.string.j8x));
            AppMethodBeat.o(262669);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$deleteWish$1$2"})
    static final class b implements o.g {
        final /* synthetic */ ParcelableFestivalWish UvA;
        final /* synthetic */ bb Uvz;

        b(bb bbVar, ParcelableFestivalWish parcelableFestivalWish) {
            this.Uvz = bbVar;
            this.UvA = parcelableFestivalWish;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(262672);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == 0) {
                com.tencent.mm.plugin.festival.model.a.a aVar = com.tencent.mm.plugin.festival.model.a.a.UzS;
                String str = this.UvA.UzM;
                if (str == null) {
                    p.hyc();
                }
                p.h(str, "wishId");
                of PF = new of().PF(com.tencent.mm.plugin.festival.model.a.a.hRU());
                com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
                PF.GK(com.tencent.mm.plugin.festival.model.a.b.hRV()).TA(str).Tz(z.aTY()).SM(3).SR(3).bfK();
                final q a2 = com.tencent.mm.ui.base.h.a(this.Uvz.hwr.getContext(), this.Uvz.hwr.getContext().getString(R.string.j8f), true, (DialogInterface.OnCancelListener) null);
                ab abVar = ab.UzG;
                String str2 = this.UvA.UzM;
                if (str2 == null) {
                    p.hyc();
                }
                this.Uvz.hwr.getContext();
                ab.q(str2, new kotlin.g.a.b<Boolean, x>(this) {
                    /* class com.tencent.mm.plugin.festival.finder.bb.b.AnonymousClass1 */
                    final /* synthetic */ b UvB;

                    {
                        this.UvB = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(Boolean bool) {
                        AppMethodBeat.i(262671);
                        final boolean booleanValue = bool.booleanValue();
                        this.UvB.Uvz.hwr.post(new Runnable(this) {
                            /* class com.tencent.mm.plugin.festival.finder.bb.b.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 UvD;

                            {
                                this.UvD = r1;
                            }

                            public final void run() {
                                AppMethodBeat.i(262670);
                                q qVar = a2;
                                if (qVar != null) {
                                    qVar.dismiss();
                                }
                                if (booleanValue) {
                                    u.cG(this.UvD.UvB.Uvz.hwr.getContext(), this.UvD.UvB.Uvz.hwr.getContext().getString(R.string.j8e));
                                    b.C0376b.a(this.UvD.UvB.Uvz.hOp, b.c.wMv);
                                    this.UvD.UvB.Uvz.Uvw.setPivotX(((float) this.UvD.UvB.Uvz.Uvw.getWidth()) / 2.0f);
                                    this.UvD.UvB.Uvz.Uvw.setPivotY(((float) this.UvD.UvB.Uvz.Uvw.getHeight()) / 2.0f);
                                    this.UvD.UvB.Uvz.gEW();
                                    AppMethodBeat.o(262670);
                                    return;
                                }
                                u.cH(this.UvD.UvB.Uvz.hwr.getContext(), this.UvD.UvB.Uvz.hwr.getContext().getString(R.string.j8d));
                                AppMethodBeat.o(262670);
                            }
                        });
                        x xVar = x.SXb;
                        AppMethodBeat.o(262671);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(262672);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$dismissWishDetails$1$1"})
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ bb Uvz;

        c(bb bbVar) {
            this.Uvz = bbVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(262673);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(262673);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            this.Uvz.hwr.setAlpha(floatValue);
            this.Uvz.Uvw.setScaleX(floatValue);
            this.Uvz.Uvw.setScaleY(floatValue);
            AppMethodBeat.o(262673);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveWishDetailsCardContainerPlugin$dismissWishDetails$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-festival_release"})
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ bb Uvz;

        d(bb bbVar) {
            this.Uvz = bbVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(262674);
            this.Uvz.hwr.setVisibility(8);
            this.Uvz.hwr.setBackground(null);
            this.Uvz.UrN = null;
            b.C0376b.a(this.Uvz.hOp, b.c.wsW);
            AppMethodBeat.o(262674);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262686);
        super.unMount();
        Animator animator = this.UrM;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.UrN;
        if (animator2 != null) {
            animator2.cancel();
            AppMethodBeat.o(262686);
            return;
        }
        AppMethodBeat.o(262686);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(262687);
        if (this.cuS) {
            gEW();
            AppMethodBeat.o(262687);
            return true;
        }
        AppMethodBeat.o(262687);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(262688);
        if (!this.cuS) {
            super.rg(8);
            AppMethodBeat.o(262688);
            return;
        }
        super.rg(i2);
        AppMethodBeat.o(262688);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01ee  */
    @Override // com.tencent.mm.live.c.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void statusChange(com.tencent.mm.live.c.b.c r14, android.os.Bundle r15) {
        /*
        // Method dump skipped, instructions count: 522
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.festival.finder.bb.statusChange(com.tencent.mm.live.c.b$c, android.os.Bundle):void");
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void gEW() {
        AppMethodBeat.i(262685);
        this.hwr.removeOnLayoutChangeListener(this.UqG);
        this.hwr.setClickable(false);
        this.Uvw.setClickable(false);
        Fj(false);
        this.Uqn.setClickable(false);
        ViewParent parent = this.Uqn.getParent();
        if (!(parent instanceof FestivalAvatarPopupSparkleWrapperLayout)) {
            parent = null;
        }
        FestivalAvatarPopupSparkleWrapperLayout festivalAvatarPopupSparkleWrapperLayout = (FestivalAvatarPopupSparkleWrapperLayout) parent;
        if (festivalAvatarPopupSparkleWrapperLayout != null) {
            festivalAvatarPopupSparkleWrapperLayout.setClickable(false);
        }
        this.Uvy = null;
        this.cuS = false;
        Animator animator = this.UrM;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.UrN;
        if (animator2 != null) {
            animator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(450L);
        ofFloat.addUpdateListener(new c(this));
        ofFloat.addListener(new d(this));
        ofFloat.start();
        this.UrN = ofFloat;
        AppMethodBeat.o(262685);
    }

    public static final /* synthetic */ void a(bb bbVar) {
        View view;
        int cR;
        AppMethodBeat.i(262691);
        if (bbVar.Uvw.isLaidOut()) {
            if (bbVar.Uqn.getParent() instanceof FestivalAvatarPopupSparkleWrapperLayout) {
                ViewParent parent = bbVar.Uqn.getParent();
                if (parent == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.ui.view.FestivalAvatarPopupSparkleWrapperLayout");
                    AppMethodBeat.o(262691);
                    throw tVar;
                }
                view = (FestivalAvatarPopupSparkleWrapperLayout) parent;
            } else {
                view = bbVar.Uqn;
            }
            if (view.isLaidOut()) {
                View findViewById = bbVar.Uvw.findViewById(R.id.jv5);
                if (findViewById == null) {
                    p.hyc();
                }
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (!(marginLayoutParams == null || marginLayoutParams.topMargin == (cR = kotlin.h.a.cR(((float) view.getHeight()) / 2.0f)))) {
                    marginLayoutParams.topMargin = cR;
                    findViewById.requestLayout();
                }
                float height = (((float) bbVar.hwr.getHeight()) * 0.45f) - (((float) findViewById.getHeight()) / 2.0f);
                if (height != bbVar.Uvw.getY()) {
                    bbVar.Uvw.setY(height);
                    bbVar.Uvw.requestLayout();
                }
            }
        }
        AppMethodBeat.o(262691);
    }

    public static final /* synthetic */ void b(bb bbVar) {
        String str;
        String str2;
        AppMethodBeat.i(262692);
        if (bbVar.Uvy != null) {
            com.tencent.mm.plugin.festival.model.a.a aVar = com.tencent.mm.plugin.festival.model.a.a.UzS;
            ParcelableFestivalWish parcelableFestivalWish = bbVar.Uvy;
            if (parcelableFestivalWish == null) {
                p.hyc();
            }
            p.h(parcelableFestivalWish, "wishInfo");
            of PF = new of().PF(com.tencent.mm.plugin.festival.model.a.a.hRU());
            com.tencent.mm.plugin.festival.model.a.b bVar = com.tencent.mm.plugin.festival.model.a.b.UzX;
            of TA = PF.GK(com.tencent.mm.plugin.festival.model.a.b.hRV()).TA(parcelableFestivalWish.UzM);
            if (parcelableFestivalWish.hRT()) {
                str2 = parcelableFestivalWish.username;
            } else {
                str2 = parcelableFestivalWish.UzO;
            }
            TA.Tz(str2).SM(2).SR(3).bfK();
        }
        ParcelableFestivalWish parcelableFestivalWish2 = bbVar.Uvy;
        if (parcelableFestivalWish2 != null) {
            str = parcelableFestivalWish2.username;
        } else {
            str = null;
        }
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("CONTACT_INFO_UI_SOURCE", 22);
            com.tencent.mm.br.c.b(bbVar.hwr.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(262692);
    }
}
