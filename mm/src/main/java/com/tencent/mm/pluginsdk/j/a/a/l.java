package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.pluginsdk.j.a.a.j;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

/* access modifiers changed from: package-private */
public final class l {
    private final long IBJ;
    private final int JYA;
    private final int JYB;
    final boolean JYZ;
    final String JYs;
    private final String JYv;
    private final int JYw;
    private final byte[] JYx;
    private final String JYz;
    volatile String JZB = null;
    final boolean JZa;
    private final int dEO;
    private final int dEP;
    private final boolean dEQ;
    private final String dER;
    private final boolean dEU;
    final String filePath;
    volatile int state = -1;
    private final int subType;
    private final String url;
    volatile String xli = null;

    l(int i2, int i3, String str, boolean z, boolean z2, String str2, int i4, boolean z3, boolean z4, byte[] bArr, String str3, String str4, long j2, String str5, int i5, int i6, int i7) {
        AppMethodBeat.i(151994);
        this.JYs = i.kD(i2, i3);
        this.dEO = i2;
        this.subType = i3;
        this.filePath = str;
        this.JZa = z;
        this.JYZ = z2;
        this.JYv = str2;
        this.JYw = i4;
        this.JYx = bArr;
        this.dER = str3;
        this.dEU = z3;
        this.dEQ = z4;
        this.JYz = str4;
        this.IBJ = j2;
        this.url = str5;
        this.JYA = i5;
        this.JYB = i6;
        this.dEP = i7;
        AppMethodBeat.o(151994);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.pluginsdk.j.a.a.l gnN() {
        /*
        // Method dump skipped, instructions count: 449
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.j.a.a.l.gnN():com.tencent.mm.pluginsdk.j.a.a.l");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.pluginsdk.j.a.a.l gnO() {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.j.a.a.l.gnO():com.tencent.mm.pluginsdk.j.a.a.l");
    }

    /* access modifiers changed from: package-private */
    public final String gnP() {
        AppMethodBeat.i(151997);
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + gnR(), this.JYs);
        if (16 == this.state) {
            String str = this.JZB;
            AppMethodBeat.o(151997);
            return str;
        } else if (4 == this.state || 32 == this.state) {
            String gnQ = gnQ();
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.JYs, gnQ);
            if (this.state == 4) {
                if (Util.isNullOrNil(gnQ) && !this.JYZ) {
                    j.F(this.IBJ, 58);
                    j.F(this.IBJ, 45);
                }
                if (Util.isNullOrNil(gnQ)) {
                    if (this.JZa) {
                        j.a(this.dEO, this.subType, this.JYw, this.dEU, true, true, false, this.JYz);
                    } else if (this.JYZ && this.dEQ) {
                        j.a(this.dEO, this.subType, this.url, this.dEP, this.JYA > this.JYB ? j.a.RETRY_SUCC : j.a.SUCC, false, this.dEU, true, this.JYz);
                    }
                } else if (this.JZa) {
                    j.a(this.dEO, this.subType, this.JYw, this.dEU, true, true, true, this.JYz);
                } else if (this.JYZ && this.dEQ) {
                    j.a(this.dEO, this.subType, this.url, this.dEP, this.JYA > this.JYB ? j.a.RETRY_SUCC : j.a.SUCC, true, this.dEU, true, this.JYz);
                }
            }
            AppMethodBeat.o(151997);
            return gnQ;
        } else {
            AppMethodBeat.o(151997);
            return null;
        }
    }

    private String gnQ() {
        String valueOf;
        AppMethodBeat.i(151998);
        if (Util.isNullOrNil(this.JZB)) {
            AppMethodBeat.o(151998);
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = this.JYs;
        objArr[1] = gnR();
        objArr[2] = this.dER;
        if (this.JYx == null) {
            valueOf = BuildConfig.COMMAND;
        } else {
            valueOf = String.valueOf(this.JYx.length);
        }
        objArr[3] = valueOf;
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s", objArr);
        if (Util.isNullOrNil(this.dER) || !Util.nullAsNil(s.bhK(this.JZB)).equals(this.dER)) {
            if (this.state == 4) {
                j.F(this.IBJ, 24);
            }
            if (Util.isNullOrNil(this.JYx) || UtilsJni.doEcdsaSHAVerify(i.JZc, a.bei(this.JZB), this.JYx) <= 0) {
                if (this.state == 4) {
                    j.F(this.IBJ, 26);
                }
                AppMethodBeat.o(151998);
                return null;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", this.JYs, gnR());
            if (this.state == 4) {
                j.F(this.IBJ, 25);
            }
            String str = this.JZB;
            AppMethodBeat.o(151998);
            return str;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", this.JYs, gnR());
        if (this.state == 4) {
            j.F(this.IBJ, 23);
        }
        String str2 = this.JZB;
        AppMethodBeat.o(151998);
        return str2;
    }

    /* access modifiers changed from: package-private */
    public final String gnR() {
        AppMethodBeat.i(151999);
        switch (this.state) {
            case 1:
                AppMethodBeat.o(151999);
                return "state_decrypt";
            case 2:
                AppMethodBeat.o(151999);
                return "state_decompress";
            case 4:
                AppMethodBeat.o(151999);
                return "state_check_sum";
            case 8:
                AppMethodBeat.o(151999);
                return "state_file_invalid";
            case 16:
                AppMethodBeat.o(151999);
                return "state_file_valid";
            case 32:
                AppMethodBeat.o(151999);
                return "state_pre_verify_check_sum";
            default:
                String sb = new StringBuilder().append(this.state).toString();
                AppMethodBeat.o(151999);
                return sb;
        }
    }
}
