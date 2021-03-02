package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zze implements FastParser.zza<Boolean> {
    zze() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zza
    public final /* synthetic */ Boolean zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12122);
        Boolean valueOf = Boolean.valueOf(FastParser.zza(fastParser, bufferedReader, false));
        AppMethodBeat.o(12122);
        return valueOf;
    }
}
