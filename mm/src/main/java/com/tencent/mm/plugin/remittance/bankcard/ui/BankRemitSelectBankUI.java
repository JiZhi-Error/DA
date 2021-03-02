package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.protobuf.jg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BankRemitSelectBankUI extends BankRemitBaseUI {
    private BankRemitSortView Clv;

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67580);
        super.onCreate(bundle);
        setMMTitle(R.string.ac2);
        addSceneEndListener(1399);
        initView();
        Log.i("MicroMsg.BankRemitSelectBankUI", "do fetch data");
        h hVar = new h();
        hVar.t(this);
        doSceneProgress(hVar);
        AppMethodBeat.o(67580);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67581);
        this.Clv = (BankRemitSortView) findViewById(R.id.ae1);
        this.Clv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(67576);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectBankUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                jg jgVar = (jg) ((d) adapterView.getAdapter().getItem(i2)).data;
                if (jgVar != null) {
                    BankcardElemParcel bankcardElemParcel = new BankcardElemParcel(jgVar);
                    Intent intent = new Intent();
                    intent.putExtra("key_bank_card_elem_parcel", bankcardElemParcel);
                    BankRemitSelectBankUI.this.setResult(-1, intent);
                    BankRemitSelectBankUI.this.finish();
                } else {
                    Log.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", Integer.valueOf(i2));
                }
                a.a(this, "com/tencent/mm/plugin/remittance/bankcard/ui/BankRemitSelectBankUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(67576);
            }
        });
        AppMethodBeat.o(67581);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(67582);
        if (qVar instanceof h) {
            final h hVar = (h) qVar;
            hVar.a(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    String sb;
                    AppMethodBeat.i(67579);
                    ArrayList arrayList = new ArrayList();
                    LinkedList<jg> linkedList = hVar.CiP.LSO;
                    LinkedList<jg> linkedList2 = hVar.CiP.LSN;
                    com.tencent.mm.plugin.remittance.bankcard.model.b bVar = new com.tencent.mm.plugin.remittance.bankcard.model.b();
                    if (linkedList != null && !linkedList.isEmpty()) {
                        Log.i("MicroMsg.BankRemitSelectBankUI", "freq card count: %s", Integer.valueOf(linkedList2.size()));
                        for (jg jgVar : linkedList) {
                            d dVar = new d();
                            dVar.Pae = "☆";
                            dVar.data = jgVar;
                            arrayList.add(dVar);
                        }
                    }
                    if (linkedList2 != null && !linkedList2.isEmpty()) {
                        Log.i("MicroMsg.BankRemitSelectBankUI", "card count: %s", Integer.valueOf(linkedList2.size()));
                        Collections.sort(linkedList2, bVar);
                        for (jg jgVar2 : linkedList2) {
                            if (!Util.isNullOrNil(jgVar2.ynT)) {
                                if (!Util.isNullOrNil(jgVar2.KNP)) {
                                    Log.i("MicroMsg.BankRemitSelectBankUI", "use sort pingyin: %s", jgVar2.KNP);
                                    sb = new StringBuilder().append(jgVar2.KNP.toUpperCase().charAt(0)).toString();
                                } else {
                                    sb = new StringBuilder().append(com.tencent.mm.plugin.remittance.bankcard.model.a.aLU(jgVar2.ynT)).toString();
                                }
                                d dVar2 = new d();
                                dVar2.Pae = sb;
                                dVar2.data = jgVar2;
                                arrayList.add(dVar2);
                            }
                        }
                    }
                    BankRemitSelectBankUI.this.Clv.hy(arrayList);
                    AppMethodBeat.o(67579);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67578);
                    Log.e("MicroMsg.BankRemitSelectBankUI", "response error: %s, %s", Integer.valueOf(hVar.CiP.dDN), hVar.CiP.qwn);
                    if (!Util.isNullOrNil(hVar.CiP.qwn)) {
                        Toast.makeText(BankRemitSelectBankUI.this, hVar.CiP.qwn, 1).show();
                    }
                    AppMethodBeat.o(67578);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(67577);
                    Log.e("MicroMsg.BankRemitSelectBankUI", "net error: %s", hVar);
                    AppMethodBeat.o(67577);
                }
            });
        }
        AppMethodBeat.o(67582);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.il;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(67583);
        super.onDestroy();
        removeSceneEndListener(1399);
        AppMethodBeat.o(67583);
    }
}
