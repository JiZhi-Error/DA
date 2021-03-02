package com.tencent.mm.plugin.finder.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.protocal.protobuf.fhd;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u001aH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowAdItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;)V", "ad_id", "", "getAd_id", "()J", "ad_page", "Lcom/tencent/mm/protocal/protobuf/AdPage;", "getAd_page", "()Lcom/tencent/mm/protocal/protobuf/AdPage;", "button_text", "", "getButton_text", "()Ljava/lang/String;", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "desc", "getDesc", "img_url", "getImg_url", "platform_name", "getPlatform_name", "promoting", "", "getPromoting", "()I", "title", "getTitle", "uxinfo", "getUxinfo", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class b implements bo {
    public final String KRv = this.UPI.KRv;
    public final int LHK = this.UPI.LHK;
    public final long UPE = this.UPI.UPE;
    public final ffq UPF = this.UPI.UPF;
    public final String UPG = this.UPI.UPG;
    public final String UPH = this.UPI.UPH;
    public final fhd UPI;
    public final String desc = this.UPI.desc;
    public final String gTk = this.UPI.gTk;
    public final String title = this.UPI.title;

    public b(fhd fhd) {
        p.h(fhd, "data");
        AppMethodBeat.i(261033);
        this.UPI = fhd;
        AppMethodBeat.o(261033);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.UPI.UPE;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(261031);
        int hashCode = b.class.hashCode();
        AppMethodBeat.o(261031);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(261032);
        p.h(iVar, "obj");
        AppMethodBeat.o(261032);
        return 0;
    }
}
