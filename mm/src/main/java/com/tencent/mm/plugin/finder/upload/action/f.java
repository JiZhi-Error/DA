package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.finder.upload.action.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "finderUser", "", "opType", "", "feedId", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isPrivate", "", "(Ljava/lang/String;IJLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Z)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "()Z", "getOpType", "()I", "doFollow", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doSomething", "toString", "uniqueId", "plugin-finder_release"})
public final class f extends e {
    public final String dNc;
    public final long feedId;
    public final int opType;
    public final bbn ttO;
    final boolean vUk;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFollowResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ k.b vTV;
        final /* synthetic */ f vUl;

        a(f fVar, k.b bVar) {
            this.vUl = fVar;
            this.vTV = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            int i2;
            AppMethodBeat.i(253196);
            c.a aVar = (c.a) obj;
            Log.i("Finder.FollowActionTask", "FollowAction callback " + aVar.errType + ' ' + aVar.errCode + ' ' + aVar.errMsg);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                FinderContact finderContact = ((arg) aVar.iLC).contact;
                if (finderContact != null) {
                    Log.i("Finder.FollowActionTask", "newContact.followFlag: " + finderContact.followFlag);
                    c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                    str = this.vUl.dNc;
                    i2 = finderContact.followFlag;
                } else {
                    c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                    str = this.vUl.dNc;
                    int i3 = this.vUl.opType;
                    bb.a aVar4 = bb.tve;
                    if (i3 == bb.tvb) {
                        g.a aVar5 = g.tsD;
                        i2 = g.tsB;
                    } else {
                        g.a aVar6 = g.tsD;
                        i2 = g.tsC;
                    }
                }
                c.a.du(str, i2);
                g.a aVar7 = g.vUn;
                g.dBr().a(this.vUl);
                EventCenter eventCenter = EventCenter.instance;
                ik ikVar = new ik();
                ikVar.dNb.dNc = this.vUl.dNc;
                ikVar.dNb.opType = this.vUl.opType;
                eventCenter.publish(ikVar);
                this.vTV.a(j.OK, false);
            } else {
                if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                    u.makeText(MMApplicationContext.getContext(), "is debug info finderfollow: " + aVar.errType + ' ' + aVar.errCode, 1).show();
                }
                if (aVar.errType == 4) {
                    g.a aVar8 = g.vUn;
                    g.dBr().a(this.vUl);
                    EventCenter eventCenter2 = EventCenter.instance;
                    ik ikVar2 = new ik();
                    ikVar2.dNb.dNc = this.vUl.dNc;
                    ikVar2.dNb.opType = this.vUl.opType;
                    eventCenter2.publish(ikVar2);
                    this.vTV.a(j.Fail, false);
                } else {
                    this.vTV.a(j.Fail, true);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253196);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(String str, int i2, long j2, bbn bbn, boolean z) {
        super(null);
        p.h(str, "finderUser");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(253200);
        this.dNc = str;
        this.opType = i2;
        this.feedId = j2;
        this.ttO = bbn;
        this.vUk = z;
        AppMethodBeat.o(253200);
    }

    public final String toString() {
        AppMethodBeat.i(253197);
        String str = "action_" + this.dNc + '_' + this.opType + '_' + this.vUi;
        AppMethodBeat.o(253197);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.upload.action.e
    public final String auK() {
        AppMethodBeat.i(253198);
        String str = "id_" + this.dNc + '_' + this.opType;
        AppMethodBeat.o(253198);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.upload.action.e
    public final void a(k.b bVar) {
        AppMethodBeat.i(253199);
        p.h(bVar, "callback");
        super.a(bVar);
        new com.tencent.mm.plugin.finder.cgi.k(this).aYI().g(new a(this, bVar));
        AppMethodBeat.o(253199);
    }
}
