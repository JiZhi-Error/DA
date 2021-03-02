package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.widget.a.d;

public class FavTipsUI extends MMBaseActivity {
    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(106939);
        super.onCreate(bundle);
        d.a aVar = new d.a(this);
        aVar.bon(getString(R.string.c_w));
        aVar.boo(getString(R.string.c_u) + "\n\n" + getString(R.string.c_v));
        aVar.aoV(R.string.c_t).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavTipsUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(106937);
                FavTipsUI.this.finish();
                AppMethodBeat.o(106937);
            }
        });
        aVar.f(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavTipsUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(106938);
                FavTipsUI.this.finish();
                AppMethodBeat.o(106938);
            }
        });
        aVar.hbn().show();
        AppMethodBeat.o(106939);
    }
}
