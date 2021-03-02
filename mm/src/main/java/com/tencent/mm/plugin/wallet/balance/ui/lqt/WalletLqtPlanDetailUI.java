package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanOrderList;
import com.tencent.mm.plugin.wallet.balance.model.lqt.z;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdNewUI;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletLqtPlanDetailUI extends WalletLqtBasePresenterUI {
    private z HyN = ((z) aq(z.class));
    private dbt HyU;
    private TextView HzA;
    private TextView HzB;
    private ListView HzC;
    private LinearLayout HzD;
    private LinearLayout HzE;
    private LinearLayout HzF;
    private View HzG;
    private View HzH;
    private int HzI;
    private int HzJ;
    private boolean HzK;
    private String Hzu;
    private List<dbu> Hzv = new ArrayList();
    private a Hzw;
    private TextView Hzx;
    private CdnImageView Hzy;
    private TextView Hzz;
    private boolean jUX;
    private LinearLayout pQt;
    private WalletTextView qzt;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtPlanDetailUI() {
        AppMethodBeat.i(68915);
        AppMethodBeat.o(68915);
    }

    static /* synthetic */ void a(WalletLqtPlanDetailUI walletLqtPlanDetailUI, int i2, int i3) {
        AppMethodBeat.i(68920);
        walletLqtPlanDetailUI.jR(i2, i3);
        AppMethodBeat.o(68920);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI
    public int getLayoutId() {
        return R.layout.b36;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        dbt dbt;
        AppMethodBeat.i(68916);
        fixStatusbar(true);
        super.onCreate(bundle);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("key_plan_item_detail");
        if (parcelableExtra instanceof CgiLqtPlanOrderList.PlanItemParcel) {
            CgiLqtPlanOrderList.PlanItemParcel planItemParcel = (CgiLqtPlanOrderList.PlanItemParcel) parcelableExtra;
            if (planItemParcel == null) {
                dbt = null;
            } else {
                dbt dbt2 = new dbt();
                dbt2.Htr = planItemParcel.Htr;
                dbt2.eht = planItemParcel.eht;
                dbt2.grV = planItemParcel.grV;
                dbt2.CiX = planItemParcel.CiX;
                dbt2.ynT = planItemParcel.ynT;
                dbt2.dDj = planItemParcel.dDj;
                dbt2.AOk = planItemParcel.AOk;
                dbt2.state = planItemParcel.state;
                dbt2.Hts = planItemParcel.Hts;
                if (planItemParcel.Htu != null) {
                    dbt2.MGH = new cpa();
                    dbt2.MGH.Htd = planItemParcel.Htu.Htd;
                    dbt2.MGH.Hte = planItemParcel.Htu.Hte;
                    Iterator<Integer> it = planItemParcel.Htu.Htf.iterator();
                    while (it.hasNext()) {
                        dbt2.MGH.Mvb.add(it.next());
                    }
                }
                dbt = dbt2;
            }
            this.HyU = dbt;
        } else {
            Log.i("MicroMsg.WalletLqtPlanDetailUI", "parcelable no instanceof CgiLqtPlanOrderList.PlanItemParcel");
            finish();
        }
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        final dbt dbt3 = this.HyU;
        if (this.HyU != null) {
            addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass4 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(68906);
                    if (dbt3.MGH != null) {
                        if (!dbt3.MGH.Htd || Util.isNullOrNil(dbt3.MGH.Hte)) {
                            WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, dbt3.MGH.Mvb, dbt3);
                        } else {
                            h.a(WalletLqtPlanDetailUI.this.getContext(), dbt3.MGH.Hte, "", WalletLqtPlanDetailUI.this.getString(R.string.w1), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass4.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(68906);
                    return false;
                }
            });
        }
        final dbt dbt4 = this.HyU;
        if (dbt4 != null) {
            this.pQt = (LinearLayout) View.inflate(getBaseContext(), R.layout.b34, null);
            this.qzt = (WalletTextView) this.pQt.findViewById(R.id.fji);
            this.HzE = (LinearLayout) this.pQt.findViewById(R.id.i4y);
            this.HzF = (LinearLayout) this.pQt.findViewById(R.id.in1);
            this.Hzx = (TextView) this.pQt.findViewById(R.id.imz);
            this.Hzy = (CdnImageView) this.pQt.findViewById(R.id.a0j);
            this.Hzz = (TextView) this.pQt.findViewById(R.id.apg);
            this.HzA = (TextView) this.pQt.findViewById(R.id.imu);
            this.HzD = (LinearLayout) this.pQt.findViewById(R.id.imv);
            this.HzH = this.pQt.findViewById(R.id.dpa);
            this.HzB = (TextView) this.pQt.findViewById(R.id.ihi);
            this.HzC = (ListView) findViewById(R.id.bod);
            this.HzG = findViewById(R.id.evz);
            this.Hzw = new a(this, (byte) 0);
            this.HzC.setAdapter((ListAdapter) this.Hzw);
            this.HzC.addHeaderView(this.pQt);
            this.qzt.setPrefix(ah.hhz());
            BigDecimal b2 = f.b(new StringBuilder().append(dbt4.eht).toString(), "100", 2, RoundingMode.HALF_UP);
            if (((double) b2.intValue()) == b2.doubleValue()) {
                this.qzt.setText(aUN(new StringBuilder().append(b2.intValue()).toString()));
            } else {
                this.qzt.setText(aUN(b2.toString()));
            }
            this.Hzx.setText(getString(R.string.ihc, new Object[]{new StringBuilder().append(dbt4.grV).toString()}));
            Bitmap a2 = u.a(new c(dbt4.CiX));
            if (a2 != null) {
                this.Hzy.setImageBitmap(a2);
            }
            this.Hzz.setText(String.format("%s %s（%s）", dbt4.ynT, dbt4.Hts, dbt4.AOk));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HzF.getLayoutParams();
            if (dbt4.state != 1) {
                this.HzE.setVisibility(0);
                layoutParams.setMargins(0, com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 8), 0, 0);
                Log.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", Integer.valueOf(layoutParams.topMargin));
            } else {
                this.HzE.setVisibility(8);
                layoutParams.setMargins(0, com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 16), 0, 0);
                Log.i("MicroMsg.WalletLqtPlanDetailUI", "params.topMargin:%s", Integer.valueOf(layoutParams.topMargin));
            }
            this.HzF.setLayoutParams(layoutParams);
            this.HzJ = 0;
            this.HzK = true;
            jR(dbt4.Htr, 0);
            this.HzC.setOnScrollListener(new AbsListView.OnScrollListener() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass1 */

                public final void onScrollStateChanged(AbsListView absListView, int i2) {
                    AppMethodBeat.i(68903);
                    if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        Log.i("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList more");
                        if (!WalletLqtPlanDetailUI.this.jUX) {
                            WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, dbt4.Htr, WalletLqtPlanDetailUI.this.HzJ);
                        }
                    }
                    AppMethodBeat.o(68903);
                }

                public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                }
            });
            this.HzH.setBackgroundColor(getContext().getResources().getColor(R.color.f3043a));
        }
        AppMethodBeat.o(68916);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68917);
        Log.i("MicroMsg.WalletLqtPlanDetailUI", "activity result: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -1) {
            if (intent != null) {
                intent.putExtra("oper_type", i2);
                intent.putExtra("plan_id", this.HzI);
                setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("oper_type", i2);
                setResult(-1, intent2);
            }
        }
        finish();
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(68917);
    }

    private void jR(int i2, int i3) {
        AppMethodBeat.i(68918);
        final Dialog c2 = com.tencent.mm.wallet_core.ui.h.c(getContext(), false, null);
        this.HyN.Hug.aH(i2, i3, 6).f(new com.tencent.mm.vending.c.a<Object, dgx>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(dgx dgx) {
                AppMethodBeat.i(68905);
                dgx dgx2 = dgx;
                WalletLqtPlanDetailUI.this.Hzu = dgx2.MLt;
                if (dgx2.MLu.size() != 0) {
                    WalletLqtPlanDetailUI.this.Hzv.addAll(dgx2.MLu);
                    WalletLqtPlanDetailUI.this.jUX = false;
                    WalletLqtPlanDetailUI.d(WalletLqtPlanDetailUI.this);
                } else {
                    WalletLqtPlanDetailUI.this.jUX = true;
                }
                if (!WalletLqtPlanDetailUI.this.HzK || dgx2.MLu.size() != 0) {
                    WalletLqtPlanDetailUI.this.HzC.setVisibility(0);
                    WalletLqtPlanDetailUI.this.HzD.setVisibility(0);
                    WalletLqtPlanDetailUI.this.HzG.setVisibility(0);
                    WalletLqtPlanDetailUI.this.HzB.setVisibility(8);
                    WalletLqtPlanDetailUI.this.HzK = false;
                } else {
                    WalletLqtPlanDetailUI.this.HzB.setText(WalletLqtPlanDetailUI.this.getString(R.string.ihg));
                    WalletLqtPlanDetailUI.this.HzB.setVisibility(0);
                    WalletLqtPlanDetailUI.this.HzD.setVisibility(8);
                    WalletLqtPlanDetailUI.this.HzG.setVisibility(8);
                    WalletLqtPlanDetailUI.this.HzK = false;
                }
                c2.dismiss();
                Log.d("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList：totalMonthNum：%s，mPlanOrderInfoItemList：%s", WalletLqtPlanDetailUI.this.Hzu, WalletLqtPlanDetailUI.this.Hzv);
                AppMethodBeat.o(68905);
                return null;
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass2 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(68904);
                c2.dismiss();
                if (obj instanceof m) {
                    ((m) obj).G(WalletLqtPlanDetailUI.this.getContext(), false);
                }
                AppMethodBeat.o(68904);
            }
        });
        AppMethodBeat.o(68918);
    }

    private static String aUN(String str) {
        AppMethodBeat.i(68919);
        if (!str.contains(".")) {
            String str2 = str + ".00";
            AppMethodBeat.o(68919);
            return str2;
        }
        AppMethodBeat.o(68919);
        return str;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(WalletLqtPlanDetailUI walletLqtPlanDetailUI, byte b2) {
            this();
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(68913);
            dbu aeq = aeq(i2);
            AppMethodBeat.o(68913);
            return aeq;
        }

        public final int getCount() {
            AppMethodBeat.i(68910);
            int size = WalletLqtPlanDetailUI.this.Hzv.size();
            AppMethodBeat.o(68910);
            return size;
        }

        private dbu aeq(int i2) {
            AppMethodBeat.i(68911);
            dbu dbu = (dbu) WalletLqtPlanDetailUI.this.Hzv.get(i2);
            AppMethodBeat.o(68911);
            return dbu;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(68912);
            if (view == null) {
                view = LayoutInflater.from(WalletLqtPlanDetailUI.this.getContext()).inflate(R.layout.b35, viewGroup, false);
                view.setTag(new b(view));
            }
            dbu aeq = aeq(i2);
            b bVar = (b) view.getTag();
            bVar.HzT.setText(aeq.BrH);
            if (aeq.state == 2) {
                bVar.HzU.setText(WalletLqtPlanDetailUI.this.getString(R.string.ii4, new Object[]{WalletLqtPlanDetailUI.aUO(new StringBuilder().append(aeq.eht).toString())}));
                bVar.HzU.setTextColor(WalletLqtPlanDetailUI.this.getResources().getColor(R.color.a2x));
            } else {
                bVar.HzU.setText(aeq.dQx);
                bVar.HzU.setTextColor(WalletLqtPlanDetailUI.this.getResources().getColor(R.color.adh));
            }
            AppMethodBeat.o(68912);
            return view;
        }
    }

    public class b {
        public TextView HzT;
        public TextView HzU;
        public View lJI;

        public b(View view) {
            AppMethodBeat.i(68914);
            this.lJI = view;
            this.HzT = (TextView) view.findViewById(R.id.bko);
            this.HzU = (TextView) view.findViewById(R.id.fjh);
            AppMethodBeat.o(68914);
        }
    }

    static /* synthetic */ void d(WalletLqtPlanDetailUI walletLqtPlanDetailUI) {
        AppMethodBeat.i(68921);
        if (walletLqtPlanDetailUI.Hzu != null) {
            walletLqtPlanDetailUI.HzA.setText(walletLqtPlanDetailUI.Hzu);
        }
        if (walletLqtPlanDetailUI.Hzv != null && !walletLqtPlanDetailUI.Hzv.isEmpty()) {
            walletLqtPlanDetailUI.HzJ += walletLqtPlanDetailUI.Hzv.size();
            Log.d("MicroMsg.WalletLqtPlanDetailUI", "doPlanOrderList：mPlanOrderInfoItemList ！= null，totalMonthMoneyTips：%s，mOffSet：%s", walletLqtPlanDetailUI.Hzu, Integer.valueOf(walletLqtPlanDetailUI.HzJ));
            walletLqtPlanDetailUI.Hzw.notifyDataSetChanged();
        }
        AppMethodBeat.o(68921);
    }

    static /* synthetic */ void a(WalletLqtPlanDetailUI walletLqtPlanDetailUI, final List list, final dbt dbt) {
        AppMethodBeat.i(68922);
        Log.i("MicroMsg.WalletLqtPlanDetailUI", "show operation menu: %s", list);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(68922);
            return;
        }
        e eVar = new e((Context) walletLqtPlanDetailUI.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(68907);
                for (Integer num : list) {
                    int intValue = num.intValue();
                    switch (intValue) {
                        case 1:
                            mVar.kV(intValue, R.string.ihp);
                            break;
                        case 2:
                            mVar.d(intValue, WalletLqtPlanDetailUI.this.getString(R.string.ihq));
                            break;
                        case 3:
                            mVar.a(intValue, WalletLqtPlanDetailUI.this.getContext().getResources().getColor(R.color.Red), WalletLqtPlanDetailUI.this.getString(R.string.ihn));
                            break;
                        case 4:
                            mVar.kV(intValue, R.string.iho);
                            break;
                    }
                }
                AppMethodBeat.o(68907);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass6 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(68909);
                final int itemId = menuItem.getItemId();
                WalletLqtPlanDetailUI.this.HzI = dbt.Htr;
                Log.i("MicroMsg.WalletLqtPlanDetailUI", "operType：%s", Integer.valueOf(itemId));
                switch (itemId) {
                    case 1:
                        WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this, itemId);
                        AppMethodBeat.o(68909);
                        return;
                    case 2:
                        h.a(WalletLqtPlanDetailUI.this.getContext(), true, WalletLqtPlanDetailUI.this.getString(R.string.ii0), "", WalletLqtPlanDetailUI.this.getString(R.string.ihz), WalletLqtPlanDetailUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass6.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(68908);
                                WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this, itemId);
                                AppMethodBeat.o(68908);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.AnonymousClass6.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }, R.color.x0, R.color.a2x);
                        AppMethodBeat.o(68909);
                        return;
                    case 3:
                        WalletLqtPlanDetailUI.b(WalletLqtPlanDetailUI.this, itemId);
                        AppMethodBeat.o(68909);
                        return;
                    case 4:
                        WalletLqtPlanDetailUI.a(WalletLqtPlanDetailUI.this, dbt);
                        break;
                }
                AppMethodBeat.o(68909);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(68922);
    }

    static /* synthetic */ void b(WalletLqtPlanDetailUI walletLqtPlanDetailUI, int i2) {
        AppMethodBeat.i(68923);
        Log.i("MicroMsg.WalletLqtPlanDetailUI", "go to check pwd");
        Intent intent = new Intent(walletLqtPlanDetailUI, WalletCheckPwdNewUI.class);
        intent.putExtra("scene", 3);
        intent.putExtra("title", com.tencent.mm.plugin.wallet.balance.model.lqt.ah.aeo(i2));
        walletLqtPlanDetailUI.startActivityForResult(intent, i2);
        AppMethodBeat.o(68923);
    }

    static /* synthetic */ void a(WalletLqtPlanDetailUI walletLqtPlanDetailUI, dbt dbt) {
        AppMethodBeat.i(68924);
        Log.i("MicroMsg.WalletLqtPlanDetailUI", "go to add plan ui -> modify");
        Intent intent = new Intent(walletLqtPlanDetailUI, WalletLqtPlanAddUI.class);
        intent.putExtra("key_mode", 2);
        try {
            intent.putExtra("key_plan_item", dbt.toByteArray());
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.WalletLqtPlanDetailUI", e2, "", new Object[0]);
        }
        Log.d("MicroMsg.WalletLqtPlanDetailUI", "gotoModifyPlanUI：%s", 65281);
        walletLqtPlanDetailUI.startActivityForResult(intent, 65281);
        AppMethodBeat.o(68924);
    }

    static /* synthetic */ String aUO(String str) {
        AppMethodBeat.i(68925);
        if (str.length() == 1) {
            String concat = "0.0".concat(String.valueOf(str));
            AppMethodBeat.o(68925);
            return concat;
        } else if (str.length() == 2) {
            String concat2 = "0.".concat(String.valueOf(str));
            AppMethodBeat.o(68925);
            return concat2;
        } else {
            String str2 = str.substring(0, str.length() - 2) + "." + str.substring(str.length() - 2);
            AppMethodBeat.o(68925);
            return str2;
        }
    }
}
