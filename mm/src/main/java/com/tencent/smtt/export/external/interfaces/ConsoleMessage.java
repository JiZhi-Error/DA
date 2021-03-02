package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ConsoleMessage {
    int lineNumber();

    String message();

    MessageLevel messageLevel();

    String sourceId();

    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG;

        public static MessageLevel valueOf(String str) {
            AppMethodBeat.i(53202);
            MessageLevel messageLevel = (MessageLevel) Enum.valueOf(MessageLevel.class, str);
            AppMethodBeat.o(53202);
            return messageLevel;
        }

        static {
            AppMethodBeat.i(53203);
            AppMethodBeat.o(53203);
        }
    }
}
