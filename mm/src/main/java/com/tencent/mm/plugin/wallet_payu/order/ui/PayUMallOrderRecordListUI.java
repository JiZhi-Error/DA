package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.widget.ListAdapter;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI;
import com.tencent.mm.plugin.wallet_payu.order.a.a;
import com.tencent.mm.plugin.wallet_payu.order.a.b;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.dbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class PayUMallOrderRecordListUI extends MallOrderRecordListUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.order.ui.MallOrderRecordListUI, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
    public final void eBm() {
        AppMethodBeat.i(72073);
        addSceneEndListener(1519);
        addSceneEndListener(1544);
        AppMethodBeat.o(72073);
    }

    @Override // com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
    public final void eBn() {
        AppMethodBeat.i(72074);
        removeSceneEndListener(1519);
        removeSceneEndListener(1544);
        AppMethodBeat.o(72074);
    }

    @Override // com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
    public final void jj(String str, String str2) {
        AppMethodBeat.i(72075);
        doSceneProgress(new b(str));
        AppMethodBeat.o(72075);
    }

    @Override // com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
    public final void eBo() {
        AppMethodBeat.i(72076);
        doSceneProgress(new a(this.fs));
        AppMethodBeat.o(72076);
    }

    @Override // com.tencent.mm.plugin.order.ui.MallOrderRecordListUI
    public final String Ul(int i2) {
        AppMethodBeat.i(72077);
        String a2 = f.a(i2, new SimpleDateFormat("dd MMMM", Locale.ENGLISH), new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH));
        AppMethodBeat.o(72077);
        return a2;
    }

    @Override // com.tencent.mm.plugin.order.ui.MallOrderRecordListUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(72078);
        if (qVar instanceof a) {
            if (this.mProgressDialog != null) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
            a aVar = (a) qVar;
            LinkedList<dbe> linkedList = ((dav) aVar.rr.iLL.iLR).MGa;
            LinkedList linkedList2 = new LinkedList();
            Iterator<dbe> it = linkedList.iterator();
            while (it.hasNext()) {
                dbe next = it.next();
                i iVar = new i();
                iVar.xMq = next.xMq;
                iVar.APc = next.APc;
                iVar.APd = next.APd;
                iVar.CreateTime = next.CreateTime;
                iVar.AOY = next.AOY;
                iVar.AOV = next.AOV;
                iVar.APb = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                iVar.AOX = next.AOX;
                iVar.APa = next.APa;
                iVar.APg = 1;
                iVar.APf = next.APf;
                iVar.APe = next.APe;
                iVar.AOZ = next.AOZ;
                iVar.AOU = (double) next.MFR;
                iVar.AOW = next.AOW;
                iVar.AOT = next.AOT;
                linkedList2.add(iVar);
            }
            fM(linkedList2);
            fN(null);
            this.mCount = this.AQa.size();
            this.zci = aVar.fUC() > this.mCount;
            this.APZ.notifyDataSetChanged();
            Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list count: " + this.mCount);
            Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list total record: " + aVar.fUC());
            Log.d("MicroMsg.PayUMallOrderRecordListUI", "orders list has more: " + this.zci);
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(72071);
                    if (PayUMallOrderRecordListUI.this.zci) {
                        Log.v("MicroMsg.PayUMallOrderRecordListUI", "has more");
                        if (!PayUMallOrderRecordListUI.this.AQc) {
                            PayUMallOrderRecordListUI.this.gAR.gKM();
                            PayUMallOrderRecordListUI.this.gAR.setAdapter((ListAdapter) PayUMallOrderRecordListUI.this.APZ);
                            PayUMallOrderRecordListUI.this.AQc = true;
                        }
                    } else {
                        Log.v("MicroMsg.PayUMallOrderRecordListUI", "no more! dismiss footer view!");
                        PayUMallOrderRecordListUI.this.gAR.gKN();
                    }
                    PayUMallOrderRecordListUI.this.APZ.notifyDataSetChanged();
                    AppMethodBeat.o(72071);
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
                Log.d("MicroMsg.PayUMallOrderRecordListUI", "delete transId:".concat(String.valueOf(eBj)));
                if (!Util.isNullOrNil(eBj)) {
                    Iterator it2 = this.AQa.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        i iVar2 = (i) it2.next();
                        if (eBj.equals(iVar2.AOT)) {
                            this.AQa.remove(iVar2);
                            this.mCount = this.AQa.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderRecordListUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(72072);
                    PayUMallOrderRecordListUI.this.APZ.notifyDataSetChanged();
                    AppMethodBeat.o(72072);
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
        AppMethodBeat.o(72078);
        return true;
    }
}
