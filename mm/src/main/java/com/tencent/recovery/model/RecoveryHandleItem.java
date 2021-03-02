package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RecoveryHandleItem extends RecoveryPersistentItem {
    public static final Parcelable.Creator<RecoveryHandleItem> CREATOR = new Parcelable.Creator<RecoveryHandleItem>() {
        /* class com.tencent.recovery.model.RecoveryHandleItem.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final RecoveryHandleItem createFromParcel(Parcel parcel) {
            RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
            recoveryHandleItem.uuid = parcel.readString();
            recoveryHandleItem.clientVersion = parcel.readString();
            recoveryHandleItem.key = parcel.readString();
            recoveryHandleItem.processName = parcel.readString();
            recoveryHandleItem.phoneStatus = parcel.readString();
            recoveryHandleItem.timestamp = parcel.readLong();
            return recoveryHandleItem;
        }

        @Override // android.os.Parcelable.Creator
        public final RecoveryHandleItem[] newArray(int i2) {
            return new RecoveryHandleItem[i2];
        }
    };
    public String clientVersion;
    public String key;
    public String phoneStatus;
    public String processName;
    public long timestamp;
    public String uuid;

    @Override // com.tencent.recovery.model.RecoveryPersistentItem
    public String toSaveString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.uuid);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.key);
        stringBuffer.append(",");
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.phoneStatus);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }

    @Override // com.tencent.recovery.model.RecoveryPersistentItem
    public boolean parseFromString(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.uuid = split[0];
            this.clientVersion = split[1];
            this.key = split[2];
            this.processName = split[3];
            this.phoneStatus = split[4];
            this.timestamp = Long.valueOf(split[5]).longValue();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.uuid);
        parcel.writeString(this.clientVersion);
        parcel.writeString(this.key);
        parcel.writeString(this.processName);
        parcel.writeString(this.phoneStatus);
        parcel.writeLong(this.timestamp);
    }

    @Override // com.tencent.recovery.model.RecoveryPersistentItem
    public long getTimeStamp() {
        return this.timestamp;
    }

    @Override // com.tencent.recovery.model.RecoveryPersistentItem
    public String getClientVersion() {
        return this.clientVersion;
    }
}
