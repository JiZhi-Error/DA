package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import java.util.ArrayList;
import java.util.List;

public class WalletECardBindCardListUI extends WalletECardBaseUI {
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.AnonymousClass3 */

        {
            AppMethodBeat.i(160894);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(160894);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(71749);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletECardBindCardListUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(71749);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.WalletECardBindCardListUI", "KindaBindCardEvent bindCard Succ");
                    je jeVar = new je();
                    jeVar.dDj = ljVar2.dQz.dQl;
                    jeVar.KNI = ljVar2.dQz.dQm;
                    jeVar.HQc = ljVar2.dQz.dQD;
                    if (!Util.isNullOrNil(jeVar.KNI) && !Util.isNullOrNil(jeVar.dDj) && !Util.isNullOrNil(jeVar.HQc)) {
                        WalletECardBindCardListUI.this.getNetController().r(jeVar);
                    }
                    WalletECardBindCardListUI.c(WalletECardBindCardListUI.this);
                } else {
                    Log.i("MicroMsg.WalletECardBindCardListUI", "KindaBindCardEvent bindCard Cancel");
                }
                WalletECardBindCardListUI.this.Iqk = false;
            }
            EventCenter.instance.removeListener(WalletECardBindCardListUI.this.AJa);
            AppMethodBeat.o(71749);
            return true;
        }
    };
    private ListView Iqg;
    private TextView Iqh;
    private List<je> Iqi = new ArrayList();
    private c Iqj;
    private boolean Iqk = true;
    private d.a Iql = new d.a() {
        /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.AnonymousClass2 */

        @Override // com.tencent.mm.wallet_core.d.a
        public final Intent q(int i2, Bundle bundle) {
            AppMethodBeat.i(71748);
            Log.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", Integer.valueOf(i2), bundle);
            if (i2 == -1) {
                BindCardOrder bindCardOrder = (BindCardOrder) bundle.getParcelable("key_bindcard_value_result");
                if (bindCardOrder != null) {
                    je jeVar = new je();
                    jeVar.dDj = bundle.getString("key_bind_card_type");
                    jeVar.KNI = bindCardOrder.HWx;
                    jeVar.HQc = bundle.getString("key_mobile");
                    if (!Util.isNullOrNil(jeVar.KNI) && !Util.isNullOrNil(jeVar.dDj) && !Util.isNullOrNil(jeVar.HQc)) {
                        WalletECardBindCardListUI.this.getNetController().r(jeVar);
                        AppMethodBeat.o(71748);
                        return null;
                    }
                }
                WalletECardBindCardListUI.c(WalletECardBindCardListUI.this);
            }
            WalletECardBindCardListUI.this.Iqk = false;
            AppMethodBeat.o(71748);
            return null;
        }
    };
    private int pmM;

    interface b {
        void a(View view, je jeVar);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBaseUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletECardBindCardListUI() {
        AppMethodBeat.i(71758);
        AppMethodBeat.o(71758);
    }

    static /* synthetic */ void c(WalletECardBindCardListUI walletECardBindCardListUI) {
        AppMethodBeat.i(71766);
        walletECardBindCardListUI.bqe();
        AppMethodBeat.o(71766);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71759);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        this.mNetSceneMgr.addSceneEndListener(1988);
        this.pmM = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq, 2);
        Log.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", Integer.valueOf(this.pmM));
        setMMTitle("");
        initView();
        this.Iqk = true;
        bqe();
        AppMethodBeat.o(71759);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71760);
        this.Iqg = (ListView) findViewById(R.id.a2i);
        View inflate = LayoutInflater.from(this).inflate(R.layout.a0a, (ViewGroup) this.Iqg, false);
        this.Iqh = (TextView) inflate.findViewById(R.id.bvg);
        this.Iqg.addHeaderView(inflate, null, false);
        this.Iqj = new c(this, (byte) 0);
        this.Iqg.setAdapter((ListAdapter) this.Iqj);
        this.Iqg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(71747);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.i("MicroMsg.WalletECardBindCardListUI", "position: %d", Integer.valueOf(i2));
                int itemViewType = adapterView.getAdapter().getItemViewType(i2);
                WalletECardBindCardListUI.this.Iqj.getClass();
                if (itemViewType == 1) {
                    Log.d("MicroMsg.WalletECardBindCardListUI", "click add item: %s", Integer.valueOf(WalletECardBindCardListUI.this.pmM));
                    WalletECardBindCardListUI.this.fUm();
                } else {
                    je jeVar = (je) adapterView.getAdapter().getItem(i2);
                    if (jeVar == null) {
                        Log.w("MicroMsg.WalletECardBindCardListUI", "empty item");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(71747);
                        return;
                    }
                    WalletECardBindCardListUI.this.getNetController().r(jeVar);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardBindCardListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(71747);
            }
        });
        AppMethodBeat.o(71760);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71761);
        if (qVar instanceof f) {
            f fVar = (f) qVar;
            if (i2 == 0 && i3 == 0) {
                if (!Util.isNullOrNil(fVar.IpX.MLv)) {
                    this.Iqh.setText(fVar.IpX.MLv);
                }
                if (fVar.IpX.pTZ == 0) {
                    Log.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", Integer.valueOf(fVar.IpX.MLw.size()));
                    Log.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", fVar.IpX.HTZ);
                    getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpH, fVar.IpX.HTZ);
                    if (fVar.IpX.MLw.size() == 0) {
                        Log.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", Boolean.valueOf(this.Iqk));
                        if (this.Iqk) {
                            fUm();
                        }
                    } else {
                        this.Iqi.clear();
                        this.Iqi.addAll(fVar.IpX.MLw);
                        this.Iqj.notifyDataSetChanged();
                    }
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a(this, fVar.IpX.KPx)) {
                    h.c(getContext(), com.tencent.mm.plugin.wallet_ecard.a.b.d(getContext(), fVar.IpX.pUa, str), "", false);
                }
            } else {
                Log.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", fVar);
                h.c(getContext(), com.tencent.mm.plugin.wallet_ecard.a.b.d(getContext(), str), "", false);
            }
            AppMethodBeat.o(71761);
            return true;
        }
        AppMethodBeat.o(71761);
        return false;
    }

    public final void fUm() {
        AppMethodBeat.i(71762);
        Bundle bundle = new Bundle();
        if (this.pmM == 3) {
            bundle.putInt("key_bind_scene", 18);
        } else {
            bundle.putInt("key_bind_scene", 19);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putString("key_pwd1", getInput().getString("key_pwd1"));
        Log.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", Integer.valueOf(this.pmM));
        if (h(this, bundle)) {
            AppMethodBeat.o(71762);
            return;
        }
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, bundle, this.Iql);
        AppMethodBeat.o(71762);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0_;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71763);
        super.onDestroy();
        this.mNetSceneMgr.removeSceneEndListener(1988);
        AppMethodBeat.o(71763);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean needConfirmFinish() {
        return true;
    }

    private void bqe() {
        AppMethodBeat.i(71764);
        Log.i("MicroMsg.WalletECardBindCardListUI", "load Data");
        doSceneForceProgress(new f("WEB_DEBIT", this.pmM));
        AppMethodBeat.o(71764);
    }

    private boolean h(Context context, Bundle bundle) {
        AppMethodBeat.i(71765);
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
            EventCenter.instance.add(this.AJa);
            Log.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:true");
            ab.mg(6, bundle.getInt("key_bind_scene"));
            z.aqh(bundle.getInt("key_bind_scene"));
            ((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(context, bundle);
            AppMethodBeat.o(71765);
            return true;
        }
        Log.d("MicroMsg.WalletECardBindCardListUI", "startKindaBindCard:false");
        AppMethodBeat.o(71765);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class c extends BaseAdapter {
        public final int BPh;
        public final int Iqn;

        private c() {
            this.BPh = 0;
            this.Iqn = 1;
        }

        /* synthetic */ c(WalletECardBindCardListUI walletECardBindCardListUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(71751);
            int size = WalletECardBindCardListUI.this.Iqi.size() + 1;
            AppMethodBeat.o(71751);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(71752);
            if (i2 < WalletECardBindCardListUI.this.Iqi.size()) {
                Object obj = WalletECardBindCardListUI.this.Iqi.get(i2);
                AppMethodBeat.o(71752);
                return obj;
            }
            AppMethodBeat.o(71752);
            return null;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(71753);
            if (i2 >= WalletECardBindCardListUI.this.Iqi.size()) {
                AppMethodBeat.o(71753);
                return 1;
            }
            AppMethodBeat.o(71753);
            return 0;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final boolean isEnabled(int i2) {
            AppMethodBeat.i(71754);
            je jeVar = (je) getItem(i2);
            if (jeVar == null) {
                boolean isEnabled = super.isEnabled(i2);
                AppMethodBeat.o(71754);
                return isEnabled;
            } else if (jeVar.KNK) {
                AppMethodBeat.o(71754);
                return false;
            } else {
                AppMethodBeat.o(71754);
                return true;
            }
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(71755);
            if (getItemViewType(i2) == 1) {
                if (view == null) {
                    view = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(R.layout.a0c, viewGroup, false);
                    view.setTag(new a(view));
                }
                ((a) view.getTag()).olP.setText(R.string.bpc);
            } else {
                if (view == null) {
                    view = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(R.layout.a0b, viewGroup, false);
                    view.setTag(new d(view));
                }
                ((b) view.getTag()).a(view, (je) getItem(i2));
            }
            AppMethodBeat.o(71755);
            return view;
        }
    }

    class d implements b {
        CdnImageView Iqo;
        TextView mPa;
        TextView pYW;

        public d(View view) {
            AppMethodBeat.i(71756);
            this.Iqo = (CdnImageView) view.findViewById(R.id.a2h);
            this.mPa = (TextView) view.findViewById(R.id.a2k);
            this.pYW = (TextView) view.findViewById(R.id.a2j);
            AppMethodBeat.o(71756);
        }

        @Override // com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI.b
        public final void a(View view, je jeVar) {
            AppMethodBeat.i(71757);
            if (jeVar != null) {
                this.Iqo.setRoundCorner(true);
                this.Iqo.setUrl(jeVar.KNJ);
                this.mPa.setText(String.format("%s %s(%s)", jeVar.ynT, jeVar.qcN, jeVar.KNH));
                if (!Util.isNullOrNil(jeVar.KNL)) {
                    this.pYW.setText(String.format("%s，%s", jeVar.HQc, jeVar.KNL));
                } else {
                    this.pYW.setText(String.format("%s", jeVar.HQc));
                }
                if (jeVar.KNK) {
                    Log.i("MicroMsg.WalletECardBindCardListUI", "disable card: %s", jeVar.ynT);
                    view.setEnabled(false);
                    this.mPa.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(R.color.wu));
                    this.pYW.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(R.color.wu));
                    AppMethodBeat.o(71757);
                    return;
                }
                view.setEnabled(true);
                this.mPa.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(R.color.a2x));
                this.pYW.setTextColor(WalletECardBindCardListUI.this.getResources().getColor(R.color.a2t));
            }
            AppMethodBeat.o(71757);
        }
    }

    class a {
        TextView olP;

        public a(View view) {
            AppMethodBeat.i(71750);
            this.olP = (TextView) view.findViewById(R.id.bvf);
            ImageView imageView = (ImageView) view.findViewById(R.id.bve);
            Drawable i2 = android.support.v4.graphics.drawable.a.i(imageView.getDrawable());
            android.support.v4.graphics.drawable.a.a(i2, ColorStateList.valueOf(MMApplicationContext.getResources().getColor(R.color.x0)));
            imageView.setImageDrawable(i2);
            AppMethodBeat.o(71750);
        }
    }
}
