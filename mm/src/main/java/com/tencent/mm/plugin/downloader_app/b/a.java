package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void a(int i2, int i3, int i4, int i5, String str, String str2, String str3) {
        AppMethodBeat.i(8921);
        Log.d("MicroMsg.DownloadReporter", "kv16099, sceneId = %d, areaId = %d, positionId = %d, actionId = %d, appId = %s,noticeId = %s, extInfo = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, str2, str3);
        h.INSTANCE.a(16099, Integer.valueOf(bAX()), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, str2, str3);
        AppMethodBeat.o(8921);
    }

    private static int bAX() {
        AppMethodBeat.i(8922);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            AppMethodBeat.o(8922);
            return 0;
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(8922);
            return 4;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(8922);
            return 3;
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(8922);
            return 2;
        } else {
            AppMethodBeat.o(8922);
            return 1;
        }
    }

    public static int Fq(int i2) {
        switch (i2) {
            case 2:
                return 1002;
            case 3:
            case 5:
            default:
                return 0;
            case 4:
                return 1003;
            case 6:
                return 1004;
        }
    }

    public static String fH(String str, String str2) {
        AppMethodBeat.i(8923);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
        }
        String str3 = "";
        try {
            str3 = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e3) {
        }
        AppMethodBeat.o(8923);
        return str3;
    }
}
