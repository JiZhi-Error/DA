package android.support.v4.view;

import android.os.Build;
import android.view.WindowInsets;

public final class ac {
    public final Object Rm;

    private ac(Object obj) {
        this.Rm = obj;
    }

    public final int getSystemWindowInsetLeft() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.Rm).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public final int getSystemWindowInsetTop() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.Rm).getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getSystemWindowInsetRight() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.Rm).getSystemWindowInsetRight();
        }
        return 0;
    }

    public final int getSystemWindowInsetBottom() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.Rm).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public final boolean isConsumed() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.Rm).isConsumed();
        }
        return false;
    }

    public final ac fI() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new ac(((WindowInsets) this.Rm).consumeSystemWindowInsets());
        }
        return null;
    }

    public final ac f(int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new ac(((WindowInsets) this.Rm).replaceSystemWindowInsets(i2, i3, i4, i5));
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ac acVar = (ac) obj;
        if (this.Rm == null) {
            return acVar.Rm == null;
        }
        return this.Rm.equals(acVar.Rm);
    }

    public final int hashCode() {
        if (this.Rm == null) {
            return 0;
        }
        return this.Rm.hashCode();
    }

    static ac G(Object obj) {
        if (obj == null) {
            return null;
        }
        return new ac(obj);
    }

    static Object c(ac acVar) {
        if (acVar == null) {
            return null;
        }
        return acVar.Rm;
    }
}
