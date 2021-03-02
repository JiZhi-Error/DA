package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CardShowWaringTransparentUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.oy;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113579);
        super.onCreate(bundle);
        h.a(this, getString(R.string.ath, new Object[]{getIntent().getStringExtra("KEY_BRAND_NAME")}), getString(R.string.ati), getString(R.string.aq_), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardShowWaringTransparentUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(113578);
                dialogInterface.dismiss();
                CardShowWaringTransparentUI.this.finish();
                AppMethodBeat.o(113578);
            }
        });
        AppMethodBeat.o(113579);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(113580);
        if (i2 == 4) {
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(113580);
        return onKeyUp;
    }
}
