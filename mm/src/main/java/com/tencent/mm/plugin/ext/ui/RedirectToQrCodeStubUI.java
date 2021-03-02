package com.tencent.mm.plugin.ext.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class RedirectToQrCodeStubUI extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24516);
        super.onCreate(bundle);
        Log.i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
        String stringExtra = getIntent().getStringExtra("K_STR");
        int intExtra = getIntent().getIntExtra("K_TYPE", -1);
        int intExtra2 = getIntent().getIntExtra("K_VERSION", -1);
        cr crVar = new cr();
        crVar.dFK.activity = this;
        crVar.dFK.dDX = stringExtra;
        crVar.dFK.dFL = intExtra;
        crVar.dFK.dFM = intExtra2;
        crVar.dFK.scene = 47;
        EventCenter.instance.publish(crVar);
        finish();
        AppMethodBeat.o(24516);
    }
}
