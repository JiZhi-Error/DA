package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

public final class b {

    interface a {
        void g(boolean z, int i2);
    }

    public static void a(Activity activity, String str, boolean z) {
        AppMethodBeat.i(12767);
        if (z) {
            Intent intent = new Intent(activity, RoomUpgradeUI.class);
            intent.setFlags(603979776);
            intent.putExtra("room_name", str);
            Intent intent2 = new Intent();
            intent2.setClassName(activity, "com.tencent.mm.plugin.account.ui.bind.BindMobileUI");
            intent2.putExtra("is_bind_for_chatroom_upgrade", true);
            MMWizardActivity.b(activity, intent2, intent);
            AppMethodBeat.o(12767);
            return;
        }
        Intent intent3 = new Intent(activity, RoomUpgradeUI.class);
        intent3.setFlags(603979776);
        intent3.putExtra("room_name", str);
        intent3.putExtra("announce_ok", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/chatroom/ui/RoomUpgradeHelper", "goUpgrade", "(Landroid/app/Activity;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/chatroom/ui/RoomUpgradeHelper", "goUpgrade", "(Landroid/app/Activity;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(12767);
    }
}
