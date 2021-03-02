package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/CaptureItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "(Z)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class c extends a {
    private final List<EmojiInfo> gXX;
    private int gXY;

    public c(boolean z) {
        super(ad.avH());
        v vVar;
        c cVar;
        AppMethodBeat.i(105526);
        ArrayList<EmojiInfo> dU = j.auL().dU(true);
        if (dU != null) {
            vVar = dU;
            cVar = this;
        } else {
            vVar = v.SXr;
            cVar = this;
        }
        cVar.gXX = vVar;
        this.gXY = this.gXX.size();
        if (!this.gXX.isEmpty()) {
            this.gXW.add(this.gXV);
            if (z) {
                this.gXW.add(new m(1));
            }
            LinkedList<ac> linkedList = this.gXW;
            List<EmojiInfo> list = this.gXX;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
            for (T t : list) {
                p.g(t, LocaleUtil.ITALIAN);
                arrayList.add(new h(t, 1));
            }
            linkedList.addAll(arrayList);
        } else if (z) {
            this.gXW.add(new b());
            AppMethodBeat.o(105526);
            return;
        }
        AppMethodBeat.o(105526);
    }

    @Override // com.tencent.mm.emoji.b.b.w
    public final int avo() {
        return this.gXY;
    }
}
