package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;

public interface Algorithm<T extends ClusterItem> {
    void addItem(T t);

    void addItems(Collection<T> collection);

    void clearItems();

    Set<? extends Cluster<T>> getClusters(double d2);

    Collection<T> getItems();

    void removeItem(T t);
}
