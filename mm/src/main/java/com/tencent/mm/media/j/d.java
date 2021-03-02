package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import com.tencent.mm.sdk.platformtools.Log;
import javax.microedition.khronos.opengles.GL10;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "renderOutputType", "", "(I)V", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "plugin-mediaeditor_release"})
public abstract class d extends a {
    public d(int i2) {
        super(0, 0, 0, 0, i2, 2);
    }

    @Override // com.tencent.mm.media.j.a
    public void onDrawFrame(GL10 gl10) {
        try {
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Media.AbsSurfaceRenderer", e2, "updateTexImage error", new Object[0]);
        }
        if (this.ijr) {
            this.ijr = false;
        } else {
            super.onDrawFrame(gl10);
        }
    }
}
