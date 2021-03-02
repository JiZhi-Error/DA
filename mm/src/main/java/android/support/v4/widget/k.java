package android.support.v4.widget;

import android.graphics.Rect;
import java.util.Comparator;

/* access modifiers changed from: package-private */
public final class k {

    public interface a<T> {
        void b(T t, Rect rect);
    }

    public interface b<T, V> {
        int L(T t);

        V get(T t, int i2);
    }

    /* access modifiers changed from: package-private */
    public static class c<T> implements Comparator<T> {
        private final a<T> UA;
        private final Rect Ux = new Rect();
        private final Rect Uy = new Rect();
        private final boolean Uz;

        c(boolean z, a<T> aVar) {
            this.Uz = z;
            this.UA = aVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Rect rect = this.Ux;
            Rect rect2 = this.Uy;
            this.UA.b(t, rect);
            this.UA.b(t2, rect2);
            if (rect.top < rect2.top) {
                return -1;
            }
            if (rect.top > rect2.top) {
                return 1;
            }
            if (rect.left < rect2.left) {
                return this.Uz ? 1 : -1;
            }
            if (rect.left > rect2.left) {
                return !this.Uz ? 1 : -1;
            }
            if (rect.bottom < rect2.bottom) {
                return -1;
            }
            if (rect.bottom > rect2.bottom) {
                return 1;
            }
            if (rect.right < rect2.right) {
                return this.Uz ? 1 : -1;
            }
            if (rect.right > rect2.right) {
                return !this.Uz ? 1 : -1;
            }
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <L, T> T a(L r9, android.support.v4.widget.k.b<L, T> r10, android.support.v4.widget.k.a<T> r11, T r12, android.graphics.Rect r13, int r14) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.k.a(java.lang.Object, android.support.v4.widget.k$b, android.support.v4.widget.k$a, java.lang.Object, android.graphics.Rect, int):java.lang.Object");
    }

    private static boolean a(int i2, Rect rect, Rect rect2, Rect rect3) {
        boolean a2 = a(i2, rect, rect2);
        if (a(i2, rect, rect3) || !a2) {
            return false;
        }
        return !b(i2, rect, rect3) || i2 == 17 || i2 == 66 || c(i2, rect, rect2) < e(i2, rect, rect3);
    }

    private static int E(int i2, int i3) {
        return (i2 * 13 * i2) + (i3 * i3);
    }

    private static boolean a(Rect rect, Rect rect2, int i2) {
        switch (i2) {
            case 17:
                return (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left;
            case 33:
                return (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top;
            case 66:
                return (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right;
            case 130:
                return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean a(int i2, Rect rect, Rect rect2) {
        switch (i2) {
            case 17:
            case 66:
                return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
            case 33:
            case 130:
                return rect2.right >= rect.left && rect2.left <= rect.right;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean b(int i2, Rect rect, Rect rect2) {
        switch (i2) {
            case 17:
                return rect.left >= rect2.right;
            case 33:
                return rect.top >= rect2.bottom;
            case 66:
                return rect.right <= rect2.left;
            case 130:
                return rect.bottom <= rect2.top;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static int c(int i2, Rect rect, Rect rect2) {
        return Math.max(0, d(i2, rect, rect2));
    }

    private static int d(int i2, Rect rect, Rect rect2) {
        switch (i2) {
            case 17:
                return rect.left - rect2.right;
            case 33:
                return rect.top - rect2.bottom;
            case 66:
                return rect2.left - rect.right;
            case 130:
                return rect2.top - rect.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static int e(int i2, Rect rect, Rect rect2) {
        return Math.max(1, f(i2, rect, rect2));
    }

    private static int f(int i2, Rect rect, Rect rect2) {
        switch (i2) {
            case 17:
                return rect.left - rect2.left;
            case 33:
                return rect.top - rect2.top;
            case 66:
                return rect2.right - rect.right;
            case 130:
                return rect2.bottom - rect.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static int g(int i2, Rect rect, Rect rect2) {
        switch (i2) {
            case 17:
            case 66:
                return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
            case 33:
            case 130:
                return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }
}
