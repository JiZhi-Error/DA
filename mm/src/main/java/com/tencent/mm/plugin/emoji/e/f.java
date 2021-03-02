package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.h;
import com.tencent.mm.ca.a;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.g.a.Cdo;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.u;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.c;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.protocal.protobuf.dyv;
import com.tencent.mm.protocal.protobuf.dyw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import com.tencent.mm.storage.emotion.w;
import com.tencent.mm.vfs.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class f implements d {
    @Override // com.tencent.mm.pluginsdk.a.d
    public final EmojiInfo aml(String str) {
        AppMethodBeat.i(108440);
        EmojiInfo blk = k.getEmojiStorageMgr().OpN.blk(str);
        AppMethodBeat.o(108440);
        return blk;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final EmojiInfo amm(String str) {
        AppMethodBeat.i(108441);
        EmojiInfo aml = aml(str);
        AppMethodBeat.o(108441);
        return aml;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final void a(Context context, ca caVar, String str) {
        EmojiInfo emojiInfo;
        AppMethodBeat.i(108444);
        if (context == null || caVar == null) {
            Log.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
            AppMethodBeat.o(108444);
            return;
        }
        be bkr = be.bkr(caVar.field_content);
        k.b HD = k.b.HD(caVar.field_content);
        if (HD == null) {
            HD = new k.b();
            HD.iwK = bkr.md5;
        }
        EmojiInfo blk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(HD.iwK);
        if (blk == null || !blk.hYi()) {
            EmojiInfo blk2 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(HD.iwK);
            if (blk2 == null) {
                String str2 = HD.iwK;
                if (Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.emoji.EmojiMgrImpl", "md5 is null.");
                    AppMethodBeat.o(108444);
                    return;
                }
                EmojiInfo emojiInfo2 = new EmojiInfo();
                emojiInfo2.field_md5 = str2;
                emojiInfo2.field_app_id = HD.appId;
                emojiInfo2.field_catalog = EmojiInfo.VkQ;
                emojiInfo2.field_size = HD.iwI;
                emojiInfo2.field_temp = 1;
                emojiInfo2.field_state = EmojiInfo.Vlg;
                com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.K(emojiInfo2);
                emojiInfo = emojiInfo2;
            } else {
                emojiInfo = blk2;
            }
            df(emojiInfo.field_md5, 0);
            Log.d("MicroMsg.emoji.EmojiMgrImpl", "start change cdn url. md5:%s", emojiInfo.field_md5);
            final String str3 = emojiInfo.field_md5;
            e eVar = e.gVM;
            e.a(emojiInfo, true, (i.a) new i.a() {
                /* class com.tencent.mm.plugin.emoji.e.f.AnonymousClass1 */

                @Override // com.tencent.mm.emoji.loader.d.i.a
                public final void dQ(boolean z) {
                    AppMethodBeat.i(108439);
                    if (z) {
                        f.df(str3, 1);
                        AppMethodBeat.o(108439);
                        return;
                    }
                    f.df(str3, 2);
                    AppMethodBeat.o(108439);
                }
            });
            AppMethodBeat.o(108444);
        } else if (caVar.field_isSend == 1) {
            a(context, HD.iwK, HD.appId, HD.appName, caVar.field_msgSvrId, caVar.field_talker, caVar.field_content, str);
            AppMethodBeat.o(108444);
        } else {
            a(context, blk.getMd5(), HD.appId, HD.appName, caVar.field_msgSvrId, caVar.field_talker, caVar.field_content, str);
            AppMethodBeat.o(108444);
        }
    }

    static void df(String str, int i2) {
        AppMethodBeat.i(108445);
        u uVar = new u();
        uVar.dCJ.dCK = str;
        uVar.dCJ.status = i2;
        uVar.dCJ.percentage = 0;
        EventCenter.instance.publish(uVar);
        Log.d("MicroMsg.emoji.EmojiMgrImpl", "attachid:%s percentage:%d status:%d", str, 0, Integer.valueOf(i2));
        AppMethodBeat.o(108445);
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean u(Context context, String str, String str2) {
        Cursor aku;
        AppMethodBeat.i(108446);
        if (context == null) {
            Log.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
            AppMethodBeat.o(108446);
            return false;
        } else if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
            AppMethodBeat.o(108446);
            return false;
        } else {
            EmojiInfo blk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(str2);
            if (blk == null) {
                Log.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", str2);
                AppMethodBeat.o(108446);
                return false;
            }
            if (blk.field_type == EmojiInfo.Vla || blk.field_type == EmojiInfo.Vlb) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                String hYx = blk.hYx();
                if (s.YS(blk.hYy())) {
                    wXMediaMessage.thumbData = s.aW(blk.hYy(), 0, -1);
                } else {
                    wXMediaMessage.setThumbImage(blk.hYk());
                }
                wXMediaMessage.mediaObject = new WXEmojiObject(hYx);
                tt ttVar = new tt();
                ttVar.eaf.dCE = wXMediaMessage;
                ttVar.eaf.appId = blk.field_app_id;
                ttVar.eaf.appName = null;
                ttVar.eaf.toUser = str;
                ttVar.eaf.dMG = 0;
                ttVar.eaf.eai = blk.getMd5();
                EventCenter.instance.publish(ttVar);
            } else {
                if (blk.field_type == EmojiInfo.VkX) {
                    if (EmojiInfo.axs(blk.field_catalog)) {
                        aku = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.aku(blk.field_catalog);
                    } else {
                        aku = (blk.field_catalog != EmojiInfo.VkS || blk.getContent().length() <= 0 || !EmojiInfo.axs(Util.getInt(blk.getContent(), 0))) ? null : com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.aku(Util.getInt(blk.getContent(), 0));
                    }
                    if (aku != null) {
                        int intRandom = Util.getIntRandom(aku.getCount() - 1, 0);
                        blk = new EmojiInfo();
                        aku.moveToPosition(intRandom);
                        blk.convertFrom(aku);
                        aku.close();
                    }
                }
                if (as.bjw(str)) {
                    com.tencent.mm.plugin.emoji.model.k.cGe().b(str, blk, null);
                } else {
                    com.tencent.mm.plugin.emoji.model.k.cGd().a(str, blk, (ca) null);
                }
            }
            AppMethodBeat.o(108446);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final void a(String str, EmojiInfo emojiInfo, ca caVar) {
        AppMethodBeat.i(108447);
        if (emojiInfo == null && caVar == null) {
            AppMethodBeat.o(108447);
            return;
        }
        if (emojiInfo == null) {
            emojiInfo = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(caVar.field_imgPath);
        }
        if (as.bjw(str)) {
            com.tencent.mm.plugin.emoji.model.k.cGe().b(str, emojiInfo, caVar);
            AppMethodBeat.o(108447);
            return;
        }
        com.tencent.mm.plugin.emoji.model.k.cGd().a(str, emojiInfo, caVar);
        AppMethodBeat.o(108447);
    }

    private static void a(Context context, String str, String str2, String str3, long j2, String str4, String str5, String str6) {
        AppMethodBeat.i(108448);
        if (str.equals("-1")) {
            Log.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            AppMethodBeat.o(108448);
            return;
        }
        EmojiInfo blk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(str);
        if (blk == null) {
            Log.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            AppMethodBeat.o(108448);
            return;
        }
        Intent intent = new Intent(context, CustomSmileyPreviewUI.class);
        intent.putExtra("custom_smiley_preview_md5", str);
        if (str2 != null) {
            intent.putExtra("custom_smiley_preview_appid", str2);
        } else {
            intent.putExtra("custom_smiley_preview_appid", blk.field_app_id);
        }
        intent.putExtra("custom_smiley_preview_appname", str3);
        intent.putExtra("msg_id", j2);
        intent.putExtra("msg_content", str5);
        if (ab.Eq(str4)) {
            str4 = bp.Ks(str5);
            intent.putExtra("room_id", str6);
        }
        intent.putExtra("msg_sender", str4);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "showEmoji", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108448);
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final bi fT(String str, String str2) {
        AppMethodBeat.i(108449);
        Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
        if (parseXml == null) {
            Log.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
            AppMethodBeat.o(108449);
            return null;
        }
        bi e2 = bi.e(parseXml, str2, str);
        if (e2 == null) {
            Log.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(str)));
            AppMethodBeat.o(108449);
            return null;
        }
        AppMethodBeat.o(108449);
        return e2;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final EmojiInfo l(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(108450);
        EmojiInfo a2 = a(str, "", i2, i3, i4, "");
        AppMethodBeat.o(108450);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final EmojiInfo a(String str, String str2, int i2, int i3, int i4, String str3) {
        AppMethodBeat.i(108451);
        EmojiInfo e2 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.e(str, str2, i2, i3, i4, str3);
        AppMethodBeat.o(108451);
        return e2;
    }

    @Override // com.tencent.mm.pluginsdk.a.d, com.tencent.mm.pluginsdk.a.e
    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(108452);
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.L(emojiInfo);
        AppMethodBeat.o(108452);
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final String amn(String str) {
        AppMethodBeat.i(108453);
        String amn = EmojiLogic.amn(str);
        AppMethodBeat.o(108453);
        return amn;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final String a(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(108454);
        String b2 = EmojiLogic.b(context, wXMediaMessage, str);
        AppMethodBeat.o(108454);
        return b2;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean a(String str, String str2, long j2, String str3, h.a aVar) {
        EmojiInfo emojiInfo;
        boolean z;
        AppMethodBeat.i(108455);
        if (as.bjw(str)) {
            c cGe = com.tencent.mm.plugin.emoji.model.k.cGe();
            bi bp = bi.bp(str, str2, str3);
            if (bp == null) {
                Log.i("MicroMsg.emoji.EmojiBypService", "prepareEmoji failed. emoji msg info is null.");
            } else {
                bp.dTS = j2;
                Log.i("MicroMsg.emoji.EmojiBypService", "prepareEmoji msgSvrId[%d], stack[%s]", Long.valueOf(j2), Util.getStack());
                g.aAk().postToWorker(new Runnable(bp.productId) {
                    /* class com.tencent.mm.plugin.emoji.model.c.AnonymousClass2 */
                    final /* synthetic */ String raF;

                    {
                        this.raF = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(240140);
                        if (k.getEmojiStorageMgr().OpP.bli(this.raF)) {
                            k.cGf();
                            f.amx(this.raF);
                        }
                        AppMethodBeat.o(240140);
                    }
                });
                if (bp == null) {
                    Log.w("MicroMsg.emoji.EmojiBypService", "downloadEmoji msginfo is null.");
                } else {
                    if (!(aVar == null || aVar.heO == null || aVar.heO.Brn != bp.dTS)) {
                        bp.fqJ = bp.d(aVar);
                        bp.jvu = aVar.heO.KHs;
                        bp.createTime = (long) aVar.heO.CreateTime;
                    }
                    EmojiInfo blk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(bp.md5);
                    if (blk != null) {
                        Log.i("MicroMsg.emoji.EmojiBypService", "downloadEmoji: db emoji info not null %s msgInfomd5 %s svrId %s", blk.field_md5, bp.md5, Long.valueOf(bp.dTS));
                        b.b(bp, blk);
                        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.L(blk);
                        emojiInfo = blk;
                    } else {
                        Log.i("MicroMsg.emoji.EmojiBypService", "downloadEmoji: create emoji info %s", bp.md5);
                        Log.i("MicroMsg.emoji.EmojiBypService", "createEmojiInfo: %s", bp.md5);
                        EmojiInfo emojiInfo2 = new EmojiInfo();
                        b.b(bp, emojiInfo2);
                        emojiInfo2.field_temp = 1;
                        emojiInfo2.field_state = EmojiInfo.Vlg;
                        emojiInfo2.field_catalog = EmojiInfo.VkQ;
                        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.J(emojiInfo2);
                        emojiInfo = emojiInfo2;
                    }
                    if (bp.OpK) {
                        Log.i("MicroMsg.emoji.EmojiBypService", "insertEmojiMsg: %s, %s msgSvrId: %s", bp.md5, emojiInfo.field_md5, Long.valueOf(bp.dTS));
                        if (bp.dTS == 0 || ((l) g.af(l.class)).eiy().aJ(bp.talker, bp.dTS).field_msgSvrId != bp.dTS) {
                            as Kn = ((l) g.af(l.class)).aSN().Kn(bp.talker);
                            if (Kn == null || ((int) Kn.gMZ) == 0) {
                                as asVar = new as(bp.talker);
                                asVar.setType(2);
                                ((l) g.af(l.class)).aSN().ap(asVar);
                            }
                            ca caVar = new ca();
                            caVar.setType(47);
                            caVar.Cy(bp.talker);
                            caVar.nv(z.Im(bp.jsh) ? 1 : 0);
                            caVar.Cz(emojiInfo.getMd5());
                            caVar.yF(bp.dTS);
                            String str4 = bp.jsh;
                            if (emojiInfo.NA() || emojiInfo.isGif()) {
                                z = false;
                            } else {
                                z = true;
                            }
                            caVar.setContent(be.a(str4, 0, z, emojiInfo.getMd5(), false, bp.OpG));
                            caVar.setCreateTime(bp.C(caVar.field_talker, bp.createTime));
                            caVar.setStatus(3);
                            if (!Util.isNullOrNil(bp.fqK)) {
                                caVar.BB(bp.fqK);
                            }
                            if (aVar == null) {
                                int i2 = bp.fqJ;
                                if (i2 != 0) {
                                    caVar.setFlag(i2);
                                    if (caVar.field_msgId == 0 && caVar.field_isSend == 0 && (i2 & 2) != 0) {
                                        caVar.setCreateTime(bp.createTime);
                                    }
                                }
                                if (bp.jvu != 0) {
                                    caVar.yH((long) bp.jvu);
                                }
                                Log.i("MicroMsg.emoji.EmojiBypService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", Integer.valueOf(i2), Integer.valueOf(bp.jvu));
                            } else {
                                bp.a(caVar, aVar);
                            }
                            bp.x(caVar);
                        }
                    }
                    Log.i("MicroMsg.emoji.EmojiBypService", "start download emoji %s, fileExist %b", emojiInfo.getMd5(), Boolean.valueOf(emojiInfo.hYi()));
                    if (!emojiInfo.hYi()) {
                        Log.i("MicroMsg.emoji.EmojiBypService", "cdnurl and cncrypt url is null. ");
                        if (bp != null) {
                            ((l) g.af(l.class)).eiy().a(new i.c(bp.talker, "update", null));
                        }
                    }
                }
            }
            AppMethodBeat.o(108455);
            return true;
        }
        com.tencent.mm.plugin.emoji.model.d cGd = com.tencent.mm.plugin.emoji.model.k.cGd();
        bi bp2 = bi.bp(str, str2, str3);
        if (bp2 == null) {
            Log.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
            AppMethodBeat.o(108455);
            return true;
        }
        bp2.dTS = j2;
        Log.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", Long.valueOf(j2), Util.getStack());
        cGd.amP(bp2.productId);
        cGd.a(bp2, aVar, !EmojiLogic.amO(n.ava()));
        AppMethodBeat.o(108455);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final List<EmojiInfo> amo(String str) {
        AppMethodBeat.i(108456);
        if (g.aAh().isSDCardAvailable()) {
            ArrayList arrayList = (ArrayList) com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.amo(str);
            AppMethodBeat.o(108456);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        AppMethodBeat.o(108456);
        return arrayList2;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final String getAccPath() {
        AppMethodBeat.i(108457);
        String str = g.aAh().hqG;
        AppMethodBeat.o(108457);
        return str;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final String amp(String str) {
        AppMethodBeat.i(108458);
        String amp = com.tencent.mm.plugin.emoji.model.k.getEmojiDescMgr().amp(str);
        AppMethodBeat.o(108458);
        return amp;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean amq(String str) {
        AppMethodBeat.i(108459);
        if (str == null || !str.equals("capture")) {
            boolean blb = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.blb(str);
            AppMethodBeat.o(108459);
            return blb;
        }
        AppMethodBeat.o(108459);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final ArrayList<String> amr(String str) {
        AppMethodBeat.i(108460);
        bf emojiDescMgr = com.tencent.mm.plugin.emoji.model.k.getEmojiDescMgr();
        if (!emojiDescMgr.mInit) {
            emojiDescMgr.gCG();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList();
        if (!emojiDescMgr.mInit) {
            emojiDescMgr.gCG();
        }
        if (com.tencent.mm.ui.tools.f.bnP(str) > emojiDescMgr.Opk) {
            Log.i("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
        } else if (!Util.isNullOrNil(str) && emojiDescMgr.Opo != null) {
            String lowerCase = str.toLowerCase();
            if (emojiDescMgr.Opn.containsKey(lowerCase)) {
                ArrayList<String> arrayList4 = emojiDescMgr.Opm.get(emojiDescMgr.Opn.get(lowerCase));
                if (arrayList4 != null) {
                    arrayList3.addAll(arrayList4);
                }
            } else {
                arrayList3.add(lowerCase);
            }
        }
        for (String str2 : arrayList3) {
            ArrayList<bf.a> arrayList5 = emojiDescMgr.Opo.get(str2);
            if (arrayList5 != null && !arrayList5.isEmpty()) {
                arrayList.addAll(arrayList5);
            }
        }
        Log.i("MicroMsg.emoji.EmojiDescNewMgr", "changeText: %s, %s", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList.size()));
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, emojiDescMgr.Opp);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.add(((bf.a) arrayList.get(i2)).md5);
            }
        }
        Log.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(108460);
        return arrayList2;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final String ams(String str) {
        AppMethodBeat.i(108461);
        String ams = EmojiLogic.ams(str);
        AppMethodBeat.o(108461);
        return ams;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final String amt(String str) {
        AppMethodBeat.i(108462);
        String amt = EmojiLogic.amt(str);
        AppMethodBeat.o(108462);
        return amt;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final int amu(String str) {
        AppMethodBeat.i(108463);
        int amu = EmojiLogic.amu(str);
        AppMethodBeat.o(108463);
        return amu;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final String amv(String str) {
        AppMethodBeat.i(108464);
        String amv = EmojiLogic.amv(str);
        AppMethodBeat.o(108464);
        return amv;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final int q(EmojiInfo emojiInfo) {
        AppMethodBeat.i(108465);
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.VkU || String.valueOf(EmojiInfo.VkU).equals(emojiInfo.field_groupId)) {
                AppMethodBeat.o(108465);
                return R.drawable.jsb;
            } else if (emojiInfo.field_catalog == EmojiInfo.VkV || String.valueOf(EmojiInfo.VkV).equals(emojiInfo.field_groupId)) {
                AppMethodBeat.o(108465);
                return R.drawable.dice;
            }
        }
        AppMethodBeat.o(108465);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final int[] r(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.VkU) {
                return new int[]{R.drawable.jsb_j, R.drawable.jsb_s, R.drawable.jsb_b};
            }
            if (emojiInfo.field_catalog == EmojiInfo.VkV) {
                return new int[]{R.drawable.dice_action_0, R.drawable.dice_action_1, R.drawable.dice_action_2, R.drawable.dice_action_3};
            }
        }
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.a.d, com.tencent.mm.pluginsdk.a.e
    public final byte[] a(EmojiInfo emojiInfo) {
        EmojiInfo aml;
        AppMethodBeat.i(108466);
        if (!(emojiInfo == null || (aml = aml(emojiInfo.field_md5)) == null || aml.field_reserved4 == emojiInfo.field_reserved4)) {
            emojiInfo.field_reserved4 = aml.field_reserved4;
        }
        byte[] a2 = com.tencent.mm.emoji.decode.a.aum().a(emojiInfo);
        AppMethodBeat.o(108466);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final byte[] s(EmojiInfo emojiInfo) {
        EmojiInfo aml;
        AppMethodBeat.i(108467);
        if (!(emojiInfo == null || (aml = aml(emojiInfo.field_md5)) == null || aml.field_reserved4 == emojiInfo.field_reserved4)) {
            emojiInfo.field_reserved4 = aml.field_reserved4;
        }
        byte[] a2 = com.tencent.mm.emoji.decode.a.aum().a(emojiInfo);
        if (ImgUtil.isWXGF(a2)) {
            byte[] nativeWxamToGif = MMWXGFJNI.nativeWxamToGif(a2);
            if (Util.isNullOrNil(nativeWxamToGif)) {
                Log.w("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: wxam to gif error");
            } else {
                Log.i("MicroMsg.emoji.EmojiMgrImpl", "decodeAsGif: %s, %s", Integer.valueOf(a2.length), Integer.valueOf(nativeWxamToGif.length));
            }
            AppMethodBeat.o(108467);
            return nativeWxamToGif;
        }
        AppMethodBeat.o(108467);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean a(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(108468);
        boolean a2 = com.tencent.mm.emoji.decode.a.aum().a(emojiInfo, z);
        AppMethodBeat.o(108468);
        return a2;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean cFH() {
        AppMethodBeat.i(108469);
        boolean auX = n.auX();
        AppMethodBeat.o(108469);
        return auX;
    }

    public static String cFI() {
        AppMethodBeat.i(240123);
        String str = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0";
        AppMethodBeat.o(240123);
        return str;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final ArrayList<SmileyInfo> cFJ() {
        AppMethodBeat.i(108470);
        ArrayList<SmileyInfo> cFJ = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpV.cFJ();
        AppMethodBeat.o(108470);
        return cFJ;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final ArrayList<SmileyPanelConfigInfo> cFK() {
        AppMethodBeat.i(108471);
        ArrayList<SmileyPanelConfigInfo> cFK = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpW.cFK();
        AppMethodBeat.o(108471);
        return cFK;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean V(ArrayList<SmileyInfo> arrayList) {
        AppMethodBeat.i(108472);
        boolean bn = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpV.bn(arrayList);
        AppMethodBeat.o(108472);
        return bn;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean W(ArrayList<SmileyPanelConfigInfo> arrayList) {
        long j2;
        com.tencent.mm.storagebase.h hVar;
        AppMethodBeat.i(108473);
        com.tencent.mm.storage.emotion.u uVar = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpW;
        if (arrayList == null || arrayList.size() <= 0) {
            Log.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
        } else {
            Log.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList: %s", Integer.valueOf(arrayList.size()));
            if (uVar.db instanceof com.tencent.mm.storagebase.h) {
                com.tencent.mm.storagebase.h hVar2 = (com.tencent.mm.storagebase.h) uVar.db;
                j2 = hVar2.beginTransaction(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                j2 = -1;
                hVar = null;
            }
            uVar.db.delete("SmileyPanelConfigInfo", null, null);
            Iterator<SmileyPanelConfigInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                uVar.insert(it.next());
            }
            int i2 = -1;
            if (hVar != null) {
                i2 = hVar.endTransaction(j2);
            }
            if (i2 >= 0) {
                AppMethodBeat.o(108473);
                return true;
            }
        }
        AppMethodBeat.o(108473);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final com.tencent.mm.bb.g cFL() {
        AppMethodBeat.i(108475);
        com.tencent.mm.bb.g cFL = h.cFT().cFL();
        AppMethodBeat.o(108475);
        return cFL;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final String getDataEmojiPath() {
        AppMethodBeat.i(240124);
        String dataEmojiPath = h.getDataEmojiPath();
        AppMethodBeat.o(240124);
        return dataEmojiPath;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final String cFN() {
        AppMethodBeat.i(108478);
        h.cFT();
        String cFN = h.cFN();
        AppMethodBeat.o(108478);
        return cFN;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void cFO() {
        AppMethodBeat.i(108479);
        h cFT = h.cFT();
        com.tencent.mm.g.a.bp bpVar = new com.tencent.mm.g.a.bp();
        bp.a aVar = bpVar.dEN;
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        aVar.filePath = com.tencent.mm.pluginsdk.j.a.a.b.kC(37, 1);
        bpVar.dEN.dEO = 37;
        bpVar.dEN.subType = 1;
        bpVar.dEN.dEP = -1;
        cFT.b(bpVar);
        AppMethodBeat.o(108479);
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final int d(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(108480);
        if (z || !(emojiInfo == null || emojiInfo.field_activityid == null || !emojiInfo.field_activityid.startsWith("Selfie:"))) {
            int aqp = com.tencent.mm.n.c.aqp();
            AppMethodBeat.o(108480);
            return aqp;
        }
        int aqn = com.tencent.mm.n.c.aqn();
        AppMethodBeat.o(108480);
        return aqn;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void h(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(108487);
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.remove(iOnStorageChange);
        AppMethodBeat.o(108487);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void i(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(108488);
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.add(iOnStorageChange);
        AppMethodBeat.o(108488);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void j(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(108489);
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.remove(iOnStorageChange);
        AppMethodBeat.o(108489);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void k(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(108490);
        if (g.aAe().azG().aBb()) {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpO.add(iOnStorageChange);
        }
        AppMethodBeat.o(108490);
    }

    public static void amx(String str) {
        AppMethodBeat.i(240125);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.emoji.EmojiMgrImpl", "doSceneGetEmotionDesc get emotion desc faild.");
            AppMethodBeat.o(240125);
            return;
        }
        g.aAg().hqi.a(new com.tencent.mm.plugin.emoji.f.l(str), 0);
        AppMethodBeat.o(240125);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean cFP() {
        AppMethodBeat.i(108491);
        boolean avd = n.avd();
        AppMethodBeat.o(108491);
        return avd;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean ave() {
        AppMethodBeat.i(108492);
        boolean ave = n.ave();
        AppMethodBeat.o(108492);
        return ave;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean avf() {
        AppMethodBeat.i(108493);
        if (WeChatEnvironment.hasDebugger() || n.avf()) {
            AppMethodBeat.o(108493);
            return true;
        }
        AppMethodBeat.o(108493);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void amy(String str) {
        v vVar;
        AppMethodBeat.i(176179);
        w wVar = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpY;
        if (!Util.isNullOrNil(str)) {
            synchronized (wVar.zns) {
                int i2 = 0;
                while (true) {
                    try {
                        if (i2 >= wVar.zns.size()) {
                            i2 = -1;
                            vVar = null;
                            break;
                        } else if (Util.isEqual(wVar.zns.get(i2).key, str)) {
                            vVar = wVar.zns.get(i2);
                            break;
                        } else {
                            i2++;
                        }
                    } finally {
                        AppMethodBeat.o(176179);
                    }
                }
                if (vVar == null) {
                    vVar = new v();
                    vVar.key = str;
                } else {
                    wVar.zns.remove(i2);
                }
                vVar.OsQ++;
                vVar.hwQ = System.currentTimeMillis();
                wVar.zns.add(0, vVar);
                if (wVar.zns.size() > 9) {
                    wVar.zns.remove(wVar.zns.size() - 1);
                }
            }
            wVar.doNotify("event_update_recent", 0, Integer.valueOf(wVar.zns.size()));
        }
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final List<v> cFQ() {
        AppMethodBeat.i(108495);
        List<v> cFQ = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpY.cFQ();
        AppMethodBeat.o(108495);
        return cFQ;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void cFR() {
        AppMethodBeat.i(108496);
        List<v> cFQ = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpY.cFQ();
        JSONArray jSONArray = new JSONArray();
        for (v vVar : cFQ) {
            if (vVar.toJson() != null) {
                jSONArray.put(vVar.toJson());
                if (jSONArray.length() >= 9) {
                    break;
                }
            }
        }
        g.aAh().azQ().set(ar.a.USERINFO_RECENT_SMILEY_STRING, jSONArray.toString());
        AppMethodBeat.o(108496);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final <T> T c(ar.a aVar, T t) {
        AppMethodBeat.i(108497);
        T t2 = (T) g.aAh().azQ().get(aVar, t);
        AppMethodBeat.o(108497);
        return t2;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void d(ar.a aVar, Object obj) {
        AppMethodBeat.i(108498);
        g.aAh().azQ().set(aVar, obj);
        AppMethodBeat.o(108498);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        if (r3 <= com.tencent.mm.n.c.aqp()) goto L_0x001a;
     */
    @Override // com.tencent.mm.pluginsdk.a.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean amz(java.lang.String r8) {
        /*
            r7 = this;
            r6 = 108499(0x1a7d3, float:1.5204E-40)
            r1 = 1
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.mm.plugin.gif.f r2 = new com.tencent.mm.plugin.gif.f
            r2.<init>(r8)
            long r4 = com.tencent.mm.vfs.s.boW(r8)
            int r3 = (int) r4
            if (r3 == 0) goto L_0x001a
            int r4 = com.tencent.mm.n.c.aqp()     // Catch:{ Exception -> 0x0034 }
            if (r3 > r4) goto L_0x0030
        L_0x001a:
            int[] r3 = r2.ydT     // Catch:{ Exception -> 0x0034 }
            r4 = 0
            r3 = r3[r4]     // Catch:{ Exception -> 0x0034 }
            int r4 = com.tencent.mm.n.c.aqo()     // Catch:{ Exception -> 0x0034 }
            if (r3 > r4) goto L_0x0030
            int[] r2 = r2.ydT     // Catch:{ Exception -> 0x0034 }
            r3 = 1
            r2 = r2[r3]     // Catch:{ Exception -> 0x0034 }
            int r3 = com.tencent.mm.n.c.aqo()     // Catch:{ Exception -> 0x0034 }
            if (r2 <= r3) goto L_0x0040
        L_0x0030:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return r0
        L_0x0034:
            r1 = move-exception
            java.lang.String r2 = "MicroMsg.emoji.EmojiMgrImpl"
            java.lang.String r1 = com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r1)
            com.tencent.mm.sdk.platformtools.Log.e(r2, r1)
            goto L_0x0030
        L_0x0040:
            r0 = r1
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.e.f.amz(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        if (r3 <= com.tencent.mm.n.c.aqm()) goto L_0x001a;
     */
    @Override // com.tencent.mm.pluginsdk.a.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean amA(java.lang.String r8) {
        /*
            r7 = this;
            r6 = 240126(0x3a9fe, float:3.36488E-40)
            r1 = 1
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.mm.plugin.gif.f r2 = new com.tencent.mm.plugin.gif.f
            r2.<init>(r8)
            long r4 = com.tencent.mm.vfs.s.boW(r8)
            int r3 = (int) r4
            if (r3 == 0) goto L_0x001a
            int r4 = com.tencent.mm.n.c.aqm()     // Catch:{ Exception -> 0x0034 }
            if (r3 > r4) goto L_0x0030
        L_0x001a:
            int[] r3 = r2.ydT     // Catch:{ Exception -> 0x0034 }
            r4 = 0
            r3 = r3[r4]     // Catch:{ Exception -> 0x0034 }
            int r4 = com.tencent.mm.n.c.aqo()     // Catch:{ Exception -> 0x0034 }
            if (r3 > r4) goto L_0x0030
            int[] r2 = r2.ydT     // Catch:{ Exception -> 0x0034 }
            r3 = 1
            r2 = r2[r3]     // Catch:{ Exception -> 0x0034 }
            int r3 = com.tencent.mm.n.c.aqo()     // Catch:{ Exception -> 0x0034 }
            if (r2 <= r3) goto L_0x0040
        L_0x0030:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return r0
        L_0x0034:
            r1 = move-exception
            java.lang.String r2 = "MicroMsg.emoji.EmojiMgrImpl"
            java.lang.String r1 = com.tencent.mm.sdk.platformtools.Util.stackTraceToString(r1)
            com.tencent.mm.sdk.platformtools.Log.e(r2, r1)
            goto L_0x0030
        L_0x0040:
            r0 = r1
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.e.f.amA(java.lang.String):boolean");
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final boolean cFS() {
        boolean z;
        AppMethodBeat.i(108500);
        if (!g.aAh().azQ().getBoolean(ar.a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, true)) {
            z = true;
        } else {
            z = false;
        }
        n.isSpringFestivalEnable();
        if (z) {
            AppMethodBeat.o(108500);
            return true;
        }
        AppMethodBeat.o(108500);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void amB(String str) {
        AppMethodBeat.i(108501);
        if (!Util.isNullOrNil(str)) {
            Log.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(str)));
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.dj(str, true);
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.doNotify("delete_emoji_info_notify");
        }
        AppMethodBeat.o(108501);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void t(EmojiInfo emojiInfo) {
        AppMethodBeat.i(108502);
        emojiInfo.field_groupId = "capture";
        ArrayList arrayList = new ArrayList();
        arrayList.add(emojiInfo.getMd5());
        ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.x(1, arrayList);
        ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(emojiInfo);
        Cdo doVar = new Cdo();
        doVar.dGz.type = 2;
        EventCenter.instance.publish(doVar);
        if (!doVar.dGA.dGB) {
            dyv gFr = ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpQ.gFr();
            if (gFr != null) {
                Iterator<dyw> it = gFr.MYx.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    dyw next = it.next();
                    if (next.ProductID.equals(String.valueOf("capture"))) {
                        next.xuA = 0;
                        break;
                    }
                }
            }
            ((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpQ.a(gFr);
            com.tencent.mm.ca.a.gvc();
            a.b bVar = com.tencent.mm.ca.a.NCN;
            a.b.bhD(String.valueOf("capture"));
        }
        AppMethodBeat.o(108502);
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final EmojiInfo p(EmojiInfo emojiInfo) {
        AppMethodBeat.i(108442);
        if (emojiInfo.field_catalog == EmojiGroupInfo.VkO && emojiInfo.getContent().length() > 0 && EmojiInfo.axs(Util.getInt(emojiInfo.getContent(), 0))) {
            Cursor aku = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.aku(Util.getInt(emojiInfo.getContent(), 0));
            if (aku != null && aku.getCount() > 1) {
                int intRandom = Util.getIntRandom(aku.getCount() - 1, 0);
                emojiInfo = new EmojiInfo();
                aku.moveToPosition(intRandom);
                emojiInfo.convertFrom(aku);
            }
            if (aku != null) {
                aku.close();
            }
        }
        AppMethodBeat.o(108442);
        return emojiInfo;
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean a(Context context, EmojiInfo emojiInfo, int i2, String str) {
        AppMethodBeat.i(108443);
        if (context == null) {
            Log.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
            AppMethodBeat.o(108443);
            return false;
        } else if (emojiInfo == null) {
            Log.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
            AppMethodBeat.o(108443);
            return false;
        } else {
            Intent intent = new Intent();
            intent.setClass(context, EmojiAddCustomDialogUI.class);
            intent.putExtra("extra_id", emojiInfo.getMd5());
            intent.putExtra("extra_scence", i2);
            intent.putExtra("extra_move_to_top", true);
            intent.putExtra("extra_username", str);
            intent.putExtra("extra_current", false);
            intent.putExtra("key_is_selfie", false);
            intent.putExtra("key_attached_text", (String) null);
            intent.putExtra("key_attached_emoji_md5", (Serializable) null);
            intent.putExtra("key_imitate_md5", (String) null);
            intent.addFlags(65536);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/emoji/mgr/EmojiMgrImpl", "saveCustomEmoji", "(Landroid/content/Context;Lcom/tencent/mm/storage/emotion/EmojiInfo;ILjava/lang/String;IZZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(108443);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final String fU(String str, String str2) {
        AppMethodBeat.i(108474);
        com.tencent.mm.emoji.e.a aVar = com.tencent.mm.emoji.e.a.hdT;
        String W = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), str, str2);
        AppMethodBeat.o(108474);
        return W;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0233  */
    @Override // com.tencent.mm.pluginsdk.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void amw(java.lang.String r18) {
        /*
        // Method dump skipped, instructions count: 2196
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.e.f.amw(java.lang.String):void");
    }

    @Override // com.tencent.mm.pluginsdk.a.d
    public final boolean cFM() {
        AppMethodBeat.i(108477);
        if (WeChatEnvironment.hasDebugger() || n.avg()) {
            AppMethodBeat.o(108477);
            return true;
        }
        AppMethodBeat.o(108477);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.a.e
    public final void amC(String str) {
        AppMethodBeat.i(108503);
        EmojiInfo aml = aml(str);
        if (aml != null) {
            com.tencent.mm.emoji.d.i iVar = com.tencent.mm.emoji.d.i.hdO;
            com.tencent.mm.emoji.d.i.o(aml);
            AppMethodBeat.o(108503);
            return;
        }
        Log.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", str);
        AppMethodBeat.o(108503);
    }
}
