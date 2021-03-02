package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.q;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.data.o;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u001c\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010.\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J\b\u0010/\u001a\u0004\u0018\u00010\u000fJ\b\u00100\u001a\u00020+H\u0016J\b\u00101\u001a\u000202H\u0016J>\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0018\u0010;\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u000fH\u0002J\b\u0010<\u001a\u00020(H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", ClientInfoTable.Columns.CLIENTID, "", ch.COL_LOCALID, "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getLocalId", "()J", "postRequest", "Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;", "getPostRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;", "setPostRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "buildSvrLongVideoDesc", "Lcom/tencent/mm/protocal/protobuf/FinderAttachmentList;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "copyLocalMediaFiles", "", "svrFeed", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFeedObject", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateLocalFeed", "updateRecentAtContact", "Companion", "plugin-finder_release"})
public final class cb extends ax implements m {
    public static final a twc = new a((byte) 0);
    private i callback;
    public final String clientId;
    public FinderObject feedObject = this.tuX.getFeedObject();
    private final long localId;
    private d rr;
    private FinderItem tuX;
    public baq twb;

    static {
        AppMethodBeat.i(165259);
        AppMethodBeat.o(165259);
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x036b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public cb(com.tencent.mm.plugin.finder.storage.FinderItem r12, java.lang.String r13, long r14) {
        /*
        // Method dump skipped, instructions count: 1051
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.cb.<init>(com.tencent.mm.plugin.finder.storage.FinderItem, java.lang.String, long):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final aoq cZa() {
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        cng cng;
        cnl cnl;
        AppMethodBeat.i(242492);
        aoq aoq = this.feedObject.attachmentList;
        if (!(aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null || (cnl = cng.MtG) == null)) {
            LinkedList<cod> linkedList2 = new LinkedList<>();
            LinkedList<cjl> longVideoMediaExtList = this.tuX.getLongVideoMediaExtList();
            ArrayList arrayList = new ArrayList(j.a(longVideoMediaExtList, 10));
            for (T t : longVideoMediaExtList) {
                cod d2 = o.d(t);
                d2.url = t.MoM;
                d2.thumbUrl = t.MoN;
                d2.md5sum = t.md5sum;
                arrayList.add(d2);
            }
            linkedList2.addAll(arrayList);
            cnl.media = linkedList2;
        }
        aoq aoq2 = this.feedObject.attachmentList;
        AppMethodBeat.o(242492);
        return aoq2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3585;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165254);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165254);
        return dispatch;
    }

    private final void a(long j2, FinderObject finderObject) {
        T t;
        boolean z;
        AppMethodBeat.i(165255);
        FinderItem Fz = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fz(j2);
        Log.i("Finder.LogPost.NetSceneFinderPost", "updateLocalFeed, isExist " + (Fz == null));
        if (Fz != null) {
            Fz.setPostFinish();
            e(finderObject);
            Fz.updateFinderObject(finderObject);
            l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            p.h(Fz, "item");
            l.a.c(j2, Fz);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            Iterator<T> it = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(3).wuc.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t2 = next;
                if (!(t2 instanceof BaseFinderFeed) || t2.feedObject.getLocalId() != j2 || j2 == 0) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                if (t3 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                    AppMethodBeat.o(165255);
                    throw tVar;
                }
                p.h(Fz, "<set-?>");
                t3.feedObject = Fz;
            }
            Fz.setMediaExtList(new LinkedList<>());
            Log.i("Finder.LogPost.NetSceneFinderPost", "updateLocalFeed, delete local feed " + ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().A(j2, false) + ", localId:" + Fz.getLocalId() + ", id:" + Fz.getId());
            e.a aVar3 = e.vFX;
            long j3 = finderObject.id;
            p.h(Fz, "finder");
            Map map = e.tsn;
            p.g(map, "cacheItems");
            map.put(Long.valueOf(j3), Fz);
            AppMethodBeat.o(165255);
            return;
        }
        AppMethodBeat.o(165255);
    }

    private final void e(FinderObject finderObject) {
        LinkedList<FinderMedia> linkedList;
        T t;
        AppMethodBeat.i(165256);
        int i2 = 0;
        for (T t2 : this.tuX.getMediaExtList()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t3 = t2;
            f fVar = f.vSz;
            String str = t3.url;
            if (str == null) {
                str = "";
            }
            f.avV(str);
            f fVar2 = f.vSz;
            String str2 = t3.thumbUrl;
            if (str2 == null) {
                str2 = "";
            }
            f.avV(str2);
            FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
            if (!(finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null)) {
                Iterator<T> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (p.j(next.url, t3.MoM)) {
                        t = next;
                        break;
                    }
                }
                T t4 = t;
                if (t4 != null) {
                    Log.v("Finder.LogPost.NetSceneFinderPost", "cpFiles new MediaId mediaID " + t3.mediaId + " newMediaID " + MD5Util.getMD5String(t4.url));
                    t3.mediaId = MD5Util.getMD5String(t4.url);
                    if (t3.mediaType == 2 || t3.mediaType == 7) {
                        k kVar = new k(t3, x.THUMB_IMAGE, null, null, 12);
                        k kVar2 = new k(t3, x.FULL_IMAGE, null, null, 12);
                        Log.i("Finder.LogPost.NetSceneFinderPost", "cp image files thumbUrl " + t3.thumbUrl + " to path " + kVar.getPath() + " url " + t4.thumbUrl);
                        Log.i("Finder.LogPost.NetSceneFinderPost", "cp image files url " + t3.url + " to path " + kVar2.getPath() + "  url " + t4.url);
                        s.nw(t3.thumbUrl, kVar.getPath());
                        s.nw(t3.url, kVar2.getPath());
                    }
                    if (t3.mediaType == 4) {
                        k kVar3 = new k(t3, x.THUMB_IMAGE, null, null, 12);
                        int i4 = com.tencent.mm.modelcontrol.e.sX(4) ? 2 : 1;
                        com.tencent.mm.plugin.finder.loader.s sVar = new com.tencent.mm.plugin.finder.loader.s(t3, x.V99_VIDEO, i4, null, 8);
                        q qVar = new q(t3, x.FULL_IMAGE);
                        com.tencent.mm.plugin.finder.loader.i iVar = new com.tencent.mm.plugin.finder.loader.i(t3, x.THUMB_IMAGE);
                        Log.i("Finder.LogPost.NetSceneFinderPost", "cp video files thumbUrl " + t3.thumbUrl + " to path " + kVar3.getPath() + "  url " + t4.thumbUrl);
                        Log.i("Finder.LogPost.NetSceneFinderPost", "cp video files url " + t3.url + " to path " + sVar.getPath() + "  url " + t4.url);
                        Log.i("Finder.LogPost.NetSceneFinderPost", "cp cover files url " + t3.coverUrl + " to path " + qVar.getPath() + "  url " + t4.coverUrl);
                        Log.i("Finder.LogPost.NetSceneFinderPost", "cp fullThumb files url " + t3.MoR + " to path " + qVar.getPath() + "  url " + t4.coverUrl);
                        s.nw(t3.thumbUrl, kVar3.getPath());
                        s.nw(t3.url, sVar.getPath());
                        s.nw(t3.coverUrl, qVar.getPath());
                        s.nw(t3.MoR, iVar.getPath());
                        long boW = s.boW(t3.url);
                        com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                        String auA = sVar.auA();
                        String str3 = t3.mediaId;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = t3.url;
                        if (str4 == null) {
                            str4 = "";
                        }
                        com.tencent.mm.plugin.finder.storage.logic.d.a(auA, str3, str4, i4, x.V99_VIDEO.detail, boW, boW, 3, sVar.uIw.videoDuration, "", "");
                    }
                    i2 = i3;
                }
            }
            i2 = i3;
        }
        AppMethodBeat.o(165256);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar) {
        FinderObject finderObject;
        AppMethodBeat.i(242493);
        Log.i("Finder.LogPost.NetSceneFinderPost", "errType %d, errCode %d, errMsg %s, localId %s localId:" + this.tuX.getLocalId(), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(this.localId));
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 5, 1, false);
            d dVar = this.rr;
            com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostResponse");
                AppMethodBeat.o(242493);
                throw tVar;
            }
            FinderObject finderObject2 = ((bar) aYK).LKm;
            Log.i("Finder.LogPost.NetSceneFinderPost", "onGYNetEnd " + finderObject2 + ' ' + (finderObject2 != null ? Long.valueOf(finderObject2.id) : null) + ", localId:" + this.localId);
            c.a aVar = c.vGN;
            if (c.a.FR(this.localId)) {
                FinderContact finderContact = this.feedObject.contact;
                if (finderObject2 == null) {
                    finderObject = this.feedObject;
                } else {
                    finderObject = finderObject2;
                }
                this.feedObject = finderObject;
                FinderObject finderObject3 = this.feedObject;
                String str2 = this.feedObject.nickname;
                if (str2 == null) {
                    str2 = finderContact != null ? finderContact.nickname : null;
                }
                if (str2 == null) {
                    str2 = "";
                }
                finderObject3.nickname = str2;
                this.feedObject.contact = finderContact;
                a(this.localId, this.feedObject);
                cZb();
                e.a aVar2 = e.vFX;
                FinderItem Fy = e.a.Fy(this.feedObject.id);
                if (Fy != null) {
                    j.a aVar3 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                    kotlin.o<Boolean, Boolean> Ga = com.tencent.mm.plugin.finder.upload.action.j.vUv.Ga(this.localId);
                    boolean booleanValue = Ga.first.booleanValue();
                    boolean booleanValue2 = Ga.second.booleanValue();
                    if (booleanValue) {
                        j.a aVar4 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                        com.tencent.mm.plugin.finder.upload.action.j jVar = com.tencent.mm.plugin.finder.upload.action.j.vUv;
                        long j2 = this.localId;
                        p.h(Fy, "feed");
                        Log.i(com.tencent.mm.plugin.finder.upload.action.j.TAG, "doLikeLocalFeed localId:" + j2 + ", isPrivate:" + booleanValue2 + ", feedid:" + Fy.getId());
                        u uVar = jVar.vUu.get(Long.valueOf(j2));
                        if (uVar != null) {
                            aj ajVar = aj.uOw;
                            bbn bbn = uVar.field_contextObj;
                            p.g(bbn, "action.field_contextObj");
                            int i5 = uVar.field_likeAction;
                            int i6 = uVar.field_scene;
                            boolean z = uVar.field_showTips;
                            y yVar = y.vXH;
                            aj.a(bbn, i5, Fy, true, booleanValue2, i6, z, false, y.dnv());
                        }
                    }
                }
            } else if (finderObject2 != null) {
                String aUg = z.aUg();
                p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                com.tencent.mm.kernel.g.azz().b(new av(aUg, finderObject2));
            }
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1279, 6, 1, false);
            r.d dVar2 = r.d.vhx;
            r.d.oj(this.tuX.isLongVideo());
            com.tencent.mm.plugin.finder.spam.a aVar5 = com.tencent.mm.plugin.finder.spam.a.vwk;
            boolean gj = com.tencent.mm.plugin.finder.spam.a.gj(i3, i4);
            boolean z2 = i4 == -4013;
            if (i3 == 4 || !gj || z2) {
                c.a aVar6 = c.vGN;
                FinderItem FS = c.a.FS(this.localId);
                if (FS != null) {
                    if (!gj) {
                        r.d dVar3 = r.d.vhx;
                        r.d.ok(this.tuX.isLongVideo());
                        FS.setPostFailedAndNotRetry(i4);
                    } else if (z2) {
                        FS.setPostFailedAndNoAuth();
                    } else {
                        FS.setPostFailed();
                    }
                    this.tuX.field_localFlag = FS.field_localFlag;
                    c.a aVar7 = c.vGN;
                    c.a.r(FS);
                }
                r.d dVar4 = r.d.vhx;
                r.d.ob(this.tuX.isLongVideo());
            }
        }
        if (this.callback != null) {
            i iVar = this.callback;
            if (iVar == null) {
                p.hyc();
            }
            iVar.onSceneEnd(i3, i4, str, this);
        }
        com.tencent.mm.plugin.finder.spam.a aVar8 = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.v(i3, i4, str);
        AppMethodBeat.o(242493);
    }

    private final void cZb() {
        cjj cjj;
        AppMethodBeat.i(242494);
        Iterator<cjj> it = this.tuX.field_postinfo.Mpg.iterator();
        while (it.hasNext()) {
            it.next().wal = this.tuX.field_createTime;
        }
        com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
        LinkedList<cjj> linkedList = this.tuX.field_postinfo.Mpg;
        p.g(linkedList, "finderItem.field_postinfo.atContactList");
        p.h(linkedList, "atContacts");
        if (!linkedList.isEmpty()) {
            LinkedList<cjj> dBy = com.tencent.mm.plugin.finder.utils.d.dBy();
            if (dBy == null) {
                dBy = new LinkedList<>();
            }
            HashMap hashMap = new HashMap(dBy.size());
            Iterator<cjj> it2 = dBy.iterator();
            while (it2.hasNext()) {
                cjj next = it2.next();
                String str = next.username;
                if (str == null) {
                    str = "";
                }
                hashMap.put(str, next);
            }
            Iterator<cjj> it3 = linkedList.iterator();
            while (it3.hasNext()) {
                cjj next2 = it3.next();
                if (!Util.isNullOrNil(next2.username) && ((cjj = (cjj) hashMap.get(next2.username)) == null || cjj.wal < next2.wal)) {
                    String str2 = next2.username;
                    if (str2 == null) {
                        str2 = "";
                    }
                    hashMap.put(str2, next2);
                }
            }
            dBy.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                entry.getKey();
                dBy.add((cjj) entry.getValue());
            }
            Collections.sort(dBy, d.b.vVj);
            if (dBy.size() > 5) {
                for (int size = dBy.size() - 1; size >= 5; size--) {
                    dBy.remove(size);
                }
            }
            cjn cjn = new cjn();
            cjn.LDz = dBy;
            try {
                byte[] byteArray = cjn.toByteArray();
                if (byteArray == null) {
                    AppMethodBeat.o(242494);
                    return;
                }
                com.tencent.mm.plugin.finder.utils.d.VQ().encode("_finder_at_mmkv_recent_at", byteArray);
            } catch (IOException e2) {
                FinderPostAtUI.a aVar = FinderPostAtUI.vME;
                Log.printErrStackTrace(FinderPostAtUI.TAG, e2, "_writeRecentAt, LocalFinderRecentAtContactCache, _write: %s", e2.getMessage());
                AppMethodBeat.o(242494);
                return;
            }
        }
        AppMethodBeat.o(242494);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final b cXS() {
        return b.Enable;
    }
}
