package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ab;
import com.tencent.mm.plugin.wallet.balance.model.lqt.q;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.ejl;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.h;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtPlanHomeUI extends WalletLqtBasePresenterUI {
    private RelativeLayout HAa;
    private LinearLayout HAb;
    private RelativeLayout HAc;
    private LinearLayout HAd;
    private TextView HAe;
    private ab HAf = ((ab) aq(ab.class));
    private a HAg = new a(this, (byte) 0);
    private List<dbt> HAh = new ArrayList();
    private dbs HAi;
    private ListView HzV;
    private TextView HzW;
    private TextView HzX;
    private LinearLayout HzY;
    private Button HzZ;
    private int requestCode;
    private ViewGroup ykw;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtPlanHomeUI() {
        AppMethodBeat.i(68942);
        AppMethodBeat.o(68942);
    }

    static /* synthetic */ void a(WalletLqtPlanHomeUI walletLqtPlanHomeUI, dbs dbs) {
        AppMethodBeat.i(68953);
        walletLqtPlanHomeUI.c(dbs);
        AppMethodBeat.o(68953);
    }

    static /* synthetic */ void b(WalletLqtPlanHomeUI walletLqtPlanHomeUI) {
        AppMethodBeat.i(68952);
        walletLqtPlanHomeUI.aer(65283);
        AppMethodBeat.o(68952);
    }

    static /* synthetic */ void c(WalletLqtPlanHomeUI walletLqtPlanHomeUI) {
        AppMethodBeat.i(68954);
        walletLqtPlanHomeUI.fNP();
        AppMethodBeat.o(68954);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        dbs dbs;
        AppMethodBeat.i(68943);
        fixStatusbar(true);
        super.onCreate(bundle);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.f3043a));
        setStatusColor();
        hideActionbarLine();
        initView();
        int intExtra = getIntent().getIntExtra("key_plan_go_scene_ui", 0);
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "WalletLqtPlanHomeUI scene：%s", Integer.valueOf(intExtra));
        switch (intExtra) {
            case 1:
                aer(65282);
                AppMethodBeat.o(68943);
                return;
            case 2:
                fNO();
                AppMethodBeat.o(68943);
                return;
            default:
                Log.i("MicroMsg.WalletLqtPlanHomeUI", "go to plan home ui");
                Parcelable parcelableExtra = getIntent().getParcelableExtra("key_plan_index_resp");
                if (parcelableExtra instanceof CgiLqtPlanIndex.PlanIndexParcel) {
                    CgiLqtPlanIndex.PlanIndexParcel planIndexParcel = (CgiLqtPlanIndex.PlanIndexParcel) parcelableExtra;
                    if (planIndexParcel == null) {
                        dbs = null;
                    } else {
                        dbs dbs2 = new dbs();
                        dbs2.pTZ = planIndexParcel.pTZ;
                        dbs2.pUa = planIndexParcel.pUa;
                        Iterator<CgiLqtPlanIndex.PlanItemParcel> it = planIndexParcel.Htg.iterator();
                        while (it.hasNext()) {
                            CgiLqtPlanIndex.PlanItemParcel next = it.next();
                            dbt dbt = new dbt();
                            dbt.grV = next.grV;
                            dbt.eht = next.eht;
                            dbt.dDj = next.dDj;
                            dbt.AOk = next.AOk;
                            dbt.Htm = next.Htm;
                            dbt.Htn = next.Htn;
                            dbt.Hts = next.Hts;
                            dbt.CiX = next.CiX;
                            if (next.Hto != null) {
                                dbt.MGF = new ejl();
                                dbt.MGF.Htt = next.Hto.Htt;
                                dbt.MGF.ixw = next.Hto.ixw;
                            }
                            if (next.Htp != null) {
                                dbt.MGG = new cre();
                                dbt.MGG.title = next.Htp.title;
                                dbt.MGG.url = next.Htp.url;
                            }
                            if (next.Htq != null) {
                                dbt.MGH = new cpa();
                                dbt.MGH.Htd = next.Htq.Htd;
                                dbt.MGH.Hte = next.Htq.Hte;
                                Iterator<Integer> it2 = next.Htq.Htf.iterator();
                                while (it2.hasNext()) {
                                    dbt.MGH.Mvb.add(it2.next());
                                }
                            }
                            dbt.Htr = next.Htr;
                            dbt.state = next.state;
                            dbt.ynT = next.ynT;
                            dbs2.MGC.add(dbt);
                        }
                        dbs2.Hth = planIndexParcel.Hth;
                        dbs2.Hti = planIndexParcel.Hti;
                        if (planIndexParcel.Htj != null) {
                            dbs2.MGD = new jh();
                            dbs2.MGD.title = planIndexParcel.Htj.title;
                            dbs2.MGD.url = planIndexParcel.Htj.url;
                        }
                        dbs2.Htk = planIndexParcel.Htk;
                        dbs2.Htl = planIndexParcel.Htl;
                        dbs = dbs2;
                    }
                    this.HAi = dbs;
                    c(this.HAi);
                    AppMethodBeat.o(68943);
                    return;
                }
                Log.i("MicroMsg.WalletLqtPlanHomeUI", "parcelable no instanceof CgiLqtPlanIndex.PlanIndexParcel");
                finish();
                AppMethodBeat.o(68943);
                return;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68944);
        this.HzV = (ListView) findViewById(R.id.eu9);
        this.HzW = (TextView) findViewById(R.id.eu7);
        this.HzX = (TextView) findViewById(R.id.eu5);
        this.HzY = (LinearLayout) findViewById(R.id.eu8);
        this.HzZ = (Button) findViewById(R.id.eu4);
        this.HAa = (RelativeLayout) findViewById(R.id.eu6);
        this.HAb = (LinearLayout) findViewById(R.id.evh);
        this.HAe = (TextView) findViewById(R.id.evi);
        this.HAg = new a(this, (byte) 0);
        this.HzV.setAdapter((ListAdapter) this.HAg);
        this.ykw = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.b39, (ViewGroup) this.HzV, false);
        this.ykw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(68928);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68928);
            }
        });
        this.HzV.addFooterView(this.ykw);
        this.HzZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(68926);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68926);
            }
        });
        this.HzV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(68927);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.i("MicroMsg.WalletLqtPlanHomeUI", "pos: %s", Integer.valueOf(i2));
                adapterView.getAdapter().getItem(i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(68927);
            }
        });
        AppMethodBeat.o(68944);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI
    public int getLayoutId() {
        return R.layout.b3_;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68945);
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "activity result: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 5 && i3 == -1) {
            i2 = intent.getIntExtra("oper_type", -1);
        }
        this.requestCode = i2;
        switch (i2) {
            case 1:
            case 2:
            case 3:
                if (i3 == -1) {
                    String stringExtra = intent.getStringExtra("encrypt_pwd");
                    int intExtra = intent.getIntExtra("oper_type", -1);
                    int intExtra2 = intent.getIntExtra("plan_id", -1);
                    final Dialog c2 = h.c(getContext(), false, null);
                    g.h(Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra).c(this.HAf.Hul).f(new com.tencent.mm.vending.c.a<Object, cmd>() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass8 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Object call(cmd cmd) {
                            AppMethodBeat.i(68935);
                            WalletLqtPlanHomeUI.c(WalletLqtPlanHomeUI.this);
                            new MMHandler().postDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass8.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(68934);
                                    c2.dismiss();
                                    AppMethodBeat.o(68934);
                                }
                            }, 800);
                            AppMethodBeat.o(68935);
                            return null;
                        }
                    }).a(new d.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass7 */

                        @Override // com.tencent.mm.vending.g.d.a
                        public final void cn(Object obj) {
                            AppMethodBeat.i(68933);
                            c2.dismiss();
                            if (obj instanceof m) {
                                ((m) obj).G(WalletLqtPlanHomeUI.this.getContext(), false);
                            }
                            AppMethodBeat.o(68933);
                        }
                    });
                    break;
                }
                break;
            case 65281:
                if (i3 == -1) {
                    fNP();
                    break;
                }
                break;
            case 65282:
                if (i3 != -1) {
                    finish();
                    break;
                } else {
                    fNP();
                    break;
                }
            case 65283:
                if (i3 == -1) {
                    fNP();
                    this.HAc.setVisibility(8);
                    break;
                }
                break;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(68945);
    }

    private void b(dbs dbs) {
        AppMethodBeat.i(68946);
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "limit: %s", Long.valueOf(dbs.Hth));
        this.ykw.setVisibility(0);
        if (dbs.Hth <= ((long) dbs.MGC.size())) {
            this.ykw.findViewById(R.id.euy).setVisibility(8);
            TextView textView = (TextView) this.ykw.findViewById(R.id.euz);
            textView.setPadding(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 24), 0, 0, 0);
            textView.setText(dbs.Htk);
            textView.setTextColor(getContext().getResources().getColor(R.color.uj));
            this.ykw.setEnabled(false);
            AppMethodBeat.o(68946);
            return;
        }
        this.ykw.findViewById(R.id.euy).setVisibility(0);
        TextView textView2 = (TextView) this.ykw.findViewById(R.id.euz);
        textView2.setPadding(0, 0, 0, 0);
        textView2.setText(R.string.ifp);
        textView2.setTextColor(getResources().getColor(R.color.a2x));
        this.ykw.setEnabled(true);
        AppMethodBeat.o(68946);
    }

    private void aer(int i2) {
        AppMethodBeat.i(68947);
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "go to add plan ui -> add");
        Intent intent = new Intent(this, WalletLqtPlanAddUI.class);
        intent.putExtra("key_mode", 1);
        startActivityForResult(intent, i2);
        AppMethodBeat.o(68947);
    }

    private void fNO() {
        AppMethodBeat.i(68948);
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "show null plan home ui");
        setMMTitle(getString(R.string.ii7));
        this.HAc = (RelativeLayout) findViewById(R.id.ex8);
        this.HAc.setVisibility(0);
        this.HAd = (LinearLayout) findViewById(R.id.ex7);
        this.HAd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(68929);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLqtPlanHomeUI.b(WalletLqtPlanHomeUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68929);
            }
        });
        AppMethodBeat.o(68948);
    }

    private void c(final dbs dbs) {
        AppMethodBeat.i(68949);
        Log.d("MicroMsg.WalletLqtPlanHomeUI", "update view");
        if (dbs == null) {
            Log.i("MicroMsg.WalletLqtPlanHomeUI", "resp is null");
            finish();
            AppMethodBeat.o(68949);
        } else if (dbs.MGC == null || dbs.MGC.isEmpty()) {
            Log.i("MicroMsg.WalletLqtPlanHomeUI", "show empty view");
            if (this.requestCode == 3) {
                fNO();
                this.HAh = dbs.MGC;
                this.HAg.notifyDataSetChanged();
                this.ykw.setVisibility(8);
                AppMethodBeat.o(68949);
                return;
            }
            finish();
            AppMethodBeat.o(68949);
        } else {
            if (Util.isNullOrNil(dbs.Htl)) {
                setMMTitle("");
            } else {
                setMMTitle(dbs.Htl);
            }
            setActionbarColor(getContext().getResources().getColor(R.color.f3043a));
            this.HAa.setVisibility(8);
            this.HzV.setVisibility(0);
            b(dbs);
            this.HAh = dbs.MGC;
            this.HAg.notifyDataSetChanged();
            if (dbs.MGD == null || Util.isNullOrNil(dbs.MGD.title)) {
                this.HAb.setVisibility(8);
                AppMethodBeat.o(68949);
                return;
            }
            this.HAe.setText(dbs.MGD.title);
            this.HAb.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(68930);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.WalletLqtPlanHomeUI", "click banner");
                    f.p(WalletLqtPlanHomeUI.this.getContext(), dbs.MGD.url, true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(68930);
                }
            });
            this.HAb.setVisibility(0);
            AppMethodBeat.o(68949);
        }
    }

    private void fNP() {
        AppMethodBeat.i(68950);
        q qVar = new q();
        qVar.b(new CgiLqtPlanIndex());
        qVar.a(new a.AbstractC2168a<dbs>(false) {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.AnonymousClass6 */
            final /* synthetic */ boolean HAl = false;

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void d(dbs dbs, int i2, int i3) {
                AppMethodBeat.i(258733);
                dbs dbs2 = dbs;
                Log.i("MicroMsg.WalletLqtPlanHomeUI", "on index response callback");
                if (dbs2 == null) {
                    m.jU(-1, -1).G(WalletLqtPlanHomeUI.this.getContext(), true);
                    AppMethodBeat.o(258733);
                } else if (dbs2.pTZ == 0) {
                    WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this, dbs2);
                    AppMethodBeat.o(258733);
                } else {
                    m.a(true, dbs2.pTZ, 0, dbs2.pUa).G(WalletLqtPlanHomeUI.this.getContext(), true);
                    AppMethodBeat.o(258733);
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void dx(dbs dbs) {
                AppMethodBeat.i(68932);
                dbs dbs2 = dbs;
                Log.i("MicroMsg.WalletLqtPlanHomeUI", "on index cache callback");
                if (dbs2 != null && this.HAl) {
                    WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this, dbs2);
                }
                AppMethodBeat.o(68932);
            }
        }, 0);
        AppMethodBeat.o(68950);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(WalletLqtPlanHomeUI walletLqtPlanHomeUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(68939);
            dbt aes = aes(i2);
            AppMethodBeat.o(68939);
            return aes;
        }

        public final int getCount() {
            AppMethodBeat.i(68936);
            int size = WalletLqtPlanHomeUI.this.HAh.size();
            AppMethodBeat.o(68936);
            return size;
        }

        private dbt aes(int i2) {
            AppMethodBeat.i(68937);
            dbt dbt = (dbt) WalletLqtPlanHomeUI.this.HAh.get(i2);
            AppMethodBeat.o(68937);
            return dbt;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(68938);
            if (view == null) {
                view = LayoutInflater.from(WalletLqtPlanHomeUI.this.getContext()).inflate(R.layout.b38, viewGroup, false);
                view.setTag(new b(view));
            }
            dbt aes = aes(i2);
            b bVar = (b) view.getTag();
            bVar.HAn.setPrefix(ah.hhz());
            BigDecimal b2 = f.b(new StringBuilder().append(aes.eht).toString(), "100", 2, RoundingMode.HALF_UP);
            if (((double) b2.intValue()) == b2.doubleValue()) {
                bVar.HAn.setText(WalletLqtPlanHomeUI.aUP(new StringBuilder().append(b2.intValue()).toString()));
            } else {
                bVar.HAn.setText(WalletLqtPlanHomeUI.aUP(b2.toString()));
            }
            bVar.HAq.setText(String.format("%s %s(%s)", aes.ynT, aes.Hts, aes.AOk));
            Bitmap a2 = u.a(new c(aes.CiX));
            if (a2 != null) {
                bVar.HyB.setImageBitmap(a2);
            }
            if (aes.MGF == null || Util.isNullOrNil(aes.MGF.Htt)) {
                bVar.HAr.setVisibility(8);
            } else {
                bVar.HAr.setText(aes.MGF.Htt);
                if (!Util.isNullOrNil(aes.MGF.ixw)) {
                    bVar.HAr.setTextColor(com.tencent.mm.plugin.wallet_core.utils.g.cI(aes.MGF.ixw, true));
                } else {
                    bVar.HAr.setTextColor(WalletLqtPlanHomeUI.this.getResources().getColor(R.color.BW_50));
                }
                bVar.HAr.setVisibility(0);
            }
            bVar.HAu.setVisibility(8);
            bVar.HAs.setVisibility(8);
            if (aes.MGG != null) {
                bVar.HAp.setOnClickListener(new View.OnClickListener(aes) {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.b.AnonymousClass1 */
                    final /* synthetic */ dbt HzQ;

                    {
                        this.HzQ = r2;
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.i(68940);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        WalletLqtPlanHomeUI.a(WalletLqtPlanHomeUI.this, this.HzQ);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanHomeUI$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(68940);
                    }
                });
            }
            if (aes.state != 1) {
                bVar.HAt.setVisibility(0);
                bVar.HAq.setAlpha(0.2f);
                bVar.HAn.setAlpha(0.2f);
                bVar.HyB.setAlpha(0.3f);
                bVar.HAo.setAlpha(1.0f);
            } else {
                bVar.HAt.setVisibility(8);
                bVar.HAq.setAlpha(1.0f);
                bVar.HAn.setAlpha(1.0f);
                bVar.HyB.setAlpha(1.0f);
                bVar.HAo.setAlpha(1.0f);
            }
            AppMethodBeat.o(68938);
            return view;
        }
    }

    public class b {
        public WalletTextView HAn;
        public ImageView HAo;
        public LinearLayout HAp;
        public TextView HAq;
        public TextView HAr;
        public TextView HAs;
        public TextView HAt;
        public LinearLayout HAu;
        public CdnImageView HyB;
        public View lJI;

        public b(View view) {
            AppMethodBeat.i(68941);
            this.lJI = view;
            this.HAn = (WalletTextView) view.findViewById(R.id.eu1);
            this.HAo = (ImageView) view.findViewById(R.id.eu2);
            this.HAt = (TextView) view.findViewById(R.id.eu3);
            this.HAq = (TextView) view.findViewById(R.id.ety);
            this.HAr = (TextView) view.findViewById(R.id.etz);
            this.HAs = (TextView) view.findViewById(R.id.etx);
            this.HAu = (LinearLayout) view.findViewById(R.id.etw);
            this.HyB = (CdnImageView) view.findViewById(R.id.etv);
            this.HAp = (LinearLayout) view.findViewById(R.id.eu0);
            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) WalletLqtPlanHomeUI.this.getContext(), 50);
            Util.expandViewTouchArea(this.HAo, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
            AppMethodBeat.o(68941);
        }
    }

    static /* synthetic */ void a(WalletLqtPlanHomeUI walletLqtPlanHomeUI) {
        AppMethodBeat.i(68951);
        walletLqtPlanHomeUI.aer(65281);
        AppMethodBeat.o(68951);
    }

    static /* synthetic */ String aUP(String str) {
        AppMethodBeat.i(68955);
        if (!str.contains(".")) {
            String str2 = str + ".00";
            AppMethodBeat.o(68955);
            return str2;
        }
        AppMethodBeat.o(68955);
        return str;
    }

    static /* synthetic */ void a(WalletLqtPlanHomeUI walletLqtPlanHomeUI, dbt dbt) {
        AppMethodBeat.i(68956);
        Log.i("MicroMsg.WalletLqtPlanHomeUI", "go to Plan DetailUI");
        Intent intent = new Intent(walletLqtPlanHomeUI, WalletLqtPlanDetailUI.class);
        intent.putExtra("key_plan_item_detail", CgiLqtPlanOrderList.a(dbt));
        walletLqtPlanHomeUI.startActivityForResult(intent, 5);
        AppMethodBeat.o(68956);
    }
}
