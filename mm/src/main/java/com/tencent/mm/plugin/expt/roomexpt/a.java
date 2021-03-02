package com.tencent.mm.plugin.expt.roomexpt;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ad;
import com.tencent.mm.g.b.a.hl;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements c, d {
    private static final float[] sKA = {0.0f, 0.3f, 0.5f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static final float[] sKB = {0.0f, 0.3f, 0.45f, 0.55f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static final float[] sKC = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final int[] sKD = {2400, 7500, 13000, 21500, 41000, 65000, 116000, 215000, 455000};
    private static final float[] sKE = {0.0f, 0.35f, 0.5f, 0.6f, 0.7f, 0.7f, 0.8f, 0.8f, 0.8f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 0.9f, 1.0f};
    private static a sKF;
    private static final float[] sKw = {0.0f, 0.3f, 0.45f, 0.55f, 0.67f, 0.75f, 0.85f, 1.0f};
    private static final float[] sKx = {0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.2f, 0.3f, 0.4f};
    private static final float[] sKy = {0.0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private static final int[] sKz = {15, 35, 83, 140, 209, i.CTRL_INDEX, 417, 599, 926, 1720};
    private SimpleDateFormat kxO = null;
    public b sKG;
    private hl sKH;
    private String[] sKI;
    private boolean sKJ = false;
    int sKK = 0;
    private z sKL = new z() {
        /* class com.tencent.mm.plugin.expt.roomexpt.a.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.z
        public final void aQ(Object obj) {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.z
        public final void aS(Object obj) {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.z
        public final void aR(Object obj) {
            LinkedList<abn> linkedList;
            AppMethodBeat.i(122398);
            if (obj instanceof k) {
                MMHandlerThread aAk = g.aAk();
                String str = ((k) obj).TAG;
                r rVar = ((k) obj).jda;
                k kVar = (k) obj;
                if (kVar.jdi == null || kVar.jdi.KAh.Ley == null) {
                    linkedList = null;
                } else {
                    linkedList = kVar.jdi.KAh.Ley.oTA;
                }
                aAk.postToWorker(new RunnableC1029a(str, rVar, linkedList));
            }
            AppMethodBeat.o(122398);
        }
    };

    public a() {
        AppMethodBeat.i(122400);
        AppMethodBeat.o(122400);
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(122416);
        aVar.cRA();
        AppMethodBeat.o(122416);
    }

    static /* synthetic */ List d(a aVar) {
        AppMethodBeat.i(122417);
        List<c> cRB = aVar.cRB();
        AppMethodBeat.o(122417);
        return cRB;
    }

    static /* synthetic */ boolean u(long j2, int i2) {
        if (i2 <= 0 && j2 <= 5000) {
            return true;
        }
        return false;
    }

    public static a cRz() {
        AppMethodBeat.i(122401);
        if (sKF == null) {
            sKF = new a();
        }
        a aVar = sKF;
        AppMethodBeat.o(122401);
        return aVar;
    }

    private void cRA() {
        AppMethodBeat.i(122402);
        if (this.sKH == null) {
            AppMethodBeat.o(122402);
            return;
        }
        g.aAh().azQ().set(ar.a.USERINFO_ROOM_EXPT_INFO_STRING, this.sKH.abV());
        Log.i("MicroMsg.ChatRoomExptService", "save expt info[%s]", this.sKH.abW());
        AppMethodBeat.o(122402);
    }

    @Override // com.tencent.mm.plugin.expt.roomexpt.d
    public final void u(Context context, Intent intent) {
        AppMethodBeat.i(122403);
        intent.setClass(context, RoomExptDebugUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/expt/roomexpt/ChatRoomExptService", "showDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/expt/roomexpt/ChatRoomExptService", "showDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(122403);
    }

    @Override // com.tencent.mm.plugin.expt.roomexpt.d
    public final void mr(final boolean z) {
        AppMethodBeat.i(122404);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.expt.roomexpt.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(122394);
                h.INSTANCE.dN(869, z ? 13 : 12);
                AppMethodBeat.o(122394);
            }
        }, "click_room_mute_msg");
        AppMethodBeat.o(122404);
    }

    @Override // com.tencent.mm.plugin.expt.roomexpt.d
    public final void aZ(final String str, final boolean z) {
        AppMethodBeat.i(122405);
        Log.d("MicroMsg.ChatRoomExptService", "enter chat room [%s] isMute[%b]", str, Boolean.valueOf(z));
        if (this.sKK > 0) {
            this.sKK--;
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.expt.roomexpt.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(122395);
                    a.ba(str, z);
                    AppMethodBeat.o(122395);
                }
            });
            AppMethodBeat.o(122405);
        } else if (this.sKI == null || this.sKI.length <= 0) {
            Log.d("MicroMsg.ChatRoomExptService", "roomname list is null");
            AppMethodBeat.o(122405);
        } else if (this.sKH == null) {
            AppMethodBeat.o(122405);
        } else if (this.sKH.eLY >= 5) {
            Log.d("MicroMsg.ChatRoomExptService", "exptInfo is finish [%d]", Long.valueOf(this.sKH.eLY));
            AppMethodBeat.o(122405);
        } else {
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.expt.roomexpt.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(122396);
                    if (!((b) g.af(b.class)).a(b.a.mmchatroom_mute_abtest_flag, a.this.sKH != null ? a.this.sKH.eMb : false)) {
                        AppMethodBeat.o(122396);
                        return;
                    }
                    int min = Math.min(a.this.sKI.length, 5);
                    for (int i2 = 0; i2 < min; i2++) {
                        if (str.equals(a.this.sKI[i2])) {
                            a.ba(str, z);
                            a.this.sKH.eLY = 6;
                            a.this.sKH.vi("");
                            a.c(a.this);
                            AppMethodBeat.o(122396);
                            return;
                        }
                    }
                    AppMethodBeat.o(122396);
                }
            });
            AppMethodBeat.o(122405);
        }
    }

    private static float a(float[] fArr, int[] iArr, long j2) {
        AppMethodBeat.i(122409);
        if (fArr == null || fArr.length <= 0) {
            AppMethodBeat.o(122409);
            return 0.0f;
        } else if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(122409);
            return 0.0f;
        } else {
            int length = fArr.length - 1;
            int min = Math.min(fArr.length, iArr.length);
            int i2 = 0;
            while (true) {
                if (i2 >= min) {
                    i2 = length;
                    break;
                } else if (j2 < ((long) iArr[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            float f2 = fArr[i2];
            AppMethodBeat.o(122409);
            return f2;
        }
    }

    private static float b(float[] fArr, int i2) {
        if (fArr == null || fArr.length <= 0) {
            return 0.0f;
        }
        if (i2 >= fArr.length) {
            return fArr[fArr.length - 1];
        }
        if (i2 <= 0) {
            return fArr[0];
        }
        return fArr[i2];
    }

    private static float b(float f2, int i2, int i3) {
        float f3 = 0.0f;
        AppMethodBeat.i(122410);
        if (i2 <= 0) {
            AppMethodBeat.o(122410);
        } else {
            if (i3 == 1) {
                try {
                    f3 = (((f2 / ((float) i2)) + (f2 / 7.0f)) / 2.0f) - b(sKx, i2);
                } catch (Exception e2) {
                    Log.e("MicroMsg.ChatRoomExptService", "calc finish score error[%s]", e2.toString());
                }
            } else {
                f3 = b(sKw, i2) + (((f2 / ((float) i2)) + (f2 / 7.0f)) / 2.0f);
            }
            Log.d("MicroMsg.ChatRoomExptService", "calc finish score result[%f] day[%d] isMute[%d] score[%f]", Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2));
            AppMethodBeat.o(122410);
        }
        return f3;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0215  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.expt.roomexpt.c> cRB() {
        /*
        // Method dump skipped, instructions count: 560
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.roomexpt.a.cRB():java.util.List");
    }

    /* renamed from: com.tencent.mm.plugin.expt.roomexpt.a$a  reason: collision with other inner class name */
    static class RunnableC1029a implements Runnable {
        private String TAG;
        private final r jda;
        private final LinkedList<abn> sKS;
        private int sKT;

        public RunnableC1029a(String str, r rVar, LinkedList<abn> linkedList) {
            this.TAG = str;
            this.jda = rVar;
            this.sKS = linkedList;
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(122399);
            if (this.jda != null && ((i2 = this.jda.jeB) == 3 || (!this.jda.cQp && (i2 == 1 || i2 == 2 || i2 == 8)))) {
                this.sKT = 0;
                Iterator<abn> it = this.sKS.iterator();
                while (it.hasNext()) {
                    abn next = it.next();
                    byte[] a2 = com.tencent.mm.platformtools.z.a(next.Lmt);
                    if (next.Lms == 5) {
                        try {
                            String dqi = ((de) new de().parseFrom(a2)).KHl.toString();
                            as Kn = ((l) g.af(l.class)).aSN().Kn(dqi);
                            if (dqi.endsWith("@chatroom") && Kn.fuH == 0) {
                                this.sKT++;
                            }
                        } catch (IOException e2) {
                            Log.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + e2.getMessage());
                        }
                    }
                }
                if (this.sKT > 0) {
                    if (this.sKT <= 5) {
                        e.INSTANCE.idkeyStat(202, (long) this.sKT, 1, false);
                    } else if (this.sKT <= 10) {
                        e.INSTANCE.idkeyStat(202, 6, 1, false);
                    } else if (this.sKT <= 15) {
                        e.INSTANCE.idkeyStat(202, 7, 1, false);
                    } else if (this.sKT <= 20) {
                        e.INSTANCE.idkeyStat(202, 8, 1, false);
                    } else {
                        e.INSTANCE.idkeyStat(202, 9, 1, false);
                    }
                    Log.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.sKT);
                    switch (i2) {
                        case 1:
                            e.INSTANCE.idkeyStat(202, 11, 1, false);
                            break;
                        case 2:
                            e.INSTANCE.idkeyStat(202, 12, 1, false);
                            break;
                        case 3:
                            e.INSTANCE.idkeyStat(202, 10, 1, false);
                            break;
                        case 8:
                            e.INSTANCE.idkeyStat(202, 13, 1, false);
                            break;
                    }
                    Log.i(this.TAG, "muteroom idkeyStat:aiScene = ".concat(String.valueOf(i2)));
                }
            }
            AppMethodBeat.o(122399);
        }
    }

    /* access modifiers changed from: protected */
    public final void cRC() {
        AppMethodBeat.i(122412);
        try {
            this.sKG.db.delete("RoomMuteExpt", null, null);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ChatRoomExptStorage", e2, "deleteAll", new Object[0]);
        }
        cRD();
        AppMethodBeat.o(122412);
    }

    /* access modifiers changed from: protected */
    public final void cRD() {
        AppMethodBeat.i(122413);
        if (this.sKH != null) {
            this.sKH = new hl();
            this.sKH.eMb = true;
            cRA();
        }
        this.sKI = null;
        AppMethodBeat.o(122413);
    }

    /* access modifiers changed from: protected */
    public final String cRE() {
        AppMethodBeat.i(122414);
        if (this.sKH != null) {
            String abW = this.sKH.abW();
            AppMethodBeat.o(122414);
            return abW;
        }
        AppMethodBeat.o(122414);
        return "";
    }

    @Override // com.tencent.mm.plugin.expt.roomexpt.d
    public final void a(final String str, final String str2, final long j2, final int i2, final int i3, final boolean z) {
        boolean z2;
        long j3;
        boolean z3;
        AppMethodBeat.i(122406);
        b bVar = (b) g.af(b.class);
        b.a aVar = b.a.mmchatroom_mute_abtest_flag;
        if (this.sKH != null) {
            z2 = this.sKH.eMb;
        } else {
            z2 = false;
        }
        if (!bVar.a(aVar, z2)) {
            z3 = false;
        } else {
            h.INSTANCE.dN(869, 1);
            long j4 = this.sKH.eLY;
            if (j4 >= 3) {
                Log.d("MicroMsg.ChatRoomExptService", "room expt already finish");
                z3 = false;
            } else {
                boolean z4 = j4 == 0;
                if (z) {
                    j3 = 1 | j4;
                } else {
                    j3 = 2 | j4;
                }
                this.sKH.eLY = j3;
                if (j3 >= 3) {
                    Log.d("MicroMsg.ChatRoomExptService", "user already enter mute room and unmute room, don't expt");
                    h.INSTANCE.dN(869, 2);
                    cRA();
                    z3 = false;
                } else {
                    if (z4) {
                        if (this.sKH.eLZ <= 0) {
                            this.sKH.agZ();
                        }
                        cRA();
                    }
                    z3 = true;
                }
            }
        }
        if (!z3) {
            AppMethodBeat.o(122406);
            return;
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.expt.roomexpt.a.AnonymousClass4 */

            public final void run() {
                int i2;
                int i3;
                int i4;
                boolean z;
                boolean b2;
                int i5;
                int i6;
                int i7;
                AppMethodBeat.i(122397);
                long currentTicks = Util.currentTicks();
                long nowSecond = Util.nowSecond();
                if (a.this.sKH.eLZ <= 0) {
                    a.this.sKH.agZ();
                    a.c(a.this);
                } else if (nowSecond - a.this.sKH.eLZ >= 604800) {
                    a.d(a.this);
                    AppMethodBeat.o(122397);
                    return;
                }
                String e2 = a.e(a.this);
                boolean u = a.u(j2, i3);
                e gz = a.this.sKG.gz(str, e2);
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = e2;
                objArr[2] = gz != null ? gz : BuildConfig.COMMAND;
                Log.i("MicroMsg.ChatRoomExptService", "get db [%s %s] item [%s]", objArr);
                if (gz != null) {
                    gz.field_sendCount += i3;
                    gz.field_unReadCount += i2;
                    int i8 = gz.field_disRedDotCount;
                    if (u) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    gz.field_disRedDotCount = i5 + i8;
                    int i9 = gz.field_enterCount;
                    if (u) {
                        i6 = 0;
                    } else {
                        i6 = 1;
                    }
                    gz.field_enterCount = i6 + i9;
                    gz.field_stayTime += j2;
                    if (z) {
                        i7 = 1;
                    } else {
                        i7 = 0;
                    }
                    gz.field_isMute = i7;
                    z = true;
                } else {
                    gz = new e();
                    gz.field_chatroom = str;
                    gz.field_nickname = str2;
                    gz.field_daySec = e2;
                    gz.field_sendCount = i3;
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    gz.field_isMute = i2;
                    gz.field_unReadCount = i2;
                    if (u) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    gz.field_disRedDotCount = i3;
                    if (u) {
                        i4 = 0;
                    } else {
                        i4 = 1;
                    }
                    gz.field_enterCount = i4;
                    gz.field_stayTime = j2;
                    z = false;
                }
                a.a(gz);
                if (z) {
                    b2 = a.this.sKG.c(gz);
                } else {
                    b2 = a.this.sKG.b(gz);
                }
                if (!b2) {
                    h.INSTANCE.dN(869, 32);
                }
                Log.i("MicroMsg.ChatRoomExptService", "noteroominfo isUpdate[%b] dbOpRet[%b] cost[%d] item[%s]", Boolean.valueOf(z), Boolean.valueOf(b2), Long.valueOf(Util.ticksToNow(currentTicks)), gz);
                AppMethodBeat.o(122397);
            }
        });
        AppMethodBeat.o(122406);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(122407);
        if (this.sKH == null) {
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_ROOM_EXPT_INFO_STRING, "");
            if (Util.isNullOrNil(str)) {
                this.sKH = new hl();
                this.sKH.eMb = false;
            } else {
                this.sKH = new hl(str);
                if (!Util.isNullOrNil(this.sKH.eMa)) {
                    this.sKI = this.sKH.eMa.split(";");
                }
            }
            Log.i("MicroMsg.ChatRoomExptService", "load expt roomnameList[%s] info[%s]", this.sKI, this.sKH.abW());
        }
        com.tencent.mm.plugin.messenger.foundation.a.k kVar = (com.tencent.mm.plugin.messenger.foundation.a.k) g.af(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        if (kVar != null) {
            kVar.addSyncDoCmdCallback(this.sKL);
        }
        AppMethodBeat.o(122407);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(122408);
        this.sKH = null;
        this.sKG = null;
        com.tencent.mm.plugin.messenger.foundation.a.k kVar = (com.tencent.mm.plugin.messenger.foundation.a.k) g.af(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        if (kVar != null) {
            kVar.removeSyncDoCmdCallback(this.sKL);
        }
        AppMethodBeat.o(122408);
    }

    static /* synthetic */ void ba(String str, boolean z) {
        String string;
        String string2;
        int i2;
        AppMethodBeat.i(122415);
        if (z) {
            string = MMApplicationContext.getResources().getString(R.string.awp);
            string2 = MMApplicationContext.getResources().getString(R.string.awm);
        } else {
            string = MMApplicationContext.getResources().getString(R.string.awn);
            string2 = MMApplicationContext.getResources().getString(R.string.awo);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<sysmsg type=\"chatroommuteexpt\">");
        stringBuffer.append("<chatroommuteexpt>");
        stringBuffer.append("<text><![CDATA[").append(string).append("]]></text>");
        stringBuffer.append("<link>");
        stringBuffer.append("<scene>chatroommuteexpt</scene>");
        stringBuffer.append("<text><![CDATA[").append(string2).append("]]></text>");
        stringBuffer.append("</link>");
        stringBuffer.append("</chatroommuteexpt>");
        stringBuffer.append("</sysmsg>");
        ca caVar = new ca();
        caVar.Cy(str);
        caVar.nv(2);
        caVar.setType(10002);
        caVar.setCreateTime(bp.aVP());
        caVar.setContent(stringBuffer.toString());
        bp.x(caVar);
        h hVar = h.INSTANCE;
        if (z) {
            i2 = 11;
        } else {
            i2 = 10;
        }
        hVar.dN(869, i2);
        AppMethodBeat.o(122415);
    }

    static /* synthetic */ String e(a aVar) {
        AppMethodBeat.i(122418);
        if (aVar.kxO == null) {
            aVar.kxO = new SimpleDateFormat("yyyyMMdd");
        }
        String format = aVar.kxO.format(new Date(Util.nowMilliSecond()));
        AppMethodBeat.o(122418);
        return format;
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(122419);
        try {
            if (eVar.field_isMute == 0) {
                float a2 = a(sKy, sKz, (long) eVar.field_unReadCount);
                float b2 = b(sKB, eVar.field_disRedDotCount);
                eVar.field_score = ((a2 + b2) - b(sKA, eVar.field_enterCount)) - a(sKC, sKD, eVar.field_stayTime);
            } else {
                float b3 = b(sKE, eVar.field_sendCount);
                float b4 = b(sKA, eVar.field_enterCount);
                eVar.field_score = ((b3 + b4) + a(sKC, sKD, eVar.field_stayTime)) - b(sKB, eVar.field_disRedDotCount);
            }
            ad adVar = new ad();
            adVar.enA = adVar.x("ChatroomName", eVar.field_chatroom, true);
            adVar.enD = eVar.field_isMute;
            adVar.enE = (long) eVar.field_unReadCount;
            adVar.enF = (long) eVar.field_disRedDotCount;
            adVar.enG = (long) eVar.field_enterCount;
            ad bX = adVar.bX(eVar.field_stayTime);
            bX.enI = (long) eVar.field_sendCount;
            bX.enJ = bX.x("Score", new StringBuilder().append(eVar.field_score).toString(), true);
            adVar.bfK();
            AppMethodBeat.o(122419);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChatRoomExptService", "calcOneScore error[%s]", e2.toString());
            AppMethodBeat.o(122419);
        }
    }
}
