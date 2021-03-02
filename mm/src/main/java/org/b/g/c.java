package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.b.b.b;

public final class c {
    private static String CHARSET = MimeTypeUtil.ContentType.DEFAULT_CHARSET;
    private static final Map<String, String> UiM;

    static {
        AppMethodBeat.i(40580);
        HashMap hashMap = new HashMap();
        hashMap.put("*", "%2A");
        hashMap.put("+", "%20");
        hashMap.put("%7E", "~");
        UiM = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(40580);
    }

    public static String encode(String str) {
        AppMethodBeat.i(40581);
        d.j(str, "Cannot encode null object");
        try {
            String encode = URLEncoder.encode(str, CHARSET);
            for (Map.Entry<String, String> entry : UiM.entrySet()) {
                encode = encode.replaceAll(Pattern.quote(entry.getKey()), entry.getValue());
            }
            AppMethodBeat.o(40581);
            return encode;
        } catch (UnsupportedEncodingException e2) {
            b bVar = new b("Charset not found while encoding string: " + CHARSET, e2);
            AppMethodBeat.o(40581);
            throw bVar;
        }
    }

    public static String decode(String str) {
        AppMethodBeat.i(40582);
        d.j(str, "Cannot decode null object");
        try {
            String decode = URLDecoder.decode(str, CHARSET);
            AppMethodBeat.o(40582);
            return decode;
        } catch (UnsupportedEncodingException e2) {
            b bVar = new b("Charset not found while decoding string: " + CHARSET, e2);
            AppMethodBeat.o(40582);
            throw bVar;
        }
    }
}
