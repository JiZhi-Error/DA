package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureCropTopRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "externalRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getInputRenderProc", "release", "", "setInputTexture", "texture", "plugin-emojicapture_release"})
public final class a extends j {
    private final String TAG = "MicroMsg.EmojiCaptureCropTopRenderProc";
    private com.tencent.mm.media.j.b.a rvR;

    public a(int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i2, i3, i4, i5, i6, i7);
        AppMethodBeat.i(830);
        this.rvR = new c(i2, i3, this.outputWidth, this.outputHeight, 2, 2);
        com.tencent.mm.media.j.b.a aVar = this.rvR;
        if (aVar != null) {
            aVar.ijH = true;
            AppMethodBeat.o(830);
            return;
        }
        AppMethodBeat.o(830);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.j
    public final com.tencent.mm.media.j.b.a cJT() {
        return this.rvR;
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void rl(int i2) {
        AppMethodBeat.i(828);
        com.tencent.mm.media.j.b.a aVar = this.rvR;
        if (aVar != null) {
            aVar.rl(i2);
            AppMethodBeat.o(828);
            return;
        }
        AppMethodBeat.o(828);
    }

    @Override // com.tencent.mm.media.j.b.a, com.tencent.mm.plugin.emojicapture.ui.b.j
    public final void release() {
        AppMethodBeat.i(cj.CTRL_INDEX);
        super.release();
        com.tencent.mm.media.j.b.a aVar = this.rvR;
        if (aVar != null) {
            aVar.release();
            AppMethodBeat.o(cj.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(cj.CTRL_INDEX);
    }
}
