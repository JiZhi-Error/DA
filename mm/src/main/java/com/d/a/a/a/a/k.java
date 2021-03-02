package com.d.a.a.a.a;

import com.tencent.mapsdk.raster.model.TileOverlay;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k implements TileOverlay {
    private com.tencent.tencentmap.mapsdk.maps.model.TileOverlay SKs;

    public k(com.tencent.tencentmap.mapsdk.maps.model.TileOverlay tileOverlay) {
        this.SKs = tileOverlay;
    }

    @Override // com.tencent.mapsdk.raster.model.TileOverlay
    public final void reload() {
        AppMethodBeat.i(217531);
        if (this.SKs == null) {
            AppMethodBeat.o(217531);
            return;
        }
        this.SKs.reload();
        AppMethodBeat.o(217531);
    }

    @Override // com.tencent.mapsdk.raster.model.TileOverlay
    public final void remove() {
        AppMethodBeat.i(217532);
        if (this.SKs == null) {
            AppMethodBeat.o(217532);
            return;
        }
        this.SKs.remove();
        AppMethodBeat.o(217532);
    }

    @Override // com.tencent.mapsdk.raster.model.TileOverlay
    public final void setDiskCacheDir(String str) {
        AppMethodBeat.i(217533);
        if (this.SKs == null) {
            AppMethodBeat.o(217533);
            return;
        }
        this.SKs.setDiskCacheDir(str);
        AppMethodBeat.o(217533);
    }

    @Override // com.tencent.mapsdk.raster.model.TileOverlay
    public final void setZindex(int i2) {
        AppMethodBeat.i(217534);
        if (this.SKs == null) {
            AppMethodBeat.o(217534);
            return;
        }
        this.SKs.setZindex(i2);
        AppMethodBeat.o(217534);
    }

    @Override // com.tencent.mapsdk.raster.model.TileOverlay
    public final void clearTileCache() {
        AppMethodBeat.i(217535);
        if (this.SKs == null) {
            AppMethodBeat.o(217535);
            return;
        }
        this.SKs.clearTileCache();
        AppMethodBeat.o(217535);
    }

    @Override // com.tencent.mapsdk.raster.model.TileOverlay
    public final String getId() {
        AppMethodBeat.i(217536);
        if (this.SKs == null) {
            AppMethodBeat.o(217536);
            return null;
        }
        String id = this.SKs.getId();
        AppMethodBeat.o(217536);
        return id;
    }
}
