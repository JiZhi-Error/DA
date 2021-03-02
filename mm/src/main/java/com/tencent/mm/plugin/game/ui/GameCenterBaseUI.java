package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class GameCenterBaseUI extends GameCenterActivity {
    private boolean isFirst = true;
    protected int xGR = 0;
    protected boolean xPr = false;
    protected o xPs;
    protected o xPt;
    protected o xPu;
    protected boolean xPv = false;

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.xPt != null && !gameCenterBaseUI.xPt.field_isHidden && !Util.isNullOrNil(gameCenterBaseUI.xPt.xFw.url)) {
            gameCenterBaseUI.xPv = true;
            o oVar = gameCenterBaseUI.xPt;
            c.a(gameCenterBaseUI.getBaseContext(), oVar, "game_center_h5_floatlayer");
            f.a(gameCenterBaseUI, 10, 1006, 1, 1, 0, oVar.field_appId, 0, oVar.xFV, oVar.field_gameMsgId, oVar.xFW, null);
            h.INSTANCE.idkeyStat(858, 18, 1, false);
            gameCenterBaseUI.xPt.field_isRead = true;
            ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().update(gameCenterBaseUI.xPt, new String[0]);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!g.aAc()) {
            Log.e("MicroMsg.GameCenterBaseUI", "account not ready");
            finish();
            return;
        }
        this.xGR = getIntent().getIntExtra("game_report_from_scene", 0);
        this.xPr = getIntent().getBooleanExtra("from_find_more_friend", false);
        c.cyh().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.GameCenterBaseUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(41926);
                GameCenterBaseUI.a(GameCenterBaseUI.this);
                if (GameCenterBaseUI.this.xPr) {
                    GameCenterBaseUI.b(GameCenterBaseUI.this);
                    ((e) g.af(e.class)).dSJ();
                    r.dVr();
                }
                AppMethodBeat.o(41926);
            }
        });
        f.a(this, 10, 1000, 0, 1, 0, null, this.xGR, 0, null, null, null);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (!g.aAc()) {
            Log.e("MicroMsg.GameCenterBaseUI", "account not ready");
            return;
        }
        if (!this.isFirst && a.C1396a.xYZ.xYX) {
            a.C1396a.xYZ.xYX = false;
            Log.i("MicroMsg.GameCenterBaseUI", "restart page from country setting");
            if (!isFinishing()) {
                finish();
            }
            sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.xtn);
            Intent intent = new Intent();
            intent.putExtra("game_report_from_scene", 901);
            intent.putExtra("switch_country_no_anim", true);
            com.tencent.mm.br.c.b(this, "game", ".ui.GameCenterUI", intent);
        }
        this.isFirst = false;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int getScene() {
        return 10;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int dWi() {
        return 1000;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity
    public final int dWj() {
        return this.xGR;
    }

    static /* synthetic */ void a(GameCenterBaseUI gameCenterBaseUI) {
        if (gameCenterBaseUI.xPr) {
            ((e) g.af(e.class)).dSJ();
            gameCenterBaseUI.xPs = r.dVn();
            if (gameCenterBaseUI.xPs != null) {
                gameCenterBaseUI.xPs.dVl();
            }
            ((e) g.af(e.class)).dSJ();
            gameCenterBaseUI.xPt = r.dVq();
            if (gameCenterBaseUI.xPt != null) {
                gameCenterBaseUI.xPt.dVl();
            }
        }
        ((e) g.af(e.class)).dSJ();
        gameCenterBaseUI.xPu = r.dVs();
        if (gameCenterBaseUI.xPu != null) {
            gameCenterBaseUI.xPu.dVl();
        }
    }
}
