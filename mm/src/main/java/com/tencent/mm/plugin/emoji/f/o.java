package com.tencent.mm.plugin.emoji.f;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.decode.a;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.a.b;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionListRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class o extends q implements m {
    private i callback;
    private final int mScene;
    public final int mType;
    public byte[] rcY;
    public int rda;
    boolean rdb;
    ArrayList<EmotionSummary> rdc;
    private final d rr;

    public o(int i2, int i3) {
        this(i2, null, i3);
    }

    public o(int i2, byte[] bArr, int i3) {
        this(i2, bArr, i3, false);
    }

    public o(int i2, byte[] bArr, int i3, boolean z) {
        AppMethodBeat.i(108706);
        this.rdb = false;
        this.rdc = new ArrayList<>();
        this.rcY = null;
        d.a aVar = new d.a();
        aVar.iLN = new GetEmotionListRequest();
        aVar.iLO = new GetEmotionListResponse();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionlist";
        aVar.funcId = 411;
        aVar.iLP = 210;
        aVar.respCmdId = 1000000210;
        this.rr = aVar.aXF();
        this.rcY = bArr;
        this.mType = i2;
        this.mScene = i3;
        this.rdb = z;
        Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "NetSceneGetEmotionList: %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
        AppMethodBeat.o(108706);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 411;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108707);
        this.callback = iVar;
        GetEmotionListRequest getEmotionListRequest = (GetEmotionListRequest) this.rr.iLK.iLR;
        if (this.rcY != null) {
            getEmotionListRequest.ReqBuf = z.aC(this.rcY);
        } else {
            getEmotionListRequest.ReqBuf = new SKBuiltinBuffer_t();
        }
        Log.d("MicroMsg.emoji.NetSceneGetEmotionList", getEmotionListRequest.ReqBuf == null ? "Buf is NULL" : getEmotionListRequest.ReqBuf.toString());
        getEmotionListRequest.ReqType = this.mType;
        getEmotionListRequest.Scene = this.mScene;
        if (this.mType == 7) {
            getEmotionListRequest.Category = this.rda;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108707);
        return dispatch;
    }

    public final GetEmotionListResponse cGx() {
        if (this.rr == null) {
            return null;
        }
        return (GetEmotionListResponse) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108708);
        Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "ErrType:" + i3 + "   errCode:" + i4);
        if (this.mType == 8) {
            if (i3 == 0 && i4 == 0) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(System.currentTimeMillis()));
            } else {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf((System.currentTimeMillis() - Util.MILLSECONDS_OF_DAY) + Util.MILLSECONDS_OF_HOUR));
            }
        }
        if (this.mType == 11) {
            if (i3 == 0 && i4 == 0) {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            } else {
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_STORE_RECOMMEND_LAST_UPDATE_TIME_LONG, Long.valueOf((System.currentTimeMillis() - 28800000) + 600000));
            }
            k.getEmojiStorageMgr().OpQ.a(this.mType, cGx());
        }
        if (i3 == 0 || i3 == 4) {
            GetEmotionListResponse getEmotionListResponse = (GetEmotionListResponse) ((d) sVar).iLL.iLR;
            if (getEmotionListResponse.ReqBuf != null) {
                this.rcY = z.a(getEmotionListResponse.ReqBuf);
            }
            if (this.mType == 8) {
                if (i4 == 0) {
                    cGy();
                    h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.plugin.emoji.f.o.AnonymousClass1 */

                        public final void run() {
                            EmojiGroupInfo emojiGroupInfo;
                            EmojiInfo blm;
                            AppMethodBeat.i(179057);
                            o oVar = o.this;
                            ArrayList<EmotionSummary> arrayList = o.this.rdc;
                            Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList: %s", Integer.valueOf(arrayList.size()));
                            c cVar = k.getEmojiStorageMgr().OpO;
                            if (cVar == null) {
                                Log.w("MicroMsg.emoji.NetSceneGetEmotionList", "preparedDownloadStoreEmojiList failed. get emoji group info storage failed.");
                                AppMethodBeat.o(179057);
                                return;
                            }
                            Long valueOf = Long.valueOf(System.currentTimeMillis());
                            if (arrayList == null || arrayList.size() <= 0) {
                                Iterator<EmojiGroupInfo> it = cVar.gEG().iterator();
                                while (it.hasNext()) {
                                    EmojiGroupInfo next = it.next();
                                    if (next.field_sync > 0) {
                                        Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "delete pid:%s", next.field_productID);
                                        cVar.blc(next.field_productID);
                                    }
                                }
                                cVar.blc("com.tencent.xin.emoticon.tusiji");
                            } else if (arrayList == null || arrayList.size() <= 0) {
                                Log.e("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary empty summary.");
                            } else {
                                HashMap<String, EmojiGroupInfo> gEF = cVar.gEF();
                                ArrayList arrayList2 = new ArrayList();
                                ArrayList arrayList3 = new ArrayList();
                                int size = arrayList.size();
                                Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "updateEmojiGroupByEmotionSummary size:%d", Integer.valueOf(size));
                                for (int i2 = 0; i2 < size; i2++) {
                                    EmotionSummary emotionSummary = arrayList.get(i2);
                                    if (emotionSummary == null || Util.isNullOrNil(emotionSummary.ProductID)) {
                                        Log.w("MicroMsg.emoji.EmojiGroupInfoStorage", "summary is null or product id is null.");
                                    } else {
                                        Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "summary productID:%s", emotionSummary.ProductID);
                                        arrayList2.add(emotionSummary.ProductID);
                                        if (gEF.containsKey(emotionSummary.ProductID)) {
                                            EmojiGroupInfo emojiGroupInfo2 = gEF.get(emotionSummary.ProductID);
                                            if (emojiGroupInfo2 == null) {
                                                emojiGroupInfo2 = new EmojiGroupInfo();
                                            }
                                            emojiGroupInfo2.field_productID = emotionSummary.ProductID;
                                            emojiGroupInfo = emojiGroupInfo2;
                                        } else if (emotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                                            EmojiGroupInfo emojiGroupInfo3 = gEF.get(String.valueOf(EmojiGroupInfo.VkN));
                                            if (emojiGroupInfo3 == null) {
                                                emojiGroupInfo3 = new EmojiGroupInfo();
                                            }
                                            emojiGroupInfo3.field_productID = String.valueOf(EmojiGroupInfo.VkN);
                                            emojiGroupInfo = emojiGroupInfo3;
                                        } else {
                                            EmojiGroupInfo emojiGroupInfo4 = new EmojiGroupInfo();
                                            emojiGroupInfo4.field_productID = emotionSummary.ProductID;
                                            emojiGroupInfo = emojiGroupInfo4;
                                        }
                                        if (emotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                                            emojiGroupInfo.field_flag = 0;
                                            emojiGroupInfo.field_packName = "emoji_custom_all";
                                            emojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
                                        } else {
                                            emojiGroupInfo.field_packName = emotionSummary.PackName;
                                            emojiGroupInfo.field_type = EmojiGroupInfo.VkK;
                                        }
                                        emojiGroupInfo.field_packIconUrl = emotionSummary.IconUrl;
                                        emojiGroupInfo.field_packGrayIconUrl = emotionSummary.PanelUrl;
                                        emojiGroupInfo.field_packCoverUrl = emotionSummary.CoverUrl;
                                        emojiGroupInfo.field_packDesc = emotionSummary.PackDesc;
                                        emojiGroupInfo.field_packAuthInfo = emotionSummary.PackAuthInfo;
                                        emojiGroupInfo.field_packPrice = emotionSummary.PackPrice;
                                        emojiGroupInfo.field_packType = emotionSummary.PackType;
                                        emojiGroupInfo.field_packFlag = emotionSummary.PackFlag;
                                        emojiGroupInfo.field_packExpire = (long) emotionSummary.PackExpire;
                                        emojiGroupInfo.field_packTimeStamp = (long) emotionSummary.Timestamp;
                                        emojiGroupInfo.field_sort = 1;
                                        emojiGroupInfo.field_idx = i2;
                                        if (emojiGroupInfo.field_sync == 0) {
                                            if (emojiGroupInfo.field_status == 7 && emojiGroupInfo.field_packStatus == 1) {
                                                emojiGroupInfo.field_sync = 2;
                                            } else {
                                                emojiGroupInfo.field_sync = 1;
                                            }
                                        }
                                        if (emojiGroupInfo.field_sync == 2) {
                                            emojiGroupInfo.field_status = 7;
                                        }
                                        if (emojiGroupInfo.field_sync == 2 && !emotionSummary.ProductID.equals("com.tencent.xin.emoticon.tusiji")) {
                                            String str = emotionSummary.ProductID;
                                            boolean z = false;
                                            if (!Util.isNullOrNil(str) && (blm = bj.gCJ().OpN.blm(str)) != null && blm.hYi()) {
                                                boolean b2 = a.aum().b(blm);
                                                if (!b2) {
                                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(252, 9, 1, false);
                                                }
                                                z = b2;
                                            }
                                            if (!z) {
                                                Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "decode failed re download product:%s.", emotionSummary.ProductID);
                                                emojiGroupInfo.field_sync = 1;
                                            }
                                        }
                                        Log.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupByEmotionSummary: prodcutId: %s, lasttime: %d, sort: %d", emojiGroupInfo.field_productID, Long.valueOf(emojiGroupInfo.field_lastUseTime), Integer.valueOf(emojiGroupInfo.field_sort));
                                        cVar.replace(emojiGroupInfo);
                                    }
                                }
                                for (EmojiGroupInfo emojiGroupInfo5 : gEF.values()) {
                                    if (emojiGroupInfo5 != null && !Util.isNullOrNil(emojiGroupInfo5.field_productID) && !emojiGroupInfo5.field_productID.equals(String.valueOf(EmojiGroupInfo.VkO))) {
                                        if (emojiGroupInfo5.field_productID.equals(String.valueOf(EmojiGroupInfo.VkN))) {
                                            if (!arrayList2.contains("com.tencent.xin.emoticon.tusiji")) {
                                                Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", "com.tencent.xin.emoticon.tusiji");
                                                arrayList3.add("com.tencent.xin.emoticon.tusiji");
                                            }
                                        } else if (!arrayList2.contains(emojiGroupInfo5.field_productID)) {
                                            Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "need to delete product id:%s", emojiGroupInfo5.field_productID);
                                            arrayList3.add(emojiGroupInfo5.field_productID);
                                        }
                                    }
                                }
                                if (arrayList3.size() > 0) {
                                    Iterator it2 = arrayList3.iterator();
                                    while (it2.hasNext()) {
                                        cVar.blc((String) it2.next());
                                    }
                                }
                                cVar.doNotify("event_update_group", 0, Util.getStack().toString());
                            }
                            Log.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[cpan] preparedDownloadCustomEmojiList use time:%d", Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                            cVar.doNotify("event_update_group", 0, Util.getStack().toString());
                            if (!oVar.rdb) {
                                ArrayList arrayList4 = (ArrayList) cVar.gEQ();
                                if (arrayList4.size() > 0) {
                                    Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d", Integer.valueOf(arrayList4.size()));
                                    ArrayList<com.tencent.mm.plugin.emoji.sync.c> arrayList5 = new ArrayList<>();
                                    Iterator it3 = arrayList4.iterator();
                                    while (it3.hasNext()) {
                                        String str2 = (String) it3.next();
                                        if (!Util.isNullOrNil(str2)) {
                                            if (str2.equals(String.valueOf(EmojiGroupInfo.VkN))) {
                                                arrayList5.add(new b("com.tencent.xin.emoticon.tusiji"));
                                            } else {
                                                arrayList5.add(new com.tencent.mm.plugin.emoji.sync.a.a(str2));
                                            }
                                        }
                                    }
                                    k.cGg().X(arrayList5);
                                    if (!k.cGg().rds.rdC) {
                                        k.cGg().rds.cGC();
                                    }
                                }
                            } else if (arrayList != null && arrayList.size() > 0) {
                                Log.i("MicroMsg.emoji.NetSceneGetEmotionList", "try to sync store emoji list:size:%d force", Integer.valueOf(arrayList.size()));
                                ArrayList<com.tencent.mm.plugin.emoji.sync.c> arrayList6 = new ArrayList<>();
                                Iterator<EmotionSummary> it4 = arrayList.iterator();
                                while (it4.hasNext()) {
                                    EmotionSummary next2 = it4.next();
                                    if (next2 != null && !Util.isNullOrNil(next2.ProductID)) {
                                        if (next2.ProductID.equals(String.valueOf(EmojiGroupInfo.VkN))) {
                                            arrayList6.add(new b("com.tencent.xin.emoticon.tusiji"));
                                        } else {
                                            arrayList6.add(new com.tencent.mm.plugin.emoji.sync.a.a(next2.ProductID, (byte) 0));
                                        }
                                    }
                                }
                                k.cGg().X(arrayList6);
                                if (!k.cGg().rds.rdC) {
                                    k.cGg().rds.cGC();
                                }
                                AppMethodBeat.o(179057);
                                return;
                            }
                            AppMethodBeat.o(179057);
                        }
                    });
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(System.currentTimeMillis()));
                } else if (i4 == 2) {
                    cGy();
                    ((GetEmotionListRequest) ((d) sVar).iLK.iLR).ReqBuf = ((GetEmotionListResponse) ((d) sVar).iLL.iLR).ReqBuf;
                    doScene(dispatcher(), this.callback);
                } else if (i4 == 3) {
                    if (this.rdc != null) {
                        this.rdc.clear();
                    }
                    ((GetEmotionListRequest) ((d) sVar).iLK.iLR).ReqBuf = new SKBuiltinBuffer_t();
                    doScene(dispatcher(), this.callback);
                }
            }
            if (this.mType == 1 || this.mType == 9) {
                e cFX = e.cFX();
                String str2 = cGx().EmotionExptConfig;
                if (!Util.isEqual(cFX.rbl, str2)) {
                    cFX.rbl = str2;
                    cFX.cFY();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_STORE_EXPT_CONFIG_STRING, str2);
                    EventCenter.instance.publish(new dl());
                }
            } else if (this.mType == 5) {
                e cFX2 = e.cFX();
                String str3 = cGx().EmotionExptConfig;
                if (!Util.isEqual(cFX2.rbk, str3)) {
                    cFX2.rbk = str3;
                    cFX2.cFY();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_STORE_EXPT_MAIN_TAB_CONFIG_STRING, str3);
                    EventCenter.instance.publish(new dl());
                }
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(108708);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108708);
    }

    public static com.tencent.mm.plugin.emoji.model.g a(GetEmotionListResponse getEmotionListResponse) {
        Object[] array;
        EmotionSummary emotionSummary;
        AppMethodBeat.i(108709);
        Log.d("MicroMsg.emoji.NetSceneGetEmotionList", "getEmotionListModel");
        if (getEmotionListResponse == null) {
            AppMethodBeat.o(108709);
            return null;
        }
        com.tencent.mm.plugin.emoji.model.g gVar = new com.tencent.mm.plugin.emoji.model.g();
        if (getEmotionListResponse != null) {
            gVar.rbs = getEmotionListResponse.EmotionCount;
            ArrayList arrayList = new ArrayList();
            if (getEmotionListResponse.EmotionList != null && !getEmotionListResponse.EmotionList.isEmpty() && (array = getEmotionListResponse.EmotionList.toArray()) != null && array.length > 0) {
                for (Object obj : array) {
                    if (obj != null && (obj instanceof EmotionSummary) && (emotionSummary = (EmotionSummary) obj) != null && !Util.isNullOrNil(emotionSummary.ProductID)) {
                        arrayList.add(new f(emotionSummary));
                    }
                }
            }
            gVar.rbt = arrayList;
            gVar.rbu = getEmotionListResponse.Banner;
            gVar.rbv = getEmotionListResponse.NewBannerList;
            LinkedList<EmotionBannerSet> linkedList = getEmotionListResponse.CellSetList;
            if (gVar.rbx == null) {
                gVar.rbx = new LinkedList();
                gVar.rbx.addAll(linkedList);
            }
            gVar.rbw = getEmotionListResponse.BannerSetList;
        }
        AppMethodBeat.o(108709);
        return gVar;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 100;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    private void cGy() {
        AppMethodBeat.i(108710);
        GetEmotionListResponse cGx = cGx();
        if (cGx == null || cGx.EmotionList == null || cGx.EmotionList.size() <= 0) {
            Log.w("MicroMsg.emoji.NetSceneGetEmotionList", "addSummaryList faild. response is null or emotion list is empty.");
            AppMethodBeat.o(108710);
            return;
        }
        this.rdc.addAll(cGx.EmotionList);
        AppMethodBeat.o(108710);
    }
}
