package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeClipBounds extends Transition {
    private static final String[] zP = {"android:clipBounds:clip"};

    @Override // android.support.transition.Transition
    public final String[] getTransitionProperties() {
        return zP;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void c(v vVar) {
        View view = vVar.view;
        if (view.getVisibility() != 8) {
            Rect aC = u.aC(view);
            vVar.values.put("android:clipBounds:clip", aC);
            if (aC == null) {
                vVar.values.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    @Override // android.support.transition.Transition
    public final void a(v vVar) {
        c(vVar);
    }

    @Override // android.support.transition.Transition
    public final void b(v vVar) {
        c(vVar);
    }

    @Override // android.support.transition.Transition
    public final Animator a(ViewGroup viewGroup, v vVar, v vVar2) {
        boolean z;
        if (vVar == null || vVar2 == null || !vVar.values.containsKey("android:clipBounds:clip") || !vVar2.values.containsKey("android:clipBounds:clip")) {
            return null;
        }
        Rect rect = (Rect) vVar.values.get("android:clipBounds:clip");
        Rect rect2 = (Rect) vVar2.values.get("android:clipBounds:clip");
        if (rect2 == null) {
            z = true;
        } else {
            z = false;
        }
        if (rect == null && rect2 == null) {
            return null;
        }
        if (rect == null) {
            rect = (Rect) vVar.values.get("android:clipBounds:bounds");
        } else if (rect2 == null) {
            rect2 = (Rect) vVar2.values.get("android:clipBounds:bounds");
        }
        if (rect.equals(rect2)) {
            return null;
        }
        u.b(vVar2.view, rect);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(vVar2.view, ah.DM, new m(new Rect()), rect, rect2);
        if (!z) {
            return ofObject;
        }
        final View view = vVar2.view;
        ofObject.addListener(new AnimatorListenerAdapter() {
            /* class android.support.transition.ChangeClipBounds.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                u.b(view, (Rect) null);
            }
        });
        return ofObject;
    }
}
