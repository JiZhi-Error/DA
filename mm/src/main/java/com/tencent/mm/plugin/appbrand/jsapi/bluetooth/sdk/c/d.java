package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c;

import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public String dGL;
    public int dIX;
    public SparseArray<byte[]> lNp;
    public List<ParcelUuid> lNq;
    public String lNr;
    public Map<ParcelUuid, byte[]> lNs;
    public String name;

    public d(String str, String str2) {
        this.name = str;
        this.dGL = str2;
    }

    public d(ScanResultCompat scanResultCompat) {
        SparseArray<byte[]> sparseArray;
        AppMethodBeat.i(144591);
        this.name = Util.nullAsNil(scanResultCompat.getDevice().getName());
        this.dGL = Util.nullAsNil(scanResultCompat.getDevice().getAddress());
        this.dIX = scanResultCompat.lOO;
        f fVar = scanResultCompat.lON;
        if (fVar != null) {
            if (a.bFm().lMq) {
                sparseArray = fVar.lOL;
            } else {
                sparseArray = fVar.lOH;
            }
            this.lNp = sparseArray;
            this.lNq = fVar.lOG;
            this.lNr = Util.nullAsNil(fVar.mDeviceName);
            this.lNs = fVar.lOI;
            AppMethodBeat.o(144591);
            return;
        }
        this.lNr = "";
        AppMethodBeat.o(144591);
    }

    public final JSONObject bEw() {
        AppMethodBeat.i(144592);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("deviceId", this.dGL);
        jSONObject.put("name", this.name);
        jSONObject.put("RSSI", this.dIX);
        byte[] bArr = new byte[0];
        StringBuilder sb = new StringBuilder();
        if (this.lNp != null && this.lNp.size() >= 0) {
            int i2 = 0;
            byte[] bArr2 = bArr;
            while (i2 < this.lNp.size()) {
                int keyAt = this.lNp.keyAt(i2);
                byte[] bArr3 = {(byte) (keyAt & 255), (byte) ((keyAt >> 8) & 255)};
                byte[] valueAt = this.lNp.valueAt(i2);
                byte[] bArr4 = new byte[(bArr2.length + 2 + valueAt.length)];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
                System.arraycopy(bArr3, 0, bArr4, bArr2.length, 2);
                System.arraycopy(valueAt, 0, bArr4, bArr2.length + 2, valueAt.length);
                i2++;
                bArr2 = bArr4;
            }
            bArr = bArr2;
        }
        sb.append(new String(Base64.encode(bArr, 2)));
        jSONObject.put("advertisData", sb);
        JSONArray jSONArray = new JSONArray();
        if (this.lNq != null) {
            for (ParcelUuid parcelUuid : this.lNq) {
                jSONArray.put(parcelUuid.getUuid().toString().toUpperCase());
            }
        }
        jSONObject.put("advertisServiceUUIDs", jSONArray);
        jSONObject.put("localName", this.lNr);
        JSONObject jSONObject2 = new JSONObject();
        if (this.lNs != null && this.lNs.size() > 0) {
            for (ParcelUuid parcelUuid2 : this.lNs.keySet()) {
                jSONObject2.put(parcelUuid2.getUuid().toString().toUpperCase(), new String(Base64.encode(this.lNs.get(parcelUuid2), 2)));
            }
        }
        jSONObject.put("serviceData", jSONObject2);
        AppMethodBeat.o(144592);
        return jSONObject;
    }
}
