package com.tencent.mm.plugin.finder.live.view.adapter;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB3\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nBA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "disableBiz", "", "canSendToBiz", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZ)V", "isMutliSelect", "selectType", "", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZZI)V", "dataCursor", "Landroid/database/Cursor;", "dataList", "", "createChatRoomDataItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;", "position", "contact", "Lcom/tencent/mm/storage/Contact;", "createDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "getCount", "resetData", "", "Companion", "plugin-finder_release"})
public final class n extends q {
    public static final a UON = new a((byte) 0);
    private final List<String> dataList;
    private Cursor jWh;

    static {
        AppMethodBeat.i(260936);
        AppMethodBeat.o(260936);
    }

    private n(MMBaseSelectContactUI mMBaseSelectContactUI) {
        super(mMBaseSelectContactUI, null, true, true);
        AppMethodBeat.i(260935);
        this.dataList = new ArrayList();
        Log.i("MicroMsg.FinderLiveMultiChatRoomAdapter", "create!");
        and();
        AppMethodBeat.o(260935);
    }

    public n(MMBaseSelectContactUI mMBaseSelectContactUI, byte b2) {
        this(mMBaseSelectContactUI);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        AppMethodBeat.i(260932);
        String str = this.dataList.get(i2);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as bjF = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().bjF(str);
        if (bjF == null) {
            com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
            bjF = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().bjK(str);
        }
        o oVar = new o(i2);
        oVar.ay(bjF);
        oVar.FK(eWh());
        o oVar2 = oVar;
        AppMethodBeat.o(260932);
        return oVar2;
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(260933);
        Log.i("MicroMsg.FinderLiveMultiChatRoomAdapter", "resetData");
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        this.jWh = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aST().b(ab.iCM, cfd(), com.tencent.mm.o.a.gNj, hYL(), "");
        clearCache();
        Cursor cursor = this.jWh;
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex(ch.COL_USERNAME));
                if (!this.dataList.contains(string)) {
                    this.dataList.add(string);
                }
            }
            AppMethodBeat.o(260933);
            return;
        }
        AppMethodBeat.o(260933);
    }

    public final int getCount() {
        AppMethodBeat.i(260934);
        int size = this.dataList.size();
        AppMethodBeat.o(260934);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomAdapter$Companion;", "", "()V", "RECENT_HEADER", "", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
