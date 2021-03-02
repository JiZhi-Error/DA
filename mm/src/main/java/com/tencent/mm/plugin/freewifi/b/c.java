package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static final String[] wOg = {TPDownloadProxyEnum.USER_SSID, TPDownloadProxyEnum.USER_BSSID, "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds"};
    private static final String[] wOh = {"errcode", "errmsg", "maxApCount", "intervalSeconds"};
    private int wOi;
    private int wOj;
    private long wOk;

    /* synthetic */ c(byte b2) {
        this();
    }

    static /* synthetic */ void a(c cVar, fw fwVar, int i2, String str) {
        AppMethodBeat.i(24758);
        cVar.a(fwVar, i2, str);
        AppMethodBeat.o(24758);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static c wOp = new c((byte) 0);

        static {
            AppMethodBeat.i(24751);
            AppMethodBeat.o(24751);
        }
    }

    private c() {
        this.wOi = 200;
        this.wOj = TXLiveConstants.RENDER_ROTATION_180;
        this.wOk = 0;
    }

    public static c dMR() {
        AppMethodBeat.i(24752);
        c cVar = a.wOp;
        AppMethodBeat.o(24752);
        return cVar;
    }

    public final synchronized void a(final fw fwVar) {
        synchronized (this) {
            AppMethodBeat.i(24753);
            Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + dMS() + "; reqIntervalSeconds=" + dMT());
            String[] strArr = fwVar.dJq.dJs;
            if (strArr == null || strArr.length == 0) {
                a(fwVar, 1101, "Args is empty.");
                AppMethodBeat.o(24753);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    sb.append("args[" + i2 + "] = " + strArr[i2]);
                }
                Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + sb.toString());
                try {
                    if (Integer.valueOf(strArr[0]).intValue() != 1) {
                        a(fwVar, 1103, "Wechant installed currently only supports version 1.");
                        AppMethodBeat.o(24753);
                    } else if (strArr.length != 3) {
                        a(fwVar, 1104, "Args.length should be 3, but now it is " + strArr.length + ".");
                        AppMethodBeat.o(24753);
                    } else {
                        try {
                            final int intValue = Integer.valueOf(strArr[2]).intValue();
                            if (intValue != 1 && intValue != 2) {
                                a(fwVar, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
                                AppMethodBeat.o(24753);
                            } else if (dMU() != 0 && System.currentTimeMillis() - dMU() < ((long) dMT()) && intValue == 2) {
                                a(fwVar, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.wOj + " seconds.");
                                AppMethodBeat.o(24753);
                            } else if (m.eP(strArr[1])) {
                                a(fwVar, 1105, "Args[1] should be an ap list json string, but now it is empty.");
                                AppMethodBeat.o(24753);
                            } else {
                                final LinkedList linkedList = new LinkedList();
                                try {
                                    JSONArray jSONArray = new JSONArray(strArr[1]);
                                    if (jSONArray.length() > dMS()) {
                                        a(fwVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + dMS() + ".");
                                        AppMethodBeat.o(24753);
                                    } else if (jSONArray.length() == 0) {
                                        a(fwVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + dMS() + ".");
                                        AppMethodBeat.o(24753);
                                    } else {
                                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                                            cmj cmj = new cmj();
                                            cmj.ssid = m.removeSsidQuote(jSONObject.getString(TPDownloadProxyEnum.USER_SSID));
                                            cmj.bssid = jSONObject.getString(TPDownloadProxyEnum.USER_BSSID);
                                            cmj.dIX = jSONObject.getInt("rssi");
                                            linkedList.add(cmj);
                                        }
                                        new j(linkedList, intValue).c(new i() {
                                            /* class com.tencent.mm.plugin.freewifi.b.c.AnonymousClass1 */

                                            /* JADX WARNING: Removed duplicated region for block: B:46:0x02bb  */
                                            @Override // com.tencent.mm.ak.i
                                            /* Code decompiled incorrectly, please refer to instructions dump. */
                                            public final void onSceneEnd(int r12, int r13, java.lang.String r14, com.tencent.mm.ak.q r15) {
                                                /*
                                                // Method dump skipped, instructions count: 873
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.b.c.AnonymousClass1.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
                                            }
                                        });
                                        AppMethodBeat.o(24753);
                                    }
                                } catch (Exception e2) {
                                    a(fwVar, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
                                    AppMethodBeat.o(24753);
                                }
                            }
                        } catch (Exception e3) {
                            a(fwVar, 1107, "Args[2] is not a valid int value.");
                            AppMethodBeat.o(24753);
                        }
                    }
                } catch (Exception e4) {
                    a(fwVar, 1102, "Args[0] is not an integer.");
                    AppMethodBeat.o(24753);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.mm.g.a.fw r9, int r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 137
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.b.c.a(com.tencent.mm.g.a.fw, int, java.lang.String):void");
    }

    public final synchronized int dMS() {
        int i2;
        AppMethodBeat.i(24755);
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.wOi);
        i2 = this.wOi;
        AppMethodBeat.o(24755);
        return i2;
    }

    public final synchronized void Nc(int i2) {
        AppMethodBeat.i(24756);
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = ".concat(String.valueOf(i2)));
        this.wOi = i2;
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.wOi);
        AppMethodBeat.o(24756);
    }

    public final synchronized int dMT() {
        return this.wOj;
    }

    public final synchronized void Nd(int i2) {
        this.wOj = i2;
    }

    private synchronized long dMU() {
        return this.wOk;
    }

    public final synchronized void GB(long j2) {
        this.wOk = j2;
    }

    static /* synthetic */ void a(fw fwVar, MatrixCursor matrixCursor) {
        AppMethodBeat.i(24757);
        Log.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setResult. errorcode=%d, errmsg=%s", 1, null);
        fwVar.dJr.dJt = matrixCursor;
        fwVar.dJr.dIY = 1;
        if (fwVar.callback != null) {
            fwVar.callback.run();
        }
        AppMethodBeat.o(24757);
    }
}
