package com.tencent.mm.plugin.wepkg.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void b(String str, String str2, String str3, String str4, long j2, long j3, String str5) {
        String str6;
        AppMethodBeat.i(110781);
        Log.d("MicroMsg.WePkgReport", "reportWepkgLogicKv, scene = %s, url = %s, pkgId = %s, version = %s, resultCode = %d, costTime = %d, extInfo = %s", str, str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3), str5);
        try {
            if (Util.isNullOrNil(str5)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DownloadInfo.NETTYPE, NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
                str6 = URLEncoder.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } else {
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(str5, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                jSONObject2.put(DownloadInfo.NETTYPE, NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
                str6 = URLEncoder.encode(jSONObject2.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            }
            try {
                if (!Util.isNullOrNil(str2)) {
                    str2 = URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            str6 = str5;
        }
        h.INSTANCE.a(13980, str, str2, str3, str4, Long.valueOf(j2), str6, Long.valueOf(j3));
        AppMethodBeat.o(110781);
    }

    public static void c(String str, int i2, String str2, long j2) {
        AppMethodBeat.i(110782);
        com.tencent.mm.plugin.wepkg.b.a bcj = b.gkD().bcj(str);
        if (bcj != null) {
            com.tencent.mm.game.report.api.a.hhr.a(new com.tencent.mm.game.report.api.b(14229, s(str, bcj.field_version, 0, Integer.valueOf(i2), 0, 0, str2, "", bcj.field_oldVersion, 4, Long.valueOf(j2), Integer.valueOf(bcj.field_pkgSize))));
        }
        AppMethodBeat.o(110782);
    }

    public static String s(Object... objArr) {
        AppMethodBeat.i(110783);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 11; i2++) {
            sb.append(String.valueOf(objArr[i2])).append(',');
        }
        sb.append(String.valueOf(objArr[11]));
        String sb2 = sb.toString();
        AppMethodBeat.o(110783);
        return sb2;
    }

    public static String bcN(String str) {
        AppMethodBeat.i(110784);
        if (str == null) {
            AppMethodBeat.o(110784);
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            String encode = URLEncoder.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(110784);
            return encode;
        } catch (JSONException e2) {
            Log.e("MicroMsg.WePkgReport", e2.getMessage());
            AppMethodBeat.o(110784);
            return "";
        } catch (UnsupportedEncodingException e3) {
            Log.e("MicroMsg.WePkgReport", e3.getMessage());
            AppMethodBeat.o(110784);
            return "";
        }
    }

    public static String ahr(int i2) {
        AppMethodBeat.i(110785);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subCode", i2);
            String encode = URLEncoder.encode(jSONObject.toString(), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(110785);
            return encode;
        } catch (UnsupportedEncodingException | JSONException e2) {
            AppMethodBeat.o(110785);
            return null;
        }
    }
}
