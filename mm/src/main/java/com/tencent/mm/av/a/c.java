package com.tencent.mm.av.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class c {
    public int height = 0;
    public WeakReference<ImageView> iaF;
    public final int iaH;
    private String url = "";
    public int width = 0;

    public c(ImageView imageView, String str) {
        AppMethodBeat.i(130375);
        this.iaF = new WeakReference<>(imageView);
        this.url = str;
        if (imageView != null) {
            this.iaH = imageView.hashCode();
            AppMethodBeat.o(130375);
            return;
        }
        this.iaH = hashCode();
        AppMethodBeat.o(130375);
    }

    public final ImageView getImageView() {
        ImageView imageView;
        AppMethodBeat.i(130376);
        if (this.iaF == null || (imageView = this.iaF.get()) == null) {
            AppMethodBeat.o(130376);
            return null;
        }
        AppMethodBeat.o(130376);
        return imageView;
    }
}
