package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public final class a implements IKeyStepAnalyser {
    public final void a(final String str, final Pattern pattern, final long j2, final IKeyStepAnalyser.a aVar) {
        AppMethodBeat.i(221240);
        new MMHandler(String.format(Locale.ENGLISH, "KeyStepAnalyser:%s", str)).post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(221239);
                a aVar = a.this;
                String str = str;
                Pattern pattern = pattern;
                long j2 = j2;
                IKeyStepAnalyser.a aVar2 = aVar;
                Log.i("MicroMsg.KeyStepAnalyser", "doAnalyse processName:%s sessionIdPattern:%s", str, pattern.pattern());
                if (aVar2 != null) {
                    List<String> V = c.bMQ().V(str, j2);
                    if (V == null || V.isEmpty()) {
                        Log.i("MicroMsg.KeyStepAnalyser", "no keystep logs");
                        aVar2.bM(new ArrayList());
                        AppMethodBeat.o(221239);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < V.size(); i2++) {
                        List<IKeyStepAnalyser.StepLogInfo> f2 = a.f(V.get(i2), pattern);
                        if (!f2.isEmpty()) {
                            arrayList.add(f2);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Log.i("MicroMsg.KeyStepAnalyser", "no keystep logs");
                        aVar2.bM(new ArrayList());
                        AppMethodBeat.o(221239);
                        return;
                    }
                    aVar2.bM(a.bL(aVar.bK(arrayList)));
                }
                AppMethodBeat.o(221239);
            }
        });
        AppMethodBeat.o(221240);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[SYNTHETIC, Splitter:B:18:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A[SYNTHETIC, Splitter:B:29:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081 A[SYNTHETIC, Splitter:B:35:0x0081] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.List<com.tencent.mm.plugin.appbrand.keylogger.base.IKeyStepAnalyser.StepLogInfo> f(java.lang.String r8, java.util.regex.Pattern r9) {
        /*
        // Method dump skipped, instructions count: 147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.keylogger.a.f(java.lang.String, java.util.regex.Pattern):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final List<IKeyStepAnalyser.StepLogInfo> bK(List<List<IKeyStepAnalyser.StepLogInfo>> list) {
        AppMethodBeat.i(221242);
        ArrayList arrayList = new ArrayList();
        PriorityQueue priorityQueue = new PriorityQueue(list.size(), new Comparator<C0729a>() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.a.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(C0729a aVar, C0729a aVar2) {
                long j2 = aVar.mOw.time;
                long j3 = aVar2.mOw.time;
                if (j2 > j3) {
                    return 1;
                }
                if (j2 < j3) {
                    return -1;
                }
                return 0;
            }
        });
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!list.get(i3).isEmpty()) {
                C0729a aVar = new C0729a((byte) 0);
                aVar.mOw = list.get(i3).get(0);
                aVar.indexInArray = 0;
                aVar.mOx = i3;
                priorityQueue.add(aVar);
                i2 += list.get(i3).size();
            }
        }
        for (int i4 = 0; i4 < i2; i4++) {
            C0729a aVar2 = (C0729a) priorityQueue.poll();
            arrayList.add(aVar2.mOw);
            List<IKeyStepAnalyser.StepLogInfo> list2 = list.get(aVar2.mOx);
            int i5 = aVar2.indexInArray + 1;
            if (i5 >= list2.size()) {
                if (C0729a.mOy == null) {
                    C0729a.mOy = new C0729a();
                    IKeyStepAnalyser.StepLogInfo stepLogInfo = new IKeyStepAnalyser.StepLogInfo();
                    stepLogInfo.time = MAlarmHandler.NEXT_FIRE_INTERVAL;
                    C0729a.mOy.mOw = stepLogInfo;
                }
                priorityQueue.add(C0729a.mOy);
            } else {
                C0729a aVar3 = new C0729a((byte) 0);
                aVar3.mOw = list2.get(i5);
                aVar3.indexInArray = i5;
                aVar3.mOx = aVar2.mOx;
                priorityQueue.add(aVar3);
            }
        }
        AppMethodBeat.o(221242);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.keylogger.a$a  reason: collision with other inner class name */
    public static final class C0729a {
        static C0729a mOy;
        int indexInArray;
        IKeyStepAnalyser.StepLogInfo mOw;
        int mOx;

        C0729a() {
        }

        /* synthetic */ C0729a(byte b2) {
            this();
        }
    }

    static List<IKeyStepAnalyser.b> bL(List<IKeyStepAnalyser.StepLogInfo> list) {
        boolean z;
        boolean z2;
        IKeyStepAnalyser.b bVar;
        AppMethodBeat.i(221243);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        boolean z3 = false;
        IKeyStepAnalyser.b bVar2 = null;
        while (i2 < list.size()) {
            IKeyStepAnalyser.StepLogInfo stepLogInfo = list.get(i2);
            Log.v("MicroMsg.KeyStepAnalyser", "sortOutResult time:%d step:%s", Long.valueOf(stepLogInfo.time), stepLogInfo.mPw);
            if ("Start".equals(stepLogInfo.mPw)) {
                if (bVar2 != null) {
                    arrayList.add(0, bVar2);
                }
                hashMap.clear();
                bVar2 = new IKeyStepAnalyser.b();
                z = false;
                hashMap.put("Start", Long.valueOf(stepLogInfo.time));
            } else {
                z = z3;
            }
            if (bVar2 != null) {
                if ("stepStart".equals(stepLogInfo.errMsg)) {
                    hashMap.put(stepLogInfo.mPw, Long.valueOf(stepLogInfo.time));
                } else if ("CollectKeyInfo".equals(stepLogInfo.mPw)) {
                    bVar2.mPv.append(stepLogInfo.mPy).append("\n");
                } else {
                    if (hashMap.containsKey(stepLogInfo.mPw)) {
                        stepLogInfo.cCv = stepLogInfo.time - ((Long) hashMap.get(stepLogInfo.mPw)).longValue();
                    }
                    bVar2.mPu.add(stepLogInfo);
                }
            }
            if (!stepLogInfo.bMX() || bVar2 == null) {
                z2 = z;
                bVar = bVar2;
            } else {
                if (hashMap.containsKey("Start")) {
                    stepLogInfo.cCv = stepLogInfo.time - ((Long) hashMap.get("Start")).longValue();
                }
                arrayList.add(0, bVar2);
                z2 = true;
                bVar = null;
                hashMap.clear();
            }
            i2++;
            z3 = z2;
            bVar2 = bVar;
        }
        if (!z3 && bVar2 != null) {
            arrayList.add(0, bVar2);
        }
        AppMethodBeat.o(221243);
        return arrayList;
    }
}
