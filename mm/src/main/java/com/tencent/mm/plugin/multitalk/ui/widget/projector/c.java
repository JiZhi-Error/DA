package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenAvatarNavAnimatorUI;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "isDoAnimationEnd", "", "mContentRoot", "Landroid/widget/RelativeLayout;", "mMainIconViewBg", "Landroid/view/View;", "mScreenProjectNavTv", "Landroid/widget/TextView;", "mUiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "runnable", "Ljava/lang/Runnable;", "screenNavBg", "screenProjectIconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "screenProjectMainIconIv", "doAnimationHide", "", "getNavLayout", "reachAnimationEnd", "releaseAnimation", "showScreenAvatarNav", "showScreenIconAvatar", "visible", "", "Companion", "plugin-multitalk_release"})
public final class c {
    public static final a zVZ = new a((byte) 0);
    Context context;
    private Runnable dQN = new RunnableC1497c(this);
    private MMHandler kAn;
    View lJI;
    WeImageView zVS;
    View zVT;
    private View zVU;
    private TextView zVV;
    private WeImageView zVW;
    private boolean zVX;
    private RelativeLayout zVY;

    static {
        AppMethodBeat.i(239918);
        AppMethodBeat.o(239918);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenAvatarNavAnimatorUI$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c(Context context2) {
        p.h(context2, "context");
        AppMethodBeat.i(239917);
        this.context = context2;
        AppMethodBeat.o(239917);
    }

    public final void a(RelativeLayout relativeLayout) {
        View view;
        View view2;
        TextView textView;
        WeImageView weImageView;
        AppMethodBeat.i(239912);
        p.h(relativeLayout, "rootView");
        this.lJI = relativeLayout;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bob, relativeLayout);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
            AppMethodBeat.o(239912);
            throw tVar;
        }
        this.zVY = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = this.zVY;
        this.zVS = relativeLayout2 != null ? (WeImageView) relativeLayout2.findViewById(R.id.hc2) : null;
        WeImageView weImageView2 = this.zVS;
        if (weImageView2 != null) {
            weImageView2.setImageDrawable(ar.m(relativeLayout.getContext(), R.raw.icons_filled_board, -1));
        }
        WeImageView weImageView3 = this.zVS;
        if (weImageView3 != null) {
            weImageView3.setIconColor(-1);
        }
        RelativeLayout relativeLayout3 = this.zVY;
        if (relativeLayout3 != null) {
            view = relativeLayout3.findViewById(R.id.hc3);
        } else {
            view = null;
        }
        this.zVT = view;
        RelativeLayout relativeLayout4 = this.zVY;
        if (relativeLayout4 != null) {
            view2 = relativeLayout4.findViewById(R.id.fos);
        } else {
            view2 = null;
        }
        this.zVU = view2;
        View view3 = this.zVU;
        if (view3 != null) {
            Context context2 = relativeLayout.getContext();
            Context context3 = relativeLayout.getContext();
            p.g(context3, "rootView.context");
            view3.setBackground(ar.m(context2, R.drawable.ak6, context3.getResources().getColor(R.color.Blue)));
        }
        View view4 = this.zVU;
        if (view4 != null) {
            view4.setVisibility(4);
        }
        RelativeLayout relativeLayout5 = this.zVY;
        if (relativeLayout5 != null) {
            textView = (TextView) relativeLayout5.findViewById(R.id.hc4);
        } else {
            textView = null;
        }
        this.zVV = textView;
        RelativeLayout relativeLayout6 = this.zVY;
        if (relativeLayout6 != null) {
            weImageView = (WeImageView) relativeLayout6.findViewById(R.id.foy);
        } else {
            weImageView = null;
        }
        this.zVW = weImageView;
        WeImageView weImageView4 = this.zVW;
        if (weImageView4 != null) {
            weImageView4.setVisibility(8);
            AppMethodBeat.o(239912);
            return;
        }
        AppMethodBeat.o(239912);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.projector.c$c  reason: collision with other inner class name */
    static final class RunnableC1497c implements Runnable {
        final /* synthetic */ c zWa;

        RunnableC1497c(c cVar) {
            this.zWa = cVar;
        }

        public final void run() {
            ViewPropertyAnimator animate;
            ViewPropertyAnimator alpha;
            ViewPropertyAnimator duration;
            ViewPropertyAnimator withStartAction;
            AppMethodBeat.i(239911);
            if (!this.zWa.zVX) {
                c cVar = this.zWa;
                View view = cVar.zVT;
                if (view != null) {
                    view.clearAnimation();
                }
                WeImageView weImageView = cVar.zVS;
                if (weImageView != null) {
                    weImageView.setVisibility(0);
                }
                View view2 = cVar.zVT;
                if (!(view2 == null || (animate = view2.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(100)) == null || (withStartAction = duration.withStartAction(new b(cVar))) == null)) {
                    withStartAction.start();
                    AppMethodBeat.o(239911);
                    return;
                }
            }
            AppMethodBeat.o(239911);
        }
    }

    public final void epl() {
        AppMethodBeat.i(239913);
        this.zVX = false;
        this.kAn = new MMHandler("ScreenAvatarNavAnimatorUI_Hide" + hashCode());
        WeImageView weImageView = this.zVS;
        if (weImageView != null) {
            weImageView.setVisibility(0);
        }
        TextView textView = this.zVV;
        if (textView != null) {
            textView.setVisibility(0);
        }
        View view = this.zVT;
        if (view != null) {
            view.setVisibility(0);
        }
        WeImageView weImageView2 = this.zVW;
        if (weImageView2 != null) {
            weImageView2.setVisibility(8);
        }
        MMHandler mMHandler = this.kAn;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
        }
        MMHandler mMHandler2 = this.kAn;
        if (mMHandler2 != null) {
            mMHandler2.postUIDelayed(this.dQN, 5000);
            AppMethodBeat.o(239913);
            return;
        }
        AppMethodBeat.o(239913);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ c zWa;

        b(c cVar) {
            this.zWa = cVar;
        }

        public final void run() {
            int i2;
            int i3;
            int i4;
            ViewPropertyAnimator animate;
            ViewPropertyAnimator translationX;
            ViewPropertyAnimator translationY;
            ViewPropertyAnimator duration;
            AppMethodBeat.i(239910);
            TextView textView = this.zWa.zVV;
            if (textView != null) {
                textView.setVisibility(4);
            }
            WeImageView weImageView = this.zWa.zVS;
            if (weImageView != null) {
                weImageView.setVisibility(0);
            }
            WeImageView weImageView2 = this.zWa.zVS;
            if (weImageView2 != null) {
                weImageView2.clearAnimation();
            }
            int i5 = -at.fromDPToPix(this.zWa.context, 4);
            View view = this.zWa.lJI;
            if (view != null) {
                i2 = view.getWidth();
            } else {
                i2 = 0;
            }
            int fromDPToPix = i2 - at.fromDPToPix(this.zWa.context, 32);
            WeImageView weImageView3 = this.zWa.zVS;
            int left = fromDPToPix - (weImageView3 != null ? weImageView3.getLeft() : 0);
            WeImageView weImageView4 = this.zWa.zVS;
            if (!(weImageView4 == null || (animate = weImageView4.animate()) == null || (translationX = animate.translationX((float) left)) == null || (translationY = translationX.translationY((float) i5)) == null || (duration = translationY.setDuration(300)) == null)) {
                duration.start();
            }
            int[] iArr = new int[2];
            View view2 = this.zWa.lJI;
            if (view2 != null) {
                i3 = view2.getWidth();
            } else {
                i3 = 0;
            }
            iArr[0] = i3;
            iArr[1] = at.fromDPToPix(this.zWa.context, 28);
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("sizeW", iArr);
            int[] iArr2 = new int[2];
            View view3 = this.zWa.lJI;
            if (view3 != null) {
                i4 = view3.getHeight();
            } else {
                i4 = 0;
            }
            iArr2[0] = i4;
            iArr2[1] = at.fromDPToPix(this.zWa.context, 28);
            ValueAnimator duration2 = ValueAnimator.ofPropertyValuesHolder(ofInt, PropertyValuesHolder.ofInt("sizeH", iArr2), PropertyValuesHolder.ofInt("marginBottom", 0, at.fromDPToPix(this.zWa.context, 8)), PropertyValuesHolder.ofInt("marginEnd", 0, at.fromDPToPix(this.zWa.context, 8))).setDuration(300L);
            duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                /* class com.tencent.mm.plugin.multitalk.ui.widget.projector.c.b.AnonymousClass1 */
                final /* synthetic */ b zWb;

                {
                    this.zWb = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup.LayoutParams layoutParams;
                    ViewGroup.LayoutParams layoutParams2;
                    AppMethodBeat.i(239909);
                    WeImageView weImageView = this.zWb.zWa.zVS;
                    if (weImageView != null) {
                        weImageView.setVisibility(0);
                    }
                    View view = this.zWb.zWa.zVU;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    View view2 = this.zWb.zWa.zVU;
                    if (!(view2 == null || (layoutParams2 = view2.getLayoutParams()) == null)) {
                        Object animatedValue = valueAnimator.getAnimatedValue("sizeW");
                        if (animatedValue == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(239909);
                            throw tVar;
                        }
                        layoutParams2.width = ((Integer) animatedValue).intValue();
                    }
                    View view3 = this.zWb.zWa.zVU;
                    if (!(view3 == null || (layoutParams = view3.getLayoutParams()) == null)) {
                        Object animatedValue2 = valueAnimator.getAnimatedValue("sizeH");
                        if (animatedValue2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                            AppMethodBeat.o(239909);
                            throw tVar2;
                        }
                        layoutParams.height = ((Integer) animatedValue2).intValue();
                    }
                    View view4 = this.zWb.zWa.zVU;
                    ViewGroup.LayoutParams layoutParams3 = view4 != null ? view4.getLayoutParams() : null;
                    if (layoutParams3 == null) {
                        t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(239909);
                        throw tVar3;
                    }
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                    Object animatedValue3 = valueAnimator.getAnimatedValue("marginBottom");
                    if (animatedValue3 == null) {
                        t tVar4 = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(239909);
                        throw tVar4;
                    }
                    layoutParams4.bottomMargin = ((Integer) animatedValue3).intValue();
                    View view5 = this.zWb.zWa.zVU;
                    ViewGroup.LayoutParams layoutParams5 = view5 != null ? view5.getLayoutParams() : null;
                    if (layoutParams5 == null) {
                        t tVar5 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(239909);
                        throw tVar5;
                    }
                    RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
                    Object animatedValue4 = valueAnimator.getAnimatedValue("marginEnd");
                    if (animatedValue4 == null) {
                        t tVar6 = new t("null cannot be cast to non-null type kotlin.Int");
                        AppMethodBeat.o(239909);
                        throw tVar6;
                    }
                    layoutParams6.setMarginEnd(((Integer) animatedValue4).intValue());
                    View view6 = this.zWb.zWa.zVU;
                    if (view6 != null) {
                        view6.requestLayout();
                        AppMethodBeat.o(239909);
                        return;
                    }
                    AppMethodBeat.o(239909);
                }
            });
            duration2.start();
            AppMethodBeat.o(239910);
        }
    }

    public final void Rw(int i2) {
        AppMethodBeat.i(239914);
        Log.i("MicroMsg.ScreenAvatarNavAnimatorUI", "showScreenIconAvatar ".concat(String.valueOf(i2)));
        View view = this.lJI;
        if (view != null) {
            view.setVisibility(0);
        }
        WeImageView weImageView = this.zVW;
        if (weImageView != null) {
            weImageView.setImageDrawable(ar.m(this.context, R.raw.icons_filled_board, this.context.getResources().getColor(R.color.am)));
        }
        WeImageView weImageView2 = this.zVW;
        if (weImageView2 != null) {
            weImageView2.setIconColor(this.context.getResources().getColor(R.color.am));
        }
        WeImageView weImageView3 = this.zVW;
        if (weImageView3 != null) {
            weImageView3.setVisibility(i2);
        }
        View view2 = this.zVU;
        if (view2 != null) {
            view2.setVisibility(i2);
        }
        WeImageView weImageView4 = this.zVS;
        if (weImageView4 != null) {
            weImageView4.setVisibility(8);
        }
        View view3 = this.zVT;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        TextView textView = this.zVV;
        if (textView != null) {
            textView.setVisibility(8);
            AppMethodBeat.o(239914);
            return;
        }
        AppMethodBeat.o(239914);
    }

    public final void epm() {
        AppMethodBeat.i(239915);
        MMHandler mMHandler = this.kAn;
        if (mMHandler != null) {
            mMHandler.removeCallbacks(this.dQN);
        }
        MMHandler mMHandler2 = this.kAn;
        if (mMHandler2 != null) {
            mMHandler2.removeCallbacksAndMessages(null);
        }
        MMHandler mMHandler3 = this.kAn;
        if (mMHandler3 != null) {
            mMHandler3.quitSafely();
        }
        View view = this.zVT;
        if (view != null) {
            view.clearAnimation();
        }
        WeImageView weImageView = this.zVS;
        if (weImageView != null) {
            weImageView.clearAnimation();
        }
        Rw(0);
        this.zVX = true;
        WeImageView weImageView2 = this.zVS;
        if (weImageView2 != null) {
            weImageView2.setVisibility(8);
        }
        View view2 = this.zVT;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        TextView textView = this.zVV;
        if (textView != null) {
            textView.setVisibility(8);
            AppMethodBeat.o(239915);
            return;
        }
        AppMethodBeat.o(239915);
    }

    public final void epn() {
        AppMethodBeat.i(239916);
        this.zVX = true;
        MMHandler mMHandler = this.kAn;
        if (mMHandler != null) {
            mMHandler.removeCallbacks(this.dQN);
        }
        MMHandler mMHandler2 = this.kAn;
        if (mMHandler2 != null) {
            mMHandler2.removeCallbacksAndMessages(null);
        }
        MMHandler mMHandler3 = this.kAn;
        if (mMHandler3 != null) {
            mMHandler3.quitSafely();
        }
        View view = this.zVT;
        if (view != null) {
            view.clearAnimation();
        }
        WeImageView weImageView = this.zVS;
        if (weImageView != null) {
            weImageView.clearAnimation();
            AppMethodBeat.o(239916);
            return;
        }
        AppMethodBeat.o(239916);
    }
}
