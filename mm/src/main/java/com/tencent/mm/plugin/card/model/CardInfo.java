package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.gx;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class CardInfo extends gx implements Parcelable, b {
    public static final Parcelable.Creator<CardInfo> CREATOR = new Parcelable.Creator<CardInfo>() {
        /* class com.tencent.mm.plugin.card.model.CardInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CardInfo[] newArray(int i2) {
            return new CardInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CardInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(112733);
            CardInfo cardInfo = new CardInfo(parcel);
            AppMethodBeat.o(112733);
            return cardInfo;
        }
    };
    protected static IAutoDBItem.MAutoDBInfo info;
    public String pSa = "";
    public uz pTh;
    public ty pTi;
    public dxr pTj;
    public us pTk;
    public boolean pTl = true;

    public CardInfo() {
        this.field_card_type = -1;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csx() {
        AppMethodBeat.i(112734);
        if (csQ() == null || csQ().nHh != 10) {
            AppMethodBeat.o(112734);
            return false;
        }
        AppMethodBeat.o(112734);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csy() {
        AppMethodBeat.i(112735);
        if (csQ() == null || csQ().nHh != 0) {
            AppMethodBeat.o(112735);
            return false;
        }
        AppMethodBeat.o(112735);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csz() {
        AppMethodBeat.i(112736);
        if (csQ() == null || csQ().nHh != 20) {
            AppMethodBeat.o(112736);
            return false;
        }
        AppMethodBeat.o(112736);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csA() {
        AppMethodBeat.i(112737);
        if (csQ() == null || csQ().nHh != 11) {
            AppMethodBeat.o(112737);
            return false;
        }
        AppMethodBeat.o(112737);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csB() {
        AppMethodBeat.i(112738);
        if (csQ() == null || csQ().nHh != 30) {
            AppMethodBeat.o(112738);
            return false;
        }
        AppMethodBeat.o(112738);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csC() {
        AppMethodBeat.i(112739);
        boolean Eg = l.Eg(csQ().nHh);
        AppMethodBeat.o(112739);
        return Eg;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csD() {
        AppMethodBeat.i(112740);
        if ((csQ().LeH & 2) == 0) {
            AppMethodBeat.o(112740);
            return true;
        }
        AppMethodBeat.o(112740);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csE() {
        AppMethodBeat.i(112741);
        if ((csQ().LeH & 1) == 0) {
            AppMethodBeat.o(112741);
            return true;
        }
        AppMethodBeat.o(112741);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csF() {
        AppMethodBeat.i(112742);
        if ((csQ().LeK & 1) == 0) {
            AppMethodBeat.o(112742);
            return true;
        }
        AppMethodBeat.o(112742);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csG() {
        AppMethodBeat.i(112743);
        if ((csQ().LeK & 16) == 0) {
            AppMethodBeat.o(112743);
            return true;
        }
        AppMethodBeat.o(112743);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csH() {
        AppMethodBeat.i(112744);
        if ((csQ().LeK & 2) > 0) {
            AppMethodBeat.o(112744);
            return true;
        }
        AppMethodBeat.o(112744);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csI() {
        AppMethodBeat.i(112745);
        if ((csQ().LeK & 32) > 0) {
            AppMethodBeat.o(112745);
            return true;
        }
        AppMethodBeat.o(112745);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csJ() {
        AppMethodBeat.i(112746);
        if ((csQ().LeK & 4) > 0) {
            AppMethodBeat.o(112746);
            return true;
        }
        AppMethodBeat.o(112746);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csK() {
        AppMethodBeat.i(112747);
        if ((csQ().LeK & 8) > 0) {
            AppMethodBeat.o(112747);
            return true;
        }
        AppMethodBeat.o(112747);
        return false;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csM() {
        return this.pTi != null && this.pTi.status == 0;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean isAcceptable() {
        AppMethodBeat.i(112748);
        if (!csM()) {
            AppMethodBeat.o(112748);
            return false;
        }
        if (this.pTh != null) {
            Log.i("MicroMsg.CardInfo", "is_acceptable:" + this.pTh.LeX);
        }
        Log.i("MicroMsg.CardInfo", "stock_num:" + this.pTi.Lct + " limit_num:" + this.pTi.Lcu);
        if (this.pTh != null && this.pTh.LeX == 1) {
            AppMethodBeat.o(112748);
            return true;
        } else if (this.pTh != null && this.pTh.LeX == 0) {
            AppMethodBeat.o(112748);
            return false;
        } else if (this.pTi.Lct == 0 || this.pTi.Lcu == 0) {
            AppMethodBeat.o(112748);
            return false;
        } else {
            AppMethodBeat.o(112748);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csN() {
        AppMethodBeat.i(112749);
        if (!csM()) {
            AppMethodBeat.o(112749);
            return false;
        }
        if (this.pTh != null) {
            Log.i("MicroMsg.CardInfo", "is_acceptable:" + this.pTh.LeX);
        }
        Log.i("MicroMsg.CardInfo", "avail_num:" + this.pTi.Lcq);
        if (this.pTh != null && this.pTh.LeX == 1) {
            AppMethodBeat.o(112749);
            return true;
        } else if (this.pTi.Lcq > 0) {
            AppMethodBeat.o(112749);
            return true;
        } else if (this.pTh != null && this.pTh.LeX == 0) {
            AppMethodBeat.o(112749);
            return false;
        } else if (this.pTi.Lcq == 0) {
            AppMethodBeat.o(112749);
            return false;
        } else {
            AppMethodBeat.o(112749);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csO() {
        AppMethodBeat.i(112750);
        if (this.pTh == null || this.pTh.LeO == null || TextUtils.isEmpty(this.pTh.LeO.text)) {
            AppMethodBeat.o(112750);
            return false;
        }
        uo uoVar = this.pTh.LeO;
        int currentTimeMillis = uoVar.DhD - ((int) (System.currentTimeMillis() / 1000));
        if (uoVar.DhD <= 0 || currentTimeMillis <= 0) {
            AppMethodBeat.o(112750);
            return false;
        }
        AppMethodBeat.o(112750);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csP() {
        return this.pTh != null && this.pTh.Lfb == 1;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final uz csQ() {
        AppMethodBeat.i(112751);
        if (this.pTh != null) {
            uz uzVar = this.pTh;
            AppMethodBeat.o(112751);
            return uzVar;
        }
        try {
            if (this.field_cardTpInfoData != null) {
                this.pTh = (uz) new uz().parseFrom(this.field_cardTpInfoData);
                uz uzVar2 = this.pTh;
                AppMethodBeat.o(112751);
                return uzVar2;
            }
            uz uzVar3 = new uz();
            AppMethodBeat.o(112751);
            return uzVar3;
        } catch (Exception e2) {
            Log.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
            uz uzVar4 = new uz();
            AppMethodBeat.o(112751);
            return uzVar4;
        }
    }

    public final void a(uz uzVar) {
        AppMethodBeat.i(112752);
        this.pTh = uzVar;
        if (uzVar != null) {
            try {
                this.field_cardTpInfoData = uzVar.toByteArray();
            } catch (Exception e2) {
                Log.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", e2.getMessage());
                AppMethodBeat.o(112752);
                return;
            }
        }
        AppMethodBeat.o(112752);
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final ty csR() {
        AppMethodBeat.i(112753);
        if (this.pTi != null) {
            ty tyVar = this.pTi;
            AppMethodBeat.o(112753);
            return tyVar;
        }
        try {
            if (this.field_dataInfoData != null) {
                this.pTi = (ty) new ty().parseFrom(this.field_dataInfoData);
                ty tyVar2 = this.pTi;
                AppMethodBeat.o(112753);
                return tyVar2;
            }
            ty tyVar3 = new ty();
            AppMethodBeat.o(112753);
            return tyVar3;
        } catch (Exception e2) {
            Log.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
            ty tyVar4 = new ty();
            AppMethodBeat.o(112753);
            return tyVar4;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final void a(ty tyVar) {
        AppMethodBeat.i(112754);
        this.pTi = tyVar;
        if (this.pTi != null) {
            this.field_status = this.pTi.status;
            if (tyVar != null) {
                try {
                    this.field_dataInfoData = tyVar.toByteArray();
                } catch (Exception e2) {
                    Log.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", e2.getMessage());
                    Log.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(112754);
            return;
        }
        AppMethodBeat.o(112754);
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final dxr csS() {
        AppMethodBeat.i(112755);
        if (this.pTj != null) {
            dxr dxr = this.pTj;
            AppMethodBeat.o(112755);
            return dxr;
        }
        try {
            if (this.field_shareInfoData != null) {
                this.pTj = (dxr) new dxr().parseFrom(this.field_shareInfoData);
                dxr dxr2 = this.pTj;
                AppMethodBeat.o(112755);
                return dxr2;
            }
            dxr dxr3 = new dxr();
            AppMethodBeat.o(112755);
            return dxr3;
        } catch (Exception e2) {
            Log.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
            dxr dxr4 = new dxr();
            AppMethodBeat.o(112755);
            return dxr4;
        }
    }

    public final void a(dxr dxr) {
        AppMethodBeat.i(112756);
        this.pTj = dxr;
        if (dxr != null) {
            try {
                this.field_shareInfoData = dxr.toByteArray();
            } catch (Exception e2) {
                Log.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
                AppMethodBeat.o(112756);
                return;
            }
        }
        AppMethodBeat.o(112756);
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final us csT() {
        AppMethodBeat.i(112757);
        if (this.pTk != null) {
            us usVar = this.pTk;
            AppMethodBeat.o(112757);
            return usVar;
        }
        try {
            if (this.field_shopInfoData != null) {
                this.pTk = (us) new us().parseFrom(this.field_shopInfoData);
                us usVar2 = this.pTk;
                AppMethodBeat.o(112757);
                return usVar2;
            }
            AppMethodBeat.o(112757);
            return null;
        } catch (Exception e2) {
            Log.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
            AppMethodBeat.o(112757);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final void a(us usVar) {
        AppMethodBeat.i(112758);
        this.pTk = usVar;
        if (usVar != null) {
            try {
                this.field_shopInfoData = usVar.toByteArray();
            } catch (Exception e2) {
                Log.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
                AppMethodBeat.o(112758);
                return;
            }
        }
        AppMethodBeat.o(112758);
    }

    public CardInfo(Parcel parcel) {
        AppMethodBeat.i(112759);
        this.field_card_id = parcel.readString();
        this.field_card_tp_id = parcel.readString();
        this.field_from_username = parcel.readString();
        this.field_status = parcel.readInt();
        this.field_delete_state_flag = parcel.readInt();
        this.field_local_updateTime = parcel.readLong();
        this.field_updateTime = parcel.readLong();
        this.field_updateSeq = parcel.readLong();
        this.field_create_time = parcel.readLong();
        this.field_begin_time = parcel.readLong();
        this.field_end_time = parcel.readLong();
        this.field_block_mask = parcel.readString();
        this.field_stickyIndex = parcel.readInt();
        this.field_stickyEndTime = parcel.readInt();
        this.field_stickyAnnouncement = parcel.readString();
        this.field_card_type = parcel.readInt();
        this.field_label_wording = parcel.readString();
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
        AppMethodBeat.o(112759);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(112760);
        parcel.writeString(this.field_card_id);
        parcel.writeString(this.field_card_tp_id);
        parcel.writeString(this.field_from_username);
        parcel.writeInt(this.field_status);
        parcel.writeInt(this.field_delete_state_flag);
        parcel.writeLong(this.field_local_updateTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeLong(this.field_updateSeq);
        parcel.writeLong(this.field_create_time);
        parcel.writeLong(this.field_begin_time);
        parcel.writeLong(this.field_end_time);
        parcel.writeString(this.field_block_mask);
        parcel.writeInt(this.field_stickyIndex);
        parcel.writeInt(this.field_stickyEndTime);
        parcel.writeString(this.field_stickyAnnouncement);
        parcel.writeInt(this.field_card_type);
        parcel.writeString(this.field_label_wording);
        if (this.field_dataInfoData != null) {
            parcel.writeInt(this.field_dataInfoData.length);
            for (int i3 = 0; i3 < this.field_dataInfoData.length; i3++) {
                parcel.writeByte(this.field_dataInfoData[i3]);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_cardTpInfoData != null) {
            parcel.writeInt(this.field_cardTpInfoData.length);
            for (int i4 = 0; i4 < this.field_cardTpInfoData.length; i4++) {
                parcel.writeByte(this.field_cardTpInfoData[i4]);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_shareInfoData != null) {
            parcel.writeInt(this.field_shareInfoData.length);
            for (int i5 = 0; i5 < this.field_shareInfoData.length; i5++) {
                parcel.writeByte(this.field_shareInfoData[i5]);
            }
        } else {
            parcel.writeInt(0);
        }
        if (this.field_shopInfoData != null) {
            parcel.writeInt(this.field_shopInfoData.length);
            for (int i6 = 0; i6 < this.field_shopInfoData.length; i6++) {
                parcel.writeByte(this.field_shopInfoData[i6]);
            }
            AppMethodBeat.o(112760);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(112760);
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
        AppMethodBeat.i(112761);
        if (csQ() == null || csQ().LeR != 0) {
            AppMethodBeat.o(112761);
            return false;
        }
        AppMethodBeat.o(112761);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csw() {
        AppMethodBeat.i(112762);
        if (csQ() == null || csQ().LeR != 1) {
            AppMethodBeat.o(112762);
            return false;
        }
        AppMethodBeat.o(112762);
        return true;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String Ee(int i2) {
        return null;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String csY() {
        return null;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final int csZ() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final String cta() {
        AppMethodBeat.i(112763);
        Log.d("MicroMsg.CardInfo", "encrypt_code:" + this.pSa);
        String str = this.pSa;
        AppMethodBeat.o(112763);
        return str;
    }

    @Override // com.tencent.mm.plugin.card.base.b
    public final boolean csL() {
        AppMethodBeat.i(112764);
        if (csQ() == null || csQ().LeW != 1) {
            AppMethodBeat.o(112764);
            return false;
        }
        AppMethodBeat.o(112764);
        return true;
    }

    static {
        AppMethodBeat.i(112765);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[22];
        mAutoDBInfo.columns = new String[23];
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
        mAutoDBInfo.columns[3] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "delete_state_flag";
        mAutoDBInfo.colsMap.put("delete_state_flag", "INTEGER");
        sb.append(" delete_state_flag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "local_updateTime";
        mAutoDBInfo.colsMap.put("local_updateTime", "LONG");
        sb.append(" local_updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[6] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG");
        sb.append(" updateTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "updateSeq";
        mAutoDBInfo.colsMap.put("updateSeq", "LONG");
        sb.append(" updateSeq LONG");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "create_time";
        mAutoDBInfo.colsMap.put("create_time", "LONG");
        sb.append(" create_time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "begin_time";
        mAutoDBInfo.colsMap.put("begin_time", "LONG");
        sb.append(" begin_time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "end_time";
        mAutoDBInfo.colsMap.put("end_time", "LONG");
        sb.append(" end_time LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "block_mask";
        mAutoDBInfo.colsMap.put("block_mask", "TEXT");
        sb.append(" block_mask TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "dataInfoData";
        mAutoDBInfo.colsMap.put("dataInfoData", "BLOB");
        sb.append(" dataInfoData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "cardTpInfoData";
        mAutoDBInfo.colsMap.put("cardTpInfoData", "BLOB");
        sb.append(" cardTpInfoData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "shareInfoData";
        mAutoDBInfo.colsMap.put("shareInfoData", "BLOB");
        sb.append(" shareInfoData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "shopInfoData";
        mAutoDBInfo.colsMap.put("shopInfoData", "BLOB");
        sb.append(" shopInfoData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "stickyIndex";
        mAutoDBInfo.colsMap.put("stickyIndex", "INTEGER");
        sb.append(" stickyIndex INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "stickyEndTime";
        mAutoDBInfo.colsMap.put("stickyEndTime", "INTEGER");
        sb.append(" stickyEndTime INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "stickyAnnouncement";
        mAutoDBInfo.colsMap.put("stickyAnnouncement", "TEXT");
        sb.append(" stickyAnnouncement TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "card_type";
        mAutoDBInfo.colsMap.put("card_type", "INTEGER default '-1' ");
        sb.append(" card_type INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "label_wording";
        mAutoDBInfo.colsMap.put("label_wording", "TEXT");
        sb.append(" label_wording TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "is_dynamic";
        mAutoDBInfo.colsMap.put("is_dynamic", "INTEGER");
        sb.append(" is_dynamic INTEGER");
        mAutoDBInfo.columns[22] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(112765);
    }
}
