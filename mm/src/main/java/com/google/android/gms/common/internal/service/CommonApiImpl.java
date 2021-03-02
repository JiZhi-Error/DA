package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CommonApiImpl implements CommonApi {

    static class zza extends BaseCommonServiceCallbacks {
        private final BaseImplementation.ResultHolder<Status> mResultHolder;

        public zza(BaseImplementation.ResultHolder<Status> resultHolder) {
            this.mResultHolder = resultHolder;
        }

        @Override // com.google.android.gms.common.internal.service.BaseCommonServiceCallbacks, com.google.android.gms.common.internal.service.ICommonCallbacks
        public final void onDefaultAccountCleared(int i2) {
            AppMethodBeat.i(11884);
            this.mResultHolder.setResult(new Status(i2));
            AppMethodBeat.o(11884);
        }
    }

    @Override // com.google.android.gms.common.internal.service.CommonApi
    public final PendingResult<Status> clearDefaultAccount(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(11885);
        BaseImplementation.ApiMethodImpl execute = googleApiClient.execute(new zzb(this, googleApiClient));
        AppMethodBeat.o(11885);
        return execute;
    }
}
