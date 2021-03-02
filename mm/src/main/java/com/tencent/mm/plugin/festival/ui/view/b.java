package com.tencent.mm.plugin.festival.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.ui.view.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\"*\u0001\u001f\u0018\u0000 |*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0003|}~B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010GJ\u0018\u0010H\u001a\u00020E2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010IH\u0016J\u0018\u0010J\u001a\u00020E2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010IH\u0016J\b\u0010K\u001a\u00020\bH\u0014J\b\u0010L\u001a\u00020EH\u0016J\u0010\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\rH\u0002J\b\u0010O\u001a\u00020EH\u0016J\u0010\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020UH\u0016J\u0018\u0010V\u001a\u00020\b2\u0006\u0010T\u001a\u00020U2\u0006\u0010N\u001a\u00020\rH\u0002J$\u0010W\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]H\u0014J\u0018\u0010^\u001a\u00020E2\u0006\u0010X\u001a\u00020Y2\u0006\u0010N\u001a\u00020\rH\u0002J\u0010\u0010_\u001a\u00020E2\u0006\u0010X\u001a\u00020YH\u0002J\u0018\u0010`\u001a\u00020E2\u0006\u0010N\u001a\u00020\r2\u0006\u0010a\u001a\u00020@H\u0016J\u000e\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00000IH\u0016J\b\u0010c\u001a\u00020EH\u0002J\b\u0010d\u001a\u00020EH\u0016J\b\u0010e\u001a\u00020EH\u0002J\u0010\u0010f\u001a\u00020E2\u0006\u0010X\u001a\u00020YH\u0014J\u0010\u0010g\u001a\u00020\b2\u0006\u0010T\u001a\u00020UH\u0016J0\u0010h\u001a\u00020E2\u0006\u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\u00192\u0006\u0010k\u001a\u00020\u00192\u0006\u0010l\u001a\u00020\u00192\u0006\u0010m\u001a\u00020\u0019H\u0014J\u0018\u0010n\u001a\u00020E2\u0006\u0010o\u001a\u00020\u00192\u0006\u0010p\u001a\u00020\u0019H\u0014J\u0010\u0010q\u001a\u00020\b2\u0006\u0010T\u001a\u00020UH\u0017J\b\u0010r\u001a\u00020EH\u0016J\u001f\u0010s\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00018\u00002\u0006\u0010t\u001a\u00020\bH\u0016¢\u0006\u0002\u0010uJ\u0018\u0010v\u001a\u00020E2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010IH\u0016J\b\u0010w\u001a\u00020EH\u0016J\b\u0010x\u001a\u00020EH\u0016J\u0010\u0010y\u001a\u00020\b2\u0006\u0010z\u001a\u00020>H\u0002J\b\u0010{\u001a\u00020EH\u0016R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nRD\u0010\u000e\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0016\u0010\u000b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\r\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fX\u0004¢\u0006\n\n\u0002\u0010\"\u0012\u0004\b \u0010!R$\u0010#\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001a\u0010&\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\nR\u001a\u0010*\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010(R\"\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR$\u00106\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u0019@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\"\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0018\u00010;R\b\u0012\u0004\u0012\u00028\u00000\u00000:X\u000e¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0:X\u000e¢\u0006\u0004\n\u0002\u0010C¨\u0006"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView;", "DATA", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DRAW_VIEW_BOUNDS", "", "getDRAW_VIEW_BOUNDS", "()Z", "value", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter;", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter$ViewHolder;", "adapter", "getAdapter", "()Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter;", "setAdapter", "(Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter;)V", "dataList", "Ljava/util/LinkedList;", "debugPaint", "Landroid/graphics/Paint;", "displayList", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "getDuration", "()I", "setDuration", "(I)V", "handler", "com/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$handler$1", "handler$annotations", "()V", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$handler$1;", "intervalBetweenItem", "getIntervalBetweenItem", "setIntervalBetweenItem", "isCyclePlay", "setCyclePlay", "(Z)V", "isStarted", "isTouchEnabled", "setTouchEnabled", "onDanmakuAppearListener", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$OnDanmakuAppearListener;", "getOnDanmakuAppearListener", "()Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$OnDanmakuAppearListener;", "setOnDanmakuAppearListener", "(Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$OnDanmakuAppearListener;)V", "paddingVertical", "getPaddingVertical", "setPaddingVertical", "_value", "rowCount", "getRowCount", "setRowCount", "scrollerArray", "", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$DanmakuScroller;", "[Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$DanmakuScroller;", "state", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$STATE;", "touchRectF", "Landroid/graphics/RectF;", "touchTarget", "viewHolderArray", "[Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuViewContract$Adapter$ViewHolder;", "addFirst", "", "data", "(Ljava/lang/Object;)V", "addFirstAll", "", "addLastAll", "canAnimate", "clear", "computeDanmakuScrollDuration", "vh", "computeScroll", "dispatchClickEvent", "pointF", "Landroid/graphics/PointF;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchTransformedTouchEventToVH", "drawChild", "canvas", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "drawingTime", "", "drawOnScreenItem", "drawViewBounds", "getDanmakuLocation", "rectF", "getDataList", "measureChildAndConfigScroller", "mount", "notifyDataSetChanged", "onDraw", "onInterceptTouchEvent", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "pause", "remove", "immediate", "(Ljava/lang/Object;Z)V", "removeAll", "resume", "start", "toState", "newState", "unMount", "Companion", "DanmakuScroller", "STATE", "plugin-festival_release"})
public final class b<DATA> extends ViewGroup implements c<DATA> {
    @Deprecated
    public static final a UFt = new a((byte) 0);
    private volatile c UFj = c.INITIALIZED;
    private c.AbstractC1084c<DATA> UFk;
    private int UFl = 4000;
    private c.a<? extends c.a.C1083a, DATA> UFm;
    private final LinkedList<DATA> UFn = new LinkedList<>();
    private c.a.C1083a[] UFo = new c.a.C1083a[0];
    private b<DATA>.C1082b[] UFp = new C1082b[0];
    private final RectF UFq = new RectF();
    private c.a.C1083a UFr;
    private final d UFs = new d(this, Looper.getMainLooper());
    private boolean Urv = true;
    private int duration = 10000;
    private Paint iY;
    private int paddingVertical;
    public boolean pbB = true;
    private final LinkedList<DATA> ppH = new LinkedList<>();
    private int rowCount;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$STATE;", "", "(Ljava/lang/String;I)V", "INITIALIZED", "MOUNTED", "STARTED", "RESUMED", "PAUSED", "UNMOUNTED", "plugin-festival_release"})
    public enum c {
        INITIALIZED,
        MOUNTED,
        STARTED,
        RESUMED,
        PAUSED,
        UNMOUNTED;

        static {
            AppMethodBeat.i(263398);
            AppMethodBeat.o(263398);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(263400);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(263400);
            return cVar;
        }
    }

    static {
        AppMethodBeat.i(263430);
        AppMethodBeat.o(263430);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$Companion;", "", "()V", "TAG", "", "plugin-festival_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(263429);
        setWillNotDraw(false);
        AppMethodBeat.o(263429);
    }

    public static final /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(263431);
        bVar.notifyDataSetChanged();
        AppMethodBeat.o(263431);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0006\u0010'\u001a\u00020\u0019J\u000e\u0010\u0018\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0019J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J&\u0010,\u001a\u00020(2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR\u0014\u0010$\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$DanmakuScroller;", "", "context", "Landroid/content/Context;", "interpolator", "Landroid/view/animation/Interpolator;", "data", "(Lcom/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView;Landroid/content/Context;Landroid/view/animation/Interpolator;Ljava/lang/Object;)V", "currX", "", "getCurrX", "()I", "currY", "getCurrY", "setCurrY", "(I)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "delay", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "dx", "finalX", "getFinalX", "forceFinished", "", "isFinished", "()Z", "pausedTimestamp", "", "scroller", "Landroid/widget/Scroller;", "startTime", "<set-?>", "startX", "getStartX", "timePassed", "getTimePassed", "()J", "computeScrollOffset", "", "finished", "pause", "resume", "startScroll", "plugin-festival_release"})
    /* renamed from: com.tencent.mm.plugin.festival.ui.view.b$b  reason: collision with other inner class name */
    public final class C1082b {
        Scroller Ays;
        final Interpolator Jen;
        int UFu;
        long UFv;
        private boolean UFw;
        int UFx = -1;
        final /* synthetic */ b UFy;
        final Context context;
        final DATA data;
        int delay;
        int duration;
        long startTime;
        int startX;

        public C1082b(b bVar, Context context2, Interpolator interpolator, DATA data2) {
            p.h(context2, "context");
            p.h(interpolator, "interpolator");
            this.UFy = bVar;
            AppMethodBeat.i(263397);
            this.context = context2;
            this.Jen = interpolator;
            this.data = data2;
            AppMethodBeat.o(263397);
        }

        public final void hSr() {
            AppMethodBeat.i(263394);
            this.UFw = true;
            if (this.Ays != null) {
                Scroller scroller = this.Ays;
                if (scroller == null) {
                    p.btv("scroller");
                }
                scroller.forceFinished(true);
            }
            AppMethodBeat.o(263394);
        }

        public final int getCurrX() {
            AppMethodBeat.i(263395);
            if (this.Ays != null) {
                Scroller scroller = this.Ays;
                if (scroller == null) {
                    p.btv("scroller");
                }
                int currX = scroller.getCurrX();
                AppMethodBeat.o(263395);
                return currX;
            }
            int i2 = this.startX;
            AppMethodBeat.o(263395);
            return i2;
        }

        public final boolean isFinished() {
            AppMethodBeat.i(263396);
            if (this.Ays != null) {
                Scroller scroller = this.Ays;
                if (scroller == null) {
                    p.btv("scroller");
                }
                boolean isFinished = scroller.isFinished();
                AppMethodBeat.o(263396);
                return isFinished;
            }
            boolean z = this.UFw;
            AppMethodBeat.o(263396);
            return z;
        }
    }

    private final boolean a(c cVar) {
        boolean z = false;
        AppMethodBeat.i(263403);
        if (cVar == c.RESUMED) {
            if (this.UFj == c.STARTED || this.UFj == c.PAUSED) {
                z = true;
            }
        } else if (cVar.ordinal() > this.UFj.ordinal()) {
            z = true;
        }
        c cVar2 = this.UFj;
        if (z) {
            this.UFj = cVar;
        }
        Log.i("MicroMsg.FestivalCanvasDanmakuView", "toState(" + cVar + "), " + cVar2 + " -> " + this.UFj);
        AppMethodBeat.o(263403);
        return z;
    }

    public final c.AbstractC1084c<DATA> getOnDanmakuAppearListener() {
        return this.UFk;
    }

    public final void setOnDanmakuAppearListener(c.AbstractC1084c<DATA> cVar) {
        this.UFk = cVar;
    }

    public final int getRowCount() {
        return this.rowCount;
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void setRowCount(int i2) {
        boolean z = true;
        AppMethodBeat.i(263404);
        int max = Math.max(i2, 0);
        if (this.rowCount != max) {
            this.rowCount = max;
            if (this.rowCount == 0) {
                this.UFo = new c.a.C1083a[0];
                this.UFp = new C1082b[0];
            } else {
                b<DATA> bVar = this;
                c.a.C1083a[] aVarArr = new c.a.C1083a[this.rowCount];
                if (bVar.UFo.length == 0) {
                    z = false;
                }
                if (z) {
                    int length = aVarArr.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (bVar.UFo.length < i3) {
                            aVarArr[i3] = bVar.UFo[i3];
                        }
                    }
                }
                bVar.UFo = aVarArr;
                this.UFp = new C1082b[this.rowCount];
            }
            requestLayout();
        }
        AppMethodBeat.o(263404);
    }

    public final int getDuration() {
        return this.duration;
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void setDuration(int i2) {
        this.duration = i2;
    }

    public final int getPaddingVertical() {
        return this.paddingVertical;
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void setPaddingVertical(int i2) {
        AppMethodBeat.i(263405);
        this.paddingVertical = Math.max(i2, 0);
        AppMethodBeat.o(263405);
    }

    public final int getIntervalBetweenItem() {
        return this.UFl;
    }

    public final void setIntervalBetweenItem(int i2) {
        AppMethodBeat.i(263406);
        this.UFl = Math.max(i2, 0);
        AppMethodBeat.o(263406);
    }

    public final void setCyclePlay(boolean z) {
        this.Urv = z;
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final boolean isStarted() {
        AppMethodBeat.i(263407);
        Log.i("MicroMsg.FestivalCanvasDanmakuView", "isStarted, state:" + this.UFj);
        int ordinal = c.STARTED.ordinal();
        int ordinal2 = c.UNMOUNTED.ordinal();
        int ordinal3 = this.UFj.ordinal();
        if (ordinal <= ordinal3 && ordinal2 > ordinal3) {
            AppMethodBeat.o(263407);
            return true;
        }
        AppMethodBeat.o(263407);
        return false;
    }

    public final c.a<? extends c.a.C1083a, DATA> getAdapter() {
        return this.UFm;
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void setAdapter(c.a<? extends c.a.C1083a, DATA> aVar) {
        AppMethodBeat.i(263408);
        if ((!p.j(this.UFm, aVar)) && isStarted()) {
            requestLayout();
            postInvalidate();
        }
        this.UFm = aVar;
        AppMethodBeat.o(263408);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void setTouchEnabled(boolean z) {
        this.pbB = z;
    }

    private final boolean getDRAW_VIEW_BOUNDS() {
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/festival/ui/view/FestivalCanvasDanmakuView$handler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "MSG_TRIGGER_RE_MEASURE", "", "getMSG_TRIGGER_RE_MEASURE", "()I", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-festival_release"})
    public static final class d extends MMHandler {
        final int UFG = 1;
        final /* synthetic */ b UFy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, Looper looper) {
            super(looper);
            this.UFy = bVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.tencent.mm.plugin.festival.ui.view.c$b */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: com.tencent.mm.plugin.festival.ui.view.c$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            Object obj;
            Object obj2;
            boolean z = false;
            AppMethodBeat.i(263401);
            if ((message != null ? message.what : 0) == this.UFG) {
                if (message == null) {
                    p.hyc();
                }
                Object obj3 = message.obj;
                if (!(obj3 instanceof Object)) {
                    obj = null;
                } else {
                    obj = obj3;
                }
                if (obj != null) {
                    synchronized (this.UFy.ppH) {
                        try {
                            if (obj instanceof c.b) {
                                Iterator it = this.UFy.ppH.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    Object next = it.next();
                                    if (!(next instanceof c.b)) {
                                        obj2 = null;
                                    } else {
                                        obj2 = next;
                                    }
                                    if (((c.b) obj2) != null && ((c.b) next).gS(obj) && ((c.b) next).gT(obj) == 0) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.UFy.UFn.addLast(obj);
                                }
                            } else if (this.UFy.ppH.contains(obj)) {
                                this.UFy.UFn.addLast(obj);
                            }
                            x xVar = x.SXb;
                        } catch (Throwable th) {
                            AppMethodBeat.o(263401);
                            throw th;
                        }
                    }
                }
                b.d(this.UFy);
            }
            AppMethodBeat.o(263401);
        }
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void start() {
        AppMethodBeat.i(263409);
        if (a(c.STARTED)) {
            postInvalidate();
        }
        AppMethodBeat.o(263409);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c, com.tencent.mm.plugin.festival.finder.bo.a
    public final void resume() {
        AppMethodBeat.i(263410);
        if (a(c.RESUMED)) {
            b<DATA>.C1082b[] bVarArr = this.UFp;
            for (b<DATA>.C1082b bVar : bVarArr) {
                if (bVar != null && bVar.UFv > 0 && !bVar.isFinished()) {
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - bVar.UFv;
                    if (bVar.Ays != null) {
                        Scroller scroller = bVar.Ays;
                        if (scroller == null) {
                            p.btv("scroller");
                        }
                        int currX = scroller.getCurrX();
                        Scroller scroller2 = bVar.Ays;
                        if (scroller2 == null) {
                            p.btv("scroller");
                        }
                        int finalX = scroller2.getFinalX();
                        Scroller scroller3 = bVar.Ays;
                        if (scroller3 == null) {
                            p.btv("scroller");
                        }
                        int currX2 = finalX - scroller3.getCurrX();
                        int i2 = (int) (((float) bVar.duration) * (((float) currX2) / ((float) bVar.UFu)));
                        Scroller scroller4 = bVar.Ays;
                        if (scroller4 == null) {
                            p.btv("scroller");
                        }
                        scroller4.startScroll(currX, 0, currX2, 0, i2);
                    } else {
                        bVar.delay += Math.max((int) currentAnimationTimeMillis, 0);
                    }
                    bVar.UFv = 0;
                }
            }
            requestLayout();
            postInvalidate();
        }
        AppMethodBeat.o(263410);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c, com.tencent.mm.plugin.festival.finder.bo.a
    public final void pause() {
        AppMethodBeat.i(263411);
        if (a(c.PAUSED)) {
            b<DATA>.C1082b[] bVarArr = this.UFp;
            for (b<DATA>.C1082b bVar : bVarArr) {
                if (bVar != null && bVar.UFv <= 0) {
                    bVar.UFv = AnimationUtils.currentAnimationTimeMillis();
                }
            }
        }
        AppMethodBeat.o(263411);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void unMount() {
        AppMethodBeat.i(263412);
        a(c.UNMOUNTED);
        this.UFs.removeCallbacksAndMessages(null);
        Log.i("MicroMsg.FestivalCanvasDanmakuView", "clear");
        synchronized (this.ppH) {
            try {
                this.ppH.clear();
                this.UFn.clear();
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(263412);
                throw th;
            }
        }
        notifyDataSetChanged();
        kotlin.a.e.P(this.UFp);
        kotlin.a.e.P(this.UFo);
        setAdapter(null);
        AppMethodBeat.o(263412);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void addFirst(DATA data) {
        AppMethodBeat.i(263413);
        if (data == null) {
            AppMethodBeat.o(263413);
            return;
        }
        synchronized (this.ppH) {
            try {
                this.ppH.addFirst(data);
                this.UFn.addFirst(data);
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(263413);
                throw th;
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(263413);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void kX(List<? extends DATA> list) {
        AppMethodBeat.i(263414);
        List<? extends DATA> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AppMethodBeat.o(263414);
            return;
        }
        synchronized (this.ppH) {
            try {
                this.ppH.addAll(0, list);
                this.UFn.addAll(0, list);
            } catch (Throwable th) {
                AppMethodBeat.o(263414);
                throw th;
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(263414);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void ab(List<? extends DATA> list) {
        AppMethodBeat.i(263415);
        Log.i("MicroMsg.FestivalCanvasDanmakuView", "addLastAll dataList.size:" + (list != null ? list.size() : -1));
        List<? extends DATA> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AppMethodBeat.o(263415);
            return;
        }
        synchronized (this.ppH) {
            try {
                this.ppH.addAll(list);
                this.UFn.addAll(list);
            } catch (Throwable th) {
                AppMethodBeat.o(263415);
                throw th;
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(263415);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void h(DATA data, boolean z) {
        AppMethodBeat.i(263416);
        if (data == null) {
            AppMethodBeat.o(263416);
            return;
        }
        synchronized (this.ppH) {
            try {
                if (data instanceof c.b) {
                    Iterator<DATA> it = this.ppH.iterator();
                    while (it.hasNext()) {
                        DATA next = it.next();
                        if (next == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.ui.view.FestivalCanvasDanmakuViewContract.DanmakuComparable<DATA>");
                            AppMethodBeat.o(263416);
                            throw tVar;
                        }
                        DATA data2 = next;
                        if (data2.gS(data) && data2.gT(data) <= 0) {
                            it.remove();
                        }
                    }
                    Iterator<DATA> it2 = this.UFn.iterator();
                    while (it2.hasNext()) {
                        DATA next2 = it2.next();
                        if (next2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.ui.view.FestivalCanvasDanmakuViewContract.DanmakuComparable<DATA>");
                            AppMethodBeat.o(263416);
                            throw tVar2;
                        }
                        DATA data3 = next2;
                        if (data3.gS(data) && data3.gT(data) <= 0) {
                            it2.remove();
                        }
                    }
                    x xVar = x.SXb;
                } else {
                    this.ppH.remove(data);
                    Boolean.valueOf(this.UFn.remove(data));
                }
            } catch (Throwable th) {
                AppMethodBeat.o(263416);
                throw th;
            }
        }
        if (z) {
            e eVar = new e(this, data);
            if (p.j(Looper.myLooper(), Looper.getMainLooper())) {
                eVar.run();
            } else {
                post(eVar);
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(263416);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "DATA", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ Object UFH;
        final /* synthetic */ b UFy;

        e(b bVar, Object obj) {
            this.UFy = bVar;
            this.UFH = obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: DATA */
        /* JADX WARN: Multi-variable type inference failed */
        public final void run() {
            DATA data;
            DATA data2;
            boolean z;
            AppMethodBeat.i(263402);
            C1082b[] bVarArr = this.UFy.UFp;
            int length = bVarArr.length;
            int i2 = 0;
            int i3 = 0;
            boolean z2 = false;
            while (i2 < length) {
                C1082b bVar = bVarArr[i2];
                int i4 = i3 + 1;
                if (this.UFH instanceof c.b) {
                    if (bVar != null) {
                        data2 = bVar.data;
                    } else {
                        data2 = null;
                    }
                    if (!(data2 instanceof c.b)) {
                        data2 = null;
                    }
                    DATA data3 = data2;
                    if (data3 != 0) {
                        if (!data3.gS(this.UFH) || data3.gT(this.UFH) > 0) {
                            z = z2;
                        } else {
                            bVar.hSr();
                            this.UFy.UFp[i3] = null;
                            z = z2 | true;
                        }
                        z2 = z;
                    }
                } else {
                    if (bVar != null) {
                        data = bVar.data;
                    } else {
                        data = null;
                    }
                    if (p.j(data, this.UFH)) {
                        bVar.hSr();
                        this.UFy.UFp[i3] = null;
                        z2 |= true;
                    }
                }
                i2++;
                i3 = i4;
            }
            if (z2) {
                u.X(this.UFy);
            }
            AppMethodBeat.o(263402);
        }
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final void kY(List<? extends DATA> list) {
        boolean z;
        AppMethodBeat.i(263417);
        List<? extends DATA> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(263417);
            return;
        }
        synchronized (list) {
            try {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    h(it.next(), false);
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(263417);
            }
        }
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final List<DATA> getDataList() {
        LinkedList<DATA> linkedList;
        synchronized (this.ppH) {
            linkedList = this.ppH;
        }
        return linkedList;
    }

    private final void notifyDataSetChanged() {
        AppMethodBeat.i(263418);
        if (this.UFj == c.STARTED || this.UFj == c.RESUMED) {
            requestLayout();
            postInvalidate();
        }
        AppMethodBeat.o(263418);
    }

    @Override // com.tencent.mm.plugin.festival.ui.view.c
    public final boolean e(PointF pointF) {
        AppMethodBeat.i(263419);
        p.h(pointF, "pointF");
        int length = this.UFp.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.UFp[i2] != null) {
                c.a.C1083a aVar = this.UFo[i2];
                if (aVar == null) {
                    p.hyc();
                }
                a(aVar, this.UFq);
                if (this.UFq.contains(pointF.x, pointF.y)) {
                    boolean performClick = aVar.aus.performClick();
                    AppMethodBeat.o(263419);
                    return performClick;
                }
            }
        }
        AppMethodBeat.o(263419);
        return false;
    }

    private void a(c.a.C1083a aVar, RectF rectF) {
        AppMethodBeat.i(263420);
        p.h(aVar, "vh");
        p.h(rectF, "rectF");
        rectF.setEmpty();
        int indexOf = kotlin.a.e.indexOf(this.UFo, aVar);
        if (indexOf >= 0) {
            b<DATA>.C1082b bVar = this.UFp[indexOf];
            if (bVar == null) {
                AppMethodBeat.o(263420);
                return;
            }
            rectF.set((float) bVar.getCurrX(), (float) bVar.UFx, (float) (bVar.getCurrX() + aVar.ath()), (float) (bVar.UFx + aVar.ati()));
        }
        AppMethodBeat.o(263420);
    }

    private final boolean a(MotionEvent motionEvent, c.a.C1083a aVar) {
        AppMethodBeat.i(263422);
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        try {
            obtain.offsetLocation(-this.UFq.left, -this.UFq.top);
            if (1 == motionEvent.getActionMasked()) {
                aVar.UEZ.set(motionEvent.getRawX(), motionEvent.getRawY());
            } else {
                PointF pointF = aVar.UEZ;
                kotlin.g.b.l lVar = kotlin.g.b.l.SYx;
                float hYV = kotlin.g.b.l.hYV();
                kotlin.g.b.l lVar2 = kotlin.g.b.l.SYx;
                pointF.set(hYV, kotlin.g.b.l.hYV());
            }
            return aVar.aus.dispatchTouchEvent(obtain);
        } finally {
            obtain.recycle();
            AppMethodBeat.o(263422);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(263423);
        p.h(motionEvent, "ev");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            this.UFr = null;
            int length = this.UFp.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.UFp[i2] != null) {
                    c.a.C1083a aVar = this.UFo[i2];
                    if (aVar == null) {
                        p.hyc();
                    }
                    a(aVar, this.UFq);
                    if (this.UFq.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.UFr = aVar;
                        Log.d("MicroMsg.FestivalCanvasDanmakuView", "onInterceptTouchEvent, action:" + MotionEvent.actionToString(actionMasked) + ", vh:" + aVar.hashCode() + ", handled:" + a(motionEvent, aVar));
                        AppMethodBeat.o(263423);
                        return true;
                    }
                }
            }
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(263423);
            return onInterceptTouchEvent;
        } else if (this.UFr != null) {
            AppMethodBeat.o(263423);
            return true;
        } else {
            AppMethodBeat.o(263423);
            return false;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(263424);
        p.h(motionEvent, "ev");
        c.a.C1083a aVar = this.UFr;
        if (aVar != null) {
            z = a(motionEvent, aVar);
            Log.d("MicroMsg.FestivalCanvasDanmakuView", "onTouchEvent, action:" + MotionEvent.actionToString(motionEvent.getActionMasked()) + ", vh:" + aVar.hashCode() + ", handled:" + z);
        } else {
            z = false;
        }
        switch (motionEvent.getActionMasked()) {
            case 1:
            case 3:
            case 6:
                this.UFr = null;
                break;
        }
        if (z || super.onTouchEvent(motionEvent)) {
            AppMethodBeat.o(263424);
            return true;
        }
        AppMethodBeat.o(263424);
        return false;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(263425);
        super.onMeasure(i2, i3);
        synchronized (this.ppH) {
            try {
                if (!this.ppH.isEmpty()) {
                    int length = this.UFp.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i4 >= length) {
                            x xVar = x.SXb;
                            break;
                        }
                        if (this.UFp[i4] == null) {
                            DATA pollFirst = this.UFn.pollFirst();
                            if (pollFirst == null) {
                                break;
                            }
                            c.AbstractC1084c<DATA> onDanmakuAppearListener = getOnDanmakuAppearListener();
                            if (onDanmakuAppearListener != null) {
                                onDanmakuAppearListener.dw(pollFirst);
                            }
                            if (this.UFo[i4] == null) {
                                c.a.C1083a[] aVarArr = this.UFo;
                                c.a<? extends c.a.C1083a, DATA> adapter = getAdapter();
                                if (adapter == null) {
                                    p.hyc();
                                }
                                aVarArr[i4] = adapter.r(this);
                            }
                            c.a.C1083a aVar = this.UFo[i4];
                            if (aVar == null) {
                                p.hyc();
                            }
                            c.a<? extends c.a.C1083a, DATA> adapter2 = getAdapter();
                            if (adapter2 == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.festival.ui.view.FestivalCanvasDanmakuViewContract.Adapter<com.tencent.mm.plugin.festival.ui.view.FestivalCanvasDanmakuViewContract.Adapter.ViewHolder, DATA>");
                                AppMethodBeat.o(263425);
                                throw tVar;
                            }
                            adapter2.a(aVar, pollFirst);
                            aVar.measure(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
                            aVar.cw(aVar.ath(), aVar.ati());
                            b<DATA>.C1082b[] bVarArr = this.UFp;
                            Context context = getContext();
                            p.g(context, "context");
                            bVarArr[i4] = new C1082b(this, context, new LinearInterpolator(), pollFirst);
                            b<DATA>.C1082b bVar = this.UFp[i4];
                            if (bVar == null) {
                                p.hyc();
                            }
                            int measuredWidth = getMeasuredWidth();
                            int measuredWidth2 = (-aVar.ath()) - getMeasuredWidth();
                            int duration2 = getDuration();
                            bVar.startTime = AnimationUtils.currentAnimationTimeMillis();
                            bVar.startX = measuredWidth;
                            bVar.UFu = measuredWidth2;
                            bVar.duration = duration2;
                            bVar.delay = i5;
                        }
                        i5 += getIntervalBetweenItem();
                        i4++;
                    }
                } else {
                    this.UFn.clear();
                    kotlin.a.e.P(this.UFp);
                }
            } finally {
                AppMethodBeat.o(263425);
            }
        }
        int length2 = this.UFp.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length2; i7++) {
            if (this.UFp[i7] != null) {
                c.a.C1083a aVar2 = this.UFo[i7];
                if (aVar2 == null) {
                    p.hyc();
                }
                if (aVar2.ati() > 0) {
                    i6 += aVar2.ati();
                    if (i7 != 0) {
                        i6 += getPaddingVertical();
                    }
                }
            }
        }
        if (i6 > 0) {
            int measuredWidth3 = getMeasuredWidth();
            if (getLayoutParams().height != -1) {
                i6 = Math.max(i6, getMeasuredHeight());
            }
            setMeasuredDimension(measuredWidth3, i6);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i2;
        float f2;
        DATA data;
        AppMethodBeat.i(263426);
        p.h(canvas, "canvas");
        if (getMeasuredWidth() == 0 || getMeasuredHeight() == 0 || getAdapter() == null) {
            AppMethodBeat.o(263426);
            return;
        }
        if (getDRAW_VIEW_BOUNDS()) {
            if (this.iY == null) {
                this.iY = new Paint(1);
                Paint paint = this.iY;
                if (paint == null) {
                    p.btv("debugPaint");
                }
                paint.setColor(-16711936);
                Paint paint2 = this.iY;
                if (paint2 == null) {
                    p.btv("debugPaint");
                }
                paint2.setStyle(Paint.Style.STROKE);
                Paint paint3 = this.iY;
                if (paint3 == null) {
                    p.btv("debugPaint");
                }
                paint3.setStrokeWidth((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 1.5f));
            }
            Paint paint4 = this.iY;
            if (paint4 == null) {
                p.btv("debugPaint");
            }
            float strokeWidth = paint4.getStrokeWidth() / 2.0f;
            float measuredWidth = ((float) getMeasuredWidth()) - strokeWidth;
            float measuredHeight = ((float) getMeasuredHeight()) - strokeWidth;
            Paint paint5 = this.iY;
            if (paint5 == null) {
                p.btv("debugPaint");
            }
            canvas.drawRect(strokeWidth, strokeWidth, measuredWidth, measuredHeight, paint5);
        }
        float f3 = 0.0f;
        int length = this.UFp.length;
        int i3 = 0;
        while (i3 < length) {
            b<DATA>.C1082b bVar = this.UFp[i3];
            if (bVar == null) {
                c.a.C1083a aVar = this.UFo[i3];
                if (aVar == null) {
                    f2 = f3;
                } else {
                    f2 = ((float) (aVar.ati() + getPaddingVertical())) + f3;
                }
            } else {
                c.a.C1083a aVar2 = this.UFo[i3];
                if (aVar2 == null) {
                    p.hyc();
                }
                if (bVar.UFx < 0) {
                    bVar.UFx = kotlin.h.a.cR(f3);
                }
                if (bVar.Ays != null) {
                    Scroller scroller = bVar.Ays;
                    if (scroller == null) {
                        p.btv("scroller");
                    }
                    i2 = scroller.getFinalX();
                } else {
                    i2 = bVar.startX + bVar.UFu;
                }
                int i4 = bVar.startX;
                int currX = bVar.getCurrX();
                if (i2 <= currX && i4 >= currX) {
                    canvas.save();
                    canvas.translate((float) bVar.getCurrX(), (float) bVar.UFx);
                    aVar2.draw(canvas);
                    canvas.restore();
                }
                float paddingVertical2 = f3 + ((float) (getPaddingVertical() + aVar2.ati()));
                if (bVar.isFinished()) {
                    this.UFp[i3] = null;
                    d dVar = this.UFs;
                    d dVar2 = this.UFs;
                    int i5 = this.UFs.UFG;
                    if (this.Urv) {
                        data = bVar.data;
                    } else {
                        data = null;
                    }
                    dVar.sendMessageDelayed(dVar2.obtainMessage(i5, data), (long) getIntervalBetweenItem());
                }
                f2 = paddingVertical2;
            }
            i3++;
            f3 = f2;
        }
        AppMethodBeat.o(263426);
    }

    /* access modifiers changed from: protected */
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return false;
    }

    public final void computeScroll() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(263427);
        if (this.UFj == c.RESUMED || this.UFj == c.STARTED) {
            b<DATA>.C1082b[] bVarArr = this.UFp;
            int length = bVarArr.length;
            int i2 = 0;
            boolean z3 = false;
            while (i2 < length) {
                b<DATA>.C1082b bVar = bVarArr[i2];
                if (bVar != null) {
                    if (bVar.UFv > 0) {
                        z2 = false;
                    } else if (bVar.Ays != null) {
                        Scroller scroller = bVar.Ays;
                        if (scroller == null) {
                            p.btv("scroller");
                        }
                        z2 = scroller.computeScrollOffset();
                    } else {
                        if (bVar.delay == 0 || AnimationUtils.currentAnimationTimeMillis() - bVar.startTime >= ((long) bVar.delay)) {
                            bVar.Ays = new Scroller(bVar.context, bVar.Jen);
                            Scroller scroller2 = bVar.Ays;
                            if (scroller2 == null) {
                                p.btv("scroller");
                            }
                            scroller2.startScroll(bVar.startX, 0, bVar.UFu, 0, bVar.duration);
                            Scroller scroller3 = bVar.Ays;
                            if (scroller3 == null) {
                                p.btv("scroller");
                            }
                            scroller3.computeScrollOffset();
                        }
                        z2 = true;
                    }
                    z = true == z2 ? true : z3;
                } else {
                    z = z3;
                }
                i2++;
                z3 = z;
            }
            if (z3) {
                u.X(this);
            }
        }
        AppMethodBeat.o(263427);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(263428);
        int length = this.UFp.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (this.UFp[i6] == null) {
                c.a.C1083a aVar = this.UFo[i6];
                if (aVar != null && indexOfChild(aVar.aus) >= 0) {
                    removeViewInLayout(aVar.aus);
                }
            } else {
                c.a.C1083a aVar2 = this.UFo[i6];
                if (aVar2 == null) {
                    p.hyc();
                }
                if (indexOfChild(aVar2.aus) < 0) {
                    addViewInLayout(aVar2.aus, getChildCount(), new ViewGroup.LayoutParams(-2, -2), true);
                }
            }
        }
        AppMethodBeat.o(263428);
    }

    /* access modifiers changed from: protected */
    public final boolean canAnimate() {
        return false;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(263421);
        p.h(motionEvent, "ev");
        if (!this.pbB) {
            AppMethodBeat.o(263421);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(263421);
        return dispatchTouchEvent;
    }
}
