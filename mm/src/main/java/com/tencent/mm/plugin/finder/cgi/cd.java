package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apr;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0004H\u0016J>\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "scene", "", "(I)V", "TAG", "", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "comRR", "Lcom/tencent/mm/modelbase/CommReqResp;", "isShowPostRed", "", "()Z", "setShowPostRed", "(Z)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder_release"})
public final class cd extends ax implements m {
    private final String TAG = "Finder.NetSceneFinderPrepareUser";
    private i callback;
    private d tvD;
    public boolean twh;

    public cd(int i2) {
        AppMethodBeat.i(165263);
        d.a aVar = new d.a();
        bec bec = new bec();
        bec.scene = i2;
        am amVar = am.tuw;
        bec.uli = am.cXY();
        aVar.c(bec);
        aVar.d(new bed());
        aVar.sG(getType());
        aVar.MB("/cgi-bin/micromsg-bin/finderuserprepare");
        this.tvD = aVar.aXF();
        AppMethodBeat.o(165263);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3761;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(165260);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.tvD, this);
        AppMethodBeat.o(165260);
        return dispatch;
    }

    public final bed cZc() {
        AppMethodBeat.i(165261);
        d dVar = this.tvD;
        if (dVar == null) {
            p.hyc();
        }
        a aYK = dVar.aYK();
        if (aYK == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPrepareResponse");
            AppMethodBeat.o(165261);
            throw tVar;
        }
        bed bed = (bed) aYK;
        AppMethodBeat.o(165261);
        return bed;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.ax
    public final void a(int i2, int i3, int i4, String str, s sVar) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ao azQ;
        ar.a aVar;
        String str7;
        long j2;
        AppMethodBeat.i(242499);
        if (i3 == 0 && i4 == 0) {
            String str8 = this.TAG;
            StringBuilder append = new StringBuilder("userFlag=").append(cZc().LNK).append(" username=");
            FinderContact finderContact = cZc().LAJ;
            StringBuilder append2 = append.append(finderContact != null ? finderContact.username : null).append(" nickname=");
            FinderContact finderContact2 = cZc().LAJ;
            if (finderContact2 != null) {
                str2 = finderContact2.nickname;
            } else {
                str2 = null;
            }
            Log.i(str8, append2.append(str2).toString());
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, Integer.valueOf(cZc().LNK));
            FinderContact finderContact3 = cZc().LAJ;
            if (finderContact3 != null) {
                e aAh2 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, finderContact3.username);
                e aAh3 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh3, "MMKernel.storage()");
                aAh3.azQ().set(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, finderContact3.nickname);
                e aAh4 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh4, "MMKernel.storage()");
                aAh4.azQ().set(ar.a.USERINFO_MY_FINDER_SIGNATURE_STRING_SYNC, finderContact3.signature);
                e aAh5 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh5, "MMKernel.storage()");
                aAh5.azQ().set(ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC, finderContact3.headUrl);
                e aAh6 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh6, "MMKernel.storage()");
                aAh6.azQ().set(ar.a.USERINFO_MY_FINDER_COVER_IMG_STRING_SYNC, finderContact3.coverImgUrl);
                e aAh7 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh7, "MMKernel.storage()");
                aAh7.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(finderContact3.extFlag));
                e aAh8 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh8, "MMKernel.storage()");
                aAh8.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_FLAG2_INT_SYNC, Integer.valueOf(finderContact3.originalFlag));
                e aAh9 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh9, "MMKernel.storage()");
                aAh9.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_ENTRANCE2_INT_SYNC, Integer.valueOf(finderContact3.originalEntranceFlag));
                bac bac = finderContact3.originalInfo;
                if (bac != null) {
                    e aAh10 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh10, "MMKernel.storage()");
                    aAh10.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_REPOST_COUNT_INT_SYNC, Integer.valueOf(bac.LJQ));
                    e aAh11 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh11, "MMKernel.storage()");
                    aAh11.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_APPLY_COUNT_INT_SYNC, Integer.valueOf(bac.LJR));
                    e aAh12 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh12, "MMKernel.storage()");
                    aAh12.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_INT_SYNC, Integer.valueOf(bac.LJS));
                    e aAh13 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh13, "MMKernel.storage()");
                    aAh13.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_PUNISH_YEAR_FLAG_INT_SYNC, Integer.valueOf(bac.LJT));
                    e aAh14 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh14, "MMKernel.storage()");
                    aAh14.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_NEED_CHECK_FLAG_INT_SYNC, Integer.valueOf(bac.LJU));
                }
                c.a aVar2 = c.tsp;
                p.g(finderContact3, LocaleUtil.ITALIAN);
                c.a.a(finderContact3);
                if (finderContact3.authInfo == null) {
                    e aAh15 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh15, "MMKernel.storage()");
                    aAh15.azQ().set(ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC, "");
                } else {
                    e aAh16 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh16, "MMKernel.storage()");
                    ao azQ2 = aAh16.azQ();
                    ar.a aVar3 = ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC;
                    FinderAuthInfo finderAuthInfo = finderContact3.authInfo;
                    azQ2.set(aVar3, Util.encodeHexString(finderAuthInfo != null ? finderAuthInfo.toByteArray() : null));
                }
                e aAh17 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh17, "MMKernel.storage()");
                aAh17.azQ().set(ar.a.USERINFO_FINDER_LIVE_COVER_IMAGE_STRING_SYNC, finderContact3.liveCoverImgUrl);
                e aAh18 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh18, "MMKernel.storage()");
                ao azQ3 = aAh18.azQ();
                ar.a aVar4 = ar.a.USERINFO_FINDER_LIVE_ANCHOR_STATUS_FLAG_LONG_SYNC;
                apr apr = finderContact3.live_info;
                azQ3.set(aVar4, apr != null ? Long.valueOf(apr.LBA) : 0L);
                e aAh19 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh19, "MMKernel.storage()");
                ao azQ4 = aAh19.azQ();
                ar.a aVar5 = ar.a.USERINFO_FINDER_LIVE_SWITCH_FLAG_LONG_SYNC;
                apr apr2 = finderContact3.live_info;
                if (apr2 != null) {
                    j2 = Long.valueOf((long) apr2.LBB);
                } else {
                    j2 = 0L;
                }
                azQ4.set(aVar5, j2);
            }
            String str9 = cZc().LNM;
            if (str9 != null) {
                e aAh20 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh20, "MMKernel.storage()");
                aAh20.azQ().set(ar.a.USERINFO_MY_FINDER_POST_EDU_TITLE_STRING_SYNC, str9);
            }
            String str10 = cZc().LNN;
            if (str10 != null) {
                e aAh21 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh21, "MMKernel.storage()");
                aAh21.azQ().set(ar.a.USERINFO_MY_FINDER_POST_EDU_DESC_STRING_SYNC, str10);
            }
            e aAh22 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh22, "MMKernel.storage()");
            ao azQ5 = aAh22.azQ();
            ar.a aVar6 = ar.a.USERINFO_MY_FINDER_SHOP_BINDER_APPID_STRING_SYNC;
            bel bel = cZc().LNT;
            if (bel == null || (str3 = bel.appId) == null) {
                str3 = "";
            }
            azQ5.set(aVar6, str3);
            e aAh23 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh23, "MMKernel.storage()");
            ao azQ6 = aAh23.azQ();
            ar.a aVar7 = ar.a.USERINFO_MY_FINDER_SHOP_BINDER_PATH_STRING_SYNC;
            bel bel2 = cZc().LNT;
            if (bel2 == null || (str4 = bel2.LOg) == null) {
                str4 = "";
            }
            azQ6.set(aVar7, str4);
            e aAh24 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh24, "MMKernel.storage()");
            ao azQ7 = aAh24.azQ();
            ar.a aVar8 = ar.a.USERINFO_MY_FINDER_SHOP_APPID_STRING_SYNC;
            bel bel3 = cZc().wxaShopInfo;
            if (bel3 == null || (str5 = bel3.appId) == null) {
                str5 = "";
            }
            azQ7.set(aVar8, str5);
            e aAh25 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh25, "MMKernel.storage()");
            ao azQ8 = aAh25.azQ();
            ar.a aVar9 = ar.a.USERINFO_MY_FINDER_SHOP_PATH_STRING_SYNC;
            bel bel4 = cZc().wxaShopInfo;
            if (bel4 == null || (str6 = bel4.LOg) == null) {
                str6 = "";
            }
            azQ8.set(aVar9, str6);
            e aAh26 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh26, "MMKernel.storage()");
            aAh26.azQ().set(ar.a.USERINFO_MY_FINDER_LIVE_FLAG_INT_SYNC, Integer.valueOf(cZc().LNW));
            int i5 = cZc().vIE;
            if (i5 > 0) {
                Log.i(this.TAG, "nicknameMaxLength ： ".concat(String.valueOf(i5)));
                e aAh27 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh27, "MMKernel.storage()");
                aAh27.azQ().set(ar.a.USERINFO_MY_FINDER_POST_NICK_NAME_MAX_LENGTH_INT_SYNC, Integer.valueOf(i5));
            }
            if (cZc().LNZ == null) {
                e aAh28 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh28, "MMKernel.storage()");
                aAh28.azQ().set(ar.a.USERINFO_ACCOUNT_EXT_CONFIG_STRING_SYNC, "");
            } else {
                e aAh29 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh29, "MMKernel.storage()");
                ao azQ9 = aAh29.azQ();
                ar.a aVar10 = ar.a.USERINFO_ACCOUNT_EXT_CONFIG_STRING_SYNC;
                ax axVar = cZc().LNZ;
                azQ9.set(aVar10, Util.encodeHexString(axVar != null ? axVar.toByteArray() : null));
            }
            r rVar = r.vWn;
            r.a(cZc().LNV);
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            com.tencent.mm.plugin.finder.utils.m.bU(cZc().LEV);
            int i6 = cZc().LEW;
            Log.i(this.TAG, "current_alias_role_type：".concat(String.valueOf(i6)));
            e aAh30 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh30, "MMKernel.storage()");
            aAh30.azQ().set(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, Integer.valueOf(i6));
            long j3 = cZc().LEY;
            Log.i(this.TAG, "next_alias_mod_available_time：".concat(String.valueOf(j3)));
            e aAh31 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh31, "MMKernel.storage()");
            aAh31.azQ().set(ar.a.USERINFO_FINDER_LIVE_ALIAS_MODIFY_TIME_LONG_SYNC, Long.valueOf(j3));
            String str11 = cZc().LNY;
            if (str11 == null || str11.length() == 0) {
                e aAh32 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh32, "MMKernel.storage()");
                azQ = aAh32.azQ();
                aVar = ar.a.USERINFO_FINDER_ACCOUNT_DETAIL_URL_STRING_SYNC;
                str7 = "";
            } else {
                e aAh33 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh33, "MMKernel.storage()");
                azQ = aAh33.azQ();
                aVar = ar.a.USERINFO_FINDER_ACCOUNT_DETAIL_URL_STRING_SYNC;
                str7 = cZc().LNY;
                if (str7 == null) {
                    str7 = "";
                }
            }
            azQ.set(aVar, str7);
        }
        i iVar = this.callback;
        if (iVar != null) {
            iVar.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(242499);
            return;
        }
        AppMethodBeat.o(242499);
    }
}
