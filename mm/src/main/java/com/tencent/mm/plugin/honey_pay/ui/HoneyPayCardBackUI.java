package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.honey_pay.a.k;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.svg.a.a;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.f;

public class HoneyPayCardBackUI extends HoneyPayBaseUI {
    private CdnImageView yjT;
    private WalletTextView yjU;
    private TextView yjV;
    private TextView yjW;
    private TextView yjX;
    private String yjY;
    private eig yjZ;

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64663);
        this.wwG = R.color.un;
        fixStatusbar(true);
        super.onCreate(bundle);
        setMMTitle("");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(64661);
                HoneyPayCardBackUI.this.hideVKB();
                HoneyPayCardBackUI.this.hideTenpayKB();
                HoneyPayCardBackUI.this.finish();
                AppMethodBeat.o(64661);
                return false;
            }
        });
        addSceneEndListener(2851);
        this.yjY = getIntent().getStringExtra("key_card_no");
        initView();
        Log.i(this.TAG, "do qry card detail: %s", this.yjY);
        k kVar = new k(this.yjY);
        kVar.t(this);
        doSceneProgress(kVar, true);
        AppMethodBeat.o(64663);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64664);
        this.yjT = (CdnImageView) findViewById(R.id.dq9);
        this.yjU = (WalletTextView) findViewById(R.id.dqc);
        this.yjV = (TextView) findViewById(R.id.dqd);
        this.yjW = (TextView) findViewById(R.id.dq_);
        this.yjX = (TextView) findViewById(R.id.dqb);
        this.yjU.setPrefix(ah.hhz());
        AppMethodBeat.o(64664);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64665);
        super.onDestroy();
        removeSceneEndListener(2851);
        AppMethodBeat.o(64665);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64666);
        if (qVar instanceof k) {
            final k kVar = (k) qVar;
            kVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64662);
                    HoneyPayCardBackUI.this.yjZ = kVar.yjI.LUW;
                    HoneyPayCardBackUI.a(HoneyPayCardBackUI.this, kVar.yjI);
                    AppMethodBeat.o(64662);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardBackUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        }
        AppMethodBeat.o(64666);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aud;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(64667);
        if (i2 == 1 && i3 == -1) {
            Log.i(this.TAG, "unbind success");
            finish();
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(64667);
    }

    static /* synthetic */ void a(HoneyPayCardBackUI honeyPayCardBackUI, dhd dhd) {
        AppMethodBeat.i(64668);
        honeyPayCardBackUI.yjT.setImageDrawable(a.h(honeyPayCardBackUI.getResources(), R.raw.honey_pay_bank_logo));
        if (!Util.isNullOrNil(dhd.icon)) {
            honeyPayCardBackUI.yjT.gI(dhd.icon, R.raw.honey_pay_bank_logo);
        }
        honeyPayCardBackUI.yjW.setText(dhd.pTn);
        f.i(honeyPayCardBackUI.yjX, dhd.KBN);
        honeyPayCardBackUI.yjU.setText(c.GO(dhd.MhJ));
        honeyPayCardBackUI.yjV.setText(honeyPayCardBackUI.getString(R.string.e0t, new Object[]{ah.hhz() + c.GO(dhd.LpD)}));
        c.a(honeyPayCardBackUI, dhd.MhF, honeyPayCardBackUI.yjY, 1, honeyPayCardBackUI.yjZ);
        honeyPayCardBackUI.findViewById(R.id.dqa).setVisibility(0);
        AppMethodBeat.o(64668);
    }
}
