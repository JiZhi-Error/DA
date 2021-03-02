package com.tencent.mm.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPAudioFrame;

public final class c {
    public static int aqj() {
        AppMethodBeat.i(149991);
        int i2 = Util.getInt(h.aqJ().getValue("InputLimitSNSObjectText"), 2000) * 2;
        AppMethodBeat.o(149991);
        return i2;
    }

    public static int aqk() {
        AppMethodBeat.i(149992);
        int i2 = Util.getInt(h.aqJ().getValue("SnsCommentMaxSize"), 1000) * 2;
        AppMethodBeat.o(149992);
        return i2;
    }

    public static int aql() {
        AppMethodBeat.i(149993);
        int i2 = Util.getInt(h.aqJ().getValue("InputLimitFavText"), 100000) * 2;
        AppMethodBeat.o(149993);
        return i2;
    }

    public static int aqm() {
        AppMethodBeat.i(223497);
        int i2 = Util.getInt(h.aqJ().getValue("InputLimitSendEmotionBufSize"), 10485760);
        AppMethodBeat.o(223497);
        return i2;
    }

    public static int aqn() {
        AppMethodBeat.i(149994);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_emoji_custom_max_size, 1);
        Log.i("MicroMsg.BoundaryConfig", "getCustomEmojiMaxSize: %s", Integer.valueOf(a2));
        int i2 = a2 * 1048576;
        AppMethodBeat.o(149994);
        return i2;
    }

    public static int aqo() {
        int i2 = 1024;
        AppMethodBeat.i(149995);
        try {
            i2 = Util.getInt(h.aqJ().getValue("InputLimitSendEmotionWidth"), 1024);
            AppMethodBeat.o(149995);
        } catch (Exception e2) {
            Log.printDebugStack("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", e2);
            AppMethodBeat.o(149995);
        }
        return i2;
    }

    public static int aqp() {
        int i2 = 5242880;
        AppMethodBeat.i(149996);
        try {
            i2 = Util.getInt(h.aqJ().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
            AppMethodBeat.o(149996);
        } catch (Exception e2) {
            Log.printDebugStack("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", e2);
            AppMethodBeat.o(149996);
        }
        return i2;
    }

    public static int aqq() {
        AppMethodBeat.i(149997);
        int i2 = Util.getInt(h.aqJ().getValue("InputLimitVideoSize"), 26214400);
        AppMethodBeat.o(149997);
        return i2;
    }

    public static int aqr() {
        AppMethodBeat.i(223498);
        String value = h.aqJ().getValue("InputLimitSendFileSize");
        Log.i("MicroMsg.BoundaryConfig", "MaxSendFileSize, svrLimit:%s, localLimit:%s", value, 104857600);
        int i2 = Util.getInt(value, 104857600);
        AppMethodBeat.o(223498);
        return i2;
    }

    public static int aqs() {
        AppMethodBeat.i(223499);
        try {
            String value = ((a) g.af(a.class)).aqJ().getValue("InputLimitFavFileSize");
            if (Util.isNullOrNil(value)) {
                Log.i("MicroMsg.BoundaryConfig", "getFileSizeLimit nullOrNil");
            } else {
                Log.i("MicroMsg.BoundaryConfig", "getFileSizeLimit ".concat(String.valueOf(value)));
            }
            int i2 = Util.getInt(value, 104857600);
            AppMethodBeat.o(223499);
            return i2;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.BoundaryConfig", th, "getMaxFavFileSize", new Object[0]);
            AppMethodBeat.o(223499);
            return 104857600;
        }
    }

    public static String aqt() {
        AppMethodBeat.i(149998);
        String value = h.aqJ().getValue("InputLimitForbiddenChar");
        AppMethodBeat.o(149998);
        return value;
    }

    public static long aqu() {
        AppMethodBeat.i(177286);
        String value = h.aqJ().getValue("InputLimitGroupFileTotalSize");
        Log.d("MicroMsg.BoundaryConfig", "MaxMultipleFileTotalSize, svrLimit:%s, localLimit:%s", value, Long.valueOf((long) TPAudioFrame.TP_CH_STEREO_RIGHT));
        long j2 = Util.getLong(value, TPAudioFrame.TP_CH_STEREO_RIGHT);
        AppMethodBeat.o(177286);
        return j2;
    }
}
