package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.c;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderVideoMixRenderer;", "Lcom/tencent/mm/media/render/MixRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "videoHeight", "videoWidth", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setVideoSize", "", "width", "height", "plugin-finder_release"})
public final class m extends c {
    final String TAG;
    int videoHeight;
    int videoWidth;

    public /* synthetic */ m(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, 1);
    }

    public m(int i2, int i3, int i4, int i5, int i6) {
        super(i2, i3, i4, i5, i6, 4);
        this.TAG = "MicroMsg.FinderVideoMixRenderer";
    }

    @Override // com.tencent.mm.media.j.c, com.tencent.mm.media.j.a
    public final a aEC() {
        AppMethodBeat.i(254334);
        c cVar = new c(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
        cVar.ijA = this.ijA;
        int i2 = this.videoWidth;
        int i3 = this.videoHeight;
        cVar.videoWidth = i2;
        cVar.videoHeight = i3;
        c cVar2 = cVar;
        AppMethodBeat.o(254334);
        return cVar2;
    }
}
