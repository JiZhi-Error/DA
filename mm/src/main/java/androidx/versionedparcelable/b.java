package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b extends a {
    private final int Pc;
    private final SparseIntArray aBt;
    private final Parcel aBu;
    private int aBv;
    private int aBw;
    private final int fs;
    private final String mPrefix;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
        AppMethodBeat.i(62410);
        AppMethodBeat.o(62410);
    }

    private b(Parcel parcel, int i2, int i3, String str) {
        AppMethodBeat.i(62411);
        this.aBt = new SparseIntArray();
        this.aBv = -1;
        this.aBw = 0;
        this.aBu = parcel;
        this.fs = i2;
        this.Pc = i3;
        this.aBw = this.fs;
        this.mPrefix = str;
        AppMethodBeat.o(62411);
    }

    @Override // androidx.versionedparcelable.a
    public final void dd(int i2) {
        AppMethodBeat.i(62413);
        nw();
        this.aBv = i2;
        this.aBt.put(i2, this.aBu.dataPosition());
        writeInt(0);
        writeInt(i2);
        AppMethodBeat.o(62413);
    }

    @Override // androidx.versionedparcelable.a
    public final void nw() {
        AppMethodBeat.i(62414);
        if (this.aBv >= 0) {
            int i2 = this.aBt.get(this.aBv);
            int dataPosition = this.aBu.dataPosition();
            this.aBu.setDataPosition(i2);
            this.aBu.writeInt(dataPosition - i2);
            this.aBu.setDataPosition(dataPosition);
        }
        AppMethodBeat.o(62414);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.versionedparcelable.a
    public final a nx() {
        AppMethodBeat.i(62415);
        b bVar = new b(this.aBu, this.aBu.dataPosition(), this.aBw == this.fs ? this.Pc : this.aBw, this.mPrefix + "  ");
        AppMethodBeat.o(62415);
        return bVar;
    }

    @Override // androidx.versionedparcelable.a
    public final void writeByteArray(byte[] bArr) {
        AppMethodBeat.i(62416);
        if (bArr != null) {
            this.aBu.writeInt(bArr.length);
            this.aBu.writeByteArray(bArr);
            AppMethodBeat.o(62416);
            return;
        }
        this.aBu.writeInt(-1);
        AppMethodBeat.o(62416);
    }

    @Override // androidx.versionedparcelable.a
    public final void writeInt(int i2) {
        AppMethodBeat.i(62417);
        this.aBu.writeInt(i2);
        AppMethodBeat.o(62417);
    }

    @Override // androidx.versionedparcelable.a
    public final void writeString(String str) {
        AppMethodBeat.i(62418);
        this.aBu.writeString(str);
        AppMethodBeat.o(62418);
    }

    @Override // androidx.versionedparcelable.a
    public final void a(Parcelable parcelable) {
        AppMethodBeat.i(62419);
        this.aBu.writeParcelable(parcelable, 0);
        AppMethodBeat.o(62419);
    }

    @Override // androidx.versionedparcelable.a
    public final int readInt() {
        AppMethodBeat.i(62420);
        int readInt = this.aBu.readInt();
        AppMethodBeat.o(62420);
        return readInt;
    }

    @Override // androidx.versionedparcelable.a
    public final String readString() {
        AppMethodBeat.i(62421);
        String readString = this.aBu.readString();
        AppMethodBeat.o(62421);
        return readString;
    }

    @Override // androidx.versionedparcelable.a
    public final byte[] ny() {
        AppMethodBeat.i(62422);
        int readInt = this.aBu.readInt();
        if (readInt < 0) {
            AppMethodBeat.o(62422);
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.aBu.readByteArray(bArr);
        AppMethodBeat.o(62422);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    public final <T extends Parcelable> T nz() {
        AppMethodBeat.i(62423);
        T t = (T) this.aBu.readParcelable(getClass().getClassLoader());
        AppMethodBeat.o(62423);
        return t;
    }

    @Override // androidx.versionedparcelable.a
    public final boolean dc(int i2) {
        int i3;
        AppMethodBeat.i(62412);
        while (true) {
            if (this.aBw >= this.Pc) {
                i3 = -1;
                break;
            }
            this.aBu.setDataPosition(this.aBw);
            int readInt = this.aBu.readInt();
            int readInt2 = this.aBu.readInt();
            this.aBw = readInt + this.aBw;
            if (readInt2 == i2) {
                i3 = this.aBu.dataPosition();
                break;
            }
        }
        if (i3 == -1) {
            AppMethodBeat.o(62412);
            return false;
        }
        this.aBu.setDataPosition(i3);
        AppMethodBeat.o(62412);
        return true;
    }
}
