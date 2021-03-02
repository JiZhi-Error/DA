package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView extends FrameLayout {
    public static DisplayMetrics metrics;
    GestureDetector jKk = new GestureDetector(new GestureDetector.OnGestureListener() {
        /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass14 */

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(65129);
            Log.d("ShuffleView", "gesture down");
            switch (ShuffleView.this.yTz.yTX) {
                case 4:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    for (int i2 = 0; i2 < ShuffleView.this.yTJ; i2++) {
                        Rect a2 = ShuffleView.a(ShuffleView.this, i2);
                        if (a2 != null && a2.contains(x, y)) {
                            View view = (View) ShuffleView.this.yTy.get(i2);
                            if (ShuffleView.this.kmM != view && ShuffleView.this.kmM != null) {
                                ShuffleView.m(ShuffleView.this);
                            } else if (ShuffleView.this.kmM == view) {
                                Log.i("ShuffleView", "down on the select card");
                                AppMethodBeat.o(65129);
                                return true;
                            }
                            ShuffleView.b(ShuffleView.this, i2);
                            AppMethodBeat.o(65129);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(65129);
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(65130);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            switch (ShuffleView.this.yTz.yTX) {
                case 4:
                    if (ShuffleView.this.kmM != null) {
                        Log.d("ShuffleView", "click the select card");
                        if (ShuffleView.this.yTD != null) {
                            ShuffleView.this.yTD.gT(ShuffleView.this.yTG, ShuffleView.this.yTJ);
                        }
                        ShuffleView.m(ShuffleView.this);
                    }
                    if (ShuffleView.this.yTH != null) {
                        if (ShuffleView.this.yTD != null) {
                            b bVar2 = ShuffleView.this.yTD;
                            int unused = ShuffleView.this.yTI;
                            bVar2.PE(ShuffleView.this.yTJ);
                        }
                        ShuffleView.c(ShuffleView.this, ShuffleView.this.yTI);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(65130);
                    return true;
                default:
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(65130);
                    return false;
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            View view;
            AppMethodBeat.i(65131);
            if (motionEvent2.getActionMasked() == 2) {
                int x = (int) motionEvent2.getX();
                int y = (int) motionEvent2.getY();
                switch (ShuffleView.this.yTz.yTX) {
                    case 4:
                        if (Math.abs(f3) < ((float) ShuffleView.this.yTQ)) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < ShuffleView.this.yTJ) {
                                    Rect a2 = ShuffleView.a(ShuffleView.this, i2);
                                    if (a2 != null && a2.contains(x, y)) {
                                        View view2 = (View) ShuffleView.this.yTy.get(i2);
                                        if (ShuffleView.this.kmM != view2 && ShuffleView.this.kmM != null) {
                                            ShuffleView.m(ShuffleView.this);
                                        } else if (ShuffleView.this.kmM == view2) {
                                            Log.i("ShuffleView", "scroll on the select card");
                                        }
                                        if (ShuffleView.this.yTH != view2) {
                                            ShuffleView.p(ShuffleView.this);
                                            ShuffleView.b(ShuffleView.this, i2);
                                        }
                                    }
                                    i2++;
                                }
                            }
                        }
                        if (Math.abs(f2) < ((float) ShuffleView.this.yTQ)) {
                            Log.d("ShuffleView", "scroll distanceY:".concat(String.valueOf(f3)));
                            if (ShuffleView.this.yTH != null) {
                                view = ShuffleView.this.yTH;
                            } else if (ShuffleView.this.kmM != null) {
                                view = ShuffleView.this.kmM;
                            } else {
                                view = null;
                            }
                            if (view != null) {
                                Log.i("ShuffleView", "scroll translationY:" + view.getTranslationY() + "," + (view.getHeight() / 7));
                                if (((int) view.getTranslationY()) <= (-view.getHeight()) / 7) {
                                    if (f3 < 0.0f && Math.abs(f3) > ((float) ShuffleView.this.yTQ)) {
                                        if (((int) f3) <= (-view.getHeight()) / 7) {
                                            view.setTranslationY(0.0f);
                                        } else {
                                            view.setTranslationY(view.getTranslationY() - f3);
                                        }
                                        if (view == ShuffleView.this.kmM) {
                                            ShuffleView.this.yTH = ShuffleView.this.kmM;
                                            ShuffleView.this.yTI = ShuffleView.this.yTG;
                                            if (ShuffleView.this.yTA.isStarted()) {
                                                Log.i("ShuffleView", "scroll when select view is animation");
                                                ShuffleView.this.yTA.cancel();
                                            }
                                            ShuffleView.this.kmM = null;
                                            ShuffleView.this.yTG = 0;
                                        }
                                    }
                                } else if (view.getTranslationY() == 0.0f) {
                                    if (f3 > 0.0f && Math.abs(f3) > ((float) ShuffleView.this.yTQ)) {
                                        if (((int) f3) >= view.getHeight() / 7) {
                                            view.setTranslationY((float) ((-view.getHeight()) / 7));
                                        } else {
                                            view.setTranslationY(view.getTranslationY() - f3);
                                        }
                                    }
                                } else if (f3 < 0.0f) {
                                    if (view.getTranslationY() - f3 >= 0.0f) {
                                        view.setTranslationY(0.0f);
                                    } else {
                                        view.setTranslationY(view.getTranslationY() - f3);
                                    }
                                } else if (((int) (view.getTranslationY() - f3)) <= (-view.getHeight()) / 7) {
                                    view.setTranslationY((float) ((-view.getHeight()) / 7));
                                } else {
                                    view.setTranslationY(view.getTranslationY() - f3);
                                }
                            }
                            AppMethodBeat.o(65131);
                            break;
                        }
                        break;
                    default:
                        AppMethodBeat.o(65131);
                        break;
                }
                return false;
            }
            AppMethodBeat.o(65131);
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(213266);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(213266);
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(65132);
            Log.i("ShuffleView", "fling up ".concat(String.valueOf(f3)));
            if (f3 < ((float) (-ShuffleView.this.yTR))) {
                switch (ShuffleView.this.yTz.yTX) {
                    case 4:
                        if (ShuffleView.this.kmM != null) {
                            ShuffleView.m(ShuffleView.this);
                        }
                        if (ShuffleView.this.yTH != null) {
                            if (ShuffleView.this.yTD != null) {
                                b bVar = ShuffleView.this.yTD;
                                int unused = ShuffleView.this.yTI;
                                bVar.PE(ShuffleView.this.yTJ);
                            }
                            ShuffleView.c(ShuffleView.this, ShuffleView.this.yTI);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(65132);
                return true;
            }
            AppMethodBeat.o(65132);
            return false;
        }
    });
    View kmM;
    ValueAnimator rnC;
    private ValueAnimator tMC;
    ValueAnimator tMD;
    private float translationX;
    private float translationY;
    ValueAnimator yTA;
    private a yTB;
    private a yTC;
    private b yTD;
    View yTE;
    private View yTF;
    int yTG;
    private View yTH;
    private int yTI;
    int yTJ;
    private final float yTK = 0.23f;
    private final float yTL = 0.28f;
    private final float yTM = 0.33f;
    private ArrayList<Float> yTN = new ArrayList<>();
    private ArrayList<Float> yTO = new ArrayList<>();
    private boolean yTP;
    private int yTQ = getResources().getDimensionPixelSize(R.dimen.aay);
    private int yTR = 2500;
    List<View> yTy = new ArrayList();
    private c yTz = new c();

    /* access modifiers changed from: package-private */
    public interface a {
        void a(ValueAnimator valueAnimator, View view);
    }

    /* access modifiers changed from: package-private */
    public interface b {
        void PE(int i2);

        void gS(int i2, int i3);

        void gT(int i2, int i3);
    }

    static /* synthetic */ Rect a(ShuffleView shuffleView, int i2) {
        AppMethodBeat.i(65153);
        Rect PI = shuffleView.PI(i2);
        AppMethodBeat.o(65153);
        return PI;
    }

    static /* synthetic */ void a(ShuffleView shuffleView) {
        AppMethodBeat.i(65150);
        shuffleView.eeT();
        AppMethodBeat.o(65150);
    }

    static /* synthetic */ void c(ShuffleView shuffleView, int i2) {
        AppMethodBeat.i(65156);
        shuffleView.PH(i2);
        AppMethodBeat.o(65156);
    }

    static /* synthetic */ void f(ShuffleView shuffleView, int i2) {
        AppMethodBeat.i(65158);
        shuffleView.PJ(i2);
        AppMethodBeat.o(65158);
    }

    static /* synthetic */ float g(ShuffleView shuffleView) {
        AppMethodBeat.i(65151);
        float selectScaleTranslationX = shuffleView.getSelectScaleTranslationX();
        AppMethodBeat.o(65151);
        return selectScaleTranslationX;
    }

    static /* synthetic */ float j(ShuffleView shuffleView) {
        AppMethodBeat.i(65152);
        float touchScaleTranslationX = shuffleView.getTouchScaleTranslationX();
        AppMethodBeat.o(65152);
        return touchScaleTranslationX;
    }

    static /* synthetic */ void m(ShuffleView shuffleView) {
        AppMethodBeat.i(65154);
        shuffleView.eeV();
        AppMethodBeat.o(65154);
    }

    static /* synthetic */ void p(ShuffleView shuffleView) {
        AppMethodBeat.i(65157);
        shuffleView.eeW();
        AppMethodBeat.o(65157);
    }

    static /* synthetic */ int y(ShuffleView shuffleView) {
        AppMethodBeat.i(65159);
        int eeU = shuffleView.eeU();
        AppMethodBeat.o(65159);
        return eeU;
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public float scaleX = 0.01f;
        public float scaleY = 0.01f;
        public int yTW = 1;
        public int yTX = 1;
        public int yTY = 2;
        public int yTZ = 200;
        public int yUa = 80;

        c() {
        }
    }

    public ShuffleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65134);
        AppMethodBeat.o(65134);
    }

    public void setShuffleSetting(c cVar) {
        AppMethodBeat.i(65135);
        this.yTz = cVar;
        this.rnC = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration((long) cVar.yTZ);
        this.yTA = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration((long) cVar.yUa);
        AppMethodBeat.o(65135);
    }

    public void setAllShuffleCards(List<View> list) {
        AppMethodBeat.i(65136);
        this.yTy.clear();
        this.yTy.addAll(list);
        this.yTG = 0;
        this.kmM = null;
        this.yTI = -1;
        this.yTH = null;
        removeAllViews();
        List<View> list2 = this.yTy;
        if (list2.size() > 100) {
            this.yTJ = 100;
        } else {
            this.yTJ = list2.size();
            if (this.yTJ == 1) {
                list2.get(0).findViewById(R.id.f1_).setVisibility(0);
            }
        }
        for (int i2 = this.yTJ - 1; i2 >= 0; i2--) {
            addView(list2.get(i2));
        }
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass1 */

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(65114);
                ShuffleView.a(ShuffleView.this);
                ShuffleView shuffleView = ShuffleView.this;
                for (int i10 = 0; i10 < shuffleView.yTJ; i10++) {
                    shuffleView.al(shuffleView.yTy.get(i10), i10);
                }
                ShuffleView.this.removeOnLayoutChangeListener(this);
                AppMethodBeat.o(65114);
            }
        });
        AppMethodBeat.o(65136);
    }

    private void eeT() {
        AppMethodBeat.i(65137);
        if (this.yTJ > 1) {
            Log.d("ShuffleView", "card width: %d,height: %d", Integer.valueOf(this.yTy.get(0).getWidth()), Integer.valueOf(this.yTy.get(0).getHeight()));
            if (this.yTz.yTW == 2) {
                this.translationX = (((float) this.yTy.get(0).getWidth()) * 1.5f) / ((float) this.yTJ);
                if (this.translationX > ((float) this.yTy.get(0).getWidth()) * 0.23f) {
                    this.translationX = ((float) this.yTy.get(0).getWidth()) * 0.23f;
                    AppMethodBeat.o(65137);
                    return;
                }
            } else if (this.yTz.yTW == 1) {
                this.translationY = (((float) this.yTy.get(0).getHeight()) * 1.0f) / ((float) this.yTJ);
                AppMethodBeat.o(65137);
                return;
            }
        } else {
            this.translationX = 0.0f;
            this.translationY = 0.0f;
        }
        AppMethodBeat.o(65137);
    }

    /* access modifiers changed from: package-private */
    public final void al(View view, int i2) {
        AppMethodBeat.i(65138);
        if (this.yTz.yTW == 1) {
            view.setScaleX(1.0f - (this.yTz.scaleX * ((float) i2)));
            view.setTranslationY(PG(i2));
            AppMethodBeat.o(65138);
            return;
        }
        if (this.yTz.yTW == 2) {
            view.setScaleY(1.0f - (this.yTz.scaleY * ((float) i2)));
            view.setTranslationX(PF(i2));
        }
        AppMethodBeat.o(65138);
    }

    public final float PF(int i2) {
        if (this.yTz.yTW == 2 && this.yTJ > 0) {
            if (this.yTz.yTX == 3) {
                return ((((float) (this.yTJ - 1)) * 0.5f) * this.translationX) - (this.translationX * ((float) i2));
            }
            if (this.yTz.yTX == 4) {
                return (this.translationX * ((float) i2)) - ((((float) (this.yTJ - 1)) * 0.5f) * this.translationX);
            }
        }
        return 0.0f;
    }

    public final float PG(int i2) {
        if (this.yTz.yTW == 1) {
            if (this.yTz.yTX == 1) {
                return ((((float) (this.yTJ - 1)) * 0.5f) * this.translationY) - (this.translationY * ((float) i2));
            }
            if (this.yTz.yTX == 2) {
                return (this.translationY * ((float) i2)) - ((((float) (this.yTJ - 1)) * 0.5f) * this.translationY);
            }
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final int eeU() {
        AppMethodBeat.i(65139);
        int random = (int) (Math.random() * ((double) this.yTJ));
        AppMethodBeat.o(65139);
        return random;
    }

    private void eeV() {
        AppMethodBeat.i(65140);
        if (this.kmM != null) {
            Log.i("ShuffleView", "selectView != null, cancel select");
            if (this.yTA.isStarted()) {
                this.yTA.cancel();
            }
            this.yTA.removeAllUpdateListeners();
            this.yTA.removeAllListeners();
            switch (this.yTz.yTX) {
                case 4:
                    if (this.yTG >= 0) {
                        this.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass8 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i2 = 0;
                                AppMethodBeat.i(65123);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.yTN.clear();
                                    ShuffleView.this.yTO.clear();
                                    while (i2 < ShuffleView.this.yTJ) {
                                        ShuffleView.this.yTN.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationX()));
                                        ShuffleView.this.yTO.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationY()));
                                        i2++;
                                    }
                                    AppMethodBeat.o(65123);
                                    return;
                                }
                                while (i2 < ShuffleView.this.yTJ) {
                                    ((View) ShuffleView.this.yTy.get(i2)).setTranslationX((((Float) ShuffleView.this.yTN.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(i2) * floatValue));
                                    ((View) ShuffleView.this.yTy.get(i2)).setTranslationY((((Float) ShuffleView.this.yTO.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i2) * floatValue));
                                    i2++;
                                }
                                AppMethodBeat.o(65123);
                            }
                        });
                        break;
                    }
                    break;
            }
            this.kmM = null;
            this.yTG = 0;
            this.yTA.start();
        }
        AppMethodBeat.o(65140);
    }

    private float getSelectScaleTranslationX() {
        AppMethodBeat.i(65141);
        if (this.kmM != null) {
            float width = (0.33f * ((float) this.kmM.getWidth())) - this.translationX;
            int i2 = this.yTG - 1;
            int i3 = (this.yTJ - 1) - this.yTG;
            int i4 = 0;
            if (i2 > 0) {
                i4 = i2 + 0;
            }
            if (i3 > 0) {
                i4 += i3;
            }
            if (i4 > 0) {
                float f2 = (width * 2.0f) / ((float) i4);
                AppMethodBeat.o(65141);
                return f2;
            }
        }
        AppMethodBeat.o(65141);
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final void PH(int i2) {
        AppMethodBeat.i(65142);
        if (i2 >= 0 && i2 < this.yTJ) {
            Log.i("ShuffleView", "select card ".concat(String.valueOf(i2)));
            if (this.yTA.isStarted()) {
                this.yTA.cancel();
            }
            this.yTA.removeAllUpdateListeners();
            this.yTA.removeAllListeners();
            this.kmM = this.yTy.get(i2);
            this.yTG = i2;
            this.yTH = null;
            this.yTI = -1;
            switch (this.yTz.yTX) {
                case 4:
                    if (i2 <= 0) {
                        this.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass10 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(65125);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.yTN.clear();
                                    ShuffleView.this.yTO.clear();
                                    for (int i2 = 0; i2 < ShuffleView.this.yTJ; i2++) {
                                        ShuffleView.this.yTN.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationX()));
                                        ShuffleView.this.yTO.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationY()));
                                    }
                                    AppMethodBeat.o(65125);
                                    return;
                                }
                                ShuffleView.this.kmM.setTranslationY((((Float) ShuffleView.this.yTO.get(0)).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.this.kmM.getHeight()) * floatValue) / 7.0f));
                                for (int i3 = 1; i3 < ShuffleView.this.yTJ; i3++) {
                                    ((View) ShuffleView.this.yTy.get(i3)).setTranslationX((((Float) ShuffleView.this.yTN.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(i3) * floatValue));
                                    ((View) ShuffleView.this.yTy.get(i3)).setTranslationY((((Float) ShuffleView.this.yTO.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i3) * floatValue));
                                }
                                AppMethodBeat.o(65125);
                            }
                        });
                        break;
                    } else {
                        final int i3 = i2 - 1;
                        final int i4 = (this.yTJ - 1) - i2;
                        this.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass9 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i2 = 0;
                                AppMethodBeat.i(65124);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.yTN.clear();
                                    ShuffleView.this.yTO.clear();
                                    while (i2 < ShuffleView.this.yTJ) {
                                        ShuffleView.this.yTN.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationX()));
                                        ShuffleView.this.yTO.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationY()));
                                        i2++;
                                    }
                                    AppMethodBeat.o(65124);
                                    return;
                                }
                                if (i3 > 0) {
                                    while (i2 < ShuffleView.this.yTG - 1) {
                                        ((View) ShuffleView.this.yTy.get(i2)).setTranslationX((((Float) ShuffleView.this.yTN.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.PF(i2) - (((float) (i2 + 1)) * ShuffleView.g(ShuffleView.this))) * floatValue));
                                        ((View) ShuffleView.this.yTy.get(i2)).setTranslationY((((Float) ShuffleView.this.yTO.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i2) * floatValue));
                                        i2++;
                                    }
                                    ((View) ShuffleView.this.yTy.get(ShuffleView.this.yTG - 1)).setTranslationX((((Float) ShuffleView.this.yTN.get(ShuffleView.this.yTG - 1)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.PF(ShuffleView.this.yTG - 1) - ((ShuffleView.g(ShuffleView.this) * ((float) i3)) / 2.0f)) * floatValue));
                                    ((View) ShuffleView.this.yTy.get(ShuffleView.this.yTG - 1)).setTranslationY((((Float) ShuffleView.this.yTO.get(ShuffleView.this.yTG - 1)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(ShuffleView.this.yTG - 1) * floatValue));
                                } else {
                                    while (i2 < ShuffleView.this.yTG) {
                                        ((View) ShuffleView.this.yTy.get(i2)).setTranslationX((((Float) ShuffleView.this.yTN.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(i2) * floatValue));
                                        ((View) ShuffleView.this.yTy.get(i2)).setTranslationY((((Float) ShuffleView.this.yTO.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i2) * floatValue));
                                        i2++;
                                    }
                                }
                                if (i4 > 0) {
                                    ShuffleView.this.kmM.setTranslationX((((Float) ShuffleView.this.yTN.get(ShuffleView.this.yTG)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.PF(ShuffleView.this.yTG) + ((ShuffleView.g(ShuffleView.this) * ((float) i4)) / 2.0f)) * floatValue));
                                    for (int i3 = ShuffleView.this.yTG + 1; i3 < ShuffleView.this.yTJ; i3++) {
                                        ((View) ShuffleView.this.yTy.get(i3)).setTranslationX((((Float) ShuffleView.this.yTN.get(i3)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.PF(i3) + (((float) (ShuffleView.this.yTJ - i3)) * ShuffleView.g(ShuffleView.this))) * floatValue));
                                        ((View) ShuffleView.this.yTy.get(i3)).setTranslationY((((Float) ShuffleView.this.yTO.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i3) * floatValue));
                                    }
                                } else {
                                    for (int i4 = ShuffleView.this.yTG; i4 < ShuffleView.this.yTJ; i4++) {
                                        ((View) ShuffleView.this.yTy.get(i4)).setTranslationX((((Float) ShuffleView.this.yTN.get(i4)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(i4) * floatValue));
                                        ((View) ShuffleView.this.yTy.get(i4)).setTranslationY((((Float) ShuffleView.this.yTO.get(i4)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i4) * floatValue));
                                    }
                                }
                                ShuffleView.this.kmM.setTranslationY((((Float) ShuffleView.this.yTO.get(ShuffleView.this.yTG)).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.this.kmM.getHeight()) * floatValue) / 7.0f));
                                AppMethodBeat.o(65124);
                            }
                        });
                        break;
                    }
            }
            this.yTA.start();
        }
        AppMethodBeat.o(65142);
    }

    private void eeW() {
        AppMethodBeat.i(65143);
        if (this.yTH != null) {
            Log.i("ShuffleView", "touchView != null,cancel touch");
            if (this.yTA.isStarted()) {
                this.yTA.cancel();
            }
            this.yTA.removeAllUpdateListeners();
            this.yTA.removeAllListeners();
            switch (this.yTz.yTX) {
                case 4:
                    if (this.yTI >= 0) {
                        this.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass11 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i2 = 0;
                                AppMethodBeat.i(65126);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.yTN.clear();
                                    ShuffleView.this.yTO.clear();
                                    while (i2 < ShuffleView.this.yTJ) {
                                        ShuffleView.this.yTN.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationX()));
                                        ShuffleView.this.yTO.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationY()));
                                        i2++;
                                    }
                                    AppMethodBeat.o(65126);
                                    return;
                                }
                                while (i2 < ShuffleView.this.yTJ) {
                                    ((View) ShuffleView.this.yTy.get(i2)).setTranslationX((((Float) ShuffleView.this.yTN.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(i2) * floatValue));
                                    ((View) ShuffleView.this.yTy.get(i2)).setTranslationY((((Float) ShuffleView.this.yTO.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i2) * floatValue));
                                    i2++;
                                }
                                AppMethodBeat.o(65126);
                            }
                        });
                        break;
                    }
                    break;
            }
            this.yTH = null;
            this.yTI = -1;
            this.yTA.start();
        }
        AppMethodBeat.o(65143);
    }

    private float getTouchScaleTranslationX() {
        AppMethodBeat.i(65144);
        if (this.yTH != null) {
            float width = (0.28f * ((float) this.yTH.getWidth())) - this.translationX;
            int i2 = this.yTI - 1;
            int i3 = (this.yTJ - 1) - this.yTI;
            int i4 = 0;
            if (i2 > 0) {
                i4 = i2 + 0;
            }
            if (i3 > 0) {
                i4 += i3;
            }
            if (i4 > 0) {
                float f2 = (width * 2.0f) / ((float) i4);
                AppMethodBeat.o(65144);
                return f2;
            }
        }
        AppMethodBeat.o(65144);
        return 0.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(65145);
        if (this.yTP) {
            AppMethodBeat.o(65145);
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.yTJ <= 0) {
            AppMethodBeat.o(65145);
            return false;
        }
        Log.d("ShuffleView", "y:%d,packet largest:%d", Integer.valueOf(y), Integer.valueOf((getHeight() - this.yTy.get(0).getHeight()) - (this.yTy.get(0).getHeight() / 7)));
        if (y < (getHeight() - this.yTy.get(0).getHeight()) - (this.yTy.get(0).getHeight() / 7)) {
            if (this.kmM != null && motionEvent.getActionMasked() == 0) {
                if (this.yTD != null) {
                    this.yTD.gT(this.yTG, this.yTJ);
                }
                eeV();
            } else if (this.yTH != null && this.yTH.getTranslationY() == ((float) ((-this.yTH.getHeight()) / 7))) {
                if (this.yTD != null) {
                    this.yTD.PE(this.yTJ);
                }
                PH(this.yTI);
            } else if (this.yTH != null) {
                eeW();
            }
            AppMethodBeat.o(65145);
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.yTJ) {
                z = false;
                break;
            }
            Rect PI = PI(i2);
            if (PI != null && PI.contains(x, y)) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            Log.d("ShuffleView", "event %d out of cards,%d,%d", Integer.valueOf(motionEvent.getActionMasked()), Integer.valueOf(x), Integer.valueOf(y));
            if (this.kmM != null && motionEvent.getActionMasked() == 0) {
                if (this.yTD != null) {
                    this.yTD.gT(this.yTG, this.yTJ);
                }
                eeV();
            } else if (this.yTH != null && this.yTH.getTranslationY() == ((float) ((-this.yTH.getHeight()) / 7))) {
                if (this.yTD != null) {
                    this.yTD.PE(this.yTJ);
                }
                PH(this.yTI);
            } else if (this.yTH != null) {
                eeW();
            }
        }
        if (this.yTJ <= 1) {
            AppMethodBeat.o(65145);
            return false;
        }
        GestureDetector gestureDetector = this.jKk;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        Log.i("ShuffleView", "ret:%s,action:%s", Boolean.valueOf(a2), Integer.valueOf(motionEvent.getActionMasked()));
        if (!a2 && motionEvent.getActionMasked() == 1) {
            if (this.yTH != null && this.yTH.getTranslationY() == ((float) ((-this.yTH.getHeight()) / 7))) {
                if (this.yTD != null) {
                    this.yTD.PE(this.yTJ);
                }
                PH(this.yTI);
            } else if (this.yTH != null) {
                eeW();
            }
        }
        AppMethodBeat.o(65145);
        return true;
    }

    private Rect PI(int i2) {
        AppMethodBeat.i(65146);
        if (i2 >= 0 && i2 < this.yTJ) {
            View view = this.yTy.get(i2);
            switch (this.yTz.yTX) {
                case 4:
                    if (i2 == 0) {
                        Rect rect = new Rect(view.getLeft() + ((int) view.getTranslationX()), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                        AppMethodBeat.o(65146);
                        return rect;
                    }
                    View view2 = this.yTy.get(i2 - 1);
                    Rect rect2 = new Rect(((int) view2.getTranslationX()) + view2.getRight(), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                    AppMethodBeat.o(65146);
                    return rect2;
            }
        }
        AppMethodBeat.o(65146);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void PJ(final int i2) {
        AppMethodBeat.i(65147);
        this.rnC.removeAllUpdateListeners();
        this.rnC.removeAllListeners();
        if (this.yTy.size() < this.yTJ) {
            this.yTJ--;
            if (this.yTJ == 1) {
                this.yTy.get(0).findViewById(R.id.f1_).setVisibility(0);
            }
            eeT();
            this.rnC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass15 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i2 = 0;
                    AppMethodBeat.i(65133);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue == 0.0f) {
                        ShuffleView.this.yTN.clear();
                        ShuffleView.this.yTO.clear();
                        while (i2 < ShuffleView.this.yTJ) {
                            ShuffleView.this.yTN.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationX()));
                            ShuffleView.this.yTO.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationY()));
                            i2++;
                        }
                        AppMethodBeat.o(65133);
                        return;
                    }
                    while (i2 < ShuffleView.this.yTJ) {
                        View view = (View) ShuffleView.this.yTy.get(i2);
                        if (ShuffleView.this.yTz.yTW == 1) {
                            view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.yTz.scaleX) + (1.0f - (ShuffleView.this.yTz.scaleX * ((float) (i2 + 1)))));
                            view.setTranslationY((((Float) ShuffleView.this.yTO.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * ShuffleView.this.PG(i2)));
                        } else if (ShuffleView.this.yTz.yTW == 2) {
                            view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.yTz.scaleY) + (1.0f - (ShuffleView.this.yTz.scaleY * ((float) (i2 + 1)))));
                            view.setTranslationX((((Float) ShuffleView.this.yTN.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * ShuffleView.this.PF(i2)));
                        }
                        i2++;
                    }
                    AppMethodBeat.o(65133);
                }
            });
            this.rnC.addListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(65115);
                    ShuffleView.this.yTP = true;
                    AppMethodBeat.o(65115);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(65116);
                    ShuffleView.this.yTP = false;
                    ShuffleView.this.yTH = null;
                    ShuffleView.this.yTI = -1;
                    AppMethodBeat.o(65116);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        } else {
            this.yTF = this.yTy.get(this.yTJ - 1);
            al(this.yTF, this.yTJ - 1);
            addView(this.yTF, 0);
            if (this.tMC != null) {
                switch (this.yTz.yTY) {
                    case 1:
                        this.yTF.setTranslationY((float) (-metrics.heightPixels));
                        break;
                    case 2:
                        this.yTF.setTranslationY((float) metrics.heightPixels);
                        break;
                    case 3:
                        this.yTF.setTranslationX((float) (-metrics.widthPixels));
                        break;
                    case 4:
                        this.yTF.setTranslationX((float) metrics.widthPixels);
                        break;
                }
            }
            this.yTF.setVisibility(4);
            this.rnC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass3 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(65117);
                    for (int i2 = i2; i2 < ShuffleView.this.yTJ - 1; i2++) {
                        View view = (View) ShuffleView.this.yTy.get(i2);
                        if (ShuffleView.this.yTz.yTW == 1) {
                            view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.yTz.scaleX) + (1.0f - (ShuffleView.this.yTz.scaleX * ((float) (i2 + 1)))));
                            if (ShuffleView.this.yTz.yTX == 2) {
                                view.setTranslationY(ShuffleView.this.PG(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.translationY));
                            } else if (ShuffleView.this.yTz.yTX == 1) {
                                view.setTranslationY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.translationY) + ShuffleView.this.PG(i2 + 1));
                            }
                        } else if (ShuffleView.this.yTz.yTW == 2) {
                            view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.yTz.scaleY) + (1.0f - (ShuffleView.this.yTz.scaleY * ((float) (i2 + 1)))));
                            if (ShuffleView.this.yTz.yTX == 3) {
                                view.setTranslationX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.translationX) + ShuffleView.this.PF(i2 + 1));
                            } else if (ShuffleView.this.yTz.yTX == 4) {
                                view.setTranslationX(ShuffleView.this.PF(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.translationX));
                            }
                        }
                    }
                    AppMethodBeat.o(65117);
                }
            });
            this.rnC.addListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass4 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(65118);
                    ShuffleView.this.yTP = true;
                    AppMethodBeat.o(65118);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(65119);
                    ShuffleView.this.yTP = false;
                    ShuffleView.this.yTF.setVisibility(0);
                    if (ShuffleView.this.tMC != null) {
                        ShuffleView.this.tMC.start();
                    }
                    AppMethodBeat.o(65119);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        this.rnC.start();
        AppMethodBeat.o(65147);
    }

    public void setExitAnimator(ValueAnimator valueAnimator) {
        AppMethodBeat.i(65148);
        if (this.tMD != null) {
            this.tMD.removeAllListeners();
            this.tMD.cancel();
        }
        this.tMD = valueAnimator;
        if (this.tMD != null) {
            this.tMD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass6 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(65121);
                    if (ShuffleView.this.yTB != null) {
                        ShuffleView.this.yTB.a(valueAnimator, ShuffleView.this.yTE);
                    }
                    AppMethodBeat.o(65121);
                }
            });
        }
        AppMethodBeat.o(65148);
    }

    public void setEnterAnimator(ValueAnimator valueAnimator) {
        AppMethodBeat.i(65149);
        if (this.tMC != null) {
            this.tMC.removeAllListeners();
            this.tMC.cancel();
        }
        this.tMC = valueAnimator;
        if (this.tMC != null) {
            this.tMC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass7 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(65122);
                    if (ShuffleView.this.yTC != null) {
                        ShuffleView.this.yTC.a(valueAnimator, ShuffleView.this.yTF);
                    }
                    AppMethodBeat.o(65122);
                }
            });
        }
        AppMethodBeat.o(65149);
    }

    public void setExitAnimatorListener(a aVar) {
        this.yTB = aVar;
    }

    public void setEnterAnimatorListener(a aVar) {
        this.yTC = aVar;
    }

    public void setCardListener(b bVar) {
        this.yTD = bVar;
    }

    public View getExitView() {
        return this.yTE;
    }

    public View getEnterView() {
        return this.yTF;
    }

    static /* synthetic */ void b(ShuffleView shuffleView, int i2) {
        AppMethodBeat.i(65155);
        if (i2 >= 0 && i2 < shuffleView.yTJ) {
            Log.i("ShuffleView", "touch card ".concat(String.valueOf(i2)));
            if (shuffleView.yTA.isStarted()) {
                shuffleView.yTA.cancel();
            }
            shuffleView.yTA.removeAllUpdateListeners();
            shuffleView.yTA.removeAllListeners();
            shuffleView.yTH = shuffleView.yTy.get(i2);
            shuffleView.yTI = i2;
            switch (shuffleView.yTz.yTX) {
                case 4:
                    if (i2 > 0) {
                        final int i3 = i2 - 1;
                        final int i4 = (shuffleView.yTJ - 1) - i2;
                        shuffleView.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass12 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i2 = 0;
                                AppMethodBeat.i(65127);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.yTN.clear();
                                    ShuffleView.this.yTO.clear();
                                    while (i2 < ShuffleView.this.yTJ) {
                                        ShuffleView.this.yTN.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationX()));
                                        ShuffleView.this.yTO.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationY()));
                                        i2++;
                                    }
                                    AppMethodBeat.o(65127);
                                    return;
                                }
                                if (i3 > 0) {
                                    while (i2 < ShuffleView.this.yTI - 1) {
                                        ((View) ShuffleView.this.yTy.get(i2)).setTranslationX((((Float) ShuffleView.this.yTN.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.PF(i2) - (((float) (i2 + 1)) * ShuffleView.j(ShuffleView.this))) * floatValue));
                                        ((View) ShuffleView.this.yTy.get(i2)).setTranslationY((((Float) ShuffleView.this.yTO.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i2) * floatValue));
                                        i2++;
                                    }
                                    ((View) ShuffleView.this.yTy.get(ShuffleView.this.yTI - 1)).setTranslationX((((Float) ShuffleView.this.yTN.get(ShuffleView.this.yTI - 1)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.PF(ShuffleView.this.yTI - 1) - ((ShuffleView.j(ShuffleView.this) * ((float) i3)) / 2.0f)) * floatValue));
                                } else {
                                    while (i2 < ShuffleView.this.yTI) {
                                        ((View) ShuffleView.this.yTy.get(i2)).setTranslationX((((Float) ShuffleView.this.yTN.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(i2) * floatValue));
                                        ((View) ShuffleView.this.yTy.get(i2)).setTranslationY((((Float) ShuffleView.this.yTO.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i2) * floatValue));
                                        i2++;
                                    }
                                }
                                if (i4 > 0) {
                                    ShuffleView.this.yTH.setTranslationX((((Float) ShuffleView.this.yTN.get(ShuffleView.this.yTI)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.PF(ShuffleView.this.yTI) + ((ShuffleView.j(ShuffleView.this) * ((float) i4)) / 2.0f)) * floatValue));
                                    ShuffleView.this.yTH.setTranslationY((((Float) ShuffleView.this.yTO.get(ShuffleView.this.yTI)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(ShuffleView.this.yTI) * floatValue));
                                    for (int i3 = ShuffleView.this.yTI + 1; i3 < ShuffleView.this.yTJ; i3++) {
                                        ((View) ShuffleView.this.yTy.get(i3)).setTranslationX((((Float) ShuffleView.this.yTN.get(i3)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.PF(i3) + (((float) (ShuffleView.this.yTJ - i3)) * ShuffleView.j(ShuffleView.this))) * floatValue));
                                        ((View) ShuffleView.this.yTy.get(i3)).setTranslationY((((Float) ShuffleView.this.yTO.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i3) * floatValue));
                                    }
                                    AppMethodBeat.o(65127);
                                    return;
                                }
                                for (int i4 = ShuffleView.this.yTI; i4 < ShuffleView.this.yTJ; i4++) {
                                    ((View) ShuffleView.this.yTy.get(i4)).setTranslationX((((Float) ShuffleView.this.yTN.get(i4)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(i4) * floatValue));
                                    ((View) ShuffleView.this.yTy.get(i4)).setTranslationY((((Float) ShuffleView.this.yTO.get(i4)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i4) * floatValue));
                                }
                                AppMethodBeat.o(65127);
                            }
                        });
                    } else {
                        shuffleView.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass13 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AppMethodBeat.i(65128);
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.yTN.clear();
                                    ShuffleView.this.yTO.clear();
                                    for (int i2 = 0; i2 < ShuffleView.this.yTJ; i2++) {
                                        ShuffleView.this.yTN.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationX()));
                                        ShuffleView.this.yTO.add(Float.valueOf(((View) ShuffleView.this.yTy.get(i2)).getTranslationY()));
                                    }
                                    AppMethodBeat.o(65128);
                                    return;
                                }
                                ((View) ShuffleView.this.yTy.get(0)).setTranslationX((((Float) ShuffleView.this.yTN.get(0)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(0) * floatValue));
                                ((View) ShuffleView.this.yTy.get(0)).setTranslationY((((Float) ShuffleView.this.yTO.get(0)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(0) * floatValue));
                                for (int i3 = 1; i3 < ShuffleView.this.yTJ; i3++) {
                                    ((View) ShuffleView.this.yTy.get(i3)).setTranslationX((((Float) ShuffleView.this.yTN.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PF(i3) * floatValue));
                                    ((View) ShuffleView.this.yTy.get(i3)).setTranslationY((((Float) ShuffleView.this.yTO.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.PG(i3) * floatValue));
                                }
                                AppMethodBeat.o(65128);
                            }
                        });
                    }
                    if (shuffleView.yTD != null) {
                        shuffleView.yTD.gS(shuffleView.yTI, shuffleView.yTJ);
                        break;
                    }
                    break;
            }
            shuffleView.yTA.start();
        }
        AppMethodBeat.o(65155);
    }
}
