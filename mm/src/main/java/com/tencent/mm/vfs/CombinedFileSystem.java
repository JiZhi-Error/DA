package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class CombinedFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<CombinedFileSystem> CREATOR = new Parcelable.Creator<CombinedFileSystem>() {
        /* class com.tencent.mm.vfs.CombinedFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CombinedFileSystem[] newArray(int i2) {
            return new CombinedFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CombinedFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(13039);
            CombinedFileSystem combinedFileSystem = new CombinedFileSystem(parcel, (byte) 0);
            AppMethodBeat.o(13039);
            return combinedFileSystem;
        }
    };
    protected final FileSystem[] Rbd;
    protected final a[] Rbe;

    /* synthetic */ CombinedFileSystem(Parcel parcel, byte b2) {
        this(parcel);
    }

    static final class a {
        final int Rbf;
        final Pattern lnT;

        a(Pattern pattern, int i2) {
            this.lnT = pattern;
            this.Rbf = i2;
        }
    }

    private CombinedFileSystem(Parcel parcel) {
        AppMethodBeat.i(13040);
        aa.a(parcel, CombinedFileSystem.class, 1);
        int readInt = parcel.readInt();
        this.Rbd = new FileSystem[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            FileSystem fileSystem = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
            if (fileSystem == null) {
                ParcelFormatException parcelFormatException = new ParcelFormatException();
                AppMethodBeat.o(13040);
                throw parcelFormatException;
            }
            this.Rbd[i2] = fileSystem;
        }
        int readInt2 = parcel.readInt();
        this.Rbe = new a[readInt2];
        for (int i3 = 0; i3 < readInt2; i3++) {
            String readString = parcel.readString();
            this.Rbe[i3] = new a(readString == null ? null : Pattern.compile(readString), parcel.readInt());
        }
        AppMethodBeat.o(13040);
    }

    public String toString() {
        AppMethodBeat.i(13045);
        StringBuilder sb = new StringBuilder("CombinedFS [");
        for (FileSystem fileSystem : this.Rbd) {
            sb.append(fileSystem.toString()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        String sb2 = sb.append(']').toString();
        AppMethodBeat.o(13045);
        return sb2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(13046);
        aa.b(parcel, CombinedFileSystem.class, 1);
        parcel.writeInt(this.Rbd.length);
        for (FileSystem fileSystem : this.Rbd) {
            parcel.writeParcelable(fileSystem, i2);
        }
        parcel.writeInt(this.Rbe.length);
        a[] aVarArr = this.Rbe;
        for (a aVar : aVarArr) {
            parcel.writeString(aVar.lnT == null ? null : aVar.lnT.pattern());
            parcel.writeInt(aVar.Rbf);
        }
        AppMethodBeat.o(13046);
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final FileSystem.b cj(Map<String, String> map) {
        int i2 = 0;
        AppMethodBeat.i(187631);
        FileSystem.b[] bVarArr = new FileSystem.b[this.Rbd.length];
        for (int i3 = 0; i3 < bVarArr.length; i3++) {
            FileSystem.b cj = this.Rbd[i3].cj(map);
            i2 = cj.hdR() | i2;
            bVarArr[i3] = cj;
        }
        b bVar = new b(bVarArr, i2);
        AppMethodBeat.o(187631);
        return bVar;
    }

    static {
        AppMethodBeat.i(13047);
        AppMethodBeat.o(13047);
    }

    protected class b extends c {
        protected final FileSystem.b[] Rbg;
        private final int Rbh;

        b(FileSystem.b[] bVarArr, int i2) {
            this.Rbg = bVarArr;
            this.Rbh = i2;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return CombinedFileSystem.this;
        }

        @Override // com.tencent.mm.vfs.c
        public final FileSystem.b ho(String str, int i2) {
            AppMethodBeat.i(187627);
            a[] aVarArr = CombinedFileSystem.this.Rbe;
            for (a aVar : aVarArr) {
                if (aVar.lnT == null || aVar.lnT.matcher(str).matches()) {
                    FileSystem.b bVar = this.Rbg[aVar.Rbf];
                    AppMethodBeat.o(187627);
                    return bVar;
                }
            }
            AppMethodBeat.o(187627);
            return null;
        }

        @Override // com.tencent.mm.vfs.c
        public final List<FileSystem.b> hdS() {
            AppMethodBeat.i(187628);
            List<FileSystem.b> asList = Arrays.asList(this.Rbg);
            AppMethodBeat.o(187628);
            return asList;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final int hdR() {
            return this.Rbh;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final FileSystem.a boK(String str) {
            AppMethodBeat.i(187629);
            FileSystem.a boK = this.Rbg[this.Rbg.length - 1].boK(str);
            AppMethodBeat.o(187629);
            return boK;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public final boolean boN(String str) {
            AppMethodBeat.i(187630);
            FileSystem.b[] bVarArr = this.Rbg;
            int length = bVarArr.length;
            int i2 = 0;
            boolean z = false;
            while (i2 < length) {
                i2++;
                z = bVarArr[i2].boN(str) | z;
            }
            AppMethodBeat.o(187630);
            return z;
        }
    }
}
