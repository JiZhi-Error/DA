package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.b;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    private static b ndc = null;
    private static String ndd = null;
    private static AbstractC0752a nde = null;
    private static MTimerHandler ndf = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.a$a  reason: collision with other inner class name */
    public interface AbstractC0752a {
        void wM(int i2);
    }

    private static void stopTimer() {
        AppMethodBeat.i(146137);
        if (ndf != null) {
            ndf.stopTimer();
        }
        ndf = null;
        AppMethodBeat.o(146137);
    }

    public static boolean a(String str, AbstractC0752a aVar, int i2) {
        AppMethodBeat.i(146138);
        Log.i("MicroMsg.Record.AudioRecorder", JsApiStartRecordVoice.NAME);
        yv(1);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.Record.AudioRecorder", "startRecord, path is null or nil");
            AppMethodBeat.o(146138);
            return false;
        }
        b bVar = new b(c.a.SILK);
        ndc = bVar;
        if (bVar.dyJ == c.a.AMR) {
            if (bVar.dyH != null) {
                bVar.dyH.reset();
            }
        } else if (bVar.dyK != b.EnumC0271b.ERROR) {
            bVar.release();
            bVar.aae();
        }
        ndc.aac();
        ndc.aad();
        ndc.aab();
        ndc.setOutputFile(str);
        ndc.a(new b.a() {
            /* class com.tencent.mm.plugin.appbrand.media.record.a.AnonymousClass2 */

            @Override // com.tencent.mm.audio.b.b.a
            public final void onError() {
                AppMethodBeat.i(146136);
                Log.e("MicroMsg.Record.AudioRecorder", "onError");
                a.yv(-1);
                AppMethodBeat.o(146136);
            }
        });
        try {
            ndc.prepare();
            ndc.start();
            nde = aVar;
            ndd = str;
            stopTimer();
            MTimerHandler mTimerHandler = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.appbrand.media.record.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(146135);
                    a.yv(1);
                    AppMethodBeat.o(146135);
                    return false;
                }
            }, false);
            ndf = mTimerHandler;
            mTimerHandler.startTimer((long) i2);
            AppMethodBeat.o(146138);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.Record.AudioRecorder", "record prepare, exp = %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(146138);
            return false;
        }
    }

    public static void yv(int i2) {
        AppMethodBeat.i(146139);
        Log.i("MicroMsg.Record.AudioRecorder", "stopRecord what:%d", Integer.valueOf(i2));
        if (Util.isNullOrNil(ndd)) {
            AppMethodBeat.o(146139);
        } else if (ndc == null) {
            Log.i("MicroMsg.Record.AudioRecorder", "sRecorder is null,err");
            AppMethodBeat.o(146139);
        } else {
            ndc.Qt();
            ndc.release();
            ndc = null;
            stopTimer();
            ndd = null;
            if (nde != null) {
                nde.wM(i2);
            }
            nde = null;
            AppMethodBeat.o(146139);
        }
    }
}
