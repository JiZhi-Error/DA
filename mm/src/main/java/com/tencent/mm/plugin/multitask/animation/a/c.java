package com.tencent.mm.plugin.multitask.animation.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u0000 =2\u00020\u0001:\u0001=B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0014J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014H\u0014J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0011H\u0016J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0014H\u0016J(\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0016JH\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020-2\u0006\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020-H\u0016J\u0018\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterToMultiTaskView;", "Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterBaseView;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "<set-?>", "getContentBitmap", "()Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "mClipPath", "Landroid/graphics/Path;", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "", "mMaskAlpha", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mPaint", "mRectConnerRadius", "", "mWidth", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDstRect", "dstRect", "setMaskAlpha", "maskAlpha", "setMaskRect", "left", "", "top", "right", "buttom", "setRectConnerRadius", "radll", "radlt", "radtl", "radtt", "radrl", "radrt", "radbl", "radbt", "setViewSize", "width", "height", "Companion", "plugin-multitask_release"})
public final class c extends a {
    private static final int zZS = at.fromDPToPix(MMApplicationContext.getContext(), 8);
    public static final a zZU = new a((byte) 0);
    private Rect Ky;
    private int mHeight;
    private Paint mPaint = new Paint();
    private int mWidth;
    private int oZh;
    private Paint oZj = new Paint();
    private Path pcR = new Path();
    private Rect pcS;
    private RectF pcT;
    private Bitmap zZM;
    private GradientDrawable zZO;
    private final float[] zZR = {0.0f, 0.0f, 0.0f, 0.0f, (float) zZS, (float) zZS, (float) zZS, (float) zZS};

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, Bitmap bitmap) {
        super(context);
        p.h(bitmap, "contentBitmap");
        AppMethodBeat.i(200389);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        Paint paint = this.oZj;
        if (paint == null) {
            p.btv("mMaskPaint");
        }
        paint.setXfermode(porterDuffXfermode);
        this.zZM = bitmap;
        this.mWidth = (int) (((float) bitmap.getWidth()) * 1.25f);
        this.mHeight = (int) (((float) bitmap.getHeight()) * 1.25f);
        this.pcS = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.Ky = new Rect(0, 0, this.mWidth, this.mHeight);
        this.pcT = new RectF();
        RectF rectF = this.pcT;
        if (rectF == null) {
            p.btv("mMaskRect");
        }
        rectF.left = 0.0f;
        RectF rectF2 = this.pcT;
        if (rectF2 == null) {
            p.btv("mMaskRect");
        }
        rectF2.top = 0.0f;
        RectF rectF3 = this.pcT;
        if (rectF3 == null) {
            p.btv("mMaskRect");
        }
        rectF3.right = (float) this.mWidth;
        RectF rectF4 = this.pcT;
        if (rectF4 == null) {
            p.btv("mMaskRect");
        }
        rectF4.bottom = (float) this.mHeight;
        this.zZO = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(230, 0, 0, 0), Color.argb(76, 0, 0, 0), Color.argb(0, 0, 0, 0)});
        GradientDrawable gradientDrawable = this.zZO;
        if (gradientDrawable != null) {
            gradientDrawable.setGradientType(0);
        }
        GradientDrawable gradientDrawable2 = this.zZO;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setGradientCenter(0.5f, 0.4f);
        }
        GradientDrawable gradientDrawable3 = this.zZO;
        if (gradientDrawable3 != null) {
            Rect rect = this.Ky;
            if (rect == null) {
                p.btv("mDstRect");
            }
            gradientDrawable3.setBounds(rect);
        }
        ae aeVar = ae.SYK;
        String format = String.format("default init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)}, 2));
        p.g(format, "java.lang.String.format(format, *args)");
        Log.i("MicroMsg.TransformSwipeBackToMultiTaskView", format);
        AppMethodBeat.o(200389);
    }

    public final Bitmap getContentBitmap() {
        return this.zZM;
    }

    public final GradientDrawable getGradientDrawable() {
        return this.zZO;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(200385);
        p.h(canvas, "canvas");
        Path path = this.pcR;
        if (path == null) {
            p.btv("mClipPath");
        }
        path.reset();
        Path path2 = this.pcR;
        if (path2 == null) {
            p.btv("mClipPath");
        }
        RectF rectF = this.pcT;
        if (rectF == null) {
            p.btv("mMaskRect");
        }
        path2.addRoundRect(rectF, this.zZR, Path.Direction.CW);
        Path path3 = this.pcR;
        if (path3 == null) {
            p.btv("mClipPath");
        }
        canvas.clipPath(path3);
        Bitmap bitmap = this.zZM;
        if (bitmap != null) {
            Rect rect = this.pcS;
            if (rect == null) {
                p.btv("mDrawRect");
            }
            Rect rect2 = this.Ky;
            if (rect2 == null) {
                p.btv("mDstRect");
            }
            Paint paint = this.mPaint;
            if (paint == null) {
                p.btv("mPaint");
            }
            canvas.drawBitmap(bitmap, rect, rect2, paint);
        }
        GradientDrawable gradientDrawable = this.zZO;
        if (gradientDrawable != null) {
            gradientDrawable.setAlpha(this.oZh);
            gradientDrawable.draw(canvas);
            AppMethodBeat.o(200385);
            return;
        }
        AppMethodBeat.o(200385);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(200386);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
        AppMethodBeat.o(200386);
    }

    @Override // com.tencent.mm.plugin.multitask.animation.a.a
    public final void m(float f2, float f3, float f4) {
        AppMethodBeat.i(200387);
        RectF rectF = this.pcT;
        if (rectF == null) {
            p.btv("mMaskRect");
        }
        rectF.set(0.0f, f2, f3, f4);
        AppMethodBeat.o(200387);
    }

    @Override // com.tencent.mm.plugin.multitask.animation.a.a
    public final void setDstRect(Rect rect) {
        AppMethodBeat.i(200388);
        p.h(rect, "dstRect");
        this.Ky = rect;
        AppMethodBeat.o(200388);
    }

    @Override // com.tencent.mm.plugin.multitask.animation.a.a
    public final void setMaskAlpha(int i2) {
        this.oZh = i2;
    }

    @Override // com.tencent.mm.plugin.multitask.animation.a.a
    public final void hk(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    @Override // com.tencent.mm.plugin.multitask.animation.a.a
    public final void m(float f2, float f3, float f4, float f5) {
        this.zZR[0] = 0.0f;
        this.zZR[1] = 0.0f;
        this.zZR[2] = 0.0f;
        this.zZR[3] = 0.0f;
        this.zZR[4] = f2;
        this.zZR[5] = f3;
        this.zZR[6] = f4;
        this.zZR[7] = f5;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/enter/TransformEnterToMultiTaskView$Companion;", "", "()V", "DEFAULT_CORNER_RADIUS", "", "getDEFAULT_CORNER_RADIUS", "()I", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(200390);
        AppMethodBeat.o(200390);
    }
}
