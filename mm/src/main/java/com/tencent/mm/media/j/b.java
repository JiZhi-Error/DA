package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
public final class b implements SurfaceTexture.OnFrameAvailableListener {
    private final /* synthetic */ kotlin.g.a.b hXF;

    public b(kotlin.g.a.b bVar) {
        this.hXF = bVar;
    }

    public final /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(93837);
        p.g(this.hXF.invoke(surfaceTexture), "invoke(...)");
        AppMethodBeat.o(93837);
    }
}
