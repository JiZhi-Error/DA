package com.tencent.mm.plugin.location.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI extends MMTextInputUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.tools.MMTextInputUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.tools.MMTextInputUI
    public int getLayoutId() {
        return R.layout.bmh;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.tools.MMTextInputUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55883);
        super.onCreate(bundle);
        setMMTitle(R.string.ekx);
        String stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (Util.isNullOrNil(stringExtra)) {
            findViewById(R.id.eqc).setVisibility(8);
            AppMethodBeat.o(55883);
            return;
        }
        ((TextView) findViewById(R.id.eqw)).setText(stringExtra);
        AppMethodBeat.o(55883);
    }

    @Override // com.tencent.mm.ui.tools.MMTextInputUI
    public final void O(CharSequence charSequence) {
        AppMethodBeat.i(55884);
        long longExtra = getIntent().getLongExtra("kFavInfoLocalId", -1);
        if (longExtra > 0) {
            String charSequence2 = charSequence == null ? "" : charSequence.toString();
            Log.i("MicroMsg.MMTextInputUI", "same remark[%s]", charSequence2);
            if (!charSequence2.equals(getIntent().getStringExtra("kRemark"))) {
                cz czVar = new cz();
                czVar.dFZ.type = -2;
                czVar.dFZ.dFN = Long.toString(longExtra);
                czVar.dFZ.desc = charSequence2;
                Log.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", czVar.dFZ.dFN, czVar.dFZ.desc);
                EventCenter.instance.publish(czVar);
            }
        }
        AppMethodBeat.o(55884);
    }
}
