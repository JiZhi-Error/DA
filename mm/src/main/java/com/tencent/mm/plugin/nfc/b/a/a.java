package com.tencent.mm.plugin.nfc.b.a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.plugin.nfc.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b {
    private static a AEg = null;
    private Set<String> AEh;
    public d AEi = null;

    public static a exw() {
        AppMethodBeat.i(26656);
        if (AEg == null) {
            AEg = new a();
        }
        a aVar = AEg;
        AppMethodBeat.o(26656);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.nfc.b.b
    public final boolean a(Tag tag) {
        AppMethodBeat.i(26657);
        super.a(tag);
        this.AEh = new HashSet();
        String[] techList = tag.getTechList();
        for (String str : techList) {
            Log.d("MicroMsg.ApduEngine", "[NFC]tech : ".concat(String.valueOf(str)));
            this.AEh.add(str);
        }
        try {
            if (this.AEi != null && this.AEi.isConnected()) {
                this.AEi.close();
            }
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.ApduEngine", e2, "", new Object[0]);
            Log.e("MicroMsg.ApduEngine", e2.toString());
        }
        if (this.AEh.contains(IsoDep.class.getName())) {
            this.AEi = new b(tag);
            AppMethodBeat.o(26657);
            return true;
        } else if (this.AEh.contains(NfcA.class.getName())) {
            this.AEi = new c(tag);
            AppMethodBeat.o(26657);
            return true;
        } else {
            Log.i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
            AppMethodBeat.o(26657);
            return false;
        }
    }

    public final c a(com.tencent.mm.plugin.nfc.a.a aVar) {
        AppMethodBeat.i(26658);
        com.tencent.mm.plugin.nfc.b.a aVar2 = new com.tencent.mm.plugin.nfc.b.a(1, "def", aVar);
        a(aVar2);
        c cVar = aVar2.AEd;
        AppMethodBeat.o(26658);
        return cVar;
    }

    private boolean a(com.tencent.mm.plugin.nfc.b.a aVar) {
        AppMethodBeat.i(26659);
        if (this.AEi == null) {
            Log.e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
            IllegalStateException illegalStateException = new IllegalStateException("ApduEngine not ready !");
            AppMethodBeat.o(26659);
            throw illegalStateException;
        } else if (aVar == null || aVar.AEc == null) {
            Log.e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("apdu is null !");
            AppMethodBeat.o(26659);
            throw illegalArgumentException;
        } else {
            Log.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] do cmd : " + aVar.AEc.toString());
            aVar.AEd = b(aVar.AEc);
            if (aVar.AEd.exv()) {
                Log.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> OK : " + aVar.AEd.toString());
                AppMethodBeat.o(26659);
                return true;
            }
            Log.e("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> fail : " + aVar.AEd.toString());
            AppMethodBeat.o(26659);
            return false;
        }
    }

    private c b(com.tencent.mm.plugin.nfc.a.a aVar) {
        AppMethodBeat.i(26660);
        c a2 = this.AEi.a(aVar);
        AppMethodBeat.o(26660);
        return a2;
    }

    public final boolean b(List<com.tencent.mm.plugin.nfc.b.a> list, boolean z, boolean z2) {
        AppMethodBeat.i(26661);
        for (com.tencent.mm.plugin.nfc.b.a aVar : list) {
            boolean a2 = a(aVar);
            if (!a2 && z) {
                AppMethodBeat.o(26661);
                return false;
            } else if (a2 && z2) {
                AppMethodBeat.o(26661);
                return false;
            }
        }
        AppMethodBeat.o(26661);
        return true;
    }

    public final int gI(Context context) {
        AppMethodBeat.i(26662);
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        if (defaultAdapter == null) {
            Log.i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
            AppMethodBeat.o(26662);
            return 0;
        } else if (!defaultAdapter.isEnabled()) {
            AppMethodBeat.o(26662);
            return 1;
        } else if (this.AEi == null) {
            AppMethodBeat.o(26662);
            return 4;
        } else {
            try {
                if (this.AEi == null || !this.AEi.isConnected()) {
                    AppMethodBeat.o(26662);
                    return 2;
                }
                AppMethodBeat.o(26662);
                return 3;
            } catch (IOException e2) {
                Log.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e2.toString());
                AppMethodBeat.o(26662);
                return 2;
            }
        }
    }

    public final int gJ(Context context) {
        AppMethodBeat.i(26663);
        int gI = gI(context);
        if (gI == 3 || gI == 2) {
            try {
                if (this.AEi != null) {
                    this.AEi.connect();
                    if (this.AEi.isConnected()) {
                        AppMethodBeat.o(26663);
                        return 3;
                    }
                }
                AppMethodBeat.o(26663);
                return 2;
            } catch (IOException e2) {
                Log.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e2.toString());
                AppMethodBeat.o(26663);
                return 2;
            }
        } else {
            AppMethodBeat.o(26663);
            return gI;
        }
    }

    public final String getInfo() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        AppMethodBeat.i(26664);
        if (this.AEe == null) {
            Log.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
            AppMethodBeat.o(26664);
            return null;
        }
        long nowMilliSecond = Util.nowMilliSecond();
        JSONObject jSONObject3 = new JSONObject();
        Log.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: mTechList = " + this.AEh.size());
        for (String str : this.AEh) {
            Log.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: tech = ".concat(String.valueOf(str)));
            try {
                if (str.equals(NfcA.class.getName())) {
                    NfcA nfcA = NfcA.get(this.AEe);
                    if (nfcA == null) {
                        Log.w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject();
                        jSONObject2.put("atqa", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(nfcA.getAtqa()));
                        jSONObject2.put("sak", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.c.a.b(nfcA.getSak())));
                    }
                    jSONObject3.put(NfcA.class.getSimpleName(), jSONObject2);
                } else if (str.equals(IsoDep.class.getName())) {
                    IsoDep isoDep = IsoDep.get(this.AEe);
                    if (isoDep == null) {
                        Log.w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
                        jSONObject = null;
                    } else {
                        jSONObject = new JSONObject();
                        jSONObject.put("hiLayerResponse", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(isoDep.getHiLayerResponse()));
                        jSONObject.put("historicalBytes", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(isoDep.getHistoricalBytes()));
                    }
                    jSONObject3.put(IsoDep.class.getSimpleName(), jSONObject);
                }
            } catch (JSONException e2) {
                Log.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + e2.getLocalizedMessage());
                String jSONObject4 = jSONObject3.toString();
                AppMethodBeat.o(26664);
                return jSONObject4;
            }
        }
        Log.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (Util.nowMilliSecond() - nowMilliSecond));
        Log.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + jSONObject3.toString());
        String jSONObject5 = jSONObject3.toString();
        AppMethodBeat.o(26664);
        return jSONObject5;
    }
}
