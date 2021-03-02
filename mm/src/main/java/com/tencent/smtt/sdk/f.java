package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import java.util.LinkedHashMap;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f2045a = "SDKEcService";

    /* renamed from: b  reason: collision with root package name */
    private static f f2046b;

    /* renamed from: c  reason: collision with root package name */
    private Map<Integer, a> f2047c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<Integer, String> f2048d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    private int f2049e = -1;

    public interface a {
        void a(String str);
    }

    public static f a() {
        AppMethodBeat.i(188389);
        if (f2046b == null) {
            f2046b = new f();
        }
        f fVar = f2046b;
        AppMethodBeat.o(188389);
        return fVar;
    }

    public f() {
        AppMethodBeat.i(188390);
        AppMethodBeat.o(188390);
    }

    public void a(int i2, a aVar) {
        AppMethodBeat.i(188391);
        if (this.f2048d.containsKey(Integer.valueOf(i2))) {
            String str = this.f2048d.get(Integer.valueOf(i2));
            this.f2048d.remove(Integer.valueOf(i2));
            aVar.a(str);
            TbsLog.e(f2045a, "Executed command: " + i2 + ", extra: " + str + ", emergency configuration has requested");
            AppMethodBeat.o(188391);
        } else if (this.f2049e == -1) {
            this.f2047c.put(Integer.valueOf(i2), aVar);
            TbsLog.e(f2045a, "Emergency configuration has not yet dispatched. Command query: " + i2 + " has been suspended");
            AppMethodBeat.o(188391);
        } else {
            TbsLog.e(f2045a, "Emergency configuration has been dispatched, status: " + this.f2049e + ". Command query: " + i2 + " ignored");
            AppMethodBeat.o(188391);
        }
    }

    public void a(int i2, Map<Integer, String> map) {
        AppMethodBeat.i(188392);
        TbsLog.e(f2045a, "Handle emergency commands in sdk, status: ".concat(String.valueOf(i2)));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (i2 == 0) {
            for (Integer num : map.keySet()) {
                if (this.f2047c.containsKey(num)) {
                    a aVar = this.f2047c.get(num);
                    if (aVar != null) {
                        aVar.a(map.get(num));
                    }
                } else {
                    String str = map.get(num);
                    if (str == null) {
                        str = "";
                    }
                    linkedHashMap.put(num, str);
                }
            }
        } else {
            this.f2047c.clear();
            TbsLog.e(f2045a, "Handle emergency commands failed, ignore all unhandled emergencies, status: ".concat(String.valueOf(i2)));
        }
        this.f2048d = linkedHashMap;
        this.f2049e = i2;
        AppMethodBeat.o(188392);
    }
}
