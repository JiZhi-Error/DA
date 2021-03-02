package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.protobuf.bs;
import com.tencent.mm.plugin.game.protobuf.v;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class GameDownloadGuidanceUI extends GameCenterBaseUI implements i {
    private Dialog rAV;
    private LinearLayout tmh;
    private bs xHf;
    private TextView xRF;
    private TextView xRG;
    private TextView xRH;
    private boolean xRI;
    private String xRJ = "";

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42057);
        super.onCreate(bundle);
        g.azz().a(2586, this);
        initView();
        c.cyh().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(42052);
                byte[] azn = ((f) g.af(f.class)).dSL().azn("pb_download_guidance");
                if (azn == null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42050);
                            if (GameDownloadGuidanceUI.this.isFinishing()) {
                                AppMethodBeat.o(42050);
                                return;
                            }
                            GameDownloadGuidanceUI.this.rAV = c.gl(GameDownloadGuidanceUI.this);
                            GameDownloadGuidanceUI.this.rAV.show();
                            AppMethodBeat.o(42050);
                        }
                    });
                } else {
                    final ab abVar = new ab(azn);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(42051);
                            try {
                                GameDownloadGuidanceUI.this.a(abVar, 1);
                                AppMethodBeat.o(42051);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", e2.getMessage());
                                GameDownloadGuidanceUI.this.finish();
                                AppMethodBeat.o(42051);
                            }
                        }
                    });
                }
                g.azz().a(new ao(LocaleUtil.getApplicationLanguage(), e.dUR(), GameDownloadGuidanceUI.this.xPs, GameDownloadGuidanceUI.this.xPt, GameDownloadGuidanceUI.this.xPu, GameDownloadGuidanceUI.this.xPr), 0);
                e.dUW();
                a.C1396a.xYZ.dWM();
                AppMethodBeat.o(42052);
            }
        });
        AppMethodBeat.o(42057);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42058);
        Log.i("MicroMsg.GameDownloadGuidanceUI", "onDestroy");
        super.onDestroy();
        a.C1396a.xYZ.clearCache();
        g.azz().b(2586, this);
        ((com.tencent.mm.plugin.game.api.e) g.af(com.tencent.mm.plugin.game.api.e.class)).dSI().clearCache();
        AppMethodBeat.o(42058);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42059);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42049);
                GameDownloadGuidanceUI.this.finish();
                AppMethodBeat.o(42049);
                return true;
            }
        });
        setMMTitle(R.string.dte);
        this.tmh = (LinearLayout) findViewById(R.id.be3);
        this.xRF = (TextView) findViewById(R.id.f68);
        this.xRG = (TextView) findViewById(R.id.hfp);
        this.xRH = (TextView) findViewById(R.id.hfg);
        AppMethodBeat.o(42059);
    }

    public final void a(ab abVar, int i2) {
        AppMethodBeat.i(42060);
        if (isFinishing()) {
            Log.w("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI hasFinished");
            AppMethodBeat.o(42060);
        } else if (abVar == null || abVar.dVN() == null) {
            Log.e("MicroMsg.GameDownloadGuidanceUI", "Null data");
            AppMethodBeat.o(42060);
        } else {
            if (abVar == null || abVar.dVO() == null) {
                this.xRJ = "";
            } else {
                this.xRJ = abVar.dVO().xIy;
            }
            if (!Util.isNullOrNil(this.xRJ)) {
                if (!this.xRI) {
                    addIconOptionMenu(0, R.raw.actionbar_setting_icon, new MenuItem.OnMenuItemClickListener() {
                        /* class com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.AnonymousClass4 */

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(42054);
                            com.tencent.mm.game.report.f.a(GameDownloadGuidanceUI.this.getContext(), 10, 1008, 1, c.aQ(GameDownloadGuidanceUI.this.getContext(), GameDownloadGuidanceUI.this.xRJ), GameDownloadGuidanceUI.this.xGR, null);
                            AppMethodBeat.o(42054);
                            return true;
                        }
                    });
                    this.xRI = true;
                }
            } else if (this.xRI) {
                removeOptionMenu(0);
                this.xRI = false;
            }
            this.tmh.setVisibility(0);
            v dVN = abVar.dVN();
            if (!Util.isNullOrNil(dVN.xJI)) {
                this.xRF.setText(dVN.xJI);
                this.xRF.setVisibility(0);
            } else {
                this.xRF.setVisibility(8);
            }
            if (!Util.isNullOrNil(dVN.xJJ)) {
                this.xRG.setText(dVN.xJJ);
                this.xRG.setVisibility(0);
            } else {
                this.xRG.setVisibility(8);
            }
            if (!Util.isNullOrNil(dVN.xJK)) {
                this.xRH.setText(dVN.xJK);
                this.xRH.setVisibility(0);
            } else {
                this.xRH.setVisibility(8);
            }
            if (i2 == 2) {
                c.cyh().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(42053);
                        ((f) g.af(f.class)).dSL().b("pb_over_sea", GameDownloadGuidanceUI.this.xHf);
                        AppMethodBeat.o(42053);
                    }
                });
            }
            AppMethodBeat.o(42060);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aqp;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(42061);
        Log.i("MicroMsg.GameDownloadGuidanceUI", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(qVar.hashCode()));
        if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 2586:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bw.a aVar = ((ao) qVar).hhm.iLL.iLR;
                    c.cyh().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(42056);
                            if (aVar == null) {
                                GameDownloadGuidanceUI.this.xHf = new bs();
                            } else {
                                GameDownloadGuidanceUI.this.xHf = (bs) aVar;
                            }
                            final ab abVar = new ab(aVar);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(42055);
                                    try {
                                        GameDownloadGuidanceUI.this.a(abVar, 2);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.GameDownloadGuidanceUI", "GameDownloadGuidanceUI crash, %s", e2.getMessage());
                                        GameDownloadGuidanceUI.this.finish();
                                    }
                                    if (GameDownloadGuidanceUI.this.rAV != null) {
                                        GameDownloadGuidanceUI.this.rAV.dismiss();
                                    }
                                    Log.i("MicroMsg.GameDownloadGuidanceUI", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.o(42055);
                                }
                            });
                            AppMethodBeat.o(42056);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(42061);
            return;
        }
        if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, i2, i3, str)) {
            Toast.makeText(this, getString(R.string.dqd, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        }
        if (this.rAV != null) {
            this.rAV.cancel();
        }
        AppMethodBeat.o(42061);
    }
}
