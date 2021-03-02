package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.hd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class Bankcard extends hd implements Parcelable {
    public static final Parcelable.Creator<Bankcard> CREATOR = new Parcelable.Creator<Bankcard>() {
        /* class com.tencent.mm.plugin.wallet_core.model.Bankcard.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Bankcard[] newArray(int i2) {
            return new Bankcard[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Bankcard createFromParcel(Parcel parcel) {
            AppMethodBeat.i(70213);
            Bankcard bankcard = new Bankcard(parcel);
            AppMethodBeat.o(70213);
            return bankcard;
        }
    };
    public static int HVo = 1;
    public static int HVp = 2;
    public static int HVq = 4;
    public static int HVr = 8;
    public static int HVs = 16;
    public static int HVt = 32;
    public static int HVu = 64;
    public static int HVv = 128;
    public static int HVw = 256;
    public static IAutoDBItem.MAutoDBInfo info;
    public int HUQ;
    public String HUS;
    public String HVA;
    public String HVB = null;
    public double HVC;
    public String HVD;
    public double HVE;
    public String HVF;
    public String HVG;
    public String HVH;
    public String HVI;
    public String HVJ;
    public b HVK;
    public String HVL = null;
    public e HVM;
    public long HVN;
    public long HVO;
    public long HVP;
    public String HVQ;
    public int HVR;
    public int HVS;
    public String HVT;
    public String HVU;
    public int HVV;
    public String HVW;
    public long HVX;
    public String HVY;
    public String HVZ;
    public String HVx;
    public String HVy;
    public String HVz;
    public String HWa;
    public String Hwr;
    public String Hws;
    public boolean dKO = false;

    static {
        AppMethodBeat.i(70225);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[43];
        mAutoDBInfo.columns = new String[44];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "bindSerial";
        mAutoDBInfo.colsMap.put("bindSerial", "TEXT PRIMARY KEY ");
        sb.append(" bindSerial TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "bindSerial";
        mAutoDBInfo.columns[1] = "cardType";
        mAutoDBInfo.colsMap.put("cardType", "INTEGER");
        sb.append(" cardType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "bankcardState";
        mAutoDBInfo.colsMap.put("bankcardState", "INTEGER");
        sb.append(" bankcardState INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "forbidWord";
        mAutoDBInfo.colsMap.put("forbidWord", "TEXT");
        sb.append(" forbidWord TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "bankName";
        mAutoDBInfo.colsMap.put("bankName", "TEXT");
        sb.append(" bankName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "bankcardType";
        mAutoDBInfo.colsMap.put("bankcardType", "TEXT");
        sb.append(" bankcardType TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "bankcardTypeName";
        mAutoDBInfo.colsMap.put("bankcardTypeName", "TEXT");
        sb.append(" bankcardTypeName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "bankcardTag";
        mAutoDBInfo.colsMap.put("bankcardTag", "INTEGER");
        sb.append(" bankcardTag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "bankcardTail";
        mAutoDBInfo.colsMap.put("bankcardTail", "TEXT");
        sb.append(" bankcardTail TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "supportTag";
        mAutoDBInfo.colsMap.put("supportTag", "INTEGER");
        sb.append(" supportTag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "mobile";
        mAutoDBInfo.colsMap.put("mobile", "TEXT");
        sb.append(" mobile TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "trueName";
        mAutoDBInfo.colsMap.put("trueName", "TEXT");
        sb.append(" trueName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "desc";
        mAutoDBInfo.colsMap.put("desc", "TEXT");
        sb.append(" desc TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "bankPhone";
        mAutoDBInfo.colsMap.put("bankPhone", "TEXT");
        sb.append(" bankPhone TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "bizUsername";
        mAutoDBInfo.colsMap.put("bizUsername", "TEXT");
        sb.append(" bizUsername TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "onceQuotaKind";
        mAutoDBInfo.colsMap.put("onceQuotaKind", "DOUBLE");
        sb.append(" onceQuotaKind DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "onceQuotaVirtual";
        mAutoDBInfo.colsMap.put("onceQuotaVirtual", "DOUBLE");
        sb.append(" onceQuotaVirtual DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "dayQuotaKind";
        mAutoDBInfo.colsMap.put("dayQuotaKind", "DOUBLE");
        sb.append(" dayQuotaKind DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "dayQuotaVirtual";
        mAutoDBInfo.colsMap.put("dayQuotaVirtual", "DOUBLE");
        sb.append(" dayQuotaVirtual DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "fetchArriveTime";
        mAutoDBInfo.colsMap.put("fetchArriveTime", "LONG");
        sb.append(" fetchArriveTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "fetchArriveTimeWording";
        mAutoDBInfo.colsMap.put("fetchArriveTimeWording", "TEXT");
        sb.append(" fetchArriveTimeWording TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "repay_url";
        mAutoDBInfo.colsMap.put("repay_url", "TEXT");
        sb.append(" repay_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "wxcreditState";
        mAutoDBInfo.colsMap.put("wxcreditState", "INTEGER");
        sb.append(" wxcreditState INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "bankcardClientType";
        mAutoDBInfo.colsMap.put("bankcardClientType", "INTEGER");
        sb.append(" bankcardClientType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "ext_msg";
        mAutoDBInfo.colsMap.put("ext_msg", "TEXT");
        sb.append(" ext_msg TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "support_micropay";
        mAutoDBInfo.colsMap.put("support_micropay", "INTEGER");
        sb.append(" support_micropay INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "arrive_type";
        mAutoDBInfo.colsMap.put("arrive_type", "TEXT");
        sb.append(" arrive_type TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "avail_save_wording";
        mAutoDBInfo.colsMap.put("avail_save_wording", "TEXT");
        sb.append(" avail_save_wording TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[28] = "fetch_charge_rate";
        mAutoDBInfo.colsMap.put("fetch_charge_rate", "DOUBLE");
        sb.append(" fetch_charge_rate DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[29] = "full_fetch_charge_fee";
        mAutoDBInfo.colsMap.put("full_fetch_charge_fee", "DOUBLE");
        sb.append(" full_fetch_charge_fee DOUBLE");
        sb.append(", ");
        mAutoDBInfo.columns[30] = "fetch_charge_info";
        mAutoDBInfo.colsMap.put("fetch_charge_info", "TEXT");
        sb.append(" fetch_charge_info TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[31] = "tips";
        mAutoDBInfo.colsMap.put("tips", "TEXT");
        sb.append(" tips TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[32] = "forbid_title";
        mAutoDBInfo.colsMap.put("forbid_title", "TEXT");
        sb.append(" forbid_title TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[33] = "forbid_url";
        mAutoDBInfo.colsMap.put("forbid_url", "TEXT");
        sb.append(" forbid_url TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[34] = "no_micro_word";
        mAutoDBInfo.colsMap.put("no_micro_word", "TEXT");
        sb.append(" no_micro_word TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[35] = "card_bottom_wording";
        mAutoDBInfo.colsMap.put("card_bottom_wording", "TEXT");
        sb.append(" card_bottom_wording TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[36] = "support_lqt_turn_in";
        mAutoDBInfo.colsMap.put("support_lqt_turn_in", "INTEGER");
        sb.append(" support_lqt_turn_in INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[37] = "support_lqt_turn_out";
        mAutoDBInfo.colsMap.put("support_lqt_turn_out", "INTEGER");
        sb.append(" support_lqt_turn_out INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[38] = "is_hightlight_pre_arrive_time_wording";
        mAutoDBInfo.colsMap.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
        sb.append(" is_hightlight_pre_arrive_time_wording INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[39] = "card_state_name";
        mAutoDBInfo.colsMap.put("card_state_name", "TEXT");
        sb.append(" card_state_name TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[40] = "prompt_info_prompt_text";
        mAutoDBInfo.colsMap.put("prompt_info_prompt_text", "TEXT");
        sb.append(" prompt_info_prompt_text TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[41] = "prompt_info_jump_text";
        mAutoDBInfo.colsMap.put("prompt_info_jump_text", "TEXT");
        sb.append(" prompt_info_jump_text TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[42] = "prompt_info_jump_url";
        mAutoDBInfo.colsMap.put("prompt_info_jump_url", "TEXT");
        sb.append(" prompt_info_jump_url TEXT");
        mAutoDBInfo.columns[43] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70225);
    }

    public Bankcard() {
    }

    public Bankcard(byte b2) {
        this.field_bankcardTag = 1;
    }

    public Bankcard(String str, String str2, String str3, String str4, String str5, String str6, double d2, String str7, double d3, String str8, String str9, String str10, String str11, String str12, b bVar, int i2, String str13, boolean z, e eVar, long j2, long j3, long j4, String str14, int i3, int i4, String str15, String str16, int i5, String str17, long j5, String str18, String str19, String str20, String str21, String str22) {
        this.HVx = str;
        this.HVy = str2;
        this.HUS = str3;
        this.HVz = str4;
        this.HVA = str5;
        this.HVB = str6;
        this.HVC = d2;
        this.HVD = str7;
        this.HVE = d3;
        this.HVF = str8;
        this.HVG = str9;
        this.HVH = str10;
        this.HVI = str11;
        this.HVJ = str12;
        this.HVK = bVar;
        this.HUQ = i2;
        this.HVL = str13;
        this.dKO = z;
        this.HVM = eVar;
        this.HVN = j2;
        this.HVO = j3;
        this.HVP = j4;
        this.HVQ = str14;
        this.HVR = i3;
        this.HVS = i4;
        this.HVT = str15;
        this.HVU = str16;
        this.HVV = i5;
        this.HVW = str17;
        this.HVX = j5;
        this.HVY = str18;
        this.HVZ = str19;
        this.HWa = str20;
        this.Hwr = str21;
        this.Hws = str22;
    }

    private boolean isSupport(int i2) {
        return (this.field_bankcardTag & i2) > 0;
    }

    public static boolean jT(int i2, int i3) {
        AppMethodBeat.i(70214);
        Log.d("MicroMsg.Bankcard", "supportBankcardTag : " + i2 + ", bankcardTag : " + i3);
        if ((i2 & i3) > 0) {
            AppMethodBeat.o(70214);
            return true;
        }
        AppMethodBeat.o(70214);
        return false;
    }

    public static boolean aeI(int i2) {
        return (i2 & 2) > 0;
    }

    public final int a(int i2, Orders orders) {
        AppMethodBeat.i(70215);
        if (this.field_bankcardState != 0) {
            Log.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
            int i3 = this.field_bankcardState;
            AppMethodBeat.o(70215);
            return i3;
        } else if (orders != null && orders.dDL.equals(this.HVB)) {
            AppMethodBeat.o(70215);
            return 4;
        } else if (!isSupport(i2)) {
            if (fQe()) {
                AppMethodBeat.o(70215);
                return 5;
            }
            AppMethodBeat.o(70215);
            return 6;
        } else if (orders == null || orders.HYZ.isEmpty() || orders.HYZ.contains(this.field_bankcardType)) {
            AppMethodBeat.o(70215);
            return 0;
        } else {
            AppMethodBeat.o(70215);
            return 7;
        }
    }

    public static String au(Context context, int i2) {
        AppMethodBeat.i(70216);
        switch (i2) {
            case 1:
                String string = context.getString(R.string.in5);
                AppMethodBeat.o(70216);
                return string;
            case 2:
                String string2 = context.getString(R.string.ina);
                AppMethodBeat.o(70216);
                return string2;
            case 3:
                String string3 = context.getString(R.string.inf);
                AppMethodBeat.o(70216);
                return string3;
            case 4:
                String string4 = context.getString(R.string.in7);
                AppMethodBeat.o(70216);
                return string4;
            case 5:
                String string5 = context.getString(R.string.in3);
                AppMethodBeat.o(70216);
                return string5;
            case 6:
                String string6 = context.getString(R.string.in9);
                AppMethodBeat.o(70216);
                return string6;
            case 7:
                String string7 = context.getString(R.string.ind);
                AppMethodBeat.o(70216);
                return string7;
            default:
                String string8 = context.getString(R.string.inb);
                AppMethodBeat.o(70216);
                return string8;
        }
    }

    public final boolean fQa() {
        AppMethodBeat.i(70217);
        boolean z = (this.field_cardType & HVq) > 0;
        Log.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(70217);
        return z;
    }

    public final boolean fQb() {
        AppMethodBeat.i(70218);
        boolean z = (this.field_cardType & HVr) > 0;
        Log.d("MicroMsg.Bankcard", "isWXCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(70218);
        return z;
    }

    public final boolean fQc() {
        AppMethodBeat.i(70219);
        boolean z = (this.field_cardType & HVu) > 0;
        Log.d("MicroMsg.Bankcard", "isLqtCard, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(70219);
        return z;
    }

    public final boolean fQd() {
        AppMethodBeat.i(70220);
        boolean z = (this.field_cardType & HVp) > 0;
        Log.d("MicroMsg.Bankcard", "isCredit, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(70220);
        return z;
    }

    public final boolean fQe() {
        AppMethodBeat.i(70221);
        boolean z = (this.field_cardType & HVo) <= 0;
        Log.d("MicroMsg.Bankcard", "isDomestic, ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(70221);
        return z;
    }

    public final boolean fQf() {
        return (this.field_cardType & HVv) > 0;
    }

    public final boolean fQg() {
        return (this.field_cardType & HVw) > 0;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public int describeContents() {
        return 0;
    }

    public Bankcard(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(70222);
        this.field_bankName = parcel.readString();
        this.field_desc = parcel.readString();
        this.field_bankcardType = parcel.readString();
        this.field_bindSerial = parcel.readString();
        this.field_cardType = parcel.readInt();
        this.dKO = parcel.readInt() == 1;
        this.field_mobile = parcel.readString();
        this.field_onceQuotaKind = parcel.readDouble();
        this.field_onceQuotaVirtual = parcel.readDouble();
        this.field_dayQuotaKind = parcel.readDouble();
        this.field_dayQuotaVirtual = parcel.readDouble();
        this.field_bankcardTail = parcel.readString();
        this.field_bankPhone = parcel.readString();
        this.field_bankcardTag = parcel.readInt();
        this.field_bankcardState = parcel.readInt();
        this.HVB = parcel.readString();
        this.HUQ = parcel.readInt();
        this.HVL = parcel.readString();
        this.field_bankcardClientType = parcel.readInt();
        this.field_ext_msg = parcel.readString();
        this.field_support_micropay = parcel.readInt() != 1 ? false : z;
        this.field_arrive_type = parcel.readString();
        this.field_fetch_charge_rate = parcel.readDouble();
        this.field_full_fetch_charge_fee = parcel.readDouble();
        this.field_no_micro_word = parcel.readString();
        this.field_card_bottom_wording = parcel.readString();
        this.HVQ = parcel.readString();
        this.HVN = parcel.readLong();
        this.HVP = parcel.readLong();
        this.HVO = parcel.readLong();
        this.HVR = parcel.readInt();
        this.HVV = parcel.readInt();
        this.HVS = parcel.readInt();
        this.HVT = parcel.readString();
        this.HVU = parcel.readString();
        this.HVW = parcel.readString();
        this.HVX = parcel.readLong();
        this.HVY = parcel.readString();
        this.HVZ = parcel.readString();
        this.HWa = parcel.readString();
        this.Hwr = parcel.readString();
        this.Hws = parcel.readString();
        AppMethodBeat.o(70222);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 1;
        AppMethodBeat.i(70223);
        parcel.writeString(this.field_bankName);
        parcel.writeString(this.field_desc);
        parcel.writeString(this.field_bankcardType);
        parcel.writeString(this.field_bindSerial);
        parcel.writeInt(this.field_cardType);
        parcel.writeInt(this.dKO ? 1 : 0);
        parcel.writeString(this.field_mobile);
        parcel.writeDouble(this.field_onceQuotaKind);
        parcel.writeDouble(this.field_onceQuotaVirtual);
        parcel.writeDouble(this.field_dayQuotaKind);
        parcel.writeDouble(this.field_dayQuotaVirtual);
        parcel.writeString(this.field_bankcardTail);
        parcel.writeString(this.field_bankPhone);
        parcel.writeInt(this.field_bankcardTag);
        parcel.writeInt(this.field_bankcardState);
        parcel.writeString(this.HVB);
        parcel.writeInt(this.HUQ);
        parcel.writeString(this.HVL);
        parcel.writeInt(this.field_bankcardClientType);
        parcel.writeString(this.field_ext_msg);
        if (!this.field_support_micropay) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.field_arrive_type);
        parcel.writeDouble(this.field_fetch_charge_rate);
        parcel.writeDouble(this.field_full_fetch_charge_fee);
        parcel.writeString(this.field_no_micro_word);
        parcel.writeString(this.field_card_bottom_wording);
        parcel.writeString(this.HVQ);
        parcel.writeLong(this.HVN);
        parcel.writeLong(this.HVP);
        parcel.writeLong(this.HVO);
        parcel.writeInt(this.HVR);
        parcel.writeInt(this.HVV);
        parcel.writeInt(this.HVS);
        parcel.writeString(this.HVT);
        parcel.writeString(this.HVU);
        parcel.writeString(this.HVW);
        parcel.writeLong(this.HVX);
        parcel.writeString(this.HVY);
        parcel.writeString(this.HVZ);
        parcel.writeString(this.HWa);
        parcel.writeString(this.Hwr);
        parcel.writeString(this.Hws);
        AppMethodBeat.o(70223);
    }

    @Override // com.tencent.mm.g.c.hd, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        AppMethodBeat.i(70224);
        super.convertFrom(cursor);
        AppMethodBeat.o(70224);
    }
}
