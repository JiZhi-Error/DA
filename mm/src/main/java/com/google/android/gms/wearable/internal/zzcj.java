package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataClient;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcj extends DataClient {
    private final DataApi zzdi = new zzbw();

    public zzcj(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        AppMethodBeat.i(101124);
        AppMethodBeat.o(101124);
    }

    public zzcj(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        AppMethodBeat.i(101123);
        AppMethodBeat.o(101123);
    }

    private final Task<Void> zza(DataClient.OnDataChangedListener onDataChangedListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101136);
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(onDataChangedListener, getLooper(), "DataListener");
        Task<Void> doRegisterEventListener = doRegisterEventListener(new zzcv(onDataChangedListener, intentFilterArr, createListenerHolder), new zzcw(onDataChangedListener, createListenerHolder.getListenerKey()));
        AppMethodBeat.o(101136);
        return doRegisterEventListener;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Void> addListener(DataClient.OnDataChangedListener onDataChangedListener) {
        AppMethodBeat.i(101134);
        Task<Void> zza = zza(onDataChangedListener, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.DATA_CHANGED")});
        AppMethodBeat.o(101134);
        return zza;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Void> addListener(DataClient.OnDataChangedListener onDataChangedListener, Uri uri, int i2) {
        AppMethodBeat.i(101135);
        Asserts.checkNotNull(uri, "uri must not be null");
        Preconditions.checkArgument(i2 == 0 || i2 == 1, "invalid filter type");
        Task<Void> zza = zza(onDataChangedListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.DATA_CHANGED", uri, i2)});
        AppMethodBeat.o(101135);
        return zza;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Integer> deleteDataItems(Uri uri) {
        AppMethodBeat.i(101130);
        Task<Integer> task = PendingResultUtil.toTask(this.zzdi.deleteDataItems(asGoogleApiClient(), uri), zzcp.zzbx);
        AppMethodBeat.o(101130);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Integer> deleteDataItems(Uri uri, int i2) {
        AppMethodBeat.i(101131);
        Task<Integer> task = PendingResultUtil.toTask(this.zzdi.deleteDataItems(asGoogleApiClient(), uri, i2), zzcq.zzbx);
        AppMethodBeat.o(101131);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItem> getDataItem(Uri uri) {
        AppMethodBeat.i(101126);
        Task<DataItem> task = PendingResultUtil.toTask(this.zzdi.getDataItem(asGoogleApiClient(), uri), zzcl.zzbx);
        AppMethodBeat.o(101126);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems() {
        AppMethodBeat.i(101127);
        Task<DataItemBuffer> task = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient()), zzcm.zzbx);
        AppMethodBeat.o(101127);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems(Uri uri) {
        AppMethodBeat.i(101128);
        Task<DataItemBuffer> task = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient(), uri), zzcn.zzbx);
        AppMethodBeat.o(101128);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItemBuffer> getDataItems(Uri uri, int i2) {
        AppMethodBeat.i(101129);
        Task<DataItemBuffer> task = PendingResultUtil.toTask(this.zzdi.getDataItems(asGoogleApiClient(), uri, i2), zzco.zzbx);
        AppMethodBeat.o(101129);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(Asset asset) {
        AppMethodBeat.i(101132);
        Task<DataClient.GetFdForAssetResponse> task = PendingResultUtil.toTask(this.zzdi.getFdForAsset(asGoogleApiClient(), asset), zzcr.zzbx);
        AppMethodBeat.o(101132);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataClient.GetFdForAssetResponse> getFdForAsset(DataItemAsset dataItemAsset) {
        AppMethodBeat.i(101133);
        Task<DataClient.GetFdForAssetResponse> task = PendingResultUtil.toTask(this.zzdi.getFdForAsset(asGoogleApiClient(), dataItemAsset), zzcs.zzbx);
        AppMethodBeat.o(101133);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<DataItem> putDataItem(PutDataRequest putDataRequest) {
        AppMethodBeat.i(101125);
        Task<DataItem> task = PendingResultUtil.toTask(this.zzdi.putDataItem(asGoogleApiClient(), putDataRequest), zzck.zzbx);
        AppMethodBeat.o(101125);
        return task;
    }

    @Override // com.google.android.gms.wearable.DataClient
    public final Task<Boolean> removeListener(DataClient.OnDataChangedListener onDataChangedListener) {
        AppMethodBeat.i(101137);
        Task<Boolean> doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(onDataChangedListener, getLooper(), "DataListener").getListenerKey());
        AppMethodBeat.o(101137);
        return doUnregisterEventListener;
    }
}
