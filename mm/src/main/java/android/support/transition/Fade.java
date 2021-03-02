package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.a.g;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

public class Fade extends Visibility {
    public Fade(int i2) {
        setMode(i2);
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.BV);
        setMode(g.a(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "fadingMode", 0, this.mMode));
        obtainStyledAttributes.recycle();
    }

    @Override // android.support.transition.Transition, android.support.transition.Visibility
    public final void a(v vVar) {
        super.a(vVar);
        vVar.values.put("android:fade:transitionAlpha", Float.valueOf(ah.P(vVar.view)));
    }

    private Animator b(final View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ah.d(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ah.DL, f3);
        ofFloat.addListener(new a(view));
        a(new r() {
            /* class android.support.transition.Fade.AnonymousClass1 */

            @Override // android.support.transition.r, android.support.transition.Transition.d
            public final void a(Transition transition) {
                ah.d(view, 1.0f);
                ah.R(view);
                transition.b(this);
            }
        });
        return ofFloat;
    }

    @Override // android.support.transition.Visibility
    public final Animator a(ViewGroup viewGroup, View view, v vVar, v vVar2) {
        float f2 = 0.0f;
        float a2 = a(vVar, 0.0f);
        if (a2 != 1.0f) {
            f2 = a2;
        }
        return b(view, f2, 1.0f);
    }

    @Override // android.support.transition.Visibility
    public final Animator a(ViewGroup viewGroup, View view, v vVar) {
        ah.Q(view);
        return b(view, a(vVar, 1.0f), 0.0f);
    }

    private static float a(v vVar, float f2) {
        Float f3;
        if (vVar == null || (f3 = (Float) vVar.values.get("android:fade:transitionAlpha")) == null) {
            return f2;
        }
        return f3.floatValue();
    }

    /* access modifiers changed from: package-private */
    public static class a extends AnimatorListenerAdapter {
        private boolean AU = false;
        private final View mView;

        a(View view) {
            this.mView = view;
        }

        public final void onAnimationStart(Animator animator) {
            if (u.ar(this.mView) && this.mView.getLayerType() == 0) {
                this.AU = true;
                this.mView.setLayerType(2, null);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            ah.d(this.mView, 1.0f);
            if (this.AU) {
                this.mView.setLayerType(0, null);
            }
        }
    }
}
