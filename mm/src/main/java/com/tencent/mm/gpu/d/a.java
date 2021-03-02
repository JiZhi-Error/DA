package com.tencent.mm.gpu.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a {
    private static a hje = new a();
    private Map<Integer, List<Long>> hjf = new HashMap();
    public Handler hjg;

    static {
        AppMethodBeat.i(186178);
        AppMethodBeat.o(186178);
    }

    private a() {
        AppMethodBeat.i(186170);
        HandlerThread handlerThread = new HandlerThread("EGLAllResRecorder");
        handlerThread.start();
        this.hjg = new Handler(handlerThread.getLooper());
        this.hjf.put(17, new ArrayList());
        this.hjf.put(18, new ArrayList());
        AppMethodBeat.o(186170);
    }

    public static a axl() {
        return hje;
    }

    public final void a(final b bVar) {
        AppMethodBeat.i(186171);
        this.hjg.post(new Runnable() {
            /* class com.tencent.mm.gpu.d.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186167);
                if (bVar == null) {
                    AppMethodBeat.o(186167);
                    return;
                }
                a.a(a.this, bVar);
                AppMethodBeat.o(186167);
            }
        });
        AppMethodBeat.o(186171);
    }

    public final void b(final b bVar) {
        AppMethodBeat.i(186172);
        this.hjg.post(new Runnable() {
            /* class com.tencent.mm.gpu.d.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(186168);
                if (bVar == null) {
                    AppMethodBeat.o(186168);
                    return;
                }
                a.b(a.this, bVar);
                AppMethodBeat.o(186168);
            }
        });
        AppMethodBeat.o(186172);
    }

    private int pz(int i2) {
        int size;
        AppMethodBeat.i(186173);
        synchronized (this.hjf) {
            try {
                List<Long> list = this.hjf.get(Integer.valueOf(i2));
                if (list == null) {
                    size = 0;
                } else {
                    size = list.size();
                    AppMethodBeat.o(186173);
                }
            } finally {
                AppMethodBeat.o(186173);
            }
        }
        return size;
    }

    public final String toString() {
        AppMethodBeat.i(186174);
        String sb = new StringBuilder("(").append(("TYPE_CONTEXT_CNT:" + pz(17)) + APLogFileUtil.SEPARATOR_LOG + ("TYPE_SURFACE_CNT:" + pz(18))).append(")    (").append(axm()).append(")").toString();
        AppMethodBeat.o(186174);
        return sb;
    }

    private String axm() {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(186175);
        synchronized (this.hjf) {
            try {
                List<Long> list = this.hjf.get(17);
                List<Long> list2 = this.hjf.get(18);
                if (list == null || list.size() == 0) {
                    str = "[null]";
                } else {
                    str = list.toString();
                }
                if (list2 == null || list2.size() == 0) {
                    str2 = "[null]";
                } else {
                    str2 = list2.toString();
                }
                str3 = "egl context detail: " + str + "\negl surface detail: " + str2;
            } finally {
                AppMethodBeat.o(186175);
            }
        }
        return str3;
    }

    static /* synthetic */ void a(a aVar, b bVar) {
        AppMethodBeat.i(186176);
        synchronized (aVar.hjf) {
            try {
                int i2 = bVar.type;
                List<Long> list = aVar.hjf.get(Integer.valueOf(i2));
                if (list != null) {
                    if (list.contains(Long.valueOf(bVar.id))) {
                        if (i2 == 17) {
                            Log.e("Gpu.EGLAllResRecorder", "re create the same egl context, egl context.id= " + bVar.id);
                        } else {
                            Log.e("Gpu.EGLAllResRecorder", "re create the same egl surface, egl surface.id= " + bVar.id);
                        }
                        AppMethodBeat.o(186176);
                        return;
                    }
                    synchronized (list) {
                        try {
                            list.add(Long.valueOf(bVar.id));
                        } catch (Throwable th) {
                            AppMethodBeat.o(186176);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(186176);
                }
            } finally {
                AppMethodBeat.o(186176);
            }
        }
    }

    static /* synthetic */ void b(a aVar, b bVar) {
        AppMethodBeat.i(186177);
        synchronized (aVar.hjf) {
            try {
                int i2 = bVar.type;
                List<Long> list = aVar.hjf.get(Integer.valueOf(i2));
                if (list != null) {
                    if (!list.contains(Long.valueOf(bVar.id))) {
                        if (i2 == 17) {
                            Log.e("Gpu.EGLAllResRecorder", "egl context has been remove, context.id= " + bVar.id);
                        } else {
                            Log.e("Gpu.EGLAllResRecorder", "egl surface has been remove, surface.id= " + bVar.id);
                        }
                        AppMethodBeat.o(186177);
                        return;
                    }
                    synchronized (list) {
                        try {
                            Iterator<Long> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().longValue() == bVar.id) {
                                        it.remove();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(186177);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(186177);
                }
            } finally {
                AppMethodBeat.o(186177);
            }
        }
    }
}
