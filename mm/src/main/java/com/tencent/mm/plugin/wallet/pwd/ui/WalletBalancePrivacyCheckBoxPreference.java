package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WalletBalancePrivacyCheckBoxPreference extends CheckBoxPreference {
    private int HIJ;
    private String HIK;
    private int HIL;
    private View mView;
    boolean oD;
    private MMSwitchBtn sLW;

    static /* synthetic */ boolean a(WalletBalancePrivacyCheckBoxPreference walletBalancePrivacyCheckBoxPreference, Object obj) {
        AppMethodBeat.i(214075);
        boolean callChangeListener = walletBalancePrivacyCheckBoxPreference.callChangeListener(obj);
        AppMethodBeat.o(214075);
        return callChangeListener;
    }

    public WalletBalancePrivacyCheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletBalancePrivacyCheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(214071);
        this.oD = false;
        this.HIJ = -1;
        this.HIK = "";
        this.HIL = 8;
        setLayoutResource(R.layout.i3);
        AppMethodBeat.o(214071);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(214072);
        this.mView = super.onCreateView(viewGroup);
        View view = this.mView;
        AppMethodBeat.o(214072);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final void onBindView(View view) {
        AppMethodBeat.i(214073);
        super.onBindView(view);
        alO(8);
        this.sLW = (MMSwitchBtn) view.findViewById(R.id.b0m);
        this.sLW.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyCheckBoxPreference.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(214070);
                WalletBalancePrivacyCheckBoxPreference.a(WalletBalancePrivacyCheckBoxPreference.this, Boolean.valueOf(z));
                AppMethodBeat.o(214070);
            }
        });
        this.sLW.setCheck(this.oD);
        if (!isEnabled()) {
            this.sLW.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(R.color.m5));
            ((TextView) view.findViewById(16908304)).setTextColor(view.getResources().getColor(R.color.m5));
        }
        View findViewById = view.findViewById(R.id.it2);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        AppMethodBeat.o(214073);
    }

    @Override // com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final boolean isChecked() {
        if (this.sLW != null) {
            return this.sLW.QDw;
        }
        return this.oD;
    }

    @Override // com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final void setChecked(boolean z) {
        this.oD = z;
    }

    @Override // com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final void xZ(boolean z) {
        AppMethodBeat.i(214074);
        if (this.sLW != null) {
            this.oD = z;
            this.sLW.setCheck(z);
        }
        AppMethodBeat.o(214074);
    }

    @Override // com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final void fZ(String str, int i2) {
    }

    @Override // com.tencent.mm.ui.base.preference.CheckBoxPreference
    public final void aez(int i2) {
    }
}
