package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.predownload.a.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.f;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.d;
import com.tencent.mm.plugin.appbrand.launching.m;
import com.tencent.mm.plugin.appbrand.launching.x;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.x;

public enum j {
    INSTANCE;
    
    private volatile boolean kPT = false;
    private volatile f<Void> kPU;

    private j(String str) {
    }

    public static j valueOf(String str) {
        AppMethodBeat.i(44413);
        j jVar = (j) Enum.valueOf(j.class, str);
        AppMethodBeat.o(44413);
        return jVar;
    }

    static {
        AppMethodBeat.i(44417);
        AppMethodBeat.o(44417);
    }

    public final synchronized void bwR() {
        AppMethodBeat.i(44414);
        if (!g.aAf().hpY) {
            Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
            if (this.kPU != null) {
                this.kPU.hdy();
            }
            this.kPT = false;
            AppMethodBeat.o(44414);
        } else if (this.kPT) {
            Log.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
            AppMethodBeat.o(44414);
        } else {
            Log.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
            this.kPT = true;
            this.kPU = com.tencent.mm.co.g.hio();
            this.kPU.i(new a<Void, Void>() {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.j.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(Void r3) {
                    AppMethodBeat.i(44405);
                    Void buw = buw();
                    AppMethodBeat.o(44405);
                    return buw;
                }

                private Void buw() {
                    AppMethodBeat.i(44404);
                    try {
                        j.a(j.this);
                    } catch (Throwable th) {
                        AppMethodBeat.o(44404);
                        throw th;
                    }
                    AppMethodBeat.o(44404);
                    return null;
                }
            });
            AppMethodBeat.o(44414);
        }
    }

    public final synchronized void cleanup() {
        AppMethodBeat.i(44415);
        if (this.kPU != null) {
            this.kPU.hdy();
        }
        this.kPT = false;
        AppMethodBeat.o(44415);
    }

    static /* synthetic */ void a(j jVar) {
        int i2;
        AppMethodBeat.i(44416);
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "retry but disconnected");
            com.tencent.mm.vending.g.g.hdx().ej(null);
            synchronized (jVar) {
                try {
                    jVar.kPT = false;
                } finally {
                    AppMethodBeat.o(44416);
                }
            }
        } else if (!g.aAf().hpY) {
            Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "retry but account not ready");
            com.tencent.mm.vending.g.g.hdx().ej(null);
            synchronized (jVar) {
                try {
                    jVar.kPT = false;
                } finally {
                    AppMethodBeat.o(44416);
                }
            }
        } else {
            Context context = MMApplicationContext.getContext();
            if (NetStatusUtil.isWifi(context)) {
                i2 = 1;
            } else if (NetStatusUtil.is2G(context)) {
                i2 = 2;
            } else if (NetStatusUtil.is3G(context)) {
                i2 = 4;
            } else if (NetStatusUtil.is4G(context)) {
                i2 = 8;
            } else {
                i2 = -1;
            }
            LinkedList<c> linkedList = new LinkedList();
            linkedList.addAll(((d) n.W(d.class)).c("networkType=?", AppEventsConstants.EVENT_PARAM_VALUE_NO));
            for (c cVar : ((d) n.W(d.class)).c("networkType<>?", AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                if ((cVar.field_networkType & i2) > 0) {
                    linkedList.add(cVar);
                }
            }
            if (Util.isNullOrNil(linkedList)) {
                com.tencent.mm.vending.g.g.hdx().ej(null);
                synchronized (jVar) {
                    try {
                        jVar.kPT = false;
                    } finally {
                        AppMethodBeat.o(44416);
                    }
                }
                return;
            }
            for (final c cVar2 : linkedList) {
                jVar.kPU.g(new a<Void, Void>() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.j.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(Void r13) {
                        int i2;
                        AppMethodBeat.i(44409);
                        ad adVar = new ad(cVar2.field_appId, cVar2.field_packageKey, cVar2.field_packageType);
                        WxaPkgWrappingInfo bS = m.bS(adVar.toString(), 0);
                        if (bS == null || bS.pkgVersion < cVar2.field_version) {
                            if (!cVar2.field_firstTimeTried) {
                                cVar2.field_firstTimeTried = true;
                                cVar2.field_lastRetryTime = Util.nowSecond();
                                ((d) n.W(d.class)).update(cVar2, new String[0]);
                            } else if (cVar2.field_retryTimes <= 0) {
                                Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "record(%s) retryTimes == 0, skip", adVar.toString());
                                ((d) n.W(d.class)).delete(cVar2, new String[0]);
                            } else if (cVar2.field_lastRetryTime + cVar2.field_retryInterval > Util.nowSecond()) {
                                Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "exceed record(%s) retryInterval %d, skip", adVar.toString(), Long.valueOf(cVar2.field_retryInterval));
                            } else if (cVar2.field_retriedCount + 1 > cVar2.field_retryTimes) {
                                Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "exceed record(%s) retryTimes %d, skip", adVar.toString(), Integer.valueOf(cVar2.field_retryTimes));
                                ((d) n.W(d.class)).delete(cVar2, new String[0]);
                            } else {
                                cVar2.field_retriedCount++;
                                cVar2.field_lastRetryTime = Util.nowSecond();
                                ((d) n.W(d.class)).update(cVar2, new String[0]);
                            }
                            if (cVar2.field_type == 0) {
                                n.buL().r(adVar.toString(), cVar2.field_version, cVar2.field_pkgMd5);
                                final b hdx = com.tencent.mm.vending.g.g.hdx();
                                hdx.hdw();
                                com.tencent.mm.plugin.appbrand.appcache.predownload.a.b bVar = new com.tencent.mm.plugin.appbrand.appcache.predownload.a.b(cVar2, new kotlin.g.a.a<x>() {
                                    /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.j.AnonymousClass2.AnonymousClass1 */

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.g.a.a
                                    public final /* synthetic */ x invoke() {
                                        AppMethodBeat.i(226379);
                                        if (!g.aAc()) {
                                            String format = String.format(Locale.ENGLISH, "appId[%s] packageKey[%s] packageType[%d] version[%d]", cVar2.field_appId, cVar2.field_packageKey, Integer.valueOf(cVar2.field_packageType), Integer.valueOf(cVar2.field_version));
                                            j.this.cleanup();
                                            Log.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "predownload normal pkg onResult AccountNotReady ".concat(String.valueOf(format)));
                                            x xVar = x.SXb;
                                            AppMethodBeat.o(226379);
                                            return xVar;
                                        }
                                        hdx.resume();
                                        x xVar2 = x.SXb;
                                        AppMethodBeat.o(226379);
                                        return xVar2;
                                    }
                                });
                                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                                int i3 = bVar.reportId;
                                if (bVar.kPB) {
                                    i2 = 51;
                                } else {
                                    i2 = 46;
                                }
                                com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) i3, (long) i2);
                                x.b bVar2 = com.tencent.mm.plugin.appbrand.launching.x.mTR;
                                String str = bVar.kPC.field_appId;
                                p.g(str, "record.field_appId");
                                acc acc = new acc();
                                acc.LmG = 1;
                                x.b.a(new x.d(str, bVar.kPC.field_packageKey, bVar.kPC.field_packageType, 0, new x.g.b(bVar.kPC.field_version), false), new b.C0548b(bVar), new b.c(bVar), null, null, acc, null, 152);
                            } else {
                                an anVar = (an) n.W(an.class);
                                am A = anVar.A(cVar2.field_appId, cVar2.field_type, cVar2.field_version);
                                if (A != null) {
                                    Log.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "record(%s %d %d) integrated, decryptResult %b", cVar2.field_appId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_version), Boolean.valueOf(f.a(A, f.a.GET_CODE)));
                                } else {
                                    String str2 = cVar2.field_appId;
                                    int i4 = cVar2.field_type;
                                    int i5 = cVar2.field_version;
                                    String str3 = cVar2.field_pkgMd5;
                                    am amVar = new am();
                                    amVar.field_appId = str2;
                                    amVar.field_type = i4;
                                    amVar.field_version = i5;
                                    boolean z = anVar.get(amVar, new String[0]);
                                    amVar.field_pkgMd5 = str3;
                                    if (z) {
                                        anVar.update(amVar, new String[0]);
                                    } else {
                                        anVar.insert(amVar);
                                    }
                                    final com.tencent.mm.vending.g.b hdx2 = com.tencent.mm.vending.g.g.hdx();
                                    hdx2.hdw();
                                    com.tencent.mm.co.g.ey(cVar2).j(new com.tencent.mm.plugin.appbrand.appcache.predownload.a.a()).g(new a<Void, Boolean>() {
                                        /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.j.AnonymousClass2.AnonymousClass2 */

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ Void call(Boolean bool) {
                                            AppMethodBeat.i(44408);
                                            Boolean bool2 = bool;
                                            if (bool2 != null && bool2.booleanValue()) {
                                                Log.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "record(%s %d %d) download ok, decryptResult %b", cVar2.field_appId, Integer.valueOf(cVar2.field_type), Integer.valueOf(cVar2.field_version), Boolean.valueOf(f.a(((an) n.W(an.class)).A(cVar2.field_appId, cVar2.field_type, cVar2.field_version), f.a.GET_CODE)));
                                            }
                                            hdx2.resume();
                                            AppMethodBeat.o(44408);
                                            return null;
                                        }
                                    });
                                }
                            }
                        } else {
                            Log.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "available pkg(%s %d) >= record(%s %d), skip", adVar.toString(), Integer.valueOf(bS.pkgVersion), adVar.toString(), Integer.valueOf(cVar2.field_version));
                            ((d) n.W(d.class)).delete(cVar2, new String[0]);
                        }
                        AppMethodBeat.o(44409);
                        return null;
                    }
                });
            }
            jVar.kPU.g(new a<Void, Void>() {
                /* class com.tencent.mm.plugin.appbrand.appcache.predownload.b.j.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Void call(Void r3) {
                    AppMethodBeat.i(44411);
                    Void buw = buw();
                    AppMethodBeat.o(44411);
                    return buw;
                }

                private Void buw() {
                    AppMethodBeat.i(44410);
                    com.tencent.mm.vending.g.g.hdx().ej(null);
                    synchronized (j.this) {
                        try {
                            j.this.kPT = false;
                        } finally {
                            AppMethodBeat.o(44410);
                        }
                    }
                    return null;
                }
            });
            AppMethodBeat.o(44416);
        }
    }
}
