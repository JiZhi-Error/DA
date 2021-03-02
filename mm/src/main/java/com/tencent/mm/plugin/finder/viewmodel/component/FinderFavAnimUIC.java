package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u00011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0018\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020 J\u0010\u0010/\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0002J\b\u00100\u001a\u00020$H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "imageAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "imageFinalSize", "", "interpolator", "Landroid/view/animation/LinearInterpolator;", "pictureAnimIv", "Landroid/widget/ImageView;", "getPictureAnimIv", "()Landroid/widget/ImageView;", "setPictureAnimIv", "(Landroid/widget/ImageView;)V", "scaleRatio", "", "starAnimIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStarAnimIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setStarAnimIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "starDownAnimator", "starFinalSize", "starMiddleSize", "starOriginalSize", "starUpAnimator", "startLocation", "", "targetRect", "Landroid/graphics/Rect;", "addViewToDecor", "", "child", "Landroid/view/View;", "isAdd", "", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "animFav", "bitmap", "Landroid/graphics/Bitmap;", "startViewLocation", "animFrameImage", "animStar", "Companion", "plugin-finder_release"})
public final class FinderFavAnimUIC extends UIComponent {
    public static final g wvS = new g((byte) 0);
    public ImageView wvF;
    WeImageView wvG;
    public final int wvH;
    private final int wvI;
    private final int wvJ;
    private final int wvK;
    public float wvL = 1.0f;
    public final Rect wvM = new Rect();
    public int[] wvN;
    private final LinearInterpolator wvO = new LinearInterpolator();
    public final ValueAnimator wvP;
    private final ValueAnimator wvQ;
    private final ValueAnimator wvR;

    static {
        AppMethodBeat.i(255478);
        AppMethodBeat.o(255478);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFavAnimUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255477);
        this.wvH = appCompatActivity.getResources().getDimensionPixelSize(R.dimen.cb);
        this.wvI = appCompatActivity.getResources().getDimensionPixelSize(R.dimen.cl);
        this.wvJ = appCompatActivity.getResources().getDimensionPixelSize(R.dimen.cb);
        this.wvK = appCompatActivity.getResources().getDimensionPixelSize(R.dimen.ct);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        p.g(ofFloat, LocaleUtil.ITALIAN);
        ofFloat.setInterpolator(this.wvO);
        ofFloat.setDuration(400L);
        z.c cVar = new z.c();
        cVar.SYD = 0.0f;
        z.c cVar2 = new z.c();
        cVar2.SYD = 0.0f;
        ofFloat.addUpdateListener(new a(cVar2, cVar, this));
        ofFloat.addListener(new b(cVar, cVar2, this));
        this.wvP = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        p.g(ofFloat2, LocaleUtil.ITALIAN);
        ofFloat2.setDuration(150L);
        ofFloat2.addUpdateListener(new c(this));
        ofFloat2.addListener(new d(this));
        this.wvQ = ofFloat2;
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        p.g(ofFloat3, LocaleUtil.ITALIAN);
        ofFloat3.setDuration(300L);
        ofFloat3.setInterpolator(this.wvO);
        z.c cVar3 = new z.c();
        cVar3.SYD = 0.0f;
        z.c cVar4 = new z.c();
        cVar4.SYD = 0.0f;
        ofFloat3.addUpdateListener(new e(cVar3, cVar4, this));
        ofFloat3.addListener(new f(cVar3, cVar4, this));
        this.wvR = ofFloat3;
        AppMethodBeat.o(255477);
    }

    public static final /* synthetic */ void a(FinderFavAnimUIC finderFavAnimUIC, View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(255480);
        finderFavAnimUIC.a(view, true, layoutParams);
        AppMethodBeat.o(255480);
    }

    public static final /* synthetic */ int[] b(FinderFavAnimUIC finderFavAnimUIC) {
        AppMethodBeat.i(255479);
        int[] iArr = finderFavAnimUIC.wvN;
        if (iArr == null) {
            p.btv("startLocation");
        }
        AppMethodBeat.o(255479);
        return iArr;
    }

    public static final /* synthetic */ void e(FinderFavAnimUIC finderFavAnimUIC) {
        AppMethodBeat.i(255481);
        finderFavAnimUIC.dIa();
        AppMethodBeat.o(255481);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$1"})
    static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ z.c wvT;
        final /* synthetic */ z.c wvU;
        final /* synthetic */ FinderFavAnimUIC wvV;

        a(z.c cVar, z.c cVar2, FinderFavAnimUIC finderFavAnimUIC) {
            this.wvT = cVar;
            this.wvU = cVar2;
            this.wvV = finderFavAnimUIC;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(255465);
            ImageView imageView = this.wvV.wvF;
            if (imageView != null) {
                p.g(valueAnimator, "anim");
                float animatedFraction = 1.0f - (valueAnimator.getAnimatedFraction() * (1.0f - this.wvV.wvL));
                imageView.setScaleX(animatedFraction);
                imageView.setScaleY(animatedFraction);
                imageView.setTranslationX(((float) FinderFavAnimUIC.b(this.wvV)[0]) + ((this.wvT.SYD - ((float) FinderFavAnimUIC.b(this.wvV)[0])) * valueAnimator.getAnimatedFraction()));
                imageView.setTranslationY(((float) FinderFavAnimUIC.b(this.wvV)[1]) + ((this.wvU.SYD - ((float) FinderFavAnimUIC.b(this.wvV)[1])) * valueAnimator.getAnimatedFraction()));
                AppMethodBeat.o(255465);
                return;
            }
            AppMethodBeat.o(255465);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ z.c wvT;
        final /* synthetic */ z.c wvU;
        final /* synthetic */ FinderFavAnimUIC wvV;

        b(z.c cVar, z.c cVar2, FinderFavAnimUIC finderFavAnimUIC) {
            this.wvU = cVar;
            this.wvT = cVar2;
            this.wvV = finderFavAnimUIC;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(255466);
            ImageView imageView = this.wvV.wvF;
            if (imageView != null) {
                FinderFavAnimUIC.a(this.wvV, imageView, new ViewGroup.LayoutParams(-1, -2));
                imageView.setVisibility(0);
                imageView.setScaleX(1.0f);
                imageView.setScaleY(1.0f);
                imageView.setPivotY(0.0f);
                imageView.setTranslationX((float) FinderFavAnimUIC.b(this.wvV)[0]);
                imageView.setTranslationY((float) FinderFavAnimUIC.b(this.wvV)[1]);
                this.wvU.SYD = ((float) this.wvV.wvM.top) + (((float) (this.wvV.wvM.height() - this.wvV.wvH)) / 2.0f);
                this.wvT.SYD = ((float) this.wvV.wvM.left) + (((float) (this.wvV.wvM.width() - this.wvV.wvH)) / 2.0f);
                AppMethodBeat.o(255466);
                return;
            }
            AppMethodBeat.o(255466);
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            AppMethodBeat.i(255467);
            ImageView imageView = this.wvV.wvF;
            if (imageView != null) {
                FinderFavAnimUIC.a(this.wvV, imageView);
            }
            FinderFavAnimUIC.e(this.wvV);
            AppMethodBeat.o(255467);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$1"})
    static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderFavAnimUIC wvV;

        c(FinderFavAnimUIC finderFavAnimUIC) {
            this.wvV = finderFavAnimUIC;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(255468);
            WeImageView weImageView = this.wvV.wvG;
            if (weImageView != null) {
                p.g(valueAnimator, "anim");
                float animatedFraction = 1.0f - (valueAnimator.getAnimatedFraction() * (1.0f - (((float) this.wvV.wvJ) / ((float) this.wvV.wvI))));
                weImageView.setScaleX(animatedFraction);
                weImageView.setScaleY(animatedFraction);
                weImageView.setTranslationX((((1.0f - animatedFraction) * ((float) weImageView.getWidth())) / 2.0f) + ((float) this.wvV.wvM.left));
                AppMethodBeat.o(255468);
                return;
            }
            AppMethodBeat.o(255468);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ FinderFavAnimUIC wvV;

        d(FinderFavAnimUIC finderFavAnimUIC) {
            this.wvV = finderFavAnimUIC;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(255469);
            WeImageView weImageView = this.wvV.wvG;
            if (weImageView != null) {
                weImageView.setVisibility(0);
                FinderFavAnimUIC.a(this.wvV, weImageView, new ViewGroup.LayoutParams(this.wvV.wvI, this.wvV.wvI));
                weImageView.setScaleX(1.0f);
                weImageView.setScaleY(1.0f);
                weImageView.setPivotY(0.0f);
                weImageView.setAlpha(1.0f);
                weImageView.setTranslationX((float) this.wvV.wvM.left);
                weImageView.setTranslationY((float) this.wvV.wvM.top);
                AppMethodBeat.o(255469);
                return;
            }
            AppMethodBeat.o(255469);
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            AppMethodBeat.i(255470);
            this.wvV.wvR.start();
            AppMethodBeat.o(255470);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$1"})
    static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ FinderFavAnimUIC wvV;
        final /* synthetic */ z.c wvW;
        final /* synthetic */ z.c wvX;

        e(z.c cVar, z.c cVar2, FinderFavAnimUIC finderFavAnimUIC) {
            this.wvW = cVar;
            this.wvX = cVar2;
            this.wvV = finderFavAnimUIC;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(255471);
            WeImageView weImageView = this.wvV.wvG;
            if (weImageView != null) {
                p.g(valueAnimator, "anim");
                if (valueAnimator.getAnimatedFraction() <= 0.5f) {
                    float animatedFraction = this.wvW.SYD - ((valueAnimator.getAnimatedFraction() * 2.0f) * (this.wvW.SYD - (((float) this.wvV.wvK) / ((float) this.wvV.wvI))));
                    weImageView.setScaleX(animatedFraction);
                    weImageView.setScaleY(animatedFraction);
                    weImageView.setTranslationY(this.wvX.SYD + (valueAnimator.getAnimatedFraction() * ((float) this.wvV.wvJ) * 2.0f));
                    weImageView.setTranslationX((((1.0f - animatedFraction) * ((float) weImageView.getWidth())) / 2.0f) + ((float) this.wvV.wvM.left));
                }
                weImageView.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
                AppMethodBeat.o(255471);
                return;
            }
            AppMethodBeat.o(255471);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
    public static final class f extends AnimatorListenerAdapter {
        final /* synthetic */ FinderFavAnimUIC wvV;
        final /* synthetic */ z.c wvW;
        final /* synthetic */ z.c wvX;

        f(z.c cVar, z.c cVar2, FinderFavAnimUIC finderFavAnimUIC) {
            this.wvW = cVar;
            this.wvX = cVar2;
            this.wvV = finderFavAnimUIC;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(255472);
            WeImageView weImageView = this.wvV.wvG;
            if (weImageView != null) {
                this.wvW.SYD = weImageView.getScaleX();
                this.wvX.SYD = weImageView.getTranslationY();
                AppMethodBeat.o(255472);
                return;
            }
            AppMethodBeat.o(255472);
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            AppMethodBeat.i(255473);
            WeImageView weImageView = this.wvV.wvG;
            if (weImageView != null) {
                FinderFavAnimUIC.a(this.wvV, weImageView);
                AppMethodBeat.o(255473);
                return;
            }
            AppMethodBeat.o(255473);
        }
    }

    public final void dIa() {
        AppMethodBeat.i(255474);
        Log.i("FinderFavAnimUIC", "[animStar]");
        if (this.wvG == null) {
            FinderFavAnimUIC finderFavAnimUIC = this;
            finderFavAnimUIC.wvG = new WeImageView(finderFavAnimUIC.getActivity());
            x xVar = x.SXb;
        }
        WeImageView weImageView = this.wvG;
        if (weImageView != null) {
            weImageView.setImageResource(R.raw.finder_fav_anim_start);
            weImageView.setIconColor(getActivity().getResources().getColor(R.color.Yellow_100));
            this.wvR.cancel();
            this.wvQ.start();
            AppMethodBeat.o(255474);
            return;
        }
        AppMethodBeat.o(255474);
    }

    static /* synthetic */ void a(FinderFavAnimUIC finderFavAnimUIC, View view) {
        AppMethodBeat.i(255476);
        finderFavAnimUIC.a(view, false, (ViewGroup.LayoutParams) null);
        AppMethodBeat.o(255476);
    }

    private final void a(View view, boolean z, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(255475);
        if (z) {
            if (view.getParent() != null) {
                Log.i("FinderFavAnimUIC", "addViewToDecor: view already has parent view");
                Window window = getActivity().getWindow();
                p.g(window, "activity.window");
                View decorView = window.getDecorView();
                if (decorView == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(255475);
                    throw tVar;
                }
                ((ViewGroup) decorView).removeView(view);
            }
            Window window2 = getActivity().getWindow();
            p.g(window2, "activity.window");
            View decorView2 = window2.getDecorView();
            if (decorView2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(255475);
                throw tVar2;
            }
            ((ViewGroup) decorView2).addView(view, layoutParams);
            AppMethodBeat.o(255475);
            return;
        }
        Window window3 = getActivity().getWindow();
        p.g(window3, "activity.window");
        View decorView3 = window3.getDecorView();
        if (decorView3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(255475);
            throw tVar3;
        }
        ((ViewGroup) decorView3).removeView(view);
        AppMethodBeat.o(255475);
    }
}
