package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.y;
import com.tencent.mm.an.e;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.d;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.n.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import java.io.IOException;
import java.util.HashMap;

public final class j extends a implements d.a, t.a {
    private static y PAo = null;
    public static boolean PAp = false;
    private MTimerHandler Ehq = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass15 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(36258);
            if (!j.this.PAh.isStreaming()) {
                AppMethodBeat.o(36258);
                return false;
            }
            k gSh = j.this.Pwu.gSh();
            if (gSh == null) {
                AppMethodBeat.o(36258);
                return false;
            } else if (gSh.PAL == null) {
                AppMethodBeat.o(36258);
                return false;
            } else if (gSh.gTe().PAL.getVisibility() != 0) {
                AppMethodBeat.o(36258);
                return false;
            } else {
                boolean z = true;
                if (gSh.gTe().PAO.isPlaying()) {
                    z = j.c(j.this, gSh);
                }
                if (z) {
                    boolean ub = j.this.PAh.ub(gSh.gTe().PAO.getCurrentPosition() / 1000);
                    AppMethodBeat.o(36258);
                    return ub;
                }
                AppMethodBeat.o(36258);
                return false;
            }
        }
    }, true);
    private j.e EtE = new j.e() {
        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass7 */

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
        public final void bLh() {
            AppMethodBeat.i(36250);
            Log.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", Integer.valueOf(j.this.hashCode()));
            try {
                j.this.Pwu.gSh().d(true, 1.0f);
                AppMethodBeat.o(36250);
            } catch (Exception e2) {
                Log.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + e2.toString());
                AppMethodBeat.o(36250);
            }
        }
    };
    private boolean EtM;
    private long EtQ = 0;
    private long EtR = 0;
    private long Eua;
    private int Eub;
    private IListener PAf;
    final SparseArray<s> PAg = new SparseArray<>();
    private o PAh;
    private boolean PAi = false;
    private boolean PAj = false;
    private boolean PAk = false;
    private int PAl = 0;
    private int PAm = 0;
    private boolean PAn = false;
    MMHandler PAq = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback() {
        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass11 */

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(36254);
            if (message.what == 1) {
                k gSh = j.this.Pwu.gSh();
                if (gSh != null && !Util.isNullOrNil(j.this.filename)) {
                    Log.i("MicroMsg.Imagegallery.handler.video", "%d ui on pause, pause video now. %s", Integer.valueOf(hashCode()), j.this.filename);
                    if (!j.this.PAj) {
                        u.f(j.this.filename, gSh.gTe().PAO.getCurrentPosition(), j.this.EtM);
                    }
                    j.g(gSh);
                    j.b(j.this, gSh);
                    j.this.pNk.fp(false);
                    if (j.this.EtM) {
                        EventCenter.instance.removeListener(j.this.PAs);
                        j.this.PAh.gTi();
                        j.this.EtM = false;
                    }
                }
                j.this.PAi = false;
            }
            AppMethodBeat.o(36254);
            return false;
        }
    });
    private int PAr = 0;
    private IListener<oq> PAs = new IListener<oq>() {
        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass4 */

        {
            AppMethodBeat.i(161545);
            this.__eventId = oq.class.getName().hashCode();
            AppMethodBeat.o(161545);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(oq oqVar) {
            AppMethodBeat.i(36247);
            boolean a2 = a(oqVar);
            AppMethodBeat.o(36247);
            return a2;
        }

        private boolean a(oq oqVar) {
            AppMethodBeat.i(36246);
            if (!j.this.PAh.aQW(oqVar.dUF.mediaId)) {
                AppMethodBeat.o(36246);
                return false;
            } else if (oqVar.dUF.retCode == 0 || oqVar.dUF.retCode == -21006) {
                switch (oqVar.dUF.dKy) {
                    case 1:
                        o oVar = j.this.PAh;
                        long j2 = (long) oqVar.dUF.offset;
                        long j3 = oqVar.dUF.dUG;
                        boolean z = oqVar.dUF.dUH;
                        Log.i("MicroMsg.OnlineVideoUIHelper", "deal moov ready moovPos[%d] needSeekTime[%d] timeDuration[%d] startDownload[%d %d]", Long.valueOf(j2), Integer.valueOf(oVar.jpZ), Integer.valueOf(oVar.jpY), Long.valueOf(j3), Long.valueOf(oVar.gqR));
                        if (oVar.jpY != 0) {
                            Log.w("MicroMsg.OnlineVideoUIHelper", "moov had callback, do nothing.");
                        } else {
                            if (j3 <= oVar.gqR) {
                                j3 = oVar.gqR;
                            }
                            oVar.gqR = j3;
                            h.INSTANCE.idkeyStat(354, 5, 1, false);
                            oVar.Eut = Util.nowMilliSecond();
                            o.bhj();
                            String Qw = t.Qw(oVar.filename);
                            try {
                                if (oVar.Eup == null) {
                                    Log.w("MicroMsg.OnlineVideoUIHelper", "parser is null, thread is error.");
                                } else if (oVar.Eup.L(Qw, j2)) {
                                    oVar.jpY = oVar.Eup.jQw;
                                    Log.i("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov success. duration %d filename %s isFastStart %b", Integer.valueOf(oVar.jpY), oVar.filename, Boolean.valueOf(z));
                                    if (!z) {
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.ui.chatting.gallery.o.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(36392);
                                                if (o.this.PBI != null) {
                                                    if (o.this.ub(u.Q(o.this.jpY, o.this.filename))) {
                                                        if (o.this.Eus == 0 && o.this.Euu == 0) {
                                                            o.this.fgB();
                                                        }
                                                        o.this.PBI.cq(o.this.filename, true);
                                                        o.this.jqe = true;
                                                    }
                                                }
                                                AppMethodBeat.o(36392);
                                            }
                                        });
                                    }
                                    if (oVar.jpZ == -1) {
                                        oVar.jpW = 1;
                                    } else {
                                        oVar.jpW = 2;
                                    }
                                    h.INSTANCE.idkeyStat(354, 7, 1, false);
                                } else {
                                    Log.w("MicroMsg.OnlineVideoUIHelper", "mp4 parse moov error.");
                                    o.bhk();
                                    e.r(oVar.mediaId, 0, -1);
                                    u.az(oVar.filename, 15);
                                    h.INSTANCE.idkeyStat(354, 8, 1, false);
                                    Log.w("MicroMsg.OnlineVideoUIHelper", "%d rpt parse moov fail %s ", Integer.valueOf(oVar.hashCode()), oVar.filename);
                                    h.INSTANCE.a(13836, 302, Long.valueOf(Util.nowSecond()), "");
                                }
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e2, "", new Object[0]);
                                Log.e("MicroMsg.OnlineVideoUIHelper", "deal moov ready error: " + e2.toString());
                            }
                        }
                        j.this.EtM = true;
                        break;
                    case 2:
                        o oVar2 = j.this.PAh;
                        String str = oqVar.dUF.mediaId;
                        int i2 = oqVar.dUF.offset;
                        int i3 = oqVar.dUF.length;
                        oVar2.jqf = false;
                        if (i2 < 0 || i3 < 0) {
                            Log.w("MicroMsg.OnlineVideoUIHelper", "deal data available error offset[%d], length[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
                        } else if (oVar2.aQW(str)) {
                            Integer num = oVar2.Euo.get(oVar2.mediaId + i2 + "_" + i3);
                            if (num == null || num.intValue() <= 0) {
                                try {
                                    oVar2.jqc = oVar2.Eup.dG(i2, i3);
                                } catch (Exception e3) {
                                    Log.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e3, "", new Object[0]);
                                    Log.e("MicroMsg.OnlineVideoUIHelper", "deal data available file pos to video time error: " + e3.toString());
                                }
                            } else {
                                oVar2.jqc = num.intValue();
                            }
                            Log.i("MicroMsg.OnlineVideoUIHelper", "deal data available. offset[%d] length[%d] cachePlayTime[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(oVar2.jqc));
                        }
                        if (oqVar.dUF.length > 0) {
                            j.this.fO(true);
                            break;
                        }
                        break;
                    case 3:
                        j.this.fO(true);
                        break;
                    case 4:
                        o oVar3 = j.this.PAh;
                        Log.i("MicroMsg.OnlineVideoUIHelper", "deal stream finish. playStatus %d ", Integer.valueOf(oVar3.jpW));
                        oVar3.jqf = false;
                        oVar3.jpV = 3;
                        if (oVar3.jpW == 0) {
                            Log.w("MicroMsg.OnlineVideoUIHelper", "it had not moov callback and download finish start to play video.");
                            oVar3.fgy();
                            h.INSTANCE.idkeyStat(354, 6, 1, false);
                        } else if (oVar3.jpW == 5) {
                            Log.w("MicroMsg.OnlineVideoUIHelper", "it had play error, it request all video data finish, start to play." + oVar3.mediaId);
                            oVar3.fgy();
                        }
                        oVar3.gTk();
                        h.INSTANCE.idkeyStat(354, 26, 1, false);
                        j.this.fO(true);
                        break;
                    case 5:
                        o oVar4 = j.this.PAh;
                        String str2 = oqVar.dUF.mediaId;
                        int i4 = oqVar.dUF.offset;
                        if (oVar4.aQW(str2)) {
                            if (oVar4.kKK != 0) {
                                oVar4.Eur = (i4 * 100) / oVar4.kKK;
                            }
                            Log.i("MicroMsg.OnlineVideoUIHelper", "deal progress callback. downloadedPercent : " + oVar4.Eur);
                        }
                        if (oVar4.Eur >= 100) {
                            oVar4.jpV = 3;
                            break;
                        }
                        break;
                    case 6:
                        o oVar5 = j.this.PAh;
                        Log.i("MicroMsg.OnlineVideoUIHelper", "deal had dup video.");
                        oVar5.gTk();
                        oVar5.fgy();
                        break;
                    default:
                        Log.w("MicroMsg.Imagegallery.handler.video", "unknown event opcode " + oqVar.dUF.dKy);
                        break;
                }
                AppMethodBeat.o(36246);
                return false;
            } else {
                Log.w("MicroMsg.Imagegallery.handler.video", "stream download online video error. retCode: " + oqVar.dUF.retCode);
                j.a(j.this, oqVar.dUF.mediaId, oqVar.dUF.retCode);
                AppMethodBeat.o(36246);
                return false;
            }
        }
    };
    private boolean PAt = false;
    private int PAu = 0;
    private int[] PAv = {-1000, -2000, 3400};
    private HashMap<String, a> Pyt;
    private String filename;
    private PowerManager.WakeLock hCN;
    private long lastCheckTime = 0;
    private long mEN = 0;
    private d pNk;
    private MTimerHandler qbP = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass16 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(36259);
            if (j.this.Pwu == null) {
                Log.w("MicroMsg.Imagegallery.handler.video", "[onTimerExpired] null == adapter");
                AppMethodBeat.o(36259);
                return false;
            }
            k gSh = j.this.Pwu.gSh();
            if (gSh == null) {
                AppMethodBeat.o(36259);
                return false;
            } else if (gSh.PAL == null) {
                AppMethodBeat.o(36259);
                return false;
            } else if (gSh.gTe().PAL.getVisibility() != 0) {
                AppMethodBeat.o(36259);
                return false;
            } else {
                int currentItem = j.this.Pwu.Pwv.getCurrentItem();
                if (j.this.PAg.get(currentItem) == null) {
                    j.this.ank(currentItem);
                    AppMethodBeat.o(36259);
                    return false;
                } else if (!gSh.gTe().PAO.isPlaying()) {
                    Log.i("MicroMsg.Imagegallery.handler.video", "it is not playing, stop offline timer");
                    AppMethodBeat.o(36259);
                    return false;
                } else {
                    j.this.tnc = gSh.gTe().PAO.getCurrentPosition();
                    j.this.anl(j.this.tnc / 1000);
                    AppMethodBeat.o(36259);
                    return true;
                }
            }
        }
    }, true);
    int tnb = 0;
    private int tnc = 0;
    private b tni = new b() {
        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void aJq() {
            AppMethodBeat.i(36244);
            if (j.this.Pwu.gSh() != null) {
                j.b(j.this, j.this.Pwu.gSh());
            }
            j.this.Pwu.Pwv.tnh.stopTimer();
            AppMethodBeat.o(36244);
        }

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void rk(int i2) {
            boolean bL;
            AppMethodBeat.i(36245);
            String str = null;
            try {
                str = j.this.Pwu.gSh().gTe().PAO.getVideoPath();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e2, "", new Object[0]);
                Log.e("MicroMsg.Imagegallery.handler.video", "on seek get video path error: " + e2.toString());
            }
            Log.i("MicroMsg.Imagegallery.handler.video", "on seek to time[%d] isOnlinePlay[%b] videoPath[%s]", Integer.valueOf(i2), Boolean.valueOf(j.this.EtM), str);
            j.this.Pwu.gSh().gTe().PAN.setVisibility(8);
            if (!Util.isNullOrNil(str)) {
                if (!j.this.EtM) {
                    j.this.aT(i2, true);
                    bL = true;
                } else {
                    bL = j.this.PAh.bL(i2, true);
                }
                if (bL) {
                    j.this.fO(false);
                }
            } else {
                ca gSg = j.this.Pwu.gSg();
                if (gSg != null && gSg.cWJ()) {
                    u.f(gSg.field_imgPath, i2 * 1000, j.this.EtM);
                }
                j.this.Pwu.amS(j.this.Pwu.Pwv.getCurrentItem());
            }
            j.this.Pwu.Pwv.gSQ();
            ca gSg2 = j.this.Pwu.gSg();
            if (gSg2 != null && gSg2.cWK()) {
                j.this.Pwu.Pwv.PyB.i(gSg2, 13);
            }
            AppMethodBeat.o(36245);
        }
    };
    private com.tencent.mm.plugin.n.b zrF = new com.tencent.mm.plugin.n.b() {
        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.n.b
        public final long eja() {
            AppMethodBeat.i(36251);
            Log.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", Integer.valueOf(j.this.hashCode()));
            bg.aVF();
            c.azQ().set(ar.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
            try {
                if (j.this.EtM && j.this.PAh != null) {
                    long j2 = (long) j.this.PAh.jqc;
                    AppMethodBeat.o(36251);
                    return j2;
                }
            } catch (Exception e2) {
            }
            AppMethodBeat.o(36251);
            return 0;
        }
    };

    static /* synthetic */ void a(j jVar, ca caVar, s sVar, int i2, boolean z) {
        AppMethodBeat.i(36316);
        jVar.a(caVar, sVar, i2, z);
        AppMethodBeat.o(36316);
    }

    static /* synthetic */ void a(j jVar, k kVar) {
        AppMethodBeat.i(36309);
        jVar.c(kVar);
        AppMethodBeat.o(36309);
    }

    static /* synthetic */ void a(j jVar, k kVar, String str) {
        AppMethodBeat.i(36310);
        jVar.a(kVar, str);
        AppMethodBeat.o(36310);
    }

    static /* synthetic */ void b(j jVar, k kVar) {
        AppMethodBeat.i(36312);
        jVar.d(kVar);
        AppMethodBeat.o(36312);
    }

    static /* synthetic */ boolean c(j jVar, k kVar) {
        AppMethodBeat.i(36314);
        boolean f2 = jVar.f(kVar);
        AppMethodBeat.o(36314);
        return f2;
    }

    static /* synthetic */ void g(k kVar) {
        AppMethodBeat.i(36311);
        e(kVar);
        AppMethodBeat.o(36311);
    }

    static /* synthetic */ void k(j jVar) {
        AppMethodBeat.i(36313);
        jVar.fgp();
        AppMethodBeat.o(36313);
    }

    public j(b bVar) {
        super(bVar);
        AppMethodBeat.i(36261);
        PAo = null;
        this.Pyt = new HashMap<>();
        this.PAh = new o(this);
        EventCenter eventCenter = EventCenter.instance;
        al alVar = new al(al.a.VIDEO_GALLERY, bVar.Pwv);
        this.PAf = alVar;
        eventCenter.addListener(alVar);
        EventCenter.instance.addListener(this.PAs);
        this.pNk = new d();
        AppMethodBeat.o(36261);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.a
    public final boolean a(k kVar, ca caVar, int i2) {
        AppMethodBeat.i(36262);
        super.a(kVar, caVar, i2);
        s cH = cH(caVar);
        if (caVar == null) {
            Log.e("MicroMsg.Imagegallery.handler.video", "msg is null!!");
            AppMethodBeat.o(36262);
            return false;
        }
        if (this.Pyt != null) {
            this.Pyt.put(caVar.field_imgPath, new a(caVar, i2));
        } else {
            Log.e("MicroMsg.Imagegallery.handler.video", "mCacheMap is null!");
        }
        if (cH == null) {
            AppMethodBeat.o(36262);
            return false;
        }
        if (caVar.cWK()) {
            y cG = cG(caVar);
            if (cG != null) {
                String bdu = com.tencent.mm.pluginsdk.model.s.bdu(cG.iAo);
                com.tencent.mm.av.a.a bcV = q.bcV();
                String str = cG.iAo;
                ImageView imageView = kVar.gTe().PAM;
                c.a aVar = new c.a();
                aVar.fullPath = bdu;
                aVar.jbf = true;
                bcV.a(str, imageView, aVar.bdv());
                m mVar = m.PBF;
                crj bnb = m.bnb(cG.HJ(caVar.field_imgPath));
                if (bnb.LZv == 1) {
                    a(kVar, bnb.LZw);
                } else {
                    b(kVar);
                }
            }
        } else {
            ImageView imageView2 = kVar.gTe().PAM;
            Log.i("MicroMsg.Imagegallery.handler.video", "[+] [tomys] Easy crash pos, bitmap will be down sample to reduce mem cost.");
            o.bhj();
            String Qx = t.Qx(caVar.field_imgPath);
            Bitmap decodeFileWithMemLimit = BackwardSupportUtil.BitmapFactory.decodeFileWithMemLimit(Qx, 4194304);
            if (decodeFileWithMemLimit != null) {
                Log.i("MicroMsg.Imagegallery.handler.video", "[+] [tomys] Bitmap decoded, file: %s, w: %s, h: %s", Qx, Integer.valueOf(decodeFileWithMemLimit.getWidth()), Integer.valueOf(decodeFileWithMemLimit.getHeight()));
            } else {
                Log.e("MicroMsg.Imagegallery.handler.video", "[-] [tomys] Fail to decode file: %s", Qx);
            }
            imageView2.setImageBitmap(decodeFileWithMemLimit);
            b(kVar);
        }
        if (kVar.gTe().PAO.isPlaying()) {
            kVar.gTe().PAO.stop();
        }
        if (kVar.gTe().PAO instanceof VideoPlayerTextureView) {
            if (ao.gJK()) {
                ((VideoPlayerTextureView) kVar.gTe().PAO).setScaleType(i.e.CONTAIN);
            } else {
                ((VideoPlayerTextureView) kVar.gTe().PAO).setScaleType(i.e.DEFAULT);
            }
        }
        kVar.PAQ.setVisibility(8);
        kVar.gTe().PAP.setVisibility(8);
        kVar.gTe().PAY.setVisibility(8);
        kVar.d(false, 0.0f);
        this.PAl = 0;
        this.EtQ = Util.nowMilliSecond();
        AppMethodBeat.o(36262);
        return true;
    }

    public static s cF(ca caVar) {
        AppMethodBeat.i(36263);
        if (!b.m(caVar)) {
            AppMethodBeat.o(36263);
            return null;
        }
        s QN = u.QN(caVar.field_imgPath);
        AppMethodBeat.o(36263);
        return QN;
    }

    private static y br(Activity activity) {
        AppMethodBeat.i(36264);
        if (PAo == null) {
            byte[] byteArrayExtra = activity.getIntent().getByteArrayExtra("img_gallery_mp_share_video_info");
            if (Util.isNullOrNil(byteArrayExtra)) {
                Log.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo data is null");
                activity.finish();
                AppMethodBeat.o(36264);
                return null;
            }
            try {
                y yVar = new y();
                yVar.parseFrom(byteArrayExtra);
                PAo = yVar;
            } catch (IOException e2) {
                Log.e("MicroMsg.Imagegallery.handler.video", "initMPShareVideoInfo ex %s", e2.getMessage());
                activity.finish();
            }
        }
        y yVar2 = PAo;
        AppMethodBeat.o(36264);
        return yVar2;
    }

    public static y cG(ca caVar) {
        y yVar;
        AppMethodBeat.i(36265);
        if (caVar.gDd()) {
            y a2 = new y().a(caVar.OqD);
            AppMethodBeat.o(36265);
            return a2;
        }
        k.b aD = k.b.aD(caVar.field_content, caVar.field_reserved);
        if (aD == null) {
            Log.w("MicroMsg.Imagegallery.handler.video", "getVideoInfo content is null");
            AppMethodBeat.o(36265);
            return null;
        }
        com.tencent.mm.ag.e eVar = (com.tencent.mm.ag.e) aD.as(com.tencent.mm.ag.e.class);
        if (eVar == null || eVar.iwi == null) {
            yVar = null;
        } else {
            yVar = eVar.iwi;
        }
        AppMethodBeat.o(36265);
        return yVar;
    }

    public static ca f(String str, Activity activity) {
        AppMethodBeat.i(36266);
        ca caVar = new ca();
        caVar.setType(486539313);
        caVar.Cy(str);
        caVar.OqE = true;
        caVar.OqD = br(activity);
        caVar.Cz(activity.getIntent().getStringExtra("img_gallery_path"));
        AppMethodBeat.o(36266);
        return caVar;
    }

    public final void pause(int i2) {
        AppMethodBeat.i(36267);
        d(amM(i2));
        this.pNk.fp(false);
        this.Pwu.Pwv.setVideoStateIv(true);
        AppMethodBeat.o(36267);
    }

    private void releaseWakeLock() {
        AppMethodBeat.i(36268);
        if (this.hCN != null && this.hCN.isHeld()) {
            Log.i("MicroMsg.Imagegallery.handler.video", "release waklock");
            this.hCN.release();
        }
        AppMethodBeat.o(36268);
    }

    private static s cH(ca caVar) {
        long j2;
        AppMethodBeat.i(36269);
        s cF = cF(caVar);
        if (cF != null) {
            AppMethodBeat.o(36269);
        } else {
            Log.i("MicroMsg.Imagegallery.handler.video", "insert video info:" + caVar.toString());
            cF = new s();
            cF.dWq = caVar.field_talker;
            cF.fileName = caVar.field_imgPath;
            if (caVar.field_createTime <= 0) {
                j2 = System.currentTimeMillis();
            } else {
                j2 = caVar.field_createTime;
            }
            cF.createTime = j2;
            cF.dTS = caVar.field_msgSvrId;
            cF.jst = caVar.field_content;
            cF.jso = (int) caVar.field_msgId;
            y cG = cG(caVar);
            if (cG != null) {
                if (TextUtils.isEmpty(caVar.field_imgPath)) {
                    caVar.Cz(t.Qv(caVar.field_talker));
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                }
                cF.fileName = caVar.field_imgPath;
                m mVar = m.PBF;
                cF.a(Util.nullAs(m.aiK(cG.HJ(caVar.field_imgPath)), cG.videoUrl), cG.videoDuration, cG.title, cG.KOe, "", "", "");
                cF.status = 111;
            }
            o.bhj().b(cF);
            AppMethodBeat.o(36269);
        }
        return cF;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(final com.tencent.mm.storage.ca r13, final int r14) {
        /*
        // Method dump skipped, instructions count: 1068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.j.j(com.tencent.mm.storage.ca, int):void");
    }

    private void a(k kVar, String str) {
        AppMethodBeat.i(36271);
        if (kVar != null) {
            kVar.gTe();
            kVar.gTe().PAR.setVisibility(0);
            kVar.gTe().PAS.setText(Util.nullAs(str, this.Pwu.Pwv.getString(R.string.hxg)));
            kVar.gTe().PAM.setVisibility(0);
            kVar.gTe().PAN.setVisibility(8);
            c(kVar);
            AppMethodBeat.o(36271);
            return;
        }
        AppMethodBeat.o(36271);
    }

    private static void b(k kVar) {
        AppMethodBeat.i(36272);
        if (kVar != null) {
            kVar.gTe();
            kVar.gTe().PAR.setVisibility(8);
            AppMethodBeat.o(36272);
            return;
        }
        AppMethodBeat.o(36272);
    }

    public final void k(ca caVar, int i2) {
        AppMethodBeat.i(36273);
        Log.i("MicroMsg.Imagegallery.handler.video", "toggleVideoMenu pos ");
        s QN = u.QN(caVar.field_imgPath);
        if (QN != null && !QN.bhy()) {
            d(amM(i2));
            this.Pwu.Pwv.setVideoStateIv(true);
            if (this.EtM) {
                this.PAh.gTi();
                this.PAh.reset();
            }
            a(caVar, QN);
            if (this.Pwu.Pwv.NQ(caVar.field_msgId) == 2) {
                he(caVar.field_imgPath, 8);
                AppMethodBeat.o(36273);
                return;
            }
            he(caVar.field_imgPath, 5);
        }
        AppMethodBeat.o(36273);
    }

    private void a(ca caVar, s sVar, int i2, boolean z) {
        String str;
        String str2;
        AppMethodBeat.i(36274);
        if (caVar == null || sVar == null) {
            AppMethodBeat.o(36274);
        } else if (caVar.cWK() || !caVar.gDB()) {
            if (sVar.jsu == -1) {
                str = sVar.bhu();
                if (!com.tencent.mm.vfs.s.YS(str)) {
                    o.bhj();
                    str2 = t.Qw(caVar.field_imgPath);
                }
                str2 = str;
            } else {
                o.bhj();
                str = t.Qw(caVar.field_imgPath);
                if (caVar.field_isSend == 1 && sVar.jsx != null && sVar.jsx.Mrn) {
                    try {
                        String boZ = com.tencent.mm.vfs.s.boZ(str);
                        if (!boZ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                            boZ = boZ + FilePathGenerator.ANDROID_DIR_SEP;
                        }
                        String str3 = boZ + com.tencent.mm.vfs.s.bpb(str) + "_hd.mp4";
                        boolean YS = com.tencent.mm.vfs.s.YS(str3);
                        Log.i("MicroMsg.Imagegallery.handler.video", "local capture video, hdFilePath: %s, exist: %s", str3, Boolean.valueOf(YS));
                        if (!YS) {
                            str3 = str;
                        }
                        str2 = str3;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Imagegallery.handler.video", "try to get hd filePath error: %s", e2.getMessage());
                    }
                }
                str2 = str;
            }
            if (str2 == null || !com.tencent.mm.vfs.s.YS(str2)) {
                Toast.makeText(this.Pwu.Pwv, (int) R.string.hwo, 0).show();
                AppMethodBeat.o(36274);
                return;
            }
            k amM = amM(i2);
            if (amM == null) {
                AppMethodBeat.o(36274);
                return;
            }
            int i3 = 0;
            if (ab.Eq(sVar.getUser())) {
                i3 = v.Ie(sVar.getUser());
            }
            boolean Ql = r.Ql(str2);
            int NQ = this.Pwu.Pwv.NQ(caVar.field_msgId);
            Log.i("MicroMsg.Imagegallery.handler.video", "play video pos[%d], isOnlinePlay[%b] opcode[%d] resetByCompletion[%b]", Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(NQ), Boolean.valueOf(this.PAn));
            if (Ql) {
                h.INSTANCE.a(12084, Integer.valueOf(sVar.iKP), Integer.valueOf(sVar.iFw * 1000), 0, 3, sVar.getUser(), Integer.valueOf(i3), s.Qn(sVar.bhv()), Long.valueOf(sVar.createTime));
                if (!com.tencent.mm.pluginsdk.k.b.a.a.c(str2, this.Pwu.Pwv.getContext(), Ql)) {
                    Toast.makeText(this.Pwu.Pwv.getContext(), this.Pwu.Pwv.getString(R.string.hxf), 0).show();
                }
            } else if (ae.gKE.gGR != 1 || !com.tencent.mm.pluginsdk.k.b.a.a.b(sVar.getFileName(), this.Pwu.Pwv.getContext(), Ql)) {
                bg.aVF();
                if (((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, (Object) 0)).intValue() == 1 && amM.PAQ != null) {
                    amM.PAQ.setVisibility(0);
                    amM.PAQ.setText(com.tencent.mm.plugin.sight.base.e.aFm(str2));
                }
                amM.a(sVar.iFw, sVar.iKP, i3, sVar.getUser(), s.Qn(sVar.bhv()), sVar.createTime);
                this.EtM = z;
                this.PAi = true;
                this.filename = sVar.getFileName();
                if (NQ == 3) {
                    amM.gTe().PAO.setMute(true);
                } else {
                    amM.gTe().PAO.setMute(false);
                }
                if (amM.gTe().PAO.getVideoPath() == null || !amM.gTe().PAO.getVideoPath().equals(str2) || amM.gTe().PAO.isPlaying() || this.PAn) {
                    this.PAk = false;
                    this.PAn = false;
                    amM.gTe().PAO.setVideoPath(str2);
                    if (amM.gTe().PAO instanceof VideoPlayerTextureView) {
                        ((VideoPlayerTextureView) amM.gTe().PAO).setIOnlineCache(this.zrF);
                        ((VideoPlayerTextureView) amM.gTe().PAO).setNeedResetExtractor(cXc());
                        ((VideoPlayerTextureView) amM.gTe().PAO).setIsOnlineVideoType(z);
                    }
                    amM.d(true, 0.0f);
                } else {
                    amM.d(true, 1.0f);
                    amM.gTe().PAO.start();
                    fgo();
                    if (!z) {
                        bna(this.filename);
                    }
                    anl(amM.gTe().PAO.getCurrentPosition() / 1000);
                    fO(false);
                }
                b(i2, sVar);
                this.Pwu.Pwv.setVideoStateIv(false);
                this.Pwu.Pwv.getContext().getWindow().addFlags(128);
                this.pNk.a(this);
            } else {
                AppMethodBeat.o(36274);
                return;
            }
            amM.gTe().PAP.setVisibility(8);
            AppMethodBeat.o(36274);
        } else {
            Toast.makeText(this.Pwu.Pwv, (int) R.string.hwo, 0).show();
            AppMethodBeat.o(36274);
        }
    }

    private void a(ca caVar, s sVar) {
        AppMethodBeat.i(36275);
        if (!ag.dm(this.Pwu.Pwv.getContext()) && !PAp) {
            PAp = true;
        }
        b(caVar, sVar);
        AppMethodBeat.o(36275);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(ca caVar, s sVar) {
        AppMethodBeat.i(36276);
        Log.i("MicroMsg.Imagegallery.handler.video", "startDownloading [%d]", Integer.valueOf(hashCode()));
        if (caVar == null || sVar == null) {
            AppMethodBeat.o(36276);
            return;
        }
        k gSh = this.Pwu.gSh();
        if (gSh == null) {
            AppMethodBeat.o(36276);
            return;
        }
        com.tencent.mm.modelsimple.ab.ab(caVar);
        int NQ = this.Pwu.Pwv.NQ(caVar.field_msgId);
        Log.d("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode : ".concat(String.valueOf(NQ)));
        switch (NQ) {
            case 0:
                break;
            case 1:
            case 2:
            case 4:
                if (sVar.bhx()) {
                    Log.i("MicroMsg.Imagegallery.handler.video", "start complete online video");
                    u.QT(caVar.field_imgPath);
                } else {
                    Log.i("MicroMsg.Imagegallery.handler.video", "start complete offline video");
                    he(caVar.field_imgPath, 10);
                    u.QI(caVar.field_imgPath);
                }
                o.bhj().a(this, Looper.getMainLooper());
                gSh.gTe().PAN.setVisibility(8);
                gSh.gTe().PAP.setVisibility(0);
                gSh.gTe().PAP.setProgress(u.g(sVar));
                if (NQ == 2) {
                    gTa();
                    AppMethodBeat.o(36276);
                    return;
                }
                gSZ();
                AppMethodBeat.o(36276);
                return;
            case 3:
                Log.i("MicroMsg.Imagegallery.handler.video", "%d mute play video [%d]", Integer.valueOf(hashCode()), Integer.valueOf(NQ));
                break;
            default:
                Log.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(NQ));
                AppMethodBeat.o(36276);
                return;
        }
        if (this.PAh.bnc(caVar.field_imgPath) || this.PAh.c(caVar, sVar)) {
            Log.i("MicroMsg.Imagegallery.handler.video", "start online play video.");
            this.EtM = true;
            o.bhj().a(this);
            gSh.gTe().PAN.setVisibility(8);
            gSh.gTe().PAP.setVisibility(8);
            gSh.gTe().PAY.setVisibility(0);
            AppMethodBeat.o(36276);
            return;
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "start offline play video.");
        this.EtM = false;
        o.bhj().a(this, Looper.getMainLooper());
        u.QI(caVar.field_imgPath);
        gSh.gTe().PAN.setVisibility(8);
        gSh.gTe().PAP.setVisibility(0);
        gSh.gTe().PAP.setProgress(u.g(sVar));
        AppMethodBeat.o(36276);
    }

    private void he(final String str, final int i2) {
        AppMethodBeat.i(36277);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(36253);
                u.aA(str, i2);
                AppMethodBeat.o(36253);
            }
        });
        AppMethodBeat.o(36277);
    }

    private boolean b(a aVar) {
        AppMethodBeat.i(36278);
        if (aVar == null) {
            AppMethodBeat.o(36278);
            return false;
        }
        o.bhj().a(this);
        if (this.Pwu.Pwv.getCurrentItem() == aVar.pos) {
            k amM = amM(aVar.pos);
            if (amM != null) {
                amM.gTe().PAY.setVisibility(8);
                amM.gTe().PAP.setVisibility(8);
                amM.gTe().PAN.setVisibility(8);
            }
            this.PAt = true;
            this.Pwu.Pwv.gSF();
            AppMethodBeat.o(36278);
            return true;
        }
        this.Pwu.amU(aVar.pos);
        AppMethodBeat.o(36278);
        return false;
    }

    public final void stopAll() {
        AppMethodBeat.i(36279);
        Log.i("MicroMsg.Imagegallery.handler.video", "stopAll. video handler hash code : " + hashCode());
        this.EtR = Util.nowMilliSecond();
        SparseArray<Object> sparseArray = this.Pwu.OUA;
        int i2 = 0;
        boolean z = false;
        while (i2 < sparseArray.size()) {
            int keyAt = sparseArray.keyAt(i2);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                k kVar = (k) ((View) sparseArray.get(keyAt)).getTag();
                if (kVar.PAL != null && kVar.gTe().PAL.getVisibility() == 0 && (((View) kVar.gTe().PAO).getVisibility() == 0 || !Util.isNullOrNil(kVar.gTe().PAO.getVideoPath()) || (this.EtM && this.PAh.isStreaming()))) {
                    c(kVar);
                    z = true;
                }
            }
            i2++;
            z = z;
        }
        this.pNk.fp(false);
        if (!z && this.EtM) {
            this.PAh.gTi();
            this.EtM = false;
        }
        fgc();
        this.PAg.clear();
        releaseWakeLock();
        AppMethodBeat.o(36279);
    }

    private void c(k kVar) {
        AppMethodBeat.i(36280);
        Log.i("MicroMsg.Imagegallery.handler.video", "stop");
        fgc();
        if (kVar == null) {
            AppMethodBeat.o(36280);
            return;
        }
        fgp();
        if (this.EtM) {
            this.PAh.gTi();
        }
        if (!this.PAj) {
            u.f(this.filename, this.tnc - 1000, this.EtM);
        }
        kVar.gTe().PAP.setVisibility(8);
        kVar.gTe().PAY.setVisibility(8);
        kVar.gTe().PAO.stop();
        anl(0);
        kVar.d(false, 0.0f);
        this.EtM = false;
        this.PAt = false;
        this.PAn = false;
        this.filename = null;
        this.Eub = 0;
        this.Eua = 0;
        this.PAu = 0;
        this.PAr = 0;
        this.PAm = 0;
        this.PAl = 0;
        this.mEN = 0;
        this.lastCheckTime = 0;
        AppMethodBeat.o(36280);
    }

    private void d(k kVar) {
        AppMethodBeat.i(36281);
        if (kVar == null) {
            AppMethodBeat.o(36281);
            return;
        }
        releaseWakeLock();
        fgc();
        Log.d("MicroMsg.Imagegallery.handler.video", "pause video.");
        if (kVar.gTe().PAO.isPlaying()) {
            kVar.gTe().PAO.pause();
            fgp();
        }
        AppMethodBeat.o(36281);
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        k gSh;
        AppMethodBeat.i(36282);
        Log.i("MicroMsg.Imagegallery.handler.video", "ui on resume, add online video event.");
        this.PAq.removeMessages(1);
        EventCenter.instance.addListener(this.PAs);
        if (!(this.Pwu == null || !com.tencent.mm.compatible.util.d.oD(21) || (gSh = this.Pwu.gSh()) == null || gSh.PAO == null)) {
            if (gSh.PAO instanceof VideoPlayerTextureView) {
                ((VideoPlayerTextureView) gSh.PAO).bLe();
                AppMethodBeat.o(36282);
                return;
            } else if (gSh.PAO instanceof VideoTextureView) {
                ((VideoTextureView) gSh.PAO).bLe();
            }
        }
        AppMethodBeat.o(36282);
    }

    private static void e(k kVar) {
        AppMethodBeat.i(36283);
        if (kVar != null) {
            kVar.gTe();
            if (kVar.gTe().PAO.isPlaying()) {
                k.ai(kVar.gTe().PAN, 0);
            }
            AppMethodBeat.o(36283);
            return;
        }
        AppMethodBeat.o(36283);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.a
    public final void detach() {
        AppMethodBeat.i(36284);
        Log.i("MicroMsg.Imagegallery.handler.video", "detach.[%d]", Integer.valueOf(hashCode()));
        this.EtR = Util.nowMilliSecond();
        this.PAq.removeMessages(1);
        fgc();
        EventCenter.instance.removeListener(this.PAf);
        EventCenter.instance.removeListener(this.PAs);
        stopAll();
        this.Pwu.Pwv.getContext().getWindow().clearFlags(128);
        this.Pwu.Pwv.gSr().FLz.setIplaySeekCallback(null);
        super.detach();
        this.Pyt.clear();
        this.Pyt = null;
        o.bhj().a(this);
        this.PAg.clear();
        o oVar = this.PAh;
        oVar.reset();
        oVar.Eup = null;
        oVar.PBI = null;
        oVar.PBJ = null;
        if (f.ejc()) {
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(36252);
                    String ejd = f.ejd();
                    if (!Util.isNullOrNil(ejd)) {
                        h.INSTANCE.kvStat(14092, ejd);
                        AppMethodBeat.o(36252);
                        return;
                    }
                    h.INSTANCE.kvStat(14092, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    AppMethodBeat.o(36252);
                }
            });
        }
        o.bho().bhG();
        o.bho().run();
        AppMethodBeat.o(36284);
    }

    public final void gSW() {
        AppMethodBeat.i(36285);
        this.PAj = false;
        this.tnb = 0;
        k gSh = this.Pwu != null ? this.Pwu.gSh() : null;
        if (gSh == null) {
            Log.w("MicroMsg.Imagegallery.handler.video", "notify video prepared, but holder is null.");
            AppMethodBeat.o(36285);
            return;
        }
        final int videoMsToSec = Util.videoMsToSec((long) gSh.gTe().PAO.getDuration());
        int videoTotalTime = this.Pwu.Pwv.gSr().FLz.getVideoTotalTime();
        Log.i("MicroMsg.Imagegallery.handler.video", "%d videoDuration %d hadSetTotalTime %d", Integer.valueOf(hashCode()), Integer.valueOf(videoMsToSec), Integer.valueOf(videoTotalTime));
        if (videoTotalTime <= 0 || Math.abs(videoTotalTime - videoMsToSec) >= 2) {
            this.Pwu.Pwv.gSr().FLz.setVideoTotalTime(videoMsToSec);
        }
        gSY();
        if (videoMsToSec == 0 || videoMsToSec >= 1800) {
            Log.w("MicroMsg.Imagegallery.handler.video", "%d repair video duration[%d] error. filename[%s]", Integer.valueOf(hashCode()), Integer.valueOf(videoMsToSec), this.filename);
        } else {
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass6 */

                public final void run() {
                    int i2;
                    AppMethodBeat.i(36249);
                    String str = j.this.filename;
                    int i3 = videoMsToSec;
                    s QN = u.QN(str);
                    if (QN != null && ((i2 = QN.iFw) <= 0 || Math.abs(i2 - i3) > 2)) {
                        QN.iFw = i3;
                        QN.cSx = 4096;
                        Log.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", Boolean.valueOf(u.f(QN)), Integer.valueOf(i2), Integer.valueOf(i3));
                    }
                    AppMethodBeat.o(36249);
                }
            });
        }
        int Q = u.Q(videoMsToSec, this.filename);
        Log.i("MicroMsg.Imagegallery.handler.video", "notify video prepared. isOnlinePlay[%b] playDuration[%d] playVideoWhenNotify[%b] hadPlayError[%b].", Boolean.valueOf(this.EtM), Integer.valueOf(Q), Boolean.valueOf(this.PAi), Boolean.valueOf(this.PAj));
        gSh.gTe().PAO.setOneTimeVideoTextureUpdateCallback(this.EtE);
        if (this.PAi) {
            if (!this.EtM) {
                this.PAh.reset();
                fgo();
                aT(Q, true);
            } else {
                o oVar = this.PAh;
                if (Q > 0) {
                    Log.i("MicroMsg.OnlineVideoUIHelper", "seek to last duration : ".concat(String.valueOf(Q)));
                    oVar.jpZ = Q;
                    oVar.jqb = true;
                    oVar.jpW = 2;
                }
                this.PAh.ub(0);
            }
            fO(false);
            AppMethodBeat.o(36285);
            return;
        }
        if (!this.EtM) {
            aT(Q, false);
        } else {
            this.PAh.bL(Q, false);
        }
        anl(Q);
        this.Pwu.Pwv.setVideoStateIv(true);
        fgc();
        AppMethodBeat.o(36285);
    }

    public final void gSX() {
        boolean z;
        com.tencent.mm.pluginsdk.ui.tools.j jVar;
        AppMethodBeat.i(36286);
        Log.i("MicroMsg.Imagegallery.handler.video", "notify video completion. isOnlinePlay : " + this.EtM);
        fgc();
        releaseWakeLock();
        fgp();
        if (!this.EtM || this.Pwu == null || this.Pwu.gSh() == null || (jVar = this.Pwu.gSh().gTe().PAO) == null || jVar.getCurrentPosition() + 2000 >= jVar.getDuration()) {
            z = true;
        } else {
            Log.e("MicroMsg.Imagegallery.handler.video", "notify video completion, but cur pos[%d] is less than duration[%d]", Integer.valueOf(jVar.getCurrentPosition()), Integer.valueOf(jVar.getDuration()));
            z = false;
        }
        if (z) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass12 */

                public final void run() {
                    a aVar;
                    AppMethodBeat.i(36255);
                    j.this.PAk = true;
                    j.this.lastCheckTime = j.this.mEN = 0;
                    j.this.pNk.fp(false);
                    j.k(j.this);
                    if (j.this.EtM) {
                        j.this.EtR = Util.nowMilliSecond();
                        j.this.PAh.gTi();
                        j.this.PAh.reset();
                        j.this.EtM = false;
                        j.this.PAt = false;
                    }
                    u.f(j.this.filename, 0, j.this.EtM);
                    if (!(j.this.Pyt == null || (aVar = (a) j.this.Pyt.get(j.this.filename)) == null)) {
                        k gSh = j.this.Pwu.gSh();
                        gSh.gTe().PAO.stop();
                        j.this.tnc = 0;
                        j.this.a(gSh, aVar.dCM, aVar.pos);
                        j.this.anl(0);
                        if (gSh.gTe().PAY.getVisibility() != 8) {
                            gSh.gTe().PAY.setVisibility(8);
                        }
                    }
                    AppMethodBeat.o(36255);
                }
            });
            AppMethodBeat.o(36286);
            return;
        }
        try {
            u.f(this.filename, this.Pwu.gSh().PAO.getCurrentPosition(), this.EtM);
            this.Pwu.gSh().PAO.stop();
            this.PAh.gTj();
            int i2 = this.PAr + 1;
            this.PAr = i2;
            if (i2 <= 3) {
                a aVar = this.Pyt.get(this.filename);
                if (aVar == null || aVar.dCM == null) {
                    AppMethodBeat.o(36286);
                    return;
                }
                a(aVar.dCM, cF(aVar.dCM), aVar.pos, this.EtM);
            }
            AppMethodBeat.o(36286);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e2, "notify video completion error[%s]", e2.toString());
            AppMethodBeat.o(36286);
        }
    }

    public final void lh(int i2, int i3) {
        boolean z;
        final String str;
        AppMethodBeat.i(36287);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(this.EtM);
        o oVar = this.PAh;
        if (Util.isNullOrNil(oVar.mediaId) || oVar.jpV != 1) {
            z = false;
        } else {
            z = true;
        }
        objArr[3] = Boolean.valueOf(z);
        Log.e("MicroMsg.Imagegallery.handler.video", "notify video error, what %d, extras %d isOnlinePlay %b isLoading %b ", objArr);
        this.PAj = true;
        this.tnb = i3;
        if (this.EtM) {
            if (i2 == -1) {
                fgc();
                this.Pwu.gSh().PAO.stop();
                this.PAh.gTj();
            } else if (i2 == -2) {
                fgc();
                u.f(this.filename, this.Pwu.gSh().PAO.getCurrentPosition(), this.EtM);
                this.Pwu.gSh().PAO.stop();
                this.PAh.gTj();
            } else if (i2 == -3) {
                this.PAj = false;
                this.PAh.gTj();
                AppMethodBeat.o(36287);
                return;
            }
            this.PAt = false;
            this.Pwu.Pwv.setVideoStateIv(true);
            this.Pwu.gSh().gTe().PAY.setVisibility(0);
            fgp();
            h.INSTANCE.idkeyStat(354, 18, 1, false);
            AppMethodBeat.o(36287);
            return;
        }
        u.QP(this.filename);
        fgp();
        if (this.Pwu == null || this.Pwu.gSh() == null || this.Pwu.gSh().PAO == null) {
            str = "";
        } else {
            str = this.Pwu.gSh().PAO.getVideoPath();
            this.Pwu.gSh().PAO.stop();
        }
        if (this.PAk) {
            Log.i("MicroMsg.Imagegallery.handler.video", "%d had play completion don't show error tips", Integer.valueOf(hashCode()));
            AppMethodBeat.o(36287);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(36256);
                if (j.this.Pwu == null || j.this.Pwu.gSh() == null || j.this.Pyt == null) {
                    Log.w("MicroMsg.Imagegallery.handler.video", "show error alert but adapter is null.");
                    AppMethodBeat.o(36256);
                    return;
                }
                j.this.Pwu.gSh().d(false, 0.0f);
                if (!Util.isNullOrNil(str)) {
                    Log.e("MicroMsg.Imagegallery.handler.video", "mediaplay play video error, use third player.[%s]", str);
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        FileProviderHelper.setIntentDataAndType((Context) j.this.Pwu.Pwv, intent, new com.tencent.mm.vfs.o(str), "video/*", false);
                        ImageGalleryUI imageGalleryUI = j.this.Pwu.Pwv;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, bl.axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        imageGalleryUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(imageGalleryUI, "com/tencent/mm/ui/chatting/gallery/ImageGalleryVideoHandler$5", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Imagegallery.handler.video", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.h.n(j.this.Pwu.Pwv, R.string.caa, R.string.cab);
                    }
                }
                a aVar = (a) j.this.Pyt.get(j.this.filename);
                if (aVar == null || aVar.dCM == null) {
                    AppMethodBeat.o(36256);
                    return;
                }
                j.this.ank(aVar.pos);
                AppMethodBeat.o(36256);
            }
        });
        h.INSTANCE.idkeyStat(354, 25, 1, false);
        AppMethodBeat.o(36287);
    }

    private void fgc() {
        AppMethodBeat.i(36288);
        Log.i("MicroMsg.Imagegallery.handler.video", "clear timer");
        this.Ehq.stopTimer();
        this.qbP.stopTimer();
        AppMethodBeat.o(36288);
    }

    /* access modifiers changed from: protected */
    public final void fO(boolean z) {
        AppMethodBeat.i(36289);
        if (!this.PAj) {
            if (!this.EtM) {
                this.qbP.startTimer(500);
            } else if (z) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass14 */

                    public final void run() {
                        int currentPosition;
                        AppMethodBeat.i(36257);
                        try {
                            if (Util.isNullOrNil(j.this.Pwu.gSh().gTe().PAO.getVideoPath())) {
                                currentPosition = u.Q(j.this.PAh.jpY, j.this.filename);
                            } else {
                                currentPosition = j.this.Pwu.gSh().gTe().PAO.getCurrentPosition() / 1000;
                            }
                            j.this.PAh.ub(currentPosition);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.Imagegallery.handler.video", e2, "start timer error[%s]", e2.toString());
                        }
                        j.this.Ehq.startTimer(500);
                        AppMethodBeat.o(36257);
                    }
                });
                AppMethodBeat.o(36289);
                return;
            } else {
                this.Ehq.startTimer(500);
                AppMethodBeat.o(36289);
                return;
            }
        }
        AppMethodBeat.o(36289);
    }

    public final p gSe() {
        AppMethodBeat.i(233453);
        ca gSg = this.Pwu.gSg();
        if (gSg == null) {
            Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, msgInfo is null");
            AppMethodBeat.o(233453);
            return null;
        } else if (gSg.cWK() || !gSg.gDB()) {
            s cF = cF(gSg);
            if (cF == null || cF.status == 198) {
                Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, videoInfo is null or failed");
                p pVar = p.EXPIRED;
                AppMethodBeat.o(233453);
                return pVar;
            } else if (cF.bhy()) {
                Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, downloaded");
                p pVar2 = p.DOWNLOADED;
                AppMethodBeat.o(233453);
                return pVar2;
            } else {
                Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, not downloaded");
                p pVar3 = p.NOT_DOWNLOADED;
                AppMethodBeat.o(233453);
                return pVar3;
            }
        } else {
            Log.i("MicroMsg.Imagegallery.handler.video", "getCurResourceState, msgInfo is cleaned");
            p pVar4 = p.EXPIRED;
            AppMethodBeat.o(233453);
            return pVar4;
        }
    }

    public static class a {
        public ca dCM;
        public int pos;

        public a(ca caVar, int i2) {
            this.dCM = caVar;
            this.pos = i2;
        }
    }

    private void b(int i2, s sVar) {
        AppMethodBeat.i(36290);
        this.PAg.put(i2, sVar);
        AppMethodBeat.o(36290);
    }

    public final void ank(int i2) {
        AppMethodBeat.i(36291);
        this.PAg.remove(i2);
        AppMethodBeat.o(36291);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.modelvideo.t.a
    public final void a(t.a.C0460a aVar) {
        AppMethodBeat.i(36292);
        String str = aVar.fileName;
        if (Util.isNullOrNil(str) || this.Pyt == null) {
            AppMethodBeat.o(36292);
            return;
        }
        a aVar2 = this.Pyt.get(str);
        if (aVar2 == null) {
            AppMethodBeat.o(36292);
            return;
        }
        ca caVar = aVar2.dCM;
        if (caVar == null || caVar.field_imgPath == null || !caVar.field_imgPath.equals(str)) {
            AppMethodBeat.o(36292);
            return;
        }
        s cF = cF(caVar);
        if (cF == null) {
            AppMethodBeat.o(36292);
        } else if ((caVar.cWK() || !caVar.gDB()) && cF.status != 198) {
            int g2 = u.g(cF);
            k amM = amM(aVar2.pos);
            if (this.Pwu.Pwv.getCurrentItem() == aVar2.pos && amM != null) {
                amM.gTe().PAP.setVisibility(0);
                amM.gTe().PAP.setProgress(g2);
            } else if (amM == null) {
                AppMethodBeat.o(36292);
                return;
            }
            if (g2 < amM.gTe().PAP.getMax()) {
                AppMethodBeat.o(36292);
                return;
            }
            Log.d("MicroMsg.Imagegallery.handler.video", "onNotifyChange, status:%d", Integer.valueOf(cF.status));
            if ((cF.status == 199 || cF.status == 199) && b(aVar2)) {
                int NQ = this.Pwu.Pwv.NQ(caVar.field_msgId);
                switch (NQ) {
                    case 0:
                    case 3:
                        a(caVar, cF, this.Pwu.Pwv.getCurrentItem(), false);
                        AppMethodBeat.o(36292);
                        return;
                    case 1:
                        Log.d("MicroMsg.Imagegallery.handler.video", "do restransmit video");
                        h.INSTANCE.idkeyStat(354, 15, 1, false);
                        this.Pwu.ct(caVar);
                        this.Pwu.Pwv.NR(-1);
                        if (this.EtM) {
                            u.f(this.filename, this.Pwu.gSh().PAO.getCurrentPosition(), this.EtM);
                            this.PAn = true;
                        }
                        this.EtM = false;
                        AppMethodBeat.o(36292);
                        return;
                    case 2:
                        h.INSTANCE.idkeyStat(354, 16, 1, false);
                        b.a(this.Pwu.Pwv, caVar);
                        this.Pwu.Pwv.NR(-1);
                        if (this.EtM) {
                            u.f(this.filename, this.Pwu.gSh().PAO.getCurrentPosition(), this.EtM);
                            this.PAn = true;
                        }
                        this.EtM = false;
                        AppMethodBeat.o(36292);
                        return;
                    case 4:
                        this.Pwu.Pwv.NR(-1);
                        ImageGalleryUI imageGalleryUI = this.Pwu.Pwv;
                        Log.i("MicroMsg.ImageGalleryUI", "launchAppBrandIfNeed");
                        if (imageGalleryUI.PzD != null) {
                            ImageGalleryUI.c cVar = imageGalleryUI.PzD;
                            Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTaskIfNeed");
                            if (!(cVar.PAd == null || cVar.PAe == null || !cVar.PAe.equals(ImageGalleryUI.this.Pwu.gSg()))) {
                                Log.i("MicroMsg.ImageGalleryUI", "executePendingLaunchAppBrandTask");
                                com.tencent.mm.plugin.appbrand.openmaterial.j.nlj.ae(cVar.PAd);
                            }
                            cVar.PAd = null;
                            cVar.PAe = null;
                        }
                        AppMethodBeat.o(36292);
                        return;
                    default:
                        Log.w("MicroMsg.Imagegallery.handler.video", "enterVideoOpCode[%d] is error", Integer.valueOf(NQ));
                        break;
                }
            }
            AppMethodBeat.o(36292);
        } else {
            if (b(aVar2)) {
                Toast.makeText(this.Pwu.Pwv, (int) R.string.hwo, 0).show();
            }
            AppMethodBeat.o(36292);
        }
    }

    private void gSY() {
        AppMethodBeat.i(36293);
        try {
            this.Pwu.Pwv.gSr().FLz.setIplaySeekCallback(this.tni);
            AppMethodBeat.o(36293);
        } catch (Exception e2) {
            AppMethodBeat.o(36293);
        }
    }

    /* access modifiers changed from: protected */
    public final void cq(final String str, final boolean z) {
        AppMethodBeat.i(36294);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(36248);
                Log.i("MicroMsg.Imagegallery.handler.video", "prepare video filename %s isOnlinePlay %b ", str, Boolean.valueOf(z));
                if (j.this.Pyt == null) {
                    Log.w("MicroMsg.Imagegallery.handler.video", "prepare video but cache map is null.");
                    AppMethodBeat.o(36248);
                    return;
                }
                a aVar = (a) j.this.Pyt.get(str);
                if (aVar == null || aVar.dCM == null) {
                    AppMethodBeat.o(36248);
                    return;
                }
                s cF = j.cF(aVar.dCM);
                if (j.this.Pwu.Pwv.getCurrentItem() == aVar.pos) {
                    j.a(j.this, aVar.dCM, cF, aVar.pos, z);
                    j.this.bna(str);
                    AppMethodBeat.o(36248);
                    return;
                }
                Log.w("MicroMsg.Imagegallery.handler.video", "playVideo, but currentItem is not correct.[%d, %d]", Integer.valueOf(j.this.Pwu.Pwv.getCurrentItem()), Integer.valueOf(aVar.pos));
                AppMethodBeat.o(36248);
            }
        });
        AppMethodBeat.o(36294);
    }

    /* access modifiers changed from: protected */
    public final void aT(int i2, boolean z) {
        AppMethodBeat.i(36295);
        k gSh = this.Pwu.gSh();
        if (gSh == null) {
            AppMethodBeat.o(36295);
            return;
        }
        fgo();
        gSh.gTe().PAY.setVisibility(8);
        gSh.gTe().PAO.d((double) (i2 * 1000), z);
        this.Pwu.Pwv.setVideoStateIv(false);
        fO(false);
        AppMethodBeat.o(36295);
    }

    /* access modifiers changed from: protected */
    public final void bgW() {
        AppMethodBeat.i(36296);
        k gSh = this.Pwu.gSh();
        if (gSh == null) {
            AppMethodBeat.o(36296);
            return;
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "start to pause");
        this.Pwu.Pwv.setVideoStateIv(true);
        gSh.gTe().PAY.setVisibility(0);
        gSh.gTe().PAO.pause();
        fgp();
        AppMethodBeat.o(36296);
    }

    /* access modifiers changed from: protected */
    public final boolean fgn() {
        AppMethodBeat.i(36297);
        k gSh = this.Pwu.gSh();
        if (gSh == null) {
            AppMethodBeat.o(36297);
            return false;
        }
        boolean z = true;
        if (!gSh.gTe().PAO.isPlaying()) {
            Log.i("MicroMsg.Imagegallery.handler.video", "start to play");
            this.Pwu.Pwv.setVideoStateIv(false);
            gSh.gTe().PAY.setVisibility(8);
            z = gSh.gTe().PAO.start();
            fgo();
        }
        if (gSh.gTe().PAY.getVisibility() != 8) {
            gSh.gTe().PAY.setVisibility(8);
        }
        AppMethodBeat.o(36297);
        return z;
    }

    /* access modifiers changed from: protected */
    public final void anl(int i2) {
        AppMethodBeat.i(36298);
        this.Pwu.Pwv.gSr().FLz.seek(Math.max(0, i2));
        if (this.PAh != null && ((long) this.PAh.jqc) > 0) {
            this.Pwu.Pwv.gSr().FLz.aiS((int) ((long) this.PAh.jqc));
        }
        AppMethodBeat.o(36298);
    }

    /* access modifiers changed from: protected */
    public final void bna(String str) {
        AppMethodBeat.i(36299);
        if (!this.PAt && !b(this.Pyt.get(str))) {
            Log.w("MicroMsg.Imagegallery.handler.video", "show tool bar error.");
        }
        AppMethodBeat.o(36299);
    }

    private void fgo() {
        AppMethodBeat.i(36300);
        this.Eua = Util.nowMilliSecond();
        Log.d("MicroMsg.Imagegallery.handler.video", "notePlayVideo filename %s notePlayVideo %d ", this.filename, Long.valueOf(this.Eua));
        if (!(this.Pwu == null || this.Pwu.Pwv == null)) {
            this.Pwu.Pwv.PyB.cB(this.Pwu.gSg());
        }
        AppMethodBeat.o(36300);
    }

    private void fgp() {
        AppMethodBeat.i(36301);
        if (this.Eua > 0) {
            this.Eub = (int) (((long) this.Eub) + ((Util.nowMilliSecond() - this.Eua) / 1000));
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "notePauseVideo filename %s playVideoDuration %d ", this.filename, Integer.valueOf(this.Eub));
        this.Eua = 0;
        if (!(this.Pwu == null || this.Pwu.Pwv == null)) {
            this.Pwu.Pwv.PyB.cA(this.Pwu.gSg());
        }
        AppMethodBeat.o(36301);
    }

    /* access modifiers changed from: protected */
    public final int getPlayVideoDuration() {
        AppMethodBeat.i(36302);
        if (this.Eub < 0) {
            this.Eub = 0;
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", this.filename, Integer.valueOf(this.Eub));
        int i2 = this.Eub;
        AppMethodBeat.o(36302);
        return i2;
    }

    /* access modifiers changed from: protected */
    public final int getUiStayTime() {
        int i2;
        AppMethodBeat.i(36303);
        if (this.EtR <= 0 || this.EtQ <= 0) {
            i2 = 0;
        } else {
            i2 = (int) (this.EtR - this.EtQ);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        Log.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", Integer.valueOf(hashCode()), this.filename, Integer.valueOf(i2), Long.valueOf(this.EtR), Long.valueOf(this.EtQ));
        AppMethodBeat.o(36303);
        return i2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean f(k kVar) {
        int i2;
        AppMethodBeat.i(36304);
        int i3 = this.tnc;
        this.tnc = kVar.gTe().PAO.getCurrentPosition();
        if (i3 != this.tnc) {
            this.lastCheckTime = Util.nowMilliSecond();
            long lastSurfaceUpdateTime = kVar.gTe().PAO.getLastSurfaceUpdateTime();
            if (lastSurfaceUpdateTime <= 0 || lastSurfaceUpdateTime == this.mEN) {
                if (this.PAl != -1) {
                    this.PAl++;
                    Log.w("MicroMsg.Imagegallery.handler.video", "media play is playing[%d], but surface is not update!! repair time[%d]", Integer.valueOf(this.PAl), Integer.valueOf(this.PAm));
                    if (this.PAm >= 2) {
                        this.PAh.gTj();
                    }
                    switch (this.PAl) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                            int i4 = this.tnc / 1000;
                            Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(i4));
                            aT(i4, true);
                            this.PAm++;
                            AppMethodBeat.o(36304);
                            return false;
                        case 3:
                            int i5 = (this.tnc - 2000) / 1000;
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(i5));
                            aT(i5, true);
                            this.PAm++;
                            AppMethodBeat.o(36304);
                            return false;
                        case 4:
                            int i6 = (this.tnc - 4000) / 1000;
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            Log.w("MicroMsg.Imagegallery.handler.video", "surface not update, it try seek time[%d] to repair.", Integer.valueOf(i6));
                            aT(i6, true);
                            this.PAm++;
                            AppMethodBeat.o(36304);
                            return false;
                        default:
                            Log.w("MicroMsg.Imagegallery.handler.video", "rpt surface not update!!");
                            Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptSurfaceNotUpdate %s", Integer.valueOf(hashCode()), this.filename);
                            h.INSTANCE.a(13836, 300, Long.valueOf(Util.nowSecond()), "");
                            h.INSTANCE.idkeyStat(354, 20, 1, false);
                            this.PAl = -1;
                            break;
                    }
                }
            } else {
                this.mEN = lastSurfaceUpdateTime;
                int i7 = this.PAl;
                switch (i7) {
                    case 2:
                        i2 = 21;
                        Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i7), this.filename);
                        h.INSTANCE.idkeyStat(354, (long) i2, 1, false);
                        h.INSTANCE.a(13836, 301, Long.valueOf(Util.nowSecond()), "");
                        this.PAl = 0;
                        break;
                    case 3:
                        i2 = 22;
                        Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i7), this.filename);
                        h.INSTANCE.idkeyStat(354, (long) i2, 1, false);
                        h.INSTANCE.a(13836, 301, Long.valueOf(Util.nowSecond()), "");
                        this.PAl = 0;
                        break;
                    case 4:
                        i2 = 23;
                        Log.w("MicroMsg.Imagegallery.handler.video", "%d rpt rptRepairEffect idKey %d errorTime %d filename %s", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i7), this.filename);
                        h.INSTANCE.idkeyStat(354, (long) i2, 1, false);
                        h.INSTANCE.a(13836, 301, Long.valueOf(Util.nowSecond()), "");
                        this.PAl = 0;
                        break;
                    default:
                        this.PAl = 0;
                        break;
                }
            }
        } else {
            Log.i("MicroMsg.Imagegallery.handler.video", "check time[%d, %d], play time[%d, %d]", Long.valueOf(this.lastCheckTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(i3), Integer.valueOf(this.tnc));
            if (this.lastCheckTime > 0 && Util.milliSecondsToNow(this.lastCheckTime) >= 1500) {
                Log.w("MicroMsg.Imagegallery.handler.video", "play time not update! request all video data to play. ");
                int currentPosition = this.Pwu.gSh().PAO.getCurrentPosition();
                fgc();
                u.f(this.filename, currentPosition, this.EtM);
                this.Pwu.gSh().PAO.stop();
                this.PAh.gTj();
                a aVar = this.Pyt.get(this.filename);
                if (aVar == null || aVar.dCM == null) {
                    AppMethodBeat.o(36304);
                    return false;
                }
                a(aVar.dCM, cF(aVar.dCM), aVar.pos, this.EtM);
                this.lastCheckTime = 0;
                AppMethodBeat.o(36304);
                return false;
            }
        }
        AppMethodBeat.o(36304);
        return true;
    }

    private static void gSZ() {
        AppMethodBeat.i(36305);
        h.INSTANCE.idkeyStat(354, 11, 1, false);
        AppMethodBeat.o(36305);
    }

    private static void gTa() {
        AppMethodBeat.i(36306);
        h.INSTANCE.idkeyStat(354, 14, 1, false);
        AppMethodBeat.o(36306);
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }

    private boolean cXc() {
        AppMethodBeat.i(36307);
        if (!this.EtM) {
            AppMethodBeat.o(36307);
            return false;
        }
        bg.aVF();
        boolean z = com.tencent.mm.model.c.azQ().getBoolean(ar.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
        AppMethodBeat.o(36307);
        return z;
    }

    static /* synthetic */ boolean a(j jVar) {
        AppMethodBeat.i(36308);
        if (jVar.Pwu == null || jVar.Pwu.Pwv == null) {
            AppMethodBeat.o(36308);
            return true;
        }
        boolean isFinishing = jVar.Pwu.Pwv.isFinishing();
        AppMethodBeat.o(36308);
        return isFinishing;
    }

    static /* synthetic */ void a(j jVar, String str, final int i2) {
        AppMethodBeat.i(36315);
        Log.i("MicroMsg.Imagegallery.handler.video", "download online video error. mediaId: ".concat(String.valueOf(str)));
        jVar.fgp();
        o oVar = jVar.PAh;
        Log.i("MicroMsg.OnlineVideoUIHelper", "deal stream error.");
        if (oVar.aQW(str)) {
            oVar.jpV = 2;
            o.bhk().m(oVar.mediaId, oVar.fgC());
        }
        h.INSTANCE.idkeyStat(354, 9, 1, false);
        if (i2 == -10012) {
            Log.w("MicroMsg.Imagegallery.handler.video", "download online video time out, quit imageGalleryUI.");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass17 */

                public final void run() {
                    AppMethodBeat.i(36260);
                    j.this.Pwu.Pwv.onBackPressed();
                    AppMethodBeat.o(36260);
                }
            });
            AppMethodBeat.o(36315);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass2 */

            public final void run() {
                DialogInterface.OnClickListener onClickListener;
                AppMethodBeat.i(36243);
                Log.w("MicroMsg.Imagegallery.handler.video", "show play video error.");
                u.QP(j.this.filename);
                if (j.this.Pwu == null) {
                    AppMethodBeat.o(36243);
                    return;
                }
                k gSh = j.this.Pwu.gSh();
                gSh.gTe().PAO.stop();
                gSh.d(false, 0.0f);
                String string = j.this.Pwu.Pwv.getString(R.string.hwr);
                if (i2 == -5103059 || i2 == -5103087) {
                    string = j.this.Pwu.Pwv.getString(R.string.hwq);
                    onClickListener = new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(36241);
                            if (dialogInterface != null) {
                                dialogInterface.cancel();
                            }
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(36240);
                                    if (!(j.this.Pwu == null || j.this.Pwu.Pwv == null)) {
                                        j.this.Pwu.Pwv.onBackPressed();
                                    }
                                    AppMethodBeat.o(36240);
                                }
                            });
                            AppMethodBeat.o(36241);
                        }
                    };
                } else {
                    onClickListener = new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.gallery.j.AnonymousClass2.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(36242);
                            if (dialogInterface != null) {
                                dialogInterface.cancel();
                            }
                            AppMethodBeat.o(36242);
                        }
                    };
                }
                com.tencent.mm.ui.base.h.d(j.this.Pwu.Pwv, string, j.this.Pwu.Pwv.getString(R.string.b1n), onClickListener);
                j.this.PAg.clear();
                AppMethodBeat.o(36243);
            }
        });
        AppMethodBeat.o(36315);
    }
}
