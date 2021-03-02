package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends q implements m {
    public static int rcv = 0;
    public static int rcw = 1;
    private i callback;
    private int mIndex;
    private ar.a rcA;
    private LinkedList<String> rcB;
    private int rcs;
    private ArrayList<String> rcu;
    private ArrayList<EmojiInfo> rcx;
    private int rcy;
    private ar.a rcz;
    private final d rr;

    public e(int i2) {
        this(new LinkedList(), i2, rcv);
        AppMethodBeat.i(104569);
        AppMethodBeat.o(104569);
    }

    public e(LinkedList<String> linkedList) {
        this(linkedList, 0, rcw);
    }

    private e(LinkedList<String> linkedList, int i2, int i3) {
        AppMethodBeat.i(104570);
        this.rcu = new ArrayList<>();
        this.rcx = new ArrayList<>();
        this.mIndex = 0;
        this.rcy = 0;
        this.rcB = new LinkedList<>();
        d.a aVar = new d.a();
        aVar.iLN = new ka();
        aVar.iLO = new kb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.funcId = 697;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.mIndex = 0;
        this.rcy = i3;
        this.rcB = linkedList;
        this.rcs = i2;
        if (this.rcs == 1) {
            this.rcz = ar.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN;
            this.rcA = ar.a.USERINFO_EMOJI_NEXT_CAPTURE_BATCH_DOWNLOAD_TIME_LONG;
            AppMethodBeat.o(104570);
            return;
        }
        this.rcz = ar.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN;
        this.rcA = ar.a.USERINFO_EMOJI_NEXT_CUSTOM_BATCH_DOWNLOAD_TIME_LONG;
        AppMethodBeat.o(104570);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int size;
        AppMethodBeat.i(104571);
        Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.rcy == rcv) {
            if (i3 == 0 && i4 == 0) {
                kb kbVar = (kb) this.rr.iLL.iLR;
                ka kaVar = (ka) this.rr.iLK.iLR;
                if (kbVar.jeU == 0 && (kbVar.KMy == null || kbVar.KMy.size() <= 0)) {
                    this.callback.onSceneEnd(i3, i4, str, this);
                    Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
                    h.INSTANCE.idkeyStat(164, 0, 1, false);
                    AppMethodBeat.o(104571);
                } else if (kbVar.jeU == 1) {
                    this.callback.onSceneEnd(i3, i4, str, this);
                    g.aAh().azQ().set(this.rcA, Long.valueOf(System.currentTimeMillis() + Util.MILLSECONDS_OF_DAY));
                    g.aAh().azQ().set(this.rcz, Boolean.FALSE);
                    a(kbVar);
                    Object[] objArr = new Object[1];
                    if (this.rcx == null) {
                        size = 0;
                    } else {
                        size = this.rcx.size();
                    }
                    objArr[0] = Integer.valueOf(size);
                    Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] preparedDownloadCustomEmojiList size:%s", objArr);
                    ArrayList<String> arrayList = this.rcu;
                    if (arrayList == null || arrayList.size() <= 0) {
                        Log.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
                        g.aAh().azQ().set(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                    } else {
                        if (arrayList.size() < n.auY()) {
                            g.aAh().azQ().set(ar.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.FALSE);
                        }
                        ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN, Boolean.TRUE)).booleanValue();
                        bj.gCJ().OpN.y(this.rcs, this.rcx);
                        g.aAh().azQ().set(ar.a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN, Boolean.FALSE);
                        f fVar = bj.gCJ().OpN;
                        int i5 = this.rcs;
                        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (arrayList == null || arrayList.size() <= 0) {
                            Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
                        } else {
                            List<String> akt = fVar.akt(i5);
                            if (akt.size() <= 0) {
                                Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                for (String str2 : akt) {
                                    if (!arrayList.contains(str2.toLowerCase())) {
                                        arrayList2.add(str2);
                                        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", str2);
                                    }
                                }
                                fVar.I(arrayList2, i5);
                                Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(arrayList2.size()));
                            }
                        }
                        ArrayList arrayList3 = (ArrayList) bj.gCJ().OpN.akw(0);
                        if (arrayList3.size() > 0) {
                            Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", Integer.valueOf(arrayList3.size()));
                            h.INSTANCE.a(11595, 2, Integer.valueOf(this.rcs));
                            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                                h.INSTANCE.a(11595, 3, Integer.valueOf(this.rcs));
                            }
                        } else {
                            g.aAh().azQ().set(this.rcz, Boolean.FALSE);
                            Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
                        }
                        if (this.rcs == 1) {
                            j.auL().dY(true);
                            EmojiSyncManager.a aVar = EmojiSyncManager.hda;
                            EmojiSyncManager.a.awo().eg(false);
                        } else {
                            j.auL().dW(true);
                            j.auL().dV(true);
                            EmojiSyncManager.a aVar2 = EmojiSyncManager.hda;
                            EmojiSyncManager.a.awn().eg(false);
                        }
                        k kVar = k.gXr;
                        k.auS();
                        EventCenter.instance.publish(new rj());
                    }
                    h.INSTANCE.idkeyStat(164, 0, 1, false);
                    AppMethodBeat.o(104571);
                } else {
                    Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", Integer.valueOf(kaVar.xuA), Integer.valueOf(kbVar.KMy.size()));
                    this.callback.onSceneEnd(i3, i4, str, this);
                    kaVar.xuA = kbVar.xuA;
                    this.mIndex = kaVar.xuA;
                    a(kbVar);
                    int doScene = doScene(dispatcher(), this.callback);
                    if (i2 < 0) {
                        Log.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", Integer.valueOf(doScene));
                    }
                    AppMethodBeat.o(104571);
                }
            } else {
                this.callback.onSceneEnd(i3, i4, str, this);
                h.INSTANCE.idkeyStat(164, 1, 1, false);
                g.aAh().azQ().set(this.rcA, Long.valueOf(System.currentTimeMillis() + Util.MILLSECONDS_OF_HOUR));
                g.aAh().azQ().set(this.rcz, Boolean.TRUE);
                AppMethodBeat.o(104571);
            }
        } else if (i3 == 0 && i4 == 0) {
            kb kbVar2 = (kb) this.rr.iLL.iLR;
            if (kbVar2.KOp == null || kbVar2.KOp.size() <= 0) {
                Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
            } else {
                bj.gCJ().OpN.jb(kbVar2.KOp);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(104571);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(104571);
        }
    }

    private void a(kb kbVar) {
        AppMethodBeat.i(104572);
        Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList mCustomType: %d", Integer.valueOf(this.rcs));
        if (kbVar == null) {
            Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
            AppMethodBeat.o(104572);
        } else if (kbVar.KOp == null || kbVar.KOp.size() <= 0) {
            Log.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
            AppMethodBeat.o(104572);
        } else {
            Iterator<ait> it = kbVar.KOp.iterator();
            while (it.hasNext()) {
                ait next = it.next();
                if (Util.isNullOrNil(next.Md5)) {
                    Log.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList: empty md5 %s", next);
                } else {
                    this.rcu.add(next.Md5.toLowerCase());
                    EmojiInfo emojiInfo = new EmojiInfo();
                    b.a(next, emojiInfo);
                    if (this.rcs == 1) {
                        emojiInfo.field_groupId = "capture";
                    } else {
                        emojiInfo.field_catalog = EmojiInfo.VkW;
                    }
                    this.rcx.add(emojiInfo);
                }
            }
            AppMethodBeat.o(104572);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 697;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(104573);
        this.callback = iVar;
        ka kaVar = (ka) this.rr.iLK.iLR;
        kaVar.xuA = this.mIndex;
        kaVar.ReqType = this.rcy;
        kaVar.KOo = this.rcB;
        kaVar.xIY = this.rcs;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(104573);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 20;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    public final kb cGq() {
        if (this.rr == null) {
            return null;
        }
        return (kb) this.rr.iLL.iLR;
    }
}
