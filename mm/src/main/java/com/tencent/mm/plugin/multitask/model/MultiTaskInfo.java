package com.tencent.mm.plugin.multitask.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.es;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class MultiTaskInfo extends es implements Parcelable {
    public static final Parcelable.Creator<MultiTaskInfo> CREATOR = new Parcelable.Creator<MultiTaskInfo>() {
        /* class com.tencent.mm.plugin.multitask.model.MultiTaskInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MultiTaskInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(208696);
            MultiTaskInfo n = n(parcel);
            AppMethodBeat.o(208696);
            return n;
        }

        private static MultiTaskInfo n(Parcel parcel) {
            AppMethodBeat.i(208695);
            MultiTaskInfo multiTaskInfo = new MultiTaskInfo();
            multiTaskInfo.field_id = parcel.readString();
            multiTaskInfo.field_type = parcel.readInt();
            multiTaskInfo.field_createTime = parcel.readLong();
            multiTaskInfo.field_updateTime = parcel.readLong();
            cru cru = new cru();
            cru.nickname = parcel.readString();
            cru.title = parcel.readString();
            cru.MwQ = parcel.readString();
            cru.Eso = parcel.readInt();
            cru.gCr = parcel.readString();
            cru.MwR = parcel.readString();
            cru.MwS = parcel.readInt();
            cru.MwT = parcel.readInt() != 0;
            multiTaskInfo.field_showData = cru;
            try {
                byte[] bArr = new byte[parcel.readInt()];
                parcel.readByteArray(bArr);
                multiTaskInfo.field_data = bArr;
            } catch (Exception e2) {
                Log.e("MicroMsg.MultiTaskInfo", "read ext info error: %s", e2.getMessage());
            }
            AppMethodBeat.o(208695);
            return multiTaskInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MultiTaskInfo[] newArray(int i2) {
            return new MultiTaskInfo[i2];
        }
    };
    public static IAutoDBItem.MAutoDBInfo info;

    public final cru erh() {
        AppMethodBeat.i(208697);
        if (this.field_showData == null) {
            this.field_showData = new cru();
        }
        cru cru = this.field_showData;
        AppMethodBeat.o(208697);
        return cru;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(208698);
        parcel.writeString(this.field_id);
        parcel.writeInt(this.field_type);
        parcel.writeLong(this.field_createTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeString(this.field_showData.nickname);
        parcel.writeString(this.field_showData.title);
        parcel.writeString(this.field_showData.MwQ);
        parcel.writeInt(this.field_showData.Eso);
        parcel.writeString(this.field_showData.gCr);
        parcel.writeString(this.field_showData.MwR);
        parcel.writeInt(this.field_showData.MwS);
        parcel.writeInt(this.field_showData.MwT ? 1 : 0);
        parcel.writeInt(this.field_data.length);
        parcel.writeByteArray(this.field_data);
        AppMethodBeat.o(208698);
    }

    static {
        AppMethodBeat.i(208699);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[6];
        mAutoDBInfo.columns = new String[7];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "id";
        mAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
        sb.append(" id TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "id";
        mAutoDBInfo.columns[1] = "type";
        mAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
        sb.append(" type INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "createTime";
        mAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
        sb.append(" createTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[3] = ch.COL_UPDATETIME;
        mAutoDBInfo.colsMap.put(ch.COL_UPDATETIME, "LONG default '0' ");
        sb.append(" updateTime LONG default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "showData";
        mAutoDBInfo.colsMap.put("showData", "BLOB");
        sb.append(" showData BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "data";
        mAutoDBInfo.colsMap.put("data", "BLOB default '' ");
        sb.append(" data BLOB default '' ");
        mAutoDBInfo.columns[6] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(208699);
    }
}
