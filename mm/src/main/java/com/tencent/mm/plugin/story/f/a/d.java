package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.o.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.protocal.protobuf.edl;
import com.tencent.mm.protocal.protobuf.edm;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u001a\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J>\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000e¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userName", "", "maxId", "", FFmpegMetadataRetriever.METADATA_KEY_DATE, "(Ljava/lang/String;JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "forSameMd5Count", "", "fp", "", "getFp", "()Z", "setFp", "(Z)V", "getMaxId", "()J", "setMaxId", "(J)V", "minId", "getMinId", "setMinId", "originMaxId", "recentLimitID", "getRecentLimitID", "setRecentLimitID", "requestMd5", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "sourceType", "getUserName", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "insertList", "", "resp", "Lcom/tencent/mm/protocal/protobuf/StoryDateDetailResponse;", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class d extends q implements m {
    public static final a FnE = new a((byte) 0);
    private static final String TAG = TAG;
    private String BrH;
    private String DIL;
    private boolean DIe;
    private long DIf = 0;
    private long DIg;
    private long DJB;
    private long FnD;
    private i callback;
    private com.tencent.mm.ak.d rr;
    private int sourceType;
    public String userName;

    public d(String str, String str2) {
        edl edl;
        int i2;
        boolean z = false;
        p.h(str, "userName");
        p.h(str2, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        AppMethodBeat.i(118806);
        this.userName = str;
        this.BrH = str2;
        this.DIL = "";
        if (this.DIf == 0) {
            Log.i(TAG, "fp mUserName " + this.userName);
        } else {
            Log.i(TAG, "np mUserName " + this.userName);
        }
        a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
        this.sourceType = com.tencent.mm.plugin.story.i.a.FuJ;
        d.a aVar2 = new d.a();
        aVar2.c(new edl());
        aVar2.d(new edm());
        aVar2.MB("/cgi-bin/micromsg-bin/mmstorydatedetail");
        aVar2.sG(f.CTRL_INDEX);
        aVar2.sI(0);
        aVar2.sJ(0);
        com.tencent.mm.ak.d aXF = aVar2.aXF();
        p.g(aXF, "builder.buildInstance()");
        this.rr = aXF;
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailRequest");
            AppMethodBeat.o(118806);
            throw tVar;
        }
        edl edl2 = (edl) aYJ;
        edl2.UserName = this.userName;
        edl2.MZh = this.DIf;
        try {
            String timeZoneOffset = Util.getTimeZoneOffset();
            p.g(timeZoneOffset, "Util.getTimeZoneOffset()");
            i2 = (int) Float.parseFloat(timeZoneOffset);
            edl = edl2;
        } catch (Exception e2) {
            edl = edl2;
            i2 = 0;
        }
        edl.rBY = i2;
        edl2.Lrr = this.BrH;
        this.DIe = this.DIf == 0 ? true : z;
        this.FnD = this.DIf;
        Log.i(TAG, "req.mUserName:" + edl2.UserName + " req.MaxId:" + edl2.MZh + " req.TimeZone:" + edl2.rBY + " req.Date:" + edl2.Lrr);
        AppMethodBeat.o(118806);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryDateDetail$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118807);
        AppMethodBeat.o(118807);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return f.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(118804);
        p.h(iVar, "callback");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(118804);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(118805);
        Log.d(TAG, "netId=" + i2 + " errType=" + i3 + " errCode=" + i4 + " errMsg=" + str);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryDateDetailResponse");
            AppMethodBeat.o(118805);
            throw tVar;
        }
        edm edm = (edm) aYK;
        this.DJB = edm.NdN;
        Log.i(TAG, "objCount: " + edm.Ndu + ", expiredTime: " + edm.KCC);
        if (edm.NdM.isEmpty()) {
            Log.d(TAG, "error: server give size zero");
            i iVar = this.callback;
            if (iVar == null) {
                p.btv("callback");
            }
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(118805);
            return;
        }
        n.a aVar = n.FmM;
        n.a.b(this.userName, edm.NdM, this.sourceType);
        if (this.DIf == 0) {
            LinkedList<eea> linkedList = edm.NdM;
            p.g(linkedList, "resp.StoryList");
            this.DIf = linkedList.getFirst().Id;
        }
        Log.i(TAG, "insertList mUserName %s maxId %s minId %s", this.userName, Long.valueOf(this.DIf), Long.valueOf(this.DIg));
        i iVar2 = this.callback;
        if (iVar2 == null) {
            p.btv("callback");
        }
        iVar2.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(118805);
    }
}
