package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.recovery.wx.util.WXUtil;

@Deprecated
public class RegByMobileSetNickUI extends MMActivity implements i {
    private String dSf;
    private ProgressDialog gtM = null;
    private EditText kqA;
    private r kqB = null;
    private boolean kqC;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128595);
        super.onCreate(bundle);
        this.kqC = getIntent().getBooleanExtra("is_sync_addr", false);
        this.dSf = getIntent().getExtras().getString("bindmcontact_mobile");
        initView();
        g.azz().a(126, this);
        AppMethodBeat.o(128595);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128596);
        if (this.kqB != null) {
            r rVar = this.kqB;
            u uVar = rVar.kpv;
            uVar.cancel();
            uVar.timer.stopTimer();
            uVar.reset();
            rVar.text = null;
        }
        g.azz().b(126, this);
        super.onDestroy();
        AppMethodBeat.o(128596);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmd;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128597);
        setMMTitle(R.string.fzk);
        this.kqA = (EditText) findViewById(R.id.gzf);
        this.kqA.addTextChangedListener(new MMEditText.c(this.kqA, null, 16));
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128593);
                String trim = RegByMobileSetNickUI.this.kqA.getText().toString().trim();
                if (trim == null || trim.length() <= 0) {
                    h.n(RegByMobileSetNickUI.this, R.string.hvb, R.string.fzn);
                    AppMethodBeat.o(128593);
                } else {
                    RegByMobileSetNickUI.this.hideVKB();
                    final v vVar = new v("", RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_pwd"), trim, 0, "", RegByMobileSetNickUI.this.dSf, RegByMobileSetNickUI.this.getIntent().getExtras().getString("regbymobile_ticket"), 4);
                    g.azz().a(vVar, 0);
                    RegByMobileSetNickUI regByMobileSetNickUI = RegByMobileSetNickUI.this;
                    RegByMobileSetNickUI regByMobileSetNickUI2 = RegByMobileSetNickUI.this;
                    RegByMobileSetNickUI.this.getString(R.string.zb);
                    regByMobileSetNickUI.gtM = h.a((Context) regByMobileSetNickUI2, RegByMobileSetNickUI.this.getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.AnonymousClass1.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(128592);
                            g.azz().a(vVar);
                            AppMethodBeat.o(128592);
                        }
                    });
                    AppMethodBeat.o(128593);
                }
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128594);
                RegByMobileSetNickUI.this.hideVKB();
                RegByMobileSetNickUI.this.finish();
                AppMethodBeat.o(128594);
                return true;
            }
        });
        AppMethodBeat.o(128597);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128598);
        if (i2 == 4) {
            finish();
            AppMethodBeat.o(128598);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128598);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        a Dk;
        int i4;
        int i5;
        AppMethodBeat.i(128599);
        Log.i("MicroMsg.RegByMobileSetNickUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (!Util.isTopActivity(this)) {
            AppMethodBeat.o(128599);
        } else if (i2 == 0 && i3 == 0) {
            int aUc = z.aUc();
            Log.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + aUc + " isSync = " + this.kqC);
            if (this.kqC) {
                i4 = aUc & -131073;
                l.gl(true);
                getApplicationContext();
                com.tencent.mm.platformtools.a.blm();
            } else {
                i4 = aUc | 131072;
            }
            Log.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = ".concat(String.valueOf(i4)));
            g.aAh().azQ().set(7, Integer.valueOf(i4));
            if (!this.kqC) {
                i5 = 1;
            } else {
                i5 = 2;
            }
            bfx bfx = new bfx();
            bfx.LPB = 17;
            bfx.BsD = i5;
            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, bfx));
            com.tencent.mm.plugin.account.a.a.jRu.WZ();
            bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, this.dSf);
            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
            bZ.putExtra("LauncherUI.enter_from_reg", true);
            bZ.addFlags(67108864);
            if (((v) qVar).jkr) {
                MMWizardActivity.b(this, new Intent(this, BindQQUI.class).putExtra("bindqq_regbymobile", 1), bZ);
                AppMethodBeat.o(128599);
                return;
            }
            MMWizardActivity.b(this, new Intent(this, BindFacebookUI.class), bZ);
            AppMethodBeat.o(128599);
        } else if (qVar.getType() != 126 || (Dk = a.Dk(str)) == null) {
            if (!com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), i2, i3, str)) {
                switch (i2) {
                    case 4:
                        if (i3 != -7 && i3 != -10) {
                            if (i3 == -75) {
                                h.n(this, R.string.h0, R.string.fxq);
                                z = true;
                                break;
                            }
                        } else {
                            h.n(this, R.string.fxp, R.string.fxq);
                            z = true;
                            break;
                        }
                        break;
                    default:
                        z = false;
                        break;
                }
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(128599);
                return;
            }
            Toast.makeText(this, getString(R.string.dfy, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(128599);
        } else {
            Dk.a(this, null, null);
            AppMethodBeat.o(128599);
        }
    }
}
