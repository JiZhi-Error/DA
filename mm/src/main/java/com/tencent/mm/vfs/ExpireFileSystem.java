package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExpireFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<ExpireFileSystem> CREATOR = new Parcelable.Creator<ExpireFileSystem>() {
        /* class com.tencent.mm.vfs.ExpireFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ExpireFileSystem[] newArray(int i2) {
            return new ExpireFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ExpireFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(13093);
            ExpireFileSystem expireFileSystem = new ExpireFileSystem(parcel);
            AppMethodBeat.o(13093);
            return expireFileSystem;
        }
    };
    protected final FileSystem Rbo;
    protected final long nfE;

    public ExpireFileSystem(FileSystem fileSystem, long j2) {
        AppMethodBeat.i(170151);
        this.Rbo = fileSystem;
        this.nfE = j2;
        AppMethodBeat.o(170151);
    }

    protected ExpireFileSystem(Parcel parcel) {
        AppMethodBeat.i(13094);
        aa.a(parcel, ExpireFileSystem.class, 1);
        this.Rbo = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        if (this.Rbo == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong wrapped filesystem.");
            AppMethodBeat.o(13094);
            throw illegalArgumentException;
        }
        this.nfE = parcel.readLong();
        AppMethodBeat.o(13094);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(13096);
        aa.b(parcel, ExpireFileSystem.class, 1);
        parcel.writeParcelable(this.Rbo, i2);
        parcel.writeLong(this.nfE);
        AppMethodBeat.o(13096);
    }

    @Override // com.tencent.mm.vfs.AbstractFileSystem
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public FileSystem.b cj(Map<String, String> map) {
        AppMethodBeat.i(187647);
        a aVar = new a(this.Rbo.cj(map));
        AppMethodBeat.o(187647);
        return aVar;
    }

    public String toString() {
        AppMethodBeat.i(170152);
        String str = "Expire [" + this.Rbo.toString() + "]";
        AppMethodBeat.o(170152);
        return str;
    }

    protected class a extends c {
        protected final List<FileSystem.b> RbF;
        protected final FileSystem.b Rbp;

        public a(FileSystem.b bVar) {
            AppMethodBeat.i(187645);
            this.Rbp = bVar;
            this.RbF = Collections.singletonList(bVar);
            AppMethodBeat.o(187645);
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return ExpireFileSystem.this;
        }

        @Override // com.tencent.mm.vfs.c
        public final FileSystem.b ho(String str, int i2) {
            return this.Rbp;
        }

        @Override // com.tencent.mm.vfs.c
        public final List<FileSystem.b> hdS() {
            return this.RbF;
        }

        @Override // com.tencent.mm.vfs.a, com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.c
        public void a(CancellationSignal cancellationSignal) {
            long j2;
            AppMethodBeat.i(187646);
            long currentTimeMillis = System.currentTimeMillis() - ExpireFileSystem.this.nfE;
            Iterable<e> dx = this.Rbp.dx("", true);
            if (dx != null) {
                long j3 = 0;
                for (e eVar : dx) {
                    cancellationSignal.throwIfCanceled();
                    if (!eVar.RbJ && eVar.RbI <= currentTimeMillis) {
                        if (eVar.hdW()) {
                            j2 = (eVar.RbH < 0 ? eVar.size : eVar.RbH) + j3;
                        } else {
                            j2 = j3;
                        }
                        j3 = j2;
                    }
                }
                ExpireFileSystem.this.l(3, "deleteSize", Long.valueOf(j3));
            }
            super.a(cancellationSignal);
            AppMethodBeat.o(187646);
        }
    }

    static {
        AppMethodBeat.i(13097);
        AppMethodBeat.o(13097);
    }
}
