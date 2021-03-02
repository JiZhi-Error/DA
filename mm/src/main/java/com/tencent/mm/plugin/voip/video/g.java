package com.tencent.mm.plugin.voip.video;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/VoipSurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "texName", "", "(I)V", "TAG", "", "plugin-voip_release"})
public final class g extends SurfaceTexture {
    private final String TAG = "MicroMsg.VoipSurfaceTexture";

    public g(int i2) {
        super(i2);
        AppMethodBeat.i(115960);
        try {
            super.detachFromGLContext();
            AppMethodBeat.o(115960);
        } catch (Exception e2) {
            Log.i(this.TAG, "detachFromGLContext  in init error");
            AppMethodBeat.o(115960);
        }
    }
}
