package com.tencent.mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ci.b;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.MMHandler;

@TargetApi(17)
public class MemoryLeakActivity extends HellActivity {
    private AlertDialog jJF;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(145575);
            if (a.jJI.get(MemoryLeakActivity.this.mKey).get() == null) {
                MemoryLeakActivity.this.finish();
                AppMethodBeat.o(145575);
                return;
            }
            MemoryLeakActivity.this.jJF.show();
            AppMethodBeat.o(145575);
        }
    };
    private String mKey;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MemoryLeakActivity() {
        AppMethodBeat.i(145579);
        AppMethodBeat.o(145579);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(145580);
        super.onCreate(bundle);
        setContentView(R.layout.hl);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("memory leak");
        this.mKey = getIntent().getStringExtra("key");
        String stringExtra = getIntent().getStringExtra("tag");
        String stringExtra2 = getIntent().getStringExtra("class");
        if (stringExtra2.contains(" ")) {
            stringExtra2 = stringExtra2.substring(stringExtra2.indexOf(" "));
        }
        final String replace = stringExtra2.replace(".", "_");
        builder.setMessage(stringExtra + stringExtra2 + "\n\npath:" + b.OvV + replace + ".zip");
        builder.setCancelable(true);
        builder.setPositiveButton("dumphprof", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(145576);
                b.blE(replace);
                if (MemoryLeakActivity.this.jJF != null && MemoryLeakActivity.this.jJF.isShowing()) {
                    MemoryLeakActivity.this.jJF.dismiss();
                }
                MemoryLeakActivity.this.finish();
                AppMethodBeat.o(145576);
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(145577);
                if (MemoryLeakActivity.this.jJF != null && MemoryLeakActivity.this.jJF.isShowing()) {
                    MemoryLeakActivity.this.jJF.dismiss();
                }
                MemoryLeakActivity.this.finish();
                AppMethodBeat.o(145577);
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity.AnonymousClass4 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(145578);
                MemoryLeakActivity.this.finish();
                AppMethodBeat.o(145578);
            }
        });
        this.jJF = builder.create();
        b.gGk();
        this.mHandler.sendEmptyMessageDelayed(0, 200);
        AppMethodBeat.o(145580);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(145581);
        super.onDestroy();
        a.jJI.remove(this.mKey);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.jJF != null && this.jJF.isShowing()) {
            this.jJF.dismiss();
            this.jJF = null;
        }
        AppMethodBeat.o(145581);
    }
}
