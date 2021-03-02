package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bdw;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\b\u0010\u001d\u001a\u00020\u0006H\u0002J\u001c\u0010\u001e\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J\b\u0010 \u001a\u0004\u0018\u00010\u0004J\u0006\u0010!\u001a\u00020\u0006J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020$H\u0016J>\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010.\u001a\u00020\u0006H\u0014J\u0010\u0010/\u001a\u0002002\u0006\u0010+\u001a\u00020,H\u0014R\u0014\u0010\n\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "filePath", "", "scene", "", "fileMD5", "totalLen", "(Ljava/lang/String;ILjava/lang/String;I)V", "ERRCODE_CANNOT_READ_FILE", "getERRCODE_CANNOT_READ_FILE", "()I", "ERRCODE_REACH_RETRY_LIMIT", "getERRCODE_REACH_RETRY_LIMIT", "IMG_SLICE_LEN", "MAX_DO_SCENE_LIMIT", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFilePath", "()Ljava/lang/String;", "imgUrl", "readBuf", "", "getScene", "startPos", "doNextUpload", "doScene", "getFileMD5", "getImgUrl", "getTotalLen", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "plugin-finder_release"})
public final class cl extends ax implements m {
    public static final a twA = new a((byte) 0);
    private static final int twy = 1;
    private static final int twz = 2;
    private final String TAG;
    private int bNu;
    private i callback;
    private g dispatcher;
    public String fileMD5;
    private final String filePath;
    public int iKP;
    private final int scene;
    private byte[] tws;
    public String twt;
    private final int twu;
    private final int twv;
    private final int tww;
    private final int twx;

    public /* synthetic */ cl(String str, int i2) {
        this(str, i2, null, 0);
        AppMethodBeat.i(165286);
        AppMethodBeat.o(165286);
    }

    public cl(String str, int i2, String str2, int i3) {
        p.h(str, "filePath");
        AppMethodBeat.i(242520);
        this.filePath = str;
        this.scene = i2;
        this.fileMD5 = str2;
        this.iKP = i3;
        this.TAG = "Finder.NetSceneFinderUploadHeadImg";
        this.twu = 51200;
        this.twv = 20;
        this.tww = -40000;
        this.twx = -40001;
        Log.i(this.TAG, "filePath " + this.filePath + " and size: " + Util.getSizeKB(s.boW(this.filePath)) + " total:" + s.boW(this.filePath));
        AppMethodBeat.o(242520);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUploadHeadImg$Companion;", "", "()V", "UPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "", "getUPLOAD_FINDER_HEAD_IMG_SCENE_CREATE_CONTACT", "()I", "UPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "getUPLOAD_FINDER_HEAD_IMG_SCENE_UPDATE_CONTACT", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(165287);
        AppMethodBeat.o(165287);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return this.twv;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(165282);
        p.h(sVar, "rr");
        if (Util.isNullOrNil(this.filePath)) {
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(165282);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(165282);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3759;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165283);
        if (Util.isNullOrNil(this.fileMD5)) {
            this.fileMD5 = s.bhK(this.filePath);
            this.iKP = (int) s.boW(this.filePath);
            Log.i(this.TAG, "upload img file path:" + this.filePath + " totalLen:" + this.iKP + " md5:" + this.fileMD5);
        }
        this.callback = iVar;
        this.dispatcher = gVar;
        int cZg = cZg();
        AppMethodBeat.o(165283);
        return cZg;
    }

    private final int cZg() {
        i iVar;
        AppMethodBeat.i(165284);
        d.a aVar = new d.a();
        aVar.MB("/cgi-bin/micromsg-bin/finderuploadheadimg");
        aVar.sG(getType());
        bdw bdw = new bdw();
        bdw.scene = this.scene;
        bdw.bNu = this.bNu;
        bdw.iKP = this.iKP;
        bdw.LNB = this.fileMD5;
        this.tws = s.aW(this.filePath, this.bNu, this.twu);
        if (this.tws == null) {
            i iVar2 = this.callback;
            if (iVar2 != null) {
                iVar2.onSceneEnd(3, this.twx, "", this);
            }
            AppMethodBeat.o(165284);
            return -1;
        }
        byte[] bArr = this.tws;
        byte[] bArr2 = this.tws;
        bdw.LrK = b.Q(bArr, 0, bArr2 != null ? bArr2.length : 0);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("next upload start:").append(this.bNu).append(", len:");
        byte[] bArr3 = this.tws;
        Log.i(str, append.append(bArr3 != null ? Integer.valueOf(bArr3.length) : null).toString());
        am amVar = am.tuw;
        bdw.uli = am.cXY();
        aVar.c(bdw);
        aVar.d(new bdx());
        int dispatch = dispatch(this.dispatcher, aVar.aXF(), this);
        if (dispatch == -1 && (iVar = this.callback) != null) {
            iVar.onSceneEnd(3, this.tww, "", this);
        }
        AppMethodBeat.o(165284);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar) {
        AppMethodBeat.i(242519);
        Log.i(this.TAG, "errType " + i3 + " errCode " + i4 + " errMsg " + str);
        if (i3 != 0 || i4 != 0) {
            i iVar = this.callback;
            if (iVar != null) {
                iVar.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(242519);
                return;
            }
            AppMethodBeat.o(242519);
        } else if (sVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
            AppMethodBeat.o(242519);
            throw tVar;
        } else {
            com.tencent.mm.bw.a aYK = ((d) sVar).aYK();
            if (aYK == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUploadHeadImgResponse");
                AppMethodBeat.o(242519);
                throw tVar2;
            }
            bdx bdx = (bdx) aYK;
            if (bdx.completed) {
                this.twt = bdx.twt;
                Log.i(this.TAG, "upload completed " + this.twt);
                i iVar2 = this.callback;
                if (iVar2 != null) {
                    iVar2.onSceneEnd(i3, i4, str, this);
                    AppMethodBeat.o(242519);
                    return;
                }
                AppMethodBeat.o(242519);
                return;
            }
            this.bNu = bdx.bNu;
            cZg();
            AppMethodBeat.o(242519);
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final com.tencent.mm.plugin.finder.cgi.report.b cXS() {
        return com.tencent.mm.plugin.finder.cgi.report.b.Enable;
    }
}
