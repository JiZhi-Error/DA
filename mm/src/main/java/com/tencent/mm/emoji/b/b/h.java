package com.tencent.mm.emoji.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "emojiType", "", "sosDocId", "", "pageNo", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;I)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getEmojiType", "()I", "getPageNo", "getSosDocId", "()Ljava/lang/String;", "contentEquals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "equals", "plugin-emojisdk_release"})
public final class h extends ac {
    public final EmojiInfo gWm;
    public final int gYc;
    public final String gYd;
    public final int gYe;

    public /* synthetic */ h(EmojiInfo emojiInfo, int i2) {
        this(emojiInfo, i2, "", 0);
        AppMethodBeat.i(105538);
        AppMethodBeat.o(105538);
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean equals(Object obj) {
        AppMethodBeat.i(105536);
        if (!super.equals(obj) || !(obj instanceof h) || (!p.j(((h) obj).gWm.getMd5(), this.gWm.getMd5()) && (this.gWm.field_captureEnterTime == 0 || ((h) obj).gWm.field_captureEnterTime != this.gWm.field_captureEnterTime))) {
            AppMethodBeat.o(105536);
            return false;
        }
        AppMethodBeat.o(105536);
        return true;
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean aZ(Object obj) {
        AppMethodBeat.i(105537);
        if (super.aZ(obj) && (obj instanceof h) && ((h) obj).gWm.hYs() == this.gWm.hYs() && ((h) obj).gWm.getIndex() == this.gWm.getIndex() && ((h) obj).gWm.hYq() == this.gWm.hYq()) {
            AppMethodBeat.o(105537);
            return true;
        }
        AppMethodBeat.o(105537);
        return false;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(com.tencent.mm.storage.emotion.EmojiInfo r4, int r5, java.lang.String r6, int r7) {
        /*
            r3 = this;
            r2 = 199916(0x30cec, float:2.80142E-40)
            java.lang.String r0 = "emojiInfo"
            kotlin.g.b.p.h(r4, r0)
            java.lang.String r0 = "sosDocId"
            kotlin.g.b.p.h(r6, r0)
            com.tencent.mm.storage.emotion.EmojiInfo$a r0 = r4.hYs()
            if (r0 != 0) goto L_0x0028
        L_0x0015:
            r0 = 0
        L_0x0016:
            r3.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r3.gWm = r4
            r3.gYc = r5
            r3.gYd = r6
            r3.gYe = r7
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x0028:
            int[] r1 = com.tencent.mm.emoji.b.b.ae.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L_0x0015;
                default: goto L_0x0033;
            }
        L_0x0033:
            r0 = 6
            goto L_0x0016
            switch-data {1->0x0015, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.emoji.b.b.h.<init>(com.tencent.mm.storage.emotion.EmojiInfo, int, java.lang.String, int):void");
    }
}
