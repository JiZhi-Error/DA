package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI extends MMActivity {
    private String chatroomName;
    private ah gtd;
    private Button gyJ;
    private View gyK;
    private ImageView gyL;
    private TextView gyM;
    private TextView gyN;
    private TextView gyO;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(RoomUpgradeResultUI roomUpgradeResultUI) {
        AppMethodBeat.i(12778);
        roomUpgradeResultUI.goBack();
        AppMethodBeat.o(12778);
    }

    static /* synthetic */ void a(RoomUpgradeResultUI roomUpgradeResultUI, String str) {
        AppMethodBeat.i(12779);
        roomUpgradeResultUI.DK(str);
        AppMethodBeat.o(12779);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12772);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("chatroom");
        Log.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", this.chatroomName);
        this.gtd = ((c) g.af(c.class)).aSX().Kd(this.chatroomName);
        if (this.gtd == null) {
            goBack();
        }
        initView();
        AppMethodBeat.o(12772);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12773);
        super.onDestroy();
        AppMethodBeat.o(12773);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12774);
        setMMTitle(R.string.g9x);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomUpgradeResultUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12768);
                RoomUpgradeResultUI.a(RoomUpgradeResultUI.this);
                AppMethodBeat.o(12768);
                return true;
            }
        });
        this.gyK = findViewById(R.id.j0s);
        this.gyL = (ImageView) findViewById(R.id.j0r);
        this.gyM = (TextView) findViewById(R.id.j0t);
        this.gyN = (TextView) findViewById(R.id.j0o);
        this.gyO = (TextView) findViewById(R.id.j0p);
        this.gyJ = (Button) findViewById(R.id.dq8);
        this.gyJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomUpgradeResultUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(12769);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("rawUrl", RoomUpgradeResultUI.this.getString(R.string.awk, new Object[]{LocaleUtil.getApplicationLanguage()}));
                intent.putExtra("geta8key_username", z.aTY());
                com.tencent.mm.br.c.d(RoomUpgradeResultUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
                a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(12769);
            }
        });
        this.gyJ.setVisibility(0);
        final String str = this.gtd.field_roomowner;
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) > 0) {
            DK(str);
        } else {
            ay.a.iDq.a(str, this.chatroomName, new ay.b.a() {
                /* class com.tencent.mm.chatroom.ui.RoomUpgradeResultUI.AnonymousClass3 */

                @Override // com.tencent.mm.model.ay.b.a
                public final void p(String str, boolean z) {
                    AppMethodBeat.i(12771);
                    if (z) {
                        RoomUpgradeResultUI.this.gyK.post(new Runnable() {
                            /* class com.tencent.mm.chatroom.ui.RoomUpgradeResultUI.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(12770);
                                RoomUpgradeResultUI.a(RoomUpgradeResultUI.this, str);
                                AppMethodBeat.o(12770);
                            }
                        });
                    }
                    AppMethodBeat.o(12771);
                }
            });
        }
        int gBw = this.gtd.gBw();
        this.gyN.setVisibility(0);
        this.gyN.setText(getString(R.string.g_5, new Object[]{Integer.valueOf(gBw)}));
        this.gyJ.setText(R.string.g_0);
        this.gyO.setVisibility(8);
        AppMethodBeat.o(12774);
    }

    private void DK(String str) {
        AppMethodBeat.i(12775);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) <= 0) {
            AppMethodBeat.o(12775);
            return;
        }
        String arI = Kn.arI();
        a.b.c(this.gyL, str);
        this.gyM.setVisibility(0);
        this.gyM.setText(arI);
        AppMethodBeat.o(12775);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(12776);
        if (i2 == 4) {
            goBack();
            AppMethodBeat.o(12776);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(12776);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(12777);
        Intent intent = new Intent(this, RoomUpgradeUI.class);
        intent.addFlags(67108864);
        intent.putExtra("finish_self", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(12777);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.pt;
    }
}
