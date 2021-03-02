package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ab;
import com.tencent.mm.emoji.b.b.n;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/panel/PagEmojiPanelDataProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "()V", "createGroupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "createGroupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getGroupId", "", "plugin-vlog_release"})
public final class a implements n {
    @Override // com.tencent.mm.emoji.b.b.n
    public final String avy() {
        AppMethodBeat.i(190782);
        String fCd = b.fCd();
        AppMethodBeat.o(190782);
        return fCd;
    }

    @Override // com.tencent.mm.emoji.b.b.n
    public final EmojiGroupInfo avz() {
        AppMethodBeat.i(190783);
        EmojiGroupInfo fCe = b.fCe();
        AppMethodBeat.o(190783);
        return fCe;
    }

    @Override // com.tencent.mm.emoji.b.b.n
    public final ab<?> avA() {
        AppMethodBeat.i(190784);
        c cVar = new c();
        AppMethodBeat.o(190784);
        return cVar;
    }
}
