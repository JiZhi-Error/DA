package com.tencent.mm.plugin.sport.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SportChartView extends View {
    private SimpleDateFormat FjQ;
    private SimpleDateFormat FjR;
    private boolean FjS;
    private a FjT;
    private int FjU;
    private List<d> FjV;
    private b[] FjW;
    private int FjX;
    private boolean FjY;
    private GestureDetector.OnGestureListener FjZ;
    private int gRD;
    private int gRE;
    private GestureDetector jKk;
    Paint paint;
    private final float rLA;
    private final int rLB;
    private final float rLC;
    private final int rLD;
    private final float rLE;
    private final int rLF;
    private final float rLG;
    private final int rLH;
    private final float rLI;
    private final int rLJ;
    private final float rLK;
    private final int rLL;
    private final float rLM;
    private final float rLN;
    private final float rLO;
    private final float rLP;
    private final int rLQ;
    private final int rLR;
    private final int rLS;
    private final int rLT;
    private final float rLU;
    private final int rLV;
    private final float rLW;
    private final int rLX;
    private final float rLY;
    private final int rLZ;
    private final int rLa;
    private final int rLb;
    private final int rLc;
    private final float rLd;
    private final float rLe;
    private final float rLf;
    private final float rLg;
    private final float rLh;
    private final int rLi;
    private final int rLj;
    private final int rLk;
    private final int rLl;
    private final float rLo;
    private final int rLp;
    private final float rLq;
    private final int rLr;
    private final float rLs;
    private final int rLt;
    private final float rLu;
    private final int rLv;
    private final float rLw;
    private final int rLx;
    private final float rLy;
    private final int rLz;
    private int rMB;
    private boolean rMC;
    private final float rMa;
    private final int rMb;
    private final float rMc;
    private final int rMd;
    private final int rMe;
    private final int rMf;
    private final int rMg;
    private final int rMh;
    private final int rMi;
    private final int rMj;
    private final int rMk;
    private final int rMl;
    private int rMm;
    private final Typeface rMn;
    private final Typeface rMo;
    private int rMp;
    private int rMq;
    Path rMw;
    Path rMx;
    private int startY;
    private int vfW;
    private int yTI;
    private int zVN;

    static /* synthetic */ void a(SportChartView sportChartView) {
        AppMethodBeat.i(103544);
        sportChartView.fmN();
        AppMethodBeat.o(103544);
    }

    static /* synthetic */ int e(SportChartView sportChartView) {
        int i2 = sportChartView.zVN;
        sportChartView.zVN = i2 + 1;
        return i2;
    }

    static /* synthetic */ int i(SportChartView sportChartView) {
        int i2 = sportChartView.zVN;
        sportChartView.zVN = i2 - 1;
        return i2;
    }

    private void fmM() {
        AppMethodBeat.i(103530);
        for (int i2 = 0; i2 < this.FjW.length; i2++) {
            this.FjW[i2] = new b(this, (byte) 0);
        }
        AppMethodBeat.o(103530);
    }

    public SportChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(103531);
        this.FjQ = new SimpleDateFormat(getResources().getString(R.string.hdy));
        this.FjR = new SimpleDateFormat("d");
        this.rLa = -1;
        this.rLb = -1;
        this.rLc = getResources().getColor(R.color.a9x);
        this.rLd = 12.0f;
        this.rLe = 24.0f;
        this.rLf = 28.0f;
        this.rLg = 12.0f;
        this.rLh = 12.0f;
        this.rLi = getResources().getColor(R.color.a9y);
        this.rLj = -1;
        this.rLk = getResources().getColor(R.color.a9y);
        this.rLl = -1;
        this.yTI = Integer.MAX_VALUE;
        this.gRD = 0;
        this.gRE = 0;
        this.rLo = 2.5f;
        this.rLp = (int) q(1, 2.5f);
        this.rLq = 4.0f;
        this.rLr = (int) q(1, 4.0f);
        this.rLs = 1.8f;
        this.rLt = (int) q(1, 1.8f);
        this.rLu = 1.0f;
        this.rLv = (int) q(1, 1.0f);
        this.rLw = 8.0f;
        this.rLx = (int) q(1, 8.0f);
        this.rLy = 22.0f;
        this.rLz = (int) q(1, 22.0f);
        this.rLA = 67.0f;
        this.rLB = (int) q(1, 67.0f);
        this.rLC = 40.0f;
        this.rLD = (int) q(1, 40.0f);
        this.rLE = 22.0f;
        this.rLF = (int) q(1, 22.0f);
        this.rLG = 55.0f;
        this.rLH = (int) q(1, 55.0f);
        this.rLI = 35.0f;
        this.rLJ = (int) q(1, 35.0f);
        this.rLK = 45.0f;
        this.rLL = (int) q(1, 45.0f);
        this.rLM = 8.0f;
        this.rLN = (float) ((int) q(1, 8.0f));
        this.rLO = 8.0f;
        this.rLP = (float) ((int) q(1, 8.0f));
        this.rLQ = 2;
        this.rLR = (int) q(1, 2.0f);
        this.rLS = 15;
        this.rLT = (int) q(1, 15.0f);
        this.rLU = 33.0f;
        this.rLV = (int) q(1, 33.0f);
        this.rLW = 8.0f;
        this.rLX = (int) q(1, 8.0f);
        this.rLY = 35.0f;
        this.rLZ = (int) q(1, 35.0f);
        this.rMa = 10.0f;
        this.rMb = (int) q(1, 10.0f);
        this.rMc = 58.0f;
        this.rMd = (int) q(1, 58.0f);
        this.rMe = (int) q(1, 1.0f);
        this.rMf = 102;
        this.rMg = 102;
        this.rMh = 153;
        this.rMi = 102;
        this.rMj = 102;
        this.rMk = 102;
        this.rMl = 204;
        this.rMm = 0;
        this.rMn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.rMo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.rMp = 0;
        this.rMq = 0;
        this.zVN = -1;
        this.vfW = -1;
        this.FjT = a.WEEK;
        this.FjU = 7;
        this.FjW = new b[this.FjU];
        this.FjZ = new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.sport.ui.SportChartView.AnonymousClass1 */
            private long Fka;

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(224208);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(224208);
                return onContextClick;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(224207);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(224207);
                return onDoubleTap;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(224206);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(224206);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(103524);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                SportChartView.this.yTI = SportChartView.a(SportChartView.this, x);
                SportChartView.a(SportChartView.this);
                SportChartView.this.rMC = false;
                Log.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", Float.valueOf(x), Float.valueOf(y), Integer.valueOf(SportChartView.this.yTI));
                SportChartView.this.invalidate();
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(103524);
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(103525);
                Log.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", Float.valueOf(f2));
                if (System.currentTimeMillis() - this.Fka < 500 || !SportChartView.this.FjY) {
                    AppMethodBeat.o(103525);
                    return false;
                }
                this.Fka = System.currentTimeMillis();
                if (f2 > 0.0f) {
                    SportChartView.e(SportChartView.this);
                    if (SportChartView.this.zVN > SportChartView.this.vfW) {
                        SportChartView.this.zVN = SportChartView.this.vfW;
                    }
                    SportChartView.h(SportChartView.this);
                    SportChartView.this.invalidate();
                    AppMethodBeat.o(103525);
                    return true;
                } else if (f2 < 0.0f) {
                    SportChartView.i(SportChartView.this);
                    if (SportChartView.this.zVN <= 0) {
                        SportChartView.this.zVN = 1;
                    }
                    SportChartView.h(SportChartView.this);
                    SportChartView.this.invalidate();
                    AppMethodBeat.o(103525);
                    return true;
                } else {
                    AppMethodBeat.o(103525);
                    return false;
                }
            }
        };
        cMe();
        AppMethodBeat.o(103531);
    }

    public SportChartView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(103532);
        this.FjQ = new SimpleDateFormat(getResources().getString(R.string.hdy));
        this.FjR = new SimpleDateFormat("d");
        this.rLa = -1;
        this.rLb = -1;
        this.rLc = getResources().getColor(R.color.a9x);
        this.rLd = 12.0f;
        this.rLe = 24.0f;
        this.rLf = 28.0f;
        this.rLg = 12.0f;
        this.rLh = 12.0f;
        this.rLi = getResources().getColor(R.color.a9y);
        this.rLj = -1;
        this.rLk = getResources().getColor(R.color.a9y);
        this.rLl = -1;
        this.yTI = Integer.MAX_VALUE;
        this.gRD = 0;
        this.gRE = 0;
        this.rLo = 2.5f;
        this.rLp = (int) q(1, 2.5f);
        this.rLq = 4.0f;
        this.rLr = (int) q(1, 4.0f);
        this.rLs = 1.8f;
        this.rLt = (int) q(1, 1.8f);
        this.rLu = 1.0f;
        this.rLv = (int) q(1, 1.0f);
        this.rLw = 8.0f;
        this.rLx = (int) q(1, 8.0f);
        this.rLy = 22.0f;
        this.rLz = (int) q(1, 22.0f);
        this.rLA = 67.0f;
        this.rLB = (int) q(1, 67.0f);
        this.rLC = 40.0f;
        this.rLD = (int) q(1, 40.0f);
        this.rLE = 22.0f;
        this.rLF = (int) q(1, 22.0f);
        this.rLG = 55.0f;
        this.rLH = (int) q(1, 55.0f);
        this.rLI = 35.0f;
        this.rLJ = (int) q(1, 35.0f);
        this.rLK = 45.0f;
        this.rLL = (int) q(1, 45.0f);
        this.rLM = 8.0f;
        this.rLN = (float) ((int) q(1, 8.0f));
        this.rLO = 8.0f;
        this.rLP = (float) ((int) q(1, 8.0f));
        this.rLQ = 2;
        this.rLR = (int) q(1, 2.0f);
        this.rLS = 15;
        this.rLT = (int) q(1, 15.0f);
        this.rLU = 33.0f;
        this.rLV = (int) q(1, 33.0f);
        this.rLW = 8.0f;
        this.rLX = (int) q(1, 8.0f);
        this.rLY = 35.0f;
        this.rLZ = (int) q(1, 35.0f);
        this.rMa = 10.0f;
        this.rMb = (int) q(1, 10.0f);
        this.rMc = 58.0f;
        this.rMd = (int) q(1, 58.0f);
        this.rMe = (int) q(1, 1.0f);
        this.rMf = 102;
        this.rMg = 102;
        this.rMh = 153;
        this.rMi = 102;
        this.rMj = 102;
        this.rMk = 102;
        this.rMl = 204;
        this.rMm = 0;
        this.rMn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.rMo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.rMp = 0;
        this.rMq = 0;
        this.zVN = -1;
        this.vfW = -1;
        this.FjT = a.WEEK;
        this.FjU = 7;
        this.FjW = new b[this.FjU];
        this.FjZ = new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.sport.ui.SportChartView.AnonymousClass1 */
            private long Fka;

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(224208);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(224208);
                return onContextClick;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(224207);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(224207);
                return onDoubleTap;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(224206);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(224206);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(103524);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                SportChartView.this.yTI = SportChartView.a(SportChartView.this, x);
                SportChartView.a(SportChartView.this);
                SportChartView.this.rMC = false;
                Log.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", Float.valueOf(x), Float.valueOf(y), Integer.valueOf(SportChartView.this.yTI));
                SportChartView.this.invalidate();
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(103524);
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(103525);
                Log.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", Float.valueOf(f2));
                if (System.currentTimeMillis() - this.Fka < 500 || !SportChartView.this.FjY) {
                    AppMethodBeat.o(103525);
                    return false;
                }
                this.Fka = System.currentTimeMillis();
                if (f2 > 0.0f) {
                    SportChartView.e(SportChartView.this);
                    if (SportChartView.this.zVN > SportChartView.this.vfW) {
                        SportChartView.this.zVN = SportChartView.this.vfW;
                    }
                    SportChartView.h(SportChartView.this);
                    SportChartView.this.invalidate();
                    AppMethodBeat.o(103525);
                    return true;
                } else if (f2 < 0.0f) {
                    SportChartView.i(SportChartView.this);
                    if (SportChartView.this.zVN <= 0) {
                        SportChartView.this.zVN = 1;
                    }
                    SportChartView.h(SportChartView.this);
                    SportChartView.this.invalidate();
                    AppMethodBeat.o(103525);
                    return true;
                } else {
                    AppMethodBeat.o(103525);
                    return false;
                }
            }
        };
        cMe();
        AppMethodBeat.o(103532);
    }

    public void setTodayStep(int i2) {
        this.FjX = i2;
    }

    private void c(Canvas canvas, boolean z) {
        AppMethodBeat.i(103533);
        if (z) {
            this.rMx.reset();
            this.rMx.moveTo(this.FjW[0].x, this.FjW[0].y);
            for (int i2 = 0; i2 < this.FjW.length; i2++) {
                this.rMx.lineTo(this.FjW[i2].x, this.FjW[i2].y);
            }
            this.rMx.lineTo(this.FjW[this.FjW.length - 1].x, (float) ((this.gRE - this.rLJ) - 1));
            this.rMx.lineTo((float) this.rLx, (float) ((this.gRE - this.rLJ) - 1));
            this.rMx.lineTo((float) this.rLx, this.FjW[0].y);
            canvas.drawPath(this.rMx, this.paint);
            AppMethodBeat.o(103533);
            return;
        }
        this.rMx.reset();
        this.rMx.moveTo(this.FjW[0].x, this.FjW[0].y);
        for (int i3 = 0; i3 < this.FjW.length; i3++) {
            if (i3 <= 0) {
                cMg();
            } else if (this.FjW[i3 - 1].y == ((float) (this.gRE - this.rLD))) {
                this.paint.reset();
                this.paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.paint.setAntiAlias(true);
                this.paint.setStrokeWidth((float) this.rLt);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setColor(-1);
            } else {
                cMg();
            }
            this.rMx.lineTo(this.FjW[i3].x, this.FjW[i3].y);
            canvas.drawPath(this.rMx, this.paint);
            this.rMx.reset();
            this.rMx.moveTo(this.FjW[i3].x, this.FjW[i3].y);
        }
        AppMethodBeat.o(103533);
    }

    private void w(Canvas canvas) {
        AppMethodBeat.i(103534);
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setColor(-1);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setStyle(Paint.Style.FILL);
        for (int i2 = 0; i2 < this.FjW.length; i2++) {
            if (i2 == this.FjW.length - 1) {
                canvas.drawCircle(this.FjW[i2].x, this.FjW[i2].y, (float) this.rLr, this.paint);
            } else {
                canvas.drawCircle(this.FjW[i2].x, this.FjW[i2].y, (float) this.rLp, this.paint);
            }
        }
        AppMethodBeat.o(103534);
    }

    private float q(int i2, float f2) {
        Resources resources;
        AppMethodBeat.i(103536);
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics());
        AppMethodBeat.o(103536);
        return applyDimension;
    }

    private void x(Canvas canvas) {
        AppMethodBeat.i(103537);
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setTextSize(q(2, 12.0f));
        this.paint.setAlpha(153);
        for (int i2 = 0; i2 < this.FjW.length; i2++) {
            if (i2 == 0) {
                this.paint.setTextAlign(Paint.Align.LEFT);
            } else {
                this.paint.setTextAlign(Paint.Align.CENTER);
            }
            if (this.FjW[i2].Fkf) {
                this.paint.setColor(-1);
            } else {
                this.paint.setColor(this.rLi);
            }
            canvas.drawText(this.FjW[i2].BrH, this.FjW[i2].x, (float) (this.gRE - this.rLT), this.paint);
        }
        AppMethodBeat.o(103537);
    }

    private void cMe() {
        AppMethodBeat.i(103538);
        this.paint = new Paint();
        this.rMw = new Path();
        this.rMx = new Path();
        this.FjW = new b[this.FjU];
        fmM();
        fmN();
        this.jKk = new GestureDetector(getContext(), this.FjZ);
        AppMethodBeat.o(103538);
    }

    private void fmN() {
        for (int i2 = 0; i2 < this.FjU; i2++) {
            if (i2 == this.FjU - 1) {
                this.FjW[i2].Fkf = true;
            } else {
                this.FjW[i2].Fkf = false;
            }
        }
    }

    private void cMg() {
        AppMethodBeat.i(103539);
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth((float) this.rLt);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(-1);
        AppMethodBeat.o(103539);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(103542);
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(103542);
        return true;
    }

    public enum a {
        WEEK,
        MONTH;

        public static a valueOf(String str) {
            AppMethodBeat.i(103527);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(103527);
            return aVar;
        }

        static {
            AppMethodBeat.i(103528);
            AppMethodBeat.o(103528);
        }
    }

    public void setHasSwitchBtn(boolean z) {
        this.FjY = z;
    }

    /* access modifiers changed from: package-private */
    public class b {
        String BrH;
        boolean Fkf;
        int lCq;
        long timestamp;
        float x;
        float y;

        private b() {
            this.BrH = "";
        }

        /* synthetic */ b(SportChartView sportChartView, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(103540);
        this.gRD = getWidth();
        this.gRE = getHeight();
        this.rMp = ((this.gRD - this.rLx) - this.rLz) / (this.FjU - 1);
        this.rMq = ((this.gRE - this.rLB) - this.rLD) / 2;
        for (int i2 = 0; i2 < this.FjW.length; i2++) {
            this.FjW[i2].x = (float) (this.rLx + (this.rMp * i2));
        }
        int length = this.FjW.length;
        if (length > this.FjU) {
            length = this.FjU;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.FjW[i4].lCq > 100000) {
                this.FjW[i4].lCq = 100000;
            }
            if (this.FjW[i4].lCq < 0) {
                this.FjW[i4].lCq = 0;
            }
            if (this.FjW[i4].lCq > i3) {
                i3 = this.FjW[i4].lCq;
            }
        }
        if (i3 <= 15000 && i3 >= 0) {
            i3 = 15000;
        } else if (i3 <= 15000 || i3 > 100000) {
            i3 = 0;
        } else if (((double) i3) / 5000.0d > ((double) (((float) i3) / 5000.0f))) {
            i3 = ((i3 / 5000) + 1) * 5000;
        }
        this.rMm = (((this.gRE - this.rLB) - this.rLD) * 10000) / i3;
        this.rMm = (this.gRE - this.rLD) - this.rMm;
        for (int i5 = 0; i5 < length; i5++) {
            this.FjW[i5].y = ((float) (this.gRE - this.rLD)) - ((((float) this.FjW[i5].lCq) / ((float) i3)) * ((float) ((this.gRE - this.rLB) - this.rLD)));
        }
        for (int i6 = 0; i6 < length; i6++) {
            if (i6 == 0) {
                this.FjW[i6].BrH = this.FjQ.format(new Date(this.FjW[i6].timestamp));
            } else if (this.FjT != a.MONTH) {
                this.FjW[i6].BrH = this.FjR.format(new Date(this.FjW[i6].timestamp));
            } else if (i6 % 6 == 5) {
                this.FjW[i6].BrH = this.FjR.format(new Date(this.FjW[i6].timestamp));
            } else {
                this.FjW[i6].BrH = "";
            }
        }
        super.onDraw(canvas);
        if (!this.FjS) {
            w(canvas);
            if (this.yTI != Integer.MAX_VALUE) {
                int i7 = this.yTI;
                if (i7 >= 0 && i7 <= this.FjU - 1) {
                    this.paint.reset();
                    this.paint.setColor(this.rLi);
                    this.paint.setAntiAlias(true);
                    this.paint.setStrokeWidth(0.0f);
                    this.paint.setTextSize(q(2, 12.0f));
                    this.paint.setTextAlign(Paint.Align.CENTER);
                    if (i7 == 0) {
                        this.paint.setTextAlign(Paint.Align.LEFT);
                    }
                    if (i7 == this.FjU - 1) {
                        this.paint.setTextAlign(Paint.Align.RIGHT);
                    }
                    if (!this.rMC) {
                        this.rMB = ((int) this.FjW[i7].y) - this.rMd;
                        this.startY = this.rMB;
                        this.rMC = true;
                    }
                    if (this.rMC) {
                        float f2 = (float) (((double) this.startY) / 8.0d);
                        if (this.rMB > 0) {
                            this.paint.setAlpha(((this.startY - this.rMB) * 255) / this.startY);
                        }
                        canvas.drawText(new StringBuilder().append(this.FjW[i7].lCq).toString(), this.FjW[i7].x, (float) (this.rMB + this.rMd), this.paint);
                        if (this.FjT == a.MONTH) {
                            this.paint.reset();
                            this.rMw.reset();
                            this.paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                            this.paint.setColor(this.rLc);
                            this.paint.setStrokeWidth((float) this.rLv);
                            this.paint.setStyle(Paint.Style.STROKE);
                            this.paint.setAlpha(102);
                            this.rMw.moveTo(this.FjW[i7].x, (float) (this.gRE - this.rLJ));
                            this.rMw.lineTo(this.FjW[i7].x, (float) (this.rMB + this.rMd + this.rLr));
                            canvas.drawPath(this.rMw, this.paint);
                        }
                        if (this.rMB > 0) {
                            if (((float) this.rMB) / ((float) this.startY) <= 1.0f / f2) {
                                this.rMB--;
                            } else {
                                this.rMB = (int) (((float) this.rMB) - (f2 * (((float) this.rMB) / ((float) this.startY))));
                            }
                            invalidate();
                        } else {
                            this.rMC = false;
                        }
                    }
                }
                int i8 = this.yTI;
                if (i8 >= 0 && i8 <= this.FjU - 1) {
                    this.FjW[i8].Fkf = true;
                }
            }
        }
        this.paint.reset();
        this.rMw.reset();
        this.paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.paint.setColor(this.rLc);
        this.paint.setStrokeWidth((float) this.rLv);
        this.paint.setAlpha(102);
        this.paint.setStyle(Paint.Style.STROKE);
        if (this.rMm != 0 && !this.FjS) {
            this.rMw.moveTo((float) this.rLx, (float) this.rMm);
            this.rMw.lineTo((float) (this.gRD - this.rLF), (float) this.rMm);
            canvas.drawPath(this.rMw, this.paint);
        }
        this.paint.reset();
        this.rMw.reset();
        this.paint.setColor(this.rLc);
        this.paint.setStrokeWidth((float) this.rLv);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setAlpha(102);
        this.rMw.reset();
        this.rMw.moveTo(this.rLN, (float) (this.gRE - this.rLJ));
        this.rMw.lineTo(((float) this.gRD) - this.rLP, (float) (this.gRE - this.rLJ));
        this.rMw.moveTo(this.rLN, (float) this.rLL);
        this.rMw.lineTo(((float) this.gRD) - this.rLP, (float) this.rLL);
        canvas.drawPath(this.rMw, this.paint);
        if (!this.FjS) {
            this.paint.reset();
            this.paint.setColor(this.rLk);
            this.paint.setAntiAlias(true);
            this.paint.setAlpha(102);
            this.paint.setStrokeWidth(0.0f);
            this.paint.setTextSize(q(2, 12.0f));
            this.paint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(getResources().getString(R.string.hdx), (float) (this.gRD - this.rLR), (float) (((double) this.rMm) + (((double) this.paint.getTextSize()) * 0.34d)), this.paint);
        }
        if (this.FjY) {
            this.paint.reset();
            this.paint.setColor(-1);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0f);
            this.paint.setTypeface(this.rMn);
            this.paint.setTextAlign(Paint.Align.RIGHT);
            this.paint.setTextSize(q(2, 28.0f));
            String valueOf = String.valueOf(this.FjX);
            canvas.drawText(valueOf, (float) (this.gRD - this.rMb), (float) this.rLZ, this.paint);
            float measureText = this.paint.measureText(valueOf);
            this.paint.setTextSize(q(2, 24.0f));
            canvas.drawText(getResources().getString(R.string.he0), ((float) (this.gRD - this.rMb)) - measureText, (float) this.rLV, this.paint);
        } else {
            this.paint.reset();
            this.paint.setColor(-1);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0f);
            this.paint.setTypeface(this.rMn);
            this.paint.setTextSize(q(2, 24.0f));
            this.paint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(getResources().getString(R.string.hdz), (float) this.rLX, (float) this.rLV, this.paint);
            this.paint.setTextAlign(Paint.Align.RIGHT);
            this.paint.setTextSize(q(2, 28.0f));
            canvas.drawText(new StringBuilder().append(this.FjX).toString(), (float) (this.gRD - this.rMb), (float) this.rLZ, this.paint);
        }
        if (this.FjW.length > 2) {
            this.paint.reset();
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0f);
            this.paint.setAlpha(102);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.gRE - this.rLJ), -1, 16777215, Shader.TileMode.REPEAT));
            this.paint.setColor(-1);
            c(canvas, true);
            cMg();
            if (!this.FjS) {
                c(canvas, false);
            }
        }
        x(canvas);
        AppMethodBeat.o(103540);
    }

    static /* synthetic */ int a(SportChartView sportChartView, float f2) {
        AppMethodBeat.i(103543);
        sportChartView.yTI = Integer.MAX_VALUE;
        if (sportChartView.FjW.length > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= sportChartView.FjW.length) {
                    break;
                }
                if (i2 != 0) {
                    if (i2 > 0 && i2 < sportChartView.FjW.length - 1) {
                        if (f2 < sportChartView.FjW[i2].x + ((float) (sportChartView.rMp / 2)) && f2 > sportChartView.FjW[i2].x - ((float) (sportChartView.rMp / 2))) {
                            sportChartView.yTI = i2;
                            sportChartView.invalidate();
                            break;
                        }
                    } else if (i2 == sportChartView.FjW.length - 1) {
                        if (f2 < ((float) sportChartView.gRD) && f2 > sportChartView.FjW[i2].x - ((float) (sportChartView.rMp / 2))) {
                            sportChartView.yTI = i2;
                            sportChartView.invalidate();
                            break;
                        }
                    } else {
                        sportChartView.yTI = Integer.MAX_VALUE;
                        break;
                    }
                } else if (f2 < sportChartView.FjW[i2].x + ((float) (sportChartView.rMp / 2)) && f2 > 0.0f) {
                    sportChartView.yTI = i2;
                    sportChartView.invalidate();
                    break;
                }
                i2++;
            }
        }
        int i3 = sportChartView.yTI;
        AppMethodBeat.o(103543);
        return i3;
    }

    static /* synthetic */ void h(SportChartView sportChartView) {
        AppMethodBeat.i(103545);
        sportChartView.yTI = Integer.MAX_VALUE;
        Calendar instance = Calendar.getInstance();
        sportChartView.FjW = new b[sportChartView.FjU];
        sportChartView.fmM();
        if (sportChartView.FjV == null || sportChartView.FjV.size() <= 0) {
            sportChartView.FjS = true;
            instance.add(5, -sportChartView.FjU);
            for (int i2 = 0; i2 < sportChartView.FjW.length; i2++) {
                instance.add(5, 1);
                sportChartView.FjW[i2].timestamp = instance.getTimeInMillis();
                sportChartView.FjW[i2].lCq = 0;
            }
            AppMethodBeat.o(103545);
            return;
        }
        sportChartView.FjS = false;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(sportChartView.FjV);
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (sportChartView.vfW == -1) {
            int i3 = size / sportChartView.FjU;
            if (size % sportChartView.FjU != 0) {
                sportChartView.vfW = i3 + 1;
            } else {
                sportChartView.vfW = i3;
            }
            if (sportChartView.vfW > 4) {
                sportChartView.vfW = 4;
            }
            sportChartView.zVN = sportChartView.vfW;
        }
        int i4 = size - (sportChartView.FjU * ((sportChartView.vfW - sportChartView.zVN) + 1));
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = size - (sportChartView.FjU * (sportChartView.vfW - sportChartView.zVN));
        Log.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", Integer.valueOf(i4), Integer.valueOf(i5));
        List subList = arrayList.subList(i4, i5);
        int size2 = subList.size();
        if (size2 < sportChartView.FjU) {
            instance.setTimeInMillis(((d) subList.get(0)).field_timestamp);
            for (int i6 = 0; i6 < sportChartView.FjU - size2; i6++) {
                instance.add(5, -1);
                d dVar = new d();
                dVar.field_timestamp = instance.getTimeInMillis();
                dVar.field_step = 0;
                subList.add(0, dVar);
            }
        }
        for (int i7 = 0; i7 < sportChartView.FjU; i7++) {
            d dVar2 = (d) subList.get(i7);
            sportChartView.FjW[i7].lCq = dVar2.field_step;
            sportChartView.FjW[i7].timestamp = dVar2.field_timestamp;
        }
        AppMethodBeat.o(103545);
    }
}
