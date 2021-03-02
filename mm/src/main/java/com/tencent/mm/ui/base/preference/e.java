package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class e {
    Bitmap bitmap = null;
    int resId = -1;

    public final void p(ImageView imageView) {
        AppMethodBeat.i(142536);
        if (imageView == null) {
            AppMethodBeat.o(142536);
            return;
        }
        if (this.resId != -1) {
            imageView.setImageDrawable(a.l(imageView.getContext(), this.resId));
        }
        if (this.bitmap != null) {
            imageView.setImageBitmap(this.bitmap);
        }
        AppMethodBeat.o(142536);
    }
}
