package io.flutter.embedding.engine.c;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.f;
import java.util.Map;

public final class b {
    public final io.flutter.plugin.a.b<Object> SPQ;

    public b(DartExecutor dartExecutor) {
        AppMethodBeat.i(10233);
        this.SPQ = new io.flutter.plugin.a.b<>(dartExecutor, "flutter/keyevent", f.SSk);
        AppMethodBeat.o(10233);
    }

    public static void a(a aVar, Map<String, Object> map) {
        AppMethodBeat.i(10234);
        map.put("flags", Integer.valueOf(aVar.flags));
        map.put("plainCodePoint", Integer.valueOf(aVar.SPV));
        map.put("codePoint", Integer.valueOf(aVar.SPW));
        map.put("keyCode", Integer.valueOf(aVar.kEV));
        map.put(JsApiScanCode.NAME, Integer.valueOf(aVar.SPY));
        map.put("metaState", Integer.valueOf(aVar.SPZ));
        if (aVar.SPX != null) {
            map.put(FirebaseAnalytics.b.CHARACTER, aVar.SPX.toString());
        }
        map.put("source", Integer.valueOf(aVar.source));
        map.put("vendorId", Integer.valueOf(aVar.SQa));
        map.put("productId", Integer.valueOf(aVar.SQb));
        map.put("deviceId", Integer.valueOf(aVar.SPU));
        map.put("repeatCount", Integer.valueOf(aVar.repeatCount));
        AppMethodBeat.o(10234);
    }

    public static class a {
        public final int SPU;
        public final int SPV;
        public final int SPW;
        public final Character SPX;
        public final int SPY;
        public final int SPZ;
        public final int SQa;
        public final int SQb;
        public final int flags;
        public final int kEV;
        public final int repeatCount;
        public final int source;

        public a(KeyEvent keyEvent, Character ch) {
            this(keyEvent.getDeviceId(), keyEvent.getFlags(), keyEvent.getUnicodeChar(0), keyEvent.getUnicodeChar(), keyEvent.getKeyCode(), ch, keyEvent.getScanCode(), keyEvent.getMetaState(), keyEvent.getSource(), keyEvent.getRepeatCount());
            AppMethodBeat.i(10254);
            AppMethodBeat.o(10254);
        }

        private a(int i2, int i3, int i4, int i5, int i6, Character ch, int i7, int i8, int i9, int i10) {
            AppMethodBeat.i(214985);
            this.SPU = i2;
            this.flags = i3;
            this.SPV = i4;
            this.SPW = i5;
            this.kEV = i6;
            this.SPX = ch;
            this.SPY = i7;
            this.SPZ = i8;
            this.source = i9;
            this.repeatCount = i10;
            InputDevice device = InputDevice.getDevice(i2);
            if (device == null) {
                this.SQa = 0;
                this.SQb = 0;
                AppMethodBeat.o(214985);
            } else if (Build.VERSION.SDK_INT >= 19) {
                this.SQa = device.getVendorId();
                this.SQb = device.getProductId();
                AppMethodBeat.o(214985);
            } else {
                this.SQa = 0;
                this.SQb = 0;
                AppMethodBeat.o(214985);
            }
        }
    }
}
