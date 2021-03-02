package com.tencent.mm.plugin.audio.d;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0007J\u0016\u0010\u0015\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/audio/util/HeadSetPlugUtil;", "", "()V", "TAG", "", "mIsPlugged", "", "getMIsPlugged", "()Z", "setMIsPlugged", "(Z)V", "initResource", "", "isHeadsetPlugged", "audioManager", "Landroid/media/AudioManager;", "isWireHeadsetPluggedNew", "releaseHeadSetResource", "mDeviceQueue", "Ljava/util/Stack;", "", "requestHeadSetResource", "plugin-audio_release"})
public final class d {
    private static boolean oIk;
    public static final d oIq = new d();

    static {
        AppMethodBeat.i(224030);
        AppMethodBeat.o(224030);
    }

    private d() {
    }

    public static boolean ces() {
        return oIk;
    }

    public static void jw(boolean z) {
        oIk = z;
    }

    public static final void cet() {
        AppMethodBeat.i(224026);
        a.C0831a aVar = a.oIh;
        oIk = a.C0831a.cea().cdW();
        AppMethodBeat.o(224026);
    }

    public static final boolean d(Stack<Integer> stack) {
        Integer lastElement;
        AppMethodBeat.i(224027);
        p.h(stack, "mDeviceQueue");
        Log.i("MicroMsg.HeadSetPlugUtil", " request the headset resource");
        if (stack.isEmpty() || (lastElement = stack.lastElement()) == null || lastElement.intValue() != 3) {
            if (stack.contains(3)) {
                stack.removeElement(3);
            }
            stack.push(3);
            AppMethodBeat.o(224027);
            return true;
        }
        AppMethodBeat.o(224027);
        return false;
    }

    public static final void e(Stack<Integer> stack) {
        AppMethodBeat.i(224028);
        p.h(stack, "mDeviceQueue");
        Log.i("MicroMsg.HeadSetPlugUtil", " release the headset resource");
        stack.removeElement(3);
        AppMethodBeat.o(224028);
    }

    public static boolean f(AudioManager audioManager) {
        boolean z = true;
        AppMethodBeat.i(224029);
        p.h(audioManager, "audioManager");
        boolean isWiredHeadsetOn = audioManager.isWiredHeadsetOn();
        if (isWiredHeadsetOn || !com.tencent.mm.compatible.util.d.oD(23)) {
            z = isWiredHeadsetOn;
        } else {
            if (com.tencent.mm.compatible.util.d.oD(23)) {
                AudioDeviceInfo[] devices = audioManager.getDevices(3);
                int length = devices.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    AudioDeviceInfo audioDeviceInfo = devices[i2];
                    p.g(audioDeviceInfo, "deviceInfo");
                    Log.i("MicroMsg.HeadSetPlugUtil", "isWireHeadsetPluggedNew, deviceInfo type: %s", Integer.valueOf(audioDeviceInfo.getType()));
                    if (audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 11) {
                        break;
                    }
                    i2++;
                }
            }
            z = false;
        }
        AppMethodBeat.o(224029);
        return z;
    }
}
