package com.tencent.sqlitelint;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class SQLiteLintIssue implements Parcelable {
    public static final Parcelable.Creator<SQLiteLintIssue> CREATOR = new Parcelable.Creator<SQLiteLintIssue>() {
        /* class com.tencent.sqlitelint.SQLiteLintIssue.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final SQLiteLintIssue createFromParcel(Parcel parcel) {
            AppMethodBeat.i(52854);
            SQLiteLintIssue sQLiteLintIssue = new SQLiteLintIssue(parcel);
            AppMethodBeat.o(52854);
            return sQLiteLintIssue;
        }

        @Override // android.os.Parcelable.Creator
        public final SQLiteLintIssue[] newArray(int i2) {
            return new SQLiteLintIssue[i2];
        }
    };
    public static final int ERROR = 4;
    public static final int PASS = 0;
    public static final int SUGGESTION = 2;
    public static final int TIPS = 1;
    public static final int WARNING = 3;
    public String advice;
    public long createTime;
    public String dbPath;
    public String desc;
    public String detail;
    public String extInfo;
    public String id;
    public boolean isInMainThread;
    public boolean isNew;
    public int level;
    public String sql;
    public long sqlTimeCost;
    public String table;
    public int type;

    public static String getLevelText(int i2, Context context) {
        String string;
        AppMethodBeat.i(52857);
        switch (i2) {
            case 1:
                string = context.getString(R.string.bmk);
                break;
            case 2:
                string = context.getString(R.string.bmj);
                break;
            case 3:
                string = context.getString(R.string.bml);
                break;
            case 4:
                string = context.getString(R.string.bmi);
                break;
            default:
                string = context.getString(R.string.bmj);
                break;
        }
        AppMethodBeat.o(52857);
        return string;
    }

    public SQLiteLintIssue() {
    }

    public SQLiteLintIssue(String str, String str2, int i2, int i3, String str3, String str4, String str5, String str6, String str7, long j2, String str8, long j3, boolean z) {
        this.id = str;
        this.dbPath = str2;
        this.level = i2;
        this.type = i3;
        this.sql = str3;
        this.table = str4;
        this.desc = str5;
        this.detail = str6;
        this.advice = str7;
        this.createTime = j2;
        this.extInfo = str8;
        this.sqlTimeCost = j3;
        this.isInMainThread = z;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(52858);
        if (!(obj instanceof SQLiteLintIssue)) {
            AppMethodBeat.o(52858);
            return false;
        }
        boolean equals = ((SQLiteLintIssue) obj).id.equals(this.id);
        AppMethodBeat.o(52858);
        return equals;
    }

    public int hashCode() {
        AppMethodBeat.i(52859);
        int hashCode = this.id.hashCode();
        AppMethodBeat.o(52859);
        return hashCode;
    }

    protected SQLiteLintIssue(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(52860);
        this.id = parcel.readString();
        this.dbPath = parcel.readString();
        this.level = parcel.readInt();
        this.type = parcel.readInt();
        this.sql = parcel.readString();
        this.table = parcel.readString();
        this.desc = parcel.readString();
        this.detail = parcel.readString();
        this.advice = parcel.readString();
        this.createTime = parcel.readLong();
        this.extInfo = parcel.readString();
        this.sqlTimeCost = parcel.readLong();
        this.isInMainThread = parcel.readInt() != 1 ? false : z;
        AppMethodBeat.o(52860);
    }

    static {
        AppMethodBeat.i(52862);
        AppMethodBeat.o(52862);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(52861);
        parcel.writeString(this.id);
        parcel.writeString(this.dbPath);
        parcel.writeInt(this.level);
        parcel.writeInt(this.type);
        parcel.writeString(this.sql);
        parcel.writeString(this.table);
        parcel.writeString(this.desc);
        parcel.writeString(this.detail);
        parcel.writeString(this.advice);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.extInfo);
        parcel.writeLong(this.sqlTimeCost);
        parcel.writeInt(this.isInMainThread ? 1 : 0);
        AppMethodBeat.o(52861);
    }
}
