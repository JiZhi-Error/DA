package com.tencent.mm.bd;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class c {
    private static c jie;
    private QueueWorkerThread jif = null;

    public interface a {
        void fI(boolean z);
    }

    public static c bez() {
        AppMethodBeat.i(90694);
        if (jie == null) {
            jie = new c();
        }
        c cVar = jie;
        AppMethodBeat.o(90694);
        return cVar;
    }

    private c() {
    }

    public static String Pr(String str) {
        AppMethodBeat.i(90695);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(90695);
            return null;
        }
        String genPath = FilePathGenerator.genPath(com.tencent.mm.plugin.w.a.eMT(), "remark_", g.getMessageDigest((str + "ZnVjaw==").getBytes()), ".png", 1);
        AppMethodBeat.o(90695);
        return genPath;
    }

    public static boolean Ps(String str) {
        AppMethodBeat.i(90696);
        String Pr = Pr(str);
        Log.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, Pr);
        boolean exists = new o(Pr).exists();
        AppMethodBeat.o(90696);
        return exists;
    }

    public static boolean Pt(String str) {
        AppMethodBeat.i(90697);
        String Pr = Pr(str);
        Log.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, Pr);
        boolean deleteFile = s.deleteFile(Pr);
        AppMethodBeat.o(90697);
        return deleteFile;
    }

    public final void a(String str, String str2, a aVar) {
        AppMethodBeat.i(90699);
        if (!Util.isNullOrNil(str2) && !Ps(str)) {
            if (this.jif == null || this.jif.isDead()) {
                this.jif = new QueueWorkerThread(1, "download-remark-img", 1);
            }
            this.jif.add(new b(str, str2, aVar));
        }
        AppMethodBeat.o(90699);
    }

    /* access modifiers changed from: package-private */
    public class b implements QueueWorkerThread.ThreadObject {
        private String fullPath;
        private String imageUrl;
        private a jig;
        private boolean success = false;
        private String username;

        public b(String str, String str2, a aVar) {
            this.username = str;
            this.imageUrl = str2;
            this.jig = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x0198 A[SYNTHETIC, Splitter:B:44:0x0198] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x019d A[SYNTHETIC, Splitter:B:47:0x019d] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x01a2 A[SYNTHETIC, Splitter:B:50:0x01a2] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0235 A[SYNTHETIC, Splitter:B:77:0x0235] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x023a A[SYNTHETIC, Splitter:B:80:0x023a] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x023f A[SYNTHETIC, Splitter:B:83:0x023f] */
        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean doInBackground() {
            /*
            // Method dump skipped, instructions count: 669
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bd.c.b.doInBackground():boolean");
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(90693);
            if (!this.success) {
                this.jig.fI(false);
                AppMethodBeat.o(90693);
                return false;
            }
            s.deleteFile(this.fullPath);
            new o(this.fullPath + ".tmp").am(new o(this.fullPath));
            this.jig.fI(true);
            AppMethodBeat.o(90693);
            return true;
        }
    }

    public static Bitmap Pu(String str) {
        boolean z = false;
        AppMethodBeat.i(90698);
        Bitmap bitmapNative = BitmapUtil.getBitmapNative(Pr(str), 0, 0);
        if (bitmapNative != null && !bitmapNative.isRecycled()) {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(90698);
            return bitmapNative;
        }
        AppMethodBeat.o(90698);
        return null;
    }
}
