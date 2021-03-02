package com.tencent.mm.plugin.flutter.f;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.i.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001LB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J6\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020&2\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u001c\u0010(\u001a\u00020)2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0015\u0010+\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010-¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u000200J\u001c\u00101\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u0004\u0018\u00010\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\"\u00105\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020-H\u0016J$\u00108\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u00109\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010:\u001a\u0002002\u0006\u0010\u001f\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010\bH\u0016J*\u0010<\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020-2\u0006\u0010=\u001a\u00020\bH\u0016J\u001c\u0010>\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\"\u0010?\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020-H\u0016J\u001f\u0010B\u001a\u0002002\b\u0010C\u001a\u0004\u0018\u00010\b2\b\u0010,\u001a\u0004\u0018\u00010-¢\u0006\u0002\u0010DJ\u001e\u0010E\u001a\u0002002\u0006\u0010C\u001a\u00020\b2\u0006\u0010F\u001a\u00020-2\u0006\u00107\u001a\u00020-J1\u0010G\u001a\u0002002\u0006\u0010H\u001a\u00020&2\b\u0010C\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010,\u001a\u0004\u0018\u00010-¢\u0006\u0002\u0010IJ\u001a\u0010J\u001a\u0002002\b\u0010C\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u0010\u0010K\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\bR\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u000eR6\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "lastPlayMediaId", "getLastPlayMediaId", "setLastPlayMediaId", "(Ljava/lang/String;)V", "preLoadTaskUrl", "getPreLoadTaskUrl", "setPreLoadTaskUrl", "root", "getRoot", "setRoot", "videoTaskInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "Lkotlin/collections/HashMap;", "getVideoTaskInfoMap", "()Ljava/util/HashMap;", "setVideoTaskInfoMap", "(Ljava/util/HashMap;)V", "callback", "", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "checkTask", "decodePrepareResponse", "", "inbuf", "doPreLoadTask", "minLength", "", "(Ljava/lang/Long;)I", "dumpTaskDoing", "", "getCdnAuthInfo", "buff", "Ljava/io/ByteArrayOutputStream;", "getTaskInfo", "onDataAvailable", "offset", "length", "onFinish", "ret", "onM3U8Ready", "m3u8", "onMoovReady", "svrFlag", "onPreloadCompleted", "onProgress", "finished", "total", "preloadTask", "url", "(Ljava/lang/String;Ljava/lang/Long;)V", "queryDate", "offest", "retryStartTask", "isPlayMode", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "startTask", "stopTask", "FTVideoTaskInfo", "plugin-flutter_release"})
public final class b implements g.a, g.b, h.a {
    private final String TAG = "MicroMsg.FlutterVideoPlayerMgr";
    private String wKP;
    private String wKQ;
    private HashMap<String, a> wKR = new HashMap<>();
    private String wKS;

    public b(Context context) {
        p.h(context, "context");
        AppMethodBeat.i(241132);
        this.wKP = context.getCacheDir() + "/flutter/FTVideo/";
        AppMethodBeat.o(241132);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/flutter/video/FlutterCdnDownloadMgr$FTVideoTaskInfo;", "", "()V", "cacheSize", "", "getCacheSize", "()J", "setCacheSize", "(J)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "isDoing", "setDoing", "isPlayMode", "setPlayMode", "isPreloadComplete", "setPreloadComplete", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "preloadedSize", "getPreloadedSize", "setPreloadedSize", "totalSize", "getTotalSize", "setTotalSize", "plugin-flutter_release"})
    public static final class a {
        boolean brr;
        long cacheSize;
        long oJj;
        String path = "";
        long wKT;
        boolean wKU;
        boolean wKV;
        boolean wKW;

        public final void setPath(String str) {
            AppMethodBeat.i(241117);
            p.h(str, "<set-?>");
            this.path = str;
            AppMethodBeat.o(241117);
        }
    }

    public final void a(String str, Long l) {
        byte[] bArr;
        a aVar;
        AppMethodBeat.i(241118);
        this.wKS = str;
        if (this.wKS == null) {
            Log.d(this.TAG, "FVPlayer preLoadTask empty preload task");
            AppMethodBeat.o(241118);
            return;
        }
        String str2 = this.wKS;
        if (str2 != null) {
            Charset charset = d.UTF_8;
            if (str2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(241118);
                throw tVar;
            }
            bArr = str2.getBytes(charset);
            p.g(bArr, "(this as java.lang.String).getBytes(charset)");
        } else {
            bArr = null;
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(bArr);
        StringBuilder append = new StringBuilder().append(this.wKP).append('-');
        String str3 = this.wKS;
        String absolutePath = new o(append.append(str3 != null ? str3.hashCode() : 0).append(".mp4").toString()).getAbsolutePath();
        p.g(absolutePath, "VFSFile(\"${root}-${preLo…ode()}.mp4\").absolutePath");
        if (n.I(messageDigest, this.wKQ, true)) {
            Log.d(this.TAG, "FVPlayer preLoadTask can not preload playing task lastPlayMediaId:" + this.wKQ);
            AppMethodBeat.o(241118);
            return;
        }
        Log.d(this.TAG, "FVPlayer preLoadTask mediaId:" + messageDigest + " url:" + this.wKS + " path:" + absolutePath);
        if (this.wKR.get(messageDigest) == null) {
            aVar = new a();
        } else {
            a aVar2 = this.wKR.get(messageDigest);
            if (aVar2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
                AppMethodBeat.o(241118);
                throw tVar2;
            }
            aVar = aVar2;
        }
        if (aVar.wKW && l != null && l.longValue() != 0 && aVar.cacheSize < l.longValue()) {
            aVar.wKW = false;
        }
        if (aVar.brr || aVar.wKW || aVar.wKU) {
            Log.d(this.TAG, "FVPlayer preLoadTask mediaId:" + messageDigest + " has downloaded or isDoing:" + aVar.brr + ", " + aVar.wKW + ", " + aVar.wKU + '.');
        } else {
            h hVar = new h();
            hVar.taskName = "task_FlutterCdnDownloadMgr_1";
            hVar.field_mediaId = messageDigest;
            hVar.url = this.wKS;
            hVar.gqC = 60;
            hVar.gqD = 60;
            hVar.gqO = 2;
            hVar.gqU = 2;
            hVar.gqP = 3;
            hVar.field_requestVideoFormat = 0;
            hVar.field_fullpath = absolutePath;
            hVar.concurrentCount = 8;
            hVar.connectionCount = 1;
            hVar.gre = this;
            hVar.gqy = this;
            hVar.gqQ = this;
            if (!(l == null || l.longValue() == 0)) {
                hVar.preloadMinSize = l.longValue();
            }
            if (!CdnLogic.taskExist(messageDigest)) {
                e.wLs.dMk().wLq.g(hVar);
                aVar.wKU = true;
                aVar.wKV = false;
                Log.d(this.TAG, "cdntaskaction adddownload FVPlayer preLoadTask mediaId:" + messageDigest + " .");
            } else {
                Log.d(this.TAG, "FVPlayer preLoadTask task exist mediaId:" + messageDigest + " .");
            }
        }
        aVar.setPath(absolutePath);
        p.g(messageDigest, "mediaId");
        this.wKR.put(messageDigest, aVar);
        AppMethodBeat.o(241118);
    }

    public final void hp(String str, String str2) {
        byte[] bArr;
        int i2;
        a aVar;
        Boolean bool;
        Boolean bool2 = null;
        AppMethodBeat.i(241119);
        Log.d(this.TAG, "FVPlayer startTask mediaId:" + str2 + " url:" + str);
        if (!CdnLogic.taskExist(str2)) {
            boolean z = this.wKR.get(str2) == null;
            a aVar2 = this.wKR.get(str2);
            if (aVar2 != null) {
                bool = Boolean.valueOf(aVar2.brr);
            } else {
                bool = null;
            }
            Log.e(this.TAG, "testtest task not in preload, in info cache:" + z + ", completed:" + bool);
        }
        if (str != null) {
            Charset charset = d.UTF_8;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(241119);
                throw tVar;
            }
            bArr = str.getBytes(charset);
            p.g(bArr, "(this as java.lang.String).getBytes(charset)");
        } else {
            bArr = null;
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(bArr);
        StringBuilder append = new StringBuilder().append(this.wKP).append('-');
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        String absolutePath = new o(append.append(i2).append(".mp4").toString()).getAbsolutePath();
        p.g(absolutePath, "VFSFile(\"${root}-${url.h…ode()}.mp4\").absolutePath");
        if (this.wKR.get(messageDigest) == null) {
            aVar = new a();
        } else {
            a aVar3 = this.wKR.get(messageDigest);
            if (aVar3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
                AppMethodBeat.o(241119);
                throw tVar2;
            }
            aVar = aVar3;
        }
        if (!n.I(this.wKQ, messageDigest, false) || !aVar.wKU || !aVar.wKV) {
            if (!aVar.brr) {
                h hVar = new h();
                hVar.taskName = "task_FlutterCdnDownloadMgr_2";
                hVar.field_mediaId = messageDigest;
                hVar.url = str;
                hVar.gqC = 60;
                hVar.gqD = 60;
                hVar.gqO = 1;
                hVar.gqU = 1;
                hVar.gqP = 3;
                hVar.field_requestVideoFormat = 0;
                hVar.field_fullpath = absolutePath;
                hVar.concurrentCount = 8;
                hVar.gre = this;
                if (this.wKQ != null && !n.I(this.wKQ, messageDigest, false) && CdnLogic.taskExist(this.wKQ)) {
                    int axz = e.wLs.dMk().wLq.axz(this.wKQ);
                    if (aVar != null) {
                        aVar.wKU = false;
                    }
                    Log.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.wKQ + ' ' + axz);
                }
                if (CdnLogic.taskExist(messageDigest)) {
                    if (aVar != null) {
                        bool2 = Boolean.valueOf(aVar.wKV);
                    }
                    if (!bool2.booleanValue()) {
                        int axz2 = e.wLs.dMk().wLq.axz(messageDigest);
                        if (aVar != null) {
                            aVar.wKU = false;
                        }
                        Log.d(this.TAG, "cdntaskaction cancel FVPlayer startTask cancelDownloadTask lastPlayMediaId:" + this.wKQ + " mediaId:" + messageDigest + ' ' + axz2);
                    }
                }
                int g2 = e.wLs.dMk().wLq.g(hVar);
                if (aVar != null) {
                    aVar.wKU = true;
                }
                if (aVar != null) {
                    aVar.wKV = true;
                }
                Log.d(this.TAG, "cdntaskaction adddownload FVPlayer startTask addDownloadTaskNotCancelInMainThread mediaId:" + messageDigest + ' ' + g2 + " playmode:true path: " + absolutePath);
            } else {
                Log.d(this.TAG, "FVPlayer startTask mediaId:" + messageDigest + " has downloaded.");
            }
            this.wKQ = messageDigest;
            aVar.setPath(absolutePath);
            p.g(messageDigest, "mediaId");
            this.wKR.put(messageDigest, aVar);
            AppMethodBeat.o(241119);
            return;
        }
        Log.i(this.TAG, "playmode is downloading:".concat(String.valueOf(messageDigest)));
        AppMethodBeat.o(241119);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0091, code lost:
        if (r0.longValue() >= r12.longValue()) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r10, java.lang.String r11, java.lang.Long r12) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.flutter.f.b.a(java.lang.String, java.lang.String, java.lang.Long):void");
    }

    public final int axx(String str) {
        AppMethodBeat.i(241121);
        Log.d(this.TAG, "cdntaskaction cancel FVPlayer stopTask mediaId:" + str + ' ');
        int axz = e.wLs.dMk().wLq.axz(str);
        a aVar = this.wKR.get(str);
        if (aVar != null) {
            aVar.wKU = false;
        }
        if (n.I(this.wKQ, str, true)) {
            this.wKQ = null;
        }
        AppMethodBeat.o(241121);
        return axz;
    }

    public final a axy(String str) {
        AppMethodBeat.i(241122);
        if (this.wKR.get(str) == null) {
            a aVar = new a();
            AppMethodBeat.o(241122);
            return aVar;
        }
        a aVar2 = this.wKR.get(str);
        if (aVar2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
            AppMethodBeat.o(241122);
            throw tVar;
        }
        a aVar3 = aVar2;
        AppMethodBeat.o(241122);
        return aVar3;
    }

    @Override // com.tencent.mm.i.h.a
    public final void Ds(String str) {
        AppMethodBeat.i(241123);
        p.h(str, "mediaId");
        AppMethodBeat.o(241123);
    }

    @Override // com.tencent.mm.i.h.a
    public final void a(String str, long j2, long j3, String str2) {
        AppMethodBeat.i(241124);
        p.h(str2, "svrFlag");
        AppMethodBeat.o(241124);
    }

    @Override // com.tencent.mm.i.h.a
    public final void onDataAvailable(String str, long j2, long j3) {
        AppMethodBeat.i(241125);
        Log.d(this.TAG, "onDataAvailable mediaId:" + str + ", offset:" + j2 + ", length:" + j3);
        AppMethodBeat.o(241125);
    }

    @Override // com.tencent.mm.i.h.a
    public final void i(String str, long j2, long j3) {
        a aVar;
        AppMethodBeat.i(241126);
        Log.d(this.TAG, "onProgress mediaId:" + str + ", finish:" + j2 + ", length:" + j3);
        if (str != null) {
            if (this.wKR.get(str) == null) {
                aVar = new a();
            } else {
                a aVar2 = this.wKR.get(str);
                if (aVar2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
                    AppMethodBeat.o(241126);
                    throw tVar;
                }
                aVar = aVar2;
            }
            aVar.cacheSize = j2;
            aVar.oJj = j3;
            this.wKR.put(str, aVar);
            if (j2 == j3) {
                Log.i(this.TAG, "onprogress cdntask end id:".concat(String.valueOf(str)));
                aVar.brr = true;
            }
        }
        AppMethodBeat.o(241126);
    }

    @Override // com.tencent.mm.i.g.b
    public final void b(String str, com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(241127);
        if (!(str == null || dVar == null)) {
            if (this.wKR.get(str) == null) {
                Log.e(this.TAG, "preload completed, but task not found, mediaId:".concat(String.valueOf(str)));
                AppMethodBeat.o(241127);
                return;
            }
            a aVar = this.wKR.get(str);
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
                AppMethodBeat.o(241127);
                throw tVar;
            }
            a aVar2 = aVar;
            Log.d(this.TAG, "cdntask end preload id:" + str + ", isplaymode:" + aVar2.wKV);
            aVar2.oJj = dVar.field_fileLength;
            aVar2.wKT = dVar.field_recvedBytes;
            aVar2.wKW = true;
            aVar2.wKU = false;
            this.wKR.put(str, aVar2);
            Log.i(this.TAG, "preload completed mediaId:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(241127);
    }

    @Override // com.tencent.mm.i.h.a
    public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
        a aVar;
        AppMethodBeat.i(241128);
        if (str == null || dVar == null) {
            Log.e(this.TAG, "onfinish but id not found:".concat(String.valueOf(str)));
        } else {
            if (this.wKR.get(str) == null) {
                aVar = new a();
            } else {
                a aVar2 = this.wKR.get(str);
                if (aVar2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.flutter.video.FlutterCdnDownloadMgr.FTVideoTaskInfo");
                    AppMethodBeat.o(241128);
                    throw tVar;
                }
                aVar = aVar2;
            }
            Log.d(this.TAG, "cdntask end id:" + str + ", isplaymode:" + aVar.wKV);
            aVar.cacheSize = dVar.field_fileLength;
            aVar.oJj = dVar.field_fileLength;
            aVar.brr = true;
            this.wKR.put(str, aVar);
            this.wKQ = null;
        }
        a aVar3 = this.wKR.get(str);
        if (aVar3 != null) {
            aVar3.wKU = false;
            AppMethodBeat.o(241128);
            return;
        }
        AppMethodBeat.o(241128);
    }

    @Override // com.tencent.mm.i.g.a
    public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
        AppMethodBeat.i(241129);
        Log.d(this.TAG, "FVPlayer callback mediaId:" + str + ' ');
        AppMethodBeat.o(241129);
        return 0;
    }

    @Override // com.tencent.mm.i.g.a
    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        AppMethodBeat.i(241130);
        Log.d(this.TAG, "FVPlayer getCdnAuthInfo mediaId:".concat(String.valueOf(str)));
        AppMethodBeat.o(241130);
    }

    @Override // com.tencent.mm.i.g.a
    public final byte[] f(String str, byte[] bArr) {
        AppMethodBeat.i(241131);
        Log.d(this.TAG, "FVPlayer decodePrepareResponse mediaId:" + str + ' ');
        byte[] bArr2 = new byte[0];
        AppMethodBeat.o(241131);
        return bArr2;
    }
}
