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

public final class ae extends q {
    private String PSf;
    private Cursor jWh;

    public ae(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, new ArrayList(), false, false);
        AppMethodBeat.i(102929);
        this.PSf = str;
        anp();
        AppMethodBeat.o(102929);
    }

    private void anp() {
        AppMethodBeat.i(219809);
        g.aAi();
        this.jWh = ((l) g.af(l.class)).aSN().e(this.PSf, "", this.gzY);
        AppMethodBeat.o(219809);
    }

    @Override // com.tencent.mm.ui.contact.q
    public final void and() {
        AppMethodBeat.i(219810);
        super.and();
        anp();
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(219810);
    }

    public final int getCount() {
        AppMethodBeat.i(102930);
        int count = this.jWh.getCount();
        AppMethodBeat.o(102930);
        return count;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.contact.p
    public final a va(int i2) {
        AppMethodBeat.i(102931);
        e eVar = null;
        if (i2 < 0 || !this.jWh.moveToPosition(i2)) {
            Log.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i2));
        } else {
            eVar = new e(i2);
            as asVar = new as();
            asVar.convertFrom(this.jWh);
            eVar.contact = asVar;
            eVar.PWh = eWh();
        }
        AppMethodBeat.o(102931);
        return eVar;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final void finish() {
        AppMethodBeat.i(102932);
        super.finish();
        Log.i("MicroMsg.SpecialContactAdapter", "finish!");
        if (this.jWh != null) {
            this.jWh.close();
            this.jWh = null;
        }
        AppMethodBeat.o(102932);
    }
}
