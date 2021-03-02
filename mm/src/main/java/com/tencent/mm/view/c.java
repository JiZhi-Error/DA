package com.tencent.mm.view;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/view/DefaultViewActionCallback;", "Lcom/tencent/mm/view/IViewActionCallback;", "()V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "libmmui_release"})
public class c implements j {
    @Override // com.tencent.mm.view.j
    public void onChanged() {
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeChanged(int i2, int i3) {
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeChanged(int i2, int i3, Object obj) {
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeInserted(int i2, int i3) {
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeRemoved(int i2, int i3) {
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(204920);
        p.h(cVar, "reason");
        AppMethodBeat.o(204920);
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(204921);
        p.h(cVar, "reason");
        AppMethodBeat.o(204921);
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(204922);
        p.h(cVar, "reason");
        AppMethodBeat.o(204922);
    }
}
