package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.k;
import com.tencent.mm.api.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import java.util.List;

public final class r extends s {
    private List<String> PWD = null;
    private o.a PWf;
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private Cursor jWh;
    private String ppO;
    private String query;

    public r(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, 0);
        AppMethodBeat.i(102864);
        this.ppO = str;
        Log.i("MicroMsg.MMSearchContactAdapter", "Create!");
        amZ();
        AppMethodBeat.o(102864);
    }

    @Override // com.tencent.mm.ui.contact.o
    public final void a(o.a aVar) {
        this.PWf = aVar;
    }

    @Override // com.tencent.mm.ui.contact.s
    public final void ds(String str, boolean z) {
        AppMethodBeat.i(102865);
        if (this.PWf != null) {
            this.PWf.B(str, getCount(), z);
        }
        AppMethodBeat.o(102865);
    }

    private void amZ() {
        AppMethodBeat.i(102866);
        Log.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.query = null;
        clearCache();
        AppMethodBeat.o(102866);
    }

    @Override // com.tencent.mm.ui.contact.s
    public final int getCount() {
        AppMethodBeat.i(102867);
        if (this.jWh == null) {
            AppMethodBeat.o(102867);
            return 0;
        }
        int count = this.jWh.getCount();
        AppMethodBeat.o(102867);
        return count;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
    public final a va(int i2) {
        AppMethodBeat.i(102868);
        com.tencent.mm.ui.bizchat.a aVar = null;
        if (i2 < 0 || !this.jWh.moveToPosition(i2)) {
            Log.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i2));
        } else {
            com.tencent.mm.ui.bizchat.a aVar2 = new com.tencent.mm.ui.bizchat.a(i2);
            c cVar = new c();
            cVar.convertFrom(this.jWh);
            if (aVar2.ppv == -1) {
                aVar2.ppv = cVar.field_bizChatLocalId;
                if (cVar.isGroup()) {
                    aVar2.jVL = cVar.field_chatName;
                    aVar2.hXq = cVar.field_headImageUrl;
                    aVar2.username = cVar.field_brandUserName;
                } else {
                    k fB = ((l) g.af(l.class)).fB(cVar.field_bizChatServId);
                    if (fB != null) {
                        aVar2.jVL = fB.field_userName;
                        aVar2.hXq = fB.field_headImageUrl;
                        aVar2.username = fB.field_brandUserName;
                    }
                }
                if (Util.isNullOrNil(aVar2.jVL)) {
                    aVar2.jVL = this.PWg.getActivity().getResources().getString(R.string.gi1);
                }
                if (Util.isNullOrNil(aVar2.username)) {
                    aVar2.username = cVar.field_brandUserName;
                }
            }
            aVar = aVar2;
        }
        AppMethodBeat.o(102868);
        return aVar;
    }

    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(102869);
        super.finish();
        Log.i("MicroMsg.MMSearchContactAdapter", "finish!");
        amZ();
        AppMethodBeat.o(102869);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
    public final boolean c(a aVar) {
        return true;
    }
}
