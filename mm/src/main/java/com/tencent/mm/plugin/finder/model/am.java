package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderLiveWeCoinData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "amountCnt", "", "giftCnt", "", "wecoinHotInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "(IJLcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;)V", "getAmountCnt", "()I", "setAmountCnt", "(I)V", "getGiftCnt", "()J", "setGiftCnt", "(J)V", "getWecoinHotInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class am implements bo {
    public long USw;
    public final axa uOA;
    public int uOz;

    public am(int i2, long j2, axa axa) {
        p.h(axa, "wecoinHotInfo");
        AppMethodBeat.i(261250);
        this.uOz = i2;
        this.USw = j2;
        this.uOA = axa;
        AppMethodBeat.o(261250);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248776);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(248776);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248777);
        int hashCode = am.class.hashCode();
        AppMethodBeat.o(248777);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        FinderContact finderContact;
        String str = null;
        AppMethodBeat.i(248778);
        p.h(iVar, "obj");
        if (!(iVar instanceof axs)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        axs axs = (axs) iVar2;
        if (axs != null) {
            String str2 = axs.username;
            avn avn = this.uOA.uBm;
            if (!(avn == null || (finderContact = avn.contact) == null)) {
                str = finderContact.username;
            }
            if (Util.isEqual(str2, str)) {
                AppMethodBeat.o(248778);
                return 0;
            }
            AppMethodBeat.o(248778);
            return -1;
        }
        AppMethodBeat.o(248778);
        return -1;
    }
}
