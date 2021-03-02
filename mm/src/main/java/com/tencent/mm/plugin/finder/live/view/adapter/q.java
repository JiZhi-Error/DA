package com.tencent.mm.plugin.finder.live.view.adapter;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "disableBiz", "", "canSendToBiz", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZ)V", "dataCursor", "Landroid/database/Cursor;", "dataList", "Ljava/util/ArrayList;", "createDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "getCount", "resetData", "", "Companion", "plugin-finder_release"})
public final class q extends com.tencent.mm.ui.contact.q {
    private static final String TAG = TAG;
    public static final a UOS = new a((byte) 0);
    private Cursor jWh;
    private final ArrayList<String> kgc = new ArrayList<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(MMBaseSelectContactUI mMBaseSelectContactUI) {
        super(mMBaseSelectContactUI, null, true, false);
        p.h(mMBaseSelectContactUI, "selectContactUI");
        AppMethodBeat.i(260947);
        and();
        AppMethodBeat.o(260947);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveRoomAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(260948);
        AppMethodBeat.o(260948);
    }

    public final int getCount() {
        AppMethodBeat.i(260944);
        int size = this.kgc.size();
        AppMethodBeat.o(260944);
        return size;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        AppMethodBeat.i(260945);
        String str = this.kgc.get(i2);
        p.g(str, "dataList[position]");
        String str2 = str;
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as bjF = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().bjF(str2);
        if (bjF == null) {
            com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af2, "MMKernel.service(IMessengerStorage::class.java)");
            bjF = ((com.tencent.mm.plugin.messenger.foundation.a.l) af2).aSN().bjK(str2);
        }
        o oVar = new o(i2);
        oVar.ay(bjF);
        oVar.FK(eWh());
        o oVar2 = oVar;
        AppMethodBeat.o(260945);
        return oVar2;
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(260946);
        Log.i(TAG, "resetData");
        if (this.jWh != null) {
            Cursor cursor = this.jWh;
            if (cursor != null) {
                cursor.close();
            }
            this.jWh = null;
        }
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        this.jWh = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aST().b(ab.iCM, cfd(), com.tencent.mm.o.a.gNj, hYL(), "");
        Cursor cursor2 = this.jWh;
        if (cursor2 != null) {
            while (cursor2.moveToNext()) {
                String string = cursor2.getString(cursor2.getColumnIndex(ch.COL_USERNAME));
                p.g(string, "it.getString(it.getColumnIndex(\"username\"))");
                if (!this.kgc.contains(string)) {
                    this.kgc.add(string);
                }
            }
            cursor2.close();
            AppMethodBeat.o(260946);
            return;
        }
        AppMethodBeat.o(260946);
    }
}
