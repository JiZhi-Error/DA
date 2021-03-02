package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.b.a.ns;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

@a(3)
public class RecoverAccountUI1 extends MMActivity implements i {
    private q gut;
    private String khC;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(184449);
        super.onCreate(bundle);
        this.khC = getIntent().getStringExtra("key_qrcode_string");
        initView();
        g.azz().a(870, this);
        AppMethodBeat.o(184449);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(184450);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.f3045c));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecoverAccountUI1.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(184446);
                RecoverAccountUI1.this.finish();
                AppMethodBeat.o(184446);
                return true;
            }
        }, R.raw.icons_filled_close);
        ((Button) findViewById(R.id.fz0)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecoverAccountUI1.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(184447);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/RecoverAccountUI1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ns nsVar = new ns();
                nsVar.eqm = 3;
                nsVar.bfK();
                g.azz().a(new y(RecoverAccountUI1.this.khC), 0);
                RecoverAccountUI1.this.gut = h.a((Context) RecoverAccountUI1.this, RecoverAccountUI1.this.getString(R.string.wc), false, (DialogInterface.OnCancelListener) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/RecoverAccountUI1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(184447);
            }
        });
        AppMethodBeat.o(184450);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(184451);
        super.onDestroy();
        g.azz().b(870, this);
        AppMethodBeat.o(184451);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.blz;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(final int i2, final int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        AppMethodBeat.i(184452);
        Log.i("MicroMsg.RecoverAccountUI1", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gut != null) {
            this.gut.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            Intent intent = new Intent();
            intent.putExtra("key_session_id", ((mg) ((y) qVar).hJu.iLL.iLR).session_id);
            intent.putExtra("key_old_username", ((mg) ((y) qVar).hJu.iLL.iLR).KPN);
            startActivity(RecoverFriendUI.class, intent);
            finish();
            AppMethodBeat.o(184452);
            return;
        }
        if (Util.isNullOrNil(str)) {
            str2 = getString(R.string.u5);
        } else {
            str2 = str;
        }
        h.a((Context) this, str2, "", getString(R.string.w0), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.RecoverAccountUI1.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(184448);
                if (i2 == 4) {
                    ns nsVar = new ns();
                    nsVar.eqm = 2;
                    nsVar.fiv = i3;
                    nsVar.bfK();
                    RecoverAccountUI1.this.finish();
                    AppMethodBeat.o(184448);
                    return;
                }
                ns nsVar2 = new ns();
                nsVar2.eqm = 2;
                nsVar2.fiv = 1;
                nsVar2.bfK();
                AppMethodBeat.o(184448);
            }
        });
        AppMethodBeat.o(184452);
    }
}
