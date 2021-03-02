package com.tencent.mm.emoji.e;

import android.content.Context;
import android.util.TypedValue;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001¨\u0006\u000b"}, hxF = {"getAttrResId", "", "context", "Landroid/content/Context;", "attributeId", "Landroid/view/View;", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojisdk_release"})
public final class e {
    public static final void a(ImageView imageView, int i2, int i3) {
        AppMethodBeat.i(105783);
        p.h(imageView, "$this$setSvgDrawable");
        imageView.setImageDrawable(ar.m(imageView.getContext(), i2, i3));
        AppMethodBeat.o(105783);
    }

    public static final int cG(Context context) {
        AppMethodBeat.i(105784);
        if (context == null) {
            AppMethodBeat.o(105784);
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.kl, typedValue, true);
        int i2 = typedValue.resourceId;
        AppMethodBeat.o(105784);
        return i2;
    }
}
