package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletPayDeductUI extends MMPreference implements View.OnClickListener, i {
    protected Orders CwO;
    protected ArrayList<Preference> HGB;
    protected TextView HGC;
    private TextView HGD;
    private TextView HGE;
    private String HGF;
    private String HGG;
    private Bankcard HGH;
    protected boolean HGI = false;
    private int HGJ = 0;
    private String HGK;
    protected MMSwitchBtn jBx;
    protected Button krs;
    protected f nRm;
    private String pTK;
    private Dialog tipDialog = null;
    private LinearLayout ykB;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void c(WalletPayDeductUI walletPayDeductUI) {
        AppMethodBeat.i(69385);
        walletPayDeductUI.fOv();
        AppMethodBeat.o(69385);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69374);
        super.onCreate(bundle);
        this.nRm = getPreferenceScreen();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.afz)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.id.brt);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.ac_));
            }
            View findViewById2 = customView.findViewById(16908309);
            if (findViewById2 != null && (findViewById2 instanceof TextView)) {
                ((TextView) findViewById2).setTextColor(getResources().getColor(R.color.afz));
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            if (d.oD(23)) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.afz));
            } else {
                getWindow().setStatusBarColor(getResources().getColor(R.color.BW_90));
            }
        }
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.WalletPayDeductUI", "intent is null");
            finish();
            AppMethodBeat.o(69374);
            return;
        }
        this.CwO = (Orders) intent.getParcelableExtra("orders");
        if (this.CwO == null || this.CwO.HZi == null) {
            Log.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.CwO);
            finish();
        }
        hW(this.CwO.HZi.HZR);
        setResult(0);
        setBackBtn(new y() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.y
            public final void ane() {
                AppMethodBeat.i(69369);
                WalletPayDeductUI.this.setResult(0);
                WalletPayDeductUI.this.finish();
                AppMethodBeat.o(69369);
            }
        }, R.raw.actionbar_icon_dark_back);
        g.aAi();
        g.aAg().hqi.a(385, this);
        initView();
        AppMethodBeat.o(69374);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(69375);
        super.onResume();
        AppMethodBeat.o(69375);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(69376);
        super.onDestroy();
        g.aAi();
        g.aAg().hqi.b(385, this);
        AppMethodBeat.o(69376);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(69377);
        this.HGC = (TextView) getContentView().findViewById(R.id.a4y);
        this.krs = (Button) getContentView().findViewById(R.id.fz0);
        this.ykB = (LinearLayout) findViewById(R.id.g9n);
        ((TextView) findViewById(R.id.bl9)).setText(this.CwO.HZi.title);
        ((TextView) findViewById(R.id.ipm)).setText(this.CwO.HZd.get(0).desc);
        WalletTextView walletTextView = (WalletTextView) findViewById(R.id.ced);
        walletTextView.setTypeface(0);
        walletTextView.setText(com.tencent.mm.wallet_core.ui.f.bpq(this.CwO.AOl));
        ((TextView) findViewById(R.id.ceb)).setText(new StringBuilder().append(this.CwO.HZd.get(0).qwJ).toString());
        TextView textView = (TextView) findViewById(R.id.d8v);
        TextView textView2 = (TextView) findViewById(R.id.bl8);
        if (!Util.isNullOrNil(this.CwO.HZi.HZT)) {
            textView2.setText(this.CwO.HZi.HZT);
            if (!Util.isNullOrNil(this.CwO.HZi.HZU)) {
                textView2.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(this.CwO.HZi.HZU, true));
            }
        } else {
            textView2.setVisibility(8);
        }
        this.HGD = (TextView) findViewById(R.id.bla);
        this.HGE = (TextView) findViewById(R.id.a0c);
        if (this.CwO.HZi.HHv == 1) {
            z = true;
        } else {
            z = false;
        }
        this.HGI = z;
        this.HGJ = this.CwO.HZi.HGJ;
        this.pTK = this.CwO.HZi.pTK;
        this.HGK = this.CwO.HZi.HGK;
        Log.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", Boolean.valueOf(this.HGI), Integer.valueOf(this.HGJ));
        if (this.HGJ == 0) {
            this.jBx = (MMSwitchBtn) findViewById(R.id.b0m);
            this.jBx.setCheck(this.HGI);
            this.jBx.setSwitchListener(new MMSwitchBtn.a() {
                /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
                public final void onStatusChange(boolean z) {
                    int i2 = 2;
                    AppMethodBeat.i(69370);
                    WalletPayDeductUI.this.xV(z);
                    if (WalletPayDeductUI.this.CwO != null) {
                        h hVar = h.INSTANCE;
                        Object[] objArr = new Object[2];
                        if (z) {
                            i2 = 1;
                        }
                        objArr[0] = Integer.valueOf(i2);
                        objArr[1] = WalletPayDeductUI.this.CwO.dDL;
                        hVar.a(15379, objArr);
                    }
                    AppMethodBeat.o(69370);
                }
            });
            xV(this.HGI);
        } else {
            if (!Util.isNullOrNil(this.pTK)) {
                this.krs.setText(this.pTK);
            }
            if (!Util.isNullOrNil(this.HGK)) {
                this.HGC.setText(this.HGK);
                this.HGC.setVisibility(0);
            }
            findViewById(R.id.bl7).setVisibility(8);
            fOw();
        }
        Log.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", Integer.valueOf(this.CwO.HZi.HZS));
        if (this.CwO.HZi.HZS == 1) {
            g.aAi();
            this.HGG = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, "");
            g.aAi();
            this.HGF = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, "");
            if (Util.isNullOrNil(this.HGF) || Util.isNullOrNil(this.HGF)) {
                Log.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
                this.tipDialog = com.tencent.mm.wallet_core.ui.h.a((Context) getContext(), false, (DialogInterface.OnCancelListener) null);
                m mVar = new m();
                g.aAi();
                g.aAg().hqi.a(mVar, 0);
            } else {
                this.HGE.setText(this.HGG);
                fOv();
            }
        } else {
            this.ykB.setVisibility(8);
        }
        if (!Util.isNullOrNil(this.CwO.HZi.HZQ)) {
            String string = getString(R.string.ibp);
            String string2 = getString(R.string.ibq);
            SpannableString c2 = l.c(this, getString(R.string.ibo, new Object[]{string, string2}));
            com.tencent.mm.plugin.wallet_core.ui.l lVar = new com.tencent.mm.plugin.wallet_core.ui.l(getContext());
            SpannableString spannableString = new SpannableString(c2);
            spannableString.setSpan(lVar, c2.length() - string2.length(), c2.length(), 33);
            textView.setTextColor(getResources().getColor(R.color.uj));
            textView.setText(spannableString);
            textView.setOnClickListener(this);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        this.krs.setOnClickListener(this);
        AppMethodBeat.o(69377);
    }

    private void fOv() {
        AppMethodBeat.i(69378);
        s.fOg();
        an fOh = s.fOh();
        if (this.HGH == null) {
            this.HGH = fOh.a(null, null, true, true, true);
        }
        if (this.HGH == null) {
            Log.i("MicroMsg.WalletPayDeductUI", "no bank card!");
            finish();
            AppMethodBeat.o(69378);
            return;
        }
        SpannableString spannableString = new SpannableString(this.HGH.field_desc);
        com.tencent.mm.plugin.wallet_core.ui.l lVar = new com.tencent.mm.plugin.wallet_core.ui.l(getContext());
        final List<Bankcard> fQT = af.fQT();
        lVar.IgH = new l.a() {
            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(69372);
                AppCompatActivity context = WalletPayDeductUI.this.getContext();
                List<Bankcard> list = fQT;
                String str = WalletPayDeductUI.this.HGF;
                Bankcard bankcard = WalletPayDeductUI.this.HGH;
                AnonymousClass1 r6 = new h.a() {
                    /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.a
                    public final void Vq(int i2) {
                        AppMethodBeat.i(69371);
                        WalletPayDeductUI.this.HGH = (Bankcard) fQT.get(i2);
                        WalletPayDeductUI.c(WalletPayDeductUI.this);
                        AppMethodBeat.o(69371);
                    }
                };
                LinkedList linkedList = new LinkedList();
                if ((list == null || list.size() == 0) && Util.isNullOrNil((String) null)) {
                    Log.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
                    AppMethodBeat.o(69372);
                    return;
                }
                if (list == null || list.size() == 0) {
                    Log.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
                    linkedList.add(null);
                    i2 = 0;
                } else {
                    int i3 = 0;
                    i2 = 0;
                    for (Bankcard bankcard2 : list) {
                        linkedList.add(bankcard2.field_desc);
                        if (bankcard != null && bankcard.equals(bankcard2)) {
                            i2 = i3;
                        }
                        i3++;
                    }
                    if (!Util.isNullOrNil((String) null)) {
                        linkedList.add(null);
                        if (bankcard == null) {
                            i2 = i3;
                        }
                    }
                }
                com.tencent.mm.ui.base.h.a(context, str, linkedList, i2, r6);
                AppMethodBeat.o(69372);
            }
        };
        spannableString.setSpan(lVar, 0, spannableString.length(), 18);
        this.HGD.setText(spannableString);
        this.HGD.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(69378);
    }

    /* access modifiers changed from: protected */
    public final void xV(boolean z) {
        AppMethodBeat.i(69379);
        if (z) {
            findViewById(16908298).setVisibility(0);
            if (this.CwO.HZi.HZS == 1) {
                this.ykB.setVisibility(0);
            } else {
                this.ykB.setVisibility(8);
            }
            fOw();
            if (t.fQI().fRk()) {
                this.HGC.setVisibility(8);
                this.krs.setText(R.string.ibu);
            } else {
                this.HGC.setVisibility(0);
                this.HGC.setText(R.string.ibt);
                this.krs.setText(R.string.ibr);
            }
        } else {
            if (this.HGB != null && this.HGB.size() > 0) {
                int size = this.HGB.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.nRm.m38do(this.HGB.get(i2).mKey, true);
                }
            }
            findViewById(16908298).setVisibility(8);
            this.ykB.setVisibility(8);
            this.HGC.setVisibility(8);
            this.krs.setText(R.string.ibs);
        }
        Log.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.jBx.QDw);
        AppMethodBeat.o(69379);
    }

    private void fOw() {
        AppMethodBeat.i(69380);
        if (this.HGB == null || this.HGB.size() <= 0) {
            AppMethodBeat.o(69380);
            return;
        }
        int size = this.HGB.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.nRm.m38do(this.HGB.get(i2).mKey, false);
        }
        this.nRm.notifyDataSetChanged();
        AppMethodBeat.o(69380);
    }

    private void hW(List<Orders.DeductShowInfo> list) {
        AppMethodBeat.i(69381);
        if (list == null || list.size() == 0) {
            Log.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
            AppMethodBeat.o(69381);
            return;
        }
        if (this.HGB == null) {
            int size = list.size();
            this.HGB = new ArrayList<>();
            for (int i2 = 0; i2 < size; i2++) {
                final Orders.DeductShowInfo deductShowInfo = list.get(i2);
                if (deductShowInfo != null && !Util.isNullOrNil(deductShowInfo.name)) {
                    com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this);
                    gVar.setTitle(deductShowInfo.name);
                    if (deductShowInfo.gTx > 0) {
                        gVar.AQA = getResources().getColor(R.color.x0);
                        String str = deductShowInfo.value;
                        AnonymousClass4 r6 = new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.pay.ui.WalletPayDeductUI.AnonymousClass4 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(69373);
                                b bVar = new b();
                                bVar.bm(view);
                                a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                Log.i("MicroMsg.WalletPayDeductUI", "click link_type: %s", Integer.valueOf(deductShowInfo.gTx));
                                if (deductShowInfo.gTx == 1) {
                                    if (!Util.isNullOrNil(deductShowInfo.HZX)) {
                                        Intent intent = new Intent();
                                        intent.putExtra("rawUrl", deductShowInfo.HZX);
                                        intent.putExtra("showShare", false);
                                        com.tencent.mm.wallet_core.ui.f.aA(WalletPayDeductUI.this.getContext(), intent);
                                    }
                                } else if (deductShowInfo.gTx == 2) {
                                    wq wqVar = new wq();
                                    wqVar.ecI.userName = deductShowInfo.HZV;
                                    wqVar.ecI.ecK = Util.nullAs(deductShowInfo.HZW, "");
                                    wqVar.ecI.scene = 1097;
                                    wqVar.ecI.ecL = 0;
                                    EventCenter.instance.publish(wqVar);
                                }
                                a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(69373);
                            }
                        };
                        gVar.mContent = str;
                        gVar.mClickable = true;
                        gVar.hEZ = r6;
                    } else {
                        gVar.mContent = deductShowInfo.value;
                        gVar.mClickable = false;
                    }
                    gVar.setKey("deduct_info_".concat(String.valueOf(i2)));
                    this.HGB.add(gVar);
                    this.nRm.c(gVar);
                    this.nRm.m38do(gVar.mKey, true);
                }
            }
        }
        AppMethodBeat.o(69381);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.base.preference.MMPreference
    public int getLayoutId() {
        return R.layout.c_d;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        return false;
    }

    public void onClick(View view) {
        AppMethodBeat.i(69382);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        int id = view.getId();
        if (id == R.id.fz0) {
            Intent intent = new Intent();
            if (this.HGJ == 0) {
                intent.putExtra("auto_deduct_flag", this.jBx.QDw ? 1 : 0);
            } else {
                intent.putExtra("auto_deduct_flag", this.CwO.HZi.HHv);
            }
            if (this.HGH != null) {
                intent.putExtra("deduct_bank_type", this.HGH.field_bankcardType);
                intent.putExtra("deduct_bind_serial", this.HGH.field_bindSerial);
                Log.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", this.HGH.field_bankcardType);
            }
            setResult(-1, intent);
            finish();
        } else if (id == R.id.d8v && !Util.isNullOrNil(this.CwO.HZi.HZQ)) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", this.CwO.HZi.HZQ);
            intent2.putExtra("showShare", false);
            com.tencent.mm.wallet_core.ui.f.aA(getContext(), intent2);
        }
        a.a(this, "com/tencent/mm/plugin/wallet/pay/ui/WalletPayDeductUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69382);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(69383);
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(69383);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69384);
        Log.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (!(qVar instanceof m)) {
            Log.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
        } else if (i2 == 0 && i3 == 0) {
            g.aAi();
            this.HGG = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_DEDUCT_CHANGE_WORDING_STRING, getString(R.string.ini));
            g.aAi();
            this.HGF = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_DEDUCT_SELECT_WORDING_STRING, getString(R.string.inl));
            this.HGE.setText(this.HGG);
            fOv();
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(69384);
    }
}
