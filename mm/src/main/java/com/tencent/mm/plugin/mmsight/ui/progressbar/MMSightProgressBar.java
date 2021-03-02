package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Shader;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.progressbar.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.List;

public class MMSightProgressBar extends View {
    public static final int rLp = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 3);
    public static final int zEe = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 5);
    private static final int[] zEf = {-1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340")};
    private int centerX = 0;
    private int centerY = 0;
    private MMHandler handler = null;
    private boolean isStart = false;
    private Paint paint;
    private List<a> zEg = new ArrayList(5);
    private int zEh = 0;
    private b zEi;
    private boolean zEj = false;
    private a zEk;

    public interface a {
    }

    static {
        AppMethodBeat.i(94793);
        AppMethodBeat.o(94793);
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94789);
        init();
        AppMethodBeat.o(94789);
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94790);
        init();
        AppMethodBeat.o(94790);
    }

    private void init() {
        AppMethodBeat.i(94791);
        this.paint = new Paint();
        this.paint.setColor(-65536);
        this.paint.setAntiAlias(true);
        this.handler = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(94788);
                if (message.what == 233 && MMSightProgressBar.this.isStart && MMSightProgressBar.this.zEg.size() > 0 && MMSightProgressBar.this.zEg.size() < 5) {
                    a aVar = new a(MMSightProgressBar.this.zEg.size(), MMSightProgressBar.this.centerX, MMSightProgressBar.this.centerY, MMSightProgressBar.zEf[MMSightProgressBar.this.zEg.size()]);
                    MMSightProgressBar.this.zEi = new b((a) MMSightProgressBar.this.zEg.get(MMSightProgressBar.this.zEg.size() - 1), aVar, new b.a() {
                        /* class com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.mmsight.ui.progressbar.b.a
                        public final void a(a aVar) {
                            AppMethodBeat.i(94786);
                            MMSightProgressBar.this.zEg.add(aVar);
                            MMSightProgressBar.this.zEi = null;
                            if (MMSightProgressBar.this.zEg.size() >= 5) {
                                Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
                                if (MMSightProgressBar.this.zEk != null) {
                                    a unused = MMSightProgressBar.this.zEk;
                                }
                            } else if (MMSightProgressBar.this.isStart) {
                                MMSightProgressBar.this.handler.sendEmptyMessage(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
                            }
                            MMSightProgressBar.this.invalidate();
                            AppMethodBeat.o(94786);
                        }

                        @Override // com.tencent.mm.plugin.mmsight.ui.progressbar.b.a
                        public final void elf() {
                            AppMethodBeat.i(94787);
                            MMSightProgressBar.this.invalidate();
                            AppMethodBeat.o(94787);
                        }
                    });
                    b bVar = MMSightProgressBar.this.zEi;
                    bVar.animator = ValueAnimator.ofFloat(0.0f, 100.0f);
                    bVar.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.tencent.mm.plugin.mmsight.ui.progressbar.b.AnonymousClass1 */

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(94795);
                            b.this.progress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            b bVar = b.this;
                            float f2 = b.this.progress;
                            bVar.zEC = (float) ((int) (((float) Math.round((float) (MMSightProgressBar.zEe + (MMSightProgressBar.rLp * 2)))) * (f2 / 100.0f)));
                            bVar.zEz = bVar.zEA - ((f2 / 100.0f) * (bVar.zEA - bVar.zEB));
                            bVar.zEt = new PointF((float) MMSightProgressBar.rLp, 0.0f);
                            bVar.zEu = new PointF(((float) MMSightProgressBar.rLp) + (bVar.zEC / 2.0f), ((float) MMSightProgressBar.rLp) - (bVar.zEz / 2.0f));
                            bVar.zEv = new PointF(((float) MMSightProgressBar.rLp) + bVar.zEC, 0.0f);
                            bVar.zEw = new PointF((float) MMSightProgressBar.rLp, (float) (MMSightProgressBar.rLp * 2));
                            bVar.zEx = new PointF(((float) MMSightProgressBar.rLp) + (bVar.zEC / 2.0f), ((float) MMSightProgressBar.rLp) + (bVar.zEz / 2.0f));
                            bVar.zEy = new PointF(((float) MMSightProgressBar.rLp) + bVar.zEC, ((float) MMSightProgressBar.rLp) * 2.0f);
                            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", Float.valueOf(bVar.zEC), Float.valueOf(bVar.zEz));
                            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", bVar.zEt, bVar.zEu, bVar.zEv, bVar.zEw, bVar.zEx, bVar.zEy);
                            if (b.this.zEs != null) {
                                b.this.zEs.elf();
                            }
                            AppMethodBeat.o(94795);
                        }
                    });
                    bVar.animator.addListener(new AnimatorListenerAdapter() {
                        /* class com.tencent.mm.plugin.mmsight.ui.progressbar.b.AnonymousClass2 */

                        public final void onAnimationStart(Animator animator) {
                            b.this.zEr = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(94796);
                            b.this.zEr = true;
                            if (b.this.zEs != null) {
                                b.this.zEs.a(b.this.zEq);
                            }
                            AppMethodBeat.o(94796);
                        }
                    });
                    bVar.animator.setInterpolator(new AccelerateDecelerateInterpolator());
                    bVar.animator.setDuration(2000L);
                    bVar.animator.start();
                }
                AppMethodBeat.o(94788);
            }
        };
        Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", Integer.valueOf(rLp), Integer.valueOf(zEe));
        AppMethodBeat.o(94791);
    }

    public void setProgressCallback(a aVar) {
        this.zEk = aVar;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        AppMethodBeat.i(94792);
        super.onDraw(canvas);
        if (this.isStart && (this.centerX <= 0 || this.centerY <= 0)) {
            int left = getLeft();
            int right = getRight();
            int top = getTop();
            int bottom = getBottom();
            this.centerX = (right - left) / 2;
            this.centerY = (bottom - top) / 2;
            Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY));
            Log.i("MicroMsg.MMSightProgressBar", "add init point");
            this.zEg.add(new a(0, this.centerX, this.centerY, -1));
        }
        int save = canvas.save();
        this.zEh = this.zEg.size();
        if (this.zEh % 2 == 0) {
            f2 = -((((float) zEe) / 2.0f) + ((float) (((this.zEh / 2) - 1) * zEe)) + ((float) ((this.zEh / 2) * rLp)));
        } else {
            f2 = -((((float) rLp) / 2.0f) + ((float) ((this.zEh / 2) * zEe)) + ((float) ((this.zEh / 2) * rLp)));
        }
        if (this.zEi != null && this.zEi.zEr) {
            int i2 = this.zEh + 1;
            if (i2 % 2 == 0) {
                f3 = -(((float) ((i2 / 2) * rLp)) + (((float) zEe) / 2.0f) + ((float) (((i2 / 2) - 1) * zEe)));
            } else {
                f3 = -(((float) ((i2 / 2) * rLp)) + (((float) rLp) / 2.0f) + ((float) ((i2 / 2) * zEe)));
            }
            Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", Float.valueOf(f3), Float.valueOf(this.zEi.progress));
            f2 -= (Math.abs(f3) - Math.abs(f2)) * (this.zEi.progress / 100.0f);
        }
        Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", Float.valueOf(f2), Integer.valueOf(this.zEh));
        canvas.translate(f2, 0.0f);
        if (this.zEi != null && this.zEi.zEr) {
            b bVar = this.zEi;
            Paint paint2 = this.paint;
            float f4 = ((float) (zEe + (rLp * 2))) * (bVar.progress / 100.0f);
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", Float.valueOf(bVar.progress), Float.valueOf(f4));
            if (bVar.zEz > bVar.zEB) {
                float f5 = bVar.zEp.nSI - ((float) rLp);
                float f6 = bVar.zEp.nSJ - ((float) rLp);
                paint2.setColor(bVar.zEq.color);
                bVar.zED.reset();
                bVar.zED.moveTo(bVar.zEt.x + f5, bVar.zEt.y + f6);
                bVar.zED.quadTo(bVar.zEu.x + f5, bVar.zEu.y + f6, bVar.zEv.x + f5, bVar.zEv.y + f6);
                bVar.zED.lineTo(bVar.zEy.x + f5, bVar.zEy.y + f6);
                bVar.zED.quadTo(bVar.zEx.x + f5, bVar.zEx.y + f6, bVar.zEw.x + f5, f6 + bVar.zEw.y);
                if (bVar.zEq.color != bVar.zEp.color) {
                    paint2.setShader(new LinearGradient(bVar.zEt.x + f5, bVar.zEp.nSJ - ((float) rLp), f5 + bVar.zEv.x, bVar.zEp.nSJ - ((float) rLp), new int[]{bVar.zEp.color, bVar.zEq.color}, (float[]) null, Shader.TileMode.REPEAT));
                }
                canvas.drawPath(bVar.zED, paint2);
                paint2.setShader(null);
            }
            a aVar = bVar.zEq;
            paint2.setColor(aVar.color);
            aVar.nSJ = (float) aVar.zEo;
            aVar.nSI = ((float) (aVar.zEn + ((aVar.index - 1) * (zEe + (rLp * 2))))) + f4;
            Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", Integer.valueOf(aVar.index), Float.valueOf(f4), Float.valueOf(aVar.nSI));
            canvas.drawCircle(aVar.nSI, aVar.nSJ, (float) rLp, paint2);
            paint2.setShader(null);
        }
        for (a aVar2 : this.zEg) {
            Paint paint3 = this.paint;
            paint3.setColor(aVar2.color);
            aVar2.nSI = (float) (aVar2.zEn + (aVar2.index * (zEe + (rLp * 2))));
            aVar2.nSJ = (float) aVar2.zEo;
            Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", Integer.valueOf(aVar2.index), Float.valueOf(aVar2.nSI));
            canvas.drawCircle(aVar2.nSI, aVar2.nSJ, (float) rLp, paint3);
            paint3.setShader(null);
        }
        canvas.restoreToCount(save);
        if (this.isStart && !this.zEj && this.zEg.size() > 0) {
            Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
            this.zEj = true;
            this.handler.sendEmptyMessage(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
        }
        AppMethodBeat.o(94792);
    }
}
