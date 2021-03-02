package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzfm implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzfm();

    static {
        AppMethodBeat.i(101308);
        AppMethodBeat.o(101308);
    }

    private zzfm() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101307);
        Node node = ((NodeApi.GetLocalNodeResult) result).getNode();
        AppMethodBeat.o(101307);
        return node;
    }
}
