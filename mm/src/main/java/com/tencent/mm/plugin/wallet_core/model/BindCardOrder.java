package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class BindCardOrder implements Parcelable {
    public static final Parcelable.Creator<BindCardOrder> CREATOR = new Parcelable.Creator<BindCardOrder>() {
        /* class com.tencent.mm.plugin.wallet_core.model.BindCardOrder.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BindCardOrder[] newArray(int i2) {
            return new BindCardOrder[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BindCardOrder createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70238);
            BindCardOrder bindCardOrder = new BindCardOrder(parcel);
            AppMethodBeat.o(70238);
            return bindCardOrder;
        }
    };
    public static int HWp = 1;
    public static int HWq = 2;
    public static int HWr = 6;
    public s HWA;
    public s.a HWB;
    public s.b HWC;
    private String HWo = "";
    public int HWs;
    public String HWt = "";
    public String HWu = "";
    public String HWv = "";
    public String HWw = "";
    public String HWx = "";
    public int HWy;
    public int HWz;
    public String dDj;
    public int jumpType;

    static {
        AppMethodBeat.i(70242);
        AppMethodBeat.o(70242);
    }

    public BindCardOrder() {
    }

    protected BindCardOrder(Parcel parcel) {
        AppMethodBeat.i(70239);
        this.HWo = parcel.readString();
        try {
            bB(new JSONObject(this.HWo));
            AppMethodBeat.o(70239);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BindCardOrder", e2, "", new Object[0]);
            AppMethodBeat.o(70239);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70240);
        parcel.writeString(this.HWo);
        AppMethodBeat.o(70240);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean fQi() {
        return this.jumpType == HWp && this.HWB != null;
    }

    public final boolean fQj() {
        return this.jumpType == HWq && this.HWC != null;
    }

    public final boolean fQk() {
        return this.jumpType == HWr && this.HWB != null;
    }

    public final void bB(JSONObject jSONObject) {
        AppMethodBeat.i(70241);
        this.HWo = jSONObject == null ? "" : jSONObject.toString();
        Log.i("MicroMsg.BindCardOrder", "feed json %s", this.HWo);
        try {
            this.HWs = jSONObject.optInt("show_bind_succ_page", 0);
            this.HWt = jSONObject.optString("bind_succ_btn_wording", "");
            this.HWu = jSONObject.optString("bind_succ_remind_wording", "");
            this.jumpType = jSONObject.optInt("jump_type", 0);
            this.HWx = jSONObject.optString("bind_serial");
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_info");
            this.HWA = new s();
            if (optJSONObject != null) {
                this.HWA.bK(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("h5_info");
            if (optJSONObject2 != null) {
                this.HWB = new s.a();
                this.HWB.bK(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("native_info");
            if (optJSONObject3 != null) {
                this.HWB = new s.a();
                this.HWB.bK(optJSONObject3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tinyapp_info");
            if (optJSONObject4 != null) {
                this.HWC = new s.b();
                this.HWC.bK(optJSONObject4);
            }
            AppMethodBeat.o(70241);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BindCardOrder", e2, "", new Object[0]);
            AppMethodBeat.o(70241);
        }
    }
}
