package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.HashMap;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(19)
public class WalletPayUCardElementUI extends WalletBaseUI implements WalletFormView.a {
    private WalletFormView IsK;
    WalletFormView IsL;
    private WalletFormView IsM;
    private TextView IsN;
    private TextView IsO;
    private TextView IsP;
    private b IsQ;
    private boolean IsR = false;
    private boolean IsS = false;
    private boolean IsT = false;
    private HashMap<String, NetScenePayUElementQuery.PayUBankcardElement> IsU = null;
    private HashSet<String> IsV = null;
    private Button krs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(72005);
        super.onCreate(bundle);
        this.IsQ = new b();
        this.IsU = new HashMap<>();
        this.IsV = new HashSet<>();
        this.IsK = (WalletFormView) findViewById(R.id.ao9);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.IsK);
        this.IsL = (WalletFormView) findViewById(R.id.bkj);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.IsL);
        this.IsM = (WalletFormView) findViewById(R.id.bk5);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.IsM);
        this.IsN = (TextView) findViewById(R.id.jez);
        this.IsO = (TextView) findViewById(R.id.jeo);
        this.krs = (Button) findViewById(R.id.fz0);
        setEditFocusListener(this.IsK, 0, false);
        setEditFocusListener(this.IsM, 0, false);
        this.IsK.setOnInputValidChangeListener(this);
        this.IsM.setOnInputValidChangeListener(this);
        this.IsL.setOnInputValidChangeListener(this);
        this.IsK.setEncryptType(0);
        this.IsM.a(new a() {
            /* class com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.AnonymousClass1 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(72000);
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.IsM, editable);
                AppMethodBeat.o(72000);
            }
        });
        this.IsL.a(new a() {
            /* class com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.AnonymousClass2 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(72001);
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.IsL, editable);
                AppMethodBeat.o(72001);
            }
        });
        this.IsK.a(new a() {
            /* class com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.AnonymousClass3 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(72002);
                WalletPayUCardElementUI.a(WalletPayUCardElementUI.this, WalletPayUCardElementUI.this.IsK, editable);
                AppMethodBeat.o(72002);
            }
        });
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(72003);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/bind/ui/WalletPayUCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                NetScenePayUElementQuery.PayUBankcardElement payUBankcardElement = (NetScenePayUElementQuery.PayUBankcardElement) WalletPayUCardElementUI.this.IsU.get(WalletPayUCardElementUI.this.IsK.getText());
                if (payUBankcardElement == null) {
                    Log.e("MicroMsg.WalletPayUCardElementUI", "hy: should not be NULL!!!");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/bind/ui/WalletPayUCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72003);
                    return;
                }
                WalletPayUCardElementUI.this.IsK.setEncryptType(50);
                WalletPayUCardElementUI.this.getInput().putParcelable("key_card_element", payUBankcardElement);
                WalletPayUCardElementUI.this.getInput().putString("key_card_id", WalletPayUCardElementUI.this.IsK.getText());
                WalletPayUCardElementUI.this.getInput().putString("key_cvv", WalletPayUCardElementUI.this.IsM.getText());
                WalletPayUCardElementUI.this.getInput().putString("key_expire_data", WalletPayUCardElementUI.this.IsL.getText());
                WalletPayUCardElementUI.this.getNetController().r(new Object[0]);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/bind/ui/WalletPayUCardElementUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72003);
            }
        });
        ((TextView) findViewById(R.id.jhr)).setText(ah.hhy());
        this.IsP = (TextView) findViewById(R.id.i4j);
        c.a(this, this.IsP);
        AppMethodBeat.o(72005);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(72006);
        super.onResume();
        this.IsQ.fUz();
        AppMethodBeat.o(72006);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72007);
        if (qVar instanceof NetScenePayUElementQuery) {
            this.IsU.put(((NetScenePayUElementQuery) qVar).IsC, (NetScenePayUElementQuery.PayUBankcardElement) getInput().getParcelable("key_card_element"));
            this.IsQ.fUz();
            this.IsV.remove(((NetScenePayUElementQuery) qVar).IsC);
            AppMethodBeat.o(72007);
            return true;
        }
        if ((qVar instanceof com.tencent.mm.plugin.wallet_payu.bind.model.a) && !(i2 == 0 && i3 == 0)) {
            this.IsK.setEncryptType(0);
        }
        AppMethodBeat.o(72007);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bhk;
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
    }

    /* access modifiers changed from: protected */
    public class b {
        boolean IsX;
        boolean IsY;
        boolean IsZ;

        protected b() {
        }

        /* access modifiers changed from: protected */
        public final void fUz() {
            boolean z;
            AppMethodBeat.i(72004);
            this.IsX = WalletPayUCardElementUI.this.IsK.bql();
            this.IsY = WalletPayUCardElementUI.this.IsL.bql();
            this.IsZ = WalletPayUCardElementUI.this.IsM.bql();
            if (!WalletPayUCardElementUI.this.IsT || this.IsZ) {
                WalletPayUCardElementUI.this.IsO.setVisibility(4);
            } else {
                WalletPayUCardElementUI.this.IsO.setVisibility(0);
                WalletPayUCardElementUI.this.IsO.setText(R.string.i9k);
            }
            if (!WalletPayUCardElementUI.this.IsR) {
                z = false;
            } else if (!this.IsX) {
                WalletPayUCardElementUI.this.IsN.setVisibility(0);
                WalletPayUCardElementUI.this.IsN.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(R.color.a5c));
                WalletPayUCardElementUI.this.IsN.setText(R.string.i92);
                z = false;
            } else if (!WalletPayUCardElementUI.this.IsU.containsKey(WalletPayUCardElementUI.this.IsK.getText()) || WalletPayUCardElementUI.this.IsV.contains(WalletPayUCardElementUI.this.IsK.getText())) {
                WalletPayUCardElementUI.this.doSceneProgress(new NetScenePayUElementQuery(WalletPayUCardElementUI.this.IsK.getText()), false);
                WalletPayUCardElementUI.this.IsV.add(WalletPayUCardElementUI.this.IsK.getText());
                WalletPayUCardElementUI.this.IsN.setVisibility(0);
                WalletPayUCardElementUI.this.IsN.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(R.color.uj));
                WalletPayUCardElementUI.this.IsN.setText(WalletPayUCardElementUI.this.getString(R.string.i8h));
                z = true;
            } else {
                NetScenePayUElementQuery.PayUBankcardElement payUBankcardElement = (NetScenePayUElementQuery.PayUBankcardElement) WalletPayUCardElementUI.this.IsU.get(WalletPayUCardElementUI.this.IsK.getText());
                WalletPayUCardElementUI.this.IsN.setVisibility(0);
                if (!Util.isNullOrNil(payUBankcardElement.IsF)) {
                    WalletPayUCardElementUI.this.IsN.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(R.color.uj));
                    WalletPayUCardElementUI.this.IsN.setText(payUBankcardElement.IsG);
                    z = false;
                } else {
                    WalletPayUCardElementUI.this.IsN.setTextColor(WalletPayUCardElementUI.this.getResources().getColor(R.color.a5c));
                    WalletPayUCardElementUI.this.IsN.setText(payUBankcardElement.IsG);
                    this.IsX = false;
                    z = false;
                }
            }
            if (!this.IsX || !this.IsY || !this.IsZ || z) {
                WalletPayUCardElementUI.this.krs.setEnabled(false);
                AppMethodBeat.o(72004);
                return;
            }
            WalletPayUCardElementUI.this.krs.setEnabled(true);
            AppMethodBeat.o(72004);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    abstract class a implements TextWatcher {
        private a() {
        }

        /* synthetic */ a(WalletPayUCardElementUI walletPayUCardElementUI, byte b2) {
            this();
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    static /* synthetic */ void a(WalletPayUCardElementUI walletPayUCardElementUI, View view, Editable editable) {
        AppMethodBeat.i(72008);
        if (!(editable == null || editable.length() == 0)) {
            if (view.getId() == walletPayUCardElementUI.IsK.getId()) {
                walletPayUCardElementUI.IsR = true;
            } else if (view.getId() == walletPayUCardElementUI.IsM.getId()) {
                walletPayUCardElementUI.IsT = true;
            } else if (view.getId() == walletPayUCardElementUI.IsL.getId()) {
                walletPayUCardElementUI.IsS = true;
            }
        }
        walletPayUCardElementUI.IsQ.fUz();
        AppMethodBeat.o(72008);
    }
}
