package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.finder.video.q;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\u001c\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001jB\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ(\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u000eH\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000204H\u0002J\b\u00106\u001a\u000204H\u0016J\u0010\u00107\u001a\u0002042\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u000eH\u0016J\b\u0010;\u001a\u00020\u0011H\u0016J\b\u0010<\u001a\u00020\u0011H\u0016J\u0012\u0010=\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010@\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010A\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J,\u0010B\u001a\u00020\u00112\b\u0010C\u001a\u0004\u0018\u00010?2\b\u0010D\u001a\u0004\u0018\u00010?2\u0006\u0010E\u001a\u0002002\u0006\u0010F\u001a\u000200H\u0016J0\u0010G\u001a\u0002042\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u000eH\u0014J\u0012\u0010M\u001a\u0002042\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J \u0010N\u001a\u0002042\u0006\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020\u0011H\u0016J,\u0010R\u001a\u00020\u00112\b\u0010C\u001a\u0004\u0018\u00010?2\b\u0010D\u001a\u0004\u0018\u00010?2\u0006\u0010S\u001a\u0002002\u0006\u0010T\u001a\u000200H\u0016J\u0012\u0010U\u001a\u0002042\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010V\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010W\u001a\u00020\u00112\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010X\u001a\u0002042\u0006\u0010O\u001a\u00020&H\u0016J\u0010\u0010Y\u001a\u0002042\u0006\u0010O\u001a\u00020&H\u0016J\u0010\u0010Z\u001a\u0002042\u0006\u0010[\u001a\u00020\u000eH\u0016J\u0010\u0010\\\u001a\u0002042\u0006\u0010]\u001a\u00020\u001aH\u0016J\u0010\u0010^\u001a\u0002042\u0006\u0010_\u001a\u00020\u0011H\u0002J\u0010\u0010`\u001a\u0002042\u0006\u0010_\u001a\u00020\u0011H\u0016J\b\u0010a\u001a\u000204H\u0002J \u0010b\u001a\u0002042\u0006\u0010c\u001a\u0002002\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020eH\u0016J \u0010g\u001a\u0002042\u0006\u0010c\u001a\u0002002\u0006\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u000eH\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R#\u0010%\u001a\n '*\u0004\u0018\u00010&0&8BX\u0002¢\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b(\u0010)¨\u0006k"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableGesture", "", "isSeekBarTrackingTouch", "isSeekMode", "()Z", "setSeekMode", "(Z)V", "originalProcessDrawableRect", "Landroid/graphics/Rect;", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1;", "setTmpMaxProgress", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "Lkotlin/Lazy;", "videoSeekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getVideoSeekBar", "()Landroid/widget/SeekBar;", "videoSeekBar$delegate", "canScrollHorizontally", TencentLocation.EXTRA_DIRECTION, "parent", "Landroid/view/ViewGroup;", "x", "", "y", "canScrollVertically", "dismissProgressBar", "", "dismissProgressBarThumb", "enterSeekMode", "exitSeekMode", "reason", "", "getCurrentProgress", "isSeekingMode", "isShownSeekBar", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onLayout", "changed", "left", "top", "right", "bottom", e.a.NAME, "onProgressChanged", "seekBar", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "setProgress", "target", "setSeekBarCallback", "callback", "showBigProgressBar", "isShowThumb", "showProgressBar", "showProgressBarThumb", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "offsetSec", "allSec", "Companion", "plugin-finder_release"})
public final class FinderVideoSeekBar extends FrameLayout implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, q, FinderViewPager.a {
    private static final int wfQ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    public static final a wfR = new a((byte) 0);
    private boolean wbE;
    private q.a wbF;
    boolean wbG;
    private final kotlin.f wbH;
    private int wbJ;
    private final Rect wfM = new Rect();
    private final kotlin.f wfN = g.ah(new f(this));
    private final boolean wfO;
    private final b wfP;

    private final GestureDetector getTouchDetector() {
        AppMethodBeat.i(254343);
        GestureDetector gestureDetector = (GestureDetector) this.wbH.getValue();
        AppMethodBeat.o(254343);
        return gestureDetector;
    }

    private final SeekBar getVideoSeekBar() {
        AppMethodBeat.i(254342);
        SeekBar seekBar = (SeekBar) this.wfN.getValue();
        AppMethodBeat.o(254342);
        return seekBar;
    }

    public static final /* synthetic */ SeekBar a(FinderVideoSeekBar finderVideoSeekBar) {
        AppMethodBeat.i(254369);
        SeekBar videoSeekBar = finderVideoSeekBar.getVideoSeekBar();
        AppMethodBeat.o(254369);
        return videoSeekBar;
    }

    public static final /* synthetic */ GestureDetector d(FinderVideoSeekBar finderVideoSeekBar) {
        AppMethodBeat.i(254370);
        GestureDetector touchDetector = finderVideoSeekBar.getTouchDetector();
        AppMethodBeat.o(254370);
        return touchDetector;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoSeekBar(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(254365);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wfO = com.tencent.mm.plugin.finder.storage.c.dsc();
        this.wbH = g.ah(new e(this));
        this.wfP = new b(this);
        setId(R.id.ggr);
        if (this.wfO) {
            setOnTouchListener(this.wfP);
        }
        LayoutInflater.from(getContext()).inflate(R.layout.al6, this);
        SeekBar videoSeekBar = getVideoSeekBar();
        p.g(videoSeekBar, "videoSeekBar");
        videoSeekBar.setVisibility(4);
        AppMethodBeat.o(254365);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254366);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wfO = com.tencent.mm.plugin.finder.storage.c.dsc();
        this.wbH = g.ah(new e(this));
        this.wfP = new b(this);
        setId(R.id.ggr);
        if (this.wfO) {
            setOnTouchListener(this.wfP);
        }
        LayoutInflater.from(getContext()).inflate(R.layout.al6, this);
        SeekBar videoSeekBar = getVideoSeekBar();
        p.g(videoSeekBar, "videoSeekBar");
        videoSeekBar.setVisibility(4);
        AppMethodBeat.o(254366);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254367);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.wfO = com.tencent.mm.plugin.finder.storage.c.dsc();
        this.wbH = g.ah(new e(this));
        this.wfP = new b(this);
        setId(R.id.ggr);
        if (this.wfO) {
            setOnTouchListener(this.wfP);
        }
        LayoutInflater.from(getContext()).inflate(R.layout.al6, this);
        SeekBar videoSeekBar = getVideoSeekBar();
        p.g(videoSeekBar, "videoSeekBar");
        videoSeekBar.setVisibility(4);
        AppMethodBeat.o(254367);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_DURATION", "", "TAG", "", "_4dp", "get_4dp", "()I", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(254368);
        AppMethodBeat.o(254368);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0007R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0005R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, hxF = {"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$seekBarTouchListener$1", "Landroid/view/View$OnTouchListener;", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "isHasSeek", "", "()Z", "setHasSeek", "(Z)V", "isNeedToSeek", "setNeedToSeek", "lastX", "getLastX", "setLastX", "padding", "getPadding", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class b implements View.OnTouchListener {
        private int kuv;
        private int kuw;
        private final int padding;
        private final Rect rect = new Rect();
        private boolean wcq;
        private int wcr;
        private int wcs;
        final /* synthetic */ FinderVideoSeekBar wfS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderVideoSeekBar finderVideoSeekBar) {
            this.wfS = finderVideoSeekBar;
            AppMethodBeat.i(254337);
            Context context = finderVideoSeekBar.getContext();
            p.g(context, "context");
            this.padding = (int) context.getResources().getDimension(R.dimen.cl);
            AppMethodBeat.o(254337);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a7, code lost:
            if (r0.booleanValue() == false) goto L_0x00a9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
            /*
            // Method dump skipped, instructions count: 474
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.video.FinderVideoSeekBar.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        AppMethodBeat.i(254344);
        p.h(seekBar, "seekBar");
        q.a aVar = this.wbF;
        if (aVar == null || !aVar.dFI()) {
            Log.w("Finder.VideoSeekBar", "[onStartTrackingTouch] is Disable Seek");
            AppMethodBeat.o(254344);
            return;
        }
        seekBar.animate().cancel();
        this.wbE = true;
        SeekBar videoSeekBar = getVideoSeekBar();
        if (videoSeekBar != null) {
            videoSeekBar.setVisibility(0);
        }
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
        dFP();
        SeekBar videoSeekBar2 = getVideoSeekBar();
        p.g(videoSeekBar2, "videoSeekBar");
        if (!p.j(videoSeekBar2.getTag(), Boolean.TRUE)) {
            SeekBar videoSeekBar3 = getVideoSeekBar();
            p.g(videoSeekBar3, "videoSeekBar");
            videoSeekBar3.setVisibility(0);
            SeekBar videoSeekBar4 = getVideoSeekBar();
            p.g(videoSeekBar4, "videoSeekBar");
            Drawable progressDrawable = videoSeekBar4.getProgressDrawable();
            Rect rect = this.wfM;
            p.g(progressDrawable, "progressDrawable");
            progressDrawable.setBounds(new Rect(rect));
            getVideoSeekBar().invalidate();
            SeekBar videoSeekBar5 = getVideoSeekBar();
            p.g(videoSeekBar5, "videoSeekBar");
            videoSeekBar5.setTag(Boolean.TRUE);
        }
        q.a aVar2 = this.wbF;
        if (aVar2 != null) {
            seekBar.setProgress((int) (((1.0f * ((float) aVar2.getCurrentPosSec())) / ((float) aVar2.getVideoDurationSec())) * ((float) seekBar.getMax())));
            aVar2.dFH();
            AppMethodBeat.o(254344);
            return;
        }
        AppMethodBeat.o(254344);
    }

    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        AppMethodBeat.i(254345);
        p.h(seekBar, "seekBar");
        AppMethodBeat.o(254345);
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        AppMethodBeat.i(254346);
        p.h(seekBar, "seekBar");
        q.a aVar = this.wbF;
        if (aVar == null || !aVar.dFI()) {
            Log.w("Finder.VideoSeekBar", "[onStopTrackingTouch] is Disable Seek");
            AppMethodBeat.o(254346);
            return;
        }
        float progress = (1.0f * ((float) seekBar.getProgress())) / ((float) seekBar.getMax());
        Log.i("Finder.VideoSeekBar", "[onStopTrackingTouch] percent=".concat(String.valueOf(progress)));
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
        oI(this.wbG);
        setProgress(seekBar.getProgress());
        q.a aVar2 = this.wbF;
        if (aVar2 != null) {
            aVar2.bn(progress);
        }
        this.wbE = false;
        AppMethodBeat.o(254346);
    }

    private final void dFP() {
        Drawable thumb;
        AppMethodBeat.i(254347);
        SeekBar videoSeekBar = getVideoSeekBar();
        if (videoSeekBar == null || (thumb = videoSeekBar.getThumb()) == null) {
            AppMethodBeat.o(254347);
            return;
        }
        thumb.setAlpha(255);
        AppMethodBeat.o(254347);
    }

    private final void dFQ() {
        Drawable thumb;
        AppMethodBeat.i(254348);
        SeekBar videoSeekBar = getVideoSeekBar();
        if (videoSeekBar == null || (thumb = videoSeekBar.getThumb()) == null) {
            AppMethodBeat.o(254348);
            return;
        }
        thumb.setAlpha(0);
        AppMethodBeat.o(254348);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(254349);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.wfM.isEmpty()) {
            Rect rect = this.wfM;
            SeekBar videoSeekBar = getVideoSeekBar();
            p.g(videoSeekBar, "videoSeekBar");
            Drawable progressDrawable = videoSeekBar.getProgressDrawable();
            p.g(progressDrawable, "videoSeekBar.progressDrawable");
            rect.set(progressDrawable.getBounds());
        }
        if (z) {
            SeekBar videoSeekBar2 = getVideoSeekBar();
            p.g(videoSeekBar2, "videoSeekBar");
            ViewGroup.LayoutParams layoutParams = videoSeekBar2.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(254349);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            ViewParent parent = getParent();
            if (parent == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(254349);
                throw tVar2;
            }
            View findViewById = ((ViewGroup) parent).findViewById(R.id.jj3);
            p.g(findViewById, "warnView");
            if (findViewById.getVisibility() == 0) {
                layoutParams2.bottomMargin = (-wfQ) + findViewById.getHeight();
                SeekBar videoSeekBar3 = getVideoSeekBar();
                p.g(videoSeekBar3, "videoSeekBar");
                videoSeekBar3.setLayoutParams(layoutParams2);
            } else if (layoutParams2.bottomMargin != (-wfQ)) {
                layoutParams2.bottomMargin = -wfQ;
                SeekBar videoSeekBar4 = getVideoSeekBar();
                p.g(videoSeekBar4, "videoSeekBar");
                videoSeekBar4.setLayoutParams(layoutParams2);
            }
            Log.i("Finder.VideoSeekBar", "bottomMargin=" + layoutParams2.bottomMargin + ", warnView visibility=" + findViewById.getVisibility());
        }
        AppMethodBeat.o(254349);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void oI(boolean z) {
        AppMethodBeat.i(254350);
        if (z) {
            dFP();
        } else {
            dFQ();
        }
        SeekBar videoSeekBar = getVideoSeekBar();
        p.g(videoSeekBar, "videoSeekBar");
        if (p.j(videoSeekBar.getTag(), Boolean.FALSE)) {
            AppMethodBeat.o(254350);
            return;
        }
        SeekBar videoSeekBar2 = getVideoSeekBar();
        p.g(videoSeekBar2, "videoSeekBar");
        videoSeekBar2.setVisibility(0);
        d dVar = new d(this);
        if (this.wfM.isEmpty()) {
            addOnLayoutChangeListener(new c(this, dVar));
            AppMethodBeat.o(254350);
            return;
        }
        dVar.invoke();
        AppMethodBeat.o(254350);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$showProgressBar$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
    public static final class c implements View.OnLayoutChangeListener {
        final /* synthetic */ FinderVideoSeekBar wfS;
        final /* synthetic */ kotlin.g.a.a wfT;

        c(FinderVideoSeekBar finderVideoSeekBar, kotlin.g.a.a aVar) {
            this.wfS = finderVideoSeekBar;
            this.wfT = aVar;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(254338);
            this.wfT.invoke();
            this.wfS.removeOnLayoutChangeListener(this);
            AppMethodBeat.o(254338);
        }
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void dEX() {
        AppMethodBeat.i(254351);
        SeekBar videoSeekBar = getVideoSeekBar();
        if (videoSeekBar != null) {
            SeekBar videoSeekBar2 = getVideoSeekBar();
            p.g(videoSeekBar2, "videoSeekBar");
            videoSeekBar2.setTag(null);
            if (videoSeekBar.getVisibility() == 4) {
                AppMethodBeat.o(254351);
                return;
            }
            videoSeekBar.setVisibility(4);
            AppMethodBeat.o(254351);
            return;
        }
        AppMethodBeat.o(254351);
    }

    public final void setSeekMode(boolean z) {
        this.wbG = z;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final boolean dEZ() {
        return this.wbG;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void awG(String str) {
        AppMethodBeat.i(254352);
        p.h(str, "reason");
        this.wbG = false;
        AppMethodBeat.o(254352);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void dFa() {
        this.wbG = true;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void gs(int i2, int i3) {
        AppMethodBeat.i(254353);
        if (getVideoSeekBar() != null && Log.getLogLevel() <= 1) {
            Log.d("Finder.VideoSeekBar", "[updateProgressSec] offsetSec=" + i2 + " allSec=" + i3);
        }
        AppMethodBeat.o(254353);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void bm(float f2) {
        AppMethodBeat.i(254354);
        SeekBar videoSeekBar = getVideoSeekBar();
        if (videoSeekBar != null) {
            videoSeekBar.setProgress(kotlin.h.a.cR(((float) videoSeekBar.getMax()) * f2));
            AppMethodBeat.o(254354);
            return;
        }
        AppMethodBeat.o(254354);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void setProgress(int i2) {
        AppMethodBeat.i(254355);
        if (Log.getLogLevel() <= 1) {
            Log.d("Finder.VideoSeekBar", "[setProgress] target=".concat(String.valueOf(i2)));
        }
        this.wbJ = i2;
        SeekBar videoSeekBar = getVideoSeekBar();
        if (videoSeekBar != null) {
            videoSeekBar.setProgress(i2);
            AppMethodBeat.o(254355);
            return;
        }
        AppMethodBeat.o(254355);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final int getCurrentProgress() {
        AppMethodBeat.i(254356);
        SeekBar videoSeekBar = getVideoSeekBar();
        if (videoSeekBar != null) {
            int progress = videoSeekBar.getProgress();
            AppMethodBeat.o(254356);
            return progress;
        }
        AppMethodBeat.o(254356);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void setSeekBarCallback(q.a aVar) {
        AppMethodBeat.i(254357);
        p.h(aVar, "callback");
        this.wbF = aVar;
        AppMethodBeat.o(254357);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final boolean dEY() {
        AppMethodBeat.i(254358);
        SeekBar videoSeekBar = getVideoSeekBar();
        if (videoSeekBar == null || videoSeekBar.getVisibility() != 0) {
            AppMethodBeat.o(254358);
            return false;
        }
        AppMethodBeat.o(254358);
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(254359);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(254359);
        return false;
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

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(254360);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(254360);
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderViewPager.a
    public final boolean a(int i2, ViewGroup viewGroup) {
        AppMethodBeat.i(254361);
        p.h(viewGroup, "parent");
        AppMethodBeat.o(254361);
        return true;
    }

    public final boolean canScrollVertically(int i2) {
        AppMethodBeat.i(254362);
        if (this.wbE || super.canScrollVertically(i2)) {
            AppMethodBeat.o(254362);
            return true;
        }
        AppMethodBeat.o(254362);
        return false;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(254363);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(254363);
        return false;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(254364);
        q.a aVar = this.wbF;
        if (aVar == null || !aVar.dFI()) {
            Log.w("Finder.VideoSeekBar", "[onSingleTapConfirmed] is Disable Seek");
            AppMethodBeat.o(254364);
            return false;
        }
        if (!this.wbG) {
            oI(true);
            q.a aVar2 = this.wbF;
            if (aVar2 != null) {
                aVar2.Q(true, true);
            }
            z = true;
        } else {
            oI(false);
            q.a aVar3 = this.wbF;
            if (aVar3 != null) {
                aVar3.Q(false, true);
            }
        }
        this.wbG = z;
        StringBuilder append = new StringBuilder("[onClick]...isShownSeekBar=").append(dEY()).append(" isSeekMode=").append(this.wbG).append(" thumb=");
        SeekBar videoSeekBar = getVideoSeekBar();
        p.g(videoSeekBar, "videoSeekBar");
        Log.i("Finder.VideoSeekBar", append.append(videoSeekBar.getAlpha()).toString());
        AppMethodBeat.o(254364);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<SeekBar> {
        final /* synthetic */ FinderVideoSeekBar wfS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderVideoSeekBar finderVideoSeekBar) {
            super(0);
            this.wfS = finderVideoSeekBar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ SeekBar invoke() {
            AppMethodBeat.i(254341);
            SeekBar seekBar = (SeekBar) this.wfS.findViewById(R.id.ggq);
            if (this.wfS.wfO) {
                seekBar.setOnSeekBarChangeListener(this.wfS);
            }
            p.g(seekBar, "seekBar");
            Drawable thumb = seekBar.getThumb();
            p.g(thumb, "seekBar.thumb");
            thumb.setAlpha(0);
            AppMethodBeat.o(254341);
            return seekBar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<GestureDetector> {
        final /* synthetic */ FinderVideoSeekBar wfS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderVideoSeekBar finderVideoSeekBar) {
            super(0);
            this.wfS = finderVideoSeekBar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ GestureDetector invoke() {
            AppMethodBeat.i(254340);
            GestureDetector gestureDetector = new GestureDetector(this.wfS.getContext(), this.wfS);
            AppMethodBeat.o(254340);
            return gestureDetector;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderVideoSeekBar wfS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderVideoSeekBar finderVideoSeekBar) {
            super(0);
            this.wfS = finderVideoSeekBar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254339);
            SeekBar a2 = FinderVideoSeekBar.a(this.wfS);
            p.g(a2, "videoSeekBar");
            Drawable progressDrawable = a2.getProgressDrawable();
            Rect rect = this.wfS.wfM;
            if (progressDrawable != null) {
                progressDrawable.setBounds(rect.left, rect.top + (rect.height() / 2), rect.right, rect.bottom);
            }
            FinderVideoSeekBar.a(this.wfS).invalidate();
            SeekBar a3 = FinderVideoSeekBar.a(this.wfS);
            p.g(a3, "videoSeekBar");
            a3.setTag(Boolean.FALSE);
            x xVar = x.SXb;
            AppMethodBeat.o(254339);
            return xVar;
        }
    }
}
