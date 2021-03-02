package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceStepChartView extends View {
    private int gRD;
    private int gRE;
    Paint paint;
    List<Point> points;
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
    private int rLm;
    private final float rLn;
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
    PathEffect rMA;
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
    private int[] rMr;
    private final int rMs;
    private float[] rMt;
    private float[] rMu;
    private boolean[] rMv;
    Path rMw;
    Path rMx;
    List<String> rMy;
    private boolean rMz;
    private int startY;

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(24296);
        this.rLa = -1;
        this.rLb = -1;
        this.rLc = getResources().getColor(R.color.nh);
        this.rLd = 12.0f;
        this.rLe = 28.0f;
        this.rLf = 33.0f;
        this.rLg = 12.0f;
        this.rLh = 12.0f;
        this.rLi = getResources().getColor(R.color.ni);
        this.rLj = -1;
        this.rLk = getResources().getColor(R.color.ni);
        this.rLl = -1;
        this.rLm = Integer.MAX_VALUE;
        this.gRD = 0;
        this.gRE = 0;
        this.rLn = 10.0f;
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
        this.rMr = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.rMs = 7;
        this.rMt = new float[7];
        this.rMu = new float[7];
        this.rMv = new boolean[7];
        this.rMz = false;
        this.rMA = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        cMe();
        AppMethodBeat.o(24296);
    }

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(24297);
        this.rLa = -1;
        this.rLb = -1;
        this.rLc = getResources().getColor(R.color.nh);
        this.rLd = 12.0f;
        this.rLe = 28.0f;
        this.rLf = 33.0f;
        this.rLg = 12.0f;
        this.rLh = 12.0f;
        this.rLi = getResources().getColor(R.color.ni);
        this.rLj = -1;
        this.rLk = getResources().getColor(R.color.ni);
        this.rLl = -1;
        this.rLm = Integer.MAX_VALUE;
        this.gRD = 0;
        this.gRE = 0;
        this.rLn = 10.0f;
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
        this.rMr = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.rMs = 7;
        this.rMt = new float[7];
        this.rMu = new float[7];
        this.rMv = new boolean[7];
        this.rMz = false;
        this.rMA = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        cMe();
        AppMethodBeat.o(24297);
    }

    private void c(Canvas canvas, boolean z) {
        AppMethodBeat.i(24298);
        if (z) {
            this.rMx.reset();
            this.rMx.moveTo((float) this.points.get(0).x, (float) this.points.get(0).y);
            for (int i2 = 0; i2 < this.points.size(); i2++) {
                this.rMx.lineTo((float) this.points.get(i2).x, (float) this.points.get(i2).y);
            }
            this.rMx.lineTo(this.rMt[this.rMt.length - 1], (float) ((this.gRE - this.rLJ) - 1));
            this.rMx.lineTo((float) this.rLx, (float) ((this.gRE - this.rLJ) - 1));
            this.rMx.lineTo((float) this.rLx, this.rMu[0]);
            canvas.drawPath(this.rMx, this.paint);
            AppMethodBeat.o(24298);
            return;
        }
        this.rMx.reset();
        this.rMx.moveTo((float) this.points.get(0).x, (float) this.points.get(0).y);
        for (int i3 = 0; i3 < this.points.size(); i3++) {
            if (i3 <= 0) {
                cMg();
            } else if (this.points.get(i3 - 1).y == this.gRE - this.rLD) {
                this.paint.reset();
                this.paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.paint.setAntiAlias(true);
                this.paint.setStrokeWidth((float) this.rLt);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setColor(-1);
            } else {
                cMg();
            }
            this.rMx.lineTo((float) this.points.get(i3).x, (float) this.points.get(i3).y);
            canvas.drawPath(this.rMx, this.paint);
            this.rMx.reset();
            this.rMx.moveTo((float) this.points.get(i3).x, (float) this.points.get(i3).y);
        }
        AppMethodBeat.o(24298);
    }

    private float q(int i2, float f2) {
        Resources resources;
        AppMethodBeat.i(24299);
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics());
        AppMethodBeat.o(24299);
        return applyDimension;
    }

    private void a(Canvas canvas, List<String> list) {
        AppMethodBeat.i(24300);
        if (list != null && list.size() == 7) {
            this.paint.reset();
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0f);
            this.paint.setTextSize(q(2, 12.0f));
            this.paint.setAlpha(153);
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (i2 == 0) {
                    this.paint.setTextAlign(Paint.Align.LEFT);
                } else {
                    this.paint.setTextAlign(Paint.Align.CENTER);
                }
                if (this.rMv[i2]) {
                    this.paint.setColor(-1);
                } else {
                    this.paint.setColor(this.rLi);
                }
                canvas.drawText(list.get(i2), (float) this.points.get(i2).x, (float) (this.gRE - this.rLT), this.paint);
            }
        }
        AppMethodBeat.o(24300);
    }

    private void cMe() {
        AppMethodBeat.i(24301);
        this.paint = new Paint();
        this.rMw = new Path();
        this.rMx = new Path();
        this.points = new LinkedList();
        this.rMy = new LinkedList();
        cMf();
        AppMethodBeat.o(24301);
    }

    private void cMf() {
        for (int i2 = 0; i2 < 7; i2++) {
            if (i2 == 6) {
                this.rMv[i2] = true;
            } else {
                this.rMv[i2] = false;
            }
        }
    }

    private void cMg() {
        AppMethodBeat.i(24302);
        this.paint.reset();
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth((float) this.rLt);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(-1);
        AppMethodBeat.o(24302);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(24303);
        getData();
        super.onDraw(canvas);
        if (!this.rMz) {
            this.paint.reset();
            this.paint.setAntiAlias(true);
            this.paint.setColor(-1);
            this.paint.setStrokeWidth(0.0f);
            this.paint.setStyle(Paint.Style.FILL);
            for (int i2 = 0; i2 < this.points.size(); i2++) {
                Point point = this.points.get(i2);
                if (i2 == this.points.size() - 1) {
                    canvas.drawCircle((float) point.x, (float) point.y, (float) this.rLr, this.paint);
                } else {
                    canvas.drawCircle((float) point.x, (float) point.y, (float) this.rLp, this.paint);
                }
            }
            if (this.rLm != Integer.MAX_VALUE) {
                int i3 = this.rLm;
                this.paint.reset();
                this.paint.setColor(this.rLi);
                this.paint.setAntiAlias(true);
                this.paint.setStrokeWidth(0.0f);
                this.paint.setTextSize(q(2, 12.0f));
                this.paint.setTextAlign(Paint.Align.CENTER);
                if (i3 >= 0 && i3 <= 6) {
                    if (i3 == 0) {
                        this.paint.setTextAlign(Paint.Align.LEFT);
                    }
                    if (i3 == 6) {
                        this.paint.setTextAlign(Paint.Align.RIGHT);
                    }
                    if (!this.rMC) {
                        this.rMB = this.points.get(i3).y - this.rMd;
                        this.startY = this.rMB;
                        this.rMC = true;
                    }
                    if (this.rMC) {
                        float f2 = (float) (((double) this.startY) / 8.0d);
                        if (this.rMB > 0) {
                            this.paint.setAlpha(((this.startY - this.rMB) * 255) / this.startY);
                        }
                        canvas.drawText(new StringBuilder().append(this.rMr[i3]).toString(), (float) this.points.get(i3).x, (float) (this.rMB + this.rMd), this.paint);
                        if (this.rMB > 0) {
                            if (((float) this.rMB) / ((float) this.startY) <= 1.0f / f2) {
                                this.rMB--;
                            } else {
                                this.rMB = (int) (((float) this.rMB) - ((((float) this.rMB) / ((float) this.startY)) * f2));
                            }
                            invalidate();
                        } else {
                            this.rMC = false;
                        }
                    }
                }
                int i4 = this.rLm;
                if (i4 >= 0 && i4 <= 6) {
                    this.rMv[i4] = true;
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
        if (this.rMm != 0 && !this.rMz) {
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
        if (!this.rMz) {
            this.paint.reset();
            this.paint.setColor(this.rLk);
            this.paint.setAntiAlias(true);
            this.paint.setAlpha(102);
            this.paint.setStrokeWidth(0.0f);
            this.paint.setTextSize(q(2, 12.0f));
            this.paint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(getResources().getString(R.string.c1f), (float) (this.gRD - this.rLR), (float) (((double) this.rMm) + (((double) this.paint.getTextSize()) * 0.34d)), this.paint);
        }
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setTypeface(this.rMn);
        this.paint.setTextSize(q(2, 28.0f));
        canvas.drawText(getResources().getString(R.string.c1h), (float) this.rLX, (float) this.rLV, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(q(2, 33.0f));
        canvas.drawText(new StringBuilder().append(this.rMr[this.rMr.length - 1]).toString(), (float) (this.gRD - this.rMb), (float) this.rLZ, this.paint);
        if (this.points.size() > 2) {
            this.paint.reset();
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0f);
            this.paint.setAlpha(102);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.gRE - this.rLJ), -1, 16777215, Shader.TileMode.REPEAT));
            this.paint.setColor(-1);
            c(canvas, true);
            cMg();
            if (!this.rMz) {
                c(canvas, false);
            }
        }
        a(canvas, this.rMy);
        AppMethodBeat.o(24303);
    }

    private void getData() {
        AppMethodBeat.i(24304);
        this.points.clear();
        this.rMp = ((this.gRD - this.rLx) - this.rLz) / 6;
        this.rMq = ((this.gRE - this.rLB) - this.rLD) / 2;
        for (int i2 = 0; i2 < this.rMt.length; i2++) {
            this.rMt[i2] = (float) (this.rLx + (this.rMp * i2));
        }
        int length = this.rMr.length;
        if (length > 7) {
            length = 7;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (this.rMr[i4] > 100000) {
                this.rMr[i4] = 100000;
            }
            if (this.rMr[i4] < 0) {
                this.rMr[i4] = 0;
            }
            if (this.rMr[i4] > i3) {
                i3 = this.rMr[i4];
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
            this.rMu[i5] = ((float) (this.gRE - this.rLD)) - ((((float) this.rMr[i5]) / ((float) i3)) * ((float) ((this.gRE - this.rLB) - this.rLD)));
            this.points.add(new Point((int) this.rMt[i5], (int) this.rMu[i5]));
        }
        AppMethodBeat.o(24304);
    }

    private int bf(float f2) {
        AppMethodBeat.i(24305);
        this.rLm = Integer.MAX_VALUE;
        if (this.points.size() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.points.size()) {
                    break;
                }
                if (i2 != 0) {
                    if (i2 > 0 && i2 < this.points.size() - 1) {
                        if (f2 < ((float) (this.points.get(i2).x + (this.rMp / 2))) && f2 > ((float) (this.points.get(i2).x - (this.rMp / 2)))) {
                            this.rLm = i2;
                            invalidate();
                            break;
                        }
                    } else if (i2 == this.points.size() - 1) {
                        if (f2 < ((float) this.gRD) && f2 > ((float) (this.points.get(i2).x - (this.rMp / 2)))) {
                            this.rLm = i2;
                            invalidate();
                            break;
                        }
                    } else {
                        this.rLm = Integer.MAX_VALUE;
                        break;
                    }
                } else if (f2 < ((float) (this.points.get(i2).x + (this.rMp / 2))) && f2 > 0.0f) {
                    this.rLm = i2;
                    invalidate();
                    break;
                }
                i2++;
            }
        }
        int i3 = this.rLm;
        AppMethodBeat.o(24305);
        return i3;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(24306);
        float x = motionEvent.getX();
        motionEvent.getY();
        Log.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.rLm);
        switch (motionEvent.getAction()) {
            case 0:
                Log.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
                AppMethodBeat.o(24306);
                return true;
            case 1:
                Log.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
                this.rLm = bf(x);
                cMf();
                this.rMC = false;
                invalidate();
                AppMethodBeat.o(24306);
                return false;
            default:
                Log.d("MicroMsg.exdevice.ExdeviceStepChartView", BuildConfig.KINDA_DEFAULT);
                AppMethodBeat.o(24306);
                return false;
        }
    }
}
