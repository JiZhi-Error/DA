package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzer extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzer> CREATOR = new zzet();
    @SafeParcelable.Field(getter = "z", id = 2)
    private final Bundle zzafy;

    static {
        AppMethodBeat.i(1262);
        AppMethodBeat.o(1262);
    }

    @SafeParcelable.Constructor
    zzer(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zzafy = bundle;
    }

    /* access modifiers changed from: package-private */
    public final Object get(String str) {
        AppMethodBeat.i(1254);
        Object obj = this.zzafy.get(str);
        AppMethodBeat.o(1254);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final Long getLong(String str) {
        AppMethodBeat.i(1255);
        Long valueOf = Long.valueOf(this.zzafy.getLong(str));
        AppMethodBeat.o(1255);
        return valueOf;
    }

    /* access modifiers changed from: package-private */
    public final String getString(String str) {
        AppMethodBeat.i(1257);
        String string = this.zzafy.getString(str);
        AppMethodBeat.o(1257);
        return string;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        AppMethodBeat.i(1261);
        zzes zzes = new zzes(this);
        AppMethodBeat.o(1261);
        return zzes;
    }

    public final int size() {
        AppMethodBeat.i(1258);
        int size = this.zzafy.size();
        AppMethodBeat.o(1258);
        return size;
    }

    public final String toString() {
        AppMethodBeat.i(1259);
        String bundle = this.zzafy.toString();
        AppMethodBeat.o(1259);
        return bundle;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(1253);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzif(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(1253);
    }

    /* access modifiers changed from: package-private */
    public final Double zzbh(String str) {
        AppMethodBeat.i(1256);
        Double valueOf = Double.valueOf(this.zzafy.getDouble(str));
        AppMethodBeat.o(1256);
        return valueOf;
    }

    public final Bundle zzif() {
        AppMethodBeat.i(1260);
        Bundle bundle = new Bundle(this.zzafy);
        AppMethodBeat.o(1260);
        return bundle;
    }
}
