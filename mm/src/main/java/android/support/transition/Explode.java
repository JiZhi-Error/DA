package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.R;

public class Explode extends Visibility {
    private static final TimeInterpolator AQ = new DecelerateInterpolator();
    private static final TimeInterpolator AR = new AccelerateInterpolator();
    private int[] AS;

    public Explode() {
        this.AS = new int[2];
        a(new b());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.AS = new int[2];
        a(new b());
    }

    private void c(v vVar) {
        View view = vVar.view;
        view.getLocationOnScreen(this.AS);
        int i2 = this.AS[0];
        int i3 = this.AS[1];
        vVar.values.put("android:explode:screenBounds", new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3));
    }

    @Override // android.support.transition.Transition, android.support.transition.Visibility
    public final void a(v vVar) {
        super.a(vVar);
        c(vVar);
    }

    @Override // android.support.transition.Transition, android.support.transition.Visibility
    public final void b(v vVar) {
        super.b(vVar);
        c(vVar);
    }

    @Override // android.support.transition.Visibility
    public final Animator a(ViewGroup viewGroup, View view, v vVar, v vVar2) {
        if (vVar2 == null) {
            return null;
        }
        Rect rect = (Rect) vVar2.values.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a(viewGroup, rect, this.AS);
        return x.a(view, vVar2, rect.left, rect.top, translationX + ((float) this.AS[0]), translationY + ((float) this.AS[1]), translationX, translationY, AQ);
    }

    @Override // android.support.transition.Visibility
    public final Animator a(ViewGroup viewGroup, View view, v vVar) {
        float f2;
        float f3;
        if (vVar == null) {
            return null;
        }
        Rect rect = (Rect) vVar.values.get("android:explode:screenBounds");
        int i2 = rect.left;
        int i3 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) vVar.view.getTag(R.id.iv4);
        if (iArr != null) {
            f3 = translationX + ((float) (iArr[0] - rect.left));
            rect.offsetTo(iArr[0], iArr[1]);
            f2 = ((float) (iArr[1] - rect.top)) + translationY;
        } else {
            f2 = translationY;
            f3 = translationX;
        }
        a(viewGroup, rect, this.AS);
        return x.a(view, vVar, i2, i3, translationX, translationY, f3 + ((float) this.AS[0]), f2 + ((float) this.AS[1]), AR);
    }

    private void a(View view, Rect rect, int[] iArr) {
        int centerX;
        int centerY;
        view.getLocationOnScreen(this.AS);
        int i2 = this.AS[0];
        int i3 = this.AS[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            centerX = (view.getWidth() / 2) + i2 + Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i3 + Math.round(view.getTranslationY());
        } else {
            centerX = epicenter.centerX();
            centerY = epicenter.centerY();
        }
        float centerX2 = (float) (rect.centerX() - centerX);
        float centerY2 = (float) (rect.centerY() - centerY);
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float g2 = g(centerX2, centerY2);
        float f2 = f(view, centerX - i2, centerY - i3);
        iArr[0] = Math.round((centerX2 / g2) * f2);
        iArr[1] = Math.round(f2 * (centerY2 / g2));
    }

    private static float f(View view, int i2, int i3) {
        return g((float) Math.max(i2, view.getWidth() - i2), (float) Math.max(i3, view.getHeight() - i3));
    }

    private static float g(float f2, float f3) {
        return (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
    }
}
