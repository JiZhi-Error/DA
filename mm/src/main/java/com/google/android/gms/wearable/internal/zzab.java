package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class zzab implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzbx = new zzab();

    static {
        AppMethodBeat.i(100964);
        AppMethodBeat.o(100964);
    }

    private zzab() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        AppMethodBeat.i(100963);
        CapabilityInfo capability = ((CapabilityApi.GetCapabilityResult) result).getCapability();
        AppMethodBeat.o(100963);
        return capability;
    }
}
