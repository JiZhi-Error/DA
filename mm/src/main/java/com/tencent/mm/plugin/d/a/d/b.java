package com.tencent.mm.plugin.d.a.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.b;
import com.tencent.mm.plugin.d.a.c.a;
import com.tencent.mm.plugin.exdevice.service.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import junit.framework.Assert;

public final class b {
    private MMHandler mHandler = null;
    public com.tencent.mm.plugin.d.a.b.b pjW = null;
    public com.tencent.mm.plugin.d.a.c.a pjX = null;
    c pjY = null;
    final HashSet<String> pjZ = new HashSet<>();

    class a extends a.AbstractC0937a {
        a() {
        }

        @Override // com.tencent.mm.plugin.d.a.c.a.AbstractC0937a
        public final void i(long j2, long j3, long j4) {
            AppMethodBeat.i(22609);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSessionCreate*** sessionID = " + j2 + " deviceID = " + j3);
            Assert.assertTrue(b.a(b.this, 6, 1, new d(j2, j3, j4)));
            AppMethodBeat.o(22609);
        }

        @Override // com.tencent.mm.plugin.d.a.c.a.AbstractC0937a
        public final void ckF() {
            AppMethodBeat.i(22610);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscoverFinished***");
            b.this.pjZ.clear();
            Assert.assertTrue(b.a(b.this, 2, 1, null));
            AppMethodBeat.o(22610);
        }

        @Override // com.tencent.mm.plugin.d.a.c.a.AbstractC0937a
        public final void fb(String str, String str2) {
            boolean z;
            AppMethodBeat.i(22611);
            b bVar = b.this;
            if (str == null) {
                Log.e("MicroMsg.exdevice.BluetoothSDKManager", "null == aDeviceMac");
                z = false;
            } else if (bVar.pjZ.contains(str)) {
                z = false;
            } else {
                bVar.pjZ.add(str);
                z = true;
            }
            if (!z) {
                AppMethodBeat.o(22611);
                return;
            }
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onDiscover*** deviceMac = " + str + "deviceName = " + str2);
            Assert.assertTrue(b.a(b.this, 3, 1, new i(str, str2, 0, null)));
            AppMethodBeat.o(22611);
        }

        @Override // com.tencent.mm.plugin.d.a.c.a.AbstractC0937a
        public final void l(long j2, boolean z) {
            AppMethodBeat.i(22612);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onConnected*** SessionId = " + j2 + " Connected = " + z);
            Assert.assertTrue(b.a(b.this, 4, 1, new f(j2, z)));
            AppMethodBeat.o(22612);
        }

        @Override // com.tencent.mm.plugin.d.a.c.a.AbstractC0937a
        public final void b(long j2, byte[] bArr) {
            AppMethodBeat.i(22613);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onRecv*** sessionId = ".concat(String.valueOf(j2)));
            Assert.assertTrue(b.a(b.this, 1, 1, new h(j2, bArr)));
            AppMethodBeat.o(22613);
        }

        @Override // com.tencent.mm.plugin.d.a.c.a.AbstractC0937a
        public final void m(long j2, boolean z) {
            AppMethodBeat.i(22614);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onSend*** SessionId = " + j2 + " success = " + z);
            Assert.assertTrue(b.a(b.this, 0, 1, new j(j2, z)));
            AppMethodBeat.o(22614);
        }

        @Override // com.tencent.mm.plugin.d.a.c.a.AbstractC0937a
        public final void c(long j2, int i2, String str) {
            AppMethodBeat.i(22615);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BC onError*** SessionId = " + j2 + " errorCode = " + i2 + " errorInfo = " + str);
            Assert.assertTrue(b.a(b.this, 5, 1, new g(j2, i2, str)));
            AppMethodBeat.o(22615);
        }
    }

    /* renamed from: com.tencent.mm.plugin.d.a.d.b$b  reason: collision with other inner class name */
    class C0941b extends b.a {
        C0941b() {
        }

        @Override // com.tencent.mm.plugin.d.a.b.b.a
        public final void i(long j2, long j3, long j4) {
            AppMethodBeat.i(22616);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSessionCreate*** sessionID = " + j2 + " deviceID = " + j3);
            Assert.assertTrue(b.a(b.this, 6, 0, new d(j2, j3, j4)));
            AppMethodBeat.o(22616);
        }

        @Override // com.tencent.mm.plugin.d.a.b.b.a
        public final void ckF() {
            AppMethodBeat.i(22617);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onDiscoverFinished***");
            b.this.pjZ.clear();
            Assert.assertTrue(b.a(b.this, 2, 0, null));
            AppMethodBeat.o(22617);
        }

        @Override // com.tencent.mm.plugin.d.a.b.b.a
        public final void a(String str, String str2, int i2, byte[] bArr) {
            AppMethodBeat.i(22618);
            Log.d("MicroMsg.exdevice.BluetoothSDKManager", "---BLE onDiscover---, %s, %s", str, str2);
            Assert.assertTrue(b.a(b.this, 3, 0, new i(str, str2, i2, bArr)));
            AppMethodBeat.o(22618);
        }

        @Override // com.tencent.mm.plugin.d.a.b.b.a
        public final void l(long j2, boolean z) {
            AppMethodBeat.i(22619);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onConnected*** SessionId = " + j2 + " Connected = " + z);
            Assert.assertTrue(b.a(b.this, 4, 0, new f(j2, z)));
            AppMethodBeat.o(22619);
        }

        @Override // com.tencent.mm.plugin.d.a.b.b.a
        public final void b(long j2, byte[] bArr) {
            AppMethodBeat.i(22620);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onRecv*** sessionId = ".concat(String.valueOf(j2)));
            Assert.assertTrue(b.a(b.this, 1, 0, new h(j2, bArr)));
            AppMethodBeat.o(22620);
        }

        @Override // com.tencent.mm.plugin.d.a.b.b.a
        public final void m(long j2, boolean z) {
            AppMethodBeat.i(22621);
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***BLE onSend*** SessionId = " + j2 + " success = " + z);
            Assert.assertTrue(b.a(b.this, 0, 0, new j(j2, z)));
            AppMethodBeat.o(22621);
        }
    }

    static class e {
        long pkc;
        boolean pkd;

        public e(long j2, boolean z) {
            this.pkc = j2;
            this.pkd = z;
        }
    }

    static final class f extends e {
        public f(long j2, boolean z) {
            super(j2, z);
        }
    }

    static final class j extends e {
        public j(long j2, boolean z) {
            super(j2, z);
        }
    }

    static final class h {
        byte[] mData;
        long mSessionId;

        public h(long j2, byte[] bArr) {
            this.mSessionId = j2;
            this.mData = bArr;
        }
    }

    static final class g {
        private int mErrorCode;
        long mSessionId;
        private String pke;

        public g(long j2, int i2, String str) {
            this.mSessionId = j2;
            this.mErrorCode = i2;
            this.pke = str;
        }
    }

    static final class d {
        long mSessionId;
        long pgO;
        long pkb;

        public d(long j2, long j3, long j4) {
            this.mSessionId = j2;
            this.pkb = j3;
            this.pgO = j4;
        }
    }

    static final class i {
        int lOO;
        String mDeviceName;
        String pkf;
        byte[] pkg;

        public i(String str, String str2, int i2, byte[] bArr) {
            this.pkf = str;
            this.mDeviceName = str2;
            this.lOO = i2;
            this.pkg = bArr;
        }
    }

    static class c extends MMHandler {
        private WeakReference<b> phi = null;

        public c(String str, b bVar) {
            super(str);
            AppMethodBeat.i(179585);
            this.phi = new WeakReference<>(bVar);
            AppMethodBeat.o(179585);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22623);
            b bVar = this.phi.get();
            if (bVar == null) {
                Log.w("MicroMsg.exdevice.BluetoothSDKManager", "null == BluetoothSdkManager");
                AppMethodBeat.o(22623);
                return;
            }
            Log.i("MicroMsg.exdevice.BluetoothSDKManager", "handleMessage Message.What = " + message.what);
            switch (message.what) {
                case 0:
                    j jVar = (j) message.obj;
                    bVar.pjY.m(jVar.pkc, jVar.pkd);
                    AppMethodBeat.o(22623);
                    return;
                case 1:
                    h hVar = (h) message.obj;
                    bVar.pjY.b(hVar.mSessionId, hVar.mData);
                    AppMethodBeat.o(22623);
                    return;
                case 2:
                    bVar.pjY.CK(message.arg1);
                    AppMethodBeat.o(22623);
                    return;
                case 3:
                    i iVar = (i) message.obj;
                    bVar.pjY.a(iVar.pkf, iVar.mDeviceName, message.arg1, iVar.lOO, iVar.pkg);
                    AppMethodBeat.o(22623);
                    return;
                case 4:
                    f fVar = (f) message.obj;
                    bVar.pjY.l(fVar.pkc, fVar.pkd);
                    AppMethodBeat.o(22623);
                    return;
                case 5:
                    bVar.pjY.BB(((g) message.obj).mSessionId);
                    AppMethodBeat.o(22623);
                    return;
                case 6:
                    d dVar = (d) message.obj;
                    bVar.pjY.i(dVar.mSessionId, dVar.pkb, dVar.pgO);
                    break;
            }
            AppMethodBeat.o(22623);
        }
    }

    public b(Context context, c cVar, MMHandler mMHandler) {
        AppMethodBeat.i(179586);
        this.pjX = new com.tencent.mm.plugin.d.a.c.a(mMHandler);
        if (Build.VERSION.SDK_INT >= 18) {
            this.pjW = new com.tencent.mm.plugin.d.a.b.b(mMHandler.getSerialTag());
            com.tencent.mm.plugin.d.a.b.b bVar = this.pjW;
            C0941b bVar2 = new C0941b();
            Log.i("MicroMsg.exdevice.BluetoothLEManager", "------init------");
            Assert.assertNotNull(context);
            Assert.assertNotNull(bVar2);
            if (!bVar.mIsInit) {
                bVar.mIsInit = true;
                bVar.mAppContext = context;
                bVar.pgB = bVar2;
                bVar.pgE = com.tencent.mm.plugin.d.a.b.c.ckG();
                if (com.tencent.mm.compatible.util.d.oD(21)) {
                    bVar.pgF = com.tencent.mm.plugin.d.a.b.g.ckL();
                }
                if (!bVar.ckE()) {
                    Log.w("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport!!!");
                } else {
                    bVar.pfW = ((BluetoothManager) bVar.mAppContext.getSystemService("bluetooth")).getAdapter();
                }
            }
        }
        com.tencent.mm.plugin.d.a.c.a aVar = this.pjX;
        a aVar2 = new a();
        Log.i("MicroMsg.exdevice.BluetoothChatManager", "------init------");
        Assert.assertNotNull(context);
        Assert.assertNotNull(aVar2);
        if (!aVar.mIsInit) {
            aVar.mIsInit = true;
            aVar.pjA = aVar2;
            aVar.pjB = context;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            aVar.pjB.registerReceiver(aVar.mReceiver, intentFilter);
            aVar.pfW = BluetoothAdapter.getDefaultAdapter();
        }
        this.mHandler = new c(v.cLz().jkv.getSerialTag(), this);
        this.pjY = cVar;
        AppMethodBeat.o(179586);
    }

    public final boolean d(int i2, int... iArr) {
        AppMethodBeat.i(22625);
        Log.i("MicroMsg.exdevice.BluetoothSDKManager", "---scan--- aBluetoothVersion = ".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                if (this.pjW == null) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    AppMethodBeat.o(22625);
                    return false;
                } else if (iArr == null) {
                    boolean a2 = this.pjW.a(true, new int[0]);
                    AppMethodBeat.o(22625);
                    return a2;
                } else {
                    boolean a3 = this.pjW.a(true, iArr);
                    AppMethodBeat.o(22625);
                    return a3;
                }
            case 1:
                if (this.pjX == null) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    AppMethodBeat.o(22625);
                    return false;
                }
                boolean kg = this.pjX.kg(true);
                AppMethodBeat.o(22625);
                return kg;
            default:
                Assert.assertTrue(false);
                AppMethodBeat.o(22625);
                return false;
        }
    }

    public final void e(long j2, long j3, int i2) {
        AppMethodBeat.i(22626);
        Log.i("MicroMsg.exdevice.BluetoothSDKManager", "***createSession*** deviceId = " + j2 + "aBluetoothVersion = " + i2);
        switch (i2) {
            case 0:
                if (this.pjW == null) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBLE == null");
                    AppMethodBeat.o(22626);
                    return;
                }
                com.tencent.mm.plugin.d.a.b.b bVar = this.pjW;
                Log.i("MicroMsg.exdevice.BluetoothLEManager", "------createSession------ macAddr = %d channelId = %d", Long.valueOf(j2), Long.valueOf(j3));
                Assert.assertTrue(bVar.mIsInit);
                if (!bVar.ckE()) {
                    Log.e("MicroMsg.exdevice.BluetoothLEManager", "BLE Unsupport");
                    AppMethodBeat.o(22626);
                    return;
                }
                Assert.assertTrue(bVar.mHandler.post(new b.RunnableC0936b(j2, j3)));
                AppMethodBeat.o(22626);
                return;
            case 1:
                if (this.pjX == null) {
                    Log.e("MicroMsg.exdevice.BluetoothSDKManager", "mMrgBC == null");
                    AppMethodBeat.o(22626);
                    return;
                }
                com.tencent.mm.plugin.d.a.c.a aVar = this.pjX;
                Log.i("MicroMsg.exdevice.BluetoothChatManager", "createSession");
                Assert.assertTrue(aVar.mIsInit);
                if (!aVar.ckN()) {
                    Log.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
                    AppMethodBeat.o(22626);
                    return;
                }
                Assert.assertTrue(aVar.mHandler.post(new a.b(j2, j3)));
                AppMethodBeat.o(22626);
                return;
            default:
                Assert.assertTrue(false);
                AppMethodBeat.o(22626);
                return;
        }
    }

    static /* synthetic */ boolean a(b bVar, int i2, int i3, Object obj) {
        AppMethodBeat.i(22627);
        boolean sendMessage = bVar.mHandler.sendMessage(bVar.mHandler.obtainMessage(i2, i3, 0, obj));
        AppMethodBeat.o(22627);
        return sendMessage;
    }
}
