package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.ui.b;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.c;
import java.util.ArrayList;

public class ShareCardListUI extends CardBaseUI implements d, MStorage.IOnStorageChange {
    private String cardTpId = null;
    private long mStartTime = 0;
    private b.a pVL = null;
    private f pXB;
    private e pXC;
    private i pXD;
    private boolean pXE = false;
    private boolean pXF = true;
    private boolean pXG = false;
    private boolean pXH = true;
    private boolean pXI = true;
    private boolean pXJ = false;
    private String pXK = "";
    private boolean pXL = false;
    private boolean pXM = false;
    private boolean pXN = false;
    private int pXO = 0;
    private boolean pXP = false;
    private long pXQ = 0;
    boolean pXR = false;
    private boolean pXS = false;
    private com.tencent.mm.plugin.card.sharecard.a.b pXs;
    private long ptl = 0;
    private final long ptm = 500;
    private boolean ptn = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(113135);
        shareCardListUI.csn();
        AppMethodBeat.o(113135);
    }

    static /* synthetic */ void e(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(113136);
        shareCardListUI.cuS();
        AppMethodBeat.o(113136);
    }

    static /* synthetic */ void h(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(113137);
        shareCardListUI.cuU();
        AppMethodBeat.o(113137);
    }

    static /* synthetic */ void j(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(113138);
        shareCardListUI.cuO();
        AppMethodBeat.o(113138);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113104);
        super.onCreate(bundle);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.pXQ = currentTimeMillis;
        initView();
        g.aAg().hqi.a(1164, this);
        am.ctX().a(this);
        cuW();
        am.ctY().add(this);
        AppMethodBeat.o(113104);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113105);
        if (this.pXP) {
            csp();
        }
        this.pXB.pXs = null;
        this.pXC.pXs = null;
        this.pXs.pVL = null;
        g.aAg().hqi.b(1164, this);
        am.ctX().b(this);
        com.tencent.mm.plugin.card.sharecard.a.b.cuA();
        am.ctY().remove(this);
        long currentTimeMillis = System.currentTimeMillis() - this.pXQ;
        if (!TextUtils.isEmpty(this.cardTpId)) {
            h.INSTANCE.a(13219, "ShareCardListUI", 0, "", "", Long.valueOf(currentTimeMillis));
        } else {
            h.INSTANCE.a(13219, "ShareCardListUI", 1, "", "", Long.valueOf(currentTimeMillis));
        }
        super.onDestroy();
        AppMethodBeat.o(113105);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(113106);
        kv(true);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            ArrayList<IDKey> arrayList = new ArrayList<>();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(56);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(57);
            iDKey2.SetValue((long) ((int) (currentTimeMillis - this.mStartTime)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            h.INSTANCE.b(arrayList, true);
            this.mStartTime = 0;
        }
        super.onResume();
        AppMethodBeat.o(113106);
    }

    private void kv(boolean z) {
        AppMethodBeat.i(113107);
        Log.i("MicroMsg.ShareCardListUI", "doRefreshData() >> updateView() shouldGetLayout %s fromOnresume %s", Boolean.valueOf(this.pXF), Boolean.valueOf(z));
        if (this.pXF) {
            this.pXF = false;
            this.pXL = false;
            this.pXH = true;
            this.pXK = "";
            Log.d("MicroMsg.ShareCardListUI", "doRefreshData() >> doNetSceneGetCardsHomePageLayout()");
            if (!z) {
                cuU();
            } else if (this.pXP && this.pXR) {
                cso();
            }
        }
        cuO();
        AppMethodBeat.o(113107);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(113108);
        super.onPause();
        this.pXF = false;
        this.pXG = true;
        AppMethodBeat.o(113108);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final BaseAdapter anl() {
        AppMethodBeat.i(113109);
        c cVar = new c(getContext());
        AppMethodBeat.o(113109);
        return cVar;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.card.base.CardBaseUI
    public void initView() {
        AppMethodBeat.i(113110);
        super.initView();
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 69, (String) null, (String) null);
        Log.i("MicroMsg.ShareCardListUI", "checkPermission checkLocation[%b]", Boolean.valueOf(a2));
        this.pXP = a2;
        if (this.pXP) {
            cuN();
            AppMethodBeat.o(113110);
            return;
        }
        Log.e("MicroMsg.ShareCardListUI", "location permission is denied, doGetLayout");
        cuT();
        AppMethodBeat.o(113110);
    }

    private void cuN() {
        AppMethodBeat.i(113111);
        Log.d("MicroMsg.ShareCardListUI", "initLocation");
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(113100);
                ShareCardListUI.a(ShareCardListUI.this);
                ShareCardListUI.b(ShareCardListUI.this);
                ShareCardListUI.this.pXR = true;
                Log.d("MicroMsg.ShareCardListUI", "initLocation end");
                AppMethodBeat.o(113100);
            }
        }, "MicroMsg.ShareCardListUI");
        AppMethodBeat.o(113111);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void css() {
        AppMethodBeat.i(113112);
        Log.i("MicroMsg.ShareCardListUI", "onMPermissionGranted LocationPermissionGranted " + this.pXP);
        if (!this.pXP) {
            this.pXP = true;
            cuN();
        }
        AppMethodBeat.o(113112);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csj() {
        AppMethodBeat.i(113113);
        setMMTitle(R.string.asi);
        this.pXs = new com.tencent.mm.plugin.card.sharecard.a.b(this);
        this.pVL = new b.a() {
            /* class com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.AnonymousClass2 */
        };
        this.pXs.pVL = this.pVL;
        this.pXs.init();
        this.pXO = com.tencent.mm.plugin.card.sharecard.a.b.cux();
        if (this.pXD == null) {
            this.pXD = new i(this, getContentView());
            i iVar = this.pXD;
            iVar.pXU = View.inflate(iVar.pQZ, R.layout.op, null);
            iVar.pXV = (TextView) iVar.pXU.findViewById(R.id.and);
            iVar.pXW = (TextView) iVar.pXU.findViewById(R.id.anh);
            iVar.updateView();
        }
        if (this.pXB == null) {
            this.pXB = new f(this, getContentView());
            f fVar = this.pXB;
            fVar.pXw = (ImageView) fVar.jBN.findViewById(R.id.fzj);
            fVar.pXy = (TextView) fVar.jBN.findViewById(R.id.fzl);
            fVar.pXx = (TextView) fVar.jBN.findViewById(R.id.fzm);
            this.pXB.pXs = this.pXs;
        }
        if (this.pXC == null) {
            getContentView();
            this.pXC = new e(this);
            this.pXC.pXs = this.pXs;
            this.pXC.cuI();
            e eVar = this.pXC;
            AnonymousClass3 r1 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(113101);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    com.tencent.mm.plugin.card.sharecard.a.b unused = ShareCardListUI.this.pXs;
                    if (com.tencent.mm.plugin.card.sharecard.a.b.cuz()) {
                        com.tencent.mm.plugin.card.sharecard.a.b unused2 = ShareCardListUI.this.pXs;
                        if (com.tencent.mm.plugin.card.sharecard.a.b.cuy()) {
                            ShareCardListUI.this.pXO = 2;
                            h.INSTANCE.a(11582, "OperChangeOtherCity ", 0, 0, "", "", "");
                            am.ctV().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.this.pXO));
                            ShareCardListUI.e(ShareCardListUI.this);
                            ShareCardListUI.this.pXC.updateView();
                            com.tencent.mm.plugin.card.sharecard.a.b unused3 = ShareCardListUI.this.pXs;
                            com.tencent.mm.plugin.card.sharecard.a.b.pVM = true;
                            a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(113101);
                        }
                    }
                    com.tencent.mm.plugin.card.sharecard.a.b unused4 = ShareCardListUI.this.pXs;
                    if (com.tencent.mm.plugin.card.sharecard.a.b.cuy()) {
                        ShareCardListUI.this.pXO = 3;
                    }
                    h.INSTANCE.a(11582, "OperChangeOtherCity ", 0, 0, "", "", "");
                    am.ctV().putValue("key_share_card_show_type", Integer.valueOf(ShareCardListUI.this.pXO));
                    ShareCardListUI.e(ShareCardListUI.this);
                    ShareCardListUI.this.pXC.updateView();
                    com.tencent.mm.plugin.card.sharecard.a.b unused32 = ShareCardListUI.this.pXs;
                    com.tencent.mm.plugin.card.sharecard.a.b.pVM = true;
                    a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113101);
                }
            };
            if (eVar.pXr != null) {
                eVar.pXr.setOnClickListener(r1);
            }
        }
        if (this.pQt != null) {
            this.pQt.addView(this.pXD.pXU);
        }
        if (this.pQu != null) {
            this.pQu.addView(this.pXC.pXr);
        }
        this.pQq.setVisibility(0);
        this.pQq.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.AnonymousClass4 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                AppMethodBeat.i(113102);
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !ShareCardListUI.this.pXI && ShareCardListUI.this.pXO != 4) {
                    Log.d("MicroMsg.ShareCardListUI", "onScroll() >> doNetSceneGetCardsHomePageLayout()");
                    ShareCardListUI.h(ShareCardListUI.this);
                }
                AppMethodBeat.o(113102);
            }
        });
        if (getIntent() == null || !getIntent().getBooleanExtra("KEY_IS_SHOW_SHARE_CARD_ENTRANCE_TIPS", true)) {
            Integer num = (Integer) g.aAh().azQ().get(ar.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, (Object) 0);
            if (!(num == null || num.intValue() == 1)) {
                g.aAh().azQ().set(ar.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, (Object) 1);
            }
        } else {
            Integer num2 = (Integer) g.aAh().azQ().get(ar.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, (Object) 0);
            if (num2 == null || num2.intValue() != 1) {
                g.aAh().azQ().set(ar.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_ENTRANCE_TIP_INT_SYNC, (Object) 1);
                com.tencent.mm.plugin.card.d.d.c(this, R.layout.ow, R.string.ass, "");
            }
        }
        this.cardTpId = getIntent().getStringExtra("KEY_CARD_TP_ID");
        this.pXK = getIntent().getStringExtra("key_layout_buff");
        if (!Util.isNullOrNil(this.pXK)) {
            this.pXF = false;
        }
        if (!Util.isNullOrNil(this.cardTpId)) {
            this.pXE = true;
            this.pXG = true;
        }
        AppMethodBeat.o(113113);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(113114);
        super.onNewIntent(intent);
        setIntent(intent);
        cuW();
        if (intent != null) {
            this.cardTpId = intent.getStringExtra("KEY_CARD_TP_ID");
            if (!Util.isNullOrNil(this.cardTpId)) {
                this.pXE = true;
                this.pXG = true;
            }
        }
        AppMethodBeat.o(113114);
    }

    private void cuO() {
        AppMethodBeat.i(113115);
        long currentTimeMillis = System.currentTimeMillis() - this.ptl;
        if (!this.ptn || currentTimeMillis >= 1000) {
            Log.d("MicroMsg.ShareCardListUI", "try2UpdateView isDoingUpdateView %s,interval %s", Boolean.valueOf(this.ptn), Long.valueOf(currentTimeMillis));
            this.ptn = true;
            if (currentTimeMillis < 500) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(113103);
                        ShareCardListUI.this.ptn = false;
                        if (!ShareCardListUI.this.isFinishing()) {
                            ShareCardListUI.j(ShareCardListUI.this);
                            AppMethodBeat.o(113103);
                            return;
                        }
                        Log.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
                        AppMethodBeat.o(113103);
                    }
                }, 500);
                AppMethodBeat.o(113115);
                return;
            }
            updateView();
            this.ptl = System.currentTimeMillis();
            this.ptn = false;
            AppMethodBeat.o(113115);
            return;
        }
        Log.d("MicroMsg.ShareCardListUI", "DoingUpdateView return");
        AppMethodBeat.o(113115);
    }

    private void updateView() {
        AppMethodBeat.i(113116);
        cuV();
        Log.i("MicroMsg.ShareCardListUI", "updateView() currentType is %s, canShowLocalCity %s, canShowOtherCity %s", Integer.valueOf(this.pXO), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cuz()), Boolean.valueOf(com.tencent.mm.plugin.card.sharecard.a.b.cuy()));
        this.pXB.updateView();
        if (com.tencent.mm.plugin.card.sharecard.a.b.cuz() || com.tencent.mm.plugin.card.sharecard.a.b.cuy()) {
            this.pXC.updateView();
            this.pXD.updateView();
            if (this.pXO == 4) {
                cuR();
            }
        } else {
            this.pXC.cnh();
            this.pXD.cuX();
            cuP();
        }
        cuS();
        AppMethodBeat.o(113116);
    }

    private void cuP() {
        AppMethodBeat.i(113117);
        if (this.pQq.getEmptyView() != this.pQs) {
            this.pQq.setEmptyView(this.pQs);
            this.pQq.invalidate();
        }
        AppMethodBeat.o(113117);
    }

    private void cuQ() {
        AppMethodBeat.i(113118);
        if (!com.tencent.mm.plugin.card.sharecard.a.b.cuz() && !com.tencent.mm.plugin.card.sharecard.a.b.cuy()) {
            this.pXC.cuK();
            this.pQq.setEmptyView(null);
            this.pQq.invalidate();
            this.pXS = true;
        }
        AppMethodBeat.o(113118);
    }

    private void cuR() {
        AppMethodBeat.i(113119);
        if (this.pQq.getEmptyView() != null) {
            this.pQq.setEmptyView(null);
            this.pQq.invalidate();
        }
        AppMethodBeat.o(113119);
    }

    private void cuS() {
        AppMethodBeat.i(113120);
        if (this.pQr instanceof c) {
            ((c) this.pQr).Eo(this.pXO);
        }
        AppMethodBeat.o(113120);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csq() {
        AppMethodBeat.i(113121);
        this.pXN = true;
        if (this.pXL) {
            Log.e("MicroMsg.ShareCardListUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.pXP) {
                csp();
            }
            AppMethodBeat.o(113121);
            return;
        }
        Log.d("MicroMsg.ShareCardListUI", "onLocationFinish()");
        this.pXL = true;
        cuT();
        csp();
        AppMethodBeat.o(113121);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void csr() {
        AppMethodBeat.i(113122);
        if (this.pXM || this.pXL) {
            csp();
            AppMethodBeat.o(113122);
            return;
        }
        this.pXM = true;
        Log.i("MicroMsg.ShareCardListUI", "onLocationFail()");
        cuT();
        AppMethodBeat.o(113122);
    }

    private void cuT() {
        AppMethodBeat.i(113123);
        if (!com.tencent.mm.plugin.card.sharecard.a.b.cuB() || !com.tencent.mm.plugin.card.sharecard.a.b.cuC()) {
            if (!com.tencent.mm.plugin.card.sharecard.a.b.cuB() || !com.tencent.mm.plugin.card.sharecard.a.b.cuC()) {
                this.pXH = false;
            }
            Log.i("MicroMsg.ShareCardListUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
            cuU();
            am.ctW().G("", "", 4);
            AppMethodBeat.o(113123);
            return;
        }
        Log.i("MicroMsg.ShareCardListUI", "doGetLayout() no data to load");
        this.pXI = true;
        AppMethodBeat.o(113123);
    }

    private void cuU() {
        AppMethodBeat.i(113124);
        if (this.pXJ) {
            Log.e("MicroMsg.ShareCardListUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
            AppMethodBeat.o(113124);
            return;
        }
        if (Util.isNullOrNil(this.pXK) && !com.tencent.mm.plugin.card.sharecard.a.b.cuz() && !com.tencent.mm.plugin.card.sharecard.a.b.cuy()) {
            cuQ();
        }
        if (this.pXH && !Util.isNullOrNil(this.pXK)) {
            this.pXK = "";
        }
        this.pXJ = true;
        g.aAg().hqi.a(new com.tencent.mm.plugin.card.sharecard.model.b((double) am.ctW().gmu, (double) am.ctW().gmv, this.pXK), 0);
        AppMethodBeat.o(113124);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final boolean csl() {
        AppMethodBeat.i(113125);
        boolean csl = super.csl();
        AppMethodBeat.o(113125);
        return csl;
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final boolean csm() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void b(com.tencent.mm.plugin.card.base.b bVar, int i2) {
        AppMethodBeat.i(113126);
        if (bVar != null) {
            com.tencent.mm.plugin.card.sharecard.a.b.ajq(bVar.csV());
        }
        super.b(bVar, i2);
        AppMethodBeat.o(113126);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void a(com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(113127);
        super.a(bVar);
        AppMethodBeat.o(113127);
    }

    @Override // com.tencent.mm.plugin.card.base.CardBaseUI
    public final void a(com.tencent.mm.plugin.card.base.b bVar, int i2) {
        AppMethodBeat.i(113128);
        Intent intent = new Intent(this, CardDetailUI.class);
        Log.i("MicroMsg.ShareCardListUI", "card tp id:" + bVar.csV());
        Log.i("MicroMsg.ShareCardListUI", "card id:" + bVar.csU());
        intent.putExtra("key_card_id", am.ctY().ajy(bVar.csV()));
        intent.putExtra("key_card_tp_id", bVar.csV());
        intent.putExtra("key_is_share_card", true);
        intent.putExtra("key_from_scene", 3);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        a.a(this, "com/tencent/mm/plugin/card/sharecard/ui/ShareCardListUI", "onGotoCardDetailUI", "(Lcom/tencent/mm/plugin/card/base/ICardInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.card.sharecard.a.b.ajv(bVar.csV());
        AppMethodBeat.o(113128);
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.card.base.CardBaseUI
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = true;
        AppMethodBeat.i(113129);
        super.onSceneEnd(i2, i3, str, qVar);
        if (i2 != 0 || i3 != 0) {
            if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                if (this.pXS) {
                    this.pXS = false;
                    this.pXC.cuL();
                    this.pQq.setEmptyView(this.pQs);
                    this.pQq.invalidate();
                }
                this.pXJ = false;
                this.pXI = true;
            }
            Log.i("MicroMsg.ShareCardListUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        } else if (qVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) qVar;
            this.pXJ = false;
            this.pXK = bVar.pVT;
            this.pXs.aL(bVar.pTY, this.pXH);
            if (!com.tencent.mm.plugin.card.sharecard.a.b.cuB() || !com.tencent.mm.plugin.card.sharecard.a.b.cuC()) {
                this.pXH = false;
            }
            if (!com.tencent.mm.plugin.card.sharecard.a.b.cuB() || !com.tencent.mm.plugin.card.sharecard.a.b.cuC()) {
                z = false;
            }
            this.pXI = z;
            Log.i("MicroMsg.ShareCardListUI", "NetSceneGetShareCardsLayout() >> updateView()");
            cuO();
            AppMethodBeat.o(113129);
            return;
        }
        AppMethodBeat.o(113129);
    }

    private void cuV() {
        AppMethodBeat.i(113130);
        if (this.pXO == 0 || this.pXO == 4 || ((this.pXO == 2 && (!com.tencent.mm.plugin.card.sharecard.a.b.cuz() || !com.tencent.mm.plugin.card.sharecard.a.b.cuy())) || ((this.pXO == 1 && (!com.tencent.mm.plugin.card.sharecard.a.b.cuz() || com.tencent.mm.plugin.card.sharecard.a.b.cuy())) || (this.pXO == 3 && (!com.tencent.mm.plugin.card.sharecard.a.b.cuy() || com.tencent.mm.plugin.card.sharecard.a.b.cuz()))))) {
            this.pXO = com.tencent.mm.plugin.card.sharecard.a.b.cux();
        }
        am.ctV().putValue("key_share_card_show_type", Integer.valueOf(this.pXO));
        AppMethodBeat.o(113130);
    }

    @Override // com.tencent.mm.plugin.card.base.d
    public final void ctb() {
        AppMethodBeat.i(113131);
        com.tencent.mm.plugin.card.sharecard.a.b.cuw();
        this.pXF = true;
        Log.i("MicroMsg.ShareCardListUI", "onDBchange() shouldRefreshDataOnDbChange %s  mIsActive %s hasLocationInfo %s", Boolean.valueOf(this.pXG), Boolean.valueOf(this.pQw), Boolean.valueOf(this.pXN));
        if (!this.pXG || !this.pQw || !this.pXN) {
            cuO();
        } else {
            kv(false);
        }
        this.pXG = false;
        AppMethodBeat.o(113131);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(113132);
        Log.d("MicroMsg.ShareCardListUI", "onNotifyChange");
        this.pXF = true;
        AppMethodBeat.o(113132);
    }

    private void cuW() {
        AppMethodBeat.i(113133);
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean cO = c.axV().cO(262152, 266256);
        boolean cP = c.axV().cP(262152, 266256);
        boolean a2 = c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a3 = c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(ar.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) null));
        if (cO) {
            h.INSTANCE.a(11324, "ShareCardListUI", 0, "", "", 2, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113133);
        } else if (cP) {
            h.INSTANCE.a(11324, "ShareCardListUI", 0, "", "", 1, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113133);
        } else if (a2 && !a3) {
            h.INSTANCE.a(11324, "ShareCardListUI", 0, "", "", 3, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113133);
        } else if (a2 && a3) {
            h.INSTANCE.a(11324, "ShareCardListUI", 0, "", "", 4, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113133);
        } else if (a3) {
            h.INSTANCE.a(11324, "ShareCardListUI", 0, "", "", 5, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113133);
        } else {
            h.INSTANCE.a(11324, "ShareCardListUI", 0, "", "", 0, Integer.valueOf(intExtra), "", 0, nullAsNil);
            AppMethodBeat.o(113133);
        }
    }

    static /* synthetic */ void a(ShareCardListUI shareCardListUI) {
        AppMethodBeat.i(113134);
        shareCardListUI.iOv = com.tencent.mm.modelgeo.d.bca();
        AppMethodBeat.o(113134);
    }
}
