package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.voip.d;
import com.tencent.mm.plugin.voip.model.h;
import com.tencent.mm.plugin.voip.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMBaseActivity;
import java.util.HashMap;
import java.util.Map;

public class InviteRemindDialog extends MMBaseActivity {
    private TextView HcE;
    private TextView hbb;
    private String talker = "";
    private int type = 0;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(115294);
        super.onCreate(bundle);
        setContentView(R.layout.bal);
        this.hbb = (TextView) findViewById(R.id.ffo);
        this.HcE = (TextView) findViewById(R.id.ffk);
        this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
        this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
        if (this.type == 0) {
            this.hbb.setText(getString(R.string.i4_));
            this.HcE.setText(getString(R.string.i33));
        } else if (this.type == 1) {
            this.hbb.setText(getString(R.string.i56));
            this.HcE.setText(getString(R.string.i4x));
        }
        findViewById(R.id.ffp).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.InviteRemindDialog.AnonymousClass1 */

            public final void onClick(View view) {
                String string;
                AppMethodBeat.i(115292);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/voip/ui/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (InviteRemindDialog.this.talker != null) {
                    try {
                        Map<String, i.a> aUx = i.a.aUx((String) g.aAh().azQ().get(77829, (Object) null));
                        if (aUx != null) {
                            if (aUx != null && aUx.size() > 0) {
                                if (aUx.containsKey(InviteRemindDialog.this.talker)) {
                                    i.a aVar = aUx.get(InviteRemindDialog.this.talker);
                                    aVar.jgU++;
                                    aUx.put(InviteRemindDialog.this.talker, aVar);
                                } else {
                                    i.a aVar2 = new i.a();
                                    aVar2.jgU++;
                                    aUx.put(InviteRemindDialog.this.talker, aVar2);
                                }
                            }
                            g.aAh().azQ().set(77829, i.a.aV(aUx));
                            for (Map.Entry<String, i.a> entry : aUx.entrySet()) {
                                i.a value = entry.getValue();
                                Log.d("MMInviteRemindDialog", "val " + value.hitCount + " " + value.jgU);
                            }
                        } else {
                            HashMap hashMap = new HashMap();
                            i.a aVar3 = new i.a();
                            aVar3.jgU++;
                            hashMap.put(InviteRemindDialog.this.talker, aVar3);
                            g.aAh().azQ().set(77829, i.a.aV(hashMap));
                            for (Map.Entry entry2 : hashMap.entrySet()) {
                                i.a aVar4 = (i.a) entry2.getValue();
                                Log.d("MMInviteRemindDialog", "val " + aVar4.hitCount + " " + aVar4.jgU);
                            }
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MMInviteRemindDialog", e2, "", new Object[0]);
                    }
                }
                if (InviteRemindDialog.this.type == 0) {
                    string = InviteRemindDialog.this.getString(R.string.i32);
                } else {
                    string = InviteRemindDialog.this.type == 1 ? InviteRemindDialog.this.getString(R.string.i4w) : null;
                }
                g.azz().a(new h(InviteRemindDialog.this.talker, string, ab.JG(InviteRemindDialog.this.talker)), 0);
                Intent intent = new Intent();
                intent.addFlags(536870912);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", InviteRemindDialog.this.talker);
                d.jRt.d(intent, InviteRemindDialog.this);
                InviteRemindDialog.this.finish();
                a.a(this, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(115292);
            }
        });
        findViewById(R.id.ffb).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voip.ui.InviteRemindDialog.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(115293);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/voip/ui/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                InviteRemindDialog.this.finish();
                a.a(this, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(115293);
            }
        });
        AppMethodBeat.o(115294);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(115295);
        super.finish();
        AppMethodBeat.o(115295);
    }

    public static void o(Context context, String str, int i2) {
        AppMethodBeat.i(115296);
        Intent intent = new Intent(context, InviteRemindDialog.class);
        intent.putExtra("InviteRemindDialog_User", str);
        intent.putExtra("InviteRemindDialog_Type", i2);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(context, bl.axQ(), "com/tencent/mm/plugin/voip/ui/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        a.a(context, "com/tencent/mm/plugin/voip/ui/InviteRemindDialog", "show", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(115296);
    }
}
