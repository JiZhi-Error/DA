package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.protobuf.av;
import com.tencent.mm.plugin.game.ui.tab.GameRouteUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;

@i
@a(19)
public class GameCenterUI extends MMBaseActivity {
    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41949);
        super.onCreate(bundle);
        getIntent().putExtra("gamecenterui_createtime", System.currentTimeMillis());
        Log.i("MicroMsg.GameCenterUI", "onCreate, time: " + System.currentTimeMillis());
        if (getIntent().getBooleanExtra("game_check_float", false)) {
            int intExtra = getIntent().getIntExtra("game_sourceScene", 0);
            ((e) g.af(e.class)).dSJ();
            o dVq = r.dVq();
            if (dVq != null) {
                dVq.dVl();
                if (!Util.isNullOrNil(dVq.xFw.url)) {
                    c.a(getBaseContext(), dVq, "game_center_h5_floatlayer");
                }
            }
            m.a(dVq, intExtra, 1);
            finish();
            AppMethodBeat.o(41949);
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra("switch_country_no_anim", false);
        av avVar = null;
        if (com.tencent.mm.plugin.game.commlib.a.xvl != null) {
            avVar = com.tencent.mm.plugin.game.commlib.a.xvl.GameIndexSetting;
            if (avVar != null) {
                Log.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", Integer.valueOf(avVar.xJa), avVar.xIy);
            }
        } else {
            com.tencent.mm.plugin.game.commlib.a.dSS();
        }
        if (avVar != null) {
            switch (avVar.xJa) {
                case 0:
                    pU(booleanExtra);
                    break;
                case 1:
                    if (Util.isNullOrNil(avVar.xIy)) {
                        pU(booleanExtra);
                        break;
                    } else {
                        String str = avVar.xIy;
                        getIntent().putExtra("rawUrl", str);
                        if (((b) g.af(b.class)).a(b.a.game_luggage, true)) {
                            Intent intent = getIntent();
                            if (!Util.isNullOrNil(str) && intent != null) {
                                boolean booleanExtra2 = intent.getBooleanExtra("from_find_more_friend", false);
                                int intExtra2 = intent.getIntExtra("game_report_from_scene", 0);
                                ((e) g.af(e.class)).dSJ();
                                o dVm = r.dVm();
                                String a2 = m.a(str, dVm, intent, true);
                                intent.putExtra("rawUrl", a2);
                                intent.putExtra("from_find_more_friend", true);
                                if (booleanExtra2) {
                                    ((e) g.af(e.class)).dSJ();
                                    o dVn = r.dVn();
                                    if (dVn != null) {
                                        dVn.dVl();
                                        if (dVn.xFV == 107) {
                                            intent.putExtra("from_download_floagt_ball_shutdown_entrance", true);
                                        }
                                    }
                                    m.a(intent, "game_center_entrance", true, dVm, intExtra2, a2);
                                    c.x(intent, this);
                                    m.b(7, true, a2);
                                    ((e) g.af(e.class)).dSJ();
                                    r.dVv();
                                } else {
                                    m.a(intent, "game_center_entrance", false, dVm, intExtra2, a2);
                                    c.x(intent, this);
                                }
                            }
                            h.INSTANCE.idkeyStat(848, 3, 1, false);
                            h.INSTANCE.idkeyStat(848, 9, 1, false);
                        } else {
                            Intent intent2 = getIntent();
                            if (!Util.isNullOrNil(str) && intent2 != null) {
                                boolean booleanExtra3 = intent2.getBooleanExtra("from_find_more_friend", false);
                                int intExtra3 = intent2.getIntExtra("game_report_from_scene", 0);
                                ((e) g.af(e.class)).dSJ();
                                o dVm2 = r.dVm();
                                String a3 = m.a(str, dVm2, intent2, true);
                                intent2.putExtra("rawUrl", a3);
                                if (booleanExtra3) {
                                    m.a((Context) this, intent2, "game_center_entrance", true, dVm2, intExtra3);
                                    m.b(7, true, a3);
                                    ((e) g.af(e.class)).dSJ();
                                    r.dVv();
                                } else {
                                    m.a((Context) this, intent2, "game_center_entrance", false, dVm2, intExtra3);
                                }
                            }
                            h.INSTANCE.idkeyStat(848, 3, 1, false);
                        }
                        com.tencent.mm.plugin.game.model.e.dVc();
                        break;
                    }
                case 2:
                    Intent intent3 = new Intent(this, GameOverSeaCenterUI.class);
                    Bundle extras = getIntent().getExtras();
                    if (extras != null) {
                        intent3.putExtras(extras);
                    }
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToForeignerIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    if (booleanExtra) {
                        overridePendingTransition(R.anim.cd, R.anim.cd);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
                    }
                    if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
                        m.b(6, false, null);
                    }
                    h.INSTANCE.idkeyStat(848, 5, 1, false);
                    break;
                case 3:
                    Intent intent4 = new Intent(this, GameDownloadGuidanceUI.class);
                    Bundle extras2 = getIntent().getExtras();
                    if (extras2 != null) {
                        intent4.putExtras(extras2);
                    }
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpToDownloadGuidanceIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    if (booleanExtra) {
                        overridePendingTransition(R.anim.cd, R.anim.cd);
                    } else {
                        overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
                    }
                    if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
                        m.b(6, false, null);
                    }
                    h.INSTANCE.idkeyStat(848, 6, 1, false);
                    break;
                case 4:
                    pV(booleanExtra);
                    break;
            }
            finish();
            AppMethodBeat.o(41949);
        }
        pU(booleanExtra);
        finish();
        AppMethodBeat.o(41949);
    }

    private void pU(boolean z) {
        AppMethodBeat.i(41950);
        if (ChannelUtil.isGPVersion()) {
            Log.i("MicroMsg.GameCenterUI", "GP version");
            h.INSTANCE.idkeyStat(848, 13, 1, false);
            pV(z);
            AppMethodBeat.o(41950);
            return;
        }
        if (!m.i(this, getIntent())) {
            pV(z);
        }
        AppMethodBeat.o(41950);
    }

    private void pV(boolean z) {
        AppMethodBeat.i(41953);
        Intent intent = new Intent(this, GameRouteUI.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameCenterUI", "jumpNativeIndex", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        if (z) {
            overridePendingTransition(R.anim.cd, R.anim.cd);
        } else {
            overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
        }
        if (getIntent().getBooleanExtra("from_find_more_friend", false)) {
            m.b(6, false, null);
        }
        h.INSTANCE.idkeyStat(848, 4, 1, false);
        AppMethodBeat.o(41953);
    }
}
