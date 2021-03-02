package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.util.Map;

public final class zzaa extends CapabilityClient {
    private final CapabilityApi zzbw = new zzo();

    public zzaa(Activity activity, GoogleApi.Settings settings) {
        super(activity, settings);
        AppMethodBeat.i(100953);
        AppMethodBeat.o(100953);
    }

    public zzaa(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        AppMethodBeat.i(100952);
        AppMethodBeat.o(100952);
    }

    private final Task<Void> zza(ListenerHolder<CapabilityClient.OnCapabilityChangedListener> listenerHolder, CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(100962);
        Task<Void> doRegisterEventListener = doRegisterEventListener(new zzaf(onCapabilityChangedListener, intentFilterArr, listenerHolder), new zzag(onCapabilityChangedListener, listenerHolder.getListenerKey()));
        AppMethodBeat.o(100962);
        return doRegisterEventListener;
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addListener(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, Uri uri, int i2) {
        AppMethodBeat.i(100960);
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(uri, "uri must not be null");
        Preconditions.checkArgument(i2 == 0 || i2 == 1, "invalid filter type");
        Task<Void> zza = zza(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener"), onCapabilityChangedListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i2)});
        AppMethodBeat.o(100960);
        return zza;
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addListener(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        String str2;
        AppMethodBeat.i(100958);
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(str, "capability must not be null");
        IntentFilter zzc = zzgj.zzc("com.google.android.gms.wearable.CAPABILITY_CHANGED");
        if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            String valueOf = String.valueOf(str);
            str2 = valueOf.length() != 0 ? FilePathGenerator.ANDROID_DIR_SEP.concat(valueOf) : new String(FilePathGenerator.ANDROID_DIR_SEP);
        } else {
            str2 = str;
        }
        zzc.addDataPath(str2, 0);
        IntentFilter[] intentFilterArr = {zzc};
        Looper looper = getLooper();
        String valueOf2 = String.valueOf(str2);
        Task<Void> zza = zza(ListenerHolders.createListenerHolder(onCapabilityChangedListener, looper, valueOf2.length() != 0 ? "CapabilityListener:".concat(valueOf2) : new String("CapabilityListener:")), new zzae(onCapabilityChangedListener, str2), intentFilterArr);
        AppMethodBeat.o(100958);
        return zza;
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addLocalCapability(String str) {
        AppMethodBeat.i(100956);
        Asserts.checkNotNull(str, "capability must not be null");
        Task<Void> voidTask = PendingResultUtil.toVoidTask(this.zzbw.addLocalCapability(asGoogleApiClient(), str));
        AppMethodBeat.o(100956);
        return voidTask;
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Map<String, CapabilityInfo>> getAllCapabilities(int i2) {
        AppMethodBeat.i(100955);
        Task<Map<String, CapabilityInfo>> task = PendingResultUtil.toTask(this.zzbw.getAllCapabilities(asGoogleApiClient(), i2), zzac.zzbx);
        AppMethodBeat.o(100955);
        return task;
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<CapabilityInfo> getCapability(String str, int i2) {
        AppMethodBeat.i(100954);
        Asserts.checkNotNull(str, "capability must not be null");
        Task<CapabilityInfo> task = PendingResultUtil.toTask(this.zzbw.getCapability(asGoogleApiClient(), str, i2), zzab.zzbx);
        AppMethodBeat.o(100954);
        return task;
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Boolean> removeListener(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener) {
        AppMethodBeat.i(100961);
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Task<Boolean> doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener").getListenerKey());
        AppMethodBeat.o(100961);
        return doUnregisterEventListener;
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Boolean> removeListener(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        String str2;
        AppMethodBeat.i(100959);
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(str, "capability must not be null");
        if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            String valueOf = String.valueOf(str);
            str2 = valueOf.length() != 0 ? FilePathGenerator.ANDROID_DIR_SEP.concat(valueOf) : new String(FilePathGenerator.ANDROID_DIR_SEP);
        } else {
            str2 = str;
        }
        Looper looper = getLooper();
        String valueOf2 = String.valueOf(str2);
        Task<Boolean> doUnregisterEventListener = doUnregisterEventListener(ListenerHolders.createListenerHolder(onCapabilityChangedListener, looper, valueOf2.length() != 0 ? "CapabilityListener:".concat(valueOf2) : new String("CapabilityListener:")).getListenerKey());
        AppMethodBeat.o(100959);
        return doUnregisterEventListener;
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> removeLocalCapability(String str) {
        AppMethodBeat.i(100957);
        Asserts.checkNotNull(str, "capability must not be null");
        Task<Void> voidTask = PendingResultUtil.toVoidTask(this.zzbw.removeLocalCapability(asGoogleApiClient(), str));
        AppMethodBeat.o(100957);
        return voidTask;
    }
}
