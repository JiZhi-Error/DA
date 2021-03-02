package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RemoteController {
    private static Method juu;
    private static Method juv;
    private AudioManager jus;
    private ComponentName jut;

    public interface a {
    }

    public static class RemoteControlReceiver extends BroadcastReceiver {
        private static a juw;
        private static MTimerHandler timer;

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(148424);
            if (intent == null) {
                AppMethodBeat.o(148424);
            } else if (!"android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                Log.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + intent.getAction());
                AppMethodBeat.o(148424);
            } else {
                if (timer == null && juw != null) {
                    Log.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
                    timer = new MTimerHandler(new MTimerHandler.CallBack() {
                        /* class com.tencent.mm.modelvoice.RemoteController.RemoteControlReceiver.AnonymousClass1 */

                        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                        public final boolean onTimerExpired() {
                            AppMethodBeat.i(148423);
                            Log.d("MicroMsg.RemoteControlReceiver", "got remote key event up");
                            if (RemoteControlReceiver.juw != null) {
                                a unused = RemoteControlReceiver.juw;
                            }
                            MTimerHandler unused2 = RemoteControlReceiver.timer = null;
                            AppMethodBeat.o(148423);
                            return false;
                        }
                    }, true);
                }
                if (timer != null) {
                    timer.startTimer(1000);
                }
                AppMethodBeat.o(148424);
            }
        }

        public static void bhR() {
            AppMethodBeat.i(148425);
            juw = null;
            if (timer != null) {
                timer.stopTimer();
                timer = null;
            }
            AppMethodBeat.o(148425);
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(148426);
        try {
            if (juv != null) {
                juv.invoke(this.jus, this.jut);
                RemoteControlReceiver.bhR();
            }
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(148426);
                throw runtimeException;
            } else if (cause instanceof Error) {
                Error error = (Error) cause;
                AppMethodBeat.o(148426);
                throw error;
            } else {
                RuntimeException runtimeException2 = new RuntimeException(e2);
                AppMethodBeat.o(148426);
                throw runtimeException2;
            }
        } catch (IllegalAccessException e3) {
            Log.e("MicroMsg.RemoteControlReceiver", "unexpected ".concat(String.valueOf(e3)));
        }
        super.finalize();
        AppMethodBeat.o(148426);
    }

    static {
        AppMethodBeat.i(148427);
        try {
            if (juu == null) {
                juu = AudioManager.class.getMethod("registerMediaButtonEventReceiver", ComponentName.class);
            }
            if (juv == null) {
                juv = AudioManager.class.getMethod("unregisterMediaButtonEventReceiver", ComponentName.class);
            }
            AppMethodBeat.o(148427);
        } catch (NoSuchMethodException e2) {
            AppMethodBeat.o(148427);
        }
    }
}
