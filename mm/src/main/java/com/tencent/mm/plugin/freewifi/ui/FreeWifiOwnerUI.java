package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.freewifi.j;

public class FreeWifiOwnerUI extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25118);
        super.onCreate(bundle);
        AppMethodBeat.o(25118);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(25119);
        super.onResume();
        String stringExtra = getIntent().getStringExtra("wifi_owner_name");
        int intExtra = getIntent().getIntExtra("wifi_owner_type", 0);
        j.userName = stringExtra;
        j.type = intExtra;
        finish();
        AppMethodBeat.o(25119);
    }
}
