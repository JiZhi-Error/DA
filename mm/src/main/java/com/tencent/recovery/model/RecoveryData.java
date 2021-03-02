package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class RecoveryData implements Parcelable {
    public static final Parcelable.Creator<RecoveryData> CREATOR = new Parcelable.Creator<RecoveryData>() {
        /* class com.tencent.recovery.model.RecoveryData.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final RecoveryData createFromParcel(Parcel parcel) {
            RecoveryData recoveryData = new RecoveryData();
            recoveryData.processName = parcel.readString();
            recoveryData.uuid = parcel.readString();
            recoveryData.clientVersion = parcel.readString();
            recoveryData.configUrl = parcel.readString();
            recoveryData.exceptionItemList = parcel.readArrayList(RecoveryData.class.getClassLoader());
            return recoveryData;
        }

        @Override // android.os.Parcelable.Creator
        public final RecoveryData[] newArray(int i2) {
            return new RecoveryData[i2];
        }
    };
    public String clientVersion;
    public String configUrl;
    public List<RecoveryStatusItem> exceptionItemList;
    public String processName;
    public String uuid;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.processName);
        parcel.writeString(this.uuid);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.configUrl);
        parcel.writeList(this.exceptionItemList);
    }
}
