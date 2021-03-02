package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.Collection;

public interface Cluster<T extends ClusterItem> {
    Collection<T> getItems();

    LatLng getPosition();

    int getSize();
}
