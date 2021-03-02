package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public final class n {
    public static String Kwp = null;

    public static void a(Bundle bundle, BaseResp baseResp, String str) {
        AppMethodBeat.i(152418);
        baseResp.toBundle(bundle);
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        q.bo(bundle);
        q.bp(bundle);
        MMessageActV2.send(MMApplicationContext.getContext(), args);
        AppMethodBeat.o(152418);
    }

    public static boolean mF(String str, String str2) {
        AppMethodBeat.i(223871);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appid is null");
            AppMethodBeat.o(223871);
            return true;
        }
        g o = h.o(str, true, false);
        if (o == null) {
            Log.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount appInfo is null");
            AppMethodBeat.o(223871);
            return true;
        } else if (Util.isNullOrNil(str2)) {
            Log.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount openId is null");
            AppMethodBeat.o(223871);
            return true;
        } else {
            Log.i("MicroMsg.OpenBusinessViewUtil", "isSameAccount %s/%s", str2, o.field_openId);
            boolean equalsIgnoreCase = str2.equalsIgnoreCase(o.field_openId);
            AppMethodBeat.o(223871);
            return equalsIgnoreCase;
        }
    }

    public static void i(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(223872);
        if (!z) {
            Log.w("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom businessType:%s appid:%s extInfo:%s isSameAccount:%s", str, str2, str3, Boolean.valueOf(z));
            final Context context = MMApplicationContext.getContext();
            f.a bow = new f.a(context).bow(context.getString(R.string.fiz));
            bow.JnN = true;
            bow.apa(R.string.x_).b(new f.c() {
                /* class com.tencent.mm.pluginsdk.ui.tools.n.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.a.f.c
                public final void e(boolean z, String str) {
                    AppMethodBeat.i(223870);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse("wxwork://jump"));
                    intent.setPackage("com.tencent.wework");
                    intent.setFlags(268435456);
                    Context context = context;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(223870);
                }
            }).show();
            AppMethodBeat.o(223872);
            return;
        }
        try {
            String string = new JSONObject(str3).getString("ticket");
            Intent intent = new Intent();
            intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI");
            intent.addFlags(268435456);
            intent.putExtra("upgrade_openim_room_from_scene", 3);
            intent.putExtra("ticket", Util.nullAs(string, ""));
            Context context2 = MMApplicationContext.getContext();
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/pluginsdk/ui/tools/OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            Log.i("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom ticket:%s", Util.nullAs(string, ""));
            AppMethodBeat.o(223872);
        } catch (JSONException e2) {
            Log.e("MicroMsg.OpenBusinessViewUtil", "launchUpdateRoomToOpenImChatroom Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(223872);
        }
    }

    public static boolean d(String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(152417);
        g o = h.o(str3, true, false);
        if (o == null) {
            Log.e("MicroMsg.OpenBusinessViewUtil", "launchBackApp info is null");
            AppMethodBeat.o(152417);
            return false;
        }
        Bundle bundle = new Bundle();
        WXOpenBusinessView.Resp resp = new WXOpenBusinessView.Resp(bundle);
        resp.extMsg = str2;
        resp.errStr = str4;
        resp.openId = o.field_openId;
        resp.errCode = i2;
        resp.businessType = str;
        resp.transaction = Kwp;
        a(bundle, resp, o.field_packageName);
        AppMethodBeat.o(152417);
        return true;
    }
}
