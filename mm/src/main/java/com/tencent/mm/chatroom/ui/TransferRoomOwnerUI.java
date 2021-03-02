package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.chatroom.d.v;
import com.tencent.mm.chatroom.ui.SelectMemberUI;
import com.tencent.mm.contact.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.b.p;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;

public class TransferRoomOwnerUI extends SelectMemberUI implements i {
    private boolean gBU;
    private q gxX;

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(13005);
        super.onCreate(bundle);
        if (ab.Iy(this.gwx)) {
            g.aAg().hqi.a(811, this);
            AppMethodBeat.o(13005);
            return;
        }
        g.aAg().hqi.a(di.CTRL_INDEX, this);
        AppMethodBeat.o(13005);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void anf() {
        AppMethodBeat.i(13006);
        super.anf();
        this.gBU = getIntent().getBooleanExtra("quit_room", false);
        AppMethodBeat.o(13006);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(13007);
        super.onDestroy();
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
        }
        if (ab.Iy(this.gwx)) {
            g.aAg().hqi.b(811, this);
            AppMethodBeat.o(13007);
            return;
        }
        g.aAg().hqi.b(di.CTRL_INDEX, this);
        AppMethodBeat.o(13007);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(13008);
        if (this.gxX != null && this.gxX.isShowing()) {
            this.gxX.dismiss();
        }
        if (qVar.getType() == 990 || qVar.getType() == 811) {
            if (i2 == 0 && i3 == 0) {
                if (ab.Iy(this.gwx)) {
                    Log.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", ((p) qVar).username);
                } else {
                    Log.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", ((v) qVar).username);
                }
                u.makeText(this, (int) R.string.g9s, 1).show();
                Intent intent = new Intent(getContext(), ChatroomInfoUI.class);
                intent.putExtra("RoomInfo_Id", this.gwx);
                intent.putExtra("Chat_User", this.gwx);
                intent.putExtra("Is_Chatroom", true);
                intent.setFlags(67108864);
                AppCompatActivity context = getContext();
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                finish();
                AppMethodBeat.o(13008);
                return;
            }
            u.makeText(this, (int) R.string.g9r, 1).show();
            Log.w("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer failed: %d %d %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        AppMethodBeat.o(13008);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.chatroom.ui.SelectMemberUI
    public final void a(View view, int i2, long j2) {
        String a2;
        String str;
        String string;
        cn aEZ;
        AppMethodBeat.i(13009);
        super.a(view, i2, j2);
        SelectMemberUI.a on = this.gAA.on(i2);
        if (on == null || on.contact == null) {
            Log.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
            AppMethodBeat.o(13009);
            return;
        }
        as asVar = on.contact;
        final String str2 = asVar.field_username;
        if (!Util.isNullOrNil(asVar.field_conRemark)) {
            a2 = asVar.field_conRemark;
        } else {
            a2 = a(this.gtd, asVar.field_username);
        }
        if (Util.isNullOrNil(a2)) {
            str = asVar.arI();
        } else {
            str = a2;
        }
        if (!c.oR(asVar.field_type) && (aEZ = ((l) g.af(l.class)).aSO().aEZ(asVar.field_username)) != null && !Util.isNullOrNil(aEZ.field_conRemark)) {
            str = aEZ.field_conRemark;
        }
        String O = com.tencent.mm.openim.room.a.a.O(asVar);
        if (!TextUtils.isEmpty(O)) {
            str = str + ((Object) O);
        }
        if (!this.gBU) {
            string = getString(R.string.g9u, new Object[]{str});
        } else {
            string = getString(R.string.g8v, new Object[]{str});
        }
        h.a(this, string, "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.TransferRoomOwnerUI.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                com.tencent.mm.ak.q vVar;
                AppMethodBeat.i(13004);
                if (ab.Iy(TransferRoomOwnerUI.this.gwx)) {
                    vVar = new p(TransferRoomOwnerUI.this.gwx, str2);
                } else {
                    vVar = new v(TransferRoomOwnerUI.this.gwx, str2);
                }
                g.aAg().hqi.a(vVar, 0);
                TransferRoomOwnerUI transferRoomOwnerUI = TransferRoomOwnerUI.this;
                TransferRoomOwnerUI transferRoomOwnerUI2 = TransferRoomOwnerUI.this;
                TransferRoomOwnerUI.this.getString(R.string.zb);
                transferRoomOwnerUI.gxX = h.a((Context) transferRoomOwnerUI2, TransferRoomOwnerUI.this.getString(R.string.g9v), false, (DialogInterface.OnCancelListener) null);
                AppMethodBeat.o(13004);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.TransferRoomOwnerUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(13009);
    }
}
