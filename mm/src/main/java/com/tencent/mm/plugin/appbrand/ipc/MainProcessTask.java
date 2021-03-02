package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public abstract class MainProcessTask implements Parcelable {
    private static final Set<Object> lwZ = new HashSet();
    public String jEY = new StringBuilder().append(Process.myPid()).append(hashCode()).toString();
    Messenger lxa;

    public abstract void bjj();

    public void bjk() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }

    public int describeContents() {
        return 0;
    }

    public final String bjl() {
        return this.jEY;
    }

    /* access modifiers changed from: protected */
    public void hg(boolean z) {
    }

    public final boolean bDU() {
        if (this.lxa == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.setData(AppBrandMainProcessService.a(this, false));
        try {
            this.lxa.send(obtain);
            hg(true);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MainProcessTask", "callback failed, class[%s], e=%s", getClass().getName(), e2);
            hg(false);
            return false;
        }
    }

    public final void bjm() {
        AppBrandMainProcessService.a(this);
    }

    public final void bDJ() {
        lwZ.add(this);
        AppBrandMainProcessService.c(this);
    }

    public final void bDK() {
        lwZ.remove(this);
    }
}
