package android.support.v7.g;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public final class a implements TransformationMethod {
    private Locale QF;

    public a(Context context) {
        this.QF = context.getResources().getConfiguration().locale;
    }

    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence != null) {
            return charSequence.toString().toUpperCase(this.QF);
        }
        return null;
    }

    public final void onFocusChanged(View view, CharSequence charSequence, boolean z, int i2, Rect rect) {
    }
}
