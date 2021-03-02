package com.tencent.recovery.model;

import android.os.Parcelable;

public abstract class RecoveryPersistentItem implements Parcelable {
    public abstract String getClientVersion();

    public abstract long getTimeStamp();

    public abstract boolean parseFromString(String str);

    public abstract String toSaveString();

    public String toString() {
        return toSaveString();
    }
}
