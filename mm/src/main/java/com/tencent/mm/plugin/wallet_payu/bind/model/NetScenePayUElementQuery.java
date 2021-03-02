package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class NetScenePayUElementQuery extends a {
    public String IsC;
    public PayUBankcardElement IsE;

    public NetScenePayUElementQuery(String str) {
        AppMethodBeat.i(71975);
        this.IsC = str;
        HashMap hashMap = new HashMap();
        hashMap.put("card_number", str);
        setRequestData(hashMap);
        AppMethodBeat.o(71975);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 22;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(71976);
        this.IsE = new PayUBankcardElement();
        this.IsE.IsF = jSONObject.optString("bin");
        this.IsE.AOj = jSONObject.optString("bank_name");
        this.IsE.IsG = jSONObject.optString("issuer_type");
        this.IsE.cardType = jSONObject.optString("card_type");
        this.IsE.dRM = jSONObject.optString("payu_reference");
        AppMethodBeat.o(71976);
    }

    public static class PayUBankcardElement implements Parcelable {
        public String AOj = "";
        public String IsF = "";
        public String IsG = "";
        public String cardType = "";
        public String dRM = "";

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(71974);
            parcel.writeString(this.IsF);
            parcel.writeString(this.AOj);
            parcel.writeString(this.IsG);
            parcel.writeString(this.cardType);
            parcel.writeString(this.dRM);
            AppMethodBeat.o(71974);
        }
    }
}
