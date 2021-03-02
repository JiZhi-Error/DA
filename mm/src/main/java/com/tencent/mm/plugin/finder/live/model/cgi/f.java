package com.tencent.mm.plugin.finder.live.model.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J4\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0016\u0010 \u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0002R\u000e\u0010\f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "liveId", "", "objectId", "objectNonceId", "", ch.COL_USERNAME, "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "(JJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListRequest;", "dumpLocalGift", "gift", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "dumpRemoteGift", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGift;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalGift", "remoteGift", "Ljava/util/LinkedList;", "CallBack", "plugin-finder_release"})
public final class f extends k<ata> {
    private final String TAG = "Finder.CgiFinderGetLiveGiftList";
    private asz ukE = new asz();
    private final a ukF;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderGetLiveGiftList$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveRewardGiftListResponse;", "plugin-finder_release"})
    public interface a {
        void a(int i2, int i3, ata ata);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(long j2, long j3, String str, String str2, a aVar) {
        super((byte) 0);
        p.h(str, "objectNonceId");
        AppMethodBeat.i(246308);
        this.ukF = aVar;
        asz asz = this.ukE;
        am amVar = am.tuw;
        asz.LBM = am.cXY();
        this.ukE.hyH = j2;
        this.ukE.object_id = j3;
        this.ukE.object_nonce_id = str;
        this.ukE.username = str2;
        asz asz2 = this.ukE;
        o oVar = o.ujN;
        asz2.LDs = o.dgc();
        Log.i(this.TAG, "liveId:" + j2 + " objectId:" + j3 + " objectNonceId:" + str + " username:" + str2);
        d.a aVar2 = new d.a();
        aVar2.c(this.ukE);
        ata ata = new ata();
        ata.setBaseResponse(new BaseResponse());
        ata.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(ata);
        aVar2.MB("/cgi-bin/micromsg-bin/findergetliverewardgiftlist");
        aVar2.sG(4053);
        c(aVar2.aXF());
        AppMethodBeat.o(246308);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, dpc dpc, q qVar) {
        AppMethodBeat.i(246304);
        ata ata = (ata) dpc;
        p.h(ata, "resp");
        Log.i(this.TAG, "[onCgiBack] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            if (!Util.isNullOrNil(ata.LDV)) {
                LinkedList<awd> linkedList = ata.LDV;
                p.g(linkedList, "resp.gift_list");
                am(linkedList);
            } else {
                Log.w(this.TAG, "resp.gift_list is nullOrNil");
            }
        }
        a aVar = this.ukF;
        if (aVar != null) {
            aVar.a(i2, i3, ata);
            AppMethodBeat.o(246304);
            return;
        }
        AppMethodBeat.o(246304);
    }

    private final void am(LinkedList<awd> linkedList) {
        T t;
        T t2;
        boolean z;
        AppMethodBeat.i(246305);
        t liveGiftStorage = ((PluginFinder) g.ah(PluginFinder.class)).getLiveGiftStorage();
        List<s> dxR = liveGiftStorage.dxR();
        if (dxR.isEmpty()) {
            int i2 = 0;
            for (T t3 : linkedList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t4 = t3;
                s sVar = new s();
                sVar.field_rewardProductId = t4.LFM;
                sVar.field_businessType = t4.KTE;
                sVar.field_thumbnailFileUrl = t4.LGJ;
                sVar.field_previewPagUrl = t4.LGK;
                sVar.field_animationPagUrl = t4.LGL;
                sVar.field_thumbnailMd5 = t4.LGM;
                sVar.field_previewPagMd5 = t4.LGN;
                sVar.field_animationPagMd5 = t4.LGO;
                sVar.field_giftType = t4.LGQ;
                sVar.field_name = t4.name;
                sVar.field_price = t4.LGP;
                sVar.field_giftIndex = i2;
                ((PluginFinder) g.ah(PluginFinder.class)).getLiveGiftStorage().b(sVar);
                Log.i(this.TAG, a((awd) t4));
                i2 = i3;
            }
        } else {
            ArrayList<s> arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            for (T t5 : dxR) {
                Iterator<T> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Util.isEqual(t.LFM, ((s) t5).field_rewardProductId)) {
                        break;
                    }
                }
                boolean z2 = t == null;
                Iterator<T> it2 = linkedList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t2 = null;
                        break;
                    }
                    t2 = it2.next();
                    T t6 = t2;
                    if (!Util.isEqual(t6.LFM, ((s) t5).field_rewardProductId) || (Util.isEqual(t6.LGJ, ((s) t5).field_thumbnailFileUrl) && Util.isEqual(t6.LGK, ((s) t5).field_previewPagUrl) && Util.isEqual(t6.LGL, ((s) t5).field_animationPagUrl))) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                boolean z3 = t2 != null;
                String str = ((s) t5).field_rewardProductId;
                p.g(str, "localGiftInfo.field_rewardProductId");
                hashMap.put(str, Integer.valueOf(((s) t5).field_state));
                if (z2 || z3) {
                    arrayList.add(t5);
                    String str2 = ((s) t5).field_rewardProductId;
                    p.g(str2, "localGiftInfo.field_rewardProductId");
                    hashMap.put(str2, 0);
                }
                Log.i(this.TAG, "localGiftDeprecated:" + z2 + ", localGiftUrlDeprecated:" + z3 + ' ' + a((s) t5));
            }
            for (s sVar2 : arrayList) {
                Log.i(this.TAG, "remove " + liveGiftStorage.db.delete("FinderLiveGiftInfo", "rewardProductId=?", new String[]{String.valueOf(sVar2.field_rewardProductId)}) + ' ' + a(sVar2));
            }
            int i4 = 0;
            for (T t7 : linkedList) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    j.hxH();
                }
                T t8 = t7;
                s sVar3 = new s();
                sVar3.field_rewardProductId = t8.LFM;
                sVar3.field_businessType = t8.KTE;
                sVar3.field_thumbnailFileUrl = t8.LGJ;
                sVar3.field_previewPagUrl = t8.LGK;
                sVar3.field_animationPagUrl = t8.LGL;
                sVar3.field_thumbnailMd5 = t8.LGM;
                sVar3.field_previewPagMd5 = t8.LGN;
                sVar3.field_animationPagMd5 = t8.LGO;
                sVar3.field_giftType = t8.LGQ;
                sVar3.field_name = t8.name;
                Integer num = (Integer) hashMap.get(t8.LFM);
                sVar3.field_state = num != null ? num.intValue() : 0;
                sVar3.field_price = t8.LGP;
                sVar3.field_giftIndex = i4;
                ((PluginFinder) g.ah(PluginFinder.class)).getLiveGiftStorage().b(sVar3);
                Log.i(this.TAG, a((awd) t8));
                i4 = i5;
            }
        }
        e eVar = e.uiD;
        e.dfz();
        AppMethodBeat.o(246305);
    }

    private static String a(awd awd) {
        AppMethodBeat.i(246306);
        String str = "remoteGift : [id:" + awd.LFM + ", businessType:" + awd.KTE + ", thumbnailFileUrl:" + awd.LGJ + ", previewUrl:" + awd.LGK + ", animationUrl:" + awd.LGL + ", thumbnailMd5:" + awd.LGM + ", previewMd5:" + awd.LGN + ", animationMd5:" + awd.LGO + ", type:" + awd.LGQ + ", name:" + awd.name + ", price:" + awd.LGP + ']';
        AppMethodBeat.o(246306);
        return str;
    }

    private static String a(s sVar) {
        AppMethodBeat.i(246307);
        String str = "localGift : [id:" + sVar.field_rewardProductId + ", businessType:" + sVar.field_businessType + ", thumbnailFileUrl:" + sVar.field_thumbnailFileUrl + ", previewUrl:" + sVar.field_previewPagUrl + ", animationUrl:" + sVar.field_animationPagUrl + ", thumbnailMd5:" + sVar.field_thumbnailMd5 + ", previewMd5:" + sVar.field_previewPagMd5 + ", animationMd5:" + sVar.field_animationPagMd5 + ", type:" + sVar.field_giftType + ", name:" + sVar.field_name + ", price:" + sVar.field_price + ", state:" + sVar.field_state + ']';
        AppMethodBeat.o(246307);
        return str;
    }
}
