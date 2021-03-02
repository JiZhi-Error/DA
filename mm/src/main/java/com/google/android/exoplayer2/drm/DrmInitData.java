package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() {
        /* class com.google.android.exoplayer2.drm.DrmInitData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrmInitData[] newArray(int i2) {
            return new DrmInitData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrmInitData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(91866);
            DrmInitData drmInitData = new DrmInitData(parcel);
            AppMethodBeat.o(91866);
            return drmInitData;
        }
    };
    private int aHK;
    public final SchemeData[] bhB;
    public final int bhC;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(SchemeData schemeData, SchemeData schemeData2) {
        AppMethodBeat.i(91881);
        SchemeData schemeData3 = schemeData;
        SchemeData schemeData4 = schemeData2;
        if (!b.bbJ.equals(schemeData3.uuid)) {
            int compareTo = schemeData3.uuid.compareTo(schemeData4.uuid);
            AppMethodBeat.o(91881);
            return compareTo;
        } else if (b.bbJ.equals(schemeData4.uuid)) {
            AppMethodBeat.o(91881);
            return 0;
        } else {
            AppMethodBeat.o(91881);
            return 1;
        }
    }

    public DrmInitData(List<SchemeData> list) {
        this(false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
        AppMethodBeat.i(91874);
        AppMethodBeat.o(91874);
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(true, schemeDataArr);
    }

    private DrmInitData(boolean z, SchemeData... schemeDataArr) {
        SchemeData[] schemeDataArr2;
        AppMethodBeat.i(91875);
        if (z) {
            schemeDataArr2 = (SchemeData[]) schemeDataArr.clone();
        } else {
            schemeDataArr2 = schemeDataArr;
        }
        Arrays.sort(schemeDataArr2, this);
        for (int i2 = 1; i2 < schemeDataArr2.length; i2++) {
            if (schemeDataArr2[i2 - 1].uuid.equals(schemeDataArr2[i2].uuid)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Duplicate data for uuid: " + schemeDataArr2[i2].uuid);
                AppMethodBeat.o(91875);
                throw illegalArgumentException;
            }
        }
        this.bhB = schemeDataArr2;
        this.bhC = schemeDataArr2.length;
        AppMethodBeat.o(91875);
    }

    DrmInitData(Parcel parcel) {
        AppMethodBeat.i(91876);
        this.bhB = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.bhC = this.bhB.length;
        AppMethodBeat.o(91876);
    }

    public final DrmInitData bg(String str) {
        boolean z;
        SchemeData schemeData;
        AppMethodBeat.i(91877);
        SchemeData[] schemeDataArr = this.bhB;
        int length = schemeDataArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (!x.j(schemeDataArr[i2].type, str)) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            SchemeData[] schemeDataArr2 = new SchemeData[this.bhB.length];
            for (int i3 = 0; i3 < schemeDataArr2.length; i3++) {
                SchemeData schemeData2 = this.bhB[i3];
                if (x.j(schemeData2.type, str)) {
                    schemeData = schemeData2;
                } else {
                    schemeData = new SchemeData(schemeData2.uuid, str, schemeData2.mimeType, schemeData2.data, schemeData2.bhD);
                }
                schemeDataArr2[i3] = schemeData;
            }
            DrmInitData drmInitData = new DrmInitData(schemeDataArr2);
            AppMethodBeat.o(91877);
            return drmInitData;
        }
        AppMethodBeat.o(91877);
        return this;
    }

    public final int hashCode() {
        AppMethodBeat.i(91878);
        if (this.aHK == 0) {
            this.aHK = Arrays.hashCode(this.bhB);
        }
        int i2 = this.aHK;
        AppMethodBeat.o(91878);
        return i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91879);
        if (this == obj) {
            AppMethodBeat.o(91879);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(91879);
            return false;
        } else {
            boolean equals = Arrays.equals(this.bhB, ((DrmInitData) obj).bhB);
            AppMethodBeat.o(91879);
            return equals;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(91880);
        parcel.writeTypedArray(this.bhB, 0);
        AppMethodBeat.o(91880);
    }

    static {
        AppMethodBeat.i(91882);
        AppMethodBeat.o(91882);
    }

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() {
            /* class com.google.android.exoplayer2.drm.DrmInitData.SchemeData.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SchemeData[] newArray(int i2) {
                return new SchemeData[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SchemeData createFromParcel(Parcel parcel) {
                AppMethodBeat.i(91867);
                SchemeData schemeData = new SchemeData(parcel);
                AppMethodBeat.o(91867);
                return schemeData;
            }
        };
        private int aHK;
        public final boolean bhD;
        public final byte[] data;
        public final String mimeType;
        public final String type;
        final UUID uuid;

        public SchemeData(UUID uuid2, String str, byte[] bArr) {
            this(uuid2, null, str, bArr, false);
        }

        public SchemeData(UUID uuid2, String str, String str2, byte[] bArr, boolean z) {
            AppMethodBeat.i(91868);
            this.uuid = (UUID) a.checkNotNull(uuid2);
            this.type = str;
            this.mimeType = (String) a.checkNotNull(str2);
            this.data = (byte[]) a.checkNotNull(bArr);
            this.bhD = z;
            AppMethodBeat.o(91868);
        }

        SchemeData(Parcel parcel) {
            AppMethodBeat.i(91869);
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.type = parcel.readString();
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.bhD = parcel.readByte() != 0;
            AppMethodBeat.o(91869);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(91870);
            if (!(obj instanceof SchemeData)) {
                AppMethodBeat.o(91870);
                return false;
            } else if (obj == this) {
                AppMethodBeat.o(91870);
                return true;
            } else {
                SchemeData schemeData = (SchemeData) obj;
                if (!this.mimeType.equals(schemeData.mimeType) || !x.j(this.uuid, schemeData.uuid) || !x.j(this.type, schemeData.type) || !Arrays.equals(this.data, schemeData.data)) {
                    AppMethodBeat.o(91870);
                    return false;
                }
                AppMethodBeat.o(91870);
                return true;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(91871);
            if (this.aHK == 0) {
                this.aHK = (((((this.type == null ? 0 : this.type.hashCode()) + (this.uuid.hashCode() * 31)) * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            int i2 = this.aHK;
            AppMethodBeat.o(91871);
            return i2;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(91872);
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.type);
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte((byte) (this.bhD ? 1 : 0));
            AppMethodBeat.o(91872);
        }

        static {
            AppMethodBeat.i(91873);
            AppMethodBeat.o(91873);
        }
    }
}
