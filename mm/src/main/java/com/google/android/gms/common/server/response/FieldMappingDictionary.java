package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FieldMappingDictionary> CREATOR = new FieldMappingDictionaryCreator();
    @SafeParcelable.VersionField(id = 1)
    private final int zzal;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzxk;
    @SafeParcelable.Field(getter = "getSerializedDictionary", id = 2)
    private final ArrayList<Entry> zzxl;
    @SafeParcelable.Field(getter = "getRootClassName", id = 3)
    private final String zzxm;

    @SafeParcelable.Class(creator = "FieldMappingDictionaryEntryCreator")
    public static class Entry extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Entry> CREATOR = new FieldMappingDictionaryEntryCreator();
        @SafeParcelable.Field(id = 2)
        final String className;
        @SafeParcelable.VersionField(id = 1)
        private final int versionCode;
        @SafeParcelable.Field(id = 3)
        final ArrayList<FieldMapPair> zzxn;

        static {
            AppMethodBeat.i(12053);
            AppMethodBeat.o(12053);
        }

        @SafeParcelable.Constructor
        Entry(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i2;
            this.className = str;
            this.zzxn = arrayList;
        }

        Entry(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
            ArrayList<FieldMapPair> arrayList;
            AppMethodBeat.i(12051);
            this.versionCode = 1;
            this.className = str;
            if (map == null) {
                arrayList = null;
            } else {
                ArrayList<FieldMapPair> arrayList2 = new ArrayList<>();
                for (String str2 : map.keySet()) {
                    arrayList2.add(new FieldMapPair(str2, map.get(str2)));
                }
                arrayList = arrayList2;
            }
            this.zzxn = arrayList;
            AppMethodBeat.o(12051);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(12052);
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.className, false);
            SafeParcelWriter.writeTypedList(parcel, 3, this.zzxn, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            AppMethodBeat.o(12052);
        }
    }

    @SafeParcelable.Class(creator = "FieldMapPairCreator")
    public static class FieldMapPair extends AbstractSafeParcelable {
        public static final Parcelable.Creator<FieldMapPair> CREATOR = new FieldMapPairCreator();
        @SafeParcelable.VersionField(id = 1)
        private final int versionCode;
        @SafeParcelable.Field(id = 2)
        final String zzxo;
        @SafeParcelable.Field(id = 3)
        final FastJsonResponse.Field<?, ?> zzxp;

        static {
            AppMethodBeat.i(12055);
            AppMethodBeat.o(12055);
        }

        @SafeParcelable.Constructor
        FieldMapPair(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) FastJsonResponse.Field<?, ?> field) {
            this.versionCode = i2;
            this.zzxo = str;
            this.zzxp = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field<?, ?> field) {
            this.versionCode = 1;
            this.zzxo = str;
            this.zzxp = field;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(12054);
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.zzxo, false);
            SafeParcelWriter.writeParcelable(parcel, 3, this.zzxp, i2, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            AppMethodBeat.o(12054);
        }
    }

    static {
        AppMethodBeat.i(12066);
        AppMethodBeat.o(12066);
    }

    @SafeParcelable.Constructor
    FieldMappingDictionary(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<Entry> arrayList, @SafeParcelable.Param(id = 3) String str) {
        AppMethodBeat.i(12056);
        this.zzal = i2;
        this.zzxl = null;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Entry entry = arrayList.get(i3);
            String str2 = entry.className;
            HashMap hashMap2 = new HashMap();
            int size2 = entry.zzxn.size();
            for (int i4 = 0; i4 < size2; i4++) {
                FieldMapPair fieldMapPair = entry.zzxn.get(i4);
                hashMap2.put(fieldMapPair.zzxo, fieldMapPair.zzxp);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zzxk = hashMap;
        this.zzxm = (String) Preconditions.checkNotNull(str);
        linkFields();
        AppMethodBeat.o(12056);
    }

    public FieldMappingDictionary(Class<? extends FastJsonResponse> cls) {
        AppMethodBeat.i(12059);
        this.zzal = 1;
        this.zzxl = null;
        this.zzxk = new HashMap<>();
        this.zzxm = cls.getCanonicalName();
        AppMethodBeat.o(12059);
    }

    public void copyInternalFieldMappings() {
        AppMethodBeat.i(12058);
        for (String str : this.zzxk.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zzxk.get(str);
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                hashMap.put(str2, map.get(str2).copyForDictionary());
            }
            this.zzxk.put(str, hashMap);
        }
        AppMethodBeat.o(12058);
    }

    @VisibleForTesting
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(Class<? extends FastJsonResponse> cls) {
        AppMethodBeat.i(12061);
        Map<String, FastJsonResponse.Field<?, ?>> map = this.zzxk.get(cls.getCanonicalName());
        AppMethodBeat.o(12061);
        return map;
    }

    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMapping(String str) {
        AppMethodBeat.i(12062);
        Map<String, FastJsonResponse.Field<?, ?>> map = this.zzxk.get(str);
        AppMethodBeat.o(12062);
        return map;
    }

    public String getRootClassName() {
        return this.zzxm;
    }

    public boolean hasFieldMappingForClass(Class<? extends FastJsonResponse> cls) {
        AppMethodBeat.i(12063);
        boolean containsKey = this.zzxk.containsKey(cls.getCanonicalName());
        AppMethodBeat.o(12063);
        return containsKey;
    }

    public void linkFields() {
        AppMethodBeat.i(12057);
        for (String str : this.zzxk.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zzxk.get(str);
            for (String str2 : map.keySet()) {
                map.get(str2).setFieldMappingDictionary(this);
            }
        }
        AppMethodBeat.o(12057);
    }

    public void put(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        AppMethodBeat.i(12060);
        this.zzxk.put(cls.getCanonicalName(), map);
        AppMethodBeat.o(12060);
    }

    public String toString() {
        AppMethodBeat.i(12064);
        StringBuilder sb = new StringBuilder();
        for (String str : this.zzxk.keySet()) {
            sb.append(str).append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zzxk.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(map.get(str2));
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(12064);
        return sb2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(12065);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzxk.keySet()) {
            arrayList.add(new Entry(str, this.zzxk.get(str)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, getRootClassName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(12065);
    }
}
