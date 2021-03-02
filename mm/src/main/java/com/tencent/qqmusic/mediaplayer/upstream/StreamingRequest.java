package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class StreamingRequest {
    public final Map<String, String> headers;
    public final Uri uri;

    public StreamingRequest(Uri uri2, Map<String, String> map) {
        this.uri = uri2;
        this.headers = map;
    }

    public String toString() {
        AppMethodBeat.i(87751);
        String str = "StreamingRequest{uri='" + this.uri + '\'' + ", headers=" + this.headers + '}';
        AppMethodBeat.o(87751);
        return str;
    }
}
