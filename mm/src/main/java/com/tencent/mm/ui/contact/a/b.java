package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.a;

public final class b extends f {
    private boolean Qaf;
    public String nickName;
    public int resId = 0;

    public b(int i2) {
        super(i2);
    }

    @Override // com.tencent.mm.ui.contact.a.f, com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        AppMethodBeat.i(102933);
        if (this.resId == 0 || this.nickName == null) {
            as asVar = this.contact;
            if (!this.Qaf) {
                g.aAi();
                asVar = ((l) g.af(l.class)).aSN().Kn(this.username);
                this.contact = asVar;
                this.Qaf = true;
            }
            if (asVar == null) {
                this.jVL = "";
                AppMethodBeat.o(102933);
                return;
            }
            this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(asVar), com.tencent.mm.cb.a.aG(context, R.dimen.is));
            this.username = asVar.field_username;
            AppMethodBeat.o(102933);
            return;
        }
        this.Qay = this.resId;
        this.Qax = this.nickName;
        AppMethodBeat.o(102933);
    }
}
