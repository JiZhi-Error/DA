package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.f;

@i
public class AAEntranceUI extends MMActivity {
    private Button jUs;
    private TextView jUt;
    private TextView jUu;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(63474);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitle("");
        this.jUs = (Button) findViewById(R.id.e8o);
        this.jUt = (TextView) findViewById(R.id.azi);
        this.jUs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAEntranceUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(63471);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/aa/ui/AAEntranceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AAEntranceUI.a(AAEntranceUI.this);
                a.a(this, "com/tencent/mm/plugin/aa/ui/AAEntranceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(63471);
            }
        });
        String string = getString(R.string.b3a);
        f.a(this.jUt, string, 0, string.length(), new e(new e.a() {
            /* class com.tencent.mm.plugin.aa.ui.AAEntranceUI.AnonymousClass2 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(63472);
                Intent intent = new Intent(AAEntranceUI.this.getContext(), AAQueryListUI.class);
                AAEntranceUI aAEntranceUI = AAEntranceUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(aAEntranceUI, bl.axQ(), "com/tencent/mm/plugin/aa/ui/AAEntranceUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                aAEntranceUI.startActivity((Intent) bl.pG(0));
                a.a(aAEntranceUI, "com/tencent/mm/plugin/aa/ui/AAEntranceUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(63472);
            }
        }), getContext());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.aa.ui.AAEntranceUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(63473);
                AAEntranceUI.this.finish();
                AppMethodBeat.o(63473);
                return false;
            }
        });
        this.jUu = (TextView) findViewById(R.id.a9);
        ao.a(this.jUu.getPaint(), 0.8f);
        AppMethodBeat.o(63474);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a6;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(63475);
        if (i3 != -1) {
            AppMethodBeat.o(63475);
            return;
        }
        if (i2 == 1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            Log.i("MicroMsg.AAEntranceUI", "select chatroom：%s", stringExtra);
            if (!Util.isNullOrNil(stringExtra)) {
                Intent intent2 = new Intent(getContext(), LaunchAAUI.class);
                intent2.putExtra("enter_scene", 2);
                intent2.putExtra("chatroom_name", stringExtra);
                if (getIntent().getExtras() != null) {
                    intent2.putExtras(getIntent().getExtras());
                }
                startActivityForResult(intent2, 2);
            }
        } else if (i2 == 2) {
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(63475);
    }

    static /* synthetic */ void a(AAEntranceUI aAEntranceUI) {
        AppMethodBeat.i(63476);
        Log.i("MicroMsg.AAEntranceUI", "go to contact");
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", false);
        intent.putExtra("mutil_select_is_ret", false);
        intent.putExtra("Select_block_List", z.aTY());
        intent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.aa.model.i.bml());
        c.b(aAEntranceUI.getContext(), "remittance", ".ui.SelectRemittanceContactUI", intent, 1);
        AppMethodBeat.o(63476);
    }
}
