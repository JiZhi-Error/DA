package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ECardInfo implements Parcelable {
    public static final Parcelable.Creator<ECardInfo> CREATOR = new Parcelable.Creator<ECardInfo>() {
        /* class com.tencent.mm.plugin.wallet_core.model.ECardInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ECardInfo[] newArray(int i2) {
            return new ECardInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ECardInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70260);
            ECardInfo eCardInfo = new ECardInfo(parcel);
            AppMethodBeat.o(70260);
            return eCardInfo;
        }
    };
    public int HWQ;
    public int HWR;
    public String HWS;
    public String HWT;
    public String HWU;
    public int HWV;
    public ArrayList<String> HWW = new ArrayList<>();
    public String HWX;
    public String HWY;
    public String HWZ;
    public String HXa;
    public String dGp;
    public String egd;
    public String egh;
    public int pmM;
    public String subtitle;
    public String title;

    public ECardInfo() {
        AppMethodBeat.i(70261);
        AppMethodBeat.o(70261);
    }

    public ECardInfo(Parcel parcel) {
        AppMethodBeat.i(70262);
        this.pmM = parcel.readInt();
        this.dGp = parcel.readString();
        this.HWQ = parcel.readInt();
        this.HWR = parcel.readInt();
        this.HWS = parcel.readString();
        this.HWT = parcel.readString();
        this.HWU = parcel.readString();
        this.HWV = parcel.readInt();
        this.title = parcel.readString();
        parcel.readStringList(this.HWW);
        this.HWX = parcel.readString();
        this.HWY = parcel.readString();
        this.HWZ = parcel.readString();
        this.HXa = parcel.readString();
        this.egd = parcel.readString();
        this.subtitle = parcel.readString();
        AppMethodBeat.o(70262);
    }

    static {
        AppMethodBeat.i(70267);
        AppMethodBeat.o(70267);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(70263);
        parcel.writeInt(this.pmM);
        parcel.writeString(this.dGp);
        parcel.writeInt(this.HWQ);
        parcel.writeInt(this.HWR);
        parcel.writeString(this.HWS);
        parcel.writeString(this.HWT);
        parcel.writeString(this.HWU);
        parcel.writeInt(this.HWV);
        parcel.writeString(this.title);
        parcel.writeStringList(this.HWW);
        parcel.writeString(this.HWX);
        parcel.writeString(this.HWY);
        parcel.writeString(this.HWZ);
        parcel.writeString(this.HXa);
        parcel.writeString(this.egd);
        parcel.writeString(this.subtitle);
        AppMethodBeat.o(70263);
    }

    public static void bF(JSONObject jSONObject) {
        AppMethodBeat.i(70264);
        if (jSONObject != null) {
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_REALNAME_INFO_JSON_STRING_SYNC, jSONObject.toString());
            AppMethodBeat.o(70264);
            return;
        }
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_REALNAME_INFO_JSON_STRING_SYNC, "");
        AppMethodBeat.o(70264);
    }

    public static dju fQp() {
        AppMethodBeat.i(70265);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REALNAME_INFO_JSON_STRING_SYNC, (Object) null);
        if (!Util.isNullOrNil(str)) {
            try {
                dju dju = new dju();
                JSONObject jSONObject = new JSONObject(str);
                dju.KCl = jSONObject.optInt("guide_flag");
                dju.yXJ = jSONObject.optString("guide_wording");
                dju.lHA = jSONObject.optString("left_button_wording");
                dju.lHB = jSONObject.optString("right_button_wording");
                dju.yXK = jSONObject.optString("upload_credit_url");
                AppMethodBeat.o(70265);
                return dju;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ECardInfo", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(70265);
        return null;
    }

    public static ECardInfo fQq() {
        AppMethodBeat.i(70266);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REALNAME_INFO_JSON_STRING_SYNC, (Object) null);
        if (!Util.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("upload_reasons");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(optJSONArray.optString(i2));
                    }
                }
                if (jSONObject.has("ecard_info")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("ecard_info");
                    ECardInfo eCardInfo = new ECardInfo();
                    eCardInfo.egd = jSONObject.optString("guide_flag");
                    eCardInfo.title = jSONObject.optString("title");
                    eCardInfo.subtitle = jSONObject.optString(MessengerShareContentUtility.SUBTITLE);
                    eCardInfo.HWW = new ArrayList<>(arrayList);
                    eCardInfo.HWY = jSONObject.optString("protocol_url");
                    eCardInfo.HWZ = jSONObject.optString("left_protocol_wording");
                    eCardInfo.HXa = jSONObject.optString("right_protocol_wording");
                    eCardInfo.HWX = jSONObject.optString("done_button_wording");
                    eCardInfo.pmM = optJSONObject.optInt("ecard_open_scene", 0);
                    eCardInfo.dGp = optJSONObject.optString("ecard_type", "");
                    eCardInfo.HWQ = optJSONObject.optInt("show_check_box", 0);
                    eCardInfo.HWR = optJSONObject.optInt("check_box_selected", 0);
                    eCardInfo.HWS = optJSONObject.optString("check_box_left_wording", "");
                    eCardInfo.HWT = optJSONObject.optString("check_box_right_wording", "");
                    eCardInfo.HWU = optJSONObject.optString("check_box_url", "");
                    eCardInfo.HWV = optJSONObject.optInt("is_upload_credid", 0);
                    eCardInfo.egh = optJSONObject.optString("upload_credit_url", "");
                    AppMethodBeat.o(70266);
                    return eCardInfo;
                }
                AppMethodBeat.o(70266);
                return null;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.ECardInfo", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(70266);
        return null;
    }
}
