package com.tencent.soter.core.c;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    public String FhU = "";
    long RPO = -1;
    private String RPP = "";
    public String RPQ = "";
    private ArrayList<String> RPR = null;
    public String signature = "";
    public int uid = -1;

    public final String toString() {
        AppMethodBeat.i(88672);
        String str = "SoterPubKeyModel{counter=" + this.RPO + ", uid=" + this.uid + ", cpu_id='" + this.FhU + '\'' + ", pub_key_in_x509='" + this.RPP + '\'' + ", rawJson='" + this.RPQ + '\'' + ", signature='" + this.signature + '\'' + '}';
        AppMethodBeat.o(88672);
        return str;
    }

    public i(String str, String str2) {
        AppMethodBeat.i(88673);
        this.RPQ = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("certs")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("certs");
                if (optJSONArray.length() < 2) {
                    d.e("Soter.SoterPubKeyModel", "certificates train not enough", new Object[0]);
                }
                d.i("Soter.SoterPubKeyModel", "certs size: [%d]", Integer.valueOf(optJSONArray.length()));
                this.RPR = new ArrayList<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.RPR.add(optJSONArray.getString(i2));
                }
                a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(this.RPR.get(0).getBytes())));
                jSONObject.put("cpu_id", this.FhU);
                jSONObject.put("uid", this.uid);
                jSONObject.put("counter", this.RPO);
                this.RPQ = jSONObject.toString();
            } else {
                this.RPO = jSONObject.optLong("counter");
                this.uid = jSONObject.optInt("uid");
                this.FhU = jSONObject.optString("cpu_id");
                this.RPP = jSONObject.optString("pub_key");
            }
        } catch (Exception e2) {
            d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
        }
        this.signature = str2;
        AppMethodBeat.o(88673);
    }

    public i(Certificate[] certificateArr) {
        AppMethodBeat.i(88674);
        if (certificateArr != null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < certificateArr.length; i2++) {
                    Certificate certificate = certificateArr[i2];
                    Base64.encodeToString(certificate.getEncoded(), 2);
                    String a2 = a.a(certificate);
                    if (i2 == 0) {
                        a((X509Certificate) certificate);
                    }
                    jSONArray.put(a2);
                    arrayList.add(a2);
                }
                this.RPR = arrayList;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("certs", jSONArray);
                jSONObject.put("cpu_id", this.FhU);
                jSONObject.put("uid", this.uid);
                jSONObject.put("counter", this.RPO);
                this.RPQ = jSONObject.toString();
            } catch (Exception e2) {
                d.e("Soter.SoterPubKeyModel", "soter: pub key model failed", new Object[0]);
                AppMethodBeat.o(88674);
                return;
            }
        }
        AppMethodBeat.o(88674);
    }

    private void a(X509Certificate x509Certificate) {
        AppMethodBeat.i(88675);
        try {
            a.a(x509Certificate, this);
            AppMethodBeat.o(88675);
        } catch (Exception e2) {
            d.e("Soter.SoterPubKeyModel", "soter: loadDeviceInfo from attestationCert failed" + e2.getStackTrace(), new Object[0]);
            AppMethodBeat.o(88675);
        }
    }
}
