package com.tencent.mm.plugin.story.f.g;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.story.c.a.c;
import com.tencent.mm.plugin.story.f.g;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.plugin.story.i.j;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0002J.\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0005J\b\u0010'\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload;", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "mPath", "", "thumbPath", "callback", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;)V", "TAG", "cdnCallback", "com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1;", "cdnMediaType", "", ClientInfoTable.Columns.CLIENTID, "mMd5", ch.COL_POSTINFO, "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "sendScene", "st_new", "", "startTime", "useCdnTransClientId", "checkUpload", "", "doUpload", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/protocal/protobuf/MMSightExtInfo;", "onErrorServer", "", "errCode", "onPostScene", "url", "urlType", "thumbUrl", "thumbType", "meidiaId", "updateMd5Info", "updatePostInfo", "isOk", "plugin-story_release"})
public final class b implements g {
    private final j Fqr;
    private edu Fqw;
    private final a Fqx;
    final g.a Fqy;
    final String TAG;
    private String clientId;
    String iYT;
    private long jSo;
    private int jrO;
    private String lAl;
    private final String mPath;
    private final String thumbPath;

    public b(j jVar, String str, String str2, g.a aVar) {
        p.h(jVar, "storyInfo");
        p.h(str, "mPath");
        p.h(str2, "thumbPath");
        p.h(aVar, "callback");
        AppMethodBeat.i(119103);
        this.Fqr = jVar;
        this.mPath = str;
        this.thumbPath = str2;
        this.Fqy = aVar;
        this.clientId = "";
        this.lAl = "";
        this.Fqw = new edu();
        this.TAG = "MicroMsg.StorySightCdnUpload";
        this.Fqx = new a(this);
        this.jSo = cl.aWz();
        this.Fqw = this.Fqr.frI();
        String str3 = this.Fqw.izX;
        this.clientId = str3 == null ? "" : str3;
        String str4 = this.Fqw.md5;
        this.lAl = str4 == null ? "" : str4;
        if (Util.isNullOrNil(this.clientId)) {
            String sb = new StringBuilder().append(Util.currentTicks()).toString();
            Charset charset = d.UTF_8;
            if (sb == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(119103);
                throw tVar;
            }
            byte[] bytes = sb.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            this.clientId = com.tencent.mm.b.g.getMessageDigest(bytes);
            this.Fqw.izX = this.clientId;
            try {
                j jVar2 = this.Fqr;
                byte[] byteArray = this.Fqw.toByteArray();
                p.g(byteArray, "postinfo.toByteArray()");
                jVar2.setPostBuf(byteArray);
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.foc().a((int) this.Fqr.systemRowid, this.Fqr);
            } catch (Exception e2) {
                Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            }
        }
        Log.i(this.TAG, "storyUpload  videopath %s sightFileSize %d md5 %s", this.mPath, Integer.valueOf((int) s.boW(this.mPath)), this.lAl);
        AppMethodBeat.o(119103);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/story/model/upload/StorySightCdnUpload$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    public static final class a implements g.a {
        final /* synthetic */ b Fqz;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(b bVar) {
            this.Fqz = bVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, com.tencent.mm.i.d dVar, boolean z) {
            AppMethodBeat.i(119097);
            p.h(str, "mediaId");
            if (i2 == -21005) {
                Log.d(this.Fqz.TAG, "cdntra cdnCallback1 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.Fqz.iYT, Integer.valueOf(i2), cVar, dVar);
                this.Fqz.Fqy.a(0, true, this.Fqz);
                AppMethodBeat.o(119097);
            } else if (dVar != null && dVar.field_retCode == 0) {
                Log.i(this.Fqz.TAG, "cdntra cdnCallback2 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.Fqz.iYT, Integer.valueOf(i2), cVar, dVar);
                b bVar = this.Fqz;
                String str2 = dVar.field_fileUrl;
                p.g(str2, "sceneResult.field_fileUrl");
                a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
                int i3 = com.tencent.mm.plugin.story.i.a.FuS;
                String str3 = dVar.field_thumbUrl;
                p.g(str3, "sceneResult.field_thumbUrl");
                a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                int i4 = com.tencent.mm.plugin.story.i.a.FuS;
                StringBuilder sb = new StringBuilder("upload_ + ");
                String str4 = this.Fqz.iYT;
                if (str4 == null) {
                    str4 = BuildConfig.COMMAND;
                }
                bVar.b(str2, i3, str3, i4, sb.append(str4).toString());
                this.Fqz.Fqy.a(0, true, this.Fqz);
                AppMethodBeat.o(119097);
            } else if (dVar != null && dVar.field_retCode != 0) {
                Log.i(this.Fqz.TAG, "cdntra cdnCallback3 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.Fqz.iYT, Integer.valueOf(i2), cVar, dVar);
                this.Fqz.fpt();
                this.Fqz.Fqy.a(dVar.field_retCode, false, this.Fqz);
                AppMethodBeat.o(119097);
            } else if (i2 != 0) {
                Log.i(this.Fqz.TAG, "cdntra cdnCallback4 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.Fqz.iYT, Integer.valueOf(i2), cVar, dVar);
                this.Fqz.fpt();
                this.Fqz.Fqy.a(i2, false, this.Fqz);
                AppMethodBeat.o(119097);
            } else {
                Log.d(this.Fqz.TAG, "cdntra cdnCallback5 clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.Fqz.iYT, Integer.valueOf(i2), cVar, dVar);
                AppMethodBeat.o(119097);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(119098);
            p.h(str, "mediaId");
            p.h(byteArrayOutputStream, "buff");
            AppMethodBeat.o(119098);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            AppMethodBeat.i(119099);
            p.h(str, "mediaId");
            p.h(bArr, "inbuf");
            AppMethodBeat.o(119099);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void fpt() {
        AppMethodBeat.i(119100);
        Log.i(this.TAG, "snsupload sight by cdn error! " + Util.getStack());
        try {
            this.Fqw.ibG++;
            edu edu = this.Fqw;
            a.g gVar = a.g.FvU;
            edu.Mpa = a.g.frt();
            com.tencent.mm.plugin.story.i.j jVar = this.Fqr;
            byte[] byteArray = this.Fqw.toByteArray();
            p.g(byteArray, "postinfo.toByteArray()");
            jVar.setPostBuf(byteArray);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().a((int) this.Fqr.systemRowid, this.Fqr);
            AppMethodBeat.o(119100);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            AppMethodBeat.o(119100);
        }
    }

    public final boolean b(String str, int i2, String str2, int i3, String str3) {
        AppMethodBeat.i(119101);
        p.h(str, "url");
        p.h(str2, "thumbUrl");
        p.h(str3, "meidiaId");
        Log.d(this.TAG, "upload ok " + str + "  " + str3 + "  " + i2);
        edu edu = this.Fqw;
        a.g gVar = a.g.FvU;
        edu.Mpa = a.g.frs();
        this.Fqw.ibG = 0;
        this.Fqw.MsZ = (long) cl.aWB();
        com.tencent.mm.plugin.story.i.j jVar = this.Fqr;
        byte[] byteArray = this.Fqw.toByteArray();
        p.g(byteArray, "postinfo.toByteArray()");
        jVar.setPostBuf(byteArray);
        edt edt = this.Fqr.frG().NeB.LoV.get(0);
        edt.Url = str;
        edt.oUv = i2;
        edt.Msz = str2;
        edt.oUv = i3;
        f.baR();
        edt.MsS = com.tencent.mm.an.a.NX(this.mPath);
        Log.i(this.TAG, "mediaObj.videomd5 " + edt.MsS);
        eek frG = this.Fqr.frG();
        frG.NeB.LoV.set(0, edt);
        this.Fqr.b(frG);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foc().a((int) this.Fqr.systemRowid, this.Fqr);
        AppMethodBeat.o(119101);
        return true;
    }

    public final boolean fpu() {
        int i2;
        AppMethodBeat.i(119102);
        String bhK = s.bhK(this.mPath);
        if (Util.isNullOrNil(this.lAl) || !(!p.j(this.lAl, bhK))) {
            cly cly = new cly();
            Log.i(this.TAG, "check upload %s %d %s", this.mPath, Integer.valueOf(cly.vUh), Boolean.valueOf(cly.Mrn));
            com.tencent.mm.plugin.sight.base.a aNx = e.aNx(this.mPath);
            if (aNx != null) {
                Log.i(this.TAG, "mediaInfo: %s", aNx);
            }
            if ((this.Fqw.Nee & 1) == 0) {
                SightVideoJNI.optimizeMP4VFS(this.mPath);
            }
            try {
                String bhK2 = s.bhK(this.mPath);
                p.g(bhK2, "VFSFileOp.getFileMD5String(mPath)");
                this.lAl = bhK2;
                this.Fqw.md5 = this.lAl;
                this.Fqw.Nee |= 1;
                com.tencent.mm.plugin.story.i.j jVar = this.Fqr;
                byte[] byteArray = this.Fqw.toByteArray();
                p.g(byteArray, "postinfo.toByteArray()");
                jVar.setPostBuf(byteArray);
                Log.i(this.TAG, "new md5 is %s %s", this.mPath, this.lAl);
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.foc().a((int) this.Fqr.systemRowid, this.Fqr);
            } catch (Exception e2) {
                Log.e(this.TAG, "parseFrom MediaUploadInfo error in updateMd5Info %s", e2.getMessage());
            }
            this.iYT = this.clientId;
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.taskName = "task_StorySightCdnUpload";
            gVar.gqy = this.Fqx;
            gVar.field_mediaId = this.iYT;
            gVar.field_fullpath = this.mPath;
            gVar.field_thumbpath = this.thumbPath;
            gVar.field_fileType = CdnLogic.kMediaTypeAppVideo;
            gVar.field_talker = "";
            gVar.field_priority = com.tencent.mm.i.a.gpM;
            gVar.field_needStorage = true;
            gVar.field_isStreamMedia = false;
            gVar.field_appType = 205;
            gVar.field_bzScene = 2;
            c.a aVar = (c.a) com.tencent.mm.plugin.story.c.a.c.FkZ.aLT();
            if (aVar != null) {
                Log.i(this.TAG, "StoryEncodeElementConfig " + aVar.duration);
                gVar.field_largesvideo = aVar.duration + 3;
            } else {
                gVar.field_largesvideo = 18;
            }
            gVar.gqP = 6;
            String bhK3 = s.bhK(this.mPath);
            if (Util.isNullOrNil(this.lAl) || !(!p.j(this.lAl, bhK3))) {
                Log.d(this.TAG, "will addSendTask");
                if (!f.baQ().f(gVar)) {
                    Log.e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.iYT);
                    this.Fqy.a(-3, false, this);
                    AppMethodBeat.o(119102);
                    return false;
                }
                if (cly.Mrn) {
                    i2 = 4;
                } else {
                    i2 = 5;
                }
                this.jrO = i2;
                AppMethodBeat.o(119102);
                return true;
            }
            Log.i(this.TAG, "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.lAl, bhK3);
            fpt();
            this.Fqy.a(-2, false, this);
            AppMethodBeat.o(119102);
            return false;
        }
        Log.i(this.TAG, "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.lAl, bhK);
        fpt();
        this.Fqy.a(-2, false, this);
        AppMethodBeat.o(119102);
        return false;
    }
}
