package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J4\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0017\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "liveCookies", "", "liveId", "", "objectId", "nonceId", "scene", "", "offline", "", "clientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "reqVisitorRoleType", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;[BJJLjava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;ILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;)V", "TAG", "getReqVisitorRoleType", "()I", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class h extends k<ass> {
    private final String TAG;
    private final int UKR;
    private a ukI;
    private asr ukJ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveMsg$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "reqVisitorRoleType", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, ass ass, int i4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(aov aov, String str, byte[] bArr, long j2, long j3, String str2, int i2, boolean z, avk avk, int i3, a aVar) {
        super((byte) 0);
        boolean z2;
        p.h(aov, "finderBaseRequest");
        p.h(str2, "nonceId");
        p.h(aVar, "callback");
        AppMethodBeat.i(260510);
        this.UKR = i3;
        this.TAG = "Finder.CgiFinderGetLiveMsg";
        this.ukI = aVar;
        this.ukJ = new asr();
        this.ukJ.LAI = aov;
        this.ukJ.finderUsername = str;
        this.ukJ.LDx = b.cD(bArr);
        this.ukJ.liveId = j2;
        this.ukJ.hFK = j3;
        this.ukJ.object_nonce_id = str2;
        this.ukJ.scene = i2;
        this.ukJ.AqQ = z;
        this.ukJ.LDy = avk;
        d.a aVar2 = new d.a();
        aVar2.c(this.ukJ);
        ass ass = new ass();
        ass.setBaseResponse(new BaseResponse());
        ass.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(ass);
        aVar2.MB("/cgi-bin/micromsg-bin/findergetlivemsg");
        aVar2.sG(3976);
        aVar2.aYL();
        aVar2.aYM();
        c(aVar2.aXF());
        String str3 = this.TAG;
        StringBuilder append = new StringBuilder("CgiFinderGetLiveMsg init ").append(this.ukJ.liveId).append(',').append(this.ukJ.finderUsername).append(',').append(this.ukJ.scene).append(",liveCookies is null:");
        if (this.ukJ.LDx == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i(str3, append.append(z2).append(",reqVisitorRoleType:").append(this.UKR).toString());
        AppMethodBeat.o(260510);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(aov aov, String str, byte[] bArr, long j2, long j3, String str2, int i2, boolean z, avk avk, int i3, a aVar, int i4) {
        this(aov, str, bArr, j2, j3, str2, i2, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? null : avk, i3, aVar);
        AppMethodBeat.i(260511);
        AppMethodBeat.o(260511);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        Long l;
        Integer num = null;
        AppMethodBeat.i(246311);
        ass ass = (ass) dpc;
        p.h(ass, "resp");
        if (i2 == 0 && i3 == 0) {
            String str2 = this.TAG;
            StringBuilder append = new StringBuilder("[onCgiBack] errType=").append(i2).append(" errCode=").append(i3).append(" errMsg=").append(str).append(' ').append("resp curOnlineCount:").append(ass.LDA).append(" cur_participant_count:").append(ass.LDH).append(" liveInfoEnableFlag:").append(ass.LDB).append(' ').append("liveCloseFlag:").append(ass.LDC).append(" live_ext_flag:").append(ass.LDF).append(" id: ");
            awe awe = ass.liveInfo;
            if (awe != null) {
                l = Long.valueOf(awe.liveId);
            } else {
                l = null;
            }
            StringBuilder append2 = append.append(l).append(' ');
            awe awe2 = ass.liveInfo;
            StringBuilder append3 = append2.append(awe2 != null ? Integer.valueOf(awe2.liveStatus) : null).append(" msg:");
            LinkedList<awq> linkedList = ass.FoQ;
            if (linkedList != null) {
                num = Integer.valueOf(linkedList.size());
            }
            Log.i(str2, append3.append(num).toString());
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(this.ukO, 22);
        } else {
            Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
            com.tencent.mm.plugin.report.service.h.INSTANCE.F(this.ukO, 23);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.F(this.ukO, 21);
        this.ukI.a(i2, i3, ass, this.UKR);
        AppMethodBeat.o(246311);
    }
}
