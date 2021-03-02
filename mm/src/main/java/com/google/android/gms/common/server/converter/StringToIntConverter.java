package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

@SafeParcelable.Class(creator = "StringToIntConverterCreator")
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new StringToIntConverterCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    private final HashMap<String, Integer> zzwe;
    private final SparseArray<String> zzwf;
    @SafeParcelable.Field(getter = "getSerializedMap", id = 2)
    private final ArrayList<Entry> zzwg;

    @SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
    public static final class Entry extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Entry> CREATOR = new StringToIntConverterEntryCreator();
        @SafeParcelable.VersionField(id = 1)
        private final int versionCode;
        @SafeParcelable.Field(id = 2)
        final String zzwh;
        @SafeParcelable.Field(id = 3)
        final int zzwi;

        static {
            AppMethodBeat.i(11941);
            AppMethodBeat.o(11941);
        }

        @SafeParcelable.Constructor
        Entry(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
            this.versionCode = i2;
            this.zzwh = str;
            this.zzwi = i3;
        }

        Entry(String str, int i2) {
            this.versionCode = 1;
            this.zzwh = str;
            this.zzwi = i2;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(11940);
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.zzwh, false);
            SafeParcelWriter.writeInt(parcel, 3, this.zzwi);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            AppMethodBeat.o(11940);
        }
    }

    static {
        AppMethodBeat.i(11950);
        AppMethodBeat.o(11950);
    }

    public StringToIntConverter() {
        AppMethodBeat.i(11943);
        this.zzal = 1;
        this.zzwe = new HashMap<>();
        this.zzwf = new SparseArray<>();
        this.zzwg = null;
        AppMethodBeat.o(11943);
    }

    @SafeParcelable.Constructor
    StringToIntConverter(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<Entry> arrayList) {
        AppMethodBeat.i(11942);
        this.zzal = i2;
        this.zzwe = new HashMap<>();
        this.zzwf = new SparseArray<>();
        this.zzwg = null;
        ArrayList<Entry> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Entry entry = arrayList2.get(i3);
            i3++;
            Entry entry2 = entry;
            add(entry2.zzwh, entry2.zzwi);
        }
        AppMethodBeat.o(11942);
    }

    public final StringToIntConverter add(String str, int i2) {
        AppMethodBeat.i(11944);
        this.zzwe.put(str, Integer.valueOf(i2));
        this.zzwf.put(i2, str);
        AppMethodBeat.o(11944);
        return this;
    }

    public final Integer convert(String str) {
        AppMethodBeat.i(11945);
        Integer num = this.zzwe.get(str);
        if (num == null) {
            num = this.zzwe.get("gms_unknown");
        }
        AppMethodBeat.o(11945);
        return num;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* bridge */ /* synthetic */ Integer convert(String str) {
        AppMethodBeat.i(11949);
        Integer convert = convert(str);
        AppMethodBeat.o(11949);
        return convert;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* bridge */ /* synthetic */ String convertBack(Integer num) {
        AppMethodBeat.i(11948);
        String convertBack = convertBack(num);
        AppMethodBeat.o(11948);
        return convertBack;
    }

    public final String convertBack(Integer num) {
        AppMethodBeat.i(11946);
        String str = this.zzwf.get(num.intValue());
        if (str != null || !this.zzwe.containsKey("gms_unknown")) {
            AppMethodBeat.o(11946);
            return str;
        }
        AppMethodBeat.o(11946);
        return "gms_unknown";
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final int getTypeIn() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final int getTypeOut() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11947);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzwe.keySet()) {
            arrayList.add(new Entry(str, this.zzwe.get(str).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(11947);
    }
}
