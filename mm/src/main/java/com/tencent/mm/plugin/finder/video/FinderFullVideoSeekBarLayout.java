package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.finder.b;
import com.tencent.mm.plugin.finder.video.q;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u0007*\u0001'\u0018\u0000 }2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001}B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\rH\u0016J\u0010\u0010>\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\rH\u0016J\b\u0010?\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u0018H\u0002J\u0010\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020\u0018H\u0016J\u0010\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020\rH\u0016J\b\u0010I\u001a\u00020\u0018H\u0002J\b\u0010J\u001a\u00020\u0018H\u0002J\b\u0010K\u001a\u00020\u0018H\u0002J\u001a\u0010L\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020\rH\u0002J\b\u0010N\u001a\u00020\u0010H\u0016J\b\u0010O\u001a\u00020\u0010H\u0016J\u0006\u0010P\u001a\u00020\u0018J\u0012\u0010Q\u001a\u00020\u00102\b\u0010R\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010S\u001a\u00020\u00102\b\u0010R\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010T\u001a\u00020\u00102\b\u0010R\u001a\u0004\u0018\u00010CH\u0016J,\u0010U\u001a\u00020\u00102\b\u0010V\u001a\u0004\u0018\u00010C2\b\u0010W\u001a\u0004\u0018\u00010C2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020YH\u0016J\u0012\u0010[\u001a\u00020\u00182\b\u0010R\u001a\u0004\u0018\u00010CH\u0016J\"\u0010\\\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u0010H\u0016J,\u0010_\u001a\u00020\u00102\b\u0010V\u001a\u0004\u0018\u00010C2\b\u0010W\u001a\u0004\u0018\u00010C2\u0006\u0010`\u001a\u00020Y2\u0006\u0010a\u001a\u00020YH\u0016J\u0012\u0010b\u001a\u00020\u00182\b\u0010R\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010c\u001a\u00020\u00102\b\u0010R\u001a\u0004\u0018\u00010CH\u0016J\u0012\u0010d\u001a\u00020\u00102\b\u0010R\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010e\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010g\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\rH\u0016J\u0010\u0010i\u001a\u00020\u00182\u0006\u0010j\u001a\u00020$H\u0016J\b\u0010k\u001a\u00020\u0018H\u0002J\b\u0010l\u001a\u00020\u0018H\u0002J\u0010\u0010m\u001a\u00020\u00182\u0006\u0010n\u001a\u00020\u0010H\u0016J\u0010\u0010o\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0010H\u0002J\b\u0010q\u001a\u00020\u0018H\u0002J\u0010\u0010r\u001a\u00020\u00182\u0006\u0010p\u001a\u00020\u0010H\u0002J\u0006\u0010s\u001a\u00020\u0018J \u0010t\u001a\u00020\u00182\u0006\u0010u\u001a\u00020Y2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020wH\u0016J \u0010y\u001a\u00020\u00182\u0006\u0010u\u001a\u00020Y2\u0006\u0010z\u001a\u00020\r2\u0006\u0010{\u001a\u00020\rH\u0016J\b\u0010|\u001a\u00020\u0018H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0004¢\u0006\u0004\n\u0002\u0010(R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b+\u0010,R\u000e\u0010.\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0002¢\u0006\f\n\u0004\b4\u0010\"\u001a\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isLockShow", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "onSingleTapConfirmedListener", "Lkotlin/Function0;", "", "getOnSingleTapConfirmedListener", "()Lkotlin/jvm/functions/Function0;", "setOnSingleTapConfirmedListener", "(Lkotlin/jvm/functions/Function0;)V", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "Lkotlin/Lazy;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekBarId", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1;", "seekTimeView", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "getSeekTimeView", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "seekTimeView$delegate", "seekTimeViewId", "setTmpMaxProgress", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "verticalRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getVerticalRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setVerticalRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "videoSumTimeSec", "canScrollHorizontally", TencentLocation.EXTRA_DIRECTION, "canScrollVertically", "dismissProgressBar", "dismissProgressBarThumb", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "hideOtherView", "hidePauseIcon", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initAttribute", "defStyle", "isSeekingMode", "isShownSeekBar", "lockShowProgressBar", "onDoubleTap", "e", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", e.a.NAME, "onProgressChanged", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "callback", "showOtherView", "showPauseIcon", "showProgressBar", "isShowThumb", "showProgressBarImpl", "isShow", "showProgressBarThumb", "showSeekTimeLayout", "unlockShowProgressBar", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "updateSeekTime", "Companion", "plugin-finder_release"})
public final class FinderFullVideoSeekBarLayout extends FrameLayout implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, q {
    public static final a wcn = new a((byte) 0);
    private final kotlin.f vMb = g.ah(new c(this));
    private boolean wbE;
    private q.a wbF;
    boolean wbG;
    private final kotlin.f wbH = g.ah(new f(this));
    private int wbJ;
    private int wcf;
    private int wcg;
    private final kotlin.f wch = g.ah(new e(this));
    private int wci = 1;
    private RecyclerView wcj;
    private kotlin.g.a.a<x> wck = b.wco;
    private final d wcl = new d(this);
    private boolean wcm;

    static {
        AppMethodBeat.i(254009);
        AppMethodBeat.o(254009);
    }

    private final FinderVideoSeekTimeView getSeekTimeView() {
        AppMethodBeat.i(253980);
        FinderVideoSeekTimeView finderVideoSeekTimeView = (FinderVideoSeekTimeView) this.wch.getValue();
        AppMethodBeat.o(253980);
        return finderVideoSeekTimeView;
    }

    private final GestureDetector getTouchDetector() {
        AppMethodBeat.i(253984);
        GestureDetector gestureDetector = (GestureDetector) this.wbH.getValue();
        AppMethodBeat.o(253984);
        return gestureDetector;
    }

    public final SeekBar getSeekBar() {
        AppMethodBeat.i(253979);
        SeekBar seekBar = (SeekBar) this.vMb.getValue();
        AppMethodBeat.o(253979);
        return seekBar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        public static final b wco = new b();

        static {
            AppMethodBeat.i(253973);
            AppMethodBeat.o(253973);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public static final /* synthetic */ GestureDetector c(FinderFullVideoSeekBarLayout finderFullVideoSeekBarLayout) {
        AppMethodBeat.i(254010);
        GestureDetector touchDetector = finderFullVideoSeekBarLayout.getTouchDetector();
        AppMethodBeat.o(254010);
        return touchDetector;
    }

    public static final /* synthetic */ void d(FinderFullVideoSeekBarLayout finderFullVideoSeekBarLayout) {
        AppMethodBeat.i(254011);
        finderFullVideoSeekBarLayout.dFf();
        AppMethodBeat.o(254011);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$Companion;", "", "()V", "ANIMATION_DURATION", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFullVideoSeekBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254007);
        b(attributeSet, 0);
        AppMethodBeat.o(254007);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFullVideoSeekBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254008);
        b(attributeSet, i2);
        AppMethodBeat.o(254008);
    }

    public final RecyclerView getVerticalRecyclerView() {
        return this.wcj;
    }

    public final void setVerticalRecyclerView(RecyclerView recyclerView) {
        this.wcj = recyclerView;
    }

    public final kotlin.g.a.a<x> getOnSingleTapConfirmedListener() {
        return this.wck;
    }

    public final void setOnSingleTapConfirmedListener(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(253981);
        p.h(aVar, "<set-?>");
        this.wck = aVar;
        AppMethodBeat.o(253981);
    }

    private final void b(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(253982);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.a.FinderFullVideoSeekBarLayout, i2, 0);
        this.wcf = obtainStyledAttributes.getResourceId(0, 0);
        this.wcg = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(253982);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(253983);
        p.h(motionEvent, "event");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent || !this.wcl.onTouch(this, motionEvent)) {
            AppMethodBeat.o(253983);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(253983);
        return true;
    }

    public final void setSeekMode(boolean z) {
        this.wbG = z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0005R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, hxF = {"com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class d implements View.OnTouchListener {
        private int kuv;
        private int kuw;
        private final int padding;
        private final Rect rect = new Rect();
        final /* synthetic */ FinderFullVideoSeekBarLayout wcp;
        private boolean wcq;
        private int wcr;
        private int wcs;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderFullVideoSeekBarLayout finderFullVideoSeekBarLayout) {
            this.wcp = finderFullVideoSeekBarLayout;
            AppMethodBeat.i(253976);
            Context context = finderFullVideoSeekBarLayout.getContext();
            p.g(context, "context");
            this.padding = (int) context.getResources().getDimension(R.dimen.cl);
            AppMethodBeat.o(253976);
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            SeekBar seekBar;
            int i2;
            int i3;
            AppMethodBeat.i(253975);
            p.h(view, "v");
            p.h(motionEvent, "event");
            GestureDetector c2 = FinderFullVideoSeekBarLayout.c(this.wcp);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(c2, bl.axQ(), "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(c2, c2.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            view.getFocusedRect(this.rect);
            this.rect.left += this.padding;
            if (motionEvent.getAction() != 0 || (!this.wcp.wbG && !this.rect.contains((int) motionEvent.getX(), (int) motionEvent.getY()))) {
                if (motionEvent.getPointerCount() <= 1 && this.kuv != 0 && motionEvent.getAction() == 2) {
                    if (this.wcs != 100 && (i2 = this.wcs) >= 0 && 4 >= i2) {
                        int abs = Math.abs(this.kuv - ((int) motionEvent.getX()));
                        int abs2 = Math.abs(this.kuw - ((int) motionEvent.getY()));
                        if (abs < 8 || (abs2 > 0 && abs / abs2 < 2)) {
                            i3 = this.wcs + 1;
                        } else {
                            i3 = 100;
                        }
                        this.wcs = i3;
                        if (this.wcs != 100) {
                            AppMethodBeat.o(253975);
                            return true;
                        }
                    }
                    if (this.wcs == 100 && (seekBar = this.wcp.getSeekBar()) != null) {
                        if (!this.wcq) {
                            this.wcp.onStartTrackingTouch(seekBar);
                        }
                        this.wcq = true;
                        seekBar.setProgress(kotlin.h.a.cR(((float) (((int) motionEvent.getX()) - this.wcr)) * 0.7f) + seekBar.getProgress());
                        FinderFullVideoSeekBarLayout.d(this.wcp);
                        this.wcr = (int) motionEvent.getX();
                        AppMethodBeat.o(253975);
                        return true;
                    }
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    this.wcs = 0;
                    this.kuv = 0;
                    ViewParent parent = this.wcp.getParent();
                    if (!(parent instanceof FinderMediaBanner)) {
                        parent = null;
                    }
                    FinderMediaBanner finderMediaBanner = (FinderMediaBanner) parent;
                    if (finderMediaBanner != null) {
                        finderMediaBanner.setFrozenRecyclerView(false);
                    }
                    if (this.wcq) {
                        SeekBar seekBar2 = this.wcp.getSeekBar();
                        if (seekBar2 != null) {
                            this.wcp.onStopTrackingTouch(seekBar2);
                        }
                        this.wcq = false;
                        AppMethodBeat.o(253975);
                        return true;
                    } else if (motionEvent.getAction() == 1) {
                        int abs3 = Math.abs(this.kuv - ((int) motionEvent.getX()));
                        if (Math.abs(this.kuw - ((int) motionEvent.getY())) <= 5 && abs3 <= 5) {
                            this.wcp.performClick();
                        }
                    }
                }
                AppMethodBeat.o(253975);
                return false;
            }
            this.wcr = (int) motionEvent.getX();
            this.kuw = (int) motionEvent.getY();
            this.kuv = this.wcr;
            this.wcs = 0;
            AppMethodBeat.o(253975);
            return true;
        }
    }

    private final void dFf() {
        AppMethodBeat.i(253985);
        SeekBar seekBar = getSeekBar();
        if (seekBar != null) {
            float progress = (((float) seekBar.getProgress()) * 1.0f) / ((float) seekBar.getMax());
            int i2 = this.wci;
            float p = android.support.v4.b.a.p(progress * ((float) i2), 0.0f, ((float) i2) - 1.0f);
            FinderVideoSeekTimeView seekTimeView = getSeekTimeView();
            if (seekTimeView != null) {
                seekTimeView.setSumTime(this.wci);
            }
            FinderVideoSeekTimeView seekTimeView2 = getSeekTimeView();
            if (seekTimeView2 != null) {
                seekTimeView2.setCurrentTime((int) p);
                AppMethodBeat.o(253985);
                return;
            }
            AppMethodBeat.o(253985);
            return;
        }
        AppMethodBeat.o(253985);
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        RecyclerView.LayoutManager layoutManager;
        AppMethodBeat.i(253986);
        p.h(seekBar, "seekBar");
        q.a aVar = this.wbF;
        if (aVar == null || !aVar.dFI()) {
            Log.w("Finder.FullVideoSeekBarLayout", "[onStartTrackingTouch] is Disable Seek");
            AppMethodBeat.o(253986);
            return;
        }
        RecyclerView recyclerView = this.wcj;
        if (!(recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || !(layoutManager instanceof FinderLinearLayoutManager))) {
            ((FinderLinearLayoutManager) layoutManager).wtl = false;
        }
        seekBar.animate().cancel();
        this.wbE = true;
        seekBar.setVisibility(0);
        ViewParent parent = getParent();
        while (parent != null && !(parent instanceof FinderMediaBanner)) {
            parent = parent.getParent();
        }
        if (!(parent instanceof FinderMediaBanner)) {
            parent = null;
        }
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) parent;
        if (finderMediaBanner != null) {
            finderMediaBanner.setFrozenRecyclerView(true);
        }
        oK(true);
        oJ(true);
        q.a aVar2 = this.wbF;
        if (aVar2 != null) {
            seekBar.setProgress((int) (((1.0f * ((float) aVar2.getCurrentPosSec())) / ((float) aVar2.getVideoDurationSec())) * ((float) seekBar.getMax())));
            aVar2.dFH();
            AppMethodBeat.o(253986);
            return;
        }
        AppMethodBeat.o(253986);
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        RecyclerView.LayoutManager layoutManager;
        AppMethodBeat.i(253987);
        p.h(seekBar, "seekBar");
        RecyclerView recyclerView = this.wcj;
        if (!(recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || !(layoutManager instanceof FinderLinearLayoutManager))) {
            ((FinderLinearLayoutManager) layoutManager).wtl = true;
        }
        q.a aVar = this.wbF;
        if (aVar == null) {
            AppMethodBeat.o(253987);
        } else if (!aVar.dFI()) {
            AppMethodBeat.o(253987);
        } else {
            oK(false);
            oJ(false);
            float progress = (1.0f * ((float) seekBar.getProgress())) / ((float) seekBar.getMax());
            Log.i("Finder.FullVideoSeekBarLayout", "[onStopTrackingTouch] percent=".concat(String.valueOf(progress)));
            ViewParent parent = getParent();
            while (parent != null && !(parent instanceof FinderMediaBanner)) {
                parent = parent.getParent();
            }
            if (!(parent instanceof FinderMediaBanner)) {
                parent = null;
            }
            FinderMediaBanner finderMediaBanner = (FinderMediaBanner) parent;
            if (finderMediaBanner != null) {
                finderMediaBanner.setFrozenRecyclerView(false);
            }
            setProgress(seekBar.getProgress());
            q.a aVar2 = this.wbF;
            if (aVar2 != null) {
                aVar2.bn(progress);
            }
            this.wbE = false;
            AppMethodBeat.o(253987);
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void setProgress(int i2) {
        AppMethodBeat.i(253988);
        this.wbJ = i2;
        SeekBar seekBar = getSeekBar();
        if (seekBar != null) {
            seekBar.setProgress(i2);
        }
        dFf();
        AppMethodBeat.o(253988);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void oI(boolean z) {
    }

    private final void oJ(boolean z) {
        AppMethodBeat.i(253989);
        Log.i("Finder.FullVideoSeekBarLayout", "[showSeekTimeLayout] isShowThumb=" + z + " isLockShow=" + this.wcm);
        if (z) {
            FinderVideoSeekTimeView seekTimeView = getSeekTimeView();
            if (seekTimeView != null) {
                seekTimeView.setVisibility(0);
                AppMethodBeat.o(253989);
                return;
            }
            AppMethodBeat.o(253989);
            return;
        }
        FinderVideoSeekTimeView seekTimeView2 = getSeekTimeView();
        if (seekTimeView2 != null) {
            seekTimeView2.setVisibility(8);
            AppMethodBeat.o(253989);
            return;
        }
        AppMethodBeat.o(253989);
    }

    private final void oK(boolean z) {
        AppMethodBeat.i(253990);
        Log.i("Finder.FullVideoSeekBarLayout", "[showProgressBarImpl] isShowThumb=" + z + " isLockShow=" + this.wcm);
        if (!this.wcm) {
            SeekBar seekBar = getSeekBar();
            if (seekBar == null) {
                AppMethodBeat.o(253990);
            } else if (z) {
                seekBar.setVisibility(0);
                dFg();
                q.a aVar = this.wbF;
                if (aVar != null) {
                    aVar.Q(true, false);
                    AppMethodBeat.o(253990);
                    return;
                }
                AppMethodBeat.o(253990);
            } else {
                seekBar.setVisibility(8);
                dFb();
                q.a aVar2 = this.wbF;
                if (aVar2 != null) {
                    aVar2.Q(false, false);
                    AppMethodBeat.o(253990);
                    return;
                }
                AppMethodBeat.o(253990);
            }
        } else if (z) {
            dFi();
            AppMethodBeat.o(253990);
        } else {
            dFh();
            AppMethodBeat.o(253990);
        }
    }

    private final void dFg() {
        AppMethodBeat.i(253991);
        dFi();
        ViewParent parent = getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253991);
            throw tVar;
        }
        View findViewById = ((View) parent).findViewById(R.id.esx);
        if (findViewById != null) {
            findViewById.setAlpha(0.0f);
        }
        ViewParent parent2 = getParent();
        if (parent2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253991);
            throw tVar2;
        }
        View findViewById2 = ((View) parent2).findViewById(R.id.clr);
        if (!(findViewById2 instanceof ViewGroup)) {
            findViewById2 = null;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                SeekBar seekBar = getSeekBar();
                if (!p.j(childAt, seekBar != null ? seekBar.getParent() : null)) {
                    ViewPropertyAnimator animate = childAt.animate();
                    if (animate != null) {
                        animate.cancel();
                    }
                    childAt.animate().alpha(0.0f).setDuration(280).start();
                }
            }
            AppMethodBeat.o(253991);
            return;
        }
        AppMethodBeat.o(253991);
    }

    private final void dFb() {
        AppMethodBeat.i(253992);
        dFh();
        ViewParent parent = getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253992);
            throw tVar;
        }
        View findViewById = ((View) parent).findViewById(R.id.esx);
        if (findViewById != null) {
            ViewPropertyAnimator animate = findViewById.animate();
            if (animate != null) {
                animate.cancel();
            }
            findViewById.animate().alpha(1.0f).setDuration(280).start();
        }
        ViewParent parent2 = getParent();
        if (parent2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253992);
            throw tVar2;
        }
        View findViewById2 = ((View) parent2).findViewById(R.id.clr);
        if (!(findViewById2 instanceof ViewGroup)) {
            findViewById2 = null;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                SeekBar seekBar = getSeekBar();
                if (!p.j(childAt, seekBar != null ? seekBar.getParent() : null)) {
                    ViewPropertyAnimator animate2 = childAt.animate();
                    if (animate2 != null) {
                        animate2.cancel();
                    }
                    childAt.animate().alpha(1.0f).setDuration(280).start();
                }
            }
            AppMethodBeat.o(253992);
            return;
        }
        AppMethodBeat.o(253992);
    }

    private final void dFh() {
        AppMethodBeat.i(253993);
        ViewParent parent = getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253993);
            throw tVar;
        }
        View findViewById = ((View) parent).findViewById(R.id.clt);
        if (findViewById != null) {
            ViewPropertyAnimator animate = findViewById.animate();
            if (animate != null) {
                animate.cancel();
            }
            findViewById.animate().alpha(1.0f).setDuration(280).start();
        }
        ViewParent parent2 = getParent();
        if (parent2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253993);
            throw tVar2;
        }
        View findViewById2 = ((View) parent2).findViewById(R.id.d43);
        if (findViewById2 != null) {
            ViewPropertyAnimator animate2 = findViewById2.animate();
            if (animate2 != null) {
                animate2.cancel();
            }
            findViewById2.animate().alpha(1.0f).setDuration(280).start();
            AppMethodBeat.o(253993);
            return;
        }
        AppMethodBeat.o(253993);
    }

    private final void dFi() {
        AppMethodBeat.i(253994);
        ViewParent parent = getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253994);
            throw tVar;
        }
        View findViewById = ((View) parent).findViewById(R.id.clt);
        if (findViewById != null) {
            ViewPropertyAnimator animate = findViewById.animate();
            if (animate != null) {
                animate.cancel();
            }
            findViewById.setAlpha(0.0f);
        }
        ViewParent parent2 = getParent();
        if (parent2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253994);
            throw tVar2;
        }
        View findViewById2 = ((View) parent2).findViewById(R.id.d43);
        if (findViewById2 != null) {
            ViewPropertyAnimator animate2 = findViewById2.animate();
            if (animate2 != null) {
                animate2.cancel();
            }
            findViewById2.setAlpha(0.0f);
            AppMethodBeat.o(253994);
            return;
        }
        AppMethodBeat.o(253994);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void dEX() {
        AppMethodBeat.i(253995);
        if (this.wcm) {
            AppMethodBeat.o(253995);
            return;
        }
        SeekBar seekBar = getSeekBar();
        if (seekBar != null) {
            seekBar.setTag(null);
            FinderVideoSeekTimeView seekTimeView = getSeekTimeView();
            if (seekTimeView != null) {
                seekTimeView.setVisibility(8);
            }
            if (seekBar.getVisibility() == 8) {
                AppMethodBeat.o(253995);
                return;
            }
            seekBar.setVisibility(8);
            AppMethodBeat.o(253995);
            return;
        }
        AppMethodBeat.o(253995);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final boolean dEZ() {
        return this.wbG;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final int getCurrentProgress() {
        AppMethodBeat.i(253996);
        SeekBar seekBar = getSeekBar();
        if (seekBar != null) {
            int progress = seekBar.getProgress();
            AppMethodBeat.o(253996);
            return progress;
        }
        AppMethodBeat.o(253996);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void setSeekBarCallback(q.a aVar) {
        AppMethodBeat.i(253997);
        p.h(aVar, "callback");
        this.wbF = aVar;
        AppMethodBeat.o(253997);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final boolean dEY() {
        AppMethodBeat.i(253998);
        SeekBar seekBar = getSeekBar();
        if (seekBar == null || seekBar.getVisibility() != 0) {
            AppMethodBeat.o(253998);
            return false;
        }
        AppMethodBeat.o(253998);
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void gs(int i2, int i3) {
        AppMethodBeat.i(253999);
        if (getSeekBar() != null) {
            this.wci = i3;
        }
        AppMethodBeat.o(253999);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void bm(float f2) {
        AppMethodBeat.i(254000);
        SeekBar seekBar = getSeekBar();
        if (seekBar != null) {
            seekBar.setProgress(kotlin.h.a.cR(((float) seekBar.getMax()) * f2));
            AppMethodBeat.o(254000);
            return;
        }
        AppMethodBeat.o(254000);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void awG(String str) {
        AppMethodBeat.i(254001);
        p.h(str, "reason");
        this.wbG = false;
        AppMethodBeat.o(254001);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void dFa() {
        this.wbG = true;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return true;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(254002);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(254002);
        return false;
    }

    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(254003);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(254003);
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AppMethodBeat.i(254004);
        this.wck.invoke();
        AppMethodBeat.o(254004);
        return true;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(254005);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/finder/video/FinderFullVideoSeekBarLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(254005);
        return false;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    public final boolean canScrollHorizontally(int i2) {
        return true;
    }

    public final boolean canScrollVertically(int i2) {
        AppMethodBeat.i(254006);
        if (this.wbE || super.canScrollVertically(i2)) {
            AppMethodBeat.o(254006);
            return true;
        }
        AppMethodBeat.o(254006);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<SeekBar> {
        final /* synthetic */ FinderFullVideoSeekBarLayout wcp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFullVideoSeekBarLayout finderFullVideoSeekBarLayout) {
            super(0);
            this.wcp = finderFullVideoSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ SeekBar invoke() {
            AppMethodBeat.i(253974);
            ViewParent parent = this.wcp.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(253974);
                throw tVar;
            }
            SeekBar seekBar = (SeekBar) ((View) parent).findViewById(this.wcp.wcf);
            AppMethodBeat.o(253974);
            return seekBar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekTimeView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<FinderVideoSeekTimeView> {
        final /* synthetic */ FinderFullVideoSeekBarLayout wcp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderFullVideoSeekBarLayout finderFullVideoSeekBarLayout) {
            super(0);
            this.wcp = finderFullVideoSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderVideoSeekTimeView invoke() {
            AppMethodBeat.i(253977);
            FinderVideoSeekTimeView finderVideoSeekTimeView = (FinderVideoSeekTimeView) this.wcp.findViewById(this.wcp.wcg);
            AppMethodBeat.o(253977);
            return finderVideoSeekTimeView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<GestureDetector> {
        final /* synthetic */ FinderFullVideoSeekBarLayout wcp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderFullVideoSeekBarLayout finderFullVideoSeekBarLayout) {
            super(0);
            this.wcp = finderFullVideoSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ GestureDetector invoke() {
            AppMethodBeat.i(253978);
            GestureDetector gestureDetector = new GestureDetector(this.wcp.getContext(), this.wcp);
            AppMethodBeat.o(253978);
            return gestureDetector;
        }
    }
}
