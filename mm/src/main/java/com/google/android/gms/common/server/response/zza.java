package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zza implements FastParser.zza<Integer> {
    zza() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zza
    public final /* synthetic */ Integer zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12118);
        Integer valueOf = Integer.valueOf(FastParser.zza(fastParser, bufferedReader));
        AppMethodBeat.o(12118);
        return valueOf;
    }
}
