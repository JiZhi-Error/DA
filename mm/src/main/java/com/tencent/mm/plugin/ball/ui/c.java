package com.tencent.mm.plugin.ball.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.d.a;
import com.tencent.mm.plugin.ball.view.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;

public final class c {
    public static void a(final f fVar, final Point point, final a aVar) {
        AppMethodBeat.i(258547);
        PlaySound.play(MMApplicationContext.getContext(), R.string.j06);
        if (fVar.bCI()) {
            fVar.a(new f.b() {
                /* class com.tencent.mm.plugin.ball.ui.c.AnonymousClass1 */
                final /* synthetic */ float oYd = -1.0f;

                @Override // com.tencent.mm.plugin.ball.a.f.b
                public final void ei(boolean z) {
                    AppMethodBeat.i(106296);
                    if (!z) {
                        Log.i("MicroMsg.FloatBallSwipeTransformationHelper", "doTransform, convertToTranslucent not complete");
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.ball.ui.c.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(106294);
                                if (aVar != null) {
                                    aVar.awJ();
                                }
                                AppMethodBeat.o(106294);
                            }
                        });
                        AppMethodBeat.o(106296);
                        return;
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.ball.ui.c.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(106295);
                            if (point != null) {
                                f fVar = fVar;
                                Point point = point;
                                float f2 = AnonymousClass1.this.oYd;
                                a aVar = aVar;
                                Log.i("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, ballPos(x:%d, y:%d), lastSwipePosX:%f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f2));
                                if (fVar.getMaskView() == null) {
                                    Log.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page mask view is null");
                                    aVar.awJ();
                                    AppMethodBeat.o(106295);
                                } else if (fVar.getContentView() == null) {
                                    Log.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page content view is null");
                                    aVar.awJ();
                                    AppMethodBeat.o(106295);
                                } else if (fVar.chG() == null) {
                                    Log.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page root view is null");
                                    aVar.awJ();
                                    AppMethodBeat.o(106295);
                                } else {
                                    Bitmap bitmap = fVar.getBitmap();
                                    if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
                                        Log.w("MicroMsg.FloatBallSwipeTransformationHelper", "doMaskAnimation, page get bitmap is null");
                                        aVar.awJ();
                                        AppMethodBeat.o(106295);
                                        return;
                                    }
                                    e eVar = new e(fVar.getActivity(), bitmap);
                                    eVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                    int i2 = point.x;
                                    int i3 = point.y;
                                    eVar.pcW = i2;
                                    eVar.pcX = i3;
                                    eVar.pcV = com.tencent.mm.plugin.ball.f.e.oYK / 2;
                                    eVar.setContentStartPosX((int) f2);
                                    eVar.setListener(new AnimatorListenerAdapter(eVar, aVar, fVar) {
                                        /* class com.tencent.mm.plugin.ball.ui.c.AnonymousClass3 */
                                        final /* synthetic */ a oYa;
                                        final /* synthetic */ f oYc;
                                        final /* synthetic */ e oYf;

                                        {
                                            this.oYf = r1;
                                            this.oYa = r2;
                                            this.oYc = r3;
                                        }

                                        public final void onAnimationEnd(Animator animator) {
                                            AppMethodBeat.i(106300);
                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                /* class com.tencent.mm.plugin.ball.ui.c.AnonymousClass3.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(106298);
                                                    if (AnonymousClass3.this.oYf.getParent() != null) {
                                                        ((ViewGroup) AnonymousClass3.this.oYf.getParent()).removeView(AnonymousClass3.this.oYf);
                                                    }
                                                    AppMethodBeat.o(106298);
                                                }
                                            });
                                            this.oYa.onAnimationEnd();
                                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                                /* class com.tencent.mm.plugin.ball.ui.c.AnonymousClass3.AnonymousClass2 */

                                                public final void run() {
                                                    AppMethodBeat.i(106299);
                                                    if (!(AnonymousClass3.this.oYc == null || AnonymousClass3.this.oYc.getContentView() == null)) {
                                                        AnonymousClass3.this.oYc.getContentView().setVisibility(0);
                                                    }
                                                    AppMethodBeat.o(106299);
                                                }
                                            }, 200);
                                            AppMethodBeat.o(106300);
                                        }
                                    });
                                    ViewGroup chG = fVar.chG();
                                    chG.addView(eVar, chG.getChildCount());
                                    fVar.getContentView().setVisibility(8);
                                    LinearInterpolator linearInterpolator = new LinearInterpolator();
                                    eVar.pcZ = eVar.pcY > 0;
                                    PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("canvasTranslationX", eVar.pcY, eVar.pcY < eVar.pcW ? eVar.pcY : eVar.pcW);
                                    int i4 = eVar.pcW;
                                    if (eVar.pcZ) {
                                        if (eVar.pcY < eVar.pcW) {
                                            i4 = eVar.pcW - eVar.pcY;
                                        } else {
                                            i4 = 0;
                                        }
                                    }
                                    ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("translationX", 0, i4), PropertyValuesHolder.ofInt("translationY", 0, eVar.pcX), PropertyValuesHolder.ofFloat("scaleX", 1.0f, (2.0f * ((float) eVar.pcV)) / ((float) eVar.mWidth)), PropertyValuesHolder.ofFloat("scaleY", 1.0f, (2.0f * ((float) eVar.pcV)) / ((float) eVar.mHeight)), ofInt, PropertyValuesHolder.ofInt("bgAlpha", 255, 0));
                                    ofPropertyValuesHolder.setDuration(300L);
                                    ofPropertyValuesHolder.setInterpolator(linearInterpolator);
                                    ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                        /* class com.tencent.mm.plugin.ball.view.e.AnonymousClass1 */

                                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                            AppMethodBeat.i(106520);
                                            e.this.pcU = ((Integer) valueAnimator.getAnimatedValue("canvasTranslationX")).intValue();
                                            e.this.pcT.left = (float) ((Integer) valueAnimator.getAnimatedValue("translationX")).intValue();
                                            e.this.pcT.top = (float) ((Integer) valueAnimator.getAnimatedValue("translationY")).intValue();
                                            e.this.pcT.right = (((Float) valueAnimator.getAnimatedValue("scaleX")).floatValue() * ((float) e.this.mWidth)) + e.this.pcT.left;
                                            e.this.pcT.bottom = (((Float) valueAnimator.getAnimatedValue("scaleY")).floatValue() * ((float) e.this.mHeight)) + e.this.pcT.top;
                                            e.this.pda = ((Integer) valueAnimator.getAnimatedValue("bgAlpha")).intValue();
                                            e.this.postInvalidate();
                                            AppMethodBeat.o(106520);
                                        }
                                    });
                                    ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                                        /* class com.tencent.mm.plugin.ball.view.e.AnonymousClass2 */

                                        public final void onAnimationEnd(Animator animator) {
                                            AppMethodBeat.i(106521);
                                            if (e.this.pdb != null) {
                                                e.this.pdb.onAnimationEnd(animator);
                                            }
                                            e.this.setVisibility(8);
                                            AppMethodBeat.o(106521);
                                        }
                                    });
                                    ofPropertyValuesHolder.start();
                                    AppMethodBeat.o(106295);
                                }
                            } else {
                                if (aVar != null) {
                                    aVar.awJ();
                                }
                                AppMethodBeat.o(106295);
                            }
                        }
                    });
                    AppMethodBeat.o(106296);
                }
            });
            AppMethodBeat.o(258547);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ball.ui.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(106297);
                if (aVar != null) {
                    aVar.awJ();
                }
                AppMethodBeat.o(106297);
            }
        });
        AppMethodBeat.o(258547);
    }
}
