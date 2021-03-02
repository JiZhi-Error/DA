package com.tencent.mm.plugin.recordvideo.appcamera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/appcamera/AppBrandRecordVieDelegateFactory;", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$ImplFactory;", "()V", "createImpl", "Lcom/tencent/mm/plugin/mmsight/api/MMSightRecordView$MMSightRecordViewDelegate;", "plugin-recordvideo_release"})
public final class c implements MMSightRecordView.b {
    @Override // com.tencent.mm.plugin.mmsight.api.MMSightRecordView.b
    public final MMSightRecordView.e bqH() {
        AppMethodBeat.i(75112);
        d dVar = new d();
        AppMethodBeat.o(75112);
        return dVar;
    }
}
