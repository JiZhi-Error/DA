package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/SmileyItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "recentMaxCount", "", "(I)V", "hasRecent", "", "getHasRecent", "()Z", "recentTitle", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "reportCount", "getReportCount", "plugin-emojisdk_release"})
public final class aj extends a {
    private int gXY;
    private final u gZi = new u(ad.avE());
    public final boolean gZj;

    public aj(int i2) {
        super(ad.avF());
        AppMethodBeat.i(199926);
        a ah = g.ah(d.class);
        p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
        e provider = ((d) ah).getProvider();
        p.g(provider, "MMKernel.plugin(IPluginEmoji::class.java).provider");
        List<v> cFQ = provider.cFQ();
        int min = Math.min(cFQ != null ? cFQ.size() : 0, i2);
        this.gZj = min > 0;
        if (min > 0) {
            this.gXW.add(this.gZi);
            this.gXY += min;
            Iterator it = j.mY(0, min).iterator();
            while (it.hasNext()) {
                int nextInt = ((ab) it).nextInt();
                this.gXW.add(new ai(new com.tencent.mm.emoji.b.p(cFQ.get(nextInt).key), true, nextInt + 1));
            }
        }
        this.gXW.add(this.gXV);
        com.tencent.mm.ce.e gxR = com.tencent.mm.ce.e.gxR();
        p.g(gxR, "MergerSmileyManager.getInstance()");
        List<SmileyPanelConfigInfo> gxS = gxR.gxS();
        this.gXY += gxS.size();
        p.g(gxS, "list");
        int i3 = 0;
        for (T t : gxS) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.a.j.hxH();
            }
            this.gXW.add(new ai(new com.tencent.mm.emoji.b.p(((SmileyPanelConfigInfo) t).field_key), false, i3 + 1));
            i3 = i4;
        }
        AppMethodBeat.o(199926);
    }

    @Override // com.tencent.mm.emoji.b.b.w
    public final int avo() {
        return this.gXY;
    }
}
