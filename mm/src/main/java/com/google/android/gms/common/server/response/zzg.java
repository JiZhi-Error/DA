package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.math.BigInteger;

final class zzg implements FastParser.zza<BigInteger> {
    zzg() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zza
    public final /* synthetic */ BigInteger zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12124);
        BigInteger zzf = FastParser.zzf(fastParser, bufferedReader);
        AppMethodBeat.o(12124);
        return zzf;
    }
}
