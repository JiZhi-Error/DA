package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.a;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import com.tencent.mm.R;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] oC = {16842912};
    private boolean oD;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.nx);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        u.a(this, new a() {
            /* class android.support.design.widget.CheckableImageButton.AnonymousClass1 */

            @Override // android.support.v4.view.a
            public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            @Override // android.support.v4.view.a
            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.setCheckable(true);
                cVar.Ro.setChecked(CheckableImageButton.this.isChecked());
            }
        });
    }

    public void setChecked(boolean z) {
        if (this.oD != z) {
            this.oD = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.oD;
    }

    public void toggle() {
        setChecked(!this.oD);
    }

    public int[] onCreateDrawableState(int i2) {
        if (this.oD) {
            return mergeDrawableStates(super.onCreateDrawableState(oC.length + i2), oC);
        }
        return super.onCreateDrawableState(i2);
    }
}
