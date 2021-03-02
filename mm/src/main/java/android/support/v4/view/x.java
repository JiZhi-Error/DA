package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class x {
    @Deprecated
    public static boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof n) {
            return ((n) viewParent).a(view, view2, i2, i3);
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view, view2, i2);
                } catch (AbstractMethodError e2) {
                    new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onStartNestedScroll");
                }
            } else if (viewParent instanceof m) {
                return ((m) viewParent).onStartNestedScroll(view, view2, i2);
            }
        }
        return false;
    }

    public static void b(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof n) {
            ((n) viewParent).b(view, view2, i2, i3);
        } else if (i3 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i2);
                } catch (AbstractMethodError e2) {
                    new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedScrollAccepted");
                }
            } else if (viewParent instanceof m) {
                ((m) viewParent).onNestedScrollAccepted(view, view2, i2);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof n) {
            ((n) viewParent).k(view, i2);
        } else if (i2 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                } catch (AbstractMethodError e2) {
                    new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onStopNestedScroll");
                }
            } else if (viewParent instanceof m) {
                ((m) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6) {
        if (viewParent instanceof n) {
            ((n) viewParent).a(view, i2, i3, i4, i5, i6);
        } else if (i6 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i2, i3, i4, i5);
                } catch (AbstractMethodError e2) {
                    new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedScroll");
                }
            } else if (viewParent instanceof m) {
                ((m) viewParent).onNestedScroll(view, i2, i3, i4, i5);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof n) {
            ((n) viewParent).a(view, i2, i3, iArr, i4);
        } else if (i4 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i2, i3, iArr);
                } catch (AbstractMethodError e2) {
                    new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedPreScroll");
                }
            } else if (viewParent instanceof m) {
                ((m) viewParent).onNestedPreScroll(view, i2, i3, iArr);
            }
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z);
            } catch (AbstractMethodError e2) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedFling");
            }
        } else {
            if (viewParent instanceof m) {
                return ((m) viewParent).onNestedFling(view, f2, f3, z);
            }
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError e2) {
                new StringBuilder("ViewParent ").append(viewParent).append(" does not implement interface method onNestedPreFling");
            }
        } else {
            if (viewParent instanceof m) {
                return ((m) viewParent).onNestedPreFling(view, f2, f3);
            }
            return false;
        }
    }
}
