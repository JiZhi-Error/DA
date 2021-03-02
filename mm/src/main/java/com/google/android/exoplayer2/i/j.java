package com.google.android.exoplayer2.i;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.core.common.TPDecoderType;

public final class j {
    public static boolean bx(String str) {
        AppMethodBeat.i(93140);
        boolean equals = SlookAirButtonRecentMediaAdapter.AUDIO_TYPE.equals(bC(str));
        AppMethodBeat.o(93140);
        return equals;
    }

    public static boolean by(String str) {
        AppMethodBeat.i(93141);
        boolean equals = "video".equals(bC(str));
        AppMethodBeat.o(93141);
        return equals;
    }

    public static boolean bz(String str) {
        AppMethodBeat.i(93142);
        boolean equals = "text".equals(bC(str));
        AppMethodBeat.o(93142);
        return equals;
    }

    public static String bA(String str) {
        AppMethodBeat.i(93145);
        if (str == null) {
            AppMethodBeat.o(93145);
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            AppMethodBeat.o(93145);
            return "video/avc";
        } else if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            AppMethodBeat.o(93145);
            return TPDecoderType.TP_CODEC_MIMETYPE_HEVC;
        } else if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
            AppMethodBeat.o(93145);
            return TPDecoderType.TP_CODEC_MIMETYPE_VP9;
        } else if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
            AppMethodBeat.o(93145);
            return "video/x-vnd.on2.vp8";
        } else if (trim.startsWith("mp4a")) {
            AppMethodBeat.o(93145);
            return EncoderWriter.OUTPUT_AUDIO_MIME_TYPE;
        } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            AppMethodBeat.o(93145);
            return "audio/ac3";
        } else if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            AppMethodBeat.o(93145);
            return "audio/eac3";
        } else if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            AppMethodBeat.o(93145);
            return "audio/vnd.dts";
        } else if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            AppMethodBeat.o(93145);
            return "audio/vnd.dts.hd";
        } else if (trim.startsWith("opus")) {
            AppMethodBeat.o(93145);
            return "audio/opus";
        } else if (trim.startsWith("vorbis")) {
            AppMethodBeat.o(93145);
            return "audio/vorbis";
        } else {
            AppMethodBeat.o(93145);
            return null;
        }
    }

    public static int bB(String str) {
        AppMethodBeat.i(93146);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(93146);
            return -1;
        } else if (bx(str)) {
            AppMethodBeat.o(93146);
            return 1;
        } else if (by(str)) {
            AppMethodBeat.o(93146);
            return 2;
        } else if (bz(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            AppMethodBeat.o(93146);
            return 3;
        } else if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-camera-motion".equals(str)) {
            AppMethodBeat.o(93146);
            return 4;
        } else {
            AppMethodBeat.o(93146);
            return -1;
        }
    }

    private static String bC(String str) {
        AppMethodBeat.i(93147);
        if (str == null) {
            AppMethodBeat.o(93147);
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid mime type: ".concat(String.valueOf(str)));
            AppMethodBeat.o(93147);
            throw illegalArgumentException;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(93147);
        return substring;
    }
}
