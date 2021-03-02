package com.tencent.kinda.framework.widget.base;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankCardTypeSelectUI;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.sortview.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KindaWrapBankEditActivity extends WalletBankCardSelectUI {
    public static final String FLAG_ACTIVITY_BACK = "flag_activity_back_KindaWrapBankEditActivity";
    public static final String FLAG_ACTIVITY_CLOSE = "flag_activity_close_KindaWrapBankEditActivity";
    public static final int REQ_SELECT_BANKCARD_TYPE = 1;
    public static final String TAG = "KindaBank.KindaWrapBankEditActivity";
    private String mSelectBankName;
    private List<d> mSortEntities = new ArrayList();

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public KindaWrapBankEditActivity() {
        AppMethodBeat.i(18980);
        AppMethodBeat.o(18980);
    }

    static /* synthetic */ void access$001(KindaWrapBankEditActivity kindaWrapBankEditActivity) {
        AppMethodBeat.i(18986);
        super.fetchData();
        AppMethodBeat.o(18986);
    }

    static /* synthetic */ boolean access$200(KindaWrapBankEditActivity kindaWrapBankEditActivity) {
        AppMethodBeat.i(170119);
        boolean needConfirmFinish = kindaWrapBankEditActivity.needConfirmFinish();
        AppMethodBeat.o(170119);
        return needConfirmFinish;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(18981);
        super.onPause();
        if (isFinishing()) {
            ai aiVar = new ai();
            aiVar.dDh.dDi = FLAG_ACTIVITY_CLOSE;
            EventCenter.instance.publish(aiVar);
        }
        AppMethodBeat.o(18981);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI
    public void fetchData() {
        AppMethodBeat.i(18982);
        jd jdVar = new jd();
        try {
            jdVar.parseFrom(getIntent().getByteArrayExtra("bank_list"));
        } catch (Exception e2) {
            Log.e(TAG, "bank list parse failed");
        }
        this.bankcardList = new ArrayList();
        Iterator<jc> it = jdVar.KNG.iterator();
        while (it.hasNext()) {
            jc next = it.next();
            ElementQuery elementQuery = new ElementQuery();
            elementQuery.ynT = next.ynT;
            elementQuery.dDj = next.dDj;
            this.bankcardList.add(elementQuery);
        }
        jd jdVar2 = new jd();
        try {
            jdVar2.parseFrom(getIntent().getByteArrayExtra("bank_type_list"));
        } catch (Exception e3) {
            Log.e(TAG, "bank type list parse failed");
        }
        this.bankcardTypeList = new ArrayList();
        Iterator<jc> it2 = jdVar2.KNG.iterator();
        while (it2.hasNext()) {
            jc next2 = it2.next();
            ElementQuery elementQuery2 = new ElementQuery();
            elementQuery2.ynT = next2.ynT;
            elementQuery2.dDj = next2.dDj;
            elementQuery2.HXm = next2.KNu;
            this.bankcardTypeList.add(elementQuery2);
        }
        runOnUiThread(new Runnable() {
            /* class com.tencent.kinda.framework.widget.base.KindaWrapBankEditActivity.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(18979);
                KindaWrapBankEditActivity.access$001(KindaWrapBankEditActivity.this);
                AppMethodBeat.o(18979);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.kinda.framework.widget.base.KindaWrapBankEditActivity.AnonymousClass2 */

            public boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(170118);
                KindaWrapBankEditActivity.this.mPayResultType = 4;
                if (KindaWrapBankEditActivity.access$200(KindaWrapBankEditActivity.this)) {
                    KindaWrapBankEditActivity.this.hideVKB();
                    KindaWrapBankEditActivity.this.showDialog(1000);
                } else {
                    if (!Util.isNullOrNil(KindaWrapBankEditActivity.this.bankcardTypeList)) {
                        ai aiVar = new ai();
                        aiVar.dDh.dDi = KindaWrapBankEditActivity.FLAG_ACTIVITY_BACK;
                        EventCenter.instance.publish(aiVar);
                    }
                    KindaWrapBankEditActivity.this.finish();
                }
                AppMethodBeat.o(170118);
                return true;
            }
        });
        AppMethodBeat.o(18982);
    }

    @Override // com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI
    public void onItemSelect(Object obj, int i2) {
        AppMethodBeat.i(18983);
        BankCardSelectSortView.a aVar = (BankCardSelectSortView.a) obj;
        ArrayList<String> arrayList = new ArrayList<>();
        if (aVar == null) {
            AppMethodBeat.o(18983);
            return;
        }
        hideVKB();
        this.mSelectBankName = aVar.AOj;
        if (this.bankcardTypeList.size() == 0) {
            sendDatatoKinda(this.mSelectBankName, "");
            AppMethodBeat.o(18983);
            return;
        }
        for (ElementQuery elementQuery : this.bankcardTypeList) {
            if (elementQuery.ynT.equals(this.mSelectBankName)) {
                arrayList.add(elementQuery.HXm);
            }
        }
        if (arrayList.size() == 1) {
            sendDatatoKinda(this.mSelectBankName, arrayList.get(0));
            AppMethodBeat.o(18983);
            return;
        }
        Intent intent = new Intent(this, WalletBankCardTypeSelectUI.class);
        intent.putStringArrayListExtra("bank_type_show_list", arrayList);
        startActivityForResult(intent, 1);
        AppMethodBeat.o(18983);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(18984);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && intent != null) {
            sendDatatoKinda(this.mSelectBankName, intent.getStringExtra("bank_card_acc_name"));
        }
        AppMethodBeat.o(18984);
    }

    private void sendDatatoKinda(String str, String str2) {
        AppMethodBeat.i(18985);
        String str3 = "";
        for (ElementQuery elementQuery : this.bankcardTypeList) {
            if (elementQuery.ynT.equals(str) && elementQuery.HXm.equals(str2)) {
                str3 = elementQuery.dDj;
                Log.i(TAG, "Ktemp.bank_type：" + elementQuery.dDj);
            }
            str3 = str3;
        }
        ai aiVar = new ai();
        aiVar.dDh.dDi = str;
        aiVar.dDh.dDk = str2;
        aiVar.dDh.dDj = str3;
        EventCenter.instance.publish(aiVar);
        Log.i(TAG, "sendDataToKinda：bankName：" + str + "  bankAccName：" + str2 + "  BankType：" + str3);
        Log.i(TAG, "KindaWrapBankEditActivity.onItemSelect，发送事件，当前线程：" + Thread.currentThread().getId());
        finish();
        if (isFinishing()) {
            ai aiVar2 = new ai();
            aiVar2.dDh.dDi = FLAG_ACTIVITY_CLOSE;
            EventCenter.instance.publish(aiVar2);
        }
        AppMethodBeat.o(18985);
    }
}
