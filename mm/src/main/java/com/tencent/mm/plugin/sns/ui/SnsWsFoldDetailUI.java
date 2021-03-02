package com.tencent.mm.plugin.sns.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.is;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.n;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.a.d;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnsWsFoldDetailUI extends MMActivity implements i, x {
    private long DIf = 0;
    private long DIg = 0;
    protected k EBv = new k(0);
    private i EKZ = null;
    private d EQD = null;
    private long EQE = 0;
    private List<Long> EQF = new ArrayList();
    private Map<String, Boolean> EQG;
    private Map<String, String> EQH;
    private List<String> EQI;
    private String gna = "";
    private ListView krb = null;
    private ProgressBar mEz = null;
    private bv oQw = null;
    private String username = "";

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsWsFoldDetailUI() {
        AppMethodBeat.i(203821);
        AppMethodBeat.o(203821);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.by7;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(203822);
        h.q(this);
        super.onCreate(bundle);
        b.e(this, true);
        this.EQE = getIntent().getLongExtra("key_ws_group_id", 0);
        this.DIf = getIntent().getLongExtra("key_ws_detail_max_id", 0);
        this.DIg = getIntent().getLongExtra("key_ws_detail_min_id", 0);
        this.username = getIntent().getStringExtra("key_ws_detail_username");
        Log.i("MicroMsg.SnsWsFoldDetailUI", "groupId:%s", Long.valueOf(this.EQE));
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("key_ws_str_sns_id_list");
        if (!Util.isNullOrNil(stringArrayListExtra)) {
            for (String str : stringArrayListExtra) {
                long aOw = r.aOw(str);
                this.EQF.add(Long.valueOf(aOw));
                Log.i("MicroMsg.SnsWsFoldDetailUI", "snsId:%s-%s", str, Long.valueOf(aOw));
            }
        }
        g.aAi();
        this.oQw = ((l) g.af(l.class)).aSN();
        this.gna = aj.fau();
        this.EQG = new HashMap();
        this.EQH = new HashMap();
        this.EQI = new ArrayList();
        setMMTitle(R.string.hcd);
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(203816);
                SnsWsFoldDetailUI.this.hideVKB();
                SnsWsFoldDetailUI.this.finish();
                AppMethodBeat.o(203816);
                return false;
            }
        }, R.raw.actionbar_icon_dark_back);
        this.EKZ = new bw(this);
        this.EKZ.DQt = (FrameLayout) findViewById(R.id.i1y);
        this.EKZ.EoL = new bb(this);
        this.EKZ.b(this.EBv);
        this.krb = (ListView) findViewById(R.id.i1w);
        this.mEz = (ProgressBar) findViewById(R.id.i1x);
        ListView listView = this.krb;
        c cVar = this.EKZ.EoV;
        i iVar = this.EKZ;
        aj.fau();
        this.EQD = new d(this, listView, cVar, iVar);
        this.krb.setAdapter((ListAdapter) this.EQD);
        this.EKZ.EoS = new com.tencent.mm.plugin.sns.h.b(this, this.EQD.ESp.DQs, this.EKZ.DQt);
        this.EKZ.EoR = new b(this, this.EQD.ESp.DQs, this.EKZ.DQt, this.EKZ.EoS);
        this.EKZ.EoU = new bu(this, this.EQD.ESp.DQs, this.EKZ.DQt);
        this.EKZ.EoT = new ap(this, this.EQD.ESp.DQs, this.EKZ.DQt);
        this.EKZ.EoQ = new bs(this, this.EQD.ESp, this.EKZ.DQt);
        this.EKZ.DQX = this.EQD.ESp;
        this.EKZ.EoJ = (SnsCommentFooter) findViewById(R.id.b8y);
        this.EKZ.list = this.krb;
        this.EKZ.EoK = new bt(this.krb, this.EKZ.EoJ);
        this.krb.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(203817);
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        SnsWsFoldDetailUI.this.EKZ.ffp();
                        SnsWsFoldDetailUI.this.EKZ.EoK.fjZ();
                        break;
                    case 1:
                        SnsWsFoldDetailUI.this.ffL();
                        break;
                }
                AppMethodBeat.o(203817);
                return false;
            }
        });
        this.mEz.setVisibility(0);
        this.krb.setVisibility(8);
        bqe();
        g.aAg().hqi.a(new n(this.EQF), 0);
        g.aAg().hqi.a(5987, this);
        g.aAg().hqi.a(213, this);
        g.aAg().hqi.a(218, this);
        h.r(this);
        AppMethodBeat.o(203822);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(203823);
        super.onResume();
        this.EQD.ESp.onResume();
        AppMethodBeat.o(203823);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(203824);
        super.onPause();
        this.EQD.ESp.onPause();
        AppMethodBeat.o(203824);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(203825);
        super.onDestroy();
        if (this.EKZ != null) {
            this.EKZ.clean();
        }
        this.oQw = null;
        this.EQG.clear();
        this.EQH.clear();
        this.EQI.clear();
        g.aAg().hqi.b(5987, this);
        g.aAg().hqi.b(213, this);
        g.aAg().hqi.b(218, this);
        if (this.EQD != null) {
            this.EQD.ESp.fiP();
        }
        e eVar = e.DUQ;
        StringBuilder sb = new StringBuilder();
        for (Long l : eVar.DVJ) {
            sb.append(r.Jc(l.longValue())).append("#");
        }
        is isVar = eVar.DVI;
        isVar.ePE = isVar.x("BrowseFeedList", sb.toString(), true);
        eVar.DVI.ePC = (long) eVar.DVJ.size();
        is isVar2 = eVar.DVI;
        isVar2.eiB = isVar2.x("SessionId", com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO().cPR(), true);
        eVar.DVI.ePF = System.currentTimeMillis() - eVar.viC;
        Log.i("MicroMsg.SnsReportHelper", "setBrowseFeedList:%s FeedList:%s", sb, eVar.DVI.ePD);
        eVar.DVI.bfK();
        eVar.DVI = new is();
        eVar.DVJ.clear();
        eVar.viC = 0;
        AppMethodBeat.o(203825);
    }

    private void bqe() {
        AppMethodBeat.i(203826);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(203819);
                if (SnsWsFoldDetailUI.this.username != null) {
                    Cursor aQ = aj.faO().aQ(SnsWsFoldDetailUI.this.username, r.Jc(SnsWsFoldDetailUI.this.DIf), r.Jc(SnsWsFoldDetailUI.this.DIg));
                    ArrayList<SnsInfo> arrayList = new ArrayList();
                    if (aQ == null) {
                        Log.w("MicroMsg.SnsWsFoldDetailUI", "cursor == null");
                        AppMethodBeat.o(203819);
                        return;
                    } else if (!aQ.moveToFirst()) {
                        aQ.close();
                        Log.w("MicroMsg.SnsWsFoldDetailUI", "cursor.moveToFirst == false");
                        AppMethodBeat.o(203819);
                        return;
                    } else {
                        do {
                            try {
                                SnsInfo snsInfo = new SnsInfo();
                                snsInfo.convertFrom(aQ);
                                arrayList.add(snsInfo);
                            } catch (Throwable th) {
                                if (aQ != null) {
                                    aQ.close();
                                }
                                AppMethodBeat.o(203819);
                                throw th;
                            }
                        } while (aQ.moveToNext());
                        int size = arrayList.size();
                        final ArrayList arrayList2 = new ArrayList();
                        int i2 = 0;
                        for (SnsInfo snsInfo2 : arrayList) {
                            arrayList2.add(r.a(snsInfo2, an.C(snsInfo2), SnsWsFoldDetailUI.this, SnsWsFoldDetailUI.this.EQD.ESp, i2 < size, SnsWsFoldDetailUI.this.oQw, SnsWsFoldDetailUI.this.gna, SnsWsFoldDetailUI.this.EQG, SnsWsFoldDetailUI.this.EQH, SnsWsFoldDetailUI.this.EQI));
                            i2++;
                        }
                        Log.i("MicroMsg.SnsWsFoldDetailUI", "loadData finish, snsInfoList.size:%s, structlist.size:%s", Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()));
                        aj.dRd().post(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(203818);
                                SnsWsFoldDetailUI.k(SnsWsFoldDetailUI.this);
                                d dVar = SnsWsFoldDetailUI.this.EQD;
                                List list = arrayList2;
                                dVar.dataList.clear();
                                dVar.dataList.addAll(list);
                                SnsWsFoldDetailUI.this.EQD.notifyDataSetChanged();
                                AppMethodBeat.o(203818);
                            }
                        });
                        if (aQ != null) {
                            aQ.close();
                            AppMethodBeat.o(203819);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(203819);
            }
        });
        AppMethodBeat.o(203826);
    }

    @Override // com.tencent.mm.plugin.sns.ui.x
    public final boolean fv(View view) {
        AppMethodBeat.i(203827);
        boolean d2 = this.EKZ.EoQ.d(view, true, true);
        AppMethodBeat.o(203827);
        return d2;
    }

    @Override // com.tencent.mm.plugin.sns.ui.x
    public final boolean ffL() {
        AppMethodBeat.i(203828);
        boolean ffL = this.EKZ.EoQ.ffL();
        AppMethodBeat.o(203828);
        return ffL;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(203829);
        Log.i("MicroMsg.SnsWsFoldDetailUI", "onSceneEnd errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        bqe();
        AppMethodBeat.o(203829);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onKeyboardStateChanged() {
        AppMethodBeat.i(203830);
        super.onKeyboardStateChanged();
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(203820);
                SnsWsFoldDetailUI.this.ffL();
                AppMethodBeat.o(203820);
            }
        });
        if (keyboardState() == 2) {
            if (!(this.EKZ == null || this.EKZ.EoJ == null || this.EKZ.EoJ.fhW())) {
                Log.i("MicroMsg.SnsWsFoldDetailUI", "onKeyBoardStateChange find");
                AppMethodBeat.o(203830);
                return;
            }
        } else if (keyboardState() == 1 && this.EKZ != null) {
            this.EKZ.ffq();
        }
        AppMethodBeat.o(203830);
    }

    static /* synthetic */ void k(SnsWsFoldDetailUI snsWsFoldDetailUI) {
        AppMethodBeat.i(203831);
        snsWsFoldDetailUI.mEz.setVisibility(8);
        snsWsFoldDetailUI.krb.setVisibility(0);
        AppMethodBeat.o(203831);
    }
}
