package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ\"\u0010\u000b\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ\u001c\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ\b\u0010\u0014\u001a\u00020\nH\u0016J$\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ$\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderItemOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "remove", "svrId", "", "list", "Ljava/util/LinkedList;", "svrIds", "", "removeLocal", ch.COL_LOCALID, "targetDataType", "update", "newOne", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "updateLocal", "item", "plugin-finder_release"})
public final class i {
    public static final i vGl = new i();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<aqq, Boolean> {
        final /* synthetic */ long vGm;
        final /* synthetic */ z.a vGn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(long j2, z.a aVar) {
            super(1);
            this.vGm = j2;
            this.vGn = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(aqq aqq) {
            FinderObject finderObject;
            AppMethodBeat.i(251995);
            aqq aqq2 = aqq;
            p.h(aqq2, "item");
            int i2 = aqq2.dataType;
            i iVar = i.vGl;
            boolean z = i2 == 0 && aqq2.type != 2 && (finderObject = aqq2.LCD) != null && finderObject.id == this.vGm;
            if (z) {
                this.vGn.SYB = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(251995);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<aqq, Boolean> {
        final /* synthetic */ z.a vGn;
        final /* synthetic */ List vGo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(List list, z.a aVar) {
            super(1);
            this.vGo = list;
            this.vGn = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke(com.tencent.mm.protocal.protobuf.aqq r7) {
            /*
                r6 = this;
                r3 = 251996(0x3d85c, float:3.53122E-40)
                r2 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                com.tencent.mm.protocal.protobuf.aqq r7 = (com.tencent.mm.protocal.protobuf.aqq) r7
                java.lang.String r0 = "item"
                kotlin.g.b.p.h(r7, r0)
                int r0 = r7.dataType
                com.tencent.mm.plugin.finder.storage.data.i r1 = com.tencent.mm.plugin.finder.storage.data.i.vGl
                if (r0 != 0) goto L_0x003f
                int r0 = r7.type
                r1 = 2
                if (r0 == r1) goto L_0x003f
                java.util.List r0 = r6.vGo
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                com.tencent.mm.protocal.protobuf.FinderObject r1 = r7.LCD
                if (r1 == 0) goto L_0x003d
                long r4 = r1.id
                java.lang.Long r1 = java.lang.Long.valueOf(r4)
            L_0x0028:
                boolean r0 = kotlin.a.j.a(r0, r1)
                if (r0 == 0) goto L_0x003f
                r0 = r2
            L_0x002f:
                if (r0 == 0) goto L_0x0035
                kotlin.g.b.z$a r1 = r6.vGn
                r1.SYB = r2
            L_0x0035:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return r0
            L_0x003d:
                r1 = 0
                goto L_0x0028
            L_0x003f:
                r0 = 0
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.data.i.b.invoke(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<aqq, Boolean> {
        final /* synthetic */ long $localId;
        final /* synthetic */ z.a vGn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(long j2, z.a aVar) {
            super(1);
            this.$localId = j2;
            this.vGn = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(aqq aqq) {
            FinderObject finderObject;
            AppMethodBeat.i(251997);
            aqq aqq2 = aqq;
            p.h(aqq2, "item");
            int i2 = aqq2.dataType;
            i iVar = i.vGl;
            boolean z = i2 == 0 && aqq2.type == 2 && (finderObject = aqq2.LCD) != null && finderObject.id == this.$localId;
            if (z) {
                this.vGn.SYB = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(251997);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(252004);
        AppMethodBeat.o(252004);
    }

    private i() {
    }

    public static FinderItem a(aqq aqq) {
        boolean z;
        FinderItem Fz;
        String str;
        boolean z2 = true;
        AppMethodBeat.i(251998);
        p.h(aqq, "data");
        FinderObject finderObject = aqq.LCD;
        if (aqq.dataType == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && finderObject != null) {
            com.tencent.mm.plugin.finder.storage.l feedStorage = ((PluginFinder) g.ah(PluginFinder.class)).getFeedStorage();
            switch (aqq.type) {
                case 2:
                    Fz = feedStorage.Fz(aqq.id);
                    if (Fz == null) {
                        Fz = null;
                        break;
                    } else {
                        if (Fz.getLocalId() == 0) {
                            z2 = false;
                        }
                        if (!z2) {
                            Fz = null;
                            break;
                        }
                    }
                    break;
                default:
                    FinderItem.a aVar = FinderItem.Companion;
                    FinderItem a2 = FinderItem.a.a(finderObject, aqq.LCE);
                    c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                    FinderContact finderContact = a2.getFeedObject().contact;
                    if (finderContact != null) {
                        str = finderContact.username;
                    } else {
                        str = null;
                    }
                    if (c.a.asG(str) == null) {
                        c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                        c.a.b(a2.getFeedObject().contact);
                    }
                    e.a aVar4 = e.vFX;
                    if (e.a.Fy(a2.field_id) == null) {
                        e.a aVar5 = e.vFX;
                        e.a.n(a2);
                    }
                    Fz = a2;
                    break;
            }
            if (Fz != null) {
                AppMethodBeat.o(251998);
                return Fz;
            }
        }
        AppMethodBeat.o(251998);
        return null;
    }

    public static boolean a(long j2, FinderItem finderItem, LinkedList<aqq> linkedList) {
        T t;
        boolean z;
        FinderObject finderObject;
        AppMethodBeat.i(251999);
        p.h(finderItem, "item");
        p.h(linkedList, "list");
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            T t2 = next;
            if (t2.dataType == 0 && t2.type == 2 && (finderObject = t2.LCD) != null && finderObject.id == j2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t3 = t;
        if (t3 != null) {
            t3.type = 1;
            FinderObject finderObject2 = t3.LCD;
            if (finderObject2 != null) {
                finderObject2.id = finderItem.field_id;
            }
            t3.LCD = finderItem.getFeedObject();
            AppMethodBeat.o(251999);
            return true;
        }
        AppMethodBeat.o(251999);
        return false;
    }

    public static boolean a(long j2, LinkedList<aqq> linkedList) {
        AppMethodBeat.i(252000);
        p.h(linkedList, "list");
        z.a aVar = new z.a();
        aVar.SYB = false;
        d.a((LinkedList) linkedList, (kotlin.g.a.b) new a(j2, aVar));
        boolean z = aVar.SYB;
        AppMethodBeat.o(252000);
        return z;
    }

    public static boolean a(List<Long> list, LinkedList<aqq> linkedList) {
        AppMethodBeat.i(252001);
        p.h(list, "svrIds");
        p.h(linkedList, "list");
        z.a aVar = new z.a();
        aVar.SYB = false;
        d.a((LinkedList) linkedList, (kotlin.g.a.b) new b(list, aVar));
        boolean z = aVar.SYB;
        AppMethodBeat.o(252001);
        return z;
    }

    public static boolean b(long j2, LinkedList<aqq> linkedList) {
        AppMethodBeat.i(252002);
        p.h(linkedList, "list");
        z.a aVar = new z.a();
        aVar.SYB = false;
        d.a((LinkedList) linkedList, (kotlin.g.a.b) new c(j2, aVar));
        boolean z = aVar.SYB;
        AppMethodBeat.o(252002);
        return z;
    }

    public static boolean a(long j2, FinderObject finderObject, LinkedList<aqq> linkedList) {
        FinderObject finderObject2;
        boolean z = false;
        AppMethodBeat.i(252003);
        p.h(finderObject, "newOne");
        p.h(linkedList, "list");
        Iterator<aqq> it = linkedList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            aqq next = it.next();
            if (next.dataType == 0 && next.type != 2 && (finderObject2 = next.LCD) != null && finderObject2.id == j2) {
                break;
            }
            i2++;
        }
        if (i2 >= 0) {
            linkedList.get(i2).LCD = finderObject;
            z = true;
        }
        AppMethodBeat.o(252003);
        return z;
    }
}
