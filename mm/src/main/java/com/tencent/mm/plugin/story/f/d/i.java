package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "", "(Ljava/lang/String;I)V", "NORMAL", "UNREAD_FIRST", "plugin-story_release"})
public enum i {
    NORMAL,
    UNREAD_FIRST;

    static {
        AppMethodBeat.i(118933);
        AppMethodBeat.o(118933);
    }

    public static i valueOf(String str) {
        AppMethodBeat.i(118935);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(118935);
        return iVar;
    }
}
