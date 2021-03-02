package com.tencent.mm.plugin.multitask.f;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.ui.e;

public final class b {
    public static void a(Intent intent, fah fah) {
        AppMethodBeat.i(200271);
        Bundle bundle = new Bundle();
        bundle.putString("title", fah.title);
        bundle.putString("webpageTitle", fah.Nwj);
        bundle.putBoolean("hide_option_menu", fah.Nwk);
        bundle.putBoolean("translate_webview", fah.Nwl);
        bundle.putString("srcUsername", fah.eag);
        bundle.putString("srcDisplayname", fah.eah);
        bundle.putInt("mode", fah.mode);
        bundle.putString("KTemplateId", fah.Nwm);
        bundle.putString("KPublisherId", fah.Nwn);
        bundle.putInt(e.p.Ozw, fah.Nwo);
        bundle.putInt(e.p.Ozx, fah.Nwp);
        bundle.putInt("pay_channel", fah.MLG);
        bundle.putInt("key_download_restrict", fah.Nwq);
        bundle.putInt("key_wallet_region", fah.Nwr);
        bundle.putString("key_function_id", fah.Nws);
        bundle.putInt(e.p.OzA, fah.Nwt);
        bundle.putInt("geta8key_scene", fah.Nwu);
        bundle.putLong("biz_video_msg_id", fah.Nwv);
        bundle.putInt("biz_video_msg_index", fah.Nww);
        bundle.putLong("biz_video_msg_svr_id", fah.Nwx);
        bundle.putString("biz_mp_msg_info", fah.Nwy);
        bundle.putString(e.p.OzI, fah.Nwz);
        bundle.putBoolean("key_menu_hide_expose", fah.NwA);
        bundle.putString("webviewCurrentProcess", fah.NwB);
        bundle.putString("rawUrl", fah.edo);
        intent.putExtras(bundle);
        AppMethodBeat.o(200271);
    }

    public static void b(Intent intent, fah fah) {
        AppMethodBeat.i(200272);
        a(intent.getExtras(), fah);
        AppMethodBeat.o(200272);
    }

    public static void a(Bundle bundle, fah fah) {
        AppMethodBeat.i(200273);
        if (fah == null || bundle == null) {
            AppMethodBeat.o(200273);
            return;
        }
        fah.title = bundle.getString("title");
        fah.Nwj = bundle.getString("webpageTitle");
        fah.Nwk = bundle.getBoolean("hide_option_menu");
        fah.Nwl = bundle.getBoolean("translate_webview");
        fah.eag = bundle.getString("srcUsername");
        fah.eah = bundle.getString("srcDisplayname");
        fah.mode = bundle.getInt("mode");
        fah.Nwm = bundle.getString("KTemplateId");
        fah.Nwn = bundle.getString("KPublisherId");
        fah.Nwo = bundle.getInt(e.p.Ozw);
        fah.Nwp = bundle.getInt(e.p.Ozx);
        fah.MLG = bundle.getInt("pay_channel");
        fah.Nwq = bundle.getInt("key_download_restrict");
        fah.Nwr = bundle.getInt("key_wallet_region");
        fah.Nws = bundle.getString("key_function_id");
        fah.Nwt = bundle.getInt(e.p.OzA, -1);
        fah.Nwu = bundle.getInt("geta8key_scene");
        fah.Nwv = bundle.getLong("biz_video_msg_id");
        fah.Nww = bundle.getInt("biz_video_msg_index");
        fah.Nwx = bundle.getLong("biz_video_msg_svr_id");
        fah.Nwy = bundle.getString("biz_mp_msg_info");
        fah.Nwz = bundle.getString(e.p.OzI);
        fah.NwA = bundle.getBoolean("key_menu_hide_expose");
        fah.NwB = bundle.getString("webviewCurrentProcess");
        fah.edo = bundle.getString("rawUrl");
        AppMethodBeat.o(200273);
    }

    public static void a(Intent intent, aoe aoe) {
        AppMethodBeat.i(200274);
        Bundle bundle = new Bundle();
        bundle.putString("app_type", aoe.LzN);
        bundle.putString("app_media_id", aoe.LzO);
        bundle.putLong("app_msg_id", aoe.LzP);
        bundle.putBoolean("app_show_share", aoe.LzQ);
        bundle.putInt("scene", aoe.scene);
        intent.putExtras(bundle);
        AppMethodBeat.o(200274);
    }

    public static void a(Bundle bundle, aoe aoe) {
        AppMethodBeat.i(200275);
        if (bundle != null) {
            aoe.LzN = bundle.getString("app_type");
            aoe.LzO = bundle.getString("app_media_id");
            aoe.LzP = bundle.getLong("app_msg_id");
            aoe.LzQ = bundle.getBoolean("app_show_share");
            aoe.scene = bundle.getInt("scene");
            aoe.LzL = bundle.getBoolean("ifAppAttachDownloadUI");
            aoe.filePath = bundle.getString("filePath");
            aoe.gCr = bundle.getString("fileExt");
            aoe.appId = bundle.getString("appId");
            aoe.processName = bundle.getString("processName");
            aoe.lwF = bundle.getBoolean("showMenu");
        }
        AppMethodBeat.o(200275);
    }
}
