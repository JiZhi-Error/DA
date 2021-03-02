package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditFontResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_PATH", "", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class e extends a {
    private static final h BYk = new h(0);
    public static final e BYn = new e();

    static {
        AppMethodBeat.i(237492);
        AppMethodBeat.o(237492);
    }

    private e() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final int eLi() {
        return 75;
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String eLk() {
        AppMethodBeat.i(237491);
        String str = b.aKC() + "fonts/";
        AppMethodBeat.o(237491);
        return str;
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String eLl() {
        return "WeChatFontResource/";
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String[] eLj() {
        return new String[]{"path"};
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final String getTag() {
        return "MicroMsg.VideoEditFontResLogic";
    }

    @Override // com.tencent.mm.plugin.recordvideo.res.a
    public final /* bridge */ /* synthetic */ b eLh() {
        return BYk;
    }
}
