package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(J*\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010.\u001a\u00020&H\u0002J\u001a\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u00101\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u00102\u001a\u00020\rJ\u0018\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014J\u0010\u00106\u001a\u00020&2\b\u0010$\u001a\u0004\u0018\u00010\u0014J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0017J\u0012\u0010:\u001a\u00020&2\b\b\u0002\u00100\u001a\u00020\rH\u0002J\b\u0010;\u001a\u00020&H\u0002J\u0016\u0010<\u001a\u00020&2\u0006\u0010+\u001a\u00020\r2\u0006\u00100\u001a\u00020\rJ\u0010\u0010=\u001a\u00020&2\u0006\u00100\u001a\u00020\rH\u0002J\u0010\u0010>\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010?\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasGetInfoIconLocation", "", "hasGetLoadingIconLocation", "infoIcon", "Landroid/widget/ImageView;", "infoIconLocation", "", "infoLayout", "Landroid/view/View;", "isInfoLayoutShowing", "isLoadingShow", "loadingAnimation", "Landroid/view/animation/Animation;", "loadingIcon", "loadingIconLocation", "loadingIconTranslating", "loadingLayout", "needTranslateInfoIcon", "opButton", "Landroid/widget/TextView;", "pendingShowInfoLayout", "pendingShowLoading", "pendingShowLoadingWithAnimation", "root", "successMark", "animateSwitch", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "animateViewAlpha", "view", "show", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "cancelLoadingAnimation", "dismissInfoView", "withAnimation", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isShowLoadingView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "showInfoView", "viewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "showInfoViewInternal", "showInfoViewWithAnimation", "showLoadingView", "showLoadingViewInternal", "updateInfoLayout", "updateOpButton", "Companion", "plugin-scan_release"})
public final class ScanInfoMaskView extends LinearLayout implements com.tencent.mm.plugin.scanner.view.a {
    public static final a CSg = new a((byte) 0);
    public View BCP;
    public boolean CGG;
    private View CRS;
    private View CRT;
    public TextView CRU;
    private int[] CRV;
    private Animation CRW;
    public boolean CRX;
    private boolean CRY;
    private int[] CRZ;
    public boolean CSa;
    public boolean CSb;
    private boolean CSc;
    public boolean CSd;
    public boolean CSe;
    public boolean CSf;
    private View gvQ;
    public ImageView jBH;
    public View xcd;

    static {
        AppMethodBeat.i(240665);
        AppMethodBeat.o(240665);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$Companion;", "", "()V", "ANIMATION_DURATION", "", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ View a(ScanInfoMaskView scanInfoMaskView) {
        AppMethodBeat.i(240666);
        View view = scanInfoMaskView.BCP;
        if (view == null) {
            p.btv("infoLayout");
        }
        AppMethodBeat.o(240666);
        return view;
    }

    public static final /* synthetic */ TextView b(ScanInfoMaskView scanInfoMaskView) {
        AppMethodBeat.i(240667);
        TextView textView = scanInfoMaskView.CRU;
        if (textView == null) {
            p.btv("opButton");
        }
        AppMethodBeat.o(240667);
        return textView;
    }

    public static final /* synthetic */ ImageView c(ScanInfoMaskView scanInfoMaskView) {
        AppMethodBeat.i(240668);
        ImageView imageView = scanInfoMaskView.jBH;
        if (imageView == null) {
            p.btv("infoIcon");
        }
        AppMethodBeat.o(240668);
        return imageView;
    }

    public static final /* synthetic */ void d(ScanInfoMaskView scanInfoMaskView) {
        AppMethodBeat.i(240669);
        scanInfoMaskView.eRC();
        AppMethodBeat.o(240669);
    }

    public static final /* synthetic */ View f(ScanInfoMaskView scanInfoMaskView) {
        AppMethodBeat.i(240670);
        View view = scanInfoMaskView.CRT;
        if (view == null) {
            p.btv("loadingIcon");
        }
        AppMethodBeat.o(240670);
        return view;
    }

    public static final /* synthetic */ View h(ScanInfoMaskView scanInfoMaskView) {
        AppMethodBeat.i(240671);
        View view = scanInfoMaskView.xcd;
        if (view == null) {
            p.btv("loadingLayout");
        }
        AppMethodBeat.o(240671);
        return view;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanInfoMaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(240663);
        AppMethodBeat.o(240663);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanInfoMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(240664);
        this.CRV = new int[2];
        this.CRZ = new int[2];
        this.CSf = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.az5, this);
        View findViewById = inflate.findViewById(R.id.h8y);
        p.g(findViewById, "view.findViewById(R.id.root_container)");
        this.gvQ = findViewById;
        View findViewById2 = inflate.findViewById(R.id.ha9);
        p.g(findViewById2, "view.findViewById(R.id.scan_loading_layout)");
        this.xcd = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.ha8);
        p.g(findViewById3, "view.findViewById(R.id.scan_loading_icon)");
        this.CRT = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.haj);
        p.g(findViewById4, "view.findViewById(R.id.scan_result_info_layout)");
        this.BCP = findViewById4;
        View findViewById5 = inflate.findViewById(R.id.hai);
        p.g(findViewById5, "view.findViewById(R.id.scan_result_info_icon)");
        this.jBH = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.hak);
        p.g(findViewById6, "view.findViewById(R.id.scan_result_info_op_button)");
        this.CRU = (TextView) findViewById6;
        View view = this.gvQ;
        if (view == null) {
            p.btv("root");
        }
        view.setOnTouchListener(c.CSi);
        View view2 = this.BCP;
        if (view2 == null) {
            p.btv("infoLayout");
        }
        TextView textView = (TextView) view2.findViewById(R.id.ham);
        if (textView != null) {
            ao.a(textView.getPaint(), 0.8f);
        }
        TextView textView2 = this.CRU;
        if (textView2 == null) {
            p.btv("opButton");
        }
        ao.a(textView2.getPaint(), 0.8f);
        AppMethodBeat.o(240664);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(240657);
        super.onMeasure(i2, i3);
        if (!this.CSa) {
            ImageView imageView = this.jBH;
            if (imageView == null) {
                p.btv("infoIcon");
            }
            imageView.getLocationInWindow(this.CRZ);
        }
        if (!this.CRX) {
            View view = this.CRT;
            if (view == null) {
                p.btv("loadingIcon");
            }
            view.getLocationInWindow(this.CRV);
        }
        Log.d("MicroMsg.ScanInfoMaskView", "alvinluo onMeasure infoIcon location: %d, %d, loadingIcon location: %d, %d, pendingShowInfoLayout: %b, pendingShowLoading: %b, hasGetInfoIconLocation: %b, hasGetLoadingIconLocation: %b", Integer.valueOf(this.CRZ[0]), Integer.valueOf(this.CRZ[1]), Integer.valueOf(this.CRV[0]), Integer.valueOf(this.CRV[1]), Boolean.valueOf(this.CSb), Boolean.valueOf(this.CSd), Boolean.valueOf(this.CSa), Boolean.valueOf(this.CRX));
        if (!(this.CRZ[0] == 0 && this.CRZ[1] == 0)) {
            this.CSa = true;
            if (this.CSb) {
                ud(true);
            } else if (!this.CSc) {
                View view2 = this.BCP;
                if (view2 == null) {
                    p.btv("infoLayout");
                }
                view2.setVisibility(8);
            }
        }
        if (!(this.CRV[0] == 0 && this.CRV[1] == 0)) {
            this.CRX = true;
            if (this.CSd) {
                ue(this.CSe);
                AppMethodBeat.o(240657);
                return;
            } else if (!this.CGG) {
                View view3 = this.xcd;
                if (view3 == null) {
                    p.btv("loadingLayout");
                }
                view3.setVisibility(8);
            }
        }
        AppMethodBeat.o(240657);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class c implements View.OnTouchListener {
        public static final c CSi = new c();

        static {
            AppMethodBeat.i(240649);
            AppMethodBeat.o(240649);
        }

        c() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public final void setAnchorView(View view) {
        this.CRS = view;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ ScanInfoMaskView CSj;

        public d(ScanInfoMaskView scanInfoMaskView) {
            this.CSj = scanInfoMaskView;
        }

        public final void run() {
            AppMethodBeat.i(240650);
            this.CSj.requestLayout();
            AppMethodBeat.o(240650);
        }
    }

    public static void a(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator listener;
        AppMethodBeat.i(240658);
        view.setAlpha(1.0f);
        Log.i("MicroMsg.ScanInfoMaskView", "alvinluo animateViewAlpha view: %s, show: %b", view, Boolean.FALSE);
        ViewPropertyAnimator animate = view.animate();
        if (animate == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(150)) == null || (listener = duration.setListener(new b(view, animatorListenerAdapter))) == null) {
            AppMethodBeat.o(240658);
            return;
        }
        listener.start();
        AppMethodBeat.o(240658);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$animateViewAlpha$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationPause", "onAnimationRepeat", "onAnimationResume", "onAnimationStart", "plugin-scan_release"})
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorListenerAdapter CSh;
        final /* synthetic */ View hCI;
        final /* synthetic */ boolean rti = false;

        b(View view, AnimatorListenerAdapter animatorListenerAdapter) {
            this.hCI = view;
            this.CSh = animatorListenerAdapter;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(240643);
            this.hCI.setVisibility(this.rti ? 0 : 8);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
                AppMethodBeat.o(240643);
                return;
            }
            AppMethodBeat.o(240643);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(240644);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(animator);
                AppMethodBeat.o(240644);
                return;
            }
            AppMethodBeat.o(240644);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(240645);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationRepeat(animator);
                AppMethodBeat.o(240645);
                return;
            }
            AppMethodBeat.o(240645);
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(240646);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationStart(animator);
                AppMethodBeat.o(240646);
                return;
            }
            AppMethodBeat.o(240646);
        }

        public final void onAnimationPause(Animator animator) {
            AppMethodBeat.i(240647);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationPause(animator);
                AppMethodBeat.o(240647);
                return;
            }
            AppMethodBeat.o(240647);
        }

        public final void onAnimationResume(Animator animator) {
            AppMethodBeat.i(240648);
            AnimatorListenerAdapter animatorListenerAdapter = this.CSh;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationResume(animator);
                AppMethodBeat.o(240648);
                return;
            }
            AppMethodBeat.o(240648);
        }
    }

    public final void ud(boolean z) {
        AppMethodBeat.i(240659);
        this.CSb = false;
        this.CSc = true;
        setVisibility(0);
        View view = this.BCP;
        if (view == null) {
            p.btv("infoLayout");
        }
        view.setVisibility(0);
        View view2 = this.xcd;
        if (view2 == null) {
            p.btv("loadingLayout");
        }
        view2.setVisibility(8);
        View view3 = this.CRS;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        if (!z) {
            setVisibility(0);
            View view4 = this.BCP;
            if (view4 == null) {
                p.btv("infoLayout");
            }
            view4.setAlpha(1.0f);
            AppMethodBeat.o(240659);
            return;
        }
        eRB();
        AppMethodBeat.o(240659);
    }

    private final void eRB() {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator updateListener;
        AppMethodBeat.i(240660);
        Log.v("MicroMsg.ScanInfoMaskView", "alvinluo showInfoViewWithAnimation");
        if (this.CRS == null) {
            AppMethodBeat.o(240660);
            return;
        }
        View view = this.CRS;
        if (view == null) {
            p.hyc();
        }
        float translationX = view.getTranslationX() - ((float) this.CRZ[0]);
        View view2 = this.CRS;
        if (view2 == null) {
            p.hyc();
        }
        float paddingLeft = ((float) view2.getPaddingLeft()) + translationX;
        View view3 = this.CRS;
        if (view3 == null) {
            p.hyc();
        }
        float translationY = view3.getTranslationY() - ((float) this.CRZ[1]);
        View view4 = this.CRS;
        if (view4 == null) {
            p.hyc();
        }
        float paddingTop = ((float) view4.getPaddingTop()) + translationY;
        ImageView imageView = this.jBH;
        if (imageView == null) {
            p.btv("infoIcon");
        }
        imageView.setTranslationX(paddingLeft);
        ImageView imageView2 = this.jBH;
        if (imageView2 == null) {
            p.btv("infoIcon");
        }
        imageView2.setTranslationY(paddingTop);
        View view5 = this.BCP;
        if (view5 == null) {
            p.btv("infoLayout");
        }
        view5.setAlpha(0.0f);
        View view6 = this.CRS;
        if (view6 == null) {
            p.hyc();
        }
        view6.setVisibility(0);
        view6.setAlpha(1.0f);
        view6.setScaleX(1.0f);
        view6.setScaleY(1.0f);
        View view7 = this.CRS;
        if (view7 == null) {
            p.hyc();
        }
        ViewPropertyAnimator animate = view7.animate();
        if (!(animate == null || (alpha = animate.alpha(0.0f)) == null)) {
            float f2 = (float) this.CRZ[1];
            View view8 = this.CRS;
            if (view8 == null) {
                p.hyc();
            }
            ViewPropertyAnimator translationY2 = alpha.translationY(f2 - ((float) view8.getPaddingTop()));
            if (translationY2 != null) {
                float f3 = (float) this.CRZ[0];
                View view9 = this.CRS;
                if (view9 == null) {
                    p.hyc();
                }
                ViewPropertyAnimator translationX2 = translationY2.translationX(f3 - ((float) view9.getPaddingLeft()));
                if (!(translationX2 == null || (duration = translationX2.setDuration(300)) == null || (listener = duration.setListener(null)) == null || (updateListener = listener.setUpdateListener(new e(this, paddingLeft, paddingTop))) == null)) {
                    updateListener.start();
                    AppMethodBeat.o(240660);
                    return;
                }
            }
        }
        AppMethodBeat.o(240660);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float CCk;
        final /* synthetic */ ScanInfoMaskView CSj;
        final /* synthetic */ float CSk;

        e(ScanInfoMaskView scanInfoMaskView, float f2, float f3) {
            this.CSj = scanInfoMaskView;
            this.CSk = f2;
            this.CCk = f3;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(240651);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(240651);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            ScanInfoMaskView.a(this.CSj).setAlpha(floatValue);
            ScanInfoMaskView.b(this.CSj).setAlpha(floatValue);
            float f2 = this.CSk + ((0.0f - this.CSk) * floatValue);
            float f3 = (floatValue * (0.0f - this.CCk)) + this.CCk;
            ScanInfoMaskView.c(this.CSj).setTranslationX(f2);
            ScanInfoMaskView.c(this.CSj).setTranslationY(f3);
            AppMethodBeat.o(240651);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ ScanInfoMaskView CSj;

        public f(ScanInfoMaskView scanInfoMaskView) {
            this.CSj = scanInfoMaskView;
        }

        public final void run() {
            AppMethodBeat.i(240652);
            this.CSj.requestLayout();
            AppMethodBeat.o(240652);
        }
    }

    public final void eRC() {
        AppMethodBeat.i(240661);
        Animation animation = this.CRW;
        if (animation != null) {
            animation.cancel();
        }
        View view = this.CRT;
        if (view == null) {
            p.btv("loadingIcon");
        }
        view.clearAnimation();
        AppMethodBeat.o(240661);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0195  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ue(boolean r14) {
        /*
        // Method dump skipped, instructions count: 415
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView.ue(boolean):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$showLoadingViewInternal$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-scan_release"})
    public static final class g extends AnimatorListenerAdapter {
        final /* synthetic */ ScanInfoMaskView CSj;
        final /* synthetic */ boolean CSl;
        final /* synthetic */ kotlin.g.a.a CSm;

        g(ScanInfoMaskView scanInfoMaskView, boolean z, kotlin.g.a.a aVar) {
            this.CSj = scanInfoMaskView;
            this.CSl = z;
            this.CSm = aVar;
        }

        public final void onAnimationEnd(Animator animator) {
            ViewPropertyAnimator animate;
            AppMethodBeat.i(240653);
            View view = this.CSj.CRS;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.CSj.CRS;
            if (!(view2 == null || (animate = view2.animate()) == null)) {
                animate.setListener(null);
            }
            this.CSj.CRY = false;
            if (this.CSl) {
                this.CSm.invoke();
            }
            AppMethodBeat.o(240653);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(240654);
            super.onAnimationCancel(animator);
            this.CSj.CRY = false;
            AppMethodBeat.o(240654);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class h implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ScanInfoMaskView CSj;
        final /* synthetic */ boolean CSl;
        final /* synthetic */ z.c CSn;
        final /* synthetic */ z.c CSo;

        h(ScanInfoMaskView scanInfoMaskView, boolean z, z.c cVar, z.c cVar2) {
            this.CSj = scanInfoMaskView;
            this.CSl = z;
            this.CSn = cVar;
            this.CSo = cVar2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(240655);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(240655);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            ScanInfoMaskView.h(this.CSj).setAlpha(floatValue);
            View view = this.CSj.CRS;
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.CSl) {
                this.CSj.CRY = true;
                float f2 = this.CSn.SYD + ((0.0f - this.CSn.SYD) * floatValue);
                float f3 = (floatValue * (0.0f - this.CSo.SYD)) + this.CSo.SYD;
                ScanInfoMaskView.f(this.CSj).setTranslationX(f2);
                ScanInfoMaskView.f(this.CSj).setTranslationY(f3);
            }
            AppMethodBeat.o(240655);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ScanInfoMaskView CSj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(ScanInfoMaskView scanInfoMaskView) {
            super(0);
            this.CSj = scanInfoMaskView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(240656);
            ScanInfoMaskView.d(this.CSj);
            if (this.CSj.CRW == null) {
                this.CSj.CRW = AnimationUtils.loadAnimation(this.CSj.getContext(), R.anim.v);
                int dimensionPixelSize = this.CSj.getResources().getDimensionPixelSize(R.dimen.cl);
                this.CSj.CRW = new RotateAnimation(0.0f, 360.0f, ((float) dimensionPixelSize) / 2.0f, ((float) dimensionPixelSize) / 2.0f);
                Animation animation = this.CSj.CRW;
                if (animation != null) {
                    animation.setInterpolator(new LinearInterpolator());
                    animation.setRepeatMode(-1);
                    animation.setRepeatCount(-1);
                    animation.setDuration(1000);
                }
            }
            ScanInfoMaskView.f(this.CSj).startAnimation(this.CSj.CRW);
            x xVar = x.SXb;
            AppMethodBeat.o(240656);
            return xVar;
        }
    }
}
