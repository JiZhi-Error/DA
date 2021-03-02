package com.tencent.mm.plugin.ai.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.ai.d.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.HashSet;

public final class b {
    String dNA;
    String kxA;
    String kxB;
    String kxC;
    int kxD;
    int kxE;
    int kxF;
    int kxG;
    HashSet<String> kxH = new HashSet<>();
    boolean kxr = false;
    private PBool kxs = null;
    String kxt;
    String kxu;
    String kxv;
    String kxw;
    String kxx;
    String kxy;
    String kxz;
    int pos;

    public b(String str) {
        AppMethodBeat.i(238928);
        this.dNA = str;
        AppMethodBeat.o(238928);
    }

    /* access modifiers changed from: package-private */
    public final void TL(String str) {
        String[] split;
        AppMethodBeat.i(238929);
        if (!Util.isNullOrNil(str) && (split = str.split("#")) != null && split.length > 0) {
            for (String str2 : split) {
                this.kxH.add(str2);
            }
        }
        Log.i("MicroMsg.FinderRedDotConfig", "parse no predict session id [%s]", str);
        AppMethodBeat.o(238929);
    }

    /* access modifiers changed from: protected */
    public final int getPos() {
        if (!this.kxr) {
            return -1;
        }
        return this.pos;
    }

    /* access modifiers changed from: protected */
    public final boolean bqA() {
        if (this.kxr && this.kxD > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int bqB() {
        if (!this.kxr) {
            return -1;
        }
        if (this.kxD > 0) {
            return this.kxD;
        }
        if (this.kxE > 0) {
            return this.kxE;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public final boolean a(a aVar, PString pString, PString pString2, PString pString3) {
        char c2;
        String str;
        String z;
        boolean cj;
        String str2;
        AppMethodBeat.i(238930);
        if (!this.kxr) {
            AppMethodBeat.o(238930);
            return false;
        }
        pString3.value = "";
        pString2.value = "";
        pString.value = "";
        try {
            PString pString4 = new PString();
            String str3 = this.kxt;
            pString4.value = "";
            String TM = com.tencent.mm.plugin.ai.f.b.bqC().TM(str3);
            if (Util.isNullOrNil(TM)) {
                c2 = 65535;
            } else if (!s.YS(TM)) {
                c2 = 65535;
            } else {
                pString4.value = TM;
                c2 = 0;
            }
            switch (c2) {
                case 0:
                    h.INSTANCE.dN(1559, 30);
                    str = pString4.value;
                    break;
                default:
                    String str4 = this.kxt;
                    String str5 = this.kxu;
                    long j2 = 0;
                    if (aVar.kwG.containsKey(str4)) {
                        j2 = aVar.kwG.get(str4).longValue();
                    }
                    if (Util.milliSecondsToNow(j2) > 1800000) {
                        h.INSTANCE.dN(1559, 0);
                        aVar.kwG.put(str4, new Long(Util.nowMilliSecond()));
                        com.tencent.mm.plugin.ai.f.b bqC = com.tencent.mm.plugin.ai.f.b.bqC();
                        if (Util.isNullOrNil(str4)) {
                            str2 = "";
                        } else {
                            str2 = bqC.kxN + str4.hashCode() + ".file";
                        }
                        com.tencent.mm.plugin.ai.d.a.b bVar = new com.tencent.mm.plugin.ai.d.a.b(str4, str2, str5, aVar.kwH, com.tencent.mm.plugin.ai.f.b.bqC().TM(str4));
                        g gVar = new g();
                        gVar.field_mediaId = bVar.mediaId;
                        gVar.gqB = bVar.url;
                        gVar.field_fullpath = bVar.kwN;
                        gVar.field_fileType = com.tencent.mm.i.a.gqg;
                        gVar.gqF = false;
                        gVar.gqy = bVar;
                        f.baQ().b(gVar, -1);
                        Log.i("MicroMsg.AiDownloadTask", "start to download task [%s] [%s] [%s]", bVar.mediaId, bVar.kwN, bVar.url);
                        Log.i("MicroMsg.AiDownloadLogic", "%s add to download url[%s] path[%s] md5[%s]", aVar.info(), str4, str2, str5);
                    }
                    str = "";
                    break;
            }
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(238930);
                return false;
            }
            if (org.tensorflow.lite.a.a.Ujx.value) {
                cj = true;
            } else {
                com.tencent.mm.plugin.ai.f.b.bqC();
                o X = o.X(MMApplicationContext.getContext().getDir("aimodel", 0));
                if (X.exists() || X.mkdirs()) {
                    z = aa.z(X.her());
                } else {
                    z = "";
                }
                if (Util.isNullOrNil(z)) {
                    h.INSTANCE.dN(1559, 31);
                    cj = false;
                } else {
                    String z2 = z("libtensorflowlite_jni.so", this.kxv, z);
                    if (Util.isNullOrNil(z2)) {
                        PString pString5 = new PString();
                        if (a.a(this.kxv, "libtensorflowlite_jni.so", str, pString5) != 0 || Util.isNullOrNil(pString5.value)) {
                            h.INSTANCE.dN(1559, 32);
                            cj = false;
                        } else {
                            z2 = A(z, "libtensorflowlite_jni.so", pString5.value);
                            if (Util.isNullOrNil(z2)) {
                                h.INSTANCE.dN(1559, 33);
                                cj = false;
                            }
                        }
                    }
                    String z3 = z("libtensorflowlite_flex_jni.so", this.kxw, z);
                    if (Util.isNullOrNil(z3)) {
                        PString pString6 = new PString();
                        if (a.a(this.kxw, "libtensorflowlite_flex_jni.so", str, pString6) != 0 || Util.isNullOrNil(pString6.value)) {
                            h.INSTANCE.dN(1559, 34);
                            cj = false;
                        } else {
                            z3 = A(z, "libtensorflowlite_flex_jni.so", pString6.value);
                            if (Util.isNullOrNil(z3)) {
                                h.INSTANCE.dN(1559, 35);
                                cj = false;
                            }
                        }
                    }
                    cj = cj(z2, z3);
                }
            }
            if (!cj) {
                Log.w("MicroMsg.FinderRedDotConfig", "load tensorflow lite so error");
                s.dy(str, true);
                AppMethodBeat.o(238930);
                return false;
            }
            PString pString7 = new PString();
            switch (a.a(this.kxy, this.kxx, str, pString7)) {
                case -2:
                    h.INSTANCE.dN(1559, 1);
                    break;
                case 0:
                    h.INSTANCE.dN(1559, 2);
                    break;
            }
            pString.value = pString7.value;
            if (Util.isNullOrNil(pString.value)) {
                Log.w("MicroMsg.FinderRedDotConfig", "model file is null");
                s.dy(str, true);
                AppMethodBeat.o(238930);
                return false;
            }
            PString pString8 = new PString();
            switch (a.a(this.kxA, this.kxz, str, pString8)) {
                case -2:
                    h.INSTANCE.dN(1559, 40);
                    break;
                case 0:
                    h.INSTANCE.dN(1559, 39);
                    break;
            }
            pString2.value = pString8.value;
            if (Util.isNullOrNil(pString2.value)) {
                Log.w("MicroMsg.FinderRedDotConfig", "model Quantiles file is null");
                s.dy(str, true);
                AppMethodBeat.o(238930);
                return false;
            }
            PString pString9 = new PString();
            switch (a.a(this.kxC, this.kxB, str, pString9)) {
                case -2:
                    h.INSTANCE.dN(1559, 42);
                    break;
                case 0:
                    h.INSTANCE.dN(1559, 41);
                    break;
            }
            pString3.value = pString9.value;
            if (Util.isNullOrNil(pString3.value)) {
                Log.w("MicroMsg.FinderRedDotConfig", "model Tffeat2idx file is null");
                s.dy(str, true);
                AppMethodBeat.o(238930);
                return false;
            }
            AppMethodBeat.o(238930);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", e2, "start to check error", new Object[0]);
            AppMethodBeat.o(238930);
            return false;
        }
    }

    private boolean cj(String str, String str2) {
        AppMethodBeat.i(238931);
        long currentTicks = Util.currentTicks();
        if (this.kxs == null) {
            this.kxs = new PBool();
            this.kxs.value = false;
            try {
                System.load(str);
                try {
                    System.load(str2);
                    this.kxs.value = true;
                    org.tensorflow.lite.a.a.Ujx.value = true;
                } catch (UnsatisfiedLinkError e2) {
                    Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", e2, "", new Object[0]);
                    h.INSTANCE.dN(1559, 37);
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", e3, "", new Object[0]);
                    h.INSTANCE.dN(1559, 37);
                }
            } catch (UnsatisfiedLinkError e4) {
                Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", e4, "", new Object[0]);
                h.INSTANCE.dN(1559, 36);
            } catch (Exception e5) {
                Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", e5, "", new Object[0]);
                h.INSTANCE.dN(1559, 36);
            }
        }
        Log.i("MicroMsg.FinderRedDotConfig", "load tensorflow lite so [%b] cost[%d]", Boolean.valueOf(this.kxs.value), Long.valueOf(Util.ticksToNow(currentTicks)));
        boolean z = this.kxs.value;
        AppMethodBeat.o(238931);
        return z;
    }

    private static String z(String str, String str2, String str3) {
        AppMethodBeat.i(238932);
        o oVar = new o(str3, str);
        if (!oVar.exists()) {
            AppMethodBeat.o(238932);
            return "";
        } else if (!str2.equalsIgnoreCase(com.tencent.mm.b.g.a(oVar, ShareConstants.MD5_FILE_BUF_LENGTH))) {
            oVar.delete();
            AppMethodBeat.o(238932);
            return "";
        } else {
            String z = aa.z(oVar.her());
            AppMethodBeat.o(238932);
            return z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String A(java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ai.e.b.A(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
