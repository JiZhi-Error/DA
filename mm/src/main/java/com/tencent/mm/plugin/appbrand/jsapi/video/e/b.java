package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/GeneralErrorType;", "", "(Ljava/lang/String;I)V", "NETWORK", "EXTRACT", "EXTRACT_NOT_SUPPORT", "DECODE", "DECODE_NOT_SUPPORT", "RENDER", "ILLEGAL", "OTHER", "Companion", "luggage-commons-jsapi-video-ext_release"})
public enum b {
    NETWORK,
    EXTRACT,
    EXTRACT_NOT_SUPPORT,
    DECODE,
    DECODE_NOT_SUPPORT,
    RENDER,
    ILLEGAL,
    OTHER;
    
    public static final a mBp = new a((byte) 0);

    static {
        AppMethodBeat.i(235219);
        AppMethodBeat.o(235219);
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(235221);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(235221);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/GeneralErrorType$Companion;", "", "()V", "TAG", "", "fromErrorInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/GeneralErrorType;", "errorWhat", "", "errorExtra", "fromExoErrorInfo", "luggage-commons-jsapi-video-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final b el(int i2, int i3) {
        b bVar = null;
        AppMethodBeat.i(235222);
        if (-4000 >= i2) {
            switch (i2) {
                case -4999:
                    bVar = OTHER;
                    break;
                case -4006:
                case -4000:
                    bVar = NETWORK;
                    break;
                case TXLiteAVCode.ERR_REQUEST_ACC_BY_HOST_IP:
                    bVar = RENDER;
                    break;
                case TXLiteAVCode.ERR_MIX_PARAM_INVALID:
                    bVar = EXTRACT;
                    break;
                case TXLiteAVCode.ERR_USER_DEFINE_RECORD_ID_INVALID:
                    bVar = DECODE;
                    break;
                case TXLiteAVCode.ERR_CUSTOM_STREAM_INVALID:
                    bVar = ILLEGAL;
                    break;
                case TXLiteAVCode.ERR_REQUEST_QUERY_CONFIG_TIMEOUT:
                    bVar = EXTRACT_NOT_SUPPORT;
                    break;
            }
            if (bVar == null) {
                Log.e("MicroMsg.AppBrand.GeneralErrorType", "fromExoErrorInfo, errorType is null, errorWhat: " + i2 + ", errorExtra: " + i3);
            }
        }
        Log.i("MicroMsg.AppBrand.GeneralErrorType", "fromErrorInfo, errorWhat: " + i2 + ", errorExtra: " + i3 + ", errorType: " + bVar);
        AppMethodBeat.o(235222);
        return bVar;
    }
}
