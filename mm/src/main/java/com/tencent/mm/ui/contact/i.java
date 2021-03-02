package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;
import java.util.List;

public final class i extends q {
    private List<String> PVr;
    private Cursor jWh = ((l) g.af(l.class)).aSN().iL(this.PVr);

    public i(MMBaseSelectContactUI mMBaseSelectContactUI, boolean z, List<String> list) {
        super(mMBaseSelectContactUI, new ArrayList(), true, z);
        AppMethodBeat.i(102840);
        this.PVr = list;
        g.aAi();
        AppMethodBeat.o(102840);
    }

    public final int getCount() {
        AppMethodBeat.i(102841);
        int count = this.jWh.getCount();
        AppMethodBeat.o(102841);
        return count;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public final a va(int i2) {
        AppMethodBeat.i(102842);
        e eVar = null;
        if (i2 < 0 || !this.jWh.moveToPosition(i2)) {
            Log.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i2));
        } else {
            eVar = new e(i2);
            as asVar = new as();
            asVar.convertFrom(this.jWh);
            eVar.contact = asVar;
            eVar.PWh = eWh();
        }
        AppMethodBeat.o(102842);
        return eVar;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(102843);
        super.finish();
        Log.i("MicroMsg.CustomContactAdapter", "finish!");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        AppMethodBeat.o(102843);
    }
}
