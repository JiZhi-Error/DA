package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.editor.model.a.l;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
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

public final class e extends Thread {
    private static HashMap<String, b> qQI = new HashMap<>();
    private static Object qQJ = new byte[0];
    private static QueueWorkerThread qQK;
    public boolean isStop;
    private List<String> qQA;
    private List<String> qQB;
    private List<Integer> qQC;
    private a qQD;
    private l qQE;
    private String qQF;
    private String qQG;
    private boolean qQH = false;
    private List<String> qQy;
    private List<Integer> qQz;

    public interface a {
        void a(String str, l lVar);

        void b(String str, l lVar);
    }

    static {
        AppMethodBeat.i(181778);
        AppMethodBeat.o(181778);
    }

    public e(List<String> list, String str, String str2, l lVar, a aVar) {
        AppMethodBeat.i(181771);
        this.qQy = list;
        this.qQz = new ArrayList();
        this.qQA = new ArrayList();
        this.qQC = new ArrayList();
        this.qQB = new ArrayList();
        this.qQD = aVar;
        this.qQE = lVar;
        this.qQG = str2;
        this.qQF = str;
        AppMethodBeat.o(181771);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x032b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 892
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.model.nativenote.manager.e.run():void");
    }

    private void a(final int i2, String str, String str2, int i3, VideoTransPara videoTransPara, Context context, final String str3) {
        AppMethodBeat.i(181773);
        Log.i("MicroMsg.EditorVideoCompress", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i2), Integer.valueOf(i3));
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
                    AppMethodBeat.o(181773);
                    throw th;
                }
            }
            bVar.fileName = str;
            bVar.jpP = str2;
            bVar.kTQ = this.qQG;
            bVar.jsd = videoTransPara;
            bVar.qQD = this.qQD;
            bVar.qQE = this.qQE;
            qQK.add(bVar);
        } else if (i2 < 0) {
            aw(context, context.getString(R.string.hwl));
        } else {
            this.qQH = true;
        }
        if (this.qQD != null && !this.isStop) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.editor.model.nativenote.manager.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(181767);
                    e.this.qQD.a(str3, e.this.qQE);
                    if (e.this.qQH || i2 != -50006) {
                        g.aAk().postToWorkerDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.editor.model.nativenote.manager.e.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(181766);
                                e.this.qQD.b(e.this.qQG, e.this.qQE);
                                AppMethodBeat.o(181766);
                            }
                        }, 80);
                    }
                    AppMethodBeat.o(181767);
                }
            });
        }
        AppMethodBeat.o(181773);
    }

    private void aw(final Context context, final String str) {
        AppMethodBeat.i(181774);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.editor.model.nativenote.manager.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(181768);
                Toast.makeText(context, str, 0).show();
                AppMethodBeat.o(181768);
            }
        });
        AppMethodBeat.o(181774);
    }

    private static void fL(String str, String str2) {
        AppMethodBeat.i(181775);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.EditorVideoCompress", "do insertVideoStorage, but file name is null");
            AppMethodBeat.o(181775);
            return;
        }
        s sVar = new s();
        sVar.fileName = str;
        sVar.iFw = 1;
        sVar.dWq = null;
        sVar.jsh = (String) g.aAh().azQ().get(2, "");
        sVar.createTime = Util.nowSecond();
        sVar.jsm = Util.nowSecond();
        sVar.jst = null;
        sVar.jpP = str2;
        if (!Util.isNullOrNil(str2)) {
            sVar.jsr = 1;
        }
        sVar.iKP = 0;
        o.bhj().b(sVar);
        AppMethodBeat.o(181775);
    }

    /* access modifiers changed from: package-private */
    public static final class b implements QueueWorkerThread.ThreadObject {
        String fileName;
        String jpP;
        VideoTransPara jsd;
        String kTQ;
        private int outputHeight;
        private int outputWidth;
        private a qQD;
        l qQE;
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
            AppMethodBeat.i(181769);
            synchronized (e.qQJ) {
                try {
                    z = !e.qQI.containsKey(this.fileName);
                } catch (Throwable th) {
                    AppMethodBeat.o(181769);
                    throw th;
                }
            }
            if (!z) {
                z = u.QN(this.fileName) == null;
            }
            if (z) {
                Log.w("MicroMsg.EditorVideoCompress", "remuxing job has been removed, filename %s", this.fileName);
                AppMethodBeat.o(181769);
                return true;
            }
            if (this.jsd == null || this.jsd.isDefault) {
                int[] iArr = new int[2];
                e.d(this.jpP, iArr);
                this.outputWidth = iArr[0];
                this.outputHeight = iArr[1];
            } else {
                this.outputWidth = this.jsd.width;
                this.outputHeight = this.jsd.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (!((com.tencent.mm.plugin.m.a.a) g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().a(this.jpP, pString, pInt) || com.tencent.mm.vfs.s.nw(pString.value, this.kTQ) < 0) {
                long currentTicks = Util.currentTicks();
                if (this.jsd != null) {
                    Log.i("MicroMsg.EditorVideoCompress", "remuxing new para %s", this.jsd);
                    this.qQP = SightVideoJNI.remuxingVFS(this.jpP, this.kTQ, this.outputWidth, this.outputHeight, this.jsd.videoBitrate, this.jsd.iSV, 8, this.jsd.iSU, 25.0f, (float) this.jsd.fps, null, 0, false, 0, 51);
                } else {
                    Log.w("MicroMsg.EditorVideoCompress", "remuxing but new para is null. %s", this.fileName);
                    this.qQP = SightVideoJNI.remuxingVFS(this.jpP, this.kTQ, this.outputWidth, this.outputHeight, c.Dmd, c.Dmc, 8, 2, 25.0f, c.Dme, null, 0, false, 0, 51);
                }
                this.qQR = (int) Util.ticksToNow(currentTicks);
                Log.i("MicroMsg.EditorVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.jpP, this.kTQ, Integer.valueOf(this.qQP), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight));
                this.qQQ = this.qQP >= 0;
                PInt pInt2 = new PInt();
                if (u.a(this.kTQ, pInt2, new PInt())) {
                    this.qQP = pInt2.value;
                }
                if (!this.qQQ) {
                    Log.w("MicroMsg.EditorVideoCompress", "remuxing video error, copy source video to send.");
                    com.tencent.mm.vfs.s.deleteFile(this.kTQ);
                    com.tencent.mm.vfs.s.nw(this.jpP, this.kTQ);
                } else {
                    Log.i("MicroMsg.EditorVideoCompress", "remuxing video sucess,insert to media duplication storage");
                    try {
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(this.kTQ);
                        String name = oVar.getName();
                        String str = this.kTQ + ".tmp";
                        PInt pInt3 = new PInt(0);
                        if (com.tencent.mm.plugin.a.e.b(this.kTQ, str, pInt3)) {
                            boolean delete = oVar.delete();
                            com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(str);
                            Log.i("MicroMsg.EditorVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(delete), Boolean.valueOf(com.tencent.mm.vfs.s.bo(oVar2.getParent() + FilePathGenerator.ANDROID_DIR_SEP, oVar2.getName(), name)), aa.z(oVar2.her()), this.kTQ);
                        } else {
                            Log.i("MicroMsg.EditorVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(pInt3.value), this.jpP, this.kTQ);
                        }
                        ((com.tencent.mm.plugin.m.a.a) g.af(com.tencent.mm.plugin.m.a.a.class)).aSV().ar(this.jpP, this.kTQ, this.qQP);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.EditorVideoCompress", "fast start exception e[%s]", e2.toString());
                    }
                }
                AppMethodBeat.o(181769);
                return true;
            }
            Log.i("MicroMsg.EditorVideoCompress", "copy remuxing file success, do not remuxing again.");
            this.qQP = pInt.value;
            this.qQQ = true;
            AppMethodBeat.o(181769);
            return true;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(181770);
            synchronized (e.qQJ) {
                try {
                    e.qQI.remove(this.fileName);
                } catch (Throwable th) {
                    AppMethodBeat.o(181770);
                    throw th;
                }
            }
            if (this.qQD != null) {
                this.qQD.b(this.kTQ, this.qQE);
            }
            AppMethodBeat.o(181770);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(java.lang.String r11, int[] r12) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.editor.model.nativenote.manager.e.d(java.lang.String, int[]):void");
    }

    private synchronized void d(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(181777);
        this.qQz.add(Integer.valueOf(i2));
        this.qQA.add(str);
        this.qQB.add(str2);
        this.qQC.add(Integer.valueOf(i3));
        AppMethodBeat.o(181777);
    }
}
