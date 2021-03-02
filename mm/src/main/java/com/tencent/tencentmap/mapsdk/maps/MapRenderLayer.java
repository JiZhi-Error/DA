package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

public class MapRenderLayer extends MapView {
    public MapRenderLayer(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        AppMethodBeat.i(181003);
        onResume();
        AppMethodBeat.o(181003);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.MapView
    public final void onSurfaceChanged(Object obj, int i2, int i3) {
        AppMethodBeat.i(181004);
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture) || (obj instanceof SurfaceHolder)) {
            super.onSurfaceChanged(obj, i2, i3);
            AppMethodBeat.o(181004);
            return;
        }
        AppMethodBeat.o(181004);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public final MapViewType getViewType() {
        return MapViewType.RenderLayer;
    }
}
