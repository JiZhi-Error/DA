package com.tencent.mm.plugin.game.ui.tab;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.plugin.game.protobuf.aw;
import com.tencent.mm.plugin.game.protobuf.bq;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@a(19)
public class GameRouteUI extends GameCenterActivity implements i {
    private int xGR;

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(GameRouteUI gameRouteUI) {
        AppMethodBeat.i(42428);
        gameRouteUI.exit();
        AppMethodBeat.o(42428);
    }

    static /* synthetic */ void a(GameRouteUI gameRouteUI, List list) {
        AppMethodBeat.i(42429);
        gameRouteUI.h(list, false);
        AppMethodBeat.o(42429);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(42420);
        super.onCreate(bundle);
        initView();
        this.xGR = getIntent().getIntExtra("game_report_from_scene", 0);
        bq dWJ = dWJ();
        if (dWJ == null || Util.isNullOrNil(dWJ.xKD)) {
            g.azz().a(2641, this);
            g.azz().a(new aj(), 0);
            AppMethodBeat.o(42420);
            return;
        }
        Log.i("MicroMsg.GameRouteUI", "use cache data");
        aj.updateData();
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        getIntent().removeExtra("switch_country_no_anim");
        LinkedList<aw> linkedList = dWJ.xKD;
        if (!booleanExtra) {
            z = true;
        }
        h(linkedList, z);
        AppMethodBeat.o(42420);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ase;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42421);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.tab.GameRouteUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42418);
                GameRouteUI.a(GameRouteUI.this);
                AppMethodBeat.o(42418);
                return true;
            }
        });
        setMMTitle(R.string.dte);
        AppMethodBeat.o(42421);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42422);
        g.azz().b(2641, this);
        super.onDestroy();
        AppMethodBeat.o(42422);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(42423);
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data success");
            final bq dVX = ((aj) qVar).dVX();
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.game.ui.tab.GameRouteUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(42419);
                    aj.a(dVX);
                    if (dVX == null || Util.isNullOrNil(dVX.xKD)) {
                        Log.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
                        GameRouteUI.a(GameRouteUI.this);
                        AppMethodBeat.o(42419);
                        return;
                    }
                    GameRouteUI.a(GameRouteUI.this, dVX.xKD);
                    AppMethodBeat.o(42419);
                }
            });
            AppMethodBeat.o(42423);
            return;
        }
        Log.i("MicroMsg.GameRouteUI", "pull gameIndexTabNav data fail");
        exit();
        AppMethodBeat.o(42423);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(42424);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            exit();
            AppMethodBeat.o(42424);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(42424);
        return onKeyDown;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final boolean dWh() {
        return false;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int getScene() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int dWi() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int dWj() {
        return 0;
    }

    private void exit() {
        AppMethodBeat.i(42425);
        if (!isFinishing() && !isDestroyed()) {
            finish();
            overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
        }
        AppMethodBeat.o(42425);
    }

    private void h(List<aw> list, boolean z) {
        GameTabData.TabItem tabItem;
        AppMethodBeat.i(42426);
        if (isFinishing() || isDestroyed()) {
            AppMethodBeat.o(42426);
            return;
        }
        GameTabData fb = GameTabData.fb(list);
        if (fb == null || Util.isNullOrNil(fb.avn())) {
            Log.e("MicroMsg.GameRouteUI", "game tab data is null");
            exit();
            AppMethodBeat.o(42426);
            return;
        }
        List<GameTabData.TabItem> avn = fb.avn();
        GameTabData.TabItem tabItem2 = null;
        int i2 = 0;
        while (i2 < avn.size()) {
            GameTabData.TabItem tabItem3 = avn.get(i2);
            if (tabItem3 != null) {
                if (tabItem3.xHC) {
                    tabItem = tabItem3;
                } else {
                    tabItem = tabItem2;
                }
                com.tencent.mm.plugin.game.d.a.b(this, 18, tabItem3.dYu, tabItem3.xHK, null, this.xGR, com.tencent.mm.plugin.game.d.a.Fh(tabItem3.xEl));
            } else {
                tabItem = tabItem2;
            }
            i2++;
            tabItem2 = tabItem;
        }
        if (tabItem2 == null) {
            tabItem2 = avn.get(0);
        }
        if (tabItem2 == null) {
            Log.e("MicroMsg.GameRouteUI", "game tab entry item is null");
            exit();
            AppMethodBeat.o(42426);
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putParcelable("tab_data", fb);
        getIntent().putExtras(extras);
        GameTabWidget.a(this, tabItem2, z, true, true);
        AppMethodBeat.o(42426);
    }

    private static bq dWJ() {
        bq bqVar;
        AppMethodBeat.i(42427);
        byte[] azn = ((f) g.af(f.class)).dSL().azn("game_index4_tab_nav");
        if (Util.isNullOrNil(azn)) {
            AppMethodBeat.o(42427);
            return null;
        }
        try {
            bqVar = new bq();
            try {
                bqVar.parseFrom(azn);
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            bqVar = null;
        }
        AppMethodBeat.o(42427);
        return bqVar;
    }
}
