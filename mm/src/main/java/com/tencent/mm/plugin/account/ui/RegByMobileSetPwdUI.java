package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class RegByMobileSetPwdUI extends SetPwdUI {
    private String dHx = null;
    private String hint = null;
    private TextView knK;
    private TextView kqG;
    private View kqH;
    private View kqI;
    private TextView kqJ;
    public View kqK;
    public EditText kqL;
    private boolean kqM = false;
    public boolean kqN;
    private int kqO = 0;
    private SKBuiltinBuffer_t kqP = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.account.ui.SetPwdUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.account.ui.SetPwdUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128605);
        super.onCreate(bundle);
        this.hint = getIntent().getStringExtra("kintent_hint");
        this.ox = getIntent().getBooleanExtra("kintent_cancelable", true);
        this.kqM = getIntent().getBooleanExtra("from_unbind", false);
        g.azz().a(384, this);
        g.azz().a(255, this);
        initView();
        byte[] decodeHexString = Util.decodeHexString(bh.aVK().getString("_auth_key", ""));
        hy hyVar = new hy();
        if (!Util.isNullOrNil(decodeHexString)) {
            this.kqP = new SKBuiltinBuffer_t().setBuffer(decodeHexString);
            try {
                hyVar.parseFrom(decodeHexString);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", e2, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
            }
        } else {
            this.kqP = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        }
        g.azz().a(new u(1), 0);
        getString(R.string.zb);
        this.gtM = h.a((Context) this, getString(R.string.wc), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(128605);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.account.ui.SetPwdUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128606);
        super.onDestroy();
        g.azz().b(384, this);
        g.azz().b(255, this);
        AppMethodBeat.o(128606);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(128607);
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("setpwd_ticket");
        Log.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", stringExtra);
        if (!Util.isNullOrNil(stringExtra)) {
            this.dHx = stringExtra;
            this.kqO = 4;
            this.kqK.setVisibility(8);
            this.kqH.setVisibility(8);
        }
        AppMethodBeat.o(128607);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bme;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        AppMethodBeat.i(128608);
        if (!this.ox) {
            showMMLogo();
        }
        setMMTitle(R.string.g00);
        this.kqG = (TextView) findViewById(R.id.j1u);
        this.kqI = findViewById(R.id.bp);
        this.knK = (TextView) findViewById(R.id.gzc);
        this.kqJ = (TextView) findViewById(R.id.bz);
        if (this.hint != null && this.hint.length() > 0) {
            this.knK.setText(this.hint);
        }
        this.kqK = findViewById(R.id.gza);
        this.kqL = (EditText) this.kqK.findViewById(R.id.gzg);
        this.kqH = findViewById(R.id.d9c);
        this.kqH.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(128602);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/RegByMobileSetPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final String str = (String) g.aAh().azQ().get(6, (Object) null);
                if (Util.isNullOrNil(str)) {
                    Log.i("MicorMsg.RegByMobileSetPwdUI", "has not bind mobile");
                    final Intent intent = new Intent(RegByMobileSetPwdUI.this, BindMContactUI.class);
                    intent.putExtra("bind_scene", 4);
                    h.a((Context) RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(R.string.fzu), "", RegByMobileSetPwdUI.this.getString(R.string.ag8), RegByMobileSetPwdUI.this.getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(128600);
                            MMWizardActivity.ay(RegByMobileSetPwdUI.this, intent);
                            AppMethodBeat.o(128600);
                        }
                    }, (DialogInterface.OnClickListener) null);
                } else {
                    Log.i("MicorMsg.RegByMobileSetPwdUI", "has bind mobile");
                    h.a((Context) RegByMobileSetPwdUI.this, RegByMobileSetPwdUI.this.getString(R.string.fzs, new Object[]{str}), "", RegByMobileSetPwdUI.this.getString(R.string.yq), RegByMobileSetPwdUI.this.getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(128601);
                            Intent intent = new Intent(RegByMobileSetPwdUI.this, MobileVerifyUI.class);
                            intent.putExtra("bindmcontact_mobile", str);
                            intent.putExtra("mobile_verify_purpose", 5);
                            RegByMobileSetPwdUI.this.startActivityForResult(intent, 10001);
                            AppMethodBeat.o(128601);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
                a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSetPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128602);
            }
        });
        if (this.kqM || !g.aAf().azp()) {
            this.kqI.setVisibility(8);
        } else {
            this.kqI.setVisibility(0);
            String aTZ = z.aTZ();
            if (Util.isNullOrNil(aTZ)) {
                aTZ = z.aTY();
                if (as.bjx(aTZ)) {
                    aTZ = null;
                }
            }
            if (Util.isNullOrNil(aTZ)) {
                String str2 = (String) g.aAh().azQ().get(6, (Object) null);
                String str3 = (String) g.aAh().azQ().get(5, (Object) null);
                if (!Util.isNullOrNil(str2)) {
                    if (Util.isPhoneNumber(str2).booleanValue()) {
                        PhoneFormater phoneFormater = new PhoneFormater();
                        String str4 = "86";
                        if (str2.startsWith("+")) {
                            str = str2.replace("+", "");
                            String extractCountryCode = PhoneFormater.extractCountryCode(str);
                            if (extractCountryCode != null) {
                                str = str.substring(extractCountryCode.length());
                                str4 = extractCountryCode;
                            } else {
                                str4 = extractCountryCode;
                            }
                        } else {
                            str = str2;
                        }
                        String formatNumber = phoneFormater.formatNumber(str4, str);
                        this.kqJ.setText(R.string.gqf);
                        this.kqG.setText(formatNumber);
                    }
                    this.knK.setText(R.string.g02);
                } else if (!Util.isNullOrNil(str3)) {
                    this.kqG.setText(str3);
                    this.kqJ.setText(R.string.gob);
                    this.knK.setText(R.string.g01);
                } else {
                    this.kqI.setVisibility(8);
                }
            } else {
                this.kqJ.setText(R.string.gw_);
                this.kqG.setText(aTZ);
            }
        }
        TextView textView = (TextView) findViewById(R.id.g3m);
        TextView textView2 = (TextView) findViewById(R.id.g8y);
        TextView textView3 = (TextView) findViewById(R.id.b_n);
        EditText editText = (EditText) findViewById(R.id.gzi);
        EditText editText2 = (EditText) findViewById(R.id.gzh);
        if (!LocaleUtil.isChineseAppLang()) {
            textView.setTextSize(1, 14.0f);
            textView2.setTextSize(1, 14.0f);
            textView3.setTextSize(1, 14.0f);
            editText.setTextSize(1, 14.0f);
            editText2.setTextSize(1, 14.0f);
        }
        float measureText = this.kqJ.getPaint().measureText(this.kqJ.getText().toString());
        float max = Math.max(Math.max(Math.max(measureText, textView2.getPaint().measureText(textView2.getText().toString())), textView3.getPaint().measureText(textView3.getText().toString())), textView.getPaint().measureText(textView.getText().toString()));
        textView.setWidth((int) max);
        this.kqJ.setWidth((int) max);
        textView2.setWidth((int) max);
        textView2.setWidth((int) max);
        AppMethodBeat.o(128608);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final String bpy() {
        AppMethodBeat.i(128609);
        String obj = ((EditText) findViewById(R.id.gzi)).getText().toString();
        AppMethodBeat.o(128609);
        return obj;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final q bpx() {
        AppMethodBeat.i(128610);
        if (Util.isNullOrNil(this.dHx)) {
            this.dHx = (String) g.aAh().azQ().get(77830, (Object) null);
        }
        aa aaVar = new aa(this.ksb, this.dHx, this.kqO, this.kqP);
        AppMethodBeat.o(128610);
        return aaVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final String bpz() {
        AppMethodBeat.i(128611);
        String obj = ((EditText) findViewById(R.id.gzh)).getText().toString();
        AppMethodBeat.o(128611);
        return obj;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final void bpG() {
        AppMethodBeat.i(128612);
        if (!Util.isNullOrNil(this.dHx) || !this.kqN) {
            super.bpG();
            AppMethodBeat.o(128612);
            return;
        }
        g.azz().a(new ad(this.kqL.getText().toString(), "", "", ""), 0);
        getString(R.string.zb);
        this.gtM = h.a((Context) this, getString(R.string.ys), false, (DialogInterface.OnCancelListener) null);
        AppMethodBeat.o(128612);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final void a(a.EnumC0518a aVar) {
        AppMethodBeat.i(128613);
        switch (aVar) {
            case TwoPasswordsNotMatch:
                h.n(this, R.string.fzl, R.string.fzn);
                AppMethodBeat.o(128613);
                return;
            case BeyondMaximumLength:
                h.n(this, R.string.fzm, R.string.fzn);
                AppMethodBeat.o(128613);
                return;
            case DisallowShortNumericPassword:
                h.n(this, R.string.hvj, R.string.fzn);
                AppMethodBeat.o(128613);
                return;
            case NotReachMinimumLength:
                h.n(this, R.string.hvm, R.string.fzn);
                break;
        }
        AppMethodBeat.o(128613);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final boolean o(int i2, int i3, String str) {
        AppMethodBeat.i(128614);
        if (i2 == 0 && i3 == 0) {
            finish();
            AppMethodBeat.o(128614);
            return true;
        }
        boolean n = n(i2, i3, str);
        AppMethodBeat.o(128614);
        return n;
    }

    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final boolean bpH() {
        return true;
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.account.ui.SetPwdUI
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(128615);
        Log.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", Integer.valueOf(i3), str, qVar);
        super.onSceneEnd(i2, i3, str, qVar);
        if (qVar.getType() == 255) {
            if (((u) qVar).jkh == 1) {
                if (i2 == 0 && i3 == 0) {
                    this.kqK.setVisibility(0);
                    this.kqH.setVisibility(0);
                    this.kqN = true;
                    AppMethodBeat.o(128615);
                    return;
                } else if (i3 == -3 && i2 == 4) {
                    this.kqN = false;
                    AppMethodBeat.o(128615);
                    return;
                } else {
                    this.kqK.setVisibility(0);
                    this.kqH.setVisibility(0);
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Log.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", Integer.valueOf(i3), Integer.valueOf(Dk.dDG), Dk.url, Dk.desc);
                        h.a((Context) this, Dk.desc, Dk.Title, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128603);
                                RegByMobileSetPwdUI.this.finish();
                                AppMethodBeat.o(128603);
                            }
                        });
                    }
                    AppMethodBeat.o(128615);
                    return;
                }
            }
        } else if (qVar.getType() == 384) {
            if (i2 == 0 && i3 == 0) {
                g.aAh().azQ().set(77830, ((ad) qVar).bbG());
                bpV();
                AppMethodBeat.o(128615);
                return;
            }
            h.n(this, R.string.fzw, R.string.zb);
        }
        AppMethodBeat.o(128615);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(128616);
        if (i2 == 10001 && i3 == -1) {
            String stringExtra = intent.getStringExtra("setpwd_ticket");
            Log.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", stringExtra);
            if (!Util.isNullOrNil(stringExtra)) {
                this.dHx = stringExtra;
                this.kqO = 6;
                this.kqK.setVisibility(8);
                this.kqH.setVisibility(8);
            }
        }
        AppMethodBeat.o(128616);
    }
}
