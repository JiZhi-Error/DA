package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.cc.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.appbrand.jsapi.audio.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.tav.core.ExportErrorStatus;
import java.util.Map;

public class RegByEmailUI extends MMActivity implements i {
    private static String[] kpB;
    private String fuD;
    private ProgressDialog gtM = null;
    private String kbV;
    private String kdq;
    private Map<String, String> kpA;
    private MMAutoCompleteTextView kpw;
    private EditText kpx;
    private CheckBox kpy;
    private String kpz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(RegByEmailUI regByEmailUI) {
        AppMethodBeat.i(128494);
        regByEmailUI.goBack();
        AppMethodBeat.o(128494);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128485);
        super.onCreate(bundle);
        String string = getString(R.string.fy_);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            string = getString(R.string.wx) + h.jr(this);
        }
        setMMTitle(string);
        a.jRu.Xc();
        this.kpz = t.dy(this);
        Log.i("MicroMsg.RegByEmailUI", "get google account:[%s]", this.kpz);
        this.kpA = com.tencent.mm.platformtools.i.jMH.dq(this);
        if (this.kpA != null && !this.kpA.isEmpty()) {
            kpB = new String[this.kpA.size()];
            this.kpA.keySet().toArray(kpB);
        }
        this.kbV = com.tencent.mm.plugin.b.a.caK();
        initView();
        AppMethodBeat.o(128485);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128486);
        super.onResume();
        g.azz().a(n.CTRL_INDEX, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R500_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("R500_100");
        AppMethodBeat.o(128486);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(128487);
        super.onPause();
        g.azz().b(n.CTRL_INDEX, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R500_100")).append(",2").toString());
        AppMethodBeat.o(128487);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bm8;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128488);
        this.kpw = (MMAutoCompleteTextView) findViewById(R.id.gyx);
        this.kpx = (EditText) findViewById(R.id.gz4);
        this.kpy = (CheckBox) findViewById(R.id.i_);
        if (!Util.isNullOrNil(this.kpz)) {
            this.kpx.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(128473);
                    RegByEmailUI.this.kpx.requestFocus();
                    AppMethodBeat.o(128473);
                }
            }, 500);
            this.kpw.setText(this.kpz);
        }
        if (kpB != null) {
            d dVar = new d(this, kpB, "@");
            this.kpw.setSpilter("@");
            this.kpw.setDropDownAnchor(R.id.gyy);
            this.kpw.setDropDownVerticalOffset(this.kpw.getPaddingBottom());
            this.kpw.setAdapter(dVar);
        }
        findViewById(R.id.i9).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(128477);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByEmailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Util.jump(RegByEmailUI.this, RegByEmailUI.this.getString(R.string.htp, new Object[]{LocaleUtil.getApplicationLanguage(), LocaleUtil.getCurrentCountryCode()}));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByEmailUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128477);
            }
        });
        this.kpy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass6 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(128478);
                RegByEmailUI.b(RegByEmailUI.this);
                AppMethodBeat.o(128478);
            }
        });
        addTextOptionMenu(0, getString(R.string.x5), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128479);
                RegByEmailUI.c(RegByEmailUI.this);
                AppMethodBeat.o(128479);
                return true;
            }
        });
        enableOptionMenu(false);
        this.kpw.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass8 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128480);
                RegByEmailUI.b(RegByEmailUI.this);
                AppMethodBeat.o(128480);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.kpx.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass9 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128481);
                RegByEmailUI.b(RegByEmailUI.this);
                AppMethodBeat.o(128481);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.kpx.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass10 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128482);
                if (i2 != 6 && i2 != 5) {
                    AppMethodBeat.o(128482);
                    return false;
                } else if (!RegByEmailUI.this.kpy.isChecked()) {
                    AppMethodBeat.o(128482);
                    return false;
                } else {
                    RegByEmailUI.c(RegByEmailUI.this);
                    AppMethodBeat.o(128482);
                    return true;
                }
            }
        });
        this.kpx.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass11 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128483);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByEmailUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 != i2 || keyEvent.getAction() != 0) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/RegByEmailUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128483);
                    return false;
                } else if (!RegByEmailUI.this.kpy.isChecked()) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/RegByEmailUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128483);
                    return false;
                } else {
                    RegByEmailUI.c(RegByEmailUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/account/ui/RegByEmailUI$8", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128483);
                    return true;
                }
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass12 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128484);
                RegByEmailUI.e(RegByEmailUI.this);
                AppMethodBeat.o(128484);
                return true;
            }
        });
        AppMethodBeat.o(128488);
    }

    private void goBack() {
        AppMethodBeat.i(128489);
        com.tencent.mm.ui.base.h.a(this, (int) R.string.fxu, (int) R.string.fxx, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(128474);
                com.tencent.mm.plugin.b.a.bxl(RegByEmailUI.this.kbV);
                RegByEmailUI.this.hideVKB();
                RegByEmailUI.this.finish();
                AppMethodBeat.o(128474);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(128489);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128490);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(128490);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128490);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        Map<String, String> parseXml;
        String[] split;
        AppMethodBeat.i(128491);
        Log.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar.getType() != 481) {
            Log.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", Integer.valueOf(qVar.getType()));
            AppMethodBeat.o(128491);
        } else if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.b.a.bxl("R500_200");
            Intent intent = new Intent(this, EmailVerifyUI.class);
            intent.putExtra("email_address", this.fuD);
            intent.putExtra("password", this.kdq);
            if (this.kpA != null && !this.kpA.isEmpty() && (split = this.fuD.split("@")) != null && split.length == 2) {
                intent.putExtra("email_login_page", this.kpA.get(split[1]));
            }
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByEmailUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByEmailUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128491);
        } else {
            if (!a.jRu.a(this, i2, i3, str)) {
                switch (i3) {
                    case ExportErrorStatus.APPEND_VIDEO_SAMPLE_MAKE_CURRENT /*{ENCODED_INT: -111}*/:
                        com.tencent.mm.ui.base.h.n(this, R.string.fy0, R.string.fxx);
                        z = true;
                        break;
                    case -75:
                        com.tencent.mm.ui.base.h.n(this, R.string.h0, R.string.fxq);
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                        Toast.makeText(this, (int) R.string.fxv, 0).show();
                        z = true;
                        break;
                    case -7:
                        StringBuilder sb = new StringBuilder();
                        g.aAf();
                        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R20_email_duplicate_confirm,");
                        g.aAf();
                        com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R20_email_duplicate_confirm")).append(",3").toString());
                        com.tencent.mm.ui.base.h.a(this, (int) R.string.fya, (int) R.string.fxx, (int) R.string.fyc, (int) R.string.fyb, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128476);
                                RegByEmailUI.this.finish();
                                com.tencent.mm.plugin.b.a.bxl("L2_signup");
                                Intent intent = new Intent(RegByEmailUI.this, LoginPasswordUI.class);
                                intent.putExtra("email_address", RegByEmailUI.this.fuD);
                                RegByEmailUI regByEmailUI = RegByEmailUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(regByEmailUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegByEmailUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                regByEmailUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(regByEmailUI, "com/tencent/mm/plugin/account/ui/RegByEmailUI$12", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(128476);
                            }
                        }, (DialogInterface.OnClickListener) null);
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
                AppMethodBeat.o(128491);
                return;
            }
            if (!Util.isNullOrNil(str) && (parseXml = XmlParser.parseXml(str, "e", null)) != null && parseXml.size() > 0) {
                String str2 = parseXml.get(".e.Content");
                if (!Util.isNullOrNil(str2)) {
                    com.tencent.mm.ui.base.h.c(this, str2, getString(R.string.fxx), true);
                    AppMethodBeat.o(128491);
                    return;
                }
            }
            Toast.makeText(this, getString(R.string.fy8, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(128491);
        }
    }

    static /* synthetic */ void b(RegByEmailUI regByEmailUI) {
        AppMethodBeat.i(128492);
        if (Util.isNullOrNil(regByEmailUI.kpw.getText().toString().trim()) || Util.isNullOrNil(regByEmailUI.kpx.getText().toString().trim()) || !regByEmailUI.kpy.isChecked()) {
            regByEmailUI.enableOptionMenu(false);
            AppMethodBeat.o(128492);
            return;
        }
        regByEmailUI.enableOptionMenu(true);
        AppMethodBeat.o(128492);
    }

    static /* synthetic */ void c(RegByEmailUI regByEmailUI) {
        AppMethodBeat.i(128493);
        regByEmailUI.fuD = regByEmailUI.kpw.getText().toString().trim();
        regByEmailUI.kdq = regByEmailUI.kpx.getText().toString();
        if (Util.isNullOrNil(regByEmailUI.fuD)) {
            com.tencent.mm.ui.base.h.n(regByEmailUI, R.string.fy1, R.string.fxx);
            AppMethodBeat.o(128493);
        } else if (!Util.isValidEmail(regByEmailUI.fuD)) {
            com.tencent.mm.ui.base.h.n(regByEmailUI, R.string.fy0, R.string.fxx);
            AppMethodBeat.o(128493);
        } else if (Util.isNullOrNil(regByEmailUI.kdq)) {
            com.tencent.mm.ui.base.h.n(regByEmailUI, R.string.fy2, R.string.fxx);
            AppMethodBeat.o(128493);
        } else if (!Util.isValidPassword(regByEmailUI.kdq)) {
            com.tencent.mm.ui.base.h.n(regByEmailUI, R.string.hvm, R.string.fxx);
            AppMethodBeat.o(128493);
        } else {
            regByEmailUI.hideVKB();
            final ab abVar = new ab(regByEmailUI.fuD, regByEmailUI.kdq);
            g.azz().a(abVar, 0);
            regByEmailUI.getString(R.string.zb);
            regByEmailUI.gtM = com.tencent.mm.ui.base.h.a((Context) regByEmailUI, regByEmailUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.RegByEmailUI.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128475);
                    g.azz().a(abVar);
                    AppMethodBeat.o(128475);
                }
            });
            AppMethodBeat.o(128493);
        }
    }
}
