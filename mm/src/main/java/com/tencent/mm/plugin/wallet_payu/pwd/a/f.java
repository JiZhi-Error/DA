package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.a;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class f extends e {
    @Override // com.tencent.mm.wallet_core.d
    public final d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(72151);
        b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
        d a2 = super.a(activity, bundle);
        AppMethodBeat.o(72151);
        return a2;
    }

    @Override // com.tencent.mm.plugin.wallet_payu.pwd.a.e, com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(72152);
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
            AppMethodBeat.o(72152);
            return;
        }
        super.a(activity, i2, bundle);
        AppMethodBeat.o(72152);
    }

    @Override // com.tencent.mm.plugin.wallet_payu.pwd.a.e, com.tencent.mm.wallet_core.d
    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(72153);
        if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            a aVar = new a(mMActivity, iVar, this.dQL);
            AppMethodBeat.o(72153);
            return aVar;
        }
        g a2 = super.a(mMActivity, iVar);
        AppMethodBeat.o(72153);
        return a2;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "PayUForgotPwdProcess";
    }
}
