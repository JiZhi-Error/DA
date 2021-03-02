package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.q;

public final class d extends q implements MStorageEx.IOnStorageChange {
    private int CuC;
    private Cursor jWh;
    private String ppO;

    public d(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, false);
        AppMethodBeat.i(34092);
        Log.i("MicroMsg.RecentConversationAdapter", "create!");
        this.ppO = str;
        and();
        AppMethodBeat.o(34092);
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(34093);
        Log.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        this.jWh = ag.bak().NB(this.ppO);
        this.CuC = 0;
        AppMethodBeat.o(34093);
    }

    public final int getCount() {
        AppMethodBeat.i(34094);
        int count = this.jWh.getCount() + 1;
        AppMethodBeat.o(34094);
        return count;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.mm.ui.contact.a.h */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.ui.contact.p
    public final a va(int i2) {
        AppMethodBeat.i(34095);
        a aVar = null;
        if (i2 == this.CuC) {
            h hVar = new h(i2);
            hVar.header = this.PWg.getActivity().getResources().getString(R.string.gi4);
            aVar = hVar;
        } else if (i2 <= this.CuC || !this.jWh.moveToPosition((i2 - this.CuC) - 1)) {
            Log.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i2));
        } else {
            a aVar2 = new a(i2);
            com.tencent.mm.al.a.a aVar3 = new com.tencent.mm.al.a.a();
            aVar3.convertFrom(this.jWh);
            int i3 = (aVar2.ppv > -1 ? 1 : (aVar2.ppv == -1 ? 0 : -1));
            aVar = aVar2;
            if (i3 == 0) {
                aVar2.ppv = aVar3.field_bizChatId;
                c bs = ag.baj().bs(aVar3.field_bizChatId);
                if (bs.isGroup()) {
                    aVar2.jVL = bs.field_chatName;
                    aVar2.hXq = bs.field_headImageUrl;
                    aVar2.username = bs.field_brandUserName;
                } else {
                    k fB = ag.bal().fB(bs.field_bizChatServId);
                    if (fB != null) {
                        aVar2.jVL = fB.field_userName;
                        aVar2.hXq = fB.field_headImageUrl;
                        aVar2.username = fB.field_brandUserName;
                    }
                }
                if (Util.isNullOrNil(aVar2.jVL)) {
                    aVar2.jVL = this.PWg.getActivity().getResources().getString(R.string.g7f);
                }
                boolean isNullOrNil = Util.isNullOrNil(aVar2.username);
                aVar = aVar2;
                if (isNullOrNil) {
                    aVar2.username = aVar3.field_brandUserName;
                    aVar = aVar2;
                }
            }
        }
        AppMethodBeat.o(34095);
        return aVar;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(34096);
        super.finish();
        Log.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        AppMethodBeat.o(34096);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(34097);
        and();
        notifyDataSetChanged();
        AppMethodBeat.o(34097);
    }
}
