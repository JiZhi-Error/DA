package com.tencent.luggage.game.c;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public com.tencent.magicbrush.e cuW;
    public d cvg;
    public volatile b cvh;
    public final Queue<String> cvi = new LinkedList();
    public C0170e cvj = new C0170e((byte) 0);
    public Context mContext;
    public volatile int mState = 0;

    public static class b {
        public k cuQ;
        public com.tencent.magicbrush.e cvr;
        public FrameLayout cvs;
        public boolean cvt;
        public boolean cvu;
        public c cvv = null;
    }

    public interface c {
        void F(List<f> list);
    }

    public e() {
        AppMethodBeat.i(130524);
        AppMethodBeat.o(130524);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.luggage.game.c.e$e  reason: collision with other inner class name */
    public static class C0170e extends com.tencent.luggage.game.g.b<d> {
        private C0170e() {
        }

        /* synthetic */ C0170e(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.luggage.game.g.b
        public final /* synthetic */ d Mc() {
            AppMethodBeat.i(130523);
            d dVar = new d((byte) 0);
            AppMethodBeat.o(130523);
            return dVar;
        }
    }

    static class d implements Runnable {
        private d cvg;
        private C0170e cvj;

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(130522);
            if (this.cvg == null) {
                AppMethodBeat.o(130522);
                return;
            }
            if (this.cvj != null) {
                this.cvj.release(this);
            }
            AppMethodBeat.o(130522);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (r6.cvh != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(130525);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        r6.cvh.post(new com.tencent.luggage.game.c.e.AnonymousClass2(r6));
        com.tencent.matrix.trace.core.AppMethodBeat.o(130525);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dq(final java.lang.String r7) {
        /*
            r6 = this;
            r5 = 1
            r4 = 130525(0x1fddd, float:1.82904E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.String r0 = "MicroMsg.GameInspector"
            java.lang.String r1 = "hy: on js logged : %s"
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r3 = 0
            r2[r3] = r7
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1, r2)
            java.util.Queue<java.lang.String> r1 = r6.cvi
            monitor-enter(r1)
            int r0 = r6.mState     // Catch:{ all -> 0x002f }
            if (r0 == r5) goto L_0x0026
            java.util.Queue<java.lang.String> r0 = r6.cvi     // Catch:{ all -> 0x002f }
            r0.add(r7)     // Catch:{ all -> 0x002f }
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0025:
            return
        L_0x0026:
            monitor-exit(r1)
            com.tencent.luggage.game.c.b r0 = r6.cvh
            if (r0 != 0) goto L_0x0035
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0025
        L_0x002f:
            r0 = move-exception
            monitor-exit(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0035:
            com.tencent.luggage.game.c.b r0 = r6.cvh
            com.tencent.luggage.game.c.e$2 r1 = new com.tencent.luggage.game.c.e$2
            r1.<init>(r7)
            r0.post(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.game.c.e.dq(java.lang.String):void");
    }

    public enum a {
        DEBUG,
        INFO,
        WARNING,
        ERROR;

        public static a valueOf(String str) {
            AppMethodBeat.i(130520);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(130520);
            return aVar;
        }

        static {
            AppMethodBeat.i(130521);
            AppMethodBeat.o(130521);
        }
    }

    public final void a(a aVar, String str) {
        int i2 = 0;
        AppMethodBeat.i(130526);
        if (aVar == null || Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameInspector", "hy: not valid console!");
            AppMethodBeat.o(130526);
            return;
        }
        switch (aVar) {
            case INFO:
                i2 = 1;
                break;
            case WARNING:
                i2 = 2;
                break;
            case ERROR:
                i2 = 3;
                break;
        }
        h(i2, str);
        AppMethodBeat.o(130526);
    }

    private void h(int i2, String str) {
        AppMethodBeat.i(130527);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", i2);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("wxClient: ".concat(String.valueOf(str)));
            jSONObject.put("logs", jSONArray);
            dq(jSONObject.toString());
            AppMethodBeat.o(130527);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.GameInspector", e2, "hy: vConsole json error", new Object[0]);
            AppMethodBeat.o(130527);
        }
    }
}
