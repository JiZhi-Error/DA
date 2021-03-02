package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.luggage.sdk.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Locale;

public final class ah extends ag implements aa {
    public final String appId;
    public final String cBp;
    public final int dFL;
    public int dMe;
    public final boolean kPG;
    public final int mVo;
    public final boolean mVp;
    private b mVq;
    private bd mVr;
    private final int[] mVs;
    public final int scene;

    @Override // com.tencent.mm.plugin.appbrand.launching.z, com.tencent.mm.plugin.appbrand.launching.ag
    public final /* bridge */ /* synthetic */ void a(QualitySession qualitySession) {
        AppMethodBeat.i(47256);
        super.a(qualitySession);
        AppMethodBeat.o(47256);
    }

    public ah(String str, String str2, int i2) {
        this(str, str2, i2, null);
    }

    private ah(String str, String str2, int i2, b bVar) {
        super(new ad(str, str2));
        AppMethodBeat.i(227088);
        this.dFL = 0;
        this.dMe = 4;
        this.mVq = null;
        this.mVs = new int[]{6, 12};
        this.appId = str;
        this.cBp = str2;
        this.mVo = i2;
        this.mVp = true;
        this.kPG = false;
        this.scene = 0;
        this.mVq = null;
        this.mUW = this.mVp;
        AppMethodBeat.o(227088);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ag
    public final String brS() {
        AppMethodBeat.i(47252);
        String format = String.format(Locale.US, "pkg %s, targetVersion %d, codeType %d", this.mVm.toString(), Integer.valueOf(this.mVo), 0);
        AppMethodBeat.o(47252);
        return format;
    }

    private WxaPkgWrappingInfo acc(String str) {
        WxaPkgWrappingInfo Vx;
        AppMethodBeat.i(47253);
        if (Util.isNullOrNil(this.cBp) || !this.cBp.endsWith(ModulePkgInfo.PLUGIN_CODE)) {
            Vx = WxaPkgWrappingInfo.Vx(str);
        } else {
            Vx = WxaPkgWrappingInfo.Vy(str);
        }
        if (Vx == null) {
            AppMethodBeat.o(47253);
            return null;
        }
        Vx.pkgVersion = this.mVo;
        AppMethodBeat.o(47253);
        return Vx;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ag
    public final void prepare() {
        final h hVar;
        cye a2;
        boolean c2;
        WxaPkgWrappingInfo bS;
        AppMethodBeat.i(47254);
        bh buL = n.buL();
        if (buL == null) {
            Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL storage with %s", brS());
            e(null);
            AppMethodBeat.o(47254);
            return;
        }
        this.mVr = buL.a(this.mVm.toString(), this.mVo, 0, new String[0]);
        if (this.mVr == null) {
            Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get NULL record with %s", brS());
            e(null);
            final String string = MMApplicationContext.getContext().getString(R.string.pg, "");
            if (!this.mVp || TextUtils.isEmpty(string)) {
                AppMethodBeat.o(47254);
                return;
            }
            Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "showTip key[%s] tip[%s]", this.mVm.toString(), string);
            com.tencent.f.h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.launching.ah.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(174996);
                    Toast.makeText(MMApplicationContext.getContext(), string, 0).show();
                    AppMethodBeat.o(174996);
                }
            });
            AppMethodBeat.o(47254);
        } else if (Util.isNullOrNil(this.mVr.field_versionMd5)) {
            Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "get EMPTY md5 with %s", brS());
            e(null);
            AppMethodBeat.o(47254);
        } else if (this.mVr.field_versionMd5.equals(WxaPkgIntegrityChecker.Vn(this.mVr.field_pkgPath))) {
            Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", brS());
            e(acc(this.mVr.field_pkgPath));
            bNE();
            if (this.mVi != null) {
                ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a) n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).a(this.mVi.kEY, this.appId, this.mVo, this.dMe, this.cBp);
            }
            AppMethodBeat.o(47254);
        } else {
            s.deleteFile(this.mVr.field_pkgPath);
            bd a3 = m.a(this.mVm, 0, this.mVo, new String[]{this.mVr.field_versionMd5});
            if (a3 != null) {
                Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "find reusable record, target (%s), reusable (%s %d)", brS(), a3.field_appId, Integer.valueOf(a3.field_version));
                String aT = ba.aT(this.mVm.toString(), this.mVo);
                s.nw(a3.field_pkgPath, aT);
                n.buL().e(this.mVm.toString(), 0, this.mVo, aT);
                e(acc(aT));
                bNE();
                if (this.mVi != null) {
                    String str = this.mVi.kEY;
                    String str2 = this.appId;
                    int i2 = this.mVo;
                    getClass();
                    ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a) n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).a(str, str2, i2, 0, this.cBp);
                }
                AppMethodBeat.o(47254);
                return;
            }
            Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", brS());
            final byy byy = new byy();
            byy.dNI = this.appId;
            byy.KXD = this.mVo;
            byy.MbZ = 0;
            if (!Util.isNullOrNil(this.cBp)) {
                byy.MbZ = this.dMe;
                if (!com.tencent.mm.compatible.loader.a.contains(this.mVs, this.dMe)) {
                    byy.MbW = this.cBp;
                }
            } else if (12 == this.dMe) {
                byy.MbZ = this.dMe;
            }
            byy.Mef = this.mVr.field_versionMd5;
            if (v.bvE() && j.a.vP(0)) {
                String adVar = this.mVm.toString();
                if (!Util.isNullOrNil(adVar)) {
                    if (adVar.endsWith(ModulePkgInfo.PLUGIN_CODE)) {
                        bS = m.bT(adVar, this.mVo);
                    } else {
                        bS = m.bS(adVar, 1);
                    }
                    if (bS != null) {
                        byy.Meg = bS.pkgVersion;
                    }
                }
            }
            if (this.kPG) {
                byy.scene = this.scene;
            }
            Object[] objArr = new Object[8];
            objArr[0] = byy.dNI;
            objArr[1] = Integer.valueOf(byy.scene);
            objArr[2] = Integer.valueOf(byy.MbZ);
            objArr[3] = byy.MbW;
            objArr[4] = Integer.valueOf(byy.KXD);
            objArr[5] = Integer.valueOf(byy.Meg);
            objArr[6] = byy.Mef;
            objArr[7] = Integer.valueOf(v.bvE() ? 1 : 0);
            Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "appid:%s,scene:%d,cgirequest pkgtype:%s,modulename:%s,version:%s,old_app_version:%s,record md5:%s,openIncremental:%s", objArr);
            if (this.kPG) {
                hVar = new com.tencent.mm.plugin.appbrand.appcache.predownload.a(byy);
            } else {
                hVar = new h(byy);
            }
            final AnonymousClass1 r6 = new d() {
                /* class com.tencent.mm.plugin.appbrand.launching.ah.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.launching.d
                public final void bNe() {
                    AppMethodBeat.i(174988);
                    Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "onFallback: fallback to normal cgi with %s", ah.this.brS());
                    hVar.aYI().h(new com.tencent.mm.vending.c.a<Void, c.a<byz>>(byy) {
                        /* class com.tencent.mm.plugin.appbrand.launching.ah.AnonymousClass3 */
                        final /* synthetic */ byy mVt;

                        {
                            this.mVt = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX WARNING: Removed duplicated region for block: B:18:0x0088  */
                        /* JADX WARNING: Removed duplicated region for block: B:27:0x00cc  */
                        @Override // com.tencent.mm.vending.c.a
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final /* synthetic */ java.lang.Void call(com.tencent.mm.ak.c.a<com.tencent.mm.protocal.protobuf.byz> r12) {
                            /*
                            // Method dump skipped, instructions count: 346
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.ah.AnonymousClass3.call(java.lang.Object):java.lang.Object");
                        }
                    });
                    AppMethodBeat.o(174988);
                }
            };
            if (byy.Meg != 0 || (a2 = az.a(byy, this.mVq)) == null) {
                r6.bNe();
                AppMethodBeat.o(47254);
                return;
            }
            String str3 = "";
            String str4 = "";
            String str5 = "";
            if (a2.LVl) {
                str3 = a2.url;
            } else if (a2.LVm) {
                str4 = a2.url;
            } else {
                str5 = a2.url;
            }
            Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "tryDownloadPkyByParallelCgiOpt: %s : patchUrl = [%s], zstdUrl = [%s], fullUrl = [%s]", brS(), str3, str4, str5);
            final String str6 = a2.md5;
            AnonymousClass2 r8 = new a() {
                /* class com.tencent.mm.plugin.appbrand.launching.ah.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.c
                public final void bwE() {
                    AppMethodBeat.i(47248);
                    AppMethodBeat.o(47248);
                }

                @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.AbstractC0544b
                public final void bwD() {
                    AppMethodBeat.i(47247);
                    AppMethodBeat.o(47247);
                }

                /* access modifiers changed from: package-private */
                @Override // com.tencent.mm.plugin.appbrand.launching.af
                public final String bND() {
                    AppMethodBeat.i(47243);
                    String brS = ah.this.brS();
                    AppMethodBeat.o(47243);
                    return brS;
                }

                /* access modifiers changed from: package-private */
                @Override // com.tencent.mm.plugin.appbrand.launching.af
                public final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.i(47244);
                    if (wxaPkgWrappingInfo == null || !wxaPkgWrappingInfo.md5.equals(str6)) {
                        Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: will call fallback info ==null? [%b] with %s", wxaPkgWrappingInfo, ah.this.brS());
                        r6.bNe();
                        com.tencent.mm.plugin.appbrand.launching.d.b.pl(18);
                        AppMethodBeat.o(47244);
                        return;
                    }
                    Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "downloadPkgForParallelCgi: onDownloadCallback: downloadPkgForParallelCgi success with %s", ah.this.brS());
                    ah.this.e(wxaPkgWrappingInfo);
                    AppMethodBeat.o(47244);
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.appbrand.launching.af
                public final void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    AppMethodBeat.i(47245);
                    ah.this.c(wxaPkgLoadProgress);
                    AppMethodBeat.o(47245);
                }
            };
            if (byy.Meg > 0 && !Util.isNullOrNil(str3)) {
                c2 = com.tencent.mm.plugin.appbrand.appcache.s.a(this.mVm.toString(), byy.Meg, this.mVo, str3, r8);
            } else if (!Util.isNullOrNil(str4)) {
                c2 = bt.a(str4, this.mVm.toString(), this.mVo, 0, r8);
            } else {
                c2 = bj.c(this.mVm.toString(), 0, this.mVo, str5, r8);
            }
            if (c2) {
                Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "getDownloadURL: %s : start download success from preFetch", brS());
                AppMethodBeat.o(47254);
                return;
            }
            r6.bNe();
            AppMethodBeat.o(47254);
        }
    }

    abstract class a extends af implements b.AbstractC0544b, b.c {
        /* synthetic */ a(ah ahVar) {
            this(0);
        }

        private a(int i2) {
            super(0, ah.this);
        }
    }
}
