package com.d.a.a.a.a;

import com.tencent.mapsdk.raster.model.CustomLayer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements CustomLayer {
    private com.tencent.tencentmap.mapsdk.maps.model.CustomLayer SJK;

    public c(com.tencent.tencentmap.mapsdk.maps.model.CustomLayer customLayer) {
        this.SJK = customLayer;
    }

    @Override // com.tencent.mapsdk.raster.model.CustomLayer
    public final void reload() {
        AppMethodBeat.i(217295);
        if (this.SJK == null) {
            AppMethodBeat.o(217295);
            return;
        }
        this.SJK.reload();
        AppMethodBeat.o(217295);
    }

    @Override // com.tencent.mapsdk.raster.model.CustomLayer
    public final void remove() {
        AppMethodBeat.i(217296);
        if (this.SJK == null) {
            AppMethodBeat.o(217296);
            return;
        }
        this.SJK.remove();
        AppMethodBeat.o(217296);
    }

    @Override // com.tencent.mapsdk.raster.model.CustomLayer
    public final void clearDiskCache() {
        AppMethodBeat.i(217297);
        if (this.SJK == null) {
            AppMethodBeat.o(217297);
            return;
        }
        this.SJK.clearDiskCache();
        AppMethodBeat.o(217297);
    }

    @Override // com.tencent.mapsdk.raster.model.CustomLayer
    public final String getId() {
        AppMethodBeat.i(217298);
        if (this.SJK == null) {
            AppMethodBeat.o(217298);
            return null;
        }
        String id = this.SJK.getId();
        AppMethodBeat.o(217298);
        return id;
    }
}
