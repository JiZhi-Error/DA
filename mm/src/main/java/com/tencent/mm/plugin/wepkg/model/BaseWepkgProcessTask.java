package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

public abstract class BaseWepkgProcessTask extends MainProcessTask {
    public boolean JMQ = false;
    public boolean result = false;

    public abstract void a(Parcel parcel, int i2);

    public abstract void p(Parcel parcel);

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.result = z;
        if (parcel.readByte() == 0) {
            z2 = false;
        }
        this.JMQ = z2;
        p(parcel);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        if (this.result) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        if (!this.JMQ) {
            i4 = 0;
        }
        parcel.writeByte((byte) i4);
        a(parcel, i2);
    }
}
