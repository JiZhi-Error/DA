package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zzb implements FastParser.zza<Long> {
    zzb() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zza
    public final /* synthetic */ Long zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12119);
        Long valueOf = Long.valueOf(FastParser.zzb(fastParser, bufferedReader));
        AppMethodBeat.o(12119);
        return valueOf;
    }
}
