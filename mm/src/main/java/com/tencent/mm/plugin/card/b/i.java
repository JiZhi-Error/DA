package com.tencent.mm.plugin.card.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class i implements com.tencent.mm.ak.i {
    public Object dBh = new Object();
    public volatile float gmu = -85.0f;
    public volatile float gmv = -1000.0f;
    public volatile boolean isInit = false;
    String pQH;
    private com.tencent.mm.plugin.card.base.b pQV;
    public MMActivity pRg;
    private volatile boolean pRh = false;
    private boolean pRi = false;
    boolean pRj = false;
    private boolean pRk = false;
    qr pRl;
    private b pRm;
    public a pRn;
    private int pRo = 60;
    private long pRp = 0;
    private long pRq = 0;
    private long pRr = 10000;
    public MTimerHandler pRs = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.card.b.i.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(112645);
            i.this.report();
            i.this.ctw();
            AppMethodBeat.o(112645);
            return true;
        }
    }, false);

    public i() {
        AppMethodBeat.i(112657);
        AppMethodBeat.o(112657);
    }

    public final void a(MMActivity mMActivity, String str, com.tencent.mm.plugin.card.base.b bVar, float f2, float f3) {
        int i2;
        boolean z;
        AppMethodBeat.i(112658);
        this.isInit = true;
        this.pRg = mMActivity;
        this.pQH = str;
        this.pQV = bVar;
        this.gmu = f2;
        this.gmv = f3;
        this.pRi = bVar.csQ().Lfj;
        this.pRj = bVar.csR().LcH;
        this.pRl = bVar.csQ().Lfk;
        if (bVar.csQ().Lfk == null) {
            i2 = 60;
        } else {
            i2 = bVar.csQ().Lfk.KXx;
        }
        this.pRo = i2;
        if (bVar.csQ().Lfk == null || Util.isNullOrNil(bVar.csQ().Lfk.name)) {
            z = false;
        } else {
            z = true;
        }
        this.pRk = z;
        Log.i("MicroMsg.CardLbsOrBluetooth", "init cardId:%s, needLocation:%b, isLocationAuth:%b needBluetooth:%b reportTime:%d", str, Boolean.valueOf(this.pRi), Boolean.valueOf(this.pRj), Boolean.valueOf(this.pRk), Integer.valueOf(this.pRo));
        if (this.pRi && !this.pRj) {
            h.a(this.pRg, this.pRg.getString(R.string.ary, new Object[]{Util.isNullOrNil(this.pQV.csQ().KUD) ? this.pQV.csQ().title : this.pQV.csQ().KUD}), this.pRg.getString(R.string.zb), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.card.b.i.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(112646);
                    i.this.pRj = true;
                    i.a(i.this.pQH, new byte[0], -85.0f, -1000.0f, 0, false, true);
                    AppMethodBeat.o(112646);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.card.b.i.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    i.this.pRj = false;
                }
            });
        }
        if (this.pRk) {
            Log.i("MicroMsg.CardLbsOrBluetooth", "initBluetoothHelper blueToothInfo.name:%s", this.pRl.name);
            this.pRn = new a(this, (byte) 0);
            a aVar = this.pRn;
            Log.i("MicroMsg.CardLbsOrBluetooth", "init bluetoothStateListener");
            aVar.lKJ = new BroadcastReceiver() {
                /* class com.tencent.mm.plugin.card.b.i.a.AnonymousClass2 */

                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(112648);
                    if (intent == null) {
                        Log.i("MicroMsg.CardLbsOrBluetooth", "Receive intent failed");
                        AppMethodBeat.o(112648);
                        return;
                    }
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        int state = defaultAdapter.getState();
                        Log.d("MicroMsg.CardLbsOrBluetooth", "state:%d", Integer.valueOf(state));
                        if (state == 12) {
                            a.this.pRv = true;
                            MMHandlerThread.postToMainThreadDelayed(a.this.pRy, a.this.pRx);
                            AppMethodBeat.o(112648);
                            return;
                        } else if (state == 10) {
                            MMHandlerThread.removeRunnable(a.this.pRy);
                            a.this.pRv = false;
                            a.this.pRw.clear();
                        }
                    }
                    AppMethodBeat.o(112648);
                }
            };
            MMApplicationContext.getContext().registerReceiver(aVar.lKJ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        start();
        report();
        AppMethodBeat.o(112658);
    }

    public final void start() {
        AppMethodBeat.i(112659);
        if (!ctA()) {
            AppMethodBeat.o(112659);
            return;
        }
        Log.i("MicroMsg.CardLbsOrBluetooth", "start");
        if (!this.isInit) {
            Log.e("MicroMsg.CardLbsOrBluetooth", "isInit:%b", Boolean.valueOf(this.isInit));
            AppMethodBeat.o(112659);
            return;
        }
        if (this.pRi) {
            byG();
        }
        if (this.pRn != null && this.pRk) {
            this.pRn.ctC();
        }
        ctw();
        g.aAg().hqi.a(2574, this);
        AppMethodBeat.o(112659);
    }

    public final void ctw() {
        AppMethodBeat.i(112660);
        ctx();
        if (this.pRo > 0) {
            this.pRs.startTimer((long) (this.pRo * 1000));
            Log.i("MicroMsg.CardLbsOrBluetooth", "start ReportTimer!");
            AppMethodBeat.o(112660);
            return;
        }
        Log.e("MicroMsg.CardLbsOrBluetooth", "not to start ReportTimer!");
        AppMethodBeat.o(112660);
    }

    public final void ctx() {
        AppMethodBeat.i(112661);
        Log.i("MicroMsg.CardLbsOrBluetooth", "stop ReportTimer!");
        if (!this.pRs.stopped()) {
            this.pRs.stopTimer();
        }
        AppMethodBeat.o(112661);
    }

    public final void report() {
        boolean z;
        AppMethodBeat.i(112662);
        if (!ctA()) {
            Log.i("MicroMsg.CardLbsOrBluetooth", "[report]not need report");
            AppMethodBeat.o(112662);
        } else if (this.pRh) {
            Log.i("MicroMsg.CardLbsOrBluetooth", "isReporting, return");
            AppMethodBeat.o(112662);
        } else {
            this.pRh = true;
            boolean ctz = ctz();
            boolean cty = cty();
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(this.pRi);
            objArr[1] = Boolean.valueOf(this.pRj);
            if (this.pRn == null) {
                z = false;
            } else {
                z = this.pRn.pRv;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Boolean.valueOf(ctz);
            objArr[4] = Boolean.valueOf(cty);
            Log.i("MicroMsg.CardLbsOrBluetooth", "report needLocation:%b, isLocationAuth:%b, isBluetoothEnable:%b, needReportBluetooth:%b needReportGps:%b", objArr);
            if (ctz && cty) {
                b ctB = this.pRn.ctB();
                Log.i("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps deviceInfo:%s", ctB);
                Log.d("MicroMsg.CardLbsOrBluetooth", "reportBluetoothAndGps lbsLongitude:%f, lbsLatitude:%f", Float.valueOf(this.gmv), Float.valueOf(this.gmu));
                a(this.pQH, ctB.pRB, this.gmv, this.gmu, ctB.dIX, this.pRn.pRv);
                this.pRq = System.currentTimeMillis();
                this.pRp = System.currentTimeMillis();
                this.pRn.reset();
                this.pRm = ctB;
                AppMethodBeat.o(112662);
            } else if (ctz) {
                b ctB2 = this.pRn.ctB();
                Log.i("MicroMsg.CardLbsOrBluetooth", "reportBluetooth deviceInfo:%s", ctB2);
                a(this.pQH, ctB2.pRB, ctB2.dIX, this.pRn.pRv);
                this.pRp = System.currentTimeMillis();
                this.pRn.reset();
                this.pRm = ctB2;
                AppMethodBeat.o(112662);
            } else if (cty) {
                Log.i("MicroMsg.CardLbsOrBluetooth", "reportgps");
                Log.d("MicroMsg.CardLbsOrBluetooth", "reportgps lbsLongitude:%f, lbsLatitude:%f", Float.valueOf(this.gmv), Float.valueOf(this.gmu));
                a(this.pQH, this.gmv, this.gmu);
                this.pRq = System.currentTimeMillis();
                AppMethodBeat.o(112662);
            } else {
                Log.e("MicroMsg.CardLbsOrBluetooth", "not report");
                this.pRh = false;
                AppMethodBeat.o(112662);
            }
        }
    }

    private boolean cty() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(112663);
        synchronized (this.dBh) {
            try {
                if (System.currentTimeMillis() - this.pRq >= this.pRr) {
                    z = true;
                } else {
                    z = false;
                }
                if (Float.compare(this.gmu, -85.0f) == 0 || Float.compare(this.gmv, -1000.0f) == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!this.pRj || !this.pRi || !z2 || !z) {
                    z3 = false;
                }
            } finally {
                AppMethodBeat.o(112663);
            }
        }
        return z3;
    }

    private boolean ctz() {
        AppMethodBeat.i(112664);
        if (!this.pRk) {
            AppMethodBeat.o(112664);
            return false;
        } else if (this.pRn == null) {
            Log.e("MicroMsg.CardLbsOrBluetooth", "[needReportBluetooth]bluetoothHelper is null, return");
            AppMethodBeat.o(112664);
            return false;
        } else if (this.pRn.ctB().dGL.equals("")) {
            AppMethodBeat.o(112664);
            return false;
        } else if (System.currentTimeMillis() - this.pRp >= this.pRr) {
            AppMethodBeat.o(112664);
            return true;
        } else {
            AppMethodBeat.o(112664);
            return false;
        }
    }

    private void a(String str, float f2, float f3) {
        AppMethodBeat.i(112665);
        a(str, new byte[0], f2, f3, 0, false, this.pRj);
        AppMethodBeat.o(112665);
    }

    private void a(String str, byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(112666);
        a(str, bArr, -1000.0f, -85.0f, i2, z, this.pRj);
        AppMethodBeat.o(112666);
    }

    private void a(String str, byte[] bArr, float f2, float f3, int i2, boolean z) {
        AppMethodBeat.i(112667);
        a(str, bArr, f2, f3, i2, z, this.pRj);
        AppMethodBeat.o(112667);
    }

    static void a(String str, byte[] bArr, float f2, float f3, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(112668);
        g.aAg().hqi.a(new ai(str, bArr, f2, f3, (float) i2, z, z2), 0);
        AppMethodBeat.o(112668);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(112669);
        Log.i("MicroMsg.CardLbsOrBluetooth", "report success, onSceneEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pRh = false;
        AppMethodBeat.o(112669);
    }

    private static void byG() {
        AppMethodBeat.i(112670);
        LocationManager locationManager = (LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
        if (locationManager != null) {
            Log.i("MicroMsg.CardLbsOrBluetooth", "isGPSEnable:%b isNetworkEnable:%b", Boolean.valueOf(locationManager.isProviderEnabled("gps")), Boolean.valueOf(locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER)));
        }
        AppMethodBeat.o(112670);
    }

    public final boolean ctA() {
        return this.pRi || this.pRk;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        String dGL;
        int dIX;
        String name;
        byte[] pRB;

        public b(String str, int i2, String str2, byte[] bArr) {
            this.dGL = str;
            this.dIX = i2;
            this.name = str2;
            this.pRB = bArr;
        }

        public final String toString() {
            AppMethodBeat.i(112656);
            String str = "SrvDeviceInfo{deviceId='" + this.dGL + '\'' + ", rssi=" + this.dIX + ", name='" + this.name + '\'' + ", manuData=" + Arrays.toString(this.pRB) + '}';
            AppMethodBeat.o(112656);
            return str;
        }
    }

    public class a {
        public BroadcastReceiver lKJ;
        private BluetoothAdapter lWj;
        private volatile boolean pRu;
        boolean pRv;
        Map<String, b> pRw;
        long pRx;
        Runnable pRy;
        private BluetoothAdapter.LeScanCallback pRz;

        private a() {
            AppMethodBeat.i(112650);
            this.pRu = false;
            this.pRv = false;
            this.pRw = new ConcurrentHashMap();
            this.pRx = 3000;
            this.pRy = new Runnable() {
                /* class com.tencent.mm.plugin.card.b.i.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(112647);
                    a.this.ctD();
                    a.this.ctC();
                    AppMethodBeat.o(112647);
                }
            };
            this.pRz = new BluetoothAdapter.LeScanCallback() {
                /* class com.tencent.mm.plugin.card.b.i.a.AnonymousClass3 */

                public final void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                    AppMethodBeat.i(112649);
                    if (bluetoothDevice == null) {
                        Log.e("MicroMsg.CardLbsOrBluetooth", "device is null, return");
                        AppMethodBeat.o(112649);
                    } else if (i.this.pRl == null || Util.isNullOrNil(i.this.pRl.name)) {
                        AppMethodBeat.o(112649);
                    } else {
                        String nullAsNil = Util.nullAsNil(bluetoothDevice.getName());
                        String address = bluetoothDevice.getAddress();
                        if (nullAsNil.equals(i.this.pRl.name)) {
                            Log.i("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", address, nullAsNil, Integer.valueOf(i2));
                            a.this.pRw.put(address, new b(address, i2, nullAsNil, a.bc(bArr)));
                            AppMethodBeat.o(112649);
                            return;
                        }
                        Log.d("MicroMsg.CardLbsOrBluetooth", "onLeScan for deviceId:%s, name:%s, rssi:%d", address, nullAsNil, Integer.valueOf(i2));
                        AppMethodBeat.o(112649);
                    }
                }
            };
            AppMethodBeat.o(112650);
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }

        public final void reset() {
            AppMethodBeat.i(112651);
            this.pRw.clear();
            AppMethodBeat.o(112651);
        }

        public final b ctB() {
            AppMethodBeat.i(112652);
            b bVar = new b("", -100, "", null);
            if (this.pRw.size() <= 0) {
                AppMethodBeat.o(112652);
                return bVar;
            }
            Iterator<b> it = this.pRw.values().iterator();
            while (it.hasNext()) {
                bVar = it.next();
                if (bVar.dIX >= bVar.dIX) {
                    bVar = bVar;
                }
            }
            AppMethodBeat.o(112652);
            return bVar;
        }

        @TargetApi(18)
        public final void ctC() {
            AppMethodBeat.i(112653);
            if (Build.VERSION.SDK_INT < 18) {
                Log.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
                AppMethodBeat.o(112653);
            } else if (this.pRu) {
                Log.i("MicroMsg.CardLbsOrBluetooth", "already start");
                AppMethodBeat.o(112653);
            } else {
                this.pRw.clear();
                BluetoothManager bluetoothManager = (BluetoothManager) MMApplicationContext.getContext().getSystemService("bluetooth");
                if (bluetoothManager == null) {
                    this.pRv = false;
                    Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
                    AppMethodBeat.o(112653);
                    return;
                }
                this.pRv = true;
                this.lWj = bluetoothManager.getAdapter();
                if (this.lWj == null || !this.lWj.isEnabled()) {
                    this.pRv = false;
                    Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
                    AppMethodBeat.o(112653);
                    return;
                }
                Log.i("MicroMsg.CardLbsOrBluetooth", "[BluetoothTrace] start scan");
                Log.printErrStackTrace("MicroMsg.CardLbsOrBluetooth", new Throwable(), "[BluetoothTrace] ble scan stacktrace", new Object[0]);
                Log.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", Boolean.valueOf(this.lWj.startLeScan(this.pRz)));
                this.pRu = true;
                AppMethodBeat.o(112653);
            }
        }

        @TargetApi(18)
        public final void ctD() {
            AppMethodBeat.i(112654);
            if (Build.VERSION.SDK_INT < 18) {
                Log.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
                AppMethodBeat.o(112654);
            } else if (!this.pRu) {
                Log.i("MicroMsg.CardLbsOrBluetooth", "not start");
                AppMethodBeat.o(112654);
            } else if (this.lWj == null || !this.lWj.isEnabled()) {
                this.pRv = false;
                Log.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
                AppMethodBeat.o(112654);
            } else {
                this.pRv = true;
                this.lWj.stopLeScan(this.pRz);
                Log.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
                this.pRu = false;
                AppMethodBeat.o(112654);
            }
        }

        public static byte[] bc(byte[] bArr) {
            byte[] bArr2 = null;
            AppMethodBeat.i(112655);
            if (bArr == null) {
                AppMethodBeat.o(112655);
            } else {
                int i2 = 0;
                while (i2 < bArr.length) {
                    int i3 = i2 + 1;
                    int i4 = bArr[i2] & 255;
                    if (i4 != 0) {
                        int i5 = i4 - 1;
                        int i6 = i3 + 1;
                        switch (bArr[i3] & 255) {
                            case 255:
                                bArr2 = new byte[i5];
                                System.arraycopy(bArr, i6, bArr2, 0, i5);
                                break;
                        }
                        i2 = i5 + i6;
                    } else {
                        AppMethodBeat.o(112655);
                    }
                }
                AppMethodBeat.o(112655);
            }
            return bArr2;
        }
    }
}
