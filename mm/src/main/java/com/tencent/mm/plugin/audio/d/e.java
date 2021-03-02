package com.tencent.mm.plugin.audio.d;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Stack;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/audio/util/SpeakerUtil;", "", "()V", "TAG", "", "isSpeakerPhoneOn", "", "audioManager", "Landroid/media/AudioManager;", "releaseSpeakerResource", "", "mDeviceQueue", "Ljava/util/Stack;", "", "requestSpeakerResource", "plugin-audio_release"})
public final class e {
    public static final e oIr = new e();

    static {
        AppMethodBeat.i(224034);
        AppMethodBeat.o(224034);
    }

    private e() {
    }

    public static final boolean f(Stack<Integer> stack) {
        Integer lastElement;
        Integer lastElement2;
        AppMethodBeat.i(224031);
        p.h(stack, "mDeviceQueue");
        Log.i("MicroMsg.SpeakerUtil", " request the speaker resource");
        if (!(stack.size() == 1 && (lastElement2 = stack.lastElement()) != null && lastElement2.intValue() == 1) && !stack.isEmpty() && (lastElement = stack.lastElement()) != null && lastElement.intValue() == 1) {
            AppMethodBeat.o(224031);
            return false;
        }
        if (stack.contains(1)) {
            stack.removeElement(1);
        }
        stack.push(1);
        AppMethodBeat.o(224031);
        return true;
    }

    public static final void g(Stack<Integer> stack) {
        AppMethodBeat.i(224032);
        p.h(stack, "mDeviceQueue");
        Log.i("MicroMsg.SpeakerUtil", "release the speaker resource");
        stack.removeElement(1);
        AppMethodBeat.o(224032);
    }

    public static boolean g(AudioManager audioManager) {
        AppMethodBeat.i(224033);
        p.h(audioManager, "audioManager");
        boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        AppMethodBeat.o(224033);
        return isSpeakerphoneOn;
    }
}
