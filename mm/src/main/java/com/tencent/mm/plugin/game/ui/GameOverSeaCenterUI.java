package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
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
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.protobuf.bu;
import com.tencent.mm.plugin.game.protobuf.co;
import com.tencent.mm.plugin.game.protobuf.cq;
import com.tencent.mm.plugin.game.protobuf.cx;
import com.tencent.mm.plugin.game.ui.GameInstalledView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameOverSeaCenterUI extends GameCenterBaseUI implements i {
    private boolean gWt = true;
    private Dialog rAV;
    private bu xHt;
    k xOW = new k();
    private boolean xRI;
    private String xRJ = "";
    private View.OnClickListener xTP = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass4 */

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(42329);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.C1403a dUM = com.tencent.mm.plugin.game.model.a.dUM();
            if (dUM.cSx == 2) {
                i2 = c.D(GameOverSeaCenterUI.this.getContext(), dUM.url, "game_center_library");
            } else {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String) || Util.isNullOrNil((String) tag)) {
                    Intent intent = new Intent(GameOverSeaCenterUI.this.getContext(), GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1005);
                    GameOverSeaCenterUI gameOverSeaCenterUI = GameOverSeaCenterUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(gameOverSeaCenterUI, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    gameOverSeaCenterUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(gameOverSeaCenterUI, "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    i2 = 6;
                } else {
                    i2 = c.D(GameOverSeaCenterUI.this.getContext(), (String) tag, "game_center_library");
                }
            }
            f.a(GameOverSeaCenterUI.this.getContext(), 10, 1005, 1, i2, GameOverSeaCenterUI.this.xGR, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameOverSeaCenterUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42329);
        }
    };
    private GameCenterListView xVo;
    private g xVp;
    private GameInfoViewForeign xVq;
    private GameMessageBubbleView xVr;
    private GameInstalledView xVs;
    private View xVt;
    private TextView xVu;

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameOverSeaCenterUI() {
        AppMethodBeat.i(42333);
        AppMethodBeat.o(42333);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42334);
        super.onCreate(bundle);
        Log.i("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI create");
        g.azz().a(2855, this);
        initView();
        c.cyh().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(42327);
                byte[] azn = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn("pb_over_sea");
                if (azn == null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42324);
                            if (GameOverSeaCenterUI.this.isFinishing()) {
                                AppMethodBeat.o(42324);
                                return;
                            }
                            GameOverSeaCenterUI.this.rAV = c.gl(GameOverSeaCenterUI.this);
                            GameOverSeaCenterUI.this.rAV.show();
                            AppMethodBeat.o(42324);
                        }
                    });
                } else {
                    final af afVar = new af(azn);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(42325);
                            try {
                                GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, afVar, 1);
                                AppMethodBeat.o(42325);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", e2.getMessage());
                                GameOverSeaCenterUI.this.finish();
                                AppMethodBeat.o(42325);
                            }
                        }
                    });
                }
                ((e) g.af(e.class)).dSI().init(GameOverSeaCenterUI.this);
                c.aX(com.tencent.mm.plugin.game.model.e.dUR());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass2.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(42326);
                        GameOverSeaCenterUI.this.xVs.refresh(true);
                        AppMethodBeat.o(42326);
                    }
                });
                g.azz().a(new ap(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.dUR(), GameOverSeaCenterUI.this.xPs, GameOverSeaCenterUI.this.xPt, GameOverSeaCenterUI.this.xPu, GameOverSeaCenterUI.this.xPr), 0);
                com.tencent.mm.plugin.game.model.e.dUW();
                a.C1396a.xYZ.dWM();
                AppMethodBeat.o(42327);
            }
        });
        AppMethodBeat.o(42334);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(42335);
        super.onResume();
        if (!this.gWt) {
            if (this.xPr) {
                this.xVr.dWx();
            }
            this.xVq.dWq();
        }
        this.gWt = false;
        AppMethodBeat.o(42335);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42336);
        Log.i("MicroMsg.GameOverSeaCenterUI", "onDestroy");
        super.onDestroy();
        a.C1396a.xYZ.clearCache();
        g.azz().b(2855, this);
        ((e) g.af(e.class)).dSI().clearCache();
        AppMethodBeat.o(42336);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42337);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42323);
                GameOverSeaCenterUI.this.finish();
                AppMethodBeat.o(42323);
                return true;
            }
        });
        setMMTitle(R.string.dte);
        this.xVo = (GameCenterListView) findViewById(R.id.ddg);
        this.xVo.setOnItemClickListener(this.xOW);
        this.xOW.setSourceScene(this.xGR);
        this.xVp = new g(this);
        this.xVp.setSourceScene(this.xGR);
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.layout.apd, (ViewGroup) this.xVo, false);
        this.xVq = (GameInfoViewForeign) inflate.findViewById(R.id.ddd);
        this.xVo.addHeaderView(inflate);
        View inflate2 = layoutInflater.inflate(R.layout.ap3, (ViewGroup) this.xVo, false);
        this.xVr = (GameMessageBubbleView) inflate2.findViewById(R.id.dho);
        this.xVo.addHeaderView(inflate2);
        View inflate3 = layoutInflater.inflate(R.layout.ape, (ViewGroup) this.xVo, false);
        this.xVs = (GameInstalledView) inflate3.findViewById(R.id.dgc);
        this.xVo.addHeaderView(inflate3);
        View inflate4 = layoutInflater.inflate(R.layout.ap8, (ViewGroup) this.xVo, false);
        this.xVo.addFooterView(inflate4);
        this.xVt = inflate4.findViewById(R.id.dg0);
        this.xVt.setOnClickListener(this.xTP);
        this.xVu = (TextView) inflate4.findViewById(R.id.dg1);
        this.xVo.setAdapter((ListAdapter) this.xVp);
        AppMethodBeat.o(42337);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ap6;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(42338);
        Log.i("MicroMsg.GameOverSeaCenterUI", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(qVar.hashCode()));
        if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 2855:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bw.a aVar = ((ap) qVar).hhm.iLL.iLR;
                    c.cyh().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass6 */

                        public final void run() {
                            AppMethodBeat.i(42332);
                            if (aVar == null) {
                                GameOverSeaCenterUI.this.xHt = new bu();
                            } else {
                                GameOverSeaCenterUI.this.xHt = (bu) aVar;
                            }
                            final af afVar = new af(aVar);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass6.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(42331);
                                    try {
                                        GameOverSeaCenterUI.a(GameOverSeaCenterUI.this, afVar, 2);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI crash, %s", e2.getMessage());
                                        GameOverSeaCenterUI.this.finish();
                                    }
                                    if (GameOverSeaCenterUI.this.rAV != null) {
                                        GameOverSeaCenterUI.this.rAV.dismiss();
                                    }
                                    Log.i("MicroMsg.GameOverSeaCenterUI", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.o(42331);
                                }
                            });
                            AppMethodBeat.o(42332);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(42338);
            return;
        }
        if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, i2, i3, str)) {
            Toast.makeText(this, getString(R.string.dqd, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        }
        if (this.rAV != null) {
            this.rAV.cancel();
        }
        AppMethodBeat.o(42338);
    }

    static /* synthetic */ void a(GameOverSeaCenterUI gameOverSeaCenterUI, af afVar, int i2) {
        co coVar;
        LinkedList<com.tencent.mm.plugin.game.model.c> linkedList;
        cx cxVar;
        com.tencent.mm.plugin.game.model.c a2;
        AppMethodBeat.i(42339);
        if (gameOverSeaCenterUI.isFinishing()) {
            Log.w("MicroMsg.GameOverSeaCenterUI", "GameOverSeaCenterUI hasFinished");
            AppMethodBeat.o(42339);
        } else if (afVar == null) {
            Log.e("MicroMsg.GameOverSeaCenterUI", "Null data");
            AppMethodBeat.o(42339);
        } else {
            if (afVar == null || afVar.dVW() == null) {
                gameOverSeaCenterUI.xRJ = "";
            } else {
                gameOverSeaCenterUI.xRJ = afVar.dVW().xIy;
            }
            if (!Util.isNullOrNil(gameOverSeaCenterUI.xRJ)) {
                if (!gameOverSeaCenterUI.xRI) {
                    gameOverSeaCenterUI.addIconOptionMenu(0, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
                        /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass5 */

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(42330);
                            f.a(GameOverSeaCenterUI.this.getContext(), 10, 1008, 1, c.aQ(GameOverSeaCenterUI.this.getContext(), GameOverSeaCenterUI.this.xRJ), GameOverSeaCenterUI.this.xGR, null);
                            AppMethodBeat.o(42330);
                            return true;
                        }
                    });
                    gameOverSeaCenterUI.xRI = true;
                }
            } else if (gameOverSeaCenterUI.xRI) {
                gameOverSeaCenterUI.removeOptionMenu(0);
                gameOverSeaCenterUI.xRI = false;
            }
            if (afVar.xHt == null || afVar.xHt.xLR == null) {
                coVar = null;
            } else {
                coVar = afVar.xHt.xLR.xKH;
            }
            if (coVar != null) {
                gameOverSeaCenterUI.xVq.setSourceScene(gameOverSeaCenterUI.xGR);
                gameOverSeaCenterUI.xVq.setVisibility(0);
            } else {
                gameOverSeaCenterUI.xVq.setVisibility(8);
            }
            gameOverSeaCenterUI.xVs.setSourceScene(gameOverSeaCenterUI.xGR);
            gameOverSeaCenterUI.xVs.setVersionCodes(afVar.xHw);
            GameInstalledView gameInstalledView = gameOverSeaCenterUI.xVs;
            GameInstalledView.a aVar = new GameInstalledView.a();
            if (!(afVar.xHt.xLT == null || afVar.xHt.xLT.xMz == null)) {
                aVar.iconUrl = afVar.xHt.xLT.xMz.xIJ;
                aVar.title = afVar.xHt.xLT.xMz.Title;
                aVar.lDS = afVar.xHt.xLT.xMz.xIB;
            }
            gameInstalledView.setMoreGameInfo(aVar);
            GameInstalledView gameInstalledView2 = gameOverSeaCenterUI.xVs;
            LinkedList<com.tencent.mm.plugin.game.model.c> linkedList2 = new LinkedList<>();
            if (afVar.xHt.xLT == null || afVar.xHt.xLT.xMy == null) {
                linkedList = linkedList2;
            } else {
                Iterator<cq> it = afVar.xHt.xLT.xMy.iterator();
                while (it.hasNext()) {
                    cq next = it.next();
                    if (!(next == null || (a2 = af.a(next.xIz)) == null)) {
                        a2.Bn(next.xMA);
                        linkedList2.addFirst(a2);
                    }
                }
                linkedList = linkedList2;
            }
            gameInstalledView2.setInstalledGameInfo(linkedList);
            gameOverSeaCenterUI.xVs.refresh(true);
            if (gameOverSeaCenterUI.xPr) {
                gameOverSeaCenterUI.xVr.dWx();
            }
            if (afVar.xHt != null) {
                cxVar = afVar.xHt.xLU;
            } else {
                cxVar = null;
            }
            if (cxVar == null || Util.isNullOrNil(cxVar.Desc) || Util.isNullOrNil(cxVar.xIy)) {
                gameOverSeaCenterUI.xVt.setVisibility(8);
            } else {
                gameOverSeaCenterUI.xVt.setVisibility(0);
                gameOverSeaCenterUI.xVu.setText(cxVar.Desc);
                gameOverSeaCenterUI.xVt.setTag(cxVar.xIy);
                gameOverSeaCenterUI.xVt.setOnClickListener(gameOverSeaCenterUI.xTP);
            }
            gameOverSeaCenterUI.xVp.Ot(i2);
            gameOverSeaCenterUI.xVp.aV(afVar.xHv);
            if (i2 == 2) {
                c.cyh().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(42328);
                        ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().b("pb_over_sea", GameOverSeaCenterUI.this.xHt);
                        AppMethodBeat.o(42328);
                    }
                });
            }
            AppMethodBeat.o(42339);
        }
    }
}
