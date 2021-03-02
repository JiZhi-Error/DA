package com.tencent.mm.plugin.order.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a;
import com.tencent.mm.plugin.order.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.c;
import java.util.List;

public class MallOrderTransactionInfoUI extends WalletPreferenceUI {
    private int AQo;
    private MallTransactionObject AQp = null;
    private c AQq;
    protected f nRm;

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        String stringExtra;
        String str;
        AppMethodBeat.i(66786);
        super.onCreate(bundle);
        d by = a.by(this);
        if (by != null && (by instanceof com.tencent.mm.plugin.order.a.a)) {
            String string = getInput().getString("key_trans_id");
            stringExtra = getInput().getString("bill_id");
            str = string;
        } else if (getIntent().getIntExtra("scene", 0) == 1 || getIntent().getIntExtra("scene", 0) == 2) {
            String stringExtra2 = getIntent().getStringExtra("trans_id");
            stringExtra = getIntent().getStringExtra("bill_id");
            str = stringExtra2;
        } else {
            stringExtra = null;
            str = null;
        }
        if (Util.isNullOrNil(str)) {
            Log.w(MMPreference.TAG, "mOrders info is Illegal!");
            h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(66784);
                    MallOrderTransactionInfoUI.this.finish();
                    AppMethodBeat.o(66784);
                }
            });
        }
        this.AQo = getInput().getInt("key_pay_type");
        initView();
        hhW().a(new com.tencent.mm.plugin.order.model.h(str, stringExtra), true, 1);
        AppMethodBeat.o(66786);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(66787);
        setMMTitle(R.string.ewa);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.order.ui.MallOrderTransactionInfoUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(66785);
                MallOrderTransactionInfoUI.this.finish();
                AppMethodBeat.o(66785);
                return false;
            }
        });
        this.nRm = getPreferenceScreen();
        this.AQq = new c(this);
        this.AQq.hhP();
        AppMethodBeat.o(66787);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(66788);
        super.onDestroy();
        if (this.AQq != null) {
            this.AQq.release();
        }
        AppMethodBeat.o(66788);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.base.preference.MMPreference
    public int getLayoutId() {
        return R.layout.b6a;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bi;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI
    public final boolean e(int i2, int i3, String str, q qVar) {
        MallOrderDetailObject mallOrderDetailObject;
        a.AbstractC1568a bVar;
        List<Preference> a2;
        AppMethodBeat.i(66789);
        if (i2 == 0 && i3 == 0) {
            if ((qVar instanceof com.tencent.mm.plugin.order.model.h) && (mallOrderDetailObject = ((com.tencent.mm.plugin.order.model.h) qVar).AOR) != null) {
                this.AQp = mallOrderDetailObject.ANI;
                this.nRm.removeAll();
                AppCompatActivity context = getContext();
                f fVar = this.nRm;
                MallTransactionObject mallTransactionObject = this.AQp;
                Object[] objArr = {this.AQq};
                if (mallTransactionObject == null) {
                    a2 = null;
                } else {
                    switch (mallTransactionObject.efQ) {
                        case 21:
                            bVar = new b();
                            break;
                        default:
                            bVar = new com.tencent.mm.plugin.order.ui.a.a();
                            if (objArr[0] instanceof c) {
                                ((com.tencent.mm.plugin.order.ui.a.a) bVar).AQq = (c) objArr[0];
                                break;
                            }
                            break;
                    }
                    a2 = bVar.a(context, fVar, mallTransactionObject);
                }
                if (a2 != null) {
                    for (int i4 = 0; i4 < a2.size(); i4++) {
                        this.nRm.c(a2.get(i4));
                    }
                }
                this.nRm.notifyDataSetChanged();
            }
            AppMethodBeat.o(66789);
            return true;
        }
        AppMethodBeat.o(66789);
        return false;
    }

    private Bundle getInput() {
        AppMethodBeat.i(66790);
        Bundle bx = com.tencent.mm.wallet_core.a.bx(this);
        if (bx == null) {
            bx = new Bundle();
        }
        AppMethodBeat.o(66790);
        return bx;
    }
}
