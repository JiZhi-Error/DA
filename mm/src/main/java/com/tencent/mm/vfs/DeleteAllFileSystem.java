package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import java.util.Map;

public class DeleteAllFileSystem extends AbstractFileSystem {
    public static final Parcelable.Creator<DeleteAllFileSystem> CREATOR = new Parcelable.Creator<DeleteAllFileSystem>() {
        /* class com.tencent.mm.vfs.DeleteAllFileSystem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DeleteAllFileSystem[] newArray(int i2) {
            return new DeleteAllFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DeleteAllFileSystem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(187638);
            DeleteAllFileSystem deleteAllFileSystem = new DeleteAllFileSystem(parcel);
            AppMethodBeat.o(187638);
            return deleteAllFileSystem;
        }
    };
    protected final FileSystem Rbo;

    public DeleteAllFileSystem(FileSystem fileSystem) {
        this.Rbo = fileSystem;
    }

    protected DeleteAllFileSystem(Parcel parcel) {
        AppMethodBeat.i(187640);
        aa.a(parcel, StatisticsFileSystem.class, 1);
        this.Rbo = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        if (this.Rbo == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong wrapped filesystem.");
            AppMethodBeat.o(187640);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(187640);
    }

    public String toString() {
        AppMethodBeat.i(187641);
        String str = "DeleteAll [" + this.Rbo.toString() + "]";
        AppMethodBeat.o(187641);
        return str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(187642);
        aa.b(parcel, StatisticsFileSystem.class, 1);
        parcel.writeParcelable(this.Rbo, i2);
        AppMethodBeat.o(187642);
    }

    static {
        AppMethodBeat.i(187644);
        AppMethodBeat.o(187644);
    }

    protected class a extends i {
        protected final FileSystem.b Rbp;

        a(FileSystem.b bVar) {
            this.Rbp = bVar;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return DeleteAllFileSystem.this;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.i
        public final void a(CancellationSignal cancellationSignal) {
            AppMethodBeat.i(187639);
            this.Rbp.dy("", true);
            cancellationSignal.throwIfCanceled();
            this.Rbp.a(cancellationSignal);
            AppMethodBeat.o(187639);
        }
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final /* synthetic */ FileSystem.b cj(Map map) {
        AppMethodBeat.i(187643);
        a aVar = new a(this.Rbo.cj(map));
        AppMethodBeat.o(187643);
        return aVar;
    }
}
