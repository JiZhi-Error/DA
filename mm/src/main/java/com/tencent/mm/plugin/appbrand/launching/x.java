package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.protocal.protobuf.acc;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;

public interface x {
    public static final b mTR = b.mUe;

    public interface c {
        void b(d dVar);

        void b(d dVar, e eVar);

        void c(d dVar, e eVar);
    }

    public enum f {
        CACHED,
        REMOTE;

        static {
            AppMethodBeat.i(180576);
            AppMethodBeat.o(180576);
        }

        public static f valueOf(String str) {
            AppMethodBeat.i(180578);
            f fVar = (f) Enum.valueOf(f.class, str);
            AppMethodBeat.o(180578);
            return fVar;
        }
    }

    public static abstract class g {

        public static final class b extends g {
            public final int version;

            public final boolean equals(Object obj) {
                return this == obj || ((obj instanceof b) && this.version == ((b) obj).version);
            }

            public final int hashCode() {
                return this.version;
            }

            public b(int i2) {
                super((byte) 0);
                this.version = i2;
            }

            public final String toString() {
                AppMethodBeat.i(180580);
                String str = "VERSION(" + this.version + ')';
                AppMethodBeat.o(180580);
                return str;
            }
        }

        private g() {
        }

        public /* synthetic */ g(byte b2) {
            this();
        }

        public static final class a extends g {
            final boolean mUt;
            final int version;

            public a() {
                this(0, false, 3);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        if (!(this.version == aVar.version && this.mUt == aVar.mUt)) {
                            return false;
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                int i2 = this.version * 31;
                boolean z = this.mUt;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i3 + i2;
            }

            private a(int i2, boolean z) {
                super((byte) 0);
                this.version = i2;
                this.mUt = z;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(int i2, boolean z, int i3) {
                this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? false : z);
                AppMethodBeat.i(228660);
                AppMethodBeat.o(228660);
            }

            public final String toString() {
                AppMethodBeat.i(180579);
                String str = "LATEST(" + this.version + "|forceUpdate:" + this.mUt + ')';
                AppMethodBeat.o(180579);
                return str;
            }

            public final a bNA() {
                AppMethodBeat.i(228659);
                a aVar = new a(this.version, true);
                AppMethodBeat.o(228659);
                return aVar;
            }
        }
    }

    public enum a {
        OK(0),
        FAILED(101),
        LOCAL_FILE_NOT_FOUND(102),
        PKG_INTEGRITY_FAILED(104),
        PKG_INVALID(105),
        SEVER_FILE_NOT_FOUND(106),
        DISK_FULL(110),
        PKG_RECORD_NULL(111),
        PKG_RECORD_INVALID(112),
        CGI_GET_URL_FAILED(113),
        ENV_ERR(200);
        
        public final int code;

        public static a valueOf(String str) {
            AppMethodBeat.i(180558);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(180558);
            return aVar;
        }

        private a(int i2) {
            this.code = i2;
        }

        static {
            AppMethodBeat.i(180556);
            AppMethodBeat.o(180556);
        }
    }

    public static final class d {
        public final String appId;
        public final String cBp;
        final int iOo;
        private final kotlin.f mUk = kotlin.g.ah(new a(this));
        public final g mUl;
        public final boolean mUm;
        public final int packageType;

        public final ad bNz() {
            AppMethodBeat.i(180568);
            ad adVar = (ad) this.mUk.getValue();
            AppMethodBeat.o(180568);
            return adVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
            if (r3.mUm == r4.mUm) goto L_0x003e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 180571(0x2c15b, float:2.53034E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x003e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.launching.x.d
                if (r0 == 0) goto L_0x0043
                com.tencent.mm.plugin.appbrand.launching.x$d r4 = (com.tencent.mm.plugin.appbrand.launching.x.d) r4
                java.lang.String r0 = r3.appId
                java.lang.String r1 = r4.appId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0043
                java.lang.String r0 = r3.cBp
                java.lang.String r1 = r4.cBp
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0043
                int r0 = r3.packageType
                int r1 = r4.packageType
                if (r0 != r1) goto L_0x0043
                int r0 = r3.iOo
                int r1 = r4.iOo
                if (r0 != r1) goto L_0x0043
                com.tencent.mm.plugin.appbrand.launching.x$g r0 = r3.mUl
                com.tencent.mm.plugin.appbrand.launching.x$g r1 = r4.mUl
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0043
                boolean r0 = r3.mUm
                boolean r1 = r4.mUm
                if (r0 != r1) goto L_0x0043
            L_0x003e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0042:
                return r0
            L_0x0043:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0042
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.x.d.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(180570);
            String str = this.appId;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.cBp;
            int hashCode2 = ((((((str2 != null ? str2.hashCode() : 0) + hashCode) * 31) + this.packageType) * 31) + this.iOo) * 31;
            g gVar = this.mUl;
            if (gVar != null) {
                i2 = gVar.hashCode();
            }
            int i3 = (hashCode2 + i2) * 31;
            boolean z = this.mUm;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = i4 + i3;
            AppMethodBeat.o(180570);
            return i7;
        }

        public d(String str, String str2, int i2, int i3, g gVar, boolean z) {
            p.h(str, "appId");
            p.h(gVar, "version");
            AppMethodBeat.i(180569);
            this.appId = str;
            this.cBp = str2;
            this.packageType = i2;
            this.iOo = i3;
            this.mUl = gVar;
            this.mUm = z;
            AppMethodBeat.o(180569);
        }

        public final String toString() {
            AppMethodBeat.i(180567);
            String str = "Request{ appId=" + this.appId + ',' + " module_name=" + this.cBp + ',' + " package_type=" + this.packageType + ',' + " version_type=" + this.iOo + " app_version=" + this.mUl + " forceNoEncrypt=" + this.mUm + "}";
            AppMethodBeat.o(180567);
            return str;
        }

        /* access modifiers changed from: package-private */
        public static final class a extends q implements kotlin.g.a.a<ad> {
            final /* synthetic */ d mUn;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(0);
                this.mUn = dVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ ad invoke() {
                AppMethodBeat.i(180565);
                ad adVar = new ad(this.mUn.appId, this.mUn.cBp, this.mUn.packageType);
                AppMethodBeat.o(180565);
                return adVar;
            }
        }
    }

    public static final class e {
        public final IPkgInfo mUo;
        final f mUp;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.mUp, r4.mUp) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 180575(0x2c15f, float:2.5304E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.launching.x.e
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.appbrand.launching.x$e r4 = (com.tencent.mm.plugin.appbrand.launching.x.e) r4
                com.tencent.mm.plugin.appbrand.appcache.IPkgInfo r0 = r3.mUo
                com.tencent.mm.plugin.appbrand.appcache.IPkgInfo r1 = r4.mUo
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.appbrand.launching.x$f r0 = r3.mUp
                com.tencent.mm.plugin.appbrand.launching.x$f r1 = r4.mUp
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.x.e.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(180574);
            IPkgInfo iPkgInfo = this.mUo;
            int hashCode = (iPkgInfo != null ? iPkgInfo.hashCode() : 0) * 31;
            f fVar = this.mUp;
            if (fVar != null) {
                i2 = fVar.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(180574);
            return i3;
        }

        public e(IPkgInfo iPkgInfo, f fVar) {
            p.h(iPkgInfo, "pkgInfo");
            p.h(fVar, "source");
            AppMethodBeat.i(180572);
            this.mUo = iPkgInfo;
            this.mUp = fVar;
            AppMethodBeat.o(180572);
        }

        public final String toString() {
            AppMethodBeat.i(180573);
            String str = "Response(pkgInfo=" + this.mUo + ", source=" + this.mUp + ')';
            AppMethodBeat.o(180573);
            return str;
        }
    }

    public static final class b {
        static final /* synthetic */ b mUe = new b();

        public static final class a extends q implements kotlin.g.a.b<WxaPkgLoadProgress, kotlin.x> {
            public static final a mUf = new a();

            static {
                AppMethodBeat.i(180560);
                AppMethodBeat.o(180560);
            }

            a() {
                super(1);
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.x invoke(WxaPkgLoadProgress wxaPkgLoadProgress) {
                AppMethodBeat.i(180559);
                p.h(wxaPkgLoadProgress, "<anonymous parameter 0>");
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(180559);
                return xVar;
            }
        }

        static {
            AppMethodBeat.i(180564);
            AppMethodBeat.o(180564);
        }

        private b() {
        }

        public static /* synthetic */ void a(d dVar, kotlin.g.a.b bVar, m mVar, kotlin.g.a.b bVar2, y yVar, acc acc, c cVar, int i2) {
            a aVar;
            v vVar;
            AppMethodBeat.i(228658);
            if ((i2 & 8) != 0) {
                aVar = a.mUf;
            } else {
                aVar = bVar2;
            }
            if ((i2 & 16) != 0) {
                vVar = v.mTG;
            } else {
                vVar = yVar;
            }
            c cVar2 = (i2 & 128) != 0 ? null : cVar;
            p.h(dVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            p.h(bVar, "onSuccess");
            p.h(mVar, "onError");
            p.h(aVar, "onProgress");
            p.h(vVar, "cgiExecutor");
            p.h(acc, "cgiCommRequestSource");
            com.tencent.mm.ac.d.i(new C0743b(dVar, bVar, mVar, aVar, vVar, acc, cVar2));
            AppMethodBeat.o(228658);
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.x$b$b */
        public static final class C0743b extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ d kQl;
            final /* synthetic */ kotlin.g.a.b lza;
            final /* synthetic */ m mSV;
            final /* synthetic */ kotlin.g.a.b mUg;
            final /* synthetic */ y mUh;
            final /* synthetic */ acc mUi;
            final /* synthetic */ c mUj;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0743b(d dVar, kotlin.g.a.b bVar, m mVar, kotlin.g.a.b bVar2, y yVar, acc acc, c cVar) {
                super(0);
                this.kQl = dVar;
                this.lza = bVar;
                this.mSV = mVar;
                this.mUg = bVar2;
                this.mUh = yVar;
                this.mUi = acc;
                this.mUj = cVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(180561);
                new n(this.kQl, this.lza, this.mSV, this.mUg, this.mUh, this.mUi, this.mUj).start();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(180561);
                return xVar;
            }
        }
    }
}
