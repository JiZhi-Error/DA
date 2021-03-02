package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.ndk.Encrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI extends WalletBaseUI implements WalletFormView.a {
    IListener HDJ = new IListener<zr>() {
        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.AnonymousClass8 */

        {
            AppMethodBeat.i(160869);
            this.__eventId = zr.class.getName().hashCode();
            AppMethodBeat.o(160869);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(zr zrVar) {
            return false;
        }
    };
    private ArrayList<Bankcard> HDi = new ArrayList<>();
    private Bankcard HJA;
    private a HJB;
    private WalletFormView HJC;
    private WalletFormView HJD;
    private int HJE = 1;
    private boolean HJF = false;
    private boolean HJG = false;
    IListener HJH = new IListener<tg>() {
        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.AnonymousClass7 */

        {
            AppMethodBeat.i(160868);
            this.__eventId = tg.class.getName().hashCode();
            AppMethodBeat.o(160868);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tg tgVar) {
            AppMethodBeat.i(69657);
            tg tgVar2 = tgVar;
            if (!(tgVar2 instanceof tg)) {
                Log.f("MicroMsg.WalletForgotPwdUI", "mismatched ScanBankCardResultEvent event");
                AppMethodBeat.o(69657);
                return false;
            }
            Encrypt encrypt = new Encrypt();
            String randomKey = encrypt.getRandomKey();
            WalletForgotPwdUI.a(WalletForgotPwdUI.this, encrypt.desedeEncode(tgVar2.dZH.cardId, randomKey), randomKey, tgVar2.dZH.dZI);
            AppMethodBeat.o(69657);
            return true;
        }
    };
    private List<ElementQuery> HJz = new LinkedList();
    private LinearLayout gCh;
    private Button gxv;
    private ListView hUI;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletForgotPwdUI() {
        AppMethodBeat.i(69665);
        AppMethodBeat.o(69665);
    }

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI) {
        AppMethodBeat.i(69679);
        walletForgotPwdUI.bpv();
        AppMethodBeat.o(69679);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69666);
        super.onCreate(bundle);
        setMMTitle(R.string.ime);
        this.HJG = getInput().getBoolean("key_is_force_bind", false);
        if (!this.HJG) {
            doSceneProgress(new ad(null, 6));
            setContentViewVisibility(4);
        }
        initView();
        EventCenter.instance.addListener(this.HJH);
        EventCenter.instance.addListener(this.HDJ);
        AppMethodBeat.o(69666);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(69667);
        EventCenter.instance.removeListener(this.HJH);
        EventCenter.instance.removeListener(this.HDJ);
        super.onDestroy();
        AppMethodBeat.o(69667);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69668);
        super.onResume();
        update();
        AppMethodBeat.o(69668);
    }

    private void update() {
        AppMethodBeat.i(69669);
        s.fOg();
        this.HDi = s.fOh().fRE();
        if (this.HDi == null || this.HDi.size() == 0 || this.HJG) {
            Log.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", Boolean.valueOf(this.HJG));
            this.HDi = new ArrayList<>();
            this.gCh.setVisibility(0);
            this.hUI.setVisibility(8);
            setMMTitle(R.string.ic_);
            ((TextView) findViewById(R.id.jft)).setText(getString(R.string.il7));
            WalletFormView walletFormView = this.HJD;
            s.fOg();
            walletFormView.setText(f.bpu(s.fOh().getTrueName()));
            AppMethodBeat.o(69669);
            return;
        }
        Log.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
        if (com.tencent.mm.wallet_core.a.by(this) != null) {
            doSceneForceProgress(new y());
        }
        this.gCh.setVisibility(8);
        this.gxv.setVisibility(8);
        findViewById(R.id.fk1).setVisibility(0);
        this.HJB = new a(this);
        this.hUI.setAdapter((ListAdapter) this.HJB);
        this.HJB.iHf = this.HDi;
        this.HJB.notifyDataSetChanged();
        AppMethodBeat.o(69669);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69670);
        this.hUI = (ListView) findViewById(R.id.hmq);
        this.gCh = (LinearLayout) findViewById(R.id.d97);
        this.HJD = (WalletFormView) findViewById(R.id.fte);
        this.HJC = (WalletFormView) findViewById(R.id.am7);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.HJC);
        if (getInput().getBoolean("key_is_paymanager", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.HJD);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.HJD);
        }
        this.HJD.setOnInputValidChangeListener(this);
        this.HJC.setOnInputValidChangeListener(this);
        this.gxv = (Button) findViewById(R.id.fz0);
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(69651);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11353, 1, 0);
                WalletForgotPwdUI.a(WalletForgotPwdUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69651);
            }
        });
        this.HJF = false;
        s.fOg();
        this.HDi = s.fOh().fRE();
        update();
        findViewById(R.id.fk1).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(69652);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                f.p(WalletForgotPwdUI.this, HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/scene_product.html?scene_id=kf3258", false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69652);
            }
        });
        bqg();
        setEditFocusListener(this.HJC, 0, false, false);
        this.HJC.setOnInfoIvClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(69653);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11353, 2, 0);
                WalletForgotPwdUI walletForgotPwdUI = WalletForgotPwdUI.this;
                s.fOg();
                f.d(walletForgotPwdUI, s.fOh().getTrueName());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(69653);
            }
        });
        this.HJC.getInfoIv().setClickable(true);
        this.HJC.getInfoIv().setImageResource(R.raw.wallet_scan_camera);
        this.HJC.getInfoIv().setVisibility(0);
        AppMethodBeat.o(69670);
    }

    private void fPf() {
        AppMethodBeat.i(69671);
        getInput().remove("elemt_query");
        getInput().remove("key_bankcard");
        getInput().remove("bank_name");
        getInput().remove("key_card_id");
        AppMethodBeat.o(69671);
    }

    private void bpv() {
        ElementQuery elementQuery;
        AppMethodBeat.i(69672);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_reset_with_new_card", getInput().getBoolean("key_is_reset_with_new_card", false));
        fPf();
        if (this.HJA == null && !this.HJF) {
            doSceneProgress(new y(null, this.HJC.getText(), null));
            AppMethodBeat.o(69672);
        } else if (this.HJF) {
            am fRN = t.fQD().fRN();
            if (!Util.isNullOrNil(fRN.field_find_passwd_url)) {
                Log.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
                f.p(this, fRN.field_find_passwd_url, false);
                AppMethodBeat.o(69672);
                return;
            }
            bundle.putBoolean("key_is_force_bind", true);
            bundle.putBoolean("key_is_reset_with_new_card", true);
            if (getProcess() != null) {
                getProcess().a(this, 0, bundle);
            }
            AppMethodBeat.o(69672);
        } else {
            d by = com.tencent.mm.wallet_core.a.by(this);
            bundle.putParcelable("key_bankcard", this.HJA);
            ElementQuery elementQuery2 = new ElementQuery();
            Iterator<ElementQuery> it = this.HJz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    elementQuery = elementQuery2;
                    break;
                }
                elementQuery = it.next();
                Log.i("MicroMsg.WalletForgotPwdUI", "helios:::" + elementQuery.dDj);
                if (!Util.isNullOrNil(elementQuery.dDj) && !Util.isNullOrNil(this.HJA.field_bankcardType) && elementQuery.dDj.trim().equals(this.HJA.field_bankcardType.trim())) {
                    break;
                }
            }
            bundle.putParcelable("elemt_query", elementQuery);
            if (by != null) {
                by.a(this, 0, bundle);
            }
            AppMethodBeat.o(69672);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c92;
    }

    public class a extends BaseAdapter {
        private Context context;
        List<Bankcard> iHf = new ArrayList();

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(69664);
            Bankcard aeu = aeu(i2);
            AppMethodBeat.o(69664);
            return aeu;
        }

        public a(Context context2) {
            AppMethodBeat.i(69660);
            this.context = context2;
            AppMethodBeat.o(69660);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            WalletFormView walletFormView;
            AppMethodBeat.i(69661);
            if (view == null) {
                walletFormView = (WalletFormView) View.inflate(this.context, R.layout.c7t, null);
            } else {
                walletFormView = (WalletFormView) view;
            }
            final Bankcard aeu = aeu(i2);
            if (aeu != null) {
                String str = aeu.field_desc;
                if (aeu.field_bankcardState == 1) {
                    str = str + this.context.getString(R.string.id4);
                }
                walletFormView.setText(str);
            }
            walletFormView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(69659);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$ChoiceBankAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (aeu == null || aeu.field_bankcardState != 1) {
                        WalletForgotPwdUI.this.HJA = aeu;
                        WalletForgotPwdUI.this.HJF = false;
                        WalletForgotPwdUI.a(WalletForgotPwdUI.this);
                    } else {
                        d.a aVar = new d.a(a.this.context);
                        aVar.aoS(R.string.id2);
                        aVar.aoV(R.string.id3).c(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.a.AnonymousClass1.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(69658);
                                f.p(a.this.context, HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1p) + "/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                                AppMethodBeat.o(69658);
                            }
                        });
                        aVar.aoW(R.string.w1);
                        aVar.Dk(false);
                        aVar.hbn().show();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$ChoiceBankAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69659);
                }
            });
            AppMethodBeat.o(69661);
            return walletFormView;
        }

        public final int getCount() {
            AppMethodBeat.i(69662);
            int size = this.iHf.size();
            AppMethodBeat.o(69662);
            return size;
        }

        private Bankcard aeu(int i2) {
            AppMethodBeat.i(69663);
            if (i2 < 0 || i2 > this.iHf.size() - 1) {
                AppMethodBeat.o(69663);
                return null;
            }
            Bankcard bankcard = this.iHf.get(i2);
            AppMethodBeat.o(69663);
            return bankcard;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        int size;
        AppMethodBeat.i(69673);
        Log.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", Integer.valueOf(i3), str, qVar);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof y) {
                y yVar = (y) qVar;
                Bundle bundle = new Bundle();
                if (Util.isNullOrNil(yVar.pQH)) {
                    this.HJz = yVar.HQe;
                    Log.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
                    AppMethodBeat.o(69673);
                    return true;
                } else if (yVar.HQf == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.HJC.getText());
                    bundle.putBoolean("key_is_reset_with_new_card", true);
                    com.tencent.mm.wallet_core.a.l(this, bundle);
                } else if (yVar.HQf.isError()) {
                    Log.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
                    com.tencent.mm.ui.base.h.n(this, R.string.i7k, R.string.zb);
                    AppMethodBeat.o(69673);
                    return true;
                } else {
                    Object[] objArr = new Object[1];
                    if (this.HDi == null) {
                        size = 0;
                    } else {
                        size = this.HDi.size();
                    }
                    objArr[0] = Integer.valueOf(size);
                    Log.i("MicroMsg.WalletForgotPwdUI", "scene case 3 bankcards size %d", objArr);
                    if (this.HDi == null || this.HDi.size() == 0) {
                        fPf();
                        bundle.putString("bank_name", yVar.HQf.ynT);
                        bundle.putParcelable("elemt_query", yVar.HQf);
                        bundle.putString("key_card_id", this.HJC.getText());
                        bundle.putBoolean("key_is_reset_with_new_card", true);
                        com.tencent.mm.wallet_core.a.l(this, bundle);
                        AppMethodBeat.o(69673);
                        return true;
                    }
                }
            } else if (qVar instanceof ad) {
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(this.HJB == null);
                Log.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter is null ? %s", objArr2);
                if (this.HJB != null) {
                    ArrayList<Bankcard> arrayList = null;
                    if (t.fQI() != null) {
                        arrayList = t.fQI().fRE();
                    }
                    com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(this);
                    if (by != null) {
                        by.hgI();
                        ArrayList<Bankcard> arrayList2 = new ArrayList<>();
                        ArrayList<Bankcard> arrayList3 = new ArrayList<>();
                        Iterator<Bankcard> it = arrayList.iterator();
                        while (it.hasNext()) {
                            Bankcard next = it.next();
                            if (next.field_bankcardTag == 1) {
                                arrayList2.add(next);
                            } else if (next.field_bankcardTag == 2) {
                                arrayList3.add(next);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            this.HDi = arrayList2;
                        } else {
                            this.HDi = arrayList3;
                        }
                    }
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf(this.HDi == null ? 0 : this.HDi.size());
                    Log.i("MicroMsg.WalletForgotPwdUI", "scene case queryBound adapter update bankcardsize:  %d", objArr3);
                    this.HJB.iHf = this.HDi;
                    new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(69654);
                            WalletForgotPwdUI.this.HJB.notifyDataSetChanged();
                            WalletForgotPwdUI.c(WalletForgotPwdUI.this);
                            AppMethodBeat.o(69654);
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(69673);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean checkProcLife() {
        return true;
    }

    private boolean bqg() {
        AppMethodBeat.i(69674);
        if (this.hUI.getVisibility() == 0 || (this.HJD.bql() && this.HJC.bql())) {
            this.gxv.setEnabled(true);
            this.gxv.setClickable(true);
            AppMethodBeat.o(69674);
            return true;
        }
        this.gxv.setEnabled(false);
        this.gxv.setClickable(false);
        AppMethodBeat.o(69674);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(69675);
        bqg();
        AppMethodBeat.o(69675);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean getCancelable() {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        AppMethodBeat.i(69676);
        if (this.HDi == null || this.HDi.size() == 0) {
            am fRN = t.fQD().fRN();
            if (!Util.isNullOrNil(fRN.field_find_passwd_url) || !Util.isNullOrNil(fRN.field_forget_passwd_url)) {
                AppMethodBeat.o(69676);
                return true;
            }
            AppMethodBeat.o(69676);
            return false;
        }
        AppMethodBeat.o(69676);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onProgressFinish() {
        AppMethodBeat.i(69677);
        setContentViewVisibility(isTransparent() ? 4 : 0);
        AppMethodBeat.o(69677);
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69678);
        super.onActivityResult(i2, i2, intent);
        if (i3 == -1 && 1 == i2) {
            this.HJC.set3DesValStr(intent.getStringExtra("key_bankcard_id"));
            bpv();
        }
        AppMethodBeat.o(69678);
    }

    static /* synthetic */ void c(WalletForgotPwdUI walletForgotPwdUI) {
        SpannableString spannableString;
        AppMethodBeat.i(69680);
        if (!"1".equals(t.fQD().fRN().field_reset_passwd_flag)) {
            Log.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new");
            AppMethodBeat.o(69680);
        } else if (!Util.isNullOrNil(t.fQD().fRN().field_find_passwd_url)) {
            Log.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new h5");
            ((ViewStub) walletForgotPwdUI.findViewById(R.id.d9_)).inflate();
            TextView textView = (TextView) walletForgotPwdUI.findViewById(R.id.d9a);
            l lVar = new l(walletForgotPwdUI);
            lVar.IgH = new l.a() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
                public final void onClick(View view) {
                    AppMethodBeat.i(69655);
                    WalletForgotPwdUI.this.HJF = true;
                    WalletForgotPwdUI.a(WalletForgotPwdUI.this);
                    AppMethodBeat.o(69655);
                }
            };
            if (t.fQI().fRt()) {
                String string = walletForgotPwdUI.getString(R.string.il2);
                spannableString = new SpannableString(string);
                spannableString.setSpan(lVar, string.length() - 12, string.length(), 33);
            } else {
                String string2 = walletForgotPwdUI.getString(R.string.il3);
                spannableString = new SpannableString(string2);
                spannableString.setSpan(lVar, 0, string2.length(), 18);
            }
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            AppMethodBeat.o(69680);
        } else {
            Log.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new directly");
            ((ViewStub) walletForgotPwdUI.findViewById(R.id.d99)).inflate();
            ((WalletFormView) walletForgotPwdUI.findViewById(R.id.a4i)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(69656);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    WalletForgotPwdUI.this.HJF = true;
                    WalletForgotPwdUI.a(WalletForgotPwdUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69656);
                }
            });
            AppMethodBeat.o(69680);
        }
    }

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.i(69681);
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putBoolean("key_is_reset_with_new_card", true);
        com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(walletForgotPwdUI);
        if (by != null) {
            by.a(walletForgotPwdUI, WalletConfirmCardIDUI.class, bundle, 1);
        }
        AppMethodBeat.o(69681);
    }
}
