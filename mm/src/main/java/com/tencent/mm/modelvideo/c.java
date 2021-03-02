package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static final int jpN = com.tencent.mm.n.c.aqq();
    Context context = null;
    int duration = 0;
    String fileName = null;
    Intent intent = null;
    public a jpO = null;
    String jpP = null;
    final AsyncTask<String, Integer, String> jpQ = new AsyncTask<String, Integer, String>() {
        /* class com.tencent.mm.modelvideo.c.AnonymousClass1 */
        int ret = 0;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ String doInBackground(String[] strArr) {
            AppMethodBeat.i(126782);
            String bgS = bgS();
            AppMethodBeat.o(126782);
            return bgS;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0106 A[SYNTHETIC, Splitter:B:25:0x0106] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0141  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String bgS() {
            /*
            // Method dump skipped, instructions count: 380
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.c.AnonymousClass1.bgS():java.lang.String");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(String str) {
            AppMethodBeat.i(126781);
            if (c.this.jpO != null) {
                c.this.jpO.c(this.ret, c.this.fileName, c.this.jpP, c.this.duration);
            }
            AppMethodBeat.o(126781);
        }
    };
    String thumbPath = null;
    String videoPath = null;

    public interface a {
        void c(int i2, String str, String str2, int i3);
    }

    public c() {
        AppMethodBeat.i(126783);
        AppMethodBeat.o(126783);
    }

    static {
        AppMethodBeat.i(126785);
        AppMethodBeat.o(126785);
    }

    public final void a(Context context2, Intent intent2, String str, a aVar) {
        AppMethodBeat.i(240848);
        this.context = context2;
        this.intent = intent2;
        this.fileName = t.Qv(str);
        o.bhj();
        this.thumbPath = t.Qx(this.fileName);
        o.bhj();
        this.videoPath = t.Qw(this.fileName);
        this.jpO = aVar;
        this.jpQ.execute(new String[0]);
        AppMethodBeat.o(240848);
    }
}
