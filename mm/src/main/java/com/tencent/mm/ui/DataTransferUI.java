package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

@a(19)
public class DataTransferUI extends MMBaseActivity {
    private q nUq;
    private long startTime = 0;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33016);
        super.onCreate(bundle);
        Log.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
        this.startTime = System.currentTimeMillis();
        getString(R.string.zb);
        this.nUq = h.a((Context) this, getString(R.string.tc), false, (DialogInterface.OnCancelListener) null);
        new MMHandler() {
            /* class com.tencent.mm.ui.DataTransferUI.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(33015);
                if (DataTransferUI.this.nUq != null && DataTransferUI.this.nUq.isShowing()) {
                    Log.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
                    DataTransferUI.this.nUq.dismiss();
                    DataTransferUI.this.finish();
                }
                AppMethodBeat.o(33015);
            }
        }.sendEmptyMessageDelayed(0, Util.MILLSECONDS_OF_MINUTE);
        by(getIntent());
        AppMethodBeat.o(33016);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(33017);
        Log.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
        by(intent);
        AppMethodBeat.o(33017);
    }

    private void by(Intent intent) {
        AppMethodBeat.i(33018);
        boolean booleanExtra = intent.getBooleanExtra("finish_data_transfer", false);
        Log.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + booleanExtra);
        if (booleanExtra) {
            finish();
        }
        AppMethodBeat.o(33018);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(33019);
        Log.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
        super.onPause();
        AppMethodBeat.o(33019);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(33020);
        super.onDestroy();
        Log.d("MicroMsg.DataTransferUI", "onDestroy");
        if (this.nUq != null && this.nUq.isShowing()) {
            this.nUq.dismiss();
        }
        AppMethodBeat.o(33020);
    }
}
