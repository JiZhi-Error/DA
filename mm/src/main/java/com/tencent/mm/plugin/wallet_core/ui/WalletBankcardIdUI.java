package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.ndk.Encrypt;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI extends WalletBaseUI implements WalletFormView.a {
    IListener HDJ = new IListener<zr>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass1 */

        {
            AppMethodBeat.i(160880);
            this.__eventId = zr.class.getName().hashCode();
            AppMethodBeat.o(160880);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zr zrVar) {
            AppMethodBeat.i(70722);
            WalletBankcardIdUI.this.finish();
            AppMethodBeat.o(70722);
            return false;
        }
    };
    IListener HJH = new IListener<tg>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass2 */

        {
            AppMethodBeat.i(160881);
            this.__eventId = tg.class.getName().hashCode();
            AppMethodBeat.o(160881);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tg tgVar) {
            AppMethodBeat.i(70723);
            tg tgVar2 = tgVar;
            if (!(tgVar2 instanceof tg)) {
                Log.f("Micromsg.WalletInputCardIDUI", "mismatched ScanBankCardResultEvent event");
                AppMethodBeat.o(70723);
                return false;
            }
            Encrypt encrypt = new Encrypt();
            String randomKey = encrypt.getRandomKey();
            WalletBankcardIdUI.a(WalletBankcardIdUI.this, encrypt.desedeEncode(tgVar2.dZH.cardId, randomKey), randomKey, tgVar2.dZH.dZI);
            AppMethodBeat.o(70723);
            return true;
        }
    };
    protected WalletFormView Idp;
    protected WalletFormView Idq;
    private TextView Idr;
    private Bankcard Ids;
    private a Idt;
    private boolean Idu = false;
    private boolean Idv;
    private Button gxv;
    private int mScene = -1;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBankcardIdUI() {
        AppMethodBeat.i(70735);
        AppMethodBeat.o(70735);
    }

    static /* synthetic */ View e(WalletBankcardIdUI walletBankcardIdUI) {
        AppMethodBeat.i(70745);
        View contentView = walletBankcardIdUI.getContentView();
        AppMethodBeat.o(70745);
        return contentView;
    }

    static /* synthetic */ View f(WalletBankcardIdUI walletBankcardIdUI) {
        AppMethodBeat.i(70746);
        View contentView = walletBankcardIdUI.getContentView();
        AppMethodBeat.o(70746);
        return contentView;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c82;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70736);
        super.onCreate(bundle);
        setMMTitle(R.string.iel);
        initView();
        EventCenter.instance.addListener(this.HDJ);
        EventCenter.instance.addListener(this.HJH);
        this.mScene = getInput().getInt("key_bind_scene");
        AppMethodBeat.o(70736);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(70737);
        EventCenter.instance.removeListener(this.HDJ);
        EventCenter.instance.removeListener(this.HJH);
        super.onDestroy();
        AppMethodBeat.o(70737);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70738);
        this.gxv = (Button) findViewById(R.id.fz0);
        this.Idp = (WalletFormView) findViewById(R.id.ao9);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.Idp);
        this.Idq = (WalletFormView) findViewById(R.id.fte);
        if (getInput().getBoolean("key_bind_show_change_card", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.Idq);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Idq);
        }
        this.Idp.setOnInputValidChangeListener(this);
        this.gxv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(70724);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11353, 1, 0);
                WalletBankcardIdUI.this.bpv();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70724);
            }
        });
        d process = getProcess();
        if (process != null) {
            this.Idv = process.dQL.getBoolean("key_is_realname_verify_process", false);
        } else {
            this.Idv = false;
        }
        if (this.Idv) {
            setMMTitle(R.string.ipp);
        } else {
            setMMTitle(R.string.iel);
        }
        this.Idr = (TextView) findViewById(R.id.dyz);
        if (t.fQI().fRm() || t.fQI().fRl()) {
            l lVar = new l(this);
            lVar.IgH = new l.a() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.wallet_core.ui.l.a
                public final void onClick(View view) {
                    AppMethodBeat.i(70725);
                    Log.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
                    WalletBankcardIdUI.a(WalletBankcardIdUI.this);
                    AppMethodBeat.o(70725);
                }
            };
            String string = getString(R.string.iee);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(lVar, string.length() - 6, string.length(), 33);
            this.Idr.setText(spannableString);
            this.Idr.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            this.Idr.setVisibility(0);
            String string2 = getInput().getString("key_custom_bind_tips");
            if (!Util.isNullOrNil(string2)) {
                this.Idr.setText(string2);
            }
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) getInput().getParcelable("key_favor_pay_info");
        Orders orders = (Orders) getInput().getParcelable("key_orders");
        if (!(favorPayInfo == null || orders == null)) {
            d a2 = e.INSTANCE.a(orders);
            TextView textView = (TextView) findViewById(R.id.jes);
            if (a2 != null) {
                List<com.tencent.mm.plugin.wallet.a.t> aVI = a2.aVI(a2.aVL(favorPayInfo.HXI));
                if (aVI.size() > 0) {
                    this.Idt = new a(getContext(), aVI);
                    textView.setText(R.string.iec);
                    textView.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass5 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(70726);
                            b bVar = new b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            WalletBankcardIdUI.this.showDialog(1);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(70726);
                        }
                    });
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                Log.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
                textView.setVisibility(8);
            }
        }
        final RealNameBundle realNameBundle = (RealNameBundle) getInput().getParcelable("realname_verify_process_bundle");
        an fQI = t.fQI();
        if (this.Idv && realNameBundle != null && !Util.isNullOrNil(realNameBundle.HTZ)) {
            this.Idq.setVisibility(0);
            this.Idq.setText(realNameBundle.HTZ);
            this.Idp.setHint(getString(R.string.i_o));
            this.Idq.setClickable(false);
            this.Idq.setEnabled(false);
            this.Idr.setText(R.string.iek);
        } else if (!fQI.fRk() || fQI.getTrueName() == null || Util.isNullOrNil(fQI.getTrueName().trim()) || !fQI.fRt()) {
            this.Idq.setVisibility(8);
            this.Idp.setHint(getString(R.string.ieg));
        } else {
            this.Idq.setVisibility(0);
            this.Idq.setText(fQI.getTrueName());
            this.Idp.setHint(getString(R.string.i_o));
            this.Idq.setClickable(false);
            this.Idq.setEnabled(false);
        }
        if (getInput().getInt("key_bind_scene") == 18 || getInput().getInt("key_bind_scene") == 19) {
            this.Idp.setHint(getString(R.string.iei));
        }
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, (Object) null);
        if (!Util.isNullOrNil(str)) {
            this.Idp.setHint(str);
        }
        this.Ids = (Bankcard) getInput().getParcelable("key_history_bankcard");
        if (this.Ids != null) {
            this.Idp.setText(this.Ids.HVy);
            this.Idp.a(new TextWatcher() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass6 */

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    AppMethodBeat.i(70727);
                    if (WalletBankcardIdUI.this.Idp.bql() && !WalletBankcardIdUI.this.Idu) {
                        WalletBankcardIdUI.this.Idu = true;
                        WalletBankcardIdUI.this.Idp.eIj();
                    }
                    AppMethodBeat.o(70727);
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
        }
        bqg();
        f.b(this, getInput(), 2);
        setEditFocusListener(this.Idp, 0, false);
        this.Idp.setOnInfoIvClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass7 */

            public final void onClick(View view) {
                String trueName;
                AppMethodBeat.i(70728);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11353, 2, 0);
                if (!WalletBankcardIdUI.this.Idv || realNameBundle == null || Util.isNullOrNil(realNameBundle.HTZ)) {
                    trueName = t.fQI().getTrueName();
                } else {
                    trueName = realNameBundle.HTZ;
                }
                com.tencent.mm.wallet_core.ui.f.d(WalletBankcardIdUI.this, trueName);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankcardIdUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70728);
            }
        });
        if (t.fQI().fRs().fQZ()) {
            this.Idp.getInfoIv().setVisibility(0);
            this.Idp.getInfoIv().setImageResource(R.raw.wallet_scan_camera);
        }
        AppMethodBeat.o(70738);
    }

    /* access modifiers changed from: protected */
    public final void bpv() {
        AppMethodBeat.i(70739);
        if (getProcess() == null) {
            Log.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
            AppMethodBeat.o(70739);
            return;
        }
        String string = getProcess().dQL.getString("kreq_token");
        int i2 = getInput().getInt("entry_scene", -1);
        int i3 = getInput().getInt("real_name_verify_mode") == 4 ? 1 : 0;
        if (this.Ids != null) {
            y yVar = new y(getPayReqKey(), null, (PayInfo) getInput().getParcelable("key_pay_info"), string, this.mScene, i2, i3);
            yVar.mBankType = this.Ids.field_bankcardType;
            getInput().putParcelable("key_history_bankcard", this.Ids);
            doSceneProgress(yVar);
            AppMethodBeat.o(70739);
        } else if (bqg()) {
            doSceneProgress(new y(getPayReqKey(), this.Idp.getText(), (PayInfo) getInput().getParcelable("key_pay_info"), string, this.mScene, i2, i3));
            AppMethodBeat.o(70739);
        } else {
            com.tencent.mm.ui.base.h.n(this, R.string.ij3, R.string.zb);
            AppMethodBeat.o(70739);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public Dialog onCreateDialog(int i2) {
        int i3;
        AppMethodBeat.i(70740);
        if (i2 == 1) {
            View inflate = getLayoutInflater().inflate(R.layout.c9h, (ViewGroup) null);
            ((ListViewInScrollView) inflate.findViewById(R.id.h4)).setAdapter((ListAdapter) this.Idt);
            d.a aVar = new d.a(this);
            aVar.aoO(R.string.ieb);
            aVar.hs(inflate);
            aVar.f(null);
            aVar.aoV(R.string.idg);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            AppMethodBeat.o(70740);
            return hbn;
        } else if (!this.Idv || i2 != 1000) {
            Dialog onCreateDialog = super.onCreateDialog(i2);
            AppMethodBeat.o(70740);
            return onCreateDialog;
        } else {
            String string = getString(R.string.ied);
            com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(this);
            if (by != null) {
                i3 = by.a(this, 1);
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                string = getString(i3);
            }
            com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a((Context) this, true, string, "", getString(R.string.a0_), getString(R.string.x6), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(70729);
                    ((com.tencent.mm.plugin.wallet_core.id_verify.a) WalletBankcardIdUI.this.getProcess()).g(WalletBankcardIdUI.this, 0);
                    WalletBankcardIdUI.this.finish();
                    AppMethodBeat.o(70729);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(70730);
                    View findFocus = WalletBankcardIdUI.e(WalletBankcardIdUI.this) == null ? null : WalletBankcardIdUI.f(WalletBankcardIdUI.this).findFocus();
                    if (findFocus != null && (findFocus instanceof EditText)) {
                        WalletBankcardIdUI.this.showVKB();
                    }
                    AppMethodBeat.o(70730);
                }
            });
            AppMethodBeat.o(70740);
            return a2;
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(70741);
        Log.d("Micromsg.WalletInputCardIDUI", " errCode: " + i3 + " errMsg :" + str);
        Bundle bundle = new Bundle();
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof y) {
                y yVar = (y) qVar;
                bundle.putBoolean("key_need_area", yVar.fPS());
                bundle.putBoolean("key_need_profession", yVar.fPT());
                bundle.putParcelableArray("key_profession_list", yVar.mProfessions);
                bundle.putBoolean("key_need_country", yVar.HQj == 1);
                bundle.putStringArray("key_country_excludes", yVar.HQk);
                if (yVar.HQf == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.Idp.getText());
                    com.tencent.mm.wallet_core.a.l(this, bundle);
                } else if (!yVar.HQf.HXj || !yVar.HQf.isError()) {
                    bundle.putString("bank_name", yVar.HQf.ynT);
                    bundle.putParcelable("elemt_query", yVar.HQf);
                    bundle.putString("key_card_id", this.Idp.getText());
                    com.tencent.mm.wallet_core.a.l(this, bundle);
                    AppMethodBeat.o(70741);
                    return true;
                } else {
                    com.tencent.mm.ui.base.h.n(this, R.string.i7k, R.string.zb);
                    AppMethodBeat.o(70741);
                    return true;
                }
            }
        } else if (i3 == 1 && (qVar instanceof y)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.Idp.getText());
            com.tencent.mm.wallet_core.a.l(this, bundle);
            AppMethodBeat.o(70741);
            return true;
        }
        AppMethodBeat.o(70741);
        return false;
    }

    private boolean bqg() {
        AppMethodBeat.i(70742);
        if (this.Idp.hK(null)) {
            this.gxv.setEnabled(true);
            this.gxv.setClickable(true);
            AppMethodBeat.o(70742);
            return true;
        }
        this.gxv.setEnabled(false);
        this.gxv.setClickable(false);
        AppMethodBeat.o(70742);
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.formview.WalletFormView.a
    public final void onInputValidChange(boolean z) {
        AppMethodBeat.i(70743);
        if (!z) {
            this.Ids = null;
            getInput().putParcelable("key_history_bankcard", null);
        }
        bqg();
        AppMethodBeat.o(70743);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        List<com.tencent.mm.plugin.wallet.a.t> Idy = new LinkedList();
        private Context mContext = null;
        private LayoutInflater mInflater = null;

        public a(Context context, List<com.tencent.mm.plugin.wallet.a.t> list) {
            AppMethodBeat.i(70731);
            this.mInflater = LayoutInflater.from(context);
            this.Idy = list;
            this.mContext = context;
            AppMethodBeat.o(70731);
        }

        public final int getCount() {
            AppMethodBeat.i(70732);
            if (this.Idy == null) {
                AppMethodBeat.o(70732);
                return 0;
            }
            int size = this.Idy.size();
            AppMethodBeat.o(70732);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(70733);
            com.tencent.mm.plugin.wallet.a.t tVar = this.Idy.get(i2);
            AppMethodBeat.o(70733);
            return tVar;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1917a aVar;
            AppMethodBeat.i(70734);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.c8a, viewGroup, false);
                aVar = new C1917a();
                aVar.jVi = (ImageView) view.findViewById(R.id.jea);
                aVar.Cjs = (TextView) view.findViewById(R.id.je_);
                aVar.Idz = (TextView) view.findViewById(R.id.jec);
                aVar.IdA = (TextView) view.findViewById(R.id.jeb);
                view.setTag(aVar);
            } else {
                aVar = (C1917a) view.getTag();
            }
            com.tencent.mm.plugin.wallet.a.t tVar = (com.tencent.mm.plugin.wallet.a.t) getItem(i2);
            if (!Util.isNullOrNil(tVar.AOj)) {
                aVar.Cjs.setText(tVar.AOj);
                aVar.Cjs.setVisibility(0);
            } else {
                aVar.Cjs.setVisibility(8);
            }
            if (!Util.isNullOrNil(tVar.HFm)) {
                aVar.Idz.setText(tVar.HFm);
                aVar.Idz.setVisibility(0);
            } else {
                aVar.Idz.setVisibility(8);
            }
            if (!Util.isNullOrNil(tVar.HEo)) {
                aVar.IdA.setText(tVar.HEo);
                aVar.IdA.setVisibility(0);
            } else {
                aVar.IdA.setVisibility(8);
            }
            String str = tVar.HFs;
            Log.v("Micromsg.WalletInputCardIDUI", "bankType:" + tVar.HFr + ", logurl:" + str);
            aVar.jVi.setImageBitmap(null);
            if (!Util.isNullOrNil(str)) {
                c.a aVar2 = new c.a();
                com.tencent.mm.av.q.bcW();
                aVar2.jbw = null;
                aVar2.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                aVar2.fullPath = com.tencent.mm.plugin.wallet_core.d.b.aKj(str);
                aVar2.jbf = true;
                aVar2.hZF = true;
                com.tencent.mm.av.q.bcV().a(str, aVar.jVi, aVar2.bdv());
            }
            AppMethodBeat.o(70734);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$a$a  reason: collision with other inner class name */
        class C1917a {
            TextView Cjs;
            TextView IdA;
            TextView Idz;
            ImageView jVi;

            C1917a() {
            }
        }
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI) {
        AppMethodBeat.i(70744);
        LayoutInflater layoutInflater = (LayoutInflater) walletBankcardIdUI.getContext().getSystemService("layout_inflater");
        TextView textView = (TextView) layoutInflater.inflate(R.layout.av0, (ViewGroup) null);
        textView.setText(walletBankcardIdUI.getString(R.string.ia_));
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(R.dimen.hs);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        com.tencent.mm.ui.base.h.a(walletBankcardIdUI.getContext(), walletBankcardIdUI.getString(R.string.ia9), walletBankcardIdUI.getString(R.string.idg), textView, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(70744);
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.i(70747);
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.d by = com.tencent.mm.wallet_core.a.by(walletBankcardIdUI);
        if (by != null) {
            by.b(walletBankcardIdUI, WalletConfirmCardIDUI.class, bundle);
        }
        AppMethodBeat.o(70747);
    }
}
