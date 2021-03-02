package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/VideoMusicBussId;", "", "(Ljava/lang/String;I)V", "StoryComm", "SNSComm", "WXGGame", "ListenAPP", "WeiShi", "StoryPic", "Chatting", "ChatVideo", "Collection", "CameraApp", "Finder", "plugin-recordvideo_release"})
public enum i {
    StoryComm,
    SNSComm,
    WXGGame,
    ListenAPP,
    WeiShi,
    StoryPic,
    Chatting,
    ChatVideo,
    Collection,
    CameraApp,
    Finder;

    static {
        AppMethodBeat.i(75385);
        AppMethodBeat.o(75385);
    }

    public static i valueOf(String str) {
        AppMethodBeat.i(75387);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(75387);
        return iVar;
    }
}
