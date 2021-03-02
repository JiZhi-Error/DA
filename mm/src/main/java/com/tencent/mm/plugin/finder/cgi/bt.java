package com.tencent.mm.plugin.finder.cgi;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bdg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bv;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0016J>\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "()V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "enableReportVal", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "response", "Lcom/tencent/mm/protocal/protobuf/FinderInitResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "handleFinderCmd", "", "cmdItem", "Lcom/tencent/mm/protocal/protobuf/FinderCmdItem;", "isEnableReport", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bt extends ax implements m {
    private static final String TAG = TAG;
    private static int tvF = TXLiteAVCode.ERR_MIX_PARAM_INVALID;
    public static final a tvG = new a((byte) 0);
    private i callback;
    private b ttH;
    private d tvD;
    public auc tvE;

    public bt() {
        AppMethodBeat.i(165243);
        Log.i(TAG, "NetSceneFinderInit");
        d.a aVar = new d.a();
        aub aub = new aub();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_INIT_KEYBUF2_STRING_SYNC, "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(165243);
            throw tVar;
        }
        aub.Lev = z.aC(Util.decodeHexString((String) obj));
        am amVar = am.tuw;
        aub.uli = am.cXY();
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/finderinit");
        aVar.c(aub);
        aVar.d(new auc());
        this.tvD = aVar.aXF();
        h.INSTANCE.n(1279, 23, 1);
        this.ttH = b.Disable;
        AppMethodBeat.o(165243);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderInit$Companion;", "", "()V", "MMFinder_FinderInit_Err_User_NotCreated", "", "getMMFinder_FinderInit_Err_User_NotCreated", "()I", "setMMFinder_FinderInit_Err_User_NotCreated", "(I)V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(242468);
        AppMethodBeat.o(242468);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3930;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(165241);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.tvD, this);
        AppMethodBeat.o(165241);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.report.e, com.tencent.mm.plugin.finder.cgi.ax
    public final b cXS() {
        return this.ttH;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        long j2;
        long j3;
        byte[] bArr;
        aqs aqs;
        byte[] bArr2;
        are are;
        Integer num;
        LinkedList<FinderContact> linkedList;
        FinderContact finderContact;
        AppMethodBeat.i(242467);
        String str2 = TAG;
        StringBuilder append = new StringBuilder("errType ").append(i3).append(", errCode ").append(i4).append(", errMsg ").append(str).append(" username=");
        auc auc = this.tvE;
        Log.i(str2, append.append((auc == null || (linkedList = auc.LEN) == null || (finderContact = (FinderContact) j.kt(linkedList)) == null) ? null : finderContact.username).toString());
        if (i3 >= 4) {
            this.ttH = b.Default;
        }
        if (i3 == 0 && i4 == 0) {
            d dVar = this.tvD;
            com.tencent.mm.bw.a aYK = dVar != null ? dVar.aYK() : null;
            if (!(aYK instanceof auc)) {
                aYK = null;
            }
            this.tvE = (auc) aYK;
            auc auc2 = this.tvE;
            if (auc2 != null) {
                auc auc3 = this.tvE;
                LinkedList<FinderContact> linkedList2 = auc3 != null ? auc3.LEN : null;
                if (linkedList2 != null) {
                    if ((!linkedList2.isEmpty() ? linkedList2 : null) != null && !Util.isNullOrNil(linkedList2.get(0).username)) {
                        e aAh = g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        aAh.azQ().set(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, linkedList2.get(0).username);
                        c.a aVar = c.tsp;
                        FinderContact finderContact2 = linkedList2.get(0);
                        p.g(finderContact2, "self[0]");
                        c.a.a(finderContact2);
                        com.tencent.mm.plugin.finder.api.e finderSyncExtension = ((PluginFinder) g.ah(PluginFinder.class)).getFinderSyncExtension();
                        auc auc4 = this.tvE;
                        if (auc4 == null) {
                            p.hyc();
                        }
                        finderSyncExtension.fX(auc4.continueFlag, 5);
                        d dVar2 = this.tvD;
                        if (dVar2 == null) {
                            p.hyc();
                        }
                        com.tencent.mm.bw.a aYK2 = dVar2.aYK();
                        if (aYK2 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderInitResponse");
                            AppMethodBeat.o(242467);
                            throw tVar;
                        }
                        LinkedList<apf> linkedList3 = ((auc) aYK2).sKS;
                        if (linkedList3 != null) {
                            for (T t : linkedList3) {
                                p.g(t, LocaleUtil.ITALIAN);
                                switch (t.cmdId) {
                                    case 105:
                                        are are2 = new are();
                                        com.tencent.mm.bw.b bVar = t.LBo;
                                        if (bVar != null) {
                                            bArr2 = bVar.toByteArray();
                                        } else {
                                            bArr2 = null;
                                        }
                                        try {
                                            are2.parseFrom(bArr2);
                                            are = are2;
                                        } catch (Exception e2) {
                                            Log.printDebugStack("safeParser", "", e2);
                                            are = null;
                                        }
                                        are are3 = are;
                                        c.a aVar2 = c.tsp;
                                        if (c.a.asG(com.tencent.mm.model.z.aUg()) != null) {
                                            Log.i(TAG, "save follow count " + (are3 != null ? Integer.valueOf(are3.LBI) : null));
                                            e aAh2 = g.aAh();
                                            p.g(aAh2, "MMKernel.storage()");
                                            ao azQ = aAh2.azQ();
                                            ar.a aVar3 = ar.a.USERINFO_FINDER_FOLLOW_COUNT_INT_SYNC;
                                            if (are3 != null) {
                                                num = Integer.valueOf(are3.LBI);
                                            } else {
                                                num = null;
                                            }
                                            azQ.set(aVar3, num);
                                            break;
                                        } else {
                                            break;
                                        }
                                    case 106:
                                        aqs aqs2 = new aqs();
                                        com.tencent.mm.bw.b bVar2 = t.LBo;
                                        if (bVar2 != null) {
                                            bArr = bVar2.toByteArray();
                                        } else {
                                            bArr = null;
                                        }
                                        try {
                                            aqs2.parseFrom(bArr);
                                            aqs = aqs2;
                                        } catch (Exception e3) {
                                            Log.printDebugStack("safeParser", "", e3);
                                            aqs = null;
                                        }
                                        aqs aqs3 = aqs;
                                        c.a aVar4 = c.tsp;
                                        if (c.a.asG(com.tencent.mm.model.z.aUg()) != null) {
                                            Log.i(TAG, "save fans count " + (aqs3 != null ? Integer.valueOf(aqs3.fans_count) : null));
                                            e aAh3 = g.aAh();
                                            p.g(aAh3, "MMKernel.storage()");
                                            aAh3.azQ().set(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, aqs3 != null ? Integer.valueOf(aqs3.fans_count) : null);
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            }
                        }
                        e aAh4 = g.aAh();
                        p.g(aAh4, "MMKernel.storage()");
                        ao azQ2 = aAh4.azQ();
                        ar.a aVar5 = ar.a.USERINFO_FINDER_INIT_KEYBUF2_STRING_SYNC;
                        auc auc5 = this.tvE;
                        if (auc5 == null) {
                            p.hyc();
                        }
                        azQ2.set(aVar5, Util.encodeHexString(z.a(auc5.Lev)));
                        e aAh5 = g.aAh();
                        p.g(aAh5, "MMKernel.storage()");
                        aAh5.azQ().set(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, linkedList2.get(0).nickname);
                        e aAh6 = g.aAh();
                        p.g(aAh6, "MMKernel.storage()");
                        aAh6.azQ().set(ar.a.USERINFO_MY_FINDER_SIGNATURE_STRING_SYNC, linkedList2.get(0).signature);
                        e aAh7 = g.aAh();
                        p.g(aAh7, "MMKernel.storage()");
                        aAh7.azQ().set(ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC, linkedList2.get(0).headUrl);
                        e aAh8 = g.aAh();
                        p.g(aAh8, "MMKernel.storage()");
                        aAh8.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(linkedList2.get(0).extFlag));
                        e aAh9 = g.aAh();
                        p.g(aAh9, "MMKernel.storage()");
                        aAh9.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_FLAG2_INT_SYNC, Integer.valueOf(linkedList2.get(0).originalFlag));
                        e aAh10 = g.aAh();
                        p.g(aAh10, "MMKernel.storage()");
                        aAh10.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_ENTRANCE2_INT_SYNC, Integer.valueOf(linkedList2.get(0).originalEntranceFlag));
                        if (linkedList2.get(0).originalInfo != null) {
                            e aAh11 = g.aAh();
                            p.g(aAh11, "MMKernel.storage()");
                            ao azQ3 = aAh11.azQ();
                            ar.a aVar6 = ar.a.USERINFO_MY_FINDER_ORIGINAL_REPOST_COUNT_INT_SYNC;
                            bac bac = linkedList2.get(0).originalInfo;
                            azQ3.set(aVar6, bac != null ? Integer.valueOf(bac.LJQ) : null);
                            e aAh12 = g.aAh();
                            p.g(aAh12, "MMKernel.storage()");
                            ao azQ4 = aAh12.azQ();
                            ar.a aVar7 = ar.a.USERINFO_MY_FINDER_ORIGINAL_APPLY_COUNT_INT_SYNC;
                            bac bac2 = linkedList2.get(0).originalInfo;
                            azQ4.set(aVar7, bac2 != null ? Integer.valueOf(bac2.LJR) : null);
                            e aAh13 = g.aAh();
                            p.g(aAh13, "MMKernel.storage()");
                            ao azQ5 = aAh13.azQ();
                            ar.a aVar8 = ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_INT_SYNC;
                            bac bac3 = linkedList2.get(0).originalInfo;
                            azQ5.set(aVar8, bac3 != null ? Integer.valueOf(bac3.LJS) : null);
                            e aAh14 = g.aAh();
                            p.g(aAh14, "MMKernel.storage()");
                            ao azQ6 = aAh14.azQ();
                            ar.a aVar9 = ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_YEAR_FLAG_INT_SYNC;
                            bac bac4 = linkedList2.get(0).originalInfo;
                            azQ6.set(aVar9, bac4 != null ? Integer.valueOf(bac4.LJT) : null);
                            e aAh15 = g.aAh();
                            p.g(aAh15, "MMKernel.storage()");
                            ao azQ7 = aAh15.azQ();
                            ar.a aVar10 = ar.a.USERINFO_MY_FINDER_ORIGINAL_NEED_CHECK_FLAG_INT_SYNC;
                            bac bac5 = linkedList2.get(0).originalInfo;
                            azQ7.set(aVar10, bac5 != null ? Integer.valueOf(bac5.LJU) : null);
                        }
                        if (linkedList2.get(0).authInfo == null) {
                            e aAh16 = g.aAh();
                            p.g(aAh16, "MMKernel.storage()");
                            aAh16.azQ().set(ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC, "");
                        } else {
                            e aAh17 = g.aAh();
                            p.g(aAh17, "MMKernel.storage()");
                            ao azQ8 = aAh17.azQ();
                            ar.a aVar11 = ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC;
                            FinderAuthInfo finderAuthInfo = linkedList2.get(0).authInfo;
                            azQ8.set(aVar11, Util.encodeHexString(finderAuthInfo != null ? finderAuthInfo.toByteArray() : null));
                        }
                        e aAh18 = g.aAh();
                        p.g(aAh18, "MMKernel.storage()");
                        aAh18.azQ().set(ar.a.USERINFO_FINDER_LIVE_COVER_IMAGE_STRING_SYNC, linkedList2.get(0).liveCoverImgUrl);
                        e aAh19 = g.aAh();
                        p.g(aAh19, "MMKernel.storage()");
                        ao azQ9 = aAh19.azQ();
                        ar.a aVar12 = ar.a.USERINFO_FINDER_LIVE_ANCHOR_STATUS_FLAG_LONG_SYNC;
                        apr apr = linkedList2.get(0).live_info;
                        if (apr != null) {
                            j2 = Long.valueOf(apr.LBA);
                        } else {
                            j2 = 0L;
                        }
                        azQ9.set(aVar12, j2);
                        e aAh20 = g.aAh();
                        p.g(aAh20, "MMKernel.storage()");
                        ao azQ10 = aAh20.azQ();
                        ar.a aVar13 = ar.a.USERINFO_FINDER_LIVE_SWITCH_FLAG_LONG_SYNC;
                        apr apr2 = linkedList2.get(0).live_info;
                        if (apr2 != null) {
                            j3 = Long.valueOf((long) apr2.LBB);
                        } else {
                            j3 = 0L;
                        }
                        azQ10.set(aVar13, j3);
                    }
                }
                LinkedList<bdg> linkedList4 = auc2.LEO;
                p.g(linkedList4, "it.tabInfos");
                for (T t2 : linkedList4) {
                    Log.i(TAG, t2.tab_type + " => " + t2.LHR);
                    if (t2.tab_type == 4) {
                        e aAh21 = g.aAh();
                        p.g(aAh21, "MMKernel.storage()");
                        aAh21.azQ().set(ar.a.USERINFO_FINDER_TAB_MACHINE_NAME_STRING, t2.LHR);
                    } else if (t2.tab_type == 3) {
                        e aAh22 = g.aAh();
                        p.g(aAh22, "MMKernel.storage()");
                        aAh22.azQ().set(ar.a.USERINFO_FINDER_TAB_FOLLOW_NAME_STRING, t2.LHR);
                    } else if (t2.tab_type == 1) {
                        e aAh23 = g.aAh();
                        p.g(aAh23, "MMKernel.storage()");
                        aAh23.azQ().set(ar.a.USERINFO_FINDER_TAB_FRIEND_NAME_STRING, t2.LHR);
                    }
                }
            }
        } else if (i3 == 4 && i4 == tvF) {
            e aAh24 = g.aAh();
            p.g(aAh24, "MMKernel.storage()");
            Object obj = aAh24.azQ().get(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, "");
            if (obj == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(242467);
                throw tVar2;
            }
            String str3 = (String) obj;
            Log.w(TAG, "errCode=" + i4 + " clear local self finder username. currentFinderUsername=" + str3 + ' ');
            c.a aVar14 = c.tsp;
            p.h(str3, ch.COL_USERNAME);
            Log.d(c.access$getTAG$cp(), "delete contact %s", str3);
            if (!Util.isNullOrNil(str3)) {
                com.tencent.mm.plugin.finder.api.a cXE = c.cXE();
                p.h(str3, "key");
                cXE.tsn.remove(str3);
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
                String avA = ((PluginFinder) g.ah(PluginFinder.class)).getSessionInfoStorage().avA(str3);
                aSN.ayf(str3);
                aSN.ayf(avA);
                String str4 = "DELETE FROM FinderContact WHERE username = " + com.tencent.mm.storagebase.h.Fl(str3);
                com.tencent.mm.plugin.finder.storage.d contactStorage = ((PluginFinder) g.ah(PluginFinder.class)).getContactStorage();
                boolean execSQL = contactStorage != null ? contactStorage.execSQL("FinderContact", str4) : false;
                Log.d(c.access$getTAG$cp(), "delete success %s", Boolean.valueOf(execSQL));
                if (execSQL && contactStorage != null) {
                    contactStorage.doNotify("FinderContact", 5, contactStorage);
                }
            }
            e aAh25 = g.aAh();
            p.g(aAh25, "MMKernel.storage()");
            aAh25.azQ().set(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, "");
            h.INSTANCE.n(1279, 26, 1);
        } else {
            h.INSTANCE.n(1279, 24, 1);
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242467);
            return;
        }
        AppMethodBeat.o(242467);
    }
}
