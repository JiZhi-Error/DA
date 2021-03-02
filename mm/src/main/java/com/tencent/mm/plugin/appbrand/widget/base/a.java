package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public static void a(String str, String str2, MotionEvent motionEvent) {
        AppMethodBeat.i(131467);
        if (Log.getLogLevel() > 0) {
            AppMethodBeat.o(131467);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2).append(' ');
        sb.append("[apptouch] MotionEvent { action=").append(actionToString(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            sb.append(", x[").append(i2).append("]=").append(motionEvent.getX(i2));
            sb.append(", y[").append(i2).append("]=").append(motionEvent.getY(i2));
        }
        sb.append(", downTime=").append(motionEvent.getDownTime());
        sb.append(" }");
        Log.v(str, sb.toString());
        AppMethodBeat.o(131467);
    }

    public static String K(MotionEvent motionEvent) {
        AppMethodBeat.i(131468);
        StringBuilder sb = new StringBuilder();
        sb.append("MotionEvent { action=").append(actionToString(motionEvent.getAction()));
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            sb.append(", x[").append(i2).append("]=").append(motionEvent.getX(i2));
            sb.append(", y[").append(i2).append("]=").append(motionEvent.getY(i2));
        }
        sb.append(", downTime=").append(motionEvent.getDownTime());
        sb.append(" }");
        String sb2 = sb.toString();
        AppMethodBeat.o(131468);
        return sb2;
    }

    private static String actionToString(int i2) {
        AppMethodBeat.i(131469);
        switch (i2) {
            case 0:
                AppMethodBeat.o(131469);
                return "ACTION_DOWN";
            case 1:
                AppMethodBeat.o(131469);
                return "ACTION_UP";
            case 2:
                AppMethodBeat.o(131469);
                return "ACTION_MOVE";
            case 3:
                AppMethodBeat.o(131469);
                return "ACTION_CANCEL";
            case 4:
                AppMethodBeat.o(131469);
                return "ACTION_OUTSIDE";
            case 5:
            case 6:
            default:
                int i3 = (65280 & i2) >> 8;
                switch (i2 & 255) {
                    case 5:
                        String str = "ACTION_POINTER_DOWN(" + i3 + ")";
                        AppMethodBeat.o(131469);
                        return str;
                    case 6:
                        String str2 = "ACTION_POINTER_UP(" + i3 + ")";
                        AppMethodBeat.o(131469);
                        return str2;
                    default:
                        String num = Integer.toString(i2);
                        AppMethodBeat.o(131469);
                        return num;
                }
            case 7:
                AppMethodBeat.o(131469);
                return "ACTION_HOVER_MOVE";
            case 8:
                AppMethodBeat.o(131469);
                return "ACTION_SCROLL";
            case 9:
                AppMethodBeat.o(131469);
                return "ACTION_HOVER_ENTER";
            case 10:
                AppMethodBeat.o(131469);
                return "ACTION_HOVER_EXIT";
            case 11:
                AppMethodBeat.o(131469);
                return "ACTION_BUTTON_PRESS";
            case 12:
                AppMethodBeat.o(131469);
                return "ACTION_BUTTON_RELEASE";
        }
    }
}
