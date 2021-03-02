package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final /* synthetic */ class zzfn implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzfn();

    static {
        AppMethodBeat.i(101310);
        AppMethodBeat.o(101310);
    }

    private zzfn() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(101309);
        List<Node> nodes = ((NodeApi.GetConnectedNodesResult) result).getNodes();
        AppMethodBeat.o(101309);
        return nodes;
    }
}
