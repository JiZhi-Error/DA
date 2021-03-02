package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.nio.charset.Charset;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'Bw\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J4\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0015\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "finderUsername", "", "finderDescObject", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "ticket", "Lcom/tencent/mm/protobuf/ByteString;", "tagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "visibilityMode", "", "visibilityList", "Ljava/util/LinkedList;", "visibilityRoomList", "visibilityUserList", "luckyMoneyChatroomList", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;ILjava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class e extends k<aqd> {
    private final String TAG;
    private final JSONObject ttQ;
    private final JSONObject tuL;
    private a ukC;
    private aqc ukD;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCreateLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveResp;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, aqd aqd);
    }

    public /* synthetic */ e(String str, FinderObjectDesc finderObjectDesc, axk axk, int i2, LinkedList linkedList, LinkedList linkedList2, LinkedList linkedList3, LinkedList linkedList4, a aVar, byte b2) {
        this(str, finderObjectDesc, axk, i2, linkedList, linkedList2, linkedList3, linkedList4, aVar);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246302);
        aqd aqd = (aqd) dpc;
        p.h(aqd, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            Log.i(this.TAG, "CgiFinderCreateLive result:" + g.bN(aqd));
        }
        this.ukC.a(i2, i3, str, aqd);
        AppMethodBeat.o(246302);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private e(String str, FinderObjectDesc finderObjectDesc, axk axk, int i2, LinkedList<String> linkedList, LinkedList<String> linkedList2, LinkedList<String> linkedList3, LinkedList<String> linkedList4, a aVar) {
        super((byte) 0);
        byte[] bArr;
        axk axk2;
        p.h(linkedList, "visibilityList");
        p.h(linkedList2, "visibilityRoomList");
        p.h(linkedList3, "visibilityUserList");
        p.h(linkedList4, "luckyMoneyChatroomList");
        p.h(aVar, "callback");
        AppMethodBeat.i(260509);
        this.TAG = "Finder.CgiFinderCreateLive";
        this.ukC = aVar;
        this.ukD = new aqc();
        this.ttQ = new JSONObject();
        this.tuL = new JSONObject();
        this.ukD.objectDesc = finderObjectDesc;
        this.ukD.LBZ = null;
        aqc aqc = this.ukD;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            Charset charset = d.UTF_8;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(260509);
                throw tVar;
            }
            bArr = str.getBytes(charset);
            p.g(bArr, "(this as java.lang.String).getBytes(charset)");
        } else {
            bArr = null;
        }
        aqc.clientId = sb.append(com.tencent.mm.b.g.getMessageDigest(bArr)).append('_').append(System.currentTimeMillis()).toString();
        this.ukD.finderUsername = str;
        aqc aqc2 = this.ukD;
        am amVar = am.tuw;
        aqc2.LAI = am.cXY();
        this.ukD.LCb = axk;
        this.ukD.LCc = i2;
        this.ukD.LCd = linkedList;
        this.ukD.Vix = linkedList2;
        this.ukD.Viw = linkedList4;
        this.ukD.Viy = linkedList3;
        this.tuL.put(ch.COL_USERNAME, str);
        this.tuL.put(ClientInfoTable.Columns.CLIENTID, this.ukD.clientId);
        d.a aVar2 = new d.a();
        aVar2.c(this.ukD);
        aqd aqd = new aqd();
        aqd.setBaseResponse(new BaseResponse());
        aqd.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(aqd);
        aVar2.MB("/cgi-bin/micromsg-bin/findercreatelive");
        aVar2.sG(3686);
        c(aVar2.aXF());
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("CgiFinderCreateLive init ").append(this.ukD.clientId).append(',').append(this.ukD.finderUsername).append(',').append(this.ukD.objectDesc).append(", tag:[");
        axk axk3 = this.ukD.LCb;
        StringBuilder append2 = append.append(axk3 != null ? axk3.qHk : null).append('-');
        axk axk4 = this.ukD.LCb;
        Log.i(str2, append2.append((axk4 == null || (axk2 = axk4.LHU) == null) ? null : axk2.qHk).append(']').append(", visibility_mode:").append(this.ukD.LCc).append(", usersize:").append(this.ukD.Viy.size()).append(", list size:").append(this.ukD.LCd.size()).append(", visible_chatroom_id_list:").append(this.ukD.Vix).append(", luckyMoneyChatroom:").append(this.ukD.Viw).toString());
        AppMethodBeat.o(260509);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final b cXS() {
        return b.Enable;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final JSONObject cXV() {
        return this.tuL;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.an
    public final JSONObject cXW() {
        return this.ttQ;
    }
}
