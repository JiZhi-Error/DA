package com.tencent.mm.ui.h.a;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.c;
import com.tencent.xweb.d;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class f {
    private static String l(Bundle bundle, String str) {
        AppMethodBeat.i(152834);
        if (bundle == null) {
            AppMethodBeat.o(152834);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            if (bundle.getByteArray(str2) == null) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + bundle.getString(str2));
                sb.append("\r\n--" + str + APLogFileUtil.SEPARATOR_LINE);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(152834);
        return sb2;
    }

    public static String bw(Bundle bundle) {
        AppMethodBeat.i(152835);
        if (bundle == null) {
            AppMethodBeat.o(152835);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append('&');
            }
            sb.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(152835);
        return sb2;
    }

    private static Bundle bnG(String str) {
        AppMethodBeat.i(152836);
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
            }
        }
        AppMethodBeat.o(152836);
        return bundle;
    }

    public static Bundle bnH(String str) {
        AppMethodBeat.i(152837);
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle bnG = bnG(url.getQuery());
            bnG.putAll(bnG(url.getRef()));
            AppMethodBeat.o(152837);
            return bnG;
        } catch (MalformedURLException e2) {
            Bundle bundle = new Bundle();
            AppMethodBeat.o(152837);
            return bundle;
        }
    }

    public static String e(String str, String str2, Bundle bundle) {
        String Q;
        AppMethodBeat.i(152838);
        if (str2.equals("GET")) {
            str = str + "?" + bw(bundle);
        }
        Log.d("Facebook-Util", str2 + " URL: " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(g.sHCENCODEVIDEOTIMEOUT);
        httpURLConnection.setReadTimeout(g.sHCENCODEVIDEOTIMEOUT);
        httpURLConnection.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
        if (!str2.equals("GET")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                if (bundle.getByteArray(str3) != null) {
                    bundle2.putByteArray(str3, bundle.getByteArray(str3));
                }
            }
            if (!bundle.containsKey(FirebaseAnalytics.b.METHOD)) {
                bundle.putString(FirebaseAnalytics.b.METHOD, str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=".concat(String.valueOf("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(("--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + APLogFileUtil.SEPARATOR_LINE).getBytes());
            bufferedOutputStream.write(l(bundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
            bufferedOutputStream.write((APLogFileUtil.SEPARATOR_LINE + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + APLogFileUtil.SEPARATOR_LINE).getBytes());
            if (!bundle2.isEmpty()) {
                for (String str4 : bundle2.keySet()) {
                    bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str4 + "\"" + APLogFileUtil.SEPARATOR_LINE).getBytes());
                    bufferedOutputStream.write(("Content-Type: content/unknown" + APLogFileUtil.SEPARATOR_LINE + APLogFileUtil.SEPARATOR_LINE).getBytes());
                    bufferedOutputStream.write(bundle2.getByteArray(str4));
                    bufferedOutputStream.write((APLogFileUtil.SEPARATOR_LINE + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + APLogFileUtil.SEPARATOR_LINE).getBytes());
                }
            }
            bufferedOutputStream.flush();
        }
        try {
            Q = Q(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e2) {
            Q = Q(httpURLConnection.getErrorStream());
        }
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception e3) {
            Log.e("FacebookUtil", e3.getMessage());
        }
        httpURLConnection.disconnect();
        AppMethodBeat.o(152838);
        return Q;
    }

    private static String Q(InputStream inputStream) {
        AppMethodBeat.i(152839);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            sb.append(readLine);
        }
        inputStream.close();
        String sb2 = sb.toString();
        AppMethodBeat.o(152839);
        return sb2;
    }

    public static void ky(Context context) {
        AppMethodBeat.i(152840);
        d.lA(context);
        c.hsp().removeAllCookie();
        AppMethodBeat.o(152840);
    }

    public static JSONObject bnI(String str) {
        AppMethodBeat.i(152841);
        if (str.equals("false")) {
            e eVar = new e("request failed");
            AppMethodBeat.o(152841);
            throw eVar;
        }
        if (str.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            str = "{value : true}";
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("error")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("error");
            e eVar2 = new e(jSONObject2.getString("message"), jSONObject2.getString("type"), 0);
            AppMethodBeat.o(152841);
            throw eVar2;
        } else if (jSONObject.has("error_code") && jSONObject.has("error_msg")) {
            e eVar3 = new e(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString("error_code")));
            AppMethodBeat.o(152841);
            throw eVar3;
        } else if (jSONObject.has("error_code")) {
            e eVar4 = new e("request failed", "", Integer.parseInt(jSONObject.getString("error_code")));
            AppMethodBeat.o(152841);
            throw eVar4;
        } else if (jSONObject.has("error_msg")) {
            e eVar5 = new e(jSONObject.getString("error_msg"));
            AppMethodBeat.o(152841);
            throw eVar5;
        } else if (jSONObject.has("error_reason")) {
            e eVar6 = new e(jSONObject.getString("error_reason"));
            AppMethodBeat.o(152841);
            throw eVar6;
        } else {
            AppMethodBeat.o(152841);
            return jSONObject;
        }
    }

    public static void Y(Context context, String str, String str2) {
        AppMethodBeat.i(152842);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
        AppMethodBeat.o(152842);
    }
}
