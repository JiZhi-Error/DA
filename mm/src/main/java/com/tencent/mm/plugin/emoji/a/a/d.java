package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;

public final class d extends c {
    private final String TAG = "MicroMsg.emoji.EmojiListMineData";

    public d(g gVar) {
        super(gVar);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.c
    public final void clear() {
        AppMethodBeat.i(108372);
        super.clear();
        AppMethodBeat.o(108372);
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.c
    public final void cFq() {
    }

    @Override // com.tencent.mm.plugin.emoji.a.a.c
    public final synchronized void notifyDataSetChanged() {
        AppMethodBeat.i(108371);
        ArrayList<EmojiGroupInfo> gES = k.getEmojiStorageMgr().OpO.gES();
        boolean cHz = a.cHz();
        this.mItemList = new ArrayList();
        Log.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
        for (EmojiGroupInfo emojiGroupInfo : gES) {
            EmotionSummary hYh = emojiGroupInfo.hYh();
            f fVar = new f(hYh);
            if (a.g(hYh) && cHz) {
                this.qYh.put(hYh.ProductID, new bh(hYh.ProductID));
            }
            fVar.setStatus(9);
            this.mItemList.add(fVar);
        }
        AppMethodBeat.o(108371);
    }
}
