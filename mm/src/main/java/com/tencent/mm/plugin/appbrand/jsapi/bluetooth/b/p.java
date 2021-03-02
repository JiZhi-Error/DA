package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerStatus;", "", "(Ljava/lang/String;I)V", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "CREATED", "CONNECTED", "DESTROYED", "TROUBLESOME", "luggage-commons-jsapi-connectivity-ext_release"})
public enum p {
    INIT,
    CREATED,
    CONNECTED,
    DESTROYED,
    TROUBLESOME;

    static {
        AppMethodBeat.i(144788);
        AppMethodBeat.o(144788);
    }

    public static p valueOf(String str) {
        AppMethodBeat.i(144790);
        p pVar = (p) Enum.valueOf(p.class, str);
        AppMethodBeat.o(144790);
        return pVar;
    }
}
