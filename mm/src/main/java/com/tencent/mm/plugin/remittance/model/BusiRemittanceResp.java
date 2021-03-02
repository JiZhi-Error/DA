package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ans;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp implements Parcelable {
    public static final Parcelable.Creator<BusiRemittanceResp> CREATOR = new Parcelable.Creator<BusiRemittanceResp>() {
        /* class com.tencent.mm.plugin.remittance.model.BusiRemittanceResp.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusiRemittanceResp[] newArray(int i2) {
            return new BusiRemittanceResp[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusiRemittanceResp createFromParcel(Parcel parcel) {
            AppMethodBeat.i(67832);
            BusiRemittanceResp busiRemittanceResp = new BusiRemittanceResp(parcel);
            AppMethodBeat.o(67832);
            return busiRemittanceResp;
        }
    };
    public int Cof = 0;
    public String Cog = "";
    public String Coh = "";
    public int Coi;
    public String Coj;
    public String Cok;
    public List<ans> Col = new LinkedList();
    public rc Com;
    public int Con = 0;
    public int Coo = 0;
    public String Cop;
    public String Coq;
    public int Cor = 400;

    BusiRemittanceResp() {
        AppMethodBeat.i(67833);
        AppMethodBeat.o(67833);
    }

    BusiRemittanceResp(JSONObject jSONObject) {
        AppMethodBeat.i(67834);
        this.Cof = jSONObject.optInt("show_photo", 0);
        this.Cog = jSONObject.optString("photo_url", "");
        this.Coh = jSONObject.optString("favor_desc", "");
        this.Coi = jSONObject.optInt("scan_scene", 0);
        this.Coj = jSONObject.optString("favor_req_sign", "");
        this.Cok = jSONObject.optString("favor_req_extend", "");
        this.Cop = jSONObject.optString("paying_rcvr_info", "");
        this.Coq = jSONObject.optString("succpage_rcvr_info", "");
        this.Con = jSONObject.optInt("get_favor_flag", 0);
        this.Coo = jSONObject.optInt("photo_style", 0);
        this.Cor = jSONObject.optInt("get_favor_interval", 400);
        this.Col = b.E(jSONObject.optJSONArray("favor_list"));
        JSONObject optJSONObject = jSONObject.optJSONObject("favor_comm_resp");
        if (optJSONObject != null) {
            this.Com = new rc();
            this.Com.KXZ = optJSONObject.optString("default_fav_compose_id");
            this.Com.KXX = b.E(optJSONObject.optJSONArray("favor_info_list"));
            this.Com.KYa = optJSONObject.optString("favor_resp_sign");
            this.Com.KYb = optJSONObject.optString("no_compose_wording");
            this.Com.KXY = b.D(optJSONObject.optJSONArray("favor_compose_result_list"));
        }
        AppMethodBeat.o(67834);
    }

    protected BusiRemittanceResp(Parcel parcel) {
        AppMethodBeat.i(67835);
        this.Cof = parcel.readInt();
        this.Cog = parcel.readString();
        this.Coh = parcel.readString();
        this.Coi = parcel.readInt();
        this.Coj = parcel.readString();
        this.Cok = parcel.readString();
        this.Con = parcel.readInt();
        this.Coo = parcel.readInt();
        this.Cop = parcel.readString();
        this.Coq = parcel.readString();
        this.Cor = parcel.readInt();
        this.Col = new LinkedList();
        int readInt = parcel.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 > 0) {
                byte[] bArr = new byte[readInt2];
                parcel.readByteArray(bArr);
                try {
                    ans ans = new ans();
                    ans.parseFrom(bArr);
                    this.Col.add(ans);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
                }
            }
        }
        int readInt3 = parcel.readInt();
        if (readInt3 > 0) {
            byte[] bArr2 = new byte[readInt3];
            parcel.readByteArray(bArr2);
            this.Com = new rc();
            try {
                this.Com.parseFrom(bArr2);
                AppMethodBeat.o(67835);
                return;
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", e3, "", new Object[0]);
            }
        }
        AppMethodBeat.o(67835);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        byte[] bArr;
        AppMethodBeat.i(67836);
        parcel.writeInt(this.Cof);
        parcel.writeString(this.Cog);
        parcel.writeString(this.Coh);
        parcel.writeInt(this.Coi);
        parcel.writeString(this.Coj);
        parcel.writeString(this.Cok);
        parcel.writeInt(this.Con);
        parcel.writeInt(this.Coo);
        parcel.writeString(this.Cop);
        parcel.writeString(this.Coq);
        parcel.writeInt(this.Cor);
        parcel.writeInt(this.Col.size());
        if (this.Col.size() > 0) {
            for (int i3 = 0; i3 < this.Col.size(); i3++) {
                byte[] bArr2 = new byte[0];
                try {
                    bArr = this.Col.get(i3).toByteArray();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
                    bArr = bArr2;
                }
                parcel.writeInt(bArr.length);
                if (bArr.length > 0) {
                    parcel.writeByteArray(bArr);
                }
            }
        }
        byte[] bArr3 = new byte[0];
        try {
            bArr3 = this.Com.toByteArray();
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.BusiRemittanceResp", e3, "", new Object[0]);
        }
        parcel.writeInt(bArr3.length);
        if (bArr3.length > 0) {
            parcel.writeByteArray(bArr3);
        }
        AppMethodBeat.o(67836);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(67837);
        AppMethodBeat.o(67837);
    }
}
