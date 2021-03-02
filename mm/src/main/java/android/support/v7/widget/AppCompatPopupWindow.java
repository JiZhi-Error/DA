package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.widget.n;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* access modifiers changed from: package-private */
public class AppCompatPopupWindow extends PopupWindow {
    private static final boolean akJ = (Build.VERSION.SDK_INT < 21);
    private boolean akK;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet, i2, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        b(context, attributeSet, i2, i3);
    }

    private void b(Context context, AttributeSet attributeSet, int i2, int i3) {
        az a2 = az.a(context, attributeSet, a.C0040a.PopupWindow, i2, i3);
        if (a2.hasValue(2)) {
            ag(a2.getBoolean(2, false));
        }
        setBackgroundDrawable(a2.getDrawable(0));
        a2.ayy.recycle();
    }

    public void showAsDropDown(View view, int i2, int i3) {
        if (akJ && this.akK) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (akJ && this.akK) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        int i6;
        if (!akJ || !this.akK) {
            i6 = i3;
        } else {
            i6 = i3 - view.getHeight();
        }
        super.update(view, i2, i6, i4, i5);
    }

    private void ag(boolean z) {
        if (akJ) {
            this.akK = z;
        } else {
            n.a(this, z);
        }
    }
}
