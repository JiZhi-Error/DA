package com.tencent.mm.emoji.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/GroupExpandItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "expand", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "getExpand", "()Z", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "contentEquals", FacebookRequestErrorClassification.KEY_OTHER, "", "equals", "plugin-emojisdk_release"})
public final class t extends ac {
    private final EmojiGroupInfo gVA;
    public final boolean gYL;

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean equals(Object obj) {
        AppMethodBeat.i(105559);
        if (!super.equals(obj) || !(obj instanceof t) || !p.j(((t) obj).gVA.hYf(), this.gVA.hYf())) {
            AppMethodBeat.o(105559);
            return false;
        }
        AppMethodBeat.o(105559);
        return true;
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean aZ(Object obj) {
        AppMethodBeat.i(105560);
        if (!super.aZ(obj) || !(obj instanceof t) || !p.j(((t) obj).gVA.hYf(), this.gVA.hYf()) || ((t) obj).gYL != this.gYL) {
            AppMethodBeat.o(105560);
            return false;
        }
        AppMethodBeat.o(105560);
        return true;
    }
}
