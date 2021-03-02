package com.tencent.mm.plugin.audio.broadcast.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.audio.d.b;
import com.tencent.mm.plugin.audio.d.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\b\u0010\u001d\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/audio/broadcast/bluetooth/BluetoothMgr;", "", "()V", "TAG", "", "mConnectRetryCount", "", "mCurrentBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "mCurrentMacAddress", "mIshappendActiveChanged", "", "mLastConnectTime", "", "value", "mPreBTAddress", "setMPreBTAddress", "(Ljava/lang/String;)V", "checkBluetoothDevice", "", "intent", "Landroid/content/Intent;", "onAclStateDisconnected", "onActiveDeviceChanged", "onAdapterStateChanged", "onHeadsetStateChanged", "onScoStateUpdated", "refreshForbiddenCauseRequest", "type", "tickLastForbiddenTimes", "plugin-audio_release"})
public final class a {
    private static final String TAG = TAG;
    private static int mConnectRetryCount;
    private static String oHE;
    private static boolean oHF;
    private static String oHG;
    private static BluetoothDevice oHH;
    private static long oHI;
    public static final a oHJ = new a();

    static {
        AppMethodBeat.i(223947);
        AppMethodBeat.o(223947);
    }

    private a() {
    }

    private static void ago(String str) {
        AppMethodBeat.i(223938);
        b bVar = b.oIo;
        b.agu(oHE);
        oHE = str;
        AppMethodBeat.o(223938);
    }

    public static final void cdS() {
        AppMethodBeat.i(223939);
        if (Util.ticksToNow(oHI) > ((long) (f.cey() * 1000)) && f.cex() == 1) {
            Log.i(TAG, "refresh forbidden time");
            b bVar = b.oIo;
            b.jx(true);
        }
        mConnectRetryCount = 0;
        AppMethodBeat.o(223939);
    }

    public static final void agp(String str) {
        AppMethodBeat.i(223940);
        p.h(str, "type");
        Log.i(TAG, "refreshForbiddenCauseVoipRequest，".concat(String.valueOf(str)));
        b bVar = b.oIo;
        b.jx(true);
        mConnectRetryCount = 0;
        AppMethodBeat.o(223940);
    }

    public static final void V(Intent intent) {
        AppMethodBeat.i(223941);
        p.h(intent, "intent");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            Log.i(TAG, "device is unavailable");
            AppMethodBeat.o(223941);
            return;
        }
        if (f.cew()) {
            b bVar = b.oIo;
            BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
            p.g(bluetoothClass, "device.bluetoothClass");
            b.jx(bluetoothClass.getDeviceClass() == 1032);
        }
        if (!p.j(oHG, bluetoothDevice.getAddress())) {
            BluetoothClass bluetoothClass2 = bluetoothDevice.getBluetoothClass();
            if (bluetoothClass2 != null) {
                com.tencent.mm.plugin.audio.d.a aVar = com.tencent.mm.plugin.audio.d.a.oIj;
                Integer valueOf = Integer.valueOf(bluetoothClass2.getMajorDeviceClass());
                Integer valueOf2 = Integer.valueOf(bluetoothClass2.getDeviceClass());
                a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
                com.tencent.mm.plugin.audio.d.a.a(valueOf, valueOf2, a.C0831a.cek(), 0, bluetoothDevice.getName(), bluetoothDevice.getAddress());
            }
            oHG = bluetoothDevice.getAddress();
            mConnectRetryCount = 0;
            b bVar2 = b.oIo;
            b.jx(true);
        }
        AppMethodBeat.o(223941);
    }

    public static final void W(Intent intent) {
        int i2;
        BluetoothClass bluetoothClass;
        String str;
        String str2 = null;
        AppMethodBeat.i(223942);
        p.h(intent, "intent");
        if (!g.aAc()) {
            AppMethodBeat.o(223942);
            return;
        }
        try {
            i2 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        } catch (Exception e2) {
            Log.e(TAG, "%s", Util.stackTraceToString(e2));
            i2 = 0;
        }
        Log.d(TAG, "dkbt  action :" + intent.getAction() + " state:" + i2);
        if (oHE == null || i2 != 0 || !oHF) {
            switch (i2) {
                case 1:
                    if (f.cex() != 0) {
                        if (mConnectRetryCount < f.cez() || Util.ticksToNow(oHI) >= 1000) {
                            Log.i(TAG, "not aim at the sco connect limited " + mConnectRetryCount);
                            if (mConnectRetryCount == 0) {
                                oHI = Util.currentTicks();
                            }
                            mConnectRetryCount++;
                            Log.d(TAG, "sco connected!");
                            if (oHF) {
                                oHF = false;
                            }
                        } else {
                            Log.i(TAG, "aim at the sco connect limited");
                            mConnectRetryCount = 0;
                            b bVar = b.oIo;
                            b.jx(false);
                            BluetoothDevice bluetoothDevice = oHH;
                            if (!(bluetoothDevice == null || (bluetoothClass = bluetoothDevice.getBluetoothClass()) == null)) {
                                com.tencent.mm.plugin.audio.d.a aVar = com.tencent.mm.plugin.audio.d.a.oIj;
                                Integer valueOf = Integer.valueOf(bluetoothClass.getMajorDeviceClass());
                                Integer valueOf2 = Integer.valueOf(bluetoothClass.getDeviceClass());
                                a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
                                String cek = a.C0831a.cek();
                                BluetoothDevice bluetoothDevice2 = oHH;
                                if (bluetoothDevice2 != null) {
                                    str = bluetoothDevice2.getName();
                                } else {
                                    str = null;
                                }
                                BluetoothDevice bluetoothDevice3 = oHH;
                                if (bluetoothDevice3 != null) {
                                    str2 = bluetoothDevice3.getAddress();
                                }
                                com.tencent.mm.plugin.audio.d.a.a(valueOf, valueOf2, cek, 1, str, str2);
                                com.tencent.mm.plugin.audio.d.a aVar3 = com.tencent.mm.plugin.audio.d.a.oIj;
                                a.C0831a aVar4 = com.tencent.mm.plugin.audio.c.a.oIh;
                                String cek2 = a.C0831a.cek();
                                p.h(cek2, "caller");
                                switch (cek2.hashCode()) {
                                    case -1182426107:
                                        if (cek2.equals("ipcall")) {
                                            com.tencent.mm.plugin.audio.d.a.cep();
                                            break;
                                        }
                                        break;
                                    case -934908847:
                                        if (cek2.equals("record")) {
                                            com.tencent.mm.plugin.audio.d.a.cem();
                                            break;
                                        }
                                        break;
                                    case -810977776:
                                        if (cek2.equals("voipcs")) {
                                            com.tencent.mm.plugin.audio.d.a.cer();
                                            break;
                                        }
                                        break;
                                    case 3625376:
                                        if (cek2.equals("voip")) {
                                            com.tencent.mm.plugin.audio.d.a.cel();
                                            break;
                                        }
                                        break;
                                    case 104263205:
                                        if (cek2.equals("music")) {
                                            com.tencent.mm.plugin.audio.d.a.ceq();
                                            break;
                                        }
                                        break;
                                    case 1268443040:
                                        if (cek2.equals("multitalke")) {
                                            com.tencent.mm.plugin.audio.d.a.cen();
                                            break;
                                        }
                                        break;
                                    case 1567430952:
                                        if (cek2.equals("openvoice")) {
                                            com.tencent.mm.plugin.audio.d.a.ceo();
                                            break;
                                        }
                                        break;
                                }
                            }
                            a.C0831a aVar5 = com.tencent.mm.plugin.audio.c.a.oIh;
                            a.C0831a.cea().iY(3);
                            AppMethodBeat.o(223942);
                            return;
                        }
                    }
                    a.C0831a aVar6 = com.tencent.mm.plugin.audio.c.a.oIh;
                    a.C0831a.cea().iY(2);
                    AppMethodBeat.o(223942);
                    return;
                case 0:
                    Log.d(TAG, "sco disconnected!getStopBluetoothInBR = %s", Integer.valueOf(ae.gKE.aoi()));
                    a.C0831a aVar7 = com.tencent.mm.plugin.audio.c.a.oIh;
                    a.C0831a.cea().iY(3);
                    break;
            }
            AppMethodBeat.o(223942);
            return;
        }
        Log.i(TAG, "current run a active device changed");
        AppMethodBeat.o(223942);
    }

    public static final void X(Intent intent) {
        AppMethodBeat.i(223943);
        p.h(intent, "intent");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            Log.i(TAG, "device is unavailable");
            AppMethodBeat.o(223943);
            return;
        }
        if (!p.j(oHE, bluetoothDevice.getAddress())) {
            ago(bluetoothDevice.getAddress());
            oHF = true;
            a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
            a.C0831a.cea().iY(0);
            Log.i(TAG, "android pie switch bt device,%s", oHE);
        }
        AppMethodBeat.o(223943);
    }

    public static final void Y(Intent intent) {
        AppMethodBeat.i(223944);
        p.h(intent, "intent");
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
        Log.i(TAG, "onReceive bluetooth state changed: %s, prevState: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
        if (intExtra == 10) {
            a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
            a.C0831a.cea().iY(1);
        }
        Log.d(TAG, "BluetoothStateReceiver.onReceive()");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            if (defaultAdapter.getState() == 12) {
                h.INSTANCE.a(11921, 1);
            } else if (defaultAdapter.getState() == 10) {
                h.INSTANCE.a(11921, 0);
            }
            Log.e(TAG, "[oneliang]bluetoothAdapter state:" + defaultAdapter.getState());
        }
        AppMethodBeat.o(223944);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00aa, code lost:
        if ((!kotlin.g.b.p.j(r1, r0.getAddress())) != false) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Z(android.content.Intent r11) {
        /*
        // Method dump skipped, instructions count: 227
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.audio.broadcast.bluetooth.a.Z(android.content.Intent):void");
    }

    public static final void aa(Intent intent) {
        AppMethodBeat.i(223946);
        p.h(intent, "intent");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice == null) {
            Log.i(TAG, "pre address is null");
            AppMethodBeat.o(223946);
            return;
        }
        if (p.j(bluetoothDevice.getAddress(), oHE)) {
            Log.i(TAG, "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
            Log.i(TAG, "pre connect device is " + bluetoothDevice.getAddress());
            b bVar = b.oIo;
            b.jx(true);
            a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
            a.C0831a.cea().iY(7);
        }
        AppMethodBeat.o(223946);
    }
}
