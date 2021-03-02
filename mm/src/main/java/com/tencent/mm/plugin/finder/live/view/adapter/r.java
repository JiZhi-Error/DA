package com.tencent.mm.plugin.finder.live.view.adapter;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveSearchRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMSearchContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "isMultiSelect", "", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;Z)V", "createChatroomDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "createHeaderPosition", "resource", "plugin-finder_release"})
public final class r extends s {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(MMBaseSelectContactUI mMBaseSelectContactUI) {
        super(mMBaseSelectContactUI, null, true, 0);
        p.h(mMBaseSelectContactUI, "selectContactUI");
        AppMethodBeat.i(260951);
        AppMethodBeat.o(260951);
    }

    @Override // com.tencent.mm.ui.contact.s
    public final a aab(int i2) {
        AppMethodBeat.i(260949);
        o oVar = new o(i2);
        oVar.byI(this.query);
        oVar.lqW = (m) this.wZw.get((i2 - this.PTz) - 1);
        oVar.FK(eWh());
        o oVar2 = oVar;
        AppMethodBeat.o(260949);
        return oVar2;
    }

    @Override // com.tencent.mm.ui.contact.s
    public final a lk(int i2, int i3) {
        AppMethodBeat.i(260950);
        k kVar = new k(i3);
        n hYG = hYG();
        p.g(hYG, "selectContactUI");
        Activity activity = hYG.getActivity();
        p.g(activity, "selectContactUI.activity");
        kVar.header = activity.getResources().getString(i2);
        k kVar2 = kVar;
        AppMethodBeat.o(260950);
        return kVar2;
    }
}
