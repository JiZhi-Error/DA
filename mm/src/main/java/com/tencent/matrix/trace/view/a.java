package com.tencent.matrix.trace.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.tencent.matrix.b.c;
import com.tencent.matrix.trace.e.b;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.view.FloatFrameView;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class a extends b implements c {
    private static Handler aDv = new Handler(Looper.getMainLooper());
    private static a deb;
    private static final Object lock = new Object();
    private DisplayMetrics aJm;
    private long dcS;
    private int[] dcV;
    private int ddO;
    private int ddP;
    private int ddQ;
    private int ddR;
    private int ddS;
    private WindowManager.LayoutParams ddY;
    public boolean ddZ;
    private FloatFrameView dea;
    public View.OnClickListener dec;
    public boolean ded;
    private float dee;
    private float def;
    private long[] deg;
    private long deh;
    private int dei;
    private long[] dej;
    private int[] dek;
    private String del;
    private Runnable dem;
    private Executor executor;
    private Handler handler;
    private WindowManager windowManager;

    /* synthetic */ a(Context context, FloatFrameView floatFrameView, byte b2) {
        this(context, floatFrameView);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private a(Context context, final FloatFrameView floatFrameView) {
        this.aJm = new DisplayMetrics();
        this.ded = true;
        this.deg = new long[1];
        this.dei = this.ddO;
        this.dej = new long[1];
        this.dcV = new int[c.b.values().length];
        this.dek = new int[c.b.values().length];
        this.del = BuildConfig.KINDA_DEFAULT;
        this.dem = new Runnable() {
            /* class com.tencent.matrix.trace.view.a.AnonymousClass3 */

            public final void run() {
                a.this.dea.ddq.setText(String.format("%.2f FPS", Float.valueOf(a.this.def)));
                a.this.dea.ddq.setTextColor(a.this.dea.getResources().getColor(R.color.wl));
            }
        };
        this.executor = new Executor() {
            /* class com.tencent.matrix.trace.view.a.AnonymousClass5 */

            public final void execute(Runnable runnable) {
                a.h(a.this).post(runnable);
            }
        };
        this.dee = (1.0f * ((float) com.tencent.matrix.trace.core.b.Tw().cPm)) / 1000000.0f;
        this.def = (float) Math.round(1000.0f / this.dee);
        this.dea = floatFrameView;
        floatFrameView.ddq.setText(String.format("%.2f FPS", Float.valueOf(this.def)));
        this.ddO = context.getResources().getColor(R.color.wl);
        this.ddP = context.getResources().getColor(R.color.wp);
        this.ddQ = context.getResources().getColor(R.color.wo);
        this.ddR = context.getResources().getColor(R.color.wn);
        this.ddS = context.getResources().getColor(R.color.wm);
        com.tencent.matrix.a.INSTANCE.a(this);
        floatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            /* class com.tencent.matrix.trace.view.a.AnonymousClass1 */

            public final void onViewAttachedToWindow(View view) {
                com.tencent.matrix.trace.a aVar;
                com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
                if (com.tencent.matrix.b.isInstalled() && (aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)) != null) {
                    aVar.daF.a(a.this);
                }
            }

            public final void onViewDetachedFromWindow(View view) {
                com.tencent.matrix.trace.a aVar;
                com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
                if (com.tencent.matrix.b.isInstalled() && (aVar = (com.tencent.matrix.trace.a) com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)) != null) {
                    aVar.daF.b(a.this);
                }
            }
        });
        this.windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (this.windowManager.getDefaultDisplay() != null) {
                this.windowManager.getDefaultDisplay().getMetrics(this.aJm);
                this.windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            this.ddY = new WindowManager.LayoutParams();
            if (Build.VERSION.SDK_INT >= 26) {
                this.ddY.type = 2038;
            } else {
                this.ddY.type = 2002;
            }
            this.ddY.flags = 40;
            this.ddY.gravity = 8388659;
            if (this.dea != null) {
                this.ddY.x = displayMetrics.widthPixels - (this.dea.getLayoutParams().width * 2);
            }
            this.ddY.y = 0;
            this.ddY.width = -2;
            this.ddY.height = -2;
            this.ddY.format = -2;
        } catch (Exception e2) {
        }
        floatFrameView.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.matrix.trace.view.a.AnonymousClass2 */
            float deo = 0.0f;
            float dep = 0.0f;
            int deq = 0;
            int der = 0;

            public final boolean onTouch(final View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.deo = motionEvent.getX();
                        this.dep = motionEvent.getY();
                        this.deq = a.this.ddY.x;
                        this.der = a.this.ddY.y;
                        break;
                    case 1:
                        int[] iArr = new int[2];
                        iArr[0] = a.this.ddY.x;
                        iArr[1] = a.this.ddY.x > a.this.aJm.widthPixels / 2 ? a.this.aJm.widthPixels - floatFrameView.getWidth() : 0;
                        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("trans", iArr));
                        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.matrix.trace.view.a.AnonymousClass2.AnonymousClass1 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (a.this.ddZ) {
                                    a.this.ddY.x = ((Integer) valueAnimator.getAnimatedValue("trans")).intValue();
                                    a.this.windowManager.updateViewLayout(view, a.this.ddY);
                                }
                            }
                        });
                        ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
                        ofPropertyValuesHolder.setDuration(180L).start();
                        int i2 = a.this.ddY.x;
                        int i3 = a.this.ddY.y;
                        if (Math.abs(i2 - this.deq) <= 20 && Math.abs(i3 - this.der) <= 20 && a.this.dec != null) {
                            a.this.dec.onClick(view);
                            break;
                        }
                    case 2:
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        WindowManager.LayoutParams layoutParams = a.this.ddY;
                        layoutParams.x = (int) (((x - this.deo) / 3.0f) + ((float) layoutParams.x));
                        WindowManager.LayoutParams layoutParams2 = a.this.ddY;
                        layoutParams2.y = (int) (((y - this.dep) / 3.0f) + ((float) layoutParams2.y));
                        if (view != null) {
                            a.this.windowManager.updateViewLayout(view, a.this.ddY);
                            break;
                        }
                        break;
                }
                return true;
            }
        });
    }

    @Override // com.tencent.matrix.trace.e.b
    public final void a(String str, long j2, long j3, int i2, boolean z, long j4, long j5, long j6, long j7) {
        super.a(str, j2, j3, i2, z, j4, j5, j6, j7);
        if (!Objects.equals(str, this.del)) {
            this.dcV = new int[c.b.values().length];
            this.del = str;
            this.deg[0] = 0;
            this.dej[0] = 0;
        }
        this.dcS = (long) (((float) this.dcS) + (((float) (i2 + 1)) * this.dee));
        this.deh++;
        float f2 = (float) (this.dcS - this.deg[0]);
        if (i2 >= 42) {
            int[] iArr = this.dcV;
            int i3 = c.b.DROPPED_FROZEN.index;
            iArr[i3] = iArr[i3] + 1;
            int[] iArr2 = this.dek;
            int i4 = c.b.DROPPED_FROZEN.index;
            iArr2[i4] = iArr2[i4] + 1;
            this.dei = this.ddS;
        } else if (i2 >= 24) {
            int[] iArr3 = this.dcV;
            int i5 = c.b.DROPPED_HIGH.index;
            iArr3[i5] = iArr3[i5] + 1;
            int[] iArr4 = this.dek;
            int i6 = c.b.DROPPED_HIGH.index;
            iArr4[i6] = iArr4[i6] + 1;
            if (this.dei != this.ddS) {
                this.dei = this.ddR;
            }
        } else if (i2 >= 9) {
            int[] iArr5 = this.dcV;
            int i7 = c.b.DROPPED_MIDDLE.index;
            iArr5[i7] = iArr5[i7] + 1;
            int[] iArr6 = this.dek;
            int i8 = c.b.DROPPED_MIDDLE.index;
            iArr6[i8] = iArr6[i8] + 1;
            if (!(this.dei == this.ddS || this.dei == this.ddR)) {
                this.dei = this.ddQ;
            }
        } else if (i2 >= 3) {
            int[] iArr7 = this.dcV;
            int i9 = c.b.DROPPED_NORMAL.index;
            iArr7[i9] = iArr7[i9] + 1;
            int[] iArr8 = this.dek;
            int i10 = c.b.DROPPED_NORMAL.index;
            iArr8[i10] = iArr8[i10] + 1;
            if (!(this.dei == this.ddS || this.dei == this.ddR || this.dei == this.ddQ)) {
                this.dei = this.ddP;
            }
        } else {
            int[] iArr9 = this.dcV;
            int i11 = c.b.DROPPED_BEST.index;
            iArr9[i11] = iArr9[i11] + 1;
            int[] iArr10 = this.dek;
            int i12 = c.b.DROPPED_BEST.index;
            iArr10[i12] = iArr10[i12] + 1;
            if (!(this.dei == this.ddS || this.dei == this.ddR || this.dei == this.ddQ || this.dei == this.ddP)) {
                this.dei = this.ddO;
            }
        }
        long j8 = this.deh - this.dej[0];
        if (f2 >= 200.0f) {
            final float min = Math.min(this.def, (((float) j8) * 1000.0f) / f2);
            final FloatFrameView floatFrameView = this.dea;
            final int i13 = this.dei;
            int i14 = this.dcV[c.b.DROPPED_NORMAL.index];
            int i15 = this.dcV[c.b.DROPPED_MIDDLE.index];
            int i16 = this.dcV[c.b.DROPPED_HIGH.index];
            int i17 = this.dcV[c.b.DROPPED_FROZEN.index];
            int i18 = this.dek[c.b.DROPPED_NORMAL.index];
            int i19 = this.dek[c.b.DROPPED_MIDDLE.index];
            int i20 = this.dek[c.b.DROPPED_HIGH.index];
            int i21 = this.dek[c.b.DROPPED_FROZEN.index];
            int i22 = i14 + i15 + i16 + i17;
            float f3 = i22 <= 0 ? 0.0f : ((((float) i17) * 1.0f) / ((float) i22)) * 60.0f;
            float f4 = i22 <= 0 ? 0.0f : ((1.0f * ((float) i16)) / ((float) i22)) * 25.0f;
            float f5 = i22 <= 0 ? 0.0f : ((1.0f * ((float) i15)) / ((float) i22)) * 14.0f;
            float f6 = i22 <= 0 ? 0.0f : ((1.0f * ((float) i14)) / ((float) i22)) * 1.0f;
            float f7 = f3 + f4 + f5 + f6;
            int i23 = i18 + i19 + i20 + i21;
            float f8 = i23 <= 0 ? 0.0f : ((1.0f * ((float) i21)) / ((float) i23)) * 60.0f;
            float f9 = i23 <= 0 ? 0.0f : ((1.0f * ((float) i20)) / ((float) i23)) * 25.0f;
            float f10 = i23 <= 0 ? 0.0f : ((1.0f * ((float) i19)) / ((float) i23)) * 14.0f;
            float f11 = i23 <= 0 ? 0.0f : ((1.0f * ((float) i18)) / ((float) i23)) * 1.0f;
            final String format = String.format("%.1f", Float.valueOf(f3));
            final String format2 = String.format("%.1f", Float.valueOf(f4));
            final String format3 = String.format("%.1f", Float.valueOf(f5));
            final String format4 = String.format("%.1f", Float.valueOf(f6));
            final String format5 = String.format("current: %.1f", Float.valueOf(f7));
            final String format6 = String.format("%.1f", Float.valueOf(f8));
            final String format7 = String.format("%.1f", Float.valueOf(f9));
            final String format8 = String.format("%.1f", Float.valueOf(f10));
            final String format9 = String.format("%.1f", Float.valueOf(f11));
            final String format10 = String.format("sum: %.1f", Float.valueOf(f8 + f9 + f10 + f11));
            final String format11 = String.format("%.2f FPS", Float.valueOf(min));
            aDv.post(new Runnable() {
                /* class com.tencent.matrix.trace.view.a.AnonymousClass4 */

                public final void run() {
                    FloatFrameView.LineChartView lineChartView = floatFrameView.ddr;
                    FloatFrameView.LineChartView.a aVar = new FloatFrameView.LineChartView.a((int) min, i13);
                    if (lineChartView.ddH.size() >= 50) {
                        lineChartView.ddH.removeLast();
                    }
                    lineChartView.ddH.addFirst(aVar);
                    lineChartView.invalidate();
                    floatFrameView.ddq.setText(format11);
                    floatFrameView.ddq.setTextColor(i13);
                    floatFrameView.ddC.setText(format5);
                    floatFrameView.dds.setText(format);
                    floatFrameView.ddt.setText(format2);
                    floatFrameView.ddu.setText(format3);
                    floatFrameView.ddv.setText(format4);
                    floatFrameView.ddD.setText(format10);
                    floatFrameView.ddw.setText(format6);
                    floatFrameView.ddx.setText(format7);
                    floatFrameView.ddy.setText(format8);
                    floatFrameView.ddz.setText(format9);
                }
            });
            this.dei = this.ddO;
            this.deg[0] = this.dcS;
            this.dej[0] = this.deh;
            aDv.removeCallbacks(this.dem);
            aDv.postDelayed(this.dem, 250);
        }
    }

    @Override // com.tencent.matrix.trace.e.b
    public final Executor getExecutor() {
        return this.executor;
    }

    public static a bi(final Context context) {
        if (deb == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                deb = new a(context, new FloatFrameView(context));
            } else {
                try {
                    synchronized (lock) {
                        aDv.post(new Runnable() {
                            /* class com.tencent.matrix.trace.view.a.AnonymousClass6 */

                            public final void run() {
                                a unused = a.deb = new a(context, new FloatFrameView(context), (byte) 0);
                                synchronized (a.lock) {
                                    a.lock.notifyAll();
                                }
                            }
                        });
                        lock.wait();
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
        return deb;
    }

    public final void show() {
        if (this.ded) {
            aDv.post(new Runnable() {
                /* class com.tencent.matrix.trace.view.a.AnonymousClass7 */

                public final void run() {
                    if (!a.this.ddZ) {
                        a.this.ddZ = true;
                        a.this.windowManager.addView(a.this.dea, a.this.ddY);
                    }
                }
            });
        }
    }

    public final void dismiss() {
        if (this.ded) {
            aDv.post(new Runnable() {
                /* class com.tencent.matrix.trace.view.a.AnonymousClass8 */

                public final void run() {
                    if (a.this.ddZ) {
                        a.this.ddZ = false;
                        a.this.windowManager.removeView(a.this.dea);
                    }
                }
            });
        }
    }

    @Override // com.tencent.matrix.b.c
    public final void onForeground(final boolean z) {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "[onForeground] isForeground:%s", Boolean.valueOf(z));
        if (this.ded && aDv != null) {
            aDv.post(new Runnable() {
                /* class com.tencent.matrix.trace.view.a.AnonymousClass9 */

                public final void run() {
                    if (z) {
                        a.this.show();
                    } else {
                        a.this.dismiss();
                    }
                }
            });
        }
    }

    public final void eQ(String str) {
        TextView textView;
        if (this.dea != null && (textView = (TextView) this.dea.findViewById(R.id.c7p)) != null) {
            textView.setText(str);
        }
    }

    static /* synthetic */ Handler h(a aVar) {
        if ((aVar.handler == null || !aVar.handler.getLooper().getThread().isAlive()) && com.tencent.matrix.g.b.TP() != null) {
            aVar.handler = new Handler(com.tencent.matrix.g.b.TP().getLooper());
        }
        return aVar.handler;
    }
}
