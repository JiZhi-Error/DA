package com.tencent.mm.emoji.loader.d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
public final class h extends i<x> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(EmojiInfo emojiInfo) {
        super(emojiInfo);
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(105472);
        AppMethodBeat.o(105472);
    }

    @Override // com.tencent.mm.emoji.loader.d.i
    public final void dR(boolean z) {
        AppMethodBeat.i(105471);
        Intent intent = new Intent();
        intent.setAction(EmojiUpdateReceiver.ACTION);
        intent.putExtra(EmojiUpdateReceiver.KEY_TYPE, EmojiUpdateReceiver.hds);
        intent.putExtra("md5", this.gWm.getMd5());
        intent.putExtra("result", z);
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(105471);
    }
}
