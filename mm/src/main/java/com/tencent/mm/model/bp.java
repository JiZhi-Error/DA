package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Map;

public final class bp {
    private static volatile boolean iEf = false;

    public interface a {
        boolean amG();

        void amH();
    }

    public static class b {
        public String iEA;
        public String iEB;
        public String iEC;
        public String iED;
        public int iEE;
        public int iEF;
        public int iEG;
        public int iEH;
        public String iEI;
        public String iEo;
        public int iEp;
        public int iEq;
        public String iEr;
        public String iEs;
        public int iEt;
        public int iEu;
        public long iEv;
        public String iEw;
        @Deprecated
        public String iEx;
        public String iEy;
        public String iEz;
        public int scene = 0;
        public int serviceType;
        public String userId;
    }

    @Deprecated
    public static int Kp(String str) {
        AppMethodBeat.i(163509);
        int Kr = Kr(str);
        AppMethodBeat.o(163509);
        return Kr;
    }

    public static String aP(String str, String str2) {
        AppMethodBeat.i(42951);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42951);
            return null;
        } else if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(42951);
            return str;
        } else {
            String str3 = str2 + ": " + str;
            AppMethodBeat.o(42951);
            return str3;
        }
    }

    private static int Kr(String str) {
        AppMethodBeat.i(42952);
        if (str == null) {
            Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
            AppMethodBeat.o(42952);
            return -1;
        } else if (str.length() <= 0) {
            Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
            AppMethodBeat.o(42952);
            return -1;
        } else if (str.startsWith(SemiXml.MAGIC_HEAD)) {
            Log.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
            AppMethodBeat.o(42952);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.o(42952);
                return indexOf;
            }
            Log.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
            AppMethodBeat.o(42952);
            return -1;
        }
    }

    public static String Ks(String str) {
        AppMethodBeat.i(42953);
        int Kr = Kr(str);
        if (Kr == -1) {
            AppMethodBeat.o(42953);
            return null;
        }
        String substring = str.substring(0, Kr);
        AppMethodBeat.o(42953);
        return substring;
    }

    public static String Kt(String str) {
        AppMethodBeat.i(42954);
        int Kr = Kr(str);
        if (Kr == -1) {
            AppMethodBeat.o(42954);
            return str;
        } else if (Kr + 2 >= str.length()) {
            AppMethodBeat.o(42954);
            return str;
        } else {
            String substring = str.substring(Kr + 2);
            AppMethodBeat.o(42954);
            return substring;
        }
    }

    public static void aVO() {
        AppMethodBeat.i(42955);
        ((l) g.af(l.class)).eiy().aVO();
        AppMethodBeat.o(42955);
    }

    public static long x(ca caVar) {
        AppMethodBeat.i(42956);
        as Kn = ((l) g.af(l.class)).aSN().Kn(caVar.field_talker);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            as asVar = new as(caVar.field_talker);
            asVar.setType(2);
            mq mqVar = new mq();
            mqVar.dSg.dSh = asVar;
            EventCenter.instance.publish(mqVar);
            ((l) g.af(l.class)).aSN().ap(asVar);
        }
        long aC = ((l) g.af(l.class)).eiy().aC(caVar);
        AppMethodBeat.o(42956);
        return aC;
    }

    public static void y(ca caVar) {
        AppMethodBeat.i(225950);
        as Kn = ((l) g.af(l.class)).aSN().Kn(caVar.field_talker);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            as asVar = new as(caVar.field_talker);
            asVar.setType(2);
            mq mqVar = new mq();
            mqVar.dSg.dSh = asVar;
            EventCenter.instance.publish(mqVar);
            ((l) g.af(l.class)).aSN().ap(asVar);
        }
        ((l) g.af(l.class)).eiy().a(caVar.field_msgId, caVar);
        AppMethodBeat.o(225950);
    }

    public static int Ku(String str) {
        AppMethodBeat.i(42957);
        int Ku = ((l) g.af(l.class)).eiy().Ku(str);
        AppMethodBeat.o(42957);
        return Ku;
    }

    public static boolean Kv(String str) {
        AppMethodBeat.i(42958);
        boolean Kv = ((l) g.af(l.class)).eiy().Kv(str);
        AppMethodBeat.o(42958);
        return Kv;
    }

    public static boolean sb(int i2) {
        switch (i2) {
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case 29:
                return true;
            case 25:
            default:
                return false;
        }
    }

    public static long aVP() {
        AppMethodBeat.i(42959);
        long currentTimeMillis = System.currentTimeMillis();
        long aWz = cl.aWz();
        if (Math.abs(currentTimeMillis - aWz) > 300000) {
            Log.w("MicroMsg.MsgInfoStorageLogic", "[getFixTime] nowServer:" + aWz + " now:" + currentTimeMillis);
        }
        AppMethodBeat.o(42959);
        return aWz;
    }

    public static long Kw(String str) {
        ca aEx;
        AppMethodBeat.i(42960);
        long aVP = aVP();
        Log.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", Long.valueOf(aVP));
        if (!(str == null || (aEx = ((l) g.af(l.class)).eiy().aEx(str)) == null)) {
            Log.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", Long.valueOf(aEx.field_msgId), Long.valueOf(aVP));
            if (aEx.field_createTime + 1 > aVP) {
                long j2 = aEx.field_createTime + 1;
                AppMethodBeat.o(42960);
                return j2;
            }
        }
        AppMethodBeat.o(42960);
        return aVP;
    }

    public static long C(String str, long j2) {
        long j3;
        ca aEx;
        AppMethodBeat.i(42961);
        if (str == null || (aEx = ((l) g.af(l.class)).eiy().aEx(str)) == null) {
            j3 = 0;
        } else {
            j3 = aEx.field_createTime + 1;
        }
        if (j3 > j2 * 1000) {
            AppMethodBeat.o(42961);
            return j3;
        }
        long j4 = j2 * 1000;
        AppMethodBeat.o(42961);
        return j4;
    }

    private static int sc(int i2) {
        switch (i2) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
                return 49;
            default:
                return i2;
        }
    }

    public static void z(ca caVar) {
        AppMethodBeat.i(42962);
        if (caVar == null) {
            AppMethodBeat.o(42962);
            return;
        }
        h ck = h.d.ck(Integer.valueOf(sc(caVar.getType())));
        if (ck != null) {
            ck.b(new h.c(caVar));
        }
        cv cvVar = new cv();
        cvVar.dFX.msgId = caVar.field_msgId;
        cvVar.dFX.talker = caVar.field_talker;
        cvVar.dFX.msgType = caVar.getType();
        EventCenter.instance.publish(cvVar);
        AppMethodBeat.o(42962);
    }

    public static void ar(List<Long> list) {
        AppMethodBeat.i(42963);
        if (list.size() == 0) {
            AppMethodBeat.o(42963);
            return;
        }
        for (Long l : list) {
            Ad(l.longValue());
        }
        AppMethodBeat.o(42963);
    }

    public static int Ad(long j2) {
        AppMethodBeat.i(42964);
        ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
        if (Hb.field_msgId != j2) {
            AppMethodBeat.o(42964);
            return 0;
        }
        z(Hb);
        int Hc = ((l) g.af(l.class)).eiy().Hc(j2);
        AppMethodBeat.o(42964);
        return Hc;
    }

    public static int D(String str, long j2) {
        AppMethodBeat.i(42965);
        ca aJ = ((l) g.af(l.class)).eiy().aJ(str, j2);
        if (aJ.field_msgSvrId != j2) {
            AppMethodBeat.o(42965);
            return 0;
        }
        z(aJ);
        int aT = ((l) g.af(l.class)).eiy().aT(str, j2);
        AppMethodBeat.o(42965);
        return aT;
    }

    public static int Kx(String str) {
        AppMethodBeat.i(42966);
        int aEE = ((l) g.af(l.class)).eiy().aEE(str);
        AppMethodBeat.o(42966);
        return aEE;
    }

    public static int aVQ() {
        AppMethodBeat.i(174543);
        if (iEf) {
            Log.i("MicroMsg.MsgInfoStorageLogic", "checkUnfinishedDeleteMsgTask already started.");
            AppMethodBeat.o(174543);
            return -1;
        }
        final Map<String, Long> eiB = ((l) g.af(l.class)).aTq().eiB();
        if (eiB.isEmpty()) {
            Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask all finished!");
            AppMethodBeat.o(174543);
            return 0;
        }
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.model.bp.AnonymousClass1 */
            final int iEg = 200;
            final int iEh = 30;
            final int iEi = 5;
            int iEj = 100;

            public final void run() {
                AppMethodBeat.i(42941);
                boolean unused = bp.iEf = true;
                Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(eiB.size()));
                if (eiB.containsKey("")) {
                    bp.d(((Long) eiB.get("")).longValue(), 2);
                    eiB.remove("");
                    ((l) g.af(l.class)).aTq().aH("", 0);
                }
                for (Map.Entry entry : eiB.entrySet()) {
                    String str = (String) entry.getKey();
                    long longValue = ((Long) entry.getValue()).longValue();
                    if (longValue > 0) {
                        long nowMilliSecond = Util.nowMilliSecond();
                        int i2 = 0;
                        long j2 = 0;
                        while (true) {
                            if (this.iEj < 200 && this.iEj > 30) {
                                this.iEj = j2 > 500 ? this.iEj - 5 : this.iEj + 5;
                            }
                            long nowMilliSecond2 = Util.nowMilliSecond();
                            Cursor G = ((l) g.af(l.class)).eiy().G(str, this.iEj, longValue);
                            long j3 = 0;
                            long j4 = 0;
                            while (G.moveToNext()) {
                                ca caVar = new ca();
                                caVar.convertFrom(G);
                                if (j3 < caVar.field_createTime) {
                                    j3 = caVar.field_createTime;
                                }
                                j4 = 1 + j4;
                                bp.z(caVar);
                            }
                            G.close();
                            long nowMilliSecond3 = Util.nowMilliSecond();
                            if (j3 > 0 && j4 > 0) {
                                ((l) g.af(l.class)).eiy().aU(str, j3);
                                ((au) g.af(au.class)).A(str, j3);
                            }
                            i2 = (int) (((long) i2) + j4);
                            long nowMilliSecond4 = Util.nowMilliSecond();
                            j2 = nowMilliSecond4 - nowMilliSecond2;
                            Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", Util.secPrint(str), Integer.valueOf(i2), Long.valueOf(j4), Long.valueOf(longValue - j3), Long.valueOf(longValue), Long.valueOf(nowMilliSecond4 - nowMilliSecond3), Long.valueOf(nowMilliSecond4 - nowMilliSecond2), Long.valueOf(nowMilliSecond4 - nowMilliSecond), Integer.valueOf(this.iEj));
                            if (j4 <= 0) {
                                break;
                            }
                        }
                        ((l) g.af(l.class)).aTq().aH(str, 0);
                    }
                }
                Log.i("MicroMsg.MsgInfoStorageLogic", "Done checkUnfinishedDeleteMsgTask");
                boolean unused2 = bp.iEf = false;
                AppMethodBeat.o(42941);
            }
        }, "checkUnfinishedDeleteMsgTask");
        int size = eiB.size();
        AppMethodBeat.o(174543);
        return size;
    }

    public static int a(final String str, final a aVar) {
        AppMethodBeat.i(42967);
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", str, Util.getStack());
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] is null", str);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.model.bp.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(42942);
                    if (aVar != null) {
                        aVar.amH();
                    }
                    AppMethodBeat.o(42942);
                }
            });
            AppMethodBeat.o(42967);
        } else {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.model.bp.AnonymousClass3 */
                final int iEg = 200;
                final int iEh = 30;
                final int iEi = 5;
                int iEj = 100;

                public final void run() {
                    long j2;
                    long j3;
                    long j4;
                    int i2;
                    AppMethodBeat.i(42943);
                    try {
                        ca aEx = ((l) g.af(l.class)).eiy().aEx(str);
                        if (aEx == null) {
                            j2 = Long.MAX_VALUE;
                        } else {
                            j2 = aEx.field_createTime;
                        }
                        ((l) g.af(l.class)).aTq().aH(str, j2);
                        Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), aEx, Long.valueOf(j2));
                        long nowMilliSecond = Util.nowMilliSecond();
                        long j5 = 0;
                        int i3 = 0;
                        do {
                            if (this.iEj < 200 && this.iEj > 30) {
                                if (j5 > 500) {
                                    i2 = this.iEj - 5;
                                } else {
                                    i2 = this.iEj + 5;
                                }
                                this.iEj = i2;
                            }
                            long nowMilliSecond2 = Util.nowMilliSecond();
                            Cursor G = ((l) g.af(l.class)).eiy().G(str, this.iEj, j2);
                            long j6 = 0;
                            j3 = 0;
                            while (G.moveToNext()) {
                                ca caVar = new ca();
                                caVar.convertFrom(G);
                                if (j6 < caVar.field_createTime) {
                                    j4 = caVar.field_createTime;
                                } else {
                                    j4 = j6;
                                }
                                j3++;
                                bp.z(caVar);
                                j6 = j4;
                            }
                            G.close();
                            long nowMilliSecond3 = Util.nowMilliSecond();
                            if (j6 > 0 && j3 > 0) {
                                ((l) g.af(l.class)).eiy().aU(str, j6);
                                ((au) g.af(au.class)).A(str, j6);
                            }
                            i3 = (int) (((long) i3) + j3);
                            long nowMilliSecond4 = Util.nowMilliSecond();
                            j5 = nowMilliSecond4 - nowMilliSecond2;
                            Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", Util.secPrint(str), Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j2 - j6), Long.valueOf(j2), Long.valueOf(nowMilliSecond4 - nowMilliSecond3), Long.valueOf(nowMilliSecond4 - nowMilliSecond2), Long.valueOf(nowMilliSecond4 - nowMilliSecond), Integer.valueOf(this.iEj));
                        } while (j3 > 0);
                        AppMethodBeat.o(42943);
                    } catch (b e2) {
                        Log.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", e2, "", new Object[0]);
                        AppMethodBeat.o(42943);
                    }
                }
            }, "deleteMsgByTalker");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.model.bp.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(42944);
                    if (aVar != null) {
                        aVar.amH();
                    }
                    AppMethodBeat.o(42944);
                }
            });
            AppMethodBeat.o(42967);
        }
        return 0;
    }

    public static int ak(String str, int i2) {
        AppMethodBeat.i(174544);
        Cursor eD = ((l) g.af(l.class)).eiy().eD(str, i2);
        if (eD.moveToFirst()) {
            while (!eD.isAfterLast()) {
                ca caVar = new ca();
                caVar.convertFrom(eD);
                z(caVar);
                eD.moveToNext();
            }
        }
        eD.close();
        int eC = ((l) g.af(l.class)).eiy().eC(str, i2);
        AppMethodBeat.o(174544);
        return eC;
    }

    public static void a(final a aVar) {
        AppMethodBeat.i(42968);
        final long aWz = cl.aWz();
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.model.bp.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(42946);
                e.INSTANCE.idkeyStat(1333, 0, 1, true);
                long currentTimeMillis = System.currentTimeMillis();
                ((au) g.af(au.class)).aVn();
                ((l) g.af(l.class)).aTq().aH("", aWz);
                ((l) g.af(l.class)).aST().gCs();
                if (aVar != null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.model.bp.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(42945);
                            aVar.amH();
                            AppMethodBeat.o(42945);
                        }
                    });
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                Log.i("MicroMsg.MsgInfoStorageLogic", "Delete all messages, synchronized part, time: %d ms", Long.valueOf(currentTimeMillis2));
                e.INSTANCE.idkeyStat(1333, 6, currentTimeMillis2 / 1000, true);
                if (aVar == null || !aVar.amG()) {
                    bp.aVS();
                    if (aVar == null || !aVar.amG()) {
                        bp.aVT();
                        if (aVar == null || !aVar.amG()) {
                            bp.aVR();
                            if (aVar == null || !aVar.amG()) {
                                bp.d(aWz, 1);
                                ((l) g.af(l.class)).aTq().aH("", 0);
                                Log.i("MicroMsg.MsgInfoStorageLogic", "Delete all messages, asynchronous part, time: %d ms", Long.valueOf((System.currentTimeMillis() - currentTimeMillis) - currentTimeMillis2));
                                AppMethodBeat.o(42946);
                                return;
                            }
                            AppMethodBeat.o(42946);
                            return;
                        }
                        AppMethodBeat.o(42946);
                        return;
                    }
                    AppMethodBeat.o(42946);
                    return;
                }
                AppMethodBeat.o(42946);
            }

            public final String toString() {
                AppMethodBeat.i(42947);
                String str = super.toString() + "|deleteAllMsg";
                AppMethodBeat.o(42947);
                return str;
            }
        }, "deleteAllMsg");
        AppMethodBeat.o(42968);
    }

    public static void aVR() {
        AppMethodBeat.i(174545);
        List<ca> aEB = ((l) g.af(l.class)).eiy().aEB("bottlemessage");
        if (aEB != null) {
            for (int i2 = 0; i2 < aEB.size(); i2++) {
                z(aEB.get(i2));
            }
        }
        ((l) g.af(l.class)).eiy().aED("bottlemessage");
        AppMethodBeat.o(174545);
    }

    public static void aVS() {
        AppMethodBeat.i(42969);
        List<ca> aEB = ((l) g.af(l.class)).eiy().aEB("qmessage");
        if (aEB != null) {
            for (int i2 = 0; i2 < aEB.size(); i2++) {
                z(aEB.get(i2));
            }
        }
        ((l) g.af(l.class)).eiy().aED("qmessage");
        AppMethodBeat.o(42969);
    }

    public static void aVT() {
        AppMethodBeat.i(42970);
        List<ca> aEB = ((l) g.af(l.class)).eiy().aEB("tmessage");
        if (aEB != null) {
            for (int i2 = 0; i2 < aEB.size(); i2++) {
                z(aEB.get(i2));
            }
        }
        ((l) g.af(l.class)).eiy().aED("tmessage");
        AppMethodBeat.o(42970);
    }

    /* access modifiers changed from: package-private */
    public static class c implements Closeable {
        FileChannel iEJ;
        ByteBuffer iEK;
        long iEL;
        long iEM;

        c() {
            AppMethodBeat.i(178869);
            try {
                this.iEJ = s.a(new o(MMApplicationContext.getContext().getCacheDir(), "asyncClearMsgStat").mUri, true).getChannel();
                this.iEK = ByteBuffer.allocate(8);
                this.iEJ.read(this.iEK, 0);
                if (this.iEK.remaining() == 8) {
                    this.iEL = this.iEK.getLong(0);
                }
                this.iEK.clear();
                AppMethodBeat.o(178869);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", e2, "Cannot init time statistics", new Object[0]);
                aa.closeQuietly(this.iEJ);
                this.iEJ = null;
                AppMethodBeat.o(178869);
            }
        }

        /* access modifiers changed from: package-private */
        public final void end() {
            AppMethodBeat.i(178870);
            if (this.iEM == 0) {
                AppMethodBeat.o(178870);
                return;
            }
            this.iEL = (System.currentTimeMillis() - this.iEM) + this.iEL;
            if (this.iEJ != null) {
                this.iEK.putLong(0, this.iEL);
                try {
                    this.iEJ.write(this.iEK, 0);
                } catch (IOException e2) {
                    Log.e("MicroMsg.MsgInfoStorageLogic", "Cannot update time statistics: " + e2.getMessage());
                }
                this.iEK.clear();
            }
            this.iEM = 0;
            AppMethodBeat.o(178870);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            AppMethodBeat.i(178871);
            this.iEJ.close();
            AppMethodBeat.o(178871);
        }

        static void reset() {
            AppMethodBeat.i(178872);
            new o(MMApplicationContext.getContext().getCacheDir(), "asyncClearMsgStat").delete();
            AppMethodBeat.o(178872);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0261, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0262, code lost:
        r4.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0266, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01db, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(174546);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01e2, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e3, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e4, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01e5, code lost:
        if (r4 == null) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r21.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01ea, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(174546);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01f0, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0204, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0205, code lost:
        r3 = r2;
        r4 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01cf  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e7 A[SYNTHETIC, Splitter:B:63:0x01e7] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0204 A[ExcHandler: all (r2v5 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:6:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(long r24, int r26) {
        /*
        // Method dump skipped, instructions count: 656
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.bp.d(long, int):void");
    }

    public static void as(final List<String> list) {
        AppMethodBeat.i(174547);
        if (list == null || list.size() <= 0) {
            Log.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
            AppMethodBeat.o(174547);
            return;
        }
        Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalkers stack[%s]", Util.getStack());
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.model.bp.AnonymousClass6 */

            public final void run() {
                long j2;
                AppMethodBeat.i(42948);
                Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(list.size()));
                for (String str : list) {
                    ca aEx = ((l) g.af(l.class)).eiy().aEx(str);
                    if (aEx == null) {
                        j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                    } else {
                        j2 = aEx.field_createTime;
                    }
                    long aWy = cl.aWy();
                    if (j2 > aWy) {
                        Log.w("MicroMsg.MsgInfoStorageLogic", "last message time[%s] is over serverTime[%s]!", Long.valueOf(j2), Long.valueOf(aWy));
                        j2 = aWy;
                    }
                    if (aEx != null && aEx.field_createTime > 0) {
                        ((l) g.af(l.class)).aTq().aH(str, j2);
                    }
                    Log.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", str, aEx, Long.valueOf(j2));
                    Cursor aEG = ((l) g.af(l.class)).eiy().aEG(str);
                    if (aEG != null) {
                        if (aEG.moveToFirst()) {
                            while (!aEG.isAfterLast()) {
                                ca caVar = new ca();
                                caVar.convertFrom(aEG);
                                bp.z(caVar);
                                aEG.moveToNext();
                            }
                        }
                        aEG.close();
                        Log.i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", str, Integer.valueOf(((l) g.af(l.class)).eiy().aEE(str)));
                        ((l) g.af(l.class)).aTq().aH(str, 0);
                    }
                }
                AppMethodBeat.o(42948);
            }
        }, "deleteMsgByTalkers");
        AppMethodBeat.o(174547);
    }

    public static b Ky(String str) {
        AppMethodBeat.i(42971);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(42971);
            return null;
        }
        try {
            Map<String, String> parseXml = XmlParser.parseXml(str, "msgsource", null);
            if (parseXml == null || parseXml.isEmpty()) {
                AppMethodBeat.o(42971);
                return null;
            }
            b bVar = new b();
            bVar.iEo = parseXml.get(".msgsource.bizmsg.msgcluster");
            bVar.iEs = parseXml.get(".msgsource.kf.kf_worker");
            bVar.iEt = Util.getInt(parseXml.get(".msgsource.kf.kf_type_new"), 0);
            bVar.iEr = Util.nullAsNil(parseXml.get(".msgsource.bizmsg.bizclientmsgid"));
            if (Util.isNullOrNil(bVar.iEr)) {
                bVar.iEr = Util.nullAsNil(parseXml.get(".msgsource.enterprise_info.climsgid"));
            }
            bVar.iEx = Util.nullAsNil(parseXml.get(".msgsource.enterprise_info.qy_msg_type"));
            bVar.iEy = Util.nullAsNil(parseXml.get(".msgsource.enterprise_info.chat_type"));
            bVar.iEz = Util.nullAsNil(parseXml.get(".msgsource.enterprise_info.bizchat_id"));
            bVar.iEA = Util.nullAsNil(parseXml.get(".msgsource.enterprise_info.bizchat_ver"));
            bVar.userId = Util.nullAsNil(parseXml.get(".msgsource.enterprise_info.user_id"));
            bVar.iEB = Util.nullAsNil(parseXml.get(".msgsource.enterprise_info.user_nickname"));
            bVar.iEC = Util.nullAsNil(parseXml.get(".msgsource.enterprise_info.sync_from_qy_im"));
            bVar.iEw = parseXml.get(".msgsource.strangerantispamticket.$ticket");
            bVar.scene = Util.getInt(parseXml.get(".msgsource.strangerantispamticket.$scene"), 0);
            bVar.iED = parseXml.get(".msgsource.NotAutoDownloadRange");
            bVar.iEE = Util.getInt(parseXml.get(".msgsource.DownloadLimitKbps"), 0);
            bVar.iEF = Util.getInt(parseXml.get(".msgsource.videopreloadlen"), 0);
            bVar.iEG = Util.getInt(parseXml.get(".msgsource.PreDownload"), 0);
            bVar.iEH = Util.getInt(parseXml.get(".msgsource.PreDownloadNetType"), 0);
            bVar.iEI = parseXml.get(".msgsource.NoPreDownloadRange");
            bVar.iEp = Util.getInt(parseXml.get(".msgsource.msg_cluster_type"), -1);
            bVar.serviceType = Util.getInt(parseXml.get(".msgsource.service_type"), -1);
            bVar.iEq = Util.getInt(parseXml.get(".msgsource.scene"), -1);
            bVar.iEu = Util.getInt(parseXml.get(".msgsource.bizmsg.msg_predict"), 0);
            bVar.iEv = Util.getLong(parseXml.get(".msgsource.bizflag"), 0);
            AppMethodBeat.o(42971);
            return bVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", e2.getMessage());
            AppMethodBeat.o(42971);
            return null;
        }
    }

    public static String Kz(String str) {
        AppMethodBeat.i(42972);
        b Ky = Ky(str);
        if (Ky == null) {
            AppMethodBeat.o(42972);
            return null;
        }
        String str2 = Ky.iEs;
        AppMethodBeat.o(42972);
        return str2;
    }

    public static void a(ca caVar, h.a aVar) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(42973);
        if (caVar == null || aVar == null || aVar.heO == null) {
            Log.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", Util.getStack());
            AppMethodBeat.o(42973);
        } else if (caVar.field_msgSvrId != aVar.heO.Brn) {
            AppMethodBeat.o(42973);
        } else {
            de deVar = aVar.heO;
            if (caVar.field_isSend == 0 || deVar.KHs != 0) {
                if (caVar.field_msgSeq == 0 && deVar.KHs != 0) {
                    caVar.yH((long) deVar.KHs);
                }
                int i5 = caVar.field_flag;
                if (aVar.iLV) {
                    i2 = i5 | 2;
                } else {
                    i2 = i5 & -3;
                }
                if (aVar.iLW) {
                    i3 = i2 | 1;
                } else {
                    i3 = i2 & -2;
                }
                if (aVar.iLX) {
                    i4 = i3 | 4;
                } else {
                    i4 = i3 & -5;
                }
                caVar.setFlag(i4);
                if (caVar.field_msgId == 0 && aVar.iLV) {
                    caVar.setCreateTime(aVar.iLY);
                }
                AppMethodBeat.o(42973);
                return;
            }
            AppMethodBeat.o(42973);
        }
    }

    public static boolean c(h.a aVar) {
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(42974);
        if (aVar == null || aVar.heO == null) {
            AppMethodBeat.o(42974);
            return false;
        }
        de deVar = aVar.heO;
        ca aJ = ((l) g.af(l.class)).eiy().aJ(z.a(deVar.KHl), deVar.Brn);
        if (aJ.field_msgId == 0) {
            AppMethodBeat.o(42974);
            return false;
        } else if (aJ.field_isSend == 0 || deVar.KHs != 0) {
            int i5 = aJ.field_flag;
            if (aVar.iLV) {
                i2 = i5 | 2;
            } else {
                i2 = i5 & -3;
            }
            if (aVar.iLW) {
                i3 = i2 | 1;
            } else {
                i3 = i2 & -2;
            }
            if (aVar.iLX) {
                i4 = i3 | 4;
            } else {
                i4 = i3 & -5;
            }
            if (i4 != aJ.field_flag) {
                Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", Integer.valueOf(deVar.xKb), Integer.valueOf(i4), Integer.valueOf(aJ.field_flag));
                aJ.setFlag(i4);
                ((l) g.af(l.class)).eiy().b(aJ.field_msgSvrId, aJ);
                AppMethodBeat.o(42974);
                return true;
            }
            AppMethodBeat.o(42974);
            return false;
        } else {
            AppMethodBeat.o(42974);
            return false;
        }
    }

    public static int d(h.a aVar) {
        int i2 = 0;
        if (aVar.iLV) {
            i2 = 2;
        }
        if (aVar.iLW) {
            i2 |= 1;
        }
        if (aVar.iLX) {
            return i2 | 4;
        }
        return i2;
    }

    public static String b(boolean z, String str, int i2) {
        AppMethodBeat.i(42975);
        if (z && str != null && i2 == 0) {
            str = Kt(str);
        }
        AppMethodBeat.o(42975);
        return str;
    }

    public static long l(String str, long j2, long j3) {
        long j4;
        ca aM;
        AppMethodBeat.i(42976);
        long j5 = j2 * 1000;
        long j6 = 0;
        long j7 = -1;
        if (str != null) {
            ca aEx = ((l) g.af(l.class)).eiy().aEx(str);
            if (aEx != null) {
                j6 = aEx.field_createTime;
            }
            j7 = ((l) g.af(l.class)).eiy().aEP(str);
        }
        if (j7 == j6) {
            if (j5 == j6) {
                long j8 = j5 + 1;
                AppMethodBeat.o(42976);
                return j8;
            }
            AppMethodBeat.o(42976);
            return j5;
        } else if (j7 >= j6) {
            Log.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", Long.valueOf(j7), Long.valueOf(j6), Long.valueOf(j5));
            AppMethodBeat.o(42976);
            return j5;
        } else if (j5 == j7) {
            long j9 = j5 - 1;
            AppMethodBeat.o(42976);
            return j9;
        } else if (j5 == j6) {
            long j10 = j5 + 1;
            AppMethodBeat.o(42976);
            return j10;
        } else if (j3 == 0 || j5 > j6) {
            AppMethodBeat.o(42976);
            return j5;
        } else {
            ca aL = ((l) g.af(l.class)).eiy().aL(str, j5);
            if (!(aL.field_msgSeq == 0 || aL.field_msgSeq == j3)) {
                Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", Long.valueOf(aL.field_msgSeq), Long.valueOf(j3), Long.valueOf(aL.field_createTime), Long.valueOf(j5));
                if (j3 < aL.field_msgSeq) {
                    aM = ((l) g.af(l.class)).eiy().aN(str, j5 - 1000);
                } else {
                    aM = ((l) g.af(l.class)).eiy().aM(str, 1000 + j5);
                }
                if (aM.field_msgSeq == 0 || aM.field_msgSeq == j3) {
                    Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", Long.valueOf(aL.field_msgSeq), Long.valueOf(j3), Long.valueOf(aL.field_createTime), Long.valueOf(j5));
                } else {
                    j4 = aM.field_msgSeq < j3 ? aM.field_createTime + 1 : aM.field_createTime - 1;
                    Log.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", Long.valueOf(aL.field_msgSeq), Long.valueOf(aM.field_msgSeq), Long.valueOf(j3), Long.valueOf(aL.field_createTime), Long.valueOf(aM.field_createTime), Long.valueOf(j4));
                    AppMethodBeat.o(42976);
                    return j4;
                }
            }
            j4 = j5;
            AppMethodBeat.o(42976);
            return j4;
        }
    }

    public static String Kq(String str) {
        AppMethodBeat.i(42950);
        int Kr = Kr(str);
        if (Kr != -1) {
            String trim = str.substring(Kr + 1).trim();
            AppMethodBeat.o(42950);
            return trim;
        }
        AppMethodBeat.o(42950);
        return str;
    }
}
