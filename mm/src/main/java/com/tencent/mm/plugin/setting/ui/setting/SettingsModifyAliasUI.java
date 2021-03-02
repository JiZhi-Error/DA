package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.model.f;
import com.tencent.mm.plugin.setting.model.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.b;
import com.tencent.mm.view.CheckBoxLicenseView;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;

public class SettingsModifyAliasUI extends MMWizardActivity implements i, b.a {
    private MMClearEditText DcC;
    private f DcD;
    private e DcE;
    private ArrayList<Integer> DcF;
    private ArrayList<String> DcG;
    private ScrollView gxx;
    private InputPanelLinearLayout gxy;
    private TextView ksy;
    private q tipDialog;
    private Button vMn;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingsModifyAliasUI settingsModifyAliasUI, String str) {
        AppMethodBeat.i(256569);
        settingsModifyAliasUI.DI(str);
        AppMethodBeat.o(256569);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(256562);
        super.onCreate(bundle);
        this.DcF = getIntent().getIntegerArrayListExtra("key_ticket_type");
        this.DcG = getIntent().getStringArrayListExtra("key_ticket");
        Log.i("MicroMsg.SettingsModifyAliasUI", "ticketTypes %s, tickets %s", this.DcF, this.DcG);
        initView();
        g.azz().a(3516, this);
        g.azz().a(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, this);
        if (h.aqJ().getInt("EnableModAlias", 0) == 0) {
            finish();
        }
        AppMethodBeat.o(256562);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bqz;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(256563);
        super.onDestroy();
        g.azz().b(3516, this);
        g.azz().b(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, this);
        AppMethodBeat.o(256563);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(256564);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.gxy = (InputPanelLinearLayout) findViewById(R.id.dym);
        this.gxy.setExternalListener(this);
        this.vMn = (Button) findViewById(R.id.fz0);
        this.DcC = (MMClearEditText) findViewById(R.id.lo);
        this.ksy = (TextView) findViewById(R.id.c4r);
        this.gxx = (ScrollView) findViewById(R.id.hcs);
        this.vMn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(256553);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, SettingsModifyAliasUI.this.DcC.getText())) {
                    SettingsModifyAliasUI.this.hideVKB();
                    SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
                    SettingsModifyAliasUI.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.this.DcC.getText().toString());
                } else {
                    gc gcVar = new gc();
                    gcVar.tm(SettingsAliasUI.Dbv);
                    gcVar.ejW = 4;
                    gcVar.eIu = 5;
                    gcVar.bfK();
                }
                a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(256553);
            }
        });
        this.DcC.requestFocus();
        this.DcC.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(256554);
                boolean z = editable != null && !Util.isNullOrNil(editable.toString());
                SettingsModifyAliasUI.this.vMn.setEnabled(z);
                if (!z) {
                    SettingsModifyAliasUI.a(SettingsModifyAliasUI.this, "");
                }
                AppMethodBeat.o(256554);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(256555);
                gc gcVar = new gc();
                gcVar.tm(SettingsAliasUI.Dbv);
                gcVar.ejW = 7;
                gcVar.eIv = 2;
                gcVar.bfK();
                SettingsModifyAliasUI.this.onBackPressed();
                AppMethodBeat.o(256555);
                return true;
            }
        });
        AppMethodBeat.o(256564);
    }

    @Override // com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(256565);
        Log.i("MicroMsg.SettingsModifyAliasUI", "keyboard show %s, keyboardHeight %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.vMn.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.cb);
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.cb);
            this.vMn.setLayoutParams(layoutParams);
            this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), i2);
            final int height = this.gxx.getHeight();
            this.gxy.requestLayout();
            this.gxy.post(new Runnable() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(256557);
                    Log.i("MicroMsg.SettingsModifyAliasUI", "inputContainer.height: %d, screenHeight: %d", Integer.valueOf(SettingsModifyAliasUI.this.gxy.getHeight()), Integer.valueOf(height));
                    if (SettingsModifyAliasUI.this.gxy.getHeight() > height) {
                        SettingsModifyAliasUI.this.gxx.scrollBy(0, SettingsModifyAliasUI.this.gxy.getHeight() - height);
                    }
                    AppMethodBeat.o(256557);
                }
            });
            AppMethodBeat.o(256565);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.vMn.getLayoutParams();
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.bx);
        layoutParams2.topMargin = 0;
        this.vMn.setLayoutParams(layoutParams2);
        this.gxy.setPadding(this.gxy.getPaddingLeft(), this.gxy.getPaddingTop(), this.gxy.getPaddingRight(), 0);
        this.gxx.scrollBy(0, 0);
        AppMethodBeat.o(256565);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(256566);
        Log.i("MicroMsg.SettingsModifyAliasUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (qVar.getType() == 3516) {
            gc gcVar = new gc();
            gcVar.ejW = 4;
            gcVar.tm(SettingsAliasUI.Dbv);
            if (qVar != this.DcD) {
                Log.w("MicroMsg.SettingsModifyAliasUI", "check alias, not my scene, ignore!");
                AppMethodBeat.o(256566);
                return;
            }
            if (i2 == 0 && i3 == 0) {
                final String str2 = ((f) qVar).fMb;
                final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(this);
                gVar.apf(R.layout.bqt);
                ((TextView) gVar.lJI.findViewById(R.id.hm6)).setText(str2);
                final Button button = (Button) gVar.lJI.findViewById(R.id.fz0);
                button.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(256558);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        SettingsModifyAliasUI.c(SettingsModifyAliasUI.this, str2);
                        gc gcVar = new gc();
                        gcVar.tm(SettingsAliasUI.Dbv);
                        gcVar.ejW = 6;
                        gcVar.bfK();
                        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(256558);
                    }
                });
                CheckBoxLicenseView checkBoxLicenseView = (CheckBoxLicenseView) gVar.lJI.findViewById(R.id.fiv);
                checkBoxLicenseView.setTermText(getString(R.string.f2z));
                checkBoxLicenseView.setCheckStateChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass7 */

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        AppMethodBeat.i(256559);
                        gc gcVar = new gc();
                        gcVar.tm(SettingsAliasUI.Dbv);
                        gcVar.ejW = 5;
                        gcVar.bfK();
                        button.setEnabled(z);
                        AppMethodBeat.o(256559);
                    }
                });
                checkBoxLicenseView.setLicenseClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(256560);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        com.tencent.mm.plugin.account.a.b.a.b(SettingsModifyAliasUI.this, SettingsModifyAliasUI.this.getString(R.string.gl3, new Object[]{LocaleUtil.getApplicationLanguage()}), 0, true);
                        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(256560);
                    }
                });
                ImageView imageView = (ImageView) gVar.lJI.findViewById(R.id.fiw);
                if (ao.isDarkMode()) {
                    imageView.setImageResource(R.drawable.b6);
                }
                imageView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass9 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(256561);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        gc gcVar = new gc();
                        gcVar.tm(SettingsAliasUI.Dbv);
                        gcVar.ejW = 7;
                        gcVar.eIv = 3;
                        gcVar.bfK();
                        gVar.bMo();
                        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsModifyAliasUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(256561);
                    }
                });
                gVar.dGm();
            } else {
                gcVar.eIu = 6;
                if (!Util.isNullOrNil(str)) {
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        DI(Dk.desc);
                    } else {
                        DI(str);
                    }
                } else {
                    DI(getString(R.string.u5));
                }
            }
            gcVar.bfK();
            AppMethodBeat.o(256566);
            return;
        }
        if (qVar.getType() == 177) {
            if (qVar != this.DcE) {
                Log.w("MicroMsg.SettingsModifyAliasUI", "general set, not my scene, ignore!");
                AppMethodBeat.o(256566);
                return;
            } else if (i2 == 0 && i3 == 0) {
                com.tencent.mm.ui.base.h.cD(this, getString(R.string.wo));
                String str3 = this.DcE.CXI;
                String str4 = (String) g.aAh().azQ().get(42, (Object) null);
                String str5 = (String) g.aAh().azQ().get(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, (Object) null);
                Log.i("MicroMsg.SettingsModifyAliasUI", "newAlias %s, oldAlias %s, lastLogin %s", str3, str4, str5);
                g.aAh().azQ().set(42, str3);
                if (Util.isNullOrNil(str4) || str4.equals(str5)) {
                    g.aAh().azQ().set(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, str3);
                    ch.iFO.l(z.aTY(), WXUtil.LAST_LOGIN_USERNAME, str3);
                    bf.iDu.aO(WXUtil.LAST_LOGIN_USERNAME, str3);
                }
                ala(-1);
                AppMethodBeat.o(256566);
                return;
            } else if (i3 == -7 || i3 == -10) {
                com.tencent.mm.ui.base.h.n(getContext(), R.string.fxp, R.string.f39);
                AppMethodBeat.o(256566);
                return;
            } else if (!Util.isNullOrNil(str)) {
                com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                if (Dk2 != null) {
                    Dk2.a(this, null);
                    AppMethodBeat.o(256566);
                    return;
                }
                com.tencent.mm.ui.base.h.c(this, str, getString(R.string.f39), true);
                AppMethodBeat.o(256566);
                return;
            } else {
                com.tencent.mm.ui.base.h.n(getContext(), R.string.u5, R.string.f39);
            }
        }
        AppMethodBeat.o(256566);
    }

    private void DI(String str) {
        AppMethodBeat.i(256567);
        if (Util.isNullOrNil(str)) {
            this.ksy.setVisibility(8);
            AppMethodBeat.o(256567);
            return;
        }
        this.ksy.setVisibility(0);
        this.ksy.setText(str);
        AppMethodBeat.o(256567);
    }

    static /* synthetic */ boolean a(SettingsModifyAliasUI settingsModifyAliasUI, CharSequence charSequence) {
        AppMethodBeat.i(256568);
        if (charSequence.length() < 6 || charSequence.length() > 20) {
            settingsModifyAliasUI.DI(settingsModifyAliasUI.getString(R.string.hvc));
            AppMethodBeat.o(256568);
            return false;
        } else if (!Util.isAlpha(charSequence.charAt(0))) {
            settingsModifyAliasUI.DI(settingsModifyAliasUI.getString(R.string.hva));
            AppMethodBeat.o(256568);
            return false;
        } else {
            for (int length = charSequence.length() - 1; length > 0; length--) {
                char charAt = charSequence.charAt(length);
                if (!Util.isAlpha(charAt) && charAt != '-' && charAt != '_' && !Util.isNum(charAt)) {
                    if (Character.isSpace(charAt)) {
                        settingsModifyAliasUI.DI(settingsModifyAliasUI.getString(R.string.hv_));
                        AppMethodBeat.o(256568);
                        return false;
                    } else if (Util.isChinese(charAt)) {
                        settingsModifyAliasUI.DI(settingsModifyAliasUI.getString(R.string.hv8));
                        AppMethodBeat.o(256568);
                        return false;
                    } else {
                        settingsModifyAliasUI.DI(settingsModifyAliasUI.getString(R.string.hvc));
                        AppMethodBeat.o(256568);
                        return false;
                    }
                }
            }
            settingsModifyAliasUI.DI("");
            AppMethodBeat.o(256568);
            return true;
        }
    }

    static /* synthetic */ void b(SettingsModifyAliasUI settingsModifyAliasUI, String str) {
        AppMethodBeat.i(256570);
        settingsModifyAliasUI.DcD = new f(str);
        settingsModifyAliasUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) settingsModifyAliasUI.getContext(), settingsModifyAliasUI.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyAliasUI.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(256556);
                g.azz().a(SettingsModifyAliasUI.this.DcD);
                AppMethodBeat.o(256556);
            }
        });
        g.azz().a(settingsModifyAliasUI.DcD, 0);
        AppMethodBeat.o(256570);
    }

    static /* synthetic */ void c(SettingsModifyAliasUI settingsModifyAliasUI, String str) {
        AppMethodBeat.i(256571);
        HashMap hashMap = new HashMap();
        if (!(settingsModifyAliasUI.DcF == null || settingsModifyAliasUI.DcG == null || settingsModifyAliasUI.DcF.size() != settingsModifyAliasUI.DcG.size())) {
            for (int i2 = 0; i2 < settingsModifyAliasUI.DcF.size(); i2++) {
                hashMap.put(settingsModifyAliasUI.DcF.get(i2), settingsModifyAliasUI.DcG.get(i2));
            }
        }
        settingsModifyAliasUI.DcE = new e(str, hashMap);
        AppCompatActivity context = settingsModifyAliasUI.getContext();
        settingsModifyAliasUI.getString(R.string.f35);
        settingsModifyAliasUI.tipDialog = com.tencent.mm.ui.base.h.a((Context) context, settingsModifyAliasUI.getString(R.string.f30), false, (DialogInterface.OnCancelListener) null);
        g.azz().a(settingsModifyAliasUI.DcE, 0);
        AppMethodBeat.o(256571);
    }
}
