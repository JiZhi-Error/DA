package com.tencent.thumbplayer.core.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

@TargetApi(21)
public final class TPAudioPassThroughCapabilities {
    public static final TPAudioPassThroughCapabilities DEFAULT_AUDIO_CAPABILITIES = new TPAudioPassThroughCapabilities(new int[]{2}, 8);
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final TPAudioPassThroughCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES = new TPAudioPassThroughCapabilities(new int[]{2, 5, 6}, 8);
    private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
    private final int maxChannelCount;
    private final int[] supportedEncodings;

    static {
        AppMethodBeat.i(189676);
        AppMethodBeat.o(189676);
    }

    public static TPAudioPassThroughCapabilities getCapabilities(Context context) {
        AppMethodBeat.i(189669);
        TPAudioPassThroughCapabilities capabilities = getCapabilities(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
        AppMethodBeat.o(189669);
        return capabilities;
    }

    @SuppressLint({"InlinedApi"})
    static TPAudioPassThroughCapabilities getCapabilities(Context context, Intent intent) {
        AppMethodBeat.i(189670);
        if (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) {
            TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities = DEFAULT_AUDIO_CAPABILITIES;
            AppMethodBeat.o(189670);
            return tPAudioPassThroughCapabilities;
        }
        TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities2 = new TPAudioPassThroughCapabilities(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        AppMethodBeat.o(189670);
        return tPAudioPassThroughCapabilities2;
    }

    public TPAudioPassThroughCapabilities(int[] iArr, int i2) {
        AppMethodBeat.i(189671);
        if (iArr != null) {
            this.supportedEncodings = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.supportedEncodings);
        } else {
            this.supportedEncodings = new int[0];
        }
        this.maxChannelCount = i2;
        AppMethodBeat.o(189671);
    }

    public final boolean supportsEncoding(int i2) {
        AppMethodBeat.i(189672);
        if (Arrays.binarySearch(this.supportedEncodings, i2) >= 0) {
            AppMethodBeat.o(189672);
            return true;
        }
        AppMethodBeat.o(189672);
        return false;
    }

    public final int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(189673);
        if (this == obj) {
            AppMethodBeat.o(189673);
            return true;
        } else if (!(obj instanceof TPAudioPassThroughCapabilities)) {
            AppMethodBeat.o(189673);
            return false;
        } else {
            TPAudioPassThroughCapabilities tPAudioPassThroughCapabilities = (TPAudioPassThroughCapabilities) obj;
            if (!Arrays.equals(this.supportedEncodings, tPAudioPassThroughCapabilities.supportedEncodings) || this.maxChannelCount != tPAudioPassThroughCapabilities.maxChannelCount) {
                AppMethodBeat.o(189673);
                return false;
            }
            AppMethodBeat.o(189673);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(189674);
        int hashCode = this.maxChannelCount + (Arrays.hashCode(this.supportedEncodings) * 31);
        AppMethodBeat.o(189674);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(189675);
        String str = "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
        AppMethodBeat.o(189675);
        return str;
    }
}
