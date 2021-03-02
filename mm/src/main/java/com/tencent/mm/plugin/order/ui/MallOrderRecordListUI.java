package com.tencent.mm.plugin.order.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.plugin.appbrand.jsapi.p.ae;
import com.tencent.mm.plugin.appbrand.jsapi.p.w;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.e;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI extends WalletBaseUI {
    public a APZ = null;
    protected List<i> AQa = new ArrayList();
    protected String AQb = null;
    public boolean AQc = false;
    protected Map<String, String> AQd = new HashMap();
    protected int fs = 0;
    public MMLoadMoreListView gAR;
    protected boolean isLoading = false;
    protected int mCount = 0;
    protected MMHandler mHandler = null;
    protected Dialog mProgressDialog = null;
    public boolean zci = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallOrderRecordListUI() {
        AppMethodBeat.i(66767);
        AppMethodBeat.o(66767);
    }

    static /* synthetic */ String hI(int i2, int i3) {
        AppMethodBeat.i(66783);
        String hH = hH(i2, i3);
        AppMethodBeat.o(66783);
        return hH;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b61;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(66768);
        super.onCreate(bundle);
        this.mHandler = new MMHandler();
        eBm();
        initView();
        this.fs = 0;
        this.AQb = null;
        AppMethodBeat.o(66768);
    }

    /* access modifiers changed from: protected */
    public void eBm() {
        AppMethodBeat.i(66769);
        addSceneEndListener(w.CTRL_INDEX);
        addSceneEndListener(ae.CTRL_INDEX);
        AppMethodBeat.o(66769);
    }

    /* access modifiers changed from: protected */
    public void eBn() {
        AppMethodBeat.i(66770);
        removeSceneEndListener(w.CTRL_INDEX);
        removeSceneEndListener(ae.CTRL_INDEX);
        AppMethodBeat.o(66770);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(66771);
        super.onResume();
        if (this.APZ != null) {
            this.APZ.notifyDataSetChanged();
        }
        AppMethodBeat.o(66771);
    }

    /* access modifiers changed from: protected */
    public void jj(String str, String str2) {
        AppMethodBeat.i(66772);
        doSceneProgress(new g(str, str2));
        AppMethodBeat.o(66772);
    }

    /* access modifiers changed from: protected */
    public void eBo() {
        AppMethodBeat.i(66773);
        doSceneProgress(new e(this.fs, this.AQb));
        AppMethodBeat.o(66773);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(66774);
        if (com.tencent.mm.wallet_core.a.by(this) instanceof com.tencent.mm.plugin.order.a.a) {
            this.isLoading = true;
            eBo();
        }
        setMMTitle(R.string.evx);
        this.gAR = (MMLoadMoreListView) findViewById(R.id.f8f);
        this.APZ = new a();
        this.gAR.setAdapter((ListAdapter) this.APZ);
        this.gAR.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(66756);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                MallOrderRecordListUI.this.Uk(i2);
                f.aqm(26);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/MallOrderRecordListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(66756);
            }
        });
        this.gAR.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i2, long j2) {
                AppMethodBeat.i(66758);
                if (i2 >= MallOrderRecordListUI.this.AQa.size()) {
                    AppMethodBeat.o(66758);
                } else {
                    h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(R.string.ikt), (String[]) null, MallOrderRecordListUI.this.getResources().getString(R.string.tf), new h.d() {
                        /* class com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.h.d
                        public final void oj(int i2) {
                            AppMethodBeat.i(66757);
                            switch (i2) {
                                case 0:
                                    i iVar = MallOrderRecordListUI.this.AQa.get(i2);
                                    if (iVar != null) {
                                        MallOrderRecordListUI.this.jj(iVar.AOT, iVar.APl);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(66757);
                        }
                    });
                    AppMethodBeat.o(66758);
                }
                return true;
            }
        });
        this.gAR.setOnLoadMoreListener(new MMLoadMoreListView.a() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.MMLoadMoreListView.a
            public final void onLoadMore() {
                AppMethodBeat.i(66759);
                if (!MallOrderRecordListUI.this.isLoading) {
                    MallOrderRecordListUI.this.isLoading = true;
                    MallOrderRecordListUI.this.fs += 10;
                    MallOrderRecordListUI.this.eBo();
                }
                AppMethodBeat.o(66759);
            }
        });
        final zt ztVar = new zt();
        ztVar.efM.scene = "6";
        ztVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(66760);
                if (!Util.isNullOrNil(ztVar.efN.efO)) {
                    f.a((TextView) MallOrderRecordListUI.this.findViewById(R.id.a2b), ztVar.efN.efO, ztVar.efN.content, ztVar.efN.url);
                    AppMethodBeat.o(66760);
                    return;
                }
                Log.i("MicroMsg.WalletOrderListUI", "no bulletin data");
                AppMethodBeat.o(66760);
            }
        };
        EventCenter.instance.publish(ztVar);
        com.tencent.mm.plugin.order.a.b.eBa().onChange();
        this.APZ.notifyDataSetChanged();
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        com.tencent.mm.plugin.order.a.b.eBa();
        hVar.a(11036, Integer.valueOf(com.tencent.mm.plugin.order.a.b.eBd().eBh()));
        AppMethodBeat.o(66774);
    }

    /* access modifiers changed from: protected */
    public final void Uk(int i2) {
        AppMethodBeat.i(66775);
        if (i2 >= this.AQa.size()) {
            AppMethodBeat.o(66775);
            return;
        }
        i iVar = this.AQa.get(i2);
        if (iVar != null) {
            Bundle input = getInput();
            input.putString("key_trans_id", iVar.AOT);
            input.putInt("key_pay_type", iVar.APa);
            input.putString("bill_id", iVar.APl);
            com.tencent.mm.wallet_core.a.l(this, input);
        }
        AppMethodBeat.o(66775);
    }

    /* access modifiers changed from: protected */
    public final void fM(List<i> list) {
        AppMethodBeat.i(66776);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(66776);
            return;
        }
        if (this.AQa == null) {
            this.AQa = new ArrayList();
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            i iVar = list.get(i2);
            if (!aJF(iVar.AOT)) {
                this.AQa.add(iVar);
            }
        }
        AppMethodBeat.o(66776);
    }

    private boolean aJF(String str) {
        AppMethodBeat.i(66777);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(66777);
            return false;
        }
        for (int i2 = 0; i2 < this.AQa.size(); i2++) {
            i iVar = this.AQa.get(i2);
            if (iVar != null && str.equals(iVar.AOT)) {
                AppMethodBeat.o(66777);
                return true;
            }
        }
        AppMethodBeat.o(66777);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(66778);
        eBn();
        super.onDestroy();
        AppMethodBeat.o(66778);
    }

    /* access modifiers changed from: protected */
    public String Ul(int i2) {
        AppMethodBeat.i(66779);
        String aql = f.aql(i2);
        AppMethodBeat.o(66779);
        return aql;
    }

    public class a extends BaseAdapter {
        protected a() {
        }

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(66766);
            i Um = Um(i2);
            AppMethodBeat.o(66766);
            return Um;
        }

        public final int getCount() {
            AppMethodBeat.i(66763);
            int size = MallOrderRecordListUI.this.AQa.size();
            AppMethodBeat.o(66763);
            return size;
        }

        private i Um(int i2) {
            AppMethodBeat.i(66764);
            i iVar = MallOrderRecordListUI.this.AQa.get(i2);
            AppMethodBeat.o(66764);
            return iVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            String str;
            AppMethodBeat.i(66765);
            if (view == null) {
                view = View.inflate(MallOrderRecordListUI.this, R.layout.b62, null);
                bVar = new b(MallOrderRecordListUI.this, (byte) 0);
                bVar.AQg = (TextView) view.findViewById(R.id.g5z);
                bVar.AQi = (TextView) view.findViewById(R.id.g5y);
                bVar.AQh = (TextView) view.findViewById(R.id.g5x);
                bVar.AQj = (TextView) view.findViewById(R.id.g5v);
                bVar.AQl = view.findViewById(R.id.g5s);
                bVar.AQm = (TextView) view.findViewById(R.id.g5u);
                bVar.AQn = (TextView) view.findViewById(R.id.g5t);
                bVar.AQk = (TextView) view.findViewById(R.id.g5w);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            i Um = Um(i2);
            boolean z = false;
            if (i2 == 0) {
                z = true;
                i Um2 = Um(0);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(((long) Um2.CreateTime) * 1000);
                str = MallOrderRecordListUI.hI(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1);
            } else {
                i Um3 = Um(i2);
                i Um4 = Um(i2 - 1);
                if (Um3.CreateTime > 0 && Um4.CreateTime > 0) {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(((long) Um4.CreateTime) * 1000);
                    GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                    gregorianCalendar3.setTimeInMillis(((long) Um3.CreateTime) * 1000);
                    if (!(gregorianCalendar2.get(1) == gregorianCalendar3.get(1) && gregorianCalendar2.get(2) == gregorianCalendar3.get(2))) {
                        z = true;
                        str = MallOrderRecordListUI.hI(gregorianCalendar3.get(1), gregorianCalendar3.get(2) + 1);
                    }
                }
                str = null;
            }
            if (z) {
                bVar.AQm.setText(new SimpleDateFormat(MallOrderRecordListUI.this.getString(R.string.dgl, new Object[]{""})).format(new Date(((long) Um(i2).CreateTime) * 1000)));
                if (!Util.isNullOrNil(str) && !Util.isNullOrNil(MallOrderRecordListUI.this.AQd.get(str))) {
                    bVar.AQn.setText(MallOrderRecordListUI.this.AQd.get(str));
                }
                bVar.AQl.setVisibility(0);
            } else {
                bVar.AQl.setVisibility(8);
            }
            bVar.AQg.setText(Um.AOV);
            bVar.AQh.setText(Um.AOW);
            int color = MallOrderRecordListUI.this.getContext().getResources().getColor(R.color.zh);
            if (!Util.isNullOrNil(Um.APi)) {
                try {
                    color = com.tencent.mm.plugin.wallet_core.utils.g.cI(Um.APi, true);
                } catch (Exception e2) {
                    Log.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + Util.nullAsNil(Um.APi));
                }
            }
            bVar.AQh.setTextColor(color);
            bVar.AQi.setText(MallOrderRecordListUI.this.Ul(Um.CreateTime));
            int color2 = MallOrderRecordListUI.this.getContext().getResources().getColor(R.color.zj);
            if (!Util.isNullOrNil(Um.APj)) {
                try {
                    color2 = com.tencent.mm.plugin.wallet_core.utils.g.cI(Um.APj, true);
                } catch (Exception e3) {
                    Log.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + Util.nullAsNil(Um.APj));
                }
            }
            if (Um.AOU != Um.APk) {
                String d2 = f.d(Um.AOU / 100.0d, Um.AOY);
                SpannableString spannableString = new SpannableString(d2);
                spannableString.setSpan(new StrikethroughSpan(), 0, d2.length(), 33);
                bVar.AQj.setText(spannableString);
            } else {
                bVar.AQj.setText("");
            }
            bVar.AQk.setTextColor(color2);
            bVar.AQk.setText(f.d(Um.APk / 100.0d, Um.AOY));
            AppMethodBeat.o(66765);
            return view;
        }
    }

    class b {
        TextView AQg;
        TextView AQh;
        TextView AQi;
        TextView AQj;
        TextView AQk;
        View AQl;
        TextView AQm;
        TextView AQn;

        private b() {
        }

        /* synthetic */ b(MallOrderRecordListUI mallOrderRecordListUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final void fN(List<d> list) {
        AppMethodBeat.i(66780);
        if (list == null) {
            AppMethodBeat.o(66780);
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if (dVar != null) {
                this.AQd.put(hH(dVar.year, dVar.month), dVar.AON);
            }
        }
        AppMethodBeat.o(66780);
    }

    private static String hH(int i2, int i3) {
        AppMethodBeat.i(66781);
        String str = i2 + "-" + i3;
        AppMethodBeat.o(66781);
        return str;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(66782);
        if (qVar instanceof e) {
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
            e eVar = (e) qVar;
            this.AQb = eVar.AOQ;
            fM(eVar.AOO);
            fN(eVar.AOP);
            this.mCount = this.AQa.size();
            this.zci = eVar.qwe > this.mCount;
            this.APZ.notifyDataSetChanged();
            Log.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
            Log.d("MicroMsg.WalletOrderListUI", "orders list total record: " + eVar.qwe);
            Log.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.zci);
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(66761);
                    if (MallOrderRecordListUI.this.zci) {
                        Log.v("MicroMsg.WalletOrderListUI", "has more");
                        if (!MallOrderRecordListUI.this.AQc) {
                            MallOrderRecordListUI.this.gAR.gKM();
                            MallOrderRecordListUI.this.gAR.setAdapter((ListAdapter) MallOrderRecordListUI.this.APZ);
                            MallOrderRecordListUI.this.AQc = true;
                        }
                    } else {
                        Log.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
                        MallOrderRecordListUI.this.gAR.gKN();
                    }
                    MallOrderRecordListUI.this.APZ.notifyDataSetChanged();
                    AppMethodBeat.o(66761);
                }
            });
            this.isLoading = false;
        } else if (qVar instanceof g) {
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
            g gVar = (g) qVar;
            if (gVar.eBi() == 2) {
                if (this.AQa != null) {
                    this.AQa.clear();
                }
                this.mCount = 0;
                this.zci = false;
                this.gAR.gKN();
            } else {
                String eBj = gVar.eBj();
                Log.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(eBj)));
                if (!Util.isNullOrNil(eBj)) {
                    Iterator<i> it = this.AQa.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        i next = it.next();
                        if (eBj.equals(next.AOT)) {
                            this.AQa.remove(next);
                            this.mCount = this.AQa.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(66762);
                    MallOrderRecordListUI.this.APZ.notifyDataSetChanged();
                    AppMethodBeat.o(66762);
                }
            });
        }
        if (this.mCount > 0 || this.AQa.size() != 0) {
            showOptionMenu(true);
            findViewById(R.id.c36).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(R.id.c36).setVisibility(0);
        }
        AppMethodBeat.o(66782);
        return true;
    }
}
