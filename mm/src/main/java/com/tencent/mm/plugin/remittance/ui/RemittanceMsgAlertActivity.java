package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.a.f;

public class RemittanceMsgAlertActivity extends AppCompatActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public Resources getResources() {
        AppMethodBeat.i(213822);
        Resources resources = MMApplicationContext.getResources();
        AppMethodBeat.o(213822);
        return resources;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68212);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        f.a b2 = new f.a(this).bow(MMApplicationContext.getContext().getString(getIntent().getBooleanExtra("key_is_no_contact", false) ? R.string.g3f : R.string.g3e)).apb(MMApplicationContext.getContext().getResources().getColor(R.color.afp)).apa(R.string.e2u).b(new f.c() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
            }
        });
        b2.b(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity.AnonymousClass2 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(68211);
                RemittanceMsgAlertActivity.this.finish();
                AppMethodBeat.o(68211);
            }
        });
        b2.show();
        AppMethodBeat.o(68212);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(68213);
        super.onDestroy();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(68213);
    }
}
