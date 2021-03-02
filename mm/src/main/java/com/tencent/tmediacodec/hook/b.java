package com.tencent.tmediacodec.hook;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends SurfaceTexture {
    public final void release() {
        AppMethodBeat.i(190138);
        super.release();
        AppMethodBeat.o(190138);
    }
}
