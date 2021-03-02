package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0016J\"\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004J\b\u0010(\u001a\u00020\u0016H\u0002J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "", "()V", "TAG", "", "commentExposureMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/CommentExposure;", "Lkotlin/collections/HashMap;", "getCommentExposureMap", "()Ljava/util/HashMap;", "setCommentExposureMap", "(Ljava/util/HashMap;)V", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "enterTimeInMs", "", "getEnterTimeInMs", "()J", "setEnterTimeInMs", "(J)V", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "logReportData", "kv", "", "onCommentExposure", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/BizComment;", "onDestroy", "report10380", "actionType", "sharePageType", IssueStorage.COLUMN_EXT_INFO, "report10945", "report17537", "eventType", "plugin-brandservice_release"})
public final class n {
    private final String TAG = "MicroMsg.MPDataReportHelper";
    public b pIL;
    public HashMap<String, acd> pLM = new HashMap<>();
    public long pLN = System.currentTimeMillis();

    public n() {
        AppMethodBeat.i(7332);
        AppMethodBeat.o(7332);
    }

    public final void aL(int i2, String str) {
        AppMethodBeat.i(195988);
        fg fgVar = new fg();
        ff ffVar = new ff();
        ffVar.type = 2;
        b bVar = this.pIL;
        if (bVar == null) {
            p.btv("controller");
        }
        String str2 = bVar.vid;
        LinkedList<fi> linkedList = ffVar.KEQ;
        p.g(linkedList, "reportData.item");
        a("Vid", str2, linkedList);
        String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        LinkedList<fi> linkedList2 = ffVar.KEQ;
        p.g(linkedList2, "reportData.item");
        a("Network", formatedNetType, linkedList2);
        LinkedList<fi> linkedList3 = ffVar.KEQ;
        p.g(linkedList3, "reportData.item");
        a("SharePageType", "2", linkedList3);
        b bVar2 = this.pIL;
        if (bVar2 == null) {
            p.btv("controller");
        }
        String str3 = bVar2.url;
        LinkedList<fi> linkedList4 = ffVar.KEQ;
        p.g(linkedList4, "reportData.item");
        a("ContentUrl", str3, linkedList4);
        StringBuilder sb = new StringBuilder();
        b bVar3 = this.pIL;
        if (bVar3 == null) {
            p.btv("controller");
        }
        String sb2 = sb.append(bVar3.pHx).toString();
        LinkedList<fi> linkedList5 = ffVar.KEQ;
        p.g(linkedList5, "reportData.item");
        a("SessionId", sb2, linkedList5);
        b bVar4 = this.pIL;
        if (bVar4 == null) {
            p.btv("controller");
        }
        String valueOf = String.valueOf(bVar4.pHu);
        LinkedList<fi> linkedList6 = ffVar.KEQ;
        p.g(linkedList6, "reportData.item");
        a("EnterId", valueOf, linkedList6);
        LinkedList<fi> linkedList7 = ffVar.KEQ;
        p.g(linkedList7, "reportData.item");
        a("NativePage", "1", linkedList7);
        b bVar5 = this.pIL;
        if (bVar5 == null) {
            p.btv("controller");
        }
        String str4 = bVar5.url;
        LinkedList<fi> linkedList8 = ffVar.KEQ;
        p.g(linkedList8, "reportData.item");
        a("#AppMsgUrl#", str4, linkedList8);
        String valueOf2 = String.valueOf(i2);
        LinkedList<fi> linkedList9 = ffVar.KEQ;
        p.g(linkedList9, "reportData.item");
        a("ActionType", valueOf2, linkedList9);
        b bVar6 = this.pIL;
        if (bVar6 == null) {
            p.btv("controller");
        }
        String str5 = bVar6.pHz;
        LinkedList<fi> linkedList10 = ffVar.KEQ;
        p.g(linkedList10, "reportData.item");
        a("ChannelSessionId", str5, linkedList10);
        b bVar7 = this.pIL;
        if (bVar7 == null) {
            p.btv("controller");
        }
        String valueOf3 = String.valueOf(bVar7.pHA);
        LinkedList<fi> linkedList11 = ffVar.KEQ;
        p.g(linkedList11, "reportData.item");
        a("LandingPageType", valueOf3, linkedList11);
        b bVar8 = this.pIL;
        if (bVar8 == null) {
            p.btv("controller");
        }
        String valueOf4 = String.valueOf(bVar8.pHw);
        LinkedList<fi> linkedList12 = ffVar.KEQ;
        p.g(linkedList12, "reportData.item");
        a("SubScene", valueOf4, linkedList12);
        b bVar9 = this.pIL;
        if (bVar9 == null) {
            p.btv("controller");
        }
        String valueOf5 = String.valueOf(bVar9.scene);
        LinkedList<fi> linkedList13 = ffVar.KEQ;
        p.g(linkedList13, "reportData.item");
        a("Scene", valueOf5, linkedList13);
        LinkedList<fi> linkedList14 = ffVar.KEQ;
        p.g(linkedList14, "reportData.item");
        a("ExtInfo", str, linkedList14);
        fgVar.KIG.add(ffVar);
        b bVar10 = this.pIL;
        if (bVar10 == null) {
            p.btv("controller");
        }
        bVar10.a(fgVar);
        LinkedList<fi> linkedList15 = ffVar.KEQ;
        p.g(linkedList15, "reportData.item");
        b(10380, linkedList15);
        AppMethodBeat.o(195988);
    }

    public final void DS(int i2) {
        AppMethodBeat.i(7328);
        fg fgVar = new fg();
        ff ffVar = new ff();
        ffVar.type = 3;
        b bVar = this.pIL;
        if (bVar == null) {
            p.btv("controller");
        }
        String str = bVar.url;
        LinkedList<fi> linkedList = ffVar.KEQ;
        p.g(linkedList, "reportData.item");
        a("#AppMsgUrl#", str, linkedList);
        b bVar2 = this.pIL;
        if (bVar2 == null) {
            p.btv("controller");
        }
        String str2 = bVar2.vid;
        LinkedList<fi> linkedList2 = ffVar.KEQ;
        p.g(linkedList2, "reportData.item");
        a("VideoId", str2, linkedList2);
        StringBuilder sb = new StringBuilder();
        b bVar3 = this.pIL;
        if (bVar3 == null) {
            p.btv("controller");
        }
        String sb2 = sb.append(bVar3.pHx).toString();
        LinkedList<fi> linkedList3 = ffVar.KEQ;
        p.g(linkedList3, "reportData.item");
        a("SessionId", sb2, linkedList3);
        b bVar4 = this.pIL;
        if (bVar4 == null) {
            p.btv("controller");
        }
        String valueOf = String.valueOf(bVar4.pHu);
        LinkedList<fi> linkedList4 = ffVar.KEQ;
        p.g(linkedList4, "reportData.item");
        a("EnterId", valueOf, linkedList4);
        b bVar5 = this.pIL;
        if (bVar5 == null) {
            p.btv("controller");
        }
        String valueOf2 = String.valueOf(bVar5.scene);
        LinkedList<fi> linkedList5 = ffVar.KEQ;
        p.g(linkedList5, "reportData.item");
        a("Scene", valueOf2, linkedList5);
        b bVar6 = this.pIL;
        if (bVar6 == null) {
            p.btv("controller");
        }
        String valueOf3 = String.valueOf(bVar6.pHw);
        LinkedList<fi> linkedList6 = ffVar.KEQ;
        p.g(linkedList6, "reportData.item");
        a("SubScene", valueOf3, linkedList6);
        String valueOf4 = String.valueOf(System.currentTimeMillis());
        LinkedList<fi> linkedList7 = ffVar.KEQ;
        p.g(linkedList7, "reportData.item");
        a("ClientId", valueOf4, linkedList7);
        String valueOf5 = String.valueOf(i2);
        LinkedList<fi> linkedList8 = ffVar.KEQ;
        p.g(linkedList8, "reportData.item");
        a("EventType", valueOf5, linkedList8);
        fgVar.KIG.add(ffVar);
        b bVar7 = this.pIL;
        if (bVar7 == null) {
            p.btv("controller");
        }
        bVar7.a(fgVar);
        LinkedList<fi> linkedList9 = ffVar.KEQ;
        p.g(linkedList9, "reportData.item");
        b(17537, linkedList9);
        AppMethodBeat.o(7328);
    }

    public final void b(int i2, LinkedList<fi> linkedList) {
        AppMethodBeat.i(7329);
        if (Log.getLogLevel() <= 0 && !Util.isNullOrNil(linkedList)) {
            StringBuilder sb = new StringBuilder();
            Iterator<fi> it = linkedList.iterator();
            while (it.hasNext()) {
                fi next = it.next();
                sb.append(next.key).append(":").append(next.iFF).append("  ");
            }
            Log.v(this.TAG, i2 + ", " + ((Object) sb));
        }
        AppMethodBeat.o(7329);
    }

    public static void a(String str, String str2, LinkedList<fi> linkedList) {
        AppMethodBeat.i(7330);
        fi fiVar = new fi();
        fiVar.key = str;
        fiVar.iFF = str2;
        linkedList.add(fiVar);
        AppMethodBeat.o(7330);
    }
}
