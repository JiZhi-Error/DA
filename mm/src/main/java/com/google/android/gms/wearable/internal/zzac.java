package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final /* synthetic */ class zzac implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzac();

    static {
        AppMethodBeat.i(100966);
        AppMethodBeat.o(100966);
    }

    private zzac() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(100965);
        Map<String, CapabilityInfo> allCapabilities = ((CapabilityApi.GetAllCapabilitiesResult) result).getAllCapabilities();
        AppMethodBeat.o(100965);
        return allCapabilities;
    }
}
