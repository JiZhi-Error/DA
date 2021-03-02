package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.wearable.zze;
import com.google.android.gms.internal.wearable.zzf;
import com.google.android.gms.internal.wearable.zzg;
import com.google.android.gms.internal.wearable.zzs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@VisibleForTesting
public class DataMapItem {
    private final Uri uri;
    private final DataMap zzr;

    private DataMapItem(DataItem dataItem) {
        AppMethodBeat.i(100846);
        this.uri = dataItem.getUri();
        this.zzr = zza((DataItem) dataItem.freeze());
        AppMethodBeat.o(100846);
    }

    public static DataMapItem fromDataItem(DataItem dataItem) {
        AppMethodBeat.i(100845);
        Asserts.checkNotNull(dataItem, "dataItem must not be null");
        DataMapItem dataMapItem = new DataMapItem(dataItem);
        AppMethodBeat.o(100845);
        return dataMapItem;
    }

    private static DataMap zza(DataItem dataItem) {
        AppMethodBeat.i(100847);
        if (dataItem.getData() == null && dataItem.getAssets().size() > 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
            AppMethodBeat.o(100847);
            throw illegalArgumentException;
        } else if (dataItem.getData() == null) {
            DataMap dataMap = new DataMap();
            AppMethodBeat.o(100847);
            return dataMap;
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                int size = dataItem.getAssets().size();
                for (int i2 = 0; i2 < size; i2++) {
                    DataItemAsset dataItemAsset = dataItem.getAssets().get(Integer.toString(i2));
                    if (dataItemAsset == null) {
                        String valueOf = String.valueOf(dataItem);
                        IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 64).append("Cannot find DataItemAsset referenced in data at ").append(i2).append(" for ").append(valueOf).toString());
                        AppMethodBeat.o(100847);
                        throw illegalStateException;
                    }
                    arrayList.add(Asset.createFromRef(dataItemAsset.getId()));
                }
                DataMap zza = zze.zza(new zzf(zzg.zza(dataItem.getData()), arrayList));
                AppMethodBeat.o(100847);
                return zza;
            } catch (zzs | NullPointerException e2) {
                String valueOf2 = String.valueOf(dataItem.getUri());
                String encodeToString = Base64.encodeToString(dataItem.getData(), 0);
                new StringBuilder(String.valueOf(valueOf2).length() + 50 + String.valueOf(encodeToString).length()).append("Unable to parse datamap from dataItem. uri=").append(valueOf2).append(", data=").append(encodeToString);
                String valueOf3 = String.valueOf(dataItem.getUri());
                IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(String.valueOf(valueOf3).length() + 44).append("Unable to parse datamap from dataItem.  uri=").append(valueOf3).toString(), e2);
                AppMethodBeat.o(100847);
                throw illegalStateException2;
            }
        }
    }

    public DataMap getDataMap() {
        return this.zzr;
    }

    public Uri getUri() {
        return this.uri;
    }
}
