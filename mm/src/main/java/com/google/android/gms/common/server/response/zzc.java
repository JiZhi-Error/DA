package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;

final class zzc implements FastParser.zza<Float> {
    zzc() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.server.response.FastParser.zza
    public final /* synthetic */ Float zzh(FastParser fastParser, BufferedReader bufferedReader) {
        AppMethodBeat.i(12120);
        Float valueOf = Float.valueOf(FastParser.zzc(fastParser, bufferedReader));
        AppMethodBeat.o(12120);
        return valueOf;
    }
}
