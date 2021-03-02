package com.tencent.mm.gpu.d;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c {
    private static c hjj = new c();
    private Map<Integer, Map<Long, List<d>>> hjf = new HashMap();
    public Handler hjg;
    private HandlerThread mHandlerThread = new HandlerThread("OpenGLAllResRecorder");

    static {
        AppMethodBeat.i(186192);
        AppMethodBeat.o(186192);
    }

    private c() {
        AppMethodBeat.i(186183);
        this.mHandlerThread.start();
        this.hjg = new Handler(this.mHandlerThread.getLooper());
        this.hjf.put(1, new HashMap());
        this.hjf.put(2, new HashMap());
        this.hjf.put(3, new HashMap());
        this.hjf.put(4, new HashMap());
        AppMethodBeat.o(186183);
    }

    public static c axn() {
        return hjj;
    }

    public final void ae(final List<d> list) {
        AppMethodBeat.i(186184);
        this.hjg.post(new Runnable() {
            /* class com.tencent.mm.gpu.d.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186179);
                if (list == null || list.size() == 0) {
                    AppMethodBeat.o(186179);
                    return;
                }
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c.a(c.this, (d) list.get(i2));
                }
                AppMethodBeat.o(186179);
            }
        });
        AppMethodBeat.o(186184);
    }

    public final void af(final List<d> list) {
        AppMethodBeat.i(186185);
        this.hjg.post(new Runnable() {
            /* class com.tencent.mm.gpu.d.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(186180);
                if (list == null || list.size() == 0) {
                    AppMethodBeat.o(186180);
                    return;
                }
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c.b(c.this, (d) list.get(i2));
                }
                AppMethodBeat.o(186180);
            }
        });
        AppMethodBeat.o(186185);
    }

    public final int pz(int i2) {
        AppMethodBeat.i(186186);
        synchronized (this.hjf) {
            try {
                Map<Long, List<d>> map = this.hjf.get(Integer.valueOf(i2));
                if (map == null) {
                    return 0;
                }
                int i3 = 0;
                for (Long l : map.keySet()) {
                    List<d> list = map.get(l);
                    if (list != null) {
                        i3 += list.size();
                    }
                }
                AppMethodBeat.o(186186);
                return i3;
            } finally {
                AppMethodBeat.o(186186);
            }
        }
    }

    private int axo() {
        int size;
        AppMethodBeat.i(186187);
        synchronized (this.hjf) {
            try {
                HashSet hashSet = new HashSet();
                for (Map<Long, List<d>> map : this.hjf.values()) {
                    for (Long l : map.keySet()) {
                        hashSet.add(l);
                    }
                }
                size = hashSet.size();
            } finally {
                AppMethodBeat.o(186187);
            }
        }
        return size;
    }

    private String axm() {
        String str;
        AppMethodBeat.i(186188);
        synchronized (this.hjf) {
            try {
                HashSet<Long> hashSet = new HashSet();
                for (Map<Long, List<d>> map : this.hjf.values()) {
                    for (Long l : map.keySet()) {
                        hashSet.add(l);
                    }
                }
                Map<Long, List<d>> map2 = this.hjf.get(1);
                Map<Long, List<d>> map3 = this.hjf.get(2);
                Map<Long, List<d>> map4 = this.hjf.get(3);
                Map<Long, List<d>> map5 = this.hjf.get(4);
                String str2 = "";
                String str3 = "";
                for (Long l2 : hashSet) {
                    str2 = str2.equals("") ? String.valueOf(l2) : str2 + "," + l2;
                    String str4 = l2 + "-";
                    List<d> list = map2.get(l2);
                    int size = list == null ? 0 : list.size();
                    if (size > 0) {
                        str4 = str4 + "t" + size;
                    }
                    List<d> list2 = map3.get(l2);
                    int size2 = list2 == null ? 0 : list2.size();
                    if (size2 > 0) {
                        str4 = str4 + "b" + size2;
                    }
                    List<d> list3 = map4.get(l2);
                    int size3 = list3 == null ? 0 : list3.size();
                    String str5 = size3 > 0 ? str4 + "f" + size3 : str4;
                    List<d> list4 = map5.get(l2);
                    int size4 = list4 == null ? 0 : list4.size();
                    str3 = str3 + (size4 > 0 ? str5 + "r" + size4 : str5) + "@";
                }
                str = "EGL CONTEXT IDS:[" + str2 + "],details:" + str3;
            } finally {
                AppMethodBeat.o(186188);
            }
        }
        return str;
    }

    public final String toString() {
        AppMethodBeat.i(186189);
        String sb = new StringBuilder("(").append(("TYPE_TEXTURES_CNT:" + pz(1)) + APLogFileUtil.SEPARATOR_LOG + ("TYPE_TEXTURES_CNT:" + pz(2)) + APLogFileUtil.SEPARATOR_LOG + ("TYPE_FRAMEBUFFERS_CNT:" + pz(3)) + APLogFileUtil.SEPARATOR_LOG + ("TYPE_RENDERBUFFERS_CNT:" + pz(4)) + " | EGL CONTEXT CNT:" + axo()).append(")    (").append(axm()).append(")").toString();
        AppMethodBeat.o(186189);
        return sb;
    }

    static /* synthetic */ void a(c cVar, d dVar) {
        List<d> arrayList;
        AppMethodBeat.i(186190);
        synchronized (cVar.hjf) {
            try {
                Map<Long, List<d>> map = cVar.hjf.get(Integer.valueOf(dVar.type));
                if (map != null) {
                    if (map.containsKey(Long.valueOf(dVar.hjn))) {
                        arrayList = map.get(Long.valueOf(dVar.hjn));
                    } else {
                        arrayList = new ArrayList<>();
                        map.put(Long.valueOf(dVar.hjn), arrayList);
                    }
                    synchronized (arrayList) {
                        try {
                            arrayList.add(dVar);
                        } catch (Throwable th) {
                            AppMethodBeat.o(186190);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(186190);
                }
            } finally {
                AppMethodBeat.o(186190);
            }
        }
    }

    static /* synthetic */ void b(c cVar, d dVar) {
        AppMethodBeat.i(186191);
        synchronized (cVar.hjf) {
            try {
                Map<Long, List<d>> map = cVar.hjf.get(Integer.valueOf(dVar.type));
                if (map != null) {
                    List<d> list = null;
                    if (map.containsKey(Long.valueOf(dVar.hjn))) {
                        list = map.get(Long.valueOf(dVar.hjn));
                    }
                    if (list == null) {
                        Log.e("OpenGLAllResRecorder", "removeRecord error!");
                        AppMethodBeat.o(186191);
                        return;
                    }
                    synchronized (list) {
                        try {
                            Iterator<d> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().equals(dVar)) {
                                        it.remove();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(186191);
                            throw th;
                        }
                    }
                    AppMethodBeat.o(186191);
                }
            } finally {
                AppMethodBeat.o(186191);
            }
        }
    }
}
