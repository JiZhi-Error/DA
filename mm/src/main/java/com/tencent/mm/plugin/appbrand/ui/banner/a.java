package com.tencent.mm.plugin.appbrand.ui.banner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;

public final class a implements e {
    @Override // com.tencent.mm.plugin.appbrand.ui.banner.e
    public final BannerModel bXW() {
        AppMethodBeat.i(48980);
        BannerModel bXZ = b.bXZ();
        AppMethodBeat.o(48980);
        return bXZ;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.banner.e
    public final void a(f fVar) {
        AppMethodBeat.i(48981);
        AppBrandStickyBannerLogic.b.d(fVar);
        AppMethodBeat.o(48981);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.banner.e
    public final void b(f fVar) {
        AppMethodBeat.i(48982);
        AppBrandStickyBannerLogic.b.c(fVar);
        AppMethodBeat.o(48982);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.banner.e
    public final void bXX() {
        AppMethodBeat.i(48983);
        AppBrandStickyBannerLogic.b.bXX();
        AppMethodBeat.o(48983);
    }
}
