package com.tencent.mm.ui.c.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

final class c extends b {
    long Cd = 0;
    boolean OMo = false;
    boolean OMp = false;
    boolean OMq = false;
    Animator.AnimatorListener OMr = null;
    a OMs = new a();
    ArrayList<b> OMt = new ArrayList<>();
    Runnable OMu = new Runnable() {
        /* class com.tencent.mm.ui.c.a.c.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(205159);
            c.this.startAnimation();
            AppMethodBeat.o(205159);
        }
    };
    HashMap<Animator, C2086c> OMv = new HashMap<>();
    final WeakReference<View> Rd;
    long mDuration;
    Interpolator mInterpolator;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.c.a.c$c  reason: collision with other inner class name */
    public static class C2086c {
        int OMA;
        ArrayList<b> OMB;

        C2086c(int i2, ArrayList<b> arrayList) {
            this.OMA = i2;
            this.OMB = arrayList;
        }

        /* access modifiers changed from: package-private */
        public final boolean alp(int i2) {
            AppMethodBeat.i(205165);
            if (!((this.OMA & i2) == 0 || this.OMB == null)) {
                int size = this.OMB.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (this.OMB.get(i3).OMx == i2) {
                        this.OMB.remove(i3);
                        this.OMA &= i2 ^ -1;
                        AppMethodBeat.o(205165);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(205165);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int OMx;
        float OMy;
        float OMz;

        b(int i2, float f2, float f3) {
            this.OMx = i2;
            this.OMy = f2;
            this.OMz = f3;
        }
    }

    c(View view) {
        AppMethodBeat.i(205166);
        this.Rd = new WeakReference<>(view);
        AppMethodBeat.o(205166);
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b gKg() {
        AppMethodBeat.i(205167);
        if (250 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Animators cannot have negative duration: 250");
            AppMethodBeat.o(205167);
            throw illegalArgumentException;
        }
        this.OMo = true;
        this.mDuration = 250;
        AppMethodBeat.o(205167);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b c(Interpolator interpolator) {
        this.OMq = true;
        this.mInterpolator = interpolator;
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final void start() {
        AppMethodBeat.i(205168);
        View view = this.Rd.get();
        if (view != null) {
            view.removeCallbacks(this.OMu);
        }
        startAnimation();
        AppMethodBeat.o(205168);
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b cn(float f2) {
        AppMethodBeat.i(205169);
        A(1, f2);
        AppMethodBeat.o(205169);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b co(float f2) {
        AppMethodBeat.i(205170);
        A(2, f2);
        AppMethodBeat.o(205170);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b cp(float f2) {
        AppMethodBeat.i(205171);
        A(4, f2);
        AppMethodBeat.o(205171);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b cq(float f2) {
        AppMethodBeat.i(205172);
        A(8, f2);
        AppMethodBeat.o(205172);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void startAnimation() {
        AppMethodBeat.i(205173);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ArrayList arrayList = (ArrayList) this.OMt.clone();
        this.OMt.clear();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 |= ((b) arrayList.get(i3)).OMx;
        }
        if (this.OMl != null) {
            this.OMj.put(ofFloat, this.OMl);
            this.OMl = null;
        }
        if (this.OMm != null) {
            this.OMk.put(ofFloat, this.OMm);
            this.OMm = null;
        }
        this.OMv.put(ofFloat, new C2086c(i2, arrayList));
        ofFloat.addUpdateListener(this.OMs);
        ofFloat.addListener(this.OMs);
        if (this.OMp) {
            ofFloat.setStartDelay(this.Cd);
        }
        if (this.OMo) {
            ofFloat.setDuration(this.mDuration);
        }
        if (this.OMq) {
            ofFloat.setInterpolator(this.mInterpolator);
        }
        ofFloat.start();
        AppMethodBeat.o(205173);
    }

    private void A(int i2, float f2) {
        AppMethodBeat.i(205174);
        float alo = alo(i2);
        e(i2, alo, f2 - alo);
        AppMethodBeat.o(205174);
    }

    private void e(int i2, float f2, float f3) {
        Animator animator;
        AppMethodBeat.i(205175);
        if (this.OMv.size() > 0) {
            Iterator<Animator> it = this.OMv.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    animator = null;
                    break;
                }
                animator = it.next();
                C2086c cVar = this.OMv.get(animator);
                if (cVar.alp(i2) && cVar.OMA == 0) {
                    break;
                }
            }
            if (animator != null) {
                animator.cancel();
            }
        }
        this.OMt.add(new b(i2, f2, f3));
        View view = this.Rd.get();
        if (view != null) {
            view.removeCallbacks(this.OMu);
            view.post(this.OMu);
        }
        AppMethodBeat.o(205175);
    }

    private float alo(int i2) {
        AppMethodBeat.i(205176);
        View view = this.Rd.get();
        if (view != null) {
            switch (i2) {
                case 1:
                    float translationX = view.getTranslationX();
                    AppMethodBeat.o(205176);
                    return translationX;
                case 2:
                    float translationY = view.getTranslationY();
                    AppMethodBeat.o(205176);
                    return translationY;
                case 4:
                    float scaleX = view.getScaleX();
                    AppMethodBeat.o(205176);
                    return scaleX;
                case 8:
                    float scaleY = view.getScaleY();
                    AppMethodBeat.o(205176);
                    return scaleY;
                case 16:
                    float rotation = view.getRotation();
                    AppMethodBeat.o(205176);
                    return rotation;
                case 32:
                    float rotationX = view.getRotationX();
                    AppMethodBeat.o(205176);
                    return rotationX;
                case 64:
                    float rotationY = view.getRotationY();
                    AppMethodBeat.o(205176);
                    return rotationY;
                case 128:
                    float x = view.getX();
                    AppMethodBeat.o(205176);
                    return x;
                case 256:
                    float y = view.getY();
                    AppMethodBeat.o(205176);
                    return y;
                case 512:
                    float alpha = view.getAlpha();
                    AppMethodBeat.o(205176);
                    return alpha;
            }
        }
        AppMethodBeat.o(205176);
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public class a implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(205160);
            if (c.this.OMr != null) {
                c.this.OMr.onAnimationStart(animator);
            }
            if (c.this.OMj != null) {
                Runnable runnable = (Runnable) c.this.OMj.get(animator);
                if (runnable != null) {
                    runnable.run();
                }
                c.this.OMj.remove(animator);
            }
            AppMethodBeat.o(205160);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(205161);
            if (c.this.OMr != null) {
                c.this.OMr.onAnimationCancel(animator);
            }
            if (c.this.OMk != null) {
                c.this.OMk.remove(animator);
            }
            AppMethodBeat.o(205161);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(205162);
            if (c.this.OMr != null) {
                c.this.OMr.onAnimationRepeat(animator);
            }
            AppMethodBeat.o(205162);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(205163);
            if (c.this.OMr != null) {
                c.this.OMr.onAnimationEnd(animator);
            }
            if (c.this.OMk != null) {
                Runnable runnable = (Runnable) c.this.OMk.get(animator);
                if (runnable != null) {
                    runnable.run();
                }
                c.this.OMk.remove(animator);
            }
            c.this.OMv.remove(animator);
            if (c.this.OMv.isEmpty()) {
                c.this.OMr = null;
            }
            AppMethodBeat.o(205163);
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view;
            AppMethodBeat.i(205164);
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (c.this.OMn != null) {
                c.this.OMn.by(animatedFraction);
            }
            C2086c cVar = c.this.OMv.get(valueAnimator);
            if (!((cVar.OMA & TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED) == 0 || (view = c.this.Rd.get()) == null)) {
                view.invalidate();
            }
            ArrayList<b> arrayList = cVar.OMB;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    b bVar = arrayList.get(i2);
                    float f2 = bVar.OMy + (bVar.OMz * animatedFraction);
                    c cVar2 = c.this;
                    int i3 = bVar.OMx;
                    View view2 = cVar2.Rd.get();
                    if (view2 != null) {
                        switch (i3) {
                            case 1:
                                view2.setTranslationX(f2);
                                continue;
                            case 2:
                                view2.setTranslationY(f2);
                                continue;
                            case 4:
                                view2.setScaleX(f2);
                                continue;
                            case 8:
                                view2.setScaleY(f2);
                                continue;
                            case 16:
                                view2.setRotation(f2);
                                continue;
                            case 32:
                                view2.setRotationX(f2);
                                continue;
                            case 64:
                                view2.setRotationY(f2);
                                continue;
                            case 128:
                                view2.setX(f2);
                                continue;
                            case 256:
                                view2.setY(f2);
                                continue;
                            case 512:
                                view2.setAlpha(f2);
                                continue;
                        }
                    }
                }
            }
            View view3 = c.this.Rd.get();
            if (view3 != null) {
                view3.invalidate();
            }
            AppMethodBeat.o(205164);
        }
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b aJ(Runnable runnable) {
        AppMethodBeat.i(205177);
        this.OMm = runnable;
        if (this.OMk == null) {
            this.OMk = new HashMap();
        }
        AppMethodBeat.o(205177);
        return this;
    }

    @Override // com.tencent.mm.ui.c.a.b
    public final b aK(Runnable runnable) {
        AppMethodBeat.i(205178);
        this.OMl = runnable;
        if (this.OMj == null) {
            this.OMj = new HashMap();
        }
        AppMethodBeat.o(205178);
        return this;
    }
}
