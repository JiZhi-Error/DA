package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.protocal.protobuf.bdb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001a\u0010)\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001f¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;)V", "getCard", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamTxtCard;", "setCard", "cardId", "", "getCardId", "()J", "setCardId", "(J)V", "endAction", "", "getEndAction", "()I", "setEndAction", "(I)V", "endActionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;", "getEndActionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;", "setEndActionInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCardActionInfo;)V", "endWording", "", "getEndWording", "()Ljava/lang/String;", "setEndWording", "(Ljava/lang/String;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "position", "getPosition", "setPosition", "streamCardTitle", "getStreamCardTitle", "setStreamCardTitle", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class ah implements bo {
    public int position = -1;
    public bcv tQS;
    public int tQT;
    public String tQU = "";
    public String tQV = "";
    public long tQW;
    public bdb tQX;

    public ah(bdb bdb) {
        p.h(bdb, "card");
        AppMethodBeat.i(244175);
        this.tQX = bdb;
        AppMethodBeat.o(244175);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(244173);
        long hashCode = (long) ("FinderStreamCardTxtFeed#" + this.tQX.LMP).hashCode();
        AppMethodBeat.o(244173);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 2014;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(244174);
        p.h(iVar, "obj");
        if ((iVar instanceof bcu) && ((bcu) iVar).uOx == this.tQX.LMP && ((bcu) iVar).tQR == this.tQX.style) {
            AppMethodBeat.o(244174);
            return 0;
        }
        AppMethodBeat.o(244174);
        return -1;
    }
}
