package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.s;

public final class b extends s {
    public View.OnClickListener ESo = null;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI) {
        super(mMBaseSelectContactUI, null, true, 0);
    }

    @Override // com.tencent.mm.ui.contact.s
    public final a aab(int i2) {
        AppMethodBeat.i(99812);
        com.tencent.mm.plugin.sns.ui.a.a.a aVar = new com.tencent.mm.plugin.sns.ui.a.a.a(i2);
        aVar.query = this.query;
        aVar.ESo = this.ESo;
        aVar.lqW = (m) this.wZw.get((i2 - this.PTz) - 1);
        aVar.PWh = eWh();
        AppMethodBeat.o(99812);
        return aVar;
    }
}
