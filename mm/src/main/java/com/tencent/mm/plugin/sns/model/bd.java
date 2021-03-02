package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class bd implements f {
    private static ConcurrentHashMap<String, b> DOv = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, WeakReference<b>> DOw = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(96001);
        AppMethodBeat.o(96001);
    }

    /* access modifiers changed from: package-private */
    public class a {
        long DOy = -1;
        cnd DOz;
        String filePath;
        String mediaId;
        int mediaType;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        long DOA = -1;
        int DOB = 0;
        long DOC = -1;
        ArrayList<String> DOD = new ArrayList<>();
        HashMap<String, a> DOE = new HashMap<>();
        long DOy = -1;
        long endTime = -1;
        int iAC = 0;
        long startTime = -1;
        boolean xZv = false;

        b() {
            AppMethodBeat.i(95994);
            AppMethodBeat.o(95994);
        }
    }

    public static void aPt(String str) {
        b bVar;
        AppMethodBeat.i(95995);
        if (ac.jPe) {
            Log.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", str);
        }
        WeakReference<b> weakReference = DOw.get(str);
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            AppMethodBeat.o(95995);
            return;
        }
        bVar.xZv = true;
        AppMethodBeat.o(95995);
    }

    public static void fF(String str, int i2) {
        b bVar;
        HashMap<String, a> hashMap;
        a aVar;
        AppMethodBeat.i(202794);
        if (ac.jPe) {
            Log.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", str);
        }
        WeakReference<b> weakReference = DOw.get(str);
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            AppMethodBeat.o(202794);
            return;
        }
        if (bVar != null && bVar.DOy == -1 && (hashMap = bVar.DOE) != null && hashMap.containsKey(str) && (aVar = hashMap.get(str)) != null && aVar.DOy == -1) {
            aVar.DOy = 1;
            aVar.mediaType = i2;
            bVar.DOB++;
        }
        AppMethodBeat.o(202794);
    }

    public static void aPu(String str) {
        AppMethodBeat.i(95997);
        Log.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", str);
        if (DOv.containsKey(str)) {
            Log.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", str);
            b bVar = DOv.get(str);
            if (!(bVar == null || bVar.DOy != -1 || bVar.startTime == -1)) {
                bVar.DOy = 1;
                bVar.DOB = bVar.iAC;
                bVar.endTime = System.currentTimeMillis();
                bVar.DOA = bVar.endTime - bVar.startTime;
                for (a aVar : bVar.DOE.values()) {
                    aVar.DOy = 1;
                }
            }
        }
        AppMethodBeat.o(95997);
    }

    @Override // com.tencent.mm.plugin.sns.model.f
    public final void a(String str, TimeLineObject timeLineObject) {
        AppMethodBeat.i(95998);
        if (!DOv.containsKey(str)) {
            if (ac.jPe) {
                Log.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", str);
            }
            if (timeLineObject != null && timeLineObject.ContentObj != null && timeLineObject.ContentObj.LoU == 1 && timeLineObject.ContentObj.LoV != null && timeLineObject.ContentObj.LoV.size() > 0) {
                b bVar = new b();
                bVar.iAC = timeLineObject.ContentObj.LoV.size();
                bVar.DOB = 0;
                bVar.DOC = r.aOw(timeLineObject.Id);
                bVar.DOE = new HashMap<>();
                Iterator<cnb> it = timeLineObject.ContentObj.LoV.iterator();
                while (it.hasNext()) {
                    cnb next = it.next();
                    a aVar = new a();
                    aVar.mediaId = next.Id;
                    aVar.DOz = next.MsB;
                    String ki = ar.ki(aj.getAccSnsPath(), next.Id);
                    aVar.filePath = ki + r.e(next);
                    bVar.DOD.add(next.Id);
                    bVar.DOE.put(next.Id, aVar);
                    DOw.put(next.Id, new WeakReference<>(bVar));
                }
                bVar.startTime = System.currentTimeMillis();
                DOv.put(str, bVar);
                AppMethodBeat.o(95998);
                return;
            } else if (ac.jPe) {
                Log.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
            }
        }
        AppMethodBeat.o(95998);
    }

    @Override // com.tencent.mm.plugin.sns.model.f
    public final void aOU(String str) {
        AppMethodBeat.i(95999);
        if (DOv.containsKey(str)) {
            if (ac.jPe) {
                Log.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", str);
            }
            b bVar = DOv.get(str);
            if (!(bVar == null || bVar.startTime == -1 || bVar.DOy != -1)) {
                bVar.endTime = System.currentTimeMillis();
                bVar.DOA = bVar.endTime - bVar.startTime;
                if (bVar.DOB == bVar.iAC) {
                    bVar.DOy = 1;
                    AppMethodBeat.o(95999);
                    return;
                }
                bVar.DOy = 2;
            }
        }
        AppMethodBeat.o(95999);
    }

    @Override // com.tencent.mm.plugin.sns.model.f
    public final void fac() {
        AppMethodBeat.i(96000);
        h.RTc.aY(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.bd.AnonymousClass1 */

            public final void run() {
                int i2;
                int i3;
                AppMethodBeat.i(202793);
                synchronized (bd.this) {
                    try {
                        Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", Integer.valueOf(bd.DOv.size()));
                        int eZw = r.eZw();
                        for (String str : bd.DOv.keySet()) {
                            b bVar = (b) bd.DOv.get(str);
                            if (bVar != null && bVar.xZv) {
                                if (bVar.DOA != -1 && bVar.DOy != -1 && bVar.startTime != -1) {
                                    StringBuilder sb = new StringBuilder();
                                    StringBuilder sb2 = new StringBuilder();
                                    StringBuilder sb3 = new StringBuilder();
                                    int i4 = 0;
                                    Iterator<String> it = bVar.DOD.iterator();
                                    while (it.hasNext()) {
                                        a aVar = bVar.DOE.get(it.next());
                                        if (aVar != null) {
                                            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(aVar.filePath);
                                            int i5 = 0;
                                            int i6 = 0;
                                            if (imageOptions != null) {
                                                i5 = imageOptions.outWidth;
                                                i6 = imageOptions.outHeight;
                                            }
                                            sb.append(i5).append("|");
                                            sb2.append(i6).append("|");
                                            sb3.append(0).append("|");
                                            i3 = aVar.mediaType;
                                        } else {
                                            i3 = i4;
                                        }
                                        i4 = i3;
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11600, Integer.valueOf(bVar.iAC), Long.valueOf(bVar.DOy), Long.valueOf(bVar.DOA), Integer.valueOf(bVar.DOB), Integer.valueOf(eZw), Long.valueOf(bVar.DOC), Long.valueOf(bVar.startTime), sb.toString(), sb2.toString(), sb3.toString(), Integer.valueOf(i4));
                                    Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", Integer.valueOf(bVar.iAC), Long.valueOf(bVar.DOy), Long.valueOf(bVar.DOA), Integer.valueOf(bVar.DOB), Integer.valueOf(eZw), Long.valueOf(bVar.DOC), Long.valueOf(bVar.startTime), sb.toString(), sb2.toString(), sb3.toString(), Integer.valueOf(i4));
                                } else if (bVar.startTime != -1) {
                                    bVar.endTime = System.currentTimeMillis();
                                    bVar.DOA = bVar.endTime - bVar.startTime;
                                    if (bVar.iAC == bVar.DOB) {
                                        bVar.DOy = 1;
                                    } else {
                                        bVar.DOy = 2;
                                    }
                                    StringBuilder sb4 = new StringBuilder();
                                    StringBuilder sb5 = new StringBuilder();
                                    StringBuilder sb6 = new StringBuilder();
                                    int i7 = 0;
                                    Iterator<String> it2 = bVar.DOD.iterator();
                                    while (it2.hasNext()) {
                                        a aVar2 = bVar.DOE.get(it2.next());
                                        if (aVar2 != null) {
                                            BitmapFactory.Options imageOptions2 = BitmapUtil.getImageOptions(aVar2.filePath);
                                            int i8 = 0;
                                            int i9 = 0;
                                            if (imageOptions2 != null) {
                                                i8 = imageOptions2.outWidth;
                                                i9 = imageOptions2.outHeight;
                                            }
                                            sb4.append(i8).append("|");
                                            sb5.append(i9).append("|");
                                            sb6.append(0).append("|");
                                            i2 = aVar2.mediaType;
                                        } else {
                                            i2 = i7;
                                        }
                                        i7 = i2;
                                    }
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11600, Integer.valueOf(bVar.iAC), Long.valueOf(bVar.DOy), Long.valueOf(bVar.DOA), Integer.valueOf(bVar.DOB), Integer.valueOf(eZw), Long.valueOf(bVar.DOC), Long.valueOf(bVar.startTime), sb4.toString(), sb5.toString(), sb6.toString(), Integer.valueOf(i7));
                                    Log.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d, publishId:%s, startTime:%s, picWidth:%s,picHeight:%s,picSize:%s,picTye:%s", Integer.valueOf(bVar.iAC), Long.valueOf(bVar.DOy), Long.valueOf(bVar.DOA), Integer.valueOf(bVar.DOB), Integer.valueOf(eZw), Long.valueOf(bVar.DOC), Long.valueOf(bVar.startTime), sb4.toString(), sb5.toString(), sb6.toString(), Integer.valueOf(i7));
                                }
                            }
                        }
                        bd.DOv.clear();
                        bd.DOw.clear();
                    } catch (Throwable th) {
                        AppMethodBeat.o(202793);
                        throw th;
                    }
                }
                AppMethodBeat.o(202793);
            }
        });
        AppMethodBeat.o(96000);
    }
}
