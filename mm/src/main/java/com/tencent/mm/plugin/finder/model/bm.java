package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 W2\u00020\u0001:\u0001WB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010B\u001a\u00020'J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0016J\u0006\u0010G\u001a\u00020\u001aJ\u0006\u0010H\u001a\u00020IJ\b\u0010J\u001a\u00020\u001aH\u0016J\b\u0010K\u001a\u00020DH\u0016J\u0006\u0010L\u001a\u00020'J\u0006\u0010M\u001a\u00020'J\u0006\u0010N\u001a\u00020'J\u0006\u0010O\u001a\u00020'J\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00100QJ\u000e\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u001aJ\u000e\u0010V\u001a\u00020T2\u0006\u0010R\u001a\u00020\u0003J\u000e\u0010V\u001a\u00020T2\u0006\u0010R\u001a\u00020\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0004R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010\u001eR\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R0\u0010;\u001a\b\u0012\u0004\u0012\u00020:092\f\u00108\u001a\b\u0012\u0004\u0012\u00020:098F@FX\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001c¨\u0006X"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "(Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;)V", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "attachFinderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getAttachFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setAttachFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "bulletList", "", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBulletCommentInfo;", "getBulletList", "()Ljava/util/List;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderContact;", "setContact", "(Lcom/tencent/mm/protocal/protobuf/FinderContact;)V", "createTimestamp", "", "getCreateTimestamp", "()J", "setCreateTimestamp", "(J)V", "feedObject", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "getFinderMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "setFinderMegaVideo", "hasAddToHistory", "", "getHasAddToHistory", "()Z", "setHasAddToHistory", "(Z)V", "hasDeleteFromHistory", "getHasDeleteFromHistory", "setHasDeleteFromHistory", ch.COL_LOCALID, "getLocalId", "setLocalId", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "getMegaVideo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "setMegaVideo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideo;)V", "value", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "megaVideoMediaList", "getMegaVideoMediaList", "()Ljava/util/LinkedList;", "setMegaVideoMediaList", "(Ljava/util/LinkedList;)V", "timestamps", "getTimestamps", "canShowBullet", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFinderId", "getFinderNonceId", "", "getItemId", "getItemType", "isLandscapeVideo", "isPrivate", "isSpamForbiddenShare", "isSpamSetPrivate", "mergeBulletList", "", "data", "removeBullet", "", "bulletId", "updateData", "Companion", "plugin-finder_release"})
public final class bm implements bo {
    public static final a uOY = new a((byte) 0);
    public FinderContact contact;
    public FinderObject feedObject;
    public long localId;
    public final long timestamps = cl.aWA();
    public cng tuP;
    private ayj uOS;
    public boolean uOT;
    public boolean uOU;
    public long uOV = cl.aWA();
    public FinderItem uOW;
    public final List<cni> uOX;

    static {
        AppMethodBeat.i(248865);
        AppMethodBeat.o(248865);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final FinderObject getFeedObject() {
        AppMethodBeat.i(248853);
        FinderObject finderObject = this.feedObject;
        if (finderObject == null) {
            p.btv("feedObject");
        }
        AppMethodBeat.o(248853);
        return finderObject;
    }

    public bm(ayj ayj) {
        p.h(ayj, "finderMegaVideo");
        AppMethodBeat.i(248863);
        FinderItem finderItem = this.uOW;
        this.localId = finderItem != null ? finderItem.getLocalId() : 0;
        this.uOX = new ArrayList();
        this.uOS = ayj;
        this.contact = ayj.contact;
        this.tuP = ayj.LIA;
        AppMethodBeat.o(248863);
    }

    public bm(FinderObject finderObject) {
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        p.h(finderObject, ch.COL_FINDEROBJECT);
        AppMethodBeat.i(248864);
        FinderItem finderItem = this.uOW;
        this.localId = finderItem != null ? finderItem.getLocalId() : 0;
        this.uOX = new ArrayList();
        this.feedObject = finderObject;
        FinderObject finderObject2 = this.feedObject;
        if (finderObject2 == null) {
            p.btv("feedObject");
        }
        this.contact = finderObject2.contact;
        FinderObject finderObject3 = this.feedObject;
        if (finderObject3 == null) {
            p.btv("feedObject");
        }
        aoq aoq = finderObject3.attachmentList;
        this.tuP = (aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null) ? null : bei.LIA;
        AppMethodBeat.o(248864);
    }

    public final LinkedList<cjl> dkV() {
        cnl cnl;
        LinkedList<cod> linkedList;
        AppMethodBeat.i(248854);
        cng cng = this.tuP;
        if (cng == null || (cnl = cng.MtG) == null || (linkedList = cnl.media) == null) {
            LinkedList<cjl> linkedList2 = new LinkedList<>();
            AppMethodBeat.o(248854);
            return linkedList2;
        }
        LinkedList<cjl> aB = com.tencent.mm.plugin.finder.storage.data.j.aB(linkedList);
        AppMethodBeat.o(248854);
        return aB;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        cng cng = this.tuP;
        if (cng != null) {
            return cng.id;
        }
        return 0;
    }

    public final long dkW() {
        cns cns;
        AppMethodBeat.i(248855);
        if (this.uOS != null) {
            cng cng = this.tuP;
            if (cng == null || (cns = cng.MtI) == null) {
                AppMethodBeat.o(248855);
                return 0;
            }
            long j2 = cns.hFK;
            AppMethodBeat.o(248855);
            return j2;
        }
        FinderObject finderObject = this.feedObject;
        if (finderObject == null) {
            p.btv("feedObject");
        }
        long j3 = finderObject.id;
        AppMethodBeat.o(248855);
        return j3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 == null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String dkX() {
        /*
            r3 = this;
            r2 = 248856(0x3cc18, float:3.48722E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.protocal.protobuf.ayj r0 = r3.uOS
            if (r0 == 0) goto L_0x001b
            com.tencent.mm.protocal.protobuf.cng r0 = r3.tuP
            if (r0 == 0) goto L_0x0016
            com.tencent.mm.protocal.protobuf.cns r0 = r0.MtI
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.objectNonceId
            if (r0 != 0) goto L_0x0019
        L_0x0016:
            java.lang.String r0 = ""
        L_0x0019:
            if (r0 != 0) goto L_0x0027
        L_0x001b:
            com.tencent.mm.protocal.protobuf.FinderObject r0 = r3.feedObject
            if (r0 != 0) goto L_0x0025
            java.lang.String r1 = "feedObject"
            kotlin.g.b.p.btv(r1)
        L_0x0025:
            java.lang.String r0 = r0.objectNonceId
        L_0x0027:
            if (r0 != 0) goto L_0x002c
            java.lang.String r0 = ""
        L_0x002c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.model.bm.dkX():java.lang.String");
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248857);
        int hashCode = bm.class.hashCode();
        AppMethodBeat.o(248857);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(248858);
        p.h(iVar, "obj");
        if (!(iVar instanceof bm)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        bm bmVar = (bm) iVar2;
        if (bmVar != null) {
            if (bmVar.lT() == 0 || lT() == 0 || bmVar.lT() != lT()) {
                cng cng = bmVar.tuP;
                if (cng != null) {
                    i2 = cng.iXu;
                } else {
                    i2 = 0;
                }
                cng cng2 = this.tuP;
                if (cng2 != null) {
                    i3 = cng2.iXu;
                }
                if (i2 > i3) {
                    AppMethodBeat.o(248858);
                    return 1;
                }
            } else {
                AppMethodBeat.o(248858);
                return 0;
            }
        }
        AppMethodBeat.o(248858);
        return -1;
    }

    public final List<cni> ej(List<? extends cni> list) {
        AppMethodBeat.i(248859);
        p.h(list, "data");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            Iterator<cni> it = this.uOX.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (it.next().id == t.id) {
                    break;
                }
                i2++;
            }
            if (i2 >= 0) {
                Log.v("MegaVideoFeed", "mergeBulletList: remove exist bullet index = " + i2 + ", id = " + t.id);
            } else {
                arrayList.add(t);
            }
        }
        this.uOX.addAll(arrayList);
        Log.i("MegaVideoFeed", "mergeBulletList: bullet list size = " + this.uOX.size() + ", increase size = " + arrayList.size());
        AppMethodBeat.o(248859);
        return arrayList;
    }

    public final void g(FinderObject finderObject) {
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        AppMethodBeat.i(248860);
        p.h(finderObject, "data");
        this.feedObject = finderObject;
        FinderObject finderObject2 = this.feedObject;
        if (finderObject2 == null) {
            p.btv("feedObject");
        }
        aoq aoq = finderObject2.attachmentList;
        this.tuP = (aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null) ? null : bei.LIA;
        FinderObject finderObject3 = this.feedObject;
        if (finderObject3 == null) {
            p.btv("feedObject");
        }
        this.contact = finderObject3.contact;
        this.uOV = cl.aWA();
        AppMethodBeat.o(248860);
    }

    public final boolean isPrivate() {
        AppMethodBeat.i(248861);
        FinderObject finderObject = this.feedObject;
        if (finderObject == null) {
            p.btv("feedObject");
        }
        if (finderObject.privateFlag == 1 || dkZ()) {
            AppMethodBeat.o(248861);
            return true;
        }
        AppMethodBeat.o(248861);
        return false;
    }

    public final boolean djo() {
        AppMethodBeat.i(248862);
        cjl cjl = (cjl) j.kt(dkV());
        if (cjl == null) {
            AppMethodBeat.o(248862);
            return false;
        } else if (cjl.width > cjl.height) {
            AppMethodBeat.o(248862);
            return true;
        } else {
            AppMethodBeat.o(248862);
            return false;
        }
    }

    public final boolean dkY() {
        cng cng = this.tuP;
        return (cng != null ? cng.MtH : 0) != 0;
    }

    public final boolean dkZ() {
        cng cng = this.tuP;
        return (cng != null ? cng.MtH : 0) != 0;
    }
}
