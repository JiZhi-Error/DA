package com.tencent.mm.plugin.finder.upload;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cw;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.upload.action.a;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/ActionTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "curScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneReplyFinderComment;", "call", "", "doAction", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "uniqueId", "Companion", "plugin-finder_release"})
public final class a extends c implements i {
    public static final C1301a vRI = new C1301a((byte) 0);
    private cw vRG;
    private final an vRH;

    static {
        AppMethodBeat.i(167715);
        AppMethodBeat.o(167715);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/ActionTask$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.upload.a$a  reason: collision with other inner class name */
    public static final class C1301a {
        private C1301a() {
        }

        public /* synthetic */ C1301a(byte b2) {
            this();
        }
    }

    public a(an anVar) {
        p.h(anVar, NativeProtocol.WEB_DIALOG_ACTION);
        AppMethodBeat.i(167714);
        this.vRH = anVar;
        AppMethodBeat.o(167714);
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        bbn bbn;
        AppMethodBeat.i(167711);
        an anVar = this.vRH;
        aoh aoh = this.vRH.field_actionInfo;
        if (aoh != null) {
            bbn = aoh.ttO;
        } else {
            bbn = null;
        }
        this.vRG = new cw(anVar, bbn);
        long aWy = cl.aWy() - (this.vRH.dyb().createtime * 1000);
        long j2 = this.vRH.field_tryCount;
        a.C1302a aVar = com.tencent.mm.plugin.finder.upload.action.a.vTR;
        if (j2 < ((long) com.tencent.mm.plugin.finder.upload.action.a.dBn())) {
            a.C1302a aVar2 = com.tencent.mm.plugin.finder.upload.action.a.vTR;
            if (aWy < ((long) com.tencent.mm.plugin.finder.upload.action.a.dBm())) {
                this.vRH.field_tryCount++;
                Log.i("Finder.ActionTask", "doAction " + this.vRH + ' ' + this.vRH + ".field_tryCount");
                ((PluginFinder) g.ah(PluginFinder.class)).getFinderActionStorage().a(this.vRH.field_localCommentId, this.vRH, false);
                t azz = g.azz();
                cw cwVar = this.vRG;
                if (cwVar == null) {
                    p.btv("curScene");
                }
                azz.b(cwVar);
                g.azz().a(3906, this);
                AppMethodBeat.o(167711);
                return;
            }
        }
        Log.i("Finder.ActionTask", "make fail tryNext " + this.vRH.dyb().commentId + " tryCount " + this.vRH.field_tryCount + " createTime: " + this.vRH.dyb().createtime);
        this.vRH.field_state = -1;
        ((PluginFinder) g.ah(PluginFinder.class)).getFinderActionStorage().a(this.vRH.field_localCommentId, this.vRH, true);
        a(j.OK);
        AppMethodBeat.o(167711);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(167712);
        an anVar = this.vRH;
        String sb = new StringBuilder().append(((am) anVar).field_actionType).append('_').append(((am) anVar).field_feedId).append('_').append(((am) anVar).field_localCommentId).toString();
        AppMethodBeat.o(167712);
        return sb;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(167713);
        cw cwVar = this.vRG;
        if (cwVar == null) {
            p.btv("curScene");
        }
        if (p.j(qVar, cwVar)) {
            g.azz().b(3906, this);
            StringBuilder append = new StringBuilder("onSceneEnd ").append(i2).append(", ").append(i3).append(", ").append(str).append(", ");
            an anVar = this.vRH;
            Log.i("Finder.ActionTask", append.append((anVar != null ? Long.valueOf(anVar.field_localCommentId) : null).longValue()).toString());
            an anVar2 = this.vRH;
            if (anVar2 != null) {
                if (i2 == 0 && i3 == 0) {
                    ((PluginFinder) g.ah(PluginFinder.class)).getFinderActionStorage().Fw(anVar2.field_localCommentId);
                    a(j.OK);
                    AppMethodBeat.o(167713);
                    return;
                }
                com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
                if (!com.tencent.mm.plugin.finder.spam.a.gi(i2, i3)) {
                    if (i2 >= 4) {
                        anVar2.field_state = -1;
                        if (i3 == -4010) {
                            anVar2.field_failedFlag = 1;
                        }
                    } else {
                        anVar2.field_postTime = cl.aWy();
                    }
                    ((PluginFinder) g.ah(PluginFinder.class)).getFinderActionStorage().a(anVar2.field_localCommentId, anVar2, false);
                } else {
                    ((PluginFinder) g.ah(PluginFinder.class)).getFinderActionStorage().Fw(anVar2.field_localCommentId);
                }
                a(j.Fail);
                AppMethodBeat.o(167713);
                return;
            }
        }
        AppMethodBeat.o(167713);
    }
}
