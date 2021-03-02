package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.d;

public class JDRemindDialog extends MMBaseActivity {
    private d jzT = null;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28857);
        super.onCreate(bundle);
        requestWindowFeature(1);
        cjQ();
        AppMethodBeat.o(28857);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(28858);
        super.onResume();
        aa.activateBroadcast(true);
        AppMethodBeat.o(28858);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(28859);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.jzT != null) {
            this.jzT.dismiss();
            this.jzT = null;
        }
        cjQ();
        AppMethodBeat.o(28859);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(28860);
        super.onPause();
        aa.activateBroadcast(false);
        AppMethodBeat.o(28860);
    }

    private void cjQ() {
        AppMethodBeat.i(28861);
        if (getIntent() == null) {
            AppMethodBeat.o(28861);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            AppMethodBeat.o(28861);
            return;
        }
        d.a aVar = new d.a(this);
        aVar.bon("");
        aVar.boo(extras.getString("alertcontent"));
        aVar.bou(extras.getString("alertconfirm")).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(28855);
                String str = null;
                String str2 = "";
                if (!(JDRemindDialog.this.getIntent() == null || JDRemindDialog.this.getIntent().getExtras() == null)) {
                    str = JDRemindDialog.this.getIntent().getExtras().getString("alertjumpurl");
                    str2 = JDRemindDialog.this.getIntent().getExtras().getString("alert_activityid");
                }
                if (str2.equals(d.fsQ().fsV().FJm)) {
                    d.fsQ();
                    if (d.fsR()) {
                        d.fsQ();
                        d.fsU();
                        d.fsQ();
                        d.fsT();
                    }
                }
                if (!Util.isNullOrNil(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    c.b(JDRemindDialog.this, "webview", ".ui.tools.WebViewUI", intent);
                    h.INSTANCE.a(11179, str, d.fsQ().fsV().FJm, 5);
                }
                JDRemindDialog.this.finish();
                AppMethodBeat.o(28855);
            }
        });
        aVar.bov(extras.getString("alert_cancel")).d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.jdbiz.JDRemindDialog.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(28856);
                JDRemindDialog.this.finish();
                AppMethodBeat.o(28856);
            }
        });
        this.jzT = aVar.hbn();
        this.jzT.setCanceledOnTouchOutside(false);
        this.jzT.show();
        AppMethodBeat.o(28861);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(28862);
        Intent intent = new Intent(context, JDRemindDialog.class);
        intent.putExtra("alertcontent", str);
        intent.putExtra("alertconfirm", str2);
        intent.putExtra("alert_cancel", str3);
        intent.putExtra("alertjumpurl", str4);
        intent.putExtra("alert_activityid", str5);
        intent.addFlags(805306368);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/subapp/jdbiz/JDRemindDialog", "showAlert", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/subapp/jdbiz/JDRemindDialog", "showAlert", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(28862);
    }
}
