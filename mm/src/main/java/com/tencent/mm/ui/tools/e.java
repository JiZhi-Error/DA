package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class e {
    private int Al = 0;
    private int Am = 0;
    boolean EHq = false;
    boolean EHr = false;
    boolean EHs = false;
    int QtA = 0;
    private int QtB = 0;
    private int QtC = 0;
    float QtD = 0.0f;
    float QtE = 0.0f;
    private float QtF = 1.0f;
    public float QtG = 1.0f;
    private int QtH = 0;
    int QtI = 0;
    float QtJ = 1.0f;
    public int QtK = 0;
    int QtL = 0;
    int QtM = 0;
    int QtN = 0;
    int QtO = 0;
    private int QtP = 300;
    private int QtQ = 10;
    int QtR = 0;
    int QtS = 1;
    int QtT = 2;
    int QtU = 3;
    int QtV = 4;
    int QtW = this.QtR;
    d QtX;
    f QtY;
    private AbstractC2131e QtZ;
    int Qtz = 0;
    b Qua;
    private float aYP = 0.0f;
    private float aYQ = 0.0f;
    float aZg = 0.0f;
    float aZh = 0.0f;
    private final Context context;
    private MMHandler mHandler = new MMHandler();
    int mHeight = 0;
    VelocityTracker mVelocityTracker;
    int mWidth = 0;

    @TargetApi(18)
    public interface a {
        void L(int i2, int i3, int i4, int i5);
    }

    public interface b {
        void onExit();
    }

    public interface c {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public interface d {
        void bmu();
    }

    /* renamed from: com.tencent.mm.ui.tools.e$e  reason: collision with other inner class name */
    public interface AbstractC2131e {
        void S(float f2, float f3);
    }

    public interface f {
        void onClick();
    }

    public e(Context context2) {
        AppMethodBeat.i(143093);
        this.context = context2;
        AppMethodBeat.o(143093);
    }

    public final void Q(int i2, int i3, int i4, int i5) {
        this.Al = i2;
        this.Am = i3;
        this.mWidth = i4;
        this.mHeight = i5;
    }

    public final void ls(int i2, int i3) {
        this.Qtz = i2;
        this.QtA = i3;
    }

    public final void lt(int i2, int i3) {
        this.QtL = i2;
        this.QtM = i3;
        this.QtN = 0;
        this.QtO = 0;
    }

    public final void gXF() {
        this.QtG = 1.0f;
    }

    public final void lu(int i2, int i3) {
        this.QtH = i2;
        this.QtI = i3;
    }

    private void U(View view, boolean z) {
        int i2;
        AppMethodBeat.i(143094);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (this.Al == 0 && this.Am == 0) {
            this.Al = view.getWidth() / 2;
            this.Am = view.getHeight() / 2;
        }
        this.QtB = this.Al - iArr[0];
        this.QtC = this.Am - iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            int i3 = this.Qtz;
            height = this.QtA;
            i2 = i3;
        } else {
            i2 = width;
        }
        if (!(i2 == 0 || height == 0)) {
            this.aYP = ((float) this.mWidth) / ((float) i2);
            this.aYQ = ((float) this.mHeight) / ((float) height);
        }
        float f2 = this.QtF;
        if (!(this.QtL == 0 && this.QtM == 0 && this.QtN == 0 && this.QtO == 0)) {
            f2 = 1.1f;
        }
        if (z) {
            f2 = 1.0f;
            if (!(this.Qtz == 0 || this.QtA == 0)) {
                this.aYP = ((float) this.mWidth) / ((float) this.Qtz);
                this.aYQ = ((float) this.mHeight) / ((float) this.QtA);
            }
        }
        if (((double) this.QtG) != 1.0d) {
            this.QtB += iArr[0];
            this.QtC += iArr[1];
            this.QtD = this.aYP * this.QtG;
            this.QtE = this.QtD;
            this.QtC = (int) (((float) this.QtC) - (((float) this.QtI) * this.QtD));
            this.QtB = (int) (((float) this.QtB) - (((float) this.QtH) * this.QtD));
            AppMethodBeat.o(143094);
            return;
        }
        if (this.aYP > this.aYQ) {
            this.QtD = this.aYP * f2;
            this.QtC = (int) (((float) this.QtC) - (((((float) height) * this.QtD) - (((float) this.mHeight) * f2)) / 2.0f));
        } else {
            this.QtD = this.aYQ * f2;
            this.QtB = (int) (((float) this.QtB) - (((((float) i2) * this.QtD) - (((float) this.mWidth) * f2)) / 2.0f));
            if (this.QtA != 0 && this.QtA < height) {
                this.QtC = (int) (((float) this.QtC) - (((((float) height) * this.QtD) - (((float) this.mHeight) * f2)) / 2.0f));
            }
        }
        this.QtC = (int) ((((float) this.QtC) - ((((float) this.mHeight) * (f2 - 1.0f)) / 2.0f)) - ((((float) this.QtK) * this.QtD) / 2.0f));
        this.QtB = (int) (((float) this.QtB) - ((((float) this.mWidth) * (f2 - 1.0f)) / 2.0f));
        if (this.QtA != 0 && this.Am < (height - this.QtA) / 2) {
            this.QtC = (int) ((((f2 - 1.0f) * ((float) this.mHeight)) / 2.0f) + ((float) this.QtC));
        } else if (this.QtA != 0 && this.Am + this.mHeight > (this.QtA + height) / 2) {
            this.QtC = (int) (((float) this.QtC) - (((f2 - 1.0f) * ((float) this.mHeight)) / 2.0f));
        }
        if (this.mWidth == 0 && this.mHeight == 0) {
            this.QtD = 0.5f;
            this.QtJ = 0.0f;
            this.QtB = (int) (((float) this.QtB) - ((((float) i2) * this.QtD) / 2.0f));
            this.QtC = (int) ((((float) this.QtC) - ((((float) height) * this.QtD) / 2.0f)) - ((((float) this.QtK) * this.QtD) / 2.0f));
        }
        AppMethodBeat.o(143094);
    }

    @TargetApi(16)
    public final void a(final View view, final View view2, final c cVar) {
        AppMethodBeat.i(143095);
        if (Build.VERSION.SDK_INT < 12 || view == null || this.QtW == this.QtT || this.QtW == this.QtV || this.QtW == this.QtU) {
            Log.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", Integer.valueOf(this.QtW), view);
            AppMethodBeat.o(143095);
        } else if (Float.isNaN(this.QtD)) {
            AppMethodBeat.o(143095);
        } else {
            U(view, false);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(this.QtD);
            view.setScaleY(this.QtD);
            view.setTranslationX((float) this.QtB);
            view.setTranslationY((float) this.QtC);
            if (view2 != null) {
                view2.setAlpha(0.0f);
                view2.animate().setDuration((long) this.QtP).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(1.0f).setListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.ui.tools.e.AnonymousClass1 */

                    public final void onAnimationStart(Animator animator) {
                        AppMethodBeat.i(143080);
                        view2.setLayerType(2, null);
                        AppMethodBeat.o(143080);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(143081);
                        view2.setLayerType(0, null);
                        Log.i("MicroMsg.ImagePreviewAnimation", "pennqin, bg animation result, alpha %s.", Float.valueOf(view2.getAlpha()));
                        AppMethodBeat.o(143081);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
            }
            view.animate().setDuration((long) this.QtP).setInterpolator(new DecelerateInterpolator(1.2f)).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.ui.tools.e.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(143082);
                    if (cVar != null) {
                        cVar.onAnimationStart();
                    }
                    e.this.QtW = e.this.QtT;
                    AppMethodBeat.o(143082);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(143083);
                    if (cVar != null) {
                        cVar.onAnimationEnd();
                    }
                    e.this.QtW = e.this.QtU;
                    Log.i("MicroMsg.ImagePreviewAnimation", "pennqin, gallery animation result, sx %s, sy %s, tx %s, ty %s.", Float.valueOf(view.getScaleX()), Float.valueOf(view.getScaleY()), Float.valueOf(view.getTranslationX()), Float.valueOf(view.getTranslationY()));
                    AppMethodBeat.o(143083);
                }

                public final void onAnimationCancel(Animator animator) {
                    e.this.QtW = e.this.QtU;
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.tools.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(143084);
                    if (e.this.QtW == e.this.QtR) {
                        Log.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
                        view.requestLayout();
                    }
                    AppMethodBeat.o(143084);
                }
            }, (long) this.QtQ);
            AppMethodBeat.o(143095);
        }
    }

    @TargetApi(16)
    public final void a(final View view, final View view2, final c cVar, final a aVar) {
        AppMethodBeat.i(143096);
        if (Build.VERSION.SDK_INT < 12 || view == null || this.QtW == this.QtT || this.QtW == this.QtV || this.QtW == this.QtS) {
            Log.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", Integer.valueOf(this.QtW), view);
            AppMethodBeat.o(143096);
            return;
        }
        U(view, true);
        if (view2 != null) {
            view2.animate().setDuration(200).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f).setListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.ui.tools.e.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(143085);
                    view2.setLayerType(2, null);
                    AppMethodBeat.o(143085);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(143086);
                    view2.setLayerType(0, null);
                    AppMethodBeat.o(143086);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        AnimationSet animationSet = new AnimationSet(true);
        AnonymousClass5 r0 = new ScaleAnimation(this.QtD, this.QtD) {
            /* class com.tencent.mm.ui.tools.e.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public final void applyTransformation(float f2, Transformation transformation) {
                AppMethodBeat.i(143087);
                if (!(e.this.Qtz == 0 || e.this.QtA == 0 || e.this.QtG != 1.0f)) {
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    int i2 = (rect.right - rect.left) / 2;
                    int i3 = ((rect.bottom - rect.top) + e.this.QtK) / 2;
                    int i4 = (int) (((((float) (e.this.Qtz - e.this.mWidth)) * (1.0f - f2)) + ((float) e.this.mWidth)) / (1.0f - ((1.0f - e.this.QtD) * f2)));
                    int i5 = (int) (((((float) (e.this.QtA - e.this.mHeight)) * (1.0f - f2)) + ((float) e.this.mHeight)) / (1.0f - ((1.0f - e.this.QtD) * f2)));
                    if (e.this.QtG != 1.0f) {
                        e.this.QtD = e.this.QtE / e.this.QtG;
                        int i6 = rect.right;
                        int i7 = rect.left;
                        i2 = (rect.right + rect.left) / 2;
                        i3 = (e.this.QtI - rect.top) + ((int) (((float) e.this.QtA) / 2.0f));
                        i4 = (int) (((((float) (e.this.Qtz - e.this.mWidth)) * (1.0f - f2)) + ((float) e.this.mWidth)) / (1.0f - ((1.0f - e.this.QtD) * f2)));
                        i5 = (int) (((((float) (e.this.QtA - e.this.mHeight)) * (1.0f - f2)) + ((float) e.this.mHeight)) / (1.0f - ((1.0f - e.this.QtD) * f2)));
                    }
                    int i8 = (int) (((float) (i2 - (i4 / 2))) + ((((float) e.this.QtL) * f2) / (1.0f - ((1.0f - e.this.QtD) * f2))));
                    int i9 = (int) ((((float) (i3 - (i5 / 2))) - ((((float) e.this.QtK) * (1.0f - f2)) / 2.0f)) + ((((float) e.this.QtN) * f2) / (1.0f - ((1.0f - e.this.QtD) * f2))));
                    int i10 = (int) (((float) ((i4 / 2) + i2)) - ((((float) e.this.QtM) * f2) / (1.0f - ((1.0f - e.this.QtD) * f2))));
                    int i11 = (int) (((float) ((i5 / 2) + i3)) - ((((float) e.this.QtO) * f2) / (1.0f - ((1.0f - e.this.QtD) * f2))));
                    if (Build.VERSION.SDK_INT >= 21) {
                        view.setClipBounds(new Rect(i8, i9, i10, i11));
                    } else if (Build.VERSION.SDK_INT >= 18) {
                        if (aVar != null) {
                            aVar.L(i8, i9, i10, i11);
                        } else {
                            view.setClipBounds(new Rect(i8 + view.getScrollX(), i9, i10 + view.getScrollX(), i11));
                        }
                    }
                }
                super.applyTransformation(f2, transformation);
                AppMethodBeat.o(143087);
            }
        };
        r0.setDuration(200);
        r0.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(r0);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) this.QtB, 0.0f, (float) this.QtC);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, this.QtJ);
        alphaAnimation.setDuration(200);
        alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.ui.tools.e.AnonymousClass6 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(143088);
                Log.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
                if (cVar != null) {
                    cVar.onAnimationStart();
                }
                e.this.QtW = e.this.QtV;
                AppMethodBeat.o(143088);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(143089);
                Log.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
                if (cVar != null) {
                    cVar.onAnimationEnd();
                }
                e.this.QtW = e.this.QtS;
                AppMethodBeat.o(143089);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(animationSet);
        AppMethodBeat.o(143096);
    }

    public final void a(d dVar) {
        this.QtX = dVar;
    }

    public final void a(f fVar) {
        this.QtY = fVar;
    }

    public final void a(AbstractC2131e eVar) {
        this.QtZ = eVar;
    }

    public final void a(b bVar) {
        this.Qua = bVar;
    }

    public final void b(final View view, final View view2, final View view3) {
        AppMethodBeat.i(143097);
        final GestureDetector gestureDetector = new GestureDetector(this.context, new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.ui.tools.e.AnonymousClass7 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(205367);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(205367);
                return onContextClick;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(205366);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(205366);
                return onDoubleTap;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(143090);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                e.this.EHs = true;
                if (e.this.QtX != null) {
                    e.this.QtX.bmu();
                }
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(143090);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(143091);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                if (e.this.QtY != null) {
                    e.this.QtY.onClick();
                }
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(143091);
                return onSingleTapUp;
            }
        });
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.tools.e.AnonymousClass8 */
            final /* synthetic */ c Qud = null;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(143092);
                GestureDetector gestureDetector = gestureDetector;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                if (e.this.mVelocityTracker == null) {
                    e.this.mVelocityTracker = VelocityTracker.obtain();
                }
                e.this.mVelocityTracker.addMovement(motionEvent);
                if (motionEvent.getAction() == 0) {
                    e.this.aZg = motionEvent.getX();
                    e.this.aZh = motionEvent.getY();
                }
                if (motionEvent.getAction() == 1) {
                    if (e.this.EHr && e.this.EHq) {
                        e.a(e.this, 0.0f, 0.0f, view, view2, view3);
                        e.this.EHq = false;
                    } else if (e.this.EHq) {
                        if (e.this.Qua != null) {
                            e.this.Qua.onExit();
                        } else {
                            e.this.a(view, view2, this.Qud, null);
                        }
                        e.this.EHq = false;
                        e.this.EHr = false;
                    }
                    e.this.EHs = false;
                }
                if (motionEvent.getAction() == 2) {
                    if (com.tencent.mm.ui.base.f.ai(motionEvent) == 2) {
                        AppMethodBeat.o(143092);
                        return false;
                    }
                    VelocityTracker velocityTracker = e.this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    int yVelocity = (int) velocityTracker.getYVelocity();
                    float x = motionEvent.getX() - e.this.aZg;
                    float y = motionEvent.getY() - e.this.aZh;
                    if ((Math.abs(x) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || e.this.EHs) && !e.this.EHq) {
                        e.this.EHq = false;
                    } else {
                        e.a(e.this, x, y, view, view2, view3);
                        e.this.EHq = true;
                    }
                    if (y > 200.0f) {
                        e.this.EHr = false;
                    } else {
                        e.this.EHr = true;
                    }
                    if (e.this.mVelocityTracker != null) {
                        e.this.mVelocityTracker.recycle();
                        e.this.mVelocityTracker = null;
                    }
                }
                AppMethodBeat.o(143092);
                return false;
            }
        });
        AppMethodBeat.o(143097);
    }

    static /* synthetic */ void a(e eVar, float f2, float f3, View view, View view2, View view3) {
        AppMethodBeat.i(143098);
        if (eVar.QtZ != null) {
            eVar.QtZ.S(f2, f3);
        }
        float height = 1.0f - (f3 / ((float) view.getHeight()));
        if (height > 1.0f) {
            height = 1.0f;
        }
        if (!Float.isNaN(height)) {
            if (((double) height) != 1.0d) {
                eVar.QtG = 1.0f / height;
                if (!(f2 == 0.0f && f3 == 0.0f)) {
                    eVar.QtH = (int) (((float) ((int) ((1.0f - height) * ((float) (view.getWidth() / 2))))) + f2);
                    eVar.QtI = (int) ((((float) (view.getHeight() / 2)) + f3) - (((float) (eVar.QtA / 2)) * height));
                }
            }
            Log.d("MicroMsg.ImagePreviewAnimation", "onGalleryScale tx: %f, ty: %f, scale: %f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(height));
            if (view3 != null) {
                view3.setPivotX((float) (view.getWidth() / 2));
                view3.setPivotY((float) (view.getHeight() / 2));
                view3.setScaleX(height);
                view3.setScaleY(height);
                view3.setTranslationX(f2);
                view3.setTranslationY(f3);
                view2.setAlpha(height);
                AppMethodBeat.o(143098);
                return;
            }
            Log.d("MicroMsg.ImagePreviewAnimation", "runDragAnimation contentView is null !!");
        }
        AppMethodBeat.o(143098);
    }
}
