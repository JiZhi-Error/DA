package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class DefaultMediaHTTPService implements IMediaHTTPService {
    private static final String TAG = "DefaultMediaHTTPService";

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService
    public IMediaHTTPConnection makeHTTPConnection() {
        AppMethodBeat.i(76587);
        Logger.d(TAG, "makeHTTPConnection");
        DefaultMediaHTTPConnection defaultMediaHTTPConnection = new DefaultMediaHTTPConnection();
        AppMethodBeat.o(76587);
        return defaultMediaHTTPConnection;
    }
}
