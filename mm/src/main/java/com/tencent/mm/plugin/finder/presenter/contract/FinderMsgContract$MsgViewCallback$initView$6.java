package com.tencent.mm.plugin.finder.presenter.contract;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.plugin.finder.view.animation.e;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
public final class FinderMsgContract$MsgViewCallback$initView$6 extends RefreshLoadMoreLayout.a {
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYD;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderMsgContract$MsgViewCallback$initView$6(FinderMsgContract.MsgViewCallback msgViewCallback) {
        this.uYD = msgViewCallback;
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void ED(int i2) {
        AppMethodBeat.i(249894);
        b bVar = new b();
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
        super.ED(i2);
        FinderMsgContract.MsgPresenter b2 = FinderMsgContract.MsgViewCallback.b(this.uYD);
        g.azz().b(new bo(b2.scene, b2.tvu));
        FinderMsgContract finderMsgContract = FinderMsgContract.uYn;
        FinderMsgContract.ET(SystemClock.uptimeMillis());
        FinderMsgContract.MsgViewCallback.g(this.uYD).setItemAnimator(new e());
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(249894);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249895);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.onRefreshEnd(cVar);
        RefreshLoadMoreLayout.b(FinderMsgContract.MsgViewCallback.h(this.uYD));
        FinderMsgContract.MsgViewCallback.g(this.uYD).postDelayed(new FinderMsgContract$MsgViewCallback$initView$6$onRefreshEnd$1(this), 1000);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249895);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void cxo() {
        AppMethodBeat.i(249896);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        super.cxo();
        FinderMsgContract.MsgPresenter b2 = FinderMsgContract.MsgViewCallback.b(this.uYD);
        long j2 = ((com.tencent.mm.plugin.finder.model.a) j.ku(FinderMsgContract.MsgViewCallback.b(this.uYD).kgc)).uNF.field_id;
        FinderMsgContract finderMsgContract = FinderMsgContract.uYn;
        b2.a(j2, FinderMsgContract.dlX(), true, false);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(249896);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249897);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.a(cVar);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$initView$6", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249897);
    }
}
