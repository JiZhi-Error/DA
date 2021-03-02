package com.tencent.mm.aj;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.f.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public final class d implements i {
    boolean iKb = false;
    Set<String> iKc = Collections.synchronizedSet(new HashSet());
    f<String, C0245d> iKd = new com.tencent.mm.memory.a.c(400);
    Stack<i> iKe = new Stack<>();
    private QueueWorkerThread iKf = null;
    private QueueWorkerThread iKg = null;
    volatile String iKh;
    f<String, String> iKi = new com.tencent.mm.memory.a.c(200);
    MTimerHandler iKj = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.aj.d.AnonymousClass3 */
        private long iKm = 0;

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(150217);
            long currentTimeMillis = System.currentTimeMillis();
            if (d.this.iKb && currentTimeMillis - this.iKm > Util.MILLSECONDS_OF_MINUTE) {
                Log.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", Long.valueOf(currentTimeMillis - this.iKm));
                d.this.iKb = false;
            }
            if (d.this.iKb) {
                d.this.iKj.startTimer(1000);
                AppMethodBeat.o(150217);
            } else {
                this.iKm = currentTimeMillis;
                d.this.iKb = true;
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < 5 && d.this.iKe.size() > 0; i2++) {
                    h.INSTANCE.idkeyStat(138, 42, 1, true);
                    linkedList.add(new dqi().bhy(Util.nullAsNil(d.this.iKe.pop().getUsername())));
                }
                g.azz().a(new k(linkedList), 0);
                h.INSTANCE.idkeyStat(138, 44, 1, true);
                AppMethodBeat.o(150217);
            }
            return false;
        }
    }, false);

    /* renamed from: com.tencent.mm.aj.d$d  reason: collision with other inner class name */
    static class C0245d {
        public long hwQ;
        public int ibG;

        private C0245d() {
            this.hwQ = 0;
            this.ibG = 0;
        }

        /* synthetic */ C0245d(byte b2) {
            this();
        }
    }

    public d() {
        AppMethodBeat.i(150226);
        g.azz().a(123, this);
        this.iKb = false;
        this.iKh = z.aTY();
        AppMethodBeat.o(150226);
    }

    public final Bitmap K(String str, boolean z) {
        AppMethodBeat.i(223531);
        Bitmap b2 = b(str, z, 0, null);
        AppMethodBeat.o(223531);
        return b2;
    }

    public final Bitmap b(String str, boolean z, int i2, b bVar) {
        Bitmap bitmap;
        AppMethodBeat.i(223532);
        e aYn = aYn();
        if (aYn != null) {
            if (i2 < 0 || i2 <= 5) {
                bitmap = null;
            } else {
                bitmap = e.Mk(String.format("%s$$%d", str, Integer.valueOf(i2)));
                if (bitmap != null) {
                    Log.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", Integer.valueOf(i2));
                    AppMethodBeat.o(223532);
                    return bitmap;
                }
                Log.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", Integer.valueOf(i2));
            }
            if (bitmap == null) {
                bitmap = e.Mk(str);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (i2 >= 0 && i2 > 5) {
                Log.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", Integer.valueOf(i2));
                bitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) i2);
                aYn.d(String.format("%s$$%d", str, Integer.valueOf(i2)), bitmap);
            }
            AppMethodBeat.o(223532);
            return bitmap;
        } else if (z) {
            AppMethodBeat.o(223532);
            return null;
        } else {
            Log.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", str);
            if (this.iKc.contains(str)) {
                AppMethodBeat.o(223532);
                return null;
            }
            this.iKc.add(str);
            a(new c(str, bVar));
            AppMethodBeat.o(223532);
            return null;
        }
    }

    public final void Mg(String str) {
        AppMethodBeat.i(150228);
        a(new c(str));
        AppMethodBeat.o(150228);
    }

    public final void Mh(final String str) {
        AppMethodBeat.i(150229);
        com.tencent.f.h.RTc.aX(new j() {
            /* class com.tencent.mm.aj.d.AnonymousClass1 */

            @Override // com.tencent.f.i.j
            public final boolean axI() {
                return false;
            }

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "AvatarService#checkAvatarExpire";
            }

            public final void run() {
                boolean z;
                AppMethodBeat.i(150214);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(150214);
                } else if (str.equals(d.this.iKh)) {
                    Log.i("MicroMsg.AvatarService", "thisUser is empty!!");
                    AppMethodBeat.o(150214);
                } else {
                    j aYo = d.aYo();
                    if (aYo == null) {
                        Log.i("MicroMsg.AvatarService", "istg is null!!");
                        AppMethodBeat.o(150214);
                        return;
                    }
                    i Mx = aYo.Mx(str);
                    if (Mx == null || !Mx.getUsername().equals(str)) {
                        Log.i("MicroMsg.AvatarService", "imgFlag is null or username not equal");
                        AppMethodBeat.o(150214);
                        return;
                    }
                    if (Util.nowSecond() - (((long) Mx.iKZ) * 60) > 86400) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Log.i("MicroMsg.AvatarService", "imgFlag is expired!!");
                        AppMethodBeat.o(150214);
                    } else if (Util.isNullOrNil(Mx.aYu())) {
                        Log.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", str);
                        AppMethodBeat.o(150214);
                    } else {
                        d.this.Mg(str);
                        AppMethodBeat.o(150214);
                    }
                }
            }

            public final String toString() {
                AppMethodBeat.i(150215);
                String str = super.toString() + "|checkAvatarExpire";
                AppMethodBeat.o(150215);
                return str;
            }
        });
        AppMethodBeat.o(150229);
    }

    static i Mi(String str) {
        i iVar;
        AppMethodBeat.i(150230);
        i Mx = p.aYB().Mx(str);
        if (Mx == null || !Mx.getUsername().equals(str)) {
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            if (Kn.fuz == 4) {
                c.ap(str, Kn.fuz);
                Log.d("MicroMsg.AvatarService", "ct imgFlag :%s", Integer.valueOf(Kn.fuz));
                AppMethodBeat.o(150230);
                return null;
            }
            i iVar2 = new i();
            iVar2.username = str;
            iVar2.fuz = 3;
            byte[] bjP = ((l) g.af(l.class)).aSN().bjP(str);
            if (Util.isNullOrNil(bjP)) {
                Log.i("MicroMsg.AvatarService", "[isFlagNeed] cmdBuf is null! username:%s", str);
                AppMethodBeat.o(150230);
                return iVar2;
            }
            try {
                iVar = c.a(str, (cpl) new cpl().parseFrom(bjP));
            } catch (Exception e2) {
                Log.e("MicroMsg.AvatarService", "exception:%s", Util.stackTraceToString(e2));
                iVar = iVar2;
            }
            Log.i("MicroMsg.AvatarService", "[isFlagNeed] finally! getSmallUrl:%s getBigUrl:%s username:%s", iVar.aYu(), iVar.aYt(), str);
            AppMethodBeat.o(150230);
            return iVar;
        }
        Log.i("MicroMsg.AvatarService", "[isFlagNeed] getSmallUrl:%s username:%s", Mx.aYu(), str);
        AppMethodBeat.o(150230);
        return Mx;
    }

    public final void cancel() {
        AppMethodBeat.i(150231);
        while (this.iKe.size() > 0) {
            this.iKc.remove(this.iKe.pop());
        }
        AppMethodBeat.o(150231);
    }

    /* access modifiers changed from: package-private */
    public final int a(final QueueWorkerThread.ThreadObject threadObject) {
        AppMethodBeat.i(150232);
        com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.aj.d.AnonymousClass2 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "AvatarService#putAsyncTask";
            }

            public final void run() {
                AppMethodBeat.i(150216);
                threadObject.doInBackground();
                threadObject.onPostExecute();
                AppMethodBeat.o(150216);
            }
        });
        AppMethodBeat.o(150232);
        return 1;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(150233);
        if (qVar == null) {
            AppMethodBeat.o(150233);
        } else if (qVar.getType() != 123) {
            AppMethodBeat.o(150233);
        } else {
            if (!(i2 == 0 && i3 == 0)) {
                h.INSTANCE.idkeyStat(138, 12, 1, true);
            }
            h.INSTANCE.idkeyStat(138, 45, 1, true);
            try {
                k kVar = (k) qVar;
                HashSet hashSet = new HashSet();
                if (kVar.iLc != null) {
                    Iterator<ccz> it = kVar.iLc.iterator();
                    while (it.hasNext()) {
                        ccz next = it.next();
                        if (next == null || next.MiP == null) {
                            Log.i("MicroMsg.AvatarService", "error p is null or username is null %s", next);
                        } else {
                            String str2 = next.MiP.MTo;
                            if (next.KHp == null || next.KHp.getBuffer() == null || next.KHp.getBuffer().zy == null) {
                                h.INSTANCE.idkeyStat(138, 11, 1, true);
                            } else {
                                hashSet.add(str2);
                                i iVar = new i();
                                iVar.username = str2;
                                iVar.fuz = 3;
                                h.INSTANCE.idkeyStat(138, 43, 1, true);
                                a(new e(iVar, next.KHp.getBuffer().zy));
                            }
                        }
                    }
                }
                if (kVar.iLb != null) {
                    Iterator<dqi> it2 = kVar.iLb.iterator();
                    while (it2.hasNext()) {
                        dqi next2 = it2.next();
                        if (next2 != null) {
                            String str3 = next2.MTo;
                            if (!hashSet.contains(str3)) {
                                this.iKc.remove(str3);
                            }
                        }
                    }
                }
            } catch (NullPointerException e2) {
                Log.e("MicroMsg.AvatarService", "[onSceneEnd] NullPointerException:%s", e2);
            }
            this.iKb = false;
            if (this.iKe.size() > 0) {
                this.iKj.startTimer(0);
            }
            AppMethodBeat.o(150233);
        }
    }

    class b implements QueueWorkerThread.ThreadObject {
        public boolean bGA = false;
        public i iKq = null;
        public byte[] iKr = null;

        public b(i iVar) {
            this.iKq = iVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x0622  */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x062a  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x0632  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x075a  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x0760  */
        /* JADX WARNING: Removed duplicated region for block: B:138:0x076a  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x0770  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x0776  */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x0780  */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x0786  */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x078c  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x0796  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x079c  */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x07a2  */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x07ac  */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x07b2  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x030c  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0314  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x031c  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0352 A[SYNTHETIC, Splitter:B:60:0x0352] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0357 A[Catch:{ Exception -> 0x07dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x035c A[Catch:{ Exception -> 0x07dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0367 A[Catch:{ Exception -> 0x07dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0442  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x044a  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0452  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x0532  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x053a  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0542  */
        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean doInBackground() {
            /*
            // Method dump skipped, instructions count: 2204
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aj.d.b.doInBackground():boolean");
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(150221);
            if (this.iKq == null || Util.isNullOrNil(this.iKq.getUsername())) {
                AppMethodBeat.o(150221);
            } else if (Util.isNullOrNil(this.iKr)) {
                d.this.iKc.remove(this.iKq.getUsername());
                h.INSTANCE.idkeyStat(138, 10, 1, true);
                AppMethodBeat.o(150221);
            } else {
                if (ay.a.iDr != null) {
                    ay.a.iDr.dl(this.iKr.length, 0);
                }
                d.this.a(new a(this.iKq, this.iKr, this.bGA));
                AppMethodBeat.o(150221);
            }
            return false;
        }
    }

    class a implements QueueWorkerThread.ThreadObject {
        boolean bGA;
        i iKn;
        byte[] iKo;
        byte[] iKp;

        public a(i iVar, byte[] bArr, boolean z) {
            this.iKn = iVar;
            this.iKo = bArr;
            this.bGA = z;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            byte[] bArr;
            AppMethodBeat.i(150218);
            if (this.bGA) {
                Log.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt");
                h.INSTANCE.dN(138, 51);
                byte[] DecryptAvatar = UtilsJni.DecryptAvatar(this.iKo);
                if (Util.isNullOrNil(DecryptAvatar)) {
                    h.INSTANCE.dN(138, 52);
                    Log.i("MicroMsg.AvatarService", "DecryptAvatar: decrypt output empty");
                    AppMethodBeat.o(150218);
                    return false;
                }
                bArr = DecryptAvatar;
            } else {
                bArr = this.iKo;
            }
            if (ImgUtil.isWXGF(bArr)) {
                Log.i("MicroMsg.AvatarService", "DecryptAvatar: hevc to pic");
                h.INSTANCE.dN(138, 53);
                this.iKp = ((com.tencent.mm.plugin.emoji.b.c) g.af(com.tencent.mm.plugin.emoji.b.c.class)).bn(bArr);
                if (Util.isNullOrNil(this.iKp)) {
                    h.INSTANCE.dN(138, 54);
                    Log.i("MicroMsg.AvatarService", "DecryptAvatar: output is empty");
                    AppMethodBeat.o(150218);
                    return false;
                }
            } else {
                this.iKp = bArr;
            }
            AppMethodBeat.o(150218);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(150219);
            if (!Util.isNullOrNil(this.iKp)) {
                Log.i("MicroMsg.AvatarService", "DecryptAvatar: post to save length is %s", Integer.valueOf(this.iKp.length));
                d.this.a(new e(this.iKn, this.iKp));
                AppMethodBeat.o(150219);
                return true;
            }
            Log.i("MicroMsg.AvatarService", "DecryptAvatar: onPostExecute output is empty");
            AppMethodBeat.o(150219);
            return false;
        }
    }

    class e implements QueueWorkerThread.ThreadObject {
        Bitmap bitmap = null;
        byte[] buf;
        i iKn = null;

        public e(i iVar, byte[] bArr) {
            this.iKn = iVar;
            this.buf = bArr;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(150224);
            if (this.iKn == null || Util.isNullOrNil(this.iKn.getUsername())) {
                Log.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
                h.INSTANCE.idkeyStat(138, 13, 1, true);
                AppMethodBeat.o(150224);
                return false;
            }
            if (d.aYn() != null) {
                e.N(this.iKn.getUsername(), false);
                e.N(this.iKn.getUsername(), true);
                this.bitmap = e.g(this.iKn.getUsername(), this.buf);
                if (this.bitmap == null) {
                    h.INSTANCE.idkeyStat(138, 14, 1, true);
                }
            } else {
                Log.i("MicroMsg.AvatarService", "astg is null!!");
            }
            j aYo = d.aYo();
            if (aYo != null) {
                this.iKn.cSx = -1;
                this.iKn.aYv();
                aYo.b(this.iKn);
            }
            AppMethodBeat.o(150224);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(150225);
            if (Util.isNullOrNil(this.iKn.getUsername())) {
                AppMethodBeat.o(150225);
            } else {
                e aYn = d.aYn();
                if (!(aYn == null || this.bitmap == null)) {
                    aYn.d(this.iKn.getUsername(), this.bitmap);
                }
                d.this.iKc.remove(this.iKn.getUsername());
                AppMethodBeat.o(150225);
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements QueueWorkerThread.ThreadObject {
        Bitmap iKs = null;
        b iKt = null;
        String username = null;

        public c(String str) {
            this.username = str;
        }

        public c(String str, b bVar) {
            this.username = str;
            this.iKt = bVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            boolean startsWith;
            i Mx;
            i iVar = null;
            int i2 = 0;
            AppMethodBeat.i(150222);
            if (Util.isNullOrNil(this.username)) {
                AppMethodBeat.o(150222);
                return false;
            }
            String str = this.username;
            if (str == null) {
                startsWith = false;
            } else {
                startsWith = str.startsWith("ammURL_");
            }
            if (startsWith) {
                String str2 = d.this.iKi.get(str);
                if (!Util.isNullOrNil(str2) && ((Mx = p.aYB().Mx(str)) == null || !str.equals(Mx.getUsername()))) {
                    Cursor rawQuery = p.aYB().iFy.rawQuery("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + Util.escapeSqlValue(str2) + "\"", null, 2);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            rawQuery.moveToFirst();
                            iVar = new i();
                            iVar.convertFrom(rawQuery);
                        }
                        rawQuery.close();
                    }
                    if (iVar != null && !Util.isNullOrNil(iVar.getUsername())) {
                        s.nw(c.Me(iVar.getUsername()), c.Me(str));
                    }
                    i iVar2 = new i();
                    iVar2.username = str;
                    iVar2.fuz = 3;
                    iVar2.iKW = str2;
                    iVar2.iKX = str2;
                    iVar2.cSx = 3;
                    iVar2.fv(true);
                    iVar2.cSx = 31;
                    p.aYB().b(iVar2);
                }
            }
            e aYn = d.aYn();
            if (aYn == null) {
                AppMethodBeat.o(150222);
                return false;
            }
            if (e.iKw.containsKey(this.username)) {
                i2 = e.iKw.get(this.username).intValue();
            }
            if (i2 != 0) {
                p.aYA();
                Context context = p.getContext();
                if (context != null) {
                    aYn.e(this.username, com.tencent.mm.compatible.f.a.decodeResource(context.getResources(), i2));
                }
            }
            this.iKs = e.Mn(this.username);
            AppMethodBeat.o(150222);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            i iVar;
            AppMethodBeat.i(150223);
            if (this.iKs == null) {
                d dVar = d.this;
                String str = this.username;
                b bVar = this.iKt;
                Log.d("MicroMsg.AvatarService", "avatar service push: %s", str);
                if (Util.isNullOrNil(str)) {
                    iVar = null;
                } else if (str.equals(dVar.iKh + "@bottle") && !Util.nullAs((Boolean) g.aAh().azQ().get(60, (Object) null), false)) {
                    iVar = null;
                } else if (!str.equals(dVar.iKh) || Util.nullAs((Boolean) g.aAh().azQ().get(59, (Object) null), false)) {
                    long nowSecond = Util.nowSecond();
                    C0245d aT = dVar.iKd.aT(str);
                    if (aT == null || aT.ibG < 5 || nowSecond - aT.hwQ >= 600) {
                        i Mi = d.Mi(str);
                        if (Mi == null) {
                            Log.w("MicroMsg.AvatarService", "checkUser block local no need: %s", str);
                            C0245d dVar2 = new C0245d((byte) 0);
                            dVar2.ibG = 5;
                            dVar2.hwQ = nowSecond;
                            dVar.iKd.x(str, dVar2);
                            iVar = null;
                        } else {
                            if (aT == null || nowSecond - aT.hwQ > 600) {
                                Log.i("MicroMsg.AvatarService", "new user: %s", str);
                                C0245d dVar3 = new C0245d((byte) 0);
                                dVar3.ibG = 1;
                                dVar3.hwQ = nowSecond;
                                dVar.iKd.x(str, dVar3);
                            } else if (aT.ibG < 5) {
                                Log.i("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", str, Integer.valueOf(aT.ibG), Long.valueOf(nowSecond - aT.hwQ));
                                aT.ibG++;
                                aT.hwQ = nowSecond;
                                dVar.iKd.x(str, aT);
                            }
                            iVar = Mi;
                        }
                    } else {
                        Log.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", str);
                        iVar = null;
                    }
                } else {
                    Log.w("MicroMsg.AvatarService", "ConstantsStorage.USERINFO_HAS_HEADIMG false");
                    iVar = null;
                }
                if (iVar == null) {
                    dVar.iKc.remove(str);
                } else if (!Util.isNullOrNil(iVar.aYu())) {
                    dVar.a(new b(iVar));
                } else {
                    Log.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(iVar.fuz));
                    if (4 == iVar.fuz) {
                        Log.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
                    } else if (bVar == null || bVar.iJY) {
                        dVar.iKe.push(iVar);
                        if (dVar.iKe.size() > 5) {
                            dVar.iKj.startTimer(0);
                        } else {
                            dVar.iKj.startTimer(1000);
                        }
                    } else {
                        Log.w("MicroMsg.AvatarService", "avatar push username %s can not get avatar by username", str);
                        dVar.iKc.remove(str);
                    }
                }
                AppMethodBeat.o(150223);
                return false;
            }
            e aYn = d.aYn();
            if (aYn != null) {
                aYn.d(this.username, this.iKs);
            }
            d.this.iKc.remove(this.username);
            AppMethodBeat.o(150223);
            return false;
        }
    }

    static e aYn() {
        AppMethodBeat.i(150234);
        if (g.aAf().azp()) {
            e aYn = p.aYn();
            AppMethodBeat.o(150234);
            return aYn;
        }
        AppMethodBeat.o(150234);
        return null;
    }

    public final String Mj(String str) {
        String format;
        AppMethodBeat.i(150235);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(150235);
            return "";
        }
        try {
            format = String.format("%s%x_%s", "ammURL_", Integer.valueOf(str.hashCode()), str.substring(str.length() - 24, str.length() - 4));
        } catch (Exception e2) {
            format = String.format("%s%x_", "ammURL_", Integer.valueOf(str.hashCode()));
        }
        this.iKi.put(format, str);
        AppMethodBeat.o(150235);
        return format;
    }

    static /* synthetic */ j aYo() {
        AppMethodBeat.i(150236);
        if (g.aAf().azp()) {
            j aYB = p.aYB();
            AppMethodBeat.o(150236);
            return aYB;
        }
        AppMethodBeat.o(150236);
        return null;
    }
}
