package com.tencent.mm.plugin.wear.model.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30079);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11016);
        arrayList.add(11017);
        arrayList.add(11018);
        AppMethodBeat.o(30079);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        String str;
        AppMethodBeat.i(30080);
        try {
            str = new String(bArr, "utf8");
        } catch (UnsupportedEncodingException e2) {
            str = "";
        }
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.Wear.HttpFriendServer", "error to get username");
            AppMethodBeat.o(30080);
        } else {
            Log.i("MicroMsg.Wear.HttpFriendServer", "handle friend request %s", str);
            if (i2 == 11016) {
                Intent intent = new Intent();
                intent.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_accept_".concat(String.valueOf(str)));
                intent.setFlags(335544320);
                Context context = MMApplicationContext.getContext();
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (i2 == 11017) {
                Intent intent2 = new Intent();
                intent2.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent2.putExtra("friend_message_transfer_username", str);
                intent2.setAction("friend_message_ignore_".concat(String.valueOf(str)));
                intent2.setFlags(335544320);
                Context context2 = MMApplicationContext.getContext();
                a bl2 = new a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (i2 == 11018) {
                Intent intent3 = new Intent();
                intent3.setClassName(MMApplicationContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
                intent3.setFlags(335544320);
                Context context3 = MMApplicationContext.getContext();
                a bl3 = new a().bl(intent3);
                com.tencent.mm.hellhoundlib.a.a.a(context3, bl3.axQ(), "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context3.startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context3, "com/tencent/mm/plugin/wear/model/server/HttpFriendServer", "handleData", "(I[B)[B", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(30080);
        }
        return null;
    }
}
