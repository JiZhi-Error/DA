package io.flutter.plugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;

final class a {
    final FlutterJNI SNV;

    public a(FlutterJNI flutterJNI) {
        this.SNV = flutterJNI;
    }

    public final boolean atx(int i2) {
        AppMethodBeat.i(214906);
        boolean nativeFlutterTextUtilsIsEmoji = this.SNV.nativeFlutterTextUtilsIsEmoji(i2);
        AppMethodBeat.o(214906);
        return nativeFlutterTextUtilsIsEmoji;
    }

    public final boolean aty(int i2) {
        AppMethodBeat.i(214907);
        boolean nativeFlutterTextUtilsIsVariationSelector = this.SNV.nativeFlutterTextUtilsIsVariationSelector(i2);
        AppMethodBeat.o(214907);
        return nativeFlutterTextUtilsIsVariationSelector;
    }

    public final boolean atz(int i2) {
        AppMethodBeat.i(214908);
        boolean nativeFlutterTextUtilsIsRegionalIndicator = this.SNV.nativeFlutterTextUtilsIsRegionalIndicator(i2);
        AppMethodBeat.o(214908);
        return nativeFlutterTextUtilsIsRegionalIndicator;
    }

    public static boolean atA(int i2) {
        return (48 <= i2 && i2 <= 57) || i2 == 35 || i2 == 42;
    }
}
