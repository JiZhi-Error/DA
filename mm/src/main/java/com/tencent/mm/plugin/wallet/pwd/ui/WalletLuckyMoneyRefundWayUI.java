package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.b.a.kv;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet.pwd.a.f;
import com.tencent.mm.protocal.protobuf.cqc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.f;
import java.util.Iterator;

public class WalletLuckyMoneyRefundWayUI extends MMPreference {
    private Preference HJg;
    private RadioBelowSummarytAndIconPreference HKi;
    private RadioBelowSummarytAndIconPreference HKj;
    private f.a HKk;
    private com.tencent.mm.ui.base.preference.f nRm;
    private long qAb;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69728);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getActionbarColor());
        String stringExtra = getIntent().getStringExtra("key_hb_refund_config");
        if (!Util.isNullOrNil(stringExtra)) {
            this.HKk = f.a.aUZ(stringExtra);
            Log.d("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig:%s", this.HKk);
        } else {
            Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mHbRefundConfig == null");
            finish();
        }
        this.nRm = getPreferenceScreen();
        this.nRm.addPreferencesFromResource(R.xml.de);
        setMMTitle(this.HKk.HHX);
        g.aAi();
        this.qAb = ((Long) g.aAh().azQ().get(ar.a.USERINFO_EXT_PAY_SETTING_LONG_SYNC, (Object) 0L)).longValue();
        Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "origin extStatus: %s", Long.toBinaryString(this.qAb));
        initView();
        AppMethodBeat.o(69728);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69729);
        this.HJg = this.nRm.bmg("refund_way_detail");
        this.HKi = (RadioBelowSummarytAndIconPreference) this.nRm.bmg("refund_way_detail_lq");
        this.HKj = (RadioBelowSummarytAndIconPreference) this.nRm.bmg("refund_way_detail_origin");
        if (this.HJg != null) {
            this.HJg.setTitle(this.HKk.HId);
        }
        if (this.HKi != null) {
            this.HKi.setTitle(this.HKk.HHZ);
            this.HKi.setSummary(this.HKk.HIa);
        }
        if (this.HKj != null) {
            this.HKj.setTitle(this.HKk.HIb);
            this.HKj.setSummary(this.HKk.HIc);
            RadioBelowSummarytAndIconPreference radioBelowSummarytAndIconPreference = this.HKj;
            AnonymousClass1 r1 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletLuckyMoneyRefundWayUI.AnonymousClass1 */

                public final void onClick(View view) {
                    LinearLayout.LayoutParams marginLayoutParams;
                    AppMethodBeat.i(69726);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "mOriginWay click!!");
                    a aVar = new a(WalletLuckyMoneyRefundWayUI.this, WalletLuckyMoneyRefundWayUI.this.HKk);
                    View inflate = View.inflate(aVar.mContext, R.layout.c_t, null);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.h8y);
                    if (aVar.HKk.HIf.size() > 0) {
                        Iterator<f.b> it = aVar.HKk.HIf.iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            f.b next = it.next();
                            int i3 = i2 + 1;
                            View inflate2 = View.inflate(aVar.mContext, R.layout.c_u, null);
                            linearLayout.addView(inflate2);
                            if (i3 != 1) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate2.getLayoutParams();
                                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                    marginLayoutParams = layoutParams;
                                } else {
                                    marginLayoutParams = new ViewGroup.MarginLayoutParams((ViewGroup.LayoutParams) layoutParams);
                                }
                                marginLayoutParams.setMargins(0, com.tencent.mm.cb.a.fromDPToPix(aVar.mContext, 24), 0, 0);
                                inflate2.setLayoutParams(marginLayoutParams);
                            }
                            ImageView imageView = (ImageView) inflate2.findViewById(R.id.dt5);
                            TextView textView = (TextView) inflate2.findViewById(R.id.ipm);
                            TextView textView2 = (TextView) inflate2.findViewById(R.id.idt);
                            if (Util.isNullOrNil(next.HIh)) {
                                com.tencent.mm.av.a.a.bdb().a(next.ivw, imageView, new c.a().bdv());
                            } else {
                                com.tencent.mm.av.a.a bdb = com.tencent.mm.av.a.a.bdb();
                                String str = next.ivw;
                                c.a aVar2 = new c.a();
                                aVar2.md5 = next.HIh;
                                bdb.a(str, imageView, aVar2.bdv());
                            }
                            textView.setText(next.title);
                            textView2.setText(next.desc);
                            i2 = i3;
                        }
                    }
                    f.a aVar3 = new f.a(aVar.mContext);
                    aVar3.aC(aVar.HKk.HIe).hu(inflate).boA(aVar.mContext.getString(R.string.iin)).apb(aVar.mContext.getResources().getColor(R.color.aep)).JnN = true;
                    aVar3.b(new f.c() {
                        /* class com.tencent.mm.plugin.wallet.pwd.ui.a.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.widget.a.f.c
                        public final void e(boolean z, String str) {
                            AppMethodBeat.i(69780);
                            Log.i("MicroMsg.WalletRefundTimeDialog", "onDialogClick() bOk:%s", Boolean.valueOf(z));
                            AppMethodBeat.o(69780);
                        }
                    }).show();
                    a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLuckyMoneyRefundWayUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69726);
                }
            };
            radioBelowSummarytAndIconPreference.aeN = R.drawable.clh;
            radioBelowSummarytAndIconPreference.HIG = r1;
        }
        if (Util.isEqual(this.qAb & 3, 2)) {
            fPi();
        } else {
            fPh();
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletLuckyMoneyRefundWayUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69727);
                WalletLuckyMoneyRefundWayUI.this.finish();
                AppMethodBeat.o(69727);
                return false;
            }
        });
        AppMethodBeat.o(69729);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(69730);
        super.onDestroy();
        cqc cqc = new cqc();
        if (UM(1)) {
            cqc.MvU = 1;
            cqc.MvV = 2;
        } else if (UM(2)) {
            cqc.MvU = 2;
            cqc.MvV = 1;
        }
        Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "doSettingsOplog() extStatus: %s, set_bitmask: %s, clear_bitmask:%s", Long.toBinaryString(this.qAb), Long.toBinaryString(cqc.MvU), Long.toBinaryString(cqc.MvV));
        ((l) g.af(l.class)).aSM().d(new k.a(218, cqc));
        AppMethodBeat.o(69730);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    private void aeD(int i2) {
        int i3;
        AppMethodBeat.i(69732);
        kv kvVar = new kv();
        if (Util.isEqual(this.qAb & 3, 2)) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        kvVar.esA = (long) i3;
        kvVar.eXx = (long) i2;
        kvVar.bfK();
        AppMethodBeat.o(69732);
    }

    private boolean UM(int i2) {
        return (this.qAb & ((long) i2)) != 0;
    }

    private void fPh() {
        AppMethodBeat.i(69733);
        this.HKi.setWidgetLayoutResource(R.layout.b_m);
        this.HKj.setWidgetLayoutResource(R.layout.b_n);
        AppMethodBeat.o(69733);
    }

    private void fPi() {
        AppMethodBeat.i(69734);
        this.HKi.setWidgetLayoutResource(R.layout.b_n);
        this.HKj.setWidgetLayoutResource(R.layout.b_m);
        AppMethodBeat.o(69734);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(69731);
        String str = preference.mKey;
        Log.i("MicroMsg.WalletLuckyMoneyRefundWayUI", "onPreferenceTreeClick() key:%s", str);
        if ("refund_way_detail_lq".equals(str)) {
            fPh();
            aeD(1);
            this.qAb |= 1;
            this.qAb &= -3;
        } else if ("refund_way_detail_origin".equals(str)) {
            fPi();
            aeD(2);
            this.qAb &= -2;
            this.qAb |= 2;
        }
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_EXT_PAY_SETTING_LONG_SYNC, Long.valueOf(this.qAb));
        this.nRm.notifyDataSetChanged();
        finish();
        AppMethodBeat.o(69731);
        return true;
    }
}
