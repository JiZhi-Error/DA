package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.aw.b;
import com.tencent.mm.g.a.ka;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI extends MMWizardActivity implements i {
    private String dSf;
    private int fromScene;
    private TextView kbG;
    private TextView kbH;
    private Integer kbI = 15;
    private EditText kbd;
    private Button kbf;
    private BindWordingContent kbp;
    private int kbq;
    private boolean kbr;
    private boolean kbs;
    private Timer mTimer;
    private q tipDialog = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BindMobileVerifyUI() {
        AppMethodBeat.i(109961);
        AppMethodBeat.o(109961);
    }

    static /* synthetic */ void f(BindMobileVerifyUI bindMobileVerifyUI) {
        AppMethodBeat.i(109970);
        bindMobileVerifyUI.bnp();
        AppMethodBeat.o(109970);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109962);
        super.onCreate(bundle);
        g.azz().a(132, this);
        setMMTitle(R.string.ael);
        this.kbp = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.kbq = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.kbr = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.kbs = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        initView();
        AppMethodBeat.o(109962);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109963);
        g.azz().b(132, this);
        super.onDestroy();
        AppMethodBeat.o(109963);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(109964);
        bnp();
        super.onStop();
        AppMethodBeat.o(109964);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j5;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109965);
        this.dSf = (String) g.aAh().azQ().get(4097, (Object) null);
        this.kbd = (EditText) findViewById(R.id.a4e);
        this.kbG = (TextView) findViewById(R.id.a4d);
        this.kbH = (TextView) findViewById(R.id.a49);
        Button button = (Button) findViewById(R.id.a4b);
        if (this.dSf == null || this.dSf.equals("")) {
            this.dSf = (String) g.aAh().azQ().get(6, (Object) null);
        }
        if (this.dSf != null && this.dSf.length() > 0) {
            this.kbG.setVisibility(0);
            this.kbG.setText(this.dSf);
        }
        this.kbd.setFilters(new InputFilter[]{new InputFilter() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.AnonymousClass1 */

            public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                AppMethodBeat.i(109954);
                CharSequence filterNumber = Util.filterNumber(charSequence);
                AppMethodBeat.o(109954);
                return filterNumber;
            }
        }});
        this.kbf = (Button) findViewById(R.id.a4g);
        button.setVisibility(8);
        this.kbH.setText(getResources().getQuantityString(R.plurals.v, this.kbI.intValue(), this.kbI));
        if (this.mTimer == null) {
            this.mTimer = new Timer();
            AnonymousClass5 r1 = new TimerTask() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(109959);
                    if (BindMobileVerifyUI.this.kbH != null) {
                        BindMobileVerifyUI.d(BindMobileVerifyUI.this);
                    }
                    AppMethodBeat.o(109959);
                }
            };
            if (this.mTimer != null) {
                this.mTimer.schedule(r1, 1000, 1000);
            }
        }
        addTextOptionMenu(0, getString(R.string.x5), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109956);
                String trim = BindMobileVerifyUI.this.kbd.getText().toString().trim();
                if (trim.equals("")) {
                    h.n(BindMobileVerifyUI.this, R.string.af_, R.string.zb);
                    AppMethodBeat.o(109956);
                } else {
                    BindMobileVerifyUI.this.hideVKB();
                    ka kaVar = new ka();
                    kaVar.dOV.context = BindMobileVerifyUI.this;
                    EventCenter.instance.publish(kaVar);
                    String str = kaVar.dOW.dOX;
                    kb kbVar = new kb();
                    EventCenter.instance.publish(kbVar);
                    final z zVar = new z(BindMobileVerifyUI.this.dSf, 2, trim, "", str, kbVar.dOY.dOZ);
                    g.azz().a(zVar, 0);
                    BindMobileVerifyUI bindMobileVerifyUI = BindMobileVerifyUI.this;
                    BindMobileVerifyUI bindMobileVerifyUI2 = BindMobileVerifyUI.this;
                    BindMobileVerifyUI.this.getString(R.string.zb);
                    bindMobileVerifyUI.tipDialog = h.a((Context) bindMobileVerifyUI2, BindMobileVerifyUI.this.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.AnonymousClass2.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(109955);
                            g.azz().a(zVar);
                            AppMethodBeat.o(109955);
                        }
                    });
                    AppMethodBeat.o(109956);
                }
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109957);
                BindMobileVerifyUI.this.finish();
                AppMethodBeat.o(109957);
                return true;
            }
        });
        this.kbf.setVisibility(b.Pg(this.dSf) ? 0 : 8);
        this.kbf.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(109958);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMobileVerifyUI.this.hideVKB();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("bindmcontact_mobile", BindMobileVerifyUI.this.dSf);
                bundle.putInt("voice_verify_type", 4);
                intent.putExtras(bundle);
                com.tencent.mm.plugin.account.a.a.jRt.f(BindMobileVerifyUI.this, intent);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109958);
            }
        });
        AppMethodBeat.o(109965);
    }

    private void bnp() {
        AppMethodBeat.i(109966);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        AppMethodBeat.o(109966);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(109967);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ala(1);
            AppMethodBeat.o(109967);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(109967);
        return onKeyDown;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(109968);
        Log.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (((z) qVar).Vj() != 2) {
            AppMethodBeat.o(109968);
            return;
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i2 == 0 && i3 == 0) {
            if (((z) qVar).Vj() == 2) {
                switch (this.fromScene) {
                    case 1:
                        if (!com.tencent.mm.model.z.aUi()) {
                            yo yoVar = new yo();
                            yoVar.eeN.eeO = true;
                            yoVar.eeN.eeP = true;
                            EventCenter.instance.publish(yoVar);
                        }
                        ala(1);
                        Intent intent = new Intent();
                        intent.addFlags(67108864);
                        com.tencent.mm.plugin.account.a.a.jRt.e(this, intent);
                        AppMethodBeat.o(109968);
                        return;
                    case 6:
                        if (!this.kbr) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (this.kbs) {
                            z3 = false;
                        }
                        BindMobileStatusUI.c(this, z2, z3);
                        exit(-1);
                        AppMethodBeat.o(109968);
                        return;
                    default:
                        if (this.fromScene == 0 || this.fromScene == 3) {
                            ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                        }
                        Intent intent2 = new Intent(this, BindMobileStatusUI.class);
                        intent2.putExtra("kstyle_bind_wording", this.kbp);
                        intent2.putExtra("kstyle_bind_recommend_show", this.kbq);
                        intent2.putExtra("Kfind_friend_by_mobile_flag", this.kbr);
                        intent2.putExtra("Krecom_friends_by_mobile_flag", this.kbs);
                        intent2.putExtra("bind_scene", this.fromScene);
                        ay(this, intent2);
                        break;
                }
            }
            AppMethodBeat.o(109968);
            return;
        }
        if (!com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
            switch (i3) {
                case -214:
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Dk.a(this, null, null);
                    }
                    z = true;
                    break;
                case APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException:
                    Toast.makeText(this, (int) R.string.adr, 0).show();
                    z = true;
                    break;
                case APPluginConstants.ERROR_IO_SSLException_SSLHandshakeException:
                    Toast.makeText(this, (int) R.string.adt, 0).show();
                    z = true;
                    break;
                case APPluginConstants.ERROR_IO_ObjectStreamException_NotSerializableException:
                    Toast.makeText(this, (int) R.string.adw, 0).show();
                    z = true;
                    break;
                case APPluginConstants.ERROR_IO_ObjectStreamException_NotActiveException:
                    Toast.makeText(this, (int) R.string.ads, 0).show();
                    z = true;
                    break;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                    Toast.makeText(this, (int) R.string.adu, 0).show();
                    z = true;
                    break;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidClassException:
                    h.a(this, (int) R.string.af3, (int) R.string.af9, (DialogInterface.OnClickListener) null);
                    z = true;
                    break;
                case APPluginConstants.ERROR_IO_NoHttpResponseException:
                    h.a(this, (int) R.string.af4, (int) R.string.af9, (DialogInterface.OnClickListener) null);
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(109968);
            return;
        }
        Toast.makeText(this, getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        AppMethodBeat.o(109968);
    }

    static /* synthetic */ void d(BindMobileVerifyUI bindMobileVerifyUI) {
        AppMethodBeat.i(109969);
        bindMobileVerifyUI.kbH.post(new Runnable() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(109960);
                Integer unused = BindMobileVerifyUI.this.kbI;
                BindMobileVerifyUI.this.kbI = Integer.valueOf(BindMobileVerifyUI.this.kbI.intValue() - 1);
                if (BindMobileVerifyUI.this.kbI.intValue() > 0) {
                    BindMobileVerifyUI.this.kbH.setText(BindMobileVerifyUI.this.getResources().getQuantityString(R.plurals.v, BindMobileVerifyUI.this.kbI.intValue(), BindMobileVerifyUI.this.kbI));
                    AppMethodBeat.o(109960);
                    return;
                }
                BindMobileVerifyUI.this.kbH.setText(BindMobileVerifyUI.this.getResources().getQuantityString(R.plurals.v, 0, 0));
                BindMobileVerifyUI.f(BindMobileVerifyUI.this);
                AppMethodBeat.o(109960);
            }
        });
        AppMethodBeat.o(109969);
    }
}
