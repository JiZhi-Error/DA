package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoState;", "", "(Ljava/lang/String;I)V", "Empty", "Fake", "Uploading", "Normal", "plugin-story_release"})
public enum k {
    Empty,
    Fake,
    Uploading,
    Normal;

    static {
        AppMethodBeat.i(118942);
        AppMethodBeat.o(118942);
    }

    public static k valueOf(String str) {
        AppMethodBeat.i(118944);
        k kVar = (k) Enum.valueOf(k.class, str);
        AppMethodBeat.o(118944);
        return kVar;
    }
}
