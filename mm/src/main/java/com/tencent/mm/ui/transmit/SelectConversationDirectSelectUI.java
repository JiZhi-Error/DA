package com.tencent.mm.ui.transmit;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;

@i
@a(7)
public class SelectConversationDirectSelectUI extends SelectConversationUI {
    @Override // com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.transmit.SelectConversationUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(169901);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(1);
        AppMethodBeat.o(169901);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.contact.MMBaseSelectContactUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.transmit.SelectConversationUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(169902);
        super.onCreate(bundle);
        this.QzE = true;
        String stringExtra = getIntent().getStringExtra("Select_Conv_User");
        if (!Util.isNullOrNil(stringExtra)) {
            Log.d("MicroMsg.SelectConversationDirectSelectUI", "hy: request direct select username");
            setContentViewVisibility(8);
            overridePendingTransition(0, 0);
            y.e(getWindow());
            y.d(getWindow(), false);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            setBackGroundColorResource(R.color.ts);
            aMp(stringExtra);
            AppMethodBeat.o(169902);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not provide username for share. please use pure SelectConversationUI");
        AppMethodBeat.o(169902);
        throw illegalArgumentException;
    }
}
