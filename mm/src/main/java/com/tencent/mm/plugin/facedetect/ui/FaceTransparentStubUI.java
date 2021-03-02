package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FaceTransparentStubUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104033);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("KEY_REQUEST_CODE", 1000);
        Bundle bundleExtra = getIntent().getBundleExtra("KEY_EXTRAS");
        if (!bundleExtra.containsKey("k_user_name")) {
            g.aAf();
            if (com.tencent.mm.kernel.a.azo()) {
                bundleExtra.putString("k_user_name", z.aUb());
            }
        }
        sh shVar = new sh();
        shVar.dYV.context = this;
        shVar.dYV.dYQ = intExtra;
        shVar.dYV.extras = bundleExtra;
        EventCenter.instance.publish(shVar);
        Log.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", Boolean.valueOf(shVar.dYW.dYN));
        if (!shVar.dYW.dYN) {
            if (shVar.dYW.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(shVar.dYW.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
        AppMethodBeat.o(104033);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(104034);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
        setResult(i3, intent);
        finish();
        AppMethodBeat.o(104034);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
