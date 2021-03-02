package com.tencent.mm.plugin.game.ui.chat_tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.game.report.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.protobuf.dk;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.e.a;
import com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI;
import com.tencent.mm.plugin.gamelife.ui.GameLifeEmptyCoverView;
import com.tencent.mm.plugin.gamelife.ui.GameLifeLoadingCoverView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.view.TouchableLayout;
import kotlin.g.b.p;

public class GameChatTabUI extends GameLifeConversationUI {
    private GameTabWidget2 xWR;
    private String xWS;
    private MStorage.IOnStorageChange xWT = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(204191);
            if (mStorageEventData.obj instanceof a) {
                GameChatTabUI.d(GameChatTabUI.this);
            }
            AppMethodBeat.o(204191);
        }
    };
    private com.tencent.mm.pluginsdk.c.a xWU = new com.tencent.mm.pluginsdk.c.a() {
        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI.AnonymousClass6 */

        @Override // com.tencent.mm.pluginsdk.c.a
        public final void g(IEvent iEvent) {
            AppMethodBeat.i(204192);
            if (iEvent instanceof iy) {
                GameChatTabUI.e(GameChatTabUI.this);
                GameChatTabUI.d(GameChatTabUI.this);
            }
            AppMethodBeat.o(204192);
        }
    };
    private BroadcastReceiver xWV = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI.AnonymousClass7 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(204193);
            if (intent != null && "com.tencent.mm.game.ACTION_EXIT".equals(intent.getAction()) && GameChatTabUI.this != null && !GameChatTabUI.this.isFinishing()) {
                Log.i("MicroMsg.GameChatTabUI", "GameWebTabUI exit!");
                GameChatTabUI.this.finish();
            }
            AppMethodBeat.o(204193);
        }
    };

    @Override // com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameChatTabUI() {
        AppMethodBeat.i(204194);
        AppMethodBeat.o(204194);
    }

    static /* synthetic */ void d(GameChatTabUI gameChatTabUI) {
        AppMethodBeat.i(204207);
        gameChatTabUI.dWz();
        AppMethodBeat.o(204207);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onCreate(Bundle bundle) {
        String str;
        boolean z;
        dk dkVar;
        AppMethodBeat.i(204195);
        super.onCreate(bundle);
        Log.i("MicroMsg.GameChatTabUI", "onCreate");
        this.xWR = a.b(this, getContentView());
        this.xWR.post(new Runnable() {
            /* class com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(204187);
                GameChatTabUI.a(GameChatTabUI.this, GameChatTabUI.this.xWR.getHeight());
                AppMethodBeat.o(204187);
            }
        });
        if (com.tencent.mm.plugin.game.commlib.a.dSY() == null || (dkVar = com.tencent.mm.plugin.game.commlib.a.dSY().xKZ) == null) {
            str = null;
        } else {
            str = dkVar.xMs;
        }
        if (Util.isNullOrNil(str)) {
            str = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/gamelife/homepage.html";
        }
        this.xWS = str;
        Log.i("MicroMsg.GameChatTabUI", "profile entrance: %s", this.xWS);
        setMMTitle(R.string.dte);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.game.ACTION_EXIT");
        registerReceiver(this.xWV, intentFilter, com.tencent.mm.plugin.game.a.xtn, null);
        ((c) g.af(c.class)).m(this.xWT);
        com.tencent.mm.pluginsdk.c.a.a(iy.class.getName(), this.xWU);
        View customView = getSupportActionBar().getCustomView();
        if (customView != null && (customView instanceof LinearLayout)) {
            ViewGroup.LayoutParams layoutParams = customView.getLayoutParams();
            layoutParams.width = -1;
            customView.setLayoutParams(layoutParams);
            View inflate = LayoutInflater.from(this).inflate(R.layout.ar_, (ViewGroup) ((LinearLayout) customView), false);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) inflate.getLayoutParams();
            layoutParams2.gravity = 16;
            ((LinearLayout) customView).addView(inflate, layoutParams2);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(204190);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    c.a aVar = com.tencent.mm.game.report.c.hhl;
                    c.a.a(2, 201, 0, 7, (long) GameChatTabUI.this.getIntent().getIntExtra("game_report_from_scene", 0)).bfK();
                    com.tencent.mm.plugin.game.e.c.aQ(GameChatTabUI.this, GameChatTabUI.this.xWS);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/GameChatTabUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(204190);
                }
            });
        }
        setRequestedOrientation(1);
        if (this.xWR != null) {
            this.xWR.dWE();
        }
        boolean aln = ar.aln(getResources().getColor(R.color.afz));
        View contentView = getContentView();
        int color = getResources().getColor(R.color.afz);
        if (!aln) {
            z = true;
        } else {
            z = false;
        }
        com.tencent.mm.ui.statusbar.a.e(contentView, color, z);
        getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.color.afz));
        AppMethodBeat.o(204195);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onResume() {
        AppMethodBeat.i(204196);
        super.onResume();
        dWz();
        if (getIntent().getBooleanExtra("disable_game_tab_home_swipe", false)) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI.AnonymousClass2 */

                public final boolean queueIdle() {
                    AppMethodBeat.i(204188);
                    if (GameChatTabUI.this.isDestroyed() || GameChatTabUI.this.isFinishing()) {
                        AppMethodBeat.o(204188);
                    } else {
                        GameChatTabUI.b(GameChatTabUI.this);
                        AppMethodBeat.o(204188);
                    }
                    return false;
                }
            });
        }
        if (((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_game_life_preload_profile_url, 0) == 1) {
            Log.i("MicroMsg.GameChatTabUI", "preload profile");
            h.RTc.n(new Runnable() {
                /* class com.tencent.mm.plugin.game.ui.chat_tab.GameChatTabUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(204189);
                    if (GameChatTabUI.this.isDestroyed() || GameChatTabUI.this.isFinishing()) {
                        AppMethodBeat.o(204189);
                        return;
                    }
                    GameChatTabUI.aAE(GameChatTabUI.this.xWS);
                    AppMethodBeat.o(204189);
                }
            }, 500);
        }
        AppMethodBeat.o(204196);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onPause() {
        AppMethodBeat.i(204197);
        super.onPause();
        Log.i("MicroMsg.GameChatTabUI", "onPause");
        g.aAh().azQ().set(ar.a.USERINFO_GAME_LIFE_LATEST_MSG_ID_LONG, Long.valueOf(((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dXa().msgId));
        AppMethodBeat.o(204197);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(204198);
        super.onNewIntent(intent);
        overridePendingTransition(R.anim.cd, R.anim.cd);
        Log.i("MicroMsg.GameChatTabUI", "onNewIntent");
        if (intent == null) {
            AppMethodBeat.o(204198);
            return;
        }
        setIntent(intent);
        String stringExtra = intent.getStringExtra("game_tab_key");
        String stringExtra2 = intent.getStringExtra("game_red_dot_tab_key");
        if (this.xWR != null) {
            this.xWR.hP(stringExtra, stringExtra2);
        }
        AppMethodBeat.o(204198);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(204199);
        super.onBackPressed();
        a.gk(this);
        AppMethodBeat.o(204199);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.gamelife.ui.GameLifeChattingCompatUI
    public void onDestroy() {
        AppMethodBeat.i(204200);
        super.onDestroy();
        Log.i("MicroMsg.GameChatTabUI", "onDestroy");
        unregisterReceiver(this.xWV);
        ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).l(this.xWT);
        com.tencent.mm.pluginsdk.c.a.b(iy.class.getName(), this.xWU);
        a.gk(this);
        AppMethodBeat.o(204200);
    }

    @Override // com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI, com.tencent.mm.j.a.c
    public final void onFinish() {
        AppMethodBeat.i(204201);
        a.gk(this);
        AppMethodBeat.o(204201);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(204202);
        super.onConfigurationChanged(configuration);
        setRequestedOrientation(1);
        AppMethodBeat.o(204202);
    }

    private void dWz() {
        boolean z;
        AppMethodBeat.i(204203);
        int dWZ = ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dWZ();
        int NY = ((com.tencent.mm.plugin.game.api.c) g.af(com.tencent.mm.plugin.game.api.c.class)).NY(1);
        int NY2 = ((com.tencent.mm.plugin.game.api.c) g.af(com.tencent.mm.plugin.game.api.c.class)).NY(2);
        Log.d("MicroMsg.GameChatTabUI", "get chat unread count: %d, interactiveUnreadCount:%d, notifyUnreadCount:%d", Integer.valueOf(dWZ), Integer.valueOf(NY), Integer.valueOf(NY2));
        if (this.xWR != null) {
            GameTabWidget2 gameTabWidget2 = this.xWR;
            int i2 = dWZ + NY;
            if (NY2 > 0) {
                z = true;
            } else {
                z = false;
            }
            gameTabWidget2.aA(i2, z);
        }
        AppMethodBeat.o(204203);
    }

    static /* synthetic */ void a(GameChatTabUI gameChatTabUI, int i2) {
        AppMethodBeat.i(204204);
        TouchableLayout touchableLayout = (TouchableLayout) gameChatTabUI._$_findCachedViewById(R.id.be3);
        p.g(touchableLayout, "container");
        ViewGroup.LayoutParams layoutParams = touchableLayout.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = i2;
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = com.tencent.mm.cb.a.fromDPToPix((Context) gameChatTabUI, 152);
        FrameLayout frameLayout = (FrameLayout) gameChatTabUI._$_findCachedViewById(R.id.bfz);
        GameLifeLoadingCoverView gameLifeLoadingCoverView = gameChatTabUI.ydk;
        if (gameLifeLoadingCoverView == null) {
            p.btv("loadingCoverView");
        }
        frameLayout.addView(gameLifeLoadingCoverView, layoutParams3);
        FrameLayout frameLayout2 = (FrameLayout) gameChatTabUI._$_findCachedViewById(R.id.bfz);
        GameLifeEmptyCoverView gameLifeEmptyCoverView = gameChatTabUI.ydl;
        if (gameLifeEmptyCoverView == null) {
            p.btv("emptyCoverView");
        }
        frameLayout2.addView(gameLifeEmptyCoverView, layoutParams3);
        AppMethodBeat.o(204204);
    }

    static /* synthetic */ void b(GameChatTabUI gameChatTabUI) {
        AppMethodBeat.i(204205);
        gameChatTabUI.getSwipeBackLayout().setEnableGesture(false);
        View findViewById = gameChatTabUI.findViewById(R.id.iew);
        if (findViewById != null) {
            ((SwipeBackLayout) findViewById).setEnableGesture(false);
        }
        AppMethodBeat.o(204205);
    }

    static /* synthetic */ void aAE(String str) {
        AppMethodBeat.i(204206);
        if (!Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameChatTabUI", "preload url: %s", str);
            nr nrVar = new nr();
            nrVar.dTO.type = 3;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            nrVar.dTO.intent = intent;
            EventCenter.instance.publish(nrVar);
        }
        AppMethodBeat.o(204206);
    }

    static /* synthetic */ void e(GameChatTabUI gameChatTabUI) {
        AppMethodBeat.i(204208);
        gameChatTabUI.ydi.ydb.dXn();
        AppMethodBeat.o(204208);
    }
}
