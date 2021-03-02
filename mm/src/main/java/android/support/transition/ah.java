package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.u;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* access modifiers changed from: package-private */
public final class ah {
    private static final al DI;
    private static Field DJ;
    private static boolean DK;
    static final Property<View, Float> DL = new Property<View, Float>(Float.class, "translationAlpha") {
        /* class android.support.transition.ah.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ Float get(View view) {
            return Float.valueOf(ah.P(view));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(View view, Float f2) {
            ah.d(view, f2.floatValue());
        }
    };
    static final Property<View, Rect> DM = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* class android.support.transition.ah.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ Rect get(View view) {
            return u.aC(view);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public final /* synthetic */ void set(View view, Rect rect) {
            u.b(view, rect);
        }
    };

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            DI = new ak();
        } else if (Build.VERSION.SDK_INT >= 21) {
            DI = new aj();
        } else if (Build.VERSION.SDK_INT >= 19) {
            DI = new ai();
        } else {
            DI = new al();
        }
    }

    static ag N(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new af(view);
        }
        return ae.M(view);
    }

    static ap O(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ao(view);
        }
        return new an(view.getWindowToken());
    }

    static void d(View view, float f2) {
        DI.d(view, f2);
    }

    static float P(View view) {
        return DI.P(view);
    }

    static void Q(View view) {
        DI.Q(view);
    }

    static void R(View view) {
        DI.R(view);
    }

    static void a(View view, Matrix matrix) {
        DI.a(view, matrix);
    }

    static void b(View view, Matrix matrix) {
        DI.b(view, matrix);
    }

    static void c(View view, Matrix matrix) {
        DI.c(view, matrix);
    }

    static void b(View view, int i2, int i3, int i4, int i5) {
        DI.b(view, i2, i3, i4, i5);
    }

    static void m(View view, int i2) {
        if (!DK) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                DJ = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            DK = true;
        }
        if (DJ != null) {
            try {
                DJ.setInt(view, (DJ.getInt(view) & -13) | i2);
            } catch (IllegalAccessException e3) {
            }
        }
    }
}
