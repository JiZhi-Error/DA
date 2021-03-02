package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.wxmm.v2helper;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u001bR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/view/RecordUploadProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "backColor", "", "getBackColor", "()I", "setBackColor", "(I)V", "foreColor", "getForeColor", "setForeColor", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "progress", "getProgress", "setProgress", "draw", "", "canvas", "Landroid/graphics/Canvas;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "ui-selectcontact_release"})
public final class RecordUploadProgressView extends View {
    public Paint paint = new Paint();
    private int progress;
    private int woy;
    private int woz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordUploadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(219814);
        Paint paint2 = this.paint;
        if (paint2 == null) {
            p.btv("paint");
        }
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.paint;
        if (paint3 == null) {
            p.btv("paint");
        }
        paint3.setStrokeWidth(getResources().getDimension(R.dimen.aih));
        Paint paint4 = this.paint;
        if (paint4 == null) {
            p.btv("paint");
        }
        paint4.setAntiAlias(true);
        this.woy = getResources().getColor(R.color.BW_0_Alpha_0_1);
        this.woz = getResources().getColor(R.color.Brand_100);
        AppMethodBeat.o(219814);
    }

    public final Paint getPaint() {
        AppMethodBeat.i(219811);
        Paint paint2 = this.paint;
        if (paint2 == null) {
            p.btv("paint");
        }
        AppMethodBeat.o(219811);
        return paint2;
    }

    public final void setPaint(Paint paint2) {
        AppMethodBeat.i(219812);
        p.h(paint2, "<set-?>");
        this.paint = paint2;
        AppMethodBeat.o(219812);
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress(int i2) {
        this.progress = i2;
    }

    public final int getBackColor() {
        return this.woy;
    }

    public final void setBackColor(int i2) {
        this.woy = i2;
    }

    public final int getForeColor() {
        return this.woz;
    }

    public final void setForeColor(int i2) {
        this.woz = i2;
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(219813);
        super.draw(canvas);
        int width = getWidth() / 2;
        Paint paint2 = this.paint;
        if (paint2 == null) {
            p.btv("paint");
        }
        int strokeWidth = (int) (((float) width) - (paint2.getStrokeWidth() / 2.0f));
        Paint paint3 = this.paint;
        if (paint3 == null) {
            p.btv("paint");
        }
        paint3.setColor(this.woy);
        Paint paint4 = this.paint;
        if (paint4 == null) {
            p.btv("paint");
        }
        paint4.setAntiAlias(true);
        Paint paint5 = this.paint;
        if (paint5 == null) {
            p.btv("paint");
        }
        paint5.setStyle(Paint.Style.STROKE);
        if (canvas != null) {
            float f2 = (float) width;
            float f3 = (float) width;
            float f4 = (float) strokeWidth;
            Paint paint6 = this.paint;
            if (paint6 == null) {
                p.btv("paint");
            }
            canvas.drawCircle(f2, f3, f4, paint6);
        }
        Paint paint7 = this.paint;
        if (paint7 == null) {
            p.btv("paint");
        }
        paint7.setColor(this.woz);
        RectF rectF = new RectF((float) (width - strokeWidth), (float) (width - strokeWidth), (float) (width + strokeWidth), (float) (width + strokeWidth));
        float f5 = ((float) (this.progress * v2helper.VOIP_ENC_HEIGHT_LV1)) / 100.0f;
        if (canvas != null) {
            Paint paint8 = this.paint;
            if (paint8 == null) {
                p.btv("paint");
            }
            canvas.drawArc(rectF, -90.0f, f5, false, paint8);
            AppMethodBeat.o(219813);
            return;
        }
        AppMethodBeat.o(219813);
    }
}
