package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view;

import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager;
import java.util.Set;

public interface ClusterRenderer<T extends ClusterItem> {
    void cancel();

    void onAdd();

    void onClustersChanged(Set<? extends Cluster<T>> set);

    void onRemove();

    void setInfoWindowAdapter(ClusterManager.ClusterInfoWindowAdapter clusterInfoWindowAdapter);

    void setItemInfoWindowAdapter(ClusterManager.ClusterItemInfoWindowAdapter clusterItemInfoWindowAdapter);

    void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener);

    void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener);

    void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener);

    void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener);
}
