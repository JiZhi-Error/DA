package com.tencent.midas.download;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APMidasRSATools;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class APMidasPluginDownloadUtils {
    private static final String TAG = "PDUtils";

    static /* synthetic */ void access$000(Context context, ArrayList arrayList) {
        AppMethodBeat.i(193257);
        writeMidasSignFile(context, arrayList);
        AppMethodBeat.o(193257);
    }

    private static ArrayList<APMidasPluginDownInfo> parseDownJson(JSONArray jSONArray) {
        AppMethodBeat.i(193251);
        if (jSONArray == null) {
            APLog.e(TAG, "Cannot parse down json! jsonArray is null!");
            AppMethodBeat.o(193251);
            return null;
        }
        try {
            int length = jSONArray.length();
            if (length == 0) {
                APLog.e(TAG, "Cannot parse down json! jsonArray length is 0!");
                AppMethodBeat.o(193251);
                return null;
            }
            ArrayList<APMidasPluginDownInfo> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                APMidasPluginDownInfo aPMidasPluginDownInfo = new APMidasPluginDownInfo();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                aPMidasPluginDownInfo.name = jSONObject.getString("file_name");
                if (TextUtils.isEmpty(aPMidasPluginDownInfo.name)) {
                    APLog.e(TAG, "Cannot parse down json! item's name is empty!");
                    AppMethodBeat.o(193251);
                    return null;
                }
                aPMidasPluginDownInfo.new_md5_encode = jSONObject.getString("update_md5");
                if (TextUtils.isEmpty(aPMidasPluginDownInfo.new_md5_encode)) {
                    APLog.e(TAG, "Cannot parse down json! item's new encode md5 is empty!");
                    AppMethodBeat.o(193251);
                    return null;
                }
                try {
                    String deCodeKey = new APMidasRSATools().deCodeKey(aPMidasPluginDownInfo.new_md5_encode);
                    aPMidasPluginDownInfo.new_md5_decode = deCodeKey.substring(deCodeKey.length() - 32);
                    APLog.d(TAG, "Parse down json! name = " + aPMidasPluginDownInfo.name + " decode md5 success!");
                } catch (Exception e2) {
                    APLog.e(TAG, "Cannot parse down json, decode md5 got exception = ".concat(String.valueOf(e2)));
                }
                if (TextUtils.isEmpty(aPMidasPluginDownInfo.new_md5_decode)) {
                    APLog.e(TAG, "Cannot parse down json! item's new decode md5 is empty!");
                    AppMethodBeat.o(193251);
                    return null;
                }
                aPMidasPluginDownInfo.full_url = jSONObject.getString("full_download_url");
                if (TextUtils.isEmpty(aPMidasPluginDownInfo.full_url)) {
                    APLog.e(TAG, "Cannot parse down json! item's full url is empty!");
                    AppMethodBeat.o(193251);
                    return null;
                }
                arrayList.add(aPMidasPluginDownInfo);
            }
            AppMethodBeat.o(193251);
            return arrayList;
        } catch (Exception e3) {
            APLog.e(TAG, "Cannot parse down json! exception = ".concat(String.valueOf(e3)));
            AppMethodBeat.o(193251);
            return null;
        }
    }

    private static JSONArray getPureH5UpdateJsAlertData(String str) {
        JSONArray jSONArray = null;
        AppMethodBeat.i(193252);
        if (!TextUtils.isEmpty(str) && str.startsWith("midassdk://") && str.length() > 11) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(11, str.length()));
                if (jSONObject.has(NativeProtocol.WEB_DIALOG_ACTION) && "update".equalsIgnoreCase(jSONObject.getString(NativeProtocol.WEB_DIALOG_ACTION)) && jSONObject.has("data") && !TextUtils.isEmpty(jSONObject.getString("data"))) {
                    jSONArray = jSONObject.getJSONArray("data");
                    AppMethodBeat.o(193252);
                    return jSONArray;
                }
            } catch (JSONException e2) {
                AppMethodBeat.o(193252);
            }
        }
        AppMethodBeat.o(193252);
        return jSONArray;
    }

    private static boolean isPureH5UpdateJsAlert(String str) {
        AppMethodBeat.i(193253);
        if (!TextUtils.isEmpty(str) && str.startsWith("midassdk://") && str.length() > 11) {
            try {
                JSONObject jSONObject = new JSONObject(str.substring(11, str.length()));
                if (jSONObject.has(NativeProtocol.WEB_DIALOG_ACTION) && "update".equalsIgnoreCase(jSONObject.getString(NativeProtocol.WEB_DIALOG_ACTION))) {
                    APLog.d(TAG, "isPureH5UpdateJsAlert msg = ".concat(String.valueOf(str)));
                    APLog.d(TAG, "isPureH5UpdateJsAlert == true!");
                    AppMethodBeat.o(193253);
                    return true;
                }
            } catch (JSONException e2) {
                AppMethodBeat.o(193253);
                return false;
            }
        }
        AppMethodBeat.o(193253);
        return false;
    }

    static boolean checkIniFileExist(File file) {
        AppMethodBeat.i(193254);
        if (file == null) {
            AppMethodBeat.o(193254);
            return false;
        } else if (!file.isDirectory()) {
            AppMethodBeat.o(193254);
            return false;
        } else {
            boolean exists = new File(file, "MidasSign.ini").exists();
            AppMethodBeat.o(193254);
            return exists;
        }
    }

    private static void writeMidasSignFile(Context context, ArrayList<APMidasPluginDownInfo> arrayList) {
        AppMethodBeat.i(193255);
        if (context == null) {
            APLog.e(TAG, "Cannot write MidasSign.ini! null context!");
            AppMethodBeat.o(193255);
        } else if (arrayList == null) {
            APLog.e(TAG, "Cannot write MidasSign.ini! null list!");
            AppMethodBeat.o(193255);
        } else if (arrayList.size() <= 0) {
            APLog.e(TAG, "Cannot write MidasSign.ini! list size error = " + arrayList.size());
            AppMethodBeat.o(193255);
        } else {
            File file = new File(context.getApplicationContext().getDir("midaspluginsTemp", 0), "MidasSign.ini");
            if (!file.exists() || file.delete()) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = arrayList.get(i2).name;
                    if (TextUtils.isEmpty(str)) {
                        APLog.e(TAG, "Cannot write MidasSign.ini! item name empty!");
                        AppMethodBeat.o(193255);
                        return;
                    }
                    String str2 = !str.endsWith(".apk") ? str + ".apk" : str;
                    String str3 = arrayList.get(i2).new_md5_encode;
                    if (TextUtils.isEmpty(str3)) {
                        APLog.e(TAG, "Cannot write MidasSign.ini! item md5 empty!");
                        AppMethodBeat.o(193255);
                        return;
                    }
                    sb.append(str2 + ":" + str3);
                    sb.append(APLogFileUtil.SEPARATOR_LINE);
                }
                String sb2 = sb.toString();
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(sb2);
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (Exception e2) {
                    APLog.e(TAG, "Write MidasSign.ini got exception = ".concat(String.valueOf(e2)));
                }
                APLog.d(TAG, "Write MidasSign.ini success!");
                AppMethodBeat.o(193255);
                return;
            }
            APLog.e(TAG, "Cannot delete old MidasSign.ini file!");
            AppMethodBeat.o(193255);
        }
    }

    public static boolean handlePureH5UpdateJsAlertLogic(final Context context, String str) {
        boolean z = false;
        AppMethodBeat.i(193256);
        if (context == null) {
            APLog.d(TAG, "Cannot handle h5 update logic! Null context!");
            AppMethodBeat.o(193256);
        } else if (TextUtils.isEmpty(str)) {
            APLog.d(TAG, "Cannot handle h5 update logic! Empty alert message!");
            AppMethodBeat.o(193256);
        } else {
            if (isPureH5UpdateJsAlert(str)) {
                z = true;
            }
            JSONArray pureH5UpdateJsAlertData = getPureH5UpdateJsAlertData(str);
            if (pureH5UpdateJsAlertData == null) {
                APLog.d(TAG, "Cannot handle h5 update logic! Not relevant message!");
                AppMethodBeat.o(193256);
            } else {
                APLog.d(TAG, "Got h5 update alert message!");
                final ArrayList<APMidasPluginDownInfo> parseDownJson = parseDownJson(pureH5UpdateJsAlertData);
                if (parseDownJson == null) {
                    APLog.d(TAG, "Got h5 update alert message! Cannot parse json to list!");
                    AppMethodBeat.o(193256);
                } else if (parseDownJson.size() <= 0) {
                    APLog.d(TAG, "Got h5 update alert message! Cannot parse json to list! Size error = " + parseDownJson.size());
                    AppMethodBeat.o(193256);
                } else {
                    APLog.d(TAG, "Got h5 update alert message! Start down lists = " + parseDownJson.toString());
                    APMidasPluginDownloadManager.startDownload(context, parseDownJson, new IAPMidasPluginDownListener() {
                        /* class com.tencent.midas.download.APMidasPluginDownloadUtils.AnonymousClass1 */

                        @Override // com.tencent.midas.download.IAPMidasPluginDownListener
                        public final void onDownloadFail(int i2) {
                        }

                        @Override // com.tencent.midas.download.IAPMidasPluginDownListener
                        public final void onDownloadSuccess() {
                            AppMethodBeat.i(193237);
                            APLog.d(APMidasPluginDownloadUtils.TAG, "Got h5 update alert message! List download success!");
                            APMidasPluginDownloadUtils.access$000(context, parseDownJson);
                            AppMethodBeat.o(193237);
                        }
                    });
                    AppMethodBeat.o(193256);
                }
            }
        }
        return z;
    }
}
