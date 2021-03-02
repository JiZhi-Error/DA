package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements com.tencent.mm.plugin.appbrand.canvas.widget.a {
    volatile boolean kYN;
    JSONArray kYO;
    volatile DrawCanvasArg kYP;
    private d kYQ;
    private c kYR;
    public com.tencent.mm.plugin.appbrand.canvas.widget.a kYS;
    public Runnable kYT = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.canvas.b.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(144823);
            b.this.kZb = 0;
            b.this.mPause = true;
            AppMethodBeat.o(144823);
        }
    };
    private Runnable kYU = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.canvas.b.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(144824);
            boolean z = b.this.mPause;
            b.this.mPause = false;
            Log.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", Boolean.valueOf(z), Boolean.valueOf(b.this.kYN));
            if (z && b.this.kYN) {
                b.this.kYS.bzg();
            }
            AppMethodBeat.o(144824);
        }
    };
    public volatile long kYV;
    private volatile long kYW;
    protected volatile int kYX = 0;
    protected volatile long kYY;
    protected volatile long kYZ;
    protected volatile long kZa;
    protected volatile long kZb;
    private com.tencent.mm.plugin.appbrand.canvas.c.a kZc;
    boolean kZd = true;
    private String kZe;
    protected volatile int mCount;
    public volatile boolean mPause;
    private volatile String mSessionId;

    public b(com.tencent.mm.plugin.appbrand.canvas.widget.a aVar) {
        AppMethodBeat.i(144832);
        this.kYS = aVar;
        this.kYQ = new d(new a(aVar));
        this.kYR = new c();
        AppMethodBeat.o(144832);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final boolean o(Canvas canvas) {
        AppMethodBeat.i(144833);
        if (this.kZd) {
            this.kYQ.kZt = false;
            boolean a2 = a(canvas, this.kYO);
            AppMethodBeat.o(144833);
            return a2;
        }
        boolean p = p(canvas);
        AppMethodBeat.o(144833);
        return p;
    }

    private boolean p(Canvas canvas) {
        List<DrawActionWrapper> list;
        AppMethodBeat.i(144834);
        this.kYQ.kZt = true;
        if (this.kYP == null) {
            this.kYN = false;
            AppMethodBeat.o(144834);
            return false;
        } else if (!this.kYP.laA || this.kYP.laE) {
            this.kYN = false;
            if (this.kYP == null) {
                list = null;
            } else {
                list = this.kYP.kZW;
            }
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(144834);
                return false;
            }
            long j2 = this.kYV;
            long nanoTime = System.nanoTime();
            this.kYQ.reset();
            for (DrawActionWrapper drawActionWrapper : list) {
                try {
                    if (drawActionWrapper != null) {
                        try {
                            switch (drawActionWrapper.type) {
                                case 1:
                                    this.kYR.a(this.kYQ, canvas, drawActionWrapper.kZw);
                                    IllegalStateException illegalStateException = new IllegalStateException("please use draw obj " + drawActionWrapper.kZw.toString());
                                    AppMethodBeat.o(144834);
                                    throw illegalStateException;
                                case 2:
                                    c cVar = this.kYR;
                                    d dVar = this.kYQ;
                                    BaseDrawActionArg baseDrawActionArg = drawActionWrapper.kZv;
                                    d dVar2 = cVar.kZk.get(baseDrawActionArg.method);
                                    if (dVar2 != null) {
                                        dVar2.a(dVar, canvas, baseDrawActionArg);
                                        break;
                                    } else {
                                        continue;
                                    }
                                default:
                                    Log.w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", Integer.valueOf(drawActionWrapper.type));
                                    continue;
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", e2);
                        }
                    }
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", e3, "", new Object[0]);
                }
            }
            h(j2, nanoTime, System.nanoTime());
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mPause) {
                this.kZb = currentTimeMillis;
            }
            AppMethodBeat.o(144834);
            return true;
        } else {
            boolean a2 = a(canvas, this.kYP.laB);
            AppMethodBeat.o(144834);
            return a2;
        }
    }

    private void h(long j2, long j3, long j4) {
        long j5 = j4 - j3;
        if (j2 != 0) {
            this.kZa = j5 + this.kZa;
            this.kYZ += j4 - j2;
            this.mCount++;
        }
    }

    private boolean a(Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(144835);
        this.kYN = false;
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(144835);
            return false;
        }
        long j2 = this.kYV;
        long nanoTime = System.nanoTime();
        this.kYQ.reset();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                try {
                    this.kYR.a(this.kYQ, canvas, optJSONObject);
                } catch (Exception e2) {
                    Log.e("MicroMsg.DrawActionDelegateImpl", "drawAction error with method[%s], exception : %s", optJSONObject.optString(FirebaseAnalytics.b.METHOD), e2);
                }
            }
        }
        h(j2, nanoTime, System.nanoTime());
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.mPause) {
            this.kZb = currentTimeMillis;
        }
        AppMethodBeat.o(144835);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzg() {
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(final JSONArray jSONArray, final a.AbstractC0561a aVar) {
        AppMethodBeat.i(144836);
        this.kYS.U(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.canvas.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(144825);
                DrawCanvasArg drawCanvasArg = b.this.kYP;
                b.this.kYP = null;
                b.this.kYO = jSONArray;
                b.this.kZd = true;
                b.this.kYN = true;
                if (aVar != null) {
                    aVar.a(drawCanvasArg);
                }
                b.a(b.this);
                AppMethodBeat.o(144825);
            }
        });
        AppMethodBeat.o(144836);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(final JSONArray jSONArray, final a.AbstractC0561a aVar) {
        AppMethodBeat.i(144837);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(144837);
            return;
        }
        this.kYS.U(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.canvas.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(144826);
                b.this.kZd = true;
                if (b.this.kYO == null) {
                    b.this.kYO = jSONArray;
                } else {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        b.this.kYO.put(jSONArray.opt(i2));
                    }
                }
                b.this.kYN = true;
                if (aVar != null) {
                    aVar.a(null);
                }
                AppMethodBeat.o(144826);
            }
        });
        AppMethodBeat.o(144837);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void a(final DrawCanvasArg drawCanvasArg, final a.AbstractC0561a aVar) {
        AppMethodBeat.i(144838);
        this.kYS.U(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.canvas.b.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(144827);
                DrawCanvasArg drawCanvasArg = b.this.kYP;
                b.this.kYP = drawCanvasArg;
                b.this.kYN = true;
                b.this.kZd = false;
                if (aVar != null) {
                    aVar.a(drawCanvasArg);
                }
                b.a(b.this);
                AppMethodBeat.o(144827);
            }
        });
        AppMethodBeat.o(144838);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void b(final DrawCanvasArg drawCanvasArg, final a.AbstractC0561a aVar) {
        AppMethodBeat.i(144839);
        if (drawCanvasArg == null) {
            AppMethodBeat.o(144839);
            return;
        }
        this.kYS.U(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.canvas.b.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(144828);
                if (b.this.kYP == null) {
                    AppMethodBeat.o(144828);
                    return;
                }
                b.this.kYP.kZW.addAll(drawCanvasArg.kZW);
                b.this.kYN = true;
                b.this.kZd = false;
                if (aVar != null) {
                    aVar.a(null);
                }
                AppMethodBeat.o(144828);
            }
        });
        AppMethodBeat.o(144839);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void bzh() {
        AppMethodBeat.i(144840);
        this.kYS.U(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.canvas.b.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(144829);
                Log.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
                b.this.kYP = null;
                b.this.kYO = null;
                b.this.kYN = true;
                AppMethodBeat.o(144829);
            }
        });
        AppMethodBeat.o(144840);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final void onResume() {
        AppMethodBeat.i(144841);
        this.kYS.U(this.kYU);
        AppMethodBeat.o(144841);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void U(Runnable runnable) {
        AppMethodBeat.i(144842);
        if (equals(this.kYS)) {
            AppMethodBeat.o(144842);
            return;
        }
        MMHandlerThread.postToMainThread(runnable);
        AppMethodBeat.o(144842);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.b
    public final boolean isPaused() {
        return this.mPause;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public final String getSessionId() {
        return this.mSessionId;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.g
    public final void setSessionId(String str) {
        this.mSessionId = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public final void setStartTime(long j2) {
        this.kYV = j2;
        this.kYW = j2;
    }

    @Override // com.tencent.mm.plugin.appbrand.collector.d
    public final void bzi() {
        AppMethodBeat.i(144843);
        int i2 = this.mCount;
        long j2 = this.kZa;
        long j3 = this.kYZ;
        if (i2 <= 0 || j2 <= 0 || j3 <= 0) {
            AppMethodBeat.o(144843);
            return;
        }
        float f2 = ((((float) this.kYY) * 1.0f) / ((float) this.kYX)) / 1000000.0f;
        float f3 = ((((float) j2) * 1.0f) / ((float) i2)) / 1000000.0f;
        Log.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(this.kYX), Integer.valueOf(i2));
        if (this.kZc != null) {
            this.kZc.Ba(j2 / ((long) i2));
            this.kZc.Bb(j3 / ((long) i2));
            this.kZc.d(j2, j3, i2);
            this.kZc.aH(f2);
            this.kZc.aI(f3);
        }
        AppMethodBeat.o(144843);
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final d getDrawContext() {
        return this.kYQ;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a aVar) {
        this.kZc = aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final void setTraceId(String str) {
        this.kZe = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a
    public final String getTraceId() {
        return this.kZe;
    }

    static class a implements a {
        private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> kZj;

        a(com.tencent.mm.plugin.appbrand.canvas.widget.a aVar) {
            AppMethodBeat.i(144830);
            this.kZj = new WeakReference<>(aVar);
            AppMethodBeat.o(144830);
        }

        @Override // com.tencent.mm.plugin.appbrand.canvas.a
        public final void invalidate() {
            AppMethodBeat.i(144831);
            com.tencent.mm.plugin.appbrand.canvas.widget.a aVar = this.kZj.get();
            if (aVar == null) {
                AppMethodBeat.o(144831);
                return;
            }
            aVar.bzg();
            AppMethodBeat.o(144831);
        }
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(144844);
        if (bVar.kYW != 0) {
            bVar.kYY += System.nanoTime() - bVar.kYW;
            bVar.kYW = 0;
            bVar.kYX++;
            if (bVar.kZc != null) {
                bVar.kZc.bzw();
            }
        }
        AppMethodBeat.o(144844);
    }
}
