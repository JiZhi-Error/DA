package com.tencent.mm.plugin.subapp.ui.friend;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

@i
public class FMessageTransferUI extends MMActivity {
    private int dnr;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29053);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("friend_message_transfer_username");
        if (Util.isNullOrNil(stringExtra)) {
            finish();
        }
        d.bgN().bks(stringExtra);
        d.bgN().gCS();
        String action = getIntent().getAction();
        String concat = "friend_message_accept_".concat(String.valueOf(stringExtra));
        this.dnr = 2130706432 | (Integer.MAX_VALUE & stringExtra.hashCode());
        bg.getNotification().cancel(this.dnr);
        if (concat.equals(action)) {
            a.i(getContext(), stringExtra, true);
        }
        finish();
        AppMethodBeat.o(29053);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
