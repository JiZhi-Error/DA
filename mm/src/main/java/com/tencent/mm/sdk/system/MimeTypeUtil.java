package com.tencent.mm.sdk.system;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MimeTypeUtil {
    private static final Map<String, String> MyMimeMapExtToMime;
    private static final Map<String, String> MyMimeMapMimeToExt;

    public static final class ContentType {
        private static final String CHARSET_EQ = "charset=";
        public static final String DEFAULT_CHARSET = "UTF-8";
        private static final Pattern MIMETYPE_PATTERN = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");
        public final String charset;
        public final String mimeType;

        private ContentType(String str, String str2) {
            this.mimeType = str;
            this.charset = str2;
        }

        public final String toString() {
            AppMethodBeat.i(153465);
            String str = "ContentType{mimeType='" + this.mimeType + '\'' + ", charset='" + this.charset + '\'' + '}';
            AppMethodBeat.o(153465);
            return str;
        }

        static {
            AppMethodBeat.i(153467);
            AppMethodBeat.o(153467);
        }

        public static ContentType obtain(String str) {
            String str2 = null;
            AppMethodBeat.i(153466);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(153466);
                return null;
            }
            Matcher matcher = MIMETYPE_PATTERN.matcher(str);
            if (!matcher.find()) {
                AppMethodBeat.o(153466);
                return null;
            }
            String group = matcher.group(0);
            if (str.contains(CHARSET_EQ)) {
                str2 = str.substring(str.indexOf(CHARSET_EQ) + 8).trim();
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = DEFAULT_CHARSET;
            }
            ContentType contentType = new ContentType(group, str2);
            AppMethodBeat.o(153466);
            return contentType;
        }
    }

    static {
        AppMethodBeat.i(153471);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("silk", "audio/silk"));
        arrayList.add(new Pair("jpg", "image/jpeg"));
        arrayList.add(new Pair("json", "application/json"));
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            hashMap.put(pair.first, pair.second);
            hashMap2.put(pair.second, pair.first);
        }
        MyMimeMapExtToMime = Collections.unmodifiableMap(hashMap);
        MyMimeMapMimeToExt = Collections.unmodifiableMap(hashMap2);
        AppMethodBeat.o(153471);
    }

    public static String getMimeTypeByFileExt(String str) {
        AppMethodBeat.i(153468);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(153468);
            return null;
        }
        String str2 = MyMimeMapExtToMime.get(str.toLowerCase());
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (!TextUtils.isEmpty(str2) || !"mp3".equals(str)) {
            AppMethodBeat.o(153468);
            return str2;
        }
        AppMethodBeat.o(153468);
        return "audio/mpeg";
    }

    public static String getMimeTypeByFilePath(String str) {
        AppMethodBeat.i(153469);
        String mimeTypeByFileExt = getMimeTypeByFileExt(getFileExtByFilePath(str));
        AppMethodBeat.o(153469);
        return mimeTypeByFileExt;
    }

    public static String getFileExtByFilePath(String str) {
        AppMethodBeat.i(214368);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(214368);
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) {
            AppMethodBeat.o(214368);
            return null;
        }
        String substring = str.substring(lastIndexOf + 1);
        AppMethodBeat.o(214368);
        return substring;
    }

    public static String getExtByMimeType(String str) {
        AppMethodBeat.i(153470);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(153470);
            return null;
        }
        String lowerCase = str.toLowerCase();
        String str2 = MyMimeMapMimeToExt.get(lowerCase);
        if (TextUtils.isEmpty(str2)) {
            str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        if (TextUtils.isEmpty(str2)) {
            if ("audio/mpeg".equals(lowerCase)) {
                AppMethodBeat.o(153470);
                return "mp3";
            } else if ("audio/mp3".equals(lowerCase)) {
                AppMethodBeat.o(153470);
                return "mp3";
            } else if ("audio/mp4".equals(lowerCase)) {
                AppMethodBeat.o(153470);
                return "mp4";
            } else if ("application/pdf".equals(lowerCase)) {
                AppMethodBeat.o(153470);
                return "pdf";
            } else if ("image/jpeg".equals(lowerCase)) {
                AppMethodBeat.o(153470);
                return "jpg";
            }
        }
        AppMethodBeat.o(153470);
        return str2;
    }
}
