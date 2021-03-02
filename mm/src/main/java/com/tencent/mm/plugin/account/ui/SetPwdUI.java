package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;

public abstract class SetPwdUI extends MMActivity implements i {
    protected ProgressDialog gtM = null;
    protected String ksb;
    protected String ksc;
    public boolean ox = true;

    /* access modifiers changed from: protected */
    public abstract void a(a.EnumC0518a aVar);

    /* access modifiers changed from: protected */
    public abstract q bpx();

    /* access modifiers changed from: protected */
    public abstract String bpy();

    /* access modifiers changed from: protected */
    public abstract String bpz();

    /* access modifiers changed from: protected */
    public abstract boolean o(int i2, int i3, String str);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        g.azz().a(bpA(), this);
        super.onCreate(bundle);
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.SetPwdUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128729);
                SetPwdUI.this.bpG();
                AppMethodBeat.o(128729);
                return true;
            }
        }, null, t.b.GREEN);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.SetPwdUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128730);
                SetPwdUI setPwdUI = SetPwdUI.this;
                if (setPwdUI.bpH() && setPwdUI.ox) {
                    Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                    h.INSTANCE.a(11868, 1);
                }
                setPwdUI.hideVKB();
                setPwdUI.setResult(0);
                setPwdUI.finish();
                AppMethodBeat.o(128730);
                return true;
            }
        });
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        g.azz().b(bpA(), this);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public ProgressDialog a(Context context, String str, String str2, DialogInterface.OnCancelListener onCancelListener) {
        return com.tencent.mm.ui.base.h.a(context, str2, true, onCancelListener);
    }

    /* access modifiers changed from: protected */
    public int bpA() {
        return 383;
    }

    /* access modifiers changed from: protected */
    public final void bpV() {
        this.ksb = bpy();
        this.ksc = bpz();
        if (!Util.isNullOrNil(this.ksb)) {
            if (!this.ksb.equals(this.ksc)) {
                a(a.EnumC0518a.TwoPasswordsNotMatch);
            } else if (this.ksb.length() > 16) {
                a(a.EnumC0518a.BeyondMaximumLength);
            } else if (Util.isChinese(this.ksb)) {
                com.tencent.mm.ui.base.h.n(this, R.string.fyn, R.string.fzn);
            } else if (Util.isValidPassword(this.ksb)) {
                hideVKB();
                final q bpx = bpx();
                g.azz().a(bpx, 0);
                this.gtM = a(this, getString(R.string.zb), getString(R.string.fxo), new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.ui.SetPwdUI.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(128728);
                        g.azz().a(bpx);
                        AppMethodBeat.o(128728);
                    }
                });
                if (bpH() && !this.ox) {
                    Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
                    h.INSTANCE.a(11868, 0);
                }
            } else if (this.ksb.length() < 8 || this.ksb.length() >= 16) {
                a(a.EnumC0518a.NotReachMinimumLength);
            } else {
                a(a.EnumC0518a.DisallowShortNumericPassword);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void bpG() {
        bpV();
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(final int i2, final int i3, final String str, q qVar) {
        String string;
        dwn dwn;
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar.getType() == bpA()) {
            if (qVar.getType() == 383) {
                if (i2 == 0 && i3 == 0) {
                    if (Util.isNullOrNil((String) g.aAh().azQ().get(6, (Object) null))) {
                        Log.i("MicroMsg.SetPwdUI", "has not bind mobile");
                        string = getString(R.string.fdu);
                    } else {
                        Log.i("MicroMsg.SetPwdUI", "has bind mobile");
                        string = getString(R.string.afl);
                    }
                    aa aaVar = (aa) qVar;
                    if (aaVar.rr == null || aaVar.rr.iLL.iLR == null) {
                        dwn = null;
                    } else {
                        dwn = (dwn) aaVar.rr.iLL.iLR;
                    }
                    if (!(dwn == null || dwn.KKZ == null)) {
                        byte[] byteArray = dwn.KKZ.getBuffer().toByteArray();
                        SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.aps()).edit();
                        edit.putBoolean("key_auth_info_prefs_created", true);
                        edit.putInt("key_auth_update_version", d.KyO);
                        edit.putString("_auth_key", Util.encodeHexString(byteArray));
                        g.aAf();
                        edit.putInt("_auth_uin", com.tencent.mm.kernel.a.getUin());
                        edit.commit();
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, string, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.SetPwdUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(128731);
                            SetPwdUI.this.setResult(-1);
                            if (SetPwdUI.this.o(i2, i3, str)) {
                                AppMethodBeat.o(128731);
                            } else {
                                AppMethodBeat.o(128731);
                            }
                        }
                    });
                }
            } else if (!o(i2, i3, str)) {
                Toast.makeText(this, getString(R.string.dg_, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean n(int i2, int i3, String str) {
        if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), i2, i3, str)) {
            return true;
        }
        return false;
    }

    public boolean bpH() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        if (this.ox) {
            if (bpH()) {
                Log.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                h.INSTANCE.a(11868, 1);
            }
            super.onBackPressed();
        }
    }
}
