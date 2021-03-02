package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.CapabilityApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;

public final class zzo implements CapabilityApi {
    private static PendingResult<Status> zza(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101444);
        PendingResult<Status> zza = zzb.zza(googleApiClient, new zzt(intentFilterArr), capabilityListener);
        AppMethodBeat.o(101444);
        return zza;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<Status> addCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        String str2;
        AppMethodBeat.i(101442);
        Asserts.checkNotNull(str, "capability must not be null");
        zzv zzv = new zzv(capabilityListener, str);
        IntentFilter zzc = zzgj.zzc("com.google.android.gms.wearable.CAPABILITY_CHANGED");
        if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            String valueOf = String.valueOf(str);
            str2 = valueOf.length() != 0 ? FilePathGenerator.ANDROID_DIR_SEP.concat(valueOf) : new String(FilePathGenerator.ANDROID_DIR_SEP);
        } else {
            str2 = str;
        }
        zzc.addDataPath(str2, 0);
        PendingResult<Status> zza = zza(googleApiClient, zzv, new IntentFilter[]{zzc});
        AppMethodBeat.o(101442);
        return zza;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, Uri uri, int i2) {
        AppMethodBeat.i(101443);
        Asserts.checkNotNull(uri, "uri must not be null");
        Preconditions.checkArgument(i2 == 0 || i2 == 1, "invalid filter type");
        PendingResult<Status> zza = zza(googleApiClient, capabilityListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i2)});
        AppMethodBeat.o(101443);
        return zza;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient googleApiClient, String str) {
        AppMethodBeat.i(101440);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzr(this, googleApiClient, str));
        AppMethodBeat.o(101440);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient googleApiClient, int i2) {
        boolean z = true;
        AppMethodBeat.i(101439);
        if (!(i2 == 0 || i2 == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzq(this, googleApiClient, i2));
        AppMethodBeat.o(101439);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient googleApiClient, String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(101438);
        if (!(i2 == 0 || i2 == 1)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzp(this, googleApiClient, str, i2));
        AppMethodBeat.o(101438);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<Status> removeCapabilityListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
        AppMethodBeat.i(101445);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzz(googleApiClient, new zzv(capabilityListener, str), null));
        AppMethodBeat.o(101445);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener) {
        AppMethodBeat.i(101446);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzz(googleApiClient, capabilityListener, null));
        AppMethodBeat.o(101446);
        return enqueue;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient googleApiClient, String str) {
        AppMethodBeat.i(101441);
        BaseImplementation.ApiMethodImpl enqueue = googleApiClient.enqueue(new zzs(this, googleApiClient, str));
        AppMethodBeat.o(101441);
        return enqueue;
    }
}
