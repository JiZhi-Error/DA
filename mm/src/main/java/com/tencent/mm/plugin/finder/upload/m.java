package com.tencent.mm.plugin.finder.upload;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000b¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "resultThumbUrl", "getResultThumbUrl", "setResultThumbUrl", "(Ljava/lang/String;)V", "resultUrl", "getResultUrl", "setResultUrl", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "plugin-finder_release"})
public final class m extends c {
    final String TAG = "Finder.FinderUploadLiveCoverImageTask";
    public d hmq;
    private final String path;
    public String resultUrl = "";
    private final String userName;
    public String vTf = "";
    private final a vTg = new a(this);

    public m(String str, String str2) {
        p.h(str, "path");
        p.h(str2, "userName");
        AppMethodBeat.i(253118);
        this.path = str;
        this.userName = str2;
        AppMethodBeat.o(253118);
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        AppMethodBeat.i(253117);
        if (!s.YS(this.path)) {
            Log.d(this.TAG, "path " + this.path + " is not file");
            a(j.Fail);
            AppMethodBeat.o(253117);
            return;
        }
        g gVar = new g();
        gVar.gqy = this.vTg;
        gVar.field_mediaId = MD5Util.getMD5String(this.path);
        gVar.field_fullpath = this.path;
        f fVar = f.vSz;
        gVar.field_thumbpath = f.avU(this.path);
        gVar.field_talker = "";
        gVar.field_needStorage = true;
        gVar.field_fileType = CdnLogic.kMediaTypeAppImageStorage;
        gVar.field_appType = 251;
        gVar.field_bzScene = 2;
        gVar.gqC = 60;
        gVar.gqD = 300;
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        f.baQ().f(gVar);
        AppMethodBeat.o(253117);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderUploadLiveCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
    public static final class a implements g.a {
        final /* synthetic */ m vTh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(m mVar) {
            this.vTh = mVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            String str2;
            AppMethodBeat.i(253116);
            String str3 = this.vTh.TAG;
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i2);
            if (dVar == null || (str2 = dVar.toString()) == null) {
                str2 = BuildConfig.COMMAND;
            }
            objArr[2] = str2;
            Log.i(str3, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", objArr);
            if (i2 != 0) {
                Log.e(this.vTh.TAG, "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                if (i2 != -21005) {
                    this.vTh.a(j.Fail);
                }
                AppMethodBeat.o(253116);
            } else {
                if (!Util.isNullOrNil(str) && dVar != null) {
                    Log.i(this.vTh.TAG, "retCode %d, fileId %s, url %s", Integer.valueOf(dVar.field_retCode), dVar.field_fileId, dVar.field_fileUrl);
                    if (dVar.field_retCode != 0) {
                        this.vTh.a(j.Fail);
                    } else {
                        m mVar = this.vTh;
                        String str4 = dVar.field_fileUrl;
                        p.g(str4, "sceneResult.field_fileUrl");
                        p.h(str4, "<set-?>");
                        mVar.resultUrl = str4;
                        m mVar2 = this.vTh;
                        String str5 = dVar.field_thumbUrl;
                        p.g(str5, "sceneResult.field_thumbUrl");
                        p.h(str5, "<set-?>");
                        mVar2.vTf = str5;
                        this.vTh.hmq = dVar;
                        this.vTh.a(j.OK);
                    }
                }
                AppMethodBeat.o(253116);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        return this.path;
    }
}
