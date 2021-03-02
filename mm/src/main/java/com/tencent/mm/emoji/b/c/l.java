package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "type", "", "reportPosition", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;II)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getReportPosition", "()I", "setReportPosition", "(I)V", "getType", "setType", "plugin-emojisdk_release"})
public final class l {
    public final EmojiInfo gWm;
    public int gZO;
    public int type;

    public l(EmojiInfo emojiInfo, int i2, int i3) {
        p.h(emojiInfo, "emojiInfo");
        AppMethodBeat.i(199958);
        this.gWm = emojiInfo;
        this.type = i2;
        this.gZO = i3;
        AppMethodBeat.o(199958);
    }
}
