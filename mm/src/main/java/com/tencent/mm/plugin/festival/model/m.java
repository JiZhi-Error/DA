package com.tencent.mm.plugin.festival.model;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mm.vfs.o;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalLiveCanvasDataProviderContract;", "Lcom/tencent/mm/plugin/festival/model/IFestivalDataProviderContract;", "getLatestCanvasData", "Lcom/tencent/mm/vfs/VFSFile;", "registerDataUpdateListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/festival/model/FestivalLiveCanvasDataProviderContract$OnCanvasDataUpdateListener;", "unregisterDataUpdateListener", "OnCanvasDataUpdateListener", "plugin-festival_release"})
public interface m extends af {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalLiveCanvasDataProviderContract$OnCanvasDataUpdateListener;", "", "onCanvasDataUpdated", "", "vfsFile", "Lcom/tencent/mm/vfs/VFSFile;", "plugin-festival_release"})
    public interface a {
        void aq(o oVar);
    }
}
