package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;

public final class q {
    public static int Kwu = 2;

    public static void a(int i2, g gVar, WxaAttributes wxaAttributes, WXMediaMessage wXMediaMessage, WXMiniProgramObject wXMiniProgramObject, LinkedList<String> linkedList) {
        AppMethodBeat.i(152419);
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String str = gVar.field_appId;
            String str2 = gVar.field_appName;
            int i3 = gVar.NA() ? 1 : 0;
            int type = wXMediaMessage.getType();
            int i4 = ab.Eq(next) ? 1 : 0;
            try {
                String encode = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMiniProgramObject.webpageUrl), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                String encode2 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.title), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                String encode3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.description), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                String str3 = wxaAttributes.field_appId;
                String encode4 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMiniProgramObject.path), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                int i5 = wXMiniProgramObject.miniprogramType;
                Log.i("MicroMsg.ShareReport", i2 + "," + str + "," + str2 + "," + i3 + "," + type + "," + i4 + ",1," + next + "," + encode2 + "," + encode3 + "," + encode + "," + str3 + "," + encode4 + "," + i5);
                h.INSTANCE.a(16492, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(type), Integer.valueOf(i4), 1, next, encode2, encode3, encode, str3, encode4, Integer.valueOf(i5), "");
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            }
        }
        AppMethodBeat.o(152419);
    }

    public static void a(int i2, g gVar, WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.i(152420);
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String str = gVar.field_appId;
            String str2 = gVar.field_appName;
            int i3 = gVar.NA() ? 1 : 0;
            int type = wXMediaMessage.getType();
            int i4 = ab.Eq(next) ? 1 : 0;
            try {
                String encode = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(b(wXMediaMessage)), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                String encode2 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(c(wXMediaMessage)), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                String encode3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.title), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                String encode4 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.description), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                Log.i("MicroMsg.ShareReport", i2 + "," + str + "," + str2 + "," + i3 + "," + type + "," + i4 + ",1," + next + "," + encode3 + "," + encode4 + "," + encode + "," + "" + "," + "" + "," + "" + "," + encode2);
                h.INSTANCE.a(16492, Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Integer.valueOf(type), Integer.valueOf(i4), 1, next, encode3, encode4, encode, "", "", "", encode2);
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            }
        }
        AppMethodBeat.o(152420);
    }

    public static void mG(String str, String str2) {
        int i2;
        String str3;
        AppMethodBeat.i(152421);
        k.b HC = k.b.HC(Util.processXml(str));
        if (HC == null) {
            AppMethodBeat.o(152421);
            return;
        }
        g o = com.tencent.mm.pluginsdk.model.app.h.o(HC.appId, true, false);
        if (o == null) {
            AppMethodBeat.o(152421);
            return;
        }
        String str4 = o.field_appId;
        String str5 = o.field_appName;
        int i3 = o.NA() ? 1 : 0;
        int i4 = HC.type;
        if (ab.Eq(str2)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i5 = Kwu;
        try {
            String encode = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(HC.url), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String encode2 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(HC.title), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String encode3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(HC.description), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String str6 = HC.izj;
            String str7 = HC.izh;
            int i6 = HC.izz;
            b bVar = (b) HC.as(b.class);
            if (bVar == null || Util.isNullOrNil(bVar.songAlbumUrl)) {
                str3 = "";
            } else {
                str3 = com.tencent.mm.compatible.util.q.encode(bVar.songAlbumUrl, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            }
            Log.i("MicroMsg.ShareReport", "," + str4 + "," + str5 + "," + i3 + "," + i4 + "," + i2 + "," + i5 + "," + str2 + "," + encode2 + "," + encode3 + "," + encode + "," + str6 + "," + str7 + "," + i6 + "," + str3);
            h.INSTANCE.a(16492, "", str4, str5, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i5), str2, encode2, encode3, encode, str6, str7, Integer.valueOf(i6), str3);
            AppMethodBeat.o(152421);
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.o(152421);
        }
    }

    public static void br(Intent intent) {
        AppMethodBeat.i(152422);
        Bundle bundleExtra = intent.getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra == null) {
            AppMethodBeat.o(152422);
            return;
        }
        String stringExtra = IntentUtil.getStringExtra(intent, "Ksnsupload_appid");
        String stringExtra2 = IntentUtil.getStringExtra(intent, "Ksnsupload_appname");
        int intExtra = IntentUtil.getIntExtra(intent, "Ksnsupload_open_sdk_version", 0);
        boolean booleanExtra = IntentUtil.getBooleanExtra(intent, "KThrid_app", false);
        boolean booleanExtra2 = IntentUtil.getBooleanExtra(intent, "Ksnsupload_app_is_game", false);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.fromBundle(bundleExtra);
        WXMediaMessage wXMediaMessage = req.message;
        if (wXMediaMessage == null) {
            AppMethodBeat.o(152422);
            return;
        }
        try {
            String encode = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(b(wXMediaMessage)), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String encode2 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(c(wXMediaMessage)), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String encode3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.title), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String encode4 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.description), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            Log.i("MicroMsg.ShareReport", intExtra + "," + stringExtra + "," + stringExtra2 + "," + (booleanExtra2 ? 1 : 0) + "," + wXMediaMessage.getType() + ",2," + (booleanExtra ? 1 : 2) + ",," + encode3 + "," + encode4 + "," + encode + "," + encode2);
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[15];
            objArr[0] = Integer.valueOf(intExtra);
            objArr[1] = stringExtra;
            objArr[2] = stringExtra2;
            objArr[3] = Integer.valueOf(booleanExtra2 ? 1 : 0);
            objArr[4] = Integer.valueOf(wXMediaMessage.getType());
            objArr[5] = 2;
            objArr[6] = Integer.valueOf(booleanExtra ? 1 : 2);
            objArr[7] = "";
            objArr[8] = encode3;
            objArr[9] = encode4;
            objArr[10] = encode;
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = encode2;
            hVar.a(16492, objArr);
            AppMethodBeat.o(152422);
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.o(152422);
        }
    }

    private static String b(WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(152424);
        if (wXMediaMessage == null) {
            Log.w("MicroMsg.ShareReport", "sendImgMsg msg not img");
            AppMethodBeat.o(152424);
            return null;
        } else if (wXMediaMessage.mediaObject instanceof WXImageObject) {
            String str = ((WXImageObject) wXMediaMessage.mediaObject).imagePath;
            AppMethodBeat.o(152424);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXVideoFileObject) {
            String str2 = ((WXVideoFileObject) wXMediaMessage.mediaObject).filePath;
            AppMethodBeat.o(152424);
            return str2;
        } else if (wXMediaMessage.mediaObject instanceof WXMusicObject) {
            String str3 = ((WXMusicObject) wXMediaMessage.mediaObject).musicUrl;
            AppMethodBeat.o(152424);
            return str3;
        } else if (wXMediaMessage.mediaObject instanceof WXVideoObject) {
            String str4 = ((WXVideoObject) wXMediaMessage.mediaObject).videoUrl;
            AppMethodBeat.o(152424);
            return str4;
        } else if (wXMediaMessage.mediaObject instanceof WXWebpageObject) {
            String str5 = ((WXWebpageObject) wXMediaMessage.mediaObject).webpageUrl;
            AppMethodBeat.o(152424);
            return str5;
        } else {
            AppMethodBeat.o(152424);
            return "";
        }
    }

    private static String c(WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage == null) {
            return null;
        }
        if (wXMediaMessage.mediaObject instanceof WXMusicObject) {
            return ((WXMusicObject) wXMediaMessage.mediaObject).songAlbumUrl;
        }
        return "";
    }

    public static void a(int i2, String str, WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(152423);
        g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
        if (o == null) {
            AppMethodBeat.o(152423);
            return;
        }
        String str2 = o.field_appId;
        String str3 = o.field_appName;
        int i3 = o.NA() ? 1 : 0;
        int type = wXMediaMessage.getType();
        try {
            String encode = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(b(wXMediaMessage)), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String encode2 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(c(wXMediaMessage)), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String encode3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.title), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            String encode4 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(wXMediaMessage.description), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            Log.i("MicroMsg.ShareReport", i2 + "," + str2 + "," + str3 + "," + i3 + "," + type + ",3,1," + "" + "," + encode3 + "," + encode4 + "," + encode + "," + encode2);
            h.INSTANCE.a(16492, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), Integer.valueOf(type), 3, 1, "", encode3, encode4, encode, "", "", "", encode2);
            AppMethodBeat.o(152423);
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.o(152423);
        }
    }
}
