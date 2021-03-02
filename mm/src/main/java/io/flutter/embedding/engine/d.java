package io.flutter.embedding.engine;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d {
    private Set<String> SOF;

    public static d bO(Intent intent) {
        AppMethodBeat.i(214940);
        ArrayList arrayList = new ArrayList();
        if (intent.getBooleanExtra("trace-startup", false)) {
            arrayList.add("--trace-startup");
        }
        if (intent.getBooleanExtra("start-paused", false)) {
            arrayList.add("--start-paused");
        }
        int intExtra = intent.getIntExtra("observatory-port", 0);
        if (intExtra > 0) {
            arrayList.add("--observatory-port=" + Integer.toString(intExtra));
        }
        if (intent.getBooleanExtra("disable-service-auth-codes", false)) {
            arrayList.add("--disable-service-auth-codes");
        }
        if (intent.getBooleanExtra("endless-trace-buffer", false)) {
            arrayList.add("--endless-trace-buffer");
        }
        if (intent.getBooleanExtra("use-test-fonts", false)) {
            arrayList.add("--use-test-fonts");
        }
        if (intent.getBooleanExtra("enable-dart-profiling", false)) {
            arrayList.add("--enable-dart-profiling");
        }
        if (intent.getBooleanExtra("enable-software-rendering", false)) {
            arrayList.add("--enable-software-rendering");
        }
        if (intent.getBooleanExtra("skia-deterministic-rendering", false)) {
            arrayList.add("--skia-deterministic-rendering");
        }
        if (intent.getBooleanExtra("trace-skia", false)) {
            arrayList.add("--trace-skia");
        }
        if (intent.getBooleanExtra("trace-systrace", false)) {
            arrayList.add("--trace-systrace");
        }
        if (intent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
            arrayList.add("--dump-skp-on-shader-compilation");
        }
        if (intent.getBooleanExtra("cache-sksl", false)) {
            arrayList.add("--cache-sksl");
        }
        if (intent.getBooleanExtra("verbose-logging", false)) {
            arrayList.add("--verbose-logging");
        }
        if (intent.hasExtra("dart-flags")) {
            arrayList.add("--dart-flags=" + intent.getStringExtra("dart-flags"));
        }
        d dVar = new d(arrayList);
        AppMethodBeat.o(214940);
        return dVar;
    }

    public d(String[] strArr) {
        AppMethodBeat.i(10182);
        this.SOF = new HashSet(Arrays.asList(strArr));
        AppMethodBeat.o(10182);
    }

    private d(List<String> list) {
        AppMethodBeat.i(10183);
        this.SOF = new HashSet(list);
        AppMethodBeat.o(10183);
    }

    public final String[] toArray() {
        AppMethodBeat.i(10184);
        String[] strArr = (String[]) this.SOF.toArray(new String[this.SOF.size()]);
        AppMethodBeat.o(10184);
        return strArr;
    }
}
