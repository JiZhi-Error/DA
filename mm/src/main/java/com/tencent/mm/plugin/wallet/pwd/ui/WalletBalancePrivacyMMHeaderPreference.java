package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.r;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class WalletBalancePrivacyMMHeaderPreference extends Preference {
    Map<String, r.a> Cmg = new HashMap();
    String icon;
    private int noe;
    String title;

    public WalletBalancePrivacyMMHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(69587);
        AppMethodBeat.o(69587);
    }

    public WalletBalancePrivacyMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(69588);
        AppMethodBeat.o(69588);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void gr() {
        this.noe = R.raw.addfriend_icon_invite;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(69589);
        super.onBindView(view);
        view.findViewById(R.id.a03);
        TextView textView = (TextView) view.findViewById(R.id.a04);
        if (!Util.isNullOrNil(this.title)) {
            textView.setText(this.title);
        }
        ao.a(textView.getPaint(), 0.8f);
        AppMethodBeat.o(69589);
    }
}
