package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzdc implements DataItem {
    private byte[] data;
    private Uri uri;
    private Map<String, DataItemAsset> zzdo;

    public zzdc(DataItem dataItem) {
        AppMethodBeat.i(101174);
        this.uri = dataItem.getUri();
        this.data = dataItem.getData();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, DataItemAsset> entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), (DataItemAsset) entry.getValue().freeze());
            }
        }
        this.zzdo = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(101174);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataItem freeze() {
        return this;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Map<String, DataItemAsset> getAssets() {
        return this.zzdo;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final byte[] getData() {
        return this.data;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final DataItem setData(byte[] bArr) {
        AppMethodBeat.i(101175);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(101175);
        throw unsupportedOperationException;
    }

    public final String toString() {
        AppMethodBeat.i(101176);
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder sb = new StringBuilder("DataItemEntity{ ");
        String valueOf = String.valueOf(this.uri);
        sb.append(new StringBuilder(String.valueOf(valueOf).length() + 4).append("uri=").append(valueOf).toString());
        String valueOf2 = String.valueOf(this.data == null ? BuildConfig.COMMAND : Integer.valueOf(this.data.length));
        sb.append(new StringBuilder(String.valueOf(valueOf2).length() + 9).append(", dataSz=").append(valueOf2).toString());
        sb.append(new StringBuilder(23).append(", numAssets=").append(this.zzdo.size()).toString());
        if (isLoggable && !this.zzdo.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry<String, DataItemAsset> entry : this.zzdo.entrySet()) {
                String key = entry.getKey();
                String id = entry.getValue().getId();
                sb.append(new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(key).length() + String.valueOf(id).length()).append(str).append(key).append(": ").append(id).toString());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        String sb2 = sb.toString();
        AppMethodBeat.o(101176);
        return sb2;
    }
}
