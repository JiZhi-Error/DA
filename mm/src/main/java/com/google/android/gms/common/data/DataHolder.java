package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.sqlite.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@KeepName
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder zznt = new zza(new String[0], null);
    private boolean mClosed;
    @SafeParcelable.VersionField(id = 1000)
    private final int zzal;
    @SafeParcelable.Field(getter = "getStatusCode", id = 3)
    private final int zzam;
    @SafeParcelable.Field(getter = "getColumns", id = 1)
    private final String[] zznm;
    private Bundle zznn;
    @SafeParcelable.Field(getter = "getWindows", id = 2)
    private final CursorWindow[] zzno;
    @SafeParcelable.Field(getter = "getMetadata", id = 4)
    private final Bundle zznp;
    private int[] zznq;
    private int zznr;
    private boolean zzns;

    public static class Builder {
        private final String[] zznm;
        private final ArrayList<HashMap<String, Object>> zznu;
        private final String zznv;
        private final HashMap<Object, Integer> zznw;
        private boolean zznx;
        private String zzny;

        private Builder(String[] strArr, String str) {
            AppMethodBeat.i(11565);
            this.zznm = (String[]) Preconditions.checkNotNull(strArr);
            this.zznu = new ArrayList<>();
            this.zznv = str;
            this.zznw = new HashMap<>();
            this.zznx = false;
            this.zzny = null;
            AppMethodBeat.o(11565);
        }

        /* synthetic */ Builder(String[] strArr, String str, zza zza) {
            this(strArr, str);
        }

        private final boolean zzg(String str) {
            AppMethodBeat.i(11573);
            Asserts.checkNotNull(str);
            if (!this.zznx || !str.equals(this.zzny)) {
                AppMethodBeat.o(11573);
                return false;
            }
            AppMethodBeat.o(11573);
            return true;
        }

        public DataHolder build(int i2) {
            AppMethodBeat.i(11575);
            DataHolder dataHolder = new DataHolder(this, i2, (Bundle) null, (zza) null);
            AppMethodBeat.o(11575);
            return dataHolder;
        }

        public DataHolder build(int i2, Bundle bundle) {
            AppMethodBeat.i(11576);
            DataHolder dataHolder = new DataHolder(this, i2, bundle, -1, (zza) null);
            AppMethodBeat.o(11576);
            return dataHolder;
        }

        public DataHolder build(int i2, Bundle bundle, int i3) {
            AppMethodBeat.i(11577);
            DataHolder dataHolder = new DataHolder(this, i2, bundle, i3, (zza) null);
            AppMethodBeat.o(11577);
            return dataHolder;
        }

        public boolean containsRowWithValue(String str, Object obj) {
            AppMethodBeat.i(11569);
            int size = this.zznu.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (Objects.equal(this.zznu.get(i2).get(str), obj)) {
                    AppMethodBeat.o(11569);
                    return true;
                }
            }
            AppMethodBeat.o(11569);
            return false;
        }

        public Builder descendingSort(String str) {
            AppMethodBeat.i(11572);
            if (zzg(str)) {
                AppMethodBeat.o(11572);
            } else {
                sort(str);
                Collections.reverse(this.zznu);
                AppMethodBeat.o(11572);
            }
            return this;
        }

        public int getCount() {
            AppMethodBeat.i(11574);
            int size = this.zznu.size();
            AppMethodBeat.o(11574);
            return size;
        }

        public void modifyUniqueRowValue(Object obj, String str, Object obj2) {
            AppMethodBeat.i(11567);
            if (this.zznv == null) {
                AppMethodBeat.o(11567);
                return;
            }
            Integer num = this.zznw.get(obj);
            if (num == null) {
                AppMethodBeat.o(11567);
                return;
            }
            this.zznu.get(num.intValue()).put(str, obj2);
            AppMethodBeat.o(11567);
        }

        public Builder removeRowsWithValue(String str, Object obj) {
            AppMethodBeat.i(11570);
            for (int size = this.zznu.size() - 1; size >= 0; size--) {
                if (Objects.equal(this.zznu.get(size).get(str), obj)) {
                    this.zznu.remove(size);
                }
            }
            AppMethodBeat.o(11570);
            return this;
        }

        public Builder sort(String str) {
            AppMethodBeat.i(11571);
            if (zzg(str)) {
                AppMethodBeat.o(11571);
            } else {
                Collections.sort(this.zznu, new zza(str));
                if (this.zznv != null) {
                    this.zznw.clear();
                    int size = this.zznu.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Object obj = this.zznu.get(i2).get(this.zznv);
                        if (obj != null) {
                            this.zznw.put(obj, Integer.valueOf(i2));
                        }
                    }
                }
                this.zznx = true;
                this.zzny = str;
                AppMethodBeat.o(11571);
            }
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            AppMethodBeat.i(11568);
            Asserts.checkNotNull(contentValues);
            HashMap<String, Object> hashMap = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            Builder withRow = withRow(hashMap);
            AppMethodBeat.o(11568);
            return withRow;
        }

        public Builder withRow(HashMap<String, Object> hashMap) {
            int intValue;
            AppMethodBeat.i(11566);
            Asserts.checkNotNull(hashMap);
            if (this.zznv == null) {
                intValue = -1;
            } else {
                Object obj = hashMap.get(this.zznv);
                if (obj == null) {
                    intValue = -1;
                } else {
                    Integer num = this.zznw.get(obj);
                    if (num == null) {
                        this.zznw.put(obj, Integer.valueOf(this.zznu.size()));
                        intValue = -1;
                    } else {
                        intValue = num.intValue();
                    }
                }
            }
            if (intValue == -1) {
                this.zznu.add(hashMap);
            } else {
                this.zznu.remove(intValue);
                this.zznu.add(intValue, hashMap);
            }
            this.zznx = false;
            AppMethodBeat.o(11566);
            return this;
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zza implements Comparator<HashMap<String, Object>> {
        private final String zznz;

        zza(String str) {
            AppMethodBeat.i(11578);
            this.zznz = (String) Preconditions.checkNotNull(str);
            AppMethodBeat.o(11578);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
            AppMethodBeat.i(11579);
            Object checkNotNull = Preconditions.checkNotNull(hashMap.get(this.zznz));
            Object checkNotNull2 = Preconditions.checkNotNull(hashMap2.get(this.zznz));
            if (checkNotNull.equals(checkNotNull2)) {
                AppMethodBeat.o(11579);
                return 0;
            } else if (checkNotNull instanceof Boolean) {
                int compareTo = ((Boolean) checkNotNull).compareTo((Boolean) checkNotNull2);
                AppMethodBeat.o(11579);
                return compareTo;
            } else if (checkNotNull instanceof Long) {
                int compareTo2 = ((Long) checkNotNull).compareTo((Long) checkNotNull2);
                AppMethodBeat.o(11579);
                return compareTo2;
            } else if (checkNotNull instanceof Integer) {
                int compareTo3 = ((Integer) checkNotNull).compareTo((Integer) checkNotNull2);
                AppMethodBeat.o(11579);
                return compareTo3;
            } else if (checkNotNull instanceof String) {
                int compareTo4 = ((String) checkNotNull).compareTo((String) checkNotNull2);
                AppMethodBeat.o(11579);
                return compareTo4;
            } else if (checkNotNull instanceof Double) {
                int compareTo5 = ((Double) checkNotNull).compareTo((Double) checkNotNull2);
                AppMethodBeat.o(11579);
                return compareTo5;
            } else if (checkNotNull instanceof Float) {
                int compareTo6 = ((Float) checkNotNull).compareTo((Float) checkNotNull2);
                AppMethodBeat.o(11579);
                return compareTo6;
            } else {
                String valueOf = String.valueOf(checkNotNull);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown type for lValue ").append(valueOf).toString());
                AppMethodBeat.o(11579);
                throw illegalArgumentException;
            }
        }
    }

    static {
        AppMethodBeat.i(11614);
        AppMethodBeat.o(11614);
    }

    @SafeParcelable.Constructor
    DataHolder(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.mClosed = false;
        this.zzns = true;
        this.zzal = i2;
        this.zznm = strArr;
        this.zzno = cursorWindowArr;
        this.zzam = i3;
        this.zznp = bundle;
    }

    public DataHolder(Cursor cursor, int i2, Bundle bundle) {
        this(new CursorWrapper(cursor), i2, bundle);
        AppMethodBeat.i(11582);
        AppMethodBeat.o(11582);
    }

    private DataHolder(Builder builder, int i2, Bundle bundle) {
        this(builder.zznm, zza(builder, -1), i2, bundle);
        AppMethodBeat.i(11583);
        AppMethodBeat.o(11583);
    }

    private DataHolder(Builder builder, int i2, Bundle bundle, int i3) {
        this(builder.zznm, zza(builder, i3), i2, bundle);
        AppMethodBeat.i(11584);
        AppMethodBeat.o(11584);
    }

    /* synthetic */ DataHolder(Builder builder, int i2, Bundle bundle, int i3, zza zza2) {
        this(builder, i2, bundle, i3);
    }

    /* synthetic */ DataHolder(Builder builder, int i2, Bundle bundle, zza zza2) {
        this(builder, i2, (Bundle) null);
    }

    public DataHolder(CursorWrapper cursorWrapper, int i2, Bundle bundle) {
        this(cursorWrapper.getColumnNames(), zza(cursorWrapper), i2, bundle);
        AppMethodBeat.i(11581);
        AppMethodBeat.o(11581);
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        AppMethodBeat.i(11580);
        this.mClosed = false;
        this.zzns = true;
        this.zzal = 1;
        this.zznm = (String[]) Preconditions.checkNotNull(strArr);
        this.zzno = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zzam = i2;
        this.zznp = bundle;
        validateContents();
        AppMethodBeat.o(11580);
    }

    public static Builder builder(String[] strArr) {
        AppMethodBeat.i(11610);
        Builder builder = new Builder(strArr, null, null);
        AppMethodBeat.o(11610);
        return builder;
    }

    public static Builder builder(String[] strArr, String str) {
        AppMethodBeat.i(11611);
        Preconditions.checkNotNull(str);
        Builder builder = new Builder(strArr, str, null);
        AppMethodBeat.o(11611);
        return builder;
    }

    public static DataHolder empty(int i2) {
        AppMethodBeat.i(11612);
        DataHolder empty = empty(i2, null);
        AppMethodBeat.o(11612);
        return empty;
    }

    public static DataHolder empty(int i2, Bundle bundle) {
        AppMethodBeat.i(11613);
        DataHolder dataHolder = new DataHolder(zznt, i2, bundle);
        AppMethodBeat.o(11613);
        return dataHolder;
    }

    private final void zza(String str, int i2) {
        AppMethodBeat.i(11590);
        if (this.zznn == null || !this.zznn.containsKey(str)) {
            String valueOf = String.valueOf(str);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
            AppMethodBeat.o(11590);
            throw illegalArgumentException;
        } else if (isClosed()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Buffer is closed.");
            AppMethodBeat.o(11590);
            throw illegalArgumentException2;
        } else if (i2 < 0 || i2 >= this.zznr) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException(i2, this.zznr);
            AppMethodBeat.o(11590);
            throw cursorIndexOutOfBoundsException;
        } else {
            AppMethodBeat.o(11590);
        }
    }

    private static CursorWindow[] zza(Builder builder, int i2) {
        int i3;
        boolean z;
        AppMethodBeat.i(11589);
        if (builder.zznm.length == 0) {
            CursorWindow[] cursorWindowArr = new CursorWindow[0];
            AppMethodBeat.o(11589);
            return cursorWindowArr;
        }
        ArrayList subList = (i2 < 0 || i2 >= builder.zznu.size()) ? builder.zznu : builder.zznu.subList(0, i2);
        int size = subList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.zznm.length);
        int i4 = 0;
        boolean z2 = false;
        while (i4 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    new StringBuilder(72).append("Allocating additional cursor window for large data set (row ").append(i4).append(")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i4);
                    cursorWindow.setNumColumns(builder.zznm.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        arrayList.remove(cursorWindow);
                        CursorWindow[] cursorWindowArr2 = (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                        AppMethodBeat.o(11589);
                        return cursorWindowArr2;
                    }
                }
                Map map = (Map) subList.get(i4);
                boolean z3 = true;
                for (int i5 = 0; i5 < builder.zznm.length && z3; i5++) {
                    String str = builder.zznm[i5];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z3 = cursorWindow.putNull(i4, i5);
                    } else if (obj instanceof String) {
                        z3 = cursorWindow.putString((String) obj, i4, i5);
                    } else if (obj instanceof Long) {
                        z3 = cursorWindow.putLong(((Long) obj).longValue(), i4, i5);
                    } else if (obj instanceof Integer) {
                        z3 = cursorWindow.putLong((long) ((Integer) obj).intValue(), i4, i5);
                    } else if (obj instanceof Boolean) {
                        z3 = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i4, i5);
                    } else if (obj instanceof byte[]) {
                        z3 = cursorWindow.putBlob((byte[]) obj, i4, i5);
                    } else if (obj instanceof Double) {
                        z3 = cursorWindow.putDouble(((Double) obj).doubleValue(), i4, i5);
                    } else if (obj instanceof Float) {
                        z3 = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i4, i5);
                    } else {
                        String valueOf = String.valueOf(obj);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(valueOf).length()).append("Unsupported object for column ").append(str).append(": ").append(valueOf).toString());
                        AppMethodBeat.o(11589);
                        throw illegalArgumentException;
                    }
                }
                if (z3) {
                    i3 = i4;
                    z = false;
                } else if (z2) {
                    DataHolderException dataHolderException = new DataHolderException("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    AppMethodBeat.o(11589);
                    throw dataHolderException;
                } else {
                    new StringBuilder(74).append("Couldn't populate window data for row ").append(i4).append(" - allocating new window.");
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i4);
                    cursorWindow.setNumColumns(builder.zznm.length);
                    arrayList.add(cursorWindow);
                    i3 = i4 - 1;
                    z = true;
                }
                i4 = i3 + 1;
                z2 = z;
            } catch (RuntimeException e2) {
                int size2 = arrayList.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    ((CursorWindow) arrayList.get(i6)).close();
                }
                AppMethodBeat.o(11589);
                throw e2;
            }
        }
        CursorWindow[] cursorWindowArr3 = (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        AppMethodBeat.o(11589);
        return cursorWindowArr3;
    }

    private static CursorWindow[] zza(CursorWrapper cursorWrapper) {
        int i2;
        AppMethodBeat.i(11588);
        ArrayList arrayList = new ArrayList();
        try {
            int count = cursorWrapper.getCount();
            CursorWindow window = cursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i2 = 0;
            } else {
                window.acquireReference();
                cursorWrapper.setWindow(null);
                arrayList.add(window);
                i2 = window.getNumRows();
            }
            while (i2 < count && cursorWrapper.moveToPosition(i2)) {
                CursorWindow window2 = cursorWrapper.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    cursorWrapper.setWindow(null);
                } else {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(i2);
                    cursorWrapper.fillWindow(i2, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                i2 = window2.getNumRows() + window2.getStartPosition();
            }
            cursorWrapper.close();
            CursorWindow[] cursorWindowArr = (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
            AppMethodBeat.o(11588);
            return cursorWindowArr;
        } catch (Throwable th) {
            cursorWrapper.close();
            AppMethodBeat.o(11588);
            throw th;
        }
    }

    public final void clearColumn(String str, int i2, int i3) {
        AppMethodBeat.i(11602);
        zza(str, i2);
        this.zzno[i3].putNull(i2, this.zznn.getInt(str));
        AppMethodBeat.o(11602);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(11608);
        synchronized (this) {
            try {
                if (!this.mClosed) {
                    this.mClosed = true;
                    for (int i2 = 0; i2 < this.zzno.length; i2++) {
                        this.zzno[i2].close();
                    }
                }
            } finally {
                AppMethodBeat.o(11608);
            }
        }
    }

    public final void copyToBuffer(String str, int i2, int i3, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(11600);
        zza(str, i2);
        this.zzno[i3].copyStringToBuffer(i2, this.zznn.getInt(str), charArrayBuffer);
        AppMethodBeat.o(11600);
    }

    public final void disableLeakDetection() {
        this.zzns = false;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(11609);
        try {
            if (this.zzns && this.zzno.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                new StringBuilder(String.valueOf(obj).length() + 178).append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ").append(obj).append(")");
            }
        } finally {
            super.finalize();
            AppMethodBeat.o(11609);
        }
    }

    public final boolean getBoolean(String str, int i2, int i3) {
        AppMethodBeat.i(11595);
        zza(str, i2);
        if (this.zzno[i3].getLong(i2, this.zznn.getInt(str)) == 1) {
            AppMethodBeat.o(11595);
            return true;
        }
        AppMethodBeat.o(11595);
        return false;
    }

    public final byte[] getByteArray(String str, int i2, int i3) {
        AppMethodBeat.i(11598);
        zza(str, i2);
        byte[] blob = this.zzno[i3].getBlob(i2, this.zznn.getInt(str));
        AppMethodBeat.o(11598);
        return blob;
    }

    public final int getCount() {
        return this.zznr;
    }

    public final double getDouble(String str, int i2, int i3) {
        AppMethodBeat.i(11597);
        zza(str, i2);
        double d2 = this.zzno[i3].getDouble(i2, this.zznn.getInt(str));
        AppMethodBeat.o(11597);
        return d2;
    }

    public final float getFloat(String str, int i2, int i3) {
        AppMethodBeat.i(11596);
        zza(str, i2);
        float f2 = this.zzno[i3].getFloat(i2, this.zznn.getInt(str));
        AppMethodBeat.o(11596);
        return f2;
    }

    public final int getInteger(String str, int i2, int i3) {
        AppMethodBeat.i(11593);
        zza(str, i2);
        int i4 = this.zzno[i3].getInt(i2, this.zznn.getInt(str));
        AppMethodBeat.o(11593);
        return i4;
    }

    public final long getLong(String str, int i2, int i3) {
        AppMethodBeat.i(11592);
        zza(str, i2);
        long j2 = this.zzno[i3].getLong(i2, this.zznn.getInt(str));
        AppMethodBeat.o(11592);
        return j2;
    }

    public final Bundle getMetadata() {
        return this.zznp;
    }

    public final int getStatusCode() {
        return this.zzam;
    }

    public final String getString(String str, int i2, int i3) {
        AppMethodBeat.i(11594);
        zza(str, i2);
        String string = this.zzno[i3].getString(i2, this.zznn.getInt(str));
        AppMethodBeat.o(11594);
        return string;
    }

    public final int getWindowIndex(int i2) {
        int i3 = 0;
        AppMethodBeat.i(11607);
        Preconditions.checkState(i2 >= 0 && i2 < this.zznr);
        while (true) {
            if (i3 >= this.zznq.length) {
                break;
            } else if (i2 < this.zznq[i3]) {
                i3--;
                break;
            } else {
                i3++;
            }
        }
        if (i3 == this.zznq.length) {
            i3--;
        }
        AppMethodBeat.o(11607);
        return i3;
    }

    public final boolean hasColumn(String str) {
        AppMethodBeat.i(11591);
        boolean containsKey = this.zznn.containsKey(str);
        AppMethodBeat.o(11591);
        return containsKey;
    }

    public final boolean hasNull(String str, int i2, int i3) {
        AppMethodBeat.i(11601);
        zza(str, i2);
        boolean isNull = this.zzno[i3].isNull(i2, this.zznn.getInt(str));
        AppMethodBeat.o(11601);
        return isNull;
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public final void logCursorMetadataForDebugging() {
        AppMethodBeat.i(11587);
        new StringBuilder(32).append("num cursor windows : ").append(this.zzno.length);
        new StringBuilder(46).append("total number of objects in holder: ").append(this.zznr);
        new StringBuilder(42).append("total mumber of windowOffsets: ").append(this.zznq.length);
        for (int i2 = 0; i2 < this.zznq.length; i2++) {
            new StringBuilder(43).append("offset for window ").append(i2).append(" : ").append(this.zznq[i2]);
            new StringBuilder(45).append("num rows for window ").append(i2).append(" : ").append(this.zzno[i2].getNumRows());
            new StringBuilder(46).append("start pos for window ").append(i2).append(" : ").append(this.zzno[i2].getStartPosition());
        }
        AppMethodBeat.o(11587);
    }

    public final Uri parseUri(String str, int i2, int i3) {
        AppMethodBeat.i(11599);
        String string = getString(str, i2, i3);
        if (string == null) {
            AppMethodBeat.o(11599);
            return null;
        }
        Uri parse = Uri.parse(string);
        AppMethodBeat.o(11599);
        return parse;
    }

    public final void replaceValue(String str, int i2, int i3, double d2) {
        AppMethodBeat.i(11604);
        zza(str, i2);
        this.zzno[i3].putDouble(d2, i2, this.zznn.getInt(str));
        AppMethodBeat.o(11604);
    }

    public final void replaceValue(String str, int i2, int i3, long j2) {
        AppMethodBeat.i(11605);
        zza(str, i2);
        this.zzno[i3].putLong(j2, i2, this.zznn.getInt(str));
        AppMethodBeat.o(11605);
    }

    public final void replaceValue(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(11603);
        zza(str, i2);
        this.zzno[i3].putString(str2, i2, this.zznn.getInt(str));
        AppMethodBeat.o(11603);
    }

    public final void replaceValue(String str, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(11606);
        zza(str, i2);
        this.zzno[i3].putBlob(bArr, i2, this.zznn.getInt(str));
        AppMethodBeat.o(11606);
    }

    public final void validateContents() {
        AppMethodBeat.i(11585);
        this.zznn = new Bundle();
        for (int i2 = 0; i2 < this.zznm.length; i2++) {
            this.zznn.putInt(this.zznm[i2], i2);
        }
        this.zznq = new int[this.zzno.length];
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzno.length; i4++) {
            this.zznq[i4] = i3;
            i3 += this.zzno[i4].getNumRows() - (i3 - this.zzno[i4].getStartPosition());
        }
        this.zznr = i3;
        AppMethodBeat.o(11585);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(11586);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zznm, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzno, i2, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i2 & 1) != 0) {
            close();
        }
        AppMethodBeat.o(11586);
    }
}
