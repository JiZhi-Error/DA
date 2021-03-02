package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;
import java.util.Arrays;

public class ScanResultCompat implements Parcelable {
    public static final Parcelable.Creator<ScanResultCompat> CREATOR = new Parcelable.Creator<ScanResultCompat>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScanResultCompat[] newArray(int i2) {
            return new ScanResultCompat[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ScanResultCompat createFromParcel(Parcel parcel) {
            AppMethodBeat.i(144639);
            ScanResultCompat scanResultCompat = new ScanResultCompat(parcel, (byte) 0);
            AppMethodBeat.o(144639);
            return scanResultCompat;
        }
    };
    private BluetoothDevice lOM;
    public f lON;
    public int lOO;
    private long lOP;

    /* synthetic */ ScanResultCompat(Parcel parcel, byte b2) {
        this(parcel);
    }

    public ScanResultCompat(BluetoothDevice bluetoothDevice, f fVar, int i2, long j2) {
        this.lOM = bluetoothDevice;
        this.lON = fVar;
        this.lOO = i2;
        this.lOP = j2;
    }

    @TargetApi(21)
    ScanResultCompat(ScanResult scanResult) {
        AppMethodBeat.i(144640);
        this.lOM = scanResult.getDevice();
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord != null) {
            this.lON = a.bFm().lMq ? f.aJ(scanRecord.getBytes()) : new f(scanRecord);
        }
        this.lOO = scanResult.getRssi();
        this.lOP = System.currentTimeMillis();
        AppMethodBeat.o(144640);
    }

    private ScanResultCompat(Parcel parcel) {
        AppMethodBeat.i(144641);
        if (parcel.readInt() == 1) {
            this.lOM = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1) {
            this.lON = f.aJ(parcel.createByteArray());
        }
        this.lOO = parcel.readInt();
        this.lOP = parcel.readLong();
        AppMethodBeat.o(144641);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(144642);
        if (this.lOM != null) {
            parcel.writeInt(1);
            this.lOM.writeToParcel(parcel, i2);
        } else {
            parcel.writeInt(0);
        }
        if (this.lON != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.lON.lOK);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.lOO);
        parcel.writeLong(this.lOP);
        AppMethodBeat.o(144642);
    }

    public int describeContents() {
        return 0;
    }

    public final BluetoothDevice getDevice() {
        if (this.lOM != null) {
            return this.lOM;
        }
        return null;
    }

    public int hashCode() {
        AppMethodBeat.i(144643);
        int hashCode = Arrays.hashCode(new Object[]{this.lOM, Integer.valueOf(this.lOO), this.lON, Long.valueOf(this.lOP)});
        AppMethodBeat.o(144643);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(144644);
        if (this == obj) {
            AppMethodBeat.o(144644);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(144644);
            return false;
        } else {
            ScanResultCompat scanResultCompat = (ScanResultCompat) obj;
            if (!d.equals(this.lOM, scanResultCompat.lOM) || this.lOO != scanResultCompat.lOO || !d.equals(this.lON, scanResultCompat.lON) || this.lOP != scanResultCompat.lOP) {
                AppMethodBeat.o(144644);
                return false;
            }
            AppMethodBeat.o(144644);
            return true;
        }
    }

    public String toString() {
        AppMethodBeat.i(144645);
        String str = "ScanResult{mDevice=" + this.lOM + ", mScanRecord=" + d.toString(this.lON) + ", mRssi=" + this.lOO + ", mTimestampNanos=" + this.lOP + '}';
        AppMethodBeat.o(144645);
        return str;
    }

    static {
        AppMethodBeat.i(144646);
        AppMethodBeat.o(144646);
    }
}
