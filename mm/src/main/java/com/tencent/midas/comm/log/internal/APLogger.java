package com.tencent.midas.comm.log.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.Locale;

public class APLogger {
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_SILENT = 6;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    private APLogAppender appender = null;

    private APLogger() {
    }

    private void openAppender() {
        AppMethodBeat.i(193423);
        this.appender = APLogAppender.open();
        AppMethodBeat.o(193423);
    }

    public static APLogger open() {
        AppMethodBeat.i(193424);
        APLogger aPLogger = new APLogger();
        aPLogger.openAppender();
        AppMethodBeat.o(193424);
        return aPLogger;
    }

    public void flush() {
        AppMethodBeat.i(193425);
        try {
            if (this.appender != null) {
                this.appender.flushAndWrite();
            }
            AppMethodBeat.o(193425);
        } catch (Throwable th) {
            String.format(Locale.CHINA, "flush log error: %s\n, stackTrace: %s", th.toString(), th.getStackTrace()[3]);
            AppMethodBeat.o(193425);
        }
    }

    public void write(String str) {
        AppMethodBeat.i(193426);
        this.appender.append(str);
        AppMethodBeat.o(193426);
    }

    public static void log(int i2, String str, String str2) {
        AppMethodBeat.i(193427);
        int i3 = 0;
        while (i3 < str2.length()) {
            try {
                if (str2.length() <= i3 + LocalCache.TIME_HOUR) {
                    str2.substring(i3);
                } else {
                    str2.substring(i3, i3 + LocalCache.TIME_HOUR);
                }
                i3 += LocalCache.TIME_HOUR;
                switch (i2) {
                }
            } catch (Throwable th) {
                String.format(Locale.CHINA, "print log error: <%s>%s", th.getClass().getName(), th.getMessage());
                AppMethodBeat.o(193427);
                return;
            }
        }
        AppMethodBeat.o(193427);
    }
}
