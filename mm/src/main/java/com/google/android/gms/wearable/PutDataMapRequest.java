package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzt;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class PutDataMapRequest {
    private final DataMap zzr = new DataMap();
    private final PutDataRequest zzs;

    private PutDataMapRequest(PutDataRequest putDataRequest, DataMap dataMap) {
        AppMethodBeat.i(100848);
        this.zzs = putDataRequest;
        if (dataMap != null) {
            this.zzr.putAll(dataMap);
        }
        AppMethodBeat.o(100848);
    }

    public static PutDataMapRequest create(String str) {
        AppMethodBeat.i(100851);
        Asserts.checkNotNull(str, "path must not be null");
        PutDataMapRequest putDataMapRequest = new PutDataMapRequest(PutDataRequest.create(str), null);
        AppMethodBeat.o(100851);
        return putDataMapRequest;
    }

    public static PutDataMapRequest createFromDataMapItem(DataMapItem dataMapItem) {
        AppMethodBeat.i(100849);
        Asserts.checkNotNull(dataMapItem, "source must not be null");
        PutDataMapRequest putDataMapRequest = new PutDataMapRequest(PutDataRequest.zza(dataMapItem.getUri()), dataMapItem.getDataMap());
        AppMethodBeat.o(100849);
        return putDataMapRequest;
    }

    public static PutDataMapRequest createWithAutoAppendedId(String str) {
        AppMethodBeat.i(100850);
        Asserts.checkNotNull(str, "pathPrefix must not be null");
        PutDataMapRequest putDataMapRequest = new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(str), null);
        AppMethodBeat.o(100850);
        return putDataMapRequest;
    }

    public PutDataRequest asPutDataRequest() {
        AppMethodBeat.i(100855);
        zzf zza = zze.zza(this.zzr);
        this.zzs.setData(zzt.zzb(zza.zzfw));
        int size = zza.zzfx.size();
        for (int i2 = 0; i2 < size; i2++) {
            String num = Integer.toString(i2);
            Asset asset = zza.zzfx.get(i2);
            if (num == null) {
                String valueOf = String.valueOf(asset);
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("asset key cannot be null: ").append(valueOf).toString());
                AppMethodBeat.o(100855);
                throw illegalStateException;
            } else if (asset == null) {
                String valueOf2 = String.valueOf(num);
                IllegalStateException illegalStateException2 = new IllegalStateException(valueOf2.length() != 0 ? "asset cannot be null: key=".concat(valueOf2) : new String("asset cannot be null: key="));
                AppMethodBeat.o(100855);
                throw illegalStateException2;
            } else {
                if (Log.isLoggable(DataMap.TAG, 3)) {
                    String valueOf3 = String.valueOf(asset);
                    new StringBuilder(String.valueOf(num).length() + 33 + String.valueOf(valueOf3).length()).append("asPutDataRequest: adding asset: ").append(num).append(" ").append(valueOf3);
                }
                this.zzs.putAsset(num, asset);
            }
        }
        PutDataRequest putDataRequest = this.zzs;
        AppMethodBeat.o(100855);
        return putDataRequest;
    }

    public DataMap getDataMap() {
        return this.zzr;
    }

    public Uri getUri() {
        AppMethodBeat.i(100852);
        Uri uri = this.zzs.getUri();
        AppMethodBeat.o(100852);
        return uri;
    }

    public boolean isUrgent() {
        AppMethodBeat.i(100854);
        boolean isUrgent = this.zzs.isUrgent();
        AppMethodBeat.o(100854);
        return isUrgent;
    }

    public PutDataMapRequest setUrgent() {
        AppMethodBeat.i(100853);
        this.zzs.setUrgent();
        AppMethodBeat.o(100853);
        return this;
    }
}
