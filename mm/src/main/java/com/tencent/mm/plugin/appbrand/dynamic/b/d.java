package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.br;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.j.a.c.m;
import java.util.ArrayList;
import java.util.Locale;

public final class d implements ae.b {
    @Override // com.tencent.mm.plugin.appbrand.appcache.ae.b
    public final ae.a b(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(121269);
        if (br.class == aVar.getClass()) {
            a aVar2 = new a((br) aVar, (byte) 0);
            AppMethodBeat.o(121269);
            return aVar2;
        }
        AppMethodBeat.o(121269);
        return null;
    }

    static final class a implements ae.a {
        private ArrayList<IDKey> kLk;
        private long kLl;
        private long kLm;
        private final br lmS;
        private EnumC0570a lmT;

        /* synthetic */ a(br brVar, byte b2) {
            this(brVar);
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b.d$a$a  reason: collision with other inner class name */
        enum EnumC0570a {
            DOWNLOAD,
            UPDATE;

            public static EnumC0570a valueOf(String str) {
                AppMethodBeat.i(121259);
                EnumC0570a aVar = (EnumC0570a) Enum.valueOf(EnumC0570a.class, str);
                AppMethodBeat.o(121259);
                return aVar;
            }

            static {
                AppMethodBeat.i(121260);
                AppMethodBeat.o(121260);
            }
        }

        private a(br brVar) {
            this.kLl = 0;
            this.kLm = 0;
            this.lmS = brVar;
        }

        private void wn(int i2) {
            AppMethodBeat.i(121261);
            if (this.kLk == null) {
                this.kLk = new ArrayList<>();
            }
            this.kLk.add(new IDKey(640, i2, 1));
            AppMethodBeat.o(121261);
        }

        private void bvI() {
            AppMethodBeat.i(121262);
            try {
                e.INSTANCE.b(this.kLk, false);
                this.kLk.clear();
                AppMethodBeat.o(121262);
            } catch (Exception e2) {
                AppMethodBeat.o(121262);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvj() {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(121263);
            if (j.a.vP(this.lmS.dMe)) {
                if (((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub() == null) {
                    i2 = 1;
                } else {
                    Cursor rawQuery = ((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub().kNJ.rawQuery(String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", "version", "AppBrandWxaPkgManifestRecord", "appId", "debugType"), new String[]{this.lmS.appId, String.valueOf(this.lmS.dMe)}, 2);
                    if (rawQuery == null) {
                        i2 = 0;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            i2 = rawQuery.getInt(0);
                        } else {
                            i2 = 0;
                        }
                        rawQuery.close();
                    }
                }
                this.lmT = i2 > 1 ? EnumC0570a.UPDATE : EnumC0570a.DOWNLOAD;
            } else {
                this.lmT = EnumC0570a.DOWNLOAD;
            }
            switch (this.lmT) {
                case DOWNLOAD:
                    i3 = 1;
                    break;
                case UPDATE:
                    i3 = 10;
                    break;
            }
            wn(i3);
            this.kLl = SystemClock.elapsedRealtime();
            AppMethodBeat.o(121263);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvk() {
            AppMethodBeat.i(121264);
            wn(32);
            AppMethodBeat.o(121264);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvl() {
            AppMethodBeat.i(192518);
            wn(34);
            AppMethodBeat.o(192518);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void a(m mVar) {
            int i2;
            boolean z = true;
            int i3 = 2;
            AppMethodBeat.i(121266);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.kLl;
            if (elapsedRealtime <= 1000) {
                i2 = 0;
            } else if (elapsedRealtime <= 2000) {
                i2 = 1;
            } else if (elapsedRealtime <= 3000) {
                i2 = 2;
            } else if (elapsedRealtime <= 4000) {
                i2 = 3;
            } else if (elapsedRealtime <= 5000) {
                i2 = 4;
            } else {
                i2 = 5;
            }
            e.INSTANCE.idkeyStat(665, (long) i2, 1, false);
            e.INSTANCE.idkeyStat(665, 6, 1, false);
            if (mVar == null || mVar.status != 2) {
                z = false;
            }
            switch (this.lmT) {
                case DOWNLOAD:
                    if (!z) {
                        i3 = 3;
                    }
                    wn(i3);
                    break;
                case UPDATE:
                    wn(z ? 11 : 12);
                    break;
            }
            bvI();
            AppMethodBeat.o(121266);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvm() {
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void vQ(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvn() {
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvo() {
            AppMethodBeat.i(121267);
            this.kLm = SystemClock.elapsedRealtime();
            switch (this.lmT) {
                case DOWNLOAD:
                    wn(5);
                    AppMethodBeat.o(121267);
                    return;
                case UPDATE:
                    wn(14);
                    break;
            }
            AppMethodBeat.o(121267);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void gE(boolean z) {
            int i2;
            AppMethodBeat.i(121268);
            SystemClock.elapsedRealtime();
            switch (this.lmT) {
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
                default:
                    i2 = 0;
                    break;
            }
            wn(i2);
            bvI();
            AppMethodBeat.o(121268);
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void bvp() {
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.ae.a
        public final void gF(boolean z) {
        }
    }
}
