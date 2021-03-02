package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

public class TextureMapView extends MapView {
    public TextureMapView(Context context) {
        this(context, (TencentMapOptions) null);
    }

    public TextureMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, TencentMapOptions tencentMapOptions) {
        this(context, attributeSet, 0, tencentMapOptions);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i2, TencentMapOptions tencentMapOptions) {
        super(context, attributeSet, i2, tencentMapOptions);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public final MapViewType getViewType() {
        return MapViewType.TextureView;
    }
}
