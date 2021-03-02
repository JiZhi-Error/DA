package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr;", "", "()V", "Companion", "plugin-card_release"})
public final class a {
    private static final String TAG = TAG;
    public static final C0902a pVg = new C0902a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\bJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\rJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u0004\u0018\u00010#J&\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020)J\b\u0010*\u001a\u0004\u0018\u00010+J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u000fJ\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\bJ0\u00102\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u00104\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001dJ\u000e\u00105\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u00106\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020#J&\u00107\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020)J\u000e\u00108\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020+J\u000e\u00109\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v2/CardSnapshotMgr$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCouponListSortInfo", "Lcom/tencent/mm/protocal/protobuf/CardSortInfo;", "getVipCardListSortInfo", "loadCouponCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "loadCouponGiftCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "loadCouponHistoryCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "loadHomePageSnapshot", "", "storeList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageStoreList;", "underList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageUnderList;", "topList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellList;", "cardSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "faqItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadHomePageV3Snapshot", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "loadInvalidTicketPageSnapshot", "", "invalidTicketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "loadMemberCardHistoryListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "loadTicketPageSnapshot", "jumpList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "ticketList", "licenseList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "loadVipCardListSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "saveCouponAndGiftCardListSnapshot", "response", "saveCouponCardListSnapshot", "saveCouponHistoryCardListSnapshot", "saveCouponListSortInfo", "sortInfo", "saveHomePageSnapshot", "sortInfoList", "saveHomePageV3Snapshot", "saveInvalidTicketPageSnapshot", "saveMemberCardHistoryListSnapshot", "saveTicketPageSnapshot", "saveVipCardListSnapshot", "saveVipCardListSortInfo", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.a$a  reason: collision with other inner class name */
    public static final class C0902a {
        private C0902a() {
        }

        public /* synthetic */ C0902a(byte b2) {
            this();
        }

        public static bqq cuh() {
            boolean z;
            bqq bqq;
            AppMethodBeat.i(201361);
            Log.d(a.TAG, "load home page v3 snapshot");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(ar.a.USERINFO_CARD_HOME_PAGE_V3_STRING_SYNC, "");
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(201361);
                return null;
            }
            bqq bqq2 = new bqq();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(201361);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            try {
                bqq2.parseFrom(bytes);
                bqq = bqq2;
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                bqq = null;
            }
            bqq bqq3 = bqq;
            AppMethodBeat.o(201361);
            return bqq3;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.a$a$e */
        public static final class e extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ bqq pVl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(bqq bqq) {
                super(0);
                this.pVl = bqq;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201357);
                byte[] byteArray = this.pVl.toByteArray();
                p.g(byteArray, "response.toByteArray()");
                String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_CARD_HOME_PAGE_V3_STRING_SYNC, str);
                x xVar = x.SXb;
                AppMethodBeat.o(201357);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.a$a$g */
        public static final class g extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ bqk pVn;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(bqk bqk) {
                super(0);
                this.pVn = bqk;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201359);
                byte[] byteArray = this.pVn.toByteArray();
                p.g(byteArray, "response.toByteArray()");
                String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_CARD_VIPCARD_LIST_STRING_SYNC, str);
                x xVar = x.SXb;
                AppMethodBeat.o(201359);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.a$a$h */
        public static final class h extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ uv pVk;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public h(uv uvVar) {
                super(0);
                this.pVk = uvVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201360);
                byte[] byteArray = this.pVk.toByteArray();
                p.g(byteArray, "sortInfo.toByteArray()");
                String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_CARD_VIPCARD_SORTINFO_STRING_SYNC, str);
                x xVar = x.SXb;
                AppMethodBeat.o(201360);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.a$a$b */
        public static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ bma pVi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(bma bma) {
                super(0);
                this.pVi = bma;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201354);
                byte[] byteArray = this.pVi.toByteArray();
                p.g(byteArray, "response.toByteArray()");
                String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_CARD_COUPON_LIST_STRING_SYNC, str);
                x xVar = x.SXb;
                AppMethodBeat.o(201354);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.a$a$a  reason: collision with other inner class name */
        static final class C0903a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ bly pVh;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0903a(bly bly) {
                super(0);
                this.pVh = bly;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201353);
                byte[] byteArray = this.pVh.toByteArray();
                p.g(byteArray, "response.toByteArray()");
                String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_CARD_COUPON_GIFT_LIST_STRING_SYNC, str);
                x xVar = x.SXb;
                AppMethodBeat.o(201353);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.a$a$c */
        public static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ blw pVj;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(blw blw) {
                super(0);
                this.pVj = blw;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201355);
                byte[] byteArray = this.pVj.toByteArray();
                p.g(byteArray, "response.toByteArray()");
                String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_CARD_COUPON_HISTORY_LIST_STRING_SYNC, str);
                x xVar = x.SXb;
                AppMethodBeat.o(201355);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.a$a$f */
        public static final class f extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ bqi pVm;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(bqi bqi) {
                super(0);
                this.pVm = bqi;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201358);
                byte[] byteArray = this.pVm.toByteArray();
                p.g(byteArray, "response.toByteArray()");
                String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_CARD_MEMBER_CARD_HISTORY_STRING_SYNC, str);
                x xVar = x.SXb;
                AppMethodBeat.o(201358);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.a$a$d */
        public static final class d extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ uv pVk;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(uv uvVar) {
                super(0);
                this.pVk = uvVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(201356);
                byte[] byteArray = this.pVk.toByteArray();
                p.g(byteArray, "sortInfo.toByteArray()");
                String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_CARD_COUPON_LIST_SORTINFO_STRING_SYNC, str);
                x xVar = x.SXb;
                AppMethodBeat.o(201356);
                return xVar;
            }
        }

        public static bqk cui() {
            boolean z;
            bqk bqk;
            AppMethodBeat.i(201362);
            Log.d(a.TAG, "load vip card list snapshot");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(ar.a.USERINFO_CARD_VIPCARD_LIST_STRING_SYNC, "");
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(201362);
                return null;
            }
            bqk bqk2 = new bqk();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(201362);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            try {
                bqk2.parseFrom(bytes);
                bqk = bqk2;
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                bqk = null;
            }
            bqk bqk3 = bqk;
            AppMethodBeat.o(201362);
            return bqk3;
        }

        public static uv cuj() {
            boolean z;
            uv uvVar;
            AppMethodBeat.i(201363);
            Log.d(a.TAG, "load vip card list snapshot");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(ar.a.USERINFO_CARD_VIPCARD_SORTINFO_STRING_SYNC, "");
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(201363);
                return null;
            }
            uv uvVar2 = new uv();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(201363);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            try {
                uvVar2.parseFrom(bytes);
                uvVar = uvVar2;
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                uvVar = null;
            }
            uv uvVar3 = uvVar;
            AppMethodBeat.o(201363);
            return uvVar3;
        }

        public static bma cuk() {
            boolean z;
            bma bma;
            AppMethodBeat.i(201364);
            Log.d(a.TAG, "load vip card list snapshot");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(ar.a.USERINFO_CARD_COUPON_LIST_STRING_SYNC, "");
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(201364);
                return null;
            }
            bma bma2 = new bma();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(201364);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            try {
                bma2.parseFrom(bytes);
                bma = bma2;
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                bma = null;
            }
            bma bma3 = bma;
            AppMethodBeat.o(201364);
            return bma3;
        }

        public static bly cul() {
            boolean z;
            bly bly;
            AppMethodBeat.i(201365);
            Log.d(a.TAG, "load coupon and gift card list snapshot");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(ar.a.USERINFO_CARD_COUPON_GIFT_LIST_STRING_SYNC, "");
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(201365);
                return null;
            }
            bly bly2 = new bly();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(201365);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            try {
                bly2.parseFrom(bytes);
                bly = bly2;
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                bly = null;
            }
            bly bly3 = bly;
            AppMethodBeat.o(201365);
            return bly3;
        }

        public static void a(bly bly) {
            AppMethodBeat.i(201366);
            p.h(bly, "response");
            Log.d(a.TAG, "save coupon and gift card list snapshot");
            com.tencent.mm.ac.d.i(new C0903a(bly));
            AppMethodBeat.o(201366);
        }

        public static blw cum() {
            boolean z;
            blw blw;
            AppMethodBeat.i(201367);
            Log.d(a.TAG, "load coupon History card list snapshot");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(ar.a.USERINFO_CARD_COUPON_HISTORY_LIST_STRING_SYNC, "");
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(201367);
                return null;
            }
            blw blw2 = new blw();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(201367);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            try {
                blw2.parseFrom(bytes);
                blw = blw2;
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                blw = null;
            }
            blw blw3 = blw;
            AppMethodBeat.o(201367);
            return blw3;
        }

        public static bqi cun() {
            boolean z;
            bqi bqi;
            AppMethodBeat.i(201368);
            Log.d(a.TAG, "load coupon History card list snapshot");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(ar.a.USERINFO_CARD_MEMBER_CARD_HISTORY_STRING_SYNC, "");
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(201368);
                return null;
            }
            bqi bqi2 = new bqi();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(201368);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            try {
                bqi2.parseFrom(bytes);
                bqi = bqi2;
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                bqi = null;
            }
            bqi bqi3 = bqi;
            AppMethodBeat.o(201368);
            return bqi3;
        }

        public static uv cuo() {
            boolean z;
            uv uvVar;
            AppMethodBeat.i(201369);
            Log.d(a.TAG, "load vip card list snapshot");
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().get(ar.a.USERINFO_CARD_COUPON_LIST_SORTINFO_STRING_SYNC, "");
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(201369);
                return null;
            }
            uv uvVar2 = new uv();
            Charset charset = kotlin.n.d.ISO_8859_1;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(201369);
                throw tVar;
            }
            byte[] bytes = str.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            try {
                uvVar2.parseFrom(bytes);
                uvVar = uvVar2;
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
                uvVar = null;
            }
            uv uvVar3 = uvVar;
            AppMethodBeat.o(201369);
            return uvVar3;
        }
    }

    static {
        AppMethodBeat.i(112380);
        AppMethodBeat.o(112380);
    }
}
