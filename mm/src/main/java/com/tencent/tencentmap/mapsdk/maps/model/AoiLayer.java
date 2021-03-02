package com.tencent.tencentmap.mapsdk.maps.model;

public interface AoiLayer extends IOverlay {

    public interface OnAoiLayerLoadListener {
        void onAoiLayerLoaded(boolean z, AoiLayer aoiLayer);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    String getId();

    LatLng location();

    String name();

    boolean remove();
}
