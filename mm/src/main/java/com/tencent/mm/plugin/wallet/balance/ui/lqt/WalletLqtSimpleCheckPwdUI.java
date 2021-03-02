package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(1)
public class WalletLqtSimpleCheckPwdUI extends WalletBaseUI {
    private w HCq;
    private EditHintPasswdView ykY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        String string;
        AppMethodBeat.i(69048);
        super.onCreate(bundle);
        if (z.aUo()) {
            string = getString(R.string.ib7);
        } else {
            string = getString(R.string.ib5);
        }
        setMMTitle(string);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSimpleCheckPwdUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69046);
                WalletLqtSimpleCheckPwdUI.this.finish();
                AppMethodBeat.o(69046);
                return false;
            }
        });
        ((TextView) findViewById(R.id.dyz)).setText(R.string.ib3);
        this.ykY = (EditHintPasswdView) findViewById(R.id.dyp);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.ykY);
        this.ykY.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSimpleCheckPwdUI.AnonymousClass2 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(69047);
                if (z) {
                    WalletLqtSimpleCheckPwdUI.this.HCq = new w(WalletLqtSimpleCheckPwdUI.this.ykY.getText(), 7, WalletLqtSimpleCheckPwdUI.this.getPayReqKey());
                    WalletLqtSimpleCheckPwdUI.this.doSceneForceProgress(WalletLqtSimpleCheckPwdUI.this.HCq);
                }
                AppMethodBeat.o(69047);
            }
        });
        setEditFocusListener(this.ykY, 0, false);
        AppMethodBeat.o(69048);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69049);
        Log.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof w) {
            if (i2 == 0 && i3 == 0) {
                String text = this.ykY.getText();
                Intent intent = new Intent();
                intent.putExtra("lqt_enc_pwd", text);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(69049);
                return true;
            } else if (this.ykY != null) {
                this.ykY.eIj();
            }
        }
        AppMethodBeat.o(69049);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(69050);
        super.cleanUiData(i2);
        if (this.ykY != null) {
            this.ykY.eIj();
        }
        AppMethodBeat.o(69050);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c9q;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
