package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletSecuritySettingHeaderPref extends Preference {
    private TextView HKS;
    TextView HKT;
    String HKU;
    String HKV;
    View.OnClickListener HKW;
    View.OnClickListener HKX;
    private MMActivity gte;
    ImageView hTd;
    String sUf;
    private TextView trw;

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(69786);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(69786);
    }

    public WalletSecuritySettingHeaderPref(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(69787);
        this.HKW = null;
        this.HKX = null;
        this.gte = (MMActivity) context;
        setLayoutResource(R.layout.c_x);
        AppMethodBeat.o(69787);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(69788);
        super.onBindView(view);
        Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo onBindView");
        this.trw = (TextView) view.findViewById(R.id.f68);
        ao.a(this.trw.getPaint(), 0.8f);
        this.HKS = (TextView) view.findViewById(R.id.bmr);
        this.HKT = (TextView) view.findViewById(R.id.bot);
        this.hTd = (ImageView) view.findViewById(R.id.ji5);
        updateView();
        if (!(this.HKT == null || this.HKW == null)) {
            this.HKT.setOnClickListener(this.HKW);
        }
        if (!(this.hTd == null || this.HKX == null)) {
            this.hTd.setOnClickListener(this.HKX);
        }
        AppMethodBeat.o(69788);
    }

    /* access modifiers changed from: package-private */
    public final void updateView() {
        AppMethodBeat.i(69789);
        if (!Util.isNullOrNil(this.sUf) && this.trw != null) {
            this.trw.setText(this.sUf);
            this.trw.setVisibility(0);
        }
        if (!Util.isNullOrNil(this.HKU) && this.HKS != null) {
            this.HKS.setText(this.HKU);
            this.HKS.setVisibility(0);
        }
        if (!Util.isNullOrNil(this.HKV) && this.HKT != null) {
            this.HKT.setText(this.HKV);
            this.HKT.setVisibility(0);
        }
        if (Util.isNullOrNil(this.HKV) && this.HKT != null) {
            this.HKT.setVisibility(8);
        }
        AppMethodBeat.o(69789);
    }
}
