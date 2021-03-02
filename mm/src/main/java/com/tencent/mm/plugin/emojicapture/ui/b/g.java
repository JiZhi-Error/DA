package com.tencent.mm.plugin.emojicapture.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.a;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.ad;
import com.tencent.mm.plugin.emojicapture.model.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureRecorderRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "()V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "mirror", "", "", "setRotate", "degree", "", "updateDrawViewSize", "width", "height", "updateTextureSize", "plugin-emojicapture_release"})
public final class g extends a {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g() {
        /*
            r8 = this;
            r7 = 861(0x35d, float:1.207E-42)
            r5 = 1
            com.tencent.mm.plugin.emojicapture.model.d$a r0 = com.tencent.mm.plugin.emojicapture.model.d.roA
            int r1 = com.tencent.mm.plugin.emojicapture.model.d.cIG()
            com.tencent.mm.plugin.emojicapture.model.d$a r0 = com.tencent.mm.plugin.emojicapture.model.d.roA
            int r2 = com.tencent.mm.plugin.emojicapture.model.d.cIG()
            com.tencent.mm.plugin.emojicapture.model.d$a r0 = com.tencent.mm.plugin.emojicapture.model.d.roA
            int r3 = com.tencent.mm.plugin.emojicapture.model.d.cIG()
            com.tencent.mm.plugin.emojicapture.model.d$a r0 = com.tencent.mm.plugin.emojicapture.model.d.roA
            int r4 = com.tencent.mm.plugin.emojicapture.model.d.cIG()
            r0 = r8
            r6 = r5
            r0.<init>(r1, r2, r3, r4, r5, r6)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emojicapture.ui.b.g.<init>():void");
    }

    @Override // com.tencent.mm.media.j.a
    public final com.tencent.mm.media.j.b.a aEC() {
        AppMethodBeat.i(858);
        e eVar = new e(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
        AppMethodBeat.o(858);
        return eVar;
    }

    @Override // com.tencent.mm.media.j.a
    public final void cZ(int i2, int i3) {
        AppMethodBeat.i(859);
        d.a aVar = d.roA;
        int i4 = d.rov;
        d.a aVar2 = d.roA;
        super.cZ(i4, d.rov);
        AppMethodBeat.o(859);
    }

    @Override // com.tencent.mm.media.j.a
    public final void cY(int i2, int i3) {
        AppMethodBeat.i(ad.CTRL_INDEX);
        d.a aVar = d.roA;
        int i4 = d.rov;
        d.a aVar2 = d.roA;
        super.cY(i4, d.rov);
        AppMethodBeat.o(ad.CTRL_INDEX);
    }

    @Override // com.tencent.mm.media.j.a
    public final void qx(int i2) {
    }

    @Override // com.tencent.mm.media.j.a
    public final void eD(boolean z) {
    }
}
