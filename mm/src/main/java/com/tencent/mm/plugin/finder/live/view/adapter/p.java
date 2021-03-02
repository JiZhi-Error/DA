package com.tencent.mm.plugin.finder.live.view.adapter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.s;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomSearchAdapter;", "Lcom/tencent/mm/ui/contact/MMSearchContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "isMultiSelect", "", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;Z)V", "createChatroomDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "plugin-finder_release"})
public final class p extends s {
    public p(MMBaseSelectContactUI mMBaseSelectContactUI) {
        super(mMBaseSelectContactUI, null, true, 0);
    }

    @Override // com.tencent.mm.ui.contact.s
    public final a aab(int i2) {
        AppMethodBeat.i(260943);
        o oVar = new o(i2);
        oVar.byI(this.query);
        oVar.lqW = (m) this.wZw.get((i2 - this.PTz) - 1);
        oVar.FK(eWh());
        o oVar2 = oVar;
        AppMethodBeat.o(260943);
        return oVar2;
    }
}
