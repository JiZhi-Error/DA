package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019BU\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0002J\u001a\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u001a\u0010(\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0002J \u0010,\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0002J\b\u00100\u001a\u00020!H\u0002J\b\u00101\u001a\u000202H\u0016J4\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u00022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0011\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "micFinderUsername", "micObjectId", "", "micLiveId", "timeout", "", "requestId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;Ljava/lang/String;JJIJLcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "getFinderBaseRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareRequest;", "requestExt", "Lorg/json/JSONObject;", "getRequestId", "()J", "resultExt", "getTimeout", "()I", "actionExt", "addDebugData", "", "resp", "dumpFinderObject", "sb", "Ljava/lang/StringBuilder;", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "dumpFinderRecoverLiveInfo", "recoverLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderRecoverLiveInfo;", "dumpResp", "dumpVisibilityFileList", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "initReqResp", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class s extends k<aqb> {
    private final String TAG;
    private final int timeout;
    private final JSONObject ttQ;
    private final JSONObject tuL;
    private aqa ulh;
    private final aov uli;
    private final long ulj;
    private final a ulk;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "requestId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, String str, long j2, aqb aqb);
    }

    private s(aov aov, String str, long j2, a aVar) {
        super((byte) 0);
        AppMethodBeat.i(246336);
        this.uli = aov;
        this.timeout = 5000;
        this.ulj = j2;
        this.ulk = aVar;
        this.TAG = "Finder.CgiFinderLivePrepare";
        this.ulh = new aqa();
        this.ttQ = new JSONObject();
        this.tuL = new JSONObject();
        this.ulh.LBM = this.uli;
        this.ulh.LAt = str;
        this.ulh.LBN = null;
        this.ulh.LBO = 0;
        this.ulh.LBP = 0;
        this.tuL.put("mic_live_id", 0L);
        this.tuL.put("mic_object_id", 0L);
        this.ttQ.put(ch.COL_USERNAME, (Object) null);
        Log.i(this.TAG, "CgiFinderLivePrepare finderUsername " + str + " micFinderUsername " + ((String) null) + " micObjectId 0 micLiveId 0");
        d.a aVar2 = new d.a();
        aVar2.c(this.ulh);
        aqb aqb = new aqb();
        aqb.setBaseResponse(new BaseResponse());
        aqb.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(aqb);
        aVar2.MB("/cgi-bin/micromsg-bin/findercreateliveprepare");
        aVar2.sG(5874);
        c(aVar2.aXF());
        AppMethodBeat.o(246336);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        awe awe;
        AppMethodBeat.i(246333);
        aqb aqb = (aqb) dpc;
        p.h(aqb, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + ", maxUserCount:" + aqb.Viv + " thread=" + Thread.currentThread());
        a(aqb);
        StringBuilder sb = new StringBuilder();
        sb.append("[user_flag:" + aqb.KTQ + ", live_global_flag:" + aqb.LBS + ']');
        bbf bbf = aqb.LBT;
        if (bbf != null) {
            sb.append("[FinderRecoverLiveInfo.object_id:" + bbf.object_id + ", FinderRecoverLiveInfo.live_id:" + bbf.hyH + ']');
        }
        FinderObject finderObject = aqb.LBU;
        if (!(finderObject == null || (awe = finderObject.liveInfo) == null)) {
            sb.append("[finderObject.liveInfo.liveId:" + awe.liveId + ", finderObject.liveInfo.liveStatus:" + awe.liveStatus + ", finderObject.liveInfo.startTime:" + awe.dvv + ", finderObject.liveInfo.endTime:" + awe.iqg + ']');
        }
        a(sb, aqb.LBX);
        Log.i(this.TAG, String.valueOf(sb));
        a aVar = this.ulk;
        if (aVar != null) {
            aVar.a(i2, i3, str, this.ulj, aqb);
            AppMethodBeat.o(246333);
            return;
        }
        AppMethodBeat.o(246333);
    }

    public /* synthetic */ s(aov aov, String str, long j2, a aVar, byte b2) {
        this(aov, str, j2, aVar);
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

    private final void a(StringBuilder sb, LinkedList<avh> linkedList) {
        AppMethodBeat.i(246334);
        try {
            sb.append("VisibilityFileList:");
            if (linkedList != null) {
                for (T t : linkedList) {
                    sb.append("[" + t.title + ':' + t.KRd + ']');
                }
                AppMethodBeat.o(246334);
                return;
            }
            AppMethodBeat.o(246334);
        } catch (Exception e2) {
            y yVar = y.vXH;
            y.a(e2, this.TAG + ",dumpVisibilityFileList");
            AppMethodBeat.o(246334);
        }
    }

    private static void a(aqb aqb) {
        AppMethodBeat.i(246335);
        y yVar = y.vXH;
        if (y.dCM() && aqb.LBX.isEmpty()) {
            c cVar = c.vCb;
            if (c.dwm().value().intValue() == 1) {
                LinkedList<avh> linkedList = new LinkedList<>();
                for (int i2 = 0; i2 < 50; i2++) {
                    avh avh = new avh();
                    avh.KRd = "finder_debug_audien_file_".concat(String.valueOf(i2));
                    avh.title = "测试列表".concat(String.valueOf(i2));
                    linkedList.add(avh);
                }
                aqb.LBX = linkedList;
            }
        }
        AppMethodBeat.o(246335);
    }
}
