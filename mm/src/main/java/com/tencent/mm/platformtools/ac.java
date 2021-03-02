package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ac {
    public static boolean jNP = false;
    public static boolean jNQ = false;
    public static boolean jNR = false;
    public static boolean jNS = false;
    public static boolean jNT = false;
    public static boolean jNU = false;
    public static boolean jNV = false;
    public static boolean jNW = false;
    public static boolean jNX = false;
    public static boolean jNY = false;
    public static boolean jNZ = false;
    public static boolean jOA = false;
    public static int jOB = 0;
    public static int jOC = 0;
    public static int jOD = 0;
    public static String jOE = "";
    public static String jOF = "";
    public static String jOG = null;
    public static String jOH = null;
    public static boolean jOI = false;
    public static boolean jOJ = false;
    public static boolean jOK = false;
    public static boolean jOL = false;
    public static String jOM = "";
    public static String jON = "";
    public static String jOO = "";
    public static String jOP = "";
    public static String jOQ = "";
    public static boolean jOR = false;
    public static boolean jOS = false;
    public static boolean jOT = false;
    public static int jOU = 0;
    public static boolean jOV = false;
    public static boolean jOW = false;
    public static boolean jOX = false;
    public static boolean jOY = false;
    public static boolean jOZ = false;
    public static boolean jOa = false;
    public static String jOb = "";
    public static boolean jOc = false;
    public static boolean jOd = false;
    public static boolean jOe = false;
    public static boolean jOf = false;
    public static int jOg = 0;
    public static boolean jOh = false;
    public static boolean jOi = false;
    public static boolean jOj = false;
    public static String jOk = "";
    public static String jOl = "";
    public static boolean jOm = false;
    public static boolean jOn = false;
    public static boolean jOo = false;
    public static boolean jOp = false;
    public static boolean jOq = false;
    public static boolean jOr = false;
    public static boolean jOs = false;
    public static boolean jOt = false;
    public static int jOu = 0;
    public static int jOv = 0;
    public static boolean jOw = false;
    public static String jOx = null;
    public static String jOy = null;
    public static boolean jOz = false;
    public static boolean jPA = false;
    public static boolean jPB = false;
    public static boolean jPC = false;
    public static boolean jPD = false;
    public static boolean jPE = false;
    public static boolean jPF = false;
    public static boolean jPG = false;
    public static boolean jPH = false;
    public static boolean jPI = false;
    public static boolean jPJ = false;
    public static int jPK = 0;
    private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> jPL = new HashMap<>();
    public static boolean jPM = false;
    public static boolean jPN = false;
    public static boolean jPO = false;
    public static String jPa = "";
    public static int jPb = 0;
    public static boolean jPc = false;
    public static boolean jPd = true;
    public static boolean jPe = false;
    public static boolean jPf = false;
    public static String jPg = "";
    public static int jPh = 0;
    public static boolean jPi = false;
    public static boolean jPj = false;
    public static int jPk = -1;
    public static boolean jPl = false;
    public static String jPm = "";
    public static float jPn = 0.4f;
    public static float jPo = 0.7f;
    public static boolean jPp = false;
    public static int jPq = 0;
    public static int jPr = 0;
    public static boolean jPs = false;
    public static String jPt = "";
    public static String jPu = "";
    public static boolean jPv = false;
    public static boolean jPw = false;
    public static String jPx = "";
    public static String jPy = "";
    public static boolean jPz = false;
    public static double lat = 0.0d;
    public static double lng = 0.0d;

    static {
        AppMethodBeat.i(132987);
        AppMethodBeat.o(132987);
    }

    public static void dF(int i2, int i3) {
        AppMethodBeat.i(132986);
        synchronized (jPL) {
            try {
                ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = jPL.get(Integer.valueOf(i2));
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                    jPL.put(Integer.valueOf(i2), concurrentLinkedQueue);
                }
                concurrentLinkedQueue.add(Integer.valueOf(i3));
            } finally {
                AppMethodBeat.o(132986);
            }
        }
    }
}
