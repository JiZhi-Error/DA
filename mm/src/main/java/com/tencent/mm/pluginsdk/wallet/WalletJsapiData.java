package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WalletJsapiData implements Parcelable {
    public static final Parcelable.Creator<WalletJsapiData> CREATOR = new Parcelable.Creator<WalletJsapiData>() {
        /* class com.tencent.mm.pluginsdk.wallet.WalletJsapiData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WalletJsapiData[] newArray(int i2) {
            return new WalletJsapiData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalletJsapiData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(117567);
            WalletJsapiData walletJsapiData = new WalletJsapiData(parcel);
            AppMethodBeat.o(117567);
            return walletJsapiData;
        }
    };
    public String DWX;
    public int KxF;
    public int KxG;
    public int KxH = 0;
    public String KxI;
    public int KxJ = 0;
    public String KxK;
    public String KxL;
    public String KxM;
    public boolean KxN;
    public String KxO;
    public Map<String, String> KxP;
    public ResultReceiver KxQ;
    public String appId;
    public String dDL;
    public String dVt;
    public String dVu;
    public int dVv;
    public int dVw;
    public String extInfo;
    public String iDk;
    public int iGQ;
    public String nonceStr;
    public String packageExt;
    public String partnerId;
    public int payChannel;
    public String signType;
    public String timeStamp;
    public String url;

    public WalletJsapiData() {
    }

    public WalletJsapiData(Map<String, Object> map) {
        AppMethodBeat.i(117568);
        this.appId = (String) map.get("appId");
        this.partnerId = (String) map.get("partnerId");
        this.signType = (String) map.get("signType");
        this.nonceStr = (String) map.get("nonceStr");
        this.timeStamp = (String) map.get("timeStamp");
        this.packageExt = (String) map.get("package");
        this.dDL = (String) map.get("reqKey");
        this.KxF = Util.getInt((String) map.get("payScene"), 1);
        this.iGQ = Util.getInt((String) map.get("businessScene"), 1);
        this.dVt = (String) map.get("paySign");
        this.url = (String) map.get("url");
        this.dVu = (String) map.get("src_username");
        this.dVv = Util.getInt((String) map.get("scene"), 0);
        if (this.dVv == 0) {
            this.dVv = Util.getInt((String) map.get("pay_scene"), 0);
        }
        this.payChannel = Util.getInt((String) map.get("pay_channel"), 0);
        this.extInfo = Util.nullAsNil((String) map.get("ext_info"));
        this.KxI = Util.nullAsNil((String) map.get("token"));
        this.KxJ = Util.getInt(Util.nullAs((String) map.get("result_jump_mode"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
        this.KxK = Util.nullAsNil((String) map.get("key_appbrand_from_path"));
        this.KxL = Util.nullAsNil((String) map.get("key_appbrand_from_username"));
        this.KxM = Util.nullAsNil((String) map.get("key_appbrand_from_scene"));
        AppMethodBeat.o(117568);
    }

    public WalletJsapiData(JSONObject jSONObject) {
        AppMethodBeat.i(117569);
        this.appId = jSONObject.optString("appId");
        this.partnerId = jSONObject.optString("partnerId");
        this.signType = jSONObject.optString("signType");
        this.nonceStr = jSONObject.optString("nonceStr");
        this.timeStamp = jSONObject.optString("timeStamp");
        this.packageExt = jSONObject.optString("package");
        this.dDL = jSONObject.optString("reqKey");
        this.KxF = jSONObject.optInt("payScene", 1);
        this.iGQ = jSONObject.optInt("businessScene", 1);
        this.dVt = jSONObject.optString("paySign");
        this.iDk = jSONObject.optString("cookie");
        this.url = jSONObject.optString("url");
        this.dVu = jSONObject.optString("src_username");
        this.dVv = jSONObject.optInt("scene", 0);
        if (this.dVv == 0) {
            this.dVv = jSONObject.optInt("pay_scene", 0);
        }
        this.payChannel = jSONObject.optInt("pay_channel", 0);
        this.extInfo = jSONObject.optString("ext_info", "");
        this.KxI = jSONObject.optString("token", "");
        this.KxJ = Util.getInt(jSONObject.optString("result_jump_mode", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
        this.KxH = jSONObject.optInt("pay_for_wallet_type", 0);
        this.KxK = Util.nullAsNil(jSONObject.optString("key_appbrand_from_path"));
        this.KxL = Util.nullAsNil(jSONObject.optString("key_appbrand_from_username"));
        this.KxM = Util.nullAsNil(jSONObject.optString("key_appbrand_from_scene"));
        this.KxN = jSONObject.optBoolean("key_joint_pay", false);
        AppMethodBeat.o(117569);
    }

    public WalletJsapiData(pj pjVar) {
        AppMethodBeat.i(117570);
        if (pjVar == null || pjVar.dVs == null) {
            AppMethodBeat.o(117570);
            return;
        }
        this.appId = pjVar.dVs.appId;
        this.partnerId = pjVar.dVs.partnerId;
        this.signType = pjVar.dVs.signType;
        this.nonceStr = pjVar.dVs.nonceStr;
        this.timeStamp = pjVar.dVs.timeStamp;
        this.packageExt = pjVar.dVs.packageExt;
        this.dVt = pjVar.dVs.dVt;
        this.url = pjVar.dVs.url;
        this.dVu = pjVar.dVs.dVu;
        this.dVv = pjVar.dVs.dVv;
        this.payChannel = pjVar.dVs.payChannel;
        this.dVw = pjVar.dVs.dVw;
        AppMethodBeat.o(117570);
    }

    public static int kG(int i2, int i3) {
        return (i2 == 1037 && i3 > 0) ? i3 : i2;
    }

    public static int kH(int i2, int i3) {
        AppMethodBeat.i(117571);
        int kG = kG(i2, i3);
        if (kG == 1000 || kG == 1018 || kG == 1017 || kG == 1033) {
            kG = 0;
        } else if (kG == 1019) {
            kG = 1;
        } else if (kG == 1010) {
            kG = 5;
        } else if (kG == 1007 || kG == 1008) {
            kG = 6;
        } else if (kG == 1009) {
            kG = 7;
        } else if (kG == 1035 || kG == 1020) {
            kG = 8;
        } else if (kG == 1011 || kG == 1047 || kG == 1025) {
            kG = 12;
        } else if (kG == 1012 || kG == 1032 || kG == 1048 || kG == 1050) {
            kG = 13;
        } else if (kG == 1005 || kG == 1027 || kG == 1042 || kG == 1006) {
            kG = 15;
        } else if (kG == 1024 || kG == 1021) {
            kG = 16;
        } else if (kG == 1029 || kG == 1028) {
            kG = 23;
        } else if (kG == 1013 || kG == 1031 || kG == 1049) {
            kG = 24;
        } else if (kG == 1001 || kG == 1003) {
            kG = 25;
        } else if (kG == 1045 || kG == 1046) {
            kG = 26;
        } else if (kG == 1022) {
            kG = 27;
        } else if (kG == 1023) {
            kG = 28;
        } else if (kG == 1026) {
            kG = 29;
        } else if (kG == 1039) {
            kG = 30;
        } else if (kG == 1034 || kG == 1060) {
            kG = 31;
        } else if (kG == 1014 || kG == 1043 || kG == 1044 || kG == 1036) {
            kG = 32;
        }
        Log.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(kG));
        AppMethodBeat.o(117571);
        return kG;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(117572);
        parcel.writeString(this.appId);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.signType);
        parcel.writeString(this.nonceStr);
        parcel.writeString(this.timeStamp);
        parcel.writeString(this.packageExt);
        parcel.writeString(this.dDL);
        parcel.writeInt(this.KxF);
        parcel.writeInt(this.iGQ);
        parcel.writeString(this.dVt);
        parcel.writeString(this.iDk);
        parcel.writeString(this.url);
        parcel.writeString(this.dVu);
        parcel.writeInt(this.dVv);
        parcel.writeInt(this.dVw);
        parcel.writeInt(this.payChannel);
        parcel.writeInt(this.KxG);
        parcel.writeString(this.extInfo);
        parcel.writeInt(this.KxH);
        parcel.writeString(this.KxI);
        parcel.writeInt(this.KxJ);
        parcel.writeString(this.KxK);
        parcel.writeString(this.KxL);
        parcel.writeString(this.KxM);
        parcel.writeInt(this.KxN ? 1 : 0);
        parcel.writeString(this.DWX);
        if (this.KxP != null) {
            parcel.writeInt(this.KxP.size());
            for (Map.Entry<String, String> entry : this.KxP.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.KxO);
        if (this.KxQ != null) {
            parcel.writeString("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD");
            this.KxQ.writeToParcel(parcel, i2);
            AppMethodBeat.o(117572);
            return;
        }
        parcel.writeString(null);
        AppMethodBeat.o(117572);
    }

    protected WalletJsapiData(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(117573);
        this.appId = parcel.readString();
        this.partnerId = parcel.readString();
        this.signType = parcel.readString();
        this.nonceStr = parcel.readString();
        this.timeStamp = parcel.readString();
        this.packageExt = parcel.readString();
        this.dDL = parcel.readString();
        this.KxF = parcel.readInt();
        this.iGQ = parcel.readInt();
        this.dVt = parcel.readString();
        this.iDk = parcel.readString();
        this.url = parcel.readString();
        this.dVu = parcel.readString();
        this.dVv = parcel.readInt();
        this.dVw = parcel.readInt();
        this.payChannel = parcel.readInt();
        this.KxG = parcel.readInt();
        this.extInfo = parcel.readString();
        this.KxH = parcel.readInt();
        this.KxI = parcel.readString();
        this.KxJ = parcel.readInt();
        this.KxK = parcel.readString();
        this.KxL = parcel.readString();
        this.KxM = parcel.readString();
        this.KxN = parcel.readInt() != 1 ? false : z;
        this.DWX = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.KxP = new HashMap();
            for (int i2 = 0; i2 < readInt; i2++) {
                this.KxP.put(parcel.readString(), parcel.readString());
            }
        }
        this.KxO = parcel.readString();
        if ("PAY_SUCCESS_AHEAD_CALLBACK_RESULT_RECEIVER_MAGIC_WORD".equals(parcel.readString())) {
            this.KxQ = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }
        AppMethodBeat.o(117573);
    }

    static {
        AppMethodBeat.i(117574);
        AppMethodBeat.o(117574);
    }
}
