package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBoundaryColor", "mMaskColor", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "mPosition", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFramePosition;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaskColor", "maskColor", "setPosition", "position", "plugin-recordvideo_release"})
public final class EditorFrameView extends View {
    private int CcE = -1;
    private int CcF = -1;
    private c CcG = c.POSITION_LEFT;
    private Paint mPaint = new Paint();
    private Path xT = new Path();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorFrameView(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(75980);
        init();
        AppMethodBeat.o(75980);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(75981);
        init();
        AppMethodBeat.o(75981);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorFrameView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(75982);
        init();
        AppMethodBeat.o(75982);
    }

    private final void init() {
        AppMethodBeat.i(75977);
        Context context = getContext();
        p.g(context, "context");
        this.CcE = context.getResources().getColor(R.color.a_u);
        int fromDPToPix = a.fromDPToPix(getContext(), 1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(2.0f * ((float) fromDPToPix));
        this.mPaint.setColor(this.CcF);
        this.mPaint.setPathEffect(new DashPathEffect(new float[]{((float) fromDPToPix) * 4.0f, ((float) fromDPToPix) * 4.0f}, 0.0f));
        AppMethodBeat.o(75977);
    }

    public final void setMaskColor(int i2) {
        this.CcE = i2;
    }

    public final void setPosition(c cVar) {
        AppMethodBeat.i(75978);
        p.h(cVar, "position");
        this.CcG = cVar;
        AppMethodBeat.o(75978);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(75979);
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.save();
        }
        if (canvas != null) {
            canvas.drawColor(this.CcE);
        }
        switch (d.$EnumSwitchMapping$0[this.CcG.ordinal()]) {
            case 1:
                this.xT.moveTo((float) getWidth(), 0.0f);
                this.xT.lineTo((float) getWidth(), (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.xT, this.mPaint);
                    break;
                }
                break;
            case 2:
                this.xT.moveTo(0.0f, (float) getHeight());
                this.xT.lineTo((float) getWidth(), (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.xT, this.mPaint);
                    break;
                }
                break;
            case 3:
                this.xT.moveTo(0.0f, 0.0f);
                this.xT.lineTo(0.0f, (float) getHeight());
                if (canvas != null) {
                    canvas.drawPath(this.xT, this.mPaint);
                    break;
                }
                break;
            case 4:
                this.xT.moveTo(0.0f, 0.0f);
                this.xT.lineTo((float) getWidth(), 0.0f);
                if (canvas != null) {
                    canvas.drawPath(this.xT, this.mPaint);
                    break;
                }
                break;
        }
        if (canvas != null) {
            canvas.restore();
            AppMethodBeat.o(75979);
            return;
        }
        AppMethodBeat.o(75979);
    }
}
