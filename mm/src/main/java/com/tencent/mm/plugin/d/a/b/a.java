package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private byte[] mData = null;
    BluetoothGattCharacteristic pgA = null;
    private int pgx = 20;
    private int pgy = 0;
    private int pgz = 0;

    public final void setData(byte[] bArr) {
        AppMethodBeat.i(22472);
        if (bArr == null) {
            this.mData = null;
            this.pgz = 0;
            this.pgy = 0;
            AppMethodBeat.o(22472);
            return;
        }
        this.mData = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.mData, 0, bArr.length);
        this.pgz = bArr.length;
        this.pgy = 0;
        AppMethodBeat.o(22472);
    }

    public final byte[] ckC() {
        AppMethodBeat.i(22473);
        int i2 = this.pgz - this.pgy;
        if (i2 == 0) {
            AppMethodBeat.o(22473);
            return null;
        }
        if (i2 >= this.pgx) {
            i2 = this.pgx;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.mData, this.pgy, bArr, 0, i2);
        this.pgy = i2 + this.pgy;
        AppMethodBeat.o(22473);
        return bArr;
    }
}
