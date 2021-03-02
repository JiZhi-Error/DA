package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.d;
import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.GameBannerView;
import com.tencent.mm.plugin.game.ui.GameDropdownView;
import com.tencent.mm.plugin.game.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.HashMap;
import java.util.LinkedList;

public class GameLibraryUI extends MMActivity implements i {
    private View gAy;
    private boolean gWt = true;
    private Dialog rAV;
    private boolean wYE = false;
    private int xGR = 0;
    private int xGW = 0;
    private k xOW = new k();
    private ListView xPd;
    private l xPe;
    private boolean xPf = false;
    private boolean xPg = true;
    private m.a xPj = new m.a() {
        /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.game.ui.m.a
        public final void Os(int i2) {
            AppMethodBeat.i(42221);
            int firstVisiblePosition = GameLibraryUI.this.xPd.getFirstVisiblePosition() - GameLibraryUI.this.xTN;
            int lastVisiblePosition = GameLibraryUI.this.xPd.getLastVisiblePosition() - GameLibraryUI.this.xTN;
            if (i2 >= firstVisiblePosition && i2 <= lastVisiblePosition) {
                GameLibraryUI.this.xPe.aj(GameLibraryUI.this.xPd.getChildAt(i2 - firstVisiblePosition), i2);
            }
            AppMethodBeat.o(42221);
        }
    };
    private AbsListView.OnScrollListener xPk = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass8 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(42227);
            if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (!GameLibraryUI.this.xPg || GameLibraryUI.this.xPf) {
                    AppMethodBeat.o(42227);
                    return;
                } else {
                    GameLibraryUI.this.gAy.setVisibility(0);
                    GameLibraryUI.h(GameLibraryUI.this);
                }
            }
            AppMethodBeat.o(42227);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    };
    private GameBannerView xTB;
    private GameLibraryCategoriesView xTC;
    private View xTD;
    private TextView xTE;
    private View xTF;
    private GameDropdownView xTG;
    private HashMap<Integer, String> xTH;
    private int xTI = 0;
    private View xTJ;
    private Button xTK;
    private boolean xTL = false;
    private int xTM = di.CTRL_INDEX;
    private int xTN = 0;
    private View.OnClickListener xTO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(42224);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c.a(view, GameLibraryUI.this);
            f.a(GameLibraryUI.this, 11, 1110, 999, 7, GameLibraryUI.this.xGR, null);
            a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42224);
        }
    };
    private View.OnClickListener xTP = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass6 */

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(42225);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof String) {
                c.a(view, GameLibraryUI.this);
                i2 = 7;
            } else {
                Intent intent = new Intent(GameLibraryUI.this, GameCategoryUI.class);
                intent.putExtra("extra_type", 2);
                intent.putExtra("extra_category_name", GameLibraryUI.this.getString(R.string.dpm));
                intent.putExtra("game_report_from_scene", FaceManager.FACE_ACQUIRED_LEFT);
                GameLibraryUI gameLibraryUI = GameLibraryUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(gameLibraryUI, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                gameLibraryUI.startActivity((Intent) bl.pG(0));
                a.a(gameLibraryUI, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i2 = 6;
            }
            f.a(GameLibraryUI.this, 11, FaceManager.FACE_ACQUIRED_LEFT, 1, i2, GameLibraryUI.this.xGR, null);
            a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42225);
        }
    };
    private GameDropdownView.a xTQ = new GameDropdownView.a() {
        /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.game.ui.GameDropdownView.a
        public final void Ov(int i2) {
            AppMethodBeat.i(42226);
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(GameLibraryUI.this.xTH.keySet());
            if (i2 > linkedList.size() - 1) {
                AppMethodBeat.o(42226);
                return;
            }
            GameLibraryUI.this.xTI = ((Integer) linkedList.get(i2)).intValue();
            Log.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", Integer.valueOf(GameLibraryUI.this.xTI));
            GameLibraryUI.this.xGW = 0;
            GameLibraryUI.h(GameLibraryUI.this);
            f.a(GameLibraryUI.this, 11, 1111, GameLibraryUI.this.xTI + GameLibraryUI.this.xTM, 2, GameLibraryUI.this.xGR, null);
            AppMethodBeat.o(42226);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameLibraryUI() {
        AppMethodBeat.i(42230);
        AppMethodBeat.o(42230);
    }

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI) {
        AppMethodBeat.i(42242);
        gameLibraryUI.goBack();
        AppMethodBeat.o(42242);
    }

    static /* synthetic */ void h(GameLibraryUI gameLibraryUI) {
        AppMethodBeat.i(42244);
        gameLibraryUI.dWs();
        AppMethodBeat.o(42244);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(42231);
        super.onCreate(bundle);
        if (!g.aAc()) {
            Log.e("MicroMsg.GameLibraryUI", "account not ready");
            finish();
            AppMethodBeat.o(42231);
            return;
        }
        this.xGR = getIntent().getIntExtra("game_report_from_scene", 0);
        g.azz().a(1218, this);
        initView();
        final byte[] azn = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn("pb_library");
        if (azn == null) {
            Log.i("MicroMsg.GameLibraryUI", "No cache found");
            z = false;
        } else {
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(42223);
                    final ae aeVar = new ae(azn);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42222);
                            GameLibraryUI.a(GameLibraryUI.this, aeVar, false);
                            AppMethodBeat.o(42222);
                        }
                    });
                    AppMethodBeat.o(42223);
                }
            });
            z = true;
        }
        if (!z) {
            this.rAV = c.gl(this);
            this.rAV.show();
        }
        dWs();
        f.a(this, 11, 1100, 0, 1, this.xGR, null);
        AppMethodBeat.o(42231);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(42232);
        super.onResume();
        if (!g.aAc()) {
            Log.e("MicroMsg.GameLibraryUI", "account not ready");
            AppMethodBeat.o(42232);
            return;
        }
        this.xPe.refresh();
        if (!this.gWt && this.xTB != null) {
            GameBannerView gameBannerView = this.xTB;
            if (gameBannerView.xOF != null && gameBannerView.xOF.stopped() && gameBannerView.xOE.size() > 1) {
                gameBannerView.xOF.startTimer(5000);
                Log.i("MicroMsg.GameBannerView", "Auto scroll restarted");
            }
        }
        if (this.gWt) {
            this.gWt = false;
        }
        AppMethodBeat.o(42232);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(42233);
        super.onPause();
        if (this.xTB != null) {
            GameBannerView gameBannerView = this.xTB;
            if (gameBannerView.xOF != null) {
                gameBannerView.xOF.stopTimer();
                Log.i("MicroMsg.GameBannerView", "Auto scroll stopped");
            }
        }
        AppMethodBeat.o(42233);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42234);
        Log.i("MicroMsg.GameLibraryUI", "onDestroy");
        super.onDestroy();
        g.azz().b(1218, this);
        this.xPe.clear();
        if (this.xTB != null) {
            this.xTB.xOF.stopTimer();
        }
        AppMethodBeat.o(42234);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(42235);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(42235);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(42235);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ar1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42236);
        setMMTitle(R.string.dpj);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42219);
                GameLibraryUI.a(GameLibraryUI.this);
                AppMethodBeat.o(42219);
                return true;
            }
        });
        if (!Util.isNullOrNil(e.dVf())) {
            addIconOptionMenu(0, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(42220);
                    Intent intent = new Intent(GameLibraryUI.this, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1109);
                    GameLibraryUI gameLibraryUI = GameLibraryUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(gameLibraryUI, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameLibraryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    gameLibraryUI.startActivity((Intent) bl.pG(0));
                    a.a(gameLibraryUI, "com/tencent/mm/plugin/game/ui/GameLibraryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(42220);
                    return true;
                }
            });
        }
        this.xPd = (ListView) findViewById(R.id.dgw);
        this.xPd.setOnItemClickListener(this.xOW);
        this.xOW.setSourceScene(this.xGR);
        this.xPd.setOnScrollListener(this.xPk);
        this.xPe = new l(this);
        this.xPe.setSourceScene(this.xGR);
        this.xPe.a(this.xPj);
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.layout.ar9, (ViewGroup) this.xPd, false);
        this.xTB = (GameBannerView) inflate.findViewById(R.id.dh0);
        this.xTB.setSourceScene(this.xGR);
        this.xPd.addHeaderView(inflate);
        this.xTN++;
        this.xTC = (GameLibraryCategoriesView) layoutInflater.inflate(R.layout.ar3, (ViewGroup) this.xPd, false);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.addView(this.xTC);
        this.xPd.addHeaderView(linearLayout);
        this.xTN++;
        this.xTD = layoutInflater.inflate(R.layout.ar8, (ViewGroup) this.xPd, false);
        this.xTD.setOnClickListener(this.xTO);
        this.xTE = (TextView) this.xTD.findViewById(R.id.dgy);
        this.xTF = layoutInflater.inflate(R.layout.ar2, (ViewGroup) this.xPd, false);
        this.xTF.setOnClickListener(null);
        this.xTG = (GameDropdownView) this.xTF.findViewById(R.id.dgq);
        this.xTG.setAnchorView(this.xTF);
        this.xTG.setOnSelectionChangedListener(this.xTQ);
        this.gAy = layoutInflater.inflate(R.layout.arb, (ViewGroup) this.xPd, false);
        this.gAy.setVisibility(8);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.addView(this.gAy);
        this.xPd.addFooterView(linearLayout2);
        this.xTJ = layoutInflater.inflate(R.layout.ar7, (ViewGroup) this.xPd, false);
        this.xTJ.setVisibility(8);
        this.xTK = (Button) this.xTJ.findViewById(R.id.dgx);
        this.xTK.setOnClickListener(this.xTP);
        this.xPd.addFooterView(this.xTJ);
        this.xPd.setAdapter((ListAdapter) this.xPe);
        AppMethodBeat.o(42236);
    }

    private void goBack() {
        AppMethodBeat.i(42237);
        dWn();
        finish();
        AppMethodBeat.o(42237);
    }

    private void dWn() {
        AppMethodBeat.i(42238);
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!Util.isNullOrNil(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            a.a(this, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryUI", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(42238);
    }

    private void dWs() {
        AppMethodBeat.i(42239);
        g.azz().a(new aq(this.xGW, e.dUR(), this.xTI, this.xGW == 0), 0);
        this.xPf = true;
        AppMethodBeat.o(42239);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(42240);
        if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 1218:
                    final com.tencent.mm.bw.a aVar = ((aq) qVar).hhm.iLL.iLR;
                    g.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass9 */

                        public final void run() {
                            AppMethodBeat.i(42229);
                            final ae aeVar = new ae(aVar, GameLibraryUI.this.xGW == 0 && !GameLibraryUI.this.wYE, GameLibraryUI.this.xGW);
                            GameLibraryUI.this.wYE = true;
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.game.ui.GameLibraryUI.AnonymousClass9.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(42228);
                                    GameLibraryUI.a(GameLibraryUI.this, aeVar, GameLibraryUI.this.xGW != 0);
                                    GameLibraryUI.this.xPf = false;
                                    GameLibraryUI.this.gAy.setVisibility(8);
                                    GameLibraryUI.this.xGW += 15;
                                    if (GameLibraryUI.this.rAV != null) {
                                        GameLibraryUI.this.rAV.dismiss();
                                    }
                                    AppMethodBeat.o(42228);
                                }
                            });
                            AppMethodBeat.o(42229);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(42240);
            return;
        }
        if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, i2, i3, str)) {
            Toast.makeText(this, getString(R.string.dqd, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        }
        if (this.rAV != null) {
            this.rAV.cancel();
        }
        AppMethodBeat.o(42240);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(42241);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.GameLibraryUI", "requestCode = %d, resultCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 != 1) {
            Log.e("MicroMsg.GameLibraryUI", "error request code");
            AppMethodBeat.o(42241);
            return;
        }
        AppMethodBeat.o(42241);
    }

    static /* synthetic */ void a(GameLibraryUI gameLibraryUI, ae aeVar, boolean z) {
        LinkedList<GameBannerView.a> linkedList;
        Pair pair = null;
        AppMethodBeat.i(42243);
        gameLibraryUI.xPg = aeVar.xHq.xMb;
        if (!z) {
            GameBannerView gameBannerView = gameLibraryUI.xTB;
            if (aeVar.xHq.xLZ == null || aeVar.xHq.xLZ.xME == null) {
                Log.e("MicroMsg.GamePBDataLibrary", "Has no banner");
                linkedList = null;
            } else {
                LinkedList<GameBannerView.a> linkedList2 = new LinkedList<>();
                for (int i2 = 0; i2 < aeVar.xHq.xLZ.xME.size(); i2++) {
                    GameBannerView.a aVar = new GameBannerView.a();
                    com.tencent.mm.plugin.game.protobuf.c cVar = aeVar.xHq.xLZ.xME.get(i2);
                    com.tencent.mm.plugin.game.model.c a2 = ae.a(cVar.xIz);
                    if (a2 != null) {
                        d.c(a2);
                        aVar.index = i2;
                        aVar.xOH = a2;
                        aVar.iJx = cVar.xIA;
                        aVar.xDX = cVar.xIB;
                        linkedList2.add(aVar);
                    }
                }
                linkedList = linkedList2;
            }
            gameBannerView.setBannerList(linkedList);
            gameLibraryUI.xTC.setData(aeVar.dVT());
            gameLibraryUI.xTC.setSourceScene(gameLibraryUI.xGR);
            LinkedList linkedList3 = new LinkedList();
            LinkedList<com.tencent.mm.plugin.game.model.c> linkedList4 = aeVar.xHr;
            LinkedList<com.tencent.mm.plugin.game.model.c> linkedList5 = aeVar.xHs;
            linkedList3.addAll(linkedList4);
            linkedList3.addAll(linkedList5);
            gameLibraryUI.xPe.aV(linkedList3);
            Log.i("MicroMsg.GameLibraryUI", "Initial new game list size: %d, initial all game list size: %d", Integer.valueOf(linkedList4.size()), Integer.valueOf(linkedList5.size()));
            gameLibraryUI.xTH = aeVar.dVS();
            LinkedList<String> linkedList6 = new LinkedList<>();
            linkedList6.addAll(gameLibraryUI.xTH.values());
            GameDropdownView gameDropdownView = gameLibraryUI.xTG;
            LinkedList linkedList7 = new LinkedList();
            linkedList7.addAll(gameLibraryUI.xTH.keySet());
            gameDropdownView.g(linkedList6, linkedList7.indexOf(Integer.valueOf(gameLibraryUI.xTI)));
            Pair pair2 = (aeVar.xHq.xLZ == null || aeVar.xHq.xLZ.xMF == null) ? null : new Pair(aeVar.xHq.xLZ.xMF.xMU, aeVar.xHq.xLZ.xMF.xMk);
            if (pair2 == null || Util.isNullOrNil((String) pair2.first) || Util.isNullOrNil((String) pair2.second)) {
                gameLibraryUI.xTD.setTag(null);
                gameLibraryUI.xTE.setVisibility(8);
            } else {
                gameLibraryUI.xTD.setTag(pair2.second);
                gameLibraryUI.xTE.setVisibility(0);
                gameLibraryUI.xTE.setText((CharSequence) pair2.first);
            }
            SparseArray sparseArray = new SparseArray();
            if (linkedList4.size() != 0) {
                sparseArray.put(0, gameLibraryUI.xTD);
            }
            sparseArray.put(linkedList4.size(), gameLibraryUI.xTF);
            gameLibraryUI.xPe.f(sparseArray);
            if (!(aeVar.xHq.xLZ == null || aeVar.xHq.xLZ.xMH == null)) {
                pair = new Pair(aeVar.xHq.xLZ.xMH.xMN, aeVar.xHq.xLZ.xMH.xIB);
            }
            if (pair != null) {
                gameLibraryUI.xTK.setText((CharSequence) pair.first);
                gameLibraryUI.xTK.setTag(pair.second);
                gameLibraryUI.xTL = true;
            }
        } else {
            LinkedList<com.tencent.mm.plugin.game.model.c> linkedList8 = aeVar.xHs;
            gameLibraryUI.xPe.aU(linkedList8);
            Log.i("MicroMsg.GameLibraryUI", "Appending list size: %d", Integer.valueOf(linkedList8.size()));
        }
        if (!gameLibraryUI.xPg && gameLibraryUI.xTL) {
            gameLibraryUI.xTJ.setVisibility(0);
        }
        AppMethodBeat.o(42243);
    }
}
