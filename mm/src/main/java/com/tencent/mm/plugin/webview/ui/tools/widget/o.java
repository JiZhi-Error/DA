package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0006"}, hxF = {"toColor", "", "context", "Landroid/content/Context;", "toDrawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
public final class o {
    static final Drawable ia(Context context) {
        AppMethodBeat.i(175713);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.gv, typedValue, true);
        Drawable l = b.l(context, typedValue.resourceId);
        AppMethodBeat.o(175713);
        return l;
    }

    static final int e(int i2, Context context) {
        AppMethodBeat.i(82750);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        int n = b.n(context, typedValue.resourceId);
        AppMethodBeat.o(82750);
        return n;
    }
}
