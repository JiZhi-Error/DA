package com.tencent.tencentmap.mapsdk.vector.compat.utils.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c;
import java.util.ArrayList;

public class MarkerTranslateAnimator extends OverlayAnimator {

    /* renamed from: a  reason: collision with root package name */
    private LatLng[] f2842a;

    /* renamed from: b  reason: collision with root package name */
    private double[] f2843b;

    /* renamed from: c  reason: collision with root package name */
    private double f2844c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2845d;

    /* renamed from: e  reason: collision with root package name */
    private AnimatorSet f2846e;

    /* renamed from: f  reason: collision with root package name */
    private c f2847f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f2848g;

    public MarkerTranslateAnimator(Marker marker, long j2, LatLng[] latLngArr) {
        this(marker, j2, latLngArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarkerTranslateAnimator(Marker marker, long j2, LatLng[] latLngArr, boolean z) {
        super(marker, j2);
        AppMethodBeat.i(199627);
        this.f2848g = false;
        if (latLngArr == null) {
            AppMethodBeat.o(199627);
            return;
        }
        this.f2842a = latLngArr;
        this.f2843b = new double[(latLngArr.length - 1)];
        this.f2847f = new c();
        for (int i2 = 0; i2 < latLngArr.length - 1; i2++) {
            this.f2843b[i2] = this.f2847f.a(latLngArr[i2], latLngArr[i2 + 1]);
            this.f2844c += this.f2843b[i2];
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < latLngArr.length - 1; i3++) {
            arrayList.add(createSegmentAnimator(i3));
        }
        getAnimatorSet().playSequentially(arrayList);
        this.f2845d = z;
        if (z) {
            a();
        }
        AppMethodBeat.o(199627);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.OverlayAnimator
    public ValueAnimator createSegmentAnimator(final int i2) {
        AppMethodBeat.i(199628);
        final b a2 = this.f2847f.a(this.f2842a[i2]);
        final b a3 = this.f2847f.a(this.f2842a[i2 + 1]);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration((long) ((((double) getDuration()) * this.f2843b[i2]) / this.f2844c));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setFloatValues((float) this.f2843b[i2]);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.MarkerTranslateAnimator.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(199626);
                if (a2.equals(a3)) {
                    AppMethodBeat.o(199626);
                    return;
                }
                double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
                double d2 = a2.f2832a + (((a3.f2832a - a2.f2832a) * parseDouble) / MarkerTranslateAnimator.this.f2843b[i2]);
                double d3 = a2.f2833b + ((parseDouble * (a3.f2833b - a2.f2833b)) / MarkerTranslateAnimator.this.f2843b[i2]);
                if (MarkerTranslateAnimator.this.getObject() == null) {
                    AppMethodBeat.o(199626);
                    return;
                }
                ((Marker) MarkerTranslateAnimator.this.getObject()).setPosition(MarkerTranslateAnimator.this.f2847f.a(new b(d2, d3)));
                AppMethodBeat.o(199626);
            }
        });
        AppMethodBeat.o(199628);
        return valueAnimator;
    }

    private void a() {
        float f2;
        int i2;
        int i3;
        long j2;
        long abs;
        float f3;
        AppMethodBeat.i(199629);
        this.f2846e = new AnimatorSet();
        this.f2846e.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.MarkerTranslateAnimator.AnonymousClass2 */

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(199624);
                MarkerTranslateAnimator.this.f2848g = false;
                AppMethodBeat.o(199624);
            }

            public void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(199625);
                MarkerTranslateAnimator.this.f2848g = false;
                AppMethodBeat.o(199625);
            }

            public void onAnimationRepeat(Animator animator) {
            }
        });
        ArrayList arrayList = new ArrayList();
        int i4 = 1;
        float f4 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        long j3 = 0;
        while (i4 < this.f2842a.length) {
            if (!this.f2842a[i6].equals(this.f2842a[i4])) {
                b a2 = this.f2847f.a(this.f2842a[i5]);
                b a3 = this.f2847f.a(this.f2842a[i6]);
                b a4 = this.f2847f.a(this.f2842a[i4]);
                float a5 = (float) a(a3.f2832a - a2.f2832a, a2.f2833b - a3.f2833b, a4.f2832a - a3.f2832a, a3.f2833b - a4.f2833b);
                if (arrayList.size() != 0) {
                    abs = (long) (((((((double) Math.abs(a5)) * 3.141592653589793d) * 6.0d) / 180.0d) * ((double) getDuration())) / this.f2844c);
                    j2 = a(i5, i6) - (abs / 2);
                    f3 = f4;
                } else if (getObject() == null) {
                    AppMethodBeat.o(199629);
                    return;
                } else {
                    float rotation = ((Marker) getObject()).getRotation();
                    a5 = ((float) a(0.0d, 1.0d, a4.f2832a - a3.f2832a, a3.f2833b - a4.f2833b)) - rotation;
                    abs = 0;
                    f3 = rotation;
                    j2 = j3;
                }
                float f5 = f3 + a5;
                arrayList.add(a(f3, f5, abs, j2));
                f2 = f5;
                i2 = i6;
                i3 = i4;
            } else {
                f2 = f4;
                i2 = i5;
                i3 = i6;
                j2 = j3;
            }
            i4++;
            f4 = f2;
            i5 = i2;
            i6 = i3;
            j3 = j2;
        }
        this.f2846e.playSequentially(arrayList);
        AppMethodBeat.o(199629);
    }

    private double a(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(199630);
        double sqrt = ((d2 * d4) + (d3 * d5)) / (Math.sqrt((d2 * d2) + (d3 * d3)) * Math.sqrt((d4 * d4) + (d5 * d5)));
        if (Double.isNaN(sqrt)) {
            AppMethodBeat.o(199630);
            return 0.0d;
        }
        if (sqrt < -1.0d) {
            sqrt = -1.0d;
        }
        if (sqrt > 1.0d) {
            sqrt = 1.0d;
        }
        double acos = (Math.acos(sqrt) * 180.0d) / 3.141592653589793d;
        if ((d2 * d5) - (d3 * d4) > 0.0d) {
            acos = -acos;
        }
        double d6 = (double) ((float) acos);
        AppMethodBeat.o(199630);
        return d6;
    }

    private long a(int i2, int i3) {
        AppMethodBeat.i(199631);
        double d2 = 0.0d;
        while (i2 < i3) {
            d2 += this.f2843b[i2];
            i2++;
        }
        long duration = (long) ((d2 * ((double) getDuration())) / this.f2844c);
        AppMethodBeat.o(199631);
        return duration;
    }

    private ValueAnimator a(float f2, float f3, long j2, long j3) {
        AppMethodBeat.i(199632);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        ofFloat.setDuration(j2);
        ofFloat.setStartDelay(j3);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.MarkerTranslateAnimator.AnonymousClass3 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(199636);
                double parseDouble = Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue()));
                if (MarkerTranslateAnimator.this.getObject() == null) {
                    AppMethodBeat.o(199636);
                    return;
                }
                ((Marker) MarkerTranslateAnimator.this.getObject()).setRotation((float) parseDouble);
                AppMethodBeat.o(199636);
            }
        });
        AppMethodBeat.o(199632);
        return ofFloat;
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.OverlayAnimator
    public void startAnimation() {
        AppMethodBeat.i(199633);
        super.startAnimation();
        synchronized (this) {
            try {
                if (this.f2845d && this.f2846e != null && !this.f2848g) {
                    this.f2848g = true;
                    this.f2846e.start();
                }
            } finally {
                AppMethodBeat.o(199633);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.OverlayAnimator
    public void cancelAnimation() {
        AppMethodBeat.i(199634);
        super.cancelAnimation();
        synchronized (this) {
            try {
                if (this.f2845d && this.f2846e != null) {
                    this.f2846e.cancel();
                }
            } finally {
                AppMethodBeat.o(199634);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.vector.compat.utils.animation.OverlayAnimator
    public void endAnimation() {
        AppMethodBeat.i(199635);
        super.endAnimation();
        synchronized (this) {
            try {
                if (this.f2845d && this.f2846e != null) {
                    this.f2846e.end();
                }
            } finally {
                AppMethodBeat.o(199635);
            }
        }
    }
}
