package com.tencent.mm.plugin.card.sharecard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.gc;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class ShareCardInfo extends gc implements Parcelable, b {
    public static final Parcelable.Creator<ShareCardInfo> CREATOR = new Parcelable.Creator<ShareCardInfo>() {
        /* class com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ShareCardInfo[] newArray(int i2) {
            return new ShareCardInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ShareCardInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(112979);
            ShareCardInfo shareCardInfo = new ShareCardInfo(parcel);
            AppMethodBeat.o(112979);
            return shareCardInfo;
        }
    };
    protected static IAutoDBItem.MAutoDBInfo info;
    public String pSa = "";
    public uz pTh;
    public ty pTi;
    public dxr pTj;
    public us pTk;
    public boolean pTl = true;

    public ShareCardInfo() {
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csx() {
        AppMethodBeat.i(112980);
        if (csQ() == null || csQ().nHh != 10) {
            AppMethodBeat.o(112980);
            return false;
        }
        AppMethodBeat.o(112980);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csy() {
        AppMethodBeat.i(112981);
        if (csQ() == null || csQ().nHh != 0) {
            AppMethodBeat.o(112981);
            return false;
        }
        AppMethodBeat.o(112981);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csz() {
        AppMethodBeat.i(112982);
        if (csQ() == null || csQ().nHh != 20) {
            AppMethodBeat.o(112982);
            return false;
        }
        AppMethodBeat.o(112982);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csA() {
        AppMethodBeat.i(112983);
        if (csQ() == null || csQ().nHh != 11) {
            AppMethodBeat.o(112983);
            return false;
        }
        AppMethodBeat.o(112983);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csB() {
        AppMethodBeat.i(112984);
        if (csQ() == null || csQ().nHh != 30) {
            AppMethodBeat.o(112984);
            return false;
        }
        AppMethodBeat.o(112984);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csC() {
        AppMethodBeat.i(112985);
        boolean Eg = l.Eg(csQ().nHh);
        AppMethodBeat.o(112985);
        return Eg;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csD() {
        AppMethodBeat.i(112986);
        if ((csQ().LeH & 2) == 0) {
            AppMethodBeat.o(112986);
            return true;
        }
        AppMethodBeat.o(112986);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csE() {
        AppMethodBeat.i(112987);
        if ((csQ().LeH & 1) == 0) {
            AppMethodBeat.o(112987);
            return true;
        }
        AppMethodBeat.o(112987);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csF() {
        AppMethodBeat.i(112988);
        if ((csQ().LeK & 1) == 0) {
            AppMethodBeat.o(112988);
            return true;
        }
        AppMethodBeat.o(112988);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csG() {
        AppMethodBeat.i(112989);
        if ((csQ().LeK & 16) == 0) {
            AppMethodBeat.o(112989);
            return true;
        }
        AppMethodBeat.o(112989);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csH() {
        AppMethodBeat.i(112990);
        if ((csQ().LeK & 2) > 0) {
            AppMethodBeat.o(112990);
            return true;
        }
        AppMethodBeat.o(112990);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csI() {
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csJ() {
        AppMethodBeat.i(112991);
        if ((csQ().LeK & 4) > 0) {
            AppMethodBeat.o(112991);
            return true;
        }
        AppMethodBeat.o(112991);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csK() {
        AppMethodBeat.i(112992);
        if ((csQ().LeK & 8) > 0) {
            AppMethodBeat.o(112992);
            return true;
        }
        AppMethodBeat.o(112992);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csM() {
        return this.pTi != null && this.pTi.status == 0;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean isAcceptable() {
        AppMethodBeat.i(112993);
        if (!csM()) {
            AppMethodBeat.o(112993);
            return false;
        }
        if (this.pTh != null) {
            Log.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.pTh.LeX);
        }
        Log.i("MicroMsg.ShareCardInfo", "stock_num:" + this.pTi.Lct + " limit_num:" + this.pTi.Lcu);
        if (this.pTh != null && this.pTh.LeX == 1) {
            AppMethodBeat.o(112993);
            return true;
        } else if (this.pTh != null && this.pTh.LeX == 0) {
            AppMethodBeat.o(112993);
            return false;
        } else if (this.pTi.Lct == 0 || this.pTi.Lcu == 0) {
            AppMethodBeat.o(112993);
            return false;
        } else {
            AppMethodBeat.o(112993);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csN() {
        AppMethodBeat.i(112994);
        if (!csM()) {
            AppMethodBeat.o(112994);
            return false;
        }
        if (this.pTh != null) {
            Log.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.pTh.LeX);
        }
        Log.i("MicroMsg.ShareCardInfo", "avail_num:" + this.pTi.Lcq);
        if (this.pTh != null && this.pTh.LeX == 1) {
            AppMethodBeat.o(112994);
            return true;
        } else if (this.pTi.Lcq > 0) {
            AppMethodBeat.o(112994);
            return true;
        } else if (this.pTh != null && this.pTh.LeX == 0) {
            AppMethodBeat.o(112994);
            return false;
        } else if (this.pTi.Lcq == 0) {
            AppMethodBeat.o(112994);
            return false;
        } else {
            AppMethodBeat.o(112994);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csO() {
        AppMethodBeat.i(112995);
        if (this.pTh == null || this.pTh.LeO == null || TextUtils.isEmpty(this.pTh.LeO.text)) {
            AppMethodBeat.o(112995);
            return false;
        }
        uo uoVar = this.pTh.LeO;
        int currentTimeMillis = uoVar.DhD - ((int) (System.currentTimeMillis() / 1000));
        if (uoVar.DhD <= 0 || currentTimeMillis <= 0) {
            AppMethodBeat.o(112995);
            return false;
        }
        AppMethodBeat.o(112995);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csP() {
        return this.pTh != null && this.pTh.Lfb == 1;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final uz csQ() {
        AppMethodBeat.i(112996);
        if (this.pTh != null) {
            uz uzVar = this.pTh;
            AppMethodBeat.o(112996);
            return uzVar;
        }
        try {
            this.pTh = (uz) new uz().parseFrom(this.field_cardTpInfoData);
            uz uzVar2 = this.pTh;
            AppMethodBeat.o(112996);
            return uzVar2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            uz uzVar3 = new uz();
            AppMethodBeat.o(112996);
            return uzVar3;
        }
    }

    public final void a(uz uzVar) {
        AppMethodBeat.i(112997);
        this.pTh = uzVar;
        try {
            this.field_cardTpInfoData = uzVar.toByteArray();
            AppMethodBeat.o(112997);
        } catch (Exception e2) {
            Log.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", e2.getMessage());
            AppMethodBeat.o(112997);
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final ty csR() {
        AppMethodBeat.i(112998);
        if (this.pTi != null) {
            ty tyVar = this.pTi;
            AppMethodBeat.o(112998);
            return tyVar;
        }
        try {
            this.pTi = (ty) new ty().parseFrom(this.field_dataInfoData);
            ty tyVar2 = this.pTi;
            AppMethodBeat.o(112998);
            return tyVar2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            ty tyVar3 = new ty();
            AppMethodBeat.o(112998);
            return tyVar3;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final void a(ty tyVar) {
        AppMethodBeat.i(112999);
        this.pTi = tyVar;
        if (this.pTi != null) {
            try {
                this.field_dataInfoData = tyVar.toByteArray();
                AppMethodBeat.o(112999);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(112999);
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final dxr csS() {
        AppMethodBeat.i(113000);
        if (this.pTj != null) {
            dxr dxr = this.pTj;
            AppMethodBeat.o(113000);
            return dxr;
        }
        try {
            this.pTj = (dxr) new dxr().parseFrom(this.field_shareInfoData);
            dxr dxr2 = this.pTj;
            AppMethodBeat.o(113000);
            return dxr2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            dxr dxr3 = new dxr();
            AppMethodBeat.o(113000);
            return dxr3;
        }
    }

    public final void a(dxr dxr) {
        AppMethodBeat.i(113001);
        this.pTj = dxr;
        try {
            this.field_shareInfoData = dxr.toByteArray();
            AppMethodBeat.o(113001);
        } catch (Exception e2) {
            Log.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            AppMethodBeat.o(113001);
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final us csT() {
        AppMethodBeat.i(113002);
        if (this.pTk != null) {
            us usVar = this.pTk;
            AppMethodBeat.o(113002);
            return usVar;
        }
        try {
            this.pTk = (us) new us().parseFrom(this.field_shopInfoData);
            us usVar2 = this.pTk;
            AppMethodBeat.o(113002);
            return usVar2;
        } catch (Exception e2) {
            Log.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            AppMethodBeat.o(113002);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final void a(us usVar) {
        AppMethodBeat.i(113003);
        this.pTk = usVar;
        try {
            this.field_shopInfoData = usVar.toByteArray();
            AppMethodBeat.o(113003);
        } catch (Exception e2) {
            Log.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            AppMethodBeat.o(113003);
        }
    }

    public ShareCardInfo(Parcel parcel) {
        AppMethodBeat.i(113004);
        this.field_card_id = parcel.readString();
        this.field_card_tp_id = parcel.readString();
        this.field_from_username = parcel.readString();
        this.field_status = parcel.readInt();
        this.field_share_time = parcel.readLong();
        this.field_local_updateTime = parcel.readLong();
        this.field_updateTime = parcel.readLong();
        this.field_updateSeq = parcel.readLong();
        this.field_block_mask = parcel.readLong();
        this.field_end_time = parcel.readLong();
        this.field_categoryType = parcel.readInt();
        this.field_itemIndex = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_dataInfoData = new byte[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                this.field_dataInfoData[i2] = parcel.readByte();
            }
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            this.field_cardTpInfoData = new byte[readInt2];
            for (int i3 = 0; i3 < readInt2; i3++) {
                this.field_cardTpInfoData[i3] = parcel.readByte();
            }
        }
        int readInt3 = parcel.readInt();
        if (readInt3 > 0) {
            this.field_shareInfoData = new byte[readInt3];
            for (int i4 = 0; i4 < readInt3; i4++) {
                this.field_shareInfoData[i4] = parcel.readByte();
            }
        }
        int readInt4 = parcel.readInt();
        if (readInt4 > 0) {
            this.field_shopInfoData = new byte[readInt4];
            for (int i5 = 0; i5 < readInt4; i5++) {
                this.field_shopInfoData[i5] = parcel.readByte();
            }
        }
        AppMethodBeat.o(113004);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(113005);
        parcel.writeString(this.field_card_id);
        parcel.writeString(this.field_card_tp_id);
        parcel.writeString(this.field_from_username);
        parcel.writeInt(this.field_status);
        parcel.writeLong(this.field_share_time);
        parcel.writeLong(this.field_local_updateTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeLong(this.field_updateSeq);
        parcel.writeLong(this.field_block_mask);
        parcel.writeLong(this.field_end_time);
        parcel.writeInt(this.field_categoryType);
        parcel.writeInt(this.field_itemIndex);
        if (this.field_dataInfoData != null) {
            parcel.writeInt(this.field_dataInfoData.length);
            for (int i3 = 0; i3 < this.field_dataInfoData.length; i3++) {
                parcel.writeByte(this.field_dataInfoData[i3]);
            }
        }
        if (this.field_cardTpInfoData != null) {
            parcel.writeInt(this.field_cardTpInfoData.length);
            for (int i4 = 0; i4 < this.field_cardTpInfoData.length; i4++) {
                parcel.writeByte(this.field_cardTpInfoData[i4]);
            }
        }
        if (this.field_shareInfoData != null) {
            parcel.writeInt(this.field_shareInfoData.length);
            for (int i5 = 0; i5 < this.field_shareInfoData.length; i5++) {
                parcel.writeByte(this.field_shareInfoData[i5]);
            }
        }
        if (this.field_shopInfoData != null) {
            parcel.writeInt(this.field_shopInfoData.length);
            for (int i6 = 0; i6 < this.field_shopInfoData.length; i6++) {
                parcel.writeByte(this.field_shopInfoData[i6]);
            }
        }
        AppMethodBeat.o(113005);
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final long getEndTime() {
        return this.field_end_time;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String csU() {
        return this.field_card_id;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String csV() {
        return this.field_card_tp_id;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String csW() {
        return this.field_from_username;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final void aiY(String str) {
        this.field_from_username = str;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final long csX() {
        return this.field_local_updateTime;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csv() {
        AppMethodBeat.i(113006);
        if (csQ() == null || csQ().LeR != 0) {
            AppMethodBeat.o(113006);
            return false;
        }
        AppMethodBeat.o(113006);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csw() {
        AppMethodBeat.i(113007);
        if (csQ() == null || csQ().LeR != 1) {
            AppMethodBeat.o(113007);
            return false;
        }
        AppMethodBeat.o(113007);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String Ee(int i2) {
        AppMethodBeat.i(113008);
        if (i2 == 10) {
            String str = (String) am.ctV().getValue("key_share_card_local_city");
            AppMethodBeat.o(113008);
            return str;
        } else if (i2 != 0) {
            AppMethodBeat.o(113008);
            return "";
        } else if (com.tencent.mm.plugin.card.sharecard.a.b.cuy()) {
            String string = MMApplicationContext.getResources().getString(R.string.as7);
            AppMethodBeat.o(113008);
            return string;
        } else {
            AppMethodBeat.o(113008);
            return "";
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String csY() {
        return "";
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final int csZ() {
        return this.field_categoryType;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String cta() {
        AppMethodBeat.i(113009);
        Log.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.pSa);
        String str = this.pSa;
        AppMethodBeat.o(113009);
        return str;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csL() {
        AppMethodBeat.i(113010);
        if (csQ() == null || csQ().LeW != 1) {
            AppMethodBeat.o(113010);
            return false;
        }
        AppMethodBeat.o(113010);
        return true;
    }

    static {
        AppMethodBeat.i(113011);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[19];
        mAutoDBInfo.columns = new String[20];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "card_id";
        mAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
        sb.append(" card_id TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "card_id";
        mAutoDBInfo.columns[1] = "card_tp_id";
        mAutoDBInfo.colsMap.put("card_tp_id", "TEXT");
        sb.append(" card_tp_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "from_username";
        mAutoDBInfo.colsMap.put("from_username", "TEXT");
        sb.append(" from_username TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "consumer";
        mAutoDBInfo.colsMap.put("consumer", "TEXT");
        sb.append(" consumer TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "app_id";
        mAutoDBInfo.colsMap.put("app_id", "TEXT");
        sb.append(" app_id TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "share_time";
        mAutoDBInfo.colsMap.put("share_time", "LONG");
        sb.append(" share_time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "local_updateTime";
        mAutoDBInfo.colsMap.put("local_updateTime", "LONG");
        sb.append(" local_updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "begin_time";
        mAutoDBInfo.colsMap.put("begin_time", "LONG");
        sb.append(" begin_time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "end_time";
        mAutoDBInfo.colsMap.put("end_time", "LONG");
        sb.append(" end_time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "updateSeq";
        mAutoDBInfo.colsMap.put("updateSeq", "LONG");
        sb.append(" updateSeq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "block_mask";
        mAutoDBInfo.colsMap.put("block_mask", "LONG");
        sb.append(" block_mask LONG");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "dataInfoData";
        mAutoDBInfo.colsMap.put("dataInfoData", "BLOB");
        sb.append(" dataInfoData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "cardTpInfoData";
        mAutoDBInfo.colsMap.put("cardTpInfoData", "BLOB");
        sb.append(" cardTpInfoData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "shareInfoData";
        mAutoDBInfo.colsMap.put("shareInfoData", "BLOB");
        sb.append(" shareInfoData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "shopInfoData";
        mAutoDBInfo.colsMap.put("shopInfoData", "BLOB");
        sb.append(" shopInfoData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "categoryType";
        mAutoDBInfo.colsMap.put("categoryType", "INTEGER default '0' ");
        sb.append(" categoryType INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "itemIndex";
        mAutoDBInfo.colsMap.put("itemIndex", "INTEGER default '0' ");
        sb.append(" itemIndex INTEGER default '0' ");
        mAutoDBInfo.columns[19] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(113011);
    }
}
