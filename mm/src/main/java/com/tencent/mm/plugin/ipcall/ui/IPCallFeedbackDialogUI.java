package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IPCallFeedbackDialogUI extends MMActivity {
    private g ywi;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25791);
        super.onCreate(bundle);
        Log.i("MicroMsg.IPCallFeedbackDialogUI", "onCreate");
        this.ywi = new g(this, getContext(), getIntent().getIntExtra("IPCallFeedbackDialogUI_KRoomId", 0), getIntent().getLongExtra("IPCallFeedbackDialogUI_KCallseq", 0));
        this.ywi.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallFeedbackDialogUI.AnonymousClass1 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(25790);
                IPCallFeedbackDialogUI.this.finish();
                AppMethodBeat.o(25790);
            }
        });
        this.ywi.getWindow().setSoftInputMode(16);
        this.ywi.show();
        AppMethodBeat.o(25791);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25792);
        Log.d("MicroMsg.IPCallFeedbackDialogUI", "onResume");
        super.onResume();
        AppMethodBeat.o(25792);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(25793);
        Log.d("MicroMsg.IPCallFeedbackDialogUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(25793);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25794);
        Log.d("MicroMsg.IPCallFeedbackDialogUI", "onDestroy");
        super.onDestroy();
        AppMethodBeat.o(25794);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(25795);
        Log.i("MicroMsg.IPCallFeedbackDialogUI", "finish");
        if (this.ywi != null && this.ywi.isShowing()) {
            this.ywi.dismiss();
            this.ywi = null;
        }
        super.finish();
        AppMethodBeat.o(25795);
    }
}
