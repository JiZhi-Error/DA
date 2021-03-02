package com.tencent.mm.plugin.scanner.util;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.f.h;
import com.tencent.f.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J4\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J$\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0007J4\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J(\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019J0\u0010 \u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\n2\u0014\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u00060#H\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001e\u0010%\u001a\u0004\u0018\u00010\u00132\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/scanner/util/ScanViewUtils;", "", "()V", "TAG", "", "animateAlpha", "", "view", "Landroid/view/View;", "show", "", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "fromAlpha", "", "targetAlpha", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "convertToImageCoordinate", "Landroid/graphics/PointF;", "imageView", "x", "y", "Landroid/widget/ImageView;", "imageWidth", "", "imageHeight", "fitBitmapBottom", "bitmap", "Landroid/graphics/Bitmap;", "viewWidth", "viewHeight", "getBlurBitmap", "async", "callback", "Lkotlin/Function1;", "getRoundBitmap", "invertMapPoint", "matrix", "Landroid/graphics/Matrix;", "srcPoints", "", "scan-sdk_release"})
public final class m {
    public static final m CUv = new m();

    static {
        AppMethodBeat.i(194806);
        AppMethodBeat.o(194806);
    }

    private m() {
    }

    public static boolean a(Bitmap bitmap, ImageView imageView, int i2, int i3) {
        AppMethodBeat.i(194799);
        p.h(imageView, "imageView");
        if (bitmap == null || bitmap.isRecycled()) {
            imageView.setImageBitmap(null);
            AppMethodBeat.o(194799);
            return false;
        }
        imageView.setImageBitmap(bitmap);
        Matrix matrix = new Matrix();
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix imageMatrix = imageView.getImageMatrix();
        float width = (1.0f * ((float) i2)) / ((float) bitmap.getWidth());
        float height = ((float) i3) - (((float) bitmap.getHeight()) * width);
        Log.d("MicroMsg.ScanViewUtils", "alvinluo fitBitmapBottom bitmap: %d, %d, scale: %f, translationY: %f, width: %d, height: %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Float.valueOf(width), Float.valueOf(height), Integer.valueOf(i2), Integer.valueOf(i3));
        imageMatrix.postScale(width, width);
        imageMatrix.postTranslate(0.0f, height);
        matrix.set(imageMatrix);
        imageView.setImageMatrix(matrix);
        AppMethodBeat.o(194799);
        return true;
    }

    public static Bitmap ar(Bitmap bitmap) {
        AppMethodBeat.i(194800);
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    Bitmap roundedCornerBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) (bitmap.getWidth() > bitmap.getHeight() ? Math.floor((((double) bitmap.getWidth()) / 2.0d) + 0.5d) : Math.floor((((double) bitmap.getHeight()) / 2.0d) + 0.5d)));
                    AppMethodBeat.o(194800);
                    return roundedCornerBitmap;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ScanViewUtils", e2, "alvinluo decodeRoundBitmap exception", new Object[0]);
                AppMethodBeat.o(194800);
                return null;
            }
        }
        AppMethodBeat.o(194800);
        return bitmap;
    }

    public static final void a(View view, boolean z, Animator.AnimatorListener animatorListener) {
        float f2;
        float f3 = 1.0f;
        AppMethodBeat.i(194801);
        if (view == null) {
            AppMethodBeat.o(194801);
        } else if (z && view.getAlpha() != 0.0f) {
            Log.w("MicroMsg.ScanViewUtils", "alvinluo animateAlpha show ignore, view: %s", view);
            AppMethodBeat.o(194801);
        } else if (z || view.getAlpha() == 1.0f) {
            Log.v("MicroMsg.ScanViewUtils", "alvinluo animateAlpha show: %b, view: %s", Boolean.valueOf(z), view);
            a aVar = new a(animatorListener, view, z);
            view.setVisibility(0);
            if (z) {
                f2 = 0.0f;
            } else {
                f2 = 1.0f;
            }
            if (!z) {
                f3 = 0.0f;
            }
            a(view, f2, f3, 200, aVar);
            AppMethodBeat.o(194801);
        } else {
            Log.w("MicroMsg.ScanViewUtils", "alvinluo animateAlpha hide ignore, view: %s", view);
            AppMethodBeat.o(194801);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/util/ScanViewUtils$animateAlpha$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "scan-sdk_release"})
    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ Animator.AnimatorListener CPk;
        final /* synthetic */ View hCI;
        final /* synthetic */ boolean rti;

        a(Animator.AnimatorListener animatorListener, View view, boolean z) {
            this.CPk = animatorListener;
            this.hCI = view;
            this.rti = z;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(194793);
            p.h(animator, "animation");
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
                AppMethodBeat.o(194793);
                return;
            }
            AppMethodBeat.o(194793);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(194794);
            p.h(animator, "animation");
            this.hCI.setVisibility(this.rti ? 0 : 8);
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
                AppMethodBeat.o(194794);
                return;
            }
            AppMethodBeat.o(194794);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(194795);
            p.h(animator, "animation");
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
                AppMethodBeat.o(194795);
                return;
            }
            AppMethodBeat.o(194795);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(194796);
            p.h(animator, "animation");
            Animator.AnimatorListener animatorListener = this.CPk;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
                AppMethodBeat.o(194796);
                return;
            }
            AppMethodBeat.o(194796);
        }
    }

    public static final void a(View view, float f2, float f3, long j2, Animator.AnimatorListener animatorListener) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator listener2;
        ViewPropertyAnimator updateListener;
        AppMethodBeat.i(194802);
        Log.v("MicroMsg.ScanViewUtils", "alvinluo animateAlpha view: %s, fromAlpha: %s, targetAlpha: %s", view, Float.valueOf(f2), Float.valueOf(f3));
        if (!(view == null || (animate2 = view.animate()) == null || (listener2 = animate2.setListener(null)) == null || (updateListener = listener2.setUpdateListener(null)) == null)) {
            updateListener.cancel();
        }
        if (view != null) {
            view.setAlpha(f2);
        }
        if (view == null || (animate = view.animate()) == null || (alpha = animate.alpha(f3)) == null || (duration = alpha.setDuration(j2)) == null || (interpolator = duration.setInterpolator(new LinearInterpolator())) == null || (listener = interpolator.setListener(animatorListener)) == null) {
            AppMethodBeat.o(194802);
            return;
        }
        listener.start();
        AppMethodBeat.o(194802);
    }

    public static final void a(Bitmap bitmap, kotlin.g.a.b<? super Bitmap, x> bVar) {
        AppMethodBeat.i(194803);
        p.h(bVar, "callback");
        z.f fVar = new z.f();
        fVar.SYG = null;
        new b(fVar, bitmap, bVar).invoke();
        AppMethodBeat.o(194803);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Object> {
        final /* synthetic */ Bitmap cKG;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ z.f hLk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(z.f fVar, Bitmap bitmap, kotlin.g.a.b bVar) {
            super(0);
            this.hLk = fVar;
            this.cKG = bitmap;
            this.gWe = bVar;
        }

        @Override // kotlin.g.a.a
        public final Object invoke() {
            Integer num;
            Integer num2 = null;
            AppMethodBeat.i(194798);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.hLk.SYG = (T) BitmapUtil.fastBlurBitmap(this.cKG, 0.1f, 10, true, 200);
                Log.i("MicroMsg.ScanViewUtils", "alvinluo blurBitmap cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ScanViewUtils", e2, "blurBitmap exception", new Object[0]);
            }
            Object[] objArr = new Object[2];
            T t = this.hLk.SYG;
            if (t != null) {
                num = Integer.valueOf(t.getWidth());
            } else {
                num = null;
            }
            objArr[0] = num;
            T t2 = this.hLk.SYG;
            if (t2 != null) {
                num2 = Integer.valueOf(t2.getHeight());
            }
            objArr[1] = num2;
            Log.d("MicroMsg.ScanViewUtils", "alvinluo blurBitmap width: %s, height: %s", objArr);
            Thread currentThread = Thread.currentThread();
            Looper mainLooper = Looper.getMainLooper();
            p.g(mainLooper, "Looper.getMainLooper()");
            if (p.j(currentThread, mainLooper.getThread())) {
                Object invoke = this.gWe.invoke(this.hLk.SYG);
                AppMethodBeat.o(194798);
                return invoke;
            }
            d<?> aV = h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.scanner.util.m.b.AnonymousClass1 */
                final /* synthetic */ b CUw;

                {
                    this.CUw = r1;
                }

                public final void run() {
                    AppMethodBeat.i(194797);
                    this.CUw.gWe.invoke(this.CUw.hLk.SYG);
                    AppMethodBeat.o(194797);
                }
            });
            AppMethodBeat.o(194798);
            return aV;
        }
    }

    public static final PointF e(View view, float f2, float f3) {
        AppMethodBeat.i(194804);
        PointF pointF = new PointF(f2, f3);
        if (view instanceof g) {
            PointF c2 = ((g) view).c(pointF);
            AppMethodBeat.o(194804);
            return c2;
        }
        AppMethodBeat.o(194804);
        return null;
    }

    public static final PointF a(ImageView imageView, float f2, float f3, int i2, int i3) {
        int i4;
        int i5;
        PointF pointF;
        AppMethodBeat.i(194805);
        if (imageView == null) {
            AppMethodBeat.o(194805);
            return null;
        } else if (i2 <= 0 || i3 <= 0) {
            AppMethodBeat.o(194805);
            return null;
        } else {
            float[] fArr = {f2, f3};
            Matrix imageMatrix = imageView.getImageMatrix();
            Drawable drawable = imageView.getDrawable();
            Rect bounds = drawable != null ? drawable.getBounds() : null;
            if (bounds != null) {
                i4 = bounds.width();
            } else {
                i4 = i2;
            }
            if (bounds != null) {
                i5 = bounds.height();
            } else {
                i5 = i3;
            }
            if (imageMatrix == null) {
                pointF = null;
            } else {
                Matrix matrix = new Matrix();
                if (!imageMatrix.invert(matrix)) {
                    Log.e("MicroMsg.ScanViewUtils", "invertMapPoint invert matrix failed");
                    pointF = null;
                } else {
                    float[] fArr2 = new float[2];
                    matrix.mapPoints(fArr2, fArr);
                    pointF = new PointF(fArr2[0], fArr2[1]);
                }
            }
            if (pointF != null) {
                pointF.x /= (float) i4;
                pointF.y /= (float) i5;
                Log.i("MicroMsg.ScanViewUtils", "alvinluo convertScreenToImageCoordinate screenCoordinate x: %s, y: %s, imageCoordinate: %s, imageWidth: %s, imageHeight: %s, show: %s, %s", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), pointF, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            }
            AppMethodBeat.o(194805);
            return pointF;
        }
    }
}
