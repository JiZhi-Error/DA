package com.tencent.soter.core.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

public class a {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());

    static {
        AppMethodBeat.i(88645);
        AppMethodBeat.o(88645);
    }

    private static void a(BufferedWriter bufferedWriter, byte[] bArr) {
        AppMethodBeat.i(88642);
        char[] cArr = new char[64];
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = 0;
            while (i3 != 64 && i2 + i3 < bArr.length) {
                cArr[i3] = (char) bArr[i2 + i3];
                i3++;
            }
            bufferedWriter.write(cArr, 0, i3);
            bufferedWriter.write("\n");
            i2 += 64;
        }
        AppMethodBeat.o(88642);
    }

    public static String a(Certificate certificate) {
        AppMethodBeat.i(88643);
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        bufferedWriter.write("-----BEGIN " + "CERTIFICATE" + "-----");
        bufferedWriter.write("\n");
        a(bufferedWriter, Base64.encode(certificate.getEncoded(), 2));
        bufferedWriter.write("-----END " + "CERTIFICATE" + "-----");
        bufferedWriter.write("\n");
        bufferedWriter.close();
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(88643);
        return stringWriter2;
    }

    public static void a(X509Certificate x509Certificate, i iVar) {
        AppMethodBeat.i(88644);
        byte[] extensionValue = x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (extensionValue == null || extensionValue.length == 0) {
            Exception exc = new Exception("Couldn't find the keystore attestation extension data.");
            AppMethodBeat.o(88644);
            throw exc;
        }
        try {
            byte b2 = "{".getBytes()[0];
            byte b3 = "}".getBytes()[0];
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < extensionValue.length; i4++) {
                byte b4 = extensionValue[i4];
                if (b4 == b2) {
                    i3 = i4;
                } else if (b4 == b3) {
                    i2 = i4;
                }
            }
            if (i3 > 0 && i3 < i2) {
                if ($assertionsDisabled || extensionValue[i3 - 1] == (i2 - i3) + 1) {
                    int i5 = (i2 - i3) + 1;
                    byte[] bArr = new byte[i5];
                    System.arraycopy(extensionValue, i3, bArr, 0, i5);
                    String str = new String(bArr);
                    d.i("Soter.CertUtil", "soter: challenge json in attestation certificate ".concat(String.valueOf(str)), new Object[0]);
                    JSONObject jSONObject = new JSONObject(str);
                    iVar.FhU = jSONObject.getString("cpu_id");
                    iVar.uid = jSONObject.getInt("uid");
                    iVar.RPO = jSONObject.getLong("counter");
                } else {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(88644);
                    throw assertionError;
                }
            }
            AppMethodBeat.o(88644);
        } catch (Exception e2) {
            Exception exc2 = new Exception("Couldn't parse challenge json string in the attestation certificate" + e2.getStackTrace());
            AppMethodBeat.o(88644);
            throw exc2;
        }
    }
}
