package com.tencent.mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Pattern;

public final class kv_14609 implements Parcelable {
    public static final Parcelable.Creator<kv_14609> CREATOR = new Parcelable.Creator<kv_14609>() {
        /* class com.tencent.mm.plugin.appbrand.report.model.kv_14609.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ kv_14609[] newArray(int i2) {
            return new kv_14609[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ kv_14609 createFromParcel(Parcel parcel) {
            AppMethodBeat.i(48161);
            kv_14609 kv_14609 = new kv_14609(parcel);
            AppMethodBeat.o(48161);
            return kv_14609;
        }
    };
    public final String appId;
    public int appType;
    public String cBp;
    public int dIZ;
    public int dMe;
    public String kEY;
    public final int kMt;
    public final int mVo;
    public QualitySession mWO;
    public CdnLogic.WebPageProfile nJB;
    public long nJC;
    public final String nJD;
    private int nJE = 1;
    public long nJF;
    public final boolean nJG;
    public boolean nJH;
    public boolean nJI;
    public int nJJ;
    public int nJK;
    public long nJL;
    private long nJM;
    public long nJN;
    public long nJO;
    public int nJP;
    private long nJQ;
    public boolean nJR;
    public int scene;

    public interface a {
        void cancel();

        void proceed();
    }

    public final int aYR() {
        return this.dMe;
    }

    public static kv_14609 ci(String str, int i2) {
        AppMethodBeat.i(175060);
        kv_14609 kv_14609 = new kv_14609(str, 0, 0);
        kv_14609.nJE = i2 + 1;
        AppMethodBeat.o(175060);
        return kv_14609;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public kv_14609(String str, int i2, int i3) {
        AppMethodBeat.i(48162);
        Log.i("MicroMsg.AppBrand.Report.kv_14609", "<init> appid:%s,oldVersion:%s,targetVersion:%s", str, Integer.valueOf(i2), Integer.valueOf(i3));
        this.nJD = str;
        if ("@LibraryAppId".equals(str)) {
            this.appId = "publiclib";
            this.cBp = null;
            this.nJG = v.bvF();
        } else {
            if (str.contains("$")) {
                String[] split = str.split(Pattern.quote("$"));
                this.appId = split[0];
                if (split != null) {
                    switch (split.length) {
                        case 2:
                            String str2 = split[1];
                            if (!Util.isNullOrNil(str2)) {
                                if (!str2.equals(ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE)) {
                                    if (!str2.equals(ModulePkgInfo.MODULE_WITHOUT_MULTI_PLUGIN_CODE)) {
                                        if (!str2.equals(ModulePkgInfo.PLUGIN_CODE)) {
                                            this.cBp = str2;
                                            break;
                                        } else {
                                            this.dMe = 6;
                                            this.cBp = null;
                                            break;
                                        }
                                    } else {
                                        this.dMe = 22;
                                        this.cBp = null;
                                        break;
                                    }
                                } else {
                                    this.dMe = 12;
                                    this.cBp = null;
                                    break;
                                }
                            }
                            break;
                        case 3:
                            this.cBp = split[1];
                            if (!Util.isNullOrNil(split[2])) {
                                if (!split[2].equals(ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE)) {
                                    if (split[2].equals(ModulePkgInfo.MODULE_WITHOUT_MULTI_PLUGIN_CODE)) {
                                        this.dMe = 23;
                                        break;
                                    }
                                } else {
                                    this.dMe = 13;
                                    break;
                                }
                            }
                            break;
                    }
                }
                Log.i("MicroMsg.AppBrand.Report.kv_14609", "getModuleName modulename:%s,appid:%s,pkgtype:%s", this.cBp, this.appId, Integer.valueOf(this.dMe));
            } else {
                this.appId = str;
                this.cBp = null;
            }
            this.nJG = v.bvE();
        }
        this.kMt = i2;
        this.mVo = i3;
        AppMethodBeat.o(48162);
    }

    public final int brf() {
        return this.nJE - 1;
    }

    public final void bUP() {
        AppMethodBeat.i(48163);
        long nowMilliSecond = Util.nowMilliSecond();
        this.nJM = nowMilliSecond;
        this.nJF = nowMilliSecond - this.nJL;
        AppMethodBeat.o(48163);
    }

    public final long bUQ() {
        return this.nJF;
    }

    public final long bUR() {
        return this.nJL;
    }

    public final long bUS() {
        return this.nJM;
    }

    public final int bUT() {
        return this.dIZ;
    }

    public final long bUU() {
        return this.nJO;
    }

    public final boolean bNr() {
        return this.nJK > 0;
    }

    public final String toString() {
        AppMethodBeat.i(48164);
        String str = "kv_14609{appId='" + this.appId + '\'' + ", appstate=" + this.nJE + '\n' + ", moduleName='" + this.cBp + '\'' + ", oldVersion=" + this.kMt + ", targetVersion=" + this.mVo + ", spendTime=" + this.nJF + ", canUsePatchUpdate=" + this.nJG + ", isUpdateComplete=" + this.nJH + ", isUpdateCompleteWithPatch=" + this.nJI + ", fullPkgSize=" + this.nJJ + ", patchSize=" + this.nJK + ", errcode=" + this.dIZ + ", processStartMs=" + this.nJL + ", processEndMs=" + this.nJM + ", gzipReadyTimeMs=" + this.nJN + ", zstdReadyTimeMs=" + this.nJO + ", pkgType=" + this.dMe + ", instanceId='" + this.kEY + '\'' + ", appType=" + this.appType + ", scene=" + this.scene + ", protocol=" + this.nJP + ", downloadSizeBeforeZSTDDecompress=" + this.nJQ + ", isNewDNSUsed=" + this.nJR + '}';
        AppMethodBeat.o(48164);
        return str;
    }

    public final void aeS(String str) {
        this.kEY = str;
    }

    abstract class b implements a {
        private boolean mCanceled;
        private boolean nJT;

        public abstract void bUV();

        private b() {
            this.nJT = false;
            this.mCanceled = false;
        }

        /* synthetic */ b(kv_14609 kv_14609, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.report.model.kv_14609.a
        public final void proceed() {
            if (!this.mCanceled && !this.nJT) {
                bUV();
                this.nJT = true;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.report.model.kv_14609.a
        public final void cancel() {
            this.mCanceled = true;
        }
    }

    public final void report() {
        AppMethodBeat.i(48165);
        this.nJQ = this.nJC;
        AnonymousClass1 r1 = new b() {
            /* class com.tencent.mm.plugin.appbrand.report.model.kv_14609.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.report.model.kv_14609.b
            public final void bUV() {
                int i2;
                int i3;
                int i4 = 1;
                AppMethodBeat.i(48160);
                Log.i("MicroMsg.AppBrand.Report.kv_14609", "report %s", kv_14609.this.toString());
                e eVar = e.INSTANCE;
                Object[] objArr = new Object[24];
                objArr[0] = kv_14609.this.appId;
                objArr[1] = Integer.valueOf(kv_14609.this.nJE);
                objArr[2] = i.getNetworkType(MMApplicationContext.getContext());
                objArr[3] = Integer.valueOf(kv_14609.this.kMt);
                objArr[4] = Integer.valueOf(kv_14609.this.mVo);
                objArr[5] = Long.valueOf(kv_14609.this.nJF);
                objArr[6] = Integer.valueOf(kv_14609.this.nJG ? 1 : 0);
                if (kv_14609.this.nJH) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr[7] = Integer.valueOf(i2);
                if (kv_14609.this.nJI) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                objArr[8] = Integer.valueOf(i3);
                objArr[9] = Integer.valueOf(kv_14609.this.nJJ);
                objArr[10] = Integer.valueOf(kv_14609.this.nJK);
                objArr[11] = Integer.valueOf(kv_14609.this.dIZ);
                objArr[12] = kv_14609.this.cBp;
                objArr[13] = Long.valueOf(kv_14609.this.nJL);
                objArr[14] = Long.valueOf(kv_14609.this.nJM);
                objArr[15] = kv_14609.this.kEY;
                objArr[16] = Long.valueOf(kv_14609.this.nJN);
                objArr[17] = Long.valueOf(kv_14609.this.nJO);
                objArr[18] = Integer.valueOf(kv_14609.this.dMe);
                objArr[19] = Integer.valueOf(kv_14609.this.appType);
                objArr[20] = Integer.valueOf(kv_14609.this.scene);
                objArr[21] = Integer.valueOf(kv_14609.this.nJP);
                objArr[22] = Long.valueOf(kv_14609.this.nJQ);
                if (!kv_14609.this.nJR) {
                    i4 = 0;
                }
                objArr[23] = Integer.valueOf(i4);
                eVar.a(14609, objArr);
                AppMethodBeat.o(48160);
            }
        };
        if (g.aAe().azG().aBb()) {
            lf lfVar = new lf();
            lfVar.dQt.dQu = this;
            lfVar.dQt.dQv = r1;
            EventCenter.instance.publish(lfVar);
        }
        r1.proceed();
        AppMethodBeat.o(48165);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3 = 1;
        AppMethodBeat.i(48166);
        parcel.writeString(this.nJD);
        parcel.writeString(this.appId);
        parcel.writeString(this.cBp);
        parcel.writeInt(this.kMt);
        parcel.writeInt(this.mVo);
        parcel.writeLong(this.nJF);
        parcel.writeByte(this.nJG ? (byte) 1 : 0);
        if (this.nJH) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        if (!this.nJI) {
            b3 = 0;
        }
        parcel.writeByte(b3);
        parcel.writeInt(this.nJJ);
        parcel.writeInt(this.nJK);
        parcel.writeInt(this.dIZ);
        parcel.writeLong(this.nJL);
        parcel.writeLong(this.nJM);
        parcel.writeString(this.kEY);
        parcel.writeLong(this.nJN);
        parcel.writeLong(this.nJO);
        parcel.writeInt(this.dMe);
        parcel.writeInt(this.appType);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.nJP);
        AppMethodBeat.o(48166);
    }

    protected kv_14609(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(48167);
        this.nJD = parcel.readString();
        this.appId = parcel.readString();
        this.cBp = parcel.readString();
        this.kMt = parcel.readInt();
        this.mVo = parcel.readInt();
        this.nJF = parcel.readLong();
        this.nJG = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.nJH = z;
        this.nJI = parcel.readByte() == 0 ? false : z2;
        this.nJJ = parcel.readInt();
        this.nJK = parcel.readInt();
        this.dIZ = parcel.readInt();
        this.nJL = parcel.readLong();
        this.nJM = parcel.readLong();
        this.kEY = parcel.readString();
        this.nJN = parcel.readLong();
        this.nJO = parcel.readLong();
        this.dMe = parcel.readInt();
        this.appType = parcel.readInt();
        this.scene = parcel.readInt();
        this.nJP = parcel.readInt();
        AppMethodBeat.o(48167);
    }

    static {
        AppMethodBeat.i(48168);
        AppMethodBeat.o(48168);
    }
}
