package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class e {
    public static int Tc(int i2) {
        AppMethodBeat.i(137405);
        Log.i("MicroMsg.PlayerErrorHandler", "getErrCodeType, errorCode: %d", Integer.valueOf(i2));
        switch (i2) {
            case 53:
            case 54:
                AppMethodBeat.o(137405);
                return ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL;
            case 55:
            case 63:
            case 64:
            case 101:
            case 701:
            case 703:
            case 705:
                AppMethodBeat.o(137405);
                return ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL;
            case 62:
            case 66:
            case 67:
            case 69:
            case 70:
            case 74:
            case 102:
            case 702:
            case 704:
            case 706:
            case 707:
                AppMethodBeat.o(137405);
                return 10001;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                AppMethodBeat.o(137405);
                return 10002;
            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
            case 600:
            case 601:
            case 602:
            case 603:
            case 604:
            case 605:
                AppMethodBeat.o(137405);
                return 10001;
            default:
                AppMethodBeat.o(137405);
                return -1;
        }
    }

    public static String yw(int i2) {
        AppMethodBeat.i(137406);
        StringBuilder sb = new StringBuilder();
        sb.append("errCode:" + i2 + ", err:");
        switch (i2) {
            case 53:
                sb.append("file not found");
                break;
            case 54:
                sb.append("file can not read");
                break;
            case 55:
                sb.append("unknow format");
                break;
            case 62:
                sb.append("load or init native decode so fail");
                break;
            case 63:
                sb.append("get audio info fail");
                break;
            case 64:
                sb.append("invalid audio info");
                break;
            case 66:
                sb.append("create AudioTrack fail");
                break;
            case 67:
                sb.append("decode audio fail");
                break;
            case 69:
                sb.append("so file not found");
                break;
            case 70:
                sb.append("create temp file fail");
                break;
            case 74:
                sb.append("invalid seek or seek fail");
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                sb.append("connect network fail");
                break;
            case 101:
                sb.append("recognition audio format error");
                break;
            case 102:
                sb.append("write AudioTrack data fail");
                break;
            case 500:
                sb.append("error URL format");
                break;
            case 501:
                sb.append("error player to prepare");
                break;
            case 502:
                sb.append("error player to start");
                break;
            case 503:
                sb.append("error player to pause");
                break;
            case 504:
                sb.append("error player to stop");
                break;
            case 600:
                sb.append("error create player fail, exceed max count audio players");
                break;
            case 601:
                sb.append("error, not found audioId");
                break;
            case 602:
                sb.append("error, not found param");
                break;
            case 603:
                sb.append("error, ready exist audioId");
                break;
            case 604:
                sb.append("error, invalid audioID");
                break;
            case 605:
                sb.append("error, invalid param");
                break;
            case 701:
                sb.append("error, invalid param");
                break;
            case 702:
                sb.append("error, mmplayer set source occur error");
                break;
            case 703:
                sb.append("error, mmplayer media format error");
                break;
            case 704:
                sb.append("error, mmplayer create MediaCode error");
                break;
            case 705:
                sb.append("error, mmplayer get audio info error");
                break;
            case 706:
                sb.append("error, mmplayer decode error");
                break;
            case 707:
                sb.append("error, mmplayer create audio track orror");
                break;
            default:
                sb.append("unknow exception");
                break;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(137406);
        return sb2;
    }
}
