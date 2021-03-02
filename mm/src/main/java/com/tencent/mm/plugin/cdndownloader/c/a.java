package com.tencent.mm.plugin.cdndownloader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.f;
import com.tencent.mm.i.b;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements b.a {
    private static a qmr = null;
    Map<String, g> iRA = new ConcurrentHashMap();
    private Map<String, Integer> iRB = new ConcurrentHashMap();
    private String iRC = "";
    private long iRD = 0;
    public HashSet<String> iRE = new HashSet<>();
    Queue<String> iRy = new LinkedList();
    Map<String, g> iRz = new ConcurrentHashMap();
    private MMHandler qmq = new MMHandler("CdnDownloadNativeService#" + hashCode());
    private com.tencent.mm.an.a qms = null;

    static /* synthetic */ com.tencent.mm.an.a e(a aVar) {
        AppMethodBeat.i(120722);
        com.tencent.mm.an.a baR = aVar.baR();
        AppMethodBeat.o(120722);
        return baR;
    }

    public a() {
        AppMethodBeat.i(120711);
        AppMethodBeat.o(120711);
    }

    public static synchronized a cxZ() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(120712);
            if (qmr == null) {
                qmr = new a();
            }
            aVar = qmr;
            AppMethodBeat.o(120712);
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public final com.tencent.mm.an.a baR() {
        AppMethodBeat.i(120713);
        if (this.qms == null) {
            if (MMApplicationContext.isMMProcess()) {
                Log.i("MicroMsg.CdnDownloadNativeService", "use mm process cdn engine.");
                this.qms = f.baR();
            } else {
                Log.i("MicroMsg.CdnDownloadNativeService", "use new cdn engine.");
                this.qms = new com.tencent.mm.an.a(MMApplicationContext.getContext().getFilesDir() + "/NativeCDNInfo", this);
            }
        }
        com.tencent.mm.an.a aVar = this.qms;
        AppMethodBeat.o(120713);
        return aVar;
    }

    public final boolean Oc(String str) {
        AppMethodBeat.i(120715);
        g remove = this.iRA.remove(str);
        if (remove != null) {
            if (remove.field_fileType == com.tencent.mm.i.a.gqa || remove.field_fileType == com.tencent.mm.i.a.gqc) {
                baR();
                com.tencent.mm.an.a.NY(str);
            } else if (remove.gqH) {
                baR();
                com.tencent.mm.an.a.NZ(str);
            } else {
                baR();
                com.tencent.mm.an.a.NU(str);
            }
            h.INSTANCE.a(10769, Integer.valueOf(c.iSb), Integer.valueOf(remove.field_fileType), Long.valueOf(Util.nowMilliSecond() - remove.field_startTime));
        }
        this.iRz.remove(str);
        this.iRB.remove(str);
        Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, remove, 0);
        AppMethodBeat.o(120715);
        return true;
    }

    public final boolean aku(String str) {
        AppMethodBeat.i(226021);
        g gVar = this.iRA.get(str);
        Oc(str);
        if (!(gVar == null || gVar.field_fullpath == null)) {
            Log.i("MicroMsg.CdnDownloadNativeService", "cancelGameRecvTask, delete file:" + gVar.field_fullpath);
            s.deleteFile(gVar.field_fullpath);
        }
        AppMethodBeat.o(226021);
        return true;
    }

    public final int i(g gVar) {
        AppMethodBeat.i(120716);
        if (this.iRA.containsKey(gVar.field_mediaId)) {
            int resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(gVar.field_mediaId);
            Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", gVar.field_mediaId, Integer.valueOf(resumeHttpMultiSocketDownloadTask));
            AppMethodBeat.o(120716);
            return resumeHttpMultiSocketDownloadTask;
        }
        Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", gVar.field_mediaId);
        int h2 = h(gVar);
        AppMethodBeat.o(120716);
        return h2;
    }

    @Override // com.tencent.mm.i.b.a
    public final int a(final String str, final com.tencent.mm.i.c cVar, final d dVar) {
        AppMethodBeat.i(120718);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
            AppMethodBeat.o(120718);
            return -1;
        } else if (cVar == null && dVar == null) {
            Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
            AppMethodBeat.o(120718);
            return -2;
        } else {
            if (cVar != null) {
                Log.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b, isUploadTask:%b", Long.valueOf(cVar.field_toltalLength), Long.valueOf(cVar.field_finishedLength), Boolean.valueOf(cVar.field_mtlnotify), Boolean.valueOf(cVar.field_isUploadTask));
            }
            final boolean z = cVar != null ? cVar.field_isUploadTask : false;
            this.iRD = Util.nowMilliSecond();
            this.iRC = str;
            this.qmq.postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.cdndownloader.c.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(120708);
                    g gVar = (g) a.this.iRA.get(str);
                    if (gVar == null) {
                        Log.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", str);
                        AppMethodBeat.o(120708);
                        return;
                    }
                    if (cVar != null) {
                        cVar.mediaId = str;
                        Log.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b, isSend:%b, isUploadTask:%b(%b)", Long.valueOf(cVar.field_toltalLength), Long.valueOf(cVar.field_finishedLength), Boolean.valueOf(cVar.field_mtlnotify), Boolean.valueOf(gVar.ehd), Boolean.valueOf(cVar.field_isUploadTask), Boolean.valueOf(z));
                        if (z != gVar.ehd) {
                            AppMethodBeat.o(120708);
                            return;
                        }
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
                            AppMethodBeat.o(120708);
                            return;
                        }
                    }
                    if (a.b(cVar)) {
                        a.this.iRB.remove(str);
                    }
                    if (dVar != null) {
                        a.this.iRA.remove(str);
                        if (dVar.field_retCode == -5103011) {
                            Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            h.INSTANCE.idkeyStat(546, 4, 1, true);
                            a.e(a.this).keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                    AppMethodBeat.o(120708);
                }

                public final String toString() {
                    AppMethodBeat.i(120709);
                    String str = super.toString() + "|callback";
                    AppMethodBeat.o(120709);
                    return str;
                }
            });
            AppMethodBeat.o(120718);
            return 0;
        }
    }

    @Override // com.tencent.mm.i.b.a
    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.i(120719);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
            AppMethodBeat.o(120719);
            return;
        }
        g gVar = this.iRA.get(str);
        if (gVar == null) {
            Log.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", str);
            AppMethodBeat.o(120719);
        } else if (gVar.gqy != null) {
            gVar.gqy.a(str, byteArrayOutputStream);
            AppMethodBeat.o(120719);
        } else {
            Log.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
            AppMethodBeat.o(120719);
        }
    }

    @Override // com.tencent.mm.i.b.a
    public final byte[] f(String str, byte[] bArr) {
        AppMethodBeat.i(120720);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
            AppMethodBeat.o(120720);
            return null;
        }
        g gVar = this.iRA.get(str);
        if (gVar == null) {
            Log.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            AppMethodBeat.o(120720);
            return null;
        } else if (gVar.gqy != null) {
            byte[] f2 = gVar.gqy.f(str, bArr);
            AppMethodBeat.o(120720);
            return f2;
        } else {
            Log.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
            AppMethodBeat.o(120720);
            return null;
        }
    }

    @Override // com.tencent.mm.i.b.a
    public final int a(final String str, final d dVar) {
        AppMethodBeat.i(226022);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(226022);
        } else {
            this.qmq.postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.cdndownloader.c.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(120710);
                    g gVar = (g) a.this.iRA.get(str);
                    if (gVar == null) {
                        Log.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", str);
                        AppMethodBeat.o(120710);
                        return;
                    }
                    if (gVar.gqQ != null) {
                        gVar.gqQ.b(str, dVar);
                    }
                    AppMethodBeat.o(120710);
                }
            });
            AppMethodBeat.o(226022);
        }
        return 0;
    }

    public final int h(final g gVar) {
        AppMethodBeat.i(120714);
        if (gVar == null) {
            Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask task info is null");
            AppMethodBeat.o(120714);
            return -1;
        } else if (Util.isNullOrNil(gVar.field_mediaId)) {
            Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
            AppMethodBeat.o(120714);
            return -1;
        } else {
            if (gVar.field_fileId == null) {
                gVar.field_fileId = "";
            }
            if (gVar.field_aesKey == null) {
                gVar.field_aesKey = "";
            }
            if (this.iRy.contains(gVar.field_fileId)) {
                Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
                AppMethodBeat.o(120714);
                return -2;
            } else if (this.iRz.containsKey(gVar.field_fileId)) {
                Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
                AppMethodBeat.o(120714);
                return -2;
            } else if (this.iRA.containsKey(gVar.field_fileId)) {
                Log.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
                AppMethodBeat.o(120714);
                return -2;
            } else {
                gVar.ehd = false;
                this.qmq.postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.cdndownloader.c.a.AnonymousClass1 */
                    final /* synthetic */ int iRM = -1;

                    public final void run() {
                        int i2;
                        int i3;
                        int length;
                        int length2;
                        int length3;
                        int length4;
                        int length5;
                        AppMethodBeat.i(120706);
                        if (this.iRM != -1) {
                            a.this.iRB.put(gVar.field_mediaId, Integer.valueOf(this.iRM));
                        }
                        a.this.iRy.add(gVar.field_mediaId);
                        a.this.iRz.put(gVar.field_mediaId, gVar);
                        a aVar = a.this;
                        Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", Integer.valueOf(aVar.iRy.size()));
                        while (!aVar.iRy.isEmpty()) {
                            g remove = aVar.iRz.remove(aVar.iRy.poll());
                            if (remove == null) {
                                Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
                                AppMethodBeat.o(120706);
                                return;
                            }
                            Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", remove.field_mediaId, Boolean.valueOf(remove.field_autostart), Integer.valueOf(remove.field_chattype));
                            remove.field_startTime = Util.nowMilliSecond();
                            if (remove.ehd) {
                                Object[] objArr = new Object[7];
                                if (remove.field_fullpath == null) {
                                    length4 = -1;
                                } else {
                                    length4 = remove.field_fullpath.length();
                                }
                                objArr[0] = Integer.valueOf(length4);
                                if (remove.field_thumbpath == null) {
                                    length5 = -1;
                                } else {
                                    length5 = remove.field_thumbpath.length();
                                }
                                objArr[1] = Integer.valueOf(length5);
                                objArr[2] = Util.secPrint(remove.field_svr_signature);
                                objArr[3] = Util.secPrint(remove.field_aesKey);
                                objArr[4] = Integer.valueOf(remove.field_fileType);
                                objArr[5] = remove.field_mediaId;
                                objArr[6] = Boolean.valueOf(remove.field_onlycheckexist);
                                Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", objArr);
                                if (remove.field_fullpath == null) {
                                    remove.field_fullpath = "";
                                }
                                if (remove.field_thumbpath == null) {
                                    remove.field_thumbpath = "";
                                }
                                int b2 = aVar.baR().b(remove);
                                if (b2 != 0) {
                                    Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", Integer.valueOf(b2), remove.field_mediaId);
                                    if (remove.gqy != null) {
                                        remove.gqy.a(remove.field_mediaId, b2, null, null, remove.field_onlycheckexist);
                                    }
                                } else {
                                    Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", remove.field_mediaId);
                                    aVar.iRA.put(remove.field_mediaId, remove);
                                }
                            } else {
                                int i4 = -1;
                                if (remove.field_fileType == com.tencent.mm.i.a.gqa || remove.field_fileType == com.tencent.mm.i.a.gqc || remove.field_fileType == com.tencent.mm.i.a.gqd || remove.field_fileType == com.tencent.mm.i.a.gqe || remove.field_fileType == com.tencent.mm.i.a.gqf || remove.field_fileType == com.tencent.mm.i.a.gqh) {
                                    if (remove.field_fullpath == null || remove.field_fullpath.isEmpty()) {
                                        i3 = -1;
                                    } else {
                                        i3 = aVar.baR().a(remove.field_mediaId, remove.gqB, remove.field_fullpath, remove.field_fileType, remove.gqC, remove.gqD, remove.gqE, remove.gqF, remove.gqM, remove.gqN);
                                    }
                                    Object[] objArr2 = new Object[5];
                                    if (remove.field_fullpath == null) {
                                        length = -1;
                                    } else {
                                        length = remove.field_fullpath.length();
                                    }
                                    objArr2[0] = Integer.valueOf(length);
                                    objArr2[1] = remove.field_mediaId;
                                    objArr2[2] = remove.gqB;
                                    objArr2[3] = Integer.valueOf(remove.field_fileType);
                                    objArr2[4] = Integer.valueOf(i3);
                                    Log.i("MicroMsg.CdnDownloadNativeService", "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d", objArr2);
                                    i2 = i3;
                                } else if (remove.gqH) {
                                    if (remove.field_fullpath != null && !remove.field_fullpath.isEmpty()) {
                                        i4 = aVar.baR().a(remove.field_mediaId, remove.field_fullpath, remove.gqB, remove.gqI, remove.gqJ, remove.allow_mobile_net_download, remove.gqC, remove.gqD, remove.is_resume_task, remove.gqG, remove.gqE);
                                    }
                                    Object[] objArr3 = new Object[4];
                                    objArr3[0] = remove.field_fullpath == null ? "" : remove.field_fullpath;
                                    objArr3[1] = remove.field_mediaId;
                                    objArr3[2] = remove.gqB;
                                    objArr3[3] = remove.gqI;
                                    Log.i("MicroMsg.CdnDownloadNativeService", "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]", objArr3);
                                    i2 = i4;
                                } else {
                                    Object[] objArr4 = new Object[7];
                                    if (remove.field_fullpath == null) {
                                        length2 = -1;
                                    } else {
                                        length2 = remove.field_fullpath.length();
                                    }
                                    objArr4[0] = Integer.valueOf(length2);
                                    if (remove.field_thumbpath == null) {
                                        length3 = -1;
                                    } else {
                                        length3 = remove.field_thumbpath.length();
                                    }
                                    objArr4[1] = Integer.valueOf(length3);
                                    objArr4[2] = remove.field_svr_signature;
                                    objArr4[3] = remove.field_aesKey;
                                    objArr4[4] = Integer.valueOf(remove.field_fileType);
                                    objArr4[5] = remove.field_mediaId;
                                    objArr4[6] = Boolean.valueOf(remove.field_onlycheckexist);
                                    Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]", objArr4);
                                    if (remove.gqO != 2) {
                                        i2 = aVar.baR().c(remove);
                                    } else if (remove instanceof com.tencent.mm.i.h) {
                                        com.tencent.mm.i.h hVar = (com.tencent.mm.i.h) remove;
                                        if (hVar.alQ()) {
                                            i2 = aVar.baR().a(remove, 2);
                                        } else {
                                            if (hVar.alO()) {
                                                hVar.connectionCount = 1;
                                                hVar.concurrentCount = 1;
                                                i4 = aVar.baR().a(hVar);
                                            }
                                            i2 = i4;
                                        }
                                    } else {
                                        i2 = -1;
                                    }
                                }
                                if (i2 != 0) {
                                    Log.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(i2), remove.field_mediaId);
                                    if (remove.gqy != null) {
                                        remove.gqy.a(remove.field_mediaId, i2, null, null, remove.field_onlycheckexist);
                                    }
                                } else {
                                    Log.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", remove.field_mediaId);
                                    aVar.iRA.put(remove.field_mediaId, remove);
                                }
                            }
                        }
                        AppMethodBeat.o(120706);
                    }

                    public final String toString() {
                        AppMethodBeat.i(120707);
                        String str = super.toString() + "|addRecvTask";
                        AppMethodBeat.o(120707);
                        return str;
                    }
                });
                AppMethodBeat.o(120714);
                return 0;
            }
        }
    }

    static /* synthetic */ boolean b(com.tencent.mm.i.c cVar) {
        if (cVar == null || cVar.field_finishedLength == cVar.field_toltalLength) {
            return true;
        }
        return false;
    }
}
