package com.eclipsesource.v8;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Inspector {
    private static JsInspectorChannelServer _server;

    public interface JsInspectorChannelServer {
        int notify(long j2, long j3, String str);

        int sendData(long j2, String str);
    }

    static native int JniNotify(long j2, long j3, String str);

    static native void JniReceiveData(long j2, String str);

    public static void setServer(JsInspectorChannelServer jsInspectorChannelServer) {
        _server = jsInspectorChannelServer;
    }

    public static void onReceiveData(long j2, String str) {
        AppMethodBeat.i(62123);
        JniReceiveData(j2, str);
        AppMethodBeat.o(62123);
    }

    public static int notify(long j2, long j3, String str) {
        AppMethodBeat.i(62124);
        int JniNotify = JniNotify(j2, j3, str);
        AppMethodBeat.o(62124);
        return JniNotify;
    }

    @Keep
    public static int jniCallbackSendData(long j2, String str) {
        AppMethodBeat.i(62125);
        if (_server == null) {
            AppMethodBeat.o(62125);
            return -1;
        }
        int sendData = _server.sendData(j2, str);
        AppMethodBeat.o(62125);
        return sendData;
    }

    @Keep
    public static int jniCallbackNotify(long j2, long j3, String str) {
        AppMethodBeat.i(62126);
        if (_server == null) {
            AppMethodBeat.o(62126);
            return -1;
        }
        int notify = _server.notify(j2, j3, str);
        AppMethodBeat.o(62126);
        return notify;
    }
}
