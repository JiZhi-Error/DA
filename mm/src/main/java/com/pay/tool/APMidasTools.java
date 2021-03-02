package com.pay.tool;

import android.text.TextUtils;
import com.pay.http.APPluginUrlConf;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.comm.APLog;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.conn.ConnectTimeoutException;

public class APMidasTools {
    static long lastClickTime = 0;

    public static boolean isFastClick() {
        AppMethodBeat.i(193311);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < 3000) {
            AppMethodBeat.o(193311);
            return true;
        }
        lastClickTime = currentTimeMillis;
        AppMethodBeat.o(193311);
        return false;
    }

    public static String urlEncode(String str, int i2) {
        String str2;
        AppMethodBeat.i(193312);
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            APLog.i("urlEncode", "编码内容为空");
        } else if (i2 <= 0) {
            AppMethodBeat.o(193312);
            return str;
        } else {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    str2 = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    APLog.i("urlEncode", e2.toString());
                    str2 = str3;
                }
                i3++;
                str3 = str2;
                str = str2;
            }
        }
        AppMethodBeat.o(193312);
        return str3;
    }

    public static String urlDecode(String str, int i2) {
        String str2;
        AppMethodBeat.i(193313);
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            APLog.w("", "解码内容为空");
        } else if (i2 <= 0) {
            AppMethodBeat.o(193313);
            return str;
        } else {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    APLog.i("urlEncode", e2.toString());
                    str2 = str3;
                }
                i3++;
                str3 = str2;
                str = str2;
            }
        }
        AppMethodBeat.o(193313);
        return str3;
    }

    public static String getUrlParamsValue(String str, String str2) {
        AppMethodBeat.i(193314);
        String[] split = str.split("[?]");
        if (split.length <= 1 || split[1] == null) {
            AppMethodBeat.o(193314);
            return null;
        }
        for (String str3 : split[1].split("[&]")) {
            String[] split2 = str3.split("[=]");
            String str4 = (split2.length <= 1 || split2[0] == null) ? null : split2[0];
            String str5 = (split2.length <= 1 || split2[1] == null) ? null : split2[1];
            if (str4 != null && str4.compareToIgnoreCase(str2) == 0) {
                AppMethodBeat.o(193314);
                return str5;
            }
        }
        AppMethodBeat.o(193314);
        return null;
    }

    public static String map2UrlParams(HashMap<String, String> hashMap) {
        AppMethodBeat.i(193315);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue());
                stringBuffer.append("&");
            }
            if (!TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        } catch (Exception e2) {
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(193315);
        return stringBuffer2;
    }

    public static String getSysServerDomain() {
        AppMethodBeat.i(193316);
        String str = APMidasPayAPI.env;
        if (str.equals(APMidasPayAPI.ENV_DEV)) {
            AppMethodBeat.o(193316);
            return APPluginUrlConf.UNIPAY_DEV_DOMAIN;
        } else if (str.equals(APMidasPayAPI.ENV_TEST)) {
            AppMethodBeat.o(193316);
            return APPluginUrlConf.UNIPAY_SANDBOX_DOMAIN;
        } else {
            AppMethodBeat.o(193316);
            return "api.unipay.qq.com";
        }
    }

    public static String getUUID() {
        AppMethodBeat.i(193317);
        String str = "";
        try {
            str = UUID.randomUUID().toString();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(193317);
        return str;
    }

    public static String getCurrentThreadName(Thread thread) {
        AppMethodBeat.i(193318);
        String name = thread.getName();
        AppMethodBeat.o(193318);
        return name;
    }

    public static long getTimeInterval(long j2, long j3) {
        return j3 - j2;
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        if (iOException instanceof ZipException) {
            return -54;
        }
        return -2;
    }
}
