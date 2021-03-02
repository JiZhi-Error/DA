package com.tencent.mm.plugin.emojicapture.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

public class EmojiCaptureReporter implements Parcelable {
    public static final Parcelable.Creator<EmojiCaptureReporter> CREATOR = new Parcelable.Creator<EmojiCaptureReporter>() {
        /* class com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EmojiCaptureReporter[] newArray(int i2) {
            return new EmojiCaptureReporter[0];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EmojiCaptureReporter createFromParcel(Parcel parcel) {
            AppMethodBeat.i(104381);
            EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter(parcel);
            AppMethodBeat.o(104381);
            return emojiCaptureReporter;
        }
    };
    public int dataSize;
    public long dtZ;
    public long gLd;
    public String gXx;
    public boolean hdB;
    public long hdz;
    public boolean ilM;
    public long rnG;
    public long rnH;
    public long rnI;
    public long rnJ;
    public long rnK;
    public long rnL;
    public long rnM;
    public boolean rnN;
    public boolean rnO;
    public int rnP;
    public String rnQ;
    public String rnR;
    public String rnS;
    public int rnT;
    public int rnU;
    public String rnV;
    public int rnW = 2;
    public int rnX = 9;
    public int scene;
    public int textColor;

    public final void h(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(104382);
        this.rnS = str;
        this.rnV = str2;
        this.rnT = i2;
        this.rnU = i3;
        Gh(23);
        AppMethodBeat.o(104382);
    }

    public final void fY(String str, String str2) {
        AppMethodBeat.i(104383);
        h.INSTANCE.a(15982, 27, Long.valueOf(this.hdz), 0, 0, 0, 0, 0, 0, 0, Integer.valueOf(this.scene), str, 0, 0, 0, str2, Integer.valueOf(this.rnW));
        AppMethodBeat.o(104383);
    }

    public final void cIs() {
        AppMethodBeat.i(104384);
        Gh(25);
        AppMethodBeat.o(104384);
    }

    public final void cIt() {
        AppMethodBeat.i(104385);
        Gh(26);
        AppMethodBeat.o(104385);
    }

    public final void bFT() {
        AppMethodBeat.i(104386);
        h.INSTANCE.a(15982, 3, Long.valueOf(this.hdz), 0, 0, 0, 0, 0, 0, 0, Integer.valueOf(this.scene), this.rnS, Integer.valueOf(this.rnT), 0, Integer.valueOf(this.rnU), this.rnV, Integer.valueOf(this.rnW), Integer.valueOf(this.rnX));
        AppMethodBeat.o(104386);
    }

    public final void cIu() {
        int i2;
        int i3;
        int i4 = 1;
        int i5 = 0;
        AppMethodBeat.i(104387);
        if (!Util.isNullOrNil(this.gXx)) {
            this.gXx = this.gXx.replace(",", " ");
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[20];
        objArr[0] = Long.valueOf(this.hdz);
        objArr[1] = Long.valueOf(this.dtZ);
        objArr[2] = Long.valueOf(this.gLd);
        objArr[3] = Long.valueOf(this.rnM);
        objArr[4] = 0;
        objArr[5] = 0;
        objArr[6] = this.gXx;
        objArr[7] = Integer.toHexString(this.textColor & 16777215);
        if (this.rnN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[8] = Integer.valueOf(i2);
        if (this.rnO) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[9] = Integer.valueOf(i3);
        objArr[10] = Integer.valueOf(this.rnP);
        if (this.hdB) {
            i5 = 1;
        }
        objArr[11] = Integer.valueOf(i5);
        objArr[12] = Integer.valueOf(this.dataSize);
        objArr[13] = this.rnQ;
        objArr[14] = "";
        objArr[15] = "";
        if (this.ilM) {
            i4 = 2;
        }
        objArr[16] = Integer.valueOf(i4);
        objArr[17] = this.rnR;
        objArr[18] = this.rnS;
        objArr[19] = this.rnV;
        hVar.a(15989, objArr);
        AppMethodBeat.o(104387);
    }

    public static void a(int i2, long j2, long j3, long j4, long j5, long j6, int i3, int i4, int i5) {
        AppMethodBeat.i(104388);
        h.INSTANCE.a(15982, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), 0L, Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        AppMethodBeat.o(104388);
    }

    public final void cIv() {
        AppMethodBeat.i(104389);
        h.INSTANCE.a(15982, 17, Long.valueOf(this.hdz), 0, 0, Long.valueOf(this.rnM), 0, 0, 0, 0, Integer.valueOf(this.scene), this.rnS, Integer.valueOf(this.rnT), 0, Integer.valueOf(this.rnU), this.rnV, Integer.valueOf(this.rnW), Integer.valueOf(this.rnX));
        AppMethodBeat.o(104389);
    }

    public static void cIw() {
        AppMethodBeat.i(104390);
        h.INSTANCE.a(15982, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, 0);
        AppMethodBeat.o(104390);
    }

    private void Gh(int i2) {
        AppMethodBeat.i(104391);
        h.INSTANCE.a(15982, Integer.valueOf(i2), Long.valueOf(this.hdz), 0, 0, 0, 0, 0, 0, 0, Integer.valueOf(this.scene), this.rnS, Integer.valueOf(this.rnT), 0, Integer.valueOf(this.rnU), this.rnV, Integer.valueOf(this.rnW), Integer.valueOf(this.rnX));
        AppMethodBeat.o(104391);
    }

    public static void f(long j2, long j3, int i2) {
        AppMethodBeat.i(104392);
        a(20, j2, 0, 0, 0, j3, 0, 0, i2);
        AppMethodBeat.o(104392);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void f(long j2, int i2, int i3) {
        AppMethodBeat.i(104393);
        a(22, j2, 0, 0, 0, 0, 0, i2, i3);
        switch (i2) {
            case 1:
                fE(7, 1);
                AppMethodBeat.o(104393);
                return;
            case 2:
                fE(6, 1);
                AppMethodBeat.o(104393);
                return;
            case 3:
                fE(8, 1);
                break;
            case 4:
                fE(28, 1);
                AppMethodBeat.o(104393);
                return;
            case 5:
                fE(22, 1);
                AppMethodBeat.o(104393);
                return;
            case 6:
                fE(24, 1);
                AppMethodBeat.o(104393);
                return;
            case 7:
                fE(25, 1);
                AppMethodBeat.o(104393);
                return;
            case 8:
                fE(26, 1);
                AppMethodBeat.o(104393);
                return;
            case 9:
                fE(27, 1);
                AppMethodBeat.o(104393);
                return;
            case 10:
                AppMethodBeat.o(104393);
                return;
        }
        AppMethodBeat.o(104393);
    }

    public static void g(long j2, long j3, int i2) {
        AppMethodBeat.i(104394);
        a(19, j2, 0, 0, j3, 0, 0, 0, i2);
        fE(1, 1);
        AppMethodBeat.o(104394);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void g(long j2, int i2, int i3) {
        AppMethodBeat.i(104395);
        a(21, j2, 0, 0, 0, 0, i2, 0, i3);
        switch (i2) {
            case 1:
                fE(5, 1);
                break;
            case 3:
                fE(21, 1);
                AppMethodBeat.o(104395);
                return;
            case 4:
                fE(29, 1);
                AppMethodBeat.o(104395);
                return;
            case 5:
                fE(30, 1);
                AppMethodBeat.o(104395);
                return;
        }
        AppMethodBeat.o(104395);
    }

    public static void fE(int i2, int i3) {
        AppMethodBeat.i(104396);
        h.INSTANCE.n(852, (long) i2, (long) i3);
        AppMethodBeat.o(104396);
    }

    public static void Gi(int i2) {
        AppMethodBeat.i(263721);
        fE(i2, 1);
        AppMethodBeat.o(263721);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3 = 1;
        AppMethodBeat.i(104398);
        parcel.writeLong(this.hdz);
        parcel.writeLong(this.rnG);
        parcel.writeLong(this.rnH);
        parcel.writeLong(this.rnI);
        parcel.writeLong(this.rnJ);
        parcel.writeLong(this.rnK);
        parcel.writeLong(this.rnL);
        parcel.writeLong(this.gLd);
        parcel.writeLong(this.rnM);
        parcel.writeLong(this.dtZ);
        parcel.writeInt(this.textColor);
        parcel.writeByte(this.rnN ? (byte) 1 : 0);
        if (this.rnO) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.rnP);
        if (!this.hdB) {
            b3 = 0;
        }
        parcel.writeByte(b3);
        parcel.writeInt(this.dataSize);
        parcel.writeString(this.gXx);
        parcel.writeString(this.rnQ);
        AppMethodBeat.o(104398);
    }

    public EmojiCaptureReporter() {
    }

    public EmojiCaptureReporter(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(104399);
        this.hdz = parcel.readLong();
        this.rnG = parcel.readLong();
        this.rnH = parcel.readLong();
        this.rnI = parcel.readLong();
        this.rnJ = parcel.readLong();
        this.rnK = parcel.readLong();
        this.rnL = parcel.readLong();
        this.gLd = parcel.readLong();
        this.rnM = parcel.readLong();
        this.dtZ = parcel.readLong();
        this.textColor = parcel.readInt();
        this.rnN = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.rnO = z;
        this.rnP = parcel.readInt();
        this.hdB = parcel.readByte() == 0 ? false : z2;
        this.dataSize = parcel.readInt();
        this.gXx = parcel.readString();
        this.rnQ = parcel.readString();
        AppMethodBeat.o(104399);
    }

    static {
        AppMethodBeat.i(104400);
        AppMethodBeat.o(104400);
    }
}
