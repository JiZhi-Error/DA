package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gg;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public class SmileyPanelConfigInfo extends gg implements Parcelable {
    public static final Parcelable.Creator<SmileyPanelConfigInfo> CREATOR = new Parcelable.Creator<SmileyPanelConfigInfo>() {
        /* class com.tencent.mm.storage.emotion.SmileyPanelConfigInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SmileyPanelConfigInfo[] newArray(int i2) {
            return new SmileyPanelConfigInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SmileyPanelConfigInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105146);
            SmileyPanelConfigInfo smileyPanelConfigInfo = new SmileyPanelConfigInfo(parcel);
            AppMethodBeat.o(105146);
            return smileyPanelConfigInfo;
        }
    };
    protected static IAutoDBItem.MAutoDBInfo info;

    protected SmileyPanelConfigInfo(Parcel parcel) {
        AppMethodBeat.i(105147);
        this.field_position = parcel.readInt();
        this.field_key = parcel.readString();
        AppMethodBeat.o(105147);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public IAutoDBItem.MAutoDBInfo getDBInfo() {
        return null;
    }

    public SmileyPanelConfigInfo() {
    }

    public SmileyPanelConfigInfo(int i2, String str) {
        this.field_position = i2;
        this.field_key = str;
    }

    public String toString() {
        AppMethodBeat.i(105148);
        StringBuilder sb = new StringBuilder();
        sb.append("index:").append(this.field_position);
        sb.append("key  :").append(this.field_key);
        String sb2 = sb.toString();
        AppMethodBeat.o(105148);
        return sb2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(105149);
        parcel.writeInt(this.field_position);
        parcel.writeString(this.field_key);
        AppMethodBeat.o(105149);
    }

    static {
        AppMethodBeat.i(105150);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "key";
        mAutoDBInfo.colsMap.put("key", "TEXT PRIMARY KEY ");
        sb.append(" key TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "key";
        mAutoDBInfo.columns[1] = "position";
        mAutoDBInfo.colsMap.put("position", "INTEGER");
        sb.append(" position INTEGER");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(105150);
    }
}
