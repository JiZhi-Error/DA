package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

public abstract class a implements e<DrawCanvasArg> {
    protected DrawCanvasArg lon;
    protected String loo;
    protected BlockingQueue<b> lop = new LinkedBlockingQueue(100);
    protected BlockingQueue<Runnable> loq = new LinkedBlockingQueue(100);
    protected volatile long lor;
    protected volatile long los;
    protected int lot;
    protected int lou;
    protected boolean lov;
    protected Thread workerThread = new Thread(new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(121371);
            while (!a.this.workerThread.isInterrupted()) {
                try {
                    b take = a.this.lop.take();
                    if (a.this.lop.size() >= 2 && a.this.lor > 0) {
                        while (take.loa < a.this.los) {
                            a.this.lot++;
                            take = a.this.lop.poll();
                            if (a.this.lop.size() <= 0) {
                                break;
                            }
                        }
                    }
                    if (take != null) {
                        take.run();
                        a.this.lor = take.loa;
                        if (a.this.lov) {
                            try {
                                u.i("BaseDrawCanvasWithObj", "wait for release task", new Object[0]);
                                Runnable take2 = a.this.loq.take();
                                if (take2 != null) {
                                    take2.run();
                                }
                                a.this.lov = false;
                                u.i("BaseDrawCanvasWithObj", "get release task", new Object[0]);
                            } catch (InterruptedException e2) {
                                Log.printErrStackTrace("BaseDrawCanvasWithObj", e2, "", new Object[0]);
                                AppMethodBeat.o(121371);
                                return;
                            }
                        }
                    }
                    if (!a.this.workerThread.isInterrupted()) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e3) {
                            Log.printErrStackTrace("BaseDrawCanvasWithObj", e3, "", new Object[0]);
                            AppMethodBeat.o(121371);
                            return;
                        }
                    } else {
                        AppMethodBeat.o(121371);
                        return;
                    }
                } catch (InterruptedException e4) {
                    Log.printErrStackTrace("BaseDrawCanvasWithObj", e4, "", new Object[0]);
                    AppMethodBeat.o(121371);
                    return;
                }
            }
            AppMethodBeat.o(121371);
        }
    }, "DrawCanvasMgr-worker");

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final /* bridge */ /* synthetic */ void cB(DrawCanvasArg drawCanvasArg) {
        String str;
        this.lon = drawCanvasArg;
        if (this.lon != null) {
            str = this.lon.lay;
        } else {
            str = null;
        }
        this.loo = str;
    }

    public a() {
        this.workerThread.start();
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final void a(b bVar) {
        try {
            this.lop.put(bVar);
            this.los = bVar.loa;
            this.lou++;
        } catch (InterruptedException e2) {
            Log.printErrStackTrace("BaseDrawCanvasWithObj", e2, "", new Object[0]);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final boolean YA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.loo == null || this.loo.hashCode() != str.hashCode()) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public DrawCanvasArg d(JSONObject jSONObject, String str) {
        DrawCanvasArg acquire = d.bzo().laa.acquire();
        if (acquire == null) {
            acquire = new DrawCanvasArg();
        }
        acquire.lax = jSONObject.optBoolean("reserve");
        acquire.lay = str;
        acquire.laz = jSONObject.optLong("__invoke_jsapi_timestamp");
        return acquire;
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final void reset() {
        this.loo = null;
        u.i("BaseDrawCanvasWithObj", "drop frame %d times, allFrame %d ", Integer.valueOf(this.lot), Integer.valueOf(this.lou));
        this.lou = 0;
        this.lot = 0;
        this.lor = 0;
        this.workerThread.interrupt();
        Runnable poll = this.loq.poll();
        while (poll != null) {
            if (poll != null) {
                poll.run();
            }
            poll = this.loq.poll();
        }
        this.loq.clear();
        this.lop.clear();
        if (this.lon != null) {
            this.lon.reset();
            this.lon = null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final void W(Runnable runnable) {
        try {
            this.loq.put(runnable);
        } catch (InterruptedException e2) {
            Log.printErrStackTrace("BaseDrawCanvasWithObj", e2, "", new Object[0]);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final void bCd() {
        this.lov = true;
    }
}
