package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern bDP = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern bDQ = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    static {
        AppMethodBeat.i(92916);
        AppMethodBeat.o(92916);
    }

    public static void I(m mVar) {
        AppMethodBeat.i(92912);
        String readLine = mVar.readLine();
        if (readLine == null || !bDQ.matcher(readLine).matches()) {
            f fVar = new f("Expected WEBVTT. Got ".concat(String.valueOf(readLine)));
            AppMethodBeat.o(92912);
            throw fVar;
        }
        AppMethodBeat.o(92912);
    }

    public static long bn(String str) {
        AppMethodBeat.i(92913);
        long j2 = 0;
        String[] split = str.split("\\.", 2);
        for (String str2 : split[0].split(":")) {
            j2 = (j2 * 60) + Long.parseLong(str2);
        }
        long parseLong = (Long.parseLong(split[1]) + (j2 * 1000)) * 1000;
        AppMethodBeat.o(92913);
        return parseLong;
    }

    public static float bo(String str) {
        AppMethodBeat.i(92914);
        if (!str.endsWith("%")) {
            NumberFormatException numberFormatException = new NumberFormatException("Percentages must end with %");
            AppMethodBeat.o(92914);
            throw numberFormatException;
        }
        float parseFloat = Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        AppMethodBeat.o(92914);
        return parseFloat;
    }

    public static Matcher J(m mVar) {
        String readLine;
        AppMethodBeat.i(92915);
        while (true) {
            String readLine2 = mVar.readLine();
            if (readLine2 == null) {
                AppMethodBeat.o(92915);
                return null;
            } else if (bDP.matcher(readLine2).matches()) {
                do {
                    readLine = mVar.readLine();
                    if (readLine == null) {
                        break;
                    }
                } while (!readLine.isEmpty());
            } else {
                Matcher matcher = f.bDF.matcher(readLine2);
                if (matcher.matches()) {
                    AppMethodBeat.o(92915);
                    return matcher;
                }
            }
        }
    }
}
