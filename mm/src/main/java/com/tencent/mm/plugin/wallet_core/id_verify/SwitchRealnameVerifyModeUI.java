package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.id_verify.model.e;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import org.json.JSONException;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI extends WalletBaseUI implements View.OnClickListener {
    private boolean HPI = false;
    private int HQW = 500;
    private long HQX = 0;
    private View HQY;
    private View HQZ;
    private View HRa;
    private TextView HRb;
    private TextView HRc;
    private TextView HRd;
    private TextView HRe;
    private TextView HRf;
    private TextView HRg;
    private TextView HRh;
    private TextView HRi;
    private TextView HRj;
    private String HRk;
    private String HRl;
    private String HRm;
    private boolean HRn;
    private boolean HRo = false;
    private int mEntryScene = 0;
    private u zmb = new u();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SwitchRealnameVerifyModeUI() {
        AppMethodBeat.i(70026);
        AppMethodBeat.o(70026);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(70027);
        super.onResume();
        this.zmb.onResume();
        AppMethodBeat.o(70027);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(70028);
        super.onPause();
        this.zmb.onPause();
        AppMethodBeat.o(70028);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70029);
        super.onDestroy();
        AppMethodBeat.o(70029);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70030);
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("is_from_new_cashier") && getProcess() == null) {
            boolean z = getIntent().getExtras().getBoolean("key_process_is_end");
            boolean z2 = getIntent().getExtras().getBoolean("key_process_is_stay");
            if (z && !z2) {
                finish();
            }
        }
        this.HRo = getInput().getBoolean("key_from_set_pwd", false);
        initView();
        getProcess();
        this.mEntryScene = getInput().getInt("entry_scene", this.mEntryScene);
        f.d(13, Util.nowSecond(), this.mEntryScene);
        if (this.HRo) {
            setMMTitle(R.string.ipq);
        }
        this.zmb.IkQ = new u.b() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final int eho() {
                return 1;
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final Context getContext() {
                return SwitchRealnameVerifyModeUI.this;
            }
        };
        AppMethodBeat.o(70030);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70031);
        setMMTitle("");
        this.HQY = findViewById(R.id.ifi);
        this.HQZ = findViewById(R.id.ifj);
        this.HRa = findViewById(R.id.ifk);
        this.HQZ.setOnClickListener(this);
        this.HQY.setOnClickListener(this);
        this.HRa.setOnClickListener(this);
        this.HRb = (TextView) findViewById(R.id.a3p);
        this.HRc = (TextView) findViewById(R.id.a3o);
        this.HRd = (TextView) findViewById(R.id.a3t);
        this.HRe = (TextView) findViewById(R.id.a3s);
        this.HRf = (TextView) findViewById(R.id.c7s);
        this.HRg = (TextView) findViewById(R.id.h_5);
        this.HRi = (TextView) findViewById(R.id.j2z);
        this.HRj = (TextView) findViewById(R.id.j2y);
        this.HRh = (TextView) findViewById(R.id.ifg);
        if (this.HRo) {
            this.HRh.setText(R.string.ipr);
        }
        yg(false);
        e eVar = new e("");
        addSceneEndListener(1666);
        doSceneProgress(eVar);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(70018);
                d process = SwitchRealnameVerifyModeUI.this.getProcess();
                if (process != null) {
                    f.d(14, Util.nowSecond(), SwitchRealnameVerifyModeUI.this.mEntryScene);
                    process.g(SwitchRealnameVerifyModeUI.this, 0);
                    AppMethodBeat.o(70018);
                    return true;
                }
                SwitchRealnameVerifyModeUI.this.finish();
                AppMethodBeat.o(70018);
                return false;
            }
        });
        AppMethodBeat.o(70031);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(70032);
        if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.d) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.pluginsdk.wallet.e.bfP(((com.tencent.mm.plugin.wallet_core.c.d) qVar).fPP());
                removeSceneEndListener(580);
                d process = getProcess();
                if (process != null) {
                    Bundle bundle = process.dQL;
                    bundle.putInt("real_name_verify_mode", 1);
                    a.l(this, bundle);
                }
                AppMethodBeat.o(70032);
                return true;
            }
        } else if (qVar instanceof e) {
            removeSceneEndListener(1666);
            yg(true);
            e eVar = (e) qVar;
            this.HPI = eVar.HPI;
            if (eVar.jumpRemind == null) {
                z = false;
            } else {
                z = true;
            }
            if (z && eVar.jumpRemind.a(this, new g() {
                /* class com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.g
                public final void eeY() {
                }
            })) {
                AppMethodBeat.o(70032);
                return true;
            }
        }
        AppMethodBeat.o(70032);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70033);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (i3 == -1) {
                this.zmb.ehm();
                AppMethodBeat.o(70033);
                return;
            }
            this.zmb.cancel();
        }
        AppMethodBeat.o(70033);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c_s;
    }

    public void onClick(final View view) {
        AppMethodBeat.i(70034);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (System.currentTimeMillis() - this.HQX <= ((long) this.HQW)) {
            Log.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70034);
            return;
        }
        this.HQX = System.currentTimeMillis();
        this.zmb.a(new u.a() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
            public final void ehm() {
                AppMethodBeat.i(70019);
                SwitchRealnameVerifyModeUI.this.onClickImp(view);
                SwitchRealnameVerifyModeUI.this.HPI = false;
                AppMethodBeat.o(70019);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
            public final void cancel() {
                AppMethodBeat.i(70020);
                SwitchRealnameVerifyModeUI.this.zmb.dEF = false;
                AppMethodBeat.o(70020);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
            public final void ehn() {
                AppMethodBeat.i(70021);
                SwitchRealnameVerifyModeUI.this.onClickImp(view);
                AppMethodBeat.o(70021);
            }
        }, this.HPI);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70034);
    }

    public void onClickImp(View view) {
        AppMethodBeat.i(70035);
        int id = view.getId();
        final d process = getProcess();
        if (process != null) {
            Bundle bundle = process.dQL;
            if (id == R.id.ifi) {
                f.d(15, Util.nowSecond(), this.mEntryScene);
                if (bundle.getInt("realname_scene") != 1) {
                    bundle.putInt("real_name_verify_mode", 1);
                } else if (getIntent() == null) {
                    String str = "";
                    if (Util.isNullOrNil(str)) {
                        str = getString(R.string.itf);
                    }
                    h.a((Context) this, str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(70023);
                            SwitchRealnameVerifyModeUI.this.finish();
                            AppMethodBeat.o(70023);
                        }
                    });
                    AppMethodBeat.o(70035);
                    return;
                } else {
                    addSceneEndListener(580);
                    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.d(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)));
                    AppMethodBeat.o(70035);
                    return;
                }
            } else if (id == R.id.ifj) {
                f.d(17, Util.nowSecond(), this.mEntryScene);
                bundle.putInt("real_name_verify_mode", 2);
            } else if (id == R.id.ifk) {
                f.d(16, Util.nowSecond(), this.mEntryScene);
                if (!this.HRn || Util.isNullOrNil(this.HRm)) {
                    bundle.putInt("real_name_verify_mode", 3);
                    bundle.putString("verify_card_flag", "1");
                } else {
                    h.a((Context) this, this.HRm, "", this.HRl, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(70022);
                            Bundle bundle = process.dQL;
                            bundle.putInt("real_name_verify_mode", 3);
                            bundle.putString("verify_card_flag", "1");
                            a.l(SwitchRealnameVerifyModeUI.this, bundle);
                            AppMethodBeat.o(70022);
                        }
                    });
                    AppMethodBeat.o(70035);
                    return;
                }
            }
            a.l(this, bundle);
        }
        AppMethodBeat.o(70035);
    }

    private static JSONObject fPW() {
        AppMethodBeat.i(70036);
        com.tencent.mm.kernel.g.aAi();
        Object obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, "");
        if (obj != null) {
            String str = (String) obj;
            if (!Util.isNullOrNil(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j2 = jSONObject.getLong(AppMeasurement.Param.TIMESTAMP);
                    long j3 = jSONObject.getLong("cache_time");
                    Log.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j2 + ";cachetime=" + j3);
                    if (currentTimeMillis - j2 > j3) {
                        Log.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
                        AppMethodBeat.o(70036);
                        return null;
                    }
                    AppMethodBeat.o(70036);
                    return jSONObject;
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", e2, "", new Object[0]);
                    Log.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
                    AppMethodBeat.o(70036);
                    return null;
                }
            }
        }
        Log.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
        AppMethodBeat.o(70036);
        return null;
    }

    private boolean yg(boolean z) {
        AppMethodBeat.i(70037);
        JSONObject fPW = fPW();
        if (z && fPW == null) {
            fPW = new JSONObject();
        }
        if (fPW != null) {
            String nullAs = Util.nullAs(fPW.optString("cache_header_titles", getString(R.string.hju)), getString(R.string.hju));
            if (this.HRo) {
                this.HRh.setText(R.string.ipr);
            } else {
                this.HRh.setText(nullAs);
            }
            if (fPW.optBoolean("isShowBindCardVerify", false)) {
                this.HRi.setText(fPW.optString("bindCardVerifyTitle"));
                this.HRj.setText(fPW.optString("bindCardVerifySubtitle"));
                this.HRa.setVisibility(0);
            } else {
                this.HRa.setVisibility(8);
            }
            if (fPW.optBoolean("isShowBindCard", false)) {
                this.HRb.setText(fPW.optString("bindcardTitle", getString(R.string.hjv)));
                this.HRc.setText(fPW.optString("bindcardSubTitle", getString(R.string.hjw)));
                this.HQY.setVisibility(0);
            } else {
                this.HQY.setVisibility(8);
            }
            if (fPW.optBoolean("isShowBindId", false)) {
                this.HRd.setText(fPW.optString("bindIdTitle", getString(R.string.hjx)));
                this.HRe.setText(fPW.optString("bindIdSubTitle", getString(R.string.hjy)));
                this.HQZ.setVisibility(0);
            } else {
                this.HQZ.setVisibility(8);
            }
            this.HRl = fPW.optString("bindCardVerifyAlertViewRightBtnTxt", "");
            this.HRm = fPW.optString("bindCardVerifyAlertViewContent", "");
            this.HRn = fPW.optBoolean("isShowBindCardVerifyAlertView", false);
            String optString = fPW.optString("extral_wording", "");
            if (!Util.isNullOrNil(optString)) {
                this.HRf.setText(optString);
                this.HRf.setVisibility(0);
            } else {
                this.HRf.setVisibility(8);
            }
            this.HRl = fPW.optString("bindCardVerifyAlertViewRightBtnTxt", "");
            this.HRm = fPW.optString("bindCardVerifyAlertViewContent");
            this.HRn = fPW.optBoolean("isShowBindCardVerifyAlertView", false);
            boolean optBoolean = fPW.optBoolean("question_answer_switch", false);
            this.HRk = fPW.optString("question_answer_url", "");
            if (optBoolean && !Util.isNullOrNil(this.HRk)) {
                addIconOptionMenu(0, R.drawable.crt, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.AnonymousClass7 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(70024);
                        f.d(18, Util.nowSecond(), SwitchRealnameVerifyModeUI.this.mEntryScene);
                        f.p(SwitchRealnameVerifyModeUI.this.getContext(), SwitchRealnameVerifyModeUI.this.HRk, false);
                        AppMethodBeat.o(70024);
                        return true;
                    }
                });
            }
            if (fPW.optBoolean("isShowCapitalSecurity", false)) {
                SpannableString spannableString = new SpannableString("#  " + getContext().getResources().getString(R.string.ijd));
                Drawable drawable = getContext().getResources().getDrawable(R.drawable.icon_shield_pay);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableString.setSpan(new ImageSpan(drawable), 0, 1, 18);
                this.HRg.setText(spannableString, TextView.BufferType.SPANNABLE);
                this.HRg.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.id_verify.SwitchRealnameVerifyModeUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(70025);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent();
                        intent.putExtra("wallet_lock_jsapi_scene", 2);
                        c.b(SwitchRealnameVerifyModeUI.this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/SwitchRealnameVerifyModeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(70025);
                    }
                });
                this.HRg.setVisibility(0);
            } else {
                this.HRg.setVisibility(8);
            }
            AppMethodBeat.o(70037);
            return true;
        }
        AppMethodBeat.o(70037);
        return z;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(70038);
        if (i2 == 4) {
            d process = getProcess();
            if (process != null) {
                f.d(14, Util.nowSecond(), this.mEntryScene);
                process.g(this, 0);
                AppMethodBeat.o(70038);
                return true;
            }
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(70038);
        return onKeyUp;
    }
}
