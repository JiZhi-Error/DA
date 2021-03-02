package android.support.v7.widget;

import android.content.Context;
import android.support.v4.widget.q;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] afR = {16843016};
    private final l akd;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i2) {
        super(aw.ae(context), attributeSet, i2);
        this.akd = new l(this);
        this.akd.a(attributeSet, i2);
        this.akd.jo();
        az a2 = az.a(getContext(), attributeSet, afR, i2, 0);
        setCheckMarkDrawable(a2.getDrawable(0));
        a2.ayy.recycle();
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(a.l(getContext(), i2));
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (this.akd != null) {
            this.akd.u(context, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.akd != null) {
            this.akd.jo();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return h.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(q.a(this, callback));
    }
}
