package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@VisibleForTesting
public final class SafeParcelableSerializer {
    public static <T extends SafeParcelable> T deserializeFromBytes(byte[] bArr, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4874);
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(4874);
        return createFromParcel;
    }

    public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4880);
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            AppMethodBeat.o(4880);
            return null;
        }
        T t = (T) deserializeFromBytes(byteArrayExtra, creator);
        AppMethodBeat.o(4880);
        return t;
    }

    public static <T extends SafeParcelable> T deserializeFromString(String str, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4878);
        T t = (T) deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
        AppMethodBeat.o(4878);
        return t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.ArrayList<T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4876);
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            AppMethodBeat.o(4876);
            return null;
        }
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList3.get(i2);
            i2++;
            arrayList2.add(deserializeFromBytes((byte[]) obj, creator));
        }
        AppMethodBeat.o(4876);
        return arrayList2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.ArrayList<T extends com.google.android.gms.common.internal.safeparcel.SafeParcelable> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(4882);
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            AppMethodBeat.o(4882);
            return null;
        }
        ArrayList<T> arrayList2 = (ArrayList<T>) new ArrayList(arrayList.size());
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList3.get(i2);
            i2++;
            arrayList2.add(deserializeFromBytes((byte[]) obj, creator));
        }
        AppMethodBeat.o(4882);
        return arrayList2;
    }

    public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> iterable, Bundle bundle, String str) {
        AppMethodBeat.i(4875);
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            arrayList.add(serializeToBytes(t));
        }
        bundle.putSerializable(str, arrayList);
        AppMethodBeat.o(4875);
    }

    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> iterable, Intent intent, String str) {
        AppMethodBeat.i(4881);
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            arrayList.add(serializeToBytes(t));
        }
        intent.putExtra(str, arrayList);
        AppMethodBeat.o(4881);
    }

    public static <T extends SafeParcelable> byte[] serializeToBytes(T t) {
        AppMethodBeat.i(4873);
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        AppMethodBeat.o(4873);
        return marshall;
    }

    public static <T extends SafeParcelable> void serializeToIntentExtra(T t, Intent intent, String str) {
        AppMethodBeat.i(4879);
        intent.putExtra(str, serializeToBytes(t));
        AppMethodBeat.o(4879);
    }

    public static <T extends SafeParcelable> String serializeToString(T t) {
        AppMethodBeat.i(4877);
        String encodeUrlSafe = Base64Utils.encodeUrlSafe(serializeToBytes(t));
        AppMethodBeat.o(4877);
        return encodeUrlSafe;
    }
}
