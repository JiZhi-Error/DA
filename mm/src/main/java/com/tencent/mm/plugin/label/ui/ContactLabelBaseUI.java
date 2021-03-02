package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactLabelBaseUI extends MMActivity {
    private ProgressDialog jZH;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return 0;
    }

    public final void aCL(String str) {
        AppMethodBeat.i(26159);
        getString(R.string.zb);
        this.jZH = h.a((Context) this, str, true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelBaseUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(26158);
                bg.azz().cancel(636);
                AppMethodBeat.o(26158);
            }
        });
        AppMethodBeat.o(26159);
    }

    public final void hideLoading() {
        AppMethodBeat.i(26160);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        AppMethodBeat.o(26160);
    }

    public final void amW(String str) {
        AppMethodBeat.i(26161);
        h.d(this, str, "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.label.ui.ContactLabelBaseUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(26161);
    }
}
