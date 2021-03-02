package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zzf implements FastParser.zza<String> {
    zzf() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zza
    public final /* synthetic */ String zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12123);
        String zze = FastParser.zze(fastParser, bufferedReader);
        AppMethodBeat.o(12123);
        return zze;
    }
}
