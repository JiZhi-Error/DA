package com.tencent.mm.plugin.finder.widget.record;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.finder.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u001a\u0010\"\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J(\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/widget/record/EdgeTransparentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomMask", "drawSize", "", "leftMask", "mGradientColors", "", "mGradientPosition", "", "mHeight", "mPaint", "Landroid/graphics/Paint;", "mWidth", "position", "rightMask", "topMask", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawChild", "", "child", "Landroid/view/View;", "drawingTime", "", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initShader", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "plugin-finder_release"})
public final class EdgeTransparentView extends FrameLayout {
    private int mHeight;
    private Paint mPaint;
    private int mWidth;
    private int position;
    private float wDI;
    private final int wDJ;
    private final int wDK;
    private final int wDL;
    private final int wDM;
    private final int[] wDN;
    private final float[] wDO;

    public EdgeTransparentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private /* synthetic */ EdgeTransparentView(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EdgeTransparentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(256163);
        this.wDJ = 1;
        this.wDK = this.wDJ << 1;
        this.wDL = this.wDJ << 2;
        this.wDM = this.wDJ << 3;
        this.mPaint = new Paint(1);
        Paint paint = this.mPaint;
        if (paint == null) {
            p.hyc();
        }
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.mPaint;
        if (paint2 == null) {
            p.hyc();
        }
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.EdgeTransparentView);
        this.position = obtainStyledAttributes.getInt(0, 0);
        this.wDI = obtainStyledAttributes.getDimension(1, (float) a.fromDPToPix(context, 20.0f));
        obtainStyledAttributes.recycle();
        this.wDN = new int[]{-1, 0};
        this.wDO = new float[]{0.0f, 1.0f};
        AppMethodBeat.o(256163);
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(256159);
        p.h(canvas, "canvas");
        super.dispatchDraw(canvas);
        AppMethodBeat.o(256159);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(256160);
        super.onSizeChanged(i2, i3, i4, i5);
        Paint paint = this.mPaint;
        if (paint == null) {
            p.hyc();
        }
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.wDI, this.wDN, this.wDO, Shader.TileMode.CLAMP));
        this.mWidth = getWidth();
        this.mHeight = getHeight();
        AppMethodBeat.o(256160);
    }

    /* access modifiers changed from: protected */
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        AppMethodBeat.i(256161);
        p.h(canvas, "canvas");
        p.h(view, "child");
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null);
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (this.position == 0 || (this.position & this.wDJ) != 0) {
            float f2 = (float) this.mWidth;
            float f3 = this.wDI;
            Paint paint = this.mPaint;
            if (paint == null) {
                p.hyc();
            }
            canvas.drawRect(0.0f, 0.0f, f2, f3, paint);
        }
        if (this.position == 0 || (this.position & this.wDK) != 0) {
            int save = canvas.save();
            canvas.rotate(180.0f, ((float) this.mWidth) / 2.0f, ((float) this.mHeight) / 2.0f);
            float f4 = (float) this.mWidth;
            float f5 = this.wDI;
            Paint paint2 = this.mPaint;
            if (paint2 == null) {
                p.hyc();
            }
            canvas.drawRect(0.0f, 0.0f, f4, f5, paint2);
            canvas.restoreToCount(save);
        }
        int i2 = (this.mHeight - this.mWidth) / 2;
        if (this.position == 0 || (this.position & this.wDL) != 0) {
            int save2 = canvas.save();
            canvas.rotate(90.0f, ((float) this.mWidth) / 2.0f, ((float) this.mHeight) / 2.0f);
            canvas.translate(0.0f, (float) i2);
            float f6 = 0.0f - ((float) i2);
            float f7 = ((float) i2) + ((float) this.mWidth);
            float f8 = this.wDI;
            Paint paint3 = this.mPaint;
            if (paint3 == null) {
                p.hyc();
            }
            canvas.drawRect(f6, 0.0f, f7, f8, paint3);
            canvas.restoreToCount(save2);
        }
        if (this.position == 0 || (this.position & this.wDM) != 0) {
            int save3 = canvas.save();
            canvas.rotate(270.0f, ((float) this.mWidth) / 2.0f, ((float) this.mHeight) / 2.0f);
            canvas.translate(0.0f, (float) i2);
            float f9 = 0.0f - ((float) i2);
            float f10 = ((float) i2) + ((float) this.mWidth);
            float f11 = this.wDI;
            Paint paint4 = this.mPaint;
            if (paint4 == null) {
                p.hyc();
            }
            canvas.drawRect(f9, 0.0f, f10, f11, paint4);
            canvas.restoreToCount(save3);
        }
        canvas.restoreToCount(saveLayer);
        AppMethodBeat.o(256161);
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(256162);
        p.h(canvas, "canvas");
        super.onDraw(canvas);
        AppMethodBeat.o(256162);
    }
}
