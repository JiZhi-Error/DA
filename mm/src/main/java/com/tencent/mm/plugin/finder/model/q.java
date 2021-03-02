package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "createTime", "", "getDraftTitle", "", "getItemId", "getItemType", "isMusicTag", "", "plugin-finder_release"})
public final class q implements bo {
    public final g uNV;

    public q(g gVar) {
        p.h(gVar, "draftItem");
        AppMethodBeat.i(248729);
        this.uNV = gVar;
        AppMethodBeat.o(248729);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.uNV.field_localId;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248726);
        int hashCode = q.class.getName().hashCode();
        AppMethodBeat.o(248726);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        AppMethodBeat.i(248727);
        p.h(iVar, "obj");
        if (!(iVar instanceof q)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        q qVar = (q) iVar2;
        if (qVar == null) {
            AppMethodBeat.o(248727);
            return -1;
        } else if (qVar.uNV.field_localId > 0 && this.uNV.field_localId > 0 && qVar.uNV.field_localId == this.uNV.field_localId) {
            AppMethodBeat.o(248727);
            return 0;
        } else if (qVar.uNV.dxn().getId() != 0 && qVar.uNV.dxn().getId() != 0 && qVar.uNV.dxn().getId() == qVar.uNV.dxn().getId()) {
            AppMethodBeat.o(248727);
            return 0;
        } else if (this.uNV.field_createTime == 0 || qVar.uNV.field_createTime == 0 || this.uNV.field_createTime != qVar.uNV.field_createTime) {
            AppMethodBeat.o(248727);
            return -1;
        } else {
            AppMethodBeat.o(248727);
            return 1;
        }
    }

    public final String dkw() {
        String str;
        axw axw;
        AppMethodBeat.i(248728);
        if (dkx()) {
            FinderObjectDesc finderObjectDesc = this.uNV.dxn().getFeedObject().objectDesc;
            axy axy = (finderObjectDesc == null || (axw = finderObjectDesc.mvInfo) == null) ? null : axw.Aqo;
            if (axy != null) {
                if (Util.isNullOrNil(axy.lDR)) {
                    str = axy.BPc;
                    if (str == null) {
                        AppMethodBeat.o(248728);
                        return "";
                    }
                } else if (Util.isNullOrNil(axy.BPc)) {
                    String valueOf = String.valueOf(axy.lDR);
                    AppMethodBeat.o(248728);
                    return valueOf;
                } else {
                    StringBuilder sb = new StringBuilder();
                    String str2 = axy.BPc;
                    if (str2 == null) {
                        str2 = "";
                    }
                    str = sb.append(str2).append('-').append(axy.lDR).toString();
                }
                AppMethodBeat.o(248728);
                return str;
            }
            AppMethodBeat.o(248728);
            return "";
        }
        FinderObjectDesc finderObjectDesc2 = this.uNV.dxn().getFeedObject().objectDesc;
        if (finderObjectDesc2 != null) {
            String str3 = finderObjectDesc2.description;
            AppMethodBeat.o(248728);
            return str3;
        }
        AppMethodBeat.o(248728);
        return null;
    }

    public final boolean dkx() {
        return this.uNV.field_objectType == 2;
    }
}
