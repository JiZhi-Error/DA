package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class k {
    public static void a(d dVar, Context context, boolean z) {
        int i2 = 4;
        AppMethodBeat.i(28323);
        if (dVar == null) {
            AppMethodBeat.o(28323);
            return;
        }
        switch (dVar.field_type) {
            case 6:
                String str = dVar.field_username;
                bg.aVF();
                as Kn = c.aSN().Kn(str);
                if (Kn != null) {
                    Intent intent = new Intent();
                    if (com.tencent.mm.contact.c.oR(Kn.field_type) && Kn.gBM()) {
                        ag.bah().MT(str);
                        if (dVar.field_distance.equals("1")) {
                            intent.putExtra("Chat_User", str);
                            intent.putExtra("finish_direct", true);
                            a.jRt.d(intent, context);
                            AppMethodBeat.o(28323);
                            return;
                        }
                    }
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("force_get_contact", true);
                    com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    AppMethodBeat.o(28323);
                    return;
                }
                break;
            case 7:
                Intent intent2 = new Intent();
                int i3 = 18;
                if (z) {
                    i3 = 26;
                }
                intent2.putExtra("geta8key_scene", i3);
                intent2.putExtra("stastic_scene", 6);
                intent2.putExtra("KAppId", "wxaf060266bfa9a35c");
                Bundle bundle = new Bundle();
                bundle.putString("jsapi_args_appid", "wxaf060266bfa9a35c");
                intent2.putExtra("jsapiargs", bundle);
                intent2.putExtra("rawUrl", dVar.field_username);
                intent2.putExtra("srcUsername", dVar.field_distance);
                a.jRt.i(intent2, context);
                AppMethodBeat.o(28323);
                return;
            case 8:
                Intent intent3 = new Intent();
                intent3.setClass(context, TVInfoUI.class);
                intent3.putExtra("key_TV_xml_bytes", dVar.field_lvbuffer);
                intent3.putExtra("key_TV_come_from_shake", true);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "handleRedirect", "(Lcom/tencent/mm/plugin/shake/model/ShakeItem;Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(28323);
                return;
            case 9:
                je jeVar = new je();
                jeVar.dNT.actionCode = 11;
                jeVar.dNT.result = dVar.field_username;
                jeVar.dNT.context = context;
                jeVar.callback = null;
                EventCenter.instance.asyncPublish(jeVar, Looper.myLooper());
                AppMethodBeat.o(28323);
                return;
            case 10:
                Intent intent4 = new Intent();
                intent4.putExtra("key_product_id", dVar.field_username);
                intent4.putExtra("key_product_scene", 9);
                com.tencent.mm.br.c.b(context, "product", ".ui.MallProductUI", intent4);
                AppMethodBeat.o(28323);
                return;
            case 12:
                if (!z) {
                    i2 = 3;
                }
                a(dVar.field_distance, dVar.field_username, i2, context);
                AppMethodBeat.o(28323);
                return;
            case 13:
                String str2 = dVar.field_username;
                String str3 = dVar.field_reserved3;
                int i4 = dVar.field_reserved2;
                if (!Util.isNullOrNil(str2)) {
                    wq wqVar = new wq();
                    wqVar.ecI.userName = str2;
                    wqVar.ecI.ecK = Util.nullAs(str3, "");
                    wqVar.ecI.ecL = 0;
                    wqVar.ecI.scene = 1039;
                    wqVar.ecI.appVersion = i4;
                    EventCenter.instance.publish(wqVar);
                    Log.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", wqVar.ecI.userName, wqVar.ecI.ecK, Integer.valueOf(wqVar.ecI.scene), Integer.valueOf(wqVar.ecI.ecL), Integer.valueOf(wqVar.ecI.appVersion));
                    break;
                } else {
                    Log.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
                    AppMethodBeat.o(28323);
                    return;
                }
        }
        AppMethodBeat.o(28323);
    }

    public static boolean XA(int i2) {
        return 7 == i2 || 6 == i2 || 8 == i2 || 9 == i2 || 10 == i2 || 12 == i2 || 13 == i2;
    }

    public static boolean eUk() {
        AppMethodBeat.i(28324);
        if (ac.jOt) {
            AppMethodBeat.o(28324);
            return true;
        }
        String value = h.aqJ().getValue("ShowShakeTV");
        Log.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", value);
        if (Util.isNullOrNil(value) || !value.equals("1")) {
            AppMethodBeat.o(28324);
            return false;
        }
        AppMethodBeat.o(28324);
        return true;
    }

    public static void a(String str, String str2, int i2, Context context) {
        AppMethodBeat.i(28325);
        if (!Util.isNullOrNil(str2)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str2));
            int i3 = 16;
            if (i2 == 3 || i2 == 4) {
                i3 = 17;
            }
            intent.putExtra("translate_link_scene", i3);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/shake/shakemedia/model/ShakeTVLogic", "doShakeTvOpenTempSession", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            Log.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12108, Util.nullAsNil(str), Integer.valueOf(i2), 1);
            AppMethodBeat.o(28325);
            return;
        }
        AppMethodBeat.o(28325);
    }
}
