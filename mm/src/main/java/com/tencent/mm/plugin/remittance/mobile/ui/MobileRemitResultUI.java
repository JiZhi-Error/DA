package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.remittance.mobile.cgi.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.protocal.protobuf.ekk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;

public class MobileRemitResultUI extends MobileRemitBaseUI {
    public String AJn;
    private PayInfo BDB;
    private LinearLayout CmS;
    private ImageView Cnb;
    private LinearLayout Cnc;
    private TextView Cnd;
    private WalletTextView Cne;
    private LinearLayout Cnf;
    public String Cng;
    public String Cnh;
    public String Cni;
    public int Cnj;
    public String Cnk;
    public String Cnl;
    public int Cnm;
    private String Cnn;
    private String Cno;
    private TextView jVn;
    private View mLine;
    private String mReqKey;
    private Button xBa;
    private TextView yQS;

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bb8;
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.i(67747);
        super.onCreate(bundle);
        b.hgC();
        boolean b2 = b.b(b.a.clicfg_kinda_open, true);
        com.tencent.mm.wallet_core.b.hgC();
        boolean b3 = com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_mobile_remittance, false);
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "isKindaEnable: %s，isKindaMobileRemittanceEnable ：%s", Boolean.valueOf(b2), Boolean.valueOf(b3));
        if (!b2 || !b3) {
            z = false;
        }
        if (z) {
            Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use Kinda");
            if (!(getIntent() == null || getIntent().getExtras() == null)) {
                Bundle extras = getIntent().getExtras();
                this.Cng = extras.getString("extinfo_key_1");
                this.AJn = extras.getString("extinfo_key_2");
                this.Cnh = extras.getString("extinfo_key_3");
                this.Cni = extras.getString("extinfo_key_4");
                this.Cnj = extras.getInt("extinfo_key_5");
                this.Cnk = extras.getString("extinfo_key_6");
                this.Cnl = extras.getString("extinfo_key_7");
                this.Cnm = extras.getInt("extinfo_key_8");
                this.Cnn = extras.getString("extinfo_key_9");
                this.Cno = extras.getString("extinfo_key_10");
                this.mReqKey = extras.getString("extinfo_key_11");
                initView();
                doSceneProgress(new e(this.Cng, this.AJn, this.Cnh, this.Cni, this.Cnj, this.Cnk, this.Cnl));
                addSceneEndListener(1903);
                mo moVar = new mo();
                moVar.dSd.dDL = this.mReqKey;
                EventCenter.instance.publish(moVar);
                AppMethodBeat.o(67747);
            }
        }
        this.BDB = (PayInfo) getInput().getParcelable("key_pay_info");
        if (this.BDB == null || this.BDB.iqp == null) {
            Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "payInfo != null && payInfo.extInfo != null");
            eNv();
        } else {
            Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "use native");
            Bundle bundle2 = this.BDB.iqp;
            this.Cng = bundle2.getString("extinfo_key_1");
            this.AJn = bundle2.getString("extinfo_key_2");
            this.Cnh = bundle2.getString("extinfo_key_3");
            this.Cni = bundle2.getString("extinfo_key_4");
            this.Cnj = bundle2.getInt("extinfo_key_5");
            this.Cnk = bundle2.getString("extinfo_key_6");
            this.Cnl = bundle2.getString("extinfo_key_7");
            this.Cnm = bundle2.getInt("extinfo_key_8");
            this.Cnn = bundle2.getString("extinfo_key_9");
            this.Cno = bundle2.getString("extinfo_key_10");
            this.mReqKey = bundle2.getString("extinfo_key_11");
        }
        initView();
        doSceneProgress(new e(this.Cng, this.AJn, this.Cnh, this.Cni, this.Cnj, this.Cnk, this.Cnl));
        addSceneEndListener(1903);
        mo moVar2 = new mo();
        moVar2.dSd.dDL = this.mReqKey;
        EventCenter.instance.publish(moVar2);
        AppMethodBeat.o(67747);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67748);
        super.initView();
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(null);
        setBackBtnVisible(false);
        this.CmS = (LinearLayout) findViewById(R.id.fi8);
        this.yQS = (TextView) findViewById(R.id.a2b);
        this.Cnb = (ImageView) findViewById(R.id.fi2);
        this.Cnc = (LinearLayout) findViewById(R.id.fi1);
        this.jVn = (TextView) findViewById(R.id.fi0);
        this.Cnd = (TextView) findViewById(R.id.fi3);
        this.Cne = (WalletTextView) findViewById(R.id.fi4);
        this.Cne.setTypeface(0);
        this.mLine = findViewById(R.id.fi6);
        this.Cnf = (LinearLayout) findViewById(R.id.fi7);
        this.xBa = (Button) findViewById(R.id.fi5);
        this.xBa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(67742);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "mFinishBt click");
                MobileRemitResultUI.this.eNv();
                a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67742);
            }
        });
        a((ekk) null);
        AppMethodBeat.o(67748);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(67749);
        if (i2 == 4) {
            Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "onKeyUp KEYCODE_BACK click");
            eNv();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(67749);
        return onKeyUp;
    }

    private void a(final ekk ekk) {
        AppMethodBeat.i(67750);
        if (ekk == null) {
            Wd(this.Cnm);
            this.Cnc.post(new Runnable() {
                /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(67743);
                    int measuredWidth = MobileRemitResultUI.this.Cnc.getMeasuredWidth();
                    String string = MobileRemitResultUI.this.getString(R.string.f26, new Object[]{MobileRemitResultUI.this.Cnn});
                    String string2 = MobileRemitResultUI.this.getString(R.string.f27, new Object[]{MobileRemitResultUI.this.Cno});
                    if (measuredWidth != 0) {
                        float measureText = MobileRemitResultUI.this.jVn.getPaint().measureText(string);
                        float measureText2 = MobileRemitResultUI.this.Cnd.getPaint().measureText(string2);
                        if (measureText + measureText2 > ((float) measuredWidth)) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) MobileRemitResultUI.this.jVn.getLayoutParams();
                            layoutParams.width = (int) (((float) measuredWidth) - measureText2);
                            MobileRemitResultUI.this.jVn.setLayoutParams(layoutParams);
                        }
                    }
                    MobileRemitResultUI.this.jVn.setText(string);
                    MobileRemitResultUI.this.Cnd.setText(string2);
                    AppMethodBeat.o(67743);
                }
            });
            this.Cne.setText(f.d(((double) this.Cnj) / 100.0d, "CNY"));
            this.mLine.setVisibility(8);
            this.Cnf.setVisibility(8);
        } else {
            Wd(ekk.Nju);
            if (ekk.Njs != null) {
                this.CmS.setVisibility(0);
                this.yQS.setText(ekk.Njs.dQx);
                this.CmS.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI.AnonymousClass3 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(67746);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click!");
                        l.a(MobileRemitResultUI.this.getContext(), ekk.Njs, (Object) null, new com.tencent.mm.plugin.remittance.mobile.a.a() {
                            /* class com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitResultUI.AnonymousClass3.AnonymousClass1 */

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNw() {
                                AppMethodBeat.i(67744);
                                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:exit");
                                MobileRemitResultUI.this.eNv();
                                AppMethodBeat.o(67744);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void dP(Object obj) {
                                AppMethodBeat.i(67745);
                                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "notice click jumpItem.action:continue");
                                AppMethodBeat.o(67745);
                            }
                        });
                        a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitResultUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(67746);
                    }
                });
            }
            if (ekk.NjC == null || ekk.NjC.isEmpty()) {
                this.Cnf.setVisibility(8);
                this.mLine.setVisibility(8);
            } else {
                for (int i2 = 0; i2 < ekk.NjC.size(); i2++) {
                    cfz cfz = ekk.NjC.get(i2);
                    View inflate = getLayoutInflater().inflate(R.layout.bb7, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.e62)).setText(cfz.key);
                    ((TextView) inflate.findViewById(R.id.j2h)).setText(cfz.value);
                    this.Cnf.addView(inflate);
                }
                this.Cnf.setVisibility(0);
                this.mLine.setVisibility(0);
            }
        }
        p.a((Context) getContext(), (ScrollView) findViewById(R.id.h9a), findViewById(R.id.aay), findViewById(R.id.abk), findViewById(R.id.aaq), 48);
        AppMethodBeat.o(67750);
    }

    private void Wd(int i2) {
        AppMethodBeat.i(67751);
        if (i2 == 0) {
            this.Cnb.setImageDrawable(com.tencent.mm.cb.a.l(this, R.raw.icons_filled_done2));
            this.Cnb.getDrawable().setColorFilter(getResources().getColor(R.color.Brand), PorterDuff.Mode.SRC_ATOP);
            AppMethodBeat.o(67751);
            return;
        }
        this.Cnb.setImageDrawable(com.tencent.mm.cb.a.l(this, R.raw.icons_filled_time));
        this.Cnb.getDrawable().setColorFilter(getResources().getColor(R.color.Blue), PorterDuff.Mode.SRC_ATOP);
        AppMethodBeat.o(67751);
    }

    @Override // com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67752);
        super.onDestroy();
        removeSceneEndListener(1903);
        AppMethodBeat.o(67752);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        ekk ekk;
        AppMethodBeat.i(67753);
        Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (i2 == 0 && i3 == 0 && (qVar instanceof e)) {
            e eVar = (e) qVar;
            if (eVar.Cma == null) {
                ekk = null;
            } else {
                ekk = eVar.Cma;
            }
            if (ekk == null) {
                Log.e("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage succPageResp is null");
                AppMethodBeat.o(67753);
                return true;
            } else if (ekk.pTZ == 0) {
                a(ekk);
            } else {
                Log.i("MicroMsg.mobileRemit.MobileRemitResultUI", "NetSceneMobileRemitGetSuccPage ret_code:%s ret_msg:%s", Integer.valueOf(ekk.pTZ), ekk.pUa);
            }
        }
        AppMethodBeat.o(67753);
        return false;
    }
}
