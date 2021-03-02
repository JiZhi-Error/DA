package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.k;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.LinkedList;

@a(3)
public class CardViewEntranceUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.m5;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(113591);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() intent == null");
            setResult(0, intent);
            finish();
            AppMethodBeat.o(113591);
            return;
        }
        int intExtra = intent.getIntExtra("key_from_scene", 50);
        Log.i("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("card_list");
        String stringExtra2 = intent.getStringExtra("key_app_id");
        Log.d("MicroMsg.CardViewEntranceUI", "appid: %s", stringExtra2);
        if (TextUtils.isEmpty(stringExtra)) {
            Log.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate card_list is empty");
            setResult(0, intent);
            finish();
            AppMethodBeat.o(113591);
            return;
        }
        LinkedList<va> G = k.G(stringExtra, intExtra, stringExtra2);
        if (G == null || G.size() == 0) {
            Log.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI oncreate tempList size is empty");
            setResult(0, intent);
            finish();
            AppMethodBeat.o(113591);
            return;
        }
        Intent intent2 = new Intent();
        if (G.size() == 1) {
            intent2.putExtra("card_list", stringExtra);
            intent2.putExtra("key_app_id", stringExtra2);
            intent2.putExtra("key_from_scene", 50);
            intent2.putExtra("key_previous_scene", intExtra);
            if (!Util.isNullOrNil(intent.getStringExtra("key_template_id"))) {
                intent2.putExtra("key_template_id", intent.getStringExtra("key_template_id"));
            }
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/card/ui/CardViewEntranceUI", "doRediect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardViewEntranceUI", "doRediect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else {
            intent2.putExtra("view_type", 0);
            intent2.putExtra("card_list", stringExtra);
            intent2.putExtra("key_previous_scene", intExtra);
            if (!Util.isNullOrNil(intent.getStringExtra("key_template_id"))) {
                intent2.putExtra("key_template_id", intent.getStringExtra("key_template_id"));
            }
            intent2.putExtra("key_app_id", stringExtra2);
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardViewUI.class);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/card/ui/CardViewEntranceUI", "doRediect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardViewEntranceUI", "doRediect", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        Log.e("MicroMsg.CardViewEntranceUI", "CardViewEntranceUI onCreate() parameter is ok");
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(113591);
    }
}
