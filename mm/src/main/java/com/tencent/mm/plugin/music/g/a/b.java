package com.tencent.mm.plugin.music.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements IMediaHTTPService {
    private final Map<String, String> Ams = new ConcurrentHashMap();

    public b() {
        AppMethodBeat.i(198191);
        AppMethodBeat.o(198191);
    }

    public final void jb(String str, String str2) {
        AppMethodBeat.i(198192);
        Logger.d("MicroMsg.MMMediaHTTPService", "setReferrer, originUrl: " + str + ", referrer: " + str2);
        if (str2 == null) {
            str2 = "";
        }
        this.Ams.put(str, str2);
        AppMethodBeat.o(198192);
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService
    public final IMediaHTTPConnection makeHTTPConnection() {
        AppMethodBeat.i(137437);
        Logger.i("MicroMsg.MMMediaHTTPService", "makeHTTPConnection");
        a aVar = new a(Collections.unmodifiableMap(this.Ams));
        AppMethodBeat.o(137437);
        return aVar;
    }
}
