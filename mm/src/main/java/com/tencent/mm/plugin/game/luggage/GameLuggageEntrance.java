package com.tencent.mm.plugin.game.luggage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMActivity;

public class GameLuggageEntrance extends MMActivity {
    private static final String xvX = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/cgi-bin/h5/static/centerbox/index_v6.html?wechat_pkgid=index_v6&abt=21");

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(186824);
        AppMethodBeat.o(186824);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(82979);
        super.onCreate(bundle);
        final EditText editText = (EditText) findViewById(R.id.bw_);
        ((Button) findViewById(R.id.e5h)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.luggage.GameLuggageEntrance.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(82976);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String obj = editText.getText().toString();
                if (!Util.isNullOrNil(obj)) {
                    new Bundle().putString("rawUrl", obj);
                    Intent intent = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
                    intent.putExtra("rawUrl", obj);
                    GameLuggageEntrance gameLuggageEntrance = GameLuggageEntrance.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(gameLuggageEntrance, bl.axQ(), "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    gameLuggageEntrance.startActivity((Intent) bl.pG(0));
                    a.a(gameLuggageEntrance, "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                a.a(this, "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82976);
            }
        });
        ((Button) findViewById(R.id.e5o)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.luggage.GameLuggageEntrance.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(82977);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                new Bundle().putString("rawUrl", GameLuggageEntrance.xvX);
                Intent intent = new Intent(GameLuggageEntrance.this, LuggageGameWebViewUI.class);
                intent.putExtra("rawUrl", GameLuggageEntrance.xvX);
                GameLuggageEntrance gameLuggageEntrance = GameLuggageEntrance.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(gameLuggageEntrance, bl.axQ(), "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                gameLuggageEntrance.startActivity((Intent) bl.pG(0));
                a.a(gameLuggageEntrance, "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/game/luggage/GameLuggageEntrance$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(82977);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.luggage.GameLuggageEntrance.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(82978);
                GameLuggageEntrance.this.finish();
                AppMethodBeat.o(82978);
                return false;
            }
        });
        AppMethodBeat.o(82979);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b4s;
    }
}
