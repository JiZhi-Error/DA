package com.tencent.mm.plugin.finder.live.model.cgi;

import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fBI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0016\u001a\u00020\u0017H\u0002J4\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0011\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "liveId", "", "commentContent", "", "liveMsgType", "", "liveCookies", "", "objectId", "nonceId", "finderUsername", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "(JLjava/lang/String;I[BJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;)V", "TAG", "getCommentContent", "()Ljava/lang/String;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class l extends k<bap> {
    private final String TAG = "Finder.CgiFinderLiveCommentPost";
    private a ukP;
    private bao ukQ;
    private final String ukR;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCommentPost$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveMsgResp;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, bap bap);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(long j2, String str, int i2, byte[] bArr, long j3, String str2, String str3, a aVar) {
        super((byte) 0);
        Integer num;
        boolean z;
        p.h(str, "commentContent");
        p.h(str2, "nonceId");
        p.h(str3, "finderUsername");
        AppMethodBeat.i(260517);
        this.ukR = str;
        this.ukP = aVar;
        this.ukQ = new bao();
        bao bao = this.ukQ;
        am amVar = am.tuw;
        bao.LAI = am.cXY();
        this.ukQ.liveId = j2;
        this.ukQ.hFK = j3;
        bao bao2 = this.ukQ;
        y yVar = y.vXH;
        bao2.fQY = y.dCV();
        this.ukQ.LDx = b.cD(bArr);
        bao bao3 = this.ukQ;
        awq awq = new awq();
        awq.content = this.ukR;
        awq.nickname = z.aUa();
        awq.type = i2;
        bao3.uke = awq;
        this.ukQ.object_nonce_id = str2;
        this.ukQ.LAt = str3;
        d.a aVar2 = new d.a();
        aVar2.c(this.ukQ);
        bap bap = new bap();
        bap.setBaseResponse(new BaseResponse());
        bap.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(bap);
        aVar2.MB("/cgi-bin/micromsg-bin/finderpostlivemsg");
        aVar2.sG(3896);
        c(aVar2.aXF());
        String str4 = this.TAG;
        StringBuilder append = new StringBuilder("CgiFinderLiveCommentPost init ").append(this.ukQ.liveId).append(",msgId:").append(this.ukQ.fQY).append(',').append(z.aUa()).append(',').append(this.ukR).append(",live_identity:");
        aov aov = this.ukQ.LAI;
        if (aov != null) {
            num = Integer.valueOf(aov.Viq);
        } else {
            num = null;
        }
        StringBuilder append2 = append.append(num).append(",nonceId is empty?:");
        String str5 = this.ukQ.object_nonce_id;
        if (str5 == null || str5.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        Log.i(str4, append2.append(z).append(",finder_username:").append(this.ukQ.LAt).toString());
        AppMethodBeat.o(260517);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246318);
        bap bap = (bap) dpc;
        p.h(bap, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i3 == -200024 && (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE)) {
            Toast.makeText(MMApplicationContext.getContext(), "已被安全拦截", 0).show();
        }
        a aVar = this.ukP;
        if (aVar != null) {
            aVar.a(i2, i3, str, bap);
            AppMethodBeat.o(246318);
            return;
        }
        AppMethodBeat.o(246318);
    }
}
