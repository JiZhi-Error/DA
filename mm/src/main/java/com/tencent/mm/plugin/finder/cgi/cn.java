package com.tencent.mm.plugin.finder.cgi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.data.u;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VBK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\u001c\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010<\u001a\u0004\u0018\u00010=J\b\u0010>\u001a\u0004\u0018\u00010\u0004J\b\u0010?\u001a\u0004\u0018\u00010\bJ\b\u0010@\u001a\u0004\u0018\u00010AJ\u0006\u0010B\u001a\u00020\u0006J\u0006\u0010C\u001a\u00020\u0013J\b\u0010D\u001a\u0004\u0018\u00010EJ\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G02J\b\u0010H\u001a\u00020\nH\u0016J\b\u0010I\u001a\u0004\u0018\u00010JJ\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010#J>\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\b\u0010R\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R \u00101\u001a\b\u0012\u0004\u0012\u00020\u000402X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006W"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "topicId", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IJ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "fansCount", "getFansCount", "()I", "setFansCount", "(I)V", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "isOnlyFetchUserInfo", "setOnlyFetchUserInfo", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "getReq_username", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTopicId", "()J", "userTags", "Ljava/util/LinkedList;", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBizInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;", "getCampaignInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getFirstPageMD5", "getLastBuffer", "getLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getMaxId", "getPrivateLock", "getShopAppInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "getTopicList", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getUserPageFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cn extends ax implements m {
    public static final a twD = new a((byte) 0);
    private i callback;
    private final int dLS;
    public int fansCount;
    public int friendFollowCount;
    public int pullType;
    public d rr;
    public boolean tuG;
    public final String tuH;
    public List<? extends FinderItem> tvo;
    public boolean twC;
    public final long twp;
    public LinkedList<String> userTags;

    static {
        AppMethodBeat.i(165291);
        AppMethodBeat.o(165291);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ cn(java.lang.String r11, long r12, com.tencent.mm.bw.b r14, int r15, com.tencent.mm.protocal.protobuf.bbn r16, int r17, long r18, int r20) {
        /*
            r10 = this;
            r0 = r20 & 2
            if (r0 == 0) goto L_0x0039
            r2 = 0
        L_0x0006:
            r0 = r20 & 4
            if (r0 == 0) goto L_0x0037
            r4 = 0
        L_0x000b:
            r0 = r20 & 8
            if (r0 == 0) goto L_0x0035
            r5 = 0
        L_0x0010:
            r0 = r20 & 32
            if (r0 == 0) goto L_0x0032
            r7 = 0
        L_0x0015:
            r0 = r20 & 64
            if (r0 == 0) goto L_0x002f
            r8 = 0
        L_0x001b:
            r0 = r10
            r1 = r11
            r6 = r16
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            r0 = 242533(0x3b365, float:3.39861E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r0)
            r0 = 242533(0x3b365, float:3.39861E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            return
        L_0x002f:
            r8 = r18
            goto L_0x001b
        L_0x0032:
            r7 = r17
            goto L_0x0015
        L_0x0035:
            r5 = r15
            goto L_0x0010
        L_0x0037:
            r4 = r14
            goto L_0x000b
        L_0x0039:
            r2 = r12
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.cn.<init>(java.lang.String, long, com.tencent.mm.bw.b, int, com.tencent.mm.protocal.protobuf.bbn, int, long, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cn(String str, long j2, b bVar, int i2, bbn bbn, int i3, long j3) {
        super(bbn);
        String str2;
        int i4;
        String str3;
        p.h(str, "req_username");
        AppMethodBeat.i(242532);
        this.tuH = str;
        this.dLS = i3;
        this.twp = j3;
        this.tuG = true;
        this.userTags = new LinkedList<>();
        c.a aVar = c.tsp;
        g asG = c.a.asG(this.tuH);
        if (asG == null || (str3 = asG.field_firstPageMD5) == null) {
            str2 = "";
        } else {
            str2 = str3;
        }
        d.a aVar2 = new d.a();
        aVar2.MB("/cgi-bin/micromsg-bin/finderuserpage");
        aVar2.sG(getType());
        beb beb = new beb();
        beb.username = this.tuH;
        beb.DIf = j2;
        beb.firstPageMD5 = str2;
        beb.LAt = z.aUg();
        beb.dLS = this.dLS;
        beb.twp = this.twp;
        am amVar = am.tuw;
        beb.uli = am.a(bbn);
        aov aov = beb.uli;
        if (aov != null) {
            aov.scene = bbn != null ? bbn.tyh : 0;
        }
        if (!n.I(beb.username, beb.LAt, false)) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!((Boolean) com.tencent.mm.plugin.finder.storage.c.hVd().value()).booleanValue()) {
                i4 = 0;
                beb.LAu = i4;
                beb.lastBuffer = bVar;
                am amVar2 = am.tuw;
                beb.LAv = am.cXZ();
                FinderUserPageResponse finderUserPageResponse = new FinderUserPageResponse();
                aVar2.c(beb);
                aVar2.d(finderUserPageResponse);
                d aXF = aVar2.aXF();
                p.g(aXF, "builder.buildInstance()");
                this.rr = aXF;
                this.pullType = i2;
                Log.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + j2 + " username " + this.tuH + " pullType " + i2 + " fpMD5 " + str2);
                AppMethodBeat.o(242532);
            }
        }
        i4 = 1;
        beb.LAu = i4;
        beb.lastBuffer = bVar;
        am amVar22 = am.tuw;
        beb.LAv = am.cXZ();
        FinderUserPageResponse finderUserPageResponse2 = new FinderUserPageResponse();
        aVar2.c(beb);
        aVar2.d(finderUserPageResponse2);
        d aXF2 = aVar2.aXF();
        p.g(aXF2, "builder.buildInstance()");
        this.rr = aXF2;
        this.pullType = i2;
        Log.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + j2 + " username " + this.tuH + " pullType " + i2 + " fpMD5 " + str2);
        AppMethodBeat.o(242532);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        String str2;
        List<? extends FinderItem> list;
        String str3;
        String str4;
        bac bac;
        bac bac2;
        bac bac3;
        bac bac4;
        bac bac5;
        AppMethodBeat.i(242527);
        Log.i("Finder.NetSceneFinderUserPage", "errType " + i3 + ", errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            e.INSTANCE.idkeyStat(1279, 13, 1, false);
            com.tencent.mm.bw.a aYK = this.rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
                AppMethodBeat.o(242527);
                throw tVar;
            }
            FinderUserPageResponse finderUserPageResponse = (FinderUserPageResponse) aYK;
            String str5 = this.tuH;
            LinkedList<String> linkedList = finderUserPageResponse.userTags;
            p.g(linkedList, "resp.userTags");
            this.userTags = linkedList;
            this.friendFollowCount = finderUserPageResponse.friendFollowCount;
            this.fansCount = finderUserPageResponse.fansCount;
            com.tencent.mm.plugin.finder.preload.a aVar = com.tencent.mm.plugin.finder.preload.a.uTO;
            baw baw = finderUserPageResponse.preloadInfo;
            LinkedList<FinderObject> linkedList2 = finderUserPageResponse.object;
            p.g(linkedList2, "resp.`object`");
            com.tencent.mm.plugin.finder.preload.a.a(baw, linkedList2, 3736);
            FinderContact finderContact = finderUserPageResponse.contact;
            if (finderContact != null) {
                StringBuilder sb = new StringBuilder("contact info ");
                p.g(finderContact, LocaleUtil.ITALIAN);
                Log.i("Finder.NetSceneFinderUserPage", sb.append(com.tencent.mm.ac.g.bN(finderContact)).append(" fansCount: ").append(finderUserPageResponse.fansCount).append(" friendFollowCount:").append(finderUserPageResponse.friendFollowCount).toString());
                String str6 = finderContact.username;
                if (str6 == null) {
                    str3 = "";
                } else {
                    str3 = str6;
                }
                c.a aVar2 = c.tsp;
                c.a.a(finderContact);
                String str7 = finderContact.username;
                if (!(str7 == null || str7.length() == 0) && (!p.j(finderContact.username, this.tuH))) {
                    FinderContact finderContact2 = new FinderContact();
                    try {
                        finderContact2.parseFrom(finderContact.toByteArray());
                    } catch (Exception e2) {
                        Log.printDebugStack("safeParser", "", e2);
                        finderContact2 = null;
                    }
                    FinderContact finderContact3 = finderContact2;
                    if (finderContact3 != null) {
                        finderContact3.username = this.tuH;
                        c.a aVar3 = c.tsp;
                        c.a.a(finderContact3);
                        Log.i("Finder.NetSceneFinderUserPage", "duplicate contact for " + this.tuH + ", " + str3);
                        x xVar = x.SXb;
                    }
                }
                c.a aVar4 = c.tsp;
                g asG = c.a.asG(finderContact.username);
                if (asG != null) {
                    asG.field_firstPageMD5 = finderUserPageResponse.firstPageMD5;
                    c.a aVar5 = c.tsp;
                    c.a.c(asG);
                    if (p.j(asG.getUsername(), z.aUg())) {
                        if (finderUserPageResponse.fansCount > 0) {
                            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh, "MMKernel.storage()");
                            aAh.azQ().set(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, Integer.valueOf(finderUserPageResponse.fansCount));
                        }
                        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh2, "MMKernel.storage()");
                        ao azQ = aAh2.azQ();
                        ar.a aVar6 = ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC;
                        FinderContact finderContact4 = finderUserPageResponse.contact;
                        azQ.set(aVar6, finderContact4 != null ? finderContact4.nickname : null);
                        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh3, "MMKernel.storage()");
                        ao azQ2 = aAh3.azQ();
                        ar.a aVar7 = ar.a.USERINFO_MY_FINDER_SIGNATURE_STRING_SYNC;
                        FinderContact finderContact5 = finderUserPageResponse.contact;
                        azQ2.set(aVar7, finderContact5 != null ? finderContact5.signature : null);
                        com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh4, "MMKernel.storage()");
                        ao azQ3 = aAh4.azQ();
                        ar.a aVar8 = ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC;
                        FinderContact finderContact6 = finderUserPageResponse.contact;
                        azQ3.set(aVar8, finderContact6 != null ? finderContact6.headUrl : null);
                        com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh5, "MMKernel.storage()");
                        ao azQ4 = aAh5.azQ();
                        ar.a aVar9 = ar.a.USERINFO_MY_FINDER_COVER_IMG_STRING_SYNC;
                        FinderContact finderContact7 = finderUserPageResponse.contact;
                        azQ4.set(aVar9, finderContact7 != null ? finderContact7.coverImgUrl : null);
                        com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh6, "MMKernel.storage()");
                        ao azQ5 = aAh6.azQ();
                        ar.a aVar10 = ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC;
                        FinderContact finderContact8 = finderUserPageResponse.contact;
                        azQ5.set(aVar10, finderContact8 != null ? Integer.valueOf(finderContact8.extFlag) : null);
                        com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh7, "MMKernel.storage()");
                        ao azQ6 = aAh7.azQ();
                        ar.a aVar11 = ar.a.USERINFO_MY_FINDER_ORIGINAL_FLAG2_INT_SYNC;
                        FinderContact finderContact9 = finderUserPageResponse.contact;
                        azQ6.set(aVar11, finderContact9 != null ? Integer.valueOf(finderContact9.originalFlag) : null);
                        com.tencent.mm.kernel.e aAh8 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh8, "MMKernel.storage()");
                        ao azQ7 = aAh8.azQ();
                        ar.a aVar12 = ar.a.USERINFO_MY_FINDER_ORIGINAL_ENTRANCE2_INT_SYNC;
                        FinderContact finderContact10 = finderUserPageResponse.contact;
                        azQ7.set(aVar12, finderContact10 != null ? Integer.valueOf(finderContact10.originalEntranceFlag) : null);
                        FinderContact finderContact11 = finderUserPageResponse.contact;
                        if ((finderContact11 != null ? finderContact11.originalInfo : null) != null) {
                            com.tencent.mm.kernel.e aAh9 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh9, "MMKernel.storage()");
                            ao azQ8 = aAh9.azQ();
                            ar.a aVar13 = ar.a.USERINFO_MY_FINDER_ORIGINAL_REPOST_COUNT_INT_SYNC;
                            FinderContact finderContact12 = finderUserPageResponse.contact;
                            azQ8.set(aVar13, (finderContact12 == null || (bac5 = finderContact12.originalInfo) == null) ? null : Integer.valueOf(bac5.LJQ));
                            com.tencent.mm.kernel.e aAh10 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh10, "MMKernel.storage()");
                            ao azQ9 = aAh10.azQ();
                            ar.a aVar14 = ar.a.USERINFO_MY_FINDER_ORIGINAL_APPLY_COUNT_INT_SYNC;
                            FinderContact finderContact13 = finderUserPageResponse.contact;
                            azQ9.set(aVar14, (finderContact13 == null || (bac4 = finderContact13.originalInfo) == null) ? null : Integer.valueOf(bac4.LJR));
                            com.tencent.mm.kernel.e aAh11 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh11, "MMKernel.storage()");
                            ao azQ10 = aAh11.azQ();
                            ar.a aVar15 = ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_INT_SYNC;
                            FinderContact finderContact14 = finderUserPageResponse.contact;
                            azQ10.set(aVar15, (finderContact14 == null || (bac3 = finderContact14.originalInfo) == null) ? null : Integer.valueOf(bac3.LJS));
                            com.tencent.mm.kernel.e aAh12 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh12, "MMKernel.storage()");
                            ao azQ11 = aAh12.azQ();
                            ar.a aVar16 = ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_YEAR_FLAG_INT_SYNC;
                            FinderContact finderContact15 = finderUserPageResponse.contact;
                            azQ11.set(aVar16, (finderContact15 == null || (bac2 = finderContact15.originalInfo) == null) ? null : Integer.valueOf(bac2.LJT));
                            com.tencent.mm.kernel.e aAh13 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh13, "MMKernel.storage()");
                            ao azQ12 = aAh13.azQ();
                            ar.a aVar17 = ar.a.USERINFO_MY_FINDER_ORIGINAL_NEED_CHECK_FLAG_INT_SYNC;
                            FinderContact finderContact16 = finderUserPageResponse.contact;
                            azQ12.set(aVar17, (finderContact16 == null || (bac = finderContact16.originalInfo) == null) ? null : Integer.valueOf(bac.LJU));
                        }
                        FinderContact finderContact17 = finderUserPageResponse.contact;
                        if ((finderContact17 != null ? finderContact17.authInfo : null) == null) {
                            com.tencent.mm.kernel.e aAh14 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh14, "MMKernel.storage()");
                            aAh14.azQ().set(ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC, "");
                        } else {
                            com.tencent.mm.kernel.e aAh15 = com.tencent.mm.kernel.g.aAh();
                            p.g(aAh15, "MMKernel.storage()");
                            ao azQ13 = aAh15.azQ();
                            ar.a aVar18 = ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC;
                            FinderAuthInfo finderAuthInfo = finderContact.authInfo;
                            azQ13.set(aVar18, Util.encodeHexString(finderAuthInfo != null ? finderAuthInfo.toByteArray() : null));
                        }
                        com.tencent.mm.kernel.e aAh16 = com.tencent.mm.kernel.g.aAh();
                        p.g(aAh16, "MMKernel.storage()");
                        ao azQ14 = aAh16.azQ();
                        ar.a aVar19 = ar.a.USERINFO_FINDER_LIVE_COVER_IMAGE_STRING_SYNC;
                        FinderContact finderContact18 = finderUserPageResponse.contact;
                        if (finderContact18 == null || (str4 = finderContact18.liveCoverImgUrl) == null) {
                            str4 = "";
                        }
                        azQ14.set(aVar19, str4);
                    }
                    x xVar2 = x.SXb;
                    str2 = str3;
                } else {
                    str2 = str3;
                }
            } else {
                str2 = str5;
            }
            if (this.twC) {
                Log.w("Finder.NetSceneFinderUserPage", "isOnlyFetchUserInfo=true");
                if (this.callback != null) {
                    i iVar = this.callback;
                    if (iVar == null) {
                        p.hyc();
                    }
                    iVar.onSceneEnd(i3, i4, str, this);
                    x xVar3 = x.SXb;
                }
                AppMethodBeat.o(242527);
                return;
            }
            LinkedList<FinderObject> linkedList3 = finderUserPageResponse.object;
            if (linkedList3 == null) {
                p.hyc();
            }
            StringBuilder append = new StringBuilder("cgiBack: continueFlag:").append(finderUserPageResponse.continueFlag).append(", list:");
            al alVar = al.tuv;
            Log.i("Finder.NetSceneFinderUserPage", append.append(al.dQ(linkedList3)).toString());
            Log.i("Finder.NetSceneFinderUserPage", "onGYNetEnd list:" + linkedList3.size());
            this.tuG = finderUserPageResponse.continueFlag == 1;
            boolean z = this.pullType != 2;
            ArrayList arrayList = new ArrayList();
            for (T t : linkedList3) {
                y yVar = y.vXH;
                if (y.r((FinderObject) t)) {
                    arrayList.add(t);
                }
            }
            c.a aVar20 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            this.tvo = c.a.a(arrayList, 2, this.ttO);
            if (z && this.twp == 0 && (list = this.tvo) != null) {
                if (this.dLS == 1) {
                    LinkedList linkedList4 = new LinkedList();
                    for (T t2 : list) {
                        cng megaVideo = t2.getMegaVideo();
                        if (megaVideo != null) {
                            linkedList4.add(new u(megaVideo.id, 32768, t2.getFeedObject()));
                        }
                    }
                    if (linkedList4.size() > 0) {
                        l.a aVar21 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                        String aUg = TextUtils.isEmpty(this.tuH) ? z.aUg() : this.tuH;
                        p.g(aUg, "if (TextUtils.isEmpty(re…rname() else req_username");
                        l.a.a(13, aUg, linkedList4);
                    }
                } else {
                    c.a aVar22 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    List<? extends FinderItem> list2 = list;
                    ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        c.a aVar23 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        arrayList2.add(c.a.s(it.next()));
                    }
                    c.a.a(arrayList2, 2, str2, z);
                }
                x xVar4 = x.SXb;
            }
        } else {
            e.INSTANCE.idkeyStat(1279, 14, 1, false);
        }
        if (this.callback != null) {
            i iVar2 = this.callback;
            if (iVar2 == null) {
                p.hyc();
            }
            iVar2.onSceneEnd(i3, i4, str, this);
            x xVar5 = x.SXb;
        }
        AppMethodBeat.o(242527);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3736;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(165289);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(165289);
        return dispatch;
    }

    public final long cZj() {
        AppMethodBeat.i(242528);
        com.tencent.mm.bw.a aYJ = this.rr.aYJ();
        if (aYJ == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageRequest");
            AppMethodBeat.o(242528);
            throw tVar;
        }
        long j2 = ((beb) aYJ).DIf;
        AppMethodBeat.o(242528);
        return j2;
    }

    public final FinderContact cZk() {
        AppMethodBeat.i(242529);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
            AppMethodBeat.o(242529);
            throw tVar;
        }
        FinderContact finderContact = ((FinderUserPageResponse) aYK).contact;
        AppMethodBeat.o(242529);
        return finderContact;
    }

    public final b getLastBuffer() {
        AppMethodBeat.i(242530);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
            AppMethodBeat.o(242530);
            throw tVar;
        }
        b bVar = ((FinderUserPageResponse) aYK).lastBuffer;
        AppMethodBeat.o(242530);
        return bVar;
    }

    public final bel cZl() {
        AppMethodBeat.i(242531);
        com.tencent.mm.bw.a aYK = this.rr.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
            AppMethodBeat.o(242531);
            throw tVar;
        }
        bel bel = ((FinderUserPageResponse) aYK).wxaShopInfo;
        AppMethodBeat.o(242531);
        return bel;
    }
}
