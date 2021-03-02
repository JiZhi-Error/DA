package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public final class a extends g {
    private Bundle dQL;

    public a(MMActivity mMActivity, i iVar, Bundle bundle) {
        super(mMActivity, iVar);
        this.dQL = bundle;
    }

    @Override // com.tencent.mm.wallet_core.d.g
    public final boolean A(Object... objArr) {
        AppMethodBeat.i(72206);
        this.Ruz.b(new c(this.dQL.getString("payu_reference")), true);
        AppMethodBeat.o(72206);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.d.g
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72207);
        if ((qVar instanceof c) && i2 == 0 && i3 == 0) {
            c cVar = (c) qVar;
            this.dQL.putParcelable("key_security_question", new PayUSecurityQuestion(cVar.id, cVar.IuI));
            AppMethodBeat.o(72207);
            return false;
        }
        if (qVar instanceof b) {
            b bVar = (b) qVar;
            if (i2 == 0 && i3 == 0) {
                if (bVar.sPX) {
                    this.dQL.putString("payu_reference", bVar.IuH);
                    com.tencent.mm.wallet_core.a.l(this.activity, this.dQL);
                    AppMethodBeat.o(72207);
                    return true;
                }
                AppMethodBeat.o(72207);
                return false;
            }
        }
        AppMethodBeat.o(72207);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d.g
    public final boolean r(Object... objArr) {
        AppMethodBeat.i(72208);
        String string = this.dQL.getString("key_question_answer");
        this.Ruz.b(new b(this.dQL.getString("payu_reference"), ((PayUSecurityQuestion) this.dQL.getParcelable("key_security_question")).id, string), true);
        AppMethodBeat.o(72208);
        return false;
    }
}
