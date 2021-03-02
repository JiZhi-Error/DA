package com.tencent.mm.plugin.finder.upload;

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

@l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "(Ljava/lang/String;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1;", "coverUrl", "getCoverUrl", "()Ljava/lang/String;", "setCoverUrl", "getPath", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "Companion", "plugin-finder_release"})
public final class k extends c {
    public static final a vSZ = new a((byte) 0);
    public String coverUrl = "";
    private final String path;
    private final b vSY = new b(this);

    static {
        AppMethodBeat.i(253114);
        AppMethodBeat.o(253114);
    }

    public k(String str) {
        p.h(str, "path");
        AppMethodBeat.i(253113);
        this.path = str;
        AppMethodBeat.o(253113);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        AppMethodBeat.i(253112);
        this.coverUrl = "";
        if (!s.YS(this.path)) {
            Log.d("Finder.UploadActivityCoverTask", "path " + this.path + " is not file");
            a(j.Fail);
            AppMethodBeat.o(253112);
            return;
        }
        g gVar = new g();
        gVar.taskName = "task_FinderUploadCoverImageTask";
        gVar.gqy = this.vSY;
        gVar.field_mediaId = MD5Util.getMD5String(this.path);
        gVar.field_fullpath = this.path;
        f fVar = f.vSz;
        gVar.field_thumbpath = f.avU(this.path);
        gVar.field_talker = "";
        gVar.field_needStorage = true;
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FRIENDS;
        gVar.field_appType = 100;
        gVar.field_bzScene = 1;
        gVar.gqC = 60;
        gVar.gqD = 300;
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        f.baQ().f(gVar);
        AppMethodBeat.o(253112);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        return this.path;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderUploadActivityCoverTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
    public static final class b implements g.a {
        final /* synthetic */ k vTa;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(k kVar) {
            this.vTa = kVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            String str2;
            AppMethodBeat.i(253111);
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i2);
            if (dVar == null || (str2 = dVar.toString()) == null) {
                str2 = BuildConfig.COMMAND;
            }
            objArr[2] = str2;
            Log.i("Finder.UploadActivityCoverTask", "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", objArr);
            if (i2 != 0) {
                Log.e("Finder.UploadActivityCoverTask", "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                if (i2 != -21005) {
                    k.a(this.vTa, j.Fail);
                }
                AppMethodBeat.o(253111);
            } else {
                if (!Util.isNullOrNil(str) && dVar != null) {
                    Log.i("Finder.UploadActivityCoverTask", "retCode %d, fileId %s, url %s", Integer.valueOf(dVar.field_retCode), dVar.field_fileId, dVar.field_fileUrl);
                    if (dVar.field_retCode != 0) {
                        k.a(this.vTa, j.Fail);
                        AppMethodBeat.o(253111);
                    } else {
                        k kVar = this.vTa;
                        String str3 = dVar.field_fileUrl;
                        p.g(str3, "sceneResult.field_fileUrl");
                        p.h(str3, "<set-?>");
                        kVar.coverUrl = str3;
                        k.a(this.vTa, j.OK);
                    }
                }
                AppMethodBeat.o(253111);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    }

    public static final /* synthetic */ void a(k kVar, j jVar) {
        AppMethodBeat.i(253115);
        kVar.a(jVar);
        AppMethodBeat.o(253115);
    }
}
