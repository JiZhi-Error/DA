package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0006\u0010\u001c\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\fR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "END_POINT_SIZE", "", "MAX_DISTANCE", "MIN_DISTANCE", "POINT_MARGIN_TOP", "START_POINT_SIZE", "mFillPaint", "Landroid/graphics/Paint;", "mLeftPoint", "Landroid/graphics/Point;", "mRightPoint", "mSlideOffset", "mStrokePaint", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getLoadingMode", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "updateLoadingMode", "mode", "updateSlideOffset", "slideOffset", "Companion", "ui-multitask_release"})
public final class MultiTaskContainerView extends FrameLayout {
    private static int AeZ;
    public static final a Afa = new a((byte) 0);
    private static int mState;
    private Point AeS = new Point();
    private Point AeT = new Point();
    private float AeU;
    private float AeV;
    private int AeW;
    private float AeX;
    private float AeY;
    public float Vm;
    private final Paint xX = new Paint();
    private final Paint xY = new Paint();

    static {
        AppMethodBeat.i(236588);
        AppMethodBeat.o(236588);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/panel/MultiTaskContainerView$Companion;", "", "()V", "MODE_DATA", "", "MODE_EMPTY", "MODE_NONE", "STATE_ALPHA", "STATE_IDLE", "STATE_NONE", "STATE_TRANSLATION", "TAG", "", "mLoadingMode", "mState", "ui-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(236586);
        init();
        AppMethodBeat.o(236586);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskContainerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attributeSet");
        AppMethodBeat.i(236587);
        init();
        AppMethodBeat.o(236587);
    }

    private final void init() {
        AppMethodBeat.i(236583);
        this.AeU = (float) at.fromDPToPix(getContext(), 4);
        this.AeV = (float) at.fromDPToPix(getContext(), 8);
        this.AeX = ((float) at.fromDPToPix(getContext(), 5)) + this.AeV;
        this.AeY = ((float) at.fromDPToPix(getContext(), 20)) + this.AeV;
        this.AeW = (at.fromDPToPix(getContext(), 48) / 2) + au.D(MMApplicationContext.getContext(), -1);
        this.xX.setColor(getResources().getColor(R.color.a1o));
        this.xX.setStyle(Paint.Style.STROKE);
        this.xX.setStrokeWidth((float) at.fromDPToPix(getContext(), 1));
        this.xX.setFlags(1);
        this.xY.setColor(getResources().getColor(R.color.a1o));
        this.xY.setStyle(Paint.Style.FILL);
        this.xY.setFlags(1);
        AppMethodBeat.o(236583);
    }

    public final void RT(int i2) {
        AppMethodBeat.i(236584);
        AeZ = i2;
        invalidate();
        AppMethodBeat.o(236584);
    }

    public final int getLoadingMode() {
        return AeZ;
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int i2 = 0;
        AppMethodBeat.i(236585);
        p.h(canvas, "canvas");
        super.dispatchDraw(canvas);
        mState = 0;
        if (AeZ == 1 || AeZ == 2) {
            canvas.save();
            float f5 = this.AeU;
            int width = getWidth();
            MultiTaskUIC.a aVar = MultiTaskUIC.Ago;
            float f6 = ((float) (width - MultiTaskUIC.Agi)) * this.Vm;
            int width2 = getWidth();
            MultiTaskUIC.a aVar2 = MultiTaskUIC.Ago;
            int i3 = (width2 - MultiTaskUIC.Agi) - (((int) f6) / 2);
            float width3 = ((float) getWidth()) * 0.15f;
            float width4 = ((float) getWidth()) * 0.18f;
            float width5 = ((float) getWidth()) * 0.25f;
            if (f6 < width3) {
                mState = 1;
                f2 = 0.0f;
                f3 = 0.0f;
            } else if (f6 >= width3 && f6 < width4) {
                f3 = (f6 - width3) / (width4 - width3);
                mState = 2;
                f2 = 0.0f;
            } else if (f6 >= width4 && f6 < width5) {
                f2 = (f6 - width4) / (width5 - width4);
                mState = 3;
                f3 = 1.0f;
            } else if (f6 >= width5) {
                mState = 3;
                f2 = 1.0f;
                f3 = 1.0f;
            } else {
                f2 = 0.0f;
                f3 = 0.0f;
            }
            this.AeS.y = this.AeW;
            this.AeT.y = this.AeW;
            this.AeS.x = i3 - (((int) this.AeX) / 2);
            this.AeT.x = (((int) this.AeX) / 2) + i3;
            if (mState == 1) {
                f4 = this.AeU;
            } else if (mState == 2) {
                f4 = this.AeU;
            } else {
                if (mState == 3) {
                    f5 = this.AeU + ((this.AeV - this.AeU) * f2);
                    this.AeS.x = i3 - ((int) ((this.AeX + ((this.AeY - this.AeX) * f2)) / 2.0f));
                    this.AeT.x = ((int) (((f2 * (this.AeY - this.AeX)) + this.AeX) / 2.0f)) + i3;
                }
                f4 = f5;
            }
            if (AeZ == 1) {
                this.xX.setAlpha(f3 < 0.0f ? 0 : f3 > 1.0f ? TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 : (int) (176.0f * f3));
                canvas.drawCircle((float) this.AeS.x, (float) this.AeS.y, f4 / 2.0f, this.xX);
                canvas.drawCircle((float) this.AeT.x, (float) this.AeT.y, f4 / 2.0f, this.xX);
            } else {
                Paint paint = this.xY;
                if (f3 >= 0.0f) {
                    i2 = f3 > 1.0f ? TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6 : (int) (176.0f * f3);
                }
                paint.setAlpha(i2);
                canvas.drawCircle((float) this.AeS.x, (float) this.AeS.y, f4 / 2.0f, this.xY);
                canvas.drawCircle((float) this.AeT.x, (float) this.AeT.y, f4 / 2.0f, this.xY);
            }
            canvas.restore();
        }
        AppMethodBeat.o(236585);
    }
}
