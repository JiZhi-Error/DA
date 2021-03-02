package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public interface TencentMapComponent {

    public interface Component {
    }

    IAlphaAnimation createAlphaAnimation(float f2, float f3);

    IAnimationSet createAnimationSet(boolean z);

    IEmergeAnimation createEmergeAnimation(LatLng latLng);

    HeatMapTileProvider createHeatMapTileProvider(HeatMapTileProvider.Builder builder);

    IRotateAnimation createRotateAnimation(float f2, float f3, float f4, float f5, float f6);

    IScaleAnimation createScaleAnimation(float f2, float f3, float f4, float f5);

    ITranslateAnimation createTranslateAnimation(LatLng latLng);

    <T extends Component> T getMapComponent(Class<T> cls);

    TencentMapServiceProtocol getMapServiceProtocol();
}
