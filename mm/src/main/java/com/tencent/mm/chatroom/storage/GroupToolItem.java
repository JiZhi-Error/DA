package com.tencent.mm.chatroom.storage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public class GroupToolItem implements Parcelable {
    public static final Parcelable.Creator<GroupToolItem> CREATOR = new Parcelable.Creator<GroupToolItem>() {
        /* class com.tencent.mm.chatroom.storage.GroupToolItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GroupToolItem[] newArray(int i2) {
            return new GroupToolItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GroupToolItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(182147);
            GroupToolItem groupToolItem = new GroupToolItem(parcel);
            AppMethodBeat.o(182147);
            return groupToolItem;
        }
    };
    public long crj = 0;
    public String path = "";
    public String username = "";

    public GroupToolItem() {
    }

    public GroupToolItem(String str, String str2) {
        this.username = str;
        this.path = str2;
    }

    public GroupToolItem(String str, String str2, long j2) {
        this.username = str;
        this.path = str2;
        this.crj = j2;
    }

    public String toString() {
        AppMethodBeat.i(182148);
        String str = "GroupToolItem{username='" + this.username + '\'' + ", path='" + this.path + '\'' + ", updateTime=" + this.crj + '}';
        AppMethodBeat.o(182148);
        return str;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(182149);
        if (obj == null) {
            AppMethodBeat.o(182149);
            return false;
        } else if (Util.isEqual(((GroupToolItem) obj).username, this.username)) {
            AppMethodBeat.o(182149);
            return true;
        } else {
            AppMethodBeat.o(182149);
            return false;
        }
    }

    public final boolean amm() {
        AppMethodBeat.i(182150);
        boolean isEqual = Util.isEqual(this.username, "roomaa@app.origin");
        AppMethodBeat.o(182150);
        return isEqual;
    }

    public final boolean amn() {
        AppMethodBeat.i(194059);
        boolean isEqual = Util.isEqual(this.username, "roomlive@app.origin");
        AppMethodBeat.o(194059);
        return isEqual;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(182151);
        parcel.writeString(this.username);
        parcel.writeString(this.path);
        parcel.writeLong(this.crj);
        AppMethodBeat.o(182151);
    }

    protected GroupToolItem(Parcel parcel) {
        AppMethodBeat.i(182152);
        this.username = parcel.readString();
        this.path = parcel.readString();
        this.crj = parcel.readLong();
        AppMethodBeat.o(182152);
    }

    static {
        AppMethodBeat.i(182153);
        AppMethodBeat.o(182153);
    }
}
