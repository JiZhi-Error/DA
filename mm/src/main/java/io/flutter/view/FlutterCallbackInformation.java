package io.flutter.view;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;

@Keep
public final class FlutterCallbackInformation {
    public final String callbackClassName;
    public final String callbackLibraryPath;
    public final String callbackName;

    public static FlutterCallbackInformation lookupCallbackInformation(long j2) {
        AppMethodBeat.i(9825);
        FlutterCallbackInformation nativeLookupCallbackInformation = FlutterJNI.nativeLookupCallbackInformation(j2);
        AppMethodBeat.o(9825);
        return nativeLookupCallbackInformation;
    }

    private FlutterCallbackInformation(String str, String str2, String str3) {
        this.callbackName = str;
        this.callbackClassName = str2;
        this.callbackLibraryPath = str3;
    }
}
