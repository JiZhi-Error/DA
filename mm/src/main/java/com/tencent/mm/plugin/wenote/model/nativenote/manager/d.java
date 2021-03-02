package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.e;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d extends Thread {
    private static HashMap<String, b> qQI = new HashMap<>();
    private static Object qQJ = new byte[0];
    private static QueueWorkerThread qQK;
    private a JIh;
    private k JIi;
    public boolean isStop;
    private List<String> qQA;
    private List<String> qQB;
    private List<Integer> qQC;
    private String qQF;
    private String qQG;
    private boolean qQH = false;
    private List<String> qQy;
    private List<Integer> qQz;

    public interface a {
        void a(String str, k kVar);

        void b(String str, k kVar);
    }

    static {
        AppMethodBeat.i(30458);
        AppMethodBeat.o(30458);
    }

    public d(List<String> list, String str, String str2, k kVar, a aVar) {
        AppMethodBeat.i(30451);
        this.qQy = list;
        this.qQz = new ArrayList();
        this.qQA = new ArrayList();
        this.qQC = new ArrayList();
        this.qQB = new ArrayList();
        this.JIh = aVar;
        this.JIi = kVar;
        this.qQG = str2;
        this.qQF = str;
        AppMethodBeat.o(30451);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0329  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 890
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.d.run():void");
    }

    private void a(final int i2, String str, String str2, int i3, VideoTransPara videoTransPara, Context context, final String str3) {
        AppMethodBeat.i(30453);
        Log.i("MicroMsg.NoteVideoCompress", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i2), Integer.valueOf(i3));
        d(i2, str, str2, i3);
        if (i2 == -50002) {
            aw(context, context.getString(R.string.hwm));
        } else if (i2 == -50008) {
            aw(context, context.getString(R.string.hwk));
        } else if (i2 == -50006) {
            fL(str, str2);
            if (qQK == null) {
                qQK = new QueueWorkerThread(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            b bVar = new b((byte) 0);
            synchronized (qQJ) {
                try {
                    qQI.put(str, bVar);
                } catch (Throwable th) {
                    AppMethodBeat.o(30453);
                    throw th;
                }
            }
            bVar.fileName = str;
            bVar.jpP = str2;
            bVar.kTQ = this.qQG;
            bVar.jsd = videoTransPara;
            bVar.JIh = this.JIh;
            bVar.JIi = this.JIi;
            qQK.add(bVar);
        } else if (i2 < 0) {
            aw(context, context.getString(R.string.hwl));
        } else {
            this.qQH = true;
        }
        if (this.JIh != null && !this.isStop) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(30447);
                    d.this.JIh.a(str3, d.this.JIi);
                    if (d.this.qQH || i2 != -50006) {
                        bg.aAk().postToWorkerDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.d.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(30446);
                                d.this.JIh.b(d.this.qQG, d.this.JIi);
                                AppMethodBeat.o(30446);
                            }
                        }, 80);
                    }
                    AppMethodBeat.o(30447);
                }
            });
        }
        AppMethodBeat.o(30453);
    }

    private void aw(final Context context, final String str) {
        AppMethodBeat.i(30454);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(30448);
                Toast.makeText(context, str, 0).show();
                AppMethodBeat.o(30448);
            }
        });
        AppMethodBeat.o(30454);
    }

    private static void fL(String str, String str2) {
        AppMethodBeat.i(30455);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.NoteVideoCompress", "do insertVideoStorage, but file name is null");
            AppMethodBeat.o(30455);
            return;
        }
        s sVar = new s();
        sVar.fileName = str;
        sVar.iFw = 1;
        sVar.dWq = null;
        bg.aVF();
        sVar.jsh = (String) c.azQ().get(2, "");
        sVar.createTime = Util.nowSecond();
        sVar.jsm = Util.nowSecond();
        sVar.jst = null;
        sVar.jpP = str2;
        if (!Util.isNullOrNil(str2)) {
            sVar.jsr = 1;
        }
        sVar.iKP = 0;
        o.bhj().b(sVar);
        AppMethodBeat.o(30455);
    }

    /* access modifiers changed from: package-private */
    public static final class b implements QueueWorkerThread.ThreadObject {
        private a JIh;
        k JIi;
        String fileName;
        String jpP;
        VideoTransPara jsd;
        String kTQ;
        private int outputHeight;
        private int outputWidth;
        int qQP;
        private boolean qQQ;
        private int qQR;

        private b() {
            this.qQR = 0;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            boolean z;
            AppMethodBeat.i(30449);
            synchronized (d.qQJ) {
                try {
                    z = !d.qQI.containsKey(this.fileName);
                } catch (Throwable th) {
                    AppMethodBeat.o(30449);
                    throw th;
                }
            }
            if (!z) {
                z = u.QN(this.fileName) == null;
            }
            if (z) {
                Log.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", this.fileName);
                AppMethodBeat.o(30449);
                return true;
            }
            if (this.jsd == null || this.jsd.isDefault) {
                int[] iArr = new int[2];
                d.d(this.jpP, iArr);
                this.outputWidth = iArr[0];
                this.outputHeight = iArr[1];
            } else {
                this.outputWidth = this.jsd.width;
                this.outputHeight = this.jsd.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            bg.aVF();
            if (!c.aSV().a(this.jpP, pString, pInt) || com.tencent.mm.vfs.s.nw(pString.value, this.kTQ) < 0) {
                long currentTicks = Util.currentTicks();
                if (this.jsd != null) {
                    Log.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", this.jsd);
                    this.qQP = SightVideoJNI.remuxingVFS(this.jpP, this.kTQ, this.outputWidth, this.outputHeight, this.jsd.videoBitrate, this.jsd.iSV, 8, this.jsd.iSU, 25.0f, (float) this.jsd.fps, null, 0, false, 0, 51);
                } else {
                    Log.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", this.fileName);
                    this.qQP = SightVideoJNI.remuxingVFS(this.jpP, this.kTQ, this.outputWidth, this.outputHeight, com.tencent.mm.plugin.sight.base.c.Dmd, com.tencent.mm.plugin.sight.base.c.Dmc, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.c.Dme, null, 0, false, 0, 51);
                }
                this.qQR = (int) Util.ticksToNow(currentTicks);
                Log.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.jpP, this.kTQ, Integer.valueOf(this.qQP), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight));
                this.qQQ = this.qQP >= 0;
                PInt pInt2 = new PInt();
                if (u.a(this.kTQ, pInt2, new PInt())) {
                    this.qQP = pInt2.value;
                }
                if (!this.qQQ) {
                    Log.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
                    com.tencent.mm.vfs.s.deleteFile(this.kTQ);
                    com.tencent.mm.vfs.s.nw(this.jpP, this.kTQ);
                } else {
                    Log.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
                    try {
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(this.kTQ);
                        String name = oVar.getName();
                        String str = this.kTQ + ".tmp";
                        PInt pInt3 = new PInt(0);
                        if (e.b(this.kTQ, str, pInt3)) {
                            boolean delete = oVar.delete();
                            com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(str);
                            Log.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(delete), Boolean.valueOf(com.tencent.mm.vfs.s.bo(oVar2.getParent() + FilePathGenerator.ANDROID_DIR_SEP, oVar2.getName(), name)), aa.z(oVar2.her()), this.kTQ);
                        } else {
                            Log.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(pInt3.value), this.jpP, this.kTQ);
                        }
                        bg.aVF();
                        c.aSV().ar(this.jpP, this.kTQ, this.qQP);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", e2.toString());
                    }
                }
                AppMethodBeat.o(30449);
                return true;
            }
            Log.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
            this.qQP = pInt.value;
            this.qQQ = true;
            AppMethodBeat.o(30449);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(30450);
            synchronized (d.qQJ) {
                try {
                    d.qQI.remove(this.fileName);
                } catch (Throwable th) {
                    AppMethodBeat.o(30450);
                    throw th;
                }
            }
            if (this.JIh != null) {
                this.JIh.b(this.kTQ, this.JIi);
            }
            AppMethodBeat.o(30450);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(java.lang.String r11, int[] r12) {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.d.d(java.lang.String, int[]):void");
    }

    private synchronized void d(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(30457);
        this.qQz.add(Integer.valueOf(i2));
        this.qQA.add(str);
        this.qQB.add(str2);
        this.qQC.add(Integer.valueOf(i3));
        AppMethodBeat.o(30457);
    }
}
