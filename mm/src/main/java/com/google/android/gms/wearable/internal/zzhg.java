package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.annotation.Nullable;

public final class zzhg extends GmsClient<zzep> {
    private final ExecutorService zzew;
    private final zzer<Object> zzex;
    private final zzer<Object> zzey;
    private final zzer<ChannelApi.ChannelListener> zzez;
    private final zzer<DataApi.DataListener> zzfa;
    private final zzer<MessageApi.MessageListener> zzfb;
    private final zzer<Object> zzfc;
    private final zzer<Object> zzfd;
    private final zzer<CapabilityApi.CapabilityListener> zzfe;
    private final zzhp zzff;

    public zzhg(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings, Executors.newCachedThreadPool(), zzhp.zza(context));
        AppMethodBeat.i(101378);
        AppMethodBeat.o(101378);
    }

    @VisibleForTesting
    private zzhg(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings, ExecutorService executorService, zzhp zzhp) {
        super(context, looper, 14, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(101379);
        this.zzex = new zzer<>();
        this.zzey = new zzer<>();
        this.zzez = new zzer<>();
        this.zzfa = new zzer<>();
        this.zzfb = new zzer<>();
        this.zzfc = new zzer<>();
        this.zzfd = new zzer<>();
        this.zzfe = new zzer<>();
        this.zzew = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzff = zzhp;
        AppMethodBeat.o(101379);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        int i2 = 0;
        AppMethodBeat.i(101383);
        if (!requiresGooglePlayServices()) {
            try {
                Bundle bundle = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
                if (bundle != null) {
                    i2 = bundle.getInt("com.google.android.wearable.api.version", 0);
                }
                if (i2 < GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                    new StringBuilder(86).append("The Wear OS app is out of date. Requires API version ").append(GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(i2);
                    Context context = getContext();
                    Context context2 = getContext();
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    triggerNotAvailable(connectionProgressReportCallbacks, 6, PendingIntent.getActivity(context, 0, intent, 0));
                    AppMethodBeat.o(101383);
                    return;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                triggerNotAvailable(connectionProgressReportCallbacks, 16, null);
                AppMethodBeat.o(101383);
                return;
            }
        }
        super.connect(connectionProgressReportCallbacks);
        AppMethodBeat.o(101383);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(101396);
        if (iBinder == null) {
            AppMethodBeat.o(101396);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        if (queryLocalInterface instanceof zzep) {
            zzep zzep = (zzep) queryLocalInterface;
            AppMethodBeat.o(101396);
            return zzep;
        }
        zzeq zzeq = new zzeq(iBinder);
        AppMethodBeat.o(101396);
        return zzeq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.GmsClient
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.wearable.BIND";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServicePackage() {
        AppMethodBeat.i(101380);
        if (this.zzff.zze("com.google.android.wearable.app.cn")) {
            AppMethodBeat.o(101380);
            return "com.google.android.wearable.app.cn";
        }
        AppMethodBeat.o(101380);
        return "com.google.android.gms";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i2, IBinder iBinder, Bundle bundle, int i3) {
        AppMethodBeat.i(101382);
        if (Log.isLoggable("WearableClient", 2)) {
            new StringBuilder(41).append("onPostInitHandler: statusCode ").append(i2);
        }
        if (i2 == 0) {
            this.zzex.zza(iBinder);
            this.zzey.zza(iBinder);
            this.zzez.zza(iBinder);
            this.zzfa.zza(iBinder);
            this.zzfb.zza(iBinder);
            this.zzfc.zza(iBinder);
            this.zzfd.zza(iBinder);
            this.zzfe.zza(iBinder);
        }
        super.onPostInitHandler(i2, iBinder, bundle, i3);
        AppMethodBeat.o(101382);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        AppMethodBeat.i(101381);
        if (!this.zzff.zze("com.google.android.wearable.app.cn")) {
            AppMethodBeat.o(101381);
            return true;
        }
        AppMethodBeat.o(101381);
        return false;
    }

    public final void zza(BaseImplementation.ResultHolder<DataApi.GetFdForAssetResult> resultHolder, Asset asset) {
        AppMethodBeat.i(101385);
        ((zzep) getService()).zza(new zzgx(resultHolder), asset);
        AppMethodBeat.o(101385);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, CapabilityApi.CapabilityListener capabilityListener) {
        AppMethodBeat.i(101394);
        this.zzfe.zza(this, resultHolder, capabilityListener);
        AppMethodBeat.o(101394);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, CapabilityApi.CapabilityListener capabilityListener, ListenerHolder<CapabilityApi.CapabilityListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101390);
        this.zzfe.zza(this, resultHolder, capabilityListener, zzhk.zzd(listenerHolder, intentFilterArr));
        AppMethodBeat.o(101390);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, ChannelApi.ChannelListener channelListener, ListenerHolder<ChannelApi.ChannelListener> listenerHolder, @Nullable String str, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101391);
        if (str == null) {
            this.zzez.zza(this, resultHolder, channelListener, zzhk.zzc(listenerHolder, intentFilterArr));
            AppMethodBeat.o(101391);
            return;
        }
        this.zzez.zza(this, resultHolder, new zzgc(str, channelListener), zzhk.zza(listenerHolder, str, intentFilterArr));
        AppMethodBeat.o(101391);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, ChannelApi.ChannelListener channelListener, String str) {
        AppMethodBeat.i(101395);
        if (str == null) {
            this.zzez.zza(this, resultHolder, channelListener);
            AppMethodBeat.o(101395);
            return;
        }
        this.zzez.zza(this, resultHolder, new zzgc(str, channelListener));
        AppMethodBeat.o(101395);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, DataApi.DataListener dataListener) {
        AppMethodBeat.i(101392);
        this.zzfa.zza(this, resultHolder, dataListener);
        AppMethodBeat.o(101392);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, DataApi.DataListener dataListener, ListenerHolder<DataApi.DataListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101388);
        this.zzfa.zza(this, resultHolder, dataListener, zzhk.zza(listenerHolder, intentFilterArr));
        AppMethodBeat.o(101388);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, MessageApi.MessageListener messageListener) {
        AppMethodBeat.i(101393);
        this.zzfb.zza(this, resultHolder, messageListener);
        AppMethodBeat.o(101393);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, MessageApi.MessageListener messageListener, ListenerHolder<MessageApi.MessageListener> listenerHolder, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(101389);
        this.zzfb.zza(this, resultHolder, messageListener, zzhk.zzb(listenerHolder, intentFilterArr));
        AppMethodBeat.o(101389);
    }

    public final void zza(BaseImplementation.ResultHolder<DataApi.DataItemResult> resultHolder, PutDataRequest putDataRequest) {
        AppMethodBeat.i(101384);
        for (Map.Entry<String, Asset> entry : putDataRequest.getAssets().entrySet()) {
            Asset value = entry.getValue();
            if (value.getData() == null && value.getDigest() == null && value.getFd() == null && value.getUri() == null) {
                String valueOf = String.valueOf(putDataRequest.getUri());
                String valueOf2 = String.valueOf(value);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33 + String.valueOf(valueOf2).length()).append("Put for ").append(valueOf).append(" contains invalid asset: ").append(valueOf2).toString());
                AppMethodBeat.o(101384);
                throw illegalArgumentException;
            }
        }
        PutDataRequest zza = PutDataRequest.zza(putDataRequest.getUri());
        zza.setData(putDataRequest.getData());
        if (putDataRequest.isUrgent()) {
            zza.setUrgent();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Asset> entry2 : putDataRequest.getAssets().entrySet()) {
            Asset value2 = entry2.getValue();
            if (value2.getData() != null) {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf3 = String.valueOf(value2);
                        String valueOf4 = String.valueOf(createPipe[0]);
                        String valueOf5 = String.valueOf(createPipe[1]);
                        new StringBuilder(String.valueOf(valueOf3).length() + 61 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length()).append("processAssets: replacing data with FD in asset: ").append(valueOf3).append(" read:").append(valueOf4).append(" write:").append(valueOf5);
                    }
                    zza.putAsset(entry2.getKey(), Asset.createFromFd(createPipe[0]));
                    FutureTask futureTask = new FutureTask(new zzhh(this, createPipe[1], value2.getData()));
                    arrayList.add(futureTask);
                    this.zzew.submit(futureTask);
                } catch (IOException e2) {
                    String valueOf6 = String.valueOf(putDataRequest);
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf6).length() + 60).append("Unable to create ParcelFileDescriptor for asset in request: ").append(valueOf6).toString(), e2);
                    AppMethodBeat.o(101384);
                    throw illegalStateException;
                }
            } else if (value2.getUri() != null) {
                try {
                    zza.putAsset(entry2.getKey(), Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(value2.getUri(), "r")));
                } catch (FileNotFoundException e3) {
                    new zzhb(resultHolder, arrayList).zza(new zzfu(WearableStatusCodes.ASSET_UNAVAILABLE, null));
                    String valueOf7 = String.valueOf(value2.getUri());
                    new StringBuilder(String.valueOf(valueOf7).length() + 28).append("Couldn't resolve asset URI: ").append(valueOf7);
                    AppMethodBeat.o(101384);
                    return;
                }
            } else {
                zza.putAsset(entry2.getKey(), value2);
            }
        }
        ((zzep) getService()).zza(new zzhb(resultHolder, arrayList), zza);
        AppMethodBeat.o(101384);
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, Uri uri, long j2, long j3) {
        AppMethodBeat.i(101387);
        try {
            ExecutorService executorService = this.zzew;
            Preconditions.checkNotNull(resultHolder);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(uri);
            Preconditions.checkArgument(j2 >= 0, "startOffset is negative: %s", Long.valueOf(j2));
            Preconditions.checkArgument(j3 >= -1, "invalid length: %s", Long.valueOf(j3));
            executorService.execute(new zzhj(this, uri, resultHolder, str, j2, j3));
            AppMethodBeat.o(101387);
        } catch (RuntimeException e2) {
            resultHolder.setFailedResult(new Status(8));
            AppMethodBeat.o(101387);
            throw e2;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Status> resultHolder, String str, Uri uri, boolean z) {
        AppMethodBeat.i(101386);
        try {
            ExecutorService executorService = this.zzew;
            Preconditions.checkNotNull(resultHolder);
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(uri);
            executorService.execute(new zzhi(this, uri, resultHolder, z, str));
            AppMethodBeat.o(101386);
        } catch (RuntimeException e2) {
            resultHolder.setFailedResult(new Status(8));
            AppMethodBeat.o(101386);
            throw e2;
        }
    }
}
