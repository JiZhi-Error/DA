package com.tencent.mm.emoji.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/PlaceHolderItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiType", "", "(I)V", "getEmojiType", "()I", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "plugin-emojisdk_release"})
public final class ah extends ac {
    public final int gYc;

    public ah(int i2) {
        super(i2);
        this.gYc = i2;
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean equals(Object obj) {
        AppMethodBeat.i(161813);
        if (!super.equals(obj) || !(obj instanceof ah) || ((ah) obj).gYc != this.gYc) {
            AppMethodBeat.o(161813);
            return false;
        }
        AppMethodBeat.o(161813);
        return true;
    }
}
