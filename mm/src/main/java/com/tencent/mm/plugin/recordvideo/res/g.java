package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0006\u0010\u0017\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/VideoLabelModelResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "TAG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "afterUnZipRes", "", "success", "", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getModelFilePath", "getResParentPath", "getResType", "", "getTag", "isModelReady", "plugin-recordvideo_release"})
public final class g extends a {
    private static final h BYk = new h(75);
    public static final g BYp = new g();

    static {
        AppMethodBeat.i(237499);
        AppMethodBeat.o(237499);
    }

    private g() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String getTag() {
        return "MicroMsg.VideoLabelModelResLogic";
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final int eLi() {
        return 80;
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String[] eLj() {
        return new String[]{"path"};
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String eLk() {
        AppMethodBeat.i(237495);
        String str = b.aKC() + "ImageLabel/";
        AppMethodBeat.o(237495);
        return str;
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String eLl() {
        return "ImageLabelModel/";
    }

    public final String eLy() {
        AppMethodBeat.i(237496);
        String str = eLk() + "ImageLabel.xnet";
        AppMethodBeat.o(237496);
        return str;
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final void tu(boolean z) {
        AppMethodBeat.i(237498);
        if (z) {
            Log.i("MicroMsg.VideoLabelModelResLogic", "afterUnZipRes, success:".concat(String.valueOf(z)));
            StringBuilder sb = new StringBuilder();
            e eVar = e.JRF;
            StringBuilder append = sb.append(e.glu()).append(FilePathGenerator.ANDROID_DIR_SEP);
            e eVar2 = e.JRF;
            String sb2 = append.append(e.glv()).toString();
            s.nx(eLy(), sb2);
            Log.i("MicroMsg.VideoLabelModelResLogic", "afterUnZipRes, copy image label model path, from:" + eLy() + " to " + sb2);
        }
        AppMethodBeat.o(237498);
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final /* bridge */ /* synthetic */ b eLh() {
        return BYk;
    }

    public final boolean eLz() {
        AppMethodBeat.i(237497);
        if (!this.BXZ || !s.YS(eLy())) {
            AppMethodBeat.o(237497);
            return false;
        }
        AppMethodBeat.o(237497);
        return true;
    }
}
