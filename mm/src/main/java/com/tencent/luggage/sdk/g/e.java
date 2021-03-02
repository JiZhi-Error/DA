package com.tencent.luggage.sdk.g;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/luggage/sdk/wxa_ktx/WebkitUtils;", "", "()V", "println", "", "Landroid/webkit/ConsoleMessage;", "tag", "", "luggage-wxa-app_release"})
public final class e {
    public static final e cCL = new e();

    static {
        AppMethodBeat.i(176453);
        AppMethodBeat.o(176453);
    }

    private e() {
    }

    public static final void a(ConsoleMessage consoleMessage, String str) {
        int i2;
        AppMethodBeat.i(176452);
        p.h(str, "tag");
        ConsoleMessage.MessageLevel messageLevel = consoleMessage != null ? consoleMessage.messageLevel() : null;
        if (messageLevel == null) {
            AppMethodBeat.o(176452);
            return;
        }
        switch (f.$EnumSwitchMapping$0[messageLevel.ordinal()]) {
            case 1:
            case 2:
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 5;
                break;
            case 5:
                i2 = 6;
                break;
            default:
                m mVar = new m();
                AppMethodBeat.o(176452);
                throw mVar;
        }
        Log.println(i2, str, "ConsoleMessage: message:" + consoleMessage.message() + ", sourceId:" + consoleMessage.sourceId() + ", lineNumber:" + consoleMessage.lineNumber());
        AppMethodBeat.o(176452);
    }
}
