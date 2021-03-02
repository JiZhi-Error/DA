package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

final class zzcu extends DataClient.GetFdForAssetResponse implements Releasable {
    private final DataApi.GetFdForAssetResult zzdj;

    zzcu(DataApi.GetFdForAssetResult getFdForAssetResult) {
        this.zzdj = getFdForAssetResult;
    }

    @Override // com.google.android.gms.wearable.DataClient.GetFdForAssetResponse
    public final ParcelFileDescriptor getFdForAsset() {
        AppMethodBeat.i(101153);
        ParcelFileDescriptor fd = this.zzdj.getFd();
        AppMethodBeat.o(101153);
        return fd;
    }

    @Override // com.google.android.gms.wearable.DataClient.GetFdForAssetResponse
    public final InputStream getInputStream() {
        AppMethodBeat.i(101154);
        InputStream inputStream = this.zzdj.getInputStream();
        AppMethodBeat.o(101154);
        return inputStream;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        AppMethodBeat.i(101155);
        this.zzdj.release();
        AppMethodBeat.o(101155);
    }
}
