package com.tencent.mm.plugin.music.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.api.TPOptionalID;

public final class c {
    public static int ST(int i2) {
        AppMethodBeat.i(63138);
        Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKey, errCode:".concat(String.valueOf(i2)));
        switch (i2) {
            case 53:
                AppMethodBeat.o(63138);
                return 17;
            case 54:
                AppMethodBeat.o(63138);
                return 18;
            case 55:
                AppMethodBeat.o(63138);
                return 19;
            case 62:
                AppMethodBeat.o(63138);
                return 20;
            case 63:
                AppMethodBeat.o(63138);
                return 21;
            case 64:
                AppMethodBeat.o(63138);
                return 22;
            case 66:
                AppMethodBeat.o(63138);
                return 23;
            case 67:
                AppMethodBeat.o(63138);
                return 24;
            case 69:
                AppMethodBeat.o(63138);
                return 25;
            case 70:
                AppMethodBeat.o(63138);
                return 36;
            case 74:
                AppMethodBeat.o(63138);
                return 26;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                AppMethodBeat.o(63138);
                return 27;
            case 101:
                AppMethodBeat.o(63138);
                return 28;
            case 102:
                AppMethodBeat.o(63138);
                return 29;
            case 500:
                AppMethodBeat.o(63138);
                return 31;
            case 501:
                AppMethodBeat.o(63138);
                return 32;
            case 502:
                AppMethodBeat.o(63138);
                return 33;
            case 503:
                AppMethodBeat.o(63138);
                return 34;
            case 504:
                AppMethodBeat.o(63138);
                return 35;
            case 700:
                AppMethodBeat.o(63138);
                return 37;
            case 701:
                AppMethodBeat.o(63138);
                return 38;
            default:
                AppMethodBeat.o(63138);
                return 30;
        }
    }

    public static int SU(int i2) {
        AppMethodBeat.i(63139);
        Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKey, errCode:".concat(String.valueOf(i2)));
        switch (i2) {
            case 700:
                AppMethodBeat.o(63139);
                return 45;
            case 701:
                AppMethodBeat.o(63139);
                return 48;
            case 702:
                AppMethodBeat.o(63139);
                return 39;
            case 703:
                AppMethodBeat.o(63139);
                return 40;
            case 704:
                AppMethodBeat.o(63139);
                return 41;
            case 705:
                AppMethodBeat.o(63139);
                return 42;
            case 706:
                AppMethodBeat.o(63139);
                return 43;
            case 707:
                AppMethodBeat.o(63139);
                return 44;
            default:
                AppMethodBeat.o(63139);
                return 189;
        }
    }

    public static int SV(int i2) {
        AppMethodBeat.i(63140);
        Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerSumidKeyByMusicType, musicType:".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                AppMethodBeat.o(63140);
                return 105;
            case 1:
                AppMethodBeat.o(63140);
                return 106;
            case 2:
            case 3:
            default:
                AppMethodBeat.o(63140);
                return 113;
            case 4:
                AppMethodBeat.o(63140);
                return 107;
            case 5:
                AppMethodBeat.o(63140);
                return 108;
            case 6:
                AppMethodBeat.o(63140);
                return 109;
            case 7:
                AppMethodBeat.o(63140);
                return 110;
            case 8:
                AppMethodBeat.o(63140);
                return 111;
            case 9:
                AppMethodBeat.o(63140);
                return 112;
        }
    }

    public static int SW(int i2) {
        AppMethodBeat.i(63141);
        Log.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerSumidKeyByMusicType, musicType:".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                AppMethodBeat.o(63141);
                return 117;
            case 1:
                AppMethodBeat.o(63141);
                return 118;
            case 2:
            case 3:
            default:
                AppMethodBeat.o(63141);
                return TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
            case 4:
                AppMethodBeat.o(63141);
                return 119;
            case 5:
                AppMethodBeat.o(63141);
                return 120;
            case 6:
                AppMethodBeat.o(63141);
                return 121;
            case 7:
                AppMethodBeat.o(63141);
                return 122;
            case 8:
                AppMethodBeat.o(63141);
                return 123;
            case 9:
                AppMethodBeat.o(63141);
                return 124;
            case 10:
                AppMethodBeat.o(63141);
                return 125;
            case 11:
                AppMethodBeat.o(63141);
                return 126;
        }
    }

    public static int aHV(String str) {
        AppMethodBeat.i(63142);
        if ("audio/3gpp".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 1;
        } else if ("audio/amr-wb".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 2;
        } else if ("audio/mpeg".equalsIgnoreCase(str) || "audio/mp3".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 3;
        } else if (EncoderWriter.OUTPUT_AUDIO_MIME_TYPE.equalsIgnoreCase(str) || str.startsWith("audio/mp4")) {
            AppMethodBeat.o(63142);
            return 4;
        } else if ("audio/qcelp".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 5;
        } else if ("audio/vorbis".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 6;
        } else if ("audio/opus".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 7;
        } else if ("audio/g711-alaw".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 8;
        } else if ("audio/g711-mlaw".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 9;
        } else if ("audio/raw".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 10;
        } else if ("audio/flac".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 11;
        } else if ("audio/gsm".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 12;
        } else if ("audio/ac3".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 13;
        } else if ("audio/eac3".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 14;
        } else if ("audio/x-ms-wma".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 15;
        } else if ("audio/x-wav".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 16;
        } else if ("audio/x-ape".equalsIgnoreCase(str) || "application/x-ape".equalsIgnoreCase(str)) {
            AppMethodBeat.o(63142);
            return 17;
        } else {
            AppMethodBeat.o(63142);
            return 0;
        }
    }
}
