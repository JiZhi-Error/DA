package com.tencent.mm.aj;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.s;
import junit.framework.Assert;

public final class f implements i {
    c iKC = null;
    l iKD = null;
    boolean iKE = false;
    boolean iKF = true;
    boolean iKG = true;
    QueueWorkerThread iKH = null;
    i iKn = null;

    public interface c {
        int dp(int i2, int i3);
    }

    public f() {
        AppMethodBeat.i(150274);
        g.azz().a(158, this);
        AppMethodBeat.o(150274);
    }

    public final void sQ() {
        AppMethodBeat.i(150275);
        g.azz().b(158, this);
        AppMethodBeat.o(150275);
    }

    public final int a(String str, c cVar) {
        String str2;
        AppMethodBeat.i(150276);
        Assert.assertTrue("GetHDHeadImg must set callback", true);
        if (Util.isNullOrNil(str)) {
            cVar.dp(3, -101);
            AppMethodBeat.o(150276);
            return -101;
        }
        this.iKC = cVar;
        if (as.IG(str)) {
            str2 = as.bjz(str);
        } else {
            str2 = str;
        }
        this.iKn = p.aYB().Mx(str2);
        Log.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", str2);
        if (this.iKn == null || !this.iKn.getUsername().equals(str2)) {
            this.iKn = new i();
            this.iKn.username = str2;
        }
        if (Util.isNullOrNil(this.iKn.aYt())) {
            Log.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(this.iKn.fuz));
            this.iKD = new l(str2);
            if (!g.azz().a(this.iKD, 0)) {
                cVar.dp(3, -102);
                AppMethodBeat.o(150276);
                return -102;
            }
            AppMethodBeat.o(150276);
            return 0;
        } else if (a(this.iKn) == 0) {
            AppMethodBeat.o(150276);
            return 0;
        } else {
            cVar.dp(3, -103);
            AppMethodBeat.o(150276);
            return -103;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(150277);
        this.iKC.dp(i2, i3);
        AppMethodBeat.o(150277);
    }

    private int a(i iVar) {
        AppMethodBeat.i(150278);
        if (this.iKH == null || this.iKH.isDead()) {
            this.iKH = new QueueWorkerThread(1, "get-hd-headimg", 1);
        }
        int add = this.iKH.add(new b(iVar));
        AppMethodBeat.o(150278);
        return add;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    public class b implements QueueWorkerThread.ThreadObject {
        public boolean aGI = true;
        boolean bGA = false;
        public String iKI = null;
        String iKJ;
        private f.a iKL;
        public i iKq = null;

        public b(i iVar) {
            AppMethodBeat.i(150271);
            this.iKq = iVar;
            p.aYn();
            this.iKI = e.L(iVar.getUsername(), true);
            this.iKJ = this.iKI + ".tmp";
            this.iKL = new f.a();
            AppMethodBeat.o(150271);
        }

        /* JADX WARNING: Removed duplicated region for block: B:73:0x0266 A[SYNTHETIC, Splitter:B:73:0x0266] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x026b A[Catch:{ Exception -> 0x0274 }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0270 A[Catch:{ Exception -> 0x0274 }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x02c3 A[SYNTHETIC, Splitter:B:86:0x02c3] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x02c8 A[Catch:{ Exception -> 0x02d4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x02cd A[Catch:{ Exception -> 0x02d4 }] */
        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean doInBackground() {
            /*
            // Method dump skipped, instructions count: 807
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.aj.f.b.doInBackground():boolean");
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(150273);
            if (f.this.iKE) {
                AppMethodBeat.o(150273);
                return false;
            } else if (this.aGI || Util.isNullOrNil(this.iKI)) {
                f.this.iKC.dp(4, -1);
                AppMethodBeat.o(150273);
                return false;
            } else {
                Log.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.iKq.getUsername() + " urltime:" + this.iKL.apr());
                if (ay.a.iDr != null) {
                    ay.a.iDr.dl((int) s.boW(this.iKJ), 0);
                }
                f.this.iKH.add(new a(f.this.iKn, this.iKI, this.iKJ));
                AppMethodBeat.o(150273);
                return true;
            }
        }
    }

    class a implements QueueWorkerThread.ThreadObject {
        boolean aGI = true;
        boolean bGA;
        String iKI;
        String iKJ;
        i iKn;
        boolean isHevc = false;

        public a(i iVar, String str, String str2) {
            this.iKn = iVar;
            this.iKI = str;
            this.iKJ = str2;
            this.bGA = false;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            AppMethodBeat.i(150269);
            if (this.bGA) {
                h.INSTANCE.dN(138, 61);
                Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt %s", this.iKJ);
                byte[] DecryptAvatar = UtilsJni.DecryptAvatar(s.aW(this.iKJ, 0, -1));
                if (DecryptAvatar == null || DecryptAvatar.length <= 0) {
                    h.INSTANCE.dN(138, 62);
                    Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: decrypt failed");
                    AppMethodBeat.o(150269);
                    return true;
                }
                s.deleteFile(this.iKJ);
                s.f(this.iKJ, DecryptAvatar, DecryptAvatar.length);
            }
            if (ImgUtil.isWXGF(this.iKJ)) {
                this.isHevc = true;
                Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic start");
                h.INSTANCE.dN(138, 63);
                String str = this.iKJ + "_hevc";
                boolean nx = s.nx(this.iKJ, str);
                boolean bpa = s.bpa(this.iKJ);
                String k = s.k(this.iKJ, true);
                String k2 = s.k(str, false);
                if (k == null || k2 == null) {
                    Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: uri is null %s, %s; path %s, %s; result %s, %s", k, k2, this.iKJ, str, Boolean.valueOf(nx), Boolean.valueOf(bpa));
                    h.INSTANCE.dN(138, 65);
                    AppMethodBeat.o(150269);
                    return true;
                }
                int nativeWxam2Pic = ((com.tencent.mm.plugin.emoji.b.c) g.af(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(k2, k);
                s.deleteFile(str);
                if (nativeWxam2Pic != 0) {
                    h.INSTANCE.dN(138, 64);
                    Log.i("MicroMsg.GetHDHeadImgHelper", "DecryptAvatar: hevc to pic failed");
                    AppMethodBeat.o(150269);
                    return true;
                }
            }
            this.aGI = false;
            AppMethodBeat.o(150269);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(150270);
            if (f.this.iKE) {
                AppMethodBeat.o(150270);
                return false;
            } else if (this.aGI) {
                if (!this.isHevc || !f.this.iKF) {
                    f.this.iKC.dp(3, -1);
                } else {
                    Log.i("MicroMsg.GetHDHeadImgHelper", "onPostExecute: first request hevc failed");
                    f.this.iKF = false;
                    f.this.iKG = false;
                    f.this.iKH.add(new b(this.iKn));
                }
                AppMethodBeat.o(150270);
                return false;
            } else {
                s.deleteFile(this.iKI);
                s.nx(this.iKJ, this.iKI);
                l.bc(this.iKI, this.iKn.getUsername());
                f.this.iKC.dp(0, 0);
                AppMethodBeat.o(150270);
                return true;
            }
        }
    }
}
