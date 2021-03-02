package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class x implements ae.b {
    private static final ConcurrentHashMap<String, Boolean> kLf = new ConcurrentHashMap<>();

    public static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(226357);
        if (aVar == null) {
            AppMethodBeat.o(226357);
            return false;
        } else if (ba.class == aVar.getClass() || av.class == aVar.getClass() || aw.class == aVar.getClass() || bs.class == aVar.getClass()) {
            AppMethodBeat.o(226357);
            return true;
        } else {
            AppMethodBeat.o(226357);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.ae.b
    public final ae.a b(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(44293);
        if (a(aVar)) {
            a aVar2 = new a(aVar, (byte) 0);
            AppMethodBeat.o(44293);
            return aVar2;
        }
        AppMethodBeat.o(44293);
        return null;
    }

    static {
        AppMethodBeat.i(44296);
        AppMethodBeat.o(44296);
    }

    public static void Va(String str) {
        AppMethodBeat.i(44294);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44294);
            return;
        }
        kLf.put(str, Boolean.TRUE);
        AppMethodBeat.o(44294);
    }

    static final class a implements ae.a {
        private final com.tencent.mm.plugin.appbrand.appcache.a.a eiu;
        private final int kLh;
        private final boolean kLi;
        private EnumC0554a kLj;
        private ArrayList<IDKey> kLk;
        private long kLl;
        private long kLm;
        private long kLn;
        private kv_14609 kLo;

        /* synthetic */ a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar, byte b2) {
            this(aVar);
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.x$a$a  reason: collision with other inner class name */
        enum EnumC0554a {
            DOWNLOAD(1),
            UPDATE(4),
            LIB_UPDATE(7),
            INCREMENTAL_UPDATE(10),
            LIB_INCREMENTAL_UPDATE(13);
            
            final int value;

            public static EnumC0554a valueOf(String str) {
                AppMethodBeat.i(44276);
                EnumC0554a aVar = (EnumC0554a) Enum.valueOf(EnumC0554a.class, str);
                AppMethodBeat.o(44276);
                return aVar;
            }

            static {
                AppMethodBeat.i(44277);
                AppMethodBeat.o(44277);
            }

            private EnumC0554a(int i2) {
                this.value = i2;
            }
        }

        private a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
            int length;
            AppMethodBeat.i(44278);
            this.kLl = 0;
            this.kLm = 0;
            this.kLn = 0;
            this.eiu = aVar;
            this.kLh = x.Vb(aVar.appId) ? 776 : 368;
            String[] split = aVar.appId.split(Pattern.quote("$"));
            if (split == null) {
                length = -1;
            } else {
                length = split.length;
            }
            this.kLi = length == 2;
            AppMethodBeat.o(44278);
        }

        private void vR(int i2) {
            AppMethodBeat.i(44279);
            dM(this.kLh, i2);
            AppMethodBeat.o(44279);
        }

        private void dM(int i2, int i3) {
            AppMethodBeat.i(44280);
            if (this.kLk == null) {
                this.kLk = new ArrayList<>();
            }
            this.kLk.add(new IDKey(i2, i3, 1));
            AppMethodBeat.o(44280);
        }

        private void bvI() {
            AppMethodBeat.i(44281);
            try {
                e.INSTANCE.b(this.kLk, false);
                this.kLk.clear();
                AppMethodBeat.o(44281);
            } catch (Exception e2) {
                AppMethodBeat.o(44281);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvj() {
            int i2 = 0;
            AppMethodBeat.i(44282);
            if (this.eiu instanceof aw) {
                this.kLj = "@LibraryAppId".equals(this.eiu.appId) ? EnumC0554a.LIB_INCREMENTAL_UPDATE : EnumC0554a.INCREMENTAL_UPDATE;
                this.kLo = new kv_14609(this.eiu.appId, ((aw) this.eiu).kMt, ((aw) this.eiu).kMu);
                this.kLo.nJL = Util.nowMilliSecond();
            } else if ("@LibraryAppId".equals(this.eiu.appId)) {
                this.kLj = EnumC0554a.LIB_UPDATE;
            } else if (j.a.vP(this.eiu.dMe)) {
                WxaPkgWrappingInfo bS = m.bS(this.eiu.appId, 1);
                this.kLj = bS != null ? EnumC0554a.UPDATE : EnumC0554a.DOWNLOAD;
                this.kLo = new kv_14609(this.eiu.appId, bS == null ? 0 : bS.pkgVersion, this.eiu.version);
                this.kLo.nJL = Util.nowMilliSecond();
            } else {
                if (this.eiu instanceof av) {
                    this.kLo = kv_14609.ci(this.eiu.appId, this.eiu.dMe);
                    this.kLo.nJL = Util.nowMilliSecond();
                }
                this.kLj = EnumC0554a.DOWNLOAD;
            }
            switch (this.kLj) {
                case DOWNLOAD:
                    i2 = 1;
                    break;
                case UPDATE:
                    i2 = 10;
                    break;
                case LIB_UPDATE:
                    i2 = 20;
                    break;
                case INCREMENTAL_UPDATE:
                    i2 = 35;
                    break;
                case LIB_INCREMENTAL_UPDATE:
                    i2 = 46;
                    break;
            }
            vR(i2);
            this.kLl = SystemClock.elapsedRealtime();
            AppMethodBeat.o(44282);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvk() {
            AppMethodBeat.i(44283);
            vR(32);
            AppMethodBeat.o(44283);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvl() {
            int i2;
            AppMethodBeat.i(226356);
            switch (this.kLj) {
                case LIB_UPDATE:
                case LIB_INCREMENTAL_UPDATE:
                    i2 = 33;
                    break;
                case INCREMENTAL_UPDATE:
                default:
                    i2 = 34;
                    break;
            }
            vR(i2);
            AppMethodBeat.o(226356);
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x0085 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf  */
        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.pluginsdk.j.a.c.m r14) {
            /*
            // Method dump skipped, instructions count: 496
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.x.a.a(com.tencent.mm.pluginsdk.j.a.c.m):void");
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvm() {
            AppMethodBeat.i(44286);
            this.kLn = SystemClock.elapsedRealtime();
            dM(697, 1);
            AppMethodBeat.o(44286);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void vQ(int i2) {
            AppMethodBeat.i(44287);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.kLn;
            aw awVar = (aw) this.eiu;
            Log.i("MicroMsg.AppBrand.PkgDownloadReporterImpl", "onIncrementalMergeEnd, cost[%dms], appId[%s], version[%d->%d]", Long.valueOf(elapsedRealtime), awVar.appId, Integer.valueOf(awVar.kMt), Integer.valueOf(awVar.kMu));
            if (i2 == 0) {
                dM(697, 2);
            } else if (i2 < 0) {
                dM(697, -i2);
            } else if (i2 == 1) {
                dM(697, 10);
            }
            bvI();
            if (this.kLo != null) {
                if (i2 != 0) {
                    if (i2 == -4) {
                        this.kLo.dIZ = 4;
                    } else {
                        this.kLo.dIZ = 5;
                    }
                    this.kLo.bUP();
                    this.kLo.report();
                    if (!(this.kLo.mWO == null || this.kLo.nJB == null)) {
                        i.a(this.kLo.mWO, this.kLo, this.eiu, this.kLo.nJB);
                        AppMethodBeat.o(44287);
                        return;
                    }
                } else {
                    this.kLo.nJJ = (int) s.boW(((aw) this.eiu).bwb());
                }
            }
            AppMethodBeat.o(44287);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvn() {
            AppMethodBeat.i(44288);
            if (!(EnumC0554a.LIB_UPDATE == this.kLj || EnumC0554a.LIB_INCREMENTAL_UPDATE == this.kLj)) {
                com.tencent.mm.plugin.appbrand.report.i.T(this.eiu.appId, 20, this.eiu.dMe + 1);
            }
            AppMethodBeat.o(44288);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvo() {
            AppMethodBeat.i(44289);
            this.kLm = SystemClock.elapsedRealtime();
            switch (this.kLj) {
                case DOWNLOAD:
                    vR(5);
                    AppMethodBeat.o(44289);
                    return;
                case UPDATE:
                    vR(14);
                    AppMethodBeat.o(44289);
                    return;
                case LIB_UPDATE:
                    vR(24);
                    AppMethodBeat.o(44289);
                    return;
                case INCREMENTAL_UPDATE:
                    vR(41);
                    AppMethodBeat.o(44289);
                    return;
                case LIB_INCREMENTAL_UPDATE:
                    vR(49);
                    break;
            }
            AppMethodBeat.o(44289);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void gE(boolean z) {
            int i2;
            String str;
            AppMethodBeat.i(44290);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.kLm;
            switch (this.kLj) {
                case DOWNLOAD:
                    if (!z) {
                        i2 = 7;
                        break;
                    } else {
                        i2 = 6;
                        break;
                    }
                case UPDATE:
                    if (!z) {
                        i2 = 16;
                        break;
                    } else {
                        i2 = 15;
                        break;
                    }
                case LIB_UPDATE:
                    if (!z) {
                        i2 = 26;
                        break;
                    } else {
                        i2 = 25;
                        break;
                    }
                case INCREMENTAL_UPDATE:
                    if (!z) {
                        i2 = 43;
                        break;
                    } else {
                        i2 = 42;
                        break;
                    }
                case LIB_INCREMENTAL_UPDATE:
                    if (!z) {
                        i2 = 51;
                        break;
                    } else {
                        i2 = 50;
                        break;
                    }
                default:
                    i2 = 0;
                    break;
            }
            vR(i2);
            if (this.kLn > 0 && !z) {
                dM(697, 11);
            }
            if (this.kLo != null && this.kLo.nJO > 0 && !z) {
                vR(58);
            }
            bvI();
            if (EnumC0554a.LIB_UPDATE == this.kLj || EnumC0554a.LIB_INCREMENTAL_UPDATE == this.kLj) {
                str = "";
            } else {
                str = this.eiu.appId;
            }
            com.tencent.mm.plugin.appbrand.report.i.a(str, this.kLj.value + 1, z ? 1 : 2, elapsedRealtime, this.kLi);
            if (!z) {
                com.tencent.mm.plugin.appbrand.report.i.T(this.eiu.appId, 22, this.eiu.dMe + 1);
            }
            if (this.kLo != null) {
                this.kLo.bUP();
                if (this.kLj != EnumC0554a.INCREMENTAL_UPDATE && this.kLj != EnumC0554a.LIB_INCREMENTAL_UPDATE) {
                    this.kLo.nJH = z;
                } else if (z) {
                    this.kLo.nJH = true;
                    this.kLo.nJI = true;
                }
                if (!z) {
                    this.kLo.dIZ = 6;
                }
                this.kLo.report();
                if (!(this.kLo.mWO == null || this.kLo.nJB == null)) {
                    i.a(this.kLo.mWO, this.kLo, this.eiu, this.kLo.nJB);
                }
            }
            AppMethodBeat.o(44290);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvp() {
            AppMethodBeat.i(44291);
            vR(56);
            AppMethodBeat.o(44291);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void gF(boolean z) {
            AppMethodBeat.i(44292);
            if (!z) {
                vR(57);
            } else if (this.kLo != null && (this.eiu instanceof bs)) {
                this.kLo.nJJ = (int) s.boW(((bs) this.eiu).bwC());
            }
            if (this.kLo != null) {
                this.kLo.nJO = SystemClock.elapsedRealtime() - this.kLl;
            }
            AppMethodBeat.o(44292);
        }
    }

    static /* synthetic */ boolean Vb(String str) {
        AppMethodBeat.i(44295);
        if (Util.isNullOrNil(str) || !Boolean.TRUE.equals(kLf.get(str))) {
            AppMethodBeat.o(44295);
            return false;
        }
        AppMethodBeat.o(44295);
        return true;
    }
}
