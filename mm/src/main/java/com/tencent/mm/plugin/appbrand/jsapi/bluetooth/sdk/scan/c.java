package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* access modifiers changed from: package-private */
public final class c {
    public static final ParcelUuid lNZ = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOa = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOb = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOc = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOd = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOe = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOf = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOg = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOh = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOi = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid lOj = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid lOk = ParcelUuid.fromString("00001812-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid lOl = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOm = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOn = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOo = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOp = ParcelUuid.fromString("00001134-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOq = ParcelUuid.fromString("00001133-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOr = ParcelUuid.fromString("00001132-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid lOs = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid[] lOt = {lNZ, lOa, lOb, lOc, lOe, lOg, lOh, lOi, lOl, lOm, lOp, lOq, lOr};

    static {
        AppMethodBeat.i(144620);
        AppMethodBeat.o(144620);
    }

    public static ParcelUuid aI(byte[] bArr) {
        long j2;
        AppMethodBeat.i(144619);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("uuidBytes cannot be null");
            AppMethodBeat.o(144619);
            throw illegalArgumentException;
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("uuidBytes length invalid - ".concat(String.valueOf(length)));
            AppMethodBeat.o(144619);
            throw illegalArgumentException2;
        } else if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            ParcelUuid parcelUuid = new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
            AppMethodBeat.o(144619);
            return parcelUuid;
        } else {
            if (length == 2) {
                j2 = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
            } else {
                j2 = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8)) + ((long) ((bArr[2] & 255) << 16)) + ((long) ((bArr[3] & 255) << 24));
            }
            ParcelUuid parcelUuid2 = new ParcelUuid(new UUID(lOs.getUuid().getMostSignificantBits() + (j2 << 32), lOs.getUuid().getLeastSignificantBits()));
            AppMethodBeat.o(144619);
            return parcelUuid2;
        }
    }
}
