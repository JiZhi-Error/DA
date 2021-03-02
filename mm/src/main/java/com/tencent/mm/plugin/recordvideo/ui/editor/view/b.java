package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "", "(Ljava/lang/String;I)V", "EditItemTypeDefault", "EditItemTypeText", "EditItemTypeTip", "EditItemTypePosition", "EditItemTypeLyrics", "EditItemTypeEmoji", "EditItemTypeCaption", "EditItemTypeRecordCaption", "EditItemTypePagSticker", "plugin-recordvideo_release"})
public enum b {
    EditItemTypeDefault,
    EditItemTypeText,
    EditItemTypeTip,
    EditItemTypePosition,
    EditItemTypeLyrics,
    EditItemTypeEmoji,
    EditItemTypeCaption,
    EditItemTypeRecordCaption,
    EditItemTypePagSticker;

    static {
        AppMethodBeat.i(237953);
        AppMethodBeat.o(237953);
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(237955);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(237955);
        return bVar;
    }
}
