package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gf;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public class SmileyInfo extends gf implements Parcelable {
    public static final Parcelable.Creator<SmileyInfo> CREATOR = new Parcelable.Creator<SmileyInfo>() {
        /* class com.tencent.mm.storage.emotion.SmileyInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SmileyInfo[] newArray(int i2) {
            return new SmileyInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SmileyInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105138);
            SmileyInfo smileyInfo = new SmileyInfo(parcel);
            AppMethodBeat.o(105138);
            return smileyInfo;
        }
    };
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    public SmileyInfo() {
    }

    protected SmileyInfo(Parcel parcel) {
        AppMethodBeat.i(105139);
        this.field_key = parcel.readString();
        this.field_cnValue = parcel.readString();
        this.field_qqValue = parcel.readString();
        this.field_twValue = parcel.readString();
        this.field_enValue = parcel.readString();
        this.field_thValue = parcel.readString();
        this.field_fileName = parcel.readString();
        this.field_position = parcel.readInt();
        this.field_eggIndex = parcel.readInt();
        this.field_flag = parcel.readInt();
        AppMethodBeat.o(105139);
    }

    public SmileyInfo(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.field_key = str;
        this.field_cnValue = str3;
        this.field_qqValue = str2;
        this.field_enValue = str5;
        this.field_thValue = str6;
        this.field_twValue = str4;
        this.field_position = i2;
    }

    public SmileyInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2) {
        this.field_key = str;
        this.field_cnValue = str3;
        this.field_qqValue = str2;
        this.field_enValue = str5;
        this.field_thValue = str6;
        this.field_twValue = str4;
        this.field_fileName = str7;
        this.field_eggIndex = i2;
    }

    public String toString() {
        AppMethodBeat.i(105140);
        StringBuilder sb = new StringBuilder();
        sb.append("key:").append(this.field_key).append("/n");
        sb.append("cn:").append(this.field_cnValue).append("/n");
        sb.append("qq:").append(this.field_qqValue).append("/n");
        sb.append("en:").append(this.field_enValue).append("/n");
        sb.append("th:").append(this.field_thValue).append("/n");
        sb.append("tw:").append(this.field_twValue).append("/n");
        sb.append("position:").append(this.field_position).append("/n");
        sb.append("file Name:").append(this.field_fileName).append("/n");
        sb.append("egg index:").append(this.field_eggIndex).append("/n");
        String sb2 = sb.toString();
        AppMethodBeat.o(105140);
        return sb2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(105141);
        parcel.writeString(this.field_key);
        parcel.writeString(this.field_cnValue);
        parcel.writeString(this.field_qqValue);
        parcel.writeString(this.field_twValue);
        parcel.writeString(this.field_enValue);
        parcel.writeString(this.field_thValue);
        parcel.writeString(this.field_fileName);
        parcel.writeInt(this.field_position);
        parcel.writeInt(this.field_eggIndex);
        parcel.writeInt(this.field_flag);
        AppMethodBeat.o(105141);
    }

    static {
        AppMethodBeat.i(105142);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[10];
        mAutoDBInfo.columns = new String[11];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "key";
        mAutoDBInfo.colsMap.put("key", "TEXT PRIMARY KEY ");
        sb.append(" key TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "key";
        mAutoDBInfo.columns[1] = "cnValue";
        mAutoDBInfo.colsMap.put("cnValue", "TEXT");
        sb.append(" cnValue TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "qqValue";
        mAutoDBInfo.colsMap.put("qqValue", "TEXT");
        sb.append(" qqValue TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "twValue";
        mAutoDBInfo.colsMap.put("twValue", "TEXT");
        sb.append(" twValue TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "enValue";
        mAutoDBInfo.colsMap.put("enValue", "TEXT");
        sb.append(" enValue TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "thValue";
        mAutoDBInfo.colsMap.put("thValue", "TEXT");
        sb.append(" thValue TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = DownloadInfo.FILENAME;
        mAutoDBInfo.colsMap.put(DownloadInfo.FILENAME, "TEXT");
        sb.append(" fileName TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "eggIndex";
        mAutoDBInfo.colsMap.put("eggIndex", "INTEGER default '-1' ");
        sb.append(" eggIndex INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "position";
        mAutoDBInfo.colsMap.put("position", "INTEGER default '-1' ");
        sb.append(" position INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "flag";
        mAutoDBInfo.colsMap.put("flag", "INTEGER");
        sb.append(" flag INTEGER");
        mAutoDBInfo.columns[10] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(105142);
    }
}
