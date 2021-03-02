package com.tencent.smtt.sandbox;

import android.os.ParcelFileDescriptor;

public final class FileDescriptorInfo {
    public final ParcelFileDescriptor fd;
    public final int id;
    public final long offset;
    public final long size;

    public FileDescriptorInfo(int i2, ParcelFileDescriptor parcelFileDescriptor, long j2, long j3) {
        this.id = i2;
        this.fd = parcelFileDescriptor;
        this.offset = j2;
        this.size = j3;
    }
}
