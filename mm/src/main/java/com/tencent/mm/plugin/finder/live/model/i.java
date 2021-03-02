package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.live.b.o;
import com.tencent.mm.plugin.finder.live.util.p;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.protocal.protobuf.fgh;
import com.tencent.mm.protocal.protobuf.fgm;
import com.tencent.mm.protocal.protobuf.fgn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010\"\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010#\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010$\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J&\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*H\u0002J&\u0010+\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*H\u0002J\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020-0'2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'J\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020-0'2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020-0'2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'H\u0002J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020-0'2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'H\u0002J\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020-0'2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'J\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020-0'2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u00105\u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070'2\f\u00105\u001a\b\u0012\u0004\u0012\u0002070'H\u0002J\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020:092\f\u00105\u001a\b\u0012\u0004\u0012\u00020-0'H\u0002J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020-0'2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'H\u0002J\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020-0'2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'J\u0018\u0010=\u001a\u0004\u0018\u00010-2\f\u00105\u001a\b\u0012\u0004\u0012\u00020-0'H\u0002J,\u0010>\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002070'2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020-0'H\u0002J\u0018\u0010A\u001a\u0004\u0018\u0001072\f\u00105\u001a\b\u0012\u0004\u0012\u0002070'H\u0002J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u0002070'2\f\u00105\u001a\b\u0012\u0004\u0012\u0002070'H\u0002J\u001c\u0010C\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002070'JF\u0010D\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002070'2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020-0'2\u0006\u0010)\u001a\u00020*2\b\u0010F\u001a\u0004\u0018\u00010\u00042\b\u0010G\u001a\u0004\u0018\u00010\u0004J\u001c\u0010H\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020-0'J\u001c\u0010I\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020-0'J\u001c\u0010J\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020-0'J\u001c\u0010K\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020-0'J*\u0010L\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002070'2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020-0'J\u001c\u0010M\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002070'J\u0018\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020-H\u0002J\u0014\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR\u000e\u0010\u001c\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager;", "", "()V", "TAG", "", "acceptMicMsg", "", "acceptMicPkMsg", "addLocalGiftToMsg", "", "getAddLocalGiftToMsg", "()Z", "setAddLocalGiftToMsg", "(Z)V", "applyMicMsg", "applyMicPkMsg", "closeMicMsg", "closeMicPkMsg", "giftMsgType", "highLightCheerMsg", "msgInCommentList", "msgInFirstLevelBullet", "msgPromoteAd", "msgPromoteProduct", "pkStatusMsg", "saveMyselfComment", "getSaveMyselfComment", "setSaveMyselfComment", "topMsg", "appendGiftTip", "", "roomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "appendLinkMicTip", "appendLocationTip", "appendSysLawTip", "appendWelcomeTip", "checkCommentListSize", "remoteLiveMsg", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "maxCount", "", "checkCommentListSizeSaveMySelf", "filterAcceptLinkMicMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "appMsgList", "filterAcceptLinkMicPkMsg", "filterApplyLinkMicMsg", "filterApplyLinkMicPkMsg", "filterCloseLinkMicMsg", "filterCloseLinkMicPkMsg", "filterCommentMsg", "msgList", "filterFirstLevelBulletMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "filterGiftMsg", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "filterHighLightCheerMsg", "filterPkStatusMsg", "filterPromoteAdMsg", "filterPromoteProduct", "remote", "remoteAppMsg", "filterPromoteProductMsg", "filterTopMsg", "handleBulletMsg", "handleCommentMsg", "remoteLiveAppMsg", "selfID", "selfFinderID", "handleGiftMsg", "handleHighLightCheerMsg", "handleLinkMicMsg", "handleLinkMicPkMsg", "handlePromoteProductMsg", "handleTopMsg", "isMySelfLiveMsg", "scene", "liveMsg", "parsePromoteProductContent", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "msgContent", "plugin-finder_release"})
public final class i {
    private static final String TAG = TAG;
    private static final int[] UKq = {20021, 20022};
    private static final int[] UKr = {20016};
    private static final int[] UKs = {20015};
    private static final int[] UKt = {20017};
    private static final int[] UKu = {20018};
    private static boolean uiP;
    private static boolean uiQ;
    private static final int[] uiR = {o.c.aFn(), o.c.aFr(), o.c.aFs(), o.c.aFw(), o.c.aFq(), 20001, 20002, 20013, 20014, 20019, 20020};
    private static final int[] uiS = {o.c.aFv(), o.c.aFp()};
    private static final int[] uiT = {o.c.aFt(), o.c.aFu()};
    private static final int[] uiU = {20009};
    private static final int[] uiV = {o.c.aFx()};
    private static final int[] uiW = {20006};
    private static final int[] uiX = {20004};
    private static final int[] uiY = {20003};
    private static final int[] uiZ = {20005};
    public static final i uja = new i();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<aut, Boolean> {
        public static final a ujb = new a();

        static {
            AppMethodBeat.i(246140);
            AppMethodBeat.o(246140);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(aut aut) {
            boolean z;
            AppMethodBeat.i(246139);
            aut aut2 = aut;
            p.h(aut2, LocaleUtil.ITALIAN);
            i iVar = i.uja;
            boolean contains = kotlin.a.e.contains(i.uiU, aut2.ybm);
            i iVar2 = i.uja;
            if (!i.a("filterGiftMsg", aut2)) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z & contains);
            AppMethodBeat.o(246139);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<aut, p.b> {
        public static final b ujc = new b();

        static {
            AppMethodBeat.i(246142);
            AppMethodBeat.o(246142);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ p.b invoke(aut aut) {
            AppMethodBeat.i(246141);
            aut aut2 = aut;
            kotlin.g.b.p.h(aut2, LocaleUtil.ITALIAN);
            p.b bVar = new p.b(aut2);
            i iVar = i.uja;
            Log.i(i.TAG, "filterGiftMsg: giftShowInfo=" + bVar + ", client_msg_id=" + aut2.LFr + ", local_client_msg_id=" + aut2.LFF + ", quoted_msg_seq=" + aut2.LFA + ", seq=" + aut2.seq);
            AppMethodBeat.o(246141);
            return bVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<awq, Boolean> {
        public static final c ujd = new c();

        static {
            AppMethodBeat.i(246144);
            AppMethodBeat.o(246144);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(awq awq) {
            AppMethodBeat.i(246143);
            awq awq2 = awq;
            kotlin.g.b.p.h(awq2, LocaleUtil.ITALIAN);
            i iVar = i.uja;
            Boolean valueOf = Boolean.valueOf(kotlin.a.e.contains(i.uiT, awq2.type));
            AppMethodBeat.o(246143);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<aut, Boolean> {
        public static final e UKv = new e();

        static {
            AppMethodBeat.i(260459);
            AppMethodBeat.o(260459);
        }

        e() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(aut aut) {
            AppMethodBeat.i(260458);
            aut aut2 = aut;
            kotlin.g.b.p.h(aut2, LocaleUtil.ITALIAN);
            i iVar = i.uja;
            Boolean valueOf = Boolean.valueOf(kotlin.a.e.contains(i.UKq, aut2.ybm));
            AppMethodBeat.o(260458);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager$handleLinkMicMsg$1$1$1", "com/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager$$special$$inlined$let$lambda$1"})
    public static final class f extends q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ auw UKw;
        final /* synthetic */ aut UKx;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(auw auw, aut aut, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKw = auw;
            this.UKx = aut;
            this.UKy = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            AppMethodBeat.i(260460);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.uCo, this.UKw.Lmn));
            AppMethodBeat.o(260460);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager$handleLinkMicMsg$1$1$2", "com/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager$$special$$inlined$let$lambda$2"})
    public static final class g extends q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ auw UKw;
        final /* synthetic */ aut UKx;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(auw auw, aut aut, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKw = auw;
            this.UKx = aut;
            this.UKy = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            AppMethodBeat.i(260461);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.uCo, this.UKw.Lmn));
            AppMethodBeat.o(260461);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager$handleLinkMicPkMsg$1$1$1", "com/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager$$special$$inlined$let$lambda$3"})
    public static final class h extends q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ aut UKx;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKy;
        final /* synthetic */ fgh UKz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(fgh fgh, aut aut, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKz = fgh;
            this.UKx = aut;
            this.UKy = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            AppMethodBeat.i(260462);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.uCo, this.UKz.ViN));
            AppMethodBeat.o(260462);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, hxF = {"<anonymous>", "", "user", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager$handleLinkMicPkMsg$1$1$2", "com/tencent/mm/plugin/finder/live/model/FinderLiveMsgManager$$special$$inlined$let$lambda$4"})
    /* renamed from: com.tencent.mm.plugin.finder.live.model.i$i  reason: collision with other inner class name */
    public static final class C1186i extends q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ aut UKx;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKy;
        final /* synthetic */ fgh UKz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1186i(fgh fgh, aut aut, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKz = fgh;
            this.UKx = aut;
            this.UKy = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            AppMethodBeat.i(260463);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.uCo, this.UKz.ViN));
            AppMethodBeat.o(260463);
            return valueOf;
        }
    }

    static {
        boolean z;
        AppMethodBeat.i(246164);
        uiP = true;
        uiQ = true;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.dwg().value().intValue();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue2 = com.tencent.mm.plugin.finder.storage.c.dwh().value().intValue();
        uiP = intValue == 0;
        if (intValue2 == 0) {
            z = true;
        } else {
            z = false;
        }
        uiQ = z;
        Log.i(TAG, "sendLocalGiftToMsgValue :" + intValue + ",saveMyselfCommentValue:" + intValue2);
        o.c cVar3 = o.c.hGH;
        o.c cVar4 = o.c.hGH;
        o.c cVar5 = o.c.hGH;
        o.c cVar6 = o.c.hGH;
        o.c cVar7 = o.c.hGH;
        o.c cVar8 = o.c.hGH;
        o.c cVar9 = o.c.hGH;
        o.c cVar10 = o.c.hGH;
        o.c cVar11 = o.c.hGH;
        o.c cVar12 = o.c.hGH;
        AppMethodBeat.o(246164);
    }

    private i() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class d<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(246145);
            int a2 = kotlin.b.a.a(Long.valueOf(t.cKo()), Long.valueOf(t2.cKo()));
            AppMethodBeat.o(246145);
            return a2;
        }
    }

    private static LinkedList<t> ai(LinkedList<t> linkedList) {
        AppMethodBeat.i(246148);
        LinkedList<t> linkedList2 = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(uiR, t.getType())) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        AppMethodBeat.o(246148);
        return linkedList2;
    }

    private static aut ap(LinkedList<aut> linkedList) {
        aut aut;
        AppMethodBeat.i(260464);
        LinkedList<aut> linkedList2 = linkedList;
        ListIterator<aut> listIterator = linkedList2.listIterator(linkedList2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                aut = null;
                break;
            }
            aut previous = listIterator.previous();
            if (kotlin.a.e.contains(UKq, previous.ybm)) {
                aut = previous;
                break;
            }
        }
        aut aut2 = aut;
        AppMethodBeat.o(260464);
        return aut2;
    }

    public static LinkedList<aut> aj(LinkedList<aut> linkedList) {
        AppMethodBeat.i(246149);
        kotlin.g.b.p.h(linkedList, "appMsgList");
        LinkedList<aut> linkedList2 = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(uiX, t.ybm)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        AppMethodBeat.o(246149);
        return linkedList2;
    }

    public static LinkedList<aut> ak(LinkedList<aut> linkedList) {
        AppMethodBeat.i(246150);
        kotlin.g.b.p.h(linkedList, "appMsgList");
        LinkedList<aut> linkedList2 = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(uiZ, t.ybm)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        AppMethodBeat.o(246150);
        return linkedList2;
    }

    public static LinkedList<aut> bP(LinkedList<aut> linkedList) {
        AppMethodBeat.i(260465);
        kotlin.g.b.p.h(linkedList, "appMsgList");
        LinkedList<aut> linkedList2 = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(UKr, t.ybm)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        AppMethodBeat.o(260465);
        return linkedList2;
    }

    public static LinkedList<aut> bQ(LinkedList<aut> linkedList) {
        AppMethodBeat.i(260466);
        kotlin.g.b.p.h(linkedList, "appMsgList");
        LinkedList<aut> linkedList2 = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(UKt, t.ybm)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        AppMethodBeat.o(260466);
        return linkedList2;
    }

    public static LinkedList<aut> bR(LinkedList<aut> linkedList) {
        AppMethodBeat.i(260467);
        kotlin.g.b.p.h(linkedList, "appMsgList");
        LinkedList<aut> linkedList2 = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(UKu, t.ybm)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        AppMethodBeat.o(260467);
        return linkedList2;
    }

    private static axg atE(String str) {
        AppMethodBeat.i(246151);
        if (str != null) {
            try {
                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i(str);
                axg axg = new axg();
                axg.uko = iVar.optLong("product_id");
                com.tencent.mm.ab.i FK = iVar.FK("product_page");
                axg.LHI = new det();
                if (FK != null) {
                    det det = axg.LHI;
                    if (det != null) {
                        det.appId = FK.optString("app_id");
                    }
                    det det2 = axg.LHI;
                    if (det2 != null) {
                        det2.path = FK.optString("path");
                    }
                }
                axg.title = iVar.optString("title");
                axg.twt = iVar.optString("img_url");
                axg.LHJ = iVar.optInt("stock");
                axg.AZr = iVar.optInt("min_price");
                axg.AZq = iVar.optInt("max_price");
                axg.LHK = iVar.optInt("promoting");
                axg.LHL = iVar.optString("ext_buff");
                axg.LHM = iVar.optString("platform_name");
                axg.status = iVar.optInt("status");
                com.tencent.mm.ab.i FK2 = iVar.FK("user_purchase_page");
                axg.LHN = new det();
                if (FK2 != null) {
                    det det3 = axg.LHN;
                    if (det3 != null) {
                        det3.appId = FK2.optString("app_id");
                    }
                    det det4 = axg.LHN;
                    if (det4 != null) {
                        det4.path = FK2.optString("path");
                    }
                }
                axg.LHO = iVar.optInt("platform_id");
                axg.dCu = iVar.optString("app_username");
                axg.ukr = iVar.optString("shop_extra_data");
                AppMethodBeat.o(246151);
                return axg;
            } catch (Exception e2) {
                Log.i(TAG, e2.toString());
                AppMethodBeat.o(246151);
                return null;
            }
        } else {
            AppMethodBeat.o(246151);
            return null;
        }
    }

    private static void b(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<t> linkedList, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(246153);
        try {
            int i7 = i2 / 2;
            int i8 = (i2 * 4) / 5;
            List<t> list = gVar.uDs;
            int size = linkedList.size() + list.size();
            if (size > i2) {
                i3 = size - i8;
            } else {
                i3 = 0;
            }
            Log.i(TAG, "checkCommentListSizeSaveMySelf maxCount:" + i2 + ", totalMsgSize;" + size + ", removeSize:" + i3);
            if (i3 > 0) {
                LinkedList linkedList2 = new LinkedList();
                Iterator<t> it = list.iterator();
                int i9 = 0;
                while (it.hasNext()) {
                    t next = it.next();
                    kotlin.g.b.p.g(next, "localMsgIterator.next()");
                    t tVar = next;
                    y yVar = y.vXH;
                    if (!y.awn(tVar.csW())) {
                        it.remove();
                        i9++;
                        continue;
                    } else {
                        linkedList2.add(tVar);
                        continue;
                    }
                    if (i9 >= i3) {
                        break;
                    }
                }
                if (i9 < i3) {
                    Iterator<t> it2 = linkedList.iterator();
                    kotlin.g.b.p.g(it2, "remoteLiveMsg.iterator()");
                    int i10 = i9;
                    while (true) {
                        if (!it2.hasNext()) {
                            i4 = i10;
                            break;
                        }
                        t next2 = it2.next();
                        kotlin.g.b.p.g(next2, "remoteMsgIterator.next()");
                        t tVar2 = next2;
                        y yVar2 = y.vXH;
                        if (!y.awn(tVar2.csW())) {
                            it2.remove();
                            i4 = i10 + 1;
                        } else {
                            linkedList2.add(tVar2);
                            i4 = i10;
                        }
                        if (i4 >= i3) {
                            break;
                        }
                        i10 = i4;
                    }
                } else {
                    i4 = i9;
                }
                int i11 = i4 - i9;
                int size2 = linkedList2.size();
                if (size2 > i7) {
                    int i12 = (i7 * 4) / 5;
                    if (i12 > 0) {
                        i6 = size2 - i12;
                    } else {
                        i6 = size2 - i7;
                    }
                    List a2 = j.a((List) linkedList2, new kotlin.k.f(0, i6));
                    list.removeAll(a2);
                    linkedList.removeAll(a2);
                    i5 = i6;
                } else {
                    i5 = 0;
                }
                Log.i(TAG, "checkCommentListSizeSaveMySelf localMsgRemoveSize:" + i9 + ",remoteMsgRemoveSize:" + i11 + ",myselfRemoveSize:" + i5);
                AppMethodBeat.o(246153);
                return;
            }
        } catch (Exception e2) {
            f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "liveCheckCommentMsgErr", false, false, null, 28);
            y yVar3 = y.vXH;
            y.a(e2, "checkCommentListSizeSaveMySelf");
        }
        AppMethodBeat.o(246153);
    }

    public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<awq> linkedList, LinkedList<aut> linkedList2, int i2, String str, String str2) {
        AppMethodBeat.i(246156);
        kotlin.g.b.p.h(gVar, "roomData");
        kotlin.g.b.p.h(linkedList, "remoteLiveMsg");
        kotlin.g.b.p.h(linkedList2, "remoteLiveAppMsg");
        LinkedList linkedList3 = new LinkedList();
        Iterator<T> it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList3.add(new r(it.next()));
        }
        for (T t : linkedList2) {
            switch (t.ybm) {
                case 20001:
                case 20002:
                    linkedList3.add(new f(t));
                    break;
                case 20013:
                    d dVar = new d(t);
                    Log.i(TAG, "receive FinderLiveComboRewardMsg:[" + dVar.csW() + ", " + dVar.dfr() + ']');
                    linkedList3.add(dVar);
                    break;
                case 20014:
                    k kVar = new k(t);
                    Log.i(TAG, "receive FinderLiveRewardRankingMsg:[" + kVar.csW() + ", " + kVar.dfr() + ']');
                    linkedList3.add(kVar);
                    break;
                case 20019:
                    aa aaVar = new aa(t);
                    Object dft = aaVar.dft();
                    if (dft != null) {
                        fgn fgn = (fgn) dft;
                        Log.i(TAG, "receive AppMsgSendRedPacket:[" + fgn.ViT + ", " + fgn.ViX + ']');
                        linkedList3.add(aaVar);
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgSendRedPacketInfo");
                        AppMethodBeat.o(246156);
                        throw tVar;
                    }
                case 20020:
                    z zVar = new z(t);
                    Object dft2 = zVar.dft();
                    if (dft2 != null) {
                        fgm fgm = (fgm) dft2;
                        Log.i(TAG, "receive AppMsgRecvRedPacket:[" + fgm.ViT + ", " + fgm.ViU + ']');
                        linkedList3.add(zVar);
                        break;
                    } else {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveAppMsgRecvRedPacketInfo");
                        AppMethodBeat.o(246156);
                        throw tVar2;
                    }
            }
        }
        LinkedList<t> ai = ai(linkedList3);
        j.a((List) ai, (Comparator) new d());
        for (T t2 : ai) {
            String csW = t2.csW();
            if (csW != null) {
                HashMap<String, Boolean> hashMap = gVar.uDX;
                avn dfs = t2.dfs();
                hashMap.put(csW, Boolean.valueOf(dfs != null && dfs.LGh == 1));
            }
        }
        if (uiQ) {
            b(gVar, ai, i2);
        } else {
            a(gVar, ai, i2);
        }
        for (T t3 : ai) {
            if (((!kotlin.g.b.p.j(t3.csW(), str) && !kotlin.g.b.p.j(t3.csW(), str2)) || ((t3.getType() == 20013 && !uiP) || t3.getType() == 20014 || t3.getType() == 20019 || t3.getType() == 20020)) && gVar.uEX.get(Long.valueOf(t3.cKo())) == null) {
                gVar.uDs.add(t3);
                gVar.uEX.put(Long.valueOf(t3.cKo()), t3);
            }
        }
        if (ai.size() - gVar.uDs.size() > 10) {
            gVar.uDs.clear();
            gVar.uDs.addAll(ai);
        }
        gVar.uDW = ((long) ai.size()) + kotlin.k.j.aM(gVar.uDW, (long) gVar.uDs.size());
        AppMethodBeat.o(246156);
    }

    public static void b(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        aug aug;
        String str;
        AppMethodBeat.i(246160);
        if (gVar == null) {
            AppMethodBeat.o(246160);
        } else if (!gVar.uDs.isEmpty() || (aug = gVar.uDy) == null || (str = aug.LFa) == null) {
            AppMethodBeat.o(246160);
        } else {
            awq awq = new awq();
            o.c cVar = o.c.hGH;
            awq.type = o.c.aFo();
            awq.content = str;
            r rVar = new r(awq);
            gVar.uDs.add(0, rVar);
            Log.i(TAG, "appendSysLawTip:" + rVar.uke.content);
            AppMethodBeat.o(246160);
        }
    }

    public static void c(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        boolean z;
        String str;
        T t;
        boolean z2;
        FinderObject finderObject;
        String str2;
        String str3;
        String str4;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(246161);
        if (gVar != null) {
            String str5 = gVar.desc;
            if (str5 == null || str5.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                str = gVar.desc;
            } else if (gVar.uDm == null) {
                e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                FinderItem Fy = e.a.Fy(gVar.hFK);
                str = Fy != null ? Fy.getDescription() : null;
            } else {
                FinderObjectDesc finderObjectDesc = gVar.uDm;
                str = finderObjectDesc != null ? finderObjectDesc.description : null;
            }
            List<t> list = gVar.uDs;
            kotlin.g.b.p.g(list, "liveData.msgList");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                int type = t.getType();
                o.c cVar = o.c.hGH;
                if (type == o.c.aFw()) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    break;
                }
            }
            boolean z5 = t != null;
            String str6 = TAG;
            StringBuilder sb = new StringBuilder("[START_LIVE], desc is empty:");
            String str7 = str;
            if (str7 == null || str7.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Log.i(str6, sb.append(z2).append(", containWelcomeMsg:").append(z5).toString());
            String str8 = str;
            if (str8 == null || str8.length() == 0) {
                z4 = true;
            }
            if (z4 || z5 || (finderObject = gVar.uDz) == null) {
                AppMethodBeat.o(246161);
                return;
            }
            awq awq = new awq();
            avn avn = new avn();
            FinderContact finderContact = new FinderContact();
            FinderContact finderContact2 = finderObject.contact;
            if (finderContact2 == null || (str2 = finderContact2.username) == null) {
                str2 = "";
            }
            finderContact.username = str2;
            FinderContact finderContact3 = finderObject.contact;
            if (finderContact3 == null || (str3 = finderContact3.nickname) == null) {
                str3 = "";
            }
            finderContact.nickname = str3;
            FinderContact finderContact4 = finderObject.contact;
            if (finderContact4 == null || (str4 = finderContact4.headUrl) == null) {
                str4 = "";
            }
            finderContact.headUrl = str4;
            avn.contact = finderContact;
            awq.LHp = avn;
            if (str == null) {
                str = "";
            }
            awq.content = str;
            o.c cVar2 = o.c.hGH;
            awq.type = o.c.aFw();
            r rVar = new r(awq);
            gVar.uDs.add(rVar);
            Log.i(TAG, "appendWelcomeTip:" + rVar.uke.content);
            AppMethodBeat.o(246161);
            return;
        }
        AppMethodBeat.o(246161);
    }

    public static void k(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        AppMethodBeat.i(260471);
        if (gVar != null) {
            axt axt = gVar.location;
            if (axt != null) {
                String str = axt.kHV;
                axt axt2 = !(str == null || str.length() == 0) ? axt : null;
                if (axt2 != null) {
                    awq awq = new awq();
                    o.c cVar = o.c.hGH;
                    awq.type = o.c.caa();
                    awq.content = axt2.fuK + " • " + axt2.kHV;
                    y yVar = new y(awq, axt2);
                    gVar.uDs.add(yVar);
                    Log.i(TAG, "appendLocationTip:" + yVar.uke.content);
                    AppMethodBeat.o(260471);
                    return;
                }
            }
            AppMethodBeat.o(260471);
            return;
        }
        AppMethodBeat.o(260471);
    }

    public static void d(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        String string;
        AppMethodBeat.i(246162);
        awq awq = new awq();
        o.c cVar = o.c.hGH;
        awq.type = o.c.aFo();
        if (!gVar.diZ()) {
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            string = context.getResources().getString(R.string.ctw);
        } else {
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            string = context2.getResources().getString(R.string.ctu);
        }
        awq.content = string;
        r rVar = new r(awq);
        gVar.uDs.add(rVar);
        Log.i(TAG, "appendLinkMicTip:" + rVar.uke.content);
        AppMethodBeat.o(246162);
    }

    public static void e(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        String string;
        AppMethodBeat.i(246163);
        awq awq = new awq();
        o.c cVar = o.c.hGH;
        awq.type = o.c.aFo();
        if (!gVar.dja()) {
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            string = context.getResources().getString(R.string.csq);
        } else {
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            string = context2.getResources().getString(R.string.cso);
        }
        awq.content = string;
        r rVar = new r(awq);
        gVar.uDs.add(rVar);
        Log.i(TAG, "appendGiftTip:" + rVar.uke.content);
        AppMethodBeat.o(246163);
    }

    private static void a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<t> linkedList, int i2) {
        AppMethodBeat.i(246152);
        List<t> list = gVar.uDs;
        int size = i2 - (list.size() + linkedList.size());
        if (size < 0) {
            int i3 = gVar.uEO;
            int size2 = (gVar.uDs.size() - 1) - i3;
            if (gVar.uEO < 0 || size2 <= 0) {
                kotlin.g.b.p.g(list, "commentList");
                list.removeAll(j.b(list, -size));
            } else {
                int i4 = -size;
                if (size2 > i4) {
                    kotlin.g.b.p.g(list, "commentList");
                    list.removeAll(j.a((List) list, new kotlin.k.f(i3 + 1, i3 + i4)));
                    AppMethodBeat.o(246152);
                    return;
                }
                kotlin.g.b.p.g(list, "commentList");
                list.removeAll(j.a((List) list, kotlin.k.j.mY(i3 + 1, gVar.uDs.size())));
                AppMethodBeat.o(246152);
                return;
            }
        }
        AppMethodBeat.o(246152);
    }

    public static void c(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<awq> linkedList) {
        AppMethodBeat.i(246154);
        kotlin.g.b.p.h(gVar, "roomData");
        kotlin.g.b.p.h(linkedList, "remoteLiveMsg");
        gVar.uDt.clear();
        List<awq> list = gVar.uDt;
        LinkedList linkedList2 = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(uiS, t.type)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        list.addAll(linkedList2);
        AppMethodBeat.o(246154);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g r11, java.util.LinkedList<com.tencent.mm.protocal.protobuf.awq> r12, java.util.LinkedList<com.tencent.mm.protocal.protobuf.aut> r13) {
        /*
        // Method dump skipped, instructions count: 532
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.model.i.a(com.tencent.mm.plugin.finder.live.viewmodel.g, java.util.LinkedList, java.util.LinkedList):void");
    }

    public static void e(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<awq> linkedList) {
        AppMethodBeat.i(246157);
        kotlin.g.b.p.h(gVar, "roomData");
        kotlin.g.b.p.h(linkedList, "remoteLiveMsg");
        gVar.uDu.clear();
        List<awq> list = gVar.uDu;
        LinkedList linkedList2 = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(uiV, t.type)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        list.addAll(linkedList2);
        AppMethodBeat.o(246157);
    }

    public static void f(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<aut> linkedList) {
        FinderContact finderContact;
        AppMethodBeat.i(246158);
        kotlin.g.b.p.h(gVar, "roomData");
        kotlin.g.b.p.h(linkedList, "remoteLiveAppMsg");
        gVar.uDv.clear();
        List<aut> list = gVar.uDv;
        LinkedList linkedList2 = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(uiW, t.ybm)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : linkedList2) {
            m mVar = m.vVH;
            avn avn = ((aut) obj).LFE;
            if (!m.byb((avn == null || (finderContact = avn.contact) == null) ? null : finderContact.username)) {
                arrayList2.add(obj);
            }
        }
        list.addAll(arrayList2);
        Log.i(TAG, "handleHighLightCheerMsg roomData.highLightCheerList:" + gVar.uDv.size());
        AppMethodBeat.o(246158);
    }

    public static void g(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<aut> linkedList) {
        byte[] bArr;
        String str;
        String str2;
        String str3;
        FinderContact finderContact;
        FinderContact finderContact2;
        FinderContact finderContact3;
        FinderContact finderContact4;
        FinderContact finderContact5;
        FinderContact finderContact6;
        AppMethodBeat.i(246159);
        kotlin.g.b.p.h(gVar, "roomData");
        kotlin.g.b.p.h(linkedList, "remoteLiveAppMsg");
        LinkedList<aut> linkedList2 = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(uiY, t.ybm)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        for (aut aut : linkedList2) {
            auw auw = new auw();
            auw auw2 = auw;
            com.tencent.mm.bw.b bVar = aut.LFB;
            if (bVar != null) {
                bArr = bVar.toByteArray();
            } else {
                bArr = null;
            }
            try {
                auw2.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
            }
            Log.i(TAG, "receive apply mic msg: [sessionId:" + aut.session_id + ", applyUserSdkId:" + auw.Lmn + ']');
            String str4 = aut.session_id;
            if (str4 != null) {
                if (gVar.UQc.get(str4) != null) {
                    Log.i(TAG, "has received mic apply, skip msg. sessionId:".concat(String.valueOf(str4)));
                } else {
                    kotlin.g.b.p.g(str4, "sessionId");
                    gVar.UQc.put(str4, 0);
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = gVar.UPX;
                    kotlin.g.b.p.g(list, "roomData.linkMicUserList");
                    j.c((List) list, (kotlin.g.a.b) new f(auw, aut, gVar));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = gVar.UPX;
                    String str5 = auw.Lmn;
                    avn avn = aut.LFE;
                    if (avn == null || (finderContact6 = avn.contact) == null) {
                        str = null;
                    } else {
                        str = finderContact6.headUrl;
                    }
                    avn avn2 = aut.LFE;
                    if (avn2 == null || (finderContact5 = avn2.contact) == null) {
                        str2 = null;
                    } else {
                        str2 = finderContact5.username;
                    }
                    avn avn3 = aut.LFE;
                    if (avn3 == null || (finderContact4 = avn3.contact) == null) {
                        str3 = null;
                    } else {
                        str3 = finderContact4.nickname;
                    }
                    list2.add(new com.tencent.mm.plugin.finder.live.viewmodel.e(str5, str, str2, str3, auw.LFG, aut.session_id, null, false, 0, null, null, 0, 0, 8128));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = gVar.UPY;
                    kotlin.g.b.p.g(list3, "roomData.newLinkMicUserList");
                    j.c((List) list3, (kotlin.g.a.b) new g(auw, aut, gVar));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list4 = gVar.UPY;
                    String str6 = auw.Lmn;
                    avn avn4 = aut.LFE;
                    String str7 = (avn4 == null || (finderContact3 = avn4.contact) == null) ? null : finderContact3.headUrl;
                    avn avn5 = aut.LFE;
                    String str8 = (avn5 == null || (finderContact2 = avn5.contact) == null) ? null : finderContact2.username;
                    avn avn6 = aut.LFE;
                    list4.add(new com.tencent.mm.plugin.finder.live.viewmodel.e(str6, str7, str8, (avn6 == null || (finderContact = avn6.contact) == null) ? null : finderContact.nickname, auw.LFG, aut.session_id, null, false, 0, null, null, 0, 0, 8128));
                }
            }
        }
        Log.i(TAG, "handleLinkMicMsg applyMicMsgList:".concat(String.valueOf(linkedList2)));
        AppMethodBeat.o(246159);
    }

    public static void d(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<aut> linkedList) {
        byte[] bArr;
        FinderContact finderContact;
        FinderContact finderContact2;
        FinderContact finderContact3;
        FinderContact finderContact4;
        FinderContact finderContact5;
        FinderContact finderContact6;
        FinderContact finderContact7;
        FinderContact finderContact8;
        FinderContact finderContact9;
        FinderContact finderContact10;
        AppMethodBeat.i(260469);
        kotlin.g.b.p.h(gVar, "roomData");
        kotlin.g.b.p.h(linkedList, "remoteLiveAppMsg");
        LinkedList<aut> linkedList2 = new LinkedList();
        ArrayList arrayList = new ArrayList();
        for (T t : linkedList) {
            if (kotlin.a.e.contains(UKs, t.ybm)) {
                arrayList.add(t);
            }
        }
        linkedList2.addAll(arrayList);
        for (aut aut : linkedList2) {
            fgh fgh = new fgh();
            fgh fgh2 = fgh;
            com.tencent.mm.bw.b bVar = aut.LFB;
            if (bVar != null) {
                bArr = bVar.toByteArray();
            } else {
                bArr = null;
            }
            try {
                fgh2.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
            }
            Log.i(TAG, "receive apply mic pk msg: [sessionId:" + aut.session_id + ", pkUserSdkId:" + fgh.ViN + ", pkSdkLiveId:" + fgh.ViO + ']');
            String str = aut.session_id;
            if (str != null) {
                if (gVar.UQc.get(str) != null) {
                    Log.i(TAG, "has received mic pk apply, skip msg. sessionId:".concat(String.valueOf(str)));
                } else {
                    kotlin.g.b.p.g(str, "sessionId");
                    gVar.UQc.put(str, 0);
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = gVar.UPX;
                    kotlin.g.b.p.g(list, "roomData.linkMicUserList");
                    j.c((List) list, (kotlin.g.a.b) new h(fgh, aut, gVar));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = gVar.UPX;
                    String str2 = fgh.ViN;
                    avn avn = aut.LFE;
                    String str3 = (avn == null || (finderContact10 = avn.contact) == null) ? null : finderContact10.headUrl;
                    avn avn2 = aut.LFE;
                    String str4 = (avn2 == null || (finderContact9 = avn2.contact) == null) ? null : finderContact9.username;
                    avn avn3 = aut.LFE;
                    String str5 = (avn3 == null || (finderContact8 = avn3.contact) == null) ? null : finderContact8.nickname;
                    String str6 = aut.session_id;
                    int i2 = fgh.ViO;
                    avn avn4 = aut.LFE;
                    FinderAuthInfo finderAuthInfo = (avn4 == null || (finderContact7 = avn4.contact) == null) ? null : finderContact7.authInfo;
                    avn avn5 = aut.LFE;
                    list2.add(new com.tencent.mm.plugin.finder.live.viewmodel.e(str2, str3, str4, str5, 2, str6, null, true, i2, finderAuthInfo, (avn5 == null || (finderContact6 = avn5.contact) == null) ? null : finderContact6.signature, 0, 0, 6144));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = gVar.UPY;
                    kotlin.g.b.p.g(list3, "roomData.newLinkMicUserList");
                    j.c((List) list3, (kotlin.g.a.b) new C1186i(fgh, aut, gVar));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list4 = gVar.UPY;
                    String str7 = fgh.ViN;
                    avn avn6 = aut.LFE;
                    String str8 = (avn6 == null || (finderContact5 = avn6.contact) == null) ? null : finderContact5.headUrl;
                    avn avn7 = aut.LFE;
                    String str9 = (avn7 == null || (finderContact4 = avn7.contact) == null) ? null : finderContact4.username;
                    avn avn8 = aut.LFE;
                    String str10 = (avn8 == null || (finderContact3 = avn8.contact) == null) ? null : finderContact3.nickname;
                    String str11 = aut.session_id;
                    int i3 = fgh.ViO;
                    avn avn9 = aut.LFE;
                    FinderAuthInfo finderAuthInfo2 = (avn9 == null || (finderContact2 = avn9.contact) == null) ? null : finderContact2.authInfo;
                    avn avn10 = aut.LFE;
                    list4.add(new com.tencent.mm.plugin.finder.live.viewmodel.e(str7, str8, str9, str10, 2, str11, null, true, i3, finderAuthInfo2, (avn10 == null || (finderContact = avn10.contact) == null) ? null : finderContact.signature, 0, 0, 6144));
                }
            }
        }
        Log.i(TAG, "handleLinkMicPkMsg applyMicPkMsgList:".concat(String.valueOf(linkedList2)));
        AppMethodBeat.o(260469);
    }

    public static void i(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<aut> linkedList) {
        AppMethodBeat.i(260470);
        kotlin.g.b.p.h(gVar, "roomData");
        kotlin.g.b.p.h(linkedList, "remoteLiveMsg");
        gVar.uDw.addAll(kotlin.m.i.c(kotlin.m.i.d(kotlin.m.i.a(j.z(linkedList), a.ujb), b.ujc)));
        AppMethodBeat.o(260470);
    }

    public static final /* synthetic */ boolean a(String str, aut aut) {
        String str2;
        String str3;
        FinderContact finderContact;
        FinderContact finderContact2;
        FinderContact finderContact3;
        FinderContact finderContact4;
        String str4 = null;
        AppMethodBeat.i(246165);
        m mVar = m.vVH;
        avn avn = aut.LFE;
        boolean byb = m.byb((avn == null || (finderContact4 = avn.contact) == null) ? null : finderContact4.username);
        String str5 = TAG;
        StringBuilder append = new StringBuilder().append(str).append(" isMySelfMsg:").append(byb).append(", fromUserName:");
        avn avn2 = aut.LFE;
        if (avn2 == null || (finderContact3 = avn2.contact) == null) {
            str2 = null;
        } else {
            str2 = finderContact3.username;
        }
        StringBuilder append2 = append.append(str2).append(", client_msg_id:").append(aut.LFr).append(", type:").append(aut.ybm).append(", fromNickName:");
        avn avn3 = aut.LFE;
        if (avn3 == null || (finderContact2 = avn3.contact) == null) {
            str3 = null;
        } else {
            str3 = finderContact2.nickname;
        }
        StringBuilder append3 = append2.append(str3).append(",toNickName:");
        avn avn4 = aut.LFz;
        if (!(avn4 == null || (finderContact = avn4.contact) == null)) {
            str4 = finderContact.nickname;
        }
        Log.i(str5, append3.append(str4).toString());
        AppMethodBeat.o(246165);
        return byb;
    }
}
