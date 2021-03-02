package com.tencent.smtt.sandbox;

import android.os.ParcelFileDescriptor;

public interface SandboxListener {
    void setCrashRecordFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2);
}
