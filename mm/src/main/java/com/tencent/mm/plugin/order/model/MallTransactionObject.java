package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject implements Parcelable {
    public static final Parcelable.Creator<MallTransactionObject> CREATOR = new Parcelable.Creator<MallTransactionObject>() {
        /* class com.tencent.mm.plugin.order.model.MallTransactionObject.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MallTransactionObject[] newArray(int i2) {
            return new MallTransactionObject[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MallTransactionObject createFromParcel(Parcel parcel) {
            AppMethodBeat.i(66674);
            MallTransactionObject mallTransactionObject = new MallTransactionObject(parcel);
            AppMethodBeat.o(66674);
            return mallTransactionObject;
        }
    };
    public List<MallOrderDetailObject.HelpCenter> ANM = new LinkedList();
    public int ANN = -1;
    public String ANP;
    public String ANX;
    public String ANY;
    public String ANZ;
    public int AOA;
    public String AOB;
    public int AOC;
    public int AOD;
    public int AOE;
    public String AOF;
    public String AOG;
    public String AOH;
    public String AOI;
    public String AOJ;
    public String AOK;
    public double AOL;
    public String AOM;
    public String AOa;
    public String AOb;
    public String AOc;
    public String AOd;
    public String AOe;
    public String AOf;
    public String AOg;
    public int AOh;
    public String AOi;
    public String AOj;
    public String AOk;
    public String AOl;
    public String AOm;
    public String AOn;
    public String AOo;
    public String AOp;
    public double AOq;
    public String AOr;
    public String AOs;
    public String AOt;
    public String AOu;
    public String AOv;
    public int AOw;
    public int AOx;
    public double AOy;
    public String AOz;
    public String dCu;
    public String dDM;
    public String desc;
    public int dyc;
    public int efQ;
    public int iXu;
    public String jyi;
    public double qwJ = 0.0d;
    public int subType;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallTransactionObject() {
        AppMethodBeat.i(66675);
        AppMethodBeat.o(66675);
    }

    public MallTransactionObject(Parcel parcel) {
        AppMethodBeat.i(66676);
        this.subType = parcel.readInt();
        this.efQ = parcel.readInt();
        this.dyc = parcel.readInt();
        this.ANX = parcel.readString();
        this.ANY = parcel.readString();
        this.ANZ = parcel.readString();
        this.AOa = parcel.readString();
        this.desc = parcel.readString();
        this.AOb = parcel.readString();
        this.AOc = parcel.readString();
        this.qwJ = parcel.readDouble();
        this.AOd = parcel.readString();
        this.AOe = parcel.readString();
        this.AOf = parcel.readString();
        this.AOg = parcel.readString();
        this.iXu = parcel.readInt();
        this.AOh = parcel.readInt();
        this.dDM = parcel.readString();
        this.AOi = parcel.readString();
        this.AOj = parcel.readString();
        this.AOl = parcel.readString();
        this.dCu = parcel.readString();
        this.ANP = parcel.readString();
        this.AOm = parcel.readString();
        this.jyi = parcel.readString();
        this.AOn = parcel.readString();
        this.AOo = parcel.readString();
        this.AOp = parcel.readString();
        this.AOq = parcel.readDouble();
        this.AOr = parcel.readString();
        this.AOs = parcel.readString();
        this.AOt = parcel.readString();
        this.AOu = parcel.readString();
        this.AOw = parcel.readInt();
        this.AOC = parcel.readInt();
        this.AOy = parcel.readDouble();
        this.AOz = parcel.readString();
        this.AOA = parcel.readInt();
        this.AOB = parcel.readString();
        this.AOC = parcel.readInt();
        this.AOD = parcel.readInt();
        this.AOE = parcel.readInt();
        this.AOF = parcel.readString();
        this.AOG = parcel.readString();
        this.AOH = parcel.readString();
        this.AOI = parcel.readString();
        this.AOJ = parcel.readString();
        this.AOK = parcel.readString();
        this.AOL = parcel.readDouble();
        this.AOM = parcel.readString();
        this.AOv = parcel.readString();
        this.ANN = parcel.readInt();
        int readInt = parcel.readInt();
        this.ANM = new LinkedList();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.ANM.add((MallOrderDetailObject.HelpCenter) parcel.readParcelable(MallOrderDetailObject.HelpCenter.class.getClassLoader()));
        }
        AppMethodBeat.o(66676);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(66677);
        parcel.writeInt(this.subType);
        parcel.writeInt(this.efQ);
        parcel.writeInt(this.dyc);
        parcel.writeString(this.ANX);
        parcel.writeString(this.ANY);
        parcel.writeString(this.ANZ);
        parcel.writeString(this.AOa);
        parcel.writeString(this.desc);
        parcel.writeString(this.AOb);
        parcel.writeString(this.AOc);
        parcel.writeDouble(this.qwJ);
        parcel.writeString(this.AOd);
        parcel.writeString(this.AOe);
        parcel.writeString(this.AOf);
        parcel.writeString(this.AOg);
        parcel.writeInt(this.iXu);
        parcel.writeInt(this.AOh);
        parcel.writeString(this.dDM);
        parcel.writeString(this.AOi);
        parcel.writeString(this.AOj);
        parcel.writeString(this.AOl);
        parcel.writeString(this.dCu);
        parcel.writeString(this.ANP);
        parcel.writeString(this.AOm);
        parcel.writeString(this.jyi);
        parcel.writeString(this.AOn);
        parcel.writeString(this.AOo);
        parcel.writeString(this.AOp);
        parcel.writeDouble(this.AOq);
        parcel.writeString(this.AOr);
        parcel.writeString(this.AOs);
        parcel.writeString(this.AOt);
        parcel.writeString(this.AOu);
        parcel.writeInt(this.AOw);
        parcel.writeInt(this.AOC);
        parcel.writeDouble(this.AOy);
        parcel.writeString(this.AOz);
        parcel.writeInt(this.AOA);
        parcel.writeString(this.AOB);
        parcel.writeInt(this.AOC);
        parcel.writeInt(this.AOD);
        parcel.writeInt(this.AOE);
        parcel.writeString(this.AOF);
        parcel.writeString(this.AOG);
        parcel.writeString(this.AOH);
        parcel.writeString(this.AOI);
        parcel.writeString(this.AOJ);
        parcel.writeString(this.AOK);
        parcel.writeDouble(this.AOL);
        parcel.writeString(this.AOM);
        parcel.writeString(this.AOv);
        parcel.writeInt(this.ANN);
        parcel.writeInt(this.ANM.size());
        for (MallOrderDetailObject.HelpCenter helpCenter : this.ANM) {
            parcel.writeParcelable(helpCenter, i2);
        }
        AppMethodBeat.o(66677);
    }

    static {
        AppMethodBeat.i(66680);
        AppMethodBeat.o(66680);
    }

    public static MallTransactionObject bh(JSONObject jSONObject) {
        AppMethodBeat.i(66678);
        if (jSONObject != null) {
            MallTransactionObject mallTransactionObject = new MallTransactionObject();
            mallTransactionObject.type = jSONObject.optInt("rec_type", 1);
            mallTransactionObject.subType = jSONObject.optInt("sub_pay_type", 0);
            mallTransactionObject.efQ = jSONObject.optInt("pay_scene");
            mallTransactionObject.dyc = jSONObject.optInt("user_type");
            mallTransactionObject.ANX = jSONObject.optString("buy_uin");
            mallTransactionObject.ANY = jSONObject.optString("buy_name");
            mallTransactionObject.ANZ = jSONObject.optString("sale_uin");
            mallTransactionObject.AOa = jSONObject.optString("sale_name");
            mallTransactionObject.dDM = jSONObject.optString("trans_id");
            mallTransactionObject.AOi = jSONObject.optString("sp_billno");
            mallTransactionObject.desc = jSONObject.optString("goods_name");
            mallTransactionObject.AOb = jSONObject.optString("goods_detail");
            mallTransactionObject.qwJ = jSONObject.optDouble("fee") / 100.0d;
            mallTransactionObject.AOd = jSONObject.optString("fee_color");
            mallTransactionObject.AOe = jSONObject.optString("trade_state");
            mallTransactionObject.AOf = jSONObject.optString("trade_state_name");
            mallTransactionObject.AOg = jSONObject.optString("trade_state_color");
            mallTransactionObject.AOj = jSONObject.optString("buy_bank_name");
            mallTransactionObject.AOk = jSONObject.optString("card_tail");
            mallTransactionObject.iXu = jSONObject.optInt("create_timestamp");
            mallTransactionObject.AOh = jSONObject.optInt("modify_timestamp");
            mallTransactionObject.AOl = jSONObject.optString("fee_type");
            JSONObject optJSONObject = jSONObject.optJSONObject("appinfo");
            if (optJSONObject != null) {
                mallTransactionObject.dCu = optJSONObject.optString("app_username");
                mallTransactionObject.ANP = optJSONObject.optString("app_telephone");
                mallTransactionObject.AOm = optJSONObject.optString("app_nickname");
                mallTransactionObject.jyi = optJSONObject.optString("app_icon_url");
                mallTransactionObject.AOu = optJSONObject.optString("safeguard_url");
                mallTransactionObject.AOv = optJSONObject.optString(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
            }
            mallTransactionObject.AOn = jSONObject.optString("deliver_price");
            mallTransactionObject.AOo = jSONObject.optString("preferential_price");
            mallTransactionObject.AOp = jSONObject.optString("discount");
            mallTransactionObject.AOq = jSONObject.optDouble("original_total_fee") / 100.0d;
            mallTransactionObject.AOr = jSONObject.optString("total_price");
            mallTransactionObject.AOs = jSONObject.optString("receipt_company");
            mallTransactionObject.AOt = jSONObject.optString("biz_pledge");
            mallTransactionObject.AOw = jSONObject.optInt("pre_fetch_timestamp");
            mallTransactionObject.AOx = jSONObject.optInt("arrived_timestamp");
            mallTransactionObject.AOy = jSONObject.optDouble("transfer_fee") / 100.0d;
            mallTransactionObject.AOz = jSONObject.optString("receiver_name");
            mallTransactionObject.AOA = jSONObject.optInt("allow_resend_msg");
            mallTransactionObject.AOB = jSONObject.optString("charge_fee");
            mallTransactionObject.AOC = jSONObject.optInt("receive_timestamp");
            mallTransactionObject.AOD = jSONObject.optInt("refund_timestamp");
            mallTransactionObject.AOE = jSONObject.optInt("create_timestamp");
            mallTransactionObject.AOF = jSONObject.optString("buy_bank_type");
            mallTransactionObject.AOG = jSONObject.optString("payer_name");
            mallTransactionObject.AOH = jSONObject.optString("true_name");
            mallTransactionObject.AOI = jSONObject.optString("refund_bank_type");
            mallTransactionObject.AOJ = jSONObject.optString("rateinfo");
            mallTransactionObject.AOK = jSONObject.optString("original_feeinfo");
            mallTransactionObject.AOL = jSONObject.optDouble("fetch_total_fee") / 100.0d;
            mallTransactionObject.AOM = jSONObject.optString("fetch_total_fee_color");
            mallTransactionObject.ANN = jSONObject.optInt("userroll_type");
            mallTransactionObject.ANM = bi(jSONObject);
            AppMethodBeat.o(66678);
            return mallTransactionObject;
        }
        AppMethodBeat.o(66678);
        return null;
    }

    private static List<MallOrderDetailObject.HelpCenter> bi(JSONObject jSONObject) {
        AppMethodBeat.i(66679);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("help_center");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                MallOrderDetailObject.HelpCenter helpCenter = new MallOrderDetailObject.HelpCenter();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                helpCenter.dEF = jSONObject2.optBoolean("is_show_button");
                helpCenter.name = jSONObject2.optString("name");
                helpCenter.url = jSONObject2.optString("url");
                linkedList.add(helpCenter);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MallTransactionObject", e2, "", new Object[0]);
            Log.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", e2.getMessage());
        }
        AppMethodBeat.o(66679);
        return linkedList;
    }
}
