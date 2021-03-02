package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cg;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;

public final class g extends cg {
    private static final IAutoDBItem.MAutoDBInfo info;
    public static final a vDm = new a((byte) 0);
    private FinderItem vDl;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g j(FinderItem finderItem) {
            AppMethodBeat.i(251712);
            p.h(finderItem, "finderItem");
            g gVar = new g();
            gVar.field_createTime = finderItem.getCreateTime();
            gVar.field_localFlag = 1;
            FinderItem.a aVar = FinderItem.Companion;
            gVar.field_finderItem = FinderItem.a.l(finderItem);
            gVar.field_objectType = 0;
            gVar.field_localId = finderItem.getLocalId();
            AppMethodBeat.o(251712);
            return gVar;
        }

        public static csp a(g gVar) {
            String str;
            LinkedList<aud> linkedList;
            FinderObjectDesc finderObjectDesc;
            AppMethodBeat.i(251713);
            p.h(gVar, "draftItem");
            csp csp = new csp();
            FinderItem dxn = gVar.dxn();
            cjl cjl = (cjl) j.kt(dxn.getMediaList());
            if (cjl == null || (str = cjl.url) == null) {
                str = "";
            }
            csp.MxF = str;
            csp.MxE = dxn.getFeedObject();
            FinderObject finderObject = csp.MxE;
            if (!(finderObject == null || (finderObjectDesc = finderObject.objectDesc) == null)) {
                finderObjectDesc.media = new LinkedList<>();
            }
            cjh cjh = dxn.field_clipList;
            if (!(cjh == null || (linkedList = cjh.MoH) == null)) {
                Iterator<T> it = linkedList.iterator();
                while (it.hasNext()) {
                    csp.LDi.add(it.next().tuO);
                }
            }
            csp.localId = gVar.field_localId;
            csp.MxG = gVar.field_originMvInfo;
            AppMethodBeat.o(251713);
            return csp;
        }
    }

    static {
        AppMethodBeat.i(251715);
        IAutoDBItem.MAutoDBInfo ajs = cg.ajs();
        p.g(ajs, "initAutoDBInfo(FinderDraftItem::class.java)");
        info = ajs;
        AppMethodBeat.o(251715);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final FinderItem dxn() {
        AppMethodBeat.i(251714);
        FinderItem finderItem = this.vDl;
        if (finderItem == null) {
            FinderItem.a aVar = FinderItem.Companion;
            aud aud = this.field_finderItem;
            p.g(aud, "field_finderItem");
            finderItem = FinderItem.a.a(aud, this.field_localId);
            this.vDl = finderItem;
        }
        AppMethodBeat.o(251714);
        return finderItem;
    }
}
