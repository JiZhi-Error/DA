package com.tencent.smtt.sdk;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.tbs.c.a.b;

public class VideoActivity extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55098);
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            t.a(super.getApplicationContext()).a((String) null, bundleExtra, (b) null);
        }
        AppMethodBeat.o(55098);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(55099);
        super.onResume();
        t.a(this).a(this, 2);
        AppMethodBeat.o(55099);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(55100);
        super.onStop();
        t.a(this).a(this, 1);
        AppMethodBeat.o(55100);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(55101);
        super.onPause();
        t.a(this).a(this, 3);
        AppMethodBeat.o(55101);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(55102);
        super.onDestroy();
        t.a(this).a(this, 4);
        AppMethodBeat.o(55102);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(55103);
        super.onActivityResult(i2, i3, intent);
        t.a(this).a(i2, i3, intent);
        AppMethodBeat.o(55103);
    }
}
