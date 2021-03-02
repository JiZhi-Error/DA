package com.tencent.mm.view;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\"\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0016\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0016J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/view/BaseViewActionCallback;", "Lcom/tencent/mm/view/IViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getHeaderCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "updateState", "libmmui_release"})
public class b implements j {
    private final RefreshLoadMoreLayout tLS;

    public b(RefreshLoadMoreLayout refreshLoadMoreLayout) {
        p.h(refreshLoadMoreLayout, "rlLayout");
        AppMethodBeat.i(204919);
        this.tLS = refreshLoadMoreLayout;
        AppMethodBeat.o(204919);
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(204911);
        p.h(cVar, "reason");
        this.tLS.onPreFinishLoadMoreSmooth(cVar);
        dmp();
        AppMethodBeat.o(204911);
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(204912);
        p.h(cVar, "reason");
        this.tLS.onPreFinishRefresh(cVar);
        dmp();
        AppMethodBeat.o(204912);
    }

    @Override // com.tencent.mm.view.i
    public void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(204913);
        p.h(cVar, "reason");
        this.tLS.onPreFinishLoadMore(cVar);
        dmp();
        AppMethodBeat.o(204913);
    }

    @Override // com.tencent.mm.view.j
    public void onChanged() {
        AppMethodBeat.i(204914);
        this.tLS.onChanged();
        dmp();
        AppMethodBeat.o(204914);
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeChanged(int i2, int i3) {
        AppMethodBeat.i(204915);
        this.tLS.onItemRangeChanged(getHeaderCount() + i2, i3);
        dmp();
        AppMethodBeat.o(204915);
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeChanged(int i2, int i3, Object obj) {
        AppMethodBeat.i(204916);
        this.tLS.onItemRangeChanged(getHeaderCount() + i2, i3, obj);
        dmp();
        AppMethodBeat.o(204916);
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeInserted(int i2, int i3) {
        AppMethodBeat.i(204917);
        this.tLS.onItemRangeInserted(getHeaderCount() + i2, i3);
        dmp();
        AppMethodBeat.o(204917);
    }

    @Override // com.tencent.mm.view.j
    public void onItemRangeRemoved(int i2, int i3) {
        AppMethodBeat.i(204918);
        this.tLS.onItemRangeRemoved(getHeaderCount() + i2, i3);
        dmp();
        AppMethodBeat.o(204918);
    }

    public void dmp() {
    }

    public int getHeaderCount() {
        return 0;
    }
}
