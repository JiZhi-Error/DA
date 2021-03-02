package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/render/RecorderTextureRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "TAG", "", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "setTextureSize", "width", "height", "updateDrawViewSize", "updateTextureSize", "plugin-recordvideo_release"})
public final class a extends com.tencent.mm.media.j.a {
    private final String TAG = "MicroMsg.RecorderTextureRenderer";

    public a() {
        super(0, 0, 1, 1, 15);
    }

    public final void hX(int i2, int i3) {
        AppMethodBeat.i(182856);
        super.cZ(i2, i3);
        AppMethodBeat.o(182856);
    }

    @Override // com.tencent.mm.media.j.a
    public final com.tencent.mm.media.j.b.a aEC() {
        AppMethodBeat.i(182857);
        e eVar = new e(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
        AppMethodBeat.o(182857);
        return eVar;
    }

    @Override // com.tencent.mm.media.j.a
    public final void cZ(int i2, int i3) {
        AppMethodBeat.i(182858);
        Log.i(this.TAG, "updateTextureSize " + i2 + ", " + i3 + "; " + this.hDn + ", " + this.hDo);
        AppMethodBeat.o(182858);
    }

    @Override // com.tencent.mm.media.j.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(182859);
        super.cY(i2, i3);
        AppMethodBeat.o(182859);
    }

    @Override // com.tencent.mm.media.j.a
    public final void qx(int i2) {
    }

    @Override // com.tencent.mm.media.j.a
    public final void eD(boolean z) {
    }
}
