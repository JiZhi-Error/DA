package com.tencent.mm.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.f;

public class PermissionWarningDialog extends MMBaseActivity {
    private DialogInterface.OnCancelListener XY = new DialogInterface.OnCancelListener() {
        /* class com.tencent.mm.permission.PermissionWarningDialog.AnonymousClass1 */

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(20690);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.o(20690);
        }
    };
    private d jzT = null;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PermissionWarningDialog() {
        AppMethodBeat.i(20694);
        AppMethodBeat.o(20694);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20695);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (!bkS()) {
            finish();
        }
        AppMethodBeat.o(20695);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(20696);
        super.onResume();
        aa.activateBroadcast(true);
        AppMethodBeat.o(20696);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(20697);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.jzT != null) {
            this.jzT.dismiss();
            this.jzT = null;
        }
        if (!bkS()) {
            finish();
        }
        AppMethodBeat.o(20697);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(20698);
        super.onPause();
        aa.activateBroadcast(false);
        AppMethodBeat.o(20698);
    }

    private boolean bkS() {
        AppMethodBeat.i(20699);
        if (getIntent() == null) {
            Log.e("MicroMsg.PermissionWarningDialog", "Intent is null");
            AppMethodBeat.o(20699);
            return false;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("MicroMsg.PermissionWarningDialog", "invalid params");
            AppMethodBeat.o(20699);
            return false;
        }
        int i2 = extras.getInt("warning_type", 0);
        if (1 == i2) {
            d.a aVar = new d.a(this);
            aVar.bon(extras.getString("warning_title"));
            aVar.boo(extras.getString("warning_content"));
            aVar.aoV(R.string.w1).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.permission.PermissionWarningDialog.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(20691);
                    PermissionWarningDialog.this.finish();
                    AppMethodBeat.o(20691);
                }
            });
            aVar.f(this.XY);
            this.jzT = aVar.hbn();
            this.jzT.setCanceledOnTouchOutside(false);
            this.jzT.show();
        } else if (2 == i2) {
            d.a aVar2 = new d.a(this);
            extras.getBoolean("warning_filter", false);
            extras.getBoolean("warning_due2Exception", false);
            aVar2.aoO(R.string.xq);
            aVar2.boo(getString(R.string.xl));
            aVar2.aoV(R.string.xf).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.permission.PermissionWarningDialog.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(20692);
                    PermissionWarningDialog.this.finish();
                    AppMethodBeat.o(20692);
                }
            });
            aVar2.f(this.XY);
            this.jzT = aVar2.hbn();
            this.jzT.setCanceledOnTouchOutside(false);
            this.jzT.show();
        } else if (3 == i2) {
            f.a aVar3 = new f.a(this);
            aVar3.Dq(false);
            aVar3.bow(getString(R.string.wk)).boB(getString(R.string.w3)).boA(getString(R.string.wl)).c(new f.c() {
                /* class com.tencent.mm.permission.PermissionWarningDialog.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(20693);
                    if (z) {
                        Log.i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
                        ((AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMicrophoneMute(false);
                    }
                    PermissionWarningDialog.this.finish();
                    AppMethodBeat.o(20693);
                }
            }).show();
        } else {
            AppMethodBeat.o(20699);
            return false;
        }
        AppMethodBeat.o(20699);
        return true;
    }

    public static void b(Context context, boolean z, boolean z2) {
        AppMethodBeat.i(20700);
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 2);
        intent.putExtra("warning_filter", z);
        intent.putExtra("warning_due2Exception", z2);
        intent.addFlags(805306368);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/permission/PermissionWarningDialog", "showReportAppListAlert", "(Landroid/content/Context;ZZ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(20700);
    }

    public static void dp(Context context) {
        AppMethodBeat.i(20701);
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 3);
        intent.addFlags(805306368);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/permission/PermissionWarningDialog", "showMicroPhoneMuteAlert", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(20701);
    }
}
