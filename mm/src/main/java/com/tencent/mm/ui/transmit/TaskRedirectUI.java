package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.a;

@a(7)
public class TaskRedirectUI extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39486);
        super.onCreate(bundle);
        Intent intent = new Intent(this, LauncherUI.class);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/transmit/TaskRedirectUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/TaskRedirectUI", "onCreate", "(Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(39486);
    }
}
