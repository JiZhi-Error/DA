package com.tencent.mm.plugin.audio.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0017J\b\u0010\u001b\u001a\u00020\u0012H\u0007J\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0017H\u0007J\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0017J\b\u0010!\u001a\u00020\nH\u0002J\u0016\u0010\"\u001a\u00020\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$H\u0007J\u0016\u0010%\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$H\u0007J\u0010\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010\u0006J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0017H\u0007J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/audio/util/BluetoothUtil;", "", "()V", "STREAM_BLUETOOTH_SCO", "", "TAG", "", "bluetoothSCOStreamType", "currentBluetoothAddress", "isRecordAllowToUseSco", "", "()Z", "setRecordAllowToUseSco", "(Z)V", "mIsPlugged", "getMIsPlugged", "setMIsPlugged", "checkBluetoothType", "", "context", "Landroid/content/Context;", "doStartBluetooth", "am", "Landroid/media/AudioManager;", "doStopBluetooth", "getBluetoothScoStreamType", "audioManager", "initResource", "isBluetoothCanRecord", "isBluetoothCanUse", "isBluetoothOn", "isBluetoothScoAvailable", "isBluetoothScoOn", "isConnectBluetoothHeadset", "releaseBluetoothResource", "mDeviceQueue", "Ljava/util/Stack;", "requestBluetoothResource", "setActiveDevice", "address", "startBluetooth", "stopBluetooth", "plugin-audio_release"})
public final class b {
    private static boolean oIk;
    private static int oIl = -1;
    private static String oIm;
    private static boolean oIn = true;
    public static final b oIo = new b();

    static {
        AppMethodBeat.i(224023);
        AppMethodBeat.o(224023);
    }

    private b() {
    }

    public static boolean ces() {
        return oIk;
    }

    public static void jw(boolean z) {
        oIk = z;
    }

    public static void jx(boolean z) {
        oIn = z;
    }

    public static void agu(String str) {
        oIm = str;
    }

    public static final void cet() {
        AppMethodBeat.i(224012);
        oIk = ceb();
        AppMethodBeat.o(224012);
    }

    public static boolean ceb() {
        AppMethodBeat.i(224013);
        a.C0831a aVar = a.oIh;
        boolean isBluetoothScoOn = a.C0831a.cea().audioManager.isBluetoothScoOn();
        a.C0831a aVar2 = a.oIh;
        boolean isBluetoothA2dpOn = a.C0831a.cea().audioManager.isBluetoothA2dpOn();
        Log.i("MicroMsg.BluetoothUtil", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isBluetoothCanUse: %s", Boolean.valueOf(isBluetoothScoOn), Boolean.valueOf(isBluetoothA2dpOn), Boolean.valueOf(cee()));
        if (isBluetoothScoOn || isBluetoothA2dpOn) {
            AppMethodBeat.o(224013);
            return true;
        }
        AppMethodBeat.o(224013);
        return false;
    }

    public static final boolean a(AudioManager audioManager) {
        AppMethodBeat.i(224014);
        p.h(audioManager, "audioManager");
        boolean isBluetoothScoAvailableOffCall = audioManager.isBluetoothScoAvailableOffCall();
        AppMethodBeat.o(224014);
        return isBluetoothScoAvailableOffCall;
    }

    public static final int b(AudioManager audioManager) {
        boolean z;
        AppMethodBeat.i(224015);
        p.h(audioManager, "audioManager");
        if (!cee()) {
            AppMethodBeat.o(224015);
            return -1;
        } else if (!oIn) {
            AppMethodBeat.o(224015);
            return -1;
        } else {
            a.C0831a aVar = a.oIh;
            Log.printInfoStack("MicroMsg.BluetoothUtil", "dkbt begin tryStartBluetooth %s", a.C0831a.cej());
            if (!audioManager.isBluetoothScoAvailableOffCall()) {
                Log.i("MicroMsg.BluetoothUtil", "start bluetooth failed by isBluetoothScoAvailableOffCall false");
                z = false;
            } else if (PhoneStatusWatcher.isCalling()) {
                z = false;
            } else {
                if (!audioManager.isBluetoothScoOn()) {
                    Log.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", Util.getStack());
                    audioManager.startBluetoothSco();
                }
                z = true;
            }
            a.C0831a aVar2 = a.oIh;
            Log.i("MicroMsg.BluetoothUtil", "dkbt end tryStartBluetooth %s ret:%s", a.C0831a.cej(), Boolean.valueOf(z));
            if (!z) {
                AppMethodBeat.o(224015);
                return -1;
            }
            StringBuilder sb = new StringBuilder("dkbt  tryStartBluetooth ");
            a.C0831a aVar3 = a.oIh;
            Log.d("MicroMsg.BluetoothUtil", sb.append(a.C0831a.cej()).append(" ret:true").toString());
            boolean ceb = ceb();
            if (ceb) {
                audioManager.setBluetoothScoOn(true);
                oIk = true;
            }
            Log.i("MicroMsg.BluetoothUtil", "isBluetoothOn: %b", Boolean.valueOf(ceb));
            if (ceb) {
                AppMethodBeat.o(224015);
                return 1;
            }
            AppMethodBeat.o(224015);
            return 0;
        }
    }

    public static final void c(AudioManager audioManager) {
        AppMethodBeat.i(224016);
        p.h(audioManager, "audioManager");
        a.C0831a aVar = a.oIh;
        Log.printInfoStack("MicroMsg.BluetoothUtil", "dkbt begin stopBluetooth %s", a.C0831a.cej());
        audioManager.setBluetoothScoOn(false);
        oIk = false;
        if (!PhoneStatusWatcher.isCalling()) {
            Log.i("MicroMsg.BluetoothUtil", "stop SrvDeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", Integer.valueOf(ae.gKE.aok()), Integer.valueOf(ae.gKE.aoj()));
            if (ae.gKE.aoj() == 1 || ae.gKE.aok() == -1) {
                Log.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", Util.getStack());
                audioManager.stopBluetoothSco();
            }
        }
        a.C0831a aVar2 = a.oIh;
        Log.i("MicroMsg.BluetoothUtil", "dkbt end stopBluetooth %s", a.C0831a.cej());
        AppMethodBeat.o(224016);
    }

    public static final boolean a(Stack<Integer> stack) {
        boolean z;
        Integer lastElement;
        AppMethodBeat.i(224017);
        p.h(stack, "mDeviceQueue");
        Log.i("MicroMsg.BluetoothUtil", "request the bluetooth resource");
        if (!stack.isEmpty() && (lastElement = stack.lastElement()) != null && lastElement.intValue() == 4) {
            z = true;
        } else if (cee()) {
            if (stack.contains(4)) {
                stack.removeElement(4);
            }
            stack.push(4);
            z = true;
        } else {
            z = false;
            Log.i("MicroMsg.BluetoothUtil", "current bluetooth can not use ");
        }
        AppMethodBeat.o(224017);
        return z;
    }

    public static final void b(Stack<Integer> stack) {
        AppMethodBeat.i(224018);
        p.h(stack, "mDeviceQueue");
        Log.i("MicroMsg.BluetoothUtil", " release the bluetooth resource");
        stack.removeElement(4);
        AppMethodBeat.o(224018);
    }

    public static int d(AudioManager audioManager) {
        int i2;
        AppMethodBeat.i(224019);
        p.h(audioManager, "audioManager");
        if (oIl == -1) {
            try {
                Class<?> cls = Class.forName("android.media.AudioManager");
                p.g(cls, "Class.forName(\"android.media.AudioManager\")");
                Field field = cls.getField("STREAM_BLUETOOTH_SCO");
                p.g(field, "calzz.getField(\"STREAM_BLUETOOTH_SCO\")");
                i2 = field.getInt(audioManager);
            } catch (Exception e2) {
                Log.e("MicroMsg.BluetoothUtil", "ClassNotFoundException  android.media.AudioManager,exception:" + e2.getMessage());
                i2 = 6;
            }
            oIl = i2;
        }
        int i3 = oIl;
        AppMethodBeat.o(224019);
        return i3;
    }

    public static boolean ceu() {
        return oIn;
    }

    public static boolean cee() {
        boolean z;
        AppMethodBeat.i(224020);
        boolean cev = cev();
        if (!cev) {
            Log.i("MicroMsg.BluetoothUtil", "dkbt isConnectHeadset() = ".concat(String.valueOf(cev)));
            AppMethodBeat.o(224020);
            return false;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            Log.d("MicroMsg.BluetoothUtil", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
            AppMethodBeat.o(224020);
            return false;
        } else if (!defaultAdapter.isEnabled()) {
            Log.i("MicroMsg.BluetoothUtil", "dkbt !adp.isEnabled()");
            AppMethodBeat.o(224020);
            return false;
        } else {
            Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
            if (bondedDevices == null || bondedDevices.size() == 0) {
                Log.e("MicroMsg.BluetoothUtil", "dkbt setDev == null || setDev.size() == 0");
                AppMethodBeat.o(224020);
                return false;
            }
            Iterator<BluetoothDevice> it = bondedDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                BluetoothDevice next = it.next();
                p.g(next, APMidasPayAPI.ENV_DEV);
                if (next.getBondState() == 12) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                Log.i("MicroMsg.BluetoothUtil", "dkbt hasBond == false");
                AppMethodBeat.o(224020);
                return false;
            }
            Log.i("MicroMsg.BluetoothUtil", "alvinluo isBluetoothCanUse: %b", Boolean.TRUE);
            AppMethodBeat.o(224020);
            return true;
        }
    }

    public static boolean e(AudioManager audioManager) {
        AppMethodBeat.i(224021);
        p.h(audioManager, "audioManager");
        boolean isBluetoothScoOn = audioManager.isBluetoothScoOn();
        AppMethodBeat.o(224021);
        return isBluetoothScoOn;
    }

    private static boolean cev() {
        AppMethodBeat.i(224022);
        try {
            int profileConnectionState = BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1);
            Log.i("MicroMsg.BluetoothUtil", "isConnectHeadset getProfileConnectionState: %s", Integer.valueOf(profileConnectionState));
            if (profileConnectionState == 2) {
                AppMethodBeat.o(224022);
                return true;
            }
            AppMethodBeat.o(224022);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.BluetoothUtil", "dkbt exception in isConnectDevice()");
            AppMethodBeat.o(224022);
            return false;
        }
    }
}
