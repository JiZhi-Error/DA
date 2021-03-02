package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/EditorConfig;", "", "()V", "autoDisplayMusicPanel", "", "getAutoDisplayMusicPanel", "()Z", "setAutoDisplayMusicPanel", "(Z)V", "autoPlayAudio", "getAutoPlayAudio", "setAutoPlayAudio", "muteOrigin", "getMuteOrigin", "setMuteOrigin", "scene", "Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "getScene", "()Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "setScene", "(Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;)V", "showLyrics", "getShowLyrics", "setShowLyrics", "showMuteOrigin", "getShowMuteOrigin", "setShowMuteOrigin", "enableAutoPlayAudio", "enableLyrics", "enableMuteOrigin", "plugin-recordvideo_release"})
public final class d {
    public boolean BNa;
    public boolean BNb;
    public boolean BNc;
    public boolean BNd = true;
    public boolean BNe;
    public i BNf = i.StoryComm;

    public final d a(i iVar) {
        AppMethodBeat.i(75369);
        p.h(iVar, "scene");
        this.BNf = iVar;
        AppMethodBeat.o(75369);
        return this;
    }
}
