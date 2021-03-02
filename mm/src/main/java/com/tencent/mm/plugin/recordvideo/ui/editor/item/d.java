package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.google.android.gms.stats.CodePackage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "EMOJI", CodePackage.LOCATION, "TIP", "LYRICS", "CAPTION", "RECORD_CAPTION", "PAG_STICKER", "plugin-recordvideo_release"})
public enum d {
    TEXT(1),
    EMOJI(2),
    CeM(3),
    TIP(4),
    LYRICS(5),
    CAPTION(6),
    RECORD_CAPTION(7),
    PAG_STICKER(8);
    
    public final int value;

    public static d valueOf(String str) {
        AppMethodBeat.i(237757);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(237757);
        return dVar;
    }

    private d(int i2) {
        this.value = i2;
    }

    static {
        AppMethodBeat.i(237755);
        AppMethodBeat.o(237755);
    }
}
