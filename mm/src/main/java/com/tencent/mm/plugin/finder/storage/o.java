package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.atv;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.MD5Util;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.v;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 82\u00020\u0001:\u00018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b#\u0010\u0011R\u0011\u0010$\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b%\u0010\u0011R\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b+\u0010\u0011R\u0011\u0010,\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b-\u0010\u0011R\u0011\u0010.\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b/\u0010\rR\u0011\u00100\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "", "section", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "feedList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedList", "()Ljava/util/LinkedList;", "iconType", "", "getIconType", "()I", "iconUrlDark", "", "getIconUrlDark", "()Ljava/lang/String;", "iconUrlLight", "getIconUrlLight", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "moreActionType", "getMoreActionType", "relatedResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getRelatedResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "getSection", "()Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "sectionDesc", "getSectionDesc", "sectionId", "getSectionId", "sectionInfo", "Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "getSectionInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderSectionInfo;", "sectionSubTitle", "getSectionSubTitle", "sectionTitle", "getSectionTitle", "sectionType", "getSectionType", "streamResp", "Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "getStreamResp", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamResponse;", "topicResp", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "getTopicResp", "()Lcom/tencent/mm/protocal/protobuf/FinderGetTopicListResponse;", "Companion", "plugin-finder_release"})
public final class o {
    public static final a vEb = new a((byte) 0);
    public final f tON;
    public final LinkedList<BaseFinderFeed> vDZ = new LinkedList<>();
    public final azm vEa;

    static {
        AppMethodBeat.i(251776);
        AppMethodBeat.o(251776);
    }

    public o(azm azm) {
        v vVar;
        LinkedList<BaseFinderFeed> linkedList;
        p.h(azm, "section");
        AppMethodBeat.i(251775);
        this.vEa = azm;
        LinkedList<BaseFinderFeed> linkedList2 = this.vDZ;
        LinkedList<FinderObject> linkedList3 = this.vEa.LCW;
        if (linkedList3 != null) {
            ArrayList<FinderObject> arrayList = new ArrayList();
            for (T t : linkedList3) {
                T t2 = t;
                if ((t2 != null ? t2.objectDesc : null) != null) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (FinderObject finderObject : arrayList) {
                FinderItem.a aVar = FinderItem.Companion;
                p.g(finderObject, "feed");
                FinderItem a2 = FinderItem.a.a(finderObject, 1);
                c.a aVar2 = c.vGN;
                arrayList2.add(c.a.s(a2));
            }
            vVar = arrayList2;
            linkedList = linkedList2;
        } else {
            vVar = v.SXr;
            linkedList = linkedList2;
        }
        linkedList.addAll(vVar);
        this.tON = g.ah(new b(this));
        AppMethodBeat.o(251775);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem$Companion;", "", "()V", "careSectionType", "", "sectionType", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final bcc dxE() {
        AppMethodBeat.i(251768);
        bcc bcc = this.vEa.tvs;
        if (bcc == null) {
            bcc = new bcc();
            bcc.qfq = "";
            bcc.LLm = "";
            bcc.LLn = "";
            bcc.FVr = 0;
            bcc.LLo = 0;
            bcc.LLp = "";
            bcc.LLq = "";
            bcc.Kib = "";
            bcc.jjN = 0;
        }
        AppMethodBeat.o(251768);
        return bcc;
    }

    public final String dxF() {
        AppMethodBeat.i(251769);
        String str = dxE().LLm;
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(251769);
        return str;
    }

    public final String cxc() {
        AppMethodBeat.i(251770);
        String str = dxE().qfq;
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(251770);
        return str;
    }

    public final String dxG() {
        AppMethodBeat.i(251771);
        String str = dxE().LLn;
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(251771);
        return str;
    }

    public final String dxH() {
        AppMethodBeat.i(251772);
        String str = dxE().LLp;
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(251772);
        return str;
    }

    public final atv dxI() {
        AppMethodBeat.i(251773);
        atv atv = dxE().LLr;
        if (atv == null) {
            atv = new atv();
        }
        AppMethodBeat.o(251773);
        return atv;
    }

    public final atp dxJ() {
        AppMethodBeat.i(251774);
        atp atp = dxE().LLs;
        if (atp == null) {
            atp = new atp();
        }
        AppMethodBeat.o(251774);
        return atp;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ o vEc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o oVar) {
            super(0);
            this.vEc = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(251767);
            Long valueOf = Long.valueOf((long) MD5Util.getMD5String(this.vEc.dxF()).hashCode());
            AppMethodBeat.o(251767);
            return valueOf;
        }
    }
}
