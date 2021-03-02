package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton extends ImageButton {
    private int wJ;

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.wJ = getVisibility();
    }

    public void setVisibility(int i2) {
        e(i2, true);
    }

    public final void e(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.wJ = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.wJ;
    }
}
