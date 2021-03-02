package com.tencent.mm.plugin.multitask.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.support.v4.view.i;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.multitask.animation.c.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bF\b\u0016\u0018\u0000 \u00012\u00020\u0001:\b\u0001\u0001 \u0001¡\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010-H\u0016J\b\u0010?\u001a\u00020=H\u0003J\u001c\u0010@\u001a\u00020=2\b\u0010A\u001a\u0004\u0018\u00010\u001c2\b\u0010B\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000bH\u0002J\b\u0010F\u001a\u00020=H\u0016J\u0010\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000fH\u0002J\u001a\u0010I\u001a\u00020=2\b\u0010J\u001a\u0004\u0018\u00010\u001c2\u0006\u0010K\u001a\u00020\u000fH\u0016J\u0018\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u000fH\u0016J\u0012\u0010O\u001a\u00020=2\b\u0010J\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010P\u001a\u00020=2\b\u0010J\u001a\u0004\u0018\u00010\u001c2\b\u0010Q\u001a\u0004\u0018\u00010'2\b\u0010R\u001a\u0004\u0018\u00010'H\u0016J\b\u0010S\u001a\u00020=H\u0016J\b\u0010T\u001a\u00020=H\u0016J\u0010\u0010U\u001a\u00020\u00062\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020=2\u0006\u0010E\u001a\u00020\u000bH\u0016J\b\u0010Y\u001a\u00020=H\u0016J \u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\bH\u0014J\b\u0010_\u001a\u00020\u0006H\u0016J\b\u0010`\u001a\u00020\u000fH\u0016J\b\u0010a\u001a\u00020\u000fH\u0016J\n\u0010b\u001a\u0004\u0018\u00010'H\u0002J\b\u0010c\u001a\u00020\u000fH\u0016J\b\u0010d\u001a\u00020\u000fH\u0016J\u0012\u0010e\u001a\u00020\u00062\b\u0010f\u001a\u0004\u0018\u00010\u001cH\u0002J\"\u0010g\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010\u001c2\u0006\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u000fH\u0016J\b\u0010k\u001a\u00020=H\u0014J\b\u0010l\u001a\u00020=H\u0014J\u0010\u0010m\u001a\u00020\u00062\u0006\u0010V\u001a\u00020WH\u0016J0\u0010n\u001a\u00020=2\u0006\u0010o\u001a\u00020\u00062\u0006\u0010p\u001a\u00020\u000f2\u0006\u0010q\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\u000f2\u0006\u0010s\u001a\u00020\u000fH\u0014J\u0018\u0010t\u001a\u00020=2\u0006\u0010u\u001a\u00020\u000f2\u0006\u0010v\u001a\u00020\u000fH\u0014J\u0010\u0010w\u001a\u00020=2\u0006\u0010x\u001a\u00020\u000fH\u0002J(\u0010y\u001a\u00020=2\u0006\u0010z\u001a\u00020\u000f2\u0006\u0010{\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020\u000fH\u0014J\u0010\u0010~\u001a\u00020\u00062\u0006\u0010V\u001a\u00020WH\u0016J\u0012\u0010\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010-H\u0016J\t\u0010\u0001\u001a\u00020=H\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u001b\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J\u0014\u0010\u0001\u001a\u00020=2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0011\u0010\u0001\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001fH\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u001f\u0010\u0001\u001a\u00020=2\t\u0010\u0001\u001a\u0004\u0018\u00010'2\t\b\u0002\u0010\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020'H\u0002J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u0001\u001a\u00020=2\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J,\u0010\u0001\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u0001\u001a\u00020=H\u0014J\t\u0010\u0001\u001a\u00020=H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_CLIP_PANEL_FLAG", "", "DEFAULT_FADE_COLOR", "", "DEFAULT_OVERLAY_FLAG", "mAnchorPoint", "", "mCanSlide", "mClipPanel", "mCoveredFadeColor", "", "mCoveredFadePaint", "Landroid/graphics/Paint;", "mCoveredRoundPath", "Landroid/graphics/Path;", "mCurItemIndex", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mDragView", "Landroid/view/View;", "mExtraSlideRange", "mFadeOnClickListener", "Landroid/view/View$OnClickListener;", "mFirstLayout", "mInitialMotionX", "mInitialMotionY", "mIsSlidingLeft", "mIsUnableToDrag", "mLastItemIndex", "mLastNotDraggingSlideState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "mMainView", "mOverlayContent", "mPanelExpose", "mPanelSlideListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "mPanelWidth", "mParallaxOffset", "mPlaySound", "mPrevMotionX", "mPrevMotionY", "mShadowWidth", "mSlideOffset", "mSlideRange", "mSlideState", "mSlideableView", "mTmpRect", "Landroid/graphics/Rect;", "mVibrator", "Landroid/os/Vibrator;", "addPanelSlideListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "applyParallaxForCurrentSlideOffset", "attachViewWrapper", "multTaskView", "launchView", "checkExpand", "computePanelLeftPosition", "slideOffset", "computeScroll", "computeSlideOffset", "leftPosition", "dispatchOnPanelItemSelected", "panel", "position", "dispatchOnPanelSizeChanged", "width", "height", "dispatchOnPanelSlide", "dispatchOnPanelStateChanged", "previousState", "newState", "dispatchOnPlaySound", "dispatchTouchEnd", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchTouchSlide", "dispatchTouchStart", "drawChild", "canvas", "Landroid/graphics/Canvas;", "child", "drawingTime", "getCanSlide", "getCurItem", "getCurrentParallaxOffset", "getPanelState", "getPanelWidth", "getShadowWidth", "hasOpaqueBackground", "v", "isViewUnder", "view", "x", "y", "onAttachedToWindow", "onDetachedFromWindow", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPanelDragged", "newLeft", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "removePanelSlideListener", "setAllChildrenVisible", "setCanSlide", "enable", "setCoveredFadeColor", "color", "setCurrentItem", "item", "smoothScroll", "setDragView", "dragView", "setExtraSlideRange", "val", "setFadeOnClickListener", "setOverlayed", "overlayed", "setPanelExpose", "setPanelState", "state", "withNoAnim", "setPanelStateInternal", "setPanelWidth", "setParallaxOffset", "setShadowWidth", "setSlideLeft", "isSlideLeft", "smoothSlideTo", "velocity", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "smoothToBottom", "updateObscuredViewVisibility", "Companion", "PanelSlideListener", "PanelState", "ViewDragCallback", "plugin-multitask_release"})
public final class b extends FrameLayout {
    private static final int Ade = at.fromDPToPix(MMApplicationContext.getContext(), 36);
    private static final int Adf = at.fromDPToPix(MMApplicationContext.getContext(), 16);
    public static final a Adg = new a((byte) 0);
    private static final float[] zZR = {(float) Adf, (float) Adf, 0.0f, 0.0f, 0.0f, 0.0f, (float) Adf, (float) Adf};
    public com.tencent.mm.plugin.multitask.animation.c.a.c AaG;
    private boolean AcG;
    private View.OnClickListener AcH;
    public CopyOnWriteArrayList<AbstractC1522b> AcI = new CopyOnWriteArrayList<>();
    private int AcJ = -1;
    private int AcK = -1;
    private final boolean AcL;
    private final long AcM = 2566914048L;
    private final boolean AcN = true;
    private boolean AcO;
    private boolean AcP = this.AcL;
    private final boolean AcQ = this.AcN;
    private final Paint AcR = new Paint();
    private final Path AcS = new Path();
    private float AcT;
    private float AcU;
    private int AcV = -1;
    private int AcW = -1;
    private View AcX;
    private int AcY;
    private final float AcZ = 1.0f;
    private int Ada = -1;
    private int Adb = -1;
    private c Adc = c.COLLAPSED;
    private c Add = c.EXPANDED;
    private final Rect Ui = new Rect();
    private int Vh = ((int) this.AcM);
    private View Vl;
    private float Vm;
    private int Vo;
    private boolean mCanSlide = true;
    private boolean mFirstLayout = true;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsUnableToDrag;
    public Vibrator ooM;
    private View rhx;

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&J\u001a\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH&J&\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "", "enableExpand", "", "onPanelItemSelected", "", "panel", "Landroid/view/View;", "position", "", "onPanelSizeChanged", "screenSizeW", "screenSizeH", "onPanelSlide", "slideOffset", "", "onPanelStateChanged", "previousState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "newState", "onPanelTouchEnd", "onPanelTouchSlide", "onPanelTouchStart", "onPlaySound", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.ui.base.b$b  reason: collision with other inner class name */
    public interface AbstractC1522b {
        void RQ(int i2);

        void a(c cVar, c cVar2);

        void bB(float f2);

        void bC(float f2);

        void err();

        void ers();

        void ert();

        boolean eru();

        void hm(int i2, int i3);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "ANCHORED", "HIDDEN", "DRAGGING", "plugin-multitask_release"})
    public enum c {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING;

        static {
            AppMethodBeat.i(200705);
            AppMethodBeat.o(200705);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(200707);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(200707);
            return cVar;
        }
    }

    public static final /* synthetic */ void a(b bVar, c cVar) {
        AppMethodBeat.i(200754);
        bVar.setPanelStateInternal(cVar);
        AppMethodBeat.o(200754);
    }

    public static final /* synthetic */ float b(b bVar, int i2) {
        AppMethodBeat.i(200752);
        float RP = bVar.RP(i2);
        AppMethodBeat.o(200752);
        return RP;
    }

    public static final /* synthetic */ int b(b bVar, float f2) {
        AppMethodBeat.i(200751);
        int bA = bVar.bA(f2);
        AppMethodBeat.o(200751);
        return bA;
    }

    public static final /* synthetic */ boolean g(b bVar) {
        AppMethodBeat.i(200750);
        boolean ern = bVar.ern();
        AppMethodBeat.o(200750);
        return ern;
    }

    public static final /* synthetic */ void k(b bVar) {
        AppMethodBeat.i(200753);
        bVar.ero();
        AppMethodBeat.o(200753);
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.multitask.animation.c.a.c getMDragHelper() {
        return this.AaG;
    }

    /* access modifiers changed from: protected */
    public final void setMDragHelper(com.tencent.mm.plugin.multitask.animation.c.a.c cVar) {
        this.AaG = cVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$Companion;", "", "()V", "COLLAPSE_DURATION", "", "CORNER_SIZE", "", "getCORNER_SIZE", "()I", "EXPOSE_WIDTH", "getEXPOSE_WIDTH", "MAX_FLING_VELOCITY", "MIN_FLING_VELOCITY", "SHADDER_ALPAH_FRACTOR", "", "SHADDER_START_FRACTOR", "TAG", "", "mRectConnerRadius", "", "getMRectConnerRadius", "()[F", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(200748);
        AppMethodBeat.o(200748);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(200747);
        AppMethodBeat.o(200747);
    }

    public final void setFadeOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(200718);
        p.h(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.AcH = onClickListener;
        AppMethodBeat.o(200718);
    }

    public final void setOverlayed(boolean z) {
        this.AcP = z;
    }

    public final void setCanSlide(boolean z) {
        this.mCanSlide = z;
    }

    public final boolean getCanSlide() {
        return this.mCanSlide;
    }

    public final int getCurItem() {
        return this.AcJ;
    }

    public final void setCurrentItem(int i2, boolean z) {
        AppMethodBeat.i(200719);
        if (i2 == 0) {
            if (z) {
                a(c.EXPANDED, false);
            } else {
                a(c.EXPANDED, true);
            }
        } else if (z) {
            a(c.COLLAPSED, false);
        } else {
            a(c.COLLAPSED, true);
        }
        if (!z) {
            this.AcJ = i2;
        }
        AppMethodBeat.o(200719);
    }

    public final void setSlideLeft(boolean z) {
        this.AcO = z;
    }

    public final void setCoveredFadeColor(int i2) {
        AppMethodBeat.i(200720);
        this.Vh = i2;
        requestLayout();
        AppMethodBeat.o(200720);
    }

    public final void setPanelWidth(int i2) {
        AppMethodBeat.i(200721);
        if (getPanelWidth() == i2) {
            AppMethodBeat.o(200721);
            return;
        }
        this.AcV = i2;
        if (!this.mFirstLayout) {
            requestLayout();
        }
        if (getPanelState() == c.COLLAPSED) {
            a(0.0f, 0, false);
            invalidate();
            AppMethodBeat.o(200721);
            return;
        }
        AppMethodBeat.o(200721);
    }

    public final void setPanelExpose(int i2) {
        this.AcW = i2;
    }

    public final void setExtraSlideRange(int i2) {
        this.AcY = i2;
    }

    private final c getPanelState() {
        return this.Adc;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(c cVar, boolean z) {
        int i2;
        AppMethodBeat.i(200722);
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = this.AaG;
        if (cVar2 != null && cVar2.Aas == 2) {
            Log.d("MicroMsg.MultiTaskViewGroup", "View is settling. Aborting animation.");
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar3 = this.AaG;
            if (cVar3 != null) {
                cVar3.abort();
            }
        }
        if (!((cVar == null || cVar == c.DRAGGING) ? false : true)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Panel state cannot be null or DRAGGING.".toString());
            AppMethodBeat.o(200722);
            throw illegalArgumentException;
        } else if (!isEnabled() || ((!this.mFirstLayout && this.Vl == null) || cVar == this.Adc || this.Adc == c.DRAGGING)) {
            AppMethodBeat.o(200722);
        } else if (this.mFirstLayout) {
            setPanelStateInternal(cVar);
            AppMethodBeat.o(200722);
        } else {
            if (this.Adc == c.HIDDEN) {
                View view = this.Vl;
                if (view != null) {
                    view.setVisibility(0);
                }
                requestLayout();
            }
            if (cVar == null) {
                AppMethodBeat.o(200722);
                return;
            }
            switch (c.$EnumSwitchMapping$0[cVar.ordinal()]) {
                case 1:
                    a(this.AcZ, 0, z);
                    AppMethodBeat.o(200722);
                    return;
                case 2:
                    a(0.0f, 250, z);
                    AppMethodBeat.o(200722);
                    return;
                case 3:
                    a(1.0f, 0, z);
                    AppMethodBeat.o(200722);
                    return;
                case 4:
                    int bA = bA(0.0f);
                    if (this.AcO) {
                        i2 = this.AcW + this.AcY;
                    } else {
                        i2 = -(this.AcW + this.AcY);
                    }
                    a(RP(i2 + bA), 0, z);
                    break;
            }
            AppMethodBeat.o(200722);
        }
    }

    public final int getShadowWidth() {
        return this.Ada;
    }

    public final void setShadowWidth(int i2) {
        AppMethodBeat.i(200723);
        this.Ada = i2;
        if (!this.mFirstLayout) {
            invalidate();
        }
        AppMethodBeat.o(200723);
    }

    public final int getCurrentParallaxOffset() {
        AppMethodBeat.i(200724);
        int max = (int) (((float) this.Adb) * Math.max(this.Vm, 0.0f));
        if (this.AcO) {
            int i2 = -max;
            AppMethodBeat.o(200724);
            return i2;
        }
        AppMethodBeat.o(200724);
        return max;
    }

    public final void setParallaxOffset(int i2) {
        AppMethodBeat.i(200725);
        this.Adb = i2;
        if (!this.mFirstLayout) {
            requestLayout();
        }
        AppMethodBeat.o(200725);
    }

    public final int getPanelWidth() {
        return this.AcV;
    }

    private boolean i(View view, int i2, int i3) {
        AppMethodBeat.i(200726);
        if (view == null) {
            AppMethodBeat.o(200726);
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i2;
        int i5 = iArr2[1] + i3;
        if (i4 < iArr[0] || i4 >= iArr[0] + view.getWidth() || i5 < iArr[1] || i5 >= iArr[1] + view.getHeight()) {
            AppMethodBeat.o(200726);
            return false;
        }
        AppMethodBeat.o(200726);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(200727);
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            this.mFirstLayout = true;
            synchronized (this.AcI) {
                try {
                    Iterator<AbstractC1522b> it = this.AcI.iterator();
                    while (it.hasNext()) {
                        it.next().hm(i2, i3);
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(200727);
                }
            }
            return;
        }
        AppMethodBeat.o(200727);
    }

    public final void setDragView(View view) {
        this.AcX = view;
    }

    private boolean a(float f2, long j2, boolean z) {
        int i2;
        AppMethodBeat.i(200728);
        if (!isEnabled() || this.Vl == null) {
            AppMethodBeat.o(200728);
            return false;
        }
        int bA = bA(f2);
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar = this.AaG;
        if (cVar != null) {
            View view = this.Vl;
            if (view != null) {
                i2 = view.getTop();
            } else {
                i2 = 0;
            }
            if (cVar.a(view, bA, i2, j2, z)) {
                gf();
                u.X(this);
                AppMethodBeat.o(200728);
                return true;
            }
        }
        AppMethodBeat.o(200728);
        return false;
    }

    public final void computeScroll() {
        Boolean bool;
        int i2;
        boolean z;
        View view;
        View view2;
        boolean z2 = false;
        AppMethodBeat.i(200729);
        if (this.AaG != null) {
            Boolean bool2 = Boolean.TRUE;
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar = this.AaG;
            if (cVar != null) {
                if (cVar.Aas == 2) {
                    boolean computeScrollOffset = cVar.UD.computeScrollOffset();
                    int currX = cVar.UD.getCurrX();
                    int currY = cVar.UD.getCurrY();
                    View view3 = cVar.Aax;
                    int left = currX - (view3 != null ? view3.getLeft() : 0);
                    View view4 = cVar.Aax;
                    if (view4 != null) {
                        i2 = view4.getTop();
                    } else {
                        i2 = 0;
                    }
                    int i3 = currY - i2;
                    if (!(left == 0 || (view2 = cVar.Aax) == null)) {
                        view2.offsetLeftAndRight(left);
                    }
                    if (!(i3 == 0 || (view = cVar.Aax) == null)) {
                        view.offsetTopAndBottom(i3);
                    }
                    if (!(left == 0 && i3 == 0)) {
                        cVar.Aaw.l(cVar.Aax, currX, currY, left, i3);
                    }
                    if (computeScrollOffset && currX == cVar.UD.getFinalX() && currY == cVar.UD.getFinalY()) {
                        cVar.UD.abortAnimation();
                        z = cVar.UD.isFinished();
                    } else {
                        z = computeScrollOffset;
                    }
                    if (!z) {
                        cVar.WN.post(cVar.WO);
                    }
                }
                if (cVar.Aas == 2) {
                    z2 = true;
                }
                bool = Boolean.valueOf(z2);
            } else {
                bool = null;
            }
            if (p.j(bool2, bool)) {
                if (!isEnabled()) {
                    com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = this.AaG;
                    if (cVar2 != null) {
                        cVar2.abort();
                        AppMethodBeat.o(200729);
                        return;
                    }
                    AppMethodBeat.o(200729);
                    return;
                }
                u.X(this);
            }
        }
        AppMethodBeat.o(200729);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(200730);
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        AppMethodBeat.o(200730);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(200731);
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        AppMethodBeat.o(200731);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int i4;
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int i5;
        AppMethodBeat.i(200732);
        View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        this.rhx = getChildAt(0);
        this.Vl = getChildAt(1);
        if (this.AcX == null) {
            setDragView(this.Vl);
        }
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            p.g(childAt, "child");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(200732);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (childAt.getVisibility() != 8 || i6 != 0) {
                if (p.j(childAt, this.rhx)) {
                    if (this.AcP || this.Adc == c.HIDDEN) {
                        i5 = paddingLeft;
                    } else {
                        i5 = paddingLeft - this.AcV;
                    }
                    i4 = i5 - (layoutParams2.leftMargin + layoutParams2.rightMargin);
                } else if (p.j(childAt, this.Vl)) {
                    i4 = (paddingLeft - layoutParams2.leftMargin) + this.AcY;
                } else {
                    i4 = paddingLeft;
                }
                if (layoutParams2.height == -2) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Integer.MIN_VALUE);
                } else if (layoutParams2.height == -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824);
                }
                if (layoutParams2.width == -2) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                } else {
                    if (layoutParams2.width != -1) {
                        i4 = layoutParams2.width;
                    }
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                }
                childAt.measure(makeMeasureSpec2, makeMeasureSpec);
                if (p.j(childAt, this.Vl)) {
                    this.Vo = childAt.getMeasuredWidth() - (this.AcW + this.AcY);
                    this.Adb = this.Vo;
                }
            }
        }
        setMeasuredDimension(size, size2);
        AppMethodBeat.o(200732);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        float RP;
        AppMethodBeat.i(200733);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            switch (c.haE[this.Adc.ordinal()]) {
                case 1:
                    RP = 1.0f;
                    break;
                case 2:
                    RP = this.AcZ;
                    break;
                case 3:
                    RP = RP((this.AcO ? this.AcW + this.AcY : -(this.AcW + this.AcY)) + bA(0.0f));
                    break;
                default:
                    RP = 0.0f;
                    break;
            }
            this.Vm = RP;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            p.g(childAt, "child");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(200733);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (childAt.getVisibility() != 8 || (i7 != 0 && !this.mFirstLayout)) {
                int measuredWidth = childAt.getMeasuredWidth();
                if (p.j(childAt, this.Vl)) {
                    i6 = bA(this.Vm);
                } else {
                    i6 = paddingLeft;
                }
                int i8 = layoutParams2.topMargin + paddingTop;
                childAt.layout(i6, i8, measuredWidth + i6, childAt.getMeasuredHeight() + i8);
            }
        }
        if (this.mFirstLayout) {
            erp();
        }
        ero();
        this.mFirstLayout = false;
        AppMethodBeat.o(200733);
    }

    /* access modifiers changed from: protected */
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5 = 0;
        AppMethodBeat.i(200734);
        p.h(canvas, "canvas");
        p.h(view, "child");
        int save = canvas.save();
        if (this.Vl == null || !p.j(this.Vl, view)) {
            canvas.getClipBounds(this.Ui);
            if (!this.AcP) {
                if (this.AcO) {
                    Rect rect = this.Ui;
                    int i6 = this.Ui.left;
                    View view2 = this.rhx;
                    if (view2 != null) {
                        i3 = view2.getTop();
                    } else {
                        i3 = 0;
                    }
                    rect.right = Math.max(i6, i3);
                } else {
                    Rect rect2 = this.Ui;
                    int i7 = this.Ui.left;
                    View view3 = this.rhx;
                    rect2.left = Math.min(i7, view3 != null ? view3.getBottom() : getHeight());
                }
            } else if (this.AcO) {
                Rect rect3 = this.Ui;
                int i8 = this.Ui.right;
                View view4 = this.rhx;
                rect3.right = Math.min(i8, view4 != null ? view4.getRight() : this.Ui.right);
            } else {
                Rect rect4 = this.Ui;
                int i9 = this.Ui.left;
                View view5 = this.rhx;
                rect4.left = Math.max(i9, view5 != null ? view5.getLeft() : this.Ui.left);
            }
            if (this.AcQ && this.Vm > 0.0f) {
                float width = 0.5f - ((float) (Ade / getWidth()));
                if (this.Vm >= width) {
                    float f2 = (this.Vm - width) / (1.0f - width);
                    float f3 = ((float) Adf) * f2;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    } else if (f3 > ((float) Adf)) {
                        f3 = (float) Adf;
                    }
                    zZR[0] = f3;
                    zZR[1] = f3;
                    zZR[6] = f3;
                    zZR[7] = f3;
                    int i10 = (int) (255.0f * f2);
                    if (i10 >= 0) {
                        i5 = i10 > 216 ? 216 : i10;
                    }
                    this.AcS.reset();
                    RectF rectF = new RectF(this.Ui);
                    rectF.left = this.Vm * ((float) this.Vo);
                    this.AcS.addRoundRect(rectF, zZR, Path.Direction.CW);
                    this.AcS.close();
                    canvas.clipPath(this.AcS);
                    i2 = i5;
                    z = true;
                    boolean drawChild = super.drawChild(canvas, view, j2);
                    if (this.Vh != 0 && this.Vm > 0.0f && z) {
                        this.AcR.setColor((i2 << 24) | (this.Vh & 16777215));
                        Rect rect5 = new Rect(this.Ui);
                        rect5.left = (int) (this.Vm * ((float) this.Vo));
                        canvas.drawRect(rect5, this.AcR);
                    }
                    z2 = drawChild;
                }
            }
            i2 = 0;
            z = false;
            boolean drawChild2 = super.drawChild(canvas, view, j2);
            this.AcR.setColor((i2 << 24) | (this.Vh & 16777215));
            Rect rect52 = new Rect(this.Ui);
            rect52.left = (int) (this.Vm * ((float) this.Vo));
            canvas.drawRect(rect52, this.AcR);
            z2 = drawChild2;
        } else {
            canvas.getClipBounds(this.Ui);
            if (!this.AcP) {
                if (this.AcO) {
                    Rect rect6 = this.Ui;
                    int i11 = this.Ui.right;
                    View view6 = this.Vl;
                    if (view6 != null) {
                        i4 = view6.getRight();
                    } else {
                        i4 = this.Ui.right;
                    }
                    rect6.right = Math.min(i11, i4);
                } else {
                    Rect rect7 = this.Ui;
                    int i12 = this.Ui.left;
                    View view7 = this.Vl;
                    rect7.left = Math.max(i12, view7 != null ? view7.getLeft() : this.Ui.left);
                }
            } else if (this.AcO) {
                Rect rect8 = this.Ui;
                int i13 = this.Ui.right;
                View view8 = this.Vl;
                rect8.right = Math.max(i13, view8 != null ? view8.getRight() : this.Ui.right);
                this.Ui.left -= getWidth();
            } else {
                Rect rect9 = this.Ui;
                int i14 = this.Ui.left;
                View view9 = this.Vl;
                rect9.left = Math.min(i14, view9 != null ? view9.getLeft() : this.Ui.left);
                this.Ui.right = this.Ui.left + getWidth();
            }
            if (this.AcQ) {
                canvas.clipRect(this.Ui);
            }
            z2 = super.drawChild(canvas, view, j2);
        }
        canvas.restoreToCount(save);
        AppMethodBeat.o(200734);
        return z2;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar;
        AppMethodBeat.i(200735);
        p.h(motionEvent, "ev");
        int e2 = i.e(motionEvent);
        if ((this.mCanSlide || (cVar = this.AaG) == null || !cVar.UD.isFinished()) && (!this.mIsUnableToDrag || e2 == 0)) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (e2 == 0) {
                this.AcT = x;
                this.AcU = y;
            } else if (e2 == 2) {
                float f2 = x - this.AcT;
                this.AcT = x;
                this.AcU = y;
                if (Math.abs(y - this.AcU) > Math.abs(f2)) {
                    boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(200735);
                    return dispatchTouchEvent;
                }
                boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(200735);
                return dispatchTouchEvent2;
            }
            boolean dispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(200735);
            return dispatchTouchEvent3;
        }
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = this.AaG;
        if (cVar2 != null) {
            cVar2.abort();
        }
        boolean dispatchTouchEvent4 = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(200735);
        return dispatchTouchEvent4;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar;
        AppMethodBeat.i(200736);
        p.h(motionEvent, "ev");
        if (this.mCanSlide || (cVar = this.AaG) == null || !cVar.UD.isFinished()) {
            int e2 = i.e(motionEvent);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float abs = Math.abs(x - this.mInitialMotionX);
            float abs2 = Math.abs(y - this.mInitialMotionY);
            switch (e2) {
                case 0:
                    this.mIsUnableToDrag = false;
                    this.mInitialMotionX = x;
                    this.mInitialMotionY = y;
                    this.AcT = x;
                    this.AcU = y;
                    if (!i(this.AcX, (int) x, (int) y)) {
                        com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = this.AaG;
                        if (cVar2 != null) {
                            cVar2.cancel();
                        }
                        this.mIsUnableToDrag = true;
                        AppMethodBeat.o(200736);
                        return false;
                    } else if (this.AcJ == 0 && i(this.rhx, (int) x, (int) y)) {
                        AppMethodBeat.o(200736);
                        return true;
                    }
                case 1:
                case 3:
                    com.tencent.mm.plugin.multitask.animation.c.a.c cVar3 = this.AaG;
                    if (cVar3 != null) {
                        if (cVar3.Aas == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            com.tencent.mm.plugin.multitask.animation.c.a.c cVar4 = this.AaG;
                            if (cVar4 != null) {
                                cVar4.k(motionEvent);
                            }
                            AppMethodBeat.o(200736);
                            return true;
                        }
                    }
                    break;
                case 2:
                    float f2 = x - this.AcT;
                    float f3 = y - this.AcU;
                    this.AcT = x;
                    this.AcU = y;
                    if (abs2 > abs || Math.abs(f3) > Math.abs(f2)) {
                        if (this.AcJ != 0 || !i(this.rhx, (int) x, (int) y)) {
                            com.tencent.mm.plugin.multitask.animation.c.a.c cVar5 = this.AaG;
                            if (cVar5 != null) {
                                cVar5.cancel();
                            }
                            this.mIsUnableToDrag = true;
                            AppMethodBeat.o(200736);
                            return false;
                        }
                        AppMethodBeat.o(200736);
                        return true;
                    } else if (this.AcJ == 1 && i(this.rhx, (int) x, (int) y) && f2 < 0.0f) {
                        com.tencent.mm.plugin.multitask.animation.c.a.c cVar6 = this.AaG;
                        if (cVar6 != null) {
                            cVar6.cancel();
                        }
                        this.mIsUnableToDrag = true;
                        AppMethodBeat.o(200736);
                        return false;
                    }
                    break;
            }
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar7 = this.AaG;
            if (cVar7 != null) {
                boolean j2 = cVar7.j(motionEvent);
                AppMethodBeat.o(200736);
                return j2;
            }
            AppMethodBeat.o(200736);
            return false;
        }
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar8 = this.AaG;
        if (cVar8 != null) {
            cVar8.abort();
        }
        AppMethodBeat.o(200736);
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int scaledTouchSlop;
        com.tencent.mm.plugin.multitask.animation.c.a.c cVar;
        AppMethodBeat.i(200737);
        p.h(motionEvent, "ev");
        if (this.mCanSlide || (cVar = this.AaG) == null || !cVar.UD.isFinished()) {
            try {
                int e2 = i.e(motionEvent);
                if (e2 == 3 || e2 == 1) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    float abs = Math.abs(x - this.mInitialMotionX);
                    float abs2 = Math.abs(y - this.mInitialMotionY);
                    com.tencent.mm.plugin.multitask.animation.c.a.c cVar2 = this.AaG;
                    if (cVar2 != null) {
                        scaledTouchSlop = cVar2.rZ;
                    } else {
                        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                        p.g(viewConfiguration, "ViewConfiguration.get(context)");
                        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                    }
                    if (abs2 <= ((float) scaledTouchSlop) && abs <= ((float) scaledTouchSlop) && this.AcJ == 0 && this.Vm > 0.0f && i(this.rhx, (int) this.mInitialMotionX, (int) this.mInitialMotionY) && this.AcH != null && getPanelState() != c.DRAGGING) {
                        View.OnClickListener onClickListener = this.AcH;
                        if (onClickListener != null) {
                            onClickListener.onClick(this);
                        }
                        AppMethodBeat.o(200737);
                        return true;
                    }
                }
                com.tencent.mm.plugin.multitask.animation.c.a.c cVar3 = this.AaG;
                if (cVar3 != null) {
                    cVar3.k(motionEvent);
                }
                AppMethodBeat.o(200737);
                return true;
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.MultiTaskViewGroup", e3, "get a Exception", new Object[0]);
                AppMethodBeat.o(200737);
                return false;
            }
        } else {
            com.tencent.mm.plugin.multitask.animation.c.a.c cVar4 = this.AaG;
            if (cVar4 != null) {
                cVar4.abort();
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(200737);
            return onTouchEvent;
        }
    }

    private final void setPanelStateInternal(c cVar) {
        AppMethodBeat.i(200738);
        if (this.Adc == cVar) {
            AppMethodBeat.o(200738);
            return;
        }
        c cVar2 = this.Adc;
        this.Adc = cVar;
        if (cVar == c.EXPANDED) {
            this.AcJ = 0;
            Log.i("MicroMsg.MultiTaskViewGroup", "setPanelStateInternal, EXPANDED!");
        } else if (cVar == c.COLLAPSED) {
            this.AcJ = 1;
            Log.i("MicroMsg.MultiTaskViewGroup", "setPanelStateInternal, COLLAPSED!");
        }
        if (this.AcJ != this.AcK) {
            this.AcK = this.AcJ;
            int i2 = this.AcJ;
            synchronized (this.AcI) {
                try {
                    Iterator<AbstractC1522b> it = this.AcI.iterator();
                    while (it.hasNext()) {
                        it.next().RQ(i2);
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(200738);
                    throw th;
                }
            }
        }
        synchronized (this.AcI) {
            try {
                Iterator<AbstractC1522b> it2 = this.AcI.iterator();
                while (it2.hasNext()) {
                    it2.next().a(cVar2, cVar);
                }
                x xVar2 = x.SXb;
            } catch (Throwable th2) {
                AppMethodBeat.o(200738);
                throw th2;
            }
        }
        sendAccessibilityEvent(32);
        AppMethodBeat.o(200738);
    }

    public final void erm() {
        AppMethodBeat.i(200739);
        synchronized (this.AcI) {
            try {
                Iterator<AbstractC1522b> it = this.AcI.iterator();
                while (it.hasNext()) {
                    it.next().ers();
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(200739);
            }
        }
    }

    private final boolean ern() {
        AppMethodBeat.i(200740);
        synchronized (this.AcI) {
            try {
                Iterator<AbstractC1522b> it = this.AcI.iterator();
                while (it.hasNext()) {
                    if (!it.next().eru()) {
                        AppMethodBeat.o(200740);
                        return false;
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(200740);
                return true;
            } catch (Throwable th) {
                AppMethodBeat.o(200740);
                throw th;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private final void ero() {
        AppMethodBeat.i(200741);
        if (this.Adb > 0) {
            u.e(this.rhx, (float) getCurrentParallaxOffset());
        }
        AppMethodBeat.o(200741);
    }

    private final int bA(float f2) {
        AppMethodBeat.i(200742);
        View view = this.Vl;
        int measuredWidth = view != null ? view.getMeasuredWidth() : 0;
        int i2 = (int) (((float) this.Vo) * f2);
        if (this.AcO) {
            int measuredWidth2 = ((getMeasuredWidth() - getPaddingRight()) - (this.AcW + this.AcY)) - i2;
            AppMethodBeat.o(200742);
            return measuredWidth2;
        }
        int paddingLeft = (getPaddingLeft() - measuredWidth) + this.AcW + this.AcY + i2;
        AppMethodBeat.o(200742);
        return paddingLeft;
    }

    private final float RP(int i2) {
        AppMethodBeat.i(200743);
        int bA = bA(0.0f);
        if (this.AcO) {
            float f2 = ((float) (bA - i2)) / ((float) this.Vo);
            AppMethodBeat.o(200743);
            return f2;
        }
        float f3 = ((float) (i2 - bA)) / ((float) this.Vo);
        AppMethodBeat.o(200743);
        return f3;
    }

    public final void gf() {
        AppMethodBeat.i(200744);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            p.g(childAt, "child");
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
        AppMethodBeat.o(200744);
    }

    public final void erp() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        AppMethodBeat.i(200745);
        if (getChildCount() == 0) {
            AppMethodBeat.o(200745);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View view = this.Vl;
        if (view == null) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else if (ew(this.Vl)) {
            i5 = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        View childAt = getChildAt(0);
        p.g(childAt, "child");
        int max = Math.max(paddingLeft, childAt.getLeft());
        int max2 = Math.max(paddingTop, childAt.getTop());
        int min = Math.min(width, childAt.getRight());
        int min2 = Math.min(height, childAt.getBottom());
        if (max >= i5 && max2 >= i3 && min <= i4 && min2 <= i2) {
            i6 = 4;
        }
        childAt.setVisibility(i6);
        AppMethodBeat.o(200745);
    }

    private static boolean ew(View view) {
        AppMethodBeat.i(200746);
        Drawable background = view != null ? view.getBackground() : null;
        if (background == null || background.getOpacity() != -1) {
            AppMethodBeat.o(200746);
            return false;
        }
        AppMethodBeat.o(200746);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J2\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J2\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u001bH\u0016J8\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u001a\u0010\"\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u0005H\u0016¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;)V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "pointerId", "plugin-multitask_release"})
    public final class d extends c.a implements b.AbstractC2081b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final boolean c(View view, int i2) {
            AppMethodBeat.i(200708);
            Object[] objArr = new Object[1];
            objArr[0] = view != null ? view.toString() : null;
            Log.d("MicroMsg.MultiTaskViewGroup", "tryCaptureView, child: %s", objArr);
            b bVar = b.this;
            synchronized (bVar.AcI) {
                try {
                    Iterator<AbstractC1522b> it = bVar.AcI.iterator();
                    while (it.hasNext()) {
                        it.next().err();
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(200708);
                    throw th;
                }
            }
            if (b.this.Adc == c.COLLAPSED) {
                if (!b.this.mIsUnableToDrag) {
                    com.tencent.mm.plugin.multitask.animation.c.a.c mDragHelper = b.this.getMDragHelper();
                    if (mDragHelper != null ? mDragHelper.hl(8, i2) : false) {
                        AppMethodBeat.o(200708);
                        return true;
                    }
                }
                AppMethodBeat.o(200708);
                return false;
            } else if (b.this.Adc == c.EXPANDED) {
                if (!b.this.mIsUnableToDrag) {
                    com.tencent.mm.plugin.multitask.animation.c.a.c mDragHelper2 = b.this.getMDragHelper();
                    if (mDragHelper2 != null ? mDragHelper2.hl(4, i2) : false) {
                        AppMethodBeat.o(200708);
                        return true;
                    }
                }
                AppMethodBeat.o(200708);
                return false;
            } else if (b.this.Adc == c.DRAGGING) {
                AppMethodBeat.o(200708);
                return true;
            } else {
                b.this.AcG = false;
                AppMethodBeat.o(200708);
                return false;
            }
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final int awM() {
            AppMethodBeat.i(200709);
            int i2 = b.this.Vo;
            AppMethodBeat.o(200709);
            return i2;
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void l(View view, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(200710);
            Object[] objArr = new Object[5];
            objArr[0] = view != null ? view.toString() : null;
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = Integer.valueOf(i4);
            objArr[4] = Integer.valueOf(i5);
            Log.d("MicroMsg.MultiTaskViewGroup", "changedView: %s, left: %d, top: %d, dx: %d, dy: %d", objArr);
            b.a(b.this, i2);
            b.this.invalidate();
            AppMethodBeat.o(200710);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x010f  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0154 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0189  */
        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(android.view.View r11, float r12, float r13, float r14, float r15) {
            /*
            // Method dump skipped, instructions count: 437
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitask.ui.base.b.d.b(android.view.View, float, float, float, float):void");
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final int RI(int i2) {
            AppMethodBeat.i(200712);
            int b2 = b.b(b.this, 0.0f);
            int b3 = b.b(b.this, 1.0f);
            if (b.this.AcO) {
                int min = Math.min(Math.max(i2, b3), b2);
                AppMethodBeat.o(200712);
                return min;
            }
            int min2 = Math.min(Math.max(i2, b2), b3);
            AppMethodBeat.o(200712);
            return min2;
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void L(int i2) {
            AppMethodBeat.i(200713);
            Log.d("MicroMsg.MultiTaskViewGroup", "onViewDragStateChanged, state:".concat(String.valueOf(i2)));
            if (b.this.getMDragHelper() != null) {
                com.tencent.mm.plugin.multitask.animation.c.a.c mDragHelper = b.this.getMDragHelper();
                if (mDragHelper == null) {
                    AppMethodBeat.o(200713);
                    return;
                } else if (mDragHelper.Aas == 0) {
                    b bVar = b.this;
                    b bVar2 = b.this;
                    View view = b.this.Vl;
                    bVar.Vm = b.b(bVar2, view != null ? view.getLeft() : 0);
                    b.k(b.this);
                    if (b.this.Vm == 1.0f) {
                        b.this.erp();
                        b.a(b.this, c.EXPANDED);
                        AppMethodBeat.o(200713);
                        return;
                    } else if (b.this.Vm == 0.0f) {
                        b.a(b.this, c.COLLAPSED);
                        AppMethodBeat.o(200713);
                        return;
                    } else if (b.this.Vm < 0.0f) {
                        b.a(b.this, c.HIDDEN);
                        View view2 = b.this.Vl;
                        if (view2 != null) {
                            view2.setVisibility(4);
                            AppMethodBeat.o(200713);
                            return;
                        }
                        AppMethodBeat.o(200713);
                        return;
                    } else {
                        b.this.erp();
                        b.a(b.this, c.ANCHORED);
                    }
                }
            }
            AppMethodBeat.o(200713);
        }

        @Override // com.tencent.mm.ui.base.b.AbstractC2081b
        public final void ei(boolean z) {
            AppMethodBeat.i(200714);
            Log.d("MicroMsg.MultiTaskViewGroup", "onComplete");
            AppMethodBeat.o(200714);
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void eqJ() {
            AppMethodBeat.i(200715);
            Log.i("MicroMsg.MultiTaskViewGroup", "onViewCaptured");
            b.this.gf();
            AppMethodBeat.o(200715);
        }

        @Override // com.tencent.mm.plugin.multitask.animation.c.a.c.a
        public final void a(float f2, float f3, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(200716);
            Log.d("MicroMsg.MultiTaskViewGroup", "touchX: %f, touchY: %f, dx: %d, dy: %d, adx: %d, ady: %d", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            if (b.this.AcJ == 1) {
                if (b.this.Vm <= 0.1f) {
                    b.this.AcG = false;
                }
                if (!b.this.AcG) {
                    if (((float) i4) > ((float) b.this.getWidth()) * 0.5f) {
                        Vibrator vibrator = b.this.ooM;
                        if (vibrator != null) {
                            vibrator.vibrate(10);
                        }
                        b.this.AcG = true;
                        b bVar = b.this;
                        synchronized (bVar.AcI) {
                            try {
                                Iterator<AbstractC1522b> it = bVar.AcI.iterator();
                                while (it.hasNext()) {
                                    it.next().ert();
                                }
                                x xVar = x.SXb;
                            } catch (Throwable th) {
                                AppMethodBeat.o(200716);
                                throw th;
                            }
                        }
                    }
                }
            }
            b bVar2 = b.this;
            float f4 = b.this.Vm;
            synchronized (bVar2.AcI) {
                try {
                    Iterator<AbstractC1522b> it2 = bVar2.AcI.iterator();
                    while (it2.hasNext()) {
                        it2.next().bC(f4);
                    }
                    x xVar2 = x.SXb;
                } finally {
                    AppMethodBeat.o(200716);
                }
            }
        }
    }

    public static final /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(200749);
        if (bVar.Adc != c.DRAGGING) {
            bVar.Add = bVar.Adc;
        }
        bVar.setPanelStateInternal(c.DRAGGING);
        bVar.Vm = bVar.RP(i2);
        bVar.ero();
        synchronized (bVar.AcI) {
            try {
                Iterator<AbstractC1522b> it = bVar.AcI.iterator();
                while (it.hasNext()) {
                    it.next().bB(bVar.Vm);
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(200749);
                throw th;
            }
        }
        Log.d("MicroMsg.MultiTaskViewGroup", "onPanelDragged, newLeft: %d, slideOffset: %f", Integer.valueOf(i2), Float.valueOf(bVar.Vm));
        AppMethodBeat.o(200749);
    }
}
