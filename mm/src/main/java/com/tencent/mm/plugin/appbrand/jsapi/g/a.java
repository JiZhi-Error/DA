package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class a {
    public static BroadcastReceiver lKJ;
    public static boolean lKK;
    public static Map<String, C0666a> map = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(144673);
        AppMethodBeat.o(144673);
    }

    public static void a(String str, C0666a aVar) {
        AppMethodBeat.i(144670);
        map.put(str, aVar);
        if (lKJ == null) {
            Log.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
            lKJ = new BroadcastReceiver() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.g.a.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    boolean z = false;
                    AppMethodBeat.i(144666);
                    if (intent == null) {
                        Log.i("MicroMsg.BeaconManager", "Receive intent failed");
                        AppMethodBeat.o(144666);
                        return;
                    }
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        int state = defaultAdapter.getState();
                        Log.i("MicroMsg.BeaconManager", "state:%d", Integer.valueOf(state));
                        if (state == 12) {
                            z = true;
                        } else if (state == 10) {
                        }
                        if ((a.lKK && !z) || (!a.lKK && z)) {
                            for (C0666a aVar : a.map.values()) {
                                if (aVar.isStart() && !z) {
                                    aVar.Qt();
                                }
                                if (aVar.lWm != null) {
                                    aVar.lWm.ho(z);
                                }
                            }
                        }
                        a.lKK = z;
                    }
                    AppMethodBeat.o(144666);
                }
            };
            MMApplicationContext.getContext().registerReceiver(lKJ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        AppMethodBeat.o(144670);
    }

    public static C0666a ZM(String str) {
        AppMethodBeat.i(144671);
        C0666a aVar = map.get(str);
        AppMethodBeat.o(144671);
        return aVar;
    }

    public static void remove(String str) {
        AppMethodBeat.i(144672);
        map.remove(str);
        Log.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", str);
        if (map.size() == 0 && lKJ != null) {
            Log.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
            MMApplicationContext.getContext().unregisterReceiver(lKJ);
            lKJ = null;
        }
        AppMethodBeat.o(144672);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a$a  reason: collision with other inner class name */
    public static class C0666a {
        volatile boolean isStart = false;
        BluetoothAdapter lWj;
        Map<String, JSONObject> lWk = new ConcurrentHashMap();
        UUID[] lWl = null;
        AbstractC0667a lWm;
        long lWn = 0;
        Map<String, JSONObject> lWo = new ConcurrentHashMap();
        BluetoothAdapter.LeScanCallback lWp = new BluetoothAdapter.LeScanCallback() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.g.a.C0666a.AnonymousClass1 */

            public final void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                double pow;
                AppMethodBeat.i(144667);
                if (Util.isNullOrNil(bArr)) {
                    Log.e("MicroMsg.BeaconManager", "valueByte is null or nil");
                    AppMethodBeat.o(144667);
                    return;
                }
                Log.i("MicroMsg.BeaconManager", "handleScanData, device: ".concat(String.valueOf(bluetoothDevice)));
                int i3 = 2;
                boolean z = false;
                while (true) {
                    if (i3 > 5) {
                        break;
                    }
                    if ((bArr[i3 + 2] & 255) == 2 && (bArr[i3 + 3] & 255) == 21) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z) {
                    byte[] bArr2 = new byte[16];
                    System.arraycopy(bArr, i3 + 4, bArr2, 0, 16);
                    StringBuilder sb = new StringBuilder();
                    for (int i4 = 0; i4 < 16; i4++) {
                        int i5 = bArr2[i4] & 255;
                        if (i5 < 16) {
                            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        sb.append(Integer.toHexString(i5));
                    }
                    String upperCase = sb.toString().toUpperCase(Locale.US);
                    if (Util.isNullOrNil(upperCase)) {
                        Log.e("MicroMsg.BeaconManager", "hexString is null, err");
                        AppMethodBeat.o(144667);
                        return;
                    }
                    String str = upperCase.substring(0, 8) + "-" + upperCase.substring(8, 12) + "-" + upperCase.substring(12, 16) + "-" + upperCase.substring(16, 20) + "-" + upperCase.substring(20, 32);
                    Log.i("MicroMsg.BeaconManager", "strUuid %s", str);
                    UUID fromString = UUID.fromString(str);
                    boolean z2 = false;
                    UUID[] uuidArr = C0666a.this.lWl;
                    int length = uuidArr.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        } else if (uuidArr[i6].equals(fromString)) {
                            z2 = true;
                            break;
                        } else {
                            i6++;
                        }
                    }
                    if (!z2) {
                        Log.i("MicroMsg.BeaconManager", "not found beacon!");
                        AppMethodBeat.o(144667);
                        return;
                    }
                    int i7 = ((bArr[i3 + 20] & 255) * 256) + (bArr[i3 + 21] & 255);
                    int i8 = ((bArr[i3 + 22] & 255) * 256) + (bArr[i3 + 23] & 255);
                    byte b2 = bArr[i3 + 24];
                    double d2 = (double) i2;
                    if (d2 == 0.0d) {
                        pow = -1.0d;
                    } else {
                        double d3 = (d2 * 1.0d) / ((double) b2);
                        if (d3 < 1.0d) {
                            pow = Math.pow(d3, 10.0d);
                        } else {
                            pow = (Math.pow(d3, 9.9476d) * 0.92093d) + 0.54992d;
                        }
                    }
                    String address = bluetoothDevice.getAddress();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("uuid", fromString);
                        jSONObject.put("major", i7);
                        jSONObject.put("minor", i8);
                        jSONObject.put("proximity", 0);
                        jSONObject.put("accuracy", pow);
                        jSONObject.put("rssi", i2);
                        C0666a.this.lWk.put(address, jSONObject);
                        C0666a.this.lWo.put(address, jSONObject);
                        Log.d("MicroMsg.BeaconManager", "found device ibeacon %s", jSONObject);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.BeaconManager", "put JSON data error : %s", e2);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - C0666a.this.lWn > 500) {
                        if (C0666a.this.lWm != null) {
                            C0666a.this.lWm.O(C0666a.this.lWo);
                        }
                        C0666a.this.lWn = currentTimeMillis;
                        C0666a.this.lWo.clear();
                    }
                }
                AppMethodBeat.o(144667);
            }
        };

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a$a$a  reason: collision with other inner class name */
        public interface AbstractC0667a {
            void O(Map<String, JSONObject> map);

            void ho(boolean z);
        }

        public C0666a() {
            AppMethodBeat.i(144668);
            BluetoothManager bluetoothManager = (BluetoothManager) MMApplicationContext.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                Log.e("MicroMsg.BeaconManager", "bluetoothManager is null!");
                AppMethodBeat.o(144668);
                return;
            }
            this.lWj = bluetoothManager.getAdapter();
            if (this.lWj == null) {
                Log.e("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
                AppMethodBeat.o(144668);
                return;
            }
            a.lKK = this.lWj.isEnabled();
            AppMethodBeat.o(144668);
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean isStart() {
            return this.isStart;
        }

        public final boolean Qt() {
            AppMethodBeat.i(144669);
            Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d stop", Integer.valueOf(hashCode()));
            if (!isStart()) {
                Log.i("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", Integer.valueOf(hashCode()));
                AppMethodBeat.o(144669);
                return false;
            }
            this.lWk.clear();
            this.lWj.stopLeScan(this.lWp);
            this.isStart = false;
            AppMethodBeat.o(144669);
            return true;
        }
    }
}
