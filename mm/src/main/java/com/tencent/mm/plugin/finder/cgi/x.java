package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.patmsg.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.avd;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB{\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012d\u0010\u0007\u001a`\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b¢\u0006\u0002\u0010\u0012J\b\u0010\u001a\u001a\u00020\u0011H\u0002J4\u0010\u001b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0013\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000Rx\u0010\u0007\u001a`\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderPostLiveAppMsg;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "roomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "callBack", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "resp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;Lkotlin/jvm/functions/Function4;)V", "TAG", "getCallBack", "()Lkotlin/jvm/functions/Function4;", "setCallBack", "(Lkotlin/jvm/functions/Function4;)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgRequest;", "initReqResp", "onCgiEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class x extends an<ban> {
    public static final a ttF = new a((byte) 0);
    private final String TAG = "Finder.CgiFinderPostLiveAppMsg";
    private bam ttD = new bam();
    private r<? super Integer, ? super Integer, ? super String, ? super ban, kotlin.x> ttE;

    static {
        AppMethodBeat.i(242254);
        AppMethodBeat.o(242254);
    }

    public x(aut aut, g gVar, r<? super Integer, ? super Integer, ? super String, ? super ban, kotlin.x> rVar) {
        int aFW;
        Integer num;
        p.h(aut, "appMsg");
        p.h(gVar, "roomData");
        AppMethodBeat.i(242253);
        this.ttE = rVar;
        this.ttD.LFp = b.cD(gVar.hIt);
        this.ttD.uio = aut;
        this.ttD.hyH = gVar.liveInfo.liveId;
        this.ttD.object_id = gVar.hFK;
        this.ttD.object_nonce_id = gVar.hwg;
        bam bam = this.ttD;
        m mVar = m.vVH;
        if (m.dBP()) {
            o.m mVar2 = o.m.hHB;
            aFW = o.m.aFV();
        } else {
            b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                o.m mVar3 = o.m.hHB;
                aFW = o.m.aFW();
            } else {
                o.m mVar4 = o.m.hHB;
                aFW = o.m.aFW();
            }
        }
        bam.scene = aFW;
        this.ttD.LAt = z.aUg();
        bam bam2 = this.ttD;
        am amVar = am.tuw;
        bam2.LAI = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.ttD);
        ban ban = new ban();
        ban.setBaseResponse(new BaseResponse());
        ban.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(ban);
        aVar2.MB("/cgi-bin/micromsg-bin/finderpostliveappmsg");
        aVar2.sG(6888);
        c(aVar2.aXF());
        String str = this.TAG;
        StringBuilder append = new StringBuilder("CgiFinderPostLiveAppMsg init ").append(this.ttD.hyH).append(",msgType ");
        aut aut2 = this.ttD.uio;
        if (aut2 != null) {
            num = Integer.valueOf(aut2.ybm);
        } else {
            num = null;
        }
        Log.i(str, append.append(num).toString());
        AppMethodBeat.o(242253);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, ban ban, q qVar) {
        AppMethodBeat.i(242252);
        ban ban2 = ban;
        p.h(ban2, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        r<? super Integer, ? super Integer, ? super String, ? super ban, kotlin.x> rVar = this.ttE;
        if (rVar != null) {
            rVar.invoke(Integer.valueOf(i2), Integer.valueOf(i3), str, ban2);
            AppMethodBeat.o(242252);
            return;
        }
        AppMethodBeat.o(242252);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderPostLiveAppMsg$Companion;", "", "()V", "genComplaintMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "genReplyCommentMsg", "atUser", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "replyContent", "", "getHighlightCheerMsg", "getTickleMsg", "tickleUser", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static aut a(awq awq) {
            AppMethodBeat.i(260180);
            p.h(awq, "msg");
            aut aut = new aut();
            aut.LFA = awq.seq;
            aut.ybm = 20008;
            AppMethodBeat.o(260180);
            return aut;
        }

        public static aut a(avn avn, String str) {
            AppMethodBeat.i(242251);
            p.h(avn, "atUser");
            p.h(str, "replyContent");
            aut aut = new aut();
            aut.LFz = avn;
            avb avb = new avb();
            avb.content = str;
            aut.LFB = com.tencent.mm.bw.b.cD(avb.toByteArray());
            aut.ybm = 20002;
            aut.LFr = z.aTY() + System.currentTimeMillis();
            AppMethodBeat.o(242251);
            return aut;
        }

        public static aut a(avn avn) {
            String str;
            AppMethodBeat.i(260181);
            p.h(avn, "tickleUser");
            aut aut = new aut();
            aut.LFz = avn;
            avd avd = new avd();
            FinderContact finderContact = avn.contact;
            if (finderContact == null || (str = finderContact.username) == null) {
                str = "";
            }
            avd.LFU = c.aJL(str);
            aut.LFB = com.tencent.mm.bw.b.cD(avd.toByteArray());
            aut.ybm = 20001;
            aut.LFr = z.aTY() + System.currentTimeMillis();
            AppMethodBeat.o(260181);
            return aut;
        }
    }
}
