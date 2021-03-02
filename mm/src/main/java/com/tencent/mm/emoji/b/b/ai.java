package com.tencent.mm.emoji.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/SmileyItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "smileyInfo", "Lcom/tencent/mm/emoji/model/SmileyInfo;", "isRecent", "", "reportPos", "", "(Lcom/tencent/mm/emoji/model/SmileyInfo;ZI)V", "()Z", "getReportPos", "()I", "getSmileyInfo", "()Lcom/tencent/mm/emoji/model/SmileyInfo;", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "plugin-emojisdk_release"})
public final class ai extends ac {
    public final p gZf;
    public final boolean gZg;
    public final int gZh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ai(p pVar, boolean z, int i2) {
        super(1);
        kotlin.g.b.p.h(pVar, "smileyInfo");
        AppMethodBeat.i(105582);
        this.gZf = pVar;
        this.gZg = z;
        this.gZh = i2;
        AppMethodBeat.o(105582);
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean equals(Object obj) {
        AppMethodBeat.i(105581);
        if (!super.equals(obj) || !(obj instanceof ai) || ((ai) obj).gZg != this.gZg || !kotlin.g.b.p.j(((ai) obj).gZf.key, this.gZf.key)) {
            AppMethodBeat.o(105581);
            return false;
        }
        AppMethodBeat.o(105581);
        return true;
    }
}
