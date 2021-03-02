package com.tencent.map.sdk.comps.offlinemap;

import com.tencent.map.tools.Callback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import java.util.List;

public interface OfflineMapComponent extends TencentMapComponent.Component {
    OfflineItemController getOfflineItemController(OfflineItem offlineItem, OfflineStatusChangedListener offlineStatusChangedListener);

    List<OfflineItem> getOfflineItemList();

    void getOfflineItemList(Callback<List<OfflineItem>> callback);

    boolean isOfflineMapEnable();

    void syncLatestData(OfflineMapSyncedListener offlineMapSyncedListener);
}
