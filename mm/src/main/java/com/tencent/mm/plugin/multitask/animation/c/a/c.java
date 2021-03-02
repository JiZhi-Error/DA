package com.tencent.mm.plugin.multitask.animation.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.i;
import android.support.v4.view.t;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b1\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010A\u001a\u00020BJ8\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fH\u0004J\u0006\u0010J\u001a\u00020BJ\u0016\u0010K\u001a\u00020B2\u0006\u0010L\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fJ(\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020.2\u0006\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\fH\u0002J\"\u0010R\u001a\u00020%2\b\u0010S\u001a\u0004\u0018\u00010\u00102\u0006\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020.H\u0002J\u000e\u0010R\u001a\u00020%2\u0006\u0010T\u001a\u00020\fJ\u0016\u0010R\u001a\u00020%2\u0006\u0010T\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fJ \u0010U\u001a\u00020.2\u0006\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020.2\u0006\u0010X\u001a\u00020.H\u0002J \u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u00020\f2\u0006\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\fH\u0002J\b\u0010Y\u001a\u00020BH\u0002J\u0010\u0010Y\u001a\u00020B2\u0006\u0010P\u001a\u00020\fH\u0002J \u0010Z\u001a\u00020\f2\u0006\u0010N\u001a\u00020\f2\u0006\u0010[\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\fH\u0002J2\u0010]\u001a\u00020\f2\b\u0010S\u001a\u0004\u0018\u00010\u00102\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00020\fH\u0002J\u0015\u0010`\u001a\u0004\u0018\u00010%2\u0006\u0010a\u001a\u00020%¢\u0006\u0002\u0010bJ(\u0010c\u001a\u00020B2\u0006\u0010^\u001a\u00020.2\u0006\u0010_\u001a\u00020.2\u0006\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020.H\u0002J\u0010\u0010d\u001a\u00020.2\u0006\u0010e\u001a\u00020.H\u0002J(\u0010f\u001a\u00020B2\u0006\u0010g\u001a\u00020\f2\u0006\u0010h\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\fH\u0002J\u0010\u0010i\u001a\u00020B2\u0006\u0010P\u001a\u00020\fH\u0002J\u0018\u0010j\u001a\u0004\u0018\u00010\u00102\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fJ&\u0010k\u001a\u00020B2\u0006\u0010l\u001a\u00020\f2\u0006\u0010m\u001a\u00020\f2\u0006\u0010n\u001a\u00020\f2\u0006\u0010o\u001a\u00020\fJ0\u0010p\u001a\u00020%2\u0006\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00020\f2\u0006\u0010s\u001a\u00020tH\u0002J8\u0010p\u001a\u00020%2\u0006\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\f2\u0006\u0010^\u001a\u00020\f2\u0006\u0010_\u001a\u00020\f2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020%H\u0002J\u0018\u0010v\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fH\u0002J\u0016\u0010w\u001a\u00020%2\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fJ\u0006\u0010x\u001a\u00020%J\u000e\u0010y\u001a\u00020%2\u0006\u0010z\u001a\u00020\fJ\u0016\u0010y\u001a\u00020%2\u0006\u0010z\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fJ\u0006\u0010{\u001a\u00020%J\u000e\u0010|\u001a\u00020%2\u0006\u0010P\u001a\u00020\fJ \u0010}\u001a\u00020%2\b\u0010~\u001a\u0004\u0018\u00010\u00102\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fJ:\u0010\u001a\u00020B2\u0006\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020.2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\f2\u0007\u0010\u0001\u001a\u00020\fH\u0002J\u0011\u0010\u0001\u001a\u00020B2\b\u0010\u0001\u001a\u00030\u0001J\u0019\u0010\u0001\u001a\u00020B2\u0006\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020.H\u0002J!\u0010\u0001\u001a\u00020B2\u0006\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020.2\u0006\u0010P\u001a\u00020\fH\u0002J!\u0010\u0001\u001a\u00020B2\u0006\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020.2\u0006\u0010P\u001a\u00020\fH\u0002J\u0013\u0010\u0001\u001a\u00020B2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0010\u0010\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020\fJ\u0010\u0010\u0001\u001a\u00020B2\u0007\u0010\u0001\u001a\u00020\fJ\u0017\u0010\u0001\u001a\u00020%2\u0006\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\fJ\u0011\u0010\u0001\u001a\u00020%2\b\u0010\u0001\u001a\u00030\u0001J)\u0010\u0001\u001a\u00020%2\b\u0010S\u001a\u0004\u0018\u00010\u00102\u0006\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\f2\u0006\u0010u\u001a\u00020%J1\u0010\u0001\u001a\u00020%2\b\u0010S\u001a\u0004\u0018\u00010\u00102\u0006\u0010q\u001a\u00020\f2\u0006\u0010r\u001a\u00020\f2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020%J\u001a\u0010\u0001\u001a\u00020%2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00102\u0006\u0010P\u001a\u00020\fR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R$\u00108\u001a\u0002072\u0006\u00106\u001a\u000207@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000fR\u001e\u0010?\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000f¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "", "context", "Landroid/content/Context;", "forParent", "Landroid/view/ViewGroup;", "cb", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;Landroid/view/animation/Interpolator;)V", "<set-?>", "", "activePointerId", "getActivePointerId", "()I", "Landroid/view/View;", "capturedView", "getCapturedView", "()Landroid/view/View;", "edgeSize", "getEdgeSize", "setEdgeSize", "(I)V", "mCallback", "mEdgeDragsInProgress", "", "mEdgeDragsLocked", "mInitialEdgesTouched", "mInitialMotionX", "", "mInitialMotionY", "mLastMotionX", "mLastMotionY", "mParentView", "mPointersDown", "mReleaseInProgress", "", "mScroller", "Landroid/widget/OverScroller;", "mSetIdleRunnable", "Ljava/lang/Runnable;", "mTrackingEdges", "mVelocityTracker", "Landroid/view/VelocityTracker;", "maxVelocity", "", "getMaxVelocity", "()F", "setMaxVelocity", "(F)V", "minVelocity", "getMinVelocity", "setMinVelocity", "positon", "Landroid/graphics/Rect;", "targetPositon", "getTargetPositon", "()Landroid/graphics/Rect;", "setTargetPositon", "(Landroid/graphics/Rect;)V", "touchSlop", "getTouchSlop", "viewDragState", "getViewDragState", "abort", "", "canScroll", "v", "checkV", "dx", "dy", "x", "y", "cancel", "captureChildView", "childView", "checkNewEdgeDrag", "delta", "odelta", "pointerId", "edge", "checkTouchSlop", "child", "directions", "clampMag", "value", "absMin", "absMax", "clearMotionHistory", "computeAxisDuration", "velocity", "motionRange", "computeSettleDuration", "xvel", "yvel", "continueSettling", "deferCallbacks", "(Z)Ljava/lang/Boolean;", "dispatchViewReleased", "distanceInfluenceForSnapDuration", "f", "dragTo", "left", "top", "ensureMotionHistorySizeForId", "findTopChildUnder", "flingCapturedView", "minLeft", "minTop", "maxLeft", "maxTop", "forceSettleCapturedViewAt", "finalLeft", "finalTop", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "withNoAnim", "getEdgesTouched", "isCapturedViewUnder", "isDragging", "isEdgeTouched", "edges", "isFinished", "isPointerDown", "isViewUnder", "view", "moveTo", "adx", "ady", "processTouchEvent", "ev", "Landroid/view/MotionEvent;", "releaseViewForPointerUp", "reportNewEdgeDrags", "saveInitialMotion", "saveLastMotion", "setDragState", "state", "setEdgeTrackingEnabled", "edgeFlags", "settleCapturedViewAt", "shouldInterceptTouchEvent", "smoothSlideViewTo", "tryCaptureViewForDrag", "toCapture", "Callback", "Companion", "plugin-multitask_release"})
public final class c {
    public static final b Aaz = new b((byte) 0);
    private static final Interpolator sInterpolator = animation.InterpolatorC1507c.AaA;
    public int Aas;
    public float Aat;
    public float Aau;
    private int Aav;
    public final a Aaw;
    public View Aax;
    public Rect Aay;
    public final OverScroller UD;
    private float[] WA;
    private float[] WB;
    private int[] WC;
    private int[] WD;
    private int[] WE;
    private int WF;
    public int WJ;
    public boolean WM;
    public final ViewGroup WN;
    public final Runnable WO;
    private float[] Wy;
    private float[] Wz;
    public VelocityTracker mVelocityTracker;
    public int om;
    public int rZ;

    private c(Context context, ViewGroup viewGroup, a aVar, Interpolator interpolator) {
        AppMethodBeat.i(200482);
        this.om = -1;
        this.Aay = new Rect();
        this.WO = new d(this);
        if (viewGroup == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parent view may not be null".toString());
            AppMethodBeat.o(200482);
            throw illegalArgumentException;
        } else if (aVar == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Callback may not be null".toString());
            AppMethodBeat.o(200482);
            throw illegalArgumentException2;
        } else {
            this.WN = viewGroup;
            this.Aaw = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Resources resources = context.getResources();
            p.g(resources, "context.resources");
            this.Aav = (int) ((resources.getDisplayMetrics().density * 20.0f) + 0.5f);
            p.g(viewConfiguration, "vc");
            this.rZ = viewConfiguration.getScaledTouchSlop();
            this.Aat = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.Aau = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.UD = new OverScroller(context, interpolator);
            AppMethodBeat.o(200482);
        }
    }

    public /* synthetic */ c(Context context, ViewGroup viewGroup, a aVar, Interpolator interpolator, byte b2) {
        this(context, viewGroup, aVar, interpolator);
    }

    public final void m(Rect rect) {
        AppMethodBeat.i(200458);
        p.h(rect, "positon");
        this.Aay = new Rect(rect);
        AppMethodBeat.o(200458);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J2\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J2\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\b\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!H\u0016J8\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0016J\u001a\u0010(\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0004H&¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "", "()V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "clampViewPositionVertical", "top", "dy", "getOrderedChildIndex", FirebaseAnalytics.b.INDEX, "getViewHorizontalDragRange", "getViewVerticalDragRange", "onEdgeDragStarted", "", "edgeFlags", "pointerId", "onEdgeLock", "", "onEdgeTouched", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "onViewReleased", "releasedChild", "xvel", "", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "plugin-multitask_release"})
    public static abstract class a {
        public abstract boolean c(View view, int i2);

        public void L(int i2) {
        }

        public void l(View view, int i2, int i3, int i4, int i5) {
        }

        public void a(float f2, float f3, int i2, int i3, int i4, int i5) {
        }

        public void eqJ() {
        }

        public void b(View view, float f2, float f3, float f4, float f5) {
        }

        public int awM() {
            return 0;
        }

        public int RI(int i2) {
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ c AaB;

        d(c cVar) {
            this.AaB = cVar;
        }

        public final void run() {
            AppMethodBeat.i(200457);
            this.AaB.bf(0);
            AppMethodBeat.o(200457);
        }
    }

    public final void cancel() {
        AppMethodBeat.i(200459);
        this.om = -1;
        if (this.Wy != null) {
            Arrays.fill(this.Wy, 0.0f);
            Arrays.fill(this.Wz, 0.0f);
            Arrays.fill(this.WA, 0.0f);
            Arrays.fill(this.WB, 0.0f);
            Arrays.fill(this.WC, 0);
            Arrays.fill(this.WD, 0);
            Arrays.fill(this.WE, 0);
            this.WF = 0;
        }
        if (this.mVelocityTracker != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(200459);
    }

    public final void abort() {
        AppMethodBeat.i(200460);
        cancel();
        if (this.Aas == 2) {
            int currX = this.UD.getCurrX();
            int currY = this.UD.getCurrY();
            this.UD.abortAnimation();
            int currX2 = this.UD.getCurrX();
            int currY2 = this.UD.getCurrY();
            this.Aaw.l(this.Aax, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        bf(0);
        AppMethodBeat.o(200460);
    }

    public final boolean a(View view, int i2, int i3, long j2, boolean z) {
        AppMethodBeat.i(200461);
        this.Aax = view;
        this.om = -1;
        boolean a2 = a(i2, i3, 0, 0, j2, z);
        AppMethodBeat.o(200461);
        return a2;
    }

    public final boolean a(int i2, int i3, int i4, int i5, long j2, boolean z) {
        AppMethodBeat.i(200462);
        View view = this.Aax;
        int left = view != null ? view.getLeft() : 0;
        View view2 = this.Aax;
        int top = view2 != null ? view2.getTop() : 0;
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.UD.abortAnimation();
            bf(0);
            AppMethodBeat.o(200462);
            return false;
        }
        this.UD.forceFinished(true);
        if (j2 == 0 && !z) {
            j2 = (long) H(i6, i7, i4, i5);
        } else if (z) {
            j2 = 0;
        }
        Log.d("MultiTaskSwipeDragHelper", "chrispaulwu:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Long.valueOf(j2));
        this.UD.startScroll(left, top, i6, i7, (int) j2);
        bf(2);
        AppMethodBeat.o(200462);
        return true;
    }

    private final int H(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(200463);
        int i6 = i(i4, (int) this.Aau, (int) this.Aat);
        int i7 = i(i5, (int) this.Aau, (int) this.Aat);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(i6);
        int abs4 = Math.abs(i7);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        int h2 = (int) (((i7 != 0 ? ((float) abs4) / ((float) i8) : ((float) abs2) / ((float) i9)) * ((float) h(i3, i7, 0))) + ((i6 != 0 ? ((float) abs3) / ((float) i8) : ((float) abs) / ((float) i9)) * ((float) h(i2, i6, this.Aaw.awM()))));
        AppMethodBeat.o(200463);
        return h2;
    }

    private final int h(int i2, int i3, int i4) {
        int abs;
        AppMethodBeat.i(200464);
        if (i2 == 0) {
            AppMethodBeat.o(200464);
            return 0;
        }
        int width = this.WN.getWidth();
        int i5 = width / 2;
        float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width))) * ((float) i5)) + ((float) i5);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs2)) * 1000.0f) * 4;
        } else {
            abs = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        int min = Math.min(abs, 350);
        AppMethodBeat.o(200464);
        return min;
    }

    private static int i(int i2, int i3, int i4) {
        AppMethodBeat.i(200465);
        int abs = Math.abs(i2);
        if (abs < i3) {
            AppMethodBeat.o(200465);
            return 0;
        } else if (abs <= i4) {
            AppMethodBeat.o(200465);
            return i2;
        } else if (i2 > 0) {
            AppMethodBeat.o(200465);
            return i4;
        } else {
            int i5 = -i4;
            AppMethodBeat.o(200465);
            return i5;
        }
    }

    private static float f(float f2, float f3, float f4) {
        AppMethodBeat.i(200466);
        float abs = Math.abs(f2);
        if (abs < f3) {
            AppMethodBeat.o(200466);
            return 0.0f;
        } else if (abs <= f4) {
            AppMethodBeat.o(200466);
            return f2;
        } else if (f2 > 0.0f) {
            AppMethodBeat.o(200466);
            return f4;
        } else {
            float f5 = -f4;
            AppMethodBeat.o(200466);
            return f5;
        }
    }

    private static float distanceInfluenceForSnapDuration(float f2) {
        AppMethodBeat.i(200467);
        float sin = (float) Math.sin((double) ((f2 - 0.5f) * 0.4712389f));
        AppMethodBeat.o(200467);
        return sin;
    }

    private final void n(float f2, float f3, float f4, float f5) {
        AppMethodBeat.i(200468);
        this.WM = true;
        this.Aaw.b(this.Aax, f2, f3, f4, f5);
        this.WM = false;
        if (this.Aas == 1) {
            bf(0);
        }
        AppMethodBeat.o(200468);
    }

    private final void bd(int i2) {
        int i3;
        if (this.Wy != null) {
            float[] fArr = this.Wy;
            if (fArr != null) {
                i3 = fArr.length;
            } else {
                i3 = 0;
            }
            if (i3 > i2) {
                float[] fArr2 = this.Wy;
                if (fArr2 != null) {
                    fArr2[i2] = 0.0f;
                }
                float[] fArr3 = this.Wz;
                if (fArr3 != null) {
                    fArr3[i2] = 0.0f;
                }
                float[] fArr4 = this.WA;
                if (fArr4 != null) {
                    fArr4[i2] = 0.0f;
                }
                float[] fArr5 = this.WB;
                if (fArr5 != null) {
                    fArr5[i2] = 0.0f;
                }
                int[] iArr = this.WC;
                if (iArr != null) {
                    iArr[i2] = 0;
                }
                int[] iArr2 = this.WD;
                if (iArr2 != null) {
                    iArr2[i2] = 0;
                }
                int[] iArr3 = this.WE;
                if (iArr3 != null) {
                    iArr3[i2] = 0;
                }
                this.WF &= (1 << i2) ^ -1;
            }
        }
    }

    private final void i(MotionEvent motionEvent) {
        AppMethodBeat.i(200470);
        int g2 = i.g(motionEvent);
        for (int i2 = 0; i2 < g2; i2++) {
            int c2 = i.c(motionEvent, i2);
            float d2 = i.d(motionEvent, i2);
            float e2 = i.e(motionEvent, i2);
            float[] fArr = this.WA;
            float[] fArr2 = this.WB;
            if (fArr != null && fArr2 != null && fArr.length > c2 && fArr2.length > c2) {
                fArr[c2] = d2;
                fArr2[c2] = e2;
            }
        }
        AppMethodBeat.o(200470);
    }

    private boolean be(int i2) {
        return ((this.WF & 1) << i2) != 0;
    }

    public final void bf(int i2) {
        AppMethodBeat.i(200471);
        if (this.Aas != i2) {
            this.Aas = i2;
            this.Aaw.L(i2);
            if (i2 == 0) {
                this.Aax = null;
            }
        }
        AppMethodBeat.o(200471);
    }

    private boolean z(View view, int i2) {
        boolean z = false;
        AppMethodBeat.i(200472);
        if (view == this.Aax && this.om == i2) {
            AppMethodBeat.o(200472);
            return true;
        } else if (view == null || !this.Aaw.c(view, i2)) {
            AppMethodBeat.o(200472);
            return false;
        } else {
            this.om = i2;
            p.h(view, "childView");
            if (view.getParent() == this.WN) {
                z = true;
            }
            if (!z) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.WN + ")").toString());
                AppMethodBeat.o(200472);
                throw illegalArgumentException;
            }
            this.Aax = view;
            this.om = i2;
            this.Aaw.eqJ();
            bf(1);
            AppMethodBeat.o(200472);
            return true;
        }
    }

    public final boolean j(MotionEvent motionEvent) {
        View J;
        AppMethodBeat.i(200473);
        p.h(motionEvent, "ev");
        int e2 = i.e(motionEvent);
        int f2 = i.f(motionEvent);
        if (e2 == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        switch (e2) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int c2 = i.c(motionEvent, 0);
                a(x, y, c2);
                View J2 = J((int) x, (int) y);
                if (J2 == this.Aax && this.Aas == 2) {
                    z(J2, c2);
                }
                int[] iArr = this.WC;
                Integer valueOf = iArr != null ? Integer.valueOf(iArr[c2]) : null;
                if (valueOf != null) {
                    valueOf.intValue();
                    break;
                }
                break;
            case 1:
            case 3:
                cancel();
                break;
            case 2:
                i(motionEvent);
                int g2 = i.g(motionEvent);
                for (int i2 = 0; i2 < g2 && this.Wy != null; i2++) {
                    int c3 = i.c(motionEvent, i2);
                    float d2 = i.d(motionEvent, i2);
                    float e3 = i.e(motionEvent, i2);
                    float[] fArr = this.Wy;
                    float f3 = d2 - (fArr != null ? fArr[c3] : 0.0f);
                    float[] fArr2 = this.Wz;
                    b(f3, e3 - (fArr2 != null ? fArr2[c3] : 0.0f), c3);
                    if (this.Aas == 1) {
                        break;
                    } else {
                        float[] fArr3 = this.Wy;
                        int i3 = fArr3 != null ? (int) fArr3[c3] : 0;
                        float[] fArr4 = this.Wz;
                        View J3 = J(i3, fArr4 != null ? (int) fArr4[c3] : 0);
                        if (J3 != null && r(J3, f3) && z(J3, c3)) {
                            break;
                        }
                    }
                }
                break;
            case 5:
                int c4 = i.c(motionEvent, f2);
                float d3 = i.d(motionEvent, f2);
                float e4 = i.e(motionEvent, f2);
                a(d3, e4, c4);
                if (this.Aas != 0) {
                    if (this.Aas == 2 && (J = J((int) d3, (int) e4)) == this.Aax) {
                        z(J, c4);
                        break;
                    }
                } else {
                    int[] iArr2 = this.WC;
                    Integer valueOf2 = iArr2 != null ? Integer.valueOf(iArr2[c4]) : null;
                    if (valueOf2 != null) {
                        valueOf2.intValue();
                        if ((valueOf2.intValue() & this.WJ) != 0) {
                            valueOf2.intValue();
                            break;
                        }
                    }
                }
                break;
            case 6:
                bd(i.c(motionEvent, f2));
                break;
        }
        if (this.Aas == 1) {
            AppMethodBeat.o(200473);
            return true;
        }
        AppMethodBeat.o(200473);
        return false;
    }

    public final void k(MotionEvent motionEvent) {
        int i2 = 0;
        float f2 = 0.0f;
        AppMethodBeat.i(200474);
        p.h(motionEvent, "ev");
        int e2 = i.e(motionEvent);
        int f3 = i.f(motionEvent);
        if (e2 == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        switch (e2) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int c2 = i.c(motionEvent, 0);
                View J = J((int) x, (int) y);
                a(x, y, c2);
                z(J, c2);
                int[] iArr = this.WC;
                Integer valueOf = iArr != null ? Integer.valueOf(iArr[c2]) : null;
                if (valueOf != null) {
                    valueOf.intValue();
                    if ((valueOf.intValue() & this.WJ) != 0) {
                        valueOf.intValue();
                    }
                    AppMethodBeat.o(200474);
                    return;
                }
                AppMethodBeat.o(200474);
                return;
            case 1:
                if (this.Aas == 1) {
                    int b2 = i.b(motionEvent, this.om);
                    if (b2 >= 0) {
                        i2 = b2;
                    }
                    float d2 = i.d(motionEvent, i2);
                    float e3 = i.e(motionEvent, i2);
                    float[] fArr = this.Wy;
                    float f4 = d2 - (fArr != null ? fArr[this.om] : 0.0f);
                    float[] fArr2 = this.Wz;
                    if (fArr2 != null) {
                        f2 = fArr2[this.om];
                    }
                    ab(f4, e3 - f2);
                }
                cancel();
                AppMethodBeat.o(200474);
                return;
            case 2:
                if (this.Aas == 1) {
                    int b3 = i.b(motionEvent, this.om);
                    if (b3 < 0) {
                        b3 = 0;
                    }
                    float d3 = i.d(motionEvent, b3);
                    float e4 = i.e(motionEvent, b3);
                    float[] fArr3 = this.WA;
                    int i3 = (int) ((d3 - (fArr3 != null ? fArr3[this.om] : 0.0f)) / 1.6666666f);
                    float[] fArr4 = this.WB;
                    int i4 = (int) ((e4 - (fArr4 != null ? fArr4[this.om] : 0.0f)) / 1.6666666f);
                    View view = this.Aax;
                    int left = (view != null ? view.getLeft() : 0) + i3;
                    View view2 = this.Aax;
                    int top = (view2 != null ? view2.getTop() : 0) + i4;
                    View view3 = this.Aax;
                    int left2 = view3 != null ? view3.getLeft() : 0;
                    View view4 = this.Aax;
                    int top2 = view4 != null ? view4.getTop() : 0;
                    if (i3 != 0) {
                        left = this.Aaw.RI(left);
                        View view5 = this.Aax;
                        if (view5 != null) {
                            view5.offsetLeftAndRight(left - left2);
                        }
                    }
                    if (i4 != 0) {
                        View view6 = this.Aax;
                        if (view6 != null) {
                            view6.offsetTopAndBottom(0 - top2);
                            top = 0;
                        } else {
                            top = 0;
                        }
                    }
                    if (!(i3 == 0 && i4 == 0)) {
                        this.Aaw.l(this.Aax, left, top, left - left2, top - top2);
                    }
                    float[] fArr5 = this.Wy;
                    float f5 = d3 - (fArr5 != null ? fArr5[this.om] : 0.0f);
                    float[] fArr6 = this.Wz;
                    if (fArr6 != null) {
                        f2 = fArr6[this.om];
                    }
                    this.Aaw.a(d3, e4, i3, i4, (int) f5, (int) (e4 - f2));
                    i(motionEvent);
                    AppMethodBeat.o(200474);
                    return;
                }
                int g2 = i.g(motionEvent);
                for (int i5 = 0; i5 < g2 && this.Wy != null; i5++) {
                    int c3 = i.c(motionEvent, i5);
                    float d4 = i.d(motionEvent, i5);
                    float e5 = i.e(motionEvent, i5);
                    float[] fArr7 = this.Wy;
                    float f6 = d4 - (fArr7 != null ? fArr7[c3] : 0.0f);
                    float[] fArr8 = this.Wz;
                    b(f6, e5 - (fArr8 != null ? fArr8[c3] : 0.0f), c3);
                    if (this.Aas != 1) {
                        float[] fArr9 = this.Wy;
                        int i6 = fArr9 != null ? (int) fArr9[c3] : 0;
                        float[] fArr10 = this.Wz;
                        View J2 = J(i6, fArr10 != null ? (int) fArr10[c3] : 0);
                        if (!r(J2, f6) || !z(J2, c3)) {
                        }
                    }
                }
                i(motionEvent);
                AppMethodBeat.o(200474);
                return;
            case 3:
                if (this.Aas == 1) {
                    int b4 = i.b(motionEvent, this.om);
                    if (b4 >= 0) {
                        i2 = b4;
                    }
                    float d5 = i.d(motionEvent, i2);
                    float e6 = i.e(motionEvent, i2);
                    float[] fArr11 = this.Wy;
                    float f7 = d5 - (fArr11 != null ? fArr11[this.om] : 0.0f);
                    float[] fArr12 = this.Wz;
                    n(0.0f, 0.0f, f7, e6 - (fArr12 != null ? fArr12[this.om] : 0.0f));
                }
                cancel();
                break;
            case 5:
                int c4 = i.c(motionEvent, f3);
                float d6 = i.d(motionEvent, f3);
                float e7 = i.e(motionEvent, f3);
                a(d6, e7, c4);
                if (this.Aas == 0) {
                    z(J((int) d6, (int) e7), c4);
                    if (this.WC == null) {
                        AppMethodBeat.o(200474);
                        return;
                    }
                } else {
                    int i7 = (int) d6;
                    int i8 = (int) e7;
                    View view7 = this.Aax;
                    if (view7 != null && i7 >= view7.getLeft() && i7 < view7.getRight() && i8 >= view7.getTop() && i8 < view7.getBottom()) {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        z(this.Aax, c4);
                    }
                    AppMethodBeat.o(200474);
                    return;
                }
                break;
            case 6:
                int c5 = i.c(motionEvent, f3);
                if (this.Aas == 1 && c5 == this.om) {
                    int i9 = -1;
                    int g3 = i.g(motionEvent);
                    while (true) {
                        if (i2 < g3) {
                            int c6 = i.c(motionEvent, i2);
                            if (c6 == this.om) {
                                i2++;
                            } else if (J((int) i.d(motionEvent, i2), (int) i.e(motionEvent, i2)) != this.Aax || !z(this.Aax, c6)) {
                                i2++;
                            } else {
                                i9 = this.om;
                            }
                        }
                    }
                    if (i9 == -1) {
                        ab(0.0f, 0.0f);
                    }
                }
                bd(c5);
                AppMethodBeat.o(200474);
                return;
        }
        AppMethodBeat.o(200474);
    }

    private final void b(float f2, float f3, int i2) {
        int[] iArr;
        int i3 = 1;
        AppMethodBeat.i(200475);
        if (!a(f2, f3, i2, 1)) {
            i3 = 0;
        }
        if (a(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (a(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (a(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 == 0 || (iArr = this.WD) == null) {
            AppMethodBeat.o(200475);
            return;
        }
        iArr[i2] = i3 | iArr[i2];
        AppMethodBeat.o(200475);
    }

    private final boolean a(float f2, float f3, int i2, int i3) {
        AppMethodBeat.i(200476);
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        int[] iArr = this.WC;
        if (((iArr != null ? iArr[i2] : 0) & i3) == i3 && (this.WJ & i3) != 0) {
            int[] iArr2 = this.WE;
            if (((iArr2 != null ? iArr2[i2] : 0) & i3) != i3) {
                int[] iArr3 = this.WD;
                if (((iArr3 != null ? iArr3[i2] : 0) & i3) != i3 && (abs > ((float) this.rZ) || abs2 > ((float) this.rZ))) {
                    int[] iArr4 = this.WD;
                    if (((iArr4 != null ? iArr4[i2] : 0) & i3) != 0 || abs <= ((float) this.rZ)) {
                        AppMethodBeat.o(200476);
                        return false;
                    }
                    AppMethodBeat.o(200476);
                    return true;
                }
            }
        }
        AppMethodBeat.o(200476);
        return false;
    }

    private final boolean r(View view, float f2) {
        AppMethodBeat.i(200477);
        if (view == null) {
            AppMethodBeat.o(200477);
            return false;
        }
        if (!(this.Aaw.awM() > 0)) {
            AppMethodBeat.o(200477);
            return false;
        } else if (Math.abs(f2) > ((float) this.rZ)) {
            AppMethodBeat.o(200477);
            return true;
        } else {
            AppMethodBeat.o(200477);
            return false;
        }
    }

    public final boolean hl(int i2, int i3) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(200478);
        if (!be(i3) || this.Wy == null) {
            AppMethodBeat.o(200478);
            return false;
        }
        boolean z4 = (i2 & 1) == 1;
        if ((i2 & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        if ((i2 & 8) == 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((i2 & 4) == 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        float[] fArr = this.WA;
        float[] fArr2 = this.WB;
        float[] fArr3 = this.Wy;
        float[] fArr4 = this.Wz;
        if (!(fArr == null || fArr2 == null || fArr3 == null || fArr4 == null)) {
            float f2 = fArr[i3] - fArr3[i3];
            float f3 = fArr2[i3] - fArr4[i3];
            if (!z4 || !z) {
                if (z3) {
                    if (f2 >= ((float) this.rZ) || Math.abs(f2) <= Math.abs(f3)) {
                        AppMethodBeat.o(200478);
                        return false;
                    }
                    AppMethodBeat.o(200478);
                    return true;
                } else if (z2) {
                    if (f2 <= ((float) this.rZ) || Math.abs(f2) <= Math.abs(f3)) {
                        AppMethodBeat.o(200478);
                        return false;
                    }
                    AppMethodBeat.o(200478);
                    return true;
                } else if (z4) {
                    if (Math.abs(f2) > ((float) this.rZ)) {
                        AppMethodBeat.o(200478);
                        return true;
                    }
                    AppMethodBeat.o(200478);
                    return false;
                } else if (z) {
                    if (Math.abs(f3) > ((float) this.rZ)) {
                        AppMethodBeat.o(200478);
                        return true;
                    }
                    AppMethodBeat.o(200478);
                    return false;
                }
            } else if ((f2 * f2) + (f3 * f3) > ((float) (this.rZ * this.rZ))) {
                AppMethodBeat.o(200478);
                return true;
            } else {
                AppMethodBeat.o(200478);
                return false;
            }
        }
        AppMethodBeat.o(200478);
        return false;
    }

    public final boolean RH(int i2) {
        AppMethodBeat.i(200479);
        if (be(i2)) {
            int[] iArr = this.WC;
            if (((iArr != null ? iArr[i2] : 0) & 1) != 0) {
                AppMethodBeat.o(200479);
                return true;
            }
        }
        AppMethodBeat.o(200479);
        return false;
    }

    private final void ab(float f2, float f3) {
        AppMethodBeat.i(200480);
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000, this.Aat);
        }
        n(f(t.a(this.mVelocityTracker, this.om), this.Aau, this.Aat), f(t.b(this.mVelocityTracker, this.om), this.Aau, this.Aat), f2, f3);
        AppMethodBeat.o(200480);
    }

    private View J(int i2, int i3) {
        AppMethodBeat.i(200481);
        for (int childCount = this.WN.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.WN.getChildAt(childCount);
            p.g(childAt, "child");
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                AppMethodBeat.o(200481);
                return childAt;
            }
        }
        AppMethodBeat.o(200481);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0018J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Companion;", "", "()V", "BASE_SETTLE_DURATION", "", "DIRECTION_ALL", "DIRECTION_HORIZONTAL", "DIRECTION_HORIZONTAL_LEFT", "DIRECTION_HORIZONTAL_RIGHT", "DIRECTION_VERTICAL", "EDGE_ALL", "EDGE_BOTTOM", "EDGE_LEFT", "EDGE_RIGHT", "EDGE_SIZE", "EDGE_TOP", "INVALID_POINTER", "MAX_SETTLE_DURATION", "STATE_DRAGGING", "STATE_IDLE", "STATE_SETTLING", "TAG", "", "sInterpolator", "Landroid/view/animation/Interpolator;", "create", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "forParent", "Landroid/view/ViewGroup;", "cb", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "interpolator", "sensitivity", "", "plugin-multitask_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static c a(ViewGroup viewGroup, a aVar, Interpolator interpolator) {
            AppMethodBeat.i(200456);
            p.h(viewGroup, "forParent");
            p.h(interpolator, "interpolator");
            Context context = viewGroup.getContext();
            p.g(context, "forParent.context");
            c cVar = new c(context, viewGroup, aVar, interpolator, (byte) 0);
            AppMethodBeat.o(200456);
            return cVar;
        }
    }

    static {
        AppMethodBeat.i(200483);
        AppMethodBeat.o(200483);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "t", "getInterpolation"})
    /* renamed from: com.tencent.mm.plugin.multitask.animation.c.a.c$c  reason: collision with other inner class name */
    static final class animation.InterpolatorC1507c implements Interpolator {
        public static final animation.InterpolatorC1507c AaA = new animation.InterpolatorC1507c();

        static {
            AppMethodBeat.i(200455);
            AppMethodBeat.o(200455);
        }

        animation.InterpolatorC1507c() {
        }

        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        if ((r1 != null ? r1.length : 0) <= r18) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(float r16, float r17, int r18) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitask.animation.c.a.c.a(float, float, int):void");
    }
}
