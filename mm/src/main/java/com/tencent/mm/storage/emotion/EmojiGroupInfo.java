package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bi;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class EmojiGroupInfo extends bi implements Parcelable {
    public static final Parcelable.Creator<EmojiGroupInfo> CREATOR = new Parcelable.Creator<EmojiGroupInfo>() {
        /* class com.tencent.mm.storage.emotion.EmojiGroupInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EmojiGroupInfo[] newArray(int i2) {
            return new EmojiGroupInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EmojiGroupInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(104978);
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo(parcel);
            AppMethodBeat.o(104978);
            return emojiGroupInfo;
        }
    };
    public static int TYPE_CUSTOM = 3;
    public static int TYPE_SYSTEM = 1;
    public static int VkK = 2;
    public static int VkL = 4;
    public static int VkM = 256;
    public static int VkN = 17;
    public static int VkO = 18;
    public static int VkP = 81;
    public static int VkQ = 65;
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final String hYf() {
        return this.field_productID;
    }

    public final void setProductID(String str) {
        this.field_productID = str;
    }

    public final String hYg() {
        return this.field_packGrayIconUrl;
    }

    public final String beq() {
        return this.field_packName;
    }

    public final void byF(String str) {
        this.field_packName = str;
    }

    public final EmotionSummary hYh() {
        AppMethodBeat.i(104979);
        EmotionSummary emotionSummary = new EmotionSummary();
        emotionSummary.ProductID = this.field_productID;
        emotionSummary.IconUrl = this.field_packIconUrl;
        emotionSummary.PackName = this.field_packName;
        emotionSummary.PackDesc = this.field_packDesc;
        emotionSummary.PackAuthInfo = this.field_packAuthInfo;
        emotionSummary.PackPrice = this.field_packPrice;
        emotionSummary.PackType = this.field_packType;
        emotionSummary.PackFlag = this.field_packFlag;
        emotionSummary.CoverUrl = this.field_packCoverUrl;
        emotionSummary.PackExpire = (int) this.field_packExpire;
        emotionSummary.PackCopyright = this.field_packCopyright;
        emotionSummary.Timestamp = (int) this.field_packTimeStamp;
        emotionSummary.PriceNum = this.field_packPrice;
        AppMethodBeat.o(104979);
        return emotionSummary;
    }

    public String toString() {
        AppMethodBeat.i(104980);
        StringBuilder sb = new StringBuilder();
        sb.append("field_productID:").append(this.field_productID).append("\n");
        sb.append("field_packIconUrl:").append(this.field_packIconUrl).append("\n");
        sb.append("field_packGrayIconUrl:").append(this.field_packGrayIconUrl).append("\n");
        sb.append("field_packCoverUrl:").append(this.field_packCoverUrl).append("\n");
        sb.append("field_packName:").append(this.field_packName).append("\n");
        sb.append("field_packDesc:").append(this.field_packDesc).append("\n");
        sb.append("field_packAuthInfo:").append(this.field_packAuthInfo).append("\n");
        sb.append("field_packPrice:").append(this.field_packPrice).append("\n");
        sb.append("field_packType:").append(this.field_packType).append("\n");
        sb.append("field_packFlag:").append(this.field_packFlag).append("\n");
        sb.append("field_packExpire:").append(this.field_packExpire).append("\n");
        sb.append("field_packTimeStamp:").append(this.field_packTimeStamp).append("\n");
        sb.append("field_packCopyright:").append(this.field_packCopyright).append("\n");
        sb.append("field_type:").append(this.field_type).append("\n");
        sb.append("field_status:").append(this.field_status).append("\n");
        sb.append("field_sort:").append(this.field_sort).append("\n");
        sb.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
        sb.append("field_packStatus:").append(this.field_packStatus).append("\n");
        sb.append("field_recommand:").append(this.field_recommand).append("\n");
        sb.append("field_sync:").append(this.field_sync).append("\n");
        sb.append("field_idx:").append(this.field_idx).append("\n");
        sb.append("field_BigIconUrl:").append(this.field_BigIconUrl).append("\n");
        sb.append("field_MutiLanName:").append(this.field_MutiLanName).append("\n");
        sb.append("field_count:").append(this.field_count).append("\n");
        String sb2 = sb.toString();
        AppMethodBeat.o(104980);
        return sb2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(104981);
        parcel.writeString(this.field_productID);
        parcel.writeString(this.field_packIconUrl);
        parcel.writeString(this.field_packGrayIconUrl);
        parcel.writeString(this.field_packCoverUrl);
        parcel.writeString(this.field_packName);
        parcel.writeString(this.field_packDesc);
        parcel.writeString(this.field_packAuthInfo);
        parcel.writeString(this.field_packPrice);
        parcel.writeInt(this.field_packType);
        parcel.writeInt(this.field_packFlag);
        parcel.writeLong(this.field_packExpire);
        parcel.writeLong(this.field_packTimeStamp);
        parcel.writeString(this.field_packCopyright);
        parcel.writeInt(this.field_type);
        parcel.writeInt(this.field_status);
        parcel.writeInt(this.field_sort);
        parcel.writeLong(this.field_lastUseTime);
        parcel.writeInt(this.field_packStatus);
        parcel.writeInt(this.field_flag);
        parcel.writeInt(this.field_recommand);
        parcel.writeInt(this.field_sync);
        parcel.writeInt(this.field_idx);
        parcel.writeString(this.field_BigIconUrl);
        parcel.writeString(this.field_MutiLanName);
        parcel.writeInt(this.field_recommandType);
        parcel.writeString(this.field_lang);
        parcel.writeString(this.field_recommandWord);
        parcel.writeInt(this.field_buttonType);
        parcel.writeInt(this.field_count);
        parcel.writeLong(this.systemRowid);
        AppMethodBeat.o(104981);
    }

    public EmojiGroupInfo() {
    }

    protected EmojiGroupInfo(Parcel parcel) {
        AppMethodBeat.i(104982);
        this.field_productID = parcel.readString();
        this.field_packIconUrl = parcel.readString();
        this.field_packGrayIconUrl = parcel.readString();
        this.field_packCoverUrl = parcel.readString();
        this.field_packName = parcel.readString();
        this.field_packDesc = parcel.readString();
        this.field_packAuthInfo = parcel.readString();
        this.field_packPrice = parcel.readString();
        this.field_packType = parcel.readInt();
        this.field_packFlag = parcel.readInt();
        this.field_packExpire = parcel.readLong();
        this.field_packTimeStamp = parcel.readLong();
        this.field_packCopyright = parcel.readString();
        this.field_type = parcel.readInt();
        this.field_status = parcel.readInt();
        this.field_sort = parcel.readInt();
        this.field_lastUseTime = parcel.readLong();
        this.field_packStatus = parcel.readInt();
        this.field_flag = parcel.readInt();
        this.field_recommand = parcel.readInt();
        this.field_sync = parcel.readInt();
        this.field_idx = parcel.readInt();
        this.field_BigIconUrl = parcel.readString();
        this.field_MutiLanName = parcel.readString();
        this.field_recommandType = parcel.readInt();
        this.field_lang = parcel.readString();
        this.field_recommandWord = parcel.readString();
        this.field_buttonType = parcel.readInt();
        this.field_count = parcel.readInt();
        this.systemRowid = parcel.readLong();
        AppMethodBeat.o(104982);
    }

    static {
        AppMethodBeat.i(104983);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[29];
        mAutoDBInfo.columns = new String[30];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "productID";
        mAutoDBInfo.colsMap.put("productID", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        sb.append(" productID TEXT PRIMARY KEY  COLLATE NOCASE ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "productID";
        mAutoDBInfo.columns[1] = "packIconUrl";
        mAutoDBInfo.colsMap.put("packIconUrl", "TEXT");
        sb.append(" packIconUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "packGrayIconUrl";
        mAutoDBInfo.colsMap.put("packGrayIconUrl", "TEXT");
        sb.append(" packGrayIconUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "packCoverUrl";
        mAutoDBInfo.colsMap.put("packCoverUrl", "TEXT");
        sb.append(" packCoverUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "packName";
        mAutoDBInfo.colsMap.put("packName", "TEXT");
        sb.append(" packName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "packDesc";
        mAutoDBInfo.colsMap.put("packDesc", "TEXT");
        sb.append(" packDesc TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "packAuthInfo";
        mAutoDBInfo.colsMap.put("packAuthInfo", "TEXT");
        sb.append(" packAuthInfo TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "packPrice";
        mAutoDBInfo.colsMap.put("packPrice", "TEXT");
        sb.append(" packPrice TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "packType";
        mAutoDBInfo.colsMap.put("packType", "INTEGER");
        sb.append(" packType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "packFlag";
        mAutoDBInfo.colsMap.put("packFlag", "INTEGER");
        sb.append(" packFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "packExpire";
        mAutoDBInfo.colsMap.put("packExpire", "LONG");
        sb.append(" packExpire LONG");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "packTimeStamp";
        mAutoDBInfo.colsMap.put("packTimeStamp", "LONG");
        sb.append(" packTimeStamp LONG");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "packCopyright";
        mAutoDBInfo.colsMap.put("packCopyright", "TEXT");
        sb.append(" packCopyright TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER");
        sb.append(" type INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER");
        sb.append(" status INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "sort";
        mAutoDBInfo.colsMap.put("sort", "INTEGER default '1' ");
        sb.append(" sort INTEGER default '1' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "lastUseTime";
        mAutoDBInfo.colsMap.put("lastUseTime", "LONG");
        sb.append(" lastUseTime LONG");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "packStatus";
        mAutoDBInfo.colsMap.put("packStatus", "INTEGER default '0' ");
        sb.append(" packStatus INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "flag";
        mAutoDBInfo.colsMap.put("flag", "INTEGER default '0' ");
        sb.append(" flag INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "recommand";
        mAutoDBInfo.colsMap.put("recommand", "INTEGER default '0' ");
        sb.append(" recommand INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "sync";
        mAutoDBInfo.colsMap.put("sync", "INTEGER default '0' ");
        sb.append(" sync INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[21] = "idx";
        mAutoDBInfo.colsMap.put("idx", "INTEGER default '0' ");
        sb.append(" idx INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[22] = "BigIconUrl";
        mAutoDBInfo.colsMap.put("BigIconUrl", "TEXT");
        sb.append(" BigIconUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[23] = "MutiLanName";
        mAutoDBInfo.colsMap.put("MutiLanName", "TEXT");
        sb.append(" MutiLanName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[24] = "recommandType";
        mAutoDBInfo.colsMap.put("recommandType", "INTEGER default '-1' ");
        sb.append(" recommandType INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[25] = "lang";
        mAutoDBInfo.colsMap.put("lang", "TEXT");
        sb.append(" lang TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[26] = "recommandWord";
        mAutoDBInfo.colsMap.put("recommandWord", "TEXT");
        sb.append(" recommandWord TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[27] = "buttonType";
        mAutoDBInfo.colsMap.put("buttonType", "INTEGER");
        sb.append(" buttonType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[28] = "count";
        mAutoDBInfo.colsMap.put("count", "INTEGER");
        sb.append(" count INTEGER");
        mAutoDBInfo.columns[29] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(104983);
    }
}
