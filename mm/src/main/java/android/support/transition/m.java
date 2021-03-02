package android.support.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

final class m implements TypeEvaluator<Rect> {
    private Rect mRect;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
    @Override // android.animation.TypeEvaluator
    public final /* synthetic */ Rect evaluate(float f2, Rect rect, Rect rect2) {
        Rect rect3 = rect;
        Rect rect4 = rect2;
        int i2 = ((int) (((float) (rect4.left - rect3.left)) * f2)) + rect3.left;
        int i3 = ((int) (((float) (rect4.top - rect3.top)) * f2)) + rect3.top;
        int i4 = ((int) (((float) (rect4.right - rect3.right)) * f2)) + rect3.right;
        int i5 = ((int) (((float) (rect4.bottom - rect3.bottom)) * f2)) + rect3.bottom;
        if (this.mRect == null) {
            return new Rect(i2, i3, i4, i5);
        }
        this.mRect.set(i2, i3, i4, i5);
        return this.mRect;
    }

    m() {
    }

    m(Rect rect) {
        this.mRect = rect;
    }
}
