package com.tencent.mm.an;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.a;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.b.a.gp;
import com.tencent.mm.g.b.a.iq;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.b.a.lg;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.xwalk.core.XWalkFeature;

public final class e implements i, a.AbstractC0257a {
    MMHandler hAk = new MMHandler(Looper.getMainLooper());
    Map<String, h> iRA = new HashMap();
    Queue<String> iRy = new LinkedList();
    Map<String, h> iRz = new HashMap();
    Map<String, h> iSl = new HashMap();
    Map<String, d> iSm = new HashMap();
    private final MMHandler mainHandler = new MMHandler(Looper.getMainLooper());

    public interface a {
        void a(h hVar, d dVar);
    }

    public e() {
        AppMethodBeat.i(126721);
        g.azz().a(379, this);
        AppMethodBeat.o(126721);
    }

    public final void release() {
        AppMethodBeat.i(126722);
        g.azz().b(379, this);
        AppMethodBeat.o(126722);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(126723);
        if (qVar.getType() != 379) {
            AppMethodBeat.o(126723);
            return;
        }
        Log.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", Integer.valueOf(i2), Integer.valueOf(i3));
        if (g.aAf().azp()) {
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.an.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(126711);
                    e.this.fD(true);
                    AppMethodBeat.o(126711);
                }
            });
        }
        AppMethodBeat.o(126723);
    }

    public final boolean a(final h hVar, boolean z) {
        AppMethodBeat.i(126724);
        if (hVar == null) {
            Log.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            AppMethodBeat.o(126724);
            return false;
        } else if (Util.isNullOrNil(hVar.field_mediaId)) {
            Log.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            AppMethodBeat.o(126724);
            return false;
        } else {
            Log.i("MicroMsg.OnlineVideoService", "add download task : " + hVar.field_mediaId + " delay : " + z);
            if (hVar.field_fileId == null) {
                hVar.field_fileId = "";
            }
            if (hVar.field_aesKey == null) {
                hVar.field_aesKey = "";
            }
            hVar.ehd = false;
            if (m(hVar.field_mediaId, null) || z) {
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.an.e.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(126713);
                        e.this.iRy.add(hVar.field_mediaId);
                        e.this.iRz.put(hVar.field_mediaId, hVar);
                        e.this.fD(false);
                        AppMethodBeat.o(126713);
                    }
                });
            } else {
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.an.e.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(126714);
                        e.this.iRy.add(hVar.field_mediaId);
                        e.this.iRz.put(hVar.field_mediaId, hVar);
                        e.this.fD(false);
                        AppMethodBeat.o(126714);
                    }
                });
            }
            AppMethodBeat.o(126724);
            return true;
        }
    }

    public final boolean e(final h hVar) {
        AppMethodBeat.i(126725);
        if (hVar == null) {
            Log.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            AppMethodBeat.o(126725);
            return false;
        } else if (Util.isNullOrNil(hVar.field_mediaId)) {
            Log.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            AppMethodBeat.o(126725);
            return false;
        } else {
            Log.i("MicroMsg.OnlineVideoService", "add download task : " + hVar.field_mediaId);
            if (hVar.field_fileId == null) {
                hVar.field_fileId = "";
            }
            if (hVar.field_aesKey == null) {
                hVar.field_aesKey = "";
            }
            hVar.ehd = false;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.an.e.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(126715);
                        e.this.hAk.removeCallbacksAndMessages(hVar.field_mediaId);
                        e.this.iRy.add(hVar.field_mediaId);
                        e.this.iRz.put(hVar.field_mediaId, hVar);
                        e.this.fD(false);
                        AppMethodBeat.o(126715);
                    }
                });
            } else {
                this.hAk.removeCallbacksAndMessages(hVar.field_mediaId);
                this.iRy.add(hVar.field_mediaId);
                this.iRz.put(hVar.field_mediaId, hVar);
                fD(false);
            }
            AppMethodBeat.o(126725);
            return true;
        }
    }

    public final boolean l(final String str, final Object[] objArr) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(126726);
        if (!Util.isNullOrNil(str)) {
            if (this.iRA.containsKey(str)) {
                z2 = true;
            } else {
                f.baQ().Oc(str);
                z2 = false;
            }
            if (!z2 || Looper.myLooper() == Looper.getMainLooper()) {
                this.hAk.removeCallbacksAndMessages(str);
                h remove = this.iRA.remove(str);
                if (remove != null) {
                    d dVar = new d();
                    f.baR();
                    int c2 = a.c(remove.field_mediaId, dVar);
                    if (c2 == 0) {
                        a(objArr, dVar, remove, false);
                    } else {
                        Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(c2), remove.field_mediaId);
                    }
                } else {
                    h remove2 = this.iSl.remove(str);
                    d remove3 = this.iSm.remove(str);
                    if (!(remove2 == null || remove3 == null)) {
                        a(objArr, remove3, remove2, true);
                    }
                }
                this.iRz.remove(str);
                z = z2;
            } else {
                this.hAk.postAtTime(new Runnable() {
                    /* class com.tencent.mm.an.e.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(126716);
                        h remove = e.this.iRA.remove(str);
                        if (remove != null) {
                            d dVar = new d();
                            f.baR();
                            int c2 = a.c(remove.field_mediaId, dVar);
                            if (c2 == 0) {
                                e.a(objArr, dVar, remove, false);
                            } else {
                                Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(c2), remove.field_mediaId);
                            }
                        } else {
                            h remove2 = e.this.iSl.remove(str);
                            d remove3 = e.this.iSm.remove(str);
                            if (!(remove2 == null || remove3 == null)) {
                                e.a(objArr, remove3, remove2, true);
                            }
                        }
                        e.this.iRz.remove(str);
                        AppMethodBeat.o(126716);
                    }
                }, str, SystemClock.uptimeMillis());
                z = z2;
            }
        } else {
            z = false;
        }
        Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskInMainThread mediaId : " + str + " remove : " + z);
        AppMethodBeat.o(126726);
        return z;
    }

    public final boolean m(final String str, final Object[] objArr) {
        AppMethodBeat.i(126727);
        boolean z = false;
        if (!Util.isNullOrNil(str)) {
            if (this.iRA.containsKey(str)) {
                z = true;
            } else {
                f.baQ().Oc(str);
            }
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.an.e.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(126717);
                    h remove = e.this.iRA.remove(str);
                    if (remove != null) {
                        d dVar = new d();
                        f.baR();
                        int c2 = a.c(remove.field_mediaId, dVar);
                        if (c2 == 0) {
                            e.a(objArr, dVar, remove, false);
                        } else {
                            Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(c2), remove.field_mediaId);
                        }
                    } else {
                        h remove2 = e.this.iSl.remove(str);
                        d remove3 = e.this.iSm.remove(str);
                        if (!(remove2 == null || remove3 == null)) {
                            e.a(objArr, remove3, remove2, true);
                        }
                    }
                    e.this.iRz.remove(str);
                    AppMethodBeat.o(126717);
                }
            });
        }
        Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + str + " remove : " + z);
        AppMethodBeat.o(126727);
        return z;
    }

    public final boolean a(final String str, final a aVar) {
        AppMethodBeat.i(169096);
        boolean z = false;
        if (!Util.isNullOrNil(str)) {
            if (this.iRA.containsKey(str)) {
                z = true;
            } else {
                f.baQ().Oc(str);
            }
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.an.e.AnonymousClass9 */
                final /* synthetic */ Object[] iSr = null;

                public final void run() {
                    d remove;
                    AppMethodBeat.i(126718);
                    h remove2 = e.this.iRA.remove(str);
                    if (remove2 != null) {
                        remove = new d();
                        f.baR();
                        int c2 = a.c(remove2.field_mediaId, remove);
                        if (c2 == 0) {
                            e.a(this.iSr, remove, remove2, false);
                        } else {
                            Log.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(c2), remove2.field_mediaId);
                        }
                    } else {
                        remove2 = e.this.iSl.remove(str);
                        remove = e.this.iSm.remove(str);
                        if (!(remove2 == null || remove == null)) {
                            e.a(this.iSr, remove, remove2, true);
                        }
                    }
                    e.this.iRz.remove(str);
                    if (aVar != null) {
                        aVar.a(remove2, remove);
                    }
                    AppMethodBeat.o(126718);
                }
            });
        }
        Log.i("MicroMsg.OnlineVideoService", "cancelDownloadTaskWithCallback mediaId : " + str + " remove : " + z);
        AppMethodBeat.o(169096);
        return z;
    }

    public final boolean isVideoDataAvailable(String str, int i2, int i3) {
        AppMethodBeat.i(126728);
        if (this.iRA.get(str) == null) {
            Log.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", str);
            AppMethodBeat.o(126728);
            return false;
        }
        f.baR();
        boolean isVideoDataAvailable = a.isVideoDataAvailable(str, (long) i2, (long) i3);
        Log.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(isVideoDataAvailable));
        AppMethodBeat.o(126728);
        return isVideoDataAvailable;
    }

    public static int r(String str, int i2, int i3) {
        AppMethodBeat.i(126729);
        f.baR();
        int requestVideoData = a.requestVideoData(str, (long) i2, (long) i3, 0);
        Log.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", str, Integer.valueOf(i2), Integer.valueOf(i3), 0, Integer.valueOf(requestVideoData));
        AppMethodBeat.o(126729);
        return requestVideoData;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x012a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fD(boolean r11) {
        /*
        // Method dump skipped, instructions count: 845
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.an.e.fD(boolean):void");
    }

    @Override // com.tencent.mm.an.a.AbstractC0257a
    public final int d(final String str, final int i2, final int i3, final String str2) {
        AppMethodBeat.i(240833);
        this.mainHandler.post(new Runnable() {
            /* class com.tencent.mm.an.e.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(126719);
                Log.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", str);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(126719);
                    return;
                }
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.an.e.AnonymousClass10.AnonymousClass1 */

                    public final void run() {
                        boolean z = true;
                        AppMethodBeat.i(169095);
                        h hVar = e.this.iRA.get(str);
                        Log.w("MicroMsg.OnlineVideoService", "info=" + hVar + " mediaId=" + str + " info.videoCallback=" + (hVar != null && hVar.gre == null));
                        if (hVar != null) {
                            hVar.gra = (long) i2;
                            if (hVar.gre != null) {
                                hVar.gre.a(str, (long) i2, (long) i3, str2);
                                AppMethodBeat.o(169095);
                                return;
                            } else if (r.Ql(hVar.field_fullpath)) {
                                Log.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + hVar.gqU);
                                if (hVar.gqU == 1) {
                                    e.r(hVar.field_mediaId, 0, hVar.field_totalLen);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 19, 1, false);
                                }
                                AppMethodBeat.o(169095);
                                return;
                            } else {
                                oq oqVar = new oq();
                                oqVar.dUF.dKy = 1;
                                oqVar.dUF.retCode = 0;
                                oqVar.dUF.mediaId = str;
                                oqVar.dUF.offset = i2;
                                oqVar.dUF.length = i3;
                                oqVar.dUF.dUG = hVar.gqR;
                                oq.a aVar = oqVar.dUF;
                                if (hVar.gqz <= 0) {
                                    z = false;
                                }
                                aVar.dUH = z;
                                EventCenter.instance.publish(oqVar);
                                s QN = u.QN(hVar.filename);
                                if (QN != null) {
                                    Log.i("MicroMsg.OnlineVideoService", "on moov ready info: " + QN.getFileName() + " status : " + QN.status);
                                    if (QN.status == 130) {
                                        AppMethodBeat.o(169095);
                                        return;
                                    } else if (QN.status != 122) {
                                        s QN2 = u.QN(hVar.filename);
                                        if (QN2 != null) {
                                            QN2.status = 121;
                                            QN2.cSx = 256;
                                            o.bhj().c(QN2);
                                        }
                                        if (hVar.gqU == 0) {
                                            Log.i("MicroMsg.OnlineVideoService", "stop download video");
                                            o.bho().bhG();
                                            o.bho().run();
                                        }
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(169095);
                    }
                });
                AppMethodBeat.o(126719);
            }
        });
        if (this.iRA.containsKey(str)) {
            AppMethodBeat.o(240833);
            return 1;
        }
        AppMethodBeat.o(240833);
        return 0;
    }

    @Override // com.tencent.mm.an.a.AbstractC0257a
    public final int p(final String str, final int i2, final int i3) {
        AppMethodBeat.i(240834);
        Log.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(240834);
            return 0;
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.an.e.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(126720);
                h hVar = e.this.iRA.get(str);
                if (hVar != null) {
                    if (hVar.gre != null) {
                        hVar.gre.onDataAvailable(str, (long) i2, (long) i3);
                    }
                    oq oqVar = new oq();
                    oqVar.dUF.dKy = 2;
                    oqVar.dUF.retCode = 0;
                    oqVar.dUF.mediaId = str;
                    oqVar.dUF.offset = i2;
                    oqVar.dUF.length = i3;
                    EventCenter.instance.publish(oqVar);
                }
                AppMethodBeat.o(126720);
            }
        });
        if (this.iRA.containsKey(str)) {
            AppMethodBeat.o(240834);
            return 1;
        }
        AppMethodBeat.o(240834);
        return 0;
    }

    @Override // com.tencent.mm.an.a.AbstractC0257a
    public final int q(final String str, final int i2, final int i3) {
        AppMethodBeat.i(240835);
        Log.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(240835);
            return 0;
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.an.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(126712);
                h hVar = e.this.iRA.get(str);
                if (hVar != null) {
                    oq oqVar = new oq();
                    oqVar.dUF.dKy = 3;
                    oqVar.dUF.retCode = 0;
                    oqVar.dUF.mediaId = str;
                    oqVar.dUF.offset = i2;
                    oqVar.dUF.length = i3;
                    EventCenter.instance.publish(oqVar);
                    if (i2 == 0 && i3 >= hVar.gqT) {
                        e.a(u.QN(hVar.filename), hVar.gqT, hVar.gqS);
                    }
                }
                AppMethodBeat.o(126712);
            }
        });
        if (this.iRA.containsKey(str)) {
            AppMethodBeat.o(240835);
            return 1;
        }
        AppMethodBeat.o(240835);
        return 0;
    }

    @Override // com.tencent.mm.an.a.AbstractC0257a
    public final int a(final String str, final c cVar, final d dVar) {
        AppMethodBeat.i(126734);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
            AppMethodBeat.o(126734);
            return -1;
        } else if (cVar == null && dVar == null) {
            Log.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
            AppMethodBeat.o(126734);
            return -2;
        } else {
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.an.e.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(169094);
                    h hVar = e.this.iRA.get(str);
                    if (hVar == null) {
                        AppMethodBeat.o(169094);
                    } else if (hVar.gre != null) {
                        Log.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback", str);
                        if (cVar != null) {
                            hVar.gre.i(str, cVar.field_finishedLength, cVar.field_toltalLength);
                            AppMethodBeat.o(169094);
                        } else if (dVar != null) {
                            Log.i("MicroMsg.OnlineVideoService", "cdn callback %s route to videoCallback, sceneResult.retCode:%s", str, Integer.valueOf(dVar.field_retCode));
                            hVar.gre.a(str, dVar.field_retCode, dVar);
                            e.this.iRA.remove(str);
                            if (dVar.field_retCode == 0) {
                                e.this.iSl.put(hVar.field_mediaId, hVar);
                                e.this.iSm.put(hVar.field_mediaId, dVar);
                            }
                            AppMethodBeat.o(169094);
                        } else {
                            AppMethodBeat.o(169094);
                        }
                    } else {
                        s QN = u.QN(hVar.filename);
                        if (QN == null) {
                            Log.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", hVar.filename);
                            AppMethodBeat.o(169094);
                        } else if (hVar.gqy != null) {
                            hVar.gqy.a(str, 0, cVar, dVar, hVar.field_onlycheckexist);
                            if (dVar != null) {
                                e.this.iRA.remove(str);
                            }
                            AppMethodBeat.o(169094);
                        } else if (cVar == null) {
                            if (dVar != null) {
                                Log.i("MicroMsg.OnlineVideoService", "callback result info " + dVar.field_retCode + ", filesize:" + dVar.field_fileLength + ",recved:" + dVar.field_recvedBytes);
                                if (dVar.field_retCode != 0) {
                                    if (dVar.field_retCode != -10012) {
                                        u.QE(QN.getFileName());
                                    }
                                    boolean alQ = hVar.alQ();
                                    int i2 = dVar.field_retCode;
                                    int i3 = hVar.gqU;
                                    if (alQ) {
                                        if (i3 == 1) {
                                            if (i2 == -5103059) {
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 111, 1, false);
                                            } else if (i2 == -5103087) {
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 112, 1, false);
                                            } else if (i2 == -10012) {
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 113, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 114, 1, false);
                                            }
                                        } else if (i2 == -5103059) {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 116, 1, false);
                                        } else if (i2 == -5103087) {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 117, 1, false);
                                        } else if (i2 == -10012) {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 118, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 119, 1, false);
                                        }
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13836, 101, Long.valueOf(Util.nowSecond()), Integer.valueOf(i2));
                                    } else {
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 213, 1, false);
                                        if (i3 == 1) {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 214, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 215, 1, false);
                                        }
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13836, 201, Long.valueOf(Util.nowSecond()), Integer.valueOf(i2));
                                    }
                                } else {
                                    e.a(QN, (int) dVar.field_fileLength, hVar.gqS);
                                    e.this.iSl.put(hVar.field_mediaId, hVar);
                                    e.this.iSm.put(hVar.field_mediaId, dVar);
                                }
                                oq oqVar = new oq();
                                oqVar.dUF.dKy = 4;
                                oqVar.dUF.mediaId = str;
                                oqVar.dUF.offset = 0;
                                oqVar.dUF.retCode = dVar.field_retCode;
                                oqVar.dUF.length = (int) dVar.field_fileLength;
                                EventCenter.instance.publish(oqVar);
                                e.this.iRA.remove(str);
                            }
                            AppMethodBeat.o(169094);
                        } else if (cVar.field_finishedLength == ((long) QN.iKP)) {
                            Log.i("MicroMsg.OnlineVideoService", "stream download finish.");
                            AppMethodBeat.o(169094);
                        } else if (QN.status == 130 || ((long) QN.jsj) <= cVar.field_finishedLength) {
                            Log.i("MicroMsg.OnlineVideoService", "callback progress info " + cVar.field_finishedLength);
                            QN.jsm = Util.nowSecond();
                            QN.jsj = (int) cVar.field_finishedLength;
                            QN.cSx = XWalkFeature.INTERFACE_SHOW_HIDE;
                            u.f(QN);
                            oq oqVar2 = new oq();
                            oqVar2.dUF.dKy = 5;
                            oqVar2.dUF.mediaId = str;
                            oqVar2.dUF.offset = (int) cVar.field_finishedLength;
                            oqVar2.dUF.length = (int) cVar.field_toltalLength;
                            EventCenter.instance.publish(oqVar2);
                            AppMethodBeat.o(169094);
                        } else {
                            Log.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", Integer.valueOf(QN.jsj), Long.valueOf(cVar.field_finishedLength));
                            AppMethodBeat.o(169094);
                        }
                    }
                }
            });
            if (this.iRA.get(str) != null) {
                AppMethodBeat.o(126734);
                return 1;
            }
            AppMethodBeat.o(126734);
            return 0;
        }
    }

    static void a(s sVar, int i2, String str) {
        AppMethodBeat.i(126735);
        Log.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", Integer.valueOf(i2));
        if (sVar != null) {
            u.ay(sVar.getFileName(), i2);
            i(i2, str, sVar.getFileName());
        }
        AppMethodBeat.o(126735);
    }

    private static boolean i(int i2, String str, String str2) {
        AppMethodBeat.i(126736);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126736);
            return false;
        }
        o.bhj();
        String Qw = t.Qw(str2);
        if (Util.isNullOrNil(str) || i2 <= 0 || Util.isNullOrNil(Qw)) {
            Log.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i2), str, Qw);
            AppMethodBeat.o(126736);
            return false;
        }
        boolean P = ((com.tencent.mm.plugin.m.a.a) g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().P(str, i2, Qw);
        AppMethodBeat.o(126736);
        return P;
    }

    public static h Oe(String str) {
        int i2;
        AppMethodBeat.i(126737);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126737);
            return null;
        }
        s QN = u.QN(str);
        if (QN == null) {
            AppMethodBeat.o(126737);
            return null;
        }
        Map<String, String> parseXml = XmlParser.parseXml(QN.bhv(), "msg", null);
        if (parseXml == null) {
            Log.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
            AppMethodBeat.o(126737);
            return null;
        }
        String str2 = parseXml.get(".msg.videomsg.$cdnvideourl");
        if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.OnlineVideoService", "cdntra parse video recv xml failed");
            AppMethodBeat.o(126737);
            return null;
        }
        int i3 = Util.getInt(parseXml.get(".msg.videomsg.$length"), 0);
        String str3 = parseXml.get(".msg.videomsg.$md5");
        String str4 = parseXml.get(".msg.videomsg.$aeskey");
        String str5 = parseXml.get(".msg.videomsg.$fileparam");
        String a2 = c.a("downvideo", QN.createTime, QN.getUser(), QN.getFileName());
        if (Util.isNullOrNil(a2)) {
            Log.w("MicroMsg.OnlineVideoService", "cdntra genClientId failed not use cdn file:%s", QN.getFileName());
            AppMethodBeat.o(126737);
            return null;
        }
        o.bhj();
        String Qw = t.Qw(str);
        h hVar = new h();
        hVar.taskName = "task_OnlineVideoService_1";
        hVar.filename = str;
        hVar.gqS = str3;
        hVar.gqT = i3;
        hVar.gqU = 1;
        hVar.dRL = QN.bhs();
        hVar.gqV = QN.getUser();
        hVar.dRN = ab.Eq(QN.getUser()) ? v.Ie(QN.getUser()) : 0;
        hVar.field_mediaId = a2;
        hVar.field_fullpath = Qw;
        hVar.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
        hVar.field_totalLen = i3;
        hVar.field_aesKey = str4;
        hVar.field_fileId = str2;
        hVar.field_priority = com.tencent.mm.i.a.gpM;
        hVar.field_wxmsgparam = str5;
        if (ab.Eq(QN.getUser())) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        hVar.field_chattype = i2;
        hVar.gqW = QN.gqW;
        ca aJ = ((l) g.af(l.class)).eiy().aJ(QN.getUser(), QN.dTS);
        bp.b Ky = bp.Ky(aJ.fqK);
        hVar.gqz = 0;
        hVar.gqA = 0;
        hVar.gqY = aJ.field_createTime;
        hVar.dTS = aJ.field_msgSvrId;
        hVar.gqZ = Ky != null ? Ky.iEG : 0;
        if (hVar.gqz > 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 36, 1, false);
        }
        hVar.field_autostart = false;
        hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.a(1, QN);
        AppMethodBeat.o(126737);
        return hVar;
    }

    public static h a(com.tencent.mm.storage.bp bpVar, String str, String str2, String str3, int i2, boolean z) {
        String str4;
        AppMethodBeat.i(240836);
        if (bpVar == null) {
            Log.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
            AppMethodBeat.o(240836);
            return null;
        } else if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
            AppMethodBeat.o(240836);
            return null;
        } else {
            s QN = u.QN(str3);
            if (QN == null) {
                Log.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", str3);
                AppMethodBeat.o(240836);
                return null;
            }
            String a2 = c.a("snsvideo", (long) bpVar.hXs, "sns", str);
            if (Util.isNullOrNil(a2)) {
                Log.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", str);
                AppMethodBeat.o(240836);
                return null;
            }
            h hVar = new h();
            hVar.taskName = "task_OnlineVideoService_2";
            hVar.filename = str3;
            hVar.field_fullpath = str2;
            hVar.field_mediaId = a2;
            hVar.gqP = 2;
            hVar.gqU = i2;
            hVar.gqW = QN.gqW;
            if (bpVar == null) {
                str4 = "";
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oqm)) {
                str4 = "album_friend";
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oqn)) {
                str4 = "album_self";
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oqo)) {
                str4 = "album_stranger";
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oqp)) {
                str4 = "profile_friend";
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oqq)) {
                str4 = "profile_stranger";
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oqr)) {
                str4 = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oql)) {
                str4 = "timeline";
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oqu)) {
                str4 = "snssight";
            } else if (bpVar.equals(com.tencent.mm.storage.bp.Oqw)) {
                str4 = "storysight";
            } else {
                str4 = "";
            }
            String str5 = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(com.tencent.mm.protocal.d.KyO);
            g.aAi();
            g.aAf();
            objArr[1] = p.getString(com.tencent.mm.kernel.a.getUin());
            objArr[2] = Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext()));
            objArr[3] = Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext()));
            objArr[4] = !Util.isNullOrNil(str4) ? "&scene=".concat(String.valueOf(str4)) : "";
            hVar.referer = String.format(str5, objArr);
            hVar.url = str;
            String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("SnsSightDomainList");
            long j2 = (long) ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("SnsSightMainStandbyIpSwitchTime", 0);
            Log.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", value, Long.valueOf(j2), Integer.valueOf(bpVar.hXs));
            if (j2 <= 0) {
                j2 = 259200;
            }
            boolean a3 = a(bpVar, hVar.url, j2, value);
            try {
                hVar.host = new URL(hVar.url).getHost();
                ArrayList arrayList = new ArrayList();
                com.tencent.mm.network.d.b(a3, arrayList, hVar.host);
                hVar.gqr = new String[arrayList.size()];
                arrayList.toArray(hVar.gqr);
                hVar.isColdSnsData = Util.secondsToNow((long) bpVar.hXs) > j2;
                hVar.signalQuality = new StringBuilder().append(NetStatusUtil.getStrength(MMApplicationContext.getContext())).toString();
                hVar.snsScene = str4;
                hVar.concurrentCount = 5;
                if (((b) g.af(b.class)).a(b.a.mmsns_video_hevc_download_and, false)) {
                    if (z) {
                        hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.j(i2, str2, str);
                    } else {
                        hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.K(i2, str2);
                    }
                }
                AppMethodBeat.o(240836);
                return hVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.OnlineVideoService", e2, "check can sns online video error taskInfo %s", hVar);
                AppMethodBeat.o(240836);
                return null;
            }
        }
    }

    private static boolean a(com.tencent.mm.storage.bp bpVar, String str, long j2, String str2) {
        AppMethodBeat.i(126739);
        if (str == null) {
            AppMethodBeat.o(126739);
            return false;
        }
        try {
            URL url = new URL(str);
            if (bpVar == null) {
                AppMethodBeat.o(126739);
                return false;
            } else if (str2 == null) {
                AppMethodBeat.o(126739);
                return false;
            } else if (str2.indexOf(url.getHost()) == -1) {
                AppMethodBeat.o(126739);
                return false;
            } else if (bpVar.hXs == 0) {
                AppMethodBeat.o(126739);
                return false;
            } else if (Util.secondsToNow((long) bpVar.hXs) > j2) {
                AppMethodBeat.o(126739);
                return true;
            } else {
                AppMethodBeat.o(126739);
                return false;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.OnlineVideoService", "error for check dcip %s", e2.getMessage());
            AppMethodBeat.o(126739);
            return false;
        }
    }

    public static void s(int[] iArr) {
        AppMethodBeat.i(126740);
        if (iArr == null) {
            AppMethodBeat.o(126740);
            return;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17891, Integer.valueOf(iArr[6]), Integer.valueOf(iArr[8]), Integer.valueOf(iArr[9]), Integer.valueOf(iArr[7]), Integer.valueOf(iArr[10]), Integer.valueOf(iArr[11]), Integer.valueOf(iArr[12]), Integer.valueOf(iArr[13]), Integer.valueOf(iArr[14]), Integer.valueOf(iArr[15]), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5]), Integer.valueOf(iArr[16]), Integer.valueOf(iArr[17]), Integer.valueOf(iArr[18]), Integer.valueOf(iArr[19]), Integer.valueOf(iArr[20]), Integer.valueOf(iArr[21]), Integer.valueOf(iArr[22]), Integer.valueOf(iArr[23]), Integer.valueOf(iArr[24]), Integer.valueOf(iArr[25]), Integer.valueOf(iArr[26]), Integer.valueOf(iArr[27]), Integer.valueOf(iArr[28]), Integer.valueOf(iArr[29]), Integer.valueOf(iArr[30]), Integer.valueOf(iArr[31]), Integer.valueOf(iArr[32]), Integer.valueOf(iArr[33]));
        AppMethodBeat.o(126740);
    }

    public static void a(Object[] objArr, d dVar, h hVar, boolean z) {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j2;
        long j3;
        long j4;
        AppMethodBeat.i(126742);
        if (hVar == null || dVar == null) {
            Log.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
            AppMethodBeat.o(126742);
        } else if (hVar.alO() || hVar.alQ() || hVar.alS()) {
            String str2 = dVar.field_clientIP;
            int i9 = dVar.field_isCrossNet ? 1 : 0;
            Log.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", Integer.valueOf(dVar.field_videoFormat), str2, Integer.valueOf(i9));
            if (dVar.field_videoFormat == 2) {
                u.QQ(hVar.filename);
            }
            if (Util.isNullOrNil(str2)) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 45, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 46, 1, false);
            }
            if (dVar.field_isCrossNet) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 47, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 48, 1, false);
            }
            boolean alQ = hVar.alQ();
            boolean alS = hVar.alS();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            pInt2.value = 0;
            pInt.value = 0;
            u.a(hVar.field_fullpath, pInt, pInt2);
            int i10 = pInt.value * 1000;
            int i11 = pInt2.value;
            int i12 = 0;
            int i13 = 0;
            if (objArr == null || objArr.length <= 6) {
                str = "";
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
            } else {
                i6 = ((Integer) objArr[0]).intValue() * 1000;
                int intValue = ((Integer) objArr[1]).intValue();
                i8 = ((Integer) objArr[2]).intValue();
                i2 = ((Integer) objArr[3]).intValue();
                int intValue2 = ((Integer) objArr[4]).intValue();
                i4 = ((Integer) objArr[5]).intValue();
                i5 = ((Integer) objArr[6]).intValue();
                if (alS || alQ || objArr.length <= 10) {
                    str = "";
                    i3 = intValue2;
                    i7 = intValue;
                } else {
                    int intValue3 = ((Integer) objArr[7]).intValue();
                    str = (String) objArr[8];
                    i13 = ((Long) objArr[9]).intValue();
                    i12 = intValue3;
                    i3 = intValue2;
                    i7 = intValue;
                }
            }
            int i14 = hVar.gqW;
            if (i14 <= 0) {
                if (alQ) {
                    i14 = 10;
                } else {
                    i14 = 31;
                }
            }
            int iOSNetType = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
            String alM = dVar.alM();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            a(pInt3, pInt4, hVar.filename, hVar.gqZ);
            StringBuffer stringBuffer = new StringBuffer();
            if (alQ) {
                stringBuffer.append(hVar.field_fileId).append(",").append(hVar.field_aesKey).append(",");
            } else {
                stringBuffer.append(hVar.url).append(",").append(hVar.gqX).append(",");
            }
            stringBuffer.append(dVar.field_fileLength).append(",").append(i10).append(",");
            stringBuffer.append(dVar.field_recvedBytes).append(",");
            stringBuffer.append(i6 + ",").append(i7 + ",").append(i8 + ",");
            stringBuffer.append(i2 + ",").append(i3 + ",");
            stringBuffer.append(iOSNetType).append(",");
            stringBuffer.append(i14).append(",");
            stringBuffer.append(dVar.field_startTime).append(",");
            stringBuffer.append(dVar.field_endTime).append(",");
            if (alQ) {
                stringBuffer.append(hVar.gqV != null ? com.tencent.mm.b.g.getMessageDigest(hVar.gqV.getBytes()) : 0).append(",");
                stringBuffer.append(ab.Eq(hVar.gqV) ? 1 : 0).append(",");
            } else {
                stringBuffer.append(0).append(",");
                stringBuffer.append(dVar.field_httpStatusCode).append(",");
            }
            stringBuffer.append(dVar.field_retCode).append(",");
            stringBuffer.append(dVar.field_enQueueTime).append(",");
            stringBuffer.append(dVar.field_firstRequestCost).append(",");
            stringBuffer.append(dVar.field_firstRequestSize).append(",");
            stringBuffer.append(dVar.field_firstRequestDownloadSize).append(",");
            stringBuffer.append(dVar.field_firstRequestCompleted ? 1 : 0).append(",");
            stringBuffer.append(dVar.field_averageSpeed).append(",");
            stringBuffer.append(dVar.field_averageConnectCost).append(",");
            stringBuffer.append(dVar.field_firstConnectCost).append(",");
            stringBuffer.append(dVar.field_netConnectTimes).append(",");
            stringBuffer.append(dVar.field_moovRequestTimes).append(",");
            stringBuffer.append(dVar.field_moovCost).append(",");
            stringBuffer.append(dVar.field_moovSize).append(",");
            stringBuffer.append(dVar.field_moovCompleted ? 1 : 0).append(",");
            stringBuffer.append(dVar.field_moovFailReason).append(",");
            stringBuffer.append(i4).append(",");
            stringBuffer.append(i5).append(",");
            if (alQ) {
                stringBuffer.append(i11).append(",");
            } else {
                stringBuffer.append(i11).append(",");
                stringBuffer.append(hVar.gqV != null ? com.tencent.mm.b.g.getMessageDigest(hVar.gqV.getBytes()) : 0).append(",");
            }
            stringBuffer.append(alM).append(",");
            if (alQ) {
                stringBuffer.append(hVar.gqY).append(",");
                stringBuffer.append(hVar.dTS).append(",");
                stringBuffer.append(hVar.gqz).append(",");
                stringBuffer.append(dVar.field_videoFormat).append(",");
            } else {
                stringBuffer.append(com.tencent.mm.plugin.video.c.aTR(hVar.dRS)).append(",");
            }
            stringBuffer.append(str2).append(",");
            stringBuffer.append(i9).append(",");
            stringBuffer.append(hVar.gra).append(",");
            stringBuffer.append(pInt3.value).append(",");
            stringBuffer.append(pInt4.value).append(",");
            stringBuffer.append(dVar.transportProtocol).append(",");
            stringBuffer.append(dVar.transportProtocolError);
            int i15 = alQ ? 13570 : 13790;
            if (alS) {
                i15 = 13570;
            }
            String stringBuffer2 = stringBuffer.toString();
            Log.i("MicroMsg.OnlineVideoService", "report online video %d:%s", Integer.valueOf(i15), stringBuffer2);
            if (alQ) {
                new gp(stringBuffer2).bfK();
            } else if (alS) {
                int i16 = 0;
                int i17 = 0;
                String str3 = "";
                long j5 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                if (objArr != null && objArr.length >= 11) {
                    i16 = Util.getInt(objArr[7].toString(), 0);
                    Util.getInt(objArr[8].toString(), 0);
                    i17 = Util.getInt(objArr[9].toString(), 0);
                    str3 = objArr[11].toString();
                    i18 = Util.getInt(objArr[12].toString(), 0);
                    j5 = Util.getLong(objArr[13].toString(), 0);
                    i19 = Util.getInt(objArr[14].toString(), 0);
                    i20 = Util.getInt(objArr[15].toString(), 0);
                    i21 = Util.getInt(objArr[16].toString(), 0);
                }
                lg lgVar = new lg();
                lg ys = lgVar.ys(str3);
                ys.eXO = (long) i18;
                ys.eXP = (long) i20;
                ys.eXQ = (long) i19;
                ys.eoV = (long) i10;
                ys.eXR = (long) (i6 / 1000);
                ys.eKd = (long) i7;
                ys.eKe = (long) i8;
                ys.eGw = (long) i2;
                ys.eGx = (long) i3;
                ys.eXS = 0;
                ys.eKy = (long) i4;
                ys.eXT = (long) i5;
                lg yt = ys.yt("");
                yt.eoW = (long) (i11 * 1000);
                lg yu = yt.yu(new StringBuilder().append(hVar.field_requestVideoFormat).toString());
                yu.elK = dVar.field_fileLength;
                yu.eXW = dVar.field_recvedBytes;
                yu.eKh = dVar.field_startTime;
                yu.eKi = dVar.field_endTime;
                yu.eXX = (long) dVar.field_retCode;
                yu.eXY = dVar.field_enQueueTime;
                yu.eXZ = (long) dVar.field_moovRequestTimes;
                yu.eYa = (long) dVar.field_moovCost;
                yu.eKv = (long) dVar.field_moovSize;
                if (dVar.field_moovCompleted) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                yu.eYb = j2;
                yu.eYc = (long) dVar.field_moovFailReason;
                yu.eYd = (long) dVar.field_firstConnectCost;
                yu.eYe = (long) dVar.field_firstRequestCost;
                yu.eYf = (long) dVar.field_firstRequestSize;
                yu.eYg = (long) dVar.field_firstRequestDownloadSize;
                if (dVar.field_firstRequestCompleted) {
                    j3 = 1;
                } else {
                    j3 = 0;
                }
                yu.eYh = j3;
                yu.eYi = (long) dVar.field_averageSpeed;
                yu.eYj = (long) dVar.field_averageConnectCost;
                yu.eKs = (long) dVar.field_netConnectTimes;
                lg yw = yu.yv(dVar.alM()).yw(dVar.field_clientIP);
                if (dVar.field_isCrossNet) {
                    j4 = 1;
                } else {
                    j4 = 0;
                }
                yw.eYl = j4;
                yw.eKG = hVar.gra;
                yw.eYm = (long) i17;
                yw.elI = (long) iOSNetType;
                yw.eYn = j5;
                yw.epd = (long) i16;
                yw.eYo = (long) i21;
                yw.eKH = dVar.transportProtocol;
                yw.eKI = dVar.transportProtocolError;
                yw.eKJ = dVar.traceId;
                Log.d("MicroMsg.OnlineVideoService", "time distance %d", Long.valueOf(System.currentTimeMillis() - lgVar.eYn));
                if (System.currentTimeMillis() - lgVar.eYn > 500) {
                    lgVar.bfK();
                }
                if (alS) {
                    jh jhVar = new jh();
                    com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(hVar.field_fullpath);
                    if (aNx != null) {
                        jhVar.eoV = (long) aNx.videoDuration;
                        jhVar.eoW = (long) aNx.videoBitrate;
                        jhVar.eoX = (long) aNx.audioBitrate;
                        jhVar.eoY = (long) aNx.frameRate;
                        jhVar.eoZ = (long) aNx.width;
                        jhVar.epa = (long) aNx.height;
                        jhVar.epc = (long) aNx.audioChannel;
                    }
                    jhVar.eoU = dVar.field_fileLength;
                    jh wK = jhVar.wK(hVar.url);
                    f.baR();
                    jh wL = wK.wL(a.NX(hVar.field_fullpath));
                    wL.eoS = dVar.field_startTime;
                    wL.eoT = dVar.field_endTime;
                    jh wM = wL.wM(alM);
                    wM.epd = (long) i16;
                    wM.epe = (long) pInt4.value;
                    wM.bfK();
                }
            } else {
                iq iqVar = new iq(stringBuffer2);
                iqVar.ePx = i13;
                iqVar.wp(str);
                iqVar.ePv = i12;
                iqVar.eKJ = dVar.traceId;
                Log.d("13790", "report 13790 value: " + iqVar.abV());
                Log.d("13790", "trace id  " + (dVar.traceId & -1));
                iqVar.bfK();
            }
            if (z) {
                a(hVar.dRL, hVar.gqV, hVar.dRN, dVar.field_fileId, iOSNetType, dVar.field_startTime, dVar.field_endTime, hVar.field_fullpath, dVar.field_usedSvrIps, hVar.url, pInt3.value, pInt4.value, hVar.dRS);
            }
            if (alQ) {
                if (dVar.field_videoFormat == 2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 132, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(354, 133, 1, false);
                }
                s QN = u.QN(hVar.filename);
                if (QN != null) {
                    ca Hb = ((l) g.af(l.class)).eiy().Hb((long) QN.jso);
                    ((l) g.af(l.class)).eiy().a(new i.c(Hb.field_talker, "update", Hb));
                }
            }
            AppMethodBeat.o(126742);
        } else {
            AppMethodBeat.o(126742);
        }
    }

    private static void a(PInt pInt, PInt pInt2, String str, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(126743);
        int i5 = 0;
        s QN = u.QN(str);
        if (QN != null) {
            i5 = QN.dRQ;
            i3 = QN.iKP;
        } else {
            i3 = 0;
        }
        if (i2 <= 0) {
            i4 = 1;
        } else {
            int i6 = (int) ((((float) i2) / 100.0f) * ((float) i3));
            if (i5 < i6) {
                i4 = 2;
            } else {
                i4 = 3;
            }
            Log.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), Integer.valueOf(i5));
        }
        pInt.value = i5;
        pInt2.value = i4;
        Log.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value));
        AppMethodBeat.o(126743);
    }

    private static void a(String str, String str2, int i2, String str3, int i3, long j2, long j3, String str4, String[] strArr, String str5, int i4, int i5, String str6) {
        AppMethodBeat.i(126744);
        mk mkVar = new mk();
        mkVar.dRK.dRL = str;
        mkVar.dRK.dRM = str2;
        mkVar.dRK.dRN = i2;
        mkVar.dRK.fileId = str3;
        mkVar.dRK.netType = i3;
        mkVar.dRK.startTime = j2;
        mkVar.dRK.endTime = j3;
        mkVar.dRK.path = str4;
        mkVar.dRK.dRO = strArr;
        mkVar.dRK.dRP = str5;
        mkVar.dRK.dRQ = i4;
        mkVar.dRK.dRR = i5;
        mkVar.dRK.dRS = str6;
        EventCenter.instance.publish(mkVar);
        AppMethodBeat.o(126744);
    }
}
