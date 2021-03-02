package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzfl extends NodeClient {
    private final NodeApi zzem = new zzfg();

    public zzfl(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        AppMethodBeat.i(101304);
        AppMethodBeat.o(101304);
    }

    public zzfl(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        AppMethodBeat.i(101303);
        AppMethodBeat.o(101303);
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<List<Node>> getConnectedNodes() {
        AppMethodBeat.i(101306);
        Task<List<Node>> task = PendingResultUtil.toTask(this.zzem.getConnectedNodes(asGoogleApiClient()), zzfn.zzbx);
        AppMethodBeat.o(101306);
        return task;
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<Node> getLocalNode() {
        AppMethodBeat.i(101305);
        Task<Node> task = PendingResultUtil.toTask(this.zzem.getLocalNode(asGoogleApiClient()), zzfm.zzbx);
        AppMethodBeat.o(101305);
        return task;
    }
}
