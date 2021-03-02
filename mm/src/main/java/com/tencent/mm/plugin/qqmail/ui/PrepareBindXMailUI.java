package com.tencent.mm.plugin.qqmail.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.qqmail.d.p;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class PrepareBindXMailUI extends MMActivity implements i {
    private TextView BwI;
    private Button BwJ;
    private TextView BwK;
    private String BwL;
    private String BwM;
    private String BwN;
    private ImageView gyr;
    private TextView kaq;
    private ProgressDialog klA;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(PrepareBindXMailUI prepareBindXMailUI, String str, String str2, String str3) {
        AppMethodBeat.i(198737);
        prepareBindXMailUI.aC(str, str2, str3);
        AppMethodBeat.o(198737);
    }

    static /* synthetic */ void a(PrepareBindXMailUI prepareBindXMailUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(198736);
        prepareBindXMailUI.y(str, str2, str3, str4);
        AppMethodBeat.o(198736);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(198728);
        super.onCreate(bundle);
        this.BwL = getIntent().getStringExtra("Key_WeXin_Mail");
        this.BwN = getIntent().getStringExtra("Key_QQMail_Login_Url");
        this.BwM = getIntent().getStringExtra("Key_Last_Bind_Mail");
        Log.i("MicroMsg.PrepareBindXMailUI", "wxMail %s, loginQQ %s, lastBindMail %s", this.BwL, this.BwN, this.BwM);
        initView();
        g.azz().a(586, this);
        AppMethodBeat.o(198728);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(198729);
        setMMTitle("");
        showMMLogo();
        getSupportActionBar().hide();
        getController().p(this, getContext().getResources().getColor(R.color.afz));
        this.gyr = (ImageView) findViewById(R.id.x1);
        this.BwI = (TextView) findViewById(R.id.jrf);
        this.BwJ = (Button) findViewById(R.id.a4x);
        this.kaq = (TextView) findViewById(R.id.aib);
        this.BwK = (TextView) findViewById(R.id.a4l);
        if (Util.isNullOrNil(this.BwL)) {
            this.BwJ.setEnabled(false);
        } else {
            this.BwI.setText(this.BwL);
        }
        this.BwJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(198722);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (Util.isNullOrNil(PrepareBindXMailUI.this.BwM) || PrepareBindXMailUI.this.BwM.equals(PrepareBindXMailUI.this.BwL)) {
                    PrepareBindXMailUI.c(PrepareBindXMailUI.this);
                } else {
                    h.a(PrepareBindXMailUI.this, PrepareBindXMailUI.this.getString(R.string.be4), "", new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(198721);
                            PrepareBindXMailUI.c(PrepareBindXMailUI.this);
                            AppMethodBeat.o(198721);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198722);
            }
        });
        this.kaq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(198723);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                PrepareBindXMailUI.this.onBackPressed();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198723);
            }
        });
        this.BwK.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(198724);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", PrepareBindXMailUI.this.BwN);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                c.b(PrepareBindXMailUI.this, "webview", ".ui.tools.WebViewUI", intent, (int) com.tencent.mm.plugin.appbrand.jsapi.audio.h.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198724);
            }
        });
        com.tencent.mm.ui.g.a.a.c(this.gyr, z.aTY());
        AppMethodBeat.o(198729);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bim;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(198730);
        Log.i("MicroMsg.PrepareBindXMailUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.klA != null) {
            this.klA.dismiss();
        }
        int eGo = ((p) qVar).eGo();
        if (i2 == 0 && i3 == 0 && eGo == 0) {
            Toast.makeText(this, getString(R.string.gpz), 0).show();
            Intent intent = new Intent();
            intent.putExtra("Key_Bind_XMail", ((p) qVar).BrO);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(198730);
        } else if (eGo == -39006) {
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.frf);
            }
            Toast.makeText(this, str, 0).show();
            aC(((p) qVar).BrO, ((p) qVar).dHx, ((p) qVar).BrP);
            AppMethodBeat.o(198730);
        } else {
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.gpy);
            }
            Toast.makeText(this, str, 1).show();
            AppMethodBeat.o(198730);
        }
    }

    private void y(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(198731);
        g.azz().a(new p(3, str, str2, str3, str4), 0);
        this.klA = h.a((Context) this, getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(198731);
    }

    private void aC(final String str, final String str2, final String str3) {
        AppMethodBeat.i(198732);
        View inflate = View.inflate(this, R.layout.bp6, null);
        final EditText editText = (EditText) inflate.findViewById(R.id.hfq);
        h.a(this, getString(R.string.be6), inflate, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(198725);
                if (editText.getText() != null && !Util.isNullOrNil(editText.getText())) {
                    PrepareBindXMailUI.a(PrepareBindXMailUI.this, str, str2, str3, editText.getText().toString());
                }
                AppMethodBeat.o(198725);
            }
        });
        AppMethodBeat.o(198732);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(198733);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 293) {
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle != null) {
                final String string = bundle.getString("key_qq_mail");
                final String string2 = bundle.getString("key_bind_ticket");
                boolean z = bundle.getBoolean("key_need_second_pwd", false);
                final String string3 = bundle.getString("key_second_pwd_key");
                Log.i("MicroMsg.PrepareBindXMailUI", "mail %s, ticket %s, needSecondPwd %s, secPwdKey %s", string, string2, Boolean.valueOf(z), string3);
                if (!Util.isNullOrNil(string, string2)) {
                    if (z) {
                        if (Util.isNullOrNil(string3)) {
                            Toast.makeText(this, getString(R.string.gpy), 1).show();
                            AppMethodBeat.o(198733);
                            return;
                        } else if (Util.isNullOrNil(this.BwM) || this.BwM.equals(string)) {
                            aC(string, string2, string3);
                            AppMethodBeat.o(198733);
                            return;
                        } else {
                            h.a(this, getString(R.string.be4), "", new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.AnonymousClass5 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(198726);
                                    PrepareBindXMailUI.a(PrepareBindXMailUI.this, string, string2, string3);
                                    AppMethodBeat.o(198726);
                                }
                            }, (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(198733);
                            return;
                        }
                    } else if (Util.isNullOrNil(this.BwM) || this.BwM.equals(string)) {
                        y(string, string2, "", "");
                    } else {
                        h.a(this, getString(R.string.be4), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.AnonymousClass6 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(198727);
                                PrepareBindXMailUI.a(PrepareBindXMailUI.this, string, string2, "", "");
                                AppMethodBeat.o(198727);
                            }
                        }, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(198733);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(198733);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(198734);
        super.onDestroy();
        g.azz().b(586, this);
        AppMethodBeat.o(198734);
    }

    static /* synthetic */ void c(PrepareBindXMailUI prepareBindXMailUI) {
        AppMethodBeat.i(198735);
        g.azz().a(new p(2, prepareBindXMailUI.BwL, "", "", ""), 0);
        prepareBindXMailUI.klA = h.a((Context) prepareBindXMailUI, prepareBindXMailUI.getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(198735);
    }
}
