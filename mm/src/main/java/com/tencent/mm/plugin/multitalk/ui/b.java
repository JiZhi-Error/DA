package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;
import java.util.List;

public final class b extends s {
    private String chatroomName;
    private Cursor jWh;
    private String[] jWi;
    private String query;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        AppMethodBeat.i(114711);
        this.chatroomName = str;
        List<String> Kh = ((c) g.af(c.class)).aSX().Kh(this.chatroomName);
        if (Kh != null) {
            this.jWi = Util.listToStrings(Kh);
        }
        AppMethodBeat.o(114711);
    }

    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.o
    public final void b(String str, int[] iArr) {
        AppMethodBeat.i(114712);
        Log.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", str);
        clearCache();
        this.query = str;
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        if (!Util.isNullOrNil(this.query) && this.jWi != null) {
            this.jWh = ((l) g.af(l.class)).aSN().a(this.jWi, "@all.chatroom", this.query, new LinkedList(), null);
        }
        notifyDataSetChanged();
        ds(str, true);
        AppMethodBeat.o(114712);
    }

    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
    public final a va(int i2) {
        AppMethodBeat.i(114713);
        e eVar = null;
        if (this.jWh.moveToPosition(i2)) {
            as asVar = new as();
            asVar.convertFrom(this.jWh);
            eVar = new e(i2);
            eVar.contact = asVar;
            eVar.PWh = eWh();
            eVar.query = this.query;
        }
        AppMethodBeat.o(114713);
        return eVar;
    }

    @Override // com.tencent.mm.ui.contact.s, com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(114714);
        super.finish();
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        AppMethodBeat.o(114714);
    }

    @Override // com.tencent.mm.ui.contact.s
    public final int getCount() {
        AppMethodBeat.i(114715);
        if (this.jWh == null) {
            AppMethodBeat.o(114715);
            return 0;
        }
        int count = this.jWh.getCount();
        AppMethodBeat.o(114715);
        return count;
    }
}
