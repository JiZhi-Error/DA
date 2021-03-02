package com.tencent.mm.vending.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.vending.e.b;

public abstract class PresenterActivity extends HellActivity implements b {
    private c htH = new c();

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.htH.A(getIntent(), this);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        super.onResume();
        this.htH.apB(2);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        this.htH.apB(3);
        super.onPause();
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        this.htH.onDestroy();
        super.onDestroy();
    }
}
