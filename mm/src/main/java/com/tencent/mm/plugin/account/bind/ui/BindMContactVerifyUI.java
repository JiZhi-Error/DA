package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMContactVerifyUI extends MMWizardActivity {
    private String dSf;
    private int fromScene = 0;
    private boolean jZU = false;
    private EditText kbd;
    private TextView kbe;
    private Button kbf;
    private i kbg;
    private SharedPreferences sp;
    private int status;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.i(109919);
        bindMContactVerifyUI.goBack();
        AppMethodBeat.o(109919);
    }

    static /* synthetic */ void f(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.i(109921);
        bindMContactVerifyUI.ala(-1);
        AppMethodBeat.o(109921);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109913);
        super.onCreate(bundle);
        setMMTitle(R.string.ael);
        this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = z.aUc();
        initView();
        AppMethodBeat.o(109913);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109914);
        super.onDestroy();
        AppMethodBeat.o(109914);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j5;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109915);
        this.dSf = (String) g.aAh().azQ().get(4097, (Object) null);
        this.kbd = (EditText) findViewById(R.id.a4e);
        this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        Button button = (Button) findViewById(R.id.a4b);
        if (this.dSf == null || this.dSf.equals("")) {
            this.dSf = (String) g.aAh().azQ().get(6, (Object) null);
        }
        this.kbd.setFilters(new InputFilter[]{new InputFilter() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.AnonymousClass1 */

            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                AppMethodBeat.i(109906);
                CharSequence filterNumber = Util.filterNumber(charSequence);
                AppMethodBeat.o(109906);
                return filterNumber;
            }
        }});
        this.kbf = (Button) findViewById(R.id.a4g);
        this.kbe = (TextView) findViewById(R.id.a4c);
        this.kbe.setText(getString(R.string.ae8, new Object[]{this.dSf}));
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(109907);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String trim = BindMContactVerifyUI.this.kbd.getText().toString().trim();
                if (Util.isNullOrNil(trim)) {
                    h.n(BindMContactVerifyUI.this, R.string.af_, R.string.zb);
                    a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(109907);
                    return;
                }
                BindMContactVerifyUI.this.hideVKB();
                BindMContactVerifyUI.a(BindMContactVerifyUI.this, trim);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109907);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109908);
                BindMContactVerifyUI.b(BindMContactVerifyUI.this);
                AppMethodBeat.o(109908);
                return true;
            }
        });
        this.kbf.setVisibility(com.tencent.mm.aw.b.Pg(this.dSf) ? 0 : 8);
        this.kbf.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(109909);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMContactVerifyUI.this.hideVKB();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", BindMContactVerifyUI.this.dSf);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.account.a.a.jRt.f(BindMContactVerifyUI.this, intent);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109909);
            }
        });
        AppMethodBeat.o(109915);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(109916);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            goBack();
            AppMethodBeat.o(109916);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(109916);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(109917);
        if (this.kbg != null) {
            this.kbg.recycle();
        }
        ala(1);
        AppMethodBeat.o(109917);
    }

    static /* synthetic */ void a(BindMContactVerifyUI bindMContactVerifyUI, String str) {
        boolean z;
        AppMethodBeat.i(109918);
        i.b bVar = i.b.BINDMOBILE;
        if (bindMContactVerifyUI.fromScene == 3) {
            bVar = i.b.CHANGEMOBILE;
        }
        bindMContactVerifyUI.kbg = new i(bVar, bindMContactVerifyUI, new i.a() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.AnonymousClass5 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.plugin.account.friend.ui.i.a
            public final void h(int i2, Bundle bundle) {
                AppMethodBeat.i(109912);
                if (i2 == 2) {
                    switch (BindMContactVerifyUI.this.fromScene) {
                        case 1:
                            Log.i("MicroMsg.BindMContactVerifyUI", "to startMySafedeviceListUI");
                            if (!z.aUi()) {
                                yo yoVar = new yo();
                                yoVar.eeN.eeO = true;
                                yoVar.eeN.eeP = true;
                                EventCenter.instance.publish(yoVar);
                            }
                            BindMContactVerifyUI.e(BindMContactVerifyUI.this);
                            Intent intent = new Intent();
                            intent.addFlags(67108864);
                            com.tencent.mm.plugin.account.a.a.jRt.e(BindMContactVerifyUI.this, intent);
                            AppMethodBeat.o(109912);
                            return;
                        case 2:
                        default:
                            if (BindMContactVerifyUI.this.jZU) {
                                if (BindMContactVerifyUI.this.fromScene == 2) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 3, 3);
                                } else {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 1, 2);
                                }
                            }
                            if (BindMContactVerifyUI.this.fromScene != 0 || !bundle.getBoolean("restart_wechat", false)) {
                                Intent intent2 = new Intent(BindMContactVerifyUI.this, BindMContactStatusUI.class);
                                intent2.putExtra("WizardRootClass", BindMContactIntroUI.class.getCanonicalName());
                                MMWizardActivity.ay(BindMContactVerifyUI.this, intent2);
                                break;
                            } else {
                                Log.i("MicroMsg.BindMContactVerifyUI", "restart after bind mobile!");
                                h.a((Context) BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(R.string.au4), BindMContactVerifyUI.this.getString(R.string.zb), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.AnonymousClass5.AnonymousClass2 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(109911);
                                        Intent intent = new Intent();
                                        intent.addFlags(67108864);
                                        intent.putExtra("exit_and_restart", true);
                                        com.tencent.mm.plugin.account.a.a.jRt.o(intent, BindMContactVerifyUI.this);
                                        AppMethodBeat.o(109911);
                                    }
                                });
                                AppMethodBeat.o(109912);
                                return;
                            }
                            break;
                        case 3:
                            Log.i("MicroMsg.BindMContactVerifyUI", "to BindMContactStatusUI for change mobile");
                            if (bundle.getBoolean("restart_wechat", false)) {
                                Log.i("MicroMsg.BindMContactVerifyUI", "restart after change mobile!");
                                h.a((Context) BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(R.string.au4), BindMContactVerifyUI.this.getString(R.string.zb), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.AnonymousClass5.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(109910);
                                        Intent intent = new Intent();
                                        intent.addFlags(67108864);
                                        intent.putExtra("exit_and_restart", true);
                                        com.tencent.mm.plugin.account.a.a.jRt.o(intent, BindMContactVerifyUI.this);
                                        AppMethodBeat.o(109910);
                                    }
                                });
                                AppMethodBeat.o(109912);
                                return;
                            }
                            h.cD(BindMContactVerifyUI.this, BindMContactVerifyUI.this.getString(R.string.vl));
                            MMWizardActivity.ay(BindMContactVerifyUI.this, new Intent(BindMContactVerifyUI.this, BindMContactStatusUI.class));
                            AppMethodBeat.o(109912);
                            return;
                        case 4:
                            Log.i("MicroMsg.BindMContactVerifyUI", "to RegByMobileSetPwdUI for reset pwd");
                            BindMContactVerifyUI.this.finish();
                            Intent intent3 = new Intent();
                            intent3.addFlags(603979776);
                            intent3.putExtra("setpwd_ticket", bundle.getString("setpwd_ticket", ""));
                            c.b(BindMContactVerifyUI.this, "account", ".ui.RegByMobileSetPwdUI", intent3);
                            AppMethodBeat.o(109912);
                            return;
                        case 5:
                            Log.i("MicroMsg.BindMContactVerifyUI", "to finish  finishWizard for get phone number");
                            BindMContactVerifyUI.f(BindMContactVerifyUI.this);
                            AppMethodBeat.o(109912);
                            return;
                    }
                }
                AppMethodBeat.o(109912);
            }
        });
        i iVar = bindMContactVerifyUI.kbg;
        if (bindMContactVerifyUI.fromScene == 0 || bindMContactVerifyUI.fromScene == 3) {
            z = true;
        } else {
            z = false;
        }
        iVar.khR = z;
        i iVar2 = bindMContactVerifyUI.kbg;
        if (iVar2.tipDialog != null) {
            iVar2.tipDialog.setCancelable(true);
        }
        if (iVar2.khS == i.b.BINDMOBILE || iVar2.khS == i.b.CHANGEMOBILE) {
            g.azz().a(132, iVar2);
            ka kaVar = new ka();
            kaVar.dOV.context = iVar2.mContext;
            EventCenter.instance.publish(kaVar);
            String str2 = kaVar.dOW.dOX;
            kb kbVar = new kb();
            EventCenter.instance.publish(kbVar);
            String str3 = kbVar.dOY.dOZ;
            int i2 = 2;
            if (iVar2.khS == i.b.CHANGEMOBILE) {
                i2 = 19;
            }
            iVar2.ifz = false;
            iVar2.khP = new com.tencent.mm.plugin.account.friend.a.z(iVar2.dSf, i2, str, "", str2, str3);
            g.azz().a(iVar2.khP, 0);
            if (iVar2.tipDialog != null) {
                iVar2.tipDialog.dismiss();
            }
            iVar2.tipDialog = h.a(iVar2.mContext, iVar2.mContext.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.friend.ui.i.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    i.this.ifz = true;
                }
            });
        }
        AppMethodBeat.o(109918);
    }

    static /* synthetic */ void e(BindMContactVerifyUI bindMContactVerifyUI) {
        AppMethodBeat.i(109920);
        bindMContactVerifyUI.ala(1);
        AppMethodBeat.o(109920);
    }
}
