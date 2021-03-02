package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class b {
    public static void a(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(113737);
        Intent intent = new Intent(mMActivity, CardNewMsgUI.class);
        intent.putExtra("from_menu", z);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/card/util/CardActivityHelper", "goCardNewMsgUI", "(Lcom/tencent/mm/ui/MMActivity;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        mMActivity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/card/util/CardActivityHelper", "goCardNewMsgUI", "(Lcom/tencent/mm/ui/MMActivity;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        Log.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
        h.INSTANCE.a(11324, "CardMsgCenterView", 0, "", "", 0, 0, "", 0, "");
        AppMethodBeat.o(113737);
    }

    public static void am(Context context, String str) {
        AppMethodBeat.i(113738);
        if (TextUtils.isEmpty(str)) {
            Log.v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.o(113738);
        } else if (context == null) {
            Log.e("MicroMsg.CardActivityHelper", "context is null, err");
            AppMethodBeat.o(113738);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("force_get_contact", true);
            c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(113738);
        }
    }

    public static void an(Context context, String str) {
        AppMethodBeat.i(113739);
        if (TextUtils.isEmpty(str)) {
            Log.v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.o(113739);
        } else if (ab.IS(str)) {
            ao(context, str);
            AppMethodBeat.o(113739);
        } else {
            am(context, str);
            AppMethodBeat.o(113739);
        }
    }

    private static void ao(Context context, String str) {
        AppMethodBeat.i(113740);
        if (TextUtils.isEmpty(str)) {
            Log.v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.o(113740);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        c.f(context, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(113740);
    }

    public static void a(MMActivity mMActivity, String str) {
        AppMethodBeat.i(261895);
        a(mMActivity, str, 0);
        AppMethodBeat.o(261895);
    }

    public static void a(MMActivity mMActivity, String str, String str2) {
        AppMethodBeat.i(113742);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", 0);
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        c.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(113742);
    }

    public static void a(MMActivity mMActivity, String str, int i2) {
        AppMethodBeat.i(113743);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", i2);
        c.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(113743);
    }

    public static void a(MMActivity mMActivity, float f2, float f3, String str) {
        AppMethodBeat.i(113744);
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", (double) f2);
        intent.putExtra("kwebmap_lng", (double) f3);
        intent.putExtra("Kwebmap_locaion", str);
        c.b(mMActivity, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(113744);
    }

    public static void a(MMActivity mMActivity, int i2, MMActivity.a aVar) {
        AppMethodBeat.i(113745);
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", false);
        intent.putExtra("Select_Conv_Type", 3);
        c.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i2, aVar);
        AppMethodBeat.o(113745);
    }

    public static void b(MMActivity mMActivity, String str) {
        AppMethodBeat.i(113746);
        Intent intent = new Intent();
        intent.putExtra("KEY_BRAND_NAME", str);
        c.b(mMActivity, "card", ".ui.CardShowWaringTransparentUI", intent);
        AppMethodBeat.o(113746);
    }

    public static void a(MMActivity mMActivity, int i2, String str, boolean z, com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(113747);
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 3);
        intent.putExtra("key_expire_time", i2);
        intent.putExtra("key_begin_time", System.currentTimeMillis());
        intent.putExtra("key_card_tips", str);
        intent.putExtra("key_is_mark", z);
        intent.putExtra("key_card_id", bVar.csV());
        intent.putExtra("key_user_card_id", bVar.csU());
        intent.putExtra("key_card_code", bVar.csR().code);
        c.b(mMActivity, "offline", ".ui.WalletOfflineEntranceUI", intent);
        h.INSTANCE.a(11850, 5, 0);
        h.INSTANCE.a(19671, 1, bVar.csU());
        AppMethodBeat.o(113747);
    }

    public static boolean a(String str, abz abz, int i2, int i3) {
        AppMethodBeat.i(113748);
        if (abz == null) {
            Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
            AppMethodBeat.o(113748);
            return false;
        }
        boolean d2 = d(str, abz.Leo, abz.Lep, i2, i3);
        AppMethodBeat.o(113748);
        return d2;
    }

    public static boolean V(String str, String str2, String str3) {
        AppMethodBeat.i(201322);
        boolean d2 = d(str, str2, str3, TXLiteAVCode.EVT_SW_ENCODER_START_SUCC, 0);
        AppMethodBeat.o(201322);
        return d2;
    }

    public static boolean d(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(113749);
        if (Util.isNullOrNil(str2)) {
            Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
            AppMethodBeat.o(113749);
            return false;
        }
        wq wqVar = new wq();
        wqVar.ecI.userName = str2;
        wqVar.ecI.ecK = Util.nullAs(str3, "");
        wqVar.ecI.ecL = i3;
        if (i2 == 26) {
            wqVar.ecI.scene = TXLiteAVCode.EVT_LOCAL_RECORD_RESULT;
        } else {
            wqVar.ecI.scene = TXLiteAVCode.EVT_SW_ENCODER_START_SUCC;
        }
        wqVar.ecI.dCw = str;
        wqVar.ecI.ecP = true;
        EventCenter.instance.publish(wqVar);
        Log.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", wqVar.ecI.userName, wqVar.ecI.ecK, Integer.valueOf(wqVar.ecI.scene), Integer.valueOf(wqVar.ecI.ecL));
        AppMethodBeat.o(113749);
        return true;
    }

    public static void H(String str, String str2, int i2) {
        AppMethodBeat.i(113750);
        wq wqVar = new wq();
        wqVar.ecI.userName = str;
        wqVar.ecI.ecK = Util.nullAs(str2, "");
        if (i2 > 0) {
            wqVar.ecI.appVersion = i2;
        }
        wqVar.ecI.scene = TXLiteAVCode.EVT_SW_ENCODER_START_SUCC;
        EventCenter.instance.publish(wqVar);
        AppMethodBeat.o(113750);
    }
}
