package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.UUID;

public class ScanFilterCompat implements Parcelable {
    public static final Parcelable.Creator<ScanFilterCompat> CREATOR = new Parcelable.Creator<ScanFilterCompat>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScanFilterCompat[] newArray(int i2) {
            return new ScanFilterCompat[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ScanFilterCompat createFromParcel(Parcel parcel) {
            AppMethodBeat.i(144624);
            a aVar = new a();
            if (parcel.readInt() == 1) {
                aVar.mDeviceName = parcel.readString();
            }
            if (parcel.readInt() == 1) {
                String readString = parcel.readString();
                if (readString == null || BluetoothAdapter.checkBluetoothAddress(readString)) {
                    aVar.lOu = readString;
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid device address ".concat(String.valueOf(readString)));
                    AppMethodBeat.o(144624);
                    throw illegalArgumentException;
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                aVar.a(parcelUuid);
                if (parcel.readInt() == 1) {
                    ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                    if (aVar.lOE == null || aVar.lOv != null) {
                        aVar.lOv = parcelUuid;
                        aVar.lOE = parcelUuid2;
                    } else {
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("uuid is null while uuidMask is not null!");
                        AppMethodBeat.o(144624);
                        throw illegalArgumentException2;
                    }
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid3 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() != 0) {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        if (parcelUuid3 == null) {
                            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("serviceDataUuid is null");
                            AppMethodBeat.o(144624);
                            throw illegalArgumentException3;
                        }
                        if (aVar.lOz != null) {
                            if (aVar.lOy == null) {
                                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                                AppMethodBeat.o(144624);
                                throw illegalArgumentException4;
                            } else if (aVar.lOy.length != aVar.lOz.length) {
                                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("size mismatch for service data and service data mask");
                                AppMethodBeat.o(144624);
                                throw illegalArgumentException5;
                            }
                        }
                        aVar.lOx = parcelUuid3;
                        aVar.lOy = bArr;
                        aVar.lOz = bArr2;
                    } else if (parcelUuid3 == null) {
                        IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("serviceDataUuid is null");
                        AppMethodBeat.o(144624);
                        throw illegalArgumentException6;
                    } else {
                        aVar.lOx = parcelUuid3;
                        aVar.lOy = bArr;
                        aVar.lOz = null;
                    }
                }
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() != 0) {
                    byte[] bArr4 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr4);
                    if (readInt < 0) {
                        IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("invalid manufacture id");
                        AppMethodBeat.o(144624);
                        throw illegalArgumentException7;
                    }
                    if (aVar.lOC != null) {
                        if (aVar.lOB == null) {
                            IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                            AppMethodBeat.o(144624);
                            throw illegalArgumentException8;
                        } else if (aVar.lOB.length != aVar.lOC.length) {
                            IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                            AppMethodBeat.o(144624);
                            throw illegalArgumentException9;
                        }
                    }
                    aVar.lOA = readInt;
                    aVar.lOB = bArr3;
                    aVar.lOC = bArr4;
                } else if (readInt < 0) {
                    IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("invalid manufacture id");
                    AppMethodBeat.o(144624);
                    throw illegalArgumentException10;
                } else {
                    aVar.lOA = readInt;
                    aVar.lOB = bArr3;
                    aVar.lOC = null;
                }
            }
            ScanFilterCompat bFx = aVar.bFx();
            AppMethodBeat.o(144624);
            return bFx;
        }
    };
    private static final ScanFilterCompat lOD = new a().bFx();
    final int lOA;
    final byte[] lOB;
    final byte[] lOC;
    final String lOu;
    final ParcelUuid lOv;
    final ParcelUuid lOw;
    final ParcelUuid lOx;
    final byte[] lOy;
    final byte[] lOz;
    final String mDeviceName;

    /* synthetic */ ScanFilterCompat(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, byte b2) {
        this(str, str2, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i2, bArr3, bArr4);
    }

    static {
        AppMethodBeat.i(144631);
        AppMethodBeat.o(144631);
    }

    private ScanFilterCompat(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        this.mDeviceName = str;
        this.lOv = parcelUuid;
        this.lOw = parcelUuid2;
        this.lOu = str2;
        this.lOx = parcelUuid3;
        this.lOy = bArr;
        this.lOz = bArr2;
        this.lOA = i2;
        this.lOB = bArr3;
        this.lOC = bArr4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        AppMethodBeat.i(144626);
        parcel.writeInt(this.mDeviceName == null ? 0 : 1);
        if (this.mDeviceName != null) {
            parcel.writeString(this.mDeviceName);
        }
        if (this.lOu == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        parcel.writeInt(i3);
        if (this.lOu != null) {
            parcel.writeString(this.lOu);
        }
        if (this.lOv == null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        parcel.writeInt(i4);
        if (this.lOv != null) {
            parcel.writeParcelable(this.lOv, i2);
            if (this.lOw == null) {
                i9 = 0;
            } else {
                i9 = 1;
            }
            parcel.writeInt(i9);
            if (this.lOw != null) {
                parcel.writeParcelable(this.lOw, i2);
            }
        }
        if (this.lOx == null) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        parcel.writeInt(i5);
        if (this.lOx != null) {
            parcel.writeParcelable(this.lOx, i2);
            if (this.lOy == null) {
                i7 = 0;
            } else {
                i7 = 1;
            }
            parcel.writeInt(i7);
            if (this.lOy != null) {
                parcel.writeInt(this.lOy.length);
                parcel.writeByteArray(this.lOy);
                if (this.lOz == null) {
                    i8 = 0;
                } else {
                    i8 = 1;
                }
                parcel.writeInt(i8);
                if (this.lOz != null) {
                    parcel.writeInt(this.lOz.length);
                    parcel.writeByteArray(this.lOz);
                }
            }
        }
        parcel.writeInt(this.lOA);
        if (this.lOB == null) {
            i6 = 0;
        } else {
            i6 = 1;
        }
        parcel.writeInt(i6);
        if (this.lOB != null) {
            parcel.writeInt(this.lOB.length);
            parcel.writeByteArray(this.lOB);
            if (this.lOC != null) {
                i10 = 1;
            }
            parcel.writeInt(i10);
            if (this.lOC != null) {
                parcel.writeInt(this.lOC.length);
                parcel.writeByteArray(this.lOC);
            }
        }
        AppMethodBeat.o(144626);
    }

    static boolean a(UUID uuid, UUID uuid2, UUID uuid3) {
        AppMethodBeat.i(144627);
        if (uuid2 == null) {
            boolean equals = uuid.equals(uuid3);
            AppMethodBeat.o(144627);
            return equals;
        } else if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) != (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits())) {
            AppMethodBeat.o(144627);
            return false;
        } else if ((uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid3.getMostSignificantBits() & uuid2.getMostSignificantBits())) {
            AppMethodBeat.o(144627);
            return true;
        } else {
            AppMethodBeat.o(144627);
            return false;
        }
    }

    static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr3[i2] != bArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if ((bArr2[i3] & bArr3[i3]) != (bArr2[i3] & bArr[i3])) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        AppMethodBeat.i(144628);
        String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.lOu + ", mUuid=" + this.lOv + ", mUuidMask=" + this.lOw + ", mServiceDataUuid=" + d.toString(this.lOx) + ", mServiceData=" + Arrays.toString(this.lOy) + ", mServiceDataMask=" + Arrays.toString(this.lOz) + ", mManufacturerId=" + this.lOA + ", mManufacturerData=" + Arrays.toString(this.lOB) + ", mManufacturerDataMask=" + Arrays.toString(this.lOC) + "]";
        AppMethodBeat.o(144628);
        return str;
    }

    public int hashCode() {
        AppMethodBeat.i(144629);
        int hashCode = Arrays.hashCode(new Object[]{this.mDeviceName, this.lOu, Integer.valueOf(this.lOA), this.lOB, this.lOC, this.lOx, this.lOy, this.lOz, this.lOv, this.lOw});
        AppMethodBeat.o(144629);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(144630);
        if (this == obj) {
            AppMethodBeat.o(144630);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(144630);
            return false;
        } else {
            ScanFilterCompat scanFilterCompat = (ScanFilterCompat) obj;
            if (!d.equals(this.mDeviceName, scanFilterCompat.mDeviceName) || !d.equals(this.lOu, scanFilterCompat.lOu) || this.lOA != scanFilterCompat.lOA || !d.deepEquals(this.lOB, scanFilterCompat.lOB) || !d.deepEquals(this.lOC, scanFilterCompat.lOC) || !d.deepEquals(this.lOx, scanFilterCompat.lOx) || !d.deepEquals(this.lOy, scanFilterCompat.lOy) || !d.deepEquals(this.lOz, scanFilterCompat.lOz) || !d.equals(this.lOv, scanFilterCompat.lOv) || !d.equals(this.lOw, scanFilterCompat.lOw)) {
                AppMethodBeat.o(144630);
                return false;
            }
            AppMethodBeat.o(144630);
            return true;
        }
    }

    public static final class a {
        int lOA = -1;
        byte[] lOB;
        byte[] lOC;
        ParcelUuid lOE;
        String lOu;
        ParcelUuid lOv;
        ParcelUuid lOx;
        byte[] lOy;
        byte[] lOz;
        String mDeviceName;

        public final a a(ParcelUuid parcelUuid) {
            this.lOv = parcelUuid;
            this.lOE = null;
            return this;
        }

        public final ScanFilterCompat bFx() {
            AppMethodBeat.i(144625);
            ScanFilterCompat scanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.lOu, this.lOv, this.lOE, this.lOx, this.lOy, this.lOz, this.lOA, this.lOB, this.lOC, (byte) 0);
            AppMethodBeat.o(144625);
            return scanFilterCompat;
        }
    }
}
