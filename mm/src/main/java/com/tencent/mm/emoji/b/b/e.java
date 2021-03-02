package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "hasSystem", "(ZZ)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class e extends a {
    private final List<EmojiInfo> gXX;
    private int gXY;

    public e(boolean z, boolean z2) {
        super(ad.avG());
        v vVar;
        e eVar;
        AppMethodBeat.i(105531);
        ArrayList<EmojiInfo> dT = j.auL().dT(true);
        if (dT != null) {
            vVar = dT;
            eVar = this;
        } else {
            vVar = v.SXr;
            eVar = this;
        }
        eVar.gXX = vVar;
        this.gXY = this.gXX.size();
        this.gXW.add(this.gXV);
        if (z) {
            this.gXW.add(new m(0));
        }
        for (EmojiInfo emojiInfo : this.gXX) {
            if (z2 || emojiInfo.field_catalog != EmojiGroupInfo.VkO) {
                LinkedList<ac> linkedList = this.gXW;
                p.g(emojiInfo, "info");
                linkedList.add(new h(emojiInfo, 0));
            }
        }
        AppMethodBeat.o(105531);
    }

    @Override // com.tencent.mm.emoji.b.b.w
    public final int avo() {
        return this.gXY;
    }
}
