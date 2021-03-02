package com.tencent.mm.plugin.aa.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f extends s {
    private ArrayList<String> jVT;
    private String[] jWg;
    private Cursor jWh;
    private String query;

    public f(MMBaseSelectContactUI mMBaseSelectContactUI, ArrayList<String> arrayList) {
        super(mMBaseSelectContactUI, null, true, 0);
        AppMethodBeat.i(63557);
        this.jVT = arrayList;
        if (this.jVT != null) {
            this.jWg = Util.listToStrings(this.jVT);
        }
        AppMethodBeat.o(63557);
    }

    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.o
    public final void b(String str, int[] iArr) {
        AppMethodBeat.i(63558);
        Log.i("MicroMsg.AASelectSearchContactItem", "doSearch: %s", str);
        clearCache();
        this.query = str;
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        if (!Util.isNullOrNil(this.query) && this.jWg != null) {
            g.aAi();
            this.jWh = ((l) g.af(l.class)).aSN().a(this.jWg, "@all.chatroom", this.query, new LinkedList(), null);
        }
        notifyDataSetChanged();
        ds(str, true);
        AppMethodBeat.o(63558);
    }

    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
    public final a va(int i2) {
        AppMethodBeat.i(63559);
        e eVar = null;
        if (this.jWh.moveToPosition(i2)) {
            as asVar = new as();
            asVar.convertFrom(this.jWh);
            eVar = new e(i2);
            eVar.contact = asVar;
            eVar.PWh = true;
        }
        AppMethodBeat.o(63559);
        return eVar;
    }

    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(63560);
        super.finish();
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        AppMethodBeat.o(63560);
    }

    @Override // com.tencent.mm.ui.contact.s
    public final int getCount() {
        AppMethodBeat.i(63561);
        if (this.jWh == null) {
            AppMethodBeat.o(63561);
            return 0;
        }
        int count = this.jWh.getCount();
        AppMethodBeat.o(63561);
        return count;
    }
}
