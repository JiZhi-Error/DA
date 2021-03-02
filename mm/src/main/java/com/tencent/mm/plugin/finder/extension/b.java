package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/extension/FinderSyncHandler;", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "()V", "TAG", "", "finderSyncReportHandler", "Lcom/tencent/mm/plugin/finder/extension/FinderSyncReportHandler;", "handleCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "selector", "", "scene", "processFansCount", "processFollowCount", "processGetFollower", "processGetMentionCount", "processGetRedDot", "processGetWxMentionCount", "processNotInterestedConfig", "processObjectWordingConfig", "processPreFetch", "processReInit", "processRevokeRedDot", "processRevokeTabTips", "processSpamObj", "processTabRedDot", "plugin-finder_release"})
public final class b implements f {
    final String TAG = "Finder.SyncFinderSyncHandler";
    private final c tJc = new c();

    public b() {
        AppMethodBeat.i(243483);
        AppMethodBeat.o(243483);
    }

    @Override // com.tencent.mm.plugin.finder.api.f
    public final void a(apf apf, int i2, int i3) {
        LinkedList<bdo> linkedList;
        AppMethodBeat.i(243482);
        p.h(apf, "cmdItem");
        int i4 = apf.cmdId;
        Log.i(this.TAG, "cmdId ".concat(String.valueOf(i4)));
        switch (i4) {
            case 101:
                apx apx = new apx();
                com.tencent.mm.bw.b bVar = apf.LBo;
                apx.parseFrom(bVar != null ? bVar.toByteArray() : null);
                Log.i(this.TAG, "redDotEvent new count info, msg count:" + apx.count + ", normalCount:" + apx.jhQ + ", systemCount:" + apx.LBK);
                Log.i(this.TAG, "redDotEvent new count info, msg like count:" + apx.LBF + ", mentioncommentCount:" + apx.LBG + ", followcount:" + apx.LBL);
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_FINDER_MSG_NORMAL_INT_SYNC, Integer.valueOf(apx.jhQ));
                e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_FINDER_MSG_SYSTEM_INT_SYNC, Integer.valueOf(apx.LBK));
                com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
                p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                com.tencent.mm.plugin.finder.extension.reddot.f redDotManager = ((PluginFinder) ah).getRedDotManager();
                int i5 = apx.LBF;
                int i6 = apx.LBG;
                int i7 = apx.LBL;
                if (i5 > 0 || i6 > 0 || i7 > 0) {
                    bbi bbi = new bbi();
                    bbi.LKM = String.valueOf(cl.aWA());
                    bbi.priority = 100000;
                    bbi.type = 2;
                    bdo bdo = new bdo();
                    bdo.xGz = 2;
                    bdo.LNm = 1;
                    bdo.path = "AuthorProfileNotify";
                    bdo.count = i5 + i6 + i7;
                    bbi.GaM.add(bdo);
                    if (i5 > 0) {
                        bdo bdo2 = new bdo();
                        bdo2.xGz = 2;
                        bdo2.LNm = 1;
                        bdo2.path = "NotificationCenterLike";
                        bdo2.count = i5;
                        bbi.GaM.add(bdo2);
                    }
                    if (i6 > 0) {
                        bdo bdo3 = new bdo();
                        bdo3.xGz = 2;
                        bdo3.LNm = 1;
                        bdo3.path = "NotificationCenterComment";
                        bdo3.count = i6;
                        bbi.GaM.add(bdo3);
                    }
                    if (i7 > 0) {
                        bdo bdo4 = new bdo();
                        bdo4.xGz = 2;
                        bdo4.LNm = 1;
                        bdo4.path = "NotificationCenterFollow";
                        bdo4.count = i7;
                        bbi.GaM.add(bdo4);
                    }
                    redDotManager.a(bbi);
                    com.tencent.mm.plugin.finder.extension.reddot.f.a(redDotManager, bbi, "notifyFinderTabMsgCount", null, false, null, 28);
                } else {
                    Log.i("Finder.RedDotManager", "[notifyFinderMsgCount] server error.");
                }
                if (apx.LBK > 0) {
                    com.tencent.mm.kernel.b.a ah2 = g.ah(PluginFinder.class);
                    p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                    ((PluginFinder) ah2).getRedDotManager().tJB.dau();
                    break;
                }
                break;
            case 103:
                a(apf);
                break;
            case 104:
                bbh bbh = new bbh();
                com.tencent.mm.bw.b bVar2 = apf.LBo;
                bbh.parseFrom(bVar2 != null ? bVar2.toByteArray() : null);
                Log.i(this.TAG, "redDotEvent get red dot, showRed:" + bbh.LKI);
                com.tencent.mm.kernel.b.a ah3 = g.ah(PluginFinder.class);
                p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder) ah3).getRedDotManager().a(bbh);
                break;
            case 105:
                are are = new are();
                com.tencent.mm.bw.b bVar3 = apf.LBo;
                are.parseFrom(bVar3 != null ? bVar3.toByteArray() : null);
                Log.i(this.TAG, "save svr_follow count " + are.LBI);
                e aAh3 = g.aAh();
                p.g(aAh3, "MMKernel.storage()");
                aAh3.azQ().set(ar.a.USERINFO_FINDER_FOLLOW_COUNT_INT_SYNC, Integer.valueOf(are.LBI));
                break;
            case 106:
                aqs aqs = new aqs();
                com.tencent.mm.bw.b bVar4 = apf.LBo;
                aqs.parseFrom(bVar4 != null ? bVar4.toByteArray() : null);
                Log.i(this.TAG, "redDotEvent save svr_fans count " + aqs.fans_count + " svr_fans_add_count:" + aqs.LBJ);
                e aAh4 = g.aAh();
                p.g(aAh4, "MMKernel.storage()");
                aAh4.azQ().set(ar.a.USERINFO_FINDER_FANS_ADDCOUNT_INT_SYNC, Integer.valueOf(aqs.LBJ));
                e aAh5 = g.aAh();
                p.g(aAh5, "MMKernel.storage()");
                aAh5.azQ().set(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, Integer.valueOf(aqs.fans_count));
                com.tencent.mm.kernel.b.a ah4 = g.ah(PluginFinder.class);
                p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
                com.tencent.mm.plugin.finder.extension.reddot.f redDotManager2 = ((PluginFinder) ah4).getRedDotManager();
                int i8 = aqs.LBJ;
                if (i8 > 0) {
                    Log.i("Finder.RedDotManager", "[notifyFinderFansAddCount] count = ".concat(String.valueOf(i8)));
                    bbi bbi2 = new bbi();
                    bbi2.LKM = String.valueOf(cl.aWA());
                    bbi2.priority = 100000;
                    bbi2.type = 2;
                    bdo bdo5 = new bdo();
                    bdo5.xGz = 2;
                    bdo5.LNm = 1;
                    bdo5.path = "AuthorProfileFans";
                    bdo5.count = i8;
                    bbi2.GaM.add(bdo5);
                    com.tencent.mm.plugin.finder.extension.reddot.f.a(redDotManager2, bbi2, "notifyFinderFansAddCount", null, true, null, 20);
                    break;
                } else {
                    Log.i("Finder.RedDotManager", "[notifyFinderFansAddCount] server error.");
                    break;
                }
            case 107:
                d.b("processSpamObj", new a(this, apf));
                break;
            case 108:
                bem bem = new bem();
                com.tencent.mm.bw.b bVar5 = apf.LBo;
                bem.parseFrom(bVar5 != null ? bVar5.toByteArray() : null);
                int i9 = bem.LBG + bem.LBF + bem.LOi + bem.LOj + bem.LOk;
                Log.i(this.TAG, "redDotEvent new wx count info, msg count:" + bem.count + ", comment:" + bem.LBG + ", like:" + bem.LBF + ", objectlike_like:" + bem.LOi + ", objectrecommend_like:" + bem.LOj + ", follow_accepted_count:" + bem.LOk + ", headUrl:" + bem.iAR + " totalCount=" + i9);
                if (i9 > 0) {
                    e aAh6 = g.aAh();
                    p.g(aAh6, "MMKernel.storage()");
                    aAh6.azQ().set(ar.a.USERINFO_FINDER_FIND_MORE_UI_RED_DOT_BOOLEAN_SYNC, Boolean.TRUE);
                }
                e aAh7 = g.aAh();
                p.g(aAh7, "MMKernel.storage()");
                aAh7.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, Integer.valueOf(bem.LBG));
                e aAh8 = g.aAh();
                p.g(aAh8, "MMKernel.storage()");
                aAh8.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, Integer.valueOf(bem.LBF));
                e aAh9 = g.aAh();
                p.g(aAh9, "MMKernel.storage()");
                aAh9.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_LIEK_LIKE_INT_SYNC, Integer.valueOf(bem.LOi));
                e aAh10 = g.aAh();
                p.g(aAh10, "MMKernel.storage()");
                aAh10.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, Integer.valueOf(bem.LOj));
                e aAh11 = g.aAh();
                p.g(aAh11, "MMKernel.storage()");
                aAh11.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_FOLLOW_ACCEPT_INT_SYNC, Integer.valueOf(bem.LOk));
                e aAh12 = g.aAh();
                p.g(aAh12, "MMKernel.storage()");
                aAh12.azQ().set(ar.a.USERINFO_FINDER_WX_MENTION_AVATAR_STRING_SYNC, bem.iAR);
                com.tencent.mm.kernel.b.a ah5 = g.ah(PluginFinder.class);
                p.g(ah5, "MMKernel.plugin(PluginFinder::class.java)");
                com.tencent.mm.plugin.finder.extension.reddot.f redDotManager3 = ((PluginFinder) ah5).getRedDotManager();
                p.h(bem, "wxMention");
                long aWA = cl.aWA();
                com.tencent.mm.plugin.finder.extension.reddot.l lVar = com.tencent.mm.plugin.finder.extension.reddot.l.tLu;
                long dbO = aWA - com.tencent.mm.plugin.finder.extension.reddot.l.dbO();
                if (bem.count <= 0 && bem.LOj <= 0 && bem.LOi <= 0 && bem.LBG <= 0 && bem.LBF <= 0 && bem.LOh <= 0 && bem.LOk <= 0) {
                    Log.e("Finder.RedDotManager", "[notifyWxMentionCount] server error.");
                    break;
                } else {
                    Log.i("Finder.RedDotManager", "[notifyWxMentionCount] diffTime=" + dbO + ' ' + com.tencent.mm.plugin.finder.extension.reddot.f.c(bem.LNi) + " count=" + bem.count);
                    if (dbO < com.tencent.mm.plugin.finder.extension.reddot.l.tLu.dbH()) {
                        com.tencent.mm.plugin.finder.extension.reddot.f.d(bem.LNi);
                        bbi bbi3 = bem.LNi;
                        if (!(bbi3 == null || (linkedList = bbi3.GaM) == null)) {
                            d.a((LinkedList) linkedList, (kotlin.g.a.b) f.t.tKj);
                        }
                    }
                    com.tencent.mm.plugin.finder.extension.reddot.f.a(redDotManager3, bem.LNi, "notifyWxMentionCount", null, true, null, 20);
                    break;
                }
                break;
            case 109:
                azo azo = new azo();
                if (apf.LBo != null) {
                    com.tencent.mm.bw.b bVar6 = apf.LBo;
                    azo.parseFrom(bVar6 != null ? bVar6.toByteArray() : null);
                    Log.i(this.TAG, "processNotInterestedConfig config:" + azo.Lps);
                    e aAh13 = g.aAh();
                    p.g(aAh13, "MMKernel.storage()");
                    aAh13.azQ().set(ar.a.USERINFO_FINDER_NOT_INTERESTED_CONFIG_STRING, Util.encodeHexString(azo.toByteArray()));
                    break;
                }
                break;
            case 110:
                Log.i(this.TAG, "[processReInit] ...");
                bba bba = new bba();
                com.tencent.mm.bw.b bVar7 = apf.LBo;
                if (bVar7 != null) {
                    bba.parseFrom(bVar7.toByteArray());
                    if (bba.LKF != 0) {
                        h.INSTANCE.n(1279, 20, 1);
                        LinkedList<FinderContact> linkedList2 = bba.LKE;
                        p.g(linkedList2, "newSelf.self");
                        if (!linkedList2.isEmpty()) {
                            Log.i(this.TAG, "replace new finder username %s", bba.LKE.get(0).username);
                            e aAh14 = g.aAh();
                            p.g(aAh14, "MMKernel.storage()");
                            aAh14.azQ().set(ar.a.USERINFO_MY_FINDER_REINIT_USERNAME_STRING_SYNC, bba.LKE.get(0).username);
                        } else {
                            e aAh15 = g.aAh();
                            p.g(aAh15, "MMKernel.storage()");
                            aAh15.azQ().set(ar.a.USERINFO_MY_FINDER_REINIT_USERNAME_STRING_SYNC, "");
                        }
                        e aAh16 = g.aAh();
                        p.g(aAh16, "MMKernel.storage()");
                        aAh16.azQ().set(ar.a.USERINFO_FINDER_REINIT_USER_VERSION_INT_SYNC, Integer.valueOf(bba.LAQ));
                        e aAh17 = g.aAh();
                        p.g(aAh17, "MMKernel.storage()");
                        int i10 = aAh17.azQ().getInt(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, 0);
                        Log.i(this.TAG, "[processReInit] userVersion=" + i10 + " userVersion=" + bba.LAQ);
                        if (!(i10 == bba.LAQ || bba.LAQ == 0)) {
                            e aAh18 = g.aAh();
                            p.g(aAh18, "MMKernel.storage()");
                            aAh18.azQ().set(ar.a.USERINFO_FINDER_USER_HARD_REINIT_INT_SYNC, (Object) 1);
                            break;
                        }
                    }
                }
                break;
            case 112:
                bau bau = new bau();
                com.tencent.mm.bw.b bVar8 = apf.LBo;
                bau.parseFrom(bVar8 != null ? bVar8.toByteArray() : null);
                Log.i(this.TAG, "processPreFetch needPrefetch:" + bau.LKq + " needShowRedDot:" + bau.LKr);
                break;
            case 113:
                bdh bdh = new bdh();
                com.tencent.mm.bw.b bVar9 = apf.LBo;
                bdh.parseFrom(bVar9 != null ? bVar9.toByteArray() : null);
                com.tencent.mm.kernel.b.a ah6 = g.ah(PluginFinder.class);
                p.g(ah6, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder) ah6).getRedDotManager().a(bdh, "processTabRedDot");
                break;
            case 114:
                try {
                    bbq bbq = new bbq();
                    com.tencent.mm.bw.b bVar10 = apf.LBo;
                    bbq.parseFrom(bVar10 != null ? bVar10.toByteArray() : null);
                    com.tencent.mm.kernel.b.a ah7 = g.ah(PluginFinder.class);
                    p.g(ah7, "MMKernel.plugin(PluginFinder::class.java)");
                    ((PluginFinder) ah7).getRedDotManager().a(bbq);
                    break;
                } catch (Exception e2) {
                    Log.printDebugStack(this.TAG, "", e2);
                    break;
                }
            case 116:
                try {
                    azv azv = new azv();
                    com.tencent.mm.bw.b bVar11 = apf.LBo;
                    azv.parseFrom(bVar11 != null ? bVar11.toByteArray() : null);
                    com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
                    com.tencent.mm.plugin.finder.storage.logic.g.a(azv);
                    break;
                } catch (Exception e3) {
                    Log.printDebugStack(this.TAG, "", e3);
                    break;
                }
            case 117:
                try {
                    bbo bbo = new bbo();
                    com.tencent.mm.bw.b bVar12 = apf.LBo;
                    bbo.parseFrom(bVar12 != null ? bVar12.toByteArray() : null);
                    com.tencent.mm.kernel.b.a ah8 = g.ah(PluginFinder.class);
                    p.g(ah8, "MMKernel.plugin(PluginFinder::class.java)");
                    ((PluginFinder) ah8).getRedDotManager().a(bbo);
                    break;
                } catch (Exception e4) {
                    Log.printDebugStack(this.TAG, "", e4);
                    break;
                }
        }
        this.tJc.a(apf, i2, i3);
        AppMethodBeat.o(243482);
    }

    private final void a(apf apf) {
        AppMethodBeat.i(165602);
        ark ark = new ark();
        com.tencent.mm.bw.b bVar = apf.LBo;
        if (bVar != null) {
            ark.parseFrom(bVar.toByteArray());
            LinkedList<FinderContact> linkedList = ark.LCY;
            p.g(linkedList, "follower.followers");
            for (T t : linkedList) {
                c.a aVar = c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(t.username);
                Log.i(this.TAG, "sync follow contact " + ark.LCY.size() + "  username=" + t.username + " nickname=" + t.nickname + " followFlag=" + t.followFlag + ' ');
                if (asG != null) {
                    asG.field_follow_Flag = t.followFlag;
                    c.a aVar2 = c.tsp;
                    c.a.d(asG);
                } else {
                    c.a aVar3 = c.tsp;
                    p.g(t, "follow");
                    c.a.a(t);
                }
            }
            AppMethodBeat.o(165602);
            return;
        }
        AppMethodBeat.o(165602);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b tJd;
        final /* synthetic */ apf tJe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, apf apf) {
            super(0);
            this.tJd = bVar;
            this.tJe = apf;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            AppMethodBeat.i(243481);
            bcr bcr = new bcr();
            com.tencent.mm.bw.b bVar = this.tJe.LBo;
            if (bVar != null) {
                bcr.parseFrom(bVar.toByteArray());
                LinkedList<ebw> linkedList = bcr.object;
                p.g(linkedList, "spamObj.`object`");
                if (!linkedList.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Log.i(this.tJd.TAG, "sync spam obj %s", Integer.valueOf(bcr.object.size()));
                    c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    LinkedList<ebw> linkedList2 = bcr.object;
                    p.g(linkedList2, "spamObj.`object`");
                    LinkedList<ebw> linkedList3 = linkedList2;
                    ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
                    Iterator<T> it = linkedList3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(it.next().LIV));
                    }
                    ArrayList arrayList2 = arrayList;
                    p.h(arrayList2, "objectId");
                    long currentTimeMillis = System.currentTimeMillis();
                    ((PluginFinder) g.ah(PluginFinder.class)).getFeedStorage().et(arrayList2);
                    Log.i(com.tencent.mm.plugin.finder.storage.logic.c.TAG, "delete feed size=$" + arrayList2.size() + " cost=" + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(243481);
            return xVar;
        }
    }
}
