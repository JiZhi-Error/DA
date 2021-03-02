package com.tencent.tav.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;
import java.util.Map;

public class TimePrinter {
    private static Map<String, TimePrinter> constMap = new HashMap();
    private static Map<String, TimePrinter> printerMap = new HashMap();
    private String TAG = "TimeDebug";
    private CMTime currentSyncTime;
    private long currentTimeUs;

    static {
        AppMethodBeat.i(218729);
        AppMethodBeat.o(218729);
    }

    public static synchronized void print(String str, CMTime cMTime) {
        synchronized (TimePrinter.class) {
            AppMethodBeat.i(218723);
            TimePrinter timePrinter = printerMap.get(str);
            if (timePrinter == null) {
                timePrinter = new TimePrinter(str);
                printerMap.put(str, timePrinter);
            }
            timePrinter.print(cMTime);
            AppMethodBeat.o(218723);
        }
    }

    public static synchronized void printCons(String str) {
        synchronized (TimePrinter.class) {
            AppMethodBeat.i(218724);
            TimePrinter timePrinter = constMap.get(str);
            if (timePrinter == null) {
                constMap.put(str, new TimePrinter(str, System.nanoTime() / 1000));
                AppMethodBeat.o(218724);
            } else {
                timePrinter.printCons();
                constMap.remove(str);
                AppMethodBeat.o(218724);
            }
        }
    }

    public TimePrinter(String str) {
        AppMethodBeat.i(218725);
        this.TAG += "-" + str;
        AppMethodBeat.o(218725);
    }

    public TimePrinter(String str, long j2) {
        AppMethodBeat.i(218726);
        this.TAG += "-" + str;
        this.currentTimeUs = j2;
        AppMethodBeat.o(218726);
    }

    public void print(CMTime cMTime) {
        AppMethodBeat.i(218727);
        if (this.currentSyncTime == null) {
            this.currentSyncTime = cMTime;
            AppMethodBeat.o(218727);
            return;
        }
        new StringBuilder("print: timeSub = ").append(cMTime.sub(this.currentSyncTime).getTimeUs());
        this.currentSyncTime = cMTime;
        AppMethodBeat.o(218727);
    }

    public void printCons() {
        AppMethodBeat.i(218728);
        new StringBuilder("printConst: const = ").append((System.nanoTime() / 1000) - this.currentTimeUs);
        AppMethodBeat.o(218728);
    }
}
