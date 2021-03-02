package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.g.l;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMConditionVariable;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class c {
    private int oIY;
    public boolean oJN = false;
    b.AbstractC0832b oJO;
    d oJP;
    long oJQ = 0;
    public long oJR = 0;

    public c(d dVar, int i2, b.AbstractC0832b bVar) {
        this.oJP = dVar;
        this.oIY = i2;
        this.oJO = bVar;
        this.oJN = false;
    }

    public final void cancel() {
        AppMethodBeat.i(21251);
        Log.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", MMStack.getCaller());
        this.oJN = true;
        AppMethodBeat.o(21251);
    }

    public final long cfe() {
        return this.oJQ / 1024;
    }

    public final void jy(boolean z) {
        AppMethodBeat.i(21252);
        Log.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
        if (this.oIY == 1) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.FALSE);
        } else if (this.oIY == 2) {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_MOVE_BACKUPING_BOOLEAN, Boolean.FALSE);
        }
        SharedPreferences.Editor edit = d.ceR().edit();
        edit.putString("BACKUP_PC_CHOOSE_SESSION", null);
        if (z) {
            if (this.oIY == 1) {
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
            } else if (this.oIY == 2) {
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            }
        }
        edit.commit();
        AppMethodBeat.o(21252);
    }

    public final void cff() {
        AppMethodBeat.i(21253);
        Log.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
        com.tencent.mm.plugin.backup.i.d dVar = new com.tencent.mm.plugin.backup.i.d();
        dVar.ID = this.oJP.oIU;
        try {
            com.tencent.mm.plugin.backup.g.b.N(dVar.toByteArray(), 8);
            AppMethodBeat.o(21253);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BackupPackAndSend", e2, "BackupFinishRequest to buf err.", new Object[0]);
            AppMethodBeat.o(21253);
        }
    }

    public final void a(final LinkedList<f.a> linkedList, final long j2, final boolean z) {
        AppMethodBeat.i(21254);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Long.valueOf(j2);
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", objArr);
        h.RTc.ba(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.backup.c.c.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "backupPackThread";
            }

            public final void run() {
                int size;
                AppMethodBeat.i(21232);
                if (linkedList == null) {
                    Log.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
                    if (c.this.oJO != null) {
                        c.this.oJO.ceJ();
                        c.this.oJP.ceM().oJc = -21;
                        c.this.oJO.Ba(-21);
                    }
                    AppMethodBeat.o(21232);
                    return;
                }
                com.tencent.mm.plugin.backup.g.b.cgu();
                LinkedList linkedList = linkedList;
                HashSet hashSet = new HashSet();
                if (linkedList == null) {
                    size = 0;
                } else {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        hashSet.add(((f.a) it.next()).oJo);
                    }
                    size = hashSet.size();
                }
                c.this.oJP.ceM().S(14, 1, size);
                c.this.oJO.Ba(14);
                String str = (String) com.tencent.mm.plugin.backup.h.d.cgP().cgQ().azQ().get(2, (Object) null);
                c.this.oJR = Util.nowMilliSecond();
                C0843c cVar = new C0843c();
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    c.this.a((f.a) it2.next(), cVar, str, j2, z);
                    if (c.this.oJN) {
                        break;
                    }
                }
                if (c.this.oJN) {
                    Log.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
                    AppMethodBeat.o(21232);
                    return;
                }
                long nowMilliSecond = Util.nowMilliSecond();
                long nowMilliSecond2 = Util.nowMilliSecond();
                cVar.oKu.offer(cVar.oKv);
                cVar.oKv.block();
                Log.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond2)));
                Assert.assertTrue(cVar.oKu.isEmpty());
                Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", Integer.valueOf(linkedList.size()), Long.valueOf(Util.milliSecondsToNow(c.this.oJR)), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                c.this.cff();
                c.this.oJP.ceM().S(15, size, size);
                c.this.oJO.Ba(15);
                c.this.jy(true);
                com.tencent.mm.plugin.backup.g.b.cgt();
                com.tencent.mm.plugin.backup.g.b.cgv();
                c.this.oJO.ceI();
                Log.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", Long.valueOf(c.this.oJQ), Long.valueOf(Util.milliSecondsToNow(c.this.oJR)), Long.valueOf(c.this.oJR));
                AppMethodBeat.o(21232);
            }
        });
        AppMethodBeat.o(21254);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01f9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.backup.b.f.a r29, com.tencent.mm.plugin.backup.c.c.C0843c r30, java.lang.String r31, long r32, boolean r34) {
        /*
        // Method dump skipped, instructions count: 682
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.c.c.a(com.tencent.mm.plugin.backup.b.f$a, com.tencent.mm.plugin.backup.c.c$c, java.lang.String, long, boolean):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.backup.c.c$c  reason: collision with other inner class name */
    public class C0843c {
        a oKa = new a(c.this, (byte) 0);
        LinkedBlockingQueue<Object> oKu = new LinkedBlockingQueue<>();
        MMConditionVariable oKv = new MMConditionVariable();
        b oKw = null;
        private Runnable oKx = new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.backup.c.c.C0843c.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "tagRunnable";
            }

            public final void run() {
                String str;
                int i2;
                int i3;
                AppMethodBeat.i(21249);
                while (!c.this.oJN) {
                    Object obj = null;
                    try {
                        obj = C0843c.this.oKu.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e2) {
                    }
                    Log.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", Integer.valueOf(C0843c.this.oKu.size()), obj);
                    if (obj != null) {
                        if (obj == C0843c.this.oKv) {
                            C0843c.this.oKv.open();
                            AppMethodBeat.o(21249);
                            return;
                        }
                        b bVar = (b) obj;
                        bVar.liJ = true;
                        StringBuilder sb = new StringBuilder("MicroMsg.BackupPackAndSend.tag");
                        if (bVar.liJ) {
                            str = "S.";
                        } else {
                            str = "W.";
                        }
                        bVar.TAG = sb.append(str).append(bVar.oJp).append(".").append(bVar.nickName).toString();
                        while (!c.this.oJN) {
                            Runnable runnable = null;
                            try {
                                runnable = bVar.oJZ.poll(500, TimeUnit.MILLISECONDS);
                            } catch (Exception e3) {
                            }
                            if (runnable != null) {
                                long nowMilliSecond = Util.nowMilliSecond();
                                runnable.run();
                                Object[] objArr = new Object[6];
                                objArr[0] = Integer.valueOf(bVar.oJZ.size());
                                long j2 = C0843c.this.oKa.oJW.get();
                                Object[] objArr2 = new Object[3];
                                objArr2[0] = Long.valueOf(j2);
                                if (j2 >= 8388608) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                objArr2[1] = Integer.valueOf(i2);
                                if (j2 >= 16777216) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                objArr2[2] = Integer.valueOf(i3);
                                objArr[1] = String.format("[%s,%s,%s]", objArr2);
                                objArr[2] = Long.valueOf(Util.milliSecondsToNow(nowMilliSecond));
                                objArr[3] = runnable;
                                objArr[4] = bVar;
                                objArr[5] = C0843c.this.oKw;
                                Log.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s]", objArr);
                                if (!bVar.liJ) {
                                    break;
                                }
                            }
                        }
                        System.gc();
                    }
                }
                AppMethodBeat.o(21249);
            }
        };

        public C0843c() {
            AppMethodBeat.i(21250);
            h.RTc.ba(this.oKx);
            AppMethodBeat.o(21250);
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        String TAG;
        boolean liJ;
        String nickName;
        LinkedBlockingQueue<Runnable> oJZ;
        int oJp;
        long oJr;
        long oJs;
        a oKa;
        private long oKb;
        String oKc;
        Vector<String> oKd;
        private Vector<is> oKe;
        HashMap<Long, h.a> oKf;
        long oKg;
        private final c.b oKh;
        private final Runnable oKi;
        final Runnable oKj;
        String talker;

        public final String toString() {
            return this.TAG;
        }

        public b(a aVar, f.a aVar2) {
            String displayName;
            AppMethodBeat.i(21245);
            this.TAG = "";
            this.oJZ = new LinkedBlockingQueue<>();
            this.oJr = 0;
            this.oJs = 0;
            this.oKb = 0;
            this.oKc = "";
            this.oKd = new Vector<>();
            this.oKe = new Vector<>();
            this.oKf = new HashMap<>();
            this.oKg = 0;
            this.liJ = false;
            this.oKh = new c.b() {
                /* class com.tencent.mm.plugin.backup.c.c.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.backup.g.c.b
                public final void g(boolean z, String str, int i2) {
                    AppMethodBeat.i(21234);
                    a aVar = b.this.oKa;
                    long j2 = (long) i2;
                    aVar.oJW.addAndGet(0 - j2);
                    if (aVar.oJW.get() < 8388608) {
                        aVar.oJX.open();
                    }
                    if (aVar.oJW.get() < 16777216) {
                        aVar.oJY.open();
                    }
                    Object[] objArr = new Object[6];
                    objArr[0] = Long.valueOf(j2);
                    objArr[1] = Long.valueOf(aVar.oJW.get());
                    objArr[2] = Boolean.valueOf(aVar.oJW.get() >= 8388608);
                    objArr[3] = Boolean.valueOf(aVar.oJW.get() >= 16777216);
                    objArr[4] = Boolean.valueOf(aVar.oJX.isOpen());
                    objArr[5] = Boolean.valueOf(aVar.oJY.isOpen());
                    Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.release size:%d sum:%d [%b,%b] [%b,%b]", objArr);
                    c.this.oJQ += (long) i2;
                    Log.i(b.this.TAG, "OnfinishIdCallback size[%d], isIdFinish[%b], id[%s] ", Integer.valueOf(i2), Boolean.valueOf(z), str);
                    AppMethodBeat.o(21234);
                }
            };
            this.oKi = new Runnable() {
                /* class com.tencent.mm.plugin.backup.c.c.b.AnonymousClass3 */

                public final String toString() {
                    AppMethodBeat.i(21240);
                    String str = b.this.TAG + ".reqBigFile";
                    AppMethodBeat.o(21240);
                    return str;
                }

                public final void run() {
                    boolean z = true;
                    AppMethodBeat.i(21241);
                    Assert.assertTrue(toString() + ", check running. ", b.this.liJ);
                    Log.i(b.this.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", Integer.valueOf(b.this.oKf.size()), Long.valueOf(Util.milliSecondsToNow(b.this.oKg)), MMStack.getCaller());
                    if (b.this.oKf.isEmpty()) {
                        z = false;
                    }
                    Assert.assertTrue("BigFileMap should not Empty", z);
                    new l(b.this.talker, b.this.oKf, new l.a() {
                        /* class com.tencent.mm.plugin.backup.c.c.b.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.backup.g.l.a
                        public final void E(final LinkedList<Long> linkedList) {
                            AppMethodBeat.i(21239);
                            com.tencent.f.h.RTc.ba(new com.tencent.f.i.h() {
                                /* class com.tencent.mm.plugin.backup.c.c.b.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                                public final String getKey() {
                                    return "AddBigFileToQueue";
                                }

                                public final void run() {
                                    AppMethodBeat.i(21238);
                                    int i2 = 0;
                                    while (linkedList != null && i2 < linkedList.size()) {
                                        Long l = (Long) linkedList.get(i2);
                                        h.a aVar = b.this.oKf.get(l);
                                        String str = b.this.TAG;
                                        Object[] objArr = new Object[5];
                                        objArr[0] = Integer.valueOf(i2);
                                        objArr[1] = Integer.valueOf(linkedList.size());
                                        objArr[2] = l;
                                        objArr[3] = aVar == null ? BuildConfig.COMMAND : aVar.oNI.mediaId;
                                        objArr[4] = aVar == null ? BuildConfig.COMMAND : aVar.oNI.path;
                                        Log.i(str, "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s", objArr);
                                        if (aVar != null) {
                                            b.this.oKd.add(aVar.oNI.mediaId);
                                            b.this.m(aVar.oNI.mediaId, aVar.oNI.path, true);
                                        }
                                        i2++;
                                    }
                                    b.this.oJZ.offer(b.this.oKj);
                                    AppMethodBeat.o(21238);
                                }
                            });
                            AppMethodBeat.o(21239);
                        }
                    }).cgA();
                    AppMethodBeat.o(21241);
                }
            };
            this.oKj = new Runnable() {
                /* class com.tencent.mm.plugin.backup.c.c.b.AnonymousClass4 */

                public final String toString() {
                    AppMethodBeat.i(21243);
                    String str = b.this.TAG + ".sendTag";
                    AppMethodBeat.o(21243);
                    return str;
                }

                public final void run() {
                    AppMethodBeat.i(21244);
                    Assert.assertTrue(toString() + ", check running. ", b.this.liJ);
                    switch (d.ceP()) {
                        case 1:
                            Log.i(b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", Integer.valueOf(c.this.oJP.ceM().oJd), Long.valueOf(b.this.oJr), Long.valueOf(b.this.oJs), Integer.valueOf(b.this.oKd.size()), b.this.nickName, b.this.oKc, Long.valueOf(Util.milliSecondsToNow(b.this.oKg)));
                            if (c.this.oJP.ceM().oJd < b.this.oJp + 1) {
                                int i2 = c.this.oJP.ceM().oJe;
                                e ceM = c.this.oJP.ceM();
                                if (b.this.oJp + 1 <= i2) {
                                    i2 = b.this.oJp + 1;
                                }
                                ceM.oJd = i2;
                                c.this.oJO.Ba(c.this.oJP.ceM().oJc);
                                break;
                            }
                            break;
                        case 21:
                        case 22:
                            Log.i(b.this.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", Integer.valueOf(c.this.oJP.ceM().oJd), Long.valueOf(b.this.oJr), Long.valueOf(b.this.oJs), Integer.valueOf(b.this.oKd.size()), b.this.nickName, b.this.oKc, Long.valueOf(Util.milliSecondsToNow(b.this.oKg)));
                            if (c.this.oJP.ceM().oJd < b.this.oJp + 1) {
                                int i3 = c.this.oJP.ceM().oJe;
                                e ceM2 = c.this.oJP.ceM();
                                if (b.this.oJp + 1 <= i3) {
                                    i3 = b.this.oJp + 1;
                                }
                                ceM2.oJd = i3;
                                c.this.oJO.Ba(c.this.oJP.ceM().oJc);
                                break;
                            }
                            break;
                    }
                    final boolean z = b.this.oJp == c.this.oJP.ceM().oJe + -1;
                    final MMConditionVariable mMConditionVariable = new MMConditionVariable(!z);
                    new com.tencent.mm.plugin.backup.g.d(b.this.talker, b.this.oJr, b.this.oJs, b.this.oKc, b.this.nickName, new LinkedList(b.this.oKd), new i() {
                        /* class com.tencent.mm.plugin.backup.c.c.b.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(21242);
                            String str2 = ((com.tencent.mm.plugin.backup.g.d) qVar).oPI.oUI;
                            Log.i(b.this.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", Boolean.valueOf(z), mMConditionVariable, Integer.valueOf(i2), Integer.valueOf(i3), str, b.this.oKc, str2);
                            if (z && b.this.oKc.equals(str2)) {
                                mMConditionVariable.open();
                            }
                            AppMethodBeat.o(21242);
                        }
                    }).cgA();
                    if (z) {
                        Log.w(b.this.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", Integer.valueOf(b.this.oJp), Integer.valueOf(c.this.oJP.ceM().oJe - 1));
                        mMConditionVariable.block();
                    }
                    b.this.liJ = false;
                    AppMethodBeat.o(21244);
                }
            };
            this.oKg = Util.nowMilliSecond();
            this.oKa = aVar;
            this.talker = aVar2.oJo;
            this.oJp = aVar2.oJp;
            if (ab.Eq(this.talker)) {
                displayName = aa.getDisplayName(this.talker, this.talker);
            } else {
                displayName = aa.getDisplayName(this.talker);
            }
            this.nickName = displayName;
            this.TAG = "MicroMsg.BackupPackAndSend.tag." + (this.liJ ? "S." : "W.") + this.oJp + "." + this.nickName;
            Log.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", Integer.valueOf(this.oJp), this.nickName, this.talker, MMStack.getCaller());
            AppMethodBeat.o(21245);
        }

        public final boolean a(is isVar, long j2, long j3, LinkedList<u> linkedList, HashMap<Long, h.a> hashMap) {
            AppMethodBeat.i(21246);
            this.oKe.add(isVar);
            this.oKb = (j2 > 0 ? j2 : 0) + this.oKb;
            if (this.oJr == 0) {
                this.oJr = j3;
            }
            this.oJs = j3;
            this.oKf.putAll(hashMap);
            Iterator<u> it = linkedList.iterator();
            while (it.hasNext()) {
                u next = it.next();
                m(next.mediaId, next.path, false);
            }
            Log.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", Long.valueOf(this.oJr), Long.valueOf(this.oJs), Long.valueOf(j2), Long.valueOf(this.oKb), Integer.valueOf(this.oKe.size()), Integer.valueOf(linkedList.size()), Long.valueOf(Util.milliSecondsToNow(this.oKg)));
            if (this.oKb > 83886080 || this.oKe.size() > 80) {
                cfg();
                AppMethodBeat.o(21246);
                return true;
            }
            AppMethodBeat.o(21246);
            return false;
        }

        public final void cfg() {
            AppMethodBeat.i(21247);
            this.oKc = "MSG_" + this.oKe.size() + "_" + this.talker + "_" + Util.nowMilliSecond();
            Log.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", Long.valueOf(this.oJr), Long.valueOf(this.oJs), Long.valueOf(this.oKb), Integer.valueOf(this.oKe.size()), Integer.valueOf(this.oKf.size()), this.oKc, Long.valueOf(Util.milliSecondsToNow(this.oKg)));
            if (this.oKe.size() > 0) {
                m(this.oKc, null, false);
                if (this.oKf.isEmpty()) {
                    this.oJZ.offer(this.oKj);
                    AppMethodBeat.o(21247);
                    return;
                }
                this.oJZ.offer(this.oKi);
                AppMethodBeat.o(21247);
                return;
            }
            Log.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", Integer.valueOf(this.oKe.size()), Integer.valueOf(this.oKd.size()), Integer.valueOf(this.oKf.size()));
            Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.oKe.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.oKd.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.oKf.isEmpty());
            this.oJZ.offer(this.oKj);
            AppMethodBeat.o(21247);
        }

        /* access modifiers changed from: package-private */
        public final void m(String str, String str2, boolean z) {
            boolean z2 = true;
            AppMethodBeat.i(21248);
            AnonymousClass2 r2 = new c.AbstractC0848c() {
                /* class com.tencent.mm.plugin.backup.c.c.b.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.backup.g.c.AbstractC0848c
                public final void a(final com.tencent.mm.plugin.backup.g.c cVar) {
                    AppMethodBeat.i(21237);
                    final long nowMilliSecond = Util.nowMilliSecond();
                    a aVar = b.this.oKa;
                    long cgH = (long) cVar.cgH();
                    boolean z = b.this.liJ;
                    Object[] objArr = new Object[5];
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Long.valueOf(cgH);
                    objArr[2] = Long.valueOf(aVar.oJW.get());
                    objArr[3] = Boolean.valueOf(aVar.oJW.get() >= 8388608);
                    objArr[4] = Boolean.valueOf(aVar.oJW.get() >= 16777216);
                    Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid %b inSize:%d sum:%d  [%b,%b]", objArr);
                    if (aVar.oJW.get() + cgH >= 8388608) {
                        aVar.oJX.close();
                    }
                    if (aVar.oJW.get() >= 16777216) {
                        aVar.oJY.close();
                    }
                    long nowMilliSecond2 = Util.nowMilliSecond();
                    while (true) {
                        if (c.this.oJN) {
                            break;
                        }
                        if (aVar.oJW.get() < (z ? 16777216 : 8388608)) {
                            aVar.oJW.addAndGet(cgH);
                            Object[] objArr2 = new Object[6];
                            objArr2[0] = Long.valueOf(Util.milliSecondsToNow(nowMilliSecond2));
                            objArr2[1] = Boolean.valueOf(z);
                            objArr2[2] = Long.valueOf(cgH);
                            objArr2[3] = Long.valueOf(aVar.oJW.get());
                            objArr2[4] = Boolean.valueOf(aVar.oJW.get() >= 8388608);
                            objArr2[5] = Boolean.valueOf(aVar.oJW.get() >= 16777216);
                            Log.v("MicroMsg.BackupPackAndSend", "MemoryChecker.waitMemoryValid Out:%d %b inSize:%d sum:%d  [%b,%b]", objArr2);
                        } else {
                            (z ? aVar.oJY : aVar.oJX).block(500);
                        }
                    }
                    b.this.oJZ.offer(new Runnable() {
                        /* class com.tencent.mm.plugin.backup.c.c.b.AnonymousClass2.AnonymousClass1 */

                        public final String toString() {
                            AppMethodBeat.i(21235);
                            String str = b.this.TAG + ".sendFile";
                            AppMethodBeat.o(21235);
                            return str;
                        }

                        public final void run() {
                            AppMethodBeat.i(21236);
                            Assert.assertTrue(toString() + ", check running. ", b.this.liJ);
                            long nowMilliSecond = Util.nowMilliSecond();
                            cVar.cgA();
                            long nowMilliSecond2 = Util.nowMilliSecond();
                            Log.i(b.this.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", Integer.valueOf(cVar.cgH()), Long.valueOf(nowMilliSecond2 - nowMilliSecond), Long.valueOf(nowMilliSecond2 - nowMilliSecond), cVar.oPz.oUz);
                            AppMethodBeat.o(21236);
                        }
                    });
                    AppMethodBeat.o(21237);
                }
            };
            Log.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", Boolean.valueOf(z), Integer.valueOf(this.oKe.size()), str, str2);
            if (!TextUtils.isEmpty(str2)) {
                this.oKd.add(str);
                if (str != null) {
                    com.tencent.mm.plugin.backup.g.c.a(this.oKh, r2, str, str2, c.this.oJP.oJa);
                    AppMethodBeat.o(21248);
                    return;
                }
            } else {
                if (this.oKe.isEmpty()) {
                    z2 = false;
                }
                Assert.assertTrue("chatMsgList should not empty", z2);
                if (str != null) {
                    com.tencent.mm.plugin.backup.g.c.a(this.oKh, r2, str, new LinkedList(this.oKe), c.this.oJP.oJa);
                }
            }
            AppMethodBeat.o(21248);
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        volatile AtomicLong oJW;
        MMConditionVariable oJX;
        MMConditionVariable oJY;

        private a() {
            AppMethodBeat.i(21233);
            this.oJW = new AtomicLong(0);
            this.oJX = new MMConditionVariable(true);
            this.oJY = new MMConditionVariable(true);
            AppMethodBeat.o(21233);
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }
    }
}
