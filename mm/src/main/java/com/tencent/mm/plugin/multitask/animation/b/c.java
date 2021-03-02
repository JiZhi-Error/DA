package com.tencent.mm.plugin.multitask.animation.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0014J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0014J\u001e\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nJ\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010\bJ\u0018\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u000103R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "contentBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "mAnimatorListener", "Landroid/animation/AnimatorListenerAdapter;", "mBagPosX", "", "mBagPosY", "mBgAlpha", "mCanvasTranslateX", "mClipPath", "Landroid/graphics/Path;", "mContentBitmap", "mContentFromX", "mDrawRect", "Landroid/graphics/Rect;", "mDstRect", "mHeight", "mMaskPaint", "Landroid/graphics/Paint;", "mMaskRect", "Landroid/graphics/RectF;", "mNeedTranslate", "", "mPaint", "mRectConnerRadius", "mWidth", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "bitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBagInfo", "bagX", "bagY", "bagRadius", "setContentStartPosX", "fromX", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "startAnimation", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "interpolator", "Landroid/animation/TimeInterpolator;", "Companion", "plugin-multitask_release"})
public final class c extends View {
    public static final a Aag = new a((byte) 0);
    private Rect Ky;
    int mHeight;
    private Paint mPaint = new Paint();
    int mWidth;
    private Paint oZj = new Paint();
    private Bitmap pcQ;
    private Path pcR = new Path();
    private Rect pcS;
    private RectF pcT;
    private int pcU;
    int pcV;
    int pcW;
    int pcX;
    int pcY = -1;
    boolean pcZ;
    private int pda;
    private AnimatorListenerAdapter pdb;

    static {
        AppMethodBeat.i(200426);
        AppMethodBeat.o(200426);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, Bitmap bitmap) {
        super(context);
        p.h(bitmap, "contentBitmap");
        AppMethodBeat.i(200425);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        Paint paint = this.oZj;
        if (paint == null) {
            p.btv("mMaskPaint");
        }
        paint.setXfermode(porterDuffXfermode);
        this.pcQ = bitmap;
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
        ae aeVar = ae.SYK;
        String format = String.format("init: mWidth:%d mHeight:%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)}, 2));
        p.g(format, "java.lang.String.format(format, *args)");
        Log.i("MicroMsg.TransformToMultiTaskFBAnimationMaskView", format);
        AppMethodBeat.o(200425);
    }

    public static final /* synthetic */ RectF a(c cVar) {
        AppMethodBeat.i(200427);
        RectF rectF = cVar.pcT;
        if (rectF == null) {
            p.btv("mMaskRect");
        }
        AppMethodBeat.o(200427);
        return rectF;
    }

    public final void setContentStartPosX(int i2) {
        this.pcY = i2;
    }

    public final void setListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.pdb = animatorListenerAdapter;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ c Aah;

        b(c cVar) {
            this.Aah = cVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(200420);
            c cVar = this.Aah;
            Object animatedValue = valueAnimator.getAnimatedValue("canvasTranslationX");
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(200420);
                throw tVar;
            }
            cVar.pcU = ((Integer) animatedValue).intValue();
            RectF a2 = c.a(this.Aah);
            Object animatedValue2 = valueAnimator.getAnimatedValue("translationX");
            if (animatedValue2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(200420);
                throw tVar2;
            }
            a2.left = (float) ((Integer) animatedValue2).intValue();
            RectF a3 = c.a(this.Aah);
            Object animatedValue3 = valueAnimator.getAnimatedValue("translationY");
            if (animatedValue3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(200420);
                throw tVar3;
            }
            a3.top = (float) ((Integer) animatedValue3).intValue();
            RectF a4 = c.a(this.Aah);
            float f2 = c.a(this.Aah).left;
            float f3 = (float) this.Aah.mWidth;
            Object animatedValue4 = valueAnimator.getAnimatedValue("scaleX");
            if (animatedValue4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(200420);
                throw tVar4;
            }
            a4.right = (((Float) animatedValue4).floatValue() * f3) + f2;
            RectF a5 = c.a(this.Aah);
            float f4 = c.a(this.Aah).top;
            float f5 = (float) this.Aah.mHeight;
            Object animatedValue5 = valueAnimator.getAnimatedValue("scaleY");
            if (animatedValue5 == null) {
                t tVar5 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(200420);
                throw tVar5;
            }
            a5.bottom = (((Float) animatedValue5).floatValue() * f5) + f4;
            c cVar2 = this.Aah;
            Object animatedValue6 = valueAnimator.getAnimatedValue("bgAlpha");
            if (animatedValue6 == null) {
                t tVar6 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(200420);
                throw tVar6;
            }
            cVar2.pda = ((Integer) animatedValue6).intValue();
            this.Aah.postInvalidate();
            AppMethodBeat.o(200420);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView$startAnimation$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-multitask_release"})
    /* renamed from: com.tencent.mm.plugin.multitask.animation.b.c$c  reason: collision with other inner class name */
    public static final class C1506c extends AnimatorListenerAdapter {
        final /* synthetic */ c Aah;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1506c(c cVar) {
            this.Aah = cVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AnimatorListenerAdapter animatorListenerAdapter;
            AppMethodBeat.i(200421);
            p.h(animator, "animation");
            if (!(this.Aah.pdb == null || (animatorListenerAdapter = this.Aah.pdb) == null)) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
            this.Aah.setVisibility(8);
            AppMethodBeat.o(200421);
        }

        public final void onAnimationStart(Animator animator) {
            AnimatorListenerAdapter animatorListenerAdapter;
            AppMethodBeat.i(200422);
            p.h(animator, "animation");
            if (this.Aah.pdb == null || (animatorListenerAdapter = this.Aah.pdb) == null) {
                AppMethodBeat.o(200422);
                return;
            }
            animatorListenerAdapter.onAnimationStart(animator);
            AppMethodBeat.o(200422);
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(200423);
        p.h(canvas, "canvas");
        if (this.pcZ) {
            canvas.translate((float) this.pcU, 0.0f);
        } else {
            canvas.drawColor(Color.argb(this.pda, 0, 0, 0));
        }
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
        path2.addRoundRect(rectF, (float) this.pcV, (float) this.pcV, Path.Direction.CW);
        Path path3 = this.pcR;
        if (path3 == null) {
            p.btv("mClipPath");
        }
        canvas.clipPath(path3);
        Bitmap bitmap = this.pcQ;
        if (bitmap == null) {
            p.btv("mContentBitmap");
        }
        Rect rect = this.pcS;
        if (rect == null) {
            p.btv("mDrawRect");
        }
        Rect rect2 = this.Ky;
        if (rect2 == null) {
            p.btv("mDstRect");
        }
        canvas.drawBitmap(bitmap, rect, rect2, this.mPaint);
        AppMethodBeat.o(200423);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(200424);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
        AppMethodBeat.o(200424);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitask/animation/floatball/TransformToMultiTaskFBAnimationMaskView$Companion;", "", "()V", "TAG", "", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
