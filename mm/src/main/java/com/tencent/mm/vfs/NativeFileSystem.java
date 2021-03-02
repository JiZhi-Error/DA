package com.tencent.mm.vfs;

import android.os.Build;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.StatFs;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.a.a;
import com.tencent.mm.vfs.a.e;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class NativeFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<NativeFileSystem> CREATOR = new Parcelable.Creator<NativeFileSystem>() {
        /* class com.tencent.mm.vfs.NativeFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ NativeFileSystem[] newArray(int i2) {
            return new NativeFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ NativeFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(187680);
            NativeFileSystem nativeFileSystem = new NativeFileSystem(parcel);
            AppMethodBeat.o(187680);
            return nativeFileSystem;
        }
    };
    protected final String RcA;
    private final c RcB;

    static /* synthetic */ boolean V(File file) {
        AppMethodBeat.i(187707);
        boolean G = G(file);
        AppMethodBeat.o(187707);
        return G;
    }

    static /* synthetic */ long f(String str, FileSystem.b bVar, String str2) {
        AppMethodBeat.i(187708);
        long e2 = e(str, bVar, str2);
        AppMethodBeat.o(187708);
        return e2;
    }

    public NativeFileSystem(String str) {
        AppMethodBeat.i(13156);
        this.RcA = aa.q(str, true, false);
        if (this.RcA.isEmpty()) {
            this.RcB = new c(this.RcA);
            AppMethodBeat.o(13156);
            return;
        }
        String aa = aa.aa(this.RcA, g.hYQ().Vmn.hej());
        if (aa != null) {
            this.RcB = new c(aa);
            AppMethodBeat.o(13156);
            return;
        }
        this.RcB = null;
        AppMethodBeat.o(13156);
    }

    protected NativeFileSystem(Parcel parcel) {
        String q;
        AppMethodBeat.i(13157);
        aa.a(parcel, NativeFileSystem.class, 2);
        String readString = parcel.readString();
        if (readString == null) {
            q = "";
        } else {
            q = aa.q(readString, true, false);
        }
        this.RcA = q;
        if (this.RcA.isEmpty()) {
            this.RcB = new c(this.RcA);
            AppMethodBeat.o(13157);
            return;
        }
        String aa = aa.aa(this.RcA, g.hYQ().Vmn.hej());
        if (aa != null) {
            this.RcB = new c(aa);
            AppMethodBeat.o(13157);
            return;
        }
        this.RcB = null;
        AppMethodBeat.o(13157);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(13180);
        aa.b(parcel, NativeFileSystem.class, 2);
        parcel.writeString(this.RcA);
        AppMethodBeat.o(13180);
    }

    public String toString() {
        AppMethodBeat.i(13181);
        String str = "Native [" + (this.RcB == null ? this.RcA : this.RcB.heg()) + "]";
        AppMethodBeat.o(13181);
        return str;
    }

    static {
        AppMethodBeat.i(13183);
        AppMethodBeat.o(13183);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final FileSystem.b cj(Map<String, String> map) {
        AppMethodBeat.i(187703);
        if (this.RcB != null) {
            c cVar = this.RcB;
            AppMethodBeat.o(187703);
            return cVar;
        }
        String aa = aa.aa(this.RcA, map);
        Log.i("VFS.NativeFileSystem", "Real path resolved: " + this.RcA + " => " + aa);
        c cVar2 = new c(aa);
        AppMethodBeat.o(187703);
        return cVar2;
    }

    protected class c extends a {
        protected final String RcC;
        private boolean RcD;

        static /* synthetic */ e a(c cVar, File file) {
            AppMethodBeat.i(187702);
            e W = cVar.W(file);
            AppMethodBeat.o(187702);
            return W;
        }

        c(String str) {
            AppMethodBeat.i(187683);
            if (str == null || str.isEmpty()) {
                this.RcC = str;
                this.RcD = true;
                AppMethodBeat.o(187683);
                return;
            }
            this.RcC = aa.bpf(str);
            File file = new File(this.RcC);
            if (file.isDirectory()) {
                this.RcD = true;
                AppMethodBeat.o(187683);
                return;
            }
            if (file.exists()) {
                Log.e("VFS.NativeFileSystem", "Base directory exists but is not a directory, delete and proceed.Base path: " + file.getPath());
                file.delete();
            }
            this.RcD = false;
            AppMethodBeat.o(187683);
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return NativeFileSystem.this;
        }

        public final String heg() {
            return this.RcC;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final int hdR() {
            return 31;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem.a boK(String str) {
            AppMethodBeat.i(187684);
            try {
                StatFs statFs = new StatFs(dz(str, false));
                FileSystem.a aVar = new FileSystem.a();
                if (Build.VERSION.SDK_INT >= 18) {
                    aVar.blockSize = statFs.getBlockSizeLong();
                    aVar.availableBlocks = statFs.getAvailableBlocksLong();
                    aVar.totalBlocks = statFs.getBlockCountLong();
                } else {
                    aVar.blockSize = (long) statFs.getBlockSize();
                    aVar.availableBlocks = (long) statFs.getAvailableBlocks();
                    aVar.totalBlocks = (long) statFs.getBlockCount();
                }
                aVar.RbL = aVar.availableBlocks * aVar.blockSize;
                aVar.bGI = aVar.totalBlocks * aVar.blockSize;
                AppMethodBeat.o(187684);
                return aVar;
            } catch (RuntimeException e2) {
                AppMethodBeat.o(187684);
                return null;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final InputStream openRead(String str) {
            AppMethodBeat.i(187685);
            String dz = dz(str, false);
            if (dz == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.o(187685);
                throw fileNotFoundException;
            }
            b bVar = new b(dz);
            AppMethodBeat.o(187685);
            return bVar;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
        public final ReadableByteChannel boI(String str) {
            AppMethodBeat.i(187686);
            String dz = dz(str, false);
            if (dz == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.o(187686);
                throw fileNotFoundException;
            }
            FileChannel channel = new FileInputStream(dz).getChannel();
            AppMethodBeat.o(187686);
            return channel;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final OutputStream dw(String str, boolean z) {
            AppMethodBeat.i(187687);
            String dz = dz(str, true);
            if (dz == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.o(187687);
                throw fileNotFoundException;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(dz, z);
            AppMethodBeat.o(187687);
            return fileOutputStream;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
        public final WritableByteChannel dv(String str, boolean z) {
            AppMethodBeat.i(187688);
            String dz = dz(str, true);
            if (dz == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.o(187688);
                throw fileNotFoundException;
            }
            FileChannel channel = new FileOutputStream(dz, z).getChannel();
            AppMethodBeat.o(187688);
            return channel;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
        public final ByteChannel boJ(String str) {
            AppMethodBeat.i(187689);
            String dz = dz(str, true);
            if (dz == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.o(187689);
                throw fileNotFoundException;
            }
            FileChannel channel = new RandomAccessFile(dz, "rw").getChannel();
            AppMethodBeat.o(187689);
            return channel;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
        public final ParcelFileDescriptor nr(String str, String str2) {
            AppMethodBeat.i(187690);
            String dz = dz(str, true);
            if (dz == null) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.o(187690);
                throw fileNotFoundException;
            }
            ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(dz), NativeFileSystem.boS(str2));
            AppMethodBeat.o(187690);
            return open;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean boL(String str) {
            AppMethodBeat.i(187691);
            String dz = dz(str, false);
            if (dz == null || !new File(dz).exists()) {
                AppMethodBeat.o(187691);
                return false;
            }
            AppMethodBeat.o(187691);
            return true;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final e boM(String str) {
            AppMethodBeat.i(187692);
            String dz = dz(str, false);
            if (dz == null) {
                AppMethodBeat.o(187692);
                return null;
            }
            e W = W(new File(dz));
            AppMethodBeat.o(187692);
            return W;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean ck(String str, long j2) {
            AppMethodBeat.i(187693);
            String dz = dz(str, true);
            if (dz == null) {
                AppMethodBeat.o(187693);
                return false;
            }
            boolean lastModified = new File(dz).setLastModified(j2);
            AppMethodBeat.o(187693);
            return lastModified;
        }

        final class a implements a.AbstractC2153a<File, e> {
            private final boolean FT;
            private final boolean RcF = false;

            /* Return type fixed from 'java.lang.Iterable' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vfs.a.a.AbstractC2153a
            public final /* synthetic */ Iterable<? extends e> eq(File file) {
                AppMethodBeat.i(187682);
                File file2 = file;
                e a2 = c.a(c.this, file2);
                if (a2 == null) {
                    AppMethodBeat.o(187682);
                    return null;
                }
                Set singleton = Collections.singleton(a2);
                if (!this.FT || !a2.RbJ) {
                    AppMethodBeat.o(187682);
                    return singleton;
                }
                File[] listFiles = file2.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    AppMethodBeat.o(187682);
                    return singleton;
                }
                com.tencent.mm.vfs.a.a aVar = new com.tencent.mm.vfs.a.a(Arrays.asList(listFiles), this);
                if (this.RcF) {
                    e eVar = new e(aVar, singleton);
                    AppMethodBeat.o(187682);
                    return eVar;
                }
                e eVar2 = new e(singleton, aVar);
                AppMethodBeat.o(187682);
                return eVar2;
            }

            a(boolean z) {
                this.FT = z;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final Iterable<e> dx(String str, boolean z) {
            AppMethodBeat.i(187694);
            String dz = dz(str, false);
            if (dz == null) {
                AppMethodBeat.o(187694);
                return null;
            }
            File[] listFiles = new File(dz).listFiles();
            if (listFiles == null) {
                AppMethodBeat.o(187694);
                return null;
            }
            com.tencent.mm.vfs.a.a aVar = new com.tencent.mm.vfs.a.a(Arrays.asList(listFiles), new a(z));
            AppMethodBeat.o(187694);
            return aVar;
        }

        private e W(File file) {
            String substring;
            AppMethodBeat.i(187695);
            String str = this.RcC;
            if (!file.getPath().startsWith(str)) {
                RuntimeException runtimeException = new RuntimeException("Illegal file: " + file + " (base: " + str + ")");
                AppMethodBeat.o(187695);
                throw runtimeException;
            }
            if (file.getPath().length() == str.length()) {
                substring = "";
            } else {
                substring = file.getPath().substring(str.length() + 1);
            }
            String name = file.getName();
            if (Build.VERSION.SDK_INT >= 21) {
                e a2 = a.a(file, this, substring, name);
                AppMethodBeat.o(187695);
                return a2;
            } else if (!file.exists()) {
                AppMethodBeat.o(187695);
                return null;
            } else {
                boolean isDirectory = file.isDirectory();
                long length = file.length();
                e eVar = new e(this, substring, name, length, -4096 & ((4096 + length) - 1), file.lastModified(), isDirectory);
                AppMethodBeat.o(187695);
                return eVar;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean gC(String str) {
            AppMethodBeat.i(187696);
            String dz = dz(str, false);
            if (dz == null) {
                AppMethodBeat.o(187696);
                return false;
            }
            boolean delete = new File(dz).delete();
            AppMethodBeat.o(187696);
            return delete;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean boN(String str) {
            AppMethodBeat.i(187697);
            String dz = dz(str, true);
            if (dz == null) {
                AppMethodBeat.o(187697);
                return false;
            }
            boolean mkdirs = new File(dz).mkdirs();
            AppMethodBeat.o(187697);
            return mkdirs;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final boolean dy(String str, boolean z) {
            boolean z2;
            AppMethodBeat.i(187698);
            String dz = dz(str, false);
            if (dz == null) {
                AppMethodBeat.o(187698);
                return false;
            }
            if (str.isEmpty() || str.equals(FilePathGenerator.ANDROID_DIR_SEP)) {
                z2 = true;
            } else {
                z2 = false;
            }
            File file = new File(dz);
            if (!file.isDirectory()) {
                AppMethodBeat.o(187698);
                return false;
            }
            boolean V = z ? NativeFileSystem.V(file) : file.delete();
            if (z2 && V) {
                this.RcD = false;
            }
            AppMethodBeat.o(187698);
            return V;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.vfs.a
        public final boolean b(String str, FileSystem.b bVar, String str2) {
            AppMethodBeat.i(187699);
            if ((bVar.hdR() & 2) != 0) {
                String dz = bVar.dz(str2, false);
                String dz2 = dz(str, true);
                if (!(dz == null || dz2 == null)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        boolean nu = a.nu(dz, dz2);
                        AppMethodBeat.o(187699);
                        return nu;
                    }
                    boolean renameTo = new File(dz).renameTo(new File(dz2));
                    AppMethodBeat.o(187699);
                    return renameTo;
                }
            }
            AppMethodBeat.o(187699);
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.vfs.a
        public final long d(String str, FileSystem.b bVar, String str2) {
            AppMethodBeat.i(187700);
            String dz = dz(str, true);
            if (dz == null) {
                IOException iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.o(187700);
                throw iOException;
            }
            long f2 = NativeFileSystem.f(dz, bVar, str2);
            AppMethodBeat.o(187700);
            return f2;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final String dz(String str, boolean z) {
            AppMethodBeat.i(187701);
            String str2 = this.RcC;
            if (str2 == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Base path cannot be resolved: " + NativeFileSystem.this.RcA);
                AppMethodBeat.o(187701);
                throw illegalStateException;
            }
            if (z && !this.RcD) {
                new File(this.RcC).mkdirs();
                this.RcD = true;
            }
            if (str.isEmpty()) {
                AppMethodBeat.o(187701);
                return str2;
            }
            String str3 = str2 + '/' + str;
            AppMethodBeat.o(187701);
            return str3;
        }
    }

    static class b extends FileInputStream {
        private long mMarkPosition = 0;

        b(String str) {
            super(str);
        }

        public final boolean markSupported() {
            return true;
        }

        public final void mark(int i2) {
            AppMethodBeat.i(13154);
            try {
                this.mMarkPosition = getChannel().position();
                AppMethodBeat.o(13154);
            } catch (IOException e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(13154);
                throw runtimeException;
            }
        }

        @Override // java.io.InputStream
        public final void reset() {
            AppMethodBeat.i(13155);
            getChannel().position(this.mMarkPosition);
            AppMethodBeat.o(13155);
        }
    }

    private static boolean G(File file) {
        boolean delete;
        AppMethodBeat.i(187704);
        boolean z = true;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    delete = G(file2);
                } else {
                    delete = file2.delete();
                }
                z &= delete;
            }
        }
        boolean delete2 = z & file.delete();
        AppMethodBeat.o(187704);
        return delete2;
    }

    private static long e(String str, FileSystem.b bVar, String str2) {
        Throwable th;
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;
        AppMethodBeat.i(187705);
        try {
            readableByteChannel = bVar.boI(str2);
            try {
                FileChannel channel = new FileOutputStream(str).getChannel();
                try {
                    if (Build.VERSION.SDK_INT > 23) {
                        long transferFrom = channel.transferFrom(readableByteChannel, 0, MAlarmHandler.NEXT_FIRE_INTERVAL);
                        aa.closeQuietly(channel);
                        aa.closeQuietly(readableByteChannel);
                        AppMethodBeat.o(187705);
                        return transferFrom;
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(8192);
                    long j2 = 0;
                    while (readableByteChannel.read(allocateDirect) >= 0) {
                        allocateDirect.flip();
                        j2 += (long) channel.write(allocateDirect);
                        allocateDirect.clear();
                    }
                    aa.closeQuietly(channel);
                    aa.closeQuietly(readableByteChannel);
                    AppMethodBeat.o(187705);
                    return j2;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    aa.closeQuietly(fileChannel);
                    aa.closeQuietly(readableByteChannel);
                    AppMethodBeat.o(187705);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                aa.closeQuietly(fileChannel);
                aa.closeQuietly(readableByteChannel);
                AppMethodBeat.o(187705);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            readableByteChannel = null;
            fileChannel = null;
            aa.closeQuietly(fileChannel);
            aa.closeQuietly(readableByteChannel);
            AppMethodBeat.o(187705);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        static e a(File file, FileSystem.b bVar, String str, String str2) {
            AppMethodBeat.i(187681);
            try {
                StructStat stat = Os.stat(file.getPath());
                if (stat == null) {
                    AppMethodBeat.o(187681);
                    return null;
                }
                e eVar = new e(bVar, str, str2, stat.st_size, stat.st_blocks * 512, 1000 * stat.st_mtime, OsConstants.S_ISDIR(stat.st_mode));
                AppMethodBeat.o(187681);
                return eVar;
            } catch (ErrnoException e2) {
                AppMethodBeat.o(187681);
                return null;
            }
        }

        static boolean nu(String str, String str2) {
            AppMethodBeat.i(13147);
            try {
                Os.rename(str, str2);
                AppMethodBeat.o(13147);
                return true;
            } catch (ErrnoException e2) {
                if (e2.errno == OsConstants.EXDEV) {
                    AppMethodBeat.o(13147);
                    return false;
                } else if (e2.errno == OsConstants.ENOENT) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Cannot move file " + str + " to " + str2 + ": " + e2.getMessage());
                    AppMethodBeat.o(13147);
                    throw fileNotFoundException;
                } else {
                    IOException iOException = new IOException("Cannot move file " + str + " to " + str2 + ": " + e2.getMessage());
                    AppMethodBeat.o(13147);
                    throw iOException;
                }
            }
        }
    }

    static /* synthetic */ int boS(String str) {
        int i2;
        AppMethodBeat.i(187706);
        if ("r".equals(str)) {
            i2 = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i2 = 738197504;
        } else if ("wa".equals(str)) {
            i2 = 704643072;
        } else if ("rw".equals(str)) {
            i2 = 939524096;
        } else if ("rwt".equals(str)) {
            i2 = 1006632960;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
            AppMethodBeat.o(187706);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(187706);
        return i2;
    }
}
