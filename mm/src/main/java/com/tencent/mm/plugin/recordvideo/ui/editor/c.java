package com.tencent.mm.plugin.recordvideo.ui.editor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFramePosition;", "", "position", "", "(Ljava/lang/String;II)V", "POSITION_LEFT", "POSITION_TOP", "POSITION_RIGHT", "POSITION_BOTTOM", "plugin-recordvideo_release"})
public enum c {
    POSITION_LEFT,
    POSITION_TOP,
    POSITION_RIGHT,
    POSITION_BOTTOM;

    public static c valueOf(String str) {
        AppMethodBeat.i(75975);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(75975);
        return cVar;
    }

    static {
        AppMethodBeat.i(75973);
        AppMethodBeat.o(75973);
    }
}
