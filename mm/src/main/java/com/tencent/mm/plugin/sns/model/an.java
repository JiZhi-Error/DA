package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public final class an {
    public static long DIf = 0;
    public static long DIg = 0;
    public static final Map<Long, SnsInfo> DMg = new TreeMap(new Comparator<Long>() {
        /* class com.tencent.mm.plugin.sns.model.an.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Long l, Long l2) {
            AppMethodBeat.i(95856);
            int compareTo = l2.compareTo(l);
            AppMethodBeat.o(95856);
            return compareTo;
        }
    });
    public static long DMh = 0;
    public static int DMi = 0;
    private static long DMj = -1;
    private static Map<String, SnsObject> DMk = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(95886);
        AppMethodBeat.o(95886);
    }

    public static List<SnsInfo> a(String str, boolean z, String str2, boolean z2) {
        Cursor g2;
        AppMethodBeat.i(95857);
        if (z2) {
            g2 = aj.faO().a(false, str, 10, z, str2);
        } else {
            g2 = aj.faO().g(str, z, str2);
        }
        ArrayList arrayList = new ArrayList();
        if (g2.getCount() == 0) {
            g2.close();
            AppMethodBeat.o(95857);
            return arrayList;
        }
        if (g2.moveToFirst()) {
            do {
                SnsInfo snsInfo = new SnsInfo();
                snsInfo.convertFrom(g2);
                arrayList.add(snsInfo);
            } while (g2.moveToNext());
        }
        g2.close();
        AppMethodBeat.o(95857);
        return arrayList;
    }

    public static List<SnsInfo> E(boolean z, String str) {
        String str2;
        AppMethodBeat.i(160673);
        n faO = aj.faO();
        String feX = n.feX();
        if (n.aQw(str)) {
            feX = feX + " AND " + faO.aQx(str);
        }
        if (z) {
            str2 = feX + n.Emx;
        } else {
            str2 = feX + n.Emy;
        }
        Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(str2)));
        Cursor rawQuery = faO.iFy.rawQuery(str2, null);
        ArrayList arrayList = new ArrayList();
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(160673);
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    SnsInfo snsInfo = new SnsInfo();
                    snsInfo.convertFrom(rawQuery);
                    arrayList.add(snsInfo);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(160673);
        }
        return arrayList;
    }

    public static SnsInfo aPk(String str) {
        AppMethodBeat.i(95859);
        Cursor a2 = aj.faO().a(true, str, 1, false, "");
        if (a2.getCount() == 0) {
            a2.close();
            AppMethodBeat.o(95859);
            return null;
        }
        a2.moveToFirst();
        SnsInfo snsInfo = new SnsInfo();
        snsInfo.convertFrom(a2);
        if (!a2.isClosed()) {
            a2.close();
        }
        AppMethodBeat.o(95859);
        return snsInfo;
    }

    public static void fbo() {
        AppMethodBeat.i(95860);
        if (DMk != null) {
            DMk.clear();
        }
        AppMethodBeat.o(95860);
    }

    public static SnsObject B(SnsInfo snsInfo) {
        AppMethodBeat.i(95861);
        try {
            SnsObject d2 = aj.faN().d((SnsObject) new SnsObject().parseFrom(snsInfo.field_attrBuf));
            DMk.clear();
            AppMethodBeat.o(95861);
            return d2;
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
            SnsObject snsObject = new SnsObject();
            AppMethodBeat.o(95861);
            return snsObject;
        }
    }

    public static SnsObject C(SnsInfo snsInfo) {
        SnsObject snsObject;
        AppMethodBeat.i(95862);
        try {
            if (snsInfo.contentByteMd5 == null) {
                snsInfo.contentByteMd5 = g.getMessageDigest(snsInfo.field_content) + g.getMessageDigest(snsInfo.field_attrBuf);
            }
            if (!DMk.containsKey(snsInfo.contentByteMd5) || (snsObject = DMk.get(snsInfo.contentByteMd5)) == null) {
                SnsObject snsObject2 = (SnsObject) new SnsObject().parseFrom(snsInfo.field_attrBuf);
                DMk.put(snsInfo.contentByteMd5, snsObject2);
                aj.faN().d(snsObject2);
                AppMethodBeat.o(95862);
                return snsObject2;
            }
            aj.faN().d(snsObject);
            AppMethodBeat.o(95862);
            return snsObject;
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
            SnsObject snsObject3 = new SnsObject();
            AppMethodBeat.o(95862);
            return snsObject3;
        }
    }

    public static void b(long j2, dzj dzj) {
        AppMethodBeat.i(95863);
        dzi dzi = dzj.MZb;
        if (dzi.oUv != 9) {
            AppMethodBeat.o(95863);
            return;
        }
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ == null) {
            AppMethodBeat.o(95863);
            return;
        }
        try {
            SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(JJ.field_attrBuf);
            snsObject.Id = j2;
            Iterator<dzo> it = snsObject.CommentUserList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                dzo next = it.next();
                if (next.MYT == dzi.MYT && !Util.isNullOrNil(next.Username) && next.Username.equals(dzi.MKC)) {
                    snsObject.CommentUserList.remove(next);
                    break;
                }
            }
            JJ.setAttrBuf(snsObject.toByteArray());
            aj.faO().a(snsObject.Id, JJ);
            AppMethodBeat.o(95863);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
            AppMethodBeat.o(95863);
        }
    }

    public static void c(long j2, dzj dzj) {
        AppMethodBeat.i(202775);
        Log.i("MicroMsg.SnsInfoStorageLogic", "deleteComment");
        dzi dzi = dzj.MZb;
        if (dzi.oUv != 9) {
            AppMethodBeat.o(202775);
            return;
        }
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ == null) {
            AppMethodBeat.o(202775);
            return;
        }
        try {
            SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(JJ.field_attrBuf);
            snsObject.Id = j2;
            Iterator<dzo> it = snsObject.CommentUserList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                dzo next = it.next();
                if (next.MYT == dzi.MYT && !Util.isNullOrNil(next.Username)) {
                    if (next.Username.equals(dzi.MKC) || !next.Username.equals(z.aTY())) {
                        Log.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, removeComment:%s", next.Username, dzi.MKC, Integer.valueOf(next.MYT));
                        snsObject.CommentUserList.remove(next);
                    } else if (next.Username.equals(z.aTY())) {
                        Log.i("MicroMsg.SnsInfoStorageLogic", "commentUsername:%s, actionUsername:%s, markDeleteFlag:%s", next.Username, dzi.MKC, Integer.valueOf(next.MYT));
                        next.DeleteFlag = 1;
                    }
                }
            }
            JJ.setAttrBuf(snsObject.toByteArray());
            aj.faO().a(snsObject.Id, JJ);
            AppMethodBeat.o(202775);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
            AppMethodBeat.o(202775);
        }
    }

    public static void d(long j2, dzj dzj) {
        AppMethodBeat.i(95864);
        dzi dzi = dzj.MZb;
        if (dzi.oUv != 13) {
            AppMethodBeat.o(95864);
            return;
        }
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ == null) {
            AppMethodBeat.o(95864);
            return;
        }
        try {
            SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(JJ.field_attrBuf);
            snsObject.Id = j2;
            if (snsObject.SnsRedEnvelops == null) {
                snsObject.SnsRedEnvelops = new ear();
            }
            if (dzi.oUv == 13) {
                Iterator<dzx> it = snsObject.SnsRedEnvelops.Naf.iterator();
                while (it.hasNext()) {
                    if (it.next().Username.equals(dzi.MKC)) {
                        AppMethodBeat.o(95864);
                        return;
                    }
                }
                dzx dzx = new dzx();
                dzx.MYW = dzi.MYW;
                dzx.CreateTime = dzi.CreateTime;
                dzx.Username = dzi.MKC;
                snsObject.SnsRedEnvelops.Naf.add(dzx);
                snsObject.SnsRedEnvelops.Nae = snsObject.SnsRedEnvelops.Naf.size();
            }
            JJ.setAttrBuf(snsObject.toByteArray());
            aj.faO().a(snsObject.Id, JJ);
            AppMethodBeat.o(95864);
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
            AppMethodBeat.o(95864);
        }
    }

    public static boolean a(long j2, dzj dzj) {
        AppMethodBeat.i(95865);
        dzi dzi = dzj.MZb;
        if (dzi.oUv == 1 || dzi.oUv == 2) {
            SnsInfo JJ = aj.faO().JJ(j2);
            if (JJ == null) {
                AppMethodBeat.o(95865);
                return true;
            } else if (JJ.getTypeFlag() != 21 || com.tencent.mm.plugin.sns.lucky.a.g.eZL()) {
                try {
                    SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(JJ.field_attrBuf);
                    snsObject.Id = j2;
                    if (dzi.oUv == 1) {
                        Iterator<dzo> it = snsObject.LikeUserList.iterator();
                        while (it.hasNext()) {
                            dzo next = it.next();
                            if (next.CreateTime == dzi.CreateTime && next.Username.equals(dzi.MKC)) {
                                AppMethodBeat.o(95865);
                                return true;
                            }
                        }
                        snsObject.LikeUserList.add(ag.b(dzj));
                    } else if (dzi.oUv == 2) {
                        Iterator<dzo> it2 = snsObject.CommentUserList.iterator();
                        while (it2.hasNext()) {
                            dzo next2 = it2.next();
                            if (next2.CreateTime == dzi.CreateTime && next2.Username.equals(dzi.MKC)) {
                                AppMethodBeat.o(95865);
                                return true;
                            }
                        }
                        snsObject.CommentUserList.add(ag.b(dzj));
                    }
                    JJ.setAttrBuf(snsObject.toByteArray());
                    aj.faO().a(snsObject.Id, JJ);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
                }
                AppMethodBeat.o(95865);
                return true;
            } else {
                Log.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
                AppMethodBeat.o(95865);
                return false;
            }
        } else {
            AppMethodBeat.o(95865);
            return true;
        }
    }

    public static long e(SnsObject snsObject) {
        AppMethodBeat.i(95866);
        SnsInfo JJ = aj.faO().JJ(snsObject.Id);
        if (JJ == null) {
            JJ = new SnsInfo();
        }
        long a2 = a(JJ, snsObject, "", 0);
        AppMethodBeat.o(95866);
        return a2;
    }

    private static long a(SnsInfo snsInfo, SnsObject snsObject, String str, int i2) {
        boolean z;
        boolean z2;
        SnsObject snsObject2;
        boolean z3 = true;
        boolean z4 = false;
        AppMethodBeat.i(95867);
        if (snsInfo == null) {
            snsInfo = new SnsInfo();
        }
        if (!aj.faN().Jq(snsInfo.field_snsId)) {
            long j2 = snsObject.Id;
            AppMethodBeat.o(95867);
            return j2;
        } else if (snsObject.NoChange != 0) {
            Log.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + snsObject.Id + "  " + r.Jb(snsObject.Id));
            if (!snsInfo.isSourceExist(i2)) {
                snsInfo.addSourceFlag(i2);
            } else {
                z3 = false;
            }
            if (z3) {
                aj.faO().a(snsObject.Id, snsInfo);
            }
            long j3 = snsObject.Id;
            AppMethodBeat.o(95867);
            return j3;
        } else {
            Log.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", Long.valueOf(snsObject.Id), Integer.valueOf(snsObject.CommentUserList.size()), r.Jb(snsObject.Id));
            if (snsObject.ObjectDesc == null || snsObject.ObjectDesc.getBuffer() == null) {
                Log.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
                long j4 = snsObject.Id;
                AppMethodBeat.o(95867);
                return j4;
            }
            String str2 = new String(snsObject.ObjectDesc.getBuffer().toByteArray());
            Log.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", Long.valueOf(snsObject.Id));
            if (Util.isNullOrNil(str2)) {
                long j5 = snsObject.Id;
                AppMethodBeat.o(95867);
                return j5;
            } else if (!snsInfo.setContent(str2)) {
                long j6 = snsObject.Id;
                AppMethodBeat.o(95867);
                return j6;
            } else {
                snsObject.ObjectOperations = b(snsObject.ObjectOperations, snsInfo.field_attrBuf);
                Log.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", Long.valueOf(snsObject.Id));
                snsObject.ObjectDesc.setBuffer(new byte[0]);
                snsInfo.setUserName(snsObject.Username);
                snsInfo.setCreateTime(snsObject.CreateTime);
                snsInfo.setLikeFlag(snsObject.LikeFlag);
                snsInfo.setSnsId(snsObject.Id);
                snsInfo.setStringSeq(snsObject.Id);
                snsInfo.addSourceFlag(i2);
                try {
                    if (!snsInfo.isAd()) {
                        c(snsInfo, snsObject);
                    }
                    long currentTicks = Util.currentTicks();
                    try {
                        if (snsInfo.getTypeFlag() == 15 && (snsObject2 = (SnsObject) new SnsObject().parseFrom(snsInfo.field_attrBuf)) != null && snsObject2.PreDownloadInfo != null && snsObject2.PreDownloadInfo.MIW > 0) {
                            snsObject.PreDownloadInfo = snsObject2.PreDownloadInfo;
                            Log.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", Integer.valueOf(snsObject.PreDownloadInfo.MIW), Integer.valueOf(snsObject.PreDownloadInfo.MIX), snsObject.PreDownloadInfo.MIY, Long.valueOf(Util.ticksToNow(currentTicks)));
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", e2.toString());
                    }
                    snsInfo.setAttrBuf(snsObject.toByteArray());
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e3, "", new Object[0]);
                }
                TimeLineObject timeLine = snsInfo.getTimeLine();
                timeLine.UserName = snsObject.Username;
                int i3 = timeLine.Privated;
                snsInfo.setPravited(i3);
                Log.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", Long.valueOf(snsObject.Id), Integer.valueOf(snsObject.ExtFlag));
                if ((snsObject.ExtFlag & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    snsInfo.setExtFlag();
                } else {
                    snsInfo.unSetExtFlag();
                }
                if (YA(snsObject.ExtFlag)) {
                    snsInfo.addSourceFlag(128);
                    u JN = aj.faX().JN(snsObject.Id);
                    if (JN != null && !Util.isNullOrNil(JN.field_groupStrcut)) {
                        ebn ebn = new ebn();
                        try {
                            ebn.parseFrom(JN.field_groupStrcut);
                            if (!Util.isNullOrNil(ebn.Nbk)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z4 = z2;
                        } catch (Exception e4) {
                            Log.w("MicroMsg.SnsInfoStorageLogic", "parse SnsWsGroupStruct fail:%s", e4.getMessage());
                        }
                    }
                    if (JN == null || !z4) {
                        snsInfo.cleanWsFoldFlag();
                    } else {
                        snsInfo.setWsFoldFlag();
                    }
                } else {
                    snsInfo.cleanWsFoldFlag();
                }
                if (i3 != 1 || i2 == 4 || i2 == 16) {
                    if (i3 == 1 || (!str.equals(snsObject.Username) && i2 == 4)) {
                        snsInfo.setLocalPrivate();
                    }
                    snsInfo.setTimeLine(timeLine);
                    snsInfo.setTypeFlag(timeLine.ContentObj.LoU);
                    snsInfo.setSubTypeFlag(timeLine.ContentObj.LoW);
                    aj.faO().a(snsObject.Id, snsInfo);
                    Iterator<dzo> it = snsObject.CommentUserList.iterator();
                    while (it.hasNext()) {
                        Iterator<dzu> it2 = it.next().MYY.iterator();
                        while (it2.hasNext()) {
                            EmojiInfo a2 = a(it2.next());
                            if (bj.gCJ().OpN.blk(a2.field_md5) == null) {
                                bj.gCJ().OpN.K(a2);
                                e eVar = e.gVM;
                                e.a(a2, (i.a) null);
                            }
                        }
                    }
                    long j7 = snsObject.Id;
                    AppMethodBeat.o(95867);
                    return j7;
                }
                Log.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
                AppMethodBeat.o(95867);
                return 0;
            }
        }
    }

    public static EmojiInfo a(dzu dzu) {
        AppMethodBeat.i(95868);
        EmojiInfo emojiInfo = new EmojiInfo();
        if (dzu == null) {
            AppMethodBeat.o(95868);
        } else if (dzu.MZq == null) {
            emojiInfo.field_md5 = dzu.Md5;
            AppMethodBeat.o(95868);
        } else {
            try {
                ait ait = new ait();
                ait.parseFrom(dzu.MZq.getBufferToBytes());
                b.a(ait, emojiInfo);
                emojiInfo.field_temp = 1;
                emojiInfo.field_catalog = EmojiInfo.VkQ;
            } catch (Exception e2) {
            }
            AppMethodBeat.o(95868);
        }
        return emojiInfo;
    }

    public static SKBuiltinBuffer_t b(SKBuiltinBuffer_t sKBuiltinBuffer_t, byte[] bArr) {
        SKBuiltinBuffer_t sKBuiltinBuffer_t2;
        AppMethodBeat.i(95869);
        if (bArr != null) {
            try {
                sKBuiltinBuffer_t2 = ((SnsObject) new SnsObject().parseFrom(bArr)).ObjectOperations;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
                AppMethodBeat.o(95869);
                return null;
            }
        } else {
            sKBuiltinBuffer_t2 = null;
        }
        if (sKBuiltinBuffer_t == null) {
            AppMethodBeat.o(95869);
            return sKBuiltinBuffer_t2;
        }
        eaj eaj = new eaj();
        if (sKBuiltinBuffer_t2 != null) {
            eaj = (eaj) eaj.parseFrom(sKBuiltinBuffer_t2.getBufferToBytes());
        }
        eaj eaj2 = (eaj) new eaj().parseFrom(sKBuiltinBuffer_t.getBufferToBytes());
        if (eaj2.MZL == null) {
            eaj2.MZL = eaj.MZL;
        }
        if (eaj.MZK == null) {
            eaj2.MZK = null;
        } else if (eaj2.MZK == null) {
            eaj2.MZK = eaj.MZK;
        }
        SKBuiltinBuffer_t buffer = new SKBuiltinBuffer_t().setBuffer(eaj2.toByteArray());
        AppMethodBeat.o(95869);
        return buffer;
    }

    private static void c(SnsInfo snsInfo, SnsObject snsObject) {
        AppMethodBeat.i(202776);
        if (snsInfo != null) {
            try {
                if (snsInfo.field_attrBuf != null) {
                    if (DMj == -1) {
                        DMj = (long) ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_delete_others_comment_clean_interval, LocalCache.TIME_DAY);
                    }
                    String aTY = z.aTY();
                    long aWB = (long) cl.aWB();
                    SnsObject snsObject2 = (SnsObject) new SnsObject().parseFrom(snsInfo.field_attrBuf);
                    if (!(snsObject2 == null || Util.isNullOrNil(snsObject2.CommentUserList) || snsObject == null)) {
                        ArrayList arrayList = new ArrayList();
                        if (snsObject.CommentUserList == null) {
                            snsObject.CommentUserList = new LinkedList<>();
                        }
                        Iterator<dzo> it = snsObject.CommentUserList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Integer.valueOf(it.next().MYT));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<dzo> it2 = snsObject2.CommentUserList.iterator();
                        while (it2.hasNext()) {
                            dzo next = it2.next();
                            if (Util.isEqual(next.Username, aTY) && next.DeleteFlag > 0) {
                                if (aWB - ((long) next.CreateTime) > DMj) {
                                    Log.i("MicroMsg.SnsInfoStorageLogic", "it's time to delete local comment deleted tip:[%s,%s]", Integer.valueOf(next.MYT), next.Username);
                                } else if (!arrayList.contains(Integer.valueOf(next.MYT))) {
                                    Log.i("MicroMsg.SnsInfoStorageLogic", "insert a local fake comment deleted tip:[%s,%s]", Integer.valueOf(next.MYT), next.Username);
                                    arrayList2.add(next);
                                }
                            }
                        }
                        if (!Util.isNullOrNil(arrayList2)) {
                            snsObject.CommentUserList.addAll(arrayList2);
                        }
                        Collections.sort(snsObject.CommentUserList, new Comparator<dzo>() {
                            /* class com.tencent.mm.plugin.sns.model.an.AnonymousClass2 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            @Override // java.util.Comparator
                            public final /* bridge */ /* synthetic */ int compare(dzo dzo, dzo dzo2) {
                                AppMethodBeat.i(202774);
                                int compare = Long.compare((long) dzo.CreateTime, (long) dzo2.CreateTime);
                                AppMethodBeat.o(202774);
                                return compare;
                            }
                        });
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
                AppMethodBeat.o(202776);
                return;
            }
        }
        AppMethodBeat.o(202776);
    }

    private static String gP(List<String> list) {
        AppMethodBeat.i(95870);
        String str = "";
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            str = it.next();
            if (str.length() != 0) {
                str = str + "," + str;
            }
        }
        AppMethodBeat.o(95870);
        return str;
    }

    public static void a(String str, int i2, LinkedList<SnsObject> linkedList, String str2) {
        boolean z;
        Cursor rawQuery;
        String str3;
        boolean z2;
        AppMethodBeat.i(95871);
        if (linkedList == null || linkedList.isEmpty()) {
            AppMethodBeat.o(95871);
            return;
        }
        n faO = aj.faO();
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList2 = new LinkedList();
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            SnsObject snsObject = linkedList.get(i3);
            if (snsObject == null) {
                z2 = false;
            } else if (Util.isNullOrNil(snsObject.Username)) {
                Log.e("MicroMsg.SnsInfoStorageLogic", "snsObject username invalid");
                z2 = false;
            } else if (snsObject.CreateTime <= 0) {
                Log.e("MicroMsg.SnsInfoStorageLogic", "sns CreateTime error:%s", Integer.valueOf(snsObject.CreateTime));
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                SnsInfo JJ = faO.JJ(snsObject.Id);
                if (JJ == null) {
                    JJ = new SnsInfo();
                }
                if (a(JJ, snsObject, str, i2) != 0) {
                    if (linkedList2.size() < 3 && (JJ.getTypeFlag() == 1 || JJ.getTypeFlag() == 15)) {
                        linkedList2.add(r.Jb(JJ.field_snsId));
                    }
                    arrayList.add(Long.valueOf(snsObject.Id));
                }
            }
        }
        if ((i2 == 4 || i2 == 8) && str2.equals("")) {
            l aQr = aj.faS().aQr(str);
            if (aQr != null) {
                str3 = aQr.field_newerIds;
            } else {
                str3 = "";
            }
            ArrayList<String> stringsToList = Util.stringsToList(Util.nullAs(str3, "").split(","));
            Log.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + gP(linkedList2));
            while (linkedList2.size() < 3 && stringsToList.size() > 0) {
                String remove = stringsToList.remove(0);
                if (remove != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= linkedList2.size()) {
                            break;
                        }
                        String str4 = (String) linkedList2.get(i4);
                        if (remove.compareTo(str4) == 0) {
                            break;
                        } else if (remove.compareTo(str4) > 0) {
                            linkedList2.add(0, remove);
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (!linkedList2.contains(remove)) {
                        linkedList2.add(remove);
                    }
                }
            }
            Log.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + gP(linkedList2));
            aj.faS().kK(str, gP(linkedList2));
        }
        String aOr = r.aOr(r.Jb(linkedList.getLast().Id));
        Log.i("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + str2 + "  -  " + aOr);
        if (i2 == 2) {
            n faO2 = aj.faO();
            String feR = n.feR();
            if (str2 == null || !str2.equals("")) {
                feR = feR + " AND " + faO2.aQA(str2);
            }
            if (n.aQw(aOr)) {
                feR = feR + " AND " + faO2.aQx(aOr);
            }
            Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(feR)));
            rawQuery = faO2.iFy.rawQuery(feR, null);
        } else if (i2 == 16) {
            rawQuery = aj.faO().kL(str2, aOr);
        } else if (i2 == 128) {
            rawQuery = aj.faO().aQ(null, str2, aOr);
        } else {
            n faO3 = aj.faO();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            String co = n.co(str, z);
            if (n.aQw(str2)) {
                co = co + " AND " + faO3.aQA(str2);
            }
            if (n.aQw(aOr)) {
                co = co + " AND " + faO3.aQx(aOr);
            }
            Log.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(co)));
            rawQuery = faO3.iFy.rawQuery(co, null);
        }
        if (rawQuery == null) {
            AppMethodBeat.o(95871);
        } else if (!rawQuery.moveToFirst()) {
            rawQuery.close();
            AppMethodBeat.o(95871);
        } else {
            do {
                SnsInfo snsInfo = new SnsInfo();
                snsInfo.convertFrom(rawQuery);
                long j2 = snsInfo.field_snsId;
                if (snsInfo.isWaitPost()) {
                    Log.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
                } else if (snsInfo.isDieItem()) {
                    Log.d("MicroMsg.SnsInfoStorageLogic", "die one ");
                } else if (!arrayList.contains(Long.valueOf(j2))) {
                    snsInfo.removeSourceFlag(i2);
                    aj.faO().b(j2, snsInfo);
                    if (i2 == 2) {
                        aj.faX().JO(j2);
                    }
                    Log.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + j2 + " source " + i2 + ", snsIdStr=" + r.Jb(j2));
                }
            } while (rawQuery.moveToNext());
            rawQuery.close();
            aw faZ = aj.faZ();
            Log.i("MicroMsg.SnsUnreadTipManager", "checkRemoveFeed");
            aj.dRd().post(new Runnable(arrayList) {
                /* class com.tencent.mm.plugin.sns.model.aw.AnonymousClass3 */
                final /* synthetic */ List hjk;

                {
                    this.hjk = r2;
                }

                public final void run() {
                    AppMethodBeat.i(179097);
                    if (!Util.isNullOrNil(this.hjk) && !Util.isNullOrNil(aw.this.DNJ.DRY)) {
                        long longValue = ((Long) this.hjk.get(0)).longValue();
                        long longValue2 = ((Long) this.hjk.get(this.hjk.size() - 1)).longValue();
                        ArrayList<Long> arrayList = new ArrayList();
                        Iterator<com.tencent.mm.plugin.sns.j.l> it = aw.this.DNJ.DRY.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.sns.j.l next = it.next();
                            if (!Util.isNullOrNil(next.tbl)) {
                                Iterator<Long> it2 = next.tbl.iterator();
                                while (it2.hasNext()) {
                                    Long next2 = it2.next();
                                    if (next2.longValue() < longValue && next2.longValue() > longValue2) {
                                        arrayList.add(next2);
                                    }
                                }
                            }
                        }
                        for (Long l : arrayList) {
                            if (!this.hjk.contains(l)) {
                                aw.this.Jx(l.longValue());
                            }
                        }
                    }
                    AppMethodBeat.o(179097);
                }
            });
            AppMethodBeat.o(95871);
        }
    }

    public static boolean YA(int i2) {
        return (i2 & 16) > 0;
    }

    public static boolean aQ(int i2, boolean z) {
        if (!z || i2 <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean YB(int r9) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.an.YB(int):boolean");
    }

    public static boolean In(String str) {
        AppMethodBeat.i(95873);
        boolean equals = z.aTY().equals(str.trim());
        AppMethodBeat.o(95873);
        return equals;
    }

    public static List<SnsInfo> fbp() {
        AppMethodBeat.i(95874);
        ArrayList arrayList = new ArrayList();
        n faO = aj.faO();
        Cursor rawQuery = faO.iFy.rawQuery(n.feT() + " AND " + n.EmB + " AND  (snsId = 0  ) ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(95874);
        } else {
            rawQuery.moveToFirst();
            do {
                SnsInfo snsInfo = new SnsInfo();
                snsInfo.convertFrom(rawQuery);
                arrayList.add(snsInfo);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            AppMethodBeat.o(95874);
        }
        return arrayList;
    }

    public static String aPl(String str) {
        AppMethodBeat.i(95875);
        int i2 = 1;
        LinkedList linkedList = new LinkedList();
        Cursor cursor = aj.faU().getCursor();
        if (cursor.moveToFirst()) {
            do {
                s sVar = new s();
                sVar.convertFrom(cursor);
                linkedList.add(Util.nullAs(sVar.field_tagName, ""));
            } while (cursor.moveToNext());
        }
        cursor.close();
        String str2 = str;
        while (linkedList.contains(str2)) {
            str2 = str + i2;
            i2++;
        }
        AppMethodBeat.o(95875);
        return str2;
    }

    public static SnsInfo YC(int i2) {
        AppMethodBeat.i(95876);
        SnsInfo snsInfo = new SnsInfo();
        n faO = aj.faO();
        String str = ((n.feU() + " and createTime < " + i2) + n.Emu) + " LIMIT 1";
        Log.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", str);
        Cursor rawQuery = faO.iFy.rawQuery(str, null);
        if (rawQuery == null) {
            rawQuery = null;
        }
        if (rawQuery == null) {
            AppMethodBeat.o(95876);
            return null;
        } else if (rawQuery.moveToFirst()) {
            snsInfo.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(95876);
            return snsInfo;
        } else {
            rawQuery.close();
            AppMethodBeat.o(95876);
            return null;
        }
    }

    public static List<com.tencent.mm.plugin.sns.j.b> kg(String str, String str2) {
        int i2 = 0;
        AppMethodBeat.i(95877);
        ArrayList arrayList = new ArrayList();
        dw dwVar = null;
        try {
            String str3 = str2 + str + "_ARTISTF.mm";
            String str4 = str2 + str + "_ARTIST.mm";
            if (com.tencent.mm.vfs.s.YS(str3)) {
                dwVar = (dw) new dw().parseFrom(com.tencent.mm.vfs.s.aW(str3, 0, (int) com.tencent.mm.vfs.s.boW(str3)));
            }
            if (dwVar == null) {
                com.tencent.mm.vfs.s.deleteFile(str3);
                dwVar = a.aPO(new String(com.tencent.mm.vfs.s.aW(str4, 0, (int) com.tencent.mm.vfs.s.boW(str4))));
                com.tencent.mm.vfs.s.f(str3, dwVar.toByteArray(), -1);
            }
            Iterator<bzz> it = dwVar.GroupList.iterator();
            while (it.hasNext()) {
                bzz next = it.next();
                String str5 = next.Name;
                Iterator<cnb> it2 = next.LoV.iterator();
                while (it2.hasNext()) {
                    cnb next2 = it2.next();
                    next2.Desc = str5;
                    com.tencent.mm.plugin.sns.j.b bVar = new com.tencent.mm.plugin.sns.j.b();
                    bVar.ebR = next2;
                    bVar.parentId = "";
                    int i3 = i2 + 1;
                    bVar.DRJ = i2;
                    arrayList.add(bVar);
                    i2 = i3;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
        }
        AppMethodBeat.o(95877);
        return arrayList;
    }

    public static cnb b(SnsInfo snsInfo, int i2) {
        AppMethodBeat.i(95878);
        if (aj.isInValid()) {
            AppMethodBeat.o(95878);
            return null;
        } else if (snsInfo == null) {
            AppMethodBeat.o(95878);
            return null;
        } else {
            TimeLineObject timeLine = snsInfo.getTimeLine();
            if (timeLine.ContentObj == null || timeLine.ContentObj.LoV.size() == 0 || timeLine.ContentObj.LoV.size() <= i2) {
                AppMethodBeat.o(95878);
                return null;
            }
            cnb cnb = timeLine.ContentObj.LoV.get(i2);
            AppMethodBeat.o(95878);
            return cnb;
        }
    }

    public static cnb a(SnsInfo snsInfo, String str) {
        AppMethodBeat.i(95879);
        TimeLineObject timeLine = snsInfo.getTimeLine();
        if (timeLine.ContentObj == null || timeLine.ContentObj.LoV.size() == 0) {
            AppMethodBeat.o(95879);
            return null;
        }
        Iterator<cnb> it = timeLine.ContentObj.LoV.iterator();
        while (it.hasNext()) {
            cnb next = it.next();
            if (next.Id.equals(str)) {
                AppMethodBeat.o(95879);
                return next;
            }
        }
        AppMethodBeat.o(95879);
        return null;
    }

    public static List<com.tencent.mm.plugin.sns.j.b> aPm(String str) {
        AppMethodBeat.i(95880);
        ArrayList arrayList = new ArrayList();
        if (aj.isInValid()) {
            AppMethodBeat.o(95880);
            return arrayList;
        }
        SnsInfo aQm = f.aQm(str);
        if (aQm == null) {
            AppMethodBeat.o(95880);
            return arrayList;
        }
        TimeLineObject timeLine = aQm.getTimeLine();
        if (timeLine.ContentObj == null || timeLine.ContentObj.LoV.size() == 0) {
            AppMethodBeat.o(95880);
            return arrayList;
        }
        arrayList.clear();
        int i2 = 0;
        Iterator<cnb> it = timeLine.ContentObj.LoV.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.sns.j.b bVar = new com.tencent.mm.plugin.sns.j.b();
            bVar.ebR = it.next();
            bVar.parentId = str;
            bVar.iXu = timeLine.CreateTime;
            i2++;
            bVar.DRJ = i2;
            arrayList.add(bVar);
        }
        AppMethodBeat.o(95880);
        return arrayList;
    }

    public static List<com.tencent.mm.plugin.sns.j.b> gQ(List<String> list) {
        AppMethodBeat.i(95881);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            AppMethodBeat.o(95881);
            return arrayList;
        }
        arrayList.clear();
        int i2 = 0;
        for (String str : list) {
            com.tencent.mm.plugin.sns.j.b bVar = new com.tencent.mm.plugin.sns.j.b();
            cnb cnb = new cnb();
            cnb.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
            bVar.ebR = cnb;
            bVar.parentId = "";
            i2++;
            bVar.DRJ = i2;
            arrayList.add(bVar);
        }
        AppMethodBeat.o(95881);
        return arrayList;
    }

    public static void YD(int i2) {
        AppMethodBeat.i(95882);
        Log.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(i2)));
        SnsInfo Zr = aj.faO().Zr(i2);
        if (Zr == null) {
            AppMethodBeat.o(95882);
            return;
        }
        Zr.unsetOmittedFailResend();
        aj.faO().d(i2, Zr);
        AppMethodBeat.o(95882);
    }

    public static void fbq() {
        AppMethodBeat.i(95883);
        Cursor q = aj.faO().q("", "", 0, 0);
        if (q != null) {
            Log.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
            while (q.moveToNext()) {
                SnsInfo snsInfo = new SnsInfo();
                snsInfo.convertFrom(q);
                Log.i("MicroMsg.SnsInfoStorageLogic", snsInfo.getSnsId());
            }
            Log.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
            q.close();
        }
        AppMethodBeat.o(95883);
    }

    public static List<SnsInfo> kh(String str, String str2) {
        AppMethodBeat.i(95884);
        Cursor kL = aj.faO().kL(str, str2);
        ArrayList arrayList = new ArrayList();
        if (kL.getCount() == 0) {
            kL.close();
            AppMethodBeat.o(95884);
        } else {
            if (kL.moveToFirst()) {
                do {
                    SnsInfo snsInfo = new SnsInfo();
                    snsInfo.convertFrom(kL);
                    arrayList.add(snsInfo);
                } while (kL.moveToNext());
            }
            kL.close();
            AppMethodBeat.o(95884);
        }
        return arrayList;
    }

    public static void j(LinkedList<SnsObject> linkedList, int i2) {
        AppMethodBeat.i(95885);
        if (i2 == ax.DOd) {
            DIf = linkedList.getFirst().Id;
            DIg = linkedList.getLast().Id;
            AppMethodBeat.o(95885);
        } else if (i2 == ax.DOe) {
            DIf = linkedList.getFirst().Id;
            AppMethodBeat.o(95885);
        } else {
            if (i2 == ax.DOf) {
                DIg = linkedList.getLast().Id;
            }
            AppMethodBeat.o(95885);
        }
    }

    public static void fbr() {
        DIf = 0;
        DIg = 0;
    }
}
