package com.tencent.mm.an;

import android.os.Looper;
import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.mars.Mars;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.i.b;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.e;
import com.tencent.mm.i.f;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements i, com.tencent.mm.i.b, b.a, MStorageEx.IOnStorageChange {
    private static final long[] iRF = {0, 2, 5, 7, 10, 15, 20, 30, 50, 70, 100, 200, 400, 600, 800, 1000, 3000, 5000, 10000, 20000, 30000, 40000, 50000, Util.MILLSECONDS_OF_MINUTE, 120000};
    private static final int[] iRG = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
    private static int iRH = -1;
    private static long iRI = -1;
    public o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.an.b.AnonymousClass6 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(223549);
            Log.i("MicroMsg.CdnTransportService", "onAppForeground %s", str);
            if (!b.baJ()) {
                AppMethodBeat.o(223549);
                return;
            }
            b.this.iRx = true;
            b.this.iRu.clear();
            b.this.iRv.startTimer(Util.MILLSECONDS_OF_MINUTE);
            AppMethodBeat.o(223549);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(223550);
            Log.i("MicroMsg.CdnTransportService", "onAppBackground %s", str);
            if (!b.baJ()) {
                AppMethodBeat.o(223550);
                return;
            }
            b.this.iRx = false;
            b.this.iRv.stopTimer();
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.an.b.AnonymousClass6.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(223548);
                    Log.i("MicroMsg.CdnTransportService", "appForegroundListener onAppBackground");
                    b.b(b.this);
                    for (Map.Entry entry : b.this.iRu.entrySet()) {
                        a aVar = (a) b.this.iRu.remove(entry.getKey());
                        Object[] objArr = new Object[1];
                        objArr[0] = aVar != null ? aVar.toString() : BuildConfig.COMMAND;
                        Log.i("MicroMsg.CdnTransportService", "remove %s", objArr);
                    }
                    AppMethodBeat.o(223548);
                }
            });
            AppMethodBeat.o(223550);
        }
    };
    public Map<String, g> iRA = new ConcurrentHashMap();
    public Map<String, Integer> iRB = new HashMap();
    private String iRC = "";
    private long iRD = 0;
    public HashSet<String> iRE = new HashSet<>();
    private int iRq = -1;
    MMHandler iRr = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.an.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(150391);
            if (!MMApplicationContext.isPushProcess() && NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                Log.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(546, 5, 1, true);
                Mars.onNetworkChange();
            }
            AppMethodBeat.o(150391);
        }
    };
    IListener<mb> iRs = new IListener<mb>() {
        /* class com.tencent.mm.an.b.AnonymousClass3 */

        {
            AppMethodBeat.i(161771);
            this.__eventId = mb.class.getName().hashCode();
            AppMethodBeat.o(161771);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mb mbVar) {
            AppMethodBeat.i(150392);
            if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                Log.i("MicroMsg.CdnTransportService", "cdntra mm on network change callback ");
                b.this.iRr.removeMessages(1);
                b.this.iRr.sendEmptyMessageDelayed(1, 10000);
            }
            AppMethodBeat.o(150392);
            return false;
        }
    };
    p iRt = new p.a() {
        /* class com.tencent.mm.an.b.AnonymousClass4 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(150393);
            Log.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", Integer.valueOf(i2));
            if (i2 != 4 && i2 != 6) {
                AppMethodBeat.o(150393);
            } else if (!com.tencent.mm.kernel.g.aAf().azp()) {
                AppMethodBeat.o(150393);
            } else {
                b.this.iRr.removeMessages(1);
                if (!MMApplicationContext.isPushProcess()) {
                    Mars.onNetworkChange();
                }
                AppMethodBeat.o(150393);
            }
        }
    };
    private ConcurrentHashMap<String, a> iRu = new ConcurrentHashMap<>();
    final MTimerHandler iRv = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.an.b.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(223547);
            Log.i("MicroMsg.CdnTransportService", "cdnCallbackExecuteTimeReport onTimerExpired");
            b.b(b.this);
            AppMethodBeat.o(223547);
            return true;
        }
    }, true);
    ConcurrentHashMap<String, String> iRw = new ConcurrentHashMap<>();
    private boolean iRx = com.tencent.mm.ap.a.isActive();
    private Queue<String> iRy = new LinkedList();
    public Map<String, g> iRz = new HashMap();

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(150403);
        if (!com.tencent.mm.kernel.g.aAf().azp()) {
            AppMethodBeat.o(150403);
            return;
        }
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        if (mStorageEx != com.tencent.mm.kernel.g.aAh().azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(150403);
        } else if (nullAsInt != 144385) {
            AppMethodBeat.o(150403);
        } else {
            f.baN().sU(10);
            AppMethodBeat.o(150403);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(150404);
        if (qVar.getType() != 379) {
            AppMethodBeat.o(150404);
            return;
        }
        Log.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (com.tencent.mm.kernel.g.aAf().azp()) {
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.an.b.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(150398);
                    b.this.fD(true);
                    AppMethodBeat.o(150398);
                }

                public final String toString() {
                    AppMethodBeat.i(150399);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.o(150399);
                    return str;
                }
            }, "MicroMsg.Cdn.ThreadName");
        }
        AppMethodBeat.o(150404);
    }

    public static boolean sS(int i2) {
        AppMethodBeat.i(150405);
        com.tencent.mm.kernel.g.aAf();
        if (com.tencent.mm.kernel.a.azo()) {
            int nullAs = Util.nullAs((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(144385, (Object) null), 0);
            int i3 = com.tencent.mm.n.h.aqJ().getInt("CDNGrayscaleBitMask", 0);
            int i4 = com.tencent.mm.n.h.aqJ().getInt("CDNGrayscaleBitVal", 0);
            int i5 = (nullAs & (i3 ^ -1)) | (i4 & i3);
            Log.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b, CDNGrayscaleBitMask:%d, CDNGrayscaleBitVal:%d", Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i5 & i2), Boolean.valueOf(ac.jOw), Integer.valueOf(i3), Integer.valueOf(i4));
            if (ac.jOw) {
                AppMethodBeat.o(150405);
                return true;
            } else if ((i5 & i2) > 0) {
                AppMethodBeat.o(150405);
                return true;
            } else {
                AppMethodBeat.o(150405);
                return false;
            }
        } else {
            AppMethodBeat.o(150405);
            return true;
        }
    }

    public b() {
        AppMethodBeat.i(150406);
        com.tencent.mm.kernel.g.aAg().a(this.iRt);
        if (com.tencent.mm.kernel.g.aAf().azp()) {
            com.tencent.mm.kernel.g.aAh().azQ().add(this);
        }
        com.tencent.mm.kernel.g.azz().a(379, this);
        EventCenter.instance.addListener(this.iRs);
        if (baJ()) {
            this.appForegroundListener.alive();
            this.iRv.startTimer(Util.MILLSECONDS_OF_MINUTE);
        }
        Log.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", Integer.valueOf(hashCode()), Util.getStack());
        AppMethodBeat.o(150406);
    }

    public final void sT(int i2) {
        this.iRq = i2;
    }

    public final boolean b(final g gVar, final int i2) {
        AppMethodBeat.i(150407);
        if (gVar == null) {
            Log.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            AppMethodBeat.o(150407);
            return false;
        } else if (Util.isNullOrNil(gVar.field_mediaId)) {
            Log.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            AppMethodBeat.o(150407);
            return false;
        } else {
            if (gVar.field_fileId == null) {
                gVar.field_fileId = "";
            }
            if (gVar.field_aesKey == null) {
                gVar.field_aesKey = "";
            }
            gVar.ehd = false;
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.an.b.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(150400);
                    if (i2 != -1) {
                        b.this.iRB.put(gVar.field_mediaId, Integer.valueOf(i2));
                    }
                    Log.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", gVar.field_mediaId);
                    b.this.iRy.add(gVar.field_mediaId);
                    b.this.iRz.put(gVar.field_mediaId, gVar);
                    b.this.fD(false);
                    AppMethodBeat.o(150400);
                }

                public final String toString() {
                    AppMethodBeat.i(150401);
                    String str = super.toString() + "|addRecvTask";
                    AppMethodBeat.o(150401);
                    return str;
                }
            }, "MicroMsg.Cdn.ThreadName");
            AppMethodBeat.o(150407);
            return true;
        }
    }

    public final boolean d(g gVar) {
        AppMethodBeat.i(223556);
        if (gVar == null) {
            Log.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            AppMethodBeat.o(223556);
            return false;
        } else if (Util.isNullOrNil(gVar.field_mediaId)) {
            Log.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            AppMethodBeat.o(223556);
            return false;
        } else {
            if (gVar.field_fileId == null) {
                gVar.field_fileId = "";
            }
            if (gVar.field_aesKey == null) {
                gVar.field_aesKey = "";
            }
            gVar.ehd = false;
            Log.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", gVar.field_mediaId);
            this.iRy.add(gVar.field_mediaId);
            this.iRz.put(gVar.field_mediaId, gVar);
            fD(false);
            AppMethodBeat.o(223556);
            return true;
        }
    }

    public final boolean e(g gVar) {
        AppMethodBeat.i(150408);
        boolean b2 = b(gVar, -1);
        AppMethodBeat.o(150408);
        return b2;
    }

    public final boolean f(final g gVar) {
        AppMethodBeat.i(150409);
        if (gVar == null) {
            Log.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask task info is null");
            AppMethodBeat.o(150409);
            return false;
        } else if (Util.isNullOrNil(gVar.field_mediaId)) {
            Log.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
            AppMethodBeat.o(150409);
            return false;
        } else {
            if (gVar.field_fileId == null) {
                gVar.field_fileId = "";
            }
            if (gVar.field_aesKey == null) {
                gVar.field_aesKey = "";
            }
            gVar.ehd = true;
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.an.b.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(150402);
                    b.this.iRy.add(gVar.field_mediaId);
                    b.this.iRz.put(gVar.field_mediaId, gVar);
                    b.this.fD(false);
                    AppMethodBeat.o(150402);
                }

                public final String toString() {
                    AppMethodBeat.i(223551);
                    String str = super.toString() + "|addSendTask";
                    AppMethodBeat.o(223551);
                    return str;
                }
            }, "MicroMsg.Cdn.ThreadName");
            AppMethodBeat.o(150409);
            return true;
        }
    }

    public final boolean Ob(String str) {
        AppMethodBeat.i(150410);
        g remove = this.iRA.remove(str);
        if (remove != null) {
            f.baR();
            a.NT(str);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10769, Integer.valueOf(c.iSc), Integer.valueOf(remove.field_fileType), Long.valueOf(Util.nowMilliSecond() - remove.field_startTime));
        }
        this.iRz.remove(str);
        Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", str, remove, 0);
        AppMethodBeat.o(150410);
        return true;
    }

    public final boolean Oc(String str) {
        AppMethodBeat.i(150411);
        g remove = this.iRA.remove(str);
        if (remove != null) {
            if (remove.field_fileType == com.tencent.mm.i.a.gqa || remove.field_fileType == com.tencent.mm.i.a.gqc || remove.field_fileType == com.tencent.mm.i.a.gqg) {
                f.baR();
                a.NY(str);
            } else if (remove.gqH) {
                f.baR();
                a.NZ(str);
            } else {
                f.baR();
                a.NU(str);
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10769, Integer.valueOf(c.iSb), Integer.valueOf(remove.field_fileType), Long.valueOf(Util.nowMilliSecond() - remove.field_startTime));
        }
        this.iRz.remove(str);
        this.iRB.remove(str);
        Log.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, remove, 0);
        AppMethodBeat.o(150411);
        return true;
    }

    public final void fD(boolean z) {
        int i2;
        int length;
        int i3;
        int length2;
        int length3;
        int length4;
        int length5;
        int length6;
        String str;
        AppMethodBeat.i(150412);
        if (!z && f.baR().baH()) {
            com.tencent.mm.kernel.g.aAf();
            if (com.tencent.mm.kernel.a.azo()) {
                Log.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
                f.baN().sU(4);
                AppMethodBeat.o(150412);
                return;
            }
        }
        baI();
        Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", Integer.valueOf(this.iRy.size()));
        while (!this.iRy.isEmpty()) {
            g remove = this.iRz.remove(this.iRy.poll());
            if (remove == null) {
                Log.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
                AppMethodBeat.o(150412);
                return;
            }
            Log.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", remove.field_mediaId, Boolean.valueOf(remove.field_autostart), Integer.valueOf(remove.field_chattype));
            remove.field_startTime = Util.nowMilliSecond();
            if (remove.ehd) {
                Object[] objArr = new Object[8];
                if (remove.field_fullpath == null) {
                    length5 = -1;
                } else {
                    length5 = remove.field_fullpath.length();
                }
                objArr[0] = Integer.valueOf(length5);
                if (remove.field_thumbpath == null) {
                    length6 = -1;
                } else {
                    length6 = remove.field_thumbpath.length();
                }
                objArr[1] = Integer.valueOf(length6);
                objArr[2] = Util.secPrint(remove.field_svr_signature);
                objArr[3] = Util.secPrint(remove.field_aesKey);
                objArr[4] = Integer.valueOf(remove.field_fileType);
                objArr[5] = remove.field_mediaId;
                objArr[6] = Boolean.valueOf(remove.field_onlycheckexist);
                objArr[7] = Integer.valueOf(remove.field_largesvideo);
                Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b] largesvideo[%d]", objArr);
                if (remove.field_fullpath == null) {
                    remove.field_fullpath = "";
                }
                if (remove.field_thumbpath == null) {
                    remove.field_thumbpath = "";
                }
                g put = this.iRA.put(remove.field_mediaId, remove);
                g gVar = this.iRA.get(remove.field_mediaId);
                if (gVar == null) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(594, 5, 1, true);
                }
                int b2 = f.baR().b(remove);
                Object[] objArr2 = new Object[5];
                objArr2[0] = remove.field_mediaId;
                objArr2[1] = Integer.valueOf(b2);
                objArr2[2] = put == null ? null : put.field_mediaId;
                if (gVar == null) {
                    str = null;
                } else {
                    str = gVar.field_mediaId;
                }
                objArr2[3] = str;
                objArr2[4] = Integer.valueOf(hashCode());
                Log.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", objArr2);
                if (b2 != 0) {
                    Log.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", Integer.valueOf(b2), remove.field_mediaId);
                    if (-21005 != b2) {
                        Log.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", Integer.valueOf(b2), remove.field_mediaId, this.iRA.remove(remove.field_mediaId));
                    }
                    if (remove.gqy != null) {
                        remove.gqy.a(remove.field_mediaId, b2, null, null, remove.field_onlycheckexist);
                    }
                }
            } else {
                int i4 = -1;
                if (remove.field_fileType == 40001) {
                    i3 = f.baR().a(remove.field_mediaId, remove.gqB, remove.field_fullpath, remove.field_fileType, remove.field_aesKey, remove.field_authKey);
                } else if (remove.field_fileType == 19) {
                    i3 = f.baR().a(remove.field_mediaId, remove.gqB, remove.field_fullpath, remove.field_fileType, remove.field_aesKey, remove.field_authKey);
                } else if (remove.field_fileType == com.tencent.mm.i.a.gqa || remove.field_fileType == com.tencent.mm.i.a.gqc || remove.field_fileType == com.tencent.mm.i.a.gqg) {
                    if (remove.field_fullpath == null || remove.field_fullpath.isEmpty()) {
                        i2 = -1;
                    } else {
                        i2 = f.baR().a(remove.field_mediaId, remove.gqB, remove.field_fullpath, remove.field_fileType, remove.gqC, remove.gqD, remove.gqE, remove.gqF, remove.gqM, remove.gqN);
                    }
                    Object[] objArr3 = new Object[4];
                    if (remove.field_fullpath == null) {
                        length = -1;
                    } else {
                        length = remove.field_fullpath.length();
                    }
                    objArr3[0] = Integer.valueOf(length);
                    objArr3[1] = remove.field_mediaId;
                    objArr3[2] = remove.gqB;
                    objArr3[3] = Integer.valueOf(remove.field_fileType);
                    Log.i("MicroMsg.CdnTransportService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]", objArr3);
                    i3 = i2;
                } else if (remove.gqH) {
                    if (remove.field_fullpath != null && !remove.field_fullpath.isEmpty()) {
                        i4 = f.baR().a(remove.field_mediaId, remove.field_fullpath, remove.gqB, remove.gqI, remove.gqJ, remove.allow_mobile_net_download, remove.gqC, remove.gqD, remove.is_resume_task, remove.gqG, remove.gqE);
                    }
                    Object[] objArr4 = new Object[4];
                    if (remove.field_fullpath == null) {
                        length4 = -1;
                    } else {
                        length4 = remove.field_fullpath.length();
                    }
                    objArr4[0] = Integer.valueOf(length4);
                    objArr4[1] = remove.field_mediaId;
                    objArr4[2] = remove.gqB;
                    objArr4[3] = remove.gqI;
                    Log.i("MicroMsg.CdnTransportService", "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]", objArr4);
                    i3 = i4;
                } else {
                    if (!remove.gqK) {
                        Object[] objArr5 = new Object[7];
                        if (remove.field_fullpath == null) {
                            length2 = -1;
                        } else {
                            length2 = remove.field_fullpath.length();
                        }
                        objArr5[0] = Integer.valueOf(length2);
                        if (remove.field_thumbpath == null) {
                            length3 = -1;
                        } else {
                            length3 = remove.field_thumbpath.length();
                        }
                        objArr5[1] = Integer.valueOf(length3);
                        objArr5[2] = remove.field_svr_signature;
                        objArr5[3] = remove.field_aesKey;
                        objArr5[4] = Integer.valueOf(remove.field_fileType);
                        objArr5[5] = remove.field_mediaId;
                        objArr5[6] = Boolean.valueOf(remove.field_onlycheckexist);
                        Log.i("MicroMsg.CdnTransportService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", objArr5);
                        if (remove.gqO != 2) {
                            i3 = f.baR().c(remove);
                        } else if (remove instanceof com.tencent.mm.i.h) {
                            com.tencent.mm.i.h hVar = (com.tencent.mm.i.h) remove;
                            if (hVar.alQ()) {
                                i3 = f.baR().a(remove, 2);
                            } else if (hVar.alO()) {
                                hVar.connectionCount = 1;
                                hVar.concurrentCount = 1;
                                i3 = f.baR().a(hVar);
                            } else if (hVar.alP()) {
                                i3 = f.baR().d(hVar);
                            } else if (hVar.alS()) {
                                i3 = f.baR().b(hVar);
                            } else if (hVar.alU()) {
                                i3 = f.baR().d(hVar);
                            } else {
                                if (hVar.alT()) {
                                    i4 = f.baR().c(hVar);
                                }
                                i3 = i4;
                            }
                        }
                    } else if (remove instanceof f) {
                        i3 = f.baR().a((f) remove);
                    } else if (remove instanceof e) {
                        i3 = f.baR().a((e) remove);
                    }
                    i3 = -1;
                }
                if (i3 != 0) {
                    Log.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(i3), remove.field_mediaId);
                    if (remove.gqy != null) {
                        remove.gqy.a(remove.field_mediaId, i3, null, null, remove.field_onlycheckexist);
                    }
                } else {
                    g put2 = this.iRA.put(remove.field_mediaId, remove);
                    g gVar2 = this.iRA.get(remove.field_mediaId);
                    if (gVar2 == null) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(594, 6, 1, true);
                    }
                    Object[] objArr6 = new Object[5];
                    objArr6[0] = remove.field_mediaId;
                    objArr6[1] = Integer.valueOf(i3);
                    objArr6[2] = put2 == null ? null : put2.field_mediaId;
                    objArr6[3] = gVar2 == null ? null : gVar2.field_mediaId;
                    objArr6[4] = Integer.valueOf(hashCode());
                    Log.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]", objArr6);
                }
            }
        }
        AppMethodBeat.o(150412);
    }

    public final void baI() {
        AppMethodBeat.i(150413);
        com.tencent.mm.kernel.g.aAf();
        if (com.tencent.mm.kernel.a.azo()) {
            CdnLogic.Config config = new CdnLogic.Config();
            String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableCDNUploadImg");
            String value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableCDNVerifyConnect");
            String value3 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableCDNVideoRedirectOC");
            String value4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableStreamUploadVideo");
            String value5 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("C2COverloadDelaySeconds");
            String value6 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("SNSOverloadDelaySeconds");
            String value7 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableSnsStreamDownload");
            String value8 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableSnsImageDownload");
            try {
                if (!Util.isNullOrNil(value)) {
                    config.UseStreamCDN = Integer.valueOf(value).intValue();
                }
                if (!Util.isNullOrNil(value2)) {
                    config.EnableCDNVerifyConnect = Integer.valueOf(value2).intValue();
                }
                if (!Util.isNullOrNil(value3)) {
                    config.EnableCDNVideoRedirectOC = Integer.valueOf(value3).intValue();
                }
                if (!Util.isNullOrNil(value4)) {
                    config.EnableStreamUploadVideo = Integer.valueOf(value4).intValue();
                }
                if (!Util.isNullOrNil(value5)) {
                    config.C2COverloadDelaySeconds = Integer.valueOf(value5).intValue();
                }
                if (!Util.isNullOrNil(value6)) {
                    config.SNSOverloadDelaySeconds = Integer.valueOf(value6).intValue();
                }
                if (!Util.isNullOrNil(value7)) {
                    config.EnableSnsStreamDownload = Integer.valueOf(value7).intValue();
                }
                if (!Util.isNullOrNil(value8)) {
                    config.EnableSnsImageDownload = Integer.valueOf(value8).intValue();
                }
                f.baQ();
                config.EnableSafeCDN = sS(256) ? 1 : 0;
                config.EnableSnsVideoRedirect = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_enable_snsvideo_redirect, 0);
                config.ApprovedVideoHosts = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_approved_videohosts, "vweixinf.tc.qq.com,szwbwxsns.video.qq.com,szxzwxsns.video.qq.com,szzjwxsns.video.qq.com,shwbwxsns.video.qq.com,shxzwxsns.video.qq.com,shzjwxsns.video.qq.com,wxsnsdy.wxs.qq.com,vweixinthumb.tc.qq.com,wxsnsdythumb.wxs.qq.com,wxappthumb.tc.qq.com,wxapp.tc.qq.com,wxsnsdysvp.wxs.qq.com");
                StringBuilder sb = new StringBuilder();
                sb.append("clicfg_android_channelvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_channelvideo_quic, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_statusvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_statusvideo_quic, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_snsvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_snsvideo_quic, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_snsimage_quic=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_snsimage_quic, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_c2cvideo_quic=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_c2cvideo_quic, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_quic_bigfile=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_quic_bigfile, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_quic_fullimage=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_quic_fullimage, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_c2cimage2_quic=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_c2cimage2_quic, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_c2cfile_quic=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_c2cfile_quic, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_quic_backup=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_quic_backup, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                sb.append("clicfg_android_quic_favorite=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_quic_favorite, AppEventsConstants.EVENT_PARAM_VALUE_NO)).append(";");
                config.QuicExptValues = sb.toString();
                Log.i("MicroMsg.CdnTransportService", "[quic.config] expt %s", config.QuicExptValues);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("clicfg_favriate_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_favriate_maxsize_mb, "1124")).append(";");
                sb2.append("clicfg_snsvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_snsvideo_maxsize_mb, "1124")).append(";");
                sb2.append("clicfg_c2cvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2cvideo_maxsize_mb, "300")).append(";");
                sb2.append("clicfg_bigfile_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_bigfile_maxsize_mb, "1124")).append(";");
                sb2.append("clicfg_channelvideo_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_channelvideo_maxsize_mb, "1124")).append(";");
                sb2.append("clicfg_image_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_image_maxsize_mb, "56")).append(";");
                sb2.append("clicfg_c2cfile_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_c2cfile_maxsize_mb, "56")).append(";");
                sb2.append("clicfg_adimage_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_adimage_maxsize_mb, "100")).append(";");
                sb2.append("clicfg_default_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_default_maxsize_mb, "4096")).append(";");
                sb2.append("clicfg_wecom_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wecom_maxsize_mb, "4096")).append(";");
                sb2.append("clicfg_3rdhttp_maxsize_mb=").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_3rdhttp_maxsize_mb, "4096")).append(";");
                config.MiscellaneousExptValues = sb2.toString();
                if (config.UseStreamCDN != 0) {
                    String value9 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ProgJPEGUploadSizeLimitWifi");
                    String value10 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ProgJPEGUploadSizeLimit3G");
                    String value11 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("ProgJPEGDownloadSizeLimit");
                    String value12 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableJPEGDyncmicETL");
                    if (!Util.isNullOrNil(value9)) {
                        config.WifiEtl = Integer.valueOf(value9).intValue();
                    }
                    if (!Util.isNullOrNil(value10)) {
                        config.MobileEtl = Integer.valueOf(value10).intValue();
                    }
                    if (!Util.isNullOrNil(value11)) {
                        config.Ptl = Integer.valueOf(value11).intValue();
                    }
                    if (!Util.isNullOrNil(value12)) {
                        config.UseDynamicETL = Integer.valueOf(value12).intValue();
                    }
                }
                if (this.iRq != -1) {
                    Log.w("MicroMsg.CdnTransportService", "cmd set snsimage flag: %d", Integer.valueOf(this.iRq));
                    config.EnableSnsImageDownload = this.iRq;
                }
                Log.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", config);
                CdnLogic.setConfig(config);
            } catch (NumberFormatException e2) {
                Log.e("MicroMsg.CdnTransportService", e2.toString());
            }
            if (ac.jOV) {
                Log.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
                config.UseStreamCDN = 1;
                config.EnableSnsVideoRedirect = ac.jPb;
                Log.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", config);
                CdnLogic.setConfig(config);
            }
        }
        AppMethodBeat.o(150413);
    }

    @Override // com.tencent.mm.i.b.a
    public final int a(final String str, final c cVar, final d dVar) {
        AppMethodBeat.i(150414);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
            AppMethodBeat.o(150414);
            return -1;
        } else if (cVar == null && dVar == null) {
            Log.e("MicroMsg.CdnTransportService", "cdn callback info all null");
            AppMethodBeat.o(150414);
            return -2;
        } else {
            if (cVar != null) {
                Log.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", Long.valueOf(cVar.field_toltalLength), Long.valueOf(cVar.field_finishedLength), Boolean.valueOf(cVar.field_mtlnotify));
            }
            this.iRD = Util.nowMilliSecond();
            this.iRC = str;
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.an.b.AnonymousClass10 */

                public final void run() {
                    f fVar;
                    AppMethodBeat.i(223552);
                    g gVar = (g) b.this.iRA.get(str);
                    if (gVar == null) {
                        Log.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", str, Integer.valueOf(b.this.hashCode()));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(594, 7, 1, true);
                        AppMethodBeat.o(223552);
                        return;
                    }
                    a a2 = b.a(b.this, gVar);
                    if (cVar != null) {
                        cVar.mediaId = str;
                        Log.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", Long.valueOf(cVar.field_toltalLength), Long.valueOf(cVar.field_finishedLength), Boolean.valueOf(cVar.field_mtlnotify));
                    }
                    if (dVar != null) {
                        dVar.mediaId = str;
                    }
                    if (gVar.gqy != null) {
                        long nowMilliSecond = Util.nowMilliSecond();
                        if (dVar != null || cVar == null || cVar.field_mtlnotify || NetStatusUtil.getNetWorkType(MMApplicationContext.getContext()) != -1) {
                            gVar.field_lastProgressCallbackTime = nowMilliSecond;
                            gVar.gqy.a(str, 0, cVar, dVar, gVar.field_onlycheckexist);
                        } else {
                            b.a(b.this, a2);
                            AppMethodBeat.o(223552);
                            return;
                        }
                    }
                    if (gVar instanceof f) {
                        fVar = (f) gVar;
                    } else {
                        fVar = null;
                    }
                    if (b.a(cVar) && (fVar == null || fVar.alN())) {
                        b.this.iRB.remove(str);
                    }
                    if (dVar != null) {
                        if (fVar == null || fVar.alN()) {
                            b.this.iRA.remove(str);
                        }
                        if (dVar.field_retCode == -5103011) {
                            Log.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(546, 4, 1, true);
                            f.baR().keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                    b.b(b.this, a2);
                    AppMethodBeat.o(223552);
                }

                public final String toString() {
                    AppMethodBeat.i(223553);
                    String str = super.toString() + "|callback";
                    AppMethodBeat.o(223553);
                    return str;
                }
            }, g(this.iRA.get(str)));
            AppMethodBeat.o(150414);
            return 0;
        }
    }

    @Override // com.tencent.mm.i.b.a
    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.i(150415);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
            AppMethodBeat.o(150415);
            return;
        }
        g gVar = this.iRA.get(str);
        if (gVar == null) {
            Log.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", str);
            AppMethodBeat.o(150415);
        } else if (gVar.gqy != null) {
            gVar.gqy.a(str, byteArrayOutputStream);
            AppMethodBeat.o(150415);
        } else {
            Log.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
            AppMethodBeat.o(150415);
        }
    }

    @Override // com.tencent.mm.i.b.a
    public final byte[] f(String str, byte[] bArr) {
        AppMethodBeat.i(150416);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
            AppMethodBeat.o(150416);
            return null;
        }
        g gVar = this.iRA.get(str);
        if (gVar == null) {
            Log.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            AppMethodBeat.o(150416);
            return null;
        } else if (gVar.gqy != null) {
            byte[] f2 = gVar.gqy.f(str, bArr);
            AppMethodBeat.o(150416);
            return f2;
        } else {
            Log.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
            AppMethodBeat.o(150416);
            return null;
        }
    }

    @Override // com.tencent.mm.i.b.a
    public final int a(final String str, final d dVar) {
        AppMethodBeat.i(223557);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(223557);
        } else {
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.an.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(223546);
                    g gVar = (g) b.this.iRA.get(str);
                    if (gVar == null) {
                        Log.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", str);
                        AppMethodBeat.o(223546);
                        return;
                    }
                    if (gVar.gqQ != null) {
                        gVar.gqQ.b(str, dVar);
                    }
                    AppMethodBeat.o(223546);
                }
            }, g(this.iRA.get(str)));
            AppMethodBeat.o(223557);
        }
        return 0;
    }

    private String g(g gVar) {
        AppMethodBeat.i(223558);
        if (gVar == null || Util.isNullOrNil(gVar.taskName)) {
            AppMethodBeat.o(223558);
            return "MicroMsg.CdnTransportService";
        } else if (this.iRw.containsKey(gVar.taskName)) {
            String str = this.iRw.get(gVar.taskName);
            AppMethodBeat.o(223558);
            return str;
        } else {
            String str2 = "MicroMsg.CdnTransportService_" + ((this.iRw.size() + 1) % baK());
            this.iRw.put(gVar.taskName, str2);
            Log.i("MicroMsg.CdnTransportService", "taskName:%s tag:%s", Util.nullAs(gVar.taskName, ""), Util.nullAs(str2, ""));
            AppMethodBeat.o(223558);
            return str2;
        }
    }

    private static void a(a aVar) {
        AppMethodBeat.i(223559);
        if (aVar == null) {
            AppMethodBeat.o(223559);
            return;
        }
        long j2 = aVar.endTime - aVar.startTime;
        ArrayList<IDKey> arrayList = new ArrayList<>();
        arrayList.add(z(5, j2));
        int i2 = 10;
        int length = iRF.length - 1;
        while (true) {
            if (length < 0) {
                break;
            } else if (j2 >= iRF[length]) {
                i2 = iRG[length];
                break;
            } else {
                length--;
            }
        }
        arrayList.add(z(i2, 1));
        arrayList.add(z(0, 1));
        com.tencent.mm.plugin.report.e.INSTANCE.b(arrayList, false);
        Log.i("MicroMsg.CdnTransportService", "reportCDNCallbackTime(%s) taskName:%s cdnCallbackReportId:%s mediaId:%s duration:%s(%s-%s)", Long.valueOf(aVar.threadId), aVar.taskName, Util.nullAs(aVar.iRP, ""), Util.nullAs(aVar.field_mediaId, ""), Long.valueOf(j2), Long.valueOf(aVar.startTime), Long.valueOf(aVar.endTime));
        AppMethodBeat.o(223559);
    }

    private static IDKey z(int i2, long j2) {
        AppMethodBeat.i(223560);
        IDKey iDKey = new IDKey();
        iDKey.SetID(1452);
        iDKey.SetKey(i2);
        iDKey.SetValue(j2);
        AppMethodBeat.o(223560);
        return iDKey;
    }

    public static boolean baJ() {
        AppMethodBeat.i(223561);
        String b2 = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_cdn_callback_consume_time_statistics_switch", "1", false, true);
        Log.d("MicroMsg.CdnTransportService", "canCDNCallbackStatistics() sw:%s", b2);
        boolean isEqual = Util.isEqual(b2, "1");
        AppMethodBeat.o(223561);
        return isEqual;
    }

    private static int baK() {
        AppMethodBeat.i(223562);
        if (iRH == -1) {
            String b2 = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_cdn_callback_tag_max_num", "1", false, true);
            Log.d("MicroMsg.CdnTransportService", "getTagMaxNum() maxNum:%s", b2);
            iRH = Util.getInt(b2, 1);
        }
        int i2 = iRH;
        AppMethodBeat.o(223562);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public boolean ehd;
        public int ejG = 0;
        public int ejH = 0;
        public int ejI = 0;
        public int ejJ = 0;
        public int ejK = 0;
        public int ejL = 0;
        public int ejM = 0;
        public int ejN = 0;
        public String ejO = "";
        public int ejP = 0;
        public int ejQ = 0;
        public long endTime = -1;
        public String field_mediaId = "";
        public int field_totalLen = 0;
        public String iRP = "";
        public long iRQ = 0;
        public long startTime = 0;
        public String taskName = "task_default";
        public long threadId = 0;

        public a(String str, String str2, String str3, long j2, g gVar) {
            int i2 = 0;
            AppMethodBeat.i(223554);
            this.iRP = str;
            this.taskName = str2;
            this.field_mediaId = str3;
            this.ehd = gVar.ehd;
            this.field_totalLen = gVar.field_totalLen;
            this.startTime = j2;
            this.threadId = Thread.currentThread().getId();
            this.ejG = gVar.field_fileType;
            this.ejH = gVar.field_appType;
            this.ejI = gVar.field_bzScene;
            this.ejJ = gVar.fuQ;
            this.ejK = gVar.field_chattype;
            this.ejL = gVar.field_advideoflag;
            this.ejM = gVar.field_largesvideo;
            this.ejN = gVar.field_requestVideoFormat;
            this.ejO = Util.nullAs(gVar.field_snsScene, "");
            this.ejP = gVar.gqK ? 1 : i2;
            this.ejQ = gVar.gqP;
            this.iRQ = System.currentTimeMillis();
            AppMethodBeat.o(223554);
        }

        public final String toString() {
            AppMethodBeat.i(223555);
            String str = "CdnTaskReportInfo{cdnCallbackReportId='" + this.iRP + '\'' + ", taskName='" + this.taskName + '\'' + ", field_mediaId='" + this.field_mediaId + '\'' + ", isSend=" + this.ehd + ", field_totalLen=" + this.field_totalLen + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadId=" + this.threadId + ", _FileType=" + this.ejG + ", _AppType=" + this.ejH + ", _BzScene=" + this.ejI + ", _BizType=" + this.ejJ + ", _Chattype=" + this.ejK + ", _Advideoflag=" + this.ejL + ", _Largesvideo=" + this.ejM + ", _RequestVideoFormat=" + this.ejN + ", _SnsScene='" + this.ejO + '\'' + ", _SnsImageDownload=" + this.ejP + ", _VideoTaskType=" + this.ejQ + ", localTime=" + this.iRQ + '}';
            AppMethodBeat.o(223555);
            return str;
        }
    }

    static /* synthetic */ void b(b bVar) {
        int i2;
        long j2;
        AppMethodBeat.i(223563);
        if (baJ()) {
            ArrayList<String> arrayList = new ArrayList();
            for (Map.Entry<String, a> entry : bVar.iRu.entrySet()) {
                a value = entry.getValue();
                if (value.endTime > 0) {
                    a(value);
                    arrayList.add(entry.getKey());
                } else if (System.currentTimeMillis() - value.startTime > 120000) {
                    if (value != null) {
                        Log.i("MicroMsg.CdnTransportService", "reportCDNCallbackTime(%s) taskName:%s cdnCallbackReportId:%s id:%s", Long.valueOf(value.threadId), value.taskName, Util.nullAs(value.iRP, ""), Util.nullAs(value.field_mediaId, ""));
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1452, 34, 1, false);
                    }
                    arrayList.add(entry.getKey());
                }
            }
            for (String str : arrayList) {
                a remove = bVar.iRu.remove(str);
                if (remove != null) {
                    com.tencent.mm.g.b.a.h hVar = new com.tencent.mm.g.b.a.h();
                    hVar.ejC = hVar.x("MediaId", remove.field_mediaId, true);
                    if (remove.ehd) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    hVar.ejD = i2;
                    hVar.ejE = remove.field_totalLen;
                    if (remove.endTime <= 0) {
                        j2 = 120000;
                    } else {
                        j2 = remove.endTime - remove.startTime;
                    }
                    if (iRI == -1) {
                        String b2 = com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_cdn_callback_consume_time_kv_report_min", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true);
                        iRI = Util.getLong(b2, 0);
                        Log.d("MicroMsg.CdnTransportService", "getCDNCallbackKVStatisticsMinTime() minTime:%s", b2);
                    }
                    if (j2 >= iRI) {
                        hVar.ejF = (int) j2;
                        hVar.ejG = remove.ejG;
                        hVar.ejH = remove.ejH;
                        hVar.ejI = remove.ejI;
                        hVar.ejJ = remove.ejJ;
                        hVar.ejK = remove.ejK;
                        hVar.ejL = remove.ejL;
                        hVar.ejM = remove.ejM;
                        hVar.ejN = remove.ejN;
                        hVar.ejO = hVar.x("SnsScene", remove.ejO, true);
                        hVar.ejP = remove.ejP;
                        hVar.ejQ = remove.ejQ;
                        hVar.ejR = j2;
                        hVar.ejS = remove.startTime;
                        hVar.ejT = remove.endTime;
                        hVar.ejU = remove.threadId;
                        hVar.ejV = hVar.x("TaskName", remove.taskName, true);
                        hVar.bfK();
                        Log.i("MicroMsg.CdnTransportService", "kvCDNCallbackTimeReport(%s) taskName:%s cdnCallbackReportId:%s mediaId:%s duration:%s(%s-%s) localTime:%s", Long.valueOf(remove.threadId), remove.taskName, Util.nullAs(remove.iRP, ""), Util.nullAs(remove.field_mediaId, ""), Long.valueOf(j2), Long.valueOf(remove.startTime), Long.valueOf(remove.endTime), Long.valueOf(remove.iRQ));
                    }
                }
            }
        }
        AppMethodBeat.o(223563);
    }

    static /* synthetic */ a a(b bVar, g gVar) {
        AppMethodBeat.i(223564);
        if (!bVar.iRx) {
            AppMethodBeat.o(223564);
            return null;
        } else if (gVar == null) {
            AppMethodBeat.o(223564);
            return null;
        } else {
            String str = gVar.field_mediaId + cl.aWy();
            a aVar = new a(str, gVar.taskName, gVar.field_mediaId, System.currentTimeMillis(), gVar);
            bVar.iRu.put(str, aVar);
            AppMethodBeat.o(223564);
            return aVar;
        }
    }

    static /* synthetic */ void a(b bVar, a aVar) {
        AppMethodBeat.i(223565);
        if (bVar.iRx && aVar != null) {
            bVar.iRu.remove(aVar.iRP);
        }
        AppMethodBeat.o(223565);
    }

    static /* synthetic */ boolean a(c cVar) {
        if (cVar == null || cVar.field_finishedLength == cVar.field_toltalLength) {
            return true;
        }
        return false;
    }

    static /* synthetic */ void b(b bVar, a aVar) {
        AppMethodBeat.i(223566);
        if (bVar.iRx && aVar != null) {
            if (bVar.iRu.containsKey(aVar.iRP)) {
                aVar.endTime = System.currentTimeMillis();
                bVar.iRu.put(aVar.iRP, aVar);
                AppMethodBeat.o(223566);
                return;
            }
            Log.i("MicroMsg.CdnTransportService", "cdnCallBackReportHashMap no exist %s，duration:%s-%s", Util.nullAs(aVar.field_mediaId, ""), Long.valueOf(aVar.startTime), Long.valueOf(cl.aWy()));
        }
        AppMethodBeat.o(223566);
    }
}
