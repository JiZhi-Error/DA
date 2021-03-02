package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.d;

@a(7)
public class FileDownloadConfirmUI extends MMBaseActivity {
    private d jzT = null;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(89126);
        super.onCreate(bundle);
        setContentView(R.layout.a3o);
        if (com.tencent.mm.compatible.util.d.oD(21)) {
            getWindow().setStatusBarColor(0);
        }
        final long longExtra = getIntent().getLongExtra("extra_download_id", -1);
        AnonymousClass1 r2 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(89124);
                f.cBv().Cn(longExtra);
                Log.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", Long.valueOf(longExtra));
                AppMethodBeat.o(89124);
            }
        };
        AnonymousClass2 r3 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        };
        AnonymousClass3 r4 = new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI.AnonymousClass3 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(89125);
                FileDownloadConfirmUI.this.finish();
                AppMethodBeat.o(89125);
            }
        };
        d.a aVar = new d.a(this);
        aVar.bon("");
        aVar.aoS(R.string.cdk);
        aVar.aoV(R.string.a0_).c(r2);
        aVar.aoW(R.string.x6).d(r3);
        aVar.a(r4);
        this.jzT = aVar.hbn();
        this.jzT.show();
        com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(longExtra);
        if (Cw != null) {
            b bVar = new b();
            bVar.k(Cw);
            com.tencent.mm.plugin.downloader.f.a.a(19, bVar);
        }
        Log.i("MicroMsg.FileDownloadConfirmUI", "Confirm Dialog");
        AppMethodBeat.o(89126);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(89127);
        Log.i("MicroMsg.FileDownloadConfirmUI", "onNewIntent");
        AppMethodBeat.o(89127);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(89128);
        super.onStop();
        this.jzT.dismiss();
        AppMethodBeat.o(89128);
    }
}
