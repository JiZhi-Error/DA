package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new SafeParcelResponseCreator();
    private final String mClassName;
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int zzal;
    @SafeParcelable.Field(getter = "getFieldMappingDictionary", id = 3)
    private final FieldMappingDictionary zzwn;
    @SafeParcelable.Field(getter = "getParcel", id = 2)
    private final Parcel zzxq;
    private final int zzxr;
    private int zzxs;
    private int zzxt;

    static {
        AppMethodBeat.i(12114);
        AppMethodBeat.o(12114);
    }

    @SafeParcelable.Constructor
    SafeParcelResponse(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Parcel parcel, @SafeParcelable.Param(id = 3) FieldMappingDictionary fieldMappingDictionary) {
        AppMethodBeat.i(12081);
        this.zzal = i2;
        this.zzxq = (Parcel) Preconditions.checkNotNull(parcel);
        this.zzxr = 2;
        this.zzwn = fieldMappingDictionary;
        if (this.zzwn == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzwn.getRootClassName();
        }
        this.zzxs = 2;
        AppMethodBeat.o(12081);
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, FieldMappingDictionary fieldMappingDictionary, String str) {
        AppMethodBeat.i(12075);
        this.zzal = 1;
        this.zzxq = Parcel.obtain();
        safeParcelable.writeToParcel(this.zzxq, 0);
        this.zzxr = 1;
        this.zzwn = (FieldMappingDictionary) Preconditions.checkNotNull(fieldMappingDictionary);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zzxs = 2;
        AppMethodBeat.o(12075);
    }

    public SafeParcelResponse(FieldMappingDictionary fieldMappingDictionary) {
        this(fieldMappingDictionary, fieldMappingDictionary.getRootClassName());
        AppMethodBeat.i(12073);
        AppMethodBeat.o(12073);
    }

    public SafeParcelResponse(FieldMappingDictionary fieldMappingDictionary, String str) {
        AppMethodBeat.i(12074);
        this.zzal = 1;
        this.zzxq = Parcel.obtain();
        this.zzxr = 0;
        this.zzwn = (FieldMappingDictionary) Preconditions.checkNotNull(fieldMappingDictionary);
        this.mClassName = (String) Preconditions.checkNotNull(str);
        this.zzxs = 0;
        AppMethodBeat.o(12074);
    }

    public static HashMap<String, String> convertBundleToStringMap(Bundle bundle) {
        AppMethodBeat.i(12112);
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        AppMethodBeat.o(12112);
        return hashMap;
    }

    public static Bundle convertStringMapToBundle(HashMap<String, String> hashMap) {
        AppMethodBeat.i(12113);
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, hashMap.get(str));
        }
        AppMethodBeat.o(12113);
        return bundle;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t) {
        AppMethodBeat.i(12076);
        String canonicalName = t.getClass().getCanonicalName();
        SafeParcelResponse safeParcelResponse = new SafeParcelResponse(t, zza(t), canonicalName);
        AppMethodBeat.o(12076);
        return safeParcelResponse;
    }

    public static FieldMappingDictionary generateDictionary(Class<? extends FastJsonResponse> cls) {
        AppMethodBeat.i(12080);
        try {
            FieldMappingDictionary zza = zza((FastJsonResponse) cls.newInstance());
            AppMethodBeat.o(12080);
            return zza;
        } catch (InstantiationException e2) {
            String valueOf = String.valueOf(cls.getCanonicalName());
            IllegalStateException illegalStateException = new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e2);
            AppMethodBeat.o(12080);
            throw illegalStateException;
        } catch (IllegalAccessException e3) {
            String valueOf2 = String.valueOf(cls.getCanonicalName());
            IllegalStateException illegalStateException2 = new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e3);
            AppMethodBeat.o(12080);
            throw illegalStateException2;
        }
    }

    private static FieldMappingDictionary zza(FastJsonResponse fastJsonResponse) {
        AppMethodBeat.i(12077);
        FieldMappingDictionary fieldMappingDictionary = new FieldMappingDictionary(fastJsonResponse.getClass());
        zza(fieldMappingDictionary, fastJsonResponse);
        fieldMappingDictionary.copyInternalFieldMappings();
        fieldMappingDictionary.linkFields();
        AppMethodBeat.o(12077);
        return fieldMappingDictionary;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.android.gms.common.server.response.FieldMappingDictionary */
    /* JADX WARN: Multi-variable type inference failed */
    private static void zza(FieldMappingDictionary fieldMappingDictionary, FastJsonResponse fastJsonResponse) {
        AppMethodBeat.i(12078);
        Class<?> cls = fastJsonResponse.getClass();
        if (!fieldMappingDictionary.hasFieldMappingForClass(cls)) {
            Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
            fieldMappingDictionary.put(cls, fieldMappings);
            for (String str : fieldMappings.keySet()) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(str);
                Class<? extends FastJsonResponse> concreteType = field.getConcreteType();
                if (concreteType != null) {
                    try {
                        zza(fieldMappingDictionary, (FastJsonResponse) concreteType.newInstance());
                    } catch (InstantiationException e2) {
                        String valueOf = String.valueOf(field.getConcreteType().getCanonicalName());
                        IllegalStateException illegalStateException = new IllegalStateException(valueOf.length() != 0 ? "Could not instantiate an object of type ".concat(valueOf) : new String("Could not instantiate an object of type "), e2);
                        AppMethodBeat.o(12078);
                        throw illegalStateException;
                    } catch (IllegalAccessException e3) {
                        String valueOf2 = String.valueOf(field.getConcreteType().getCanonicalName());
                        IllegalStateException illegalStateException2 = new IllegalStateException(valueOf2.length() != 0 ? "Could not access object of type ".concat(valueOf2) : new String("Could not access object of type "), e3);
                        AppMethodBeat.o(12078);
                        throw illegalStateException2;
                    }
                }
            }
        }
        AppMethodBeat.o(12078);
    }

    private static void zza(StringBuilder sb, int i2, Object obj) {
        AppMethodBeat.i(12111);
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                AppMethodBeat.o(12111);
                return;
            case 7:
                sb.append("\"").append(JsonUtils.escapeString(obj.toString())).append("\"");
                AppMethodBeat.o(12111);
                return;
            case 8:
                sb.append("\"").append(Base64Utils.encode((byte[]) obj)).append("\"");
                AppMethodBeat.o(12111);
                return;
            case 9:
                sb.append("\"").append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                AppMethodBeat.o(12111);
                return;
            case 10:
                MapUtils.writeStringMapToJson(sb, (HashMap) obj);
                AppMethodBeat.o(12111);
                return;
            case 11:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Method does not accept concrete type.");
                AppMethodBeat.o(12111);
                throw illegalArgumentException;
            default:
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(26).append("Unknown type = ").append(i2).toString());
                AppMethodBeat.o(12111);
                throw illegalArgumentException2;
        }
    }

    private final void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        AppMethodBeat.i(12109);
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().getSafeParcelableFieldId(), entry);
        }
        sb.append('{');
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.getFieldId(readHeader));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"").append((String) entry2.getKey()).append("\":");
                if (field.hasConverter()) {
                    switch (field.getTypeOut()) {
                        case 0:
                            zzb(sb, field, getOriginalValue(field, Integer.valueOf(SafeParcelReader.readInt(parcel, readHeader))));
                            break;
                        case 1:
                            zzb(sb, field, getOriginalValue(field, SafeParcelReader.createBigInteger(parcel, readHeader)));
                            break;
                        case 2:
                            zzb(sb, field, getOriginalValue(field, Long.valueOf(SafeParcelReader.readLong(parcel, readHeader))));
                            break;
                        case 3:
                            zzb(sb, field, getOriginalValue(field, Float.valueOf(SafeParcelReader.readFloat(parcel, readHeader))));
                            break;
                        case 4:
                            zzb(sb, field, getOriginalValue(field, Double.valueOf(SafeParcelReader.readDouble(parcel, readHeader))));
                            break;
                        case 5:
                            zzb(sb, field, getOriginalValue(field, SafeParcelReader.createBigDecimal(parcel, readHeader)));
                            break;
                        case 6:
                            zzb(sb, field, getOriginalValue(field, Boolean.valueOf(SafeParcelReader.readBoolean(parcel, readHeader))));
                            break;
                        case 7:
                            zzb(sb, field, getOriginalValue(field, SafeParcelReader.createString(parcel, readHeader)));
                            break;
                        case 8:
                        case 9:
                            zzb(sb, field, getOriginalValue(field, SafeParcelReader.createByteArray(parcel, readHeader)));
                            break;
                        case 10:
                            zzb(sb, field, getOriginalValue(field, convertBundleToStringMap(SafeParcelReader.createBundle(parcel, readHeader))));
                            break;
                        case 11:
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Method does not accept concrete type.");
                            AppMethodBeat.o(12109);
                            throw illegalArgumentException;
                        default:
                            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(36).append("Unknown field out type = ").append(field.getTypeOut()).toString());
                            AppMethodBeat.o(12109);
                            throw illegalArgumentException2;
                    }
                } else if (field.isTypeOutArray()) {
                    sb.append("[");
                    switch (field.getTypeOut()) {
                        case 0:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createIntArray(parcel, readHeader));
                            break;
                        case 1:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createBigIntegerArray(parcel, readHeader));
                            break;
                        case 2:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createLongArray(parcel, readHeader));
                            break;
                        case 3:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createFloatArray(parcel, readHeader));
                            break;
                        case 4:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createDoubleArray(parcel, readHeader));
                            break;
                        case 5:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createBigDecimalArray(parcel, readHeader));
                            break;
                        case 6:
                            ArrayUtils.writeArray(sb, SafeParcelReader.createBooleanArray(parcel, readHeader));
                            break;
                        case 7:
                            ArrayUtils.writeStringArray(sb, SafeParcelReader.createStringArray(parcel, readHeader));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            AppMethodBeat.o(12109);
                            throw unsupportedOperationException;
                        case 11:
                            Parcel[] createParcelArray = SafeParcelReader.createParcelArray(parcel, readHeader);
                            int length = createParcelArray.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                if (i2 > 0) {
                                    sb.append(",");
                                }
                                createParcelArray[i2].setDataPosition(0);
                                zza(sb, field.getConcreteTypeFieldMappingFromDictionary(), createParcelArray[i2]);
                            }
                            break;
                        default:
                            IllegalStateException illegalStateException = new IllegalStateException("Unknown field type out.");
                            AppMethodBeat.o(12109);
                            throw illegalStateException;
                    }
                    sb.append("]");
                } else {
                    switch (field.getTypeOut()) {
                        case 0:
                            sb.append(SafeParcelReader.readInt(parcel, readHeader));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.createBigInteger(parcel, readHeader));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.readLong(parcel, readHeader));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.readFloat(parcel, readHeader));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.readDouble(parcel, readHeader));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.createBigDecimal(parcel, readHeader));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.readBoolean(parcel, readHeader));
                            break;
                        case 7:
                            sb.append("\"").append(JsonUtils.escapeString(SafeParcelReader.createString(parcel, readHeader))).append("\"");
                            break;
                        case 8:
                            sb.append("\"").append(Base64Utils.encode(SafeParcelReader.createByteArray(parcel, readHeader))).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(Base64Utils.encodeUrlSafe(SafeParcelReader.createByteArray(parcel, readHeader)));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle createBundle = SafeParcelReader.createBundle(parcel, readHeader);
                            Set<String> keySet = createBundle.keySet();
                            keySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str : keySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"").append(str).append("\"");
                                sb.append(":");
                                sb.append("\"").append(JsonUtils.escapeString(createBundle.getString(str))).append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel createParcel = SafeParcelReader.createParcel(parcel, readHeader);
                            createParcel.setDataPosition(0);
                            zza(sb, field.getConcreteTypeFieldMappingFromDictionary(), createParcel);
                            break;
                        default:
                            IllegalStateException illegalStateException2 = new IllegalStateException("Unknown field type out");
                            AppMethodBeat.o(12109);
                            throw illegalStateException2;
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() != validateObjectHeader) {
            SafeParcelReader.ParseException parseException = new SafeParcelReader.ParseException(new StringBuilder(37).append("Overread allowed size end=").append(validateObjectHeader).toString(), parcel);
            AppMethodBeat.o(12109);
            throw parseException;
        }
        sb.append('}');
        AppMethodBeat.o(12109);
    }

    private final void zzb(FastJsonResponse.Field<?, ?> field) {
        AppMethodBeat.i(12087);
        if (!field.isValidSafeParcelableFieldId()) {
            IllegalStateException illegalStateException = new IllegalStateException("Field does not have a valid safe parcelable field id.");
            AppMethodBeat.o(12087);
            throw illegalStateException;
        } else if (this.zzxq == null) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Internal Parcel object is null.");
            AppMethodBeat.o(12087);
            throw illegalStateException2;
        } else {
            switch (this.zzxs) {
                case 0:
                    this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
                    this.zzxs = 1;
                    AppMethodBeat.o(12087);
                    return;
                case 1:
                    AppMethodBeat.o(12087);
                    return;
                case 2:
                    IllegalStateException illegalStateException3 = new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                    AppMethodBeat.o(12087);
                    throw illegalStateException3;
                default:
                    IllegalStateException illegalStateException4 = new IllegalStateException("Unknown parse state in SafeParcelResponse.");
                    AppMethodBeat.o(12087);
                    throw illegalStateException4;
            }
        }
    }

    private final void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        AppMethodBeat.i(12110);
        if (field.isTypeInArray()) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                zza(sb, field.getTypeIn(), arrayList.get(i2));
            }
            sb.append("]");
            AppMethodBeat.o(12110);
            return;
        }
        zza(sb, field.getTypeIn(), obj);
        AppMethodBeat.o(12110);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        AppMethodBeat.i(12107);
        zzb(field);
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        ArrayList<T> arrayList3 = arrayList;
        int size = arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            T t = arrayList3.get(i2);
            i2++;
            arrayList2.add(((SafeParcelResponse) t).getParcel());
        }
        SafeParcelWriter.writeParcelList(this.zzxq, field.getSafeParcelableFieldId(), arrayList2, true);
        AppMethodBeat.o(12107);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        AppMethodBeat.i(12106);
        zzb(field);
        SafeParcelWriter.writeParcel(this.zzxq, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t).getParcel(), true);
        AppMethodBeat.o(12106);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        AppMethodBeat.i(12084);
        if (this.zzwn == null) {
            AppMethodBeat.o(12084);
            return null;
        }
        Map<String, FastJsonResponse.Field<?, ?>> fieldMapping = this.zzwn.getFieldMapping(this.mClassName);
        AppMethodBeat.o(12084);
        return fieldMapping;
    }

    public Parcel getParcel() {
        AppMethodBeat.i(12083);
        switch (this.zzxs) {
            case 0:
                this.zzxt = SafeParcelWriter.beginObjectHeader(this.zzxq);
            case 1:
                SafeParcelWriter.finishObjectHeader(this.zzxq, this.zzxt);
                this.zzxs = 2;
                break;
        }
        Parcel parcel = this.zzxq;
        AppMethodBeat.o(12083);
        return parcel;
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object getValueObject(String str) {
        AppMethodBeat.i(12085);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Converting to JSON does not require this method.");
        AppMethodBeat.o(12085);
        throw unsupportedOperationException;
    }

    public int getVersionCode() {
        return this.zzal;
    }

    public <T extends SafeParcelable> T inflate(Parcelable.Creator<T> creator) {
        AppMethodBeat.i(12079);
        Parcel parcel = getParcel();
        parcel.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(parcel);
        AppMethodBeat.o(12079);
        return createFromParcel;
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean isPrimitiveFieldSet(String str) {
        AppMethodBeat.i(12086);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Converting to JSON does not require this method.");
        AppMethodBeat.o(12086);
        throw unsupportedOperationException;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setBigDecimalInternal(FastJsonResponse.Field<?, ?> field, String str, BigDecimal bigDecimal) {
        AppMethodBeat.i(12098);
        zzb(field);
        SafeParcelWriter.writeBigDecimal(this.zzxq, field.getSafeParcelableFieldId(), bigDecimal, true);
        AppMethodBeat.o(12098);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setBigDecimalsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        AppMethodBeat.i(12099);
        zzb(field);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i2 = 0; i2 < size; i2++) {
            bigDecimalArr[i2] = arrayList.get(i2);
        }
        SafeParcelWriter.writeBigDecimalArray(this.zzxq, field.getSafeParcelableFieldId(), bigDecimalArr, true);
        AppMethodBeat.o(12099);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setBigIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, BigInteger bigInteger) {
        AppMethodBeat.i(12090);
        zzb(field);
        SafeParcelWriter.writeBigInteger(this.zzxq, field.getSafeParcelableFieldId(), bigInteger, true);
        AppMethodBeat.o(12090);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setBigIntegersInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        AppMethodBeat.i(12091);
        zzb(field);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i2 = 0; i2 < size; i2++) {
            bigIntegerArr[i2] = arrayList.get(i2);
        }
        SafeParcelWriter.writeBigIntegerArray(this.zzxq, field.getSafeParcelableFieldId(), bigIntegerArr, true);
        AppMethodBeat.o(12091);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        AppMethodBeat.i(12100);
        zzb(field);
        SafeParcelWriter.writeBoolean(this.zzxq, field.getSafeParcelableFieldId(), z);
        AppMethodBeat.o(12100);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setBooleansInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        AppMethodBeat.i(12101);
        zzb(field);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i2 = 0; i2 < size; i2++) {
            zArr[i2] = arrayList.get(i2).booleanValue();
        }
        SafeParcelWriter.writeBooleanArray(this.zzxq, field.getSafeParcelableFieldId(), zArr, true);
        AppMethodBeat.o(12101);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        AppMethodBeat.i(12104);
        zzb(field);
        SafeParcelWriter.writeByteArray(this.zzxq, field.getSafeParcelableFieldId(), bArr, true);
        AppMethodBeat.o(12104);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setDoubleInternal(FastJsonResponse.Field<?, ?> field, String str, double d2) {
        AppMethodBeat.i(12096);
        zzb(field);
        SafeParcelWriter.writeDouble(this.zzxq, field.getSafeParcelableFieldId(), d2);
        AppMethodBeat.o(12096);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setDoublesInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        AppMethodBeat.i(12097);
        zzb(field);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = arrayList.get(i2).doubleValue();
        }
        SafeParcelWriter.writeDoubleArray(this.zzxq, field.getSafeParcelableFieldId(), dArr, true);
        AppMethodBeat.o(12097);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setFloatInternal(FastJsonResponse.Field<?, ?> field, String str, float f2) {
        AppMethodBeat.i(12094);
        zzb(field);
        SafeParcelWriter.writeFloat(this.zzxq, field.getSafeParcelableFieldId(), f2);
        AppMethodBeat.o(12094);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setFloatsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        AppMethodBeat.i(12095);
        zzb(field);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = arrayList.get(i2).floatValue();
        }
        SafeParcelWriter.writeFloatArray(this.zzxq, field.getSafeParcelableFieldId(), fArr, true);
        AppMethodBeat.o(12095);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i2) {
        AppMethodBeat.i(12088);
        zzb(field);
        SafeParcelWriter.writeInt(this.zzxq, field.getSafeParcelableFieldId(), i2);
        AppMethodBeat.o(12088);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setIntegersInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        AppMethodBeat.i(12089);
        zzb(field);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = arrayList.get(i2).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zzxq, field.getSafeParcelableFieldId(), iArr, true);
        AppMethodBeat.o(12089);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j2) {
        AppMethodBeat.i(12092);
        zzb(field);
        SafeParcelWriter.writeLong(this.zzxq, field.getSafeParcelableFieldId(), j2);
        AppMethodBeat.o(12092);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setLongsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        AppMethodBeat.i(12093);
        zzb(field);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = arrayList.get(i2).longValue();
        }
        SafeParcelWriter.writeLongArray(this.zzxq, field.getSafeParcelableFieldId(), jArr, true);
        AppMethodBeat.o(12093);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        AppMethodBeat.i(12102);
        zzb(field);
        SafeParcelWriter.writeString(this.zzxq, field.getSafeParcelableFieldId(), str2, true);
        AppMethodBeat.o(12102);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        AppMethodBeat.i(12105);
        zzb(field);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        SafeParcelWriter.writeBundle(this.zzxq, field.getSafeParcelableFieldId(), bundle, true);
        AppMethodBeat.o(12105);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        AppMethodBeat.i(12103);
        zzb(field);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = arrayList.get(i2);
        }
        SafeParcelWriter.writeStringArray(this.zzxq, field.getSafeParcelableFieldId(), strArr, true);
        AppMethodBeat.o(12103);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        AppMethodBeat.i(12108);
        Preconditions.checkNotNull(this.zzwn, "Cannot convert to JSON on client side.");
        Parcel parcel = getParcel();
        parcel.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.zzwn.getFieldMapping(this.mClassName), parcel);
        String sb2 = sb.toString();
        AppMethodBeat.o(12108);
        return sb2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        FieldMappingDictionary fieldMappingDictionary;
        AppMethodBeat.i(12082);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
        SafeParcelWriter.writeParcel(parcel, 2, getParcel(), false);
        switch (this.zzxr) {
            case 0:
                fieldMappingDictionary = null;
                break;
            case 1:
                fieldMappingDictionary = this.zzwn;
                break;
            case 2:
                fieldMappingDictionary = this.zzwn;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(34).append("Invalid creation type: ").append(this.zzxr).toString());
                AppMethodBeat.o(12082);
                throw illegalStateException;
        }
        SafeParcelWriter.writeParcelable(parcel, 3, fieldMappingDictionary, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(12082);
    }
}
