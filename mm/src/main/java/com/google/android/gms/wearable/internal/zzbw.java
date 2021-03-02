package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbw implements DataApi {
    private static PendingResult<Status> zza(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101102);
        PendingResult<Status> zza = zzb.zza(googleApiClient, new zzce(intentFilterArr), dataListener);
        AppMethodBeat.o(101102);
        return zza;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener) {
        AppMethodBeat.i(101100);
        PendingResult<Status> zza = zza(googleApiClient, dataListener, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.DATA_CHANGED")});
        AppMethodBeat.o(101100);
        return zza;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, Uri uri, int i2) {
        AppMethodBeat.i(101101);
        Asserts.checkNotNull(uri, "uri must not be null");
        Preconditions.checkArgument(i2 == 0 || i2 == 1, "invalid filter type");
        PendingResult<Status> zza = zza(googleApiClient, dataListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.DATA_CHANGED", uri, i2)});
        AppMethodBeat.o(101101);
        return zza;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri) {
        AppMethodBeat.i(101096);
        PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems = deleteDataItems(googleApiClient, uri, 0);
        AppMethodBeat.o(101096);
        return deleteDataItems;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient googleApiClient, Uri uri, int i2) {
        boolean z = true;
        AppMethodBeat.i(101097);
        Asserts.checkNotNull(uri, "uri must not be null");
        if (!(i2 == 0 || i2 == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid filter type");
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzcb(this, googleApiClient, uri, i2));
        AppMethodBeat.o(101097);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient googleApiClient, Uri uri) {
        AppMethodBeat.i(101092);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzby(this, googleApiClient, uri));
        AppMethodBeat.o(101092);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient) {
        AppMethodBeat.i(101093);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbz(this, googleApiClient));
        AppMethodBeat.o(101093);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri) {
        AppMethodBeat.i(101094);
        PendingResult<DataItemBuffer> dataItems = getDataItems(googleApiClient, uri, 0);
        AppMethodBeat.o(101094);
        return dataItems;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataItemBuffer> getDataItems(GoogleApiClient googleApiClient, Uri uri, int i2) {
        boolean z = true;
        AppMethodBeat.i(101095);
        Asserts.checkNotNull(uri, "uri must not be null");
        if (!(i2 == 0 || i2 == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z, "invalid filter type");
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzca(this, googleApiClient, uri, i2));
        AppMethodBeat.o(101095);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, Asset asset) {
        AppMethodBeat.i(101098);
        if (asset == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("asset is null");
            AppMethodBeat.o(101098);
            throw illegalArgumentException;
        } else if (asset.getDigest() == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("invalid asset");
            AppMethodBeat.o(101098);
            throw illegalArgumentException2;
        } else if (asset.getData() != null) {
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("invalid asset");
            AppMethodBeat.o(101098);
            throw illegalArgumentException3;
        } else {
            BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzcc(this, googleApiClient, asset));
            AppMethodBeat.o(101098);
            return enqueue;
        }
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
        AppMethodBeat.i(101099);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzcd(this, googleApiClient, dataItemAsset));
        AppMethodBeat.o(101099);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
        AppMethodBeat.i(101091);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzbx(this, googleApiClient, putDataRequest));
        AppMethodBeat.o(101091);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.DataApi
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, DataApi.DataListener dataListener) {
        AppMethodBeat.i(101103);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzcf(this, googleApiClient, dataListener));
        AppMethodBeat.o(101103);
        return enqueue;
    }
}
