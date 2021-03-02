package com.tencent.smtt.sdk.c;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsOneGreyInfoHelper;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.h;
import com.tencent.smtt.utils.i;
import com.tencent.smtt.utils.l;
import com.tencent.smtt.utils.n;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f2029a;

    static /* synthetic */ String a(HttpURLConnection httpURLConnection, String str, boolean z) {
        AppMethodBeat.i(188226);
        String b2 = b(httpURLConnection, str, z);
        AppMethodBeat.o(188226);
        return b2;
    }

    static /* synthetic */ void a(Context context, String str) {
        AppMethodBeat.i(188227);
        b(context, str);
        AppMethodBeat.o(188227);
    }

    static /* synthetic */ JSONObject b(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        AppMethodBeat.i(188225);
        JSONObject c2 = c(thirdAppInfoNew, context);
        AppMethodBeat.o(188225);
        return c2;
    }

    static {
        AppMethodBeat.i(188228);
        f2029a = null;
        try {
            f2029a = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
            AppMethodBeat.o(188228);
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(188228);
        }
    }

    public static void a(final ThirdAppInfoNew thirdAppInfoNew, final Context context) {
        AppMethodBeat.i(188217);
        new Thread("HttpUtils") {
            /* class com.tencent.smtt.sdk.c.b.AnonymousClass1 */

            public final void run() {
                String str;
                String str2;
                JSONObject jSONObject;
                byte[] a2;
                AppMethodBeat.i(188216);
                com.tencent.smtt.utils.b.b(context, thirdAppInfoNew.sGuid);
                thirdAppInfoNew.sCpu = com.tencent.smtt.utils.b.b();
                if (Build.VERSION.SDK_INT < 8) {
                    AppMethodBeat.o(188216);
                    return;
                }
                if (b.f2029a == null) {
                    try {
                        b.f2029a = "65dRa93L".getBytes(ProtocolPackage.ServerEncoding);
                    } catch (UnsupportedEncodingException e2) {
                        b.f2029a = null;
                        TbsLog.e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                    }
                }
                if (b.f2029a == null) {
                    TbsLog.e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                    AppMethodBeat.o(188216);
                    return;
                }
                String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DESkEY_TOKEN, "");
                String str3 = "";
                if (!TextUtils.isEmpty(string)) {
                    str3 = string.substring(0, string.indexOf("&"));
                    str = string.substring(string.indexOf("&") + 1, string.length());
                } else {
                    str = "";
                }
                boolean z = TextUtils.isEmpty(str3) || str3.length() != 96 || TextUtils.isEmpty(str) || str.length() != 24;
                try {
                    n a3 = n.a();
                    if (z) {
                        str2 = a3.b() + h.a().b();
                    } else {
                        str2 = a3.f() + str3;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(g.sHCENCODEVIDEOTIMEOUT);
                    if (Build.VERSION.SDK_INT > 13) {
                        httpURLConnection.setRequestProperty("Connection", "close");
                    }
                    try {
                        jSONObject = b.b(thirdAppInfoNew, context);
                    } catch (Exception e3) {
                        jSONObject = null;
                    }
                    if (jSONObject == null) {
                        TbsLog.e("sdkreport", "post -- jsonData is null!");
                        AppMethodBeat.o(188216);
                        return;
                    }
                    try {
                        byte[] bytes = jSONObject.toString().getBytes(ProtocolPackage.ServerEncoding);
                        if (z) {
                            a2 = h.a().a(bytes);
                        } else {
                            a2 = h.a(bytes, str);
                        }
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(a2.length));
                        try {
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(a2);
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200) {
                                TbsLog.i("sdkreport", "Post successful!");
                                TbsLog.i("sdkreport", "SIGNATURE is " + jSONObject.getString("SIGNATURE"));
                                b.a(context, b.a(httpURLConnection, str, z));
                                new TbsDownloadUpload(context).clearUploadCode();
                                AppMethodBeat.o(188216);
                                return;
                            }
                            TbsLog.e("sdkreport", "Post failed -- not 200 code is " + httpURLConnection.getResponseCode());
                            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo.setErrorCode(126);
                            tbsLogInfo.setFailDetail(new StringBuilder().append(httpURLConnection.getResponseCode()).toString());
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                            AppMethodBeat.o(188216);
                        } catch (Throwable th) {
                            TbsLog.e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                            TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo2.setErrorCode(126);
                            tbsLogInfo2.setFailDetail(th);
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                            AppMethodBeat.o(188216);
                        }
                    } catch (Throwable th2) {
                        AppMethodBeat.o(188216);
                    }
                } catch (IOException e4) {
                    TbsLog.e("sdkreport", "Post failed -- IOException:".concat(String.valueOf(e4)));
                    AppMethodBeat.o(188216);
                } catch (AssertionError e5) {
                    TbsLog.e("sdkreport", "Post failed -- AssertionError:".concat(String.valueOf(e5)));
                    AppMethodBeat.o(188216);
                } catch (NoClassDefFoundError e6) {
                    TbsLog.e("sdkreport", "Post failed -- NoClassDefFoundError:".concat(String.valueOf(e6)));
                    AppMethodBeat.o(188216);
                }
            }
        }.start();
        AppMethodBeat.o(188217);
    }

    private static JSONObject c(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        int i2 = 1;
        AppMethodBeat.i(188218);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            jSONObject.put("APPMETADATA", thirdAppInfoNew.sMetaData);
            jSONObject.put("VERSION_CODE", thirdAppInfoNew.sVersionCode);
            jSONObject.put("CPU", thirdAppInfoNew.sCpu);
            if ("com.tencent.mm".equals(thirdAppInfoNew.sAppName) || TbsConfig.APP_QQ.equals(thirdAppInfoNew.sAppName) || TbsConfig.APP_DEMO.equals(thirdAppInfoNew.sAppName)) {
                TbsDownloadUpload tbsDownloadUpload = new TbsDownloadUpload(context);
                tbsDownloadUpload.readTbsDownloadInfo(context);
                jSONObject.put("SIGNATURE", tbsDownloadUpload.getNeedDownloadCode() + ":" + tbsDownloadUpload.getStartDownloadCode() + ":" + tbsDownloadUpload.getNeedDownloadReturn() + ":" + tbsDownloadUpload.getLocalCoreVersion());
            } else if (thirdAppInfoNew.sAppSignature == null) {
                jSONObject.put("SIGNATURE", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            if (TbsShareManager.isThirdPartyApp(context)) {
                jSONObject.put("HOST_COREVERSION", TbsShareManager.getHostCoreVersions(context));
            } else {
                jSONObject.put("HOST_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
                jSONObject.put("DECOUPLE_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
            }
            if (thirdAppInfoNew.iCoreType == 0) {
                jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
                jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
                int i3 = TbsCoreLoadStat.mLoadErrorCode;
                if (thirdAppInfoNew.localCoreVersion <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i3);
                }
                if (i3 == -1) {
                    TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            try {
                if (QbSdk.getTID() != null) {
                    if (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_QQ)) {
                        jSONObject.put("TID", i.a().a(QbSdk.getTID()));
                        jSONObject.put("TIDTYPE", 1);
                    } else if (thirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
                        jSONObject.put("TID", QbSdk.getTID());
                        jSONObject.put("TIDTYPE", 0);
                    }
                }
            } catch (Exception e2) {
            }
            if (!com.tencent.smtt.utils.b.d()) {
                i2 = 0;
            }
            jSONObject.put("IS_64BIT", i2);
            if (TbsOneGreyInfoHelper.isOneModeAvailable(context)) {
                jSONObject.put("SDK_MODE", 3);
            } else if (TbsOneGreyInfoHelper.isTbsOneModeEnable(context)) {
                jSONObject.put("SDK_MODE", 2);
            } else {
                jSONObject.put("SDK_MODE", 1);
            }
            TbsLog.d("sdkreport", "Post data:" + jSONObject.toString());
            AppMethodBeat.o(188218);
            return jSONObject;
        } catch (Exception e3) {
            TbsLog.e("sdkreport", "getPostData exception!");
            AppMethodBeat.o(188218);
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3, int i2, boolean z, long j2, boolean z2) {
        String str4;
        AppMethodBeat.i(188219);
        if (QbSdk.getSettings() == null || !QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) || !QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.d("sdkreport", "HttpUtils.doReport(): pv = ".concat(String.valueOf(i2)));
            String str5 = "";
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                TbsLog.d("sdkreport", "HttpUtils.doReport()--appInfo.packageName = " + applicationInfo.packageName);
                if (TbsConfig.APP_QQ.equals(applicationInfo.packageName)) {
                    str5 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                    TbsLog.d("sdkreport", "HttpUtils.doReport()--appVersionName = ".concat(String.valueOf(str5)));
                    if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                        str5 = str5 + "." + QbSdk.getQQBuildNumber();
                    }
                    TbsLog.d("sdkreport", "HttpUtils.doReport()--appVersionName with build number = ".concat(String.valueOf(str5)));
                }
                str4 = str5;
            } catch (Exception e2) {
                str4 = str5;
            }
            try {
                ThirdAppInfoNew thirdAppInfoNew = new ThirdAppInfoNew();
                thirdAppInfoNew.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
                n.a(context);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
                thirdAppInfoNew.sVersionCode = com.tencent.smtt.utils.b.d(context);
                String a2 = com.tencent.smtt.utils.b.a(context, TbsDownloader.TBS_METADATA);
                if (!TextUtils.isEmpty(a2)) {
                    thirdAppInfoNew.sMetaData = a2;
                }
                thirdAppInfoNew.sGuid = str;
                if (z) {
                    thirdAppInfoNew.sQua2 = str2;
                    thirdAppInfoNew.bIsSandboxMode = z2;
                } else {
                    thirdAppInfoNew.sQua2 = l.a(context);
                }
                thirdAppInfoNew.sLc = str3;
                String h2 = com.tencent.smtt.utils.b.h(context);
                String f2 = com.tencent.smtt.utils.b.f(context);
                String g2 = com.tencent.smtt.utils.b.g(context);
                String i3 = com.tencent.smtt.utils.b.i(context);
                if (f2 != null && !"".equals(f2)) {
                    thirdAppInfoNew.sImei = f2;
                }
                if (g2 != null && !"".equals(g2)) {
                    thirdAppInfoNew.sImsi = g2;
                }
                if (!TextUtils.isEmpty(i3)) {
                    thirdAppInfoNew.sAndroidID = i3;
                }
                if (h2 != null && !"".equals(h2)) {
                    thirdAppInfoNew.sMac = h2;
                }
                thirdAppInfoNew.iPv = (long) i2;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    thirdAppInfoNew.iCoreType = z ? 1 : 0;
                    if (z && z2) {
                        thirdAppInfoNew.iCoreType = 3;
                    }
                } else if (z) {
                    if (TbsShareManager.getCoreFormOwn()) {
                        thirdAppInfoNew.iCoreType = 2;
                    } else {
                        thirdAppInfoNew.iCoreType = 1;
                    }
                    if (z2) {
                        thirdAppInfoNew.iCoreType = 3;
                    }
                } else {
                    thirdAppInfoNew.iCoreType = 0;
                }
                thirdAppInfoNew.sAppVersionName = str4;
                thirdAppInfoNew.sAppSignature = b(context);
                if (!z) {
                    thirdAppInfoNew.sWifiConnectedTime = j2;
                    thirdAppInfoNew.localCoreVersion = QbSdk.getTbsVersion(context);
                }
                a(thirdAppInfoNew, context.getApplicationContext());
                AppMethodBeat.o(188219);
            } catch (Throwable th) {
                AppMethodBeat.o(188219);
            }
        } else {
            TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.o(188219);
        }
    }

    private static String b(Context context) {
        AppMethodBeat.i(188220);
        try {
            byte[] byteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (byteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(byteArray);
                byte[] digest = instance.digest();
                if (digest != null) {
                    StringBuilder sb = new StringBuilder("");
                    if (digest == null || digest.length <= 0) {
                        AppMethodBeat.o(188220);
                        return null;
                    }
                    for (int i2 = 0; i2 < digest.length; i2++) {
                        String upperCase = Integer.toHexString(digest[i2] & 255).toUpperCase();
                        if (i2 > 0) {
                            sb.append(":");
                        }
                        if (upperCase.length() < 2) {
                            sb.append(0);
                        }
                        sb.append(upperCase);
                    }
                    String sb2 = sb.toString();
                    AppMethodBeat.o(188220);
                    return sb2;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(188220);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[SYNTHETIC, Splitter:B:17:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f A[SYNTHETIC, Splitter:B:20:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7 A[SYNTHETIC, Splitter:B:43:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bc A[SYNTHETIC, Splitter:B:46:0x00bc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.net.HttpURLConnection r7, java.lang.String r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 216
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.c.b.b(java.net.HttpURLConnection, java.lang.String, boolean):java.lang.String");
    }

    private static void b(Context context, String str) {
        AppMethodBeat.i(188222);
        try {
            TbsPVConfig.releaseInstance();
            TbsPVConfig.getInstance(context).clear();
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(188222);
                return;
            }
            for (String str2 : str.split("\\|")) {
                try {
                    String[] split = str2.split("=");
                    if (split.length == 2) {
                        a(context, split[0], split[1]);
                    }
                } catch (Exception e2) {
                }
            }
            TbsPVConfig.getInstance(context).commit();
            TbsPVConfig.getInstance(context).refreshSyncMap(context);
            AppMethodBeat.o(188222);
        } catch (Exception e3) {
            AppMethodBeat.o(188222);
        }
    }

    static File a(Context context) {
        AppMethodBeat.i(188223);
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(188223);
            return file;
        }
        AppMethodBeat.o(188223);
        return null;
    }

    private static void a(Context context, String str, String str2) {
        AppMethodBeat.i(188224);
        if ("reset".equals(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str2)) {
            QbSdk.reset(context);
            AppMethodBeat.o(188224);
        } else if ("clear_sdk_timestamp".equals(str)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("sdk_status", 0);
            if (!sharedPreferences.contains(str2)) {
                TbsDownloadConfig.getInstance(context).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0L);
                TbsDownloadConfig.getInstance(context).commit();
                sharedPreferences.edit().putString("sdk_status", str2).apply();
            }
            AppMethodBeat.o(188224);
        } else if ("clear_extension_timestamp".equals(str)) {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("extension_status", 0);
            if (!sharedPreferences2.contains(str2)) {
                f.b(new File(a(context), "tbs_extension.conf"));
                sharedPreferences2.edit().putString("extension_status", str2).apply();
            }
            AppMethodBeat.o(188224);
        } else if ("clear_switch_file".equals(str)) {
            File a2 = a(context);
            if (a2 != null && a2.exists()) {
                File file = new File(a2, "tbs_switch_disable_".concat(String.valueOf(str2)));
                if (file.exists()) {
                    f.b(file);
                }
            }
            AppMethodBeat.o(188224);
        } else {
            TbsPVConfig.getInstance(context).putData(str, str2);
            AppMethodBeat.o(188224);
        }
    }
}
