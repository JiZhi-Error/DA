package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    private static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:\\s*bytes=(\\d*)\\s*-\\s*(\\d*)");
    public static HashMap<String, Map<String, String>> mzW = new HashMap<>();
    private BufferedReader bzE;
    private String logTag;
    private LinkedHashMap<String, String> mzS = new LinkedHashMap<>();
    private LinkedHashMap<String, String> mzT = new LinkedHashMap<>();
    private int[] mzU = new int[2];
    private ArrayList<String> mzV = new ArrayList<>();
    public String mzy;

    static {
        AppMethodBeat.i(234848);
        AppMethodBeat.o(234848);
    }

    public f(InputStream inputStream, String str) {
        AppMethodBeat.i(234838);
        this.bzE = new BufferedReader(new InputStreamReader(inputStream));
        this.logTag = str + "HttpParser";
        try {
            bKa();
            AppMethodBeat.o(234838);
        } catch (IOException e2) {
            h.log(6, this.logTag, "error parsing request " + h.i(e2));
            AppMethodBeat.o(234838);
        }
    }

    private void bKa() {
        AppMethodBeat.i(234839);
        String str = null;
        String readLine = this.bzE.readLine();
        h.log(4, this.logTag, "parseRequest:".concat(String.valueOf(readLine)));
        if (readLine == null || readLine.length() == 0) {
            h.log(6, this.logTag, "initial is not valid");
            AppMethodBeat.o(234839);
        } else if (Character.isWhitespace(readLine.charAt(0))) {
            h.log(6, this.logTag, "character first char is whitespace");
            AppMethodBeat.o(234839);
        } else {
            String[] split = readLine.split("\\s");
            if (split.length != 3) {
                h.log(6, this.logTag, "cmd.length is not 3");
                AppMethodBeat.o(234839);
                return;
            }
            this.mzV.add(readLine);
            this.mzy = split[0];
            if (split[2].indexOf("HTTP/") == 0 && split[2].indexOf(46) > 5) {
                str = split[2];
            } else if (split[0].indexOf("HTTP/") == 0 && split[0].indexOf(46) > 5) {
                str = split[0];
            }
            if (str != null) {
                String[] split2 = str.substring(5).split("\\.");
                try {
                    this.mzU[0] = Integer.parseInt(split2[0]);
                    this.mzU[1] = Integer.parseInt(split2[1]);
                } catch (NumberFormatException e2) {
                    h.log(6, this.logTag, "error parsing request NumberFormatException:" + h.i(e2));
                    AppMethodBeat.o(234839);
                    return;
                }
            }
            if (split[0].equals("GET") || split[0].equals("HEAD")) {
                int indexOf = split[1].indexOf(63);
                if (indexOf >= 0) {
                    String[] split3 = split[1].substring(indexOf + 1).split("&");
                    this.mzT = new LinkedHashMap<>();
                    for (int i2 = 0; i2 < split3.length; i2++) {
                        String[] split4 = split3[i2].split("=");
                        if (split4.length == 2) {
                            this.mzT.put(URLDecoder.decode(split4[0], MimeTypeUtil.ContentType.DEFAULT_CHARSET), URLDecoder.decode(split4[1], MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                        } else if (split4.length == 1 && split3[i2].indexOf(61) == split3[i2].length() - 1) {
                            this.mzT.put(URLDecoder.decode(split4[0], MimeTypeUtil.ContentType.DEFAULT_CHARSET), "");
                        }
                    }
                }
            } else if (!split[0].equals("POST") && !split[0].equals("OPTIONS") && !split[0].equals("PUT") && !split[0].equals("DELETE") && !split[0].equals("TRACE")) {
                split[0].equals("CONNECT");
            }
            bKb();
            AppMethodBeat.o(234839);
        }
    }

    private void bKb() {
        AppMethodBeat.i(234840);
        StringBuilder sb = new StringBuilder();
        String readLine = this.bzE.readLine();
        sb.append(readLine).append("|");
        while (true) {
            if (readLine.equals("")) {
                break;
            }
            int indexOf = readLine.indexOf(58);
            if (indexOf < 0) {
                this.mzS = null;
                break;
            }
            this.mzS.put(readLine.substring(0, indexOf).toLowerCase().trim(), readLine.substring(indexOf + 1).trim());
            this.mzV.add(readLine);
            readLine = this.bzE.readLine();
            sb.append(readLine).append("|");
        }
        h.log(4, this.logTag, "parseHeaders:" + sb.toString());
        AppMethodBeat.o(234840);
    }

    public static Map<String, String> abf(String str) {
        int indexOf;
        AppMethodBeat.i(234841);
        if (TextUtils.isEmpty(str) || !mzW.containsKey(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (str != null && (indexOf = str.indexOf(63)) >= 0) {
                String[] split = str.substring(indexOf + 1).split("&");
                for (int i2 = 0; i2 < split.length; i2++) {
                    try {
                        String[] split2 = split[i2].split("=");
                        if (split2.length == 2) {
                            linkedHashMap.put(URLDecoder.decode(split2[0], MimeTypeUtil.ContentType.DEFAULT_CHARSET), URLDecoder.decode(split2[1], MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                        } else if (split2.length == 1 && split[i2].indexOf(61) == split[i2].length() - 1) {
                            linkedHashMap.put(URLDecoder.decode(split2[0], MimeTypeUtil.ContentType.DEFAULT_CHARSET), "");
                        }
                    } catch (IOException e2) {
                        h.log(5, "HttpParser", h.i(e2));
                    }
                }
                mzW.put(str, linkedHashMap);
            }
            AppMethodBeat.o(234841);
            return linkedHashMap;
        }
        Map<String, String> map = mzW.get(str);
        AppMethodBeat.o(234841);
        return map;
    }

    private static String S(Map<String, String> map) {
        AppMethodBeat.i(234842);
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                str = (str + entry.getKey()) + ": ";
            }
            str = (str + entry.getValue()) + APLogFileUtil.SEPARATOR_LINE;
        }
        AppMethodBeat.o(234842);
        return str;
    }

    public final String bKc() {
        AppMethodBeat.i(234844);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.mzV.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\n");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(234844);
        return sb2;
    }

    public final String abg(String str) {
        AppMethodBeat.i(234845);
        String str2 = this.mzT.get(str);
        AppMethodBeat.o(234845);
        return str2;
    }

    public static String a(long j2, long j3, long j4, String str, boolean z) {
        long j5;
        String str2;
        AppMethodBeat.i(234846);
        boolean z2 = j2 != -1;
        boolean z3 = !TextUtils.isEmpty(str);
        boolean z4 = j4 >= 0;
        if (!z2) {
            j5 = j4;
        } else if (j3 == -2) {
            j5 = j4 - j2;
        } else {
            if (j3 > j4 - 1) {
                h.log(5, "HttpParser", "fix rangeEnd. max=" + (j4 - 1) + " current=" + j3);
            }
            j3 = Math.min(j3, j4 - 1);
            j5 = (j3 - j2) + 1;
        }
        String str3 = ("" + (z2 ? "HTTP/1.1 206 PARTIAL CONTENT\r\n" : "HTTP/1.1 200 OK\r\n")) + "Connection: close\r\n";
        if (z4 && z2) {
            str3 = j3 == -2 ? str3 + String.format(Locale.US, "Content-Range: bytes %d-%d/%d\r\n", Long.valueOf(j2), Long.valueOf(j4 - 1), Long.valueOf(j4)) : str3 + String.format(Locale.US, "Content-Range: bytes %d-%d/%d\r\n", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }
        if (z) {
            str2 = str3 + String.format(Locale.US, "Cache-Control: max-age=%d\r\n", 10800);
        } else {
            str2 = str3 + "Cache-Control: no-cache\r\n";
        }
        StringBuilder append = new StringBuilder().append(str2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String sb = append.append("Date: " + simpleDateFormat.format(new Date()) + " GMT").append(APLogFileUtil.SEPARATOR_LINE).toString();
        if (z) {
            StringBuilder append2 = new StringBuilder().append(sb);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
            sb = append2.append("Expires: " + simpleDateFormat2.format(new Date(System.currentTimeMillis() + 10800000)) + " GMT").append(APLogFileUtil.SEPARATOR_LINE).toString();
        }
        String str4 = ((((sb + (z4 ? String.format(Locale.US, "Content-Length: %d\r\n", Long.valueOf(j5)) : "")) + "Accept-Ranges: bytes\r\n") + (z3 ? String.format("Content-Type: %s\r\n", str) : "")) + String.format("X-Server: %s\r\n", "VideoProxy 1.4.1")) + APLogFileUtil.SEPARATOR_LINE;
        if (!z2 && z3 && str.equalsIgnoreCase("video/mp4")) {
            a.bJK().mxp.Bi(j4);
        }
        AppMethodBeat.o(234846);
        return str4;
    }

    public static long[] abh(String str) {
        long j2;
        AppMethodBeat.i(234847);
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = RANGE_HEADER_PATTERN.matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                try {
                    j2 = Long.parseLong(group);
                } catch (NumberFormatException e2) {
                    j2 = 0;
                }
                try {
                    long[] jArr = {j2, Long.parseLong(group2)};
                    AppMethodBeat.o(234847);
                    return jArr;
                } catch (NumberFormatException e3) {
                    long[] jArr2 = {j2, -2};
                    AppMethodBeat.o(234847);
                    return jArr2;
                }
            }
        }
        long[] jArr3 = {-1, -1};
        AppMethodBeat.o(234847);
        return jArr3;
    }

    public static String T(Map<String, List<String>> map) {
        AppMethodBeat.i(234843);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            for (int i2 = 0; i2 < value.size(); i2++) {
                if (key != null) {
                    linkedHashMap.put(key.toLowerCase().trim(), value.get(i2));
                } else {
                    linkedHashMap.put(key, value.get(i2));
                }
            }
        }
        String S = S(linkedHashMap);
        AppMethodBeat.o(234843);
        return S;
    }
}
