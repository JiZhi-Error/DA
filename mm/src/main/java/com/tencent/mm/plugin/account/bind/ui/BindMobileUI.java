package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMobileUI extends MMWizardActivity {
    private String countryCode = null;
    private String dSf;
    private TextView hbb;
    private String jbZ = null;
    private i kaH;
    private EditText kaW;
    private LinearLayout kaX;
    private TextView kaZ;
    private CheckBox kbA;
    private LinearLayout kbB;
    private ImageView kbC;
    private boolean kbD;
    private TextView kba;
    private String kbb = null;
    private BindWordingContent kbp;
    private int kbq;
    private Button kbw;
    private TextView kbx;
    private TextView kby;
    private CheckBox kbz;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void k(BindMobileUI bindMobileUI) {
        AppMethodBeat.i(109952);
        bindMobileUI.exit(-1);
        AppMethodBeat.o(109952);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109943);
        super.onCreate(bundle);
        setMMTitle(R.string.aef);
        this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
        this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
        this.kbb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.kbp = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.kbq = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.kbD = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        initView();
        AppMethodBeat.o(109943);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109944);
        super.onDestroy();
        if (this.kaH != null) {
            this.kaH.recycle();
        }
        AppMethodBeat.o(109944);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(109945);
        if (i2 == 4) {
            ala(1);
            AppMethodBeat.o(109945);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(109945);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109946);
        this.kaW = (EditText) findViewById(R.id.a47);
        this.kaX = (LinearLayout) findViewById(R.id.bgn);
        this.kaZ = (TextView) findViewById(R.id.bgp);
        this.kba = (TextView) findViewById(R.id.bgk);
        this.hbb = (TextView) findViewById(R.id.a4a);
        this.kbw = (Button) findViewById(R.id.a3v);
        this.kbx = (TextView) findViewById(R.id.a48);
        this.hbb.setText(getString(R.string.aeb));
        this.kby = (TextView) findViewById(R.id.a3w);
        this.kbB = (LinearLayout) findViewById(R.id.a4_);
        this.kbA = (CheckBox) findViewById(R.id.a45);
        this.kbz = (CheckBox) findViewById(R.id.a44);
        this.kbC = (ImageView) findViewById(R.id.a46);
        if (this.kbp != null) {
            if (this.kbp.title != null && this.kbp.title.length() > 0) {
                this.hbb.setText(this.kbp.title);
            }
            if (this.kbp.content != null && this.kbp.content.length() > 0) {
                this.kby.setText(this.kbp.content);
            }
            switch (this.kbp.jiW.intValue()) {
                case 0:
                    this.kbC.setImageResource(R.drawable.bah);
                    break;
                case 1:
                    this.kbC.setImageResource(R.drawable.bak);
                    break;
                case 2:
                    this.kbC.setImageResource(R.drawable.bai);
                    break;
            }
        }
        switch (this.kbq) {
            case 0:
                this.kbB.setVisibility(0);
                this.kbA.setVisibility(0);
                this.kby.setVisibility(8);
                break;
            case 1:
                this.kbB.setVisibility(8);
                this.kbA.setVisibility(8);
                this.kby.setVisibility(0);
                break;
        }
        if (Util.isNullOrNil(this.jbZ) && Util.isNullOrNil(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            Log.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(simCountryIso)));
            if (Util.isNullOrNil(simCountryIso)) {
                Log.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
            } else {
                b.a bs = b.bs(simCountryIso, getString(R.string.bj8));
                if (bs == null) {
                    Log.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                } else {
                    this.jbZ = bs.jbZ;
                    this.countryCode = bs.jbY;
                }
            }
        }
        if (this.jbZ != null && !this.jbZ.equals("")) {
            this.kaZ.setText(this.jbZ);
        }
        if (this.countryCode != null && !this.countryCode.equals("")) {
            this.kba.setText("+" + this.countryCode);
        }
        if (this.kbb != null && !this.kbb.equals("")) {
            this.kaW.setText(this.kbb);
        }
        this.kbw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(109937);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (BindMobileUI.this.kaW.getText().toString() == null || BindMobileUI.this.kaW.getText().toString().length() == 0) {
                    Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(R.string.adt), 0).show();
                    a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(109937);
                    return;
                }
                BindMobileUI.this.dSf = BindMobileUI.this.kba.getText().toString().trim() + Util.trimPhoneNumber(BindMobileUI.this.kaW.getText().toString());
                Log.i("MicroMsg.BindMContactUI", "do next, send sms to self");
                BindMobileUI.c(BindMobileUI.this, BindMobileUI.this.dSf);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109937);
            }
        });
        this.kbx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(109938);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BindMobileUI.d(BindMobileUI.this);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109938);
            }
        });
        if (this.kbD) {
            setMMTitle(R.string.adg);
            this.kbC.setVisibility(8);
            this.hbb.setText(R.string.ae1);
            this.kbB.setVisibility(8);
            this.kbA.setVisibility(8);
            this.kbA.setChecked(false);
            this.kbz.setVisibility(0);
            this.kbz.setChecked(false);
            this.kby.setVisibility(8);
            this.kby.setText(getString(R.string.adi));
            this.kbx.setVisibility(8);
            this.kbw.setText(R.string.adg);
            setBackBtn(new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindMobileUI.AnonymousClass4 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(109939);
                    BindMobileUI.e(BindMobileUI.this);
                    AppMethodBeat.o(109939);
                    return true;
                }
            });
        }
        this.kaX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(109940);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMobileUI.this.jbZ);
                intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
                com.tencent.mm.plugin.account.a.a.jRt.b(intent, (Activity) BindMobileUI.this);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109940);
            }
        });
        this.kaX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(109941);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMobileUI.this.jbZ);
                intent.putExtra("couttry_code", BindMobileUI.this.countryCode);
                com.tencent.mm.plugin.account.a.a.jRt.b(intent, (Activity) BindMobileUI.this);
                a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109941);
            }
        });
        AppMethodBeat.o(109946);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109947);
        super.onActivityResult(i2, i3, intent);
        switch (i3) {
            case 100:
                this.jbZ = Util.nullAs(intent.getStringExtra("country_name"), "");
                this.countryCode = Util.nullAs(intent.getStringExtra("couttry_code"), "");
                if (!this.jbZ.equals("")) {
                    this.kaZ.setText(this.jbZ);
                }
                if (!this.countryCode.equals("")) {
                    this.kba.setText("+" + this.countryCode);
                    break;
                }
                break;
        }
        AppMethodBeat.o(109947);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.iw;
    }

    static /* synthetic */ void a(BindMobileUI bindMobileUI, final String str) {
        AppMethodBeat.i(109948);
        if (bindMobileUI.kaH == null) {
            bindMobileUI.kaH = new i(i.b.BINDMOBILE, bindMobileUI, new i.a() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindMobileUI.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.account.friend.ui.i.a
                public final void h(int i2, Bundle bundle) {
                    boolean z = true;
                    AppMethodBeat.i(109942);
                    if (i2 != 2) {
                        if (i2 == 1) {
                            BindMobileUI.d(BindMobileUI.this, str);
                        }
                        AppMethodBeat.o(109942);
                    } else if (BindMobileUI.this.kbD) {
                        BindMobileUI bindMobileUI = BindMobileUI.this;
                        boolean z2 = !BindMobileUI.this.kbz.isChecked();
                        if (BindMobileUI.this.kbA.isChecked()) {
                            z = false;
                        }
                        BindMobileStatusUI.c(bindMobileUI, z2, z);
                        BindMobileUI.k(BindMobileUI.this);
                        AppMethodBeat.o(109942);
                    } else {
                        Intent intent = new Intent(BindMobileUI.this, BindMobileStatusUI.class);
                        intent.putExtra("kstyle_bind_wording", BindMobileUI.this.kbp);
                        intent.putExtra("kstyle_bind_recommend_show", BindMobileUI.this.kbq);
                        intent.putExtra("Kfind_friend_by_mobile_flag", BindMobileUI.this.kbz.isChecked());
                        intent.putExtra("Krecom_friends_by_mobile_flag", BindMobileUI.this.kbA.isChecked());
                        MMWizardActivity.ay(BindMobileUI.this, intent);
                        AppMethodBeat.o(109942);
                    }
                }
            });
        }
        bindMobileUI.kaH.Tm(str);
        if (bindMobileUI.kbD) {
            bindMobileUI.kaH.khR = false;
        }
        AppMethodBeat.o(109948);
    }

    static /* synthetic */ void c(BindMobileUI bindMobileUI, final String str) {
        AppMethodBeat.i(109949);
        String string = bindMobileUI.getContext().getString(R.string.af7);
        h.a(bindMobileUI.getContext(), String.format("%s\n%s", bindMobileUI.getContext().getString(R.string.af8), str), string, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMobileUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(109936);
                BindMobileUI.a(BindMobileUI.this, str);
                AppMethodBeat.o(109936);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(109949);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI) {
        AppMethodBeat.i(109950);
        bindMobileUI.ala(1);
        AppMethodBeat.o(109950);
    }

    static /* synthetic */ void e(BindMobileUI bindMobileUI) {
        AppMethodBeat.i(109951);
        bindMobileUI.ala(1);
        AppMethodBeat.o(109951);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI, String str) {
        AppMethodBeat.i(109953);
        Intent intent = new Intent(bindMobileUI, BindMobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", str);
        intent.putExtra("kstyle_bind_wording", bindMobileUI.kbp);
        intent.putExtra("kstyle_bind_recommend_show", bindMobileUI.kbq);
        intent.putExtra("Kfind_friend_by_mobile_flag", bindMobileUI.kbz.isChecked());
        intent.putExtra("Krecom_friends_by_mobile_flag", bindMobileUI.kbA.isChecked());
        if (bindMobileUI.kbD) {
            intent.putExtra("bind_scene", 6);
        }
        ay(bindMobileUI, intent);
        AppMethodBeat.o(109953);
    }
}
