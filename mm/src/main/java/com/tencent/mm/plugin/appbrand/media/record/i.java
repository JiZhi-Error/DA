package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class i {
    public static String yw(int i2) {
        AppMethodBeat.i(146329);
        StringBuilder sb = new StringBuilder();
        sb.append("errType:" + i2 + ", err:");
        switch (i2) {
            case 1:
                sb.append("error PCM record callback");
                break;
            case 2:
                sb.append("init encoder fail, occur exception");
                break;
            case 3:
                sb.append("encoder un initial occur exception");
                break;
            case 4:
                sb.append("start record occur exception");
                break;
            case 5:
                sb.append("resume record occur exception");
                break;
            case 6:
                sb.append("fail to start record");
                break;
            case 7:
                sb.append("fail to resume record");
                break;
            case 8:
                sb.append("fail to pause record");
                break;
            case 9:
                sb.append("fail to stop record");
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            default:
                sb.append("unknow error");
                break;
            case 15:
                sb.append("check param invalid");
                break;
            case 16:
                sb.append("not support format type");
                break;
            case 17:
                sb.append("fail to init mp3 encoder");
                break;
            case 18:
                sb.append("mp3 file not found exception");
                break;
            case 19:
                sb.append("mp3 encode exception");
                break;
            case 20:
                sb.append("mp3 write buffer exception");
                break;
            case 21:
                sb.append("fail to init aac encoder");
                break;
            case 22:
                sb.append("fail to create mp4 file");
                break;
            case 23:
                sb.append("aac encode exception");
                break;
            case 24:
                sb.append("create cache file fail");
                break;
            case 25:
                sb.append("init encoder fail");
                break;
            case 26:
                sb.append("not support sample rate");
                break;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(146329);
        return sb2;
    }

    public static int yx(int i2) {
        AppMethodBeat.i(146330);
        Log.i("MicroMsg.Record.RecordErrorHandler", "getErrIdKey errType:%d", Integer.valueOf(i2));
        switch (i2) {
            case 1:
                AppMethodBeat.o(146330);
                return 3;
            case 2:
                AppMethodBeat.o(146330);
                return 4;
            case 3:
                AppMethodBeat.o(146330);
                return 5;
            case 4:
                AppMethodBeat.o(146330);
                return 6;
            case 5:
                AppMethodBeat.o(146330);
                return 7;
            case 6:
                AppMethodBeat.o(146330);
                return 8;
            case 7:
                AppMethodBeat.o(146330);
                return 9;
            case 8:
                AppMethodBeat.o(146330);
                return 10;
            case 9:
                AppMethodBeat.o(146330);
                return 11;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            default:
                AppMethodBeat.o(146330);
                return 0;
            case 15:
                AppMethodBeat.o(146330);
                return 15;
            case 16:
                AppMethodBeat.o(146330);
                return 16;
            case 17:
                AppMethodBeat.o(146330);
                return 17;
            case 18:
                AppMethodBeat.o(146330);
                return 18;
            case 19:
                AppMethodBeat.o(146330);
                return 19;
            case 20:
                AppMethodBeat.o(146330);
                return 20;
            case 21:
                AppMethodBeat.o(146330);
                return 21;
            case 22:
                AppMethodBeat.o(146330);
                return 22;
            case 23:
                AppMethodBeat.o(146330);
                return 23;
            case 24:
                AppMethodBeat.o(146330);
                return 24;
            case 25:
                AppMethodBeat.o(146330);
                return 25;
            case 26:
                AppMethodBeat.o(146330);
                return 26;
        }
    }
}
