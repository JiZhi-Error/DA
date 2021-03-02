package com.tencent.mm.plugin.downloader.f;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static final HashMap<Long, Integer> qJA = new HashMap<>();

    static {
        AppMethodBeat.i(89084);
        AppMethodBeat.o(89084);
    }

    public static void p(long j2, int i2) {
        AppMethodBeat.i(89074);
        qJA.put(Long.valueOf(j2), Integer.valueOf(i2));
        AppMethodBeat.o(89074);
    }

    public static void a(String str, int i2, int i3, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(89075);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.game.report.api.a.hhr.a(b.e(10737, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), 1, str, Integer.valueOf(i2), Integer.valueOf(i3), 0, 0, str2, "", str3, Integer.valueOf(getNetworkType(MMApplicationContext.getContext())), 0, 1, str4, str5));
        AppMethodBeat.o(89075);
    }

    public static void a(int i2, b bVar) {
        AppMethodBeat.i(89076);
        if (qJA.containsKey(Long.valueOf(bVar.dCa))) {
            i2 = qJA.remove(Long.valueOf(bVar.dCa)).intValue();
        }
        Log.i("MicroMsg.FileDownloadReportUtil", "report_14567, appId = %s, scene = %d, opId = %d, startSize = %d, downloadedSize = %d, totalSize = %d, downloadUrl = %s, errCode = %d, downloaderType = %d, chanelId = %s, costTime = %d, startState = %d, downloadId = %d, extInfo = %s, reservedInWifi = %d, startScene = %d, uiarea = %d, noticeId = %d, ssid = %d, downloadType = %d", bVar.appId, Integer.valueOf(bVar.scene), Integer.valueOf(i2), Long.valueOf(bVar.qJD), Long.valueOf(bVar.qJe), Long.valueOf(bVar.oJj), bVar.downloadUrl, Integer.valueOf(bVar.errCode), Integer.valueOf(bVar.dNv), bVar.channelId, Long.valueOf(bVar.costTime), Integer.valueOf(bVar.qJE), Long.valueOf(bVar.dCa), bVar.extInfo, Integer.valueOf(bVar.qJF), Integer.valueOf(bVar.qJG), Integer.valueOf(bVar.qJH), Integer.valueOf(bVar.qJI), Integer.valueOf(bVar.qJJ), Integer.valueOf(bVar.eik));
        MMApplicationContext.getContext();
        com.tencent.mm.game.report.api.a.hhr.a(b.e(14567, bVar.appId, Integer.valueOf(bVar.scene), Integer.valueOf(i2), Long.valueOf(bVar.qJe), Long.valueOf(bVar.oJj), Fh(bVar.downloadUrl), Integer.valueOf(getNetworkType(MMApplicationContext.getContext())), Integer.valueOf(bVar.errCode), Integer.valueOf(bVar.dNv), bVar.channelId, Long.valueOf(bVar.costTime), Integer.valueOf(bVar.qJE), Long.valueOf(bVar.dCa), bVar.extInfo, getDeviceInfo(), Long.valueOf(bVar.qJD), Integer.valueOf(bVar.qJF), "", Integer.valueOf(bVar.qJG), Integer.valueOf(bVar.qJH), Integer.valueOf(bVar.qJI), Integer.valueOf(bVar.qJJ), Integer.valueOf(bVar.eik), Long.valueOf(com.tencent.matrix.g.a.TK() / 1024), Long.valueOf(cBJ()), Long.valueOf(cBK())));
        h.INSTANCE.a(15015, bVar.appId, Integer.valueOf(bVar.scene), Integer.valueOf(i2), Long.valueOf(bVar.qJe), Long.valueOf(bVar.oJj), Fh(bVar.downloadUrl), Integer.valueOf(getNetworkType(MMApplicationContext.getContext())), Integer.valueOf(bVar.errCode), Integer.valueOf(bVar.dNv), bVar.channelId, Long.valueOf(bVar.costTime), Integer.valueOf(bVar.qJE), Long.valueOf(bVar.dCa), bVar.extInfo);
        AppMethodBeat.o(89076);
    }

    public static void aa(final String str, final long j2) {
        AppMethodBeat.i(89077);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(89077);
        } else if ("appid_is_empty".equals(str)) {
            h.INSTANCE.idkeyStat(860, j2, 1, false);
            AppMethodBeat.o(89077);
        } else {
            com.tencent.mm.ch.a.post(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.f.a.AnonymousClass1 */
                final /* synthetic */ long qJC = 1;

                public final void run() {
                    AppMethodBeat.i(89073);
                    g cX = com.tencent.mm.pluginsdk.model.app.h.cX(str, false);
                    if (cX != null && cX.NA()) {
                        h.INSTANCE.idkeyStat(860, j2, this.qJC, false);
                    }
                    AppMethodBeat.o(89073);
                }
            });
            AppMethodBeat.o(89077);
        }
    }

    private static String getDeviceInfo() {
        AppMethodBeat.i(89078);
        String aoz = q.aoz();
        String cBI = cBI();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IMEI", aoz);
            jSONObject.put("BLUETOOTH_ADDRESS", cBI);
        } catch (JSONException e2) {
            Log.e("MicroMsg.FileDownloadReportUtil", "getDeviceInfo: " + e2.getMessage());
        }
        String Fh = Fh(jSONObject.toString());
        AppMethodBeat.o(89078);
        return Fh;
    }

    private static String cBI() {
        AppMethodBeat.i(89079);
        try {
            String nullAsNil = Util.nullAsNil(BluetoothAdapter.getDefaultAdapter().getAddress());
            AppMethodBeat.o(89079);
            return nullAsNil;
        } catch (Exception e2) {
            Log.e("MicroMsg.FileDownloadReportUtil", "getBlueToothAddress failed: %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(89079);
            return "";
        }
    }

    private static String Fh(String str) {
        String str2;
        AppMethodBeat.i(89080);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(89080);
            return "";
        }
        try {
            str2 = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (Exception e2) {
            str2 = "";
            Log.e("MicroMsg.FileDownloadReportUtil", e2.getMessage());
        }
        AppMethodBeat.o(89080);
        return str2;
    }

    private static int getNetworkType(Context context) {
        AppMethodBeat.i(89081);
        if (NetStatusUtil.is3G(context)) {
            AppMethodBeat.o(89081);
            return 4;
        } else if (NetStatusUtil.is4G(context)) {
            AppMethodBeat.o(89081);
            return 5;
        } else {
            switch (NetStatusUtil.getNetType(context)) {
                case -1:
                    AppMethodBeat.o(89081);
                    return 255;
                case 0:
                    AppMethodBeat.o(89081);
                    return 1;
                case 1:
                case 2:
                case 3:
                case 4:
                default:
                    AppMethodBeat.o(89081);
                    return 6;
                case 5:
                    AppMethodBeat.o(89081);
                    return 2;
                case 6:
                    AppMethodBeat.o(89081);
                    return 3;
            }
        }
    }

    private static long cBJ() {
        AppMethodBeat.i(89082);
        try {
            long freeSpace = Environment.getExternalStorageDirectory().getFreeSpace() / 1048576;
            AppMethodBeat.o(89082);
            return freeSpace;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FileDownloadReportUtil", e2, "", new Object[0]);
            AppMethodBeat.o(89082);
            return 0;
        }
    }

    private static long cBK() {
        AppMethodBeat.i(89083);
        try {
            long freeSpace = Environment.getDataDirectory().getFreeSpace() / 1048576;
            AppMethodBeat.o(89083);
            return freeSpace;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FileDownloadReportUtil", e2, "", new Object[0]);
            AppMethodBeat.o(89083);
            return 0;
        }
    }
}
