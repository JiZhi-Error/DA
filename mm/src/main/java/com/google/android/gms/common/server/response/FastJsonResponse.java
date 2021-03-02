package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public abstract class FastJsonResponse {
    protected static final String QUOTE = "\"";
    private int zzwk;
    private byte[] zzwl;
    private boolean zzwm;

    @VisibleForTesting
    @SafeParcelable.Class(creator = "FieldCreator")
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final FieldCreator CREATOR = new FieldCreator();
        protected final Class<? extends FastJsonResponse> mConcreteType;
        @SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)
        protected final String mConcreteTypeName;
        @SafeParcelable.Field(getter = "getOutputFieldName", id = 6)
        protected final String mOutputFieldName;
        @SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)
        protected final int mSafeParcelableFieldId;
        @SafeParcelable.Field(getter = "getTypeIn", id = 2)
        protected final int mTypeIn;
        @SafeParcelable.Field(getter = "isTypeInArray", id = 3)
        protected final boolean mTypeInArray;
        @SafeParcelable.Field(getter = "getTypeOut", id = 4)
        protected final int mTypeOut;
        @SafeParcelable.Field(getter = "isTypeOutArray", id = 5)
        protected final boolean mTypeOutArray;
        @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
        private final int zzal;
        private FieldMappingDictionary zzwn;
        @SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        private FieldConverter<I, O> zzwo;

        static {
            AppMethodBeat.i(12013);
            AppMethodBeat.o(12013);
        }

        @SafeParcelable.Constructor
        Field(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i5, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ConverterWrapper converterWrapper) {
            AppMethodBeat.i(11957);
            this.zzal = i2;
            this.mTypeIn = i3;
            this.mTypeInArray = z;
            this.mTypeOut = i4;
            this.mTypeOutArray = z2;
            this.mOutputFieldName = str;
            this.mSafeParcelableFieldId = i5;
            if (str2 == null) {
                this.mConcreteType = null;
                this.mConcreteTypeName = null;
            } else {
                this.mConcreteType = SafeParcelResponse.class;
                this.mConcreteTypeName = str2;
            }
            if (converterWrapper == null) {
                this.zzwo = null;
                AppMethodBeat.o(11957);
                return;
            }
            this.zzwo = (FieldConverter<I, O>) converterWrapper.unwrap();
            AppMethodBeat.o(11957);
        }

        protected Field(int i2, boolean z, int i3, boolean z2, String str, int i4, Class<? extends FastJsonResponse> cls, FieldConverter<I, O> fieldConverter) {
            AppMethodBeat.i(11958);
            this.zzal = 1;
            this.mTypeIn = i2;
            this.mTypeInArray = z;
            this.mTypeOut = i3;
            this.mTypeOutArray = z2;
            this.mOutputFieldName = str;
            this.mSafeParcelableFieldId = i4;
            this.mConcreteType = cls;
            if (cls == null) {
                this.mConcreteTypeName = null;
            } else {
                this.mConcreteTypeName = cls.getCanonicalName();
            }
            this.zzwo = fieldConverter;
            AppMethodBeat.o(11958);
        }

        public static Field<byte[], byte[]> forBase64(String str) {
            AppMethodBeat.i(12005);
            Field<byte[], byte[]> field = new Field<>(8, false, 8, false, str, -1, null, null);
            AppMethodBeat.o(12005);
            return field;
        }

        @VisibleForTesting
        public static Field<byte[], byte[]> forBase64(String str, int i2) {
            AppMethodBeat.i(11981);
            Field<byte[], byte[]> field = new Field<>(8, false, 8, false, str, i2, null, null);
            AppMethodBeat.o(11981);
            return field;
        }

        @VisibleForTesting
        public static Field<byte[], byte[]> forBase64UrlSafe(String str) {
            AppMethodBeat.i(12006);
            Field<byte[], byte[]> field = new Field<>(9, false, 9, false, str, -1, null, null);
            AppMethodBeat.o(12006);
            return field;
        }

        @VisibleForTesting
        public static Field<byte[], byte[]> forBase64UrlSafe(String str, int i2) {
            AppMethodBeat.i(11982);
            Field<byte[], byte[]> field = new Field<>(9, false, 9, false, str, i2, null, null);
            AppMethodBeat.o(11982);
            return field;
        }

        public static Field<BigDecimal, BigDecimal> forBigDecimal(String str) {
            AppMethodBeat.i(11999);
            Field<BigDecimal, BigDecimal> field = new Field<>(5, false, 5, false, str, -1, null, null);
            AppMethodBeat.o(11999);
            return field;
        }

        @VisibleForTesting
        public static Field<BigDecimal, BigDecimal> forBigDecimal(String str, int i2) {
            AppMethodBeat.i(11975);
            Field<BigDecimal, BigDecimal> field = new Field<>(5, false, 5, false, str, i2, null, null);
            AppMethodBeat.o(11975);
            return field;
        }

        public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String str) {
            AppMethodBeat.i(12000);
            Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> field = new Field<>(5, true, 5, true, str, -1, null, null);
            AppMethodBeat.o(12000);
            return field;
        }

        public static Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> forBigDecimals(String str, int i2) {
            AppMethodBeat.i(11976);
            Field<ArrayList<BigDecimal>, ArrayList<BigDecimal>> field = new Field<>(5, true, 5, true, str, i2, null, null);
            AppMethodBeat.o(11976);
            return field;
        }

        public static Field<BigInteger, BigInteger> forBigInteger(String str) {
            AppMethodBeat.i(11991);
            Field<BigInteger, BigInteger> field = new Field<>(1, false, 1, false, str, -1, null, null);
            AppMethodBeat.o(11991);
            return field;
        }

        public static Field<BigInteger, BigInteger> forBigInteger(String str, int i2) {
            AppMethodBeat.i(11967);
            Field<BigInteger, BigInteger> field = new Field<>(1, false, 1, false, str, i2, null, null);
            AppMethodBeat.o(11967);
            return field;
        }

        public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String str) {
            AppMethodBeat.i(11992);
            Field<ArrayList<BigInteger>, ArrayList<BigInteger>> field = new Field<>(0, true, 1, true, str, -1, null, null);
            AppMethodBeat.o(11992);
            return field;
        }

        public static Field<ArrayList<BigInteger>, ArrayList<BigInteger>> forBigIntegers(String str, int i2) {
            AppMethodBeat.i(11968);
            Field<ArrayList<BigInteger>, ArrayList<BigInteger>> field = new Field<>(0, true, 1, true, str, i2, null, null);
            AppMethodBeat.o(11968);
            return field;
        }

        public static Field<Boolean, Boolean> forBoolean(String str) {
            AppMethodBeat.i(12001);
            Field<Boolean, Boolean> field = new Field<>(6, false, 6, false, str, -1, null, null);
            AppMethodBeat.o(12001);
            return field;
        }

        public static Field<Boolean, Boolean> forBoolean(String str, int i2) {
            AppMethodBeat.i(11977);
            Field<Boolean, Boolean> field = new Field<>(6, false, 6, false, str, i2, null, null);
            AppMethodBeat.o(11977);
            return field;
        }

        public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String str) {
            AppMethodBeat.i(12002);
            Field<ArrayList<Boolean>, ArrayList<Boolean>> field = new Field<>(6, true, 6, true, str, -1, null, null);
            AppMethodBeat.o(12002);
            return field;
        }

        public static Field<ArrayList<Boolean>, ArrayList<Boolean>> forBooleans(String str, int i2) {
            AppMethodBeat.i(11978);
            Field<ArrayList<Boolean>, ArrayList<Boolean>> field = new Field<>(6, true, 6, true, str, i2, null, null);
            AppMethodBeat.o(11978);
            return field;
        }

        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, int i2, Class<T> cls) {
            AppMethodBeat.i(11984);
            Field<T, T> field = new Field<>(11, false, 11, false, str, i2, cls, null);
            AppMethodBeat.o(11984);
            return field;
        }

        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, Class<T> cls) {
            AppMethodBeat.i(12008);
            Field<T, T> field = new Field<>(11, false, 11, false, str, -1, cls, null);
            AppMethodBeat.o(12008);
            return field;
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String str, int i2, Class<T> cls) {
            AppMethodBeat.i(11985);
            Field<ArrayList<T>, ArrayList<T>> field = new Field<>(11, true, 11, true, str, i2, cls, null);
            AppMethodBeat.o(11985);
            return field;
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String str, Class<T> cls) {
            AppMethodBeat.i(12009);
            Field<ArrayList<T>, ArrayList<T>> field = new Field<>(11, true, 11, true, str, -1, cls, null);
            AppMethodBeat.o(12009);
            return field;
        }

        public static Field<Double, Double> forDouble(String str) {
            AppMethodBeat.i(11997);
            Field<Double, Double> field = new Field<>(4, false, 4, false, str, -1, null, null);
            AppMethodBeat.o(11997);
            return field;
        }

        public static Field<Double, Double> forDouble(String str, int i2) {
            AppMethodBeat.i(11973);
            Field<Double, Double> field = new Field<>(4, false, 4, false, str, i2, null, null);
            AppMethodBeat.o(11973);
            return field;
        }

        public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String str) {
            AppMethodBeat.i(11998);
            Field<ArrayList<Double>, ArrayList<Double>> field = new Field<>(4, true, 4, true, str, -1, null, null);
            AppMethodBeat.o(11998);
            return field;
        }

        public static Field<ArrayList<Double>, ArrayList<Double>> forDoubles(String str, int i2) {
            AppMethodBeat.i(11974);
            Field<ArrayList<Double>, ArrayList<Double>> field = new Field<>(4, true, 4, true, str, i2, null, null);
            AppMethodBeat.o(11974);
            return field;
        }

        public static Field<Float, Float> forFloat(String str) {
            AppMethodBeat.i(11995);
            Field<Float, Float> field = new Field<>(3, false, 3, false, str, -1, null, null);
            AppMethodBeat.o(11995);
            return field;
        }

        public static Field<Float, Float> forFloat(String str, int i2) {
            AppMethodBeat.i(11971);
            Field<Float, Float> field = new Field<>(3, false, 3, false, str, i2, null, null);
            AppMethodBeat.o(11971);
            return field;
        }

        public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String str) {
            AppMethodBeat.i(11996);
            Field<ArrayList<Float>, ArrayList<Float>> field = new Field<>(3, true, 3, true, str, -1, null, null);
            AppMethodBeat.o(11996);
            return field;
        }

        public static Field<ArrayList<Float>, ArrayList<Float>> forFloats(String str, int i2) {
            AppMethodBeat.i(11972);
            Field<ArrayList<Float>, ArrayList<Float>> field = new Field<>(3, true, 3, true, str, i2, null, null);
            AppMethodBeat.o(11972);
            return field;
        }

        public static Field<Integer, Integer> forInteger(String str) {
            AppMethodBeat.i(11989);
            Field<Integer, Integer> field = new Field<>(0, false, 0, false, str, -1, null, null);
            AppMethodBeat.o(11989);
            return field;
        }

        @VisibleForTesting
        public static Field<Integer, Integer> forInteger(String str, int i2) {
            AppMethodBeat.i(11965);
            Field<Integer, Integer> field = new Field<>(0, false, 0, false, str, i2, null, null);
            AppMethodBeat.o(11965);
            return field;
        }

        public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String str) {
            AppMethodBeat.i(11990);
            Field<ArrayList<Integer>, ArrayList<Integer>> field = new Field<>(0, true, 0, true, str, -1, null, null);
            AppMethodBeat.o(11990);
            return field;
        }

        @VisibleForTesting
        public static Field<ArrayList<Integer>, ArrayList<Integer>> forIntegers(String str, int i2) {
            AppMethodBeat.i(11966);
            Field<ArrayList<Integer>, ArrayList<Integer>> field = new Field<>(0, true, 0, true, str, i2, null, null);
            AppMethodBeat.o(11966);
            return field;
        }

        @VisibleForTesting
        public static Field<Long, Long> forLong(String str) {
            AppMethodBeat.i(11993);
            Field<Long, Long> field = new Field<>(2, false, 2, false, str, -1, null, null);
            AppMethodBeat.o(11993);
            return field;
        }

        public static Field<Long, Long> forLong(String str, int i2) {
            AppMethodBeat.i(11969);
            Field<Long, Long> field = new Field<>(2, false, 2, false, str, i2, null, null);
            AppMethodBeat.o(11969);
            return field;
        }

        @VisibleForTesting
        public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String str) {
            AppMethodBeat.i(11994);
            Field<ArrayList<Long>, ArrayList<Long>> field = new Field<>(2, true, 2, true, str, -1, null, null);
            AppMethodBeat.o(11994);
            return field;
        }

        public static Field<ArrayList<Long>, ArrayList<Long>> forLongs(String str, int i2) {
            AppMethodBeat.i(11970);
            Field<ArrayList<Long>, ArrayList<Long>> field = new Field<>(2, true, 2, true, str, i2, null, null);
            AppMethodBeat.o(11970);
            return field;
        }

        public static Field<String, String> forString(String str) {
            AppMethodBeat.i(12003);
            Field<String, String> field = new Field<>(7, false, 7, false, str, -1, null, null);
            AppMethodBeat.o(12003);
            return field;
        }

        public static Field<String, String> forString(String str, int i2) {
            AppMethodBeat.i(11979);
            Field<String, String> field = new Field<>(7, false, 7, false, str, i2, null, null);
            AppMethodBeat.o(11979);
            return field;
        }

        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String str) {
            AppMethodBeat.i(12007);
            Field<HashMap<String, String>, HashMap<String, String>> field = new Field<>(10, false, 10, false, str, -1, null, null);
            AppMethodBeat.o(12007);
            return field;
        }

        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String str, int i2) {
            AppMethodBeat.i(11983);
            Field<HashMap<String, String>, HashMap<String, String>> field = new Field<>(10, false, 10, false, str, i2, null, null);
            AppMethodBeat.o(11983);
            return field;
        }

        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str) {
            AppMethodBeat.i(12004);
            Field<ArrayList<String>, ArrayList<String>> field = new Field<>(7, true, 7, true, str, -1, null, null);
            AppMethodBeat.o(12004);
            return field;
        }

        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str, int i2) {
            AppMethodBeat.i(11980);
            Field<ArrayList<String>, ArrayList<String>> field = new Field<>(7, true, 7, true, str, i2, null, null);
            AppMethodBeat.o(11980);
            return field;
        }

        public static Field withConverter(String str, int i2, FieldConverter<?, ?> fieldConverter, boolean z) {
            AppMethodBeat.i(11988);
            Field field = new Field(fieldConverter.getTypeIn(), z, fieldConverter.getTypeOut(), false, str, i2, null, fieldConverter);
            AppMethodBeat.o(11988);
            return field;
        }

        public static <T extends FieldConverter> Field withConverter(String str, int i2, Class<T> cls, boolean z) {
            AppMethodBeat.i(11986);
            try {
                Field withConverter = withConverter(str, i2, cls.newInstance(), z);
                AppMethodBeat.o(11986);
                return withConverter;
            } catch (InstantiationException e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(11986);
                throw runtimeException;
            } catch (IllegalAccessException e3) {
                RuntimeException runtimeException2 = new RuntimeException(e3);
                AppMethodBeat.o(11986);
                throw runtimeException2;
            }
        }

        public static Field withConverter(String str, FieldConverter<?, ?> fieldConverter, boolean z) {
            AppMethodBeat.i(11987);
            Field withConverter = withConverter(str, -1, fieldConverter, z);
            AppMethodBeat.o(11987);
            return withConverter;
        }

        public static <T extends FieldConverter> Field withConverter(String str, Class<T> cls, boolean z) {
            AppMethodBeat.i(12010);
            Field withConverter = withConverter(str, -1, cls, z);
            AppMethodBeat.o(12010);
            return withConverter;
        }

        private final String zzcz() {
            if (this.mConcreteTypeName == null) {
                return null;
            }
            return this.mConcreteTypeName;
        }

        private final ConverterWrapper zzda() {
            AppMethodBeat.i(11960);
            if (this.zzwo == null) {
                AppMethodBeat.o(11960);
                return null;
            }
            ConverterWrapper wrap = ConverterWrapper.wrap(this.zzwo);
            AppMethodBeat.o(11960);
            return wrap;
        }

        public O convert(I i2) {
            AppMethodBeat.i(11963);
            O convert = this.zzwo.convert(i2);
            AppMethodBeat.o(11963);
            return convert;
        }

        public I convertBack(O o) {
            AppMethodBeat.i(11964);
            I convertBack = this.zzwo.convertBack(o);
            AppMethodBeat.o(11964);
            return convertBack;
        }

        public Field<I, O> copyForDictionary() {
            AppMethodBeat.i(11959);
            Field<I, O> field = new Field<>(this.zzal, this.mTypeIn, this.mTypeInArray, this.mTypeOut, this.mTypeOutArray, this.mOutputFieldName, this.mSafeParcelableFieldId, this.mConcreteTypeName, zzda());
            AppMethodBeat.o(11959);
            return field;
        }

        public Class<? extends FastJsonResponse> getConcreteType() {
            return this.mConcreteType;
        }

        public Map<String, Field<?, ?>> getConcreteTypeFieldMappingFromDictionary() {
            AppMethodBeat.i(11962);
            Preconditions.checkNotNull(this.mConcreteTypeName);
            Preconditions.checkNotNull(this.zzwn);
            Map<String, Field<?, ?>> fieldMapping = this.zzwn.getFieldMapping(this.mConcreteTypeName);
            AppMethodBeat.o(11962);
            return fieldMapping;
        }

        public String getOutputFieldName() {
            return this.mOutputFieldName;
        }

        public int getSafeParcelableFieldId() {
            return this.mSafeParcelableFieldId;
        }

        public int getTypeIn() {
            return this.mTypeIn;
        }

        public int getTypeOut() {
            return this.mTypeOut;
        }

        public int getVersionCode() {
            return this.zzal;
        }

        public boolean hasConverter() {
            return this.zzwo != null;
        }

        public boolean isTypeInArray() {
            return this.mTypeInArray;
        }

        public boolean isTypeOutArray() {
            return this.mTypeOutArray;
        }

        public boolean isValidSafeParcelableFieldId() {
            return this.mSafeParcelableFieldId != -1;
        }

        public FastJsonResponse newConcreteTypeInstance() {
            AppMethodBeat.i(11961);
            if (this.mConcreteType == SafeParcelResponse.class) {
                Preconditions.checkNotNull(this.zzwn, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
                SafeParcelResponse safeParcelResponse = new SafeParcelResponse(this.zzwn, this.mConcreteTypeName);
                AppMethodBeat.o(11961);
                return safeParcelResponse;
            }
            FastJsonResponse fastJsonResponse = (FastJsonResponse) this.mConcreteType.newInstance();
            AppMethodBeat.o(11961);
            return fastJsonResponse;
        }

        public void setFieldMappingDictionary(FieldMappingDictionary fieldMappingDictionary) {
            this.zzwn = fieldMappingDictionary;
        }

        public String toString() {
            AppMethodBeat.i(12012);
            Objects.ToStringHelper add = Objects.toStringHelper(this).add(AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE, Integer.valueOf(this.zzal)).add("typeIn", Integer.valueOf(this.mTypeIn)).add("typeInArray", Boolean.valueOf(this.mTypeInArray)).add("typeOut", Integer.valueOf(this.mTypeOut)).add("typeOutArray", Boolean.valueOf(this.mTypeOutArray)).add("outputFieldName", this.mOutputFieldName).add("safeParcelFieldId", Integer.valueOf(this.mSafeParcelableFieldId)).add("concreteTypeName", zzcz());
            Class<? extends FastJsonResponse> concreteType = getConcreteType();
            if (concreteType != null) {
                add.add("concreteType.class", concreteType.getCanonicalName());
            }
            if (this.zzwo != null) {
                add.add("converterName", this.zzwo.getClass().getCanonicalName());
            }
            String toStringHelper = add.toString();
            AppMethodBeat.o(12012);
            return toStringHelper;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(12011);
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, getVersionCode());
            SafeParcelWriter.writeInt(parcel, 2, getTypeIn());
            SafeParcelWriter.writeBoolean(parcel, 3, isTypeInArray());
            SafeParcelWriter.writeInt(parcel, 4, getTypeOut());
            SafeParcelWriter.writeBoolean(parcel, 5, isTypeOutArray());
            SafeParcelWriter.writeString(parcel, 6, getOutputFieldName(), false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, zzcz(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, zzda(), i2, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            AppMethodBeat.o(12011);
        }
    }

    public interface FieldConverter<I, O> {
        O convert(I i2);

        I convertBack(O o);

        int getTypeIn();

        int getTypeOut();
    }

    public interface FieldType {
        public static final int BASE64 = 8;
        public static final int BASE64_URL_SAFE = 9;
        public static final int BIG_DECIMAL = 5;
        public static final int BIG_INTEGER = 1;
        public static final int BOOLEAN = 6;
        public static final int CONCRETE_TYPE = 11;
        public static final int DOUBLE = 4;
        public static final int FLOAT = 3;
        public static final int INT = 0;
        public static final int LONG = 2;
        public static final int STRING = 7;
        public static final int STRING_MAP = 10;
    }

    public static InputStream getUnzippedStream(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (IOUtils.isGzipByteBuffer(bArr)) {
            try {
                return new GZIPInputStream(byteArrayInputStream);
            } catch (IOException e2) {
            }
        }
        return byteArrayInputStream;
    }

    private final <I, O> void zza(Field<I, O> field, I i2) {
        String outputFieldName = field.getOutputFieldName();
        O convert = field.convert(i2);
        switch (field.getTypeOut()) {
            case 0:
                if (zzb(outputFieldName, convert)) {
                    setIntegerInternal(field, outputFieldName, convert.intValue());
                    return;
                }
                return;
            case 1:
                setBigIntegerInternal(field, outputFieldName, convert);
                return;
            case 2:
                if (zzb(outputFieldName, convert)) {
                    setLongInternal(field, outputFieldName, convert.longValue());
                    return;
                }
                return;
            case 3:
            default:
                throw new IllegalStateException(new StringBuilder(44).append("Unsupported type for conversion: ").append(field.getTypeOut()).toString());
            case 4:
                if (zzb(outputFieldName, convert)) {
                    setDoubleInternal(field, outputFieldName, convert.doubleValue());
                    return;
                }
                return;
            case 5:
                setBigDecimalInternal(field, outputFieldName, convert);
                return;
            case 6:
                if (zzb(outputFieldName, convert)) {
                    setBooleanInternal(field, outputFieldName, convert.booleanValue());
                    return;
                }
                return;
            case 7:
                setStringInternal(field, outputFieldName, convert);
                return;
            case 8:
            case 9:
                if (zzb(outputFieldName, convert)) {
                    setDecodedBytesInternal(field, outputFieldName, (byte[]) convert);
                    return;
                }
                return;
        }
    }

    private static void zza(StringBuilder sb, Field field, Object obj) {
        if (field.getTypeIn() == 11) {
            sb.append(((FastJsonResponse) field.getConcreteType().cast(obj)).toString());
        } else if (field.getTypeIn() == 7) {
            sb.append(QUOTE);
            sb.append(JsonUtils.escapeString((String) obj));
            sb.append(QUOTE);
        } else {
            sb.append(obj);
        }
    }

    private static <O> boolean zzb(String str, O o) {
        if (o != null) {
            return true;
        }
        if (Log.isLoggable("FastJsonResponse", 6)) {
            new StringBuilder(String.valueOf(str).length() + 58).append("Output field (").append(str).append(") has a null value, but expected a primitive");
        }
        return false;
    }

    public <T extends FastJsonResponse> void addConcreteType(String str, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeArray(String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> field, String str, ArrayList<T> arrayList) {
        addConcreteTypeArray(str, arrayList);
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> field, String str, T t) {
        addConcreteType(str, t);
    }

    public HashMap<String, Object> getConcreteTypeArrays() {
        return null;
    }

    public HashMap<String, Object> getConcreteTypes() {
        return null;
    }

    public abstract Map<String, Field<?, ?>> getFieldMappings();

    /* access modifiers changed from: protected */
    public Object getFieldValue(Field field) {
        String outputFieldName = field.getOutputFieldName();
        if (field.getConcreteType() == null) {
            return getValueObject(field.getOutputFieldName());
        }
        Preconditions.checkState(getValueObject(field.getOutputFieldName()) == null, "Concrete field shouldn't be value object: %s", field.getOutputFieldName());
        HashMap<String, Object> concreteTypeArrays = field.isTypeOutArray() ? getConcreteTypeArrays() : getConcreteTypes();
        if (concreteTypeArrays != null) {
            return concreteTypeArrays.get(outputFieldName);
        }
        try {
            char upperCase = Character.toUpperCase(outputFieldName.charAt(0));
            String substring = outputFieldName.substring(1);
            return getClass().getMethod(new StringBuilder(String.valueOf(substring).length() + 4).append("get").append(upperCase).append(substring).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public <O, I> I getOriginalValue(Field<I, O> field, Object obj) {
        return ((Field) field).zzwo != null ? field.convertBack(obj) : obj;
    }

    public PostProcessor<? extends FastJsonResponse> getPostProcessor() {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f A[SYNTHETIC, Splitter:B:13:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045 A[SYNTHETIC, Splitter:B:23:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getResponseBody() {
        /*
            r5 = this;
            boolean r0 = r5.zzwm
            com.google.android.gms.common.internal.Preconditions.checkState(r0)
            r0 = 0
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0051, all -> 0x0040 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0051, all -> 0x0040 }
            byte[] r3 = r5.zzwl     // Catch:{ IOException -> 0x0051, all -> 0x0040 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0051, all -> 0x0040 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0051, all -> 0x0040 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x002a }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x002a }
            r2.<init>()     // Catch:{ IOException -> 0x002a }
        L_0x001b:
            r3 = 0
            r4 = 4096(0x1000, float:5.74E-42)
            int r3 = r1.read(r0, r3, r4)     // Catch:{ IOException -> 0x002a }
            r4 = -1
            if (r3 == r4) goto L_0x0033
            r4 = 0
            r2.write(r0, r4, r3)     // Catch:{ IOException -> 0x002a }
            goto L_0x001b
        L_0x002a:
            r0 = move-exception
        L_0x002b:
            byte[] r0 = r5.zzwl     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0032:
            return r0
        L_0x0033:
            r2.flush()
            byte[] r0 = r2.toByteArray()
            r1.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0032
        L_0x003e:
            r1 = move-exception
            goto L_0x0032
        L_0x0040:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x0043:
            if (r3 == 0) goto L_0x0048
            r3.close()     // Catch:{ IOException -> 0x004b }
        L_0x0048:
            throw r2
        L_0x0049:
            r1 = move-exception
            goto L_0x0032
        L_0x004b:
            r0 = move-exception
            goto L_0x0048
        L_0x004d:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0043
        L_0x0051:
            r1 = move-exception
            r1 = r0
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastJsonResponse.getResponseBody():byte[]");
    }

    public int getResponseCode() {
        Preconditions.checkState(this.zzwm);
        return this.zzwk;
    }

    /* access modifiers changed from: protected */
    public abstract Object getValueObject(String str);

    /* access modifiers changed from: protected */
    public boolean isConcreteTypeArrayFieldSet(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    /* access modifiers changed from: protected */
    public boolean isConcreteTypeFieldSet(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSet(Field field) {
        return field.getTypeOut() == 11 ? field.isTypeOutArray() ? isConcreteTypeArrayFieldSet(field.getOutputFieldName()) : isConcreteTypeFieldSet(field.getOutputFieldName()) : isPrimitiveFieldSet(field.getOutputFieldName());
    }

    /* access modifiers changed from: protected */
    public abstract boolean isPrimitiveFieldSet(String str);

    public <T extends FastJsonResponse> void parseNetworkResponse(int i2, byte[] bArr) {
        this.zzwk = i2;
        this.zzwl = bArr;
        this.zzwm = true;
        InputStream unzippedStream = getUnzippedStream(bArr);
        try {
            new FastParser().parse(unzippedStream, this);
        } finally {
            try {
                unzippedStream.close();
            } catch (IOException e2) {
            }
        }
    }

    public final <O> void setBigDecimal(Field<BigDecimal, O> field, BigDecimal bigDecimal) {
        if (((Field) field).zzwo != null) {
            zza(field, bigDecimal);
        } else {
            setBigDecimalInternal(field, field.getOutputFieldName(), bigDecimal);
        }
    }

    /* access modifiers changed from: protected */
    public void setBigDecimal(String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    /* access modifiers changed from: protected */
    public void setBigDecimalInternal(Field<?, ?> field, String str, BigDecimal bigDecimal) {
        setBigDecimal(str, bigDecimal);
    }

    public final <O> void setBigDecimals(Field<ArrayList<BigDecimal>, O> field, ArrayList<BigDecimal> arrayList) {
        if (((Field) field).zzwo != null) {
            zza(field, arrayList);
        } else {
            setBigDecimalsInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void setBigDecimals(String str, ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    /* access modifiers changed from: protected */
    public void setBigDecimalsInternal(Field<?, ?> field, String str, ArrayList<BigDecimal> arrayList) {
        setBigDecimals(str, arrayList);
    }

    public final <O> void setBigInteger(Field<BigInteger, O> field, BigInteger bigInteger) {
        if (((Field) field).zzwo != null) {
            zza(field, bigInteger);
        } else {
            setBigIntegerInternal(field, field.getOutputFieldName(), bigInteger);
        }
    }

    /* access modifiers changed from: protected */
    public void setBigInteger(String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    /* access modifiers changed from: protected */
    public void setBigIntegerInternal(Field<?, ?> field, String str, BigInteger bigInteger) {
        setBigInteger(str, bigInteger);
    }

    public final <O> void setBigIntegers(Field<ArrayList<BigInteger>, O> field, ArrayList<BigInteger> arrayList) {
        if (((Field) field).zzwo != null) {
            zza(field, arrayList);
        } else {
            setBigIntegersInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void setBigIntegers(String str, ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    /* access modifiers changed from: protected */
    public void setBigIntegersInternal(Field<?, ?> field, String str, ArrayList<BigInteger> arrayList) {
        setBigIntegers(str, arrayList);
    }

    public final <O> void setBoolean(Field<Boolean, O> field, boolean z) {
        if (((Field) field).zzwo != null) {
            zza(field, Boolean.valueOf(z));
        } else {
            setBooleanInternal(field, field.getOutputFieldName(), z);
        }
    }

    /* access modifiers changed from: protected */
    public void setBoolean(String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    /* access modifiers changed from: protected */
    public void setBooleanInternal(Field<?, ?> field, String str, boolean z) {
        setBoolean(str, z);
    }

    public final <O> void setBooleans(Field<ArrayList<Boolean>, O> field, ArrayList<Boolean> arrayList) {
        if (((Field) field).zzwo != null) {
            zza(field, arrayList);
        } else {
            setBooleansInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void setBooleans(String str, ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    /* access modifiers changed from: protected */
    public void setBooleansInternal(Field<?, ?> field, String str, ArrayList<Boolean> arrayList) {
        setBooleans(str, arrayList);
    }

    public final <O> void setDecodedBytes(Field<byte[], O> field, byte[] bArr) {
        if (((Field) field).zzwo != null) {
            zza(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.getOutputFieldName(), bArr);
        }
    }

    /* access modifiers changed from: protected */
    public void setDecodedBytes(String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    /* access modifiers changed from: protected */
    public void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        setDecodedBytes(str, bArr);
    }

    public final <O> void setDouble(Field<Double, O> field, double d2) {
        if (((Field) field).zzwo != null) {
            zza(field, Double.valueOf(d2));
        } else {
            setDoubleInternal(field, field.getOutputFieldName(), d2);
        }
    }

    /* access modifiers changed from: protected */
    public void setDouble(String str, double d2) {
        throw new UnsupportedOperationException("Double not supported");
    }

    /* access modifiers changed from: protected */
    public void setDoubleInternal(Field<?, ?> field, String str, double d2) {
        setDouble(str, d2);
    }

    public final <O> void setDoubles(Field<ArrayList<Double>, O> field, ArrayList<Double> arrayList) {
        if (((Field) field).zzwo != null) {
            zza(field, arrayList);
        } else {
            setDoublesInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void setDoubles(String str, ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    /* access modifiers changed from: protected */
    public void setDoublesInternal(Field<?, ?> field, String str, ArrayList<Double> arrayList) {
        setDoubles(str, arrayList);
    }

    public final <O> void setFloat(Field<Float, O> field, float f2) {
        if (((Field) field).zzwo != null) {
            zza(field, Float.valueOf(f2));
        } else {
            setFloatInternal(field, field.getOutputFieldName(), f2);
        }
    }

    /* access modifiers changed from: protected */
    public void setFloat(String str, float f2) {
        throw new UnsupportedOperationException("Float not supported");
    }

    /* access modifiers changed from: protected */
    public void setFloatInternal(Field<?, ?> field, String str, float f2) {
        setFloat(str, f2);
    }

    public final <O> void setFloats(Field<ArrayList<Float>, O> field, ArrayList<Float> arrayList) {
        if (((Field) field).zzwo != null) {
            zza(field, arrayList);
        } else {
            setFloatsInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void setFloats(String str, ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    /* access modifiers changed from: protected */
    public void setFloatsInternal(Field<?, ?> field, String str, ArrayList<Float> arrayList) {
        setFloats(str, arrayList);
    }

    public final <O> void setInteger(Field<Integer, O> field, int i2) {
        if (((Field) field).zzwo != null) {
            zza(field, Integer.valueOf(i2));
        } else {
            setIntegerInternal(field, field.getOutputFieldName(), i2);
        }
    }

    /* access modifiers changed from: protected */
    public void setInteger(String str, int i2) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    /* access modifiers changed from: protected */
    public void setIntegerInternal(Field<?, ?> field, String str, int i2) {
        setInteger(str, i2);
    }

    public final <O> void setIntegers(Field<ArrayList<Integer>, O> field, ArrayList<Integer> arrayList) {
        if (((Field) field).zzwo != null) {
            zza(field, arrayList);
        } else {
            setIntegersInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void setIntegers(String str, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    /* access modifiers changed from: protected */
    public void setIntegersInternal(Field<?, ?> field, String str, ArrayList<Integer> arrayList) {
        setIntegers(str, arrayList);
    }

    public final <O> void setLong(Field<Long, O> field, long j2) {
        if (((Field) field).zzwo != null) {
            zza(field, Long.valueOf(j2));
        } else {
            setLongInternal(field, field.getOutputFieldName(), j2);
        }
    }

    /* access modifiers changed from: protected */
    public void setLong(String str, long j2) {
        throw new UnsupportedOperationException("Long not supported");
    }

    /* access modifiers changed from: protected */
    public void setLongInternal(Field<?, ?> field, String str, long j2) {
        setLong(str, j2);
    }

    public final <O> void setLongs(Field<ArrayList<Long>, O> field, ArrayList<Long> arrayList) {
        if (((Field) field).zzwo != null) {
            zza(field, arrayList);
        } else {
            setLongsInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void setLongs(String str, ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    /* access modifiers changed from: protected */
    public void setLongsInternal(Field<?, ?> field, String str, ArrayList<Long> arrayList) {
        setLongs(str, arrayList);
    }

    public final <O> void setString(Field<String, O> field, String str) {
        if (((Field) field).zzwo != null) {
            zza(field, str);
        } else {
            setStringInternal(field, field.getOutputFieldName(), str);
        }
    }

    /* access modifiers changed from: protected */
    public void setString(String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    /* access modifiers changed from: protected */
    public void setStringInternal(Field<?, ?> field, String str, String str2) {
        setString(str, str2);
    }

    public final <O> void setStringMap(Field<Map<String, String>, O> field, Map<String, String> map) {
        if (((Field) field).zzwo != null) {
            zza(field, map);
        } else {
            setStringMapInternal(field, field.getOutputFieldName(), map);
        }
    }

    /* access modifiers changed from: protected */
    public void setStringMap(String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    /* access modifiers changed from: protected */
    public void setStringMapInternal(Field<?, ?> field, String str, Map<String, String> map) {
        setStringMap(str, map);
    }

    public final <O> void setStrings(Field<ArrayList<String>, O> field, ArrayList<String> arrayList) {
        if (((Field) field).zzwo != null) {
            zza(field, arrayList);
        } else {
            setStringsInternal(field, field.getOutputFieldName(), arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void setStrings(String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    /* access modifiers changed from: protected */
    public void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        setStrings(str, arrayList);
    }

    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object originalValue = getOriginalValue(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append(QUOTE).append(str).append("\":");
                if (originalValue != null) {
                    switch (field.getTypeOut()) {
                        case 8:
                            sb.append(QUOTE).append(Base64Utils.encode((byte[]) originalValue)).append(QUOTE);
                            continue;
                        case 9:
                            sb.append(QUOTE).append(Base64Utils.encodeUrlSafe((byte[]) originalValue)).append(QUOTE);
                            continue;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) originalValue);
                            continue;
                        default:
                            if (!field.isTypeInArray()) {
                                zza(sb, field, originalValue);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) originalValue;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    if (i2 > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i2);
                                    if (obj != null) {
                                        zza(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                continue;
                            }
                    }
                } else {
                    sb.append(BuildConfig.COMMAND);
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
