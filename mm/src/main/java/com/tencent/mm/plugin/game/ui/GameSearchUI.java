package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.r;
import com.tencent.mm.plugin.game.ui.s;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bgk;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class GameSearchUI extends MMActivity implements i, s.b {
    private static final Pattern xWu = Pattern.compile("\\s+");
    private int fromScene;
    private View gAy;
    private s gzP;
    private ProgressBar progressBar;
    private TextView vtJ;
    private String xWA;
    private String xWB;
    private LinkedList<String> xWC;
    private String xWD;
    private LinkedList<q> xWE = new LinkedList<>();
    private boolean xWF = false;
    private AdapterView.OnItemClickListener xWG = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameSearchUI.AnonymousClass5 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            r.c cVar;
            AppMethodBeat.i(42390);
            b bVar = new b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            r rVar = GameSearchUI.this.xWy;
            if (i2 < 0 || i2 >= rVar.getCount()) {
                cVar = null;
            } else {
                cVar = ((r.b) rVar.getItem(i2)).xWl;
            }
            if (cVar == null) {
                a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(42390);
                return;
            }
            if (cVar.actionType == 1 && !Util.isNullOrNil(cVar.appId)) {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", cVar.appId);
                bundle.putInt("game_report_from_scene", cVar.dYu);
                int b2 = c.b(GameSearchUI.this, cVar.appId, null, bundle);
                HashMap hashMap = new HashMap();
                hashMap.put("function_type", "search");
                hashMap.put("funtion_value", cVar.xWm);
                hashMap.put("keyword", GameSearchUI.this.xWA);
                f.a(GameSearchUI.this, 14, cVar.dYu, cVar.position, b2, cVar.appId, GameSearchUI.this.fromScene, com.tencent.mm.plugin.game.d.a.u(hashMap));
            } else if (cVar.actionType == 2 && !Util.isNullOrNil(cVar.h5Url)) {
                int D = c.D(GameSearchUI.this, cVar.h5Url, "game_center_detail");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("function_type", "search");
                hashMap2.put("funtion_value", cVar.xWm);
                hashMap2.put("keyword", GameSearchUI.this.xWA);
                f.a(GameSearchUI.this, 14, cVar.dYu, cVar.position, D, 0, cVar.appId, GameSearchUI.this.fromScene, cVar.xWh, String.valueOf(cVar.xWi), null, com.tencent.mm.plugin.game.d.a.u(hashMap2));
            }
            a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(42390);
        }
    };
    private AdapterView.OnItemClickListener xWH = new AdapterView.OnItemClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameSearchUI.AnonymousClass6 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            AppMethodBeat.i(42391);
            b bVar = new b();
            bVar.bm(adapterView);
            bVar.bm(view);
            bVar.pH(i2);
            bVar.zo(j2);
            a.b("com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
            s.a OB = ((s) adapterView.getAdapter()).OB(i2);
            if (Util.isNullOrNil(OB.text)) {
                a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(42391);
                return;
            }
            if (!Util.isNullOrNil(OB.appId)) {
                switch (OB.actionType) {
                    case 1:
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", OB.appId);
                        bundle.putInt("game_report_from_scene", 1402);
                        f.a(GameSearchUI.this, 14, 1402, i2, c.b(GameSearchUI.this, OB.appId, null, bundle), OB.appId, GameSearchUI.this.fromScene, null);
                        break;
                    case 2:
                        f.a(GameSearchUI.this, 14, 1402, i2, c.D(GameSearchUI.this.getContext(), OB.xWn, "game_center_detail"), OB.appId, GameSearchUI.this.fromScene, null);
                        break;
                    default:
                        Log.e("MicroMsg.GameSearchUI", "unknowed actionType : " + OB.actionType);
                        break;
                }
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(OB.text);
                GameSearchUI.b(GameSearchUI.this, linkedList);
                GameSearchUI.h(GameSearchUI.this);
            }
            a.a(this, "com/tencent/mm/plugin/game/ui/GameSearchUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(42391);
        }
    };
    private ViewGroup xWv;
    private ListView xWw;
    private ListView xWx;
    private r xWy;
    private s xWz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameSearchUI() {
        AppMethodBeat.i(42392);
        AppMethodBeat.o(42392);
    }

    static /* synthetic */ void a(GameSearchUI gameSearchUI, LinkedList linkedList) {
        AppMethodBeat.i(42407);
        gameSearchUI.a(linkedList, 0, false);
        AppMethodBeat.o(42407);
    }

    static /* synthetic */ void h(GameSearchUI gameSearchUI) {
        AppMethodBeat.i(42409);
        gameSearchUI.xI(1);
        AppMethodBeat.o(42409);
    }

    static {
        AppMethodBeat.i(42410);
        AppMethodBeat.o(42410);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42393);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (!g.aAc()) {
            Log.e("MicroMsg.GameSearchUI", "account not ready");
            finish();
            AppMethodBeat.o(42393);
            return;
        }
        g.azz().a(1328, this);
        g.azz().a(1329, this);
        this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
        initView();
        f.a(this, 14, 1401, 0, 2, this.fromScene, null);
        Log.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(42393);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42394);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameSearchUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42386);
                GameSearchUI.this.onBackPressed();
                AppMethodBeat.o(42386);
                return true;
            }
        });
        this.gzP = new com.tencent.mm.ui.tools.s();
        this.gzP.CK(true);
        this.gzP.Qwi = this;
        this.xWv = (ViewGroup) findViewById(R.id.jai);
        this.progressBar = (ProgressBar) findViewById(R.id.heu);
        this.vtJ = (TextView) findViewById(R.id.fzz);
        this.xWw = (ListView) findViewById(R.id.hex);
        this.xWy = new r(this);
        this.xWw.setAdapter((ListAdapter) this.xWy);
        this.xWw.setOnItemClickListener(this.xWG);
        this.xWw.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.game.ui.GameSearchUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(42387);
                GameSearchUI.this.xWw.clearFocus();
                GameSearchUI.this.hideVKB();
                AppMethodBeat.o(42387);
                return false;
            }
        });
        this.xWw.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.plugin.game.ui.GameSearchUI.AnonymousClass3 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
                AppMethodBeat.i(42388);
                if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && GameSearchUI.this.xWy.xVQ) {
                    if (GameSearchUI.this.gAy != null) {
                        GameSearchUI.this.gAy.setVisibility(0);
                    }
                    GameSearchUI.a(GameSearchUI.this, GameSearchUI.this.xWC);
                }
                AppMethodBeat.o(42388);
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        this.gAy = getLayoutInflater().inflate(R.layout.arb, (ViewGroup) this.xWw, false);
        this.gAy.setVisibility(8);
        this.xWw.addFooterView(this.gAy);
        this.xWx = (ListView) findViewById(R.id.hev);
        this.xWz = new s(this);
        this.xWx.setAdapter((ListAdapter) this.xWz);
        this.xWx.setOnItemClickListener(this.xWH);
        this.xWx.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.game.ui.GameSearchUI.AnonymousClass4 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(42389);
                GameSearchUI.this.xWx.clearFocus();
                GameSearchUI.this.hideVKB();
                AppMethodBeat.o(42389);
                return false;
            }
        });
        AppMethodBeat.o(42394);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(42395);
        this.gzP.a((FragmentActivity) this, menu);
        this.gzP.setHint(e.dVf());
        AppMethodBeat.o(42395);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(42396);
        this.gzP.a((Activity) this, menu);
        AppMethodBeat.o(42396);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.asg;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void xI(int i2) {
        AppMethodBeat.i(42397);
        switch (i2) {
            case 0:
                this.xWv.setVisibility(8);
                this.vtJ.setVisibility(8);
                this.xWw.setVisibility(8);
                this.xWx.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.o(42397);
                return;
            case 1:
                hideVKB();
                ListView listView = this.xWw;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                a.a(listView, a2.axQ(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                listView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                a.a(listView, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                this.gzP.clearFocus();
                this.xWv.setVisibility(8);
                this.vtJ.setVisibility(8);
                this.xWw.setVisibility(8);
                this.xWx.setVisibility(8);
                this.progressBar.setVisibility(0);
                AppMethodBeat.o(42397);
                return;
            case 2:
                this.xWv.setVisibility(8);
                if (this.xWy.getCount() > 0) {
                    this.vtJ.setVisibility(8);
                    this.xWw.setVisibility(0);
                } else {
                    this.vtJ.setVisibility(0);
                    this.xWw.setVisibility(8);
                }
                this.xWx.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.o(42397);
                return;
            case 3:
                this.xWv.setVisibility(0);
                this.vtJ.setVisibility(8);
                this.xWw.setVisibility(8);
                this.xWx.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.o(42397);
                return;
            case 4:
                this.xWv.setVisibility(8);
                this.vtJ.setVisibility(0);
                this.xWw.setVisibility(8);
                this.xWx.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.o(42397);
                return;
            case 5:
                this.xWv.setVisibility(8);
                this.vtJ.setVisibility(8);
                this.xWw.setVisibility(8);
                this.xWx.setVisibility(0);
                this.progressBar.setVisibility(8);
                break;
            case 6:
                ListView listView2 = this.xWw;
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                a.a(listView2, a3.axQ(), "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                listView2.smoothScrollToPosition(((Integer) a3.pG(0)).intValue());
                a.a(listView2, "com/tencent/mm/plugin/game/ui/GameSearchUI", "updateUI", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
                this.xWv.setVisibility(8);
                this.vtJ.setVisibility(8);
                this.xWw.setVisibility(8);
                this.xWx.setVisibility(8);
                this.progressBar.setVisibility(0);
                AppMethodBeat.o(42397);
                return;
        }
        AppMethodBeat.o(42397);
    }

    private void aW(LinkedList<String> linkedList) {
        AppMethodBeat.i(42398);
        a(linkedList, 0, true);
        AppMethodBeat.o(42398);
    }

    private void a(LinkedList<String> linkedList, int i2, boolean z) {
        AppMethodBeat.i(42399);
        while (!this.xWE.isEmpty()) {
            g.aAi();
            g.aAg().hqi.a(this.xWE.pop());
        }
        if (z) {
            this.xWy.reset();
        }
        this.xWC = linkedList;
        ak akVar = new ak(LocaleUtil.getApplicationLanguage(), linkedList, e.dUR(), this.xWy.xGW);
        g.azz().a(akVar, 0);
        this.xWE.add(akVar);
        Iterator<String> it = linkedList.iterator();
        this.xWA = "";
        while (it.hasNext()) {
            this.xWA += " " + it.next();
        }
        this.xWA = this.xWA.trim();
        if (i2 == 1 || i2 == 2) {
            this.xWF = true;
            this.gzP.setSearchContent(this.xWA);
        }
        AppMethodBeat.o(42399);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        LinkedList<bgj> linkedList;
        boolean z;
        String string;
        AppMethodBeat.i(42400);
        if (qVar.isCanceled()) {
            AppMethodBeat.o(42400);
            return;
        }
        if (this.xWE.contains(qVar)) {
            this.xWE.remove(qVar);
        }
        this.gAy.setVisibility(8);
        switch (qVar.getType()) {
            case 1328:
                bgh bgh = (bgh) ((ak) qVar).hhm.iLK.iLR;
                Log.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", bgh.LQa, Integer.valueOf(bgh.LQb));
                if (i2 == 0 && i3 == 0) {
                    bgi bgi = (bgi) ((ak) qVar).hhm.iLL.iLR;
                    if (bgi != null) {
                        linkedList = bgi.LQc;
                    } else {
                        linkedList = null;
                    }
                    if (!Util.isNullOrNil(linkedList)) {
                        this.xWB = this.xWA;
                        if (this.xWy.xGW != 0) {
                            r rVar = this.xWy;
                            String str2 = this.xWB;
                            Iterator<bgj> it = linkedList.iterator();
                            while (it.hasNext()) {
                                bgj next = it.next();
                                if (next.type != 3 || Util.isNullOrNil(next.LQe)) {
                                    rVar.xVQ = false;
                                } else {
                                    rVar.xGW = next.LQi;
                                    rVar.xVQ = next.LQj;
                                    Iterator<bgl> it2 = next.LQe.iterator();
                                    while (it2.hasNext()) {
                                        r.b a2 = r.b.a(it2.next());
                                        a2.dDv = str2;
                                        a2.xWl.appId = a2.appId;
                                        a2.xWl.xWh = a2.xWh;
                                        a2.xWl.xWi = a2.xWi;
                                        a2.xWl.xWm = "2";
                                        r.c cVar = a2.xWl;
                                        int i4 = rVar.xVN;
                                        rVar.xVN = i4 + 1;
                                        cVar.position = i4 + 301;
                                        a2.xWl.dYu = rVar.dDz ? 1403 : 1405;
                                        rVar.gUV.add(a2);
                                    }
                                }
                            }
                        } else {
                            r rVar2 = this.xWy;
                            String str3 = this.xWB;
                            if (rVar2.gUV == null) {
                                rVar2.gUV = new ArrayList<>();
                            }
                            rVar2.xTs = 0;
                            rVar2.xVL = 0;
                            rVar2.xVM = 0;
                            rVar2.xVN = 0;
                            rVar2.xVO = 0;
                            rVar2.dDz = false;
                            rVar2.xVK = false;
                            rVar2.xVQ = false;
                            rVar2.xGW = 0;
                            rVar2.gUV.clear();
                            rVar2.xVR = false;
                            Iterator<bgj> it3 = linkedList.iterator();
                            while (it3.hasNext()) {
                                bgj next2 = it3.next();
                                boolean z2 = next2.LQd == null || next2.LQd.size() == 0;
                                boolean z3 = next2.LQe == null || next2.LQe.size() == 0;
                                boolean z4 = next2.LQh == null || next2.LQh.size() == 0;
                                if (!z2 || !z3 || !z4) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    rVar2.gUV.add(r.b.bA(0, next2.Title));
                                    if (!rVar2.xVR) {
                                        rVar2.gUV.get(rVar2.gUV.size() - 1).xWj = true;
                                        rVar2.xVR = true;
                                    }
                                    if (next2.type == 4 && next2.LQh != null) {
                                        Iterator<bgk> it4 = next2.LQh.iterator();
                                        while (it4.hasNext()) {
                                            bgk next3 = it4.next();
                                            r.b bVar = new r.b();
                                            bVar.type = 3;
                                            bVar.appId = next3.LQk.jfi;
                                            bVar.name = next3.LQk.Name;
                                            bVar.remark = next3.LQk.LoI;
                                            bVar.iconUrl = next3.LQk.IconUrl;
                                            bVar.xWd = next3.LQk.xIK;
                                            bVar.xWe = next3.LQk.LPR;
                                            bVar.actionType = next3.LQk.KWb;
                                            bVar.xWf = next3.LQk.LPS;
                                            bVar.xWg = next3.LQl;
                                            bVar.xWl = new r.c(next3.LQk.KWb, 4, next3.LQk.jfi, next3.LQk.LPS);
                                            bVar.dDv = str3;
                                            bVar.xWl.xWm = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                            r.c cVar2 = bVar.xWl;
                                            int i5 = rVar2.xVM;
                                            rVar2.xVM = i5 + 1;
                                            cVar2.position = i5 + 601;
                                            rVar2.gUV.add(bVar);
                                        }
                                    }
                                    if ((next2.type == 1 || next2.type == 2) && next2.LQd != null) {
                                        Iterator<bgd> it5 = next2.LQd.iterator();
                                        while (it5.hasNext()) {
                                            bgd next4 = it5.next();
                                            r.b bVar2 = new r.b();
                                            bVar2.type = 1;
                                            bVar2.appId = next4.jfi;
                                            bVar2.name = next4.Name;
                                            bVar2.remark = next4.LoI;
                                            bVar2.iconUrl = next4.IconUrl;
                                            bVar2.xWd = next4.xIK;
                                            bVar2.xWe = next4.LPR;
                                            bVar2.actionType = next4.KWb;
                                            bVar2.xWf = next4.LPS;
                                            bVar2.xWl = new r.c(next4.KWb, 1, next4.jfi, next4.LPS);
                                            bVar2.dDv = str3;
                                            if (next2.type == 1) {
                                                rVar2.dDz = true;
                                                r.c cVar3 = bVar2.xWl;
                                                int i6 = rVar2.xTs;
                                                rVar2.xTs = i6 + 1;
                                                cVar3.position = i6 + 1;
                                            } else if (next2.type == 2) {
                                                rVar2.xVK = true;
                                                r.c cVar4 = bVar2.xWl;
                                                int i7 = rVar2.xVL;
                                                rVar2.xVL = i7 + 1;
                                                cVar4.position = i7 + 1;
                                            }
                                            bVar2.xWl.xWm = "1";
                                            rVar2.gUV.add(bVar2);
                                        }
                                    } else if (next2.type == 3 && next2.LQe != null) {
                                        rVar2.xGW = next2.LQi;
                                        rVar2.xVQ = next2.LQj;
                                        Iterator<bgl> it6 = next2.LQe.iterator();
                                        while (it6.hasNext()) {
                                            r.b a3 = r.b.a(it6.next());
                                            a3.dDv = str3;
                                            a3.xWl.appId = a3.appId;
                                            a3.xWl.xWh = a3.xWh;
                                            a3.xWl.xWi = a3.xWi;
                                            a3.xWl.xWm = "2";
                                            r.c cVar5 = a3.xWl;
                                            int i8 = rVar2.xVN;
                                            rVar2.xVN = i8 + 1;
                                            cVar5.position = i8 + 301;
                                            rVar2.gUV.add(a3);
                                        }
                                    }
                                    if (!Util.isNullOrNil(next2.LQf) && !Util.isNullOrNil(next2.LQg) && next2.type == 1) {
                                        String str4 = next2.LQf;
                                        String str5 = next2.LQg;
                                        r.b bVar3 = new r.b();
                                        bVar3.type = 5;
                                        bVar3.name = str4;
                                        bVar3.xWl = new r.c(str5);
                                        bVar3.xWl.appId = "wx62d9035fd4fd2059";
                                        bVar3.xWl.xWm = "1";
                                        bVar3.xWl.position = 300;
                                        rVar2.gUV.add(bVar3);
                                    }
                                } else if (next2.type == 1) {
                                    if (!Util.isNullOrNil(str3)) {
                                        string = rVar2.context.getString(R.string.dsc, str3);
                                    } else {
                                        string = rVar2.context.getString(R.string.dsb);
                                    }
                                    rVar2.gUV.add(r.b.bA(6, string));
                                    rVar2.xVR = true;
                                }
                            }
                            Iterator<r.b> it7 = rVar2.gUV.iterator();
                            while (it7.hasNext()) {
                                r.b next5 = it7.next();
                                if (rVar2.dDz) {
                                    next5.xWl.dYu = 1403;
                                } else if (rVar2.xVK) {
                                    next5.xWl.dYu = 1404;
                                } else {
                                    next5.xWl.dYu = 1405;
                                }
                            }
                            rVar2.notifyDataSetChanged();
                        }
                    }
                }
                xI(2);
                AppMethodBeat.o(42400);
                return;
            case 1329:
                if (i2 == 0 && i3 == 0) {
                    this.xWz.b(((al) qVar).dDv, ((bgf) ((al) qVar).hhm.iLL.iLR).Title, ((bgf) ((al) qVar).hhm.iLL.iLR).LPY);
                    xI(5);
                    break;
                } else {
                    AppMethodBeat.o(42400);
                    return;
                }
        }
        AppMethodBeat.o(42400);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(42401);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            onBackPressed();
            AppMethodBeat.o(42401);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(42401);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(42402);
        super.onBackPressed();
        AppMethodBeat.o(42402);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42403);
        Log.i("MicroMsg.GameSearchUI", "onDestroy");
        super.onDestroy();
        g.azz().b(1328, this);
        g.azz().b(1329, this);
        AppMethodBeat.o(42403);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        AppMethodBeat.i(42404);
        hideVKB();
        onBackPressed();
        AppMethodBeat.o(42404);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void SO(String str) {
        String[] split;
        AppMethodBeat.i(42405);
        if (this.xWF) {
            this.xWF = false;
            AppMethodBeat.o(42405);
        } else if (this.xWD == null || !this.xWD.equals(Util.nullAsNil(str))) {
            this.xWD = str;
            if (Util.isNullOrNil(str)) {
                while (!this.xWE.isEmpty()) {
                    g.aAi();
                    g.aAg().hqi.a(this.xWE.pop());
                }
                al alVar = new al(LocaleUtil.getApplicationLanguage(), str, e.dUR());
                g.azz().a(alVar, 0);
                this.xWE.add(alVar);
                AppMethodBeat.o(42405);
                return;
            }
            LinkedList<String> linkedList = new LinkedList<>();
            for (String str2 : xWu.split(str.replace('*', ' '))) {
                linkedList.add(str2);
            }
            aW(linkedList);
            xI(6);
            AppMethodBeat.o(42405);
        } else {
            Log.d("MicroMsg.GameSearchUI", "repeat searchChange");
            AppMethodBeat.o(42405);
        }
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        String[] split;
        AppMethodBeat.i(42406);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42406);
        } else {
            LinkedList<String> linkedList = new LinkedList<>();
            for (String str2 : xWu.split(str.replace('*', ' '))) {
                linkedList.add(str2);
            }
            aW(linkedList);
            xI(1);
            AppMethodBeat.o(42406);
        }
        return true;
    }

    static /* synthetic */ void b(GameSearchUI gameSearchUI, LinkedList linkedList) {
        AppMethodBeat.i(42408);
        gameSearchUI.a(linkedList, 2, true);
        AppMethodBeat.o(42408);
    }
}
