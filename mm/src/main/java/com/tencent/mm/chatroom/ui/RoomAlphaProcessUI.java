package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.x;
import com.tencent.mm.chatroom.ui.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
@Deprecated
public class RoomAlphaProcessUI extends MMActivity implements b.a {
    private String chatroomName;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12676);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        initView();
        x xVar = new x(this.chatroomName);
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.video.d.b.CTRL_INDEX, new i(h.a((Context) this, getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.chatroom.ui.b.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        }), this, this) {
            /* class com.tencent.mm.chatroom.ui.b.AnonymousClass2 */
            final /* synthetic */ ProgressDialog guD;
            final /* synthetic */ boolean gyH = false;
            final /* synthetic */ a gyI;
            final /* synthetic */ Activity val$activity;

            {
                this.guD = r2;
                this.val$activity = r3;
                this.gyI = r4;
            }

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(12766);
                g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.video.d.b.CTRL_INDEX, this);
                if (!this.gyH) {
                    this.guD.cancel();
                }
                boolean z = false;
                this.val$activity.getString(R.string.g_9);
                x xVar = (x) qVar;
                if (i2 == 0 && i3 == 0) {
                    ah Kd = ((c) g.af(c.class)).aSX().Kd(xVar.chatroomName);
                    if (Kd == null) {
                        Kd = new ah();
                    }
                    Kd.mQ(z.aTY(), xVar.gsv);
                    v.a(Kd);
                    z = true;
                }
                if (this.gyI != null) {
                    this.gyI.g(z, xVar.gsw);
                }
                AppMethodBeat.o(12766);
            }
        });
        g.aAg().hqi.a(xVar, 0);
        AppMethodBeat.o(12676);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(12677);
        super.onResume();
        AppMethodBeat.o(12677);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(12678);
        super.onPause();
        AppMethodBeat.o(12678);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12679);
        super.onDestroy();
        AppMethodBeat.o(12679);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    private static void w(Runnable runnable) {
        AppMethodBeat.i(12680);
        new MMHandler().postDelayed(runnable, 200);
        AppMethodBeat.o(12680);
    }

    @Override // com.tencent.mm.chatroom.ui.b.a
    public final void g(final boolean z, final int i2) {
        AppMethodBeat.i(12681);
        if (z) {
            h.cD(this, getString(R.string.g__));
            w(new Runnable() {
                /* class com.tencent.mm.chatroom.ui.RoomAlphaProcessUI.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(12674);
                    Intent intent = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
                    intent.setFlags(603979776);
                    intent.putExtra("room_name", RoomAlphaProcessUI.this.chatroomName);
                    intent.putExtra("upgrade_success", z);
                    intent.putExtra("left_quota", i2);
                    RoomAlphaProcessUI roomAlphaProcessUI = RoomAlphaProcessUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(roomAlphaProcessUI, bl.axQ(), "com/tencent/mm/chatroom/ui/RoomAlphaProcessUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    roomAlphaProcessUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(roomAlphaProcessUI, "com/tencent/mm/chatroom/ui/RoomAlphaProcessUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(12674);
                }
            });
            AppMethodBeat.o(12681);
            return;
        }
        h.d(this, getString(R.string.g_9), "", null);
        w(new Runnable() {
            /* class com.tencent.mm.chatroom.ui.RoomAlphaProcessUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(12675);
                Intent intent = new Intent(RoomAlphaProcessUI.this, RoomUpgradeUI.class);
                intent.setFlags(603979776);
                intent.putExtra("room_name", RoomAlphaProcessUI.this.chatroomName);
                intent.putExtra("upgrade_success", z);
                RoomAlphaProcessUI roomAlphaProcessUI = RoomAlphaProcessUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(roomAlphaProcessUI, bl.axQ(), "com/tencent/mm/chatroom/ui/RoomAlphaProcessUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                roomAlphaProcessUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(roomAlphaProcessUI, "com/tencent/mm/chatroom/ui/RoomAlphaProcessUI$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(12675);
            }
        });
        AppMethodBeat.o(12681);
    }
}
