package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zzd implements FastParser.zza<Double> {
    zzd() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zza
    public final /* synthetic */ Double zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12121);
        Double valueOf = Double.valueOf(FastParser.zzd(fastParser, bufferedReader));
        AppMethodBeat.o(12121);
        return valueOf;
    }
}
