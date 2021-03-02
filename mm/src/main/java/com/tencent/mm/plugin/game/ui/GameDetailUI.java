package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameDetailUI extends MMBaseActivity {
    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42009);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("game_app_id");
        a.C1403a ei = com.tencent.mm.plugin.game.model.a.ei(stringExtra, getIntent().getIntExtra("game_report_from_scene", 0));
        if (ei.cSx != 2 || Util.isNullOrNil(ei.url)) {
            int dVb = e.dVb();
            if (dVb == 2) {
                c.l(this, stringExtra, 0);
            } else if (dVb == 1) {
                c.f(this, getIntent().getExtras());
            } else {
                String simCountryCode = Util.getSimCountryCode(this);
                if (Util.isNullOrNil(simCountryCode) || simCountryCode.toLowerCase().equals("cn")) {
                    c.l(this, stringExtra, 0);
                } else {
                    c.f(this, getIntent().getExtras());
                }
            }
        } else {
            c.D(getBaseContext(), ei.url, "game_center_detail");
        }
        finish();
        AppMethodBeat.o(42009);
    }
}
