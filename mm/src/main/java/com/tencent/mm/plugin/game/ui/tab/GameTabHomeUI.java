package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.a;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.ui.GameCenterUI5;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameTabHomeUI extends GameCenterUI5 {
    private BroadcastReceiver xWV = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(42449);
            if (intent != null && "com.tencent.mm.game.ACTION_EXIT".equals(intent.getAction()) && GameTabHomeUI.this != null && !GameTabHomeUI.this.isFinishing()) {
                Log.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
                GameTabHomeUI.this.finish();
            }
            AppMethodBeat.o(42449);
        }
    };
    public String xXH;

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, com.tencent.mm.plugin.game.ui.GameCenterUI5, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameTabHomeUI() {
        AppMethodBeat.i(42450);
        AppMethodBeat.o(42450);
    }

    static /* synthetic */ void a(GameTabHomeUI gameTabHomeUI) {
        AppMethodBeat.i(42458);
        gameTabHomeUI.goBack();
        AppMethodBeat.o(42458);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.plugin.game.ui.GameCenterActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.game.ui.GameCenterUI5, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42451);
        super.onCreate(bundle);
        Log.i("MicroMsg.GameTabHomeUI", "%s create", getClass().getSimpleName());
        this.xXH = getIntent().getStringExtra("tab_key");
        a aVar = new a(this);
        ((GameTabWidget) findViewById(R.id.igl)).setAdapter(aVar);
        aVar.a((GameTabData) getIntent().getParcelableExtra("tab_data"), this.xXH);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.game.ACTION_EXIT");
        registerReceiver(this.xWV, intentFilter, a.xtn, null);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42448);
                GameTabHomeUI.a(GameTabHomeUI.this);
                AppMethodBeat.o(42448);
                return true;
            }
        });
        AppMethodBeat.o(42451);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.game.ui.GameCenterBaseUI, com.tencent.mm.plugin.game.ui.GameCenterUI5, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(42452);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(42452);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(42453);
        super.onNewIntent(intent);
        if (intent == null) {
            AppMethodBeat.o(42453);
            return;
        }
        setIntent(intent);
        String stringExtra = intent.getStringExtra("tab_key");
        if (!Util.nullAsNil(this.xXH).equals(stringExtra)) {
            Log.i("MicroMsg.GameTabHomeUI", "reload %s. current_key:%s, next_key:%s", getClass().getSimpleName(), this.xXH, stringExtra);
            finish();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/game/ui/tab/GameTabHomeUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/tab/GameTabHomeUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        overridePendingTransition(R.anim.cd, R.anim.cd);
        AppMethodBeat.o(42453);
    }

    @Override // com.tencent.mm.plugin.game.ui.GameBaseActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.game.ui.GameCenterUI5, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42454);
        super.onDestroy();
        unregisterReceiver(this.xWV);
        AppMethodBeat.o(42454);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(42455);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(42455);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(42455);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(42456);
        Log.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI goBack!");
        dWK();
        sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), a.xtn);
        AppMethodBeat.o(42456);
    }

    private void dWK() {
        AppMethodBeat.i(42457);
        if (Util.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            c.f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.anim.em, R.anim.er);
            Log.i("MicroMsg.GameTabHomeUI", "back to FindMoreFriendsUI");
        }
        AppMethodBeat.o(42457);
    }
}
