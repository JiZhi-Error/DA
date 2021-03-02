package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.h;

public abstract class MallBaseUI extends MMActivity {
    protected String lAr;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.product.ui.MallBaseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(66933);
                MallBaseUI.this.finish();
                AppMethodBeat.o(66933);
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void aKi(String str) {
        this.lAr = str;
        showDialog(-10001);
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i2) {
        switch (i2) {
            case HttpClientWrapper.RET_CODE_PROTOCOL /*{ENCODED_INT: -10002}*/:
                return h.a((Context) getContext(), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.product.ui.MallBaseUI.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            case -10001:
                if (Util.isNullOrNil(this.lAr)) {
                    this.lAr = getString(R.string.ewn);
                }
                return com.tencent.mm.ui.base.h.a((Context) this, this.lAr, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.product.ui.MallBaseUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(66934);
                        MallBaseUI.this.finish();
                        AppMethodBeat.o(66934);
                    }
                });
            default:
                return super.onCreateDialog(i2);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setContentViewVisibility(int i2) {
        getContentView().setVisibility(i2);
        if (i2 == 0) {
            showTitleView();
        } else {
            hideTitleView();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getAction() == 1) {
            callBackMenu();
        }
        return super.onKeyUp(i2, keyEvent);
    }
}
