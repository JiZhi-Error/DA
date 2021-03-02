package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MigrationFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<MigrationFileSystem> CREATOR = new Parcelable.Creator<MigrationFileSystem>() {
        /* class com.tencent.mm.vfs.MigrationFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MigrationFileSystem[] newArray(int i2) {
            return new MigrationFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MigrationFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(13129);
            MigrationFileSystem migrationFileSystem = new MigrationFileSystem(parcel);
            AppMethodBeat.o(13129);
            return migrationFileSystem;
        }
    };
    protected final FileSystem[] Rbd;
    protected final String Rcs;
    protected final String Rct;
    protected final String Rcu;
    protected final String Rcv;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MigrationFileSystem(boolean r4, boolean r5, com.tencent.mm.vfs.FileSystem r6, com.tencent.mm.vfs.FileSystem... r7) {
        /*
            r3 = this;
            r0 = 0
            r2 = 187677(0x2dd1d, float:2.62991E-40)
            if (r4 == 0) goto L_0x0018
            java.lang.String r1 = ""
        L_0x0009:
            if (r5 == 0) goto L_0x000e
            java.lang.String r0 = ""
        L_0x000e:
            r3.<init>(r1, r0, r6, r7)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x0018:
            r1 = r0
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.MigrationFileSystem.<init>(boolean, boolean, com.tencent.mm.vfs.FileSystem, com.tencent.mm.vfs.FileSystem[]):void");
    }

    public MigrationFileSystem(String str, String str2, FileSystem fileSystem, FileSystem... fileSystemArr) {
        this(str, str2, null, fileSystem, fileSystemArr);
        AppMethodBeat.i(179552);
        AppMethodBeat.o(179552);
    }

    public MigrationFileSystem(String str, String str2, String str3, FileSystem fileSystem, FileSystem... fileSystemArr) {
        int i2;
        AppMethodBeat.i(187678);
        if (fileSystem == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("destination == null");
            AppMethodBeat.o(187678);
            throw illegalArgumentException;
        }
        this.Rcs = str;
        this.Rct = str2;
        this.Rcu = str3;
        this.Rcv = null;
        FileSystem[] fileSystemArr2 = new FileSystem[(fileSystemArr.length + 1)];
        fileSystemArr2[0] = fileSystem;
        int i3 = 1;
        int length = fileSystemArr.length;
        int i4 = 0;
        while (i4 < length) {
            FileSystem fileSystem2 = fileSystemArr[i4];
            if (fileSystem2 != null) {
                i2 = i3 + 1;
                fileSystemArr2[i3] = fileSystem2;
            } else {
                i2 = i3;
            }
            i4++;
            i3 = i2;
        }
        this.Rbd = i3 == fileSystemArr2.length ? fileSystemArr2 : (FileSystem[]) Arrays.copyOf(fileSystemArr2, i3);
        AppMethodBeat.o(187678);
    }

    protected MigrationFileSystem(Parcel parcel) {
        AppMethodBeat.i(13131);
        aa.a(parcel, MigrationFileSystem.class, 6);
        int readInt = parcel.readInt();
        this.Rbd = new FileSystem[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            FileSystem fileSystem = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
            if (fileSystem == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong wrapped filesystem.");
                AppMethodBeat.o(13131);
                throw illegalArgumentException;
            }
            this.Rbd[i2] = fileSystem;
        }
        this.Rcs = parcel.readString();
        this.Rct = parcel.readString();
        this.Rcu = parcel.readString();
        this.Rcv = parcel.readString();
        AppMethodBeat.o(13131);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(13140);
        aa.b(parcel, MigrationFileSystem.class, 6);
        parcel.writeInt(this.Rbd.length);
        for (FileSystem fileSystem : this.Rbd) {
            parcel.writeParcelable(fileSystem, i2);
        }
        parcel.writeString(this.Rcs);
        parcel.writeString(this.Rct);
        parcel.writeString(this.Rcu);
        parcel.writeString(this.Rcv);
        AppMethodBeat.o(13140);
    }

    public String toString() {
        AppMethodBeat.i(13139);
        StringBuilder append = new StringBuilder("Migration [").append(this.Rbd[0].toString()).append(" <= ");
        for (int i2 = 1; i2 < this.Rbd.length; i2++) {
            append.append(this.Rbd[i2].toString()).append(", ");
        }
        append.setLength(append.length() - 2);
        String sb = append.append(']').toString();
        AppMethodBeat.o(13139);
        return sb;
    }

    static {
        AppMethodBeat.i(13141);
        AppMethodBeat.o(13141);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final FileSystem.b cj(Map<String, String> map) {
        String heg;
        File file;
        AppMethodBeat.i(187679);
        boolean z = aa.aa(this.Rcs, map) != null;
        boolean z2 = aa.aa(this.Rct, map) != null;
        boolean z3 = aa.aa(this.Rcu, map) != null;
        boolean z4 = aa.aa(this.Rcv, map) != null;
        for (FileSystem fileSystem : this.Rbd) {
            fileSystem.cj(map);
        }
        ArrayList arrayList = new ArrayList(this.Rbd.length);
        FileSystem.b cj = this.Rbd[0].cj(map);
        arrayList.add(cj);
        HashSet hashSet = new HashSet();
        File file2 = null;
        if ((this.Rbd[0] instanceof NativeFileSystem) && (heg = ((NativeFileSystem.c) cj).heg()) != null) {
            if (z2) {
                file = new File(heg);
                if (file.exists()) {
                    file = null;
                }
            } else {
                file = null;
            }
            hashSet.add(heg);
            file2 = file;
        }
        File file3 = file2;
        for (int i2 = 1; i2 < this.Rbd.length; i2++) {
            if (!(this.Rbd[i2] instanceof NativeFileSystem)) {
                arrayList.add(this.Rbd[i2].cj(map));
            } else {
                NativeFileSystem.c cVar = (NativeFileSystem.c) this.Rbd[i2].cj(map);
                String heg2 = cVar.heg();
                if (heg2 != null) {
                    File file4 = new File(heg2);
                    boolean isDirectory = file4.isDirectory();
                    if (isDirectory && file3 != null && file4.renameTo(file3)) {
                        Log.i("VFS.MigrationFileSystem", "Fast moved '" + file4 + "' -> '" + file3 + "'");
                        file3 = null;
                        if (!z3) {
                            hashSet.add(heg2);
                        }
                    }
                    if ((isDirectory || z3) && hashSet.add(heg2)) {
                        arrayList.add(cVar);
                    }
                }
            }
            file3 = file3;
        }
        a aVar = new a(arrayList, z, z4);
        AppMethodBeat.o(187679);
        return aVar;
    }

    protected class a extends c {
        protected final List<FileSystem.b> Rcw;
        protected final boolean Rcx;
        protected final boolean Rcy;

        protected a(List<FileSystem.b> list, boolean z, boolean z2) {
            this.Rcw = list;
            this.Rcx = z;
            this.Rcy = z2;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return MigrationFileSystem.this;
        }

        @Override // com.tencent.mm.vfs.c
        public final FileSystem.b ho(String str, int i2) {
            AppMethodBeat.i(187666);
            List<FileSystem.b> list = this.Rcw;
            if (i2 == 1 || i2 == 3) {
                for (FileSystem.b bVar : list) {
                    if (bVar.boL(str)) {
                        AppMethodBeat.o(187666);
                        return bVar;
                    }
                }
            }
            FileSystem.b bVar2 = list.get(0);
            AppMethodBeat.o(187666);
            return bVar2;
        }

        @Override // com.tencent.mm.vfs.c
        public final List<FileSystem.b> hdS() {
            return this.Rcw;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final InputStream openRead(String str) {
            AppMethodBeat.i(187667);
            FileNotFoundException fileNotFoundException = null;
            for (FileSystem.b bVar : this.Rcw) {
                try {
                    InputStream openRead = bVar.openRead(str);
                    AppMethodBeat.o(187667);
                    return openRead;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    if (fileNotFoundException != null) {
                        e = fileNotFoundException;
                    }
                    fileNotFoundException = e;
                }
            }
            if (fileNotFoundException == null) {
                fileNotFoundException = new FileNotFoundException(str + " not found on any file systems.");
            }
            AppMethodBeat.o(187667);
            throw fileNotFoundException;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final ReadableByteChannel boI(String str) {
            AppMethodBeat.i(187668);
            FileNotFoundException fileNotFoundException = null;
            for (FileSystem.b bVar : this.Rcw) {
                try {
                    ReadableByteChannel boI = bVar.boI(str);
                    AppMethodBeat.o(187668);
                    return boI;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    if (fileNotFoundException != null) {
                        e = fileNotFoundException;
                    }
                    fileNotFoundException = e;
                }
            }
            if (fileNotFoundException == null) {
                fileNotFoundException = new FileNotFoundException(str + " not found on any file systems.");
            }
            AppMethodBeat.o(187668);
            throw fileNotFoundException;
        }

        private boolean boR(String str) {
            AppMethodBeat.i(187669);
            String bpg = aa.bpg(str);
            if (bpg == null) {
                AppMethodBeat.o(187669);
                return false;
            }
            FileSystem.b bVar = this.Rcw.get(0);
            if (bVar.boL(bpg)) {
                AppMethodBeat.o(187669);
                return false;
            }
            int size = this.Rcw.size();
            for (int i2 = 1; i2 < size; i2++) {
                e boM = this.Rcw.get(i2).boM(bpg);
                if (boM != null && boM.RbJ) {
                    boolean boN = bVar.boN(bpg);
                    AppMethodBeat.o(187669);
                    return boN;
                }
            }
            AppMethodBeat.o(187669);
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final OutputStream dw(String str, boolean z) {
            AppMethodBeat.i(187670);
            FileSystem.b bVar = this.Rcw.get(0);
            try {
                OutputStream dw = bVar.dw(str, z);
                AppMethodBeat.o(187670);
                return dw;
            } catch (FileNotFoundException e2) {
                if (z || !boR(str)) {
                    AppMethodBeat.o(187670);
                    throw e2;
                }
                OutputStream dw2 = bVar.dw(str, false);
                AppMethodBeat.o(187670);
                return dw2;
            }
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final WritableByteChannel dv(String str, boolean z) {
            AppMethodBeat.i(187671);
            FileSystem.b bVar = this.Rcw.get(0);
            try {
                WritableByteChannel dv = bVar.dv(str, z);
                AppMethodBeat.o(187671);
                return dv;
            } catch (FileNotFoundException e2) {
                if (z || !boR(str)) {
                    AppMethodBeat.o(187671);
                    throw e2;
                }
                WritableByteChannel dv2 = bVar.dv(str, false);
                AppMethodBeat.o(187671);
                return dv2;
            }
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final boolean boL(String str) {
            AppMethodBeat.i(187672);
            for (FileSystem.b bVar : this.Rcw) {
                if (bVar.boL(str)) {
                    AppMethodBeat.o(187672);
                    return true;
                }
            }
            AppMethodBeat.o(187672);
            return false;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final e boM(String str) {
            AppMethodBeat.i(187673);
            for (FileSystem.b bVar : this.Rcw) {
                e boM = bVar.boM(str);
                if (boM != null) {
                    AppMethodBeat.o(187673);
                    return boM;
                }
            }
            AppMethodBeat.o(187673);
            return null;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
        public final boolean a(String str, FileSystem.b bVar, String str2) {
            AppMethodBeat.i(187674);
            boolean a2 = super.a(str, bVar, str2);
            if (a2 || !boR(str)) {
                AppMethodBeat.o(187674);
                return a2;
            }
            boolean a3 = super.a(str, bVar, str2);
            AppMethodBeat.o(187674);
            return a3;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b
        public final long c(String str, FileSystem.b bVar, String str2) {
            AppMethodBeat.i(187675);
            try {
                long c2 = super.c(str, bVar, str2);
                AppMethodBeat.o(187675);
                return c2;
            } catch (FileNotFoundException e2) {
                if (boR(str)) {
                    long c3 = super.c(str, bVar, str2);
                    AppMethodBeat.o(187675);
                    return c3;
                }
                AppMethodBeat.o(187675);
                throw e2;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0320  */
        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(android.os.CancellationSignal r25) {
            /*
            // Method dump skipped, instructions count: 823
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.MigrationFileSystem.a.a(android.os.CancellationSignal):void");
        }
    }
}
