package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import java.util.Map;

public class MaintenanceGroup implements FileSystem {
    public static final Parcelable.Creator<MaintenanceGroup> CREATOR = new Parcelable.Creator<MaintenanceGroup>() {
        /* class com.tencent.mm.vfs.MaintenanceGroup.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MaintenanceGroup[] newArray(int i2) {
            return new MaintenanceGroup[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MaintenanceGroup createFromParcel(Parcel parcel) {
            AppMethodBeat.i(187659);
            MaintenanceGroup maintenanceGroup = new MaintenanceGroup(parcel);
            AppMethodBeat.o(187659);
            return maintenanceGroup;
        }
    };
    protected final FileSystem[] Rbd;

    public MaintenanceGroup(FileSystem... fileSystemArr) {
        this.Rbd = fileSystemArr;
    }

    protected MaintenanceGroup(Parcel parcel) {
        AppMethodBeat.i(187661);
        aa.a(parcel, MaintenanceGroup.class, 2);
        int readInt = parcel.readInt();
        this.Rbd = new FileSystem[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.Rbd[i2] = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
        }
        AppMethodBeat.o(187661);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(187662);
        aa.b(parcel, MaintenanceGroup.class, 2);
        parcel.writeInt(this.Rbd.length);
        for (FileSystem fileSystem : this.Rbd) {
            parcel.writeParcelable(fileSystem, i2);
        }
        AppMethodBeat.o(187662);
    }

    public String toString() {
        AppMethodBeat.i(187663);
        if (this.Rbd.length == 0) {
            AppMethodBeat.o(187663);
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (FileSystem fileSystem : this.Rbd) {
            sb.append(fileSystem.toString()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        String sb2 = sb.append(']').toString();
        AppMethodBeat.o(187663);
        return sb2;
    }

    static {
        AppMethodBeat.i(187665);
        AppMethodBeat.o(187665);
    }

    protected class a extends i {
        protected final FileSystem.b[] Rcq;

        protected a(FileSystem.b[] bVarArr) {
            this.Rcq = bVarArr;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b
        public final FileSystem hdQ() {
            return MaintenanceGroup.this;
        }

        @Override // com.tencent.mm.vfs.FileSystem.b, com.tencent.mm.vfs.i
        public final void a(CancellationSignal cancellationSignal) {
            AppMethodBeat.i(187660);
            FileSystem.b[] bVarArr = this.Rcq;
            for (FileSystem.b bVar : bVarArr) {
                cancellationSignal.throwIfCanceled();
                bVar.a(cancellationSignal);
            }
            AppMethodBeat.o(187660);
        }
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final /* synthetic */ FileSystem.b cj(Map map) {
        AppMethodBeat.i(187664);
        FileSystem.b[] bVarArr = new FileSystem.b[this.Rbd.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr[i2] = this.Rbd[i2].cj(map);
        }
        a aVar = new a(bVarArr);
        AppMethodBeat.o(187664);
        return aVar;
    }
}
