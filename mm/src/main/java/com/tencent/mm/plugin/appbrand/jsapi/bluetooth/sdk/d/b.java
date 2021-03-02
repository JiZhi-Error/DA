package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.bluetooth.BluetoothAdapter;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\b\u001a\u0006\u0010\t\u001a\u00020\n\u001a0\u0010\u000b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0003\u001a8\u0010\u0013\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u001a \u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0006\b\u0000\u0010\u0019\u0018\u0001*\u00020\u001aH\b¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"HEX", "", "TAG", "", "byteArrayToHexString", "bytes", "", "getRandomId", "", "isPeripheralBleSupported", "", "callbackFail", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "callbackId", "env", "errCode", "errMsg", "callbackSuccess", NativeProtocol.WEB_DIALOG_PARAMS, "Ljava/util/HashMap;", "", "toArray", "", "T", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/Object;", "luggage-commons-jsapi-connectivity-ext_release"})
public final class b {
    private static final char[] lOU = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final boolean bFz() {
        boolean z = true;
        AppMethodBeat.i(144795);
        z.a aVar = new z.a();
        BluetoothAdapter bFC = c.bFC();
        if (bFC == null) {
            AppMethodBeat.o(144795);
            return false;
        }
        p.g(bFC, "getBleAdapter() ?: return false");
        Log.d("MicroMsg.BLE.BleHelpExt", "isPeripheralBleSupported: isMultipleAdvertisementSupported = " + bFC.isMultipleAdvertisementSupported() + '\n' + "isOffloadedFilteringSupported = " + bFC.isOffloadedFilteringSupported() + '\n' + "isOffloadedScanBatchingSupported = " + bFC.isOffloadedScanBatchingSupported() + '\n' + "bluetoothLeAdvertiser != null? = " + (bFC.getBluetoothLeAdvertiser() != null) + '\n');
        if (bFC.getBluetoothLeAdvertiser() == null) {
            z = false;
        }
        aVar.SYB = z;
        boolean z2 = aVar.SYB;
        AppMethodBeat.o(144795);
        return z2;
    }

    public static /* synthetic */ void a(d dVar, int i2, f fVar) {
        AppMethodBeat.i(144797);
        a(dVar, i2, fVar, null);
        AppMethodBeat.o(144797);
    }

    public static final void a(d<f> dVar, int i2, f fVar, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2;
        AppMethodBeat.i(144796);
        p.h(dVar, "$this$callbackSuccess");
        p.h(fVar, "env");
        Log.d("MicroMsg.BLE.BleHelpExt", "callbackSuccess: api = " + dVar.getClass().getSimpleName());
        if (hashMap == null) {
            hashMap2 = new HashMap<>();
        } else {
            hashMap2 = hashMap;
        }
        hashMap2.put("errCode", 0);
        fVar.i(i2, dVar.n("ok", hashMap2));
        AppMethodBeat.o(144796);
    }

    public static final void a(d<f> dVar, int i2, f fVar, int i3, String str) {
        AppMethodBeat.i(144798);
        p.h(dVar, "$this$callbackFail");
        p.h(fVar, "env");
        p.h(str, "errMsg");
        Log.d("MicroMsg.BLE.BleHelpExt", "callbackFail: api = %s, reason = %s", dVar.getClass().getSimpleName(), str);
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(i3));
        fVar.i(i2, dVar.n(str, hashMap));
        AppMethodBeat.o(144798);
    }

    public static final int bFA() {
        AppMethodBeat.i(144799);
        int nextInt = kotlin.j.d.Pf(System.currentTimeMillis()).nextInt(1, Integer.MAX_VALUE);
        AppMethodBeat.o(144799);
        return nextInt;
    }
}
