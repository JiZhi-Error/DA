package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.ArrayList;
import java.util.List;

public final class b extends View {
    private Paint lSU;
    boolean mInited = false;
    private Paint mPaint = new Paint();
    boolean nmN;
    final List<c> oZd = new ArrayList();
    private float oZe;
    private float oZf;
    private float oZg;
    private int oZh = 0;
    private Runnable oZi;
    private Paint oZj;
    List<d> oZk;

    /* access modifiers changed from: package-private */
    public interface c {
        PointF cjl();

        d cjn();

        int getAlpha();

        float getRadius();
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(106395);
        this.mPaint.setAntiAlias(true);
        this.oZj = new Paint();
        this.oZj.setAntiAlias(true);
        this.lSU = new Paint();
        this.lSU.setAntiAlias(true);
        this.lSU.setColor(context.getResources().getColor(R.color.ra));
        this.lSU.setStyle(Paint.Style.STROKE);
        this.lSU.setStrokeWidth(1.0f);
        AppMethodBeat.o(106395);
    }

    public final void a(final List<d> list, final int i2, final int i3, final int i4) {
        AppMethodBeat.i(106396);
        Log.i("MicroMsg.FloatBallCrescentView", "setIconInfoList size:%d newChangeIndex:%d", Integer.valueOf(list.size()), Integer.valueOf(i4));
        this.mInited = false;
        this.oZk = list;
        this.oZi = new Runnable() {
            /* class com.tencent.mm.plugin.ball.view.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(106383);
                b.a(b.this, list, i4, i2, i3);
                b.this.mInited = true;
                b.this.oZi = null;
                AppMethodBeat.o(106383);
            }
        };
        if (this.oZe > 0.0f) {
            Log.i("MicroMsg.FloatBallCrescentView", "setIconInfoList, run pending init");
            this.oZi.run();
        }
        AppMethodBeat.o(106396);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(106397);
        super.onDraw(canvas);
        int size = this.oZd.size();
        if (size == 2) {
            a(canvas, this.oZd.get(1), this.oZd.get(0));
            a(canvas, this.oZd.get(0), true);
            AppMethodBeat.o(106397);
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.oZd.get(i2);
            c cVar2 = i2 + -1 < 0 ? this.oZd.get(size - 1) : this.oZd.get(i2 - 1);
            if (size < 3) {
                a(canvas, cVar, size != 1);
            } else {
                a(canvas, cVar, cVar2);
            }
        }
        AppMethodBeat.o(106397);
    }

    private List<PointF> c(float f2, float f3, int i2) {
        AppMethodBeat.i(106398);
        float f4 = this.oZe - f2;
        ArrayList arrayList = new ArrayList();
        if (i2 == 1) {
            arrayList.add(new PointF(f2 + f4, f2 + f4));
            AppMethodBeat.o(106398);
            return arrayList;
        }
        double d2 = 6.283185307179586d / ((double) i2);
        double d3 = ((double) (f2 - f3)) - 1.0d;
        double d4 = i2 >= 3 ? 1.5707963267948966d : 3.141592653589793d;
        for (int i3 = 0; i3 < i2; i3++) {
            d4 += d2;
            arrayList.add(new PointF((f2 - ((float) (Math.cos(d4) * d3))) + f4, (f2 - ((float) (Math.sin(d4) * d3))) + f4));
        }
        AppMethodBeat.o(106398);
        return arrayList;
    }

    private void a(Canvas canvas, c cVar, boolean z) {
        AppMethodBeat.i(106399);
        d cjn = cVar.cjn();
        PointF cjl = cVar.cjl();
        float radius = cVar.getRadius();
        if (radius == 0.0f) {
            AppMethodBeat.o(106399);
            return;
        }
        this.mPaint.setAlpha(cVar.getAlpha());
        this.oZj.setAlpha(cVar.getAlpha());
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        canvas.drawCircle(cjl.x, cjl.y, radius, this.mPaint);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        a(canvas, this.mPaint, cjn, cjl, radius);
        this.mPaint.setXfermode(null);
        if (z) {
            canvas.drawCircle(cjl.x, cjl.y, 0.5f + radius, this.lSU);
        }
        canvas.restoreToCount(saveLayer);
        AppMethodBeat.o(106399);
    }

    private void a(Canvas canvas, c cVar, c cVar2) {
        AppMethodBeat.i(106400);
        d cjn = cVar.cjn();
        PointF cjl = cVar.cjl();
        float radius = cVar.getRadius();
        PointF cjl2 = cVar2.cjl();
        float radius2 = cVar2.getRadius();
        if (radius <= 0.0f) {
            AppMethodBeat.o(106400);
            return;
        }
        this.mPaint.setAlpha(cVar.getAlpha());
        this.oZj.setAlpha(cVar.getAlpha());
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        canvas.drawCircle(cjl.x, cjl.y, radius, this.mPaint);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        a(canvas, this.mPaint, cjn, cjl, radius);
        this.mPaint.setXfermode(null);
        canvas.drawCircle(cjl.x, cjl.y, 0.5f + radius, this.lSU);
        if (radius2 > 0.0f) {
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawCircle(cjl2.x, cjl2.y, 4.0f + radius2 + 0.5f, this.mPaint);
            this.mPaint.setXfermode(null);
        }
        canvas.restoreToCount(saveLayer);
        AppMethodBeat.o(106400);
    }

    private void a(Canvas canvas, Paint paint, d dVar, PointF pointF, float f2) {
        AppMethodBeat.i(106401);
        if (!dVar.isValid()) {
            Log.i("MicroMsg.FloatBallCrescentView", "drawTheIcon, invalid icon info");
            AppMethodBeat.o(106401);
            return;
        }
        if (dVar.bitmap != null && !dVar.bitmap.isRecycled()) {
            a(canvas, paint, dVar.bitmap, pointF, f2);
        }
        if (dVar.oZx != 0) {
            this.oZj.setARGB(this.oZh, Color.red(dVar.oZx), Color.green(dVar.oZx), Color.blue(dVar.oZx));
        } else {
            this.oZj.setARGB(0, 0, 0, 0);
        }
        canvas.drawCircle(pointF.x, pointF.y, f2, this.oZj);
        AppMethodBeat.o(106401);
    }

    private static void a(Canvas canvas, Paint paint, Bitmap bitmap, PointF pointF, float f2) {
        AppMethodBeat.i(106402);
        float width = f2 / (((float) bitmap.getWidth()) / 2.0f);
        canvas.save();
        canvas.translate(pointF.x - f2, pointF.y - f2);
        canvas.scale(width, width);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.restore();
        AppMethodBeat.o(106402);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(106403);
        super.onMeasure(i2, i3);
        this.oZe = ((float) View.MeasureSpec.getSize(i2)) / 2.0f;
        if (this.oZi != null) {
            Log.i("MicroMsg.FloatBallCrescentView", "onMeasure, run pending init");
            this.oZi.run();
        }
        AppMethodBeat.o(106403);
    }

    /* access modifiers changed from: package-private */
    public static final class d {
        Bitmap bitmap;
        int oZx = 0;

        d() {
        }

        /* access modifiers changed from: package-private */
        public final boolean isValid() {
            AppMethodBeat.i(106391);
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                AppMethodBeat.o(106391);
                return false;
            }
            AppMethodBeat.o(106391);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ball.view.b$b  reason: collision with other inner class name */
    static abstract class AbstractC0853b implements c {
        private final d oZw;

        /* synthetic */ AbstractC0853b(d dVar, byte b2) {
            this(dVar);
        }

        private AbstractC0853b(d dVar) {
            this.oZw = dVar;
        }

        @Override // com.tencent.mm.plugin.ball.view.b.c
        public final d cjn() {
            return this.oZw;
        }
    }

    /* access modifiers changed from: package-private */
    public static class e extends AbstractC0853b {
        final float auL;
        final PointF oZq;

        /* synthetic */ e(d dVar, PointF pointF, float f2, byte b2) {
            this(dVar, pointF, f2);
        }

        private e(d dVar, PointF pointF, float f2) {
            super(dVar, (byte) 0);
            this.oZq = pointF;
            this.auL = f2;
        }

        @Override // com.tencent.mm.plugin.ball.view.b.c
        public final PointF cjl() {
            return this.oZq;
        }

        @Override // com.tencent.mm.plugin.ball.view.b.c
        public final float getRadius() {
            return this.auL;
        }

        @Override // com.tencent.mm.plugin.ball.view.b.c
        public final int getAlpha() {
            return 255;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends AbstractC0853b {
        protected float auL;
        protected final PointF oZq;
        final String oZr;
        final String oZs;
        final String oZt;
        protected final List<PropertyValuesHolder> oZu;

        /* synthetic */ a(d dVar, PointF pointF, float f2, PointF pointF2, float f3, byte b2) {
            this(dVar, pointF, f2, pointF2, f3);
        }

        private a(d dVar, PointF pointF, float f2, PointF pointF2, float f3) {
            super(dVar, (byte) 0);
            AppMethodBeat.i(106389);
            this.oZu = new ArrayList();
            this.oZq = pointF2;
            this.oZr = String.format("x#%d", Integer.valueOf(hashCode()));
            this.oZs = String.format("y#%d", Integer.valueOf(hashCode()));
            this.oZt = String.format("r#%d", Integer.valueOf(hashCode()));
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(this.oZr, pointF2.x, pointF.x);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(this.oZs, pointF2.y, pointF.y);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(this.oZt, f3, f2);
            this.oZu.add(ofFloat);
            this.oZu.add(ofFloat2);
            this.oZu.add(ofFloat3);
            AppMethodBeat.o(106389);
        }

        @Override // com.tencent.mm.plugin.ball.view.b.c
        public final PointF cjl() {
            return this.oZq;
        }

        @Override // com.tencent.mm.plugin.ball.view.b.c
        public final float getRadius() {
            return this.auL;
        }

        @Override // com.tencent.mm.plugin.ball.view.b.c
        public int getAlpha() {
            return 255;
        }

        public final List<PropertyValuesHolder> cjm() {
            return this.oZu;
        }

        public void setAnimator(ValueAnimator valueAnimator) {
            AppMethodBeat.i(106390);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.ball.view.b.a.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(106388);
                    a.this.oZq.x = ((Float) valueAnimator.getAnimatedValue(a.this.oZr)).floatValue();
                    a.this.oZq.y = ((Float) valueAnimator.getAnimatedValue(a.this.oZs)).floatValue();
                    a.this.auL = ((Float) valueAnimator.getAnimatedValue(a.this.oZt)).floatValue();
                    AppMethodBeat.o(106388);
                }
            });
            AppMethodBeat.o(106390);
        }
    }

    /* access modifiers changed from: package-private */
    public static class f extends a {
        int mAlpha;
        final String oZy;

        /* synthetic */ f(d dVar, PointF pointF, float f2, PointF pointF2, byte b2) {
            this(dVar, pointF, f2, pointF2);
        }

        private f(d dVar, PointF pointF, float f2, PointF pointF2) {
            super(dVar, pointF, f2, pointF2, 0.0f, (byte) 0);
            AppMethodBeat.i(106393);
            this.oZy = String.format("a#%d", Integer.valueOf(hashCode()));
            this.oZu.add(PropertyValuesHolder.ofInt(this.oZy, 0, 255));
            AppMethodBeat.o(106393);
        }

        @Override // com.tencent.mm.plugin.ball.view.b.a, com.tencent.mm.plugin.ball.view.b.c
        public final int getAlpha() {
            return this.mAlpha;
        }

        @Override // com.tencent.mm.plugin.ball.view.b.a
        public final void setAnimator(ValueAnimator valueAnimator) {
            AppMethodBeat.i(106394);
            super.setAnimator(valueAnimator);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.ball.view.b.f.AnonymousClass1 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(106392);
                    f.this.mAlpha = ((Integer) valueAnimator.getAnimatedValue(f.this.oZy)).intValue();
                    AppMethodBeat.o(106392);
                }
            });
            AppMethodBeat.o(106394);
        }
    }

    static /* synthetic */ void a(b bVar, List list, int i2, int i3, int i4) {
        boolean z;
        int i5;
        f aVar;
        AppMethodBeat.i(106404);
        float f2 = bVar.oZg;
        float f3 = bVar.oZf;
        bVar.oZg = ((float) i3) / 2.0f;
        bVar.oZf = ((float) i4) / 2.0f;
        int size = list.size();
        if (size < 3) {
            bVar.oZh = 0;
        } else if (size == 3) {
            bVar.oZh = TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
        } else if (size == 4) {
            bVar.oZh = 204;
        } else if (size >= 5) {
            bVar.oZh = 255;
        }
        Log.i("MicroMsg.FloatBallCrescentView", "init, size:%s, newChangeIndex", Integer.valueOf(size), Integer.valueOf(i2));
        if (bVar.oZd.size() < size) {
            z = true;
        } else {
            z = false;
        }
        int size2 = list.size();
        List<PointF> c2 = bVar.c(bVar.oZf, bVar.oZg, size2);
        Log.i("MicroMsg.FloatBallCrescentView", "constructCrescentPaintInfo, newChangeIndex:%s", Integer.valueOf(i2));
        if (i2 != Integer.MIN_VALUE) {
            int size3 = list.size();
            ArrayList arrayList = new ArrayList();
            if (z) {
                Log.i("MicroMsg.FloatBallCrescentView", "constructAnimatedCrescentPaintInfo, is new add");
                List<PointF> c3 = bVar.c(f3, f2, size3 - 1);
                bVar.oZd.clear();
                int i6 = 0;
                while (i6 < size3) {
                    if (i6 == i2) {
                        aVar = new f((d) list.get(i6), c2.get(i6), bVar.oZg, c2.get(i6), (byte) 0);
                    } else {
                        aVar = new a((d) list.get(i6), c2.get(i6), bVar.oZg, c3.get(i6 < i2 ? i6 : i6 - 1), f2, (byte) 0);
                    }
                    arrayList.addAll(aVar.cjm());
                    bVar.oZd.add(aVar);
                    i6++;
                }
            } else {
                Log.i("MicroMsg.FloatBallCrescentView", "constructAnimatedCrescentPaintInfo, not new add");
                List<PointF> c4 = bVar.c(f3, f2, size3 + 1);
                bVar.oZd.clear();
                for (int i7 = 0; i7 < size3; i7++) {
                    if (i7 >= i2) {
                        i5 = i7 + 1;
                    } else {
                        i5 = i7;
                    }
                    a aVar2 = new a((d) list.get(i7), c2.get(i7), bVar.oZg, c4.get(i5), f2, (byte) 0);
                    arrayList.addAll(aVar2.cjm());
                    bVar.oZd.add(aVar2);
                }
            }
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder((PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
            for (int i8 = 0; i8 < bVar.oZd.size(); i8++) {
                ((a) bVar.oZd.get(i8)).setAnimator(ofPropertyValuesHolder);
            }
            ofPropertyValuesHolder.setDuration(size3 == 1 ? 300 : 500);
            ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.ball.view.b.AnonymousClass2 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(106384);
                    b.this.postInvalidate();
                    AppMethodBeat.o(106384);
                }
            });
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.ball.view.b.AnonymousClass3 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(106385);
                    b.this.nmN = true;
                    AppMethodBeat.o(106385);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(106386);
                    b.this.nmN = false;
                    AppMethodBeat.o(106386);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(106387);
                    b.this.nmN = false;
                    AppMethodBeat.o(106387);
                }
            });
            ofPropertyValuesHolder.start();
        } else {
            bVar.oZd.clear();
            for (int i9 = 0; i9 < size2; i9++) {
                bVar.oZd.add(new e((d) list.get(i9), c2.get(i9), bVar.oZg, (byte) 0));
            }
        }
        bVar.requestLayout();
        bVar.invalidate();
        AppMethodBeat.o(106404);
    }
}
