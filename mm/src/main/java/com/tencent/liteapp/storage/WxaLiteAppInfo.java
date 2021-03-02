package com.tencent.liteapp.storage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppInfo implements Parcelable {
    public static final Parcelable.Creator<WxaLiteAppInfo> CREATOR = new Parcelable.Creator<WxaLiteAppInfo>() {
        /* class com.tencent.liteapp.storage.WxaLiteAppInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WxaLiteAppInfo[] newArray(int i2) {
            return new WxaLiteAppInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WxaLiteAppInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(197714);
            WxaLiteAppInfo wxaLiteAppInfo = new WxaLiteAppInfo();
            wxaLiteAppInfo.appId = parcel.readString();
            wxaLiteAppInfo.groupId = parcel.readString();
            wxaLiteAppInfo.url = parcel.readString();
            wxaLiteAppInfo.md5 = parcel.readString();
            wxaLiteAppInfo.crh = parcel.readString();
            wxaLiteAppInfo.path = parcel.readString();
            wxaLiteAppInfo.type = parcel.readString();
            wxaLiteAppInfo.cri = parcel.readString();
            wxaLiteAppInfo.crj = parcel.readLong();
            wxaLiteAppInfo.crk = parcel.readLong();
            AppMethodBeat.o(197714);
            return wxaLiteAppInfo;
        }
    };
    public String appId;
    public String crh;
    public String cri;
    public long crj;
    public long crk;
    public String groupId;
    public String md5;
    public String path;
    public String type;
    public String url;

    public final boolean KB() {
        AppMethodBeat.i(197715);
        boolean equalsIgnoreCase = "debug".equalsIgnoreCase(this.type);
        AppMethodBeat.o(197715);
        return equalsIgnoreCase;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(197716);
        parcel.writeString(this.appId);
        parcel.writeString(this.groupId);
        parcel.writeString(this.url);
        parcel.writeString(this.md5);
        parcel.writeString(this.crh);
        parcel.writeString(this.path);
        parcel.writeString(this.type);
        parcel.writeString(this.cri);
        parcel.writeLong(this.crj);
        parcel.writeLong(this.crk);
        AppMethodBeat.o(197716);
    }

    static {
        AppMethodBeat.i(197718);
        AppMethodBeat.o(197718);
    }

    public String toString() {
        AppMethodBeat.i(197717);
        String str = "WxaLiteAppInfo{appId='" + this.appId + '\'' + ", groupId='" + this.groupId + '\'' + ", url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", signatureKey='" + this.crh + '\'' + ", path='" + this.path + '\'' + ", type='" + this.type + '\'' + ", patchId='" + this.cri + '\'' + ", updateTime=" + this.crj + ", lastUseTime=" + this.crk + '}';
        AppMethodBeat.o(197717);
        return str;
    }
}
