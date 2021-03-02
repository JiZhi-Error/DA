package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class WalletBankcardManageUI extends WalletBaseUI {
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass3 */

        {
            AppMethodBeat.i(160857);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(160857);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(69101);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletBankcardManageUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(69101);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.WalletBankcardManageUI", "KindaBindCardEvent bindCard Succ");
                    WalletBankcardManageUI.this.xT(false);
                } else {
                    Log.i("MicroMsg.WalletBankcardManageUI", "KindaBindCardEvent bindCard Cancel");
                }
            }
            EventCenter.instance.removeListener(WalletBankcardManageUI.this.AJa);
            AppMethodBeat.o(69101);
            return true;
        }
    };
    protected ArrayList<Bankcard> HDi = new ArrayList<>();
    private ArrayList<Bankcard> HDj = new ArrayList<>();
    protected an HDk = null;
    private ListView HDl = null;
    private a HDm = null;
    private a HDn = null;
    private TextView HDo;
    private View HDp;
    private View HDq;
    private View HDr;
    private CdnImageView HDs;
    private TextView HDt;
    private n HDu;
    private AdapterView.OnItemClickListener ars = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass11 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(69112);
            b bVar = new b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            final Bankcard bankcard = (Bankcard) adapterView.getAdapter().getItem(i2);
            f.aqm(18);
            if (bankcard != null) {
                a aVar = WalletBankcardManageUI.this.HDm;
                if (aVar.HCI != null && !aVar.HCI.isEmpty()) {
                    Iterator<String> it = aVar.HCI.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (next.equals(bankcard.field_bindSerial)) {
                            Log.d("MicroMsg.BankcardListAdapter", "remove new: %s", next);
                            aVar.HCI.remove(next);
                            g.aAi();
                            g.aAh().azQ().set(ar.a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, Util.listToString(aVar.HCI, ","));
                            break;
                        }
                    }
                }
                if (bankcard.fQa()) {
                    if (bankcard.field_wxcreditState == 0) {
                        if (b.c(bankcard) && bankcard != null) {
                            g.aAi();
                            String str = (String) g.aAh().azQ().get(196659, (Object) null);
                            StringBuilder sb = new StringBuilder();
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str);
                                sb.append("&");
                                sb.append(bankcard.field_bankcardType);
                            } else {
                                sb.append(bankcard.field_bankcardType);
                            }
                            g.aAi();
                            g.aAh().azQ().set(196659, sb.toString());
                        }
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("key_bankcard", bankcard);
                        bundle.putString("key_bank_username", bankcard.field_bizUsername);
                        bundle.putString("key_bank_type", bankcard.field_bankcardType);
                        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditOpenProcess", bundle, (d.a) null);
                    } else {
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("key_bankcard", bankcard);
                        com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, "WXCreditManagerProcess", bundle2, (d.a) null);
                    }
                } else if (bankcard.fQf()) {
                    Log.i("MicroMsg.WalletBankcardManageUI", "do honey pay card back");
                    Intent intent = new Intent();
                    intent.putExtra("key_card_no", bankcard.field_bindSerial);
                    c.b(WalletBankcardManageUI.this, "honey_pay", ".ui.HoneyPayCardBackUI", intent);
                } else {
                    al fRs = t.fQI().fRs();
                    boolean z = (fRs.IbF & 4096) > 0;
                    Log.i("MicroMsg.WalletSwitchConfig", "isReportLocation, ret = %s switchBit %s", Boolean.valueOf(z), Integer.valueOf(fRs.IbF));
                    if (z) {
                        Log.i("MicroMsg.WalletBankcardManageUI", "jump to H5 bankcard detail page");
                        g.aAi();
                        g.aAi();
                        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_TIMESTAMP_LONG_SYNC, (Object) 0L)).longValue();
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        if (Util.isNullOrNil((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, "")) || currentTimeMillis - longValue >= 7200) {
                            Log.i("MicroMsg.WalletBankcardManageUI", "listen BankcardLogoReadyEvent for newest url");
                            EventCenter.instance.addListener(new IListener<aj>() {
                                /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass11.AnonymousClass1 */

                                {
                                    AppMethodBeat.i(160858);
                                    this.__eventId = aj.class.getName().hashCode();
                                    AppMethodBeat.o(160858);
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                                @Override // com.tencent.mm.sdk.event.IListener
                                public final /* synthetic */ boolean callback(aj ajVar) {
                                    AppMethodBeat.i(69111);
                                    EventCenter.instance.removeListener(this);
                                    Log.i("MicroMsg.WalletBankcardManageUI", "BankcardLogoReady,jump bank url");
                                    WalletBankcardManageUI.this.d(bankcard);
                                    AppMethodBeat.o(69111);
                                    return true;
                                }
                            });
                        } else {
                            Log.i("MicroMsg.WalletBankcardManageUI", "bank's url is not null");
                            WalletBankcardManageUI.this.d(bankcard);
                        }
                    } else {
                        WalletBankcardManageUI.this.e(bankcard);
                    }
                }
                h.INSTANCE.a(14422, 1, bankcard.field_bankcardType);
            } else {
                WalletBankcardManageUI.this.fOa();
                h.INSTANCE.a(14422, 2);
            }
            a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(69112);
        }
    };
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass10 */
        final int HDz = 1000;

        public final void onClick(View view) {
            AppMethodBeat.i(69110);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.jfi) {
                com.tencent.mm.plugin.wallet_core.model.g fQl = com.tencent.mm.plugin.wallet_core.model.g.fQl();
                if (fQl.bJw()) {
                    com.tencent.mm.ui.base.h.c(WalletBankcardManageUI.this, fQl.ANp, WalletBankcardManageUI.this.getString(R.string.zb), true);
                    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69110);
                    return;
                }
                f.aqm(19);
                WalletBankcardManageUI.this.fOa();
                h.INSTANCE.a(14422, 2);
            } else if (view.getId() == R.id.jfm) {
                Object tag = view.getTag();
                long time = new Date().getTime();
                view.setTag(Long.valueOf(time));
                if (tag == null || time - ((Long) tag).longValue() >= 1000) {
                    Intent intent = new Intent();
                    intent.putExtra(e.p.OzJ, true);
                    intent.putExtra("rawUrl", WalletBankcardManageUI.this.HDu.field_loan_jump_url);
                    f.aA(WalletBankcardManageUI.this.getContext(), intent);
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, Integer.valueOf(WalletBankcardManageUI.this.HDu.field_red_dot_index));
                    f.aqm(6);
                } else {
                    a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69110);
                    return;
                }
            }
            a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(69110);
        }
    };
    private ListView mListView = null;
    private u zmb = new u();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBankcardManageUI() {
        AppMethodBeat.i(69114);
        AppMethodBeat.o(69114);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c85;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69115);
        fixStatusbar(true);
        super.onCreate(bundle);
        setContentViewVisibility(4);
        Log.i("MicroMsg.WalletBankcardManageUI", "index Oncreate");
        s.fOg();
        this.HDk = s.fOh();
        setMMTitle(R.string.ie6);
        hideActionbarLine();
        initView();
        ab.mg(5, 0);
        f.aqm(27);
        h.INSTANCE.a(14422, 5);
        this.HDu = t.fQI().IbN;
        this.zmb.IkQ = new u.b() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final int eho() {
                return 1;
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.b
            public final Context getContext() {
                return WalletBankcardManageUI.this;
            }
        };
        AppMethodBeat.o(69115);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69116);
        if (!this.HDk.fRp()) {
            this.HDk.g(this.HDi, this.HDj);
            if (this.HDk.Hwc != null) {
                setContentViewVisibility(0);
            }
            xT(false);
        } else {
            xT(true);
        }
        this.zmb.onResume();
        updateView();
        super.onResume();
        AppMethodBeat.o(69116);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(69117);
        super.onPause();
        this.zmb.onPause();
        AppMethodBeat.o(69117);
    }

    /* access modifiers changed from: protected */
    public void xT(boolean z) {
        AppMethodBeat.i(69118);
        if (z) {
            doSceneForceProgress(new ad(null, 12));
            AppMethodBeat.o(69118);
            return;
        }
        doSceneProgress(new ad(null, 12), false);
        AppMethodBeat.o(69118);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69119);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            if (i3 == -1) {
                this.zmb.ehm();
                AppMethodBeat.o(69119);
                return;
            }
            this.zmb.cancel();
        }
        AppMethodBeat.o(69119);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69120);
        super.onDestroy();
        this.HDm.HCH.destory();
        this.HDn.HCH.destory();
        EventCenter.instance.removeListener(this.AJa);
        AppMethodBeat.o(69120);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69121);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69105);
                WalletBankcardManageUI.this.finish();
                h.INSTANCE.a(14422, 4);
                AppMethodBeat.o(69105);
                return true;
            }
        });
        this.HDo = (TextView) findViewById(R.id.jd8);
        this.HDo.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(69106);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletBankcardManageUI.this.fOa();
                f.aqm(19);
                h.INSTANCE.a(14422, 2);
                a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69106);
            }
        });
        this.mListView = (ListView) findViewById(R.id.a1q);
        this.HDm = fNZ();
        this.mListView.setAdapter((ListAdapter) this.HDm);
        this.mListView.setOnItemClickListener(this.ars);
        this.HDl = (ListView) findViewById(R.id.j8l);
        this.HDn = new a(this, this.HDj);
        this.HDl.setAdapter((ListAdapter) this.HDn);
        this.HDl.setOnItemClickListener(this.ars);
        this.HDp = findViewById(R.id.jfi);
        this.HDp.setOnClickListener(this.kuO);
        this.HDq = findViewById(R.id.jfm);
        this.HDq.setOnClickListener(this.kuO);
        this.HDr = findViewById(R.id.jfk);
        this.HDs = (CdnImageView) findViewById(R.id.jfl);
        this.HDt = (TextView) findViewById(R.id.jfj);
        fNY();
        final zt ztVar = new zt();
        ztVar.efM.scene = "4";
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(69107);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    f.a((TextView) WalletBankcardManageUI.this.findViewById(R.id.a2b), ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                    AppMethodBeat.o(69107);
                    return;
                }
                Log.i("MicroMsg.WalletBankcardManageUI", "no bulletin data");
                AppMethodBeat.o(69107);
            }
        };
        EventCenter.instance.publish(ztVar);
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69104);
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) WalletBankcardManageUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(69102);
                        mVar.kV(0, R.string.i87);
                        AppMethodBeat.o(69102);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass4.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(69103);
                        int itemId = menuItem.getItemId();
                        Log.i("MicroMsg.WalletBankcardManageUI", "operType：%s", Integer.valueOf(itemId));
                        switch (itemId) {
                            case 0:
                                Intent intent = new Intent();
                                intent.putExtra(e.p.OzJ, true);
                                intent.putExtra("rawUrl", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/product/weixinpay_app.html?platform=15&ADTAG=veda.weixinpay.wenti");
                                f.aA(WalletBankcardManageUI.this.getContext(), intent);
                                h.INSTANCE.a(14422, 3);
                                break;
                        }
                        AppMethodBeat.o(69103);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(69104);
                return false;
            }
        });
        AppMethodBeat.o(69121);
    }

    private void fNY() {
        AppMethodBeat.i(69122);
        g.aAi();
        final com.tencent.mm.plugin.wallet_core.model.f aVf = com.tencent.mm.plugin.wallet_core.model.f.aVf((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BIND_CARD_MENU_STRING_SYNC, ""));
        if (aVf != null && !Util.isNullOrNil(aVf.HWm)) {
            if (!Util.isNullOrNil(aVf.HWn)) {
                this.HDs.setUrl(aVf.HWn);
            }
            this.HDt.setText(aVf.HWm);
            f.G(this.HDt);
            if (aVf.HWi == 1) {
                this.HDr.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass8 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(69108);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (!Util.isNullOrNil(aVf.HWj)) {
                            f.o(WalletBankcardManageUI.this.getContext(), aVf.HWj, false);
                            h.INSTANCE.a(14422, 6);
                        }
                        a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(69108);
                    }
                });
                this.HDr.setVisibility(0);
                AppMethodBeat.o(69122);
                return;
            } else if (aVf.HWi == 2) {
                this.HDr.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass9 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(69109);
                        b bVar = new b();
                        bVar.bm(view);
                        a.b("com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        wq wqVar = new wq();
                        wqVar.ecI.userName = aVf.HWk;
                        wqVar.ecI.ecK = Util.nullAs(aVf.HWl, "");
                        wqVar.ecI.scene = 1071;
                        wqVar.ecI.ecL = 0;
                        EventCenter.instance.publish(wqVar);
                        h.INSTANCE.a(14422, 6);
                        a.a(this, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardManageUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(69109);
                    }
                });
                this.HDr.setVisibility(0);
                AppMethodBeat.o(69122);
                return;
            } else {
                Log.w("MicroMsg.WalletBankcardManageUI", "unknown type: %d", Integer.valueOf(aVf.HWi));
            }
        }
        this.HDr.setVisibility(8);
        AppMethodBeat.o(69122);
    }

    /* access modifiers changed from: protected */
    public a fNZ() {
        AppMethodBeat.i(69123);
        a aVar = new a(this, this.HDi);
        AppMethodBeat.o(69123);
        return aVar;
    }

    public final void d(Bankcard bankcard) {
        String str;
        AppMethodBeat.i(69124);
        g.aAi();
        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, "");
        if (!Util.isNullOrNil(str2)) {
            Log.i("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is not null");
            Intent intent = new Intent();
            String format = String.format("bank_type=%s&card_tail=%s&bind_serial=%s", bankcard.field_bankcardType, bankcard.field_bankcardTail, bankcard.field_bindSerial);
            if (str2.contains("?")) {
                str = str2 + "&" + format;
            } else {
                str = str2 + "?" + format;
            }
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("disable_bounce_scroll", true);
            intent.putExtra(e.p.OzJ, true);
            f.aA(getContext(), intent);
            AppMethodBeat.o(69124);
            return;
        }
        Log.e("MicroMsg.WalletBankcardManageUI", "jumpToH5BankDetail :: url is null");
        AppMethodBeat.o(69124);
    }

    /* access modifiers changed from: protected */
    public void e(Bankcard bankcard) {
        AppMethodBeat.i(69125);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_bankcard", bankcard);
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.bind.a.class, bundle, (d.a) null);
        AppMethodBeat.o(69125);
    }

    private void updateView() {
        AppMethodBeat.i(69126);
        if (this.HDk.fRp()) {
            this.HDo.setEnabled(false);
        } else {
            this.HDo.setEnabled(true);
        }
        if (this.HDi == null || this.HDi.size() <= 0) {
            this.mListView.setVisibility(8);
        } else {
            this.mListView.setVisibility(0);
        }
        if (this.HDj == null || this.HDj.size() <= 0) {
            this.HDl.setVisibility(8);
        } else {
            this.HDl.setVisibility(0);
        }
        if (this.HDu == null || this.HDu.field_is_show_entry != 1) {
            this.HDq.setVisibility(8);
        } else {
            ((TextView) this.HDq.findViewById(R.id.jfo)).setText(this.HDu.field_title);
            a(this.HDu);
            this.HDq.setVisibility(0);
        }
        this.HDm.aV(this.HDi);
        this.HDm.notifyDataSetChanged();
        this.HDn.aV(this.HDj);
        this.HDn.notifyDataSetChanged();
        this.HDo.setEnabled(true);
        AppMethodBeat.o(69126);
    }

    private void a(n nVar) {
        AppMethodBeat.i(69127);
        TextView textView = (TextView) findViewById(R.id.jfx);
        if (com.tencent.mm.plugin.wallet.b.a.aeG(nVar.field_red_dot_index)) {
            Log.i("MicroMsg.WalletBankcardManageUI", "red point update");
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R.id.jfn);
        if (nVar.field_is_overdue == 1) {
            Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.is_overdue = true");
            textView2.setText(R.string.i89);
            textView2.setTextColor(getResources().getColor(R.color.a5c));
        } else if (!Util.isNullOrNil(nVar.field_tips)) {
            Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.tips not null");
            textView2.setText(nVar.field_tips);
        } else if (!Util.isNullOrNil(nVar.field_available_otb)) {
            Log.i("MicroMsg.WalletBankcardManageUI", "loanEntryInfo.available_otb not null");
            int indexOf = nVar.field_available_otb.indexOf(".");
            String str = nVar.field_available_otb;
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
            }
            textView2.setText(getString(R.string.i88, new Object[]{str}));
        } else {
            textView2.setVisibility(8);
            AppMethodBeat.o(69127);
            return;
        }
        textView2.setVisibility(0);
        AppMethodBeat.o(69127);
    }

    /* access modifiers changed from: protected */
    public void fOa() {
        AppMethodBeat.i(69128);
        final Bundle bundle = new Bundle();
        final AnonymousClass12 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(69113);
                bundle.putInt("key_bind_scene", 15);
                bundle.putBoolean("key_bind_show_change_card", true);
                com.tencent.mm.wallet_core.b.hgC();
                if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
                    EventCenter.instance.add(WalletBankcardManageUI.this.AJa);
                    WalletBankcardManageUI.a(WalletBankcardManageUI.this, bundle);
                    AppMethodBeat.o(69113);
                    return;
                }
                com.tencent.mm.wallet_core.a.a(WalletBankcardManageUI.this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, (d.a) null);
                AppMethodBeat.o(69113);
            }
        };
        this.zmb.a(new u.a() {
            /* class com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
            public final void ehm() {
                AppMethodBeat.i(69098);
                r1.run();
                AppMethodBeat.o(69098);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
            public final void cancel() {
                AppMethodBeat.i(69099);
                WalletBankcardManageUI.this.zmb.dEF = false;
                AppMethodBeat.o(69099);
            }

            @Override // com.tencent.mm.plugin.wallet_core.ui.u.a
            public final void ehn() {
                AppMethodBeat.i(69100);
                r1.run();
                AppMethodBeat.o(69100);
            }
        }, new al().fRi());
        AppMethodBeat.o(69128);
    }

    /* access modifiers changed from: protected */
    public final void fOb() {
        AppMethodBeat.i(69129);
        setContentViewVisibility(0);
        this.HDk.g(this.HDi, this.HDj);
        updateView();
        fNY();
        AppMethodBeat.o(69129);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69130);
        Log.i("MicroMsg.WalletBankcardManageUI", "onSceneEnd");
        if (i2 == 0 && i3 == 0 && (qVar instanceof ad)) {
            this.HDu = t.fQI().IbN;
            fOb();
            AppMethodBeat.o(69130);
            return true;
        }
        AppMethodBeat.o(69130);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean checkProcLife() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(69131);
        if (!getIntent().getBooleanExtra("intent_finish_self", false)) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
            Log.i("MicroMsg.WalletBankcardManageUI", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
            if (a2) {
                c.b(this, "mall", ".ui.MallIndexUIv2", intent);
            } else {
                c.b(this, "mall", ".ui.MallIndexUI", intent);
            }
        }
        super.finish();
        AppMethodBeat.o(69131);
    }

    static /* synthetic */ void a(WalletBankcardManageUI walletBankcardManageUI, Bundle bundle) {
        AppMethodBeat.i(69132);
        Log.d("MicroMsg.WalletBankcardManageUI", "startKindaBindCard");
        if (bundle != null) {
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
        } else {
            ab.mg(6, 0);
            z.aqh(0);
        }
        ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(walletBankcardManageUI, bundle);
        AppMethodBeat.o(69132);
    }
}
