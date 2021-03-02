package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;

final class ai extends ag implements aa {
    final String appId;
    final String cBp;
    final int dFL;
    int dMe;
    private final int[] mVs;

    ai(String str, String str2, int i2) {
        this(str, str2, i2, (byte) 0);
    }

    private ai(String str, String str2, int i2, byte b2) {
        super(new ad(str, str2, 4));
        AppMethodBeat.i(227089);
        this.dMe = 4;
        this.mVs = new int[]{6, 12, 13};
        this.appId = str;
        this.cBp = str2;
        this.dFL = i2;
        if (a.contains(this.mVs, 4)) {
            this.dMe = 4;
        }
        AppMethodBeat.o(227089);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ag
    public final String brS() {
        AppMethodBeat.i(47262);
        String format = String.format(Locale.US, "appId %s, module %s, codeType %d, pkgType %d,queryKey:%s", this.appId, this.cBp, Integer.valueOf(this.dFL), Integer.valueOf(this.dMe), this.mVm);
        AppMethodBeat.o(47262);
        return format;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.ag
    public final void prepare() {
        String str;
        AppMethodBeat.i(47263);
        try {
            Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> D = WxaPkgIntegrityChecker.D(this.mVm.toString(), this.dFL, 1);
            if (D.second != null) {
                ((WxaPkgWrappingInfo) D.second).name = this.cBp;
                e((WxaPkgWrappingInfo) D.second);
                Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s prepare ok", brS());
                bNE();
                AppMethodBeat.o(47263);
                return;
            }
            if (Util.isNullOrNil(this.cBp)) {
                str = n.buL().aX(this.appId, this.dFL);
            } else {
                bd a2 = n.buL().a(this.mVm.toString(), this.dFL, "versionMd5", "downloadURL");
                if (a2 == null) {
                    Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", brS());
                    str = null;
                } else if (!DebuggerShell.bAx() || TextUtils.isEmpty(a2.field_downloadURL)) {
                    Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, record md5:%s", brS(), a2.field_versionMd5);
                    c.a a3 = ab.a(new i(this.appId, this.cBp, a2.field_versionMd5, this.dFL, this.dMe));
                    if (a3 != null && a3.errType == 0 && a3.errCode == 0) {
                        Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", Integer.valueOf(((bwc) a3.iLC).error_code), ((bwc) a3.iLC).error_msg, ((bwc) a3.iLC).gqB);
                        if (Util.isNullOrNil(((bwc) a3.iLC).gqB)) {
                            if (((bwc) a3.iLC).error_code == -1001) {
                                AppBrand404PageUI.show(R.string.q7);
                                com.tencent.mm.plugin.appbrand.report.i.T(this.appId, 4, this.dFL + 1);
                            } else {
                                ax.a(f.getMMString(R.string.pd, 5, Integer.valueOf(((bwc) a3.iLC).error_code)), this);
                            }
                        }
                        str = ((bwc) a3.iLC).gqB;
                    } else {
                        Object[] objArr = new Object[3];
                        objArr[0] = brS();
                        objArr[1] = Integer.valueOf(a3 == null ? -1 : a3.errType);
                        objArr[2] = Integer.valueOf(a3 == null ? -1 : a3.errCode);
                        Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, cgi failed, %d %d", objArr);
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Integer.valueOf(a3 == null ? -1 : a3.errType);
                        objArr2[1] = Integer.valueOf(a3 == null ? -1 : a3.errCode);
                        ax.a(ax.getMMString(R.string.pa, objArr2), this);
                        str = null;
                    }
                } else {
                    Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "getDownloadURL, with appId[%s], module[%s] hit monkey pushed url[%s]", this.appId, this.cBp, a2.field_downloadURL);
                    str = a2.field_downloadURL;
                }
            }
            AnonymousClass1 r1 = new af(this.dFL, this) {
                /* class com.tencent.mm.plugin.appbrand.launching.ai.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                @Override // com.tencent.mm.plugin.appbrand.launching.af
                public final String bND() {
                    AppMethodBeat.i(47257);
                    String brS = ai.this.brS();
                    AppMethodBeat.o(47257);
                    return brS;
                }

                /* access modifiers changed from: package-private */
                @Override // com.tencent.mm.plugin.appbrand.launching.af
                public final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    AppMethodBeat.i(47258);
                    ai.this.e(wxaPkgWrappingInfo);
                    AppMethodBeat.o(47258);
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.appbrand.launching.af
                public final void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    AppMethodBeat.i(47259);
                    super.b(wxaPkgLoadProgress);
                    ai.this.c(wxaPkgLoadProgress);
                    AppMethodBeat.o(47259);
                }
            };
            Log.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", brS(), str);
            if (Util.isNullOrNil(str)) {
                e(null);
                AppMethodBeat.o(47263);
                return;
            }
            if (!bj.a(this.mVm.toString(), this.dFL, str, r1, new a.AbstractC0542a() {
                /* class com.tencent.mm.plugin.appbrand.launching.ai.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.appcache.a.a.AbstractC0542a
                public final String bvJ() {
                    AppMethodBeat.i(47260);
                    String str = "_" + n.buL().a(ai.this.mVm.toString(), ai.this.dFL, "versionMd5").field_versionMd5;
                    AppMethodBeat.o(47260);
                    return str;
                }
            })) {
                Log.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", brS());
                e(null);
            }
            AppMethodBeat.o(47263);
        } catch (b | NullPointerException e2) {
            if (!g.aAc()) {
                e(null);
                AppMethodBeat.o(47263);
                return;
            }
            AppMethodBeat.o(47263);
            throw e2;
        }
    }
}
