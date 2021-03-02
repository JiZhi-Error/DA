package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.ui.widget.cropview.TouchEventLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 O2\u00020\u0001:\u0007OPQRSTUB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\tH\u0016J\u0010\u00102\u001a\u0002002\u0006\u00101\u001a\u00020\tH\u0016J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u0002002\b\u00107\u001a\u0004\u0018\u000105H\u0016J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u000205H\u0016J\u0012\u0010:\u001a\u00020;2\b\u00107\u001a\u0004\u0018\u000105H\u0016J\u0010\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010@\u001a\u00020;2\u0006\u0010=\u001a\u00020>H\u0016J(\u0010A\u001a\u0002002\u0006\u0010B\u001a\u0002052\u0006\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EH\u0016J\u0010\u0010G\u001a\u0002002\u0006\u00107\u001a\u000205H\u0016J\u0018\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020J2\u0006\u00104\u001a\u000205H\u0016J\u0012\u0010K\u001a\u00020;2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0012\u0010\u001b\u001a\u00020;2\b\u0010L\u001a\u0004\u0018\u00010NH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006V"}, hxF = {"Lcom/tencent/mm/view/HardTouchableLayout;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDoubleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "getOnDoubleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "setOnDoubleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;)V", "onInterceptTouchEventCallback", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "getOnInterceptTouchEventCallback", "()Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "setOnInterceptTouchEventCallback", "(Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;)V", "onLongClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "getOnLongClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "setOnLongClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;)V", "onScaleListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "getOnScaleListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "setOnScaleListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;)V", "onScrollListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "getOnScrollListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "setOnScrollListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;)V", "onSingleClickListener", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "getOnSingleClickListener", "()Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "setOnSingleClickListener", "(Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;)V", "canScrollHorizontally", "", TencentLocation.EXTRA_DIRECTION, "canScrollVertically", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onDoubleTap", "e", "onInterceptTouchEvent", "ev", e.a.NAME, "", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onSingleTapUp", "onTouch", "v", "Landroid/view/View;", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "Companion", "OnDoubleClickListener", "OnInterceptTouchEventCallback", "OnLongClickListener", "OnScaleListener", "OnScrollListener", "OnSingleClickListener", "libmmui_release"})
public class HardTouchableLayout extends TouchEventLayout {
    public static final a Rjl = new a((byte) 0);
    private static int kuv;
    private static int kuw;
    private d Rjf;
    private g Rjg;
    private b Rjh;
    private f Rji;
    private e Rjj;
    private c Rjk;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"})
    public interface b {
        void a(View view, MotionEvent motionEvent);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
    public interface c {
        boolean S(MotionEvent motionEvent);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "", "onLongClick", "", "view", "Landroid/view/View;", "libmmui_release"})
    public interface d {
        void ea(View view);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/view/HardTouchableLayout$OnScaleListener;", "", "onScaleBegin", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleEnd", "onScaling", "libmmui_release"})
    public interface e {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/view/HardTouchableLayout$OnScrollListener;", "", "onDown", "", "event", "Landroid/view/MotionEvent;", "onScroll", "distanceX", "", "distanceY", "isEnableOverScroll", "", "onUp", "libmmui_release"})
    public interface f {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"})
    public interface g {
        void b(View view, MotionEvent motionEvent);
    }

    static {
        AppMethodBeat.i(164513);
        AppMethodBeat.o(164513);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/view/HardTouchableLayout$Companion;", "", "()V", "TAG", "", "downX", "", "getDownX", "()I", "setDownX", "(I)V", "downY", "getDownY", "setDownY", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HardTouchableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164511);
        setEnableFling(false);
        setEnableOverScroll(false);
        setEnableScale(false);
        AppMethodBeat.o(164511);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HardTouchableLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164512);
        setEnableFling(false);
        setEnableOverScroll(false);
        setEnableScale(false);
        AppMethodBeat.o(164512);
    }

    public final d getOnLongClickListener() {
        return this.Rjf;
    }

    public final void setOnLongClickListener(d dVar) {
        this.Rjf = dVar;
    }

    public final g getOnSingleClickListener() {
        return this.Rjg;
    }

    public final void setOnSingleClickListener(g gVar) {
        this.Rjg = gVar;
    }

    public final b getOnDoubleClickListener() {
        return this.Rjh;
    }

    public final void setOnDoubleClickListener(b bVar) {
        this.Rjh = bVar;
    }

    public final f getOnScrollListener() {
        return this.Rji;
    }

    public final void setOnScrollListener(f fVar) {
        this.Rji = fVar;
    }

    public final e getOnScaleListener() {
        return this.Rjj;
    }

    public final void setOnScaleListener(e eVar) {
        this.Rjj = eVar;
    }

    public final c getOnInterceptTouchEventCallback() {
        return this.Rjk;
    }

    public final void setOnInterceptTouchEventCallback(c cVar) {
        this.Rjk = cVar;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(164499);
        p.h(view, "v");
        p.h(motionEvent, "event");
        AppMethodBeat.o(164499);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164500);
        p.h(motionEvent, "ev");
        c cVar = this.Rjk;
        if (cVar != null) {
            boolean S = cVar.S(motionEvent);
            AppMethodBeat.o(164500);
            return S;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(164500);
        return onInterceptTouchEvent;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164501);
        p.h(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            kuv = (int) motionEvent.getRawX();
            kuw = (int) motionEvent.getRawY();
        }
        super.onTouch(this, motionEvent);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            ad(motionEvent);
            if (this.Rji == null) {
            }
        } else {
            motionEvent.getAction();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(164501);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(164502);
        p.h(motionEvent, "e1");
        p.h(motionEvent2, "e2");
        boolean onScroll = super.onScroll(motionEvent, motionEvent2, f2, f3);
        AppMethodBeat.o(164502);
        return onScroll;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164503);
        p.h(scaleGestureDetector, "detector");
        boolean onScaleBegin = super.onScaleBegin(scaleGestureDetector);
        AppMethodBeat.o(164503);
        return onScaleBegin;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164504);
        p.h(scaleGestureDetector, "detector");
        boolean onScale = super.onScale(scaleGestureDetector);
        AppMethodBeat.o(164504);
        return onScale;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        AppMethodBeat.i(164505);
        p.h(scaleGestureDetector, "detector");
        super.onScaleEnd(scaleGestureDetector);
        AppMethodBeat.o(164505);
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(164506);
        super.onLongPress(motionEvent);
        d dVar = this.Rjf;
        if (dVar != null) {
            dVar.ea(this);
            AppMethodBeat.o(164506);
            return;
        }
        AppMethodBeat.o(164506);
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onDoubleTap(MotionEvent motionEvent) {
        b bVar;
        AppMethodBeat.i(164507);
        if (!(motionEvent == null || (bVar = this.Rjh) == null)) {
            bVar.a(this, motionEvent);
        }
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        AppMethodBeat.o(164507);
        return onDoubleTap;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(204950);
        p.h(motionEvent, "e");
        g gVar = this.Rjg;
        if (gVar != null) {
            gVar.b(this, motionEvent);
        }
        boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
        AppMethodBeat.o(204950);
        return onSingleTapUp;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/view/HardTouchableLayout$setOnLongClickListener$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "libmmui_release"})
    public static final class i implements d {
        final /* synthetic */ View.OnLongClickListener Rjn;

        i(View.OnLongClickListener onLongClickListener) {
            this.Rjn = onLongClickListener;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.d
        public final void ea(View view) {
            AppMethodBeat.i(164498);
            p.h(view, "view");
            View.OnLongClickListener onLongClickListener = this.Rjn;
            if (onLongClickListener != null) {
                onLongClickListener.onLongClick(view);
                AppMethodBeat.o(164498);
                return;
            }
            AppMethodBeat.o(164498);
        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(164509);
        this.Rjf = new i(onLongClickListener);
        AppMethodBeat.o(164509);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/view/HardTouchableLayout$setOnClickListener$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "libmmui_release"})
    public static final class h implements g {
        final /* synthetic */ View.OnClickListener Rjm;

        h(View.OnClickListener onClickListener) {
            this.Rjm = onClickListener;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(204949);
            p.h(view, "view");
            View.OnClickListener onClickListener = this.Rjm;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                AppMethodBeat.o(204949);
                return;
            }
            AppMethodBeat.o(204949);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(164510);
        this.Rjg = new h(onClickListener);
        AppMethodBeat.o(164510);
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean canScrollVertically(int i2) {
        return this.AwT;
    }

    @Override // com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public boolean canScrollHorizontally(int i2) {
        return this.AwT;
    }
}
