package com.tencent.mm.plugin.voip.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public class VoipScoreState implements Parcelable {
    public static final Parcelable.Creator<VoipScoreState> CREATOR = new Parcelable.Creator<VoipScoreState>() {
        /* class com.tencent.mm.plugin.voip.model.VoipScoreState.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VoipScoreState[] newArray(int i2) {
            return new VoipScoreState[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VoipScoreState createFromParcel(Parcel parcel) {
            AppMethodBeat.i(115101);
            VoipScoreState voipScoreState = new VoipScoreState(parcel);
            AppMethodBeat.o(115101);
            return voipScoreState;
        }
    };
    public String GYP = "";
    public int GYQ = -1;
    public long GYR = 0;
    public int roomId = -1;
    public long ypH = -1;
    public long yrb = -1;

    public VoipScoreState() {
        AppMethodBeat.i(115102);
        Log.printInfoStack("MicroMsg.VoipScoreState", "create VoipScoreState", new Object[0]);
        AppMethodBeat.o(115102);
    }

    protected VoipScoreState(Parcel parcel) {
        AppMethodBeat.i(115103);
        this.GYP = parcel.readString();
        this.GYQ = parcel.readInt();
        this.roomId = parcel.readInt();
        this.ypH = parcel.readLong();
        this.yrb = parcel.readLong();
        this.GYR = parcel.readLong();
        AppMethodBeat.o(115103);
    }

    static {
        AppMethodBeat.i(115108);
        AppMethodBeat.o(115108);
    }

    public final void d(String str, int i2, int i3, long j2) {
        AppMethodBeat.i(115104);
        Log.i("MicroMsg.VoipScoreState", "setScoreState, roomId:%s, roomKey:%s, title:%s, interval:%s", Integer.valueOf(i3), Long.valueOf(j2), str, Integer.valueOf(i2));
        this.roomId = i3;
        this.ypH = j2;
        if (!Util.isNullOrNil(str)) {
            try {
                String str2 = new String(Base64.decode(str.getBytes(), 0));
                Log.printInfoStack("MicroMsg.VoipScoreState", "setScoreState, title:%s, interval:%s", str2, Integer.valueOf(i2));
                this.GYQ = i2;
                this.GYP = str2;
                AppMethodBeat.o(115104);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VoipScoreState", e2, "setScoreState error: %s", e2.getMessage());
            }
        }
        AppMethodBeat.o(115104);
    }

    public final boolean fHP() {
        AppMethodBeat.i(235665);
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_VOIP_LAST_SCORE_TIME_LONG, (Object) -1L)).longValue();
        this.GYR = longValue > 0 ? longValue : 0;
        long aVP = bp.aVP();
        Log.i("MicroMsg.VoipScoreState", "needShowScoreDialog, current:%s, lastShowScoreTime:%s, scoreIntervalDay:%s", Long.valueOf(aVP), Long.valueOf(longValue), Integer.valueOf(this.GYQ));
        if (Util.isNullOrNil(this.GYP) || this.GYQ <= 0 || (longValue > 0 && aVP - longValue <= ((long) this.GYQ) * Util.MILLSECONDS_OF_DAY)) {
            AppMethodBeat.o(235665);
            return false;
        }
        Log.i("MicroMsg.VoipScoreState", "needShowScoreDialog, exceed limit");
        AppMethodBeat.o(235665);
        return true;
    }

    public static void fHQ() {
        AppMethodBeat.i(115105);
        long aVP = bp.aVP();
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_VOIP_LAST_SCORE_TIME_LONG, Long.valueOf(aVP));
        Log.i("MicroMsg.VoipScoreState", "markShowScoreDialog %s", Long.valueOf(aVP));
        AppMethodBeat.o(115105);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(115106);
        parcel.writeString(this.GYP);
        parcel.writeInt(this.GYQ);
        parcel.writeInt(this.roomId);
        parcel.writeLong(this.ypH);
        parcel.writeLong(this.yrb);
        parcel.writeLong(this.GYR);
        AppMethodBeat.o(115106);
    }

    public String toString() {
        AppMethodBeat.i(115107);
        String str = "VoipScoreState{scoreTitle='" + this.GYP + '\'' + ", scoreIntervalDay=" + this.GYQ + ", roomId=" + this.roomId + ", roomKey=" + this.ypH + ", startTalkTime=" + this.yrb + ", lastShowScoreTime=" + this.GYR + '}';
        AppMethodBeat.o(115107);
        return str;
    }
}
