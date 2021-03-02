package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.f;

public final class d extends f {
    public CharSequence Qaj;
    public boolean Qak;
    private a Qal = new a();
    public as contact;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(int i2, as asVar) {
        super(i2);
        boolean z = true;
        AppMethodBeat.i(102941);
        this.contact = asVar;
        this.Qak = asVar.fuA != 1 ? false : z;
        AppMethodBeat.o(102941);
    }

    @Override // com.tencent.mm.ui.contact.a.f, com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        boolean z = true;
        AppMethodBeat.i(102942);
        super.a(context, aVar);
        if (this.contact.fuA != 1) {
            z = false;
        }
        this.Qak = z;
        this.Qaj = ((c) g.af(c.class)).aSX().Ke(super.contact.field_username).getDisplayName(this.contact.field_username);
        AppMethodBeat.o(102942);
    }

    class a extends f.b {
        a() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b, com.tencent.mm.ui.contact.a.f.b
        public final void a(Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102940);
            super.a(context, aVar, aVar2, z, z2);
            f.a aVar3 = (f.a) aVar;
            if (!Util.isNullOrNil(d.this.Qaj)) {
                aVar3.jBR.setVisibility(0);
                d.this.Qaj = l.e(context, d.this.Qaj, com.tencent.mm.cb.a.aG(context, R.dimen.is));
                aVar3.jBR.setText(aVar3.jBR.getContext().getResources().getString(d.this.Qak ? R.string.ba9 : R.string.ba8, d.this.Qaj));
                AppMethodBeat.o(102940);
                return;
            }
            aVar3.jBR.setVisibility(8);
            AppMethodBeat.o(102940);
        }
    }

    @Override // com.tencent.mm.ui.contact.a.f, com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.Qal;
    }
}
