package com.tencent.mm.modelsfs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SFSContext {
    public long mNativePtr;

    public static class FileEntry {
        public String name;
        public long size;
        public long timestamp;
    }

    private static native int nativeClear(long j2);

    public static native String nativeErrorMessage();

    private static native boolean nativeExists(long j2, String str);

    private static native long nativeInit(String str);

    private static native int nativeList(long j2, String str, List<FileEntry> list);

    public static native long nativeOpenRead(long j2, String str);

    public static native long nativeOpenWrite(long j2, String str);

    private static native void nativeRelease(long j2);

    private static native void nativeSetIntArrayConf(int i2, int[] iArr);

    private static native void nativeSetIntConf(int i2, int i3);

    private static native void nativeSetStringConf(int i2, String str);

    private static native FileEntry nativeStat(long j2, String str);

    private static native Statistics nativeStatistics(long j2);

    public static native boolean nativeUnlink(long j2, String str);

    /* synthetic */ SFSContext(Builder builder, byte b2) {
        this(builder);
    }

    public static class Statistics implements Serializable {
        private static final long serialVersionUID = 1;
        public BlockFile[] blockFiles;
        public long blockSizeEmpty;
        public long blockSizeUsed;
        public BlockType[] blockTypes;
        public long overflowActualSize;
        public long totalActualSize;

        public static class BlockFile implements Serializable {
            private static final long serialVersionUID = 1;
            public int blockCount;
            public boolean deleted;
            public int emptyCount;
            public long fileSize;
            public long timestamp;
        }

        public static class BlockType implements Serializable {
            private static final long serialVersionUID = 1;
            public long actualSize;
            public int blockSize;
            public int emptyCount;
            public int usedCount;
        }

        public String toString() {
            AppMethodBeat.i(156020);
            StringBuilder sb = new StringBuilder(4096);
            sb.append("Total:\n\tActualSize: ").append(this.totalActualSize).append('\n').append("\tUsedBlockSize: ").append(this.blockSizeUsed).append('\n').append("\tEmptyBlockSize: ").append(this.blockSizeEmpty).append('\n').append("\tOverflowSize: ").append(this.overflowActualSize).append('\n');
            for (int i2 = 0; i2 < this.blockTypes.length; i2++) {
                BlockType blockType = this.blockTypes[i2];
                sb.append("BlockType: ").append(blockType.blockSize).append('\n').append("\tUsedCount: ").append(blockType.usedCount).append('\n').append("\tEmptyCount: ").append(blockType.emptyCount).append('\n').append("\tActualSize: ").append(blockType.actualSize).append('\n');
            }
            for (int i3 = 0; i3 < this.blockFiles.length; i3++) {
                BlockFile blockFile = this.blockFiles[i3];
                sb.append("BlockFile: ").append(i3).append('\n').append("\tFileSize: ").append(blockFile.fileSize).append('\n').append("\tUsedBlockCount: ").append(blockFile.blockCount).append('\n').append("\tEmptyBlockCount: ").append(blockFile.emptyCount).append('\n').append("\tTimestamp: ").append(blockFile.timestamp).append('\n').append("\tDeleted: ").append(blockFile.deleted).append('\n');
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(156020);
            return sb2;
        }
    }

    public static class Builder implements Parcelable {
        public static final Parcelable.Creator<Builder> CREATOR = new Parcelable.Creator<Builder>() {
            /* class com.tencent.mm.modelsfs.SFSContext.Builder.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final Builder createFromParcel(Parcel parcel) {
                AppMethodBeat.i(156001);
                Builder builder = new Builder(parcel);
                AppMethodBeat.o(156001);
                return builder;
            }

            @Override // android.os.Parcelable.Creator
            public final Builder[] newArray(int i2) {
                return new Builder[i2];
            }
        };
        HashMap<Integer, Object> mConf;
        String mName;

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setIndexDBPath(String str) {
            AppMethodBeat.i(156004);
            this.mConf.put(1, str);
            AppMethodBeat.o(156004);
            return this;
        }

        public Builder setBlockFilePrefix(String str) {
            AppMethodBeat.i(156005);
            this.mConf.put(2, str);
            AppMethodBeat.o(156005);
            return this;
        }

        public Builder setOverflowPrefix(String str) {
            AppMethodBeat.i(156006);
            this.mConf.put(3, str);
            AppMethodBeat.o(156006);
            return this;
        }

        public Builder setIOMode(int i2) {
            AppMethodBeat.i(156007);
            this.mConf.put(9, Integer.valueOf(i2));
            AppMethodBeat.o(156007);
            return this;
        }

        public Builder setBlockSizeArray(int[] iArr) {
            AppMethodBeat.i(156008);
            this.mConf.put(5, iArr);
            AppMethodBeat.o(156008);
            return this;
        }

        public Builder setBlockFileMaxSize(int i2) {
            AppMethodBeat.i(156009);
            this.mConf.put(4, Integer.valueOf(i2));
            AppMethodBeat.o(156009);
            return this;
        }

        public Builder setConnectionPool(int i2) {
            AppMethodBeat.i(156010);
            this.mConf.put(7, Integer.valueOf(i2));
            AppMethodBeat.o(156010);
            return this;
        }

        public Builder setMaxConcurrentIO(int i2) {
            AppMethodBeat.i(156011);
            this.mConf.put(10, Integer.valueOf(i2));
            AppMethodBeat.o(156011);
            return this;
        }

        public Builder setSyncMode(int i2) {
            AppMethodBeat.i(156012);
            this.mConf.put(11, Integer.valueOf(i2));
            AppMethodBeat.o(156012);
            return this;
        }

        public Builder setStoragePath(String str) {
            AppMethodBeat.i(156013);
            if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = str.substring(0, str.length() - 1);
            }
            this.mConf.put(2, str + "/%s.block");
            this.mConf.put(3, str + "/%s/");
            AppMethodBeat.o(156013);
            return this;
        }

        public Builder setDBDirectory(String str) {
            AppMethodBeat.i(156014);
            if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = str.substring(0, str.length() - 1);
            }
            this.mConf.put(1, str + "/%s.index");
            AppMethodBeat.o(156014);
            return this;
        }

        public Builder() {
            AppMethodBeat.i(156015);
            this.mName = null;
            this.mConf = new HashMap<>();
            AppMethodBeat.o(156015);
        }

        public SFSContext create() {
            AppMethodBeat.i(156016);
            SFSContext sFSContext = new SFSContext(this, (byte) 0);
            AppMethodBeat.o(156016);
            return sFSContext;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(156017);
            parcel.writeString(this.mName);
            Object[] objArr = new Object[12];
            for (Map.Entry<Integer, Object> entry : this.mConf.entrySet()) {
                int intValue = entry.getKey().intValue();
                if (intValue < 12 && intValue >= 0) {
                    objArr[intValue] = entry.getValue();
                }
            }
            parcel.writeArray(objArr);
            AppMethodBeat.o(156017);
        }

        static {
            AppMethodBeat.i(156019);
            AppMethodBeat.o(156019);
        }

        private Builder(Parcel parcel) {
            AppMethodBeat.i(156018);
            this.mName = parcel.readString();
            this.mConf = new HashMap<>();
            Object[] readArray = parcel.readArray(Builder.class.getClassLoader());
            if (readArray != null) {
                for (int i2 = 0; i2 < readArray.length; i2++) {
                    if (readArray[i2] != null) {
                        this.mConf.put(Integer.valueOf(i2), readArray[i2]);
                    }
                }
            }
            AppMethodBeat.o(156018);
        }
    }

    private SFSContext(Builder builder) {
        AppMethodBeat.i(156021);
        for (Map.Entry<Integer, Object> entry : builder.mConf.entrySet()) {
            int intValue = entry.getKey().intValue();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                nativeSetIntConf(intValue, ((Integer) value).intValue());
            } else if (value instanceof String) {
                nativeSetStringConf(intValue, (String) value);
            } else if (value instanceof int[]) {
                nativeSetIntArrayConf(intValue, (int[]) value);
            }
        }
        long nativeInit = nativeInit(builder.mName);
        if (nativeInit == 0) {
            RuntimeException runtimeException = new RuntimeException(nativeErrorMessage());
            AppMethodBeat.o(156021);
            throw runtimeException;
        }
        this.mNativePtr = nativeInit;
        AppMethodBeat.o(156021);
    }

    public final void release() {
        AppMethodBeat.i(156022);
        nativeRelease(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.o(156022);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(156023);
        if (this.mNativePtr != 0) {
            release();
        }
        super.finalize();
        AppMethodBeat.o(156023);
    }
}
