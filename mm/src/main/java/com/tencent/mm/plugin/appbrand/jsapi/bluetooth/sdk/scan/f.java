package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f {
    private final int lOF;
    public final List<ParcelUuid> lOG;
    public final SparseArray<byte[]> lOH;
    public final Map<ParcelUuid, byte[]> lOI;
    private final int lOJ;
    final byte[] lOK;
    public final SparseArray<byte[]> lOL;
    public final String mDeviceName;

    private f(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i2, int i3, String str, byte[] bArr, SparseArray<byte[]> sparseArray2) {
        this.lOG = list;
        this.lOH = sparseArray;
        this.lOI = map;
        this.mDeviceName = str;
        this.lOF = i2;
        this.lOJ = i3;
        this.lOK = bArr;
        this.lOL = sparseArray2;
    }

    @TargetApi(21)
    f(ScanRecord scanRecord) {
        AppMethodBeat.i(144632);
        this.lOG = scanRecord.getServiceUuids();
        this.lOH = scanRecord.getManufacturerSpecificData();
        this.lOI = scanRecord.getServiceData();
        this.mDeviceName = scanRecord.getDeviceName();
        this.lOF = scanRecord.getAdvertiseFlags();
        this.lOJ = scanRecord.getTxPowerLevel();
        this.lOK = scanRecord.getBytes();
        this.lOL = this.lOH;
        AppMethodBeat.o(144632);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f aJ(byte[] r17) {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f.aJ(byte[]):com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f");
    }

    public final String toString() {
        AppMethodBeat.i(144634);
        String str = "ScanRecord [mAdvertiseFlags=" + this.lOF + ", mServiceUuids=" + this.lOG + ", mManufacturerSpecificData=" + d(this.lOH) + ", mServiceData=" + M(this.lOI) + ", mTxPowerLevel=" + this.lOJ + ", mDeviceName=" + this.mDeviceName + ", mBytes=" + Arrays.toString(this.lOK) + ", mManufacturerSpecificDataFixed=" + d(this.lOL) + "]";
        AppMethodBeat.o(144634);
        return str;
    }

    private static int a(byte[] bArr, int i2, int i3, int i4, List<ParcelUuid> list) {
        AppMethodBeat.i(144635);
        while (i3 > 0) {
            list.add(c.aI(B(bArr, i2, i4)));
            i3 -= i4;
            i2 += i4;
        }
        AppMethodBeat.o(144635);
        return i2;
    }

    private static byte[] B(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(144636);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        AppMethodBeat.o(144636);
        return bArr2;
    }

    private static String d(SparseArray<byte[]> sparseArray) {
        AppMethodBeat.i(144637);
        if (sparseArray == null) {
            AppMethodBeat.o(144637);
            return BuildConfig.COMMAND;
        } else if (sparseArray.size() == 0) {
            AppMethodBeat.o(144637);
            return "{}";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                sb.append(sparseArray.keyAt(i2)).append("=").append(Arrays.toString(sparseArray.valueAt(i2)));
            }
            sb.append('}');
            String sb2 = sb.toString();
            AppMethodBeat.o(144637);
            return sb2;
        }
    }

    private static <T> String M(Map<T, byte[]> map) {
        AppMethodBeat.i(144638);
        if (map == null) {
            AppMethodBeat.o(144638);
            return BuildConfig.COMMAND;
        } else if (map.isEmpty()) {
            AppMethodBeat.o(144638);
            return "{}";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            Iterator<Map.Entry<T, byte[]>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                T key = it.next().getKey();
                sb.append((Object) key).append("=").append(Arrays.toString(map.get(key)));
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            String sb2 = sb.toString();
            AppMethodBeat.o(144638);
            return sb2;
        }
    }
}
