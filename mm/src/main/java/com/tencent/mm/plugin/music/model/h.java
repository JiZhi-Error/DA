package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/music/model/MusicFloatBallService;", "Lcom/tencent/mm/modelmusic/api/IMusicFloatBallService;", "()V", "notifyMusicFloatBallCoverChanged", "", "musicId", "", "coverPath", "updateMusicInfo", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "musicWrapperExtend", "Lcom/tencent/mm/modelmusic/MusicWrapperExtend;", "Companion", "plugin-music_release"})
public final class h implements com.tencent.mm.ay.a.a {
    public static final a Akv = new a((byte) 0);

    static {
        AppMethodBeat.i(219977);
        AppMethodBeat.o(219977);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/music/model/MusicFloatBallService$Companion;", "", "()V", "TAG", "", "plugin-music_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ay.a.a
    public final void bw(String str, String str2) {
        AppMethodBeat.i(219975);
        b.iX(str, str2);
        AppMethodBeat.o(219975);
    }

    @Override // com.tencent.mm.ay.a.a
    public final void b(f fVar, com.tencent.mm.ay.h hVar) {
        AppMethodBeat.i(219976);
        b.b(fVar, hVar);
        AppMethodBeat.o(219976);
    }
}
