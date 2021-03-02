package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.b.i;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.card.ui.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

public class CardDetailUI extends MMActivity implements i, c.a, d.a, j.a, ScreenShotUtil.ScreenShotCallback {
    private View GQ;
    private final String TAG = "MicroMsg.CardDetailUI";
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.card.ui.CardDetailUI.AnonymousClass1 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(113199);
            if (!z) {
                AppMethodBeat.o(113199);
                return true;
            }
            if (CardDetailUI.this.gmu == -85.0f && CardDetailUI.this.gmv == -1000.0f) {
                CardDetailUI.this.gmu = f3;
                CardDetailUI.this.gmv = f2;
                am.ctW().R(CardDetailUI.this.gmu, CardDetailUI.this.gmv);
            }
            com.tencent.mm.plugin.card.b.i iVar = CardDetailUI.this.pZp;
            float f4 = CardDetailUI.this.gmv;
            float f5 = CardDetailUI.this.gmu;
            synchronized (iVar.dBh) {
                try {
                    iVar.gmu = f5;
                    iVar.gmv = f4;
                } catch (Throwable th) {
                    AppMethodBeat.o(113199);
                    throw th;
                }
            }
            if (CardDetailUI.this.pZn) {
                CardDetailUI.e(CardDetailUI.this);
                CardDetailUI.this.pZn = false;
            }
            CardDetailUI.g(CardDetailUI.this);
            AppMethodBeat.o(113199);
            return false;
        }
    };
    private float gmu = -85.0f;
    private float gmv = -1000.0f;
    private int gwE = 3;
    private q gxX = null;
    private com.tencent.mm.modelgeo.d iOv;
    private String ixM = "";
    MMHandler mHandler = new MMHandler();
    private long mStartTime = 0;
    private String pQH = "";
    private com.tencent.mm.plugin.card.base.b pQV;
    private String pRT = "";
    private ArrayList<us> pRc;
    private boolean pSh = false;
    private int pWG = -1;
    private boolean pWT = false;
    private boolean pXP = false;
    private int pYI = 0;
    private String pYJ = "";
    private String pYK = "";
    private String pYL = "";
    e pZb;
    private String pZc = "";
    private String pZd = "";
    private String pZe = "";
    private boolean pZf = false;
    private boolean pZg = false;
    private boolean pZh = false;
    private String pZi = "";
    private e.a pZj;
    private boolean pZk = false;
    private boolean pZl = true;
    private boolean pZm = false;
    private boolean pZn = false;
    private String pZo = "";
    private com.tencent.mm.plugin.card.b.i pZp = new com.tencent.mm.plugin.card.b.i();
    private Vibrator paT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardDetailUI() {
        AppMethodBeat.i(113213);
        AppMethodBeat.o(113213);
    }

    static /* synthetic */ void c(CardDetailUI cardDetailUI, String str) {
        AppMethodBeat.i(113261);
        cardDetailUI.ajb(str);
        AppMethodBeat.o(113261);
    }

    static /* synthetic */ void e(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(113251);
        cardDetailUI.cvi();
        AppMethodBeat.o(113251);
    }

    static /* synthetic */ void g(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(113252);
        cardDetailUI.csp();
        AppMethodBeat.o(113252);
    }

    static /* synthetic */ void o(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(113259);
        cardDetailUI.cvj();
        AppMethodBeat.o(113259);
    }

    static /* synthetic */ void q(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(113260);
        cardDetailUI.ku(true);
        AppMethodBeat.o(113260);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.mp;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113214);
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        cvd();
        d cub = am.cub();
        AppCompatActivity context = getContext();
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.f.b.CTRL_INDEX, cub);
        am.ctX().a(cub);
        com.tencent.mm.plugin.card.b.b ctP = am.ctP();
        if (ctP.pQG == null) {
            ctP.pQG = new ArrayList();
        }
        ctP.pQG.add(new WeakReference<>(cub));
        cub.mContextRef = new WeakReference<>(context);
        am.cub().a(this);
        am.cuc().a(this);
        c cud = am.cud();
        g.aAg().hqi.a(ah.CTRL_INDEX, cud);
        cud.pQI.clear();
        cud.pQJ = 0;
        am.cud().a(this);
        initView();
        AppMethodBeat.o(113214);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        boolean z;
        AppMethodBeat.i(113215);
        super.onResume();
        cvd();
        if (this.iOv != null) {
            this.iOv.a(this.gmA, true);
        }
        this.pZb.dLD = false;
        ScreenShotUtil.setScreenShotCallback(this, this);
        am.cub().a(this, true);
        if ((this.pZf || this.pZg) && this.pQV.csw()) {
            if (this.pQV.csJ()) {
                am.cuc().cO(this.pQH, 2);
                Boolean bool = am.cub().pQU.get(this.pQH);
                if (bool == null || !bool.booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z || TextUtils.isEmpty(am.cub().pQX)) {
                    Log.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
                } else {
                    Log.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
                    ajc(am.cub().pQX);
                }
                this.pZb.pZz.d(com.tencent.mm.plugin.card.d.c.CARDCODEREFRESHACTION_DOREFRESH);
            } else {
                am.cuc().cO(this.pQH, 1);
                com.tencent.mm.plugin.card.ui.view.g gVar = this.pZb.pZz;
                if (gVar != null) {
                    gVar.d(com.tencent.mm.plugin.card.d.c.CARDCODEREFRESHACTION_DOREFRESH);
                }
            }
        }
        if (this.pZp.isInit) {
            this.pZp.start();
        }
        AppMethodBeat.o(113215);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(113216);
        cve();
        super.onPause();
        this.pZb.dLD = true;
        am.cub().a(this, false);
        ScreenShotUtil.setScreenShotCallback(this, null);
        com.tencent.mm.plugin.card.b.i iVar = this.pZp;
        if (iVar.ctA()) {
            Log.i("MicroMsg.CardLbsOrBluetooth", "stop");
            if (iVar.pRn != null) {
                iVar.pRn.ctD();
            }
            iVar.ctx();
            g.aAg().hqi.b(2574, iVar);
        }
        AppMethodBeat.o(113216);
    }

    @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
    public void onScreenShot(String str, long j2) {
        AppMethodBeat.i(201307);
        com.tencent.mm.plugin.card.ui.view.g gVar = this.pZb.pZz;
        if (gVar != null) {
            gVar.cmW();
        }
        h.INSTANCE.a(16827, this.pQH, Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.o(201307);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        g.a aVar;
        AppMethodBeat.i(113218);
        am.cub().c(this);
        cve();
        am.cub().b(this);
        am.cub().release();
        am.cuc().b(this);
        am.cud().b(this);
        am.cud().release();
        e eVar = this.pZb;
        f fVar = eVar.pZN;
        fVar.pQV = null;
        fVar.pRa.clear();
        eVar.pZN = null;
        j jVar = eVar.pZL;
        l.Z(jVar.qdH);
        for (int size = jVar.qdO.size() - 1; size >= 0; size--) {
            l.Z(jVar.qdO.remove(size));
        }
        jVar.qdO.clear();
        if (jVar.kuK.isShowing()) {
            jVar.kuK.dismiss();
        }
        jVar.kuK = null;
        jVar.cwj();
        jVar.qdG = null;
        jVar.pQV = null;
        eVar.pZL = null;
        if (eVar.pZx != null) {
            eVar.pZx.release();
        }
        eVar.pQZ.mmSetOnActivityResultCallback(null);
        EventCenter.instance.removeListener(eVar.pZW);
        eVar.pZt.destroy();
        eVar.pZw.destroy();
        eVar.pZv.destroy();
        eVar.pZJ.destroy();
        if (eVar.pZK != null) {
            eVar.pZK.destroy();
        }
        if (eVar.pZC != null) {
            eVar.pZC.destroy();
        }
        if (eVar.pZB != null) {
            eVar.pZB.destroy();
        }
        if (eVar.pZD != null) {
            eVar.pZD.destroy();
        }
        if (eVar.pZE != null) {
            eVar.pZE.destroy();
        }
        if (eVar.pZF != null) {
            eVar.pZF.destroy();
        }
        if (eVar.pZG != null) {
            eVar.pZG.destroy();
        }
        if (eVar.pZH != null) {
            eVar.pZH.destroy();
        }
        if (eVar.pZI != null) {
            eVar.pZI.destroy();
        }
        if (eVar.pZz != null) {
            eVar.pZz.destroy();
        }
        eVar.pZs = null;
        com.tencent.mm.plugin.card.b.g cug = am.cug();
        if (cug.pQG != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= cug.pQG.size()) {
                    break;
                }
                WeakReference<g.a> weakReference = cug.pQG.get(i2);
                if (!(weakReference == null || (aVar = weakReference.get()) == null || !aVar.equals(eVar))) {
                    cug.pQG.remove(weakReference);
                    break;
                }
                i2++;
            }
        }
        am.cug().release();
        this.paT.cancel();
        csp();
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (this.pQV != null) {
            h.INSTANCE.a(13219, "CardDetailView", Integer.valueOf(this.gwE), this.pQV.csV(), this.pQV.csU(), Long.valueOf(currentTimeMillis));
        } else {
            h.INSTANCE.a(13219, "CardDetailView", Integer.valueOf(this.gwE), this.pQH, this.pQH, Long.valueOf(currentTimeMillis));
        }
        if ((this.pZf || this.pZg) && this.pQV != null && this.pQV.csw()) {
            if (this.pQV.csJ()) {
                am.cuc().cO(this.pQH, 2);
            } else {
                am.cuc().cO(this.pQH, 1);
            }
        }
        com.tencent.mm.plugin.card.b.i iVar = this.pZp;
        Log.i("MicroMsg.CardLbsOrBluetooth", "uninit");
        if (iVar.pRn != null) {
            i.a aVar2 = iVar.pRn;
            if (aVar2.lKJ == null) {
                Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
            } else {
                MMApplicationContext.getContext().unregisterReceiver(aVar2.lKJ);
                aVar2.lKJ = null;
            }
            iVar.pRn = null;
        }
        iVar.ctx();
        iVar.pRs = null;
        iVar.pRg = null;
        super.onDestroy();
        AppMethodBeat.o(113218);
    }

    private void cvd() {
        AppMethodBeat.i(113219);
        com.tencent.mm.kernel.g.aAg().hqi.a(1057, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(1037, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(1058, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(1045, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(1077, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(1099, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(902, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(1051, this);
        com.tencent.mm.kernel.g.aAg().hqi.a(1163, this);
        AppMethodBeat.o(113219);
    }

    private void cve() {
        AppMethodBeat.i(113220);
        com.tencent.mm.kernel.g.aAg().hqi.b(1057, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(1037, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(1058, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(1045, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(1077, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(1099, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(902, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(1051, this);
        com.tencent.mm.kernel.g.aAg().hqi.b(1163, this);
        AppMethodBeat.o(113220);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x028c  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 1630
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.CardDetailUI.initView():void");
    }

    private void cvf() {
        AppMethodBeat.i(113222);
        this.pWG = this.gwE;
        this.pZj = new e.a();
        this.pZj.gwE = this.gwE;
        this.pZj.pWG = this.pWG;
        this.pZj.pQH = this.pQH;
        this.pZj.pZc = this.pZc;
        this.pZj.pZe = this.pZe;
        this.pZj.pZd = this.pZd;
        this.pZj.pYJ = this.pYJ;
        this.pZj.pYK = this.pYK;
        this.pZj.pSh = this.pSh;
        this.pZj.qaa = getIntent().getIntExtra("key_from_appbrand_type", 0);
        AppMethodBeat.o(113222);
    }

    private void cvg() {
        int i2 = 1;
        AppMethodBeat.i(113223);
        if (this.pZm || this.pQV == null) {
            AppMethodBeat.o(113223);
            return;
        }
        this.pZm = true;
        if (this.pSh) {
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[9];
            objArr[0] = "ShareCardDetailUI";
            objArr[1] = Integer.valueOf(this.pQV.csQ().nHh);
            objArr[2] = this.pQV.csV();
            objArr[3] = this.pQV.csU();
            objArr[4] = 0;
            objArr[5] = Integer.valueOf(this.pWG);
            objArr[6] = this.pZc;
            if (!this.pQV.csO()) {
                i2 = 0;
            }
            objArr[7] = Integer.valueOf(i2);
            objArr[8] = "";
            hVar.a(11324, objArr);
            AppMethodBeat.o(113223);
            return;
        }
        h hVar2 = h.INSTANCE;
        Object[] objArr2 = new Object[9];
        objArr2[0] = "CardDetailView";
        objArr2[1] = Integer.valueOf(this.pQV.csQ().nHh);
        objArr2[2] = this.pQV.csV();
        objArr2[3] = this.pQV.csU();
        objArr2[4] = 0;
        objArr2[5] = Integer.valueOf(this.pWG);
        objArr2[6] = this.pZc;
        if (!this.pQV.csO()) {
            i2 = 0;
        }
        objArr2[7] = Integer.valueOf(i2);
        objArr2[8] = "";
        hVar2.a(11324, objArr2);
        AppMethodBeat.o(113223);
    }

    private void cuE() {
        AppMethodBeat.i(113224);
        this.pZj.gwE = this.gwE;
        this.pZj.pWG = this.pWG;
        this.pZj.pQH = this.pQH;
        this.pZb.a(this.pQV, this.pZj, this.pRc);
        this.pZb.cuE();
        am.cub().pQV = this.pQV;
        AppMethodBeat.o(113224);
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x022d  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r11, int r12, java.lang.String r13, com.tencent.mm.ak.q r14) {
        /*
        // Method dump skipped, instructions count: 2148
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.ui.CardDetailUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private void c(int i2, String str, int i3, String str2) {
        AppMethodBeat.i(113226);
        Log.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + i2 + " errMsg = " + str + " ret_code:" + i3 + " ret_msg:" + str2);
        if (i3 == 10000) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.and);
            }
            this.pQV.csR().status = 4;
            cuE();
        } else if (i3 == 10001) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.anh);
            }
            this.pQV.csR().status = 5;
            cuE();
        } else if (i3 == 10002) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.aro);
            }
        } else if (TextUtils.isEmpty(str2)) {
            str2 = getString(R.string.anb);
        }
        com.tencent.mm.plugin.card.d.d.c(this, str2);
        AppMethodBeat.o(113226);
    }

    private void ku(boolean z) {
        AppMethodBeat.i(113227);
        if (z) {
            this.gxX = q.a(this, getString(R.string.ekc), true, 0, null);
            AppMethodBeat.o(113227);
            return;
        }
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
            this.gxX = null;
        }
        AppMethodBeat.o(113227);
    }

    private void kw(boolean z) {
        AppMethodBeat.i(113228);
        if (z) {
            l.fB(this.pZb.pZP, this.pZb.pZO);
        }
        AppMethodBeat.o(113228);
    }

    private void cvh() {
        AppMethodBeat.i(113229);
        eck eck = new eck();
        eck.NcB = this.ixM;
        eck.pTp = this.pZi;
        Log.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", this.ixM);
        com.tencent.mm.kernel.g.aAg().hqi.a(new aa(this.pQH, this.gwE, this.pZc, this.pZe, this.pYJ, this.pYK, this.pYI, this.pYL, eck), 0);
        AppMethodBeat.o(113229);
    }

    private void cvi() {
        String str;
        AppMethodBeat.i(113230);
        if (!TextUtils.isEmpty(this.pQV.csV())) {
            str = this.pQV.csV();
        } else if (!TextUtils.isEmpty(this.pQH)) {
            str = this.pQH;
        } else {
            Log.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
            AppMethodBeat.o(113230);
            return;
        }
        if (this.pQV == null || this.pQV.csQ().LeF != 1) {
            if (this.pQV == null || this.pQV.csQ().LeF <= 1) {
                if (this.pQV != null) {
                    this.pQV.a((us) null);
                    cuE();
                    if (this.pQV.csw()) {
                        ShareCardInfo ajA = am.ctY().ajA(this.pQH);
                        if (ajA != null) {
                            ajA.a((us) null);
                            am.ctY().update(ajA, this.pQH);
                        }
                        AppMethodBeat.o(113230);
                        return;
                    }
                    CardInfo ajk = am.ctQ().ajk(this.pQH);
                    if (ajk != null) {
                        ajk.a((us) null);
                        am.ctQ().update(ajk, this.pQH);
                    }
                }
            } else if (this.gmu != -85.0f && this.gmv != -1000.0f) {
                this.pZn = false;
                com.tencent.mm.kernel.g.aAg().hqi.a(new v(str, this.gmv, this.gmu, this.pQV.csU()), 0);
                AppMethodBeat.o(113230);
                return;
            } else if (!this.pZn) {
                this.pZn = true;
                if (this.pXP) {
                    csn();
                    AppMethodBeat.o(113230);
                    return;
                }
            }
            AppMethodBeat.o(113230);
            return;
        }
        float f2 = this.gmu;
        float f3 = this.gmv;
        if (f2 == -85.0f || f3 == -1000.0f) {
            f2 = am.ctW().gmu;
            f3 = am.ctW().gmv;
        }
        com.tencent.mm.kernel.g.aAg().hqi.a(new v(str, f3, f2, this.pQV.csU()), 0);
        AppMethodBeat.o(113230);
    }

    private void cvj() {
        AppMethodBeat.i(113231);
        com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.card.sharecard.model.c(this.pQH), 0);
        AppMethodBeat.o(113231);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(113232);
        if (i2 == 4) {
            Log.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
            B(false, -1);
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(113232);
        return onKeyDown;
    }

    private void B(boolean z, int i2) {
        AppMethodBeat.i(113233);
        if (i2 == 1) {
            Intent intent = new Intent();
            intent.putExtra("key_code", this.pZo);
            intent.putExtra("key_card_id", this.pQH);
            intent.putExtra("key_finish_action", i2);
            setResult(-1, intent);
            if (z) {
                finish();
            }
            AppMethodBeat.o(113233);
        } else if ((this.pWG == 7 || this.pWG == 8 || this.pWG == 16 || this.pWG == 26) && this.gwE == 3) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_code", this.pZo);
            if (i2 > 0) {
                intent2.putExtra("key_card_id", this.pQH);
                intent2.putExtra("key_finish_action", i2);
            }
            setResult(-1, intent2);
            if (z) {
                finish();
            }
            AppMethodBeat.o(113233);
        } else {
            if ((this.pWG == 7 && this.gwE == 7) || ((this.pWG == 16 && this.gwE == 16) || ((this.pWG == 8 && this.gwE == 8) || (this.pWG == 26 && this.gwE == 26)))) {
                setResult(0);
                if (z) {
                    finish();
                    AppMethodBeat.o(113233);
                    return;
                }
            } else if (z) {
                finish();
            }
            AppMethodBeat.o(113233);
        }
    }

    private void Er(int i2) {
        AppMethodBeat.i(113234);
        if (this.pWG == 7 || this.pWG == 16) {
            LinkedList linkedList = new LinkedList();
            com.tencent.mm.plugin.card.model.e eVar = new com.tencent.mm.plugin.card.model.e();
            eVar.pRX = this.pQV.csV();
            eVar.eaP = this.pZe;
            eVar.code = this.pZo;
            linkedList.add(eVar);
            com.tencent.mm.g.a.b bVar = new com.tencent.mm.g.a.b();
            bVar.dBM.resultCode = i2;
            if (i2 == -1) {
                bVar.dBM.dBN = com.tencent.mm.plugin.card.d.h.a(linkedList, true, this.pWG);
            } else {
                bVar.dBM.dBN = com.tencent.mm.plugin.card.d.h.a(linkedList, false, this.pWG);
            }
            EventCenter.instance.publish(bVar);
            AppMethodBeat.o(113234);
            return;
        }
        Log.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
        AppMethodBeat.o(113234);
    }

    private void csn() {
        AppMethodBeat.i(113235);
        if (this.iOv == null) {
            this.iOv = com.tencent.mm.modelgeo.d.bca();
        }
        this.iOv.a(this.gmA, true);
        AppMethodBeat.o(113235);
    }

    private void csp() {
        AppMethodBeat.i(113236);
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        AppMethodBeat.o(113236);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(113238);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(113238);
            return;
        }
        Log.i("MicroMsg.CardDetailUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 69:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.b96), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.card.ui.CardDetailUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(113211);
                            CardDetailUI cardDetailUI = CardDetailUI.this;
                            a bl = new a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(cardDetailUI, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardDetailUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            cardDetailUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(cardDetailUI, "com/tencent/mm/plugin/card/ui/CardDetailUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(113211);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    Log.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.pXP);
                    if (!this.pXP) {
                        this.pXP = true;
                        cuN();
                    }
                    AppMethodBeat.o(113238);
                    return;
                }
        }
        AppMethodBeat.o(113238);
    }

    private synchronized void ajb(String str) {
        AppMethodBeat.i(113239);
        if (this.pWT) {
            Log.e("MicroMsg.CardDetailUI", "has start CardConsumeSuccessUI!");
            AppMethodBeat.o(113239);
        } else {
            Log.i("MicroMsg.CardDetailUI", "startConsumedSuccUI() ");
            this.pWT = true;
            Intent intent = new Intent(this, CardConsumeSuccessUI.class);
            intent.putExtra("KEY_CARD_ID", this.pQV.csU());
            intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
            intent.putExtra("KEY_CARD_COLOR", this.pQV.csQ().ixw);
            intent.putExtra("key_stastic_scene", this.gwE);
            intent.putExtra("key_from_scene", 0);
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardDetailUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUI", "startConsumedSuccUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(113239);
        }
    }

    @Override // com.tencent.mm.plugin.card.b.d.a
    public final void d(com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(113240);
        if (bVar == null) {
            Log.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
            AppMethodBeat.o(113240);
        } else if (this.pQV == null || !this.pQV.csU().equals(bVar.csU())) {
            Log.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
            AppMethodBeat.o(113240);
        } else if (!this.pZb.cvO()) {
            Log.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
            AppMethodBeat.o(113240);
        } else {
            Log.i("MicroMsg.CardDetailUI", "onDataChange");
            this.pQV = bVar;
            this.pQH = this.pQV.csU();
            if (this.pQV.csK() && am.cud().isEmpty()) {
                am.cud().aja(this.pQV.csU());
            }
            cuE();
            AppMethodBeat.o(113240);
        }
    }

    @Override // com.tencent.mm.plugin.card.b.d.a
    public final void ctp() {
        AppMethodBeat.i(113241);
        Log.i("MicroMsg.CardDetailUI", "onVibrate");
        this.paT.vibrate(300);
        AppMethodBeat.o(113241);
    }

    @Override // com.tencent.mm.plugin.card.b.d.a
    public final void ctq() {
        AppMethodBeat.i(113242);
        Log.i("MicroMsg.CardDetailUI", "onFinishUI");
        AppMethodBeat.o(113242);
    }

    @Override // com.tencent.mm.plugin.card.b.d.a
    public final void ajc(final String str) {
        AppMethodBeat.i(113243);
        if (!this.pZb.cvO()) {
            Log.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
            AppMethodBeat.o(113243);
            return;
        }
        Log.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.ui.CardDetailUI.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(113212);
                CardDetailUI.c(CardDetailUI.this, str);
                AppMethodBeat.o(113212);
            }
        });
        AppMethodBeat.o(113243);
    }

    @Override // com.tencent.mm.plugin.card.b.j.a
    public final void b(String str, j.b bVar) {
        AppMethodBeat.i(113244);
        if (TextUtils.isEmpty(str) || str.equals(this.pQH)) {
            ku(false);
            Log.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
            Log.i("MicroMsg.CardDetailUI", "markSucc:" + bVar.pRL + " markCardId: " + bVar.pRM);
            this.pZg = false;
            if (bVar.pRL != 1) {
                this.pZf = false;
                com.tencent.mm.plugin.card.d.d.c(this, getString(R.string.ar6));
            } else if (TextUtils.isEmpty(bVar.pRM) || this.pQV.csU().equals(bVar.pRM)) {
                Log.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
                this.pZf = true;
                a(bVar);
                AppMethodBeat.o(113244);
                return;
            } else {
                Log.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
                if (this.pQV.csw()) {
                    ShareCardInfo ajA = am.ctY().ajA(bVar.pRM);
                    if (ajA != null) {
                        this.pQV = ajA;
                        this.pQH = bVar.pRM;
                        cuE();
                        am.cub().b(this.pQV);
                        Log.i("MicroMsg.CardDetailUI", "update the mCardInfo");
                        this.pZf = true;
                        a(bVar);
                        AppMethodBeat.o(113244);
                        return;
                    }
                    Log.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
                    com.tencent.mm.plugin.card.d.d.c(this, getString(R.string.ar5));
                    this.pZf = false;
                    AppMethodBeat.o(113244);
                    return;
                }
            }
            AppMethodBeat.o(113244);
            return;
        }
        Log.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.o(113244);
    }

    @Override // com.tencent.mm.plugin.card.b.j.a
    public final void fq(String str, String str2) {
        AppMethodBeat.i(113245);
        if (TextUtils.isEmpty(str) || str.equals(this.pQH)) {
            Log.i("MicroMsg.CardDetailUI", "onMarkFail()");
            this.pZf = false;
            this.pZg = false;
            ku(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.ar5);
            }
            com.tencent.mm.plugin.card.d.d.c(this, str2);
            AppMethodBeat.o(113245);
            return;
        }
        Log.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
        AppMethodBeat.o(113245);
    }

    @Override // com.tencent.mm.plugin.card.b.j.a
    public final void ajf(String str) {
        AppMethodBeat.i(113246);
        if (TextUtils.isEmpty(str) || str.equals(this.pQH)) {
            this.pZf = false;
            AppMethodBeat.o(113246);
            return;
        }
        Log.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.o(113246);
    }

    private void a(j.b bVar) {
        AppMethodBeat.i(113247);
        if (this.pZb.dLD) {
            Log.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
            AppMethodBeat.o(113247);
            return;
        }
        Log.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
        this.pZb.a(this.pZh, bVar, true);
        AppMethodBeat.o(113247);
    }

    @Override // com.tencent.mm.plugin.card.b.c.a
    public final void ctk() {
        AppMethodBeat.i(113248);
        Log.i("MicroMsg.CardDetailUI", "code change");
        if (this.pZb.pZz instanceof com.tencent.mm.plugin.card.ui.view.q) {
            ((com.tencent.mm.plugin.card.ui.view.q) this.pZb.pZz).qdP = am.cud().getCode();
            this.pZb.cuE();
        }
        AppMethodBeat.o(113248);
    }

    @Override // com.tencent.mm.plugin.card.b.c.a
    public final void aiZ(String str) {
        AppMethodBeat.i(113249);
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.card.d.d.a(this, str, true);
        }
        AppMethodBeat.o(113249);
    }

    @Override // com.tencent.mm.plugin.card.b.c.a
    public final void onSuccess() {
        AppMethodBeat.i(113250);
        if (this.pZb.pZz instanceof com.tencent.mm.plugin.card.ui.view.q) {
            ((com.tencent.mm.plugin.card.ui.view.q) this.pZb.pZz).qdP = am.cud().getCode();
            this.pZb.cuE();
        }
        Log.i("MicroMsg.CardDetailUI", "code get success");
        AppMethodBeat.o(113250);
    }

    private void cuN() {
        AppMethodBeat.i(113237);
        this.iOv = com.tencent.mm.modelgeo.d.bca();
        csn();
        AppMethodBeat.o(113237);
    }

    static /* synthetic */ void h(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(113253);
        cardDetailUI.B(true, -1);
        AppMethodBeat.o(113253);
    }

    static /* synthetic */ void i(CardDetailUI cardDetailUI) {
        int i2;
        AppMethodBeat.i(113254);
        cardDetailUI.ku(true);
        dxg dxg = new dxg();
        if (cardDetailUI.gwE == 3) {
            dxg.eaO = cardDetailUI.pQH;
            i2 = 1;
        } else {
            dxg.pRX = cardDetailUI.pQH;
            i2 = 0;
        }
        dxg.eaP = cardDetailUI.pZe;
        dxg.KDg = cardDetailUI.pYJ;
        dxg.KDf = cardDetailUI.pYK;
        dxg.KDh = cardDetailUI.pYI;
        LinkedList linkedList = new LinkedList();
        linkedList.add(dxg);
        dxy a2 = l.a(cardDetailUI.pZb.pXh, cardDetailUI.pZb.pXk, cardDetailUI.pZb.pXl);
        eck eck = new eck();
        eck.NcB = cardDetailUI.ixM;
        eck.pTp = cardDetailUI.pZi;
        Log.i("MicroMsg.CardDetailUI", "ShareCardItem upload templateId:%s", cardDetailUI.ixM);
        com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.card.sharecard.model.g(i2, linkedList, cardDetailUI.pQV.csQ().KZR, cardDetailUI.pYL, a2, cardDetailUI.gwE, eck), 0);
        AppMethodBeat.o(113254);
    }

    static /* synthetic */ void a(CardDetailUI cardDetailUI, String str) {
        AppMethodBeat.i(113255);
        cardDetailUI.ku(true);
        com.tencent.mm.kernel.g.aAg().hqi.a(new af(cardDetailUI.pQV.csU(), str, 18), 0);
        AppMethodBeat.o(113255);
    }

    static /* synthetic */ void j(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(113256);
        LinkedList linkedList = new LinkedList();
        linkedList.add(cardDetailUI.pQH);
        cardDetailUI.ku(true);
        com.tencent.mm.kernel.g.aAg().hqi.a(new r(linkedList), 0);
        AppMethodBeat.o(113256);
    }

    static /* synthetic */ void k(CardDetailUI cardDetailUI) {
        String str;
        AppMethodBeat.i(113257);
        cardDetailUI.ku(true);
        if (cardDetailUI.gwE == 6 || TextUtils.isEmpty(cardDetailUI.pQV.csV())) {
            str = cardDetailUI.pQH;
        } else {
            str = cardDetailUI.pQV.csV();
        }
        int cvN = cardDetailUI.pZb.cvN();
        eck eck = new eck();
        eck.NcB = cardDetailUI.ixM;
        eck.pTp = cardDetailUI.pZi;
        Log.i("MicroMsg.CardDetailUI", "AcceptItemInfo templateId:%s", cardDetailUI.ixM);
        com.tencent.mm.kernel.g.aAg().hqi.a(new o(str, cardDetailUI.gwE, cardDetailUI.pZc, cardDetailUI.pZe, cardDetailUI.pYJ, cardDetailUI.pYK, cardDetailUI.pYI, cvN, eck), 0);
        AppMethodBeat.o(113257);
    }

    static /* synthetic */ void l(CardDetailUI cardDetailUI) {
        AppMethodBeat.i(113258);
        com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.card.sharecard.model.a(cardDetailUI.pQH), 0);
        AppMethodBeat.o(113258);
    }
}
