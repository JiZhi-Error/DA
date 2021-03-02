package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.transition.u;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ChangeImageTransform extends Transition {
    private static final TypeEvaluator<Matrix> At = new TypeEvaluator<Matrix>() {
        /* class android.support.transition.ChangeImageTransform.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public final /* bridge */ /* synthetic */ Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };
    private static final Property<ImageView, Matrix> Au = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
        /* class android.support.transition.ChangeImageTransform.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* bridge */ /* synthetic */ Matrix get(ImageView imageView) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(ImageView imageView, Matrix matrix) {
            ImageView imageView2 = imageView;
            Matrix matrix2 = matrix;
            if (Build.VERSION.SDK_INT < 21) {
                imageView2.setImageMatrix(matrix2);
                return;
            }
            if (!h.Bv) {
                try {
                    Method declaredMethod = ImageView.class.getDeclaredMethod("animateTransform", Matrix.class);
                    h.Bu = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                }
                h.Bv = true;
            }
            if (h.Bu != null) {
                try {
                    h.Bu.invoke(imageView2, matrix2);
                } catch (IllegalAccessException e3) {
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException(e4.getCause());
                }
            }
        }
    };
    private static final String[] zP = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void c(v vVar) {
        Matrix matrix;
        View view = vVar.view;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                Map<String, Object> map = vVar.values;
                map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                switch (AnonymousClass3.Av[imageView.getScaleType().ordinal()]) {
                    case 1:
                        Drawable drawable = imageView.getDrawable();
                        Matrix matrix2 = new Matrix();
                        matrix2.postScale(((float) imageView.getWidth()) / ((float) drawable.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable.getIntrinsicHeight()));
                        matrix = matrix2;
                        break;
                    case 2:
                        Drawable drawable2 = imageView.getDrawable();
                        int intrinsicWidth = drawable2.getIntrinsicWidth();
                        int width = imageView.getWidth();
                        int intrinsicHeight = drawable2.getIntrinsicHeight();
                        int height = imageView.getHeight();
                        float max = Math.max(((float) width) / ((float) intrinsicWidth), ((float) height) / ((float) intrinsicHeight));
                        int round = Math.round((((float) width) - (((float) intrinsicWidth) * max)) / 2.0f);
                        int round2 = Math.round((((float) height) - (((float) intrinsicHeight) * max)) / 2.0f);
                        matrix = new Matrix();
                        matrix.postScale(max, max);
                        matrix.postTranslate((float) round, (float) round2);
                        break;
                    default:
                        matrix = new Matrix(imageView.getImageMatrix());
                        break;
                }
                map.put("android:changeImageTransform:matrix", matrix);
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
    public final String[] getTransitionProperties() {
        return zP;
    }

    @Override // android.support.transition.Transition
    public final Animator a(ViewGroup viewGroup, v vVar, v vVar2) {
        boolean z;
        ObjectAnimator objectAnimator;
        if (vVar == null || vVar2 == null) {
            return null;
        }
        Rect rect = (Rect) vVar.values.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) vVar2.values.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) vVar.values.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) vVar2.values.get("android:changeImageTransform:matrix");
        if (!(matrix == null && matrix2 == null) && (matrix == null || !matrix.equals(matrix2))) {
            z = false;
        } else {
            z = true;
        }
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) vVar2.view;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (Build.VERSION.SDK_INT < 21) {
            ImageView.ScaleType scaleType = imageView.getScaleType();
            imageView.setTag(R.id.h_f, scaleType);
            if (scaleType == ImageView.ScaleType.MATRIX) {
                imageView.setTag(R.id.h_b, imageView.getImageMatrix());
            } else {
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
            }
            imageView.setImageMatrix(i.xV);
        }
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            objectAnimator = ObjectAnimator.ofObject(imageView, Au, At, null, null);
        } else {
            if (matrix == null) {
                matrix = i.xV;
            }
            if (matrix2 == null) {
                matrix2 = i.xV;
            }
            Au.set(imageView, matrix);
            objectAnimator = ObjectAnimator.ofObject(imageView, Au, new u.a(), matrix, matrix2);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return objectAnimator;
        }
        objectAnimator.addListener(new AnimatorListenerAdapter(imageView) {
            /* class android.support.transition.h.AnonymousClass1 */
            final /* synthetic */ ImageView Bw;

            {
                this.Bw = r1;
            }

            public final void onAnimationEnd(Animator animator) {
                ImageView.ScaleType scaleType = (ImageView.ScaleType) this.Bw.getTag(R.id.h_f);
                this.Bw.setScaleType(scaleType);
                this.Bw.setTag(R.id.h_f, null);
                if (scaleType == ImageView.ScaleType.MATRIX) {
                    this.Bw.setImageMatrix((Matrix) this.Bw.getTag(R.id.h_b));
                    this.Bw.setTag(R.id.h_b, null);
                }
                animator.removeListener(this);
            }
        });
        return objectAnimator;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.transition.ChangeImageTransform$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] Av = new int[ImageView.ScaleType.values().length];

        static {
            try {
                Av[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Av[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
