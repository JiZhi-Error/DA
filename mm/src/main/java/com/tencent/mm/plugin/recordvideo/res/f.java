package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditTransitionResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "RES_FILE_PAG", "RES_FILE_SVG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class f extends a {
    private static final h BYk = new h(20);
    public static final f BYo = new f();

    static {
        AppMethodBeat.i(237494);
        AppMethodBeat.o(237494);
    }

    private f() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final int eLi() {
        return 76;
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String eLk() {
        AppMethodBeat.i(237493);
        String str = b.aKC() + "transition/";
        AppMethodBeat.o(237493);
        return str;
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String eLl() {
        return "WeChatVideoTransitionResource/";
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String[] eLj() {
        return new String[]{"pag"};
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String getTag() {
        return "MicroMsg.VideoEditTransitionResLogic";
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final /* bridge */ /* synthetic */ b eLh() {
        return BYk;
    }
}
