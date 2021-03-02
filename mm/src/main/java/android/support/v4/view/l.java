package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public final class l {
    private ViewParent PW;
    private ViewParent PX;
    public boolean PY;
    private int[] PZ;
    private final View mView;

    public l(View view) {
        this.mView = view;
    }

    public final void setNestedScrollingEnabled(boolean z) {
        if (this.PY) {
            u.ax(this.mView);
        }
        this.PY = z;
    }

    public final boolean isNestedScrollingEnabled() {
        return this.PY;
    }

    public final boolean hasNestedScrollingParent() {
        return aN(0);
    }

    public final boolean aN(int i2) {
        return aO(i2) != null;
    }

    public final boolean startNestedScroll(int i2) {
        return A(i2, 0);
    }

    public final boolean A(int i2, int i3) {
        if (aN(i3)) {
            return true;
        }
        if (this.PY) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (x.a(parent, view, this.mView, i2, i3)) {
                    a(i3, parent);
                    x.b(parent, view, this.mView, i2, i3);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public final void stopNestedScroll() {
        aM(0);
    }

    public final void aM(int i2) {
        ViewParent aO = aO(i2);
        if (aO != null) {
            x.a(aO, this.mView, i2);
            a(i2, null);
        }
    }

    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return a(i2, i3, i4, i5, iArr, 0);
    }

    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public final boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        int i5;
        int i6;
        int[] iArr3;
        if (this.PY) {
            ViewParent aO = aO(i4);
            if (aO == null) {
                return false;
            }
            if (i2 != 0 || i3 != 0) {
                if (iArr2 != null) {
                    this.mView.getLocationInWindow(iArr2);
                    int i7 = iArr2[0];
                    i5 = iArr2[1];
                    i6 = i7;
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                if (iArr == null) {
                    if (this.PZ == null) {
                        this.PZ = new int[2];
                    }
                    iArr3 = this.PZ;
                } else {
                    iArr3 = iArr;
                }
                iArr3[0] = 0;
                iArr3[1] = 0;
                x.a(aO, this.mView, i2, i3, iArr3, i4);
                if (iArr2 != null) {
                    this.mView.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i6;
                    iArr2[1] = iArr2[1] - i5;
                }
                return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        ViewParent aO;
        if (!this.PY || (aO = aO(0)) == null) {
            return false;
        }
        return x.a(aO, this.mView, f2, f3, z);
    }

    public final boolean dispatchNestedPreFling(float f2, float f3) {
        ViewParent aO;
        if (!this.PY || (aO = aO(0)) == null) {
            return false;
        }
        return x.a(aO, this.mView, f2, f3);
    }

    private ViewParent aO(int i2) {
        switch (i2) {
            case 0:
                return this.PW;
            case 1:
                return this.PX;
            default:
                return null;
        }
    }

    private void a(int i2, ViewParent viewParent) {
        switch (i2) {
            case 0:
                this.PW = viewParent;
                return;
            case 1:
                this.PX = viewParent;
                return;
            default:
                return;
        }
    }

    public final boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        ViewParent aO;
        int i7;
        int i8;
        if (!this.PY || (aO = aO(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            int i9 = iArr[0];
            i7 = iArr[1];
            i8 = i9;
        } else {
            i7 = 0;
            i8 = 0;
        }
        x.a(aO, this.mView, i2, i3, i4, i5, i6);
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i8;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }
}
