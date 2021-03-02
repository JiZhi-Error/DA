package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

final /* synthetic */ class zzar implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzar();

    static {
        AppMethodBeat.i(101012);
        AppMethodBeat.o(101012);
    }

    private zzar() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101011);
        OutputStream outputStream = ((Channel.GetOutputStreamResult) result).getOutputStream();
        AppMethodBeat.o(101011);
        return outputStream;
    }
}
