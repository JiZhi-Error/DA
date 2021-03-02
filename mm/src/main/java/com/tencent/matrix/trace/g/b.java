package com.tencent.matrix.trace.g;

import com.tencent.matrix.g.a;

public final class b {
    public static String getStack() {
        return a(new Throwable().getStackTrace());
    }

    public static String a(StackTraceElement[] stackTraceElementArr) {
        return a(stackTraceElementArr, "", -1);
    }

    public static String a(StackTraceElement[] stackTraceElementArr, String str, int i2) {
        int i3 = 3;
        if (stackTraceElementArr == null || stackTraceElementArr.length < 3) {
            return "";
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        StringBuilder sb = new StringBuilder(" \n");
        while (i3 < stackTraceElementArr.length - 3 && i3 < i2) {
            sb.append(str);
            sb.append("at ");
            sb.append(stackTraceElementArr[i3].getClassName());
            sb.append(":");
            sb.append(stackTraceElementArr[i3].getMethodName());
            sb.append("(" + stackTraceElementArr[i3].getLineNumber() + ")");
            sb.append("\n");
            i3++;
        }
        return sb.toString();
    }

    public static String q(long j2, long j3) {
        if (j2 <= 0) {
            return j3 > 1000 ? "0%" : "100%";
        }
        if (j2 >= j3) {
            return "100%";
        }
        return String.format("%.2f", Float.valueOf(((1.0f * ((float) j2)) / ((float) j3)) * 100.0f)) + "%";
    }

    public static boolean eP(String str) {
        return str == null || str.equals("");
    }

    public static int[] ix(int i2) {
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        try {
            String[] split = a.getStringFromFile(String.format("/proc/%s/stat", Integer.valueOf(i2))).trim().split(" ");
            if (split.length >= 19) {
                i4 = Integer.parseInt(split[17].trim());
                i3 = Integer.parseInt(split[18].trim());
            }
            return new int[]{i4, i3};
        } catch (Exception e2) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
    }
}
