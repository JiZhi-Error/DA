package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.protobuf.ax;
import com.tencent.mm.plugin.game.protobuf.bo;
import com.tencent.mm.plugin.game.protobuf.cl;
import com.tencent.mm.plugin.game.protobuf.de;
import com.tencent.mm.plugin.game.protobuf.di;
import com.tencent.mm.plugin.game.protobuf.eq;
import com.tencent.mm.plugin.game.ui.GameBlockView;
import com.tencent.mm.plugin.game.ui.GameIndexWxagView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class GameCenterUI5 extends GameCenterBaseUI implements i {
    private boolean gWt = true;
    private Dialog rAV;
    private GameNewTopBannerView xPG;
    private GameIndexSearchView xPH;
    private GameIndexWxagView xPI;
    private GameMessageBubbleView xPJ;
    private GameBlockView xPK;
    private GameRecomBlockView xPL;
    private GameNewClassifyView xPM;
    private GameIndexListView xPN;

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41961);
        super.onCreate(bundle);
        if (!g.aAc()) {
            Log.e("MicroMsg.GameCenterUI5", "account not ready");
            finish();
            AppMethodBeat.o(41961);
            return;
        }
        GameIndexListView.setSourceScene(this.xGR);
        g.azz().a(2994, this);
        initView();
        c.cyh().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.GameCenterUI5.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(41960);
                byte[] azn = ((f) g.af(f.class)).dSL().azn("pb_index_4");
                if (azn == null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameCenterUI5.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(41958);
                            if (GameCenterUI5.this.isFinishing()) {
                                AppMethodBeat.o(41958);
                                return;
                            }
                            GameCenterUI5.this.rAV = c.gl(GameCenterUI5.this);
                            GameCenterUI5.this.rAV.show();
                            AppMethodBeat.o(41958);
                        }
                    });
                } else {
                    final ac acVar = new ac(azn);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameCenterUI5.AnonymousClass3.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(41959);
                            GameCenterUI5.a(GameCenterUI5.this, acVar, 1);
                            AppMethodBeat.o(41959);
                        }
                    });
                }
                ((e) g.af(e.class)).dSI().init(GameCenterUI5.this);
                c.aX(com.tencent.mm.plugin.game.model.e.dUR());
                g.azz().a(new an(LocaleUtil.getApplicationLanguage(), com.tencent.mm.plugin.game.model.e.dUR(), GameCenterUI5.this.xPs, GameCenterUI5.this.xPt, GameCenterUI5.this.xPu, GameCenterUI5.this.xPr), 0);
                com.tencent.mm.plugin.game.model.e.fY(GameCenterUI5.this.getContext());
                com.tencent.mm.plugin.game.model.e.dUW();
                a.C1396a.xYZ.dWM();
                AppMethodBeat.o(41960);
            }
        });
        Log.i("MicroMsg.GameCenterUI5", "fromScene = %d", Integer.valueOf(this.xGR));
        AppMethodBeat.o(41961);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(41962);
        super.onResume();
        if (!g.aAc()) {
            Log.e("MicroMsg.GameCenterUI5", "account not ready");
            AppMethodBeat.o(41962);
            return;
        }
        if (!this.gWt) {
            ((e) g.af(e.class)).dSI().init(this);
            GameMessageBubbleView gameMessageBubbleView = this.xPJ;
            gameMessageBubbleView.xUR.setOnClickListener(null);
            gameMessageBubbleView.setVisibility(8);
            if (this.xPr) {
                this.xPJ.dWx();
            }
            GameBlockView gameBlockView = this.xPK;
            if (gameBlockView.xOX != null) {
                gameBlockView.xOX.xPc.refresh();
            }
            GameIndexListView gameIndexListView = this.xPN;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) gameIndexListView.getLayoutManager();
            int ks = linearLayoutManager.ks();
            gameIndexListView.xSV.aq(ks, (linearLayoutManager.ku() - ks) + 1);
        }
        this.gWt = false;
        AppMethodBeat.o(41962);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(41963);
        Log.i("MicroMsg.GameCenterUI5", "onDestroy");
        super.onDestroy();
        if (!g.aAc()) {
            Log.e("MicroMsg.GameCenterUI5", "account not ready");
            AppMethodBeat.o(41963);
            return;
        }
        a.C1396a.xYZ.clearCache();
        g.azz().b(2994, this);
        ((e) g.af(e.class)).dSI().clearCache();
        aw.dVY();
        aw.dWa();
        AppMethodBeat.o(41963);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(41964);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameCenterUI5.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41955);
                GameCenterUI5.this.finish();
                AppMethodBeat.o(41955);
                return true;
            }
        });
        setMMTitle(R.string.dte);
        this.xPN = (GameIndexListView) findViewById(R.id.dfj);
        this.xPN.setVisibility(8);
        View inflate = getLayoutInflater().inflate(R.layout.aqw, (ViewGroup) this.xPN, false);
        this.xPN.addHeaderView(inflate);
        this.xPG = (GameNewTopBannerView) inflate.findViewById(R.id.div);
        this.xPH = (GameIndexSearchView) inflate.findViewById(R.id.dg8);
        this.xPI = (GameIndexWxagView) inflate.findViewById(R.id.dg9);
        this.xPJ = (GameMessageBubbleView) inflate.findViewById(R.id.dho);
        this.xPK = (GameBlockView) inflate.findViewById(R.id.dd4);
        this.xPL = (GameRecomBlockView) inflate.findViewById(R.id.dih);
        this.xPM = (GameNewClassifyView) inflate.findViewById(R.id.di1);
        AppMethodBeat.o(41964);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(41965);
        Log.i("MicroMsg.GameCenterUI5", "errType: %d errCode: %d, scene: %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(qVar.hashCode()));
        if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 2994:
                    final long currentTimeMillis = System.currentTimeMillis();
                    final com.tencent.mm.bw.a aVar = ((an) qVar).hhm.iLL.iLR;
                    c.cyh().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameCenterUI5.AnonymousClass2 */

                        public final void run() {
                            bo boVar;
                            AppMethodBeat.i(41957);
                            if (aVar == null) {
                                boVar = new bo();
                            } else {
                                boVar = (bo) aVar;
                                ((f) g.af(f.class)).dSL().b("pb_index_4", boVar);
                            }
                            final ac acVar = new ac(boVar);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.game.ui.GameCenterUI5.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(41956);
                                    try {
                                        GameCenterUI5.a(GameCenterUI5.this, acVar, 2);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", e2.getMessage());
                                        GameCenterUI5.this.finish();
                                    }
                                    if (GameCenterUI5.this.rAV != null) {
                                        GameCenterUI5.this.rAV.dismiss();
                                    }
                                    Log.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    AppMethodBeat.o(41956);
                                }
                            });
                            AppMethodBeat.o(41957);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(41965);
            return;
        }
        if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, i2, i3, str)) {
            Toast.makeText(this, getString(R.string.dqd, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        }
        if (this.rAV != null) {
            this.rAV.cancel();
        }
        AppMethodBeat.o(41965);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ap0;
    }

    static /* synthetic */ void a(GameCenterUI5 gameCenterUI5, ac acVar, int i2) {
        int i3;
        AppMethodBeat.i(41966);
        if (gameCenterUI5.isFinishing()) {
            Log.w("MicroMsg.GameCenterUI5", "GameCenterUI5 hasFinished");
            AppMethodBeat.o(41966);
        } else if (acVar == null) {
            Log.e("MicroMsg.GameCenterUI5", "Null data");
            AppMethodBeat.o(41966);
        } else {
            GameNewTopBannerView gameNewTopBannerView = gameCenterUI5.xPG;
            cl clVar = acVar.xHh;
            int i4 = gameCenterUI5.xGR;
            boolean z = gameCenterUI5.xPv;
            if (clVar == null || clVar.xMu == null || Util.isNullOrNil(clVar.xMu.xKc)) {
                GameNewTopBannerView.dWy();
                gameNewTopBannerView.setVisibility(8);
            } else {
                gameNewTopBannerView.xGR = i4;
                gameNewTopBannerView.lAo = clVar.xMt != null ? com.tencent.mm.plugin.game.d.a.Fh(clVar.xMt.xJt) : null;
                if (!gameNewTopBannerView.xVm.equals(clVar.xMu.xKc)) {
                    gameNewTopBannerView.xVm = clVar.xMu.xKc;
                    com.tencent.mm.plugin.game.e.e.dWR().o(gameNewTopBannerView.xPE, clVar.xMu.xKc);
                    gameNewTopBannerView.xVk = gameNewTopBannerView.c(gameNewTopBannerView.xPE, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.dimen.h1), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.dimen.h0));
                    if (gameNewTopBannerView.xVk > 0) {
                        if (i2 == 2) {
                            com.tencent.mm.game.report.f.a(gameNewTopBannerView.mContext, 10, HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ, 1, 1, 0, null, gameNewTopBannerView.xGR, 0, null, null, gameNewTopBannerView.lAo);
                        }
                        if (gameNewTopBannerView.xVk <= 0 || clVar.xMt == null || Util.isNullOrNil(clVar.xMt.xIx)) {
                            gameNewTopBannerView.xPD.setVisibility(8);
                        } else {
                            com.tencent.mm.plugin.game.e.e.dWR().o(gameNewTopBannerView.xPD, clVar.xMt.xIx);
                            gameNewTopBannerView.xVl = gameNewTopBannerView.c(gameNewTopBannerView.xPD, gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.dimen.gy), gameNewTopBannerView.mContext.getResources().getDimensionPixelSize(R.dimen.h0));
                            if (gameNewTopBannerView.xVl > 0) {
                                gameNewTopBannerView.xPD.setVisibility(0);
                                gameNewTopBannerView.xPD.setTag(clVar.xMt.xIy);
                                gameNewTopBannerView.xPD.setOnClickListener(gameNewTopBannerView);
                            } else {
                                gameNewTopBannerView.xPD.setVisibility(8);
                            }
                        }
                        if (gameNewTopBannerView.xPD.getVisibility() == 0) {
                            if (clVar.xMt.xNF == com.tencent.mm.plugin.game.model.e.ge(gameNewTopBannerView.mContext) || z) {
                                GameIndexListView.setInitPadding(gameNewTopBannerView.xVk - gameNewTopBannerView.xVl);
                                gameNewTopBannerView.xPD.setImageAlpha(0);
                            } else {
                                gameNewTopBannerView.xPE.setImageAlpha(0);
                                com.tencent.mm.plugin.game.model.e.ah(gameNewTopBannerView.mContext, clVar.xMt.xNF);
                                GameIndexListView.setInitPadding(0);
                            }
                            GameIndexListView.setDefaultPadding(gameNewTopBannerView.xVk - gameNewTopBannerView.xVl);
                            GameIndexListView.setCanPulldown(true);
                        } else {
                            GameNewTopBannerView.dWy();
                        }
                        gameNewTopBannerView.setVisibility(0);
                    } else {
                        GameNewTopBannerView.dWy();
                        gameNewTopBannerView.setVisibility(8);
                    }
                } else if (i2 == 2) {
                    com.tencent.mm.game.report.f.a(gameNewTopBannerView.mContext, 10, HardCoderJNI.FUNC_CANCEL_GPU_HIGH_FREQ, 1, 1, 0, null, gameNewTopBannerView.xGR, 0, null, null, gameNewTopBannerView.lAo);
                }
            }
            GameIndexSearchView gameIndexSearchView = gameCenterUI5.xPH;
            cl clVar2 = acVar.xHh;
            int i5 = gameCenterUI5.xGR;
            if (clVar2 == null || clVar2.xMu == null || clVar2.xMu.xMS == null) {
                gameIndexSearchView.setVisibility(8);
            } else {
                gameIndexSearchView.removeAllViews();
                de deVar = clVar2.xMu.xMS;
                gameIndexSearchView.setVisibility(0);
                gameIndexSearchView.mInflater.inflate(R.layout.aqy, (ViewGroup) gameIndexSearchView, true);
                ImageView imageView = (ImageView) gameIndexSearchView.findViewById(R.id.he6);
                TextView textView = (TextView) gameIndexSearchView.findViewById(R.id.hf5);
                e.a.C1397a aVar = new e.a.C1397a();
                if (!Util.isNullOrNil(deVar.IconUrl)) {
                    com.tencent.mm.plugin.game.e.e.dWR().a(imageView, deVar.IconUrl, aVar.dWS());
                } else {
                    imageView.setVisibility(8);
                }
                if (!Util.isNullOrNil(deVar.Title)) {
                    textView.setText(deVar.Title);
                } else {
                    textView.setVisibility(8);
                }
                gameIndexSearchView.setTag(deVar.xIy);
                gameIndexSearchView.setOnClickListener(new View.OnClickListener(i5) {
                    /* class com.tencent.mm.plugin.game.ui.GameIndexSearchView.AnonymousClass1 */
                    final /* synthetic */ int xOY;

                    {
                        this.xOY = r2;
                    }

                    public final void onClick(View view) {
                        int i2;
                        AppMethodBeat.i(42170);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameIndexSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (view.getTag() == null || !(view.getTag() instanceof String)) {
                            a.C1403a dUN = com.tencent.mm.plugin.game.model.a.dUN();
                            if (dUN.cSx == 2) {
                                i2 = c.D(GameIndexSearchView.this.mContext, dUN.url, "game_center_msgcenter");
                            } else {
                                Intent intent = new Intent(GameIndexSearchView.this.mContext, GameSearchUI.class);
                                intent.putExtra("game_report_from_scene", 1001);
                                Context context = GameIndexSearchView.this.mContext;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameIndexSearchView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                context.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/game/ui/GameIndexSearchView$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                i2 = 6;
                            }
                        } else {
                            i2 = c.D(GameIndexSearchView.this.mContext, (String) view.getTag(), "game_center_msgcenter");
                        }
                        com.tencent.mm.game.report.f.a(GameIndexSearchView.this.mContext, 14, 1401, 1, i2, 0, null, this.xOY, 0, null, null, null);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(42170);
                    }
                });
            }
            GameIndexWxagView gameIndexWxagView = gameCenterUI5.xPI;
            ax axVar = acVar.xHl;
            int i6 = gameCenterUI5.xGR;
            if (axVar == null) {
                gameIndexWxagView.setVisibility(8);
            } else {
                gameIndexWxagView.xGR = i6;
                gameIndexWxagView.setVisibility(0);
                gameIndexWxagView.mContainer.removeAllViews();
                if (!Util.isNullOrNil(axVar.xKT) || axVar.xKU != null) {
                    if (i2 == 2) {
                        com.tencent.mm.plugin.game.d.a.b(gameIndexWxagView.getContext(), 10, TXLiteAVCode.EVT_CAMERA_CLOSE, 0, null, i6, com.tencent.mm.plugin.game.d.a.Fh(axVar.xJt));
                    }
                    gameIndexWxagView.mInflater.inflate(R.layout.ap2, (ViewGroup) gameIndexWxagView, true);
                    TextView textView2 = (TextView) gameIndexWxagView.findViewById(R.id.jrp);
                    LinearLayout linearLayout = (LinearLayout) gameIndexWxagView.findViewById(R.id.jrn);
                    if (!Util.isNullOrNil(axVar.Title)) {
                        textView2.setText(axVar.Title);
                    } else {
                        textView2.setVisibility(8);
                    }
                    for (int i7 = 0; i7 < 4; i7++) {
                        linearLayout.addView((LinearLayout) gameIndexWxagView.mInflater.inflate(R.layout.ap1, (ViewGroup) gameIndexWxagView, false), new LinearLayout.LayoutParams(-1, -2, 1.0f));
                    }
                    int i8 = 0;
                    if (!Util.isNullOrNil(axVar.xKT)) {
                        int i9 = 0;
                        while (true) {
                            i3 = i8;
                            if (i9 >= axVar.xKT.size()) {
                                break;
                            }
                            di diVar = axVar.xKT.get(i9);
                            if (!(diVar == null || diVar.xMW == null || diVar.xMW.xNP == null)) {
                                View childAt = linearLayout.getChildAt(i3);
                                com.tencent.mm.plugin.game.e.e.dWR().o((ImageView) childAt.findViewById(R.id.jrm), diVar.xMW.xNP.IconUrl);
                                ((TextView) childAt.findViewById(R.id.jro)).setText(diVar.xMW.xNP.xMq);
                                if (i2 == 2) {
                                    com.tencent.mm.plugin.game.d.a.b(gameIndexWxagView.getContext(), 10, TXLiteAVCode.EVT_CAMERA_CLOSE, i3 + 1, diVar.xMW.xNP.jfi, i6, null);
                                }
                                childAt.setTag(new GameIndexWxagView.a(i3 + 1, diVar.xMW.xNP));
                                childAt.setOnClickListener(gameIndexWxagView);
                                i3++;
                                if (i3 >= 3) {
                                    break;
                                }
                            }
                            i8 = i3;
                            i9++;
                        }
                    } else {
                        i3 = 0;
                    }
                    if (axVar.xKU != null) {
                        View childAt2 = linearLayout.getChildAt(i3);
                        com.tencent.mm.plugin.game.e.e.dWR().o((ImageView) childAt2.findViewById(R.id.jrm), axVar.xKU.IconUrl);
                        ((TextView) childAt2.findViewById(R.id.jro)).setText(axVar.xKU.xMq);
                        childAt2.setTag(axVar.xKU);
                        childAt2.setOnClickListener(new View.OnClickListener(i6) {
                            /* class com.tencent.mm.plugin.game.ui.GameIndexWxagView.AnonymousClass1 */
                            final /* synthetic */ int xOY;

                            {
                                this.xOY = r2;
                            }

                            public final void onClick(View view) {
                                AppMethodBeat.i(42173);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameIndexWxagView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (view.getTag() == null || !(view.getTag() instanceof eq)) {
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexWxagView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(42173);
                                    return;
                                }
                                eq eqVar = (eq) view.getTag();
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.scene = 1079;
                                ((r) g.af(r.class)).a(GameIndexWxagView.this.getContext(), eqVar.UserName, eqVar.jfi, eqVar.xNR, 0, eqVar.xut, appBrandStatObject);
                                com.tencent.mm.game.report.f.a(GameIndexWxagView.this.getContext(), 10, TXLiteAVCode.EVT_CAMERA_CLOSE, 999, 30, eqVar.jfi, this.xOY, null);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameIndexWxagView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(42173);
                            }
                        });
                    }
                    View view = new View(gameIndexWxagView.getContext());
                    view.setBackgroundColor(gameIndexWxagView.getContext().getResources().getColor(R.color.s8));
                    gameIndexWxagView.addView(view, new LinearLayout.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(gameIndexWxagView.getContext(), 5)));
                } else {
                    gameIndexWxagView.setVisibility(8);
                }
            }
            if (gameCenterUI5.xPr) {
                gameCenterUI5.xPJ.dWx();
            }
            GameBlockView gameBlockView = gameCenterUI5.xPK;
            ac.a aVar2 = acVar.xHi;
            int i10 = gameCenterUI5.xGR;
            if (aVar2 == null) {
                gameBlockView.setVisibility(8);
            } else {
                gameBlockView.xOW.setSourceScene(i10);
                gameBlockView.setVisibility(0);
                gameBlockView.tmh.removeAllViews();
                if (aVar2.xHm == null || Util.isNullOrNil(aVar2.xHm.field_appId) || Util.isNullOrNil(aVar2.xHm.field_appName)) {
                    gameBlockView.setVisibility(8);
                } else {
                    if (i2 == 2) {
                        com.tencent.mm.plugin.game.d.a.b(gameBlockView.getContext(), 10, 1002, 0, aVar2.xHm.field_appId, i10, null);
                    }
                    com.tencent.mm.plugin.game.model.c cVar = aVar2.xHm;
                    gameBlockView.xOX = new GameBlockView.a((byte) 0);
                    View inflate = gameBlockView.mInflater.inflate(R.layout.aow, (ViewGroup) gameBlockView.tmh, false);
                    gameBlockView.xOX.xPa = (ViewGroup) inflate.findViewById(R.id.f6s);
                    gameBlockView.xOX.xOL = (ImageView) inflate.findViewById(R.id.dg3);
                    gameBlockView.xOX.xOM = (TextView) inflate.findViewById(R.id.dhv);
                    gameBlockView.xOX.xPb = (TextView) inflate.findViewById(R.id.ddn);
                    gameBlockView.xOX.xPc = (GameDownloadView) inflate.findViewById(R.id.dfc);
                    com.tencent.mm.plugin.game.e.e.dWR().c(gameBlockView.xOX.xOL, cVar.field_appId, com.tencent.mm.cb.a.getDensity(gameBlockView.getContext()));
                    String str = cVar.field_appName;
                    if (!Util.isNullOrNil(cVar.field_appName) && cVar.field_appName.length() > 8) {
                        str = cVar.field_appName.substring(0, 7) + "...";
                    }
                    gameBlockView.xOX.xOM.setText(str);
                    if (!Util.isNullOrNil(cVar.xDV)) {
                        gameBlockView.xOX.xPb.setText(cVar.xDV);
                        gameBlockView.xOX.xPb.setVisibility(0);
                    } else {
                        gameBlockView.xOX.xPb.setVisibility(8);
                    }
                    gameBlockView.xOX.xPc.setDownloadInfo(new l(cVar));
                    gameBlockView.xOX.xPa.setOnClickListener(gameBlockView.xOW);
                    gameBlockView.xOX.xPa.setTag(cVar);
                    gameBlockView.tmh.addView(inflate);
                    f fVar = new f(gameBlockView.getContext());
                    fVar.a(aVar2.xHo, aVar2.xHm.field_appId, i2, i10);
                    gameBlockView.tmh.addView(fVar, gameBlockView.xOV);
                    e eVar = new e(gameBlockView.getContext());
                    eVar.a(aVar2.xHn, aVar2.xHm.field_appId, i2, i10);
                    gameBlockView.tmh.addView(eVar, gameBlockView.xOV);
                    if (aVar2.xHp != null) {
                        ImageView imageView2 = (ImageView) gameBlockView.mInflater.inflate(R.layout.aq2, (ViewGroup) gameBlockView, false);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
                        marginLayoutParams.leftMargin = com.tencent.mm.cb.a.fromDPToPix(gameBlockView.getContext(), 20);
                        imageView2.setLayoutParams(marginLayoutParams);
                        gameBlockView.addView(imageView2);
                        gameBlockView.mInflater.inflate(R.layout.aox, (ViewGroup) gameBlockView, true);
                        View findViewById = gameBlockView.findViewById(R.id.fkj);
                        ((TextView) gameBlockView.findViewById(R.id.fky)).setText(aVar2.xHp.Desc);
                        findViewById.setTag(aVar2.xHp.xIy);
                        findViewById.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x05b1: INVOKE  
                              (r2v37 'findViewById' android.view.View)
                              (wrap: android.view.View$OnClickListener : 0x05ae: CONSTRUCTOR  (r1v112 android.view.View$OnClickListener) = (r8v2 'gameBlockView' com.tencent.mm.plugin.game.ui.GameBlockView), (r6v1 'i10' int) call: com.tencent.mm.plugin.game.ui.GameBlockView.1.<init>(com.tencent.mm.plugin.game.ui.GameBlockView, int):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.tencent.mm.plugin.game.ui.GameCenterUI5.a(com.tencent.mm.plugin.game.ui.GameCenterUI5, com.tencent.mm.plugin.game.model.ac, int):void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x05ae: CONSTRUCTOR  (r1v112 android.view.View$OnClickListener) = (r8v2 'gameBlockView' com.tencent.mm.plugin.game.ui.GameBlockView), (r6v1 'i10' int) call: com.tencent.mm.plugin.game.ui.GameBlockView.1.<init>(com.tencent.mm.plugin.game.ui.GameBlockView, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.game.ui.GameCenterUI5.a(com.tencent.mm.plugin.game.ui.GameCenterUI5, com.tencent.mm.plugin.game.model.ac, int):void, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 36 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.game.ui.GameBlockView, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 42 more
                            */
                        /*
                        // Method dump skipped, instructions count: 1533
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.GameCenterUI5.a(com.tencent.mm.plugin.game.ui.GameCenterUI5, com.tencent.mm.plugin.game.model.ac, int):void");
                    }
                }
