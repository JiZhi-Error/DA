package com.tencent.mm.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.DragExitCropLayout;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002abB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u00109\u001a\u00020:2\u0006\u00103\u001a\u00020\u000eJ\u000e\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u000eJ\u0010\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0016H\u0016J\u0010\u0010?\u001a\u0002082\u0006\u0010@\u001a\u000208H\u0002J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u0016H\u0016J(\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u0002082\u0006\u0010J\u001a\u000208H\u0016J\u0012\u0010K\u001a\u00020:2\b\u0010E\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010L\u001a\u00020\u00192\u0006\u0010M\u001a\u00020%H\u0016J\u0010\u0010N\u001a\u00020\u00192\u0006\u0010M\u001a\u00020%H\u0016J\u0010\u0010O\u001a\u00020:2\u0006\u0010M\u001a\u00020%H\u0016J(\u0010P\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u00162\u0006\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u000208H\u0016J\u0012\u0010S\u001a\u00020:2\b\u0010E\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010T\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u0016H\u0016J\u0012\u0010U\u001a\u00020\u00192\b\u0010E\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010V\u001a\u00020:2\u0006\u0010M\u001a\u00020%H\u0002J\u0010\u0010W\u001a\u00020\u00192\u0006\u0010M\u001a\u00020%H\u0002J\u0018\u0010X\u001a\u00020:2\u0006\u0010>\u001a\u00020\u00162\u0006\u0010M\u001a\u00020%H\u0002J+\u0010Y\u001a\u00020:2!\u0010Z\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020:0[H\u0002J\u0006\u0010^\u001a\u00020:J\u0014\u0010^\u001a\u00020:2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020:0`R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u0010,\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b0\u0010\u0012\u001a\u0004\b.\u0010/R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u00106R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, hxF = {"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundView", "Landroid/view/View;", "getBackgroundView", "()Landroid/view/View;", "backgroundView$delegate", "Lkotlin/Lazy;", "cropLayout", "Lcom/tencent/mm/ui/widget/cropview/DragExitCropLayout;", "downMotionEvent", "Landroid/view/MotionEvent;", "indexOriginalParent", "isCanScale", "", "isInitFinish", "isPreViewMode", "()Z", "setPreViewMode", "(Z)V", "isRemoving", "isReverting", "lastMotionEvent", "linePaint", "Landroid/graphics/Paint;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scaleListener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "getScaleListener", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "setScaleListener", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;)V", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "touchOriginalParent", "Landroid/view/ViewGroup;", "touchView", "getTouchView", "setTouchView", "(Landroid/view/View;)V", "videoBaseLine", "", "addTouchView", "", "attachToDecorView", "view", "dispatchTouchEvent", "ev", "dpToPx", "dp", "draw", "canvas", "Landroid/graphics/Canvas;", "onDown", "e", "onFling", "e1", "e2", "velocityX", "velocityY", e.a.NAME, "onScale", "detector", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onTouchEvent", "onTouchScale", "onTouchScaleBegin", "onTouchScaleEnd", "removeTouchView", "finishRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "revertViewTo", "finishCall", "Lkotlin/Function0;", "Companion", "OnScaleListener", "libmmui_release"})
public class TouchMediaPreviewLayout extends FrameLayout implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener {
    private static boolean QFC;
    private static boolean QFD = true;
    public static final a QFE = new a((byte) 0);
    private final Paint GQi;
    private boolean QFA;
    private final float QFB;
    private final kotlin.f QFq = kotlin.g.ah(new c(this));
    private MotionEvent QFr;
    public boolean QFs;
    private boolean QFt;
    private ScaleGestureDetector QFu = new ScaleGestureDetector(getContext(), this);
    private b QFv;
    private boolean QFw;
    private final DragExitCropLayout QFx;
    private ViewGroup QFy;
    private boolean QFz;
    private MotionEvent aXM;
    private final kotlin.f wbH = kotlin.g.ah(new g(this));
    private int wxy;
    private View yTH;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, hxF = {"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "libmmui_release"})
    public interface b extends ScaleGestureDetector.OnScaleGestureListener {
    }

    private final View getBackgroundView() {
        AppMethodBeat.i(164343);
        View view = (View) this.QFq.getValue();
        AppMethodBeat.o(164343);
        return view;
    }

    private final GestureDetector getTouchDetector() {
        AppMethodBeat.i(164344);
        GestureDetector gestureDetector = (GestureDetector) this.wbH.getValue();
        AppMethodBeat.o(164344);
        return gestureDetector;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<View, x> {
        final /* synthetic */ TouchMediaPreviewLayout QFF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TouchMediaPreviewLayout touchMediaPreviewLayout) {
            super(1);
            this.QFF = touchMediaPreviewLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(View view) {
            AppMethodBeat.i(164340);
            p.h(view, LocaleUtil.ITALIAN);
            this.QFF.QFw = false;
            b scaleListener = this.QFF.getScaleListener();
            if (scaleListener != null) {
                scaleListener.onScaleEnd(this.QFF.QFu);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(164340);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$Companion;", "", "()V", "ANIMATION_DURATION", "", "INIT_BG_ALPHA", "", "TAG", "", "isRevertImmediately", "", "()Z", "setRevertImmediately", "(Z)V", "isShowVideoBaseLine", "setShowVideoBaseLine", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ View j(TouchMediaPreviewLayout touchMediaPreviewLayout) {
        AppMethodBeat.i(164363);
        View backgroundView = touchMediaPreviewLayout.getBackgroundView();
        AppMethodBeat.o(164363);
        return backgroundView;
    }

    static {
        AppMethodBeat.i(164342);
        AppMethodBeat.o(164342);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchMediaPreviewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164361);
        Context context2 = getContext();
        p.g(context2, "context");
        DragExitCropLayout dragExitCropLayout = new DragExitCropLayout(context2);
        dragExitCropLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        dragExitCropLayout.setTag("TouchPhotoLayout");
        dragExitCropLayout.setEnableTouch(false);
        dragExitCropLayout.setHasBorder(false);
        dragExitCropLayout.setEnableOverScroll(false);
        dragExitCropLayout.setEnableDragExit(true);
        Context context3 = dragExitCropLayout.getContext();
        p.g(context3, "context");
        dragExitCropLayout.setBackgroundColor(context3.getResources().getColor(17170445));
        this.QFx = dragExitCropLayout;
        Context context4 = getContext();
        p.g(context4, "context");
        Resources resources = context4.getResources();
        p.g(resources, "context.resources");
        this.QFB = ((float) resources.getDisplayMetrics().heightPixels) * 0.4f;
        Paint paint = new Paint(1);
        paint.setStrokeWidth(gZl());
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16711936);
        this.GQi = paint;
        if (QFC) {
            setBackgroundColor(0);
        }
        AppMethodBeat.o(164361);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchMediaPreviewLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164362);
        Context context2 = getContext();
        p.g(context2, "context");
        DragExitCropLayout dragExitCropLayout = new DragExitCropLayout(context2);
        dragExitCropLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        dragExitCropLayout.setTag("TouchPhotoLayout");
        dragExitCropLayout.setEnableTouch(false);
        dragExitCropLayout.setHasBorder(false);
        dragExitCropLayout.setEnableOverScroll(false);
        dragExitCropLayout.setEnableDragExit(true);
        Context context3 = dragExitCropLayout.getContext();
        p.g(context3, "context");
        dragExitCropLayout.setBackgroundColor(context3.getResources().getColor(17170445));
        this.QFx = dragExitCropLayout;
        Context context4 = getContext();
        p.g(context4, "context");
        Resources resources = context4.getResources();
        p.g(resources, "context.resources");
        this.QFB = ((float) resources.getDisplayMetrics().heightPixels) * 0.4f;
        Paint paint = new Paint(1);
        paint.setStrokeWidth(gZl());
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16711936);
        this.GQi = paint;
        if (QFC) {
            setBackgroundColor(0);
        }
        AppMethodBeat.o(164362);
    }

    public final void setPreViewMode(boolean z) {
        this.QFs = z;
    }

    public final b getScaleListener() {
        return this.QFv;
    }

    public final void setScaleListener(b bVar) {
        this.QFv = bVar;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164345);
        p.h(motionEvent, "ev");
        if (motionEvent.getAction() == 0) {
            TouchableLayout.a aVar = TouchableLayout.Rni;
            TouchableLayout.kuv = (int) motionEvent.getRawX();
            TouchableLayout.a aVar2 = TouchableLayout.Rni;
            TouchableLayout.kuw = (int) motionEvent.getRawY();
        }
        this.QFu.onTouchEvent(motionEvent);
        GestureDetector touchDetector = getTouchDetector();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(touchDetector, bl.axQ(), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(touchDetector, touchDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        this.aXM = motionEvent;
        if (motionEvent.getAction() == 0) {
            Log.i("TouchPhotoLayout", "[dispatchTouchEvent] down... visibility=" + getVisibility() + " isCanScale=" + this.QFt + " isInitFinish=" + this.QFz);
            this.QFr = MotionEvent.obtain(motionEvent);
        }
        if (!this.QFt && (motionEvent.getAction() & 255) == 5 && motionEvent.getPointerCount() == 2) {
            b bVar = this.QFv;
            boolean z = bVar != null && bVar.onScaleBegin(this.QFu);
            if (z) {
                getBackgroundView().setTag(Boolean.TRUE);
                getBackgroundView().setAlpha(0.0f);
                getBackgroundView().setVisibility(0);
            }
            this.QFt = z;
            if (this.QFt) {
                MotionEvent obtain = MotionEvent.obtain(this.aXM);
                p.g(obtain, "cancelEvent");
                obtain.setAction(3);
                super.dispatchTouchEvent(obtain);
            }
        }
        if (!this.QFt) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(164345);
            return dispatchTouchEvent;
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.QFs = !QFD && this.QFx.getContentViewScale()[0] >= 1.5f;
            Log.i("TouchPhotoLayout", "[onTouchScaleEnd] isPreViewMode=" + this.QFs + " isCanScale=" + this.QFt + " isInitFinish=" + this.QFz);
            float x = motionEvent.getX();
            MotionEvent motionEvent2 = this.QFr;
            if (motionEvent2 == null) {
                p.hyc();
            }
            if (Math.abs(x - motionEvent2.getX()) < 5.0f || !this.QFs) {
                gZk();
            } else {
                this.QFx.ad(motionEvent);
            }
        }
        AppMethodBeat.o(164345);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164346);
        if (this.QFt) {
            AppMethodBeat.o(164346);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(164346);
        return onTouchEvent;
    }

    public final void gZk() {
        AppMethodBeat.i(164347);
        if (!this.QFw) {
            this.QFw = true;
            this.QFs = false;
            Q(new f(this));
        }
        AppMethodBeat.o(164347);
    }

    public final View getTouchView() {
        return this.yTH;
    }

    public final void setTouchView(View view) {
        this.yTH = view;
    }

    private final void Q(kotlin.g.a.b<? super View, x> bVar) {
        AppMethodBeat.i(164349);
        if (!this.QFA) {
            float alpha = getBackgroundView().getAlpha();
            this.QFA = true;
            this.QFx.a(new d(this, bVar), new e(this, alpha));
        }
        AppMethodBeat.o(164349);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TouchMediaPreviewLayout QFF;
        final /* synthetic */ float QFH;

        e(TouchMediaPreviewLayout touchMediaPreviewLayout, float f2) {
            this.QFF = touchMediaPreviewLayout;
            this.QFH = f2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(164339);
            Object animatedValue = valueAnimator.getAnimatedValue("percent");
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(164339);
                throw tVar;
            }
            TouchMediaPreviewLayout.j(this.QFF).setAlpha(Math.min(this.QFH, 1.0f - ((Float) animatedValue).floatValue()));
            AppMethodBeat.o(164339);
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(164350);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        p.h(motionEvent, "e");
        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164350);
        return true;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(164351);
        p.h(motionEvent, "e");
        if (this.QFz) {
            this.QFx.onDown(motionEvent);
        }
        AppMethodBeat.o(164351);
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(164352);
        p.h(motionEvent, "e1");
        p.h(motionEvent2, "e2");
        if (this.QFz && this.QFs) {
            this.QFx.onFling(motionEvent, motionEvent2, f2, f3);
        }
        AppMethodBeat.o(164352);
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(164353);
        p.h(motionEvent, "e1");
        p.h(motionEvent2, "e2");
        if (this.QFt && this.QFz) {
            this.QFx.onScroll(motionEvent, motionEvent2, f2, f3);
        }
        AppMethodBeat.o(164353);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(204893);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/TouchMediaPreviewLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(204893);
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164355);
        p.h(scaleGestureDetector, "detector");
        boolean z = this.QFt;
        AppMethodBeat.o(164355);
        return z;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164356);
        p.h(scaleGestureDetector, "detector");
        AppMethodBeat.o(164356);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(164358);
        p.h(canvas, "canvas");
        super.draw(canvas);
        if (QFC) {
            float f2 = this.QFB;
            Context context = getContext();
            p.g(context, "context");
            Resources resources = context.getResources();
            p.g(resources, "context.resources");
            canvas.drawLine(0.0f, f2, (float) resources.getDisplayMetrics().widthPixels, this.QFB, this.GQi);
        }
        AppMethodBeat.o(164358);
    }

    private final float gZl() {
        AppMethodBeat.i(164359);
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        float applyDimension = TypedValue.applyDimension(1, 2.0f, resources.getDisplayMetrics());
        AppMethodBeat.o(164359);
        return applyDimension;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/View;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ TouchMediaPreviewLayout QFF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TouchMediaPreviewLayout touchMediaPreviewLayout) {
            super(0);
            this.QFF = touchMediaPreviewLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(164337);
            View view = new View(this.QFF.getContext());
            view.setVisibility(8);
            view.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            this.QFF.addView(view, 1, new FrameLayout.LayoutParams(-1, -1));
            AppMethodBeat.o(164337);
            return view;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<GestureDetector> {
        final /* synthetic */ TouchMediaPreviewLayout QFF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(TouchMediaPreviewLayout touchMediaPreviewLayout) {
            super(0);
            this.QFF = touchMediaPreviewLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ GestureDetector invoke() {
            AppMethodBeat.i(164341);
            GestureDetector gestureDetector = new GestureDetector(this.QFF.getContext(), this.QFF);
            AppMethodBeat.o(164341);
            return gestureDetector;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ TouchMediaPreviewLayout QFF;
        final /* synthetic */ kotlin.g.a.b QFG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TouchMediaPreviewLayout touchMediaPreviewLayout, kotlin.g.a.b bVar) {
            super(0);
            this.QFF = touchMediaPreviewLayout;
            this.QFG = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(164338);
            this.QFF.QFx.De(true);
            ViewGroup viewGroup = this.QFF.QFy;
            if (viewGroup != null) {
                viewGroup.addView(this.QFF.getTouchView(), this.QFF.wxy);
                this.QFF.wxy = 0;
            }
            this.QFF.removeView(this.QFF.QFx);
            View touchView = this.QFF.getTouchView();
            if (touchView != null) {
                touchView.setScaleX(1.0f);
                touchView.setScaleY(1.0f);
                touchView.setTranslationX(0.0f);
                touchView.setTranslationY(0.0f);
                this.QFG.invoke(touchView);
            }
            this.QFF.QFA = false;
            this.QFF.QFt = false;
            this.QFF.QFz = false;
            TouchMediaPreviewLayout.j(this.QFF).setAlpha(0.0f);
            x xVar = x.SXb;
            AppMethodBeat.o(164338);
            return xVar;
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164357);
        p.h(scaleGestureDetector, "detector");
        if (this.QFz && this.QFt) {
            this.QFx.onScale(scaleGestureDetector);
            b bVar = this.QFv;
            if (bVar != null) {
                bVar.onScale(scaleGestureDetector);
            }
            if (p.j(getBackgroundView().getTag(), Boolean.TRUE)) {
                getBackgroundView().animate().cancel();
            }
            getBackgroundView().setAlpha((this.QFx.getContentViewScale()[0] - 1.0f) / 0.5f);
        }
        AppMethodBeat.o(164357);
        return true;
    }
}
