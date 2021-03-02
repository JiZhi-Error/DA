package com.tencent.mm.game.report.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public class GameWebPerformanceInfo implements Parcelable {
    public static final Parcelable.Creator<GameWebPerformanceInfo> CREATOR = new Parcelable.Creator<GameWebPerformanceInfo>() {
        /* class com.tencent.mm.game.report.api.GameWebPerformanceInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GameWebPerformanceInfo[] newArray(int i2) {
            return new GameWebPerformanceInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GameWebPerformanceInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(117605);
            GameWebPerformanceInfo gameWebPerformanceInfo = new GameWebPerformanceInfo(parcel, (byte) 0);
            AppMethodBeat.o(117605);
            return gameWebPerformanceInfo;
        }
    };
    private static Map<String, GameWebPerformanceInfo> hib = new HashMap();
    public int hhA;
    public int hhB;
    public int hhC;
    public String hhD;
    public long hhE;
    public long hhF;
    public long hhG;
    public long hhH;
    public long hhI;
    public long hhJ;
    public long hhK;
    public long hhL;
    public long hhM;
    public long hhN;
    public long hhO;
    public long hhP;
    public long hhQ;
    public long hhR;
    public long hhS;
    public long hhT;
    public long hhU;
    public long hhV;
    public long hhW;
    public long hhX;
    public String hhY;
    public String hhZ;
    public String hhu;
    public int hhv;
    public int hhw;
    public int hhx;
    public int hhy;
    public int hhz;
    public String hia;
    public long startTime;
    public String url;

    /* synthetic */ GameWebPerformanceInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(117606);
        parcel.writeString(this.url);
        parcel.writeString(this.hhu);
        parcel.writeInt(this.hhv);
        parcel.writeInt(this.hhw);
        parcel.writeInt(this.hhx);
        parcel.writeInt(this.hhy);
        parcel.writeInt(this.hhz);
        parcel.writeInt(this.hhA);
        parcel.writeInt(this.hhB);
        parcel.writeInt(this.hhC);
        parcel.writeString(this.hhD);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.hhE);
        parcel.writeLong(this.hhF);
        parcel.writeLong(this.hhG);
        parcel.writeLong(this.hhH);
        parcel.writeLong(this.hhI);
        parcel.writeLong(this.hhJ);
        parcel.writeLong(this.hhK);
        parcel.writeLong(this.hhL);
        parcel.writeLong(this.hhM);
        parcel.writeLong(this.hhN);
        parcel.writeLong(this.hhO);
        parcel.writeLong(this.hhP);
        parcel.writeLong(this.hhQ);
        parcel.writeLong(this.hhR);
        parcel.writeLong(this.hhS);
        parcel.writeLong(this.hhT);
        parcel.writeLong(this.hhU);
        parcel.writeLong(this.hhV);
        parcel.writeLong(this.hhW);
        parcel.writeLong(this.hhX);
        parcel.writeString(this.hhY);
        parcel.writeString(this.hhZ);
        parcel.writeString(this.hia);
        AppMethodBeat.o(117606);
    }

    private GameWebPerformanceInfo(Parcel parcel) {
        AppMethodBeat.i(117607);
        this.url = parcel.readString();
        this.hhu = parcel.readString();
        this.hhv = parcel.readInt();
        this.hhw = parcel.readInt();
        this.hhx = parcel.readInt();
        this.hhy = parcel.readInt();
        this.hhz = parcel.readInt();
        this.hhA = parcel.readInt();
        this.hhB = parcel.readInt();
        this.hhC = parcel.readInt();
        this.hhD = parcel.readString();
        this.startTime = parcel.readLong();
        this.hhE = parcel.readLong();
        this.hhF = parcel.readLong();
        this.hhG = parcel.readLong();
        this.hhH = parcel.readLong();
        this.hhI = parcel.readLong();
        this.hhJ = parcel.readLong();
        this.hhK = parcel.readLong();
        this.hhL = parcel.readLong();
        this.hhM = parcel.readLong();
        this.hhN = parcel.readLong();
        this.hhO = parcel.readLong();
        this.hhP = parcel.readLong();
        this.hhQ = parcel.readLong();
        this.hhR = parcel.readLong();
        this.hhS = parcel.readLong();
        this.hhT = parcel.readLong();
        this.hhU = parcel.readLong();
        this.hhV = parcel.readLong();
        this.hhW = parcel.readLong();
        this.hhX = parcel.readLong();
        this.hhY = parcel.readString();
        this.hhZ = parcel.readString();
        this.hia = parcel.readString();
        AppMethodBeat.o(117607);
    }

    public GameWebPerformanceInfo() {
    }

    static {
        AppMethodBeat.i(117612);
        AppMethodBeat.o(117612);
    }

    public String toString() {
        AppMethodBeat.i(117608);
        String format = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s, jsBridgeErrMsg: %s", this.url, Integer.valueOf(this.hhv), Integer.valueOf(this.hhw), Integer.valueOf(this.hhx), Integer.valueOf(this.hhy), Integer.valueOf(this.hhz), Integer.valueOf(this.hhB), Integer.valueOf(this.hhC), this.hhD, Long.valueOf(this.startTime), Long.valueOf(this.hhE), Long.valueOf(this.hhF), Long.valueOf(this.hhI), Long.valueOf(this.hhH), Long.valueOf(this.hhI), Long.valueOf(this.hhJ), Long.valueOf(this.hhK), Long.valueOf(this.hhL), Long.valueOf(this.hhM), Long.valueOf(this.hhN), Long.valueOf(this.hhO), Long.valueOf(this.hhP), Long.valueOf(this.hhQ), Long.valueOf(this.hhR), Long.valueOf(this.hhS), Long.valueOf(this.hhT), Long.valueOf(this.hhU), Long.valueOf(this.hhV), this.hhY, this.hhZ, this.hia);
        AppMethodBeat.o(117608);
        return format;
    }

    public static synchronized GameWebPerformanceInfo Fd(String str) {
        GameWebPerformanceInfo gameWebPerformanceInfo;
        synchronized (GameWebPerformanceInfo.class) {
            AppMethodBeat.i(117609);
            if (Util.isNullOrNil(str)) {
                gameWebPerformanceInfo = new GameWebPerformanceInfo();
                AppMethodBeat.o(117609);
            } else if (hib.containsKey(str)) {
                gameWebPerformanceInfo = hib.get(str);
                AppMethodBeat.o(117609);
            } else {
                gameWebPerformanceInfo = new GameWebPerformanceInfo();
                hib.put(str, gameWebPerformanceInfo);
                AppMethodBeat.o(117609);
            }
        }
        return gameWebPerformanceInfo;
    }

    public static synchronized GameWebPerformanceInfo Fe(String str) {
        GameWebPerformanceInfo gameWebPerformanceInfo;
        synchronized (GameWebPerformanceInfo.class) {
            AppMethodBeat.i(117610);
            if (hib.containsKey(str)) {
                hib.remove(str);
            }
            gameWebPerformanceInfo = new GameWebPerformanceInfo();
            hib.put(str, gameWebPerformanceInfo);
            AppMethodBeat.o(117610);
        }
        return gameWebPerformanceInfo;
    }

    public static GameWebPerformanceInfo Ff(String str) {
        AppMethodBeat.i(117611);
        GameWebPerformanceInfo remove = hib.remove(str);
        AppMethodBeat.o(117611);
        return remove;
    }
}
