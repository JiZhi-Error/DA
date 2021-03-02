package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.R;

/* access modifiers changed from: package-private */
public class al {
    private float[] DZ;

    al() {
    }

    public void d(View view, float f2) {
        Float f3 = (Float) view.getTag(R.id.h_d);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
        } else {
            view.setAlpha(f2);
        }
    }

    public float P(View view) {
        Float f2 = (Float) view.getTag(R.id.h_d);
        if (f2 != null) {
            return view.getAlpha() / f2.floatValue();
        }
        return view.getAlpha();
    }

    public void Q(View view) {
        if (view.getTag(R.id.h_d) == null) {
            view.setTag(R.id.h_d, Float.valueOf(view.getAlpha()));
        }
    }

    public void R(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.h_d, null);
        }
    }

    public void a(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            b(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }

    public void c(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.DZ;
        if (fArr == null) {
            fArr = new float[9];
            this.DZ = fArr;
        }
        matrix.getValues(fArr);
        float f2 = fArr[3];
        float sqrt = ((float) (fArr[0] < 0.0f ? -1 : 1)) * ((float) Math.sqrt((double) (1.0f - (f2 * f2))));
        float f3 = fArr[0] / sqrt;
        float f4 = fArr[4] / sqrt;
        float f5 = fArr[2];
        float f6 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        view.setRotation((float) Math.toDegrees(Math.atan2((double) f2, (double) sqrt)));
        view.setScaleX(f3);
        view.setScaleY(f4);
    }

    public void b(View view, int i2, int i3, int i4, int i5) {
        view.setLeft(i2);
        view.setTop(i3);
        view.setRight(i4);
        view.setBottom(i5);
    }
}
