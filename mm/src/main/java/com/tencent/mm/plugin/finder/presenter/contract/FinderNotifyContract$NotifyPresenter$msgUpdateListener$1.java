package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.sdk.event.IListener;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter$msgUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderMentionUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
public final class FinderNotifyContract$NotifyPresenter$msgUpdateListener$1 extends IListener<hz> {
    final /* synthetic */ FinderNotifyContract.NotifyPresenter uYS;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderNotifyContract$NotifyPresenter$msgUpdateListener$1(FinderNotifyContract.NotifyPresenter notifyPresenter) {
        this.uYS = notifyPresenter;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(hz hzVar) {
        hz.a aVar;
        AppMethodBeat.i(249910);
        hz hzVar2 = hzVar;
        if (hzVar2 == null || (aVar = hzVar2.dMB) == null) {
            AppMethodBeat.o(249910);
        } else {
            d.h(new FinderNotifyContract$NotifyPresenter$msgUpdateListener$1$callback$1(this, aVar.id));
            AppMethodBeat.o(249910);
        }
        return false;
    }
}
