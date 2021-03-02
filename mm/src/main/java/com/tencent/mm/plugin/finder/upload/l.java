package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.bw.b;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.bx;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000*\u0001\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "path", "", "userName", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1;", "getPath", "()Ljava/lang/String;", "getUserName", "call", "", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "updateContact", "url", "succ", "", "plugin-finder_release"})
public final class l extends c {
    final String TAG = "Finder.FinderUploadCoverImageTask";
    private final String path;
    final String userName;
    private final a vTb = new a(this);

    public l(String str, String str2) {
        p.h(str, "path");
        p.h(str2, "userName");
        AppMethodBeat.i(167789);
        this.path = str;
        this.userName = str2;
        AppMethodBeat.o(167789);
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        AppMethodBeat.i(167788);
        if (!s.YS(this.path)) {
            Log.d(this.TAG, "path " + this.path + " is not file");
            a(j.Fail);
            AppMethodBeat.o(167788);
            return;
        }
        g gVar = new g();
        gVar.taskName = "task_FinderUploadCoverImageTask";
        gVar.gqy = this.vTb;
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
        AppMethodBeat.o(167788);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
    public static final class a implements g.a {
        final /* synthetic */ l vTc;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(l lVar) {
            this.vTc = lVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            String str2;
            AppMethodBeat.i(167787);
            String str3 = this.vTc.TAG;
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i2);
            if (dVar == null || (str2 = dVar.toString()) == null) {
                str2 = BuildConfig.COMMAND;
            }
            objArr[2] = str2;
            Log.i(str3, "on cdn callback mediaId = %s, startRet = %d, sceneResult %s", objArr);
            if (i2 != 0) {
                Log.e(this.vTc.TAG, "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                if (i2 != -21005) {
                    l.a(this.vTc, "", false);
                    this.vTc.a(j.Fail);
                }
                AppMethodBeat.o(167787);
            } else {
                if (!Util.isNullOrNil(str) && dVar != null) {
                    Log.i(this.vTc.TAG, "retCode %d, fileId %s, url %s", Integer.valueOf(dVar.field_retCode), dVar.field_fileId, dVar.field_fileUrl);
                    if (dVar.field_retCode != 0) {
                        l.a(this.vTc, "", false);
                        this.vTc.a(j.Fail);
                        AppMethodBeat.o(167787);
                    } else {
                        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                        if (c.a.asG(this.vTc.userName) != null) {
                            e aAh = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            aAh.azQ().set(ar.a.USERINFO_MY_FINDER_LOCAL_COVER_IMG_STRING_SYNC, dVar.field_fileUrl);
                            azg azg = new azg();
                            azg.coverImgUrl = dVar.field_fileUrl;
                            apf apf = new apf();
                            bx.a aVar2 = bx.tvW;
                            apf.cmdId = bx.tvL;
                            apf.LBo = b.cD(azg.toByteArray());
                            List listOf = kotlin.a.j.listOf(apf);
                            bx bxVar = new bx(this.vTc.userName, listOf);
                            com.tencent.mm.kernel.g.azz().a(3870, new C1310a(listOf, this, dVar));
                            com.tencent.mm.kernel.g.azz().b(bxVar);
                        }
                    }
                }
                AppMethodBeat.o(167787);
            }
            return 0;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderUploadCoverImageTask$cdnCallback$1$callback$1$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.upload.l$a$a  reason: collision with other inner class name */
        public static final class C1310a implements i {
            final /* synthetic */ d uJy;
            final /* synthetic */ List vTd;
            final /* synthetic */ a vTe;

            C1310a(List list, a aVar, d dVar) {
                this.vTd = list;
                this.vTe = aVar;
                this.uJy = dVar;
            }

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(167786);
                com.tencent.mm.kernel.g.azz().b(3870, this);
                Log.i(this.vTe.vTc.TAG, "errType " + i2 + " , errCode " + i3 + ", errMsg " + str);
                if (qVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderOplog");
                    AppMethodBeat.o(167786);
                    throw tVar;
                }
                List<apg> cYN = ((bx) qVar).cYN();
                List<apf> cYM = ((bx) qVar).cYM();
                if (i2 == 0 && i3 == 0 && p.j(this.vTd, cYM)) {
                    Iterator<apg> it = cYN.iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i4 = -1;
                            break;
                        }
                        apg next = it.next();
                        int i5 = next.cmdId;
                        bx.a aVar = bx.tvW;
                        if (i5 == bx.tvL && next.retCode == 0) {
                            break;
                        }
                        i4++;
                    }
                    if (i4 != -1) {
                        Log.i(this.vTe.vTc.TAG, "update coverImg succ");
                        l lVar = this.vTe.vTc;
                        String str2 = this.uJy.field_fileUrl;
                        p.g(str2, "sceneResult.field_fileUrl");
                        l.a(lVar, str2, true);
                        this.vTe.vTc.a(j.OK);
                        AppMethodBeat.o(167786);
                        return;
                    }
                    Log.i(this.vTe.vTc.TAG, "update coverImg failed");
                    l lVar2 = this.vTe.vTc;
                    String str3 = this.uJy.field_fileUrl;
                    p.g(str3, "sceneResult.field_fileUrl");
                    l.a(lVar2, str3, false);
                    this.vTe.vTc.a(j.Fail);
                }
                AppMethodBeat.o(167786);
            }
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

    public static final /* synthetic */ void a(l lVar, String str, boolean z) {
        AppMethodBeat.i(167790);
        Log.i(lVar.TAG, "updateContact " + str + ", " + z);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(lVar.userName);
        if (asG != null) {
            if (z) {
                e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_MY_FINDER_COVER_IMG_STRING_SYNC, str);
            }
            e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_LOCAL_COVER_IMG_STRING_SYNC, "");
            c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
            c.a.c(asG);
            AppMethodBeat.o(167790);
            return;
        }
        AppMethodBeat.o(167790);
    }
}
