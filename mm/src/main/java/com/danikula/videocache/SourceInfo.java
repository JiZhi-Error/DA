package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SourceInfo {
    public final long length;
    public final String mime;
    public final String url;

    public SourceInfo(String str, long j2, String str2) {
        this.url = str;
        this.length = j2;
        this.mime = str2;
    }

    public String toString() {
        AppMethodBeat.i(183617);
        String str = "SourceInfo{url='" + this.url + '\'' + ", length=" + this.length + ", mime='" + this.mime + '\'' + '}';
        AppMethodBeat.o(183617);
        return str;
    }
}
