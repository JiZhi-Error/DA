package com.tencent.xweb.util;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import org.xwalk.core.Log;

public final class b {
    public static boolean bw(String str, String str2, String str3) {
        AppMethodBeat.i(156990);
        boolean verify = new a(str, str2, str3, "SHA1withECDSA").verify();
        AppMethodBeat.o(156990);
        return verify;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String SEB;
        String SEC;
        String SED;
        String SEE;

        public a(String str, String str2, String str3, String str4) {
            this.SEB = str;
            this.SEC = str2;
            this.SED = str3;
            this.SEE = str4;
        }

        public final boolean verify() {
            boolean z = false;
            AppMethodBeat.i(156989);
            try {
                PublicKey generatePublic = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(Base64.decode(this.SED, 0)));
                Signature instance = Signature.getInstance(this.SEE);
                instance.initVerify(generatePublic);
                byte[] decode = Base64.decode(this.SEC, 0);
                instance.update(this.SEB.getBytes());
                z = instance.verify(decode);
                AppMethodBeat.o(156989);
            } catch (Exception e2) {
                Log.e("ECCUtil", "verify failed " + e2.getMessage());
                AppMethodBeat.o(156989);
            }
            return z;
        }
    }
}
