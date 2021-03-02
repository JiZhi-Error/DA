package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.recovery.wx.util.WXUtil;

public class RegByQQAuthUI extends MMActivity implements i {
    private String account;
    private String dHx;
    private String dWp;
    private ProgressDialog gtM = null;
    private String kdq;
    private EditText krm = null;
    private int krn;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmf;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128662);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(128662);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128663);
        super.onDestroy();
        AppMethodBeat.o(128663);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128664);
        super.onResume();
        g.azz().a(126, this);
        AppMethodBeat.o(128664);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128665);
        super.onPause();
        g.azz().b(126, this);
        AppMethodBeat.o(128665);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128666);
        this.krn = getIntent().getIntExtra("RegByQQ_BindUin", 0);
        this.kdq = getIntent().getStringExtra("RegByQQ_RawPsw");
        this.account = getIntent().getStringExtra("RegByQQ_Account");
        this.dHx = getIntent().getStringExtra("RegByQQ_Ticket");
        this.dWp = getIntent().getStringExtra("RegByQQ_Nick");
        Log.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.krn + "  pass:" + this.kdq + "  ticket:" + this.dHx);
        this.krm = (EditText) findViewById(R.id.fz7);
        if (this.dWp != null && !this.dWp.equals("")) {
            this.krm.setText(this.dWp);
        }
        setMMTitle(R.string.g0f);
        addTextOptionMenu(0, getString(R.string.x5), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByQQAuthUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128660);
                RegByQQAuthUI.this.dWp = RegByQQAuthUI.this.krm.getText().toString().trim();
                if (RegByQQAuthUI.this.dWp.equals("")) {
                    h.n(RegByQQAuthUI.this, R.string.hvb, R.string.u3);
                    AppMethodBeat.o(128660);
                } else {
                    final v vVar = new v("", RegByQQAuthUI.this.kdq, RegByQQAuthUI.this.dWp, RegByQQAuthUI.this.krn, "", "", RegByQQAuthUI.this.dHx, 2);
                    g.azz().a(vVar, 0);
                    RegByQQAuthUI regByQQAuthUI = RegByQQAuthUI.this;
                    RegByQQAuthUI regByQQAuthUI2 = RegByQQAuthUI.this;
                    RegByQQAuthUI.this.getString(R.string.zb);
                    regByQQAuthUI.gtM = h.a((Context) regByQQAuthUI2, RegByQQAuthUI.this.getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByQQAuthUI.AnonymousClass1.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(128659);
                            g.azz().a(vVar);
                            AppMethodBeat.o(128659);
                        }
                    });
                    AppMethodBeat.o(128660);
                }
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByQQAuthUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128661);
                RegByQQAuthUI.this.hideVKB();
                RegByQQAuthUI.this.finish();
                AppMethodBeat.o(128661);
                return true;
            }
        });
        AppMethodBeat.o(128666);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        a Dk;
        AppMethodBeat.i(128667);
        Log.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (!Util.isTopActivity(this)) {
            AppMethodBeat.o(128667);
        } else if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 126:
                    com.tencent.mm.kernel.a.unhold();
                    bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, this.account);
                    Intent intent = new Intent(this, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 1);
                    intent.putExtra("skip", true);
                    Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
                    bZ.addFlags(67108864);
                    bZ.putExtra("LauncherUI.enter_from_reg", true);
                    MMWizardActivity.b(this, intent, bZ);
                    break;
            }
            AppMethodBeat.o(128667);
        } else if (qVar.getType() != 126 || (Dk = a.Dk(str)) == null) {
            if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), i2, i3, str)) {
                z = true;
            } else {
                if (i2 == 4) {
                    switch (i3) {
                        case -75:
                            h.n(getContext(), R.string.h0, R.string.zb);
                            z = true;
                            break;
                        case -72:
                            h.n(getContext(), R.string.g0b, R.string.zb);
                            z = true;
                            break;
                        case -12:
                            h.n(this, R.string.g0e, R.string.g0d);
                            z = true;
                            break;
                        case -11:
                            h.n(this, R.string.g0c, R.string.g0d);
                            z = true;
                            break;
                        case -4:
                            h.n(this, R.string.u1, R.string.g0d);
                            z = true;
                            break;
                        case -1:
                            if (g.azz().aYS() == 5) {
                                h.n(this, R.string.fbf, R.string.fbe);
                                z = true;
                                break;
                            }
                        case -3:
                            h.n(this, R.string.u2, R.string.g0d);
                            z = true;
                            break;
                    }
                }
                z = false;
            }
            if (z) {
                AppMethodBeat.o(128667);
                return;
            }
            Toast.makeText(this, getString(R.string.dfy, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(128667);
        } else {
            Dk.a(this, null, null);
            AppMethodBeat.o(128667);
        }
    }
}
