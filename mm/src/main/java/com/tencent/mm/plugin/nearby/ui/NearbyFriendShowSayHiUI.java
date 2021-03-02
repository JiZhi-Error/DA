package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;

public class NearbyFriendShowSayHiUI extends MMActivity {
    String AzV = "";
    View AzW = null;
    ImageView gvv;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(89828);
        super.onCreate(bundle);
        setMMTitle(R.string.fad);
        initView();
        AppMethodBeat.o(89828);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(89829);
        super.onResume();
        TextView textView = (TextView) findViewById(R.id.h_k);
        g.aAf().azk();
        int ctM = ((l) g.af(l.class)).eiv().ctM();
        if (ctM == 0) {
            this.AzW.setVisibility(4);
            AppMethodBeat.o(89829);
            return;
        }
        textView.setText(getResources().getQuantityString(R.plurals.a3, ctM, Integer.valueOf(ctM)));
        this.gvv = (ImageView) findViewById(R.id.faz);
        bx eiG = ((l) g.af(l.class)).eiv().eiG();
        if (eiG != null) {
            this.AzV = eiG.field_sayhiuser;
            a.b.c(this.gvv, this.AzV);
        }
        AppMethodBeat.o(89829);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(89830);
        super.onPause();
        AppMethodBeat.o(89830);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bf3;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(89831);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(89825);
                NearbyFriendShowSayHiUI.this.hideVKB();
                NearbyFriendShowSayHiUI.this.finish();
                AppMethodBeat.o(89825);
                return true;
            }
        });
        ((Button) findViewById(R.id.fu5)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(89826);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                NearbyFriendShowSayHiUI nearbyFriendShowSayHiUI = NearbyFriendShowSayHiUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(NearbyFriendShowSayHiUI.this, NearbyFriendsUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(nearbyFriendShowSayHiUI, bl.axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                nearbyFriendShowSayHiUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(nearbyFriendShowSayHiUI, "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(89826);
            }
        });
        this.AzW = findViewById(R.id.dkq);
        this.AzW.setVisibility(0);
        this.AzW.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(89827);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(NearbyFriendShowSayHiUI.this, NearbySayHiListUI.class);
                intent.putExtra("k_say_hi_type", 2);
                intent.putExtra("show_clear_header", true);
                NearbyFriendShowSayHiUI.this.startActivityForResult(intent, 2009);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendShowSayHiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(89827);
            }
        });
        AppMethodBeat.o(89831);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(89832);
        if (i2 == 2009 && i3 == -1) {
            finish();
        }
        AppMethodBeat.o(89832);
    }
}
