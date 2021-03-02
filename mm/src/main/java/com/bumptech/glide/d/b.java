package com.bumptech.glide.d;

import com.bumptech.glide.load.ImageHeaderParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private final List<ImageHeaderParser> aFx = new ArrayList();

    public b() {
        AppMethodBeat.i(77601);
        AppMethodBeat.o(77601);
    }

    public final synchronized List<ImageHeaderParser> pV() {
        return this.aFx;
    }

    public final synchronized void b(ImageHeaderParser imageHeaderParser) {
        AppMethodBeat.i(77602);
        this.aFx.add(imageHeaderParser);
        AppMethodBeat.o(77602);
    }
}
