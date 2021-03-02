package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.a;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameTabWebUI extends GameWebViewUI {
    private Activity activity;
    private BroadcastReceiver xWV = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.game.ui.tab.GameTabWebUI.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(42460);
            if (intent != null && "com.tencent.mm.game.ACTION_EXIT".equals(intent.getAction()) && GameTabWebUI.this.activity != null && !GameTabWebUI.this.activity.isFinishing()) {
                Log.i("MicroMsg.GameTabWebUI", "%s exit!", GameTabWebUI.this.activity.getClass().getSimpleName());
                GameTabWebUI.this.activity.finish();
            }
            AppMethodBeat.o(42460);
        }
    };
    private String xXH;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameTabWebUI() {
        AppMethodBeat.i(42461);
        AppMethodBeat.o(42461);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42462);
        super.onCreate(bundle);
        Log.i("MicroMsg.GameTabWebUI", "%s create", getClass().getSimpleName());
        this.activity = this;
        this.xXH = getIntent().getStringExtra("tab_key");
        GameTabWidget gameTabWidget = new GameTabWidget(this);
        a aVar = new a(this);
        gameTabWidget.setAdapter(aVar);
        aVar.a((GameTabData) getIntent().getParcelableExtra("tab_data"), this.xXH);
        ((LinearLayout) findViewById(R.id.jkw)).addView(gameTabWidget);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.game.ACTION_EXIT");
        registerReceiver(this.xWV, intentFilter, a.xtn, null);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.tab.GameTabWebUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42459);
                GameTabWebUI.this.goBack();
                AppMethodBeat.o(42459);
                return true;
            }
        });
        AppMethodBeat.o(42462);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(42463);
        super.onNewIntent(intent);
        if (intent == null) {
            AppMethodBeat.o(42463);
            return;
        }
        setIntent(intent);
        if (!Util.nullAsNil(this.xXH).equals(intent.getStringExtra("tab_key"))) {
            Log.i("MicroMsg.GameTabWebUI", "reload %s", this.activity.getClass().getSimpleName());
            finish();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/game/ui/tab/GameTabWebUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/tab/GameTabWebUI", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        overridePendingTransition(R.anim.cd, R.anim.cd);
        AppMethodBeat.o(42463);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42464);
        super.onDestroy();
        unregisterReceiver(this.xWV);
        AppMethodBeat.o(42464);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(42465);
        super.onBackPressed();
        goBack();
        AppMethodBeat.o(42465);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void goBack() {
        AppMethodBeat.i(42466);
        Log.i("MicroMsg.GameTabWebUI", "%s goBack!", this.activity.getClass().getSimpleName());
        dWK();
        sendBroadcast(new Intent("com.tencent.mm.game.ACTION_EXIT"), a.xtn);
        AppMethodBeat.o(42466);
    }

    private void dWK() {
        AppMethodBeat.i(42467);
        if (Util.nullAsNil(getIntent().getStringExtra("jump_find_more_friends")).equals("jump_find_more_friends")) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            c.f(this, ".ui.LauncherUI", intent);
            finish();
            overridePendingTransition(R.anim.em, R.anim.er);
            Log.i("MicroMsg.GameTabWebUI", "back to FindMoreFriendsUI.");
        }
        AppMethodBeat.o(42467);
    }
}
