package com.tencent.mm.plugin.recordvideo.plugin.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/doodle/ClickBigImageView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "slimWidth", "", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "FIX_PADDING", "", "bitmap", "Landroid/graphics/Bitmap;", "color", "", "hasSelected", "mDoodlePaint", "Landroid/graphics/Paint;", "radius", "getSlimWidth", "()Z", "setSlimWidth", "(Z)V", "type", "getType", "()I", "setType", "(I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setBitmap", "setDrawColor", "setHasSelected", "select", "plugin-recordvideo_release"})
public final class a extends View {
    private final float BSN;
    private boolean BSO;
    private Bitmap bitmap;
    private int color;
    private final Paint hog;
    private int radius;
    private int type;
    boolean yLb;

    public /* synthetic */ a(Context context) {
        this(context, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, boolean z) {
        super(context, null);
        p.h(context, "context");
        AppMethodBeat.i(237370);
        this.BSO = z;
        this.hog = new Paint(1);
        this.radius = com.tencent.mm.cb.a.fromDPToPix(context, 7);
        this.BSN = (float) com.tencent.mm.cb.a.fromDPToPix(context, 2);
        this.hog.setStyle(Paint.Style.FILL);
        this.hog.setStrokeCap(Paint.Cap.ROUND);
        this.hog.setAntiAlias(true);
        this.hog.setStyle(Paint.Style.FILL);
        AppMethodBeat.o(237370);
    }

    public final boolean getSlimWidth() {
        return this.BSO;
    }

    public final void setSlimWidth(boolean z) {
        this.BSO = z;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        Bitmap bitmap2;
        AppMethodBeat.i(75717);
        p.h(canvas, "canvas");
        canvas.drawColor(0);
        this.hog.setColor(-1);
        int width = getWidth();
        if (!this.yLb) {
            width = getWidth() - (((int) this.BSN) * 2);
        }
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getWidth()) / 2.0f, ((float) width) / 2.0f, this.hog);
        if (this.bitmap != null && (bitmap2 = this.bitmap) != null && !bitmap2.isRecycled()) {
            float f2 = ((float) this.radius) * 2.0f;
            Bitmap bitmap3 = this.bitmap;
            if (bitmap3 == null) {
                p.hyc();
            }
            float width2 = f2 / ((float) bitmap3.getWidth());
            this.bitmap = BitmapUtil.rotateAndScale(this.bitmap, 0.0f, width2, width2);
            int width3 = getWidth();
            Bitmap bitmap4 = this.bitmap;
            if (bitmap4 == null) {
                p.hyc();
            }
            float width4 = ((float) (width3 - bitmap4.getWidth())) / 2.0f;
            Bitmap bitmap5 = this.bitmap;
            if (bitmap5 == null) {
                p.hyc();
            }
            canvas.drawBitmap(bitmap5, width4, width4, this.hog);
        } else if (this.color != 0) {
            this.hog.setColor(this.color);
            if (this.BSO) {
                this.radius = (getWidth() - com.tencent.mm.cb.a.fromDPToPix(getContext(), 8)) / 2;
            }
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getWidth()) / 2.0f, (float) this.radius, this.hog);
        }
        super.onDraw(canvas);
        AppMethodBeat.o(75717);
    }

    public final void setBitmap(Bitmap bitmap2) {
        AppMethodBeat.i(75718);
        p.h(bitmap2, "bitmap");
        this.bitmap = bitmap2;
        AppMethodBeat.o(75718);
    }

    public final void setDrawColor(int i2) {
        this.color = i2;
    }

    public final void setHasSelected(boolean z) {
        AppMethodBeat.i(75719);
        if (this.yLb != z) {
            this.yLb = z;
            invalidate();
        }
        AppMethodBeat.o(75719);
    }
}
