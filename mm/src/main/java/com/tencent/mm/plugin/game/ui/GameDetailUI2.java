package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.plugin.game.protobuf.ae;
import com.tencent.mm.plugin.game.protobuf.af;
import com.tencent.mm.plugin.game.protobuf.ci;
import com.tencent.mm.plugin.game.protobuf.dr;
import com.tencent.mm.plugin.game.ui.GameDetailRankUI;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameDetailUI2 extends MMActivity implements i {
    private String appId = null;
    private Dialog rAV;
    private c xEP = null;
    private int xGR = 0;
    private String xQA = null;
    private String xQB = null;
    private int xQD = 18;
    private boolean xQE;
    private boolean xQF;
    private String xQG = null;
    private k.a xQH = null;
    private d xQI = null;
    private l xQJ = null;
    private ViewGroup xQK;
    private ImageView xQL;
    private ImageView xQM;
    private TextView xQN;
    private Button xQO;
    private TextProgressBar xQP;
    private TextView xQQ;
    private LinearLayout xQR;
    private GameDetailAutoScrollView xQS;
    private LinearLayout xQT;
    private TextView xQU;
    private LinearLayout xQV;
    private TextView xQW;
    private LinearLayout xQX;
    private ImageView xQY;
    private View xQZ;
    private TextView xRa;
    private TextView xRb;
    private View xRc;
    private TextView xRd;
    private ImageView xRe;
    private TextView xRf;
    private TextView xRg;
    private LinearLayout xRh;
    private GameMediaList xRi;
    private TextView xRj;
    private TextView xRk;
    private TextView xRl;
    private boolean xRm = false;
    private LinearLayout xRn;
    private TextView xRo;
    private LinearLayout xRp;
    private TextView xRq;
    private dr xRr;
    private DialogInterface.OnClickListener xRs = new DialogInterface.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass15 */

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(42026);
            GameDetailUI2.this.xQJ.cCq();
            GameDetailUI2.this.xQI.a(GameDetailUI2.this.xQP, GameDetailUI2.this.xQO, GameDetailUI2.this.xEP, GameDetailUI2.this.xQJ);
            AppMethodBeat.o(42026);
        }
    };
    private View.OnClickListener xRt = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass16 */

        public final void onClick(View view) {
            AppMethodBeat.i(42027);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (GameDetailUI2.this.xEP == null) {
                Log.e("MicroMsg.GameDetailUI2", "Null appInfo");
                a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42027);
            } else if (GameDetailUI2.this.xQJ == null) {
                Log.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
                a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42027);
            } else {
                GameDetailUI2.this.xQJ.gi(GameDetailUI2.this.getContext());
                GameDetailUI2.this.xQI.a(GameDetailUI2.this.xEP, GameDetailUI2.this.xQJ);
                a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42027);
            }
        }
    };
    private View.OnClickListener xRu = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass17 */

        public final void onClick(View view) {
            AppMethodBeat.i(42028);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof String) {
                com.tencent.mm.plugin.game.e.c.a(view, GameDetailUI2.this);
                f.a(GameDetailUI2.this.getContext(), 12, TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.xGR, null);
            } else {
                GameDetailRankUI.a aVar = new GameDetailRankUI.a();
                aVar.xQA = GameDetailUI2.this.xQA;
                aVar.xQB = GameDetailUI2.this.xQB;
                aVar.xQC = GameDetailUI2.this.xEP;
                String JX = ad.JX("rankData");
                ad.aVe().G(JX, true).l(GameDetailRankUI.xQy, aVar);
                Intent intent = new Intent(GameDetailUI2.this.getContext(), GameDetailRankUI.class);
                intent.putExtra(GameDetailRankUI.EXTRA_SESSION_ID, JX);
                GameDetailUI2 gameDetailUI2 = GameDetailUI2.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(gameDetailUI2, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                gameDetailUI2.startActivity((Intent) bl.pG(0));
                a.a(gameDetailUI2, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                f.a(GameDetailUI2.this.getContext(), 12, TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED, 999, 6, GameDetailUI2.this.appId, GameDetailUI2.this.xGR, null);
            }
            a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42028);
        }
    };
    private View.OnClickListener xRv = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(42011);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.game.e.c.a(view, GameDetailUI2.this);
            f.a(GameDetailUI2.this.getContext(), 12, TXLiteAVCode.WARNING_MICROPHONE_DEVICE_ABNORMAL, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.xGR, null);
            a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42011);
        }
    };
    private View.OnClickListener xRw = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(42012);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.game.e.c.a(view, GameDetailUI2.this);
            f.a(GameDetailUI2.this.getContext(), 12, TXLiteAVCode.WARNING_SPEAKER_DEVICE_ABNORMAL, 1, 7, GameDetailUI2.this.appId, GameDetailUI2.this.xGR, null);
            a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42012);
        }
    };
    private View.OnClickListener xRx = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(42013);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.game.e.c.a(view, GameDetailUI2.this);
            f.a(GameDetailUI2.this.getContext(), 12, TXLiteAVCode.WARNING_SPEAKER_DEVICE_ABNORMAL, 999, 7, GameDetailUI2.this.appId, GameDetailUI2.this.xGR, null);
            a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42013);
        }
    };
    private View.OnClickListener xRy = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(42014);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.game.e.c.a(view, GameDetailUI2.this);
            f.a(GameDetailUI2.this.getContext(), 12, 1206, 1, 7, GameDetailUI2.this.appId, GameDetailUI2.this.xGR, null);
            a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(42014);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameDetailUI2() {
        AppMethodBeat.i(42029);
        AppMethodBeat.o(42029);
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2) {
        AppMethodBeat.i(42043);
        gameDetailUI2.goBack();
        AppMethodBeat.o(42043);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(42030);
        super.onCreate(bundle);
        if (!g.aAc()) {
            Log.e("MicroMsg.GameDetailUI2", "account not ready");
            finish();
            AppMethodBeat.o(42030);
            return;
        }
        this.xQE = true;
        this.xQF = false;
        this.appId = getIntent().getStringExtra("game_app_id");
        if (Util.isNullOrNil(this.appId)) {
            Log.e("MicroMsg.GameDetailUI2", "appid is null or nill");
            finish();
        } else {
            this.xGR = getIntent().getIntExtra("game_report_from_scene", 0);
        }
        initView();
        g.azz().a(1217, this);
        final byte[] azn = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSL().azn(this.appId);
        if (azn == null || azn.length == 0) {
            Log.i("MicroMsg.GameDetailUI2", "No cache found");
            z = false;
        } else {
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(42022);
                    final z zVar = new z(azn);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass12.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42021);
                            GameDetailUI2.a(GameDetailUI2.this, zVar);
                            AppMethodBeat.o(42021);
                        }
                    });
                    AppMethodBeat.o(42022);
                }
            });
            z = true;
        }
        if (!z) {
            this.rAV = com.tencent.mm.plugin.game.e.c.gl(this);
            this.rAV.show();
        }
        g.azz().a(new am(LocaleUtil.getApplicationLanguage(), this.appId, h.s(this, this.appId)), 0);
        AppMethodBeat.o(42030);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.apo;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(42031);
        super.onResume();
        if (!(this.xEP == null || this.xQJ == null)) {
            this.xQJ.cCq();
            this.xQI.a(this.xQP, this.xQO, this.xEP, this.xQJ);
        }
        if (!this.xQE) {
            b(new aa(this.appId));
            AppMethodBeat.o(42031);
            return;
        }
        this.xQE = false;
        AppMethodBeat.o(42031);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42032);
        super.onDestroy();
        g.azz().b(1217, this);
        if (this.xQH != null) {
            k.b(this.xQH);
        }
        AppMethodBeat.o(42032);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(42033);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(42033);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(42033);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(42034);
        dWn();
        finish();
        AppMethodBeat.o(42034);
    }

    private void dWn() {
        AppMethodBeat.i(42035);
        String stringExtra = getIntent().getStringExtra("jump_game_center");
        if (!Util.isNullOrNil(stringExtra) && stringExtra.equals("jump_game_center")) {
            Intent intent = new Intent(this, GameCenterUI.class);
            intent.putExtra("jump_find_more_friends", "jump_find_more_friends");
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            a.a(this, bl.axQ(), "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2", "backToGameCenterUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(42035);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42036);
        setMMTitle(R.string.doh);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42010);
                GameDetailUI2.a(GameDetailUI2.this);
                AppMethodBeat.o(42010);
                return true;
            }
        });
        this.xQK = (ViewGroup) findViewById(R.id.ddp);
        this.xQL = (ImageView) findViewById(R.id.ddq);
        this.xQM = (ImageView) findViewById(R.id.dg3);
        this.xQN = (TextView) findViewById(R.id.dhv);
        this.xQQ = (TextView) findViewById(R.id.dg_);
        this.xQO = (Button) findViewById(R.id.dcv);
        this.xQP = (TextProgressBar) findViewById(R.id.did);
        this.xQP.setTextSize(this.xQD);
        this.xQR = (LinearLayout) findViewById(R.id.df4);
        this.xQS = (GameDetailAutoScrollView) findViewById(R.id.df3);
        this.xQT = (LinearLayout) findViewById(R.id.del);
        this.xQU = (TextView) findViewById(R.id.den);
        this.xQV = (LinearLayout) findViewById(R.id.ddy);
        this.xQW = (TextView) findViewById(R.id.de7);
        this.xQX = (LinearLayout) findViewById(R.id.ddz);
        this.xQY = (ImageView) findViewById(R.id.de0);
        this.xQZ = findViewById(R.id.de1);
        this.xRa = (TextView) findViewById(R.id.de3);
        this.xRb = (TextView) findViewById(R.id.de2);
        this.xRc = findViewById(R.id.de8);
        this.xRd = (TextView) findViewById(R.id.deb);
        this.xRe = (ImageView) findViewById(R.id.dea);
        this.xRf = (TextView) findViewById(R.id.de9);
        this.xRg = (TextView) findViewById(R.id.de_);
        this.xRh = (LinearLayout) findViewById(R.id.ddt);
        this.xRi = (GameMediaList) findViewById(R.id.dek);
        GameMediaList gameMediaList = this.xRi;
        String str = this.appId;
        int i2 = this.xGR;
        gameMediaList.appId = str;
        gameMediaList.sQn = 12;
        gameMediaList.xSP = i2;
        gameMediaList.mContext = this;
        this.xRi.setItemLayout(R.layout.ari);
        this.xRj = (TextView) findViewById(R.id.ddw);
        this.xRk = (TextView) findViewById(R.id.ddu);
        this.xRk.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass10 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(42019);
                if (GameDetailUI2.this.xRk.getLineCount() > 3) {
                    GameDetailUI2.this.xRl.setVisibility(0);
                    AppMethodBeat.o(42019);
                    return;
                }
                GameDetailUI2.this.xRl.setVisibility(8);
                AppMethodBeat.o(42019);
            }
        });
        this.xRl = (TextView) findViewById(R.id.ddx);
        this.xRl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(42020);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!GameDetailUI2.this.xRm) {
                    GameDetailUI2.this.xRk.setMaxLines(100);
                    GameDetailUI2.this.xRl.setText(GameDetailUI2.this.getResources().getText(R.string.do4));
                    GameDetailUI2.this.xRm = true;
                } else {
                    GameDetailUI2.this.xRk.setMaxLines(3);
                    GameDetailUI2.this.xRl.setText(GameDetailUI2.this.getResources().getText(R.string.do3));
                    GameDetailUI2.this.xRm = false;
                }
                a.a(this, "com/tencent/mm/plugin/game/ui/GameDetailUI2$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(42020);
            }
        });
        this.xRn = (LinearLayout) findViewById(R.id.dec);
        this.xRo = (TextView) findViewById(R.id.dej);
        this.xRp = (LinearLayout) findViewById(R.id.ded);
        this.xRq = (TextView) findViewById(R.id.dee);
        AppMethodBeat.o(42036);
    }

    private void a(z zVar) {
        AppMethodBeat.i(42038);
        LinkedList<ae> linkedList = null;
        if (zVar.xGZ.xHa == null || zVar.xGZ.xHa.size() == 0) {
            linkedList = zVar.xGX.xLs;
        }
        if (linkedList == null || linkedList.size() == 0) {
            this.xQR.setVisibility(8);
            AppMethodBeat.o(42038);
            return;
        }
        this.xQR.setVisibility(0);
        this.xQR.removeAllViews();
        Iterator<ae> it = linkedList.iterator();
        while (it.hasNext()) {
            ae next = it.next();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.apz, (ViewGroup) this.xQR, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.df6);
            TextView textView = (TextView) inflate.findViewById(R.id.df7);
            TextView textView2 = (TextView) inflate.findViewById(R.id.df5);
            if (!Util.isNullOrNil(next.UserName)) {
                a.b.a(imageView, next.UserName, 0.5f, false);
            } else {
                c.a aVar = new c.a();
                aVar.iaT = true;
                q.bcV().a(next.xIJ, imageView, aVar.bdv());
            }
            textView.setText(next.Title);
            textView2.setText(next.xKd);
            this.xQR.addView(inflate);
        }
        AppMethodBeat.o(42038);
    }

    private void b(z zVar) {
        int i2;
        z.a aVar;
        AppMethodBeat.i(42039);
        if (zVar.dVF() == null || zVar.dVF().isEmpty()) {
            this.xQV.setVisibility(8);
            AppMethodBeat.o(42039);
            return;
        }
        this.xQV.setVisibility(0);
        if (!Util.isNullOrNil(zVar.dVE())) {
            this.xQW.setVisibility(0);
            this.xQW.setText(zVar.dVE());
        } else {
            this.xQW.setVisibility(8);
        }
        this.xQX.removeAllViews();
        if (zVar.dVG() == 1) {
            this.xQX.setOrientation(1);
            this.xQY.setVisibility(8);
            i2 = R.layout.apr;
        } else {
            this.xQX.setOrientation(0);
            this.xQY.setVisibility(0);
            i2 = R.layout.apq;
        }
        LinkedList<z.b> dVF = zVar.dVF();
        if (dVF != null) {
            Iterator<z.b> it = dVF.iterator();
            while (it.hasNext()) {
                z.b next = it.next();
                View inflate = LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) this.xQX, false);
                q.bcV().loadImage(next.icon, (ImageView) inflate.findViewById(R.id.de5));
                if (zVar.dVG() == 1) {
                    ((TextView) inflate.findViewById(R.id.de6)).setText(next.title);
                }
                ((TextView) inflate.findViewById(R.id.de4)).setText(next.desc);
                if (zVar.dVG() == 1) {
                    inflate.setTag(next.url);
                    inflate.setOnClickListener(this.xRv);
                }
                this.xQX.addView(inflate);
            }
        }
        if (zVar.xGX.xLA != null) {
            aVar = new z.a();
            aVar.title = zVar.xGX.xLA.summary;
            aVar.desc = zVar.xGX.xLA.desc;
            aVar.url = zVar.xGX.xLA.url;
        } else if (zVar.xGX.xLv == null || Util.isNullOrNil(zVar.xGX.xLv.xMj) || Util.isNullOrNil(zVar.xGX.xLv.xMk)) {
            aVar = null;
        } else {
            aVar = new z.a();
            aVar.title = zVar.xGX.xLv.xMj;
            aVar.url = zVar.xGX.xLv.xMk;
        }
        if (aVar != null) {
            this.xQZ.setVisibility(0);
            this.xRa.setText(aVar.title);
            if (!Util.isNullOrNil(aVar.desc)) {
                this.xRb.setVisibility(0);
                this.xRb.setText(aVar.desc);
            } else {
                this.xRb.setVisibility(8);
            }
            this.xQZ.setTag(aVar.url);
            this.xQZ.setOnClickListener(this.xRv);
            AppMethodBeat.o(42039);
            return;
        }
        this.xQZ.setVisibility(8);
        AppMethodBeat.o(42039);
    }

    private void c(z zVar) {
        Pair pair;
        AppMethodBeat.i(42040);
        if (zVar.dVK() == null || zVar.dVK().isEmpty()) {
            this.xRn.setVisibility(8);
            AppMethodBeat.o(42040);
            return;
        }
        this.xRn.setVisibility(0);
        if (!Util.isNullOrNil(zVar.dVJ())) {
            this.xRo.setVisibility(0);
            this.xRo.setText(zVar.dVJ());
        } else {
            this.xRo.setVisibility(8);
        }
        this.xRp.removeAllViews();
        this.xRp.setOnClickListener(null);
        Iterator<ci> it = zVar.dVK().iterator();
        while (it.hasNext()) {
            ci next = it.next();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.aps, (ViewGroup) this.xRp, false);
            ((TextView) inflate.findViewById(R.id.deh)).setText(next.xMo);
            ((TextView) inflate.findViewById(R.id.dei)).setText(next.Title);
            ((TextView) inflate.findViewById(R.id.def)).setText(next.xKd);
            q.bcV().loadImage(next.xMl, (ImageView) inflate.findViewById(R.id.deg));
            inflate.setTag(next.xIB);
            inflate.setOnClickListener(this.xRw);
            this.xRp.addView(inflate);
        }
        if (zVar.xGX.xLv == null) {
            pair = null;
        } else if (Util.isNullOrNil(zVar.xGX.xLu.Title) || Util.isNullOrNil(zVar.xGX.xLu.xMk)) {
            pair = null;
        } else {
            pair = new Pair(zVar.xGX.xLu.xMj, zVar.xGX.xLu.xMk);
        }
        if (pair != null) {
            this.xRq.setVisibility(0);
            this.xRq.setText((CharSequence) pair.first);
            this.xRq.setTag(pair.second);
            this.xRq.setOnClickListener(this.xRx);
            AppMethodBeat.o(42040);
            return;
        }
        this.xRq.setVisibility(8);
        AppMethodBeat.o(42040);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(42041);
        if (i2 == 0 && i3 == 0) {
            switch (qVar.getType()) {
                case 1217:
                    final com.tencent.mm.bw.a aVar = ((am) qVar).hhm.iLL.iLR;
                    g.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass14 */

                        public final void run() {
                            AppMethodBeat.i(42025);
                            final z zVar = new z(aVar);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass14.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(42024);
                                    GameDetailUI2.a(GameDetailUI2.this, zVar);
                                    if (GameDetailUI2.this.rAV != null) {
                                        GameDetailUI2.this.rAV.dismiss();
                                    }
                                    AppMethodBeat.o(42024);
                                }
                            });
                            AppMethodBeat.o(42025);
                        }
                    });
                    break;
            }
            AppMethodBeat.o(42041);
            return;
        }
        if (!com.tencent.mm.plugin.game.a.a.jRu.a(this, i2, i3, str)) {
            Toast.makeText(this, getString(R.string.dqd, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        }
        if (this.rAV != null) {
            this.rAV.cancel();
        }
        AppMethodBeat.o(42041);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(42042);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.GameDetailUI2", "requestCode = %d, resultCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        switch (i2) {
            case 1:
                switch (i3) {
                    case 0:
                        AppMethodBeat.o(42042);
                        return;
                    case 1:
                    default:
                        AppMethodBeat.o(42042);
                        return;
                    case 2:
                        if (!(this.xEP == null || this.xQJ == null)) {
                            this.xQJ.dVj();
                            this.xQI.a(this.xEP, this.xQJ);
                            AppMethodBeat.o(42042);
                            return;
                        }
                    case 3:
                        if (this.xQJ != null) {
                            this.xQJ.cCq();
                            AppMethodBeat.o(42042);
                            return;
                        }
                        break;
                }
                break;
            case 2:
                if (i3 == -1) {
                    final String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!Util.isNullOrNil(stringExtra)) {
                        String str = this.xRr.xIJ;
                        if (Util.isNullOrNil(str)) {
                            str = this.xEP.field_appIconUrl;
                        }
                        ab.a.Kgn.a(this.mController, this.xRr.xNi, str, this.xRr.xNj, true, getResources().getString(R.string.yq), new y.a() {
                            /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass9 */

                            @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                            public final void a(boolean z, String str, int i2) {
                                AppMethodBeat.i(42018);
                                if (z) {
                                    GameDetailUI2.a(GameDetailUI2.this, stringExtra, str);
                                    com.tencent.mm.ui.base.h.cD(GameDetailUI2.this, GameDetailUI2.this.getResources().getString(R.string.b99));
                                    f.a(GameDetailUI2.this.getContext(), 12, 1207, 2, 14, GameDetailUI2.this.appId, GameDetailUI2.this.xGR, null);
                                    AppMethodBeat.o(42018);
                                    return;
                                }
                                AppMethodBeat.o(42018);
                            }
                        });
                    }
                    AppMethodBeat.o(42042);
                    return;
                }
                break;
            case 3:
                if (i3 == -1) {
                    f.a(getContext(), 12, 1207, 2, 15, this.appId, this.xGR, null);
                    AppMethodBeat.o(42042);
                    return;
                }
                break;
            default:
                Log.e("MicroMsg.GameDetailUI2", "error request code");
                AppMethodBeat.o(42042);
                return;
        }
        AppMethodBeat.o(42042);
    }

    private void b(aa aaVar) {
        int i2 = 0;
        AppMethodBeat.i(42037);
        List<aa.a> list = aaVar.xHa;
        if (list == null || list.size() == 0) {
            this.xQT.setVisibility(8);
            this.xQU.setVisibility(8);
            AppMethodBeat.o(42037);
            return;
        }
        this.xQT.setVisibility(0);
        if (list.size() > 3) {
            this.xQU.setVisibility(0);
        } else {
            this.xQU.setVisibility(8);
        }
        this.xQT.removeAllViews();
        i iVar = new i(getContext());
        iVar.Ve = R.layout.apw;
        iVar.a(aaVar);
        iVar.xGR = this.xGR;
        while (i2 < list.size() && i2 < 3) {
            this.xQT.addView(iVar.getView(i2, null, this.xQR));
            i2++;
        }
        AppMethodBeat.o(42037);
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, z zVar) {
        String str;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(42044);
        if (gameDetailUI2.isFinishing()) {
            Log.w("MicroMsg.GameDetailUI2", "GameDetailUI2 hasFinished");
            AppMethodBeat.o(42044);
        } else if (zVar == null) {
            Log.e("MicroMsg.GameDetailUI2", "Null data");
            AppMethodBeat.o(42044);
        } else {
            gameDetailUI2.xEP = zVar.xGY;
            if (zVar.xGX.xLw == null) {
                str = null;
            } else if (Util.isNullOrNil(zVar.xGX.xLw.xNa)) {
                str = null;
            } else {
                str = zVar.xGX.xLw.xNa;
            }
            gameDetailUI2.xQA = str;
            if (zVar.xGX.xLw == null) {
                str2 = null;
            } else if (Util.isNullOrNil(zVar.xGX.xLw.xNb)) {
                str2 = null;
            } else {
                str2 = zVar.xGX.xLw.xNb;
            }
            gameDetailUI2.xQB = str2;
            if (!gameDetailUI2.xQF) {
                gameDetailUI2.xQF = true;
                f.a(gameDetailUI2, 12, 1200, 0, 1, gameDetailUI2.appId, gameDetailUI2.xGR, null);
            }
            com.tencent.mm.plugin.game.model.c cVar = zVar.xGY;
            com.tencent.mm.av.a.a bcV = q.bcV();
            String str5 = zVar.xGX.xLr;
            ImageView imageView = gameDetailUI2.xQL;
            c.a aVar = new c.a();
            aVar.jbe = true;
            bcV.a(str5, imageView, aVar.bdv());
            ImageView imageView2 = gameDetailUI2.xQM;
            String str6 = gameDetailUI2.appId;
            float density = com.tencent.mm.cb.a.getDensity(gameDetailUI2);
            if (imageView2 != null && !Util.isNullOrNil(str6)) {
                Bitmap c2 = h.c(str6, 1, density);
                if (c2 == null || c2.isRecycled()) {
                    imageView2.setImageResource(R.drawable.beg);
                    com.tencent.mm.plugin.r.a.eAS().add(new MStorage.IOnStorageChange(str6, density, imageView2) {
                        /* class com.tencent.mm.plugin.game.ui.j.a.AnonymousClass1 */
                        final /* synthetic */ float cwE;
                        final /* synthetic */ ImageView rCk;
                        final /* synthetic */ String val$appId;

                        {
                            this.val$appId = r1;
                            this.cwE = r2;
                            this.rCk = r3;
                        }

                        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
                        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                            Bitmap c2;
                            AppMethodBeat.i(42077);
                            if (this.val$appId.equals(str) && (c2 = h.c(this.val$appId, 1, this.cwE)) != null) {
                                this.rCk.setImageBitmap(c2);
                                com.tencent.mm.plugin.r.a.eAS().remove(this);
                            }
                            AppMethodBeat.o(42077);
                        }
                    });
                } else {
                    imageView2.setImageBitmap(c2);
                }
            }
            gameDetailUI2.xQN.setText(cVar != null ? cVar.field_appName : "");
            if (cVar == null || Util.isNullOrNil(cVar.xDU)) {
                gameDetailUI2.xQQ.setVisibility(8);
            } else {
                gameDetailUI2.xQQ.setText(cVar.xDU);
                gameDetailUI2.xQQ.setVisibility(0);
            }
            if (gameDetailUI2.xEP == null) {
                gameDetailUI2.xQO.setVisibility(8);
            } else {
                gameDetailUI2.xQO.setVisibility(0);
                if (gameDetailUI2.xQI == null) {
                    gameDetailUI2.xQI = new d(gameDetailUI2);
                    gameDetailUI2.xQI.xOA = gameDetailUI2.xRs;
                    gameDetailUI2.xQI.xGR = gameDetailUI2.xGR;
                    gameDetailUI2.xQI.xOl = gameDetailUI2.xQG;
                }
                gameDetailUI2.xQO.setOnClickListener(gameDetailUI2.xRt);
                gameDetailUI2.xQP.setOnClickListener(gameDetailUI2.xRt);
                gameDetailUI2.xQJ = new l(gameDetailUI2.xEP);
                gameDetailUI2.xQJ.gi(gameDetailUI2);
                gameDetailUI2.xQJ.cCq();
                gameDetailUI2.xQI.a(gameDetailUI2.xQP, gameDetailUI2.xQO, gameDetailUI2.xEP, gameDetailUI2.xQJ);
                Log.i("MicroMsg.GameDetailUI2", "App Status: %d, Download Mode: %d, Download Status: %d", Integer.valueOf(gameDetailUI2.xEP.status), Integer.valueOf(gameDetailUI2.xQJ.mode), Integer.valueOf(gameDetailUI2.xQJ.status));
                if (!Util.isNullOrNil(gameDetailUI2.appId)) {
                    if (gameDetailUI2.xQH != null) {
                        k.a(gameDetailUI2.xQH);
                    } else {
                        gameDetailUI2.xQH = new k.a() {
                            /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass6 */

                            @Override // com.tencent.mm.plugin.game.model.k.a
                            public final void e(int i2, String str, boolean z) {
                                AppMethodBeat.i(42015);
                                if (GameDetailUI2.this.xEP != null) {
                                    GameDetailUI2.this.xQJ.gi(GameDetailUI2.this);
                                    GameDetailUI2.this.xQJ.cCq();
                                    if (z) {
                                        GameDetailUI2.this.xQI.a(GameDetailUI2.this.xQP, GameDetailUI2.this.xQO, GameDetailUI2.this.xEP, GameDetailUI2.this.xQJ);
                                    }
                                }
                                AppMethodBeat.o(42015);
                            }
                        };
                        k.a(gameDetailUI2.xQH);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            if (zVar.xGX.xLx != null) {
                Iterator<af> it = zVar.xGX.xLx.iterator();
                while (it.hasNext()) {
                    af next = it.next();
                    if (!Util.isNullOrNil(next.UserName)) {
                        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(next.UserName);
                        if (Kn == null || Kn.gMZ == 0) {
                            arrayList.add(next.UserName + " ");
                        } else {
                            arrayList.add(Kn.arJ() + " ");
                        }
                    } else {
                        arrayList.add("");
                    }
                    arrayList.add(next.xKd);
                }
            }
            if (arrayList.size() != 0) {
                gameDetailUI2.xQS.setVisibility(0);
                gameDetailUI2.xQS.setText(arrayList);
            } else {
                gameDetailUI2.xQS.setVisibility(8);
            }
            gameDetailUI2.b(zVar.xGZ);
            if (zVar.xGX.xLw == null) {
                str3 = null;
            } else if (Util.isNullOrNil(zVar.xGX.xLw.xMj)) {
                str3 = null;
            } else {
                str3 = zVar.xGX.xLw.xMj;
            }
            if (zVar.xGX.xLw == null) {
                str4 = null;
            } else if (Util.isNullOrNil(zVar.xGX.xLw.xMk)) {
                str4 = null;
            } else {
                str4 = zVar.xGX.xLw.xMk;
            }
            if (!Util.isNullOrNil(str3)) {
                gameDetailUI2.xQU.setText(str3);
                if (!Util.isNullOrNil(str4)) {
                    gameDetailUI2.xQU.setTag(str4);
                } else {
                    gameDetailUI2.xQU.setTag(null);
                }
                gameDetailUI2.xQU.setOnClickListener(gameDetailUI2.xRu);
            } else {
                gameDetailUI2.xQU.setVisibility(8);
            }
            gameDetailUI2.a(zVar);
            gameDetailUI2.b(zVar);
            if (Util.isNullOrNil(zVar.dVH()) || Util.isNullOrNil(zVar.dVI())) {
                gameDetailUI2.xRh.setVisibility(8);
            } else {
                gameDetailUI2.xRh.setVisibility(0);
                gameDetailUI2.xRi.setMediaList(zVar.getMediaList());
                gameDetailUI2.xRj.setText(zVar.dVH());
                gameDetailUI2.xRk.setText(zVar.dVI());
            }
            if (zVar.xGX.xLz == null) {
                gameDetailUI2.xRc.setVisibility(8);
            } else {
                gameDetailUI2.xRc.setVisibility(0);
                gameDetailUI2.xRd.setText(zVar.xGX.xLz.title);
                q.bcV().loadImage(zVar.xGX.xLz.ivw, gameDetailUI2.xRe);
                gameDetailUI2.xRf.setText(zVar.xGX.xLz.qGG);
                gameDetailUI2.xRg.setText(zVar.xGX.xLz.desc);
                ((ViewGroup) gameDetailUI2.xRf.getParent().getParent()).setTag(zVar.xGX.xLz.xMm);
                ((ViewGroup) gameDetailUI2.xRf.getParent().getParent()).setOnClickListener(gameDetailUI2.xRy);
            }
            gameDetailUI2.c(zVar);
            gameDetailUI2.xRr = zVar.xGX.xLy;
            if (gameDetailUI2.xRr == null || (!gameDetailUI2.xRr.xNl && !gameDetailUI2.xRr.xNm)) {
                super.removeAllOptionMenu();
            } else {
                super.addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass13 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(42023);
                        GameDetailUI2.a(GameDetailUI2.this, GameDetailUI2.this.xRr);
                        f.a(GameDetailUI2.this.getContext(), 12, 1207, 1, 2, GameDetailUI2.this.appId, GameDetailUI2.this.xGR, null);
                        AppMethodBeat.o(42023);
                        return false;
                    }
                });
            }
            gameDetailUI2.xQK.removeView(gameDetailUI2.xRh);
            gameDetailUI2.xQK.removeView(gameDetailUI2.xRc);
            gameDetailUI2.xQK.removeView(gameDetailUI2.xRn);
            if (zVar.xGY.status == 1) {
                gameDetailUI2.xQK.addView(gameDetailUI2.xRc);
                gameDetailUI2.xQK.addView(gameDetailUI2.xRh);
            } else {
                gameDetailUI2.xQK.addView(gameDetailUI2.xRh);
                gameDetailUI2.xQK.addView(gameDetailUI2.xRc);
            }
            gameDetailUI2.xQK.addView(gameDetailUI2.xRn);
            AppMethodBeat.o(42044);
        }
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, final dr drVar) {
        AppMethodBeat.i(42045);
        e eVar = new e((Context) gameDetailUI2.getContext(), 1, false);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(42016);
                if (drVar.xNl) {
                    mVar.b(0, GameDetailUI2.this.getString(R.string.dse), R.raw.bottomsheet_icon_transmit);
                }
                if (drVar.xNm) {
                    mVar.b(1, GameDetailUI2.this.getString(R.string.dsk), R.raw.bottomsheet_icon_moment);
                }
                AppMethodBeat.o(42016);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.game.ui.GameDetailUI2.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(42017);
                switch (menuItem.getItemId()) {
                    case 0:
                        GameDetailUI2.p(GameDetailUI2.this);
                        AppMethodBeat.o(42017);
                        return;
                    case 1:
                        GameDetailUI2.q(GameDetailUI2.this);
                        break;
                }
                AppMethodBeat.o(42017);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(42045);
    }

    static /* synthetic */ void p(GameDetailUI2 gameDetailUI2) {
        AppMethodBeat.i(42046);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
        intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
        com.tencent.mm.br.c.c(gameDetailUI2, ".ui.transmit.SelectConversationUI", intent, 2);
        gameDetailUI2.getContext().overridePendingTransition(R.anim.dq, R.anim.bs);
        AppMethodBeat.o(42046);
    }

    static /* synthetic */ void q(GameDetailUI2 gameDetailUI2) {
        AppMethodBeat.i(42047);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", gameDetailUI2.xRr.xNk);
        String str = gameDetailUI2.xRr.xIJ;
        if (Util.isNullOrNil(str)) {
            str = gameDetailUI2.xEP.field_appIconUrl;
        }
        intent.putExtra("Ksnsupload_imgurl", str);
        intent.putExtra("Ksnsupload_link", gameDetailUI2.xRr.xIB);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        String JX = ad.JX("game_center");
        ad.aVe().G(JX, true).l("prePublishId", "game_center");
        intent.putExtra("reportSessionId", JX);
        com.tencent.mm.br.c.b(gameDetailUI2.getContext(), "sns", ".ui.SnsUploadUI", intent, 3);
        AppMethodBeat.o(42047);
    }

    static /* synthetic */ void a(GameDetailUI2 gameDetailUI2, String str, String str2) {
        AppMethodBeat.i(42048);
        k.b bVar = new k.b();
        bVar.title = gameDetailUI2.xRr.xNi;
        bVar.description = gameDetailUI2.xRr.xNj;
        bVar.type = 5;
        if (Util.isNullOrNil(gameDetailUI2.xRr.xIJ)) {
            bVar.thumburl = gameDetailUI2.xEP.field_appIconUrl;
        } else {
            bVar.thumburl = gameDetailUI2.xRr.xIJ;
        }
        bVar.url = gameDetailUI2.xRr.xIB;
        if (w.a.aSz() != null) {
            w.a.aSz().a(bVar, gameDetailUI2.appId, gameDetailUI2.xEP.field_appName, str, null, null);
        }
        if (!Util.isNullOrNil(str2)) {
            tw twVar = new tw();
            twVar.eaq.dkV = str;
            twVar.eaq.content = str2;
            twVar.eaq.type = com.tencent.mm.model.ab.JG(str);
            twVar.eaq.flags = 0;
            EventCenter.instance.publish(twVar);
        }
        AppMethodBeat.o(42048);
    }
}
