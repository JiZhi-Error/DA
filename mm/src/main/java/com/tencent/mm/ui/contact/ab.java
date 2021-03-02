package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.o.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.util.List;

public final class ab extends q implements MStorageEx.IOnStorageChange {
    private int CuC;
    private List<String> PYs;
    private int PYt;
    private boolean PYu;
    private int PYv;
    private Cursor jWh;

    public ab(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list) {
        this(mMBaseSelectContactUI, list, true, false, false, 0);
    }

    public ab(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, boolean z3, int i2) {
        super(mMBaseSelectContactUI, list, z, z2);
        AppMethodBeat.i(102921);
        this.PYv = 0;
        Log.i("MicroMsg.RecentConversationAdapter", "create!");
        this.PYu = z3;
        this.PYv = i2;
        and();
        ((l) g.af(l.class)).aST().add(this);
        AppMethodBeat.o(102921);
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(102922);
        Log.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        if (u.hasAttr(this.PYv, 4)) {
            this.jWh = ((l) g.af(l.class)).aST().b(com.tencent.mm.model.ab.iCK, this.gzY, a.gNj, this.PWC, "");
        } else if (u.hasAttr(this.PYv, 16)) {
            this.jWh = ((l) g.af(l.class)).aST().b(com.tencent.mm.model.ab.iCM, this.gzY, a.gNj, this.PWC, "");
        } else {
            this.jWh = ((l) g.af(l.class)).aST().b(com.tencent.mm.model.ab.iCF, this.gzY, a.gNj, this.PWC, "");
        }
        if (this.PYu) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (this.PYs != null) {
            i3 = this.PYs.size();
        }
        this.PYt = i3;
        this.CuC = i2 + this.PYt;
        clearCache();
        AppMethodBeat.o(102922);
    }

    public final int getCount() {
        AppMethodBeat.i(102923);
        int i2 = this.CuC + 1;
        if (this.jWh != null) {
            i2 += this.jWh.getCount();
        }
        AppMethodBeat.o(102923);
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v9, resolved type: com.tencent.mm.ui.contact.a.h */
    /* JADX DEBUG: Multi-variable search result rejected for r0v30, resolved type: com.tencent.mm.ui.contact.a.h */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002d  */
    @Override // com.tencent.mm.ui.contact.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ui.contact.a.a va(int r8) {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.ab.va(int):com.tencent.mm.ui.contact.a.a");
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(102925);
        super.finish();
        Log.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        ((l) g.af(l.class)).aST().remove(this);
        AppMethodBeat.o(102925);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(102926);
        and();
        notifyDataSetChanged();
        AppMethodBeat.o(102926);
    }
}
