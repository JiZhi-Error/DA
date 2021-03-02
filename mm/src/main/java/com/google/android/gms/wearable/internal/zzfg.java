package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.wearable.NodeApi;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfg implements NodeApi {
    @Override // com.google.android.gms.wearable.NodeApi
    public final PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(101298);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzfi(this, googleApiClient));
        AppMethodBeat.o(101298);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public final PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(101297);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzfh(this, googleApiClient));
        AppMethodBeat.o(101297);
        return enqueue;
    }
}
