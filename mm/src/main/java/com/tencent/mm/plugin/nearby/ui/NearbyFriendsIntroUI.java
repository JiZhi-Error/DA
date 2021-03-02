package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public class NearbyFriendsIntroUI extends MMActivity {
    private CheckBox AzQ;
    private d AzS = null;
    private Button hPX;
    private View jBV;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(89836);
        super.onCreate(bundle);
        setMMTitle(R.string.fad);
        initView();
        AppMethodBeat.o(89836);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bf1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(89837);
        this.jBV = View.inflate(this, R.layout.azk, null);
        this.AzQ = (CheckBox) this.jBV.findViewById(R.id.e_r);
        this.AzQ.setChecked(false);
        this.hPX = (Button) findViewById(R.id.fu5);
        this.hPX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(89834);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (NearbyFriendsIntroUI.this.AzS == null) {
                    NearbyFriendsIntroUI.this.AzS = h.a(NearbyFriendsIntroUI.this.getContext(), NearbyFriendsIntroUI.this.getString(R.string.zb), NearbyFriendsIntroUI.this.jBV, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(89833);
                            g.aAh().azQ().set(4103, Boolean.TRUE);
                            g.aAh().azQ().set(4104, Boolean.valueOf(!NearbyFriendsIntroUI.this.AzQ.isChecked()));
                            bz aWk = bz.aWk();
                            if (aWk == null) {
                                NearbyFriendsIntroUI nearbyFriendsIntroUI = NearbyFriendsIntroUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class));
                                a.a(nearbyFriendsIntroUI, bl.axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                nearbyFriendsIntroUI.startActivity((Intent) bl.pG(0));
                                a.a(nearbyFriendsIntroUI, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            } else {
                                String nullAsNil = Util.nullAsNil(aWk.getProvince());
                                Util.nullAsNil(aWk.getCity());
                                int nullAs = Util.nullAs(Integer.valueOf(aWk.fuA), 0);
                                if (nullAsNil.equals("") || nullAs == 0) {
                                    NearbyFriendsIntroUI nearbyFriendsIntroUI2 = NearbyFriendsIntroUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(NearbyFriendsIntroUI.this, NearbyPersonalInfoUI.class));
                                    a.a(nearbyFriendsIntroUI2, bl2.axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    nearbyFriendsIntroUI2.startActivity((Intent) bl2.pG(0));
                                    a.a(nearbyFriendsIntroUI2, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                } else {
                                    NearbyFriendsIntroUI nearbyFriendsIntroUI3 = NearbyFriendsIntroUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(NearbyFriendsIntroUI.this, NearbyFriendsUI.class));
                                    a.a(nearbyFriendsIntroUI3, bl3.axQ(), "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    nearbyFriendsIntroUI3.startActivity((Intent) bl3.pG(0));
                                    a.a(nearbyFriendsIntroUI3, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                }
                            }
                            NearbyFriendsIntroUI.this.finish();
                            AppMethodBeat.o(89833);
                        }
                    }, (DialogInterface.OnClickListener) null);
                } else {
                    NearbyFriendsIntroUI.this.AzS.show();
                }
                a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(89834);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(89835);
                NearbyFriendsIntroUI.this.hideVKB();
                NearbyFriendsIntroUI.this.finish();
                AppMethodBeat.o(89835);
                return true;
            }
        });
        AppMethodBeat.o(89837);
    }
}
