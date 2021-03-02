package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterActivity;
import com.tencent.mm.plugin.game.ui.tab.GameTabWidget;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;

@a(19)
public class GameTabBridgeUI extends GameCenterActivity {
    private BroadcastReceiver xWV = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI.AnonymousClass3 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(42438);
            if (intent != null && "com.tencent.mm.game.ACTION_EXIT".equals(intent.getAction()) && GameTabBridgeUI.this != null && !GameTabBridgeUI.this.isFinishing()) {
                Log.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
                GameTabBridgeUI.this.finish();
            }
            AppMethodBeat.o(42438);
        }
    };

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameTabBridgeUI() {
        AppMethodBeat.i(42439);
        AppMethodBeat.o(42439);
    }

    static /* synthetic */ void a(GameTabBridgeUI gameTabBridgeUI) {
        AppMethodBeat.i(42447);
        gameTabBridgeUI.goBack();
        AppMethodBeat.o(42447);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42440);
        super.onCreate(bundle);
        Log.i("MicroMsg.GameTabBridgeUI", "%s create", getClass().getSimpleName());
        GameTabWidget.lNi = hashCode();
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.game.ACTION_EXIT");
        registerReceiver(this.xWV, intentFilter, com.tencent.mm.plugin.game.a.xtn, null);
        final Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("tab_key");
        a aVar = new a(this);
        ((GameTabWidget) findViewById(R.id.igl)).setAdapter(aVar);
        aVar.a((GameTabData) intent.getParcelableExtra("tab_data"), stringExtra);
        intent.setComponent((ComponentName) intent.getParcelableExtra("next_tab_component"));
        final long currentTimeMillis = System.currentTimeMillis();
        ToolsProcessIPCService.a(GameTabWidget.a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(42436);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(42435);
                        Log.i("MicroMsg.GameTabBridgeUI", "load tools process, web page load time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (GameTabWidget.lNi == GameTabBridgeUI.this.hashCode()) {
                            GameTabWidget.a(GameTabBridgeUI.this, intent, false, true, true, false);
                            AppMethodBeat.o(42435);
                            return;
                        }
                        Log.i("MicroMsg.GameTabBridgeUI", "GameTabWidget.mHashCode(%d) != hashCode(%d), dont need turn page!", Integer.valueOf(GameTabWidget.lNi), Integer.valueOf(GameTabBridgeUI.this.hashCode()));
                        AppMethodBeat.o(42435);
                    }
                });
                AppMethodBeat.o(42436);
            }
        });
        AppMethodBeat.o(42440);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42441);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42437);
                GameTabBridgeUI.a(GameTabBridgeUI.this);
                AppMethodBeat.o(42437);
                return true;
            }
        });
        setMMTitle(R.string.dte);
        AppMethodBeat.o(42441);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(42442);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(42442);
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

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aor;
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42443);
        super.onDestroy();
        unregisterReceiver(this.xWV);
        AppMethodBeat.o(42443);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(42444);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(42444);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(42444);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(42445);
        Log.i("MicroMsg.GameTabBridgeUI", "GameTabHomeUI goBack!");
        dWK();
        sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), com.tencent.mm.plugin.game.a.xtn);
        AppMethodBeat.o(42445);
    }

    private void dWK() {
        AppMethodBeat.i(42446);
        if (Util.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            c.f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.anim.em, R.anim.er);
            Log.i("MicroMsg.GameTabBridgeUI", "back to FindMoreFriendsUI");
        }
        AppMethodBeat.o(42446);
    }
}
