package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "()V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class ae extends c<aru> {
    public static final a tue = new a((byte) 0);

    static {
        AppMethodBeat.i(242298);
        AppMethodBeat.o(242298);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, aru aru, q qVar) {
        ArrayList arrayList;
        StringBuilder sb;
        AppMethodBeat.i(242297);
        aru aru2 = aru;
        p.h(aru2, "resp");
        super.a(i2, i3, str, aru2, qVar);
        StringBuilder append = new StringBuilder("[onCgiBack] errType=").append(i2).append(" errCode=").append(i3).append(" errMsg=").append(str).append(" resp=");
        LinkedList<FinderContact> linkedList = aru2.LCI;
        if (linkedList != null) {
            LinkedList<FinderContact> linkedList2 = linkedList;
            ArrayList arrayList2 = new ArrayList(j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().username);
            }
            arrayList = arrayList2;
            sb = append;
        } else {
            arrayList = null;
            sb = append;
        }
        Log.i("Finder.CgiGetFinderContact", sb.append(arrayList).toString());
        AppMethodBeat.o(242297);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rJ\u0014\u0010\u000e\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\rJ\u0014\u0010\u0010\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00110\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact$Companion;", "", "()V", "CONTACT_TYPE_COMMENT", "", "CONTACT_TYPE_FANS", "CONTACT_TYPE_FINDER_USERNAME", "CONTACT_TYPE_PERSONAL_MSG", "TAG", "", "create", "Lcom/tencent/mm/plugin/finder/cgi/CgiGetFinderContact;", "usernameList", "", "create2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "create3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ae kZ(List<? extends aps> list) {
            AppMethodBeat.i(260185);
            p.h(list, "usernameList");
            ae aeVar = new ae();
            d.a aVar = new d.a();
            art art = new art();
            am amVar = am.tuw;
            art.LAI = am.cXY();
            art.LDk = 1;
            art.LAt = z.aUg();
            art.LDl.addAll(list);
            aVar.c(art);
            aru aru = new aru();
            aru.setBaseResponse(new BaseResponse());
            aru.getBaseResponse().ErrMsg = new dqi();
            aVar.d(aru);
            aVar.MB("/cgi-bin/micromsg-bin/findergetcontactlist");
            aVar.sG(3953);
            aeVar.c(aVar.aXF());
            AppMethodBeat.o(260185);
            return aeVar;
        }
    }
}
