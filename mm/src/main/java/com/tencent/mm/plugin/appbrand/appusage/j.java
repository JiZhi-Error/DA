package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class j extends MStorage {
    private static volatile j kUu = null;

    public interface a {
        void n(boolean z, String str);
    }

    private j() {
    }

    public static j bxQ() {
        AppMethodBeat.i(44482);
        if (kUu == null) {
            synchronized (j.class) {
                try {
                    if (kUu == null) {
                        kUu = new j();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(44482);
                    throw th;
                }
            }
        }
        j jVar = kUu;
        AppMethodBeat.o(44482);
        return jVar;
    }

    public static void release() {
        kUu = null;
    }

    public final void bxR() {
        AppMethodBeat.i(44483);
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appusage.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44478);
                j.a(j.this, 1, 0, 7, 0, true, null, -1, -1, null);
                AppMethodBeat.o(44478);
            }
        });
        AppMethodBeat.o(44483);
    }

    public final void a(long j2, boolean z, Bundle bundle, int i2, int i3) {
        AppMethodBeat.i(44484);
        a(j2, z, bundle, i2, i3, -1, -1, null);
        AppMethodBeat.o(44484);
    }

    public final void a(final long j2, final boolean z, final Bundle bundle, final int i2, final int i3, final int i4, final long j3, final a aVar) {
        AppMethodBeat.i(226385);
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appusage.j.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(44480);
                j.a(j.this, i2, i3, (z & v.bym() ? 2 : 0) | 1, j2, z, bundle, i4, j3, aVar);
                AppMethodBeat.o(44480);
            }
        });
        AppMethodBeat.o(226385);
    }

    public static boolean bxS() {
        AppMethodBeat.i(44485);
        if (!g.aAc()) {
            AppMethodBeat.o(44485);
            return false;
        }
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(44485);
        return booleanValue;
    }

    static /* synthetic */ void a(j jVar, final int i2, int i3, final int i4, final long j2, boolean z, final Bundle bundle, int i5, long j3, final a aVar) {
        boolean z2;
        int i6;
        int i7;
        AppMethodBeat.i(226386);
        if (g.aAc()) {
            if (2 == i2) {
                z2 = false;
            } else {
                if (6 == i2) {
                    if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                        z2 = true;
                    } else {
                        if (Util.nowSecond() - PluginAppBrand.getProcessSharedPrefs().getLong("com.tencent.mm.plugin.appbrand.appusage.AppBrandHistoryLogic.KEY_LAST_SYNC_HISTORY_TIME_SECONDS_BY_MAIN_FRAME_TASK_OPEN", 0) >= TimeUnit.MINUTES.toSeconds((long) AppBrandGlobalSystemConfig.bzP().lcX)) {
                            PluginAppBrand.getProcessSharedPrefs().edit().putLong("com.tencent.mm.plugin.appbrand.appusage.AppBrandHistoryLogic.KEY_LAST_SYNC_HISTORY_TIME_SECONDS_BY_MAIN_FRAME_TASK_OPEN", Util.nowSecond()).apply();
                        } else {
                            z2 = false;
                        }
                    }
                }
                z2 = true;
            }
            if (z2) {
                final boolean z3 = j3 != -1;
                if (!z3) {
                    j3 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG, (Object) -1L)).longValue();
                }
                if (z || j3 <= 0) {
                    i6 = Integer.MAX_VALUE;
                } else {
                    i6 = (int) j3;
                }
                if (i5 > 0) {
                    i7 = i5;
                } else {
                    i7 = 30;
                }
                new z(i3, i6, i7, i4, i2) {
                    /* class com.tencent.mm.plugin.appbrand.appusage.j.AnonymousClass4 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
                    @Override // com.tencent.mm.ak.c
                    public final /* synthetic */ void a(int i2, int i3, String str, bzl bzl, q qVar) {
                        int size;
                        String format;
                        int i4 = -1;
                        AppMethodBeat.i(44481);
                        bzl bzl2 = bzl;
                        if (g.aAc()) {
                            if (bzl2 == null) {
                                format = BuildConfig.COMMAND;
                            } else {
                                Locale locale = Locale.US;
                                Object[] objArr = new Object[3];
                                if (bzl2.Mfe == null) {
                                    size = -1;
                                } else {
                                    size = bzl2.Mfe.size();
                                }
                                objArr[0] = Integer.valueOf(size);
                                if (bzl2.Mff != null) {
                                    i4 = bzl2.Mff.size();
                                }
                                objArr[1] = Integer.valueOf(i4);
                                objArr[2] = Integer.valueOf(bzl2.status);
                                format = String.format(locale, "%d %d %d", objArr);
                            }
                            Log.i("MicroMsg.AppBrandHistoryLogic[collection]", "onCgiBack, errType %d, errCode %d, errMsg %s, resp %s", Integer.valueOf(i2), Integer.valueOf(i3), str, format);
                            if (bzl2 == null) {
                                if (aVar != null) {
                                    aVar.n(false, "cgi response is null");
                                }
                            } else if (i2 == 0 && i3 == 0) {
                                if ((i4 & 4) > 0 && !q.bxY() && (bzl2.status & 8) > 0) {
                                    q.bxZ();
                                }
                                g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN, Boolean.valueOf((bzl2.status & 4) > 0));
                                i.dO(bzl2.status, i2);
                                if (!Util.isNullOrNil(bzl2.Mff)) {
                                    n.buJ().bk(bzl2.Mff);
                                    if (!Util.isNullOrNil(bzl2.Mff)) {
                                        int i5 = bzl2.Mff.getFirst().KWR;
                                        Iterator<fcn> it = bzl2.Mff.iterator();
                                        while (it.hasNext()) {
                                            i5 = Math.min(i5, it.next().KWR);
                                        }
                                        if (!z3 && i5 > 0) {
                                            g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG, Long.valueOf((long) i5));
                                        }
                                    }
                                    w.a(i2, bzl2.Mff, new aa.d() {
                                        /* class com.tencent.mm.plugin.appbrand.appusage.j.AnonymousClass4.AnonymousClass1 */

                                        @Override // com.tencent.mm.plugin.appbrand.config.aa.d
                                        public final void done() {
                                            AppMethodBeat.i(226384);
                                            if (aVar != null) {
                                                aVar.n(true, "");
                                            }
                                            AppMethodBeat.o(226384);
                                        }
                                    });
                                } else if (aVar != null) {
                                    aVar.n(true, "");
                                }
                                v.a(i2, i2, i3, str, (d) qVar.getReqResp(), Long.valueOf(j2));
                            } else if (aVar != null) {
                                aVar.n(false, "cgi errorType:" + i2 + " errorCode:" + i3 + " errMsg:" + str);
                            }
                            j.this.doNotify(MStorageEventData.EventType.BATCH, 3, Long.valueOf(j2));
                        }
                        AppMethodBeat.o(44481);
                    }
                }.aYI();
            }
        }
        AppMethodBeat.o(226386);
    }
}
