package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemindDialog extends HellActivity {
    private static List<String> FNx = new ArrayList();
    private static boolean dEF = false;
    private List<String> FNw = new ArrayList();
    private ay.d FNy = new ay.d() {
        /* class com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.AnonymousClass1 */

        @Override // com.tencent.mm.model.ay.d
        public final void B(String str, long j2) {
            AppMethodBeat.i(29249);
            Log.d("MicroMsg.RemindDialog", "onVoiceRemind ".concat(String.valueOf(str)));
            RemindDialog.this.FNw.add(str);
            RemindDialog.b(RemindDialog.this);
            AppMethodBeat.o(29249);
        }
    };
    private MMHandler handler = new MMHandler();
    private d kdo;
    private String talker = "";

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemindDialog() {
        AppMethodBeat.i(29254);
        AppMethodBeat.o(29254);
    }

    static /* synthetic */ void b(RemindDialog remindDialog) {
        AppMethodBeat.i(29260);
        remindDialog.dGH();
        AppMethodBeat.o(29260);
    }

    static {
        AppMethodBeat.i(29261);
        AppMethodBeat.o(29261);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29255);
        super.onCreate(bundle);
        requestWindowFeature(1);
        d.a aVar = new d.a(this);
        aVar.aoO(R.string.i03);
        aVar.boo(" ");
        aVar.aoV(R.string.i00).c(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(29250);
                com.tencent.mm.plugin.subapp.d.d ftg = com.tencent.mm.plugin.subapp.d.d.ftg();
                if (ftg != null) {
                    ftg.Kl(RemindDialog.this.talker);
                }
                if (ab.Jq(bg.getNotification().ala())) {
                    RemindDialog.this.finish();
                    AppMethodBeat.o(29250);
                    return;
                }
                b.jRt.d(new Intent().putExtra("Chat_User", RemindDialog.this.talker), RemindDialog.this);
                RemindDialog.this.finish();
                AppMethodBeat.o(29250);
            }
        });
        aVar.aoW(R.string.i02).d(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(29251);
                com.tencent.mm.plugin.subapp.d.d ftg = com.tencent.mm.plugin.subapp.d.d.ftg();
                if (ftg != null) {
                    ftg.Kl(RemindDialog.this.talker);
                }
                RemindDialog.this.finish();
                AppMethodBeat.o(29251);
            }
        });
        aVar.a(new DialogInterface.OnDismissListener() {
            /* class com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.AnonymousClass4 */

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(29252);
                RemindDialog.this.finish();
                AppMethodBeat.o(29252);
            }
        });
        this.talker = getIntent().getStringExtra("_RemindDialog_User");
        String stringExtra = getIntent().getStringExtra("_RemindDialog_Remind");
        this.FNw.clear();
        this.FNw.add(stringExtra);
        for (String str : FNx) {
            this.FNw.add(str);
        }
        this.kdo = aVar.hbn();
        this.kdo.setCanceledOnTouchOutside(false);
        this.kdo.show();
        dGH();
        AppMethodBeat.o(29255);
    }

    private void dGH() {
        AppMethodBeat.i(29256);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(29253);
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : RemindDialog.this.FNw) {
                    if (Util.isNullOrNil(str)) {
                        stringBuffer.append("\n\n");
                    } else {
                        stringBuffer.append(str + "\n\n");
                    }
                }
                if (RemindDialog.this.kdo != null) {
                    RemindDialog.this.kdo.setMessage(stringBuffer);
                }
                AppMethodBeat.o(29253);
            }
        });
        AppMethodBeat.o(29256);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(29257);
        dEF = true;
        com.tencent.mm.plugin.subapp.d.d ftg = com.tencent.mm.plugin.subapp.d.d.ftg();
        if (ftg != null) {
            ftg.a(this.FNy);
        }
        super.onResume();
        AppMethodBeat.o(29257);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(29258);
        dEF = false;
        com.tencent.mm.plugin.subapp.d.d ftg = com.tencent.mm.plugin.subapp.d.d.ftg();
        if (ftg != null) {
            ftg.b(this.FNy);
        }
        super.onPause();
        AppMethodBeat.o(29258);
    }

    public static void L(Context context, String str, String str2) {
        AppMethodBeat.i(29259);
        Log.d("MicroMsg.RemindDialog", "show " + dEF + " remind " + str2);
        if (dEF) {
            FNx.add(str2);
            AppMethodBeat.o(29259);
            return;
        }
        FNx.clear();
        dEF = true;
        if (bg.azz().foreground) {
            Intent intent = new Intent(context, RemindDialog.class);
            intent.putExtra("_RemindDialog_User", str);
            intent.putExtra("_RemindDialog_Remind", str2);
            intent.setFlags(603979776);
            intent.addFlags(268435456);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(29259);
            return;
        }
        Intent intent2 = new Intent(context, RemindDialog.class);
        intent2.putExtra("_RemindDialog_User", str);
        intent2.putExtra("_RemindDialog_Remind", str2);
        intent2.setFlags(604012544);
        intent2.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl2.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/subapp/ui/voicereminder/RemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(29259);
    }
}
