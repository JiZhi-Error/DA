package com.tencent.mm.plugin.story.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "", "(Ljava/lang/String;I)V", "COMMON_SCENE", "ALBUM_SCENE", "FAV_SCENE", "plugin-story_release"})
public enum a {
    COMMON_SCENE,
    ALBUM_SCENE,
    FAV_SCENE;

    static {
        AppMethodBeat.i(118888);
        AppMethodBeat.o(118888);
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(118890);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(118890);
        return aVar;
    }
}
