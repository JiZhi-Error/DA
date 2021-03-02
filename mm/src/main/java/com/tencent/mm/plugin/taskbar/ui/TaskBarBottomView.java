package com.tencent.mm.plugin.taskbar.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarBottomView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawColor", "leftArcRectF", "Landroid/graphics/RectF;", "mContext", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "radii", "", "radius", "", "rightArcRectF", "computeRadius", "", "dp", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onDraw", "canvas", "Landroid/graphics/Canvas;", "setDrawColor", "color", "setTopRoundRadius", "topRadius", "Companion", "plugin-taskbar_release"})
public final class TaskBarBottomView extends View {
    public static final a FTD = new a((byte) 0);
    private float[] FTA = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private RectF FTB = new RectF();
    private RectF FTC = new RectF();
    private int FTz;
    private Context mContext;
    private Paint mPaint = new Paint();
    private float radius;
    private Path xT = new Path();

    static {
        AppMethodBeat.i(238447);
        AppMethodBeat.o(238447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarBottomView$Companion;", "", "()V", "DEFAULT_RADIUS_IN_DP", "", "TAG", "", "plugin-taskbar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskBarBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(238445);
        init(context);
        AppMethodBeat.o(238445);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskBarBottomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(238446);
        init(context);
        AppMethodBeat.o(238446);
    }

    private final void init(Context context) {
        AppMethodBeat.i(238440);
        this.mContext = context;
        this.FTz = getResources().getColor(R.color.d4);
        abz(8);
        AppMethodBeat.o(238440);
    }

    private final void abz(int i2) {
        AppMethodBeat.i(238441);
        this.radius = (float) com.tencent.mm.cb.a.fromDPToPix(getContext(), i2);
        this.FTA[0] = this.radius;
        this.FTA[1] = this.radius;
        this.FTA[2] = this.radius;
        this.FTA[3] = this.radius;
        Log.i("Mp.AppBrandDesktopBottomView", "alvinluo computeRadius radius: %f", Float.valueOf(this.radius));
        AppMethodBeat.o(238441);
    }

    public final void setTopRoundRadius(int i2) {
        AppMethodBeat.i(238442);
        abz(i2);
        AppMethodBeat.o(238442);
    }

    public final void setDrawColor(int i2) {
        AppMethodBeat.i(238443);
        this.FTz = i2;
        invalidate();
        AppMethodBeat.o(238443);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(238444);
        super.onDraw(canvas);
        this.mPaint.setColor(this.FTz);
        this.mPaint.setStyle(Paint.Style.FILL);
        if (d.oF(20)) {
            this.xT.addRoundRect((float) getLeft(), (float) getTop(), (float) getRight(), (float) getBottom(), this.FTA, Path.Direction.CCW);
            if (canvas != null) {
                canvas.drawPath(this.xT, this.mPaint);
            }
            this.xT.reset();
            AppMethodBeat.o(238444);
            return;
        }
        this.FTB.set((float) getLeft(), (float) getTop(), ((float) getLeft()) + (this.radius * 2.0f), ((float) getTop()) + (this.radius * 2.0f));
        this.FTC.set(((float) getRight()) - (this.radius * 2.0f), (float) getTop(), (float) getRight(), ((float) getTop()) + (this.radius * 2.0f));
        if (canvas != null) {
            canvas.drawArc(this.FTB, 180.0f, 90.0f, true, this.mPaint);
        }
        if (canvas != null) {
            canvas.drawArc(this.FTC, 270.0f, 90.0f, true, this.mPaint);
        }
        if (canvas != null) {
            canvas.drawRect(this.radius + ((float) getLeft()), (float) getTop(), ((float) getRight()) - this.radius, this.radius, this.mPaint);
        }
        if (canvas != null) {
            canvas.drawRect((float) getLeft(), this.radius + ((float) getTop()), (float) getRight(), (float) getBottom(), this.mPaint);
            AppMethodBeat.o(238444);
            return;
        }
        AppMethodBeat.o(238444);
    }
}
