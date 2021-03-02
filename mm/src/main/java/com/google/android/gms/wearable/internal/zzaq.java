package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.Channel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

final /* synthetic */ class zzaq implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzaq();

    static {
        AppMethodBeat.i(101010);
        AppMethodBeat.o(101010);
    }

    private zzaq() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101009);
        InputStream inputStream = ((Channel.GetInputStreamResult) result).getInputStream();
        AppMethodBeat.o(101009);
        return inputStream;
    }
}
