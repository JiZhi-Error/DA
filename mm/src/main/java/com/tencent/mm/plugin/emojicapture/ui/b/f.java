package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRGBRenderProc;", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiPreviewRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getInputRenderProc", "release", "", "setFrame", "frame", "", "plugin-emojicapture_release"})
public final class f extends j {
    private a rwy;

    public f(int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i2, i3, i4, i5, i6, i7);
        AppMethodBeat.i(s.CTRL_INDEX);
        this.rwy = new com.tencent.mm.media.j.b.f(i2, i3, this.outputWidth, this.outputHeight, 2, 2);
        a aVar = this.rwy;
        if (aVar != null) {
            aVar.ijH = true;
            AppMethodBeat.o(s.CTRL_INDEX);
            return;
        }
        AppMethodBeat.o(s.CTRL_INDEX);
    }

    @Override // com.tencent.mm.plugin.emojicapture.ui.b.j
    public final a cJT() {
        return this.rwy;
    }

    @Override // com.tencent.mm.media.j.b.a
    public final void ag(byte[] bArr) {
        AppMethodBeat.i(855);
        p.h(bArr, "frame");
        a aVar = this.rwy;
        if (aVar != null) {
            aVar.ag(bArr);
            AppMethodBeat.o(855);
            return;
        }
        AppMethodBeat.o(855);
    }

    @Override // com.tencent.mm.media.j.b.a, com.tencent.mm.plugin.emojicapture.ui.b.j
    public final void release() {
        AppMethodBeat.i(856);
        super.release();
        a aVar = this.rwy;
        if (aVar != null) {
            aVar.release();
            AppMethodBeat.o(856);
            return;
        }
        AppMethodBeat.o(856);
    }
}
