package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@TargetApi(21)
public final class c {
    public static final c beN = new c(new int[]{2}, 2);
    private final int maxChannelCount;
    final int[] supportedEncodings;

    static {
        AppMethodBeat.i(91761);
        AppMethodBeat.o(91761);
    }

    public static c aj(Context context) {
        AppMethodBeat.i(91756);
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        if (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            c cVar = beN;
            AppMethodBeat.o(91756);
            return cVar;
        }
        c cVar2 = new c(registerReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), registerReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
        AppMethodBeat.o(91756);
        return cVar2;
    }

    private c(int[] iArr, int i2) {
        AppMethodBeat.i(91757);
        if (iArr != null) {
            this.supportedEncodings = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.supportedEncodings);
        } else {
            this.supportedEncodings = new int[0];
        }
        this.maxChannelCount = i2;
        AppMethodBeat.o(91757);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91758);
        if (this == obj) {
            AppMethodBeat.o(91758);
            return true;
        } else if (!(obj instanceof c)) {
            AppMethodBeat.o(91758);
            return false;
        } else {
            c cVar = (c) obj;
            if (!Arrays.equals(this.supportedEncodings, cVar.supportedEncodings) || this.maxChannelCount != cVar.maxChannelCount) {
                AppMethodBeat.o(91758);
                return false;
            }
            AppMethodBeat.o(91758);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(91759);
        int hashCode = this.maxChannelCount + (Arrays.hashCode(this.supportedEncodings) * 31);
        AppMethodBeat.o(91759);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(91760);
        String str = "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
        AppMethodBeat.o(91760);
        return str;
    }
}
