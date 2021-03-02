package com.tencent.mm.plugin.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.decoder.EncoderWriter;
import com.tencent.thumbplayer.core.common.TPDecoderType;

public final class b {
    public static String azg(String str) {
        AppMethodBeat.i(111740);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3006243:
                if (str.equals("avc1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3117788:
                if (str.equals("encv")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3199032:
                if (str.equals("hev1")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3214780:
                if (str.equals("hvc1")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3356560:
                if (str.equals("mp4a")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3356581:
                if (str.equals("mp4v")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                AppMethodBeat.o(111740);
                return "video/avc";
            case 2:
            case 3:
            case 4:
                AppMethodBeat.o(111740);
                return TPDecoderType.TP_CODEC_MIMETYPE_HEVC;
            case 5:
                AppMethodBeat.o(111740);
                return EncoderWriter.OUTPUT_AUDIO_MIME_TYPE;
            default:
                Log.e("MicroMsg.AlbumAdapter.MIMEUtils", "unsupport type: %s", str);
                AppMethodBeat.o(111740);
                return "";
        }
    }
}
