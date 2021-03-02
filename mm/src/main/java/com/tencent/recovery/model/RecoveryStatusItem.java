package com.tencent.recovery.model;

import android.os.Parcel;
import android.os.Parcelable;

public class RecoveryStatusItem extends RecoveryPersistentItem {
    public static final Parcelable.Creator<RecoveryStatusItem> CREATOR = new Parcelable.Creator<RecoveryStatusItem>() {
        /* class com.tencent.recovery.model.RecoveryStatusItem.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final RecoveryStatusItem createFromParcel(Parcel parcel) {
            RecoveryStatusItem recoveryStatusItem = new RecoveryStatusItem();
            recoveryStatusItem.processName = parcel.readString();
            recoveryStatusItem.uuid = parcel.readString();
            recoveryStatusItem.clientVersion = parcel.readString();
            recoveryStatusItem.processStartFlag = parcel.readInt();
            recoveryStatusItem.processStatus = parcel.readInt();
            recoveryStatusItem.processStage = parcel.readInt();
            recoveryStatusItem.timestamp = parcel.readLong();
            return recoveryStatusItem;
        }

        @Override // android.os.Parcelable.Creator
        public final RecoveryStatusItem[] newArray(int i2) {
            return new RecoveryStatusItem[i2];
        }
    };
    public String clientVersion;
    public String processName;
    public int processStage;
    public int processStartFlag;
    public int processStatus;
    public long timestamp;
    public String uuid;

    public boolean isException() {
        switch (this.processStatus) {
            case 4096:
            case 65536:
            case 1048576:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.processName);
        parcel.writeString(this.uuid);
        parcel.writeString(this.clientVersion);
        parcel.writeInt(this.processStartFlag);
        parcel.writeInt(this.processStatus);
        parcel.writeInt(this.processStage);
        parcel.writeLong(this.timestamp);
    }

    @Override // com.tencent.recovery.model.RecoveryPersistentItem
    public boolean parseFromString(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            String[] split = str.split(",");
            this.processName = split[0];
            this.uuid = split[1];
            this.clientVersion = split[2];
            this.processStartFlag = Integer.valueOf(split[3]).intValue();
            this.processStatus = Integer.valueOf(split[4]).intValue();
            this.processStage = Integer.valueOf(split[5]).intValue();
            this.timestamp = Long.valueOf(split[6]).longValue();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // com.tencent.recovery.model.RecoveryPersistentItem
    public String toSaveString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.processName);
        stringBuffer.append(",");
        stringBuffer.append(this.uuid);
        stringBuffer.append(",");
        stringBuffer.append(this.clientVersion);
        stringBuffer.append(",");
        stringBuffer.append(this.processStartFlag);
        stringBuffer.append(",");
        stringBuffer.append(this.processStatus);
        stringBuffer.append(",");
        stringBuffer.append(this.processStage);
        stringBuffer.append(",");
        stringBuffer.append(this.timestamp);
        return stringBuffer.toString();
    }

    @Override // com.tencent.recovery.model.RecoveryPersistentItem
    public long getTimeStamp() {
        return this.timestamp;
    }

    @Override // com.tencent.recovery.model.RecoveryPersistentItem
    public String getClientVersion() {
        return this.clientVersion;
    }

    public static String getStatusString(int i2) {
        switch (i2) {
            case 4096:
                return "TimeOut";
            case 65536:
                return "Crash";
            case 1048576:
                return "Anr";
            default:
                return String.valueOf(i2);
        }
    }

    public static String getStageString(int i2) {
        switch (i2) {
            case 1:
                return "ApplicationOnCreate";
            case 16:
                return "ComponentOnCreate";
            default:
                return String.valueOf(i2);
        }
    }
}
