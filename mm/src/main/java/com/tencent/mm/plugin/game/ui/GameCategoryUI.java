package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.plugin.game.ui.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public class GameCategoryUI extends MMActivity implements i {
    private View gAy;
    private int mType;
    private Dialog ocE;
    private int xGR = 0;
    private int xGW = 0;
    private k xOW = new k();
    private ListView xPd;
    private l xPe;
    private boolean xPf = false;
    private boolean xPg = false;
    private int xPh;
    private String xPi;
    private m.a xPj = new m.a() {
        /* class com.tencent.mm.plugin.game.ui.GameCategoryUI.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.game.ui.m.a
        public final void Os(int i2) {
            AppMethodBeat.i(41914);
            int firstVisiblePosition = GameCategoryUI.this.xPd.getFirstVisiblePosition();
            int lastVisiblePosition = GameCategoryUI.this.xPd.getLastVisiblePosition();
            if (i2 >= firstVisiblePosition && i2 <= lastVisiblePosition) {
                GameCategoryUI.this.xPe.aj(GameCategoryUI.this.xPd.getChildAt(i2 - firstVisiblePosition), i2);
            }
            AppMethodBeat.o(41914);
        }
    };
    private AbsListView.OnScrollListener xPk = new AbsListView.OnScrollListener() {
        /* class com.tencent.mm.plugin.game.ui.GameCategoryUI.AnonymousClass4 */

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(41915);
            if (i2 == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                if (!GameCategoryUI.this.xPg || GameCategoryUI.this.xPf) {
                    AppMethodBeat.o(41915);
                    return;
                } else {
                    GameCategoryUI.this.gAy.setVisibility(0);
                    GameCategoryUI.g(GameCategoryUI.this);
                }
            }
            AppMethodBeat.o(41915);
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameCategoryUI() {
        AppMethodBeat.i(41918);
        AppMethodBeat.o(41918);
    }

    static /* synthetic */ void g(GameCategoryUI gameCategoryUI) {
        AppMethodBeat.i(41924);
        gameCategoryUI.dWk();
        AppMethodBeat.o(41924);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41919);
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("extra_type", 0);
        this.xPh = getIntent().getIntExtra("extra_category_id", 0);
        this.xPi = getIntent().getStringExtra("extra_category_name");
        this.xGR = getIntent().getIntExtra("game_report_from_scene", 0);
        g.azz().a(1220, this);
        setMMTitle(this.xPi);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameCategoryUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41912);
                GameCategoryUI.this.finish();
                AppMethodBeat.o(41912);
                return true;
            }
        });
        if (!Util.isNullOrNil(e.dVf())) {
            addIconOptionMenu(0, R.string.hpa, R.raw.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.game.ui.GameCategoryUI.AnonymousClass2 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(41913);
                    Intent intent = new Intent(GameCategoryUI.this, GameSearchUI.class);
                    switch (GameCategoryUI.this.mType) {
                        case 1:
                            intent.putExtra("game_report_from_scene", 1602);
                            break;
                        case 2:
                            intent.putExtra("game_report_from_scene", 1502);
                            break;
                    }
                    GameCategoryUI gameCategoryUI = GameCategoryUI.this;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(gameCategoryUI, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameCategoryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    gameCategoryUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(gameCategoryUI, "com/tencent/mm/plugin/game/ui/GameCategoryUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(41913);
                    return true;
                }
            });
        }
        this.xPd = (ListView) findViewById(R.id.dd6);
        this.xPd.setOnItemClickListener(this.xOW);
        this.xOW.setSourceScene(this.xGR);
        this.xPd.setOnScrollListener(this.xPk);
        this.xPe = new l(this);
        this.xPe.setSourceScene(this.xGR);
        this.xPe.a(this.xPj);
        this.gAy = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.arb, (ViewGroup) this.xPd, false);
        this.gAy.setVisibility(8);
        this.xPd.addFooterView(this.gAy);
        this.xPd.setAdapter((ListAdapter) this.xPe);
        this.ocE = c.gl(this);
        this.ocE.show();
        dWk();
        AppMethodBeat.o(41919);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(41920);
        super.onDestroy();
        g.azz().b(1220, this);
        this.xPe.clear();
        AppMethodBeat.o(41920);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aos;
    }

    private void dWk() {
        AppMethodBeat.i(41921);
        g.azz().a(new ar(this.xGW, this.mType, this.xPh), 0);
        this.xPf = true;
        AppMethodBeat.o(41921);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(41922);
        if (i2 == 0 && i3 == 0) {
            final com.tencent.mm.bw.a aVar = ((ar) qVar).hhm.iLL.iLR;
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.game.ui.GameCategoryUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(41917);
                    final y yVar = new y(aVar, GameCategoryUI.this.mType, GameCategoryUI.this.xGW);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameCategoryUI.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(41916);
                            GameCategoryUI.a(GameCategoryUI.this, yVar, GameCategoryUI.this.xGW != 0);
                            GameCategoryUI.this.xPf = false;
                            GameCategoryUI.this.gAy.setVisibility(8);
                            GameCategoryUI.this.xGW += 15;
                            if (GameCategoryUI.this.ocE != null) {
                                GameCategoryUI.this.ocE.dismiss();
                            }
                            AppMethodBeat.o(41916);
                        }
                    });
                    AppMethodBeat.o(41917);
                }
            });
            AppMethodBeat.o(41922);
            return;
        }
        Log.e("MicroMsg.GameCategoryUI", "errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(41922);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(41923);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.GameCategoryUI", "requestCode = %d, resultCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 != 1) {
            Log.e("MicroMsg.GameCategoryUI", "error request code");
            AppMethodBeat.o(41923);
            return;
        }
        String str = null;
        if (intent != null) {
            str = intent.getStringExtra("game_app_id");
        }
        switch (i3) {
            case 3:
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(41923);
                    return;
                }
                this.xPe.aAB(str);
                AppMethodBeat.o(41923);
                return;
            case 2:
                if (!Util.isNullOrNil(str)) {
                    this.xPe.aAA(str);
                    this.xPe.aAC(str);
                    break;
                } else {
                    AppMethodBeat.o(41923);
                    return;
                }
        }
        AppMethodBeat.o(41923);
    }

    static /* synthetic */ void a(GameCategoryUI gameCategoryUI, y yVar, boolean z) {
        AppMethodBeat.i(41925);
        gameCategoryUI.xPg = yVar.xGU.xMb;
        if (!z) {
            gameCategoryUI.xPe.aV(yVar.xGV);
            AppMethodBeat.o(41925);
            return;
        }
        gameCategoryUI.xPe.aU(yVar.xGV);
        AppMethodBeat.o(41925);
    }
}
