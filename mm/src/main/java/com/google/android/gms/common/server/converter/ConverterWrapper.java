package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator = "ConverterWrapperCreator")
public class ConverterWrapper extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConverterWrapper> CREATOR = new ConverterWrapperCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getStringToIntConverter", id = 2)
    private final StringToIntConverter zzwd;

    static {
        AppMethodBeat.i(11936);
        AppMethodBeat.o(11936);
    }

    @SafeParcelable.Constructor
    ConverterWrapper(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) StringToIntConverter stringToIntConverter) {
        this.zzal = i2;
        this.zzwd = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.zzal = 1;
        this.zzwd = stringToIntConverter;
    }

    public static ConverterWrapper wrap(FastJsonResponse.FieldConverter<?, ?> fieldConverter) {
        AppMethodBeat.i(11933);
        if (fieldConverter instanceof StringToIntConverter) {
            ConverterWrapper converterWrapper = new ConverterWrapper((StringToIntConverter) fieldConverter);
            AppMethodBeat.o(11933);
            return converterWrapper;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        AppMethodBeat.o(11933);
        throw illegalArgumentException;
    }

    public FastJsonResponse.FieldConverter<?, ?> unwrap() {
        AppMethodBeat.i(11934);
        if (this.zzwd != null) {
            StringToIntConverter stringToIntConverter = this.zzwd;
            AppMethodBeat.o(11934);
            return stringToIntConverter;
        }
        IllegalStateException illegalStateException = new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        AppMethodBeat.o(11934);
        throw illegalStateException;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11935);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzwd, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(11935);
    }
}
