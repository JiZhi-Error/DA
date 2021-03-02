package com.tencent.mm.crash;

import android.content.Intent;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMIntentService;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import junit.framework.Assert;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class CrashUploaderService extends MMIntentService {
    static final HashMap<String, Integer> gNk;

    public CrashUploaderService() {
        super("CrashUploaderService");
        AppMethodBeat.i(145673);
        if (BuildInfo.DEBUG) {
            Log.e("MicroMsg.CrashUploaderService", "CrashUploaderService Name : %s", CrashUploaderService.class.getName());
            Assert.assertTrue("CrashUploaderService name mismatch!!!", CrashUploaderService.class.getName().endsWith(".crash.CrashUploaderService"));
        }
        AppMethodBeat.o(145673);
    }

    static {
        AppMethodBeat.i(145677);
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        gNk = hashMap;
        hashMap.put("exception", 10001);
        gNk.put("anr", 10002);
        gNk.put("handler", Integer.valueOf((int) ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL));
        gNk.put(SharePluginInfo.ISSUE_KEY_SQL, Integer.valueOf((int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL));
        gNk.put("permission", 10005);
        AppMethodBeat.o(145677);
    }

    @Override // com.tencent.mm.service.MMIntentService
    public final void onHandleIntent(Intent intent) {
        AppMethodBeat.i(145674);
        if (intent == null) {
            AppMethodBeat.o(145674);
            return;
        }
        String stringExtra = intent.getStringExtra("INTENT_EXTRA_EXCEPTION_MSG");
        String stringExtra2 = intent.getStringExtra("INTENT_EXTRA_USER_NAME");
        String stringExtra3 = intent.getStringExtra("INTENT_EXTRA_SDCARD_PATH");
        String stringExtra4 = intent.getStringExtra("INTENT_EXTRA_DATA_PATH");
        String stringExtra5 = intent.getStringExtra("INTENT_EXTRA_UIN");
        int i2 = 0;
        try {
            i2 = Integer.decode(intent.getStringExtra("INTENT_EXTRA_CLIENT_VERSION")).intValue();
        } catch (Error e2) {
        }
        String stringExtra6 = intent.getStringExtra("INTENT_EXTRA_DEVICE_TYPE");
        String stringExtra7 = intent.getStringExtra("INTENT_EXTRA_HOST");
        String stringExtra8 = intent.getStringExtra("INTENT_EXTRA_TAG");
        if (stringExtra8 == null || stringExtra8.length() == 0) {
            stringExtra8 = "exception";
        }
        String str = (stringExtra2 + "," + stringExtra6 + "_" + i2 + "_" + Build.CPU_ABI + ",") + "exception,time_" + Util.nowSecond() + ",error_" + stringExtra;
        try {
            o oVar = new o(stringExtra3);
            if (!oVar.exists()) {
                oVar.mkdirs();
            } else {
                o[] het = oVar.het();
                if (het != null) {
                    for (o oVar2 : het) {
                        if (Util.milliSecondsToNow(oVar2.lastModified()) > 2592000000L) {
                            oVar2.delete();
                        }
                    }
                }
            }
            Date date = new Date();
            i(stringExtra3 + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt", str, stringExtra5);
        } catch (Exception e3) {
        }
        o oVar3 = new o(stringExtra4);
        if (!oVar3.exists()) {
            oVar3.mkdirs();
        }
        String str2 = stringExtra4 + stringExtra5;
        o oVar4 = new o(str2);
        if (oVar4.exists()) {
            if (oVar4.length() > 262144) {
                oVar4.delete();
            }
            byte[] aW = s.aW(str2, 0, -1);
            if (Util.isNullOrNil(aW)) {
                oVar4.delete();
                AppMethodBeat.o(145674);
                return;
            } else if (a(stringExtra2, aW, i2, stringExtra6, stringExtra7, stringExtra8)) {
                oVar4.delete();
            }
        }
        String str3 = stringExtra4 + stringExtra5 + "_nf/";
        o oVar5 = new o(str3);
        if (!oVar5.exists()) {
            oVar5.mkdirs();
        }
        i(str3 + "__" + i2 + "__" + System.currentTimeMillis(), str, stringExtra5);
        a(oVar5, stringExtra2, stringExtra6, stringExtra7, stringExtra8);
        AppMethodBeat.o(145674);
    }

    public static void a(o oVar, String str, String str2, String str3, String str4) {
        String[] split;
        AppMethodBeat.i(196101);
        o[] het = oVar.het();
        for (o oVar2 : het) {
            if (!(oVar2 == null || (split = oVar2.getName().split("__")) == null || split.length < 2)) {
                byte[] aW = s.aW(aa.z(oVar2.mUri), 0, -1);
                if (Util.isNullOrNil(aW)) {
                    oVar2.delete();
                } else if (a(str, aW, Integer.parseInt(split[1]), str2, str3, str4)) {
                    oVar2.delete();
                }
            }
        }
        AppMethodBeat.o(196101);
    }

    private static void i(String str, String str2, String str3) {
        AppMethodBeat.i(145675);
        if (!new o(str).exists()) {
            StringBuilder sb = new StringBuilder();
            if (Util.isNullOrNil(str3) || str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                sb.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
            } else {
                sb.append("uin[" + str3 + "] ");
            }
            sb.append(Log.getSysInfo());
            sb.append(" BRAND:[" + Build.BRAND + "] ");
            sb.append("\n");
            byte[] bytes = sb.toString().getBytes();
            s.e(str, bytes, bytes.length);
        }
        byte[] bytes2 = (str2 + "\n").getBytes();
        s.e(str, bytes2, bytes2.length);
        AppMethodBeat.o(145675);
    }

    private static boolean a(String str, byte[] bArr, int i2, String str2, String str3, String str4) {
        AppMethodBeat.i(145676);
        int length = bArr.length;
        String lowerCase = g.getMessageDigest(String.format("weixin#$()%d%d", Integer.valueOf(i2), Integer.valueOf(length)).getBytes()).toLowerCase();
        byte[] compress = com.tencent.mm.b.s.compress(bArr);
        PByteArray pByteArray = new PByteArray();
        c.a(pByteArray, compress, lowerCase.getBytes());
        StringBuilder append = new StringBuilder().append(str3).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(i2)).append("&devicetype=").append(str2).append("&filelength=").append(length).append("&sum=").append(lowerCase).append("&reporttype=1&NewReportType=").append(Util.nullAsNil(gNk.get(str4)));
        if (str != null && !str.equals("")) {
            append.append("&username=").append(str);
        }
        try {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(append.toString());
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            Log.i("MicroMsg.CrashUploaderService", Util.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
            AppMethodBeat.o(145676);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CrashUploaderService", e2, "", new Object[0]);
            AppMethodBeat.o(145676);
            return false;
        }
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.CrashUploaderService";
    }
}
