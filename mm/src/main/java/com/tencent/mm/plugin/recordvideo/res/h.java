package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0003J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "startKey", "", "(I)V", "checkRes", "", "editExist", "editNotExist", "finishDownload", "initExist", "initNotExist", "report", "key", "unzipFail", "unzipSuccess", "Companion", "plugin-recordvideo_release"})
public final class h implements b {
    public static final a BYq = new a((byte) 0);
    private final int BYi;

    static {
        AppMethodBeat.i(237509);
        AppMethodBeat.o(237509);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport$Companion;", "", "()V", "ID", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public h(int i2) {
        this.BYi = i2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.b
    public final void eLp() {
        AppMethodBeat.i(237500);
        pl(this.BYi);
        AppMethodBeat.o(237500);
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.b
    public final void eLq() {
        AppMethodBeat.i(237501);
        pl(this.BYi + 1);
        AppMethodBeat.o(237501);
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.b
    public final void eLr() {
        AppMethodBeat.i(237502);
        pl(this.BYi + 2);
        AppMethodBeat.o(237502);
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.b
    public final void eLs() {
        AppMethodBeat.i(237503);
        pl(this.BYi + 3);
        AppMethodBeat.o(237503);
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.b
    public final void bbA() {
        AppMethodBeat.i(237504);
        pl(this.BYi + 4);
        AppMethodBeat.o(237504);
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.b
    public final void eLt() {
        AppMethodBeat.i(237505);
        pl(this.BYi + 5);
        AppMethodBeat.o(237505);
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.b
    public final void eLu() {
        AppMethodBeat.i(237506);
        pl(this.BYi + 6);
        AppMethodBeat.o(237506);
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.b
    public final void eLv() {
        AppMethodBeat.i(237507);
        pl(this.BYi + 7);
        AppMethodBeat.o(237507);
    }

    private static void pl(int i2) {
        AppMethodBeat.i(237508);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1388, i2);
        AppMethodBeat.o(237508);
    }
}
