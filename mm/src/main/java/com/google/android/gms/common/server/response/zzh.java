package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.math.BigDecimal;

final class zzh implements FastParser.zza<BigDecimal> {
    zzh() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zza
    public final /* synthetic */ BigDecimal zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12125);
        BigDecimal zzg = FastParser.zzg(fastParser, bufferedReader);
        AppMethodBeat.o(12125);
        return zzg;
    }
}
