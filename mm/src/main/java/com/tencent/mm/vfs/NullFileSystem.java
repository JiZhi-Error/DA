package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem;
import java.util.Map;

public class NullFileSystem extends i implements FileSystem {
    public static final a CREATOR = new a((byte) 0);

    /* synthetic */ NullFileSystem(byte b2) {
        this();
    }

    static f heh() {
        return a.RcH;
    }

    private NullFileSystem() {
    }

    @Override // com.tencent.mm.vfs.FileSystem.b
    public final FileSystem hdQ() {
        return this;
    }

    @Override // com.tencent.mm.vfs.FileSystem
    public final FileSystem.b cj(Map<String, String> map) {
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }

    public String toString() {
        return "NullFS";
    }

    /* access modifiers changed from: package-private */
    public static class a implements Parcelable.Creator<NullFileSystem> {
        static final f RcH = new f(new NullFileSystem((byte) 0));

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        static {
            AppMethodBeat.i(187709);
            AppMethodBeat.o(187709);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ NullFileSystem[] newArray(int i2) {
            return new NullFileSystem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ NullFileSystem createFromParcel(Parcel parcel) {
            return (NullFileSystem) RcH.RbM;
        }
    }

    static {
        AppMethodBeat.i(187710);
        AppMethodBeat.o(187710);
    }
}
