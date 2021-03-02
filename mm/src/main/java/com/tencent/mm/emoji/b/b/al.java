package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/StoreItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "empty", "", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "hasNew", "getHasNew", "()Z", "setHasNew", "(Z)V", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class al extends a {
    private final List<EmojiInfo> gXX;
    private int gXY;
    public boolean gYN;

    public /* synthetic */ al(EmojiGroupInfo emojiGroupInfo) {
        this(emojiGroupInfo, false);
        AppMethodBeat.i(105587);
        AppMethodBeat.o(105587);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public al(EmojiGroupInfo emojiGroupInfo, boolean z) {
        super(emojiGroupInfo);
        v vVar;
        al alVar;
        p.h(emojiGroupInfo, "groupInfo");
        AppMethodBeat.i(199929);
        if (z) {
            vVar = v.SXr;
            alVar = this;
        } else {
            ArrayList<EmojiInfo> EQ = j.auL().EQ(emojiGroupInfo.hYf());
            if (EQ != null) {
                vVar = EQ;
                alVar = this;
            } else {
                vVar = v.SXr;
                alVar = this;
            }
        }
        alVar.gXX = vVar;
        this.gXY = this.gXX.size();
        PersonalDesigner ER = j.auL().ER(emojiGroupInfo.hYf());
        if (ER != null) {
            this.gXV.gYM = ER;
            u uVar = this.gXV;
            bg.a aVar = bg.a.Opu;
            uVar.gYN = bg.a.aki(ER.DesignerUin).gCH();
            this.gYN = this.gXV.gYN;
        }
        this.gXW.add(this.gXV);
        Iterator<T> it = this.gXX.iterator();
        while (it.hasNext()) {
            this.gXW.add(new h(it.next(), 2));
        }
        AppMethodBeat.o(199929);
    }

    @Override // com.tencent.mm.emoji.b.b.w
    public final int avo() {
        return this.gXY;
    }
}
