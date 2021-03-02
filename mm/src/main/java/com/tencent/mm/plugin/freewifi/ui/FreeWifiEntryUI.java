package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

@a(3)
public class FreeWifiEntryUI extends HellActivity {
    private boolean rHi = true;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25013);
        super.onCreate(bundle);
        AppMethodBeat.o(25013);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        if (r0 != false) goto L_0x003e;
     */
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
        // Method dump skipped, instructions count: 1344
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI.onResume():void");
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(25015);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(25015);
            return;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case TPCodecParamers.TP_PROFILE_H264_MAIN /*{ENCODED_INT: 77}*/:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.rHi = false;
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25011);
                            FreeWifiEntryUI freeWifiEntryUI = FreeWifiEntryUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiEntryUI, bl.axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            freeWifiEntryUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(freeWifiEntryUI, "com/tencent/mm/plugin/freewifi/ui/FreeWifiEntryUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            FreeWifiEntryUI.this.finish();
                            AppMethodBeat.o(25011);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.freewifi.ui.FreeWifiEntryUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25012);
                            FreeWifiEntryUI.this.finish();
                            AppMethodBeat.o(25012);
                        }
                    });
                    break;
                }
        }
        AppMethodBeat.o(25015);
    }
}
