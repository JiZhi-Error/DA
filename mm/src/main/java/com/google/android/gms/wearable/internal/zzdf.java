package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.HashMap;
import java.util.Map;

public final class zzdf extends DataBufferRef implements DataItem {
    private final int zzdl;

    public zzdf(DataHolder dataHolder, int i2, int i3) {
        super(dataHolder, i2);
        this.zzdl = i3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ DataItem freeze() {
        AppMethodBeat.i(101187);
        zzdc zzdc = new zzdc(this);
        AppMethodBeat.o(101187);
        return zzdc;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Map<String, DataItemAsset> getAssets() {
        AppMethodBeat.i(101184);
        HashMap hashMap = new HashMap(this.zzdl);
        for (int i2 = 0; i2 < this.zzdl; i2++) {
            zzdb zzdb = new zzdb(this.mDataHolder, this.mDataRow + i2);
            if (zzdb.getDataItemKey() != null) {
                hashMap.put(zzdb.getDataItemKey(), zzdb);
            }
        }
        AppMethodBeat.o(101184);
        return hashMap;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final byte[] getData() {
        AppMethodBeat.i(101183);
        byte[] byteArray = getByteArray("data");
        AppMethodBeat.o(101183);
        return byteArray;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final Uri getUri() {
        AppMethodBeat.i(101182);
        Uri parse = Uri.parse(getString("path"));
        AppMethodBeat.o(101182);
        return parse;
    }

    @Override // com.google.android.gms.wearable.DataItem
    public final DataItem setData(byte[] bArr) {
        AppMethodBeat.i(101185);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(101185);
        throw unsupportedOperationException;
    }

    public final String toString() {
        AppMethodBeat.i(101186);
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] data = getData();
        Map<String, DataItemAsset> assets = getAssets();
        StringBuilder sb = new StringBuilder("DataItemRef{ ");
        String valueOf = String.valueOf(getUri());
        sb.append(new StringBuilder(String.valueOf(valueOf).length() + 4).append("uri=").append(valueOf).toString());
        String valueOf2 = String.valueOf(data == null ? BuildConfig.COMMAND : Integer.valueOf(data.length));
        sb.append(new StringBuilder(String.valueOf(valueOf2).length() + 9).append(", dataSz=").append(valueOf2).toString());
        sb.append(new StringBuilder(23).append(", numAssets=").append(assets.size()).toString());
        if (isLoggable && !assets.isEmpty()) {
            sb.append(", assets=[");
            String str = "";
            for (Map.Entry<String, DataItemAsset> entry : assets.entrySet()) {
                String key = entry.getKey();
                String id = entry.getValue().getId();
                sb.append(new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(key).length() + String.valueOf(id).length()).append(str).append(key).append(": ").append(id).toString());
                str = ", ";
            }
            sb.append("]");
        }
        sb.append(" }");
        String sb2 = sb.toString();
        AppMethodBeat.o(101186);
        return sb2;
    }
}
