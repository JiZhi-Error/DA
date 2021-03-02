package com.tencent.mm.plugin.sight.encode.a;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a {
    boolean XB();

    long eVY();

    EnumC1698a eVZ();

    Camera.PreviewCallback eWa();

    int getDuration();

    String getRecordPath();

    /* renamed from: com.tencent.mm.plugin.sight.encode.a.a$a  reason: collision with other inner class name */
    public enum EnumC1698a {
        WaitStart,
        Start,
        PrepareStop,
        WaitStop,
        Stop,
        WaitSend,
        Sent,
        Error,
        Initialized,
        Pause;

        public static EnumC1698a valueOf(String str) {
            AppMethodBeat.i(28703);
            EnumC1698a aVar = (EnumC1698a) Enum.valueOf(EnumC1698a.class, str);
            AppMethodBeat.o(28703);
            return aVar;
        }

        static {
            AppMethodBeat.i(28704);
            AppMethodBeat.o(28704);
        }
    }
}
