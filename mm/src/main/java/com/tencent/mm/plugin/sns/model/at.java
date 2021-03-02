package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class at {
    public static long DMP = -1;
    public static long DMQ = -1;
    public static int DMR = 0;
    public static long DMS = 300000;
    public static boolean DMT = false;
    public static int DMU = 60;
    public static String TAG = "MicroMsg.SnsRetryEditTipManager";
    public long DMV = 0;
    public String DMW = "";
    public SnsInfo DMX = null;
    public String DMY = "";
    public Runnable DMZ = new Runnable() {
        /* class com.tencent.mm.plugin.sns.model.at.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(202779);
            Log.i(at.TAG, "run resetTask");
            at.a(at.this);
            at.b(at.this);
            at.fbB();
            at.this.DMX = null;
            at.this.DMY = "";
            AppMethodBeat.o(202779);
        }
    };

    public at() {
        AppMethodBeat.i(202781);
        AppMethodBeat.o(202781);
    }

    static /* synthetic */ void a(at atVar) {
        AppMethodBeat.i(202784);
        atVar.fbA();
        AppMethodBeat.o(202784);
    }

    static /* synthetic */ void b(at atVar) {
        AppMethodBeat.i(202785);
        atVar.reset();
        AppMethodBeat.o(202785);
    }

    /* access modifiers changed from: package-private */
    public final void fbA() {
        AppMethodBeat.i(202782);
        final String str = this.DMW;
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.at.AnonymousClass2 */

            public final void run() {
                j aQn;
                AppMethodBeat.i(202780);
                boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_clear_sns_tmp_file, true);
                Log.i(at.TAG, "removeDraftTmpFile clear:%s finalDraftKey:%s", Boolean.valueOf(a2), str);
                if (a2 && (aQn = aj.faV().aQn(str)) != null) {
                    byte[] bArr = aQn.field_draft;
                    if (!Util.isNullOrNil(bArr)) {
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        try {
                            Intent intent = (Intent) Intent.CREATOR.createFromParcel(obtain);
                            String stringExtra = intent.getStringExtra("KSightThumbPath");
                            String stringExtra2 = intent.getStringExtra("KSightPath");
                            Log.i(at.TAG, "delete %s, %s", stringExtra, stringExtra2);
                            c cVar = c.Cic;
                            c.aLG(stringExtra2);
                            c cVar2 = c.Cic;
                            c.aLG(stringExtra);
                            AppMethodBeat.o(202780);
                            return;
                        } catch (Exception e2) {
                            aj.faV().b(str, null, 0);
                        }
                    }
                }
                AppMethodBeat.o(202780);
            }
        });
        AppMethodBeat.o(202782);
    }

    public final void reset() {
        DMP = -1;
        DMR = 0;
        DMQ = -1;
        this.DMW = "";
        this.DMV = 0;
    }

    public final void D(SnsInfo snsInfo) {
        AppMethodBeat.i(202783);
        if (!DMT || snsInfo == null) {
            AppMethodBeat.o(202783);
            return;
        }
        DMQ = -1;
        DMP = snsInfo.field_snsId;
        DMR = snsInfo.field_createTime;
        this.DMV = Util.nowMilliSecond();
        this.DMW = "draft_retry_edit";
        k faV = aj.faV();
        j aQn = faV.aQn("draft_sent_".concat(String.valueOf(snsInfo.localid)));
        if (aQn != null) {
            faV.b("draft_retry_edit", aQn.field_draft, 0);
        }
        MMHandlerThread.postToMainThreadDelayed(this.DMZ, DMS);
        SnsObject C = an.C(snsInfo);
        this.DMY = e.DUQ.DVz.erU;
        if (C != null) {
            this.DMX = snsInfo;
            e.DUQ.DVz.xl(r.Jc(snsInfo.field_snsId));
            e.DUQ.DVz.eTY = (long) C.LikeCount;
            e.DUQ.DVz.eTZ = (long) C.CommentCount;
            e.DUQ.DVz.xn(String.valueOf(System.currentTimeMillis()));
            e.DUQ.DVA.xl(r.Jc(snsInfo.field_snsId));
            e.DUQ.DVA.eTY = (long) C.LikeCount;
            e.DUQ.DVA.eTZ = (long) C.CommentCount;
            e.DUQ.DVA.xn(String.valueOf(System.currentTimeMillis()));
        }
        Log.i(TAG, "prepareRetryEditInfo draftKey:%s", this.DMW);
        AppMethodBeat.o(202783);
    }

    public static boolean o(long j2, int i2, int i3) {
        boolean z = true;
        boolean z2 = false;
        if (DMT) {
            if (DMQ == -1) {
                if (DMP != -1 && DMR != 0 && j2 <= DMP && i2 < DMR) {
                    z2 = true;
                }
                if (z2) {
                    DMQ = (long) i3;
                }
            } else {
                if (((long) i3) != DMQ) {
                    z = false;
                }
                z2 = z;
            }
            if (z2) {
                e.DUQ.DVz.eUc++;
            }
        }
        return z2;
    }

    static /* synthetic */ void fbB() {
        AppMethodBeat.i(202786);
        EventCenter.instance.publish(new wd());
        AppMethodBeat.o(202786);
    }
}
