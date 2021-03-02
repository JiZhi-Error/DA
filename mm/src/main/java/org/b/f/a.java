package org.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.b.g.c;
import org.b.g.d;

public final class a implements b {
    @Override // org.b.f.b
    public final String bD(String str, String str2, String str3) {
        AppMethodBeat.i(40569);
        try {
            d.oM(str, "Base string cant be null or empty string");
            d.oM(str2, "Api secret cant be null or empty string");
            SecretKeySpec secretKeySpec = new SecretKeySpec((String.valueOf(c.encode(str2)) + '&' + c.encode(str3)).getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            String replace = new String(org.b.g.a.dy(instance.doFinal(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET)))).replace(APLogFileUtil.SEPARATOR_LINE, "");
            AppMethodBeat.o(40569);
            return replace;
        } catch (Exception e2) {
            org.b.b.d dVar = new org.b.b.d(str, e2);
            AppMethodBeat.o(40569);
            throw dVar;
        }
    }

    @Override // org.b.f.b
    public final String hQn() {
        return "HMAC-SHA1";
    }
}
