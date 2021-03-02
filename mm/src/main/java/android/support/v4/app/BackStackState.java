package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.b;
import android.text.TextUtils;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* class android.support.v4.app.BackStackState.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }
    };
    final int EK;
    final int EL;
    final int EP;
    final CharSequence EQ;
    final int ER;
    final CharSequence ES;
    final ArrayList<String> ET;
    final ArrayList<String> EU;
    final boolean EV;
    final int[] Fc;
    final int mIndex;
    final String mName;

    public BackStackState(b bVar) {
        int size = bVar.EF.size();
        this.Fc = new int[(size * 6)];
        if (!bVar.EM) {
            throw new IllegalStateException("Not on back stack");
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            b.a aVar = bVar.EF.get(i3);
            int i4 = i2 + 1;
            this.Fc[i2] = aVar.EX;
            int i5 = i4 + 1;
            this.Fc[i4] = aVar.fragment != null ? aVar.fragment.mIndex : -1;
            int i6 = i5 + 1;
            this.Fc[i5] = aVar.EY;
            int i7 = i6 + 1;
            this.Fc[i6] = aVar.EZ;
            int i8 = i7 + 1;
            this.Fc[i7] = aVar.Fa;
            i2 = i8 + 1;
            this.Fc[i8] = aVar.Fb;
        }
        this.EK = bVar.EK;
        this.EL = bVar.EL;
        this.mName = bVar.mName;
        this.mIndex = bVar.mIndex;
        this.EP = bVar.EP;
        this.EQ = bVar.EQ;
        this.ER = bVar.ER;
        this.ES = bVar.ES;
        this.ET = bVar.ET;
        this.EU = bVar.EU;
        this.EV = bVar.EV;
    }

    public BackStackState(Parcel parcel) {
        this.Fc = parcel.createIntArray();
        this.EK = parcel.readInt();
        this.EL = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.EP = parcel.readInt();
        this.EQ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.ER = parcel.readInt();
        this.ES = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.ET = parcel.createStringArrayList();
        this.EU = parcel.createStringArrayList();
        this.EV = parcel.readInt() != 0;
    }

    public final b a(FragmentManagerImpl fragmentManagerImpl) {
        b bVar = new b(fragmentManagerImpl);
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.Fc.length) {
            b.a aVar = new b.a();
            int i4 = i3 + 1;
            aVar.EX = this.Fc[i3];
            if (FragmentManagerImpl.DEBUG) {
                new StringBuilder("Instantiate ").append(bVar).append(" op #").append(i2).append(" base fragment #").append(this.Fc[i4]);
            }
            int i5 = i4 + 1;
            int i6 = this.Fc[i4];
            if (i6 >= 0) {
                aVar.fragment = fragmentManagerImpl.mActive.get(i6);
            } else {
                aVar.fragment = null;
            }
            int i7 = i5 + 1;
            aVar.EY = this.Fc[i5];
            int i8 = i7 + 1;
            aVar.EZ = this.Fc[i7];
            int i9 = i8 + 1;
            aVar.Fa = this.Fc[i8];
            i3 = i9 + 1;
            aVar.Fb = this.Fc[i9];
            bVar.EG = aVar.EY;
            bVar.EH = aVar.EZ;
            bVar.EI = aVar.Fa;
            bVar.EJ = aVar.Fb;
            bVar.a(aVar);
            i2++;
        }
        bVar.EK = this.EK;
        bVar.EL = this.EL;
        bVar.mName = this.mName;
        bVar.mIndex = this.mIndex;
        bVar.EM = true;
        bVar.EP = this.EP;
        bVar.EQ = this.EQ;
        bVar.ER = this.ER;
        bVar.ES = this.ES;
        bVar.ET = this.ET;
        bVar.EU = this.EU;
        bVar.EV = this.EV;
        bVar.aq(1);
        return bVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int i3 = 0;
        parcel.writeIntArray(this.Fc);
        parcel.writeInt(this.EK);
        parcel.writeInt(this.EL);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.EP);
        TextUtils.writeToParcel(this.EQ, parcel, 0);
        parcel.writeInt(this.ER);
        TextUtils.writeToParcel(this.ES, parcel, 0);
        parcel.writeStringList(this.ET);
        parcel.writeStringList(this.EU);
        if (this.EV) {
            i3 = 1;
        }
        parcel.writeInt(i3);
    }
}
