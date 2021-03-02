package com.tencent.mm.plugin.finder.live.view.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.det;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020\u0012H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u0013\u0010%\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u0011\u0010'\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u0011\u0010)\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014R\u0013\u0010+\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\bR\u0013\u0010-\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowProductItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;)V", "appUsername", "", "getAppUsername", "()Ljava/lang/String;", "getData", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "extBuff", "getExtBuff", "extraData", "getExtraData", "imgUrl", "getImgUrl", "maxPrice", "", "getMaxPrice", "()I", "minPrice", "getMinPrice", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "getPlatformId", "platformName", "getPlatformName", "productId", "", "getProductId", "()J", "productPage", "Lcom/tencent/mm/protocal/protobuf/ProductPage;", "getProductPage", "()Lcom/tencent/mm/protocal/protobuf/ProductPage;", "promoting", "getPromoting", "shopExtraData", "getShopExtraData", "status", "getStatus", "stock", "getStock", "title", "getTitle", "userPurchasePage", "getUserPurchasePage", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "plugin-finder_release"})
public final class c implements bo {
    public final int AZq = this.UPJ.AZq;
    public final int AZr = this.UPJ.AZr;
    public final det LHI = this.UPJ.LHI;
    public final int LHJ = this.UPJ.LHJ;
    public final int LHK = this.UPJ.LHK;
    private final String LHL = this.UPJ.LHL;
    public final String LHM = this.UPJ.LHM;
    public final det LHN = this.UPJ.LHN;
    public final int LHO = this.UPJ.LHO;
    public final axg UPJ;
    private final String dCu = this.UPJ.dCu;
    private final String dSJ = this.UPJ.dSJ;
    private final int status = this.UPJ.status;
    public final String title = this.UPJ.title;
    public final String twt = this.UPJ.twt;
    public final long uko = this.UPJ.uko;
    private final String ukr = this.UPJ.ukr;

    public c(axg axg) {
        p.h(axg, "data");
        AppMethodBeat.i(261036);
        this.UPJ = axg;
        AppMethodBeat.o(261036);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.UPJ.uko;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(261034);
        int hashCode = c.class.hashCode();
        AppMethodBeat.o(261034);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(261035);
        p.h(iVar, "obj");
        AppMethodBeat.o(261035);
        return 0;
    }
}
