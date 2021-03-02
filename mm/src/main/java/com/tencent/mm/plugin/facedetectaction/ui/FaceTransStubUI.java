package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.se;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FaceTransStubUI extends MMActivity {
    private Context context = this;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FaceTransStubUI() {
        AppMethodBeat.i(104268);
        AppMethodBeat.o(104268);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104269);
        super.onCreate(bundle);
        Log.i("MicroMsg.FaceTransStubUI", "carson: start FaceTransStubUI ");
        se seVar = new se();
        seVar.dYI.scene = getIntent().getIntExtra("scene", 0);
        seVar.dYI.packageName = getIntent().getStringExtra("package");
        seVar.dYI.dYK = getIntent().getStringExtra("packageSign");
        seVar.dYI.dYL = getIntent().getStringExtra("otherVerifyTitle");
        seVar.dYI.dYM = getIntent().getStringExtra("needFrontPage");
        seVar.dYI.requestCode = 63;
        if (this.context instanceof Activity) {
            seVar.dYI.dKq = (Activity) this.context;
        }
        EventCenter.instance.publish(seVar);
        Log.i("MicroMsg.FaceTransStubUI", "carson: start face detect event result: %b", Boolean.valueOf(seVar.dYJ.dYN));
        if (!seVar.dYJ.dYN) {
            if (seVar.dYJ.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(seVar.dYJ.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
        AppMethodBeat.o(104269);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(104270);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.FaceTransStubUI", "carson : on activity result in FaceTransStubUI");
        setResult(i3, intent);
        finish();
        AppMethodBeat.o(104270);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
