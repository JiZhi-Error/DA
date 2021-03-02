package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.f;
import java.util.HashMap;
import java.util.Map;

public final class j {
    public final io.flutter.plugin.a.b<Object> SPQ;

    public j(DartExecutor dartExecutor) {
        AppMethodBeat.i(10269);
        this.SPQ = new io.flutter.plugin.a.b<>(dartExecutor, "flutter/settings", f.SSk);
        AppMethodBeat.o(10269);
    }

    public final a hxi() {
        AppMethodBeat.i(10270);
        a aVar = new a(this.SPQ);
        AppMethodBeat.o(10270);
        return aVar;
    }

    public static class a {
        private final io.flutter.plugin.a.b<Object> SPQ;
        private Map<String, Object> SRk = new HashMap();

        a(io.flutter.plugin.a.b<Object> bVar) {
            AppMethodBeat.i(10280);
            this.SPQ = bVar;
            AppMethodBeat.o(10280);
        }

        public final a cQ(float f2) {
            AppMethodBeat.i(10281);
            this.SRk.put("textScaleFactor", Float.valueOf(f2));
            AppMethodBeat.o(10281);
            return this;
        }

        public final a Ez(boolean z) {
            AppMethodBeat.i(10282);
            this.SRk.put("alwaysUse24HourFormat", Boolean.valueOf(z));
            AppMethodBeat.o(10282);
            return this;
        }

        public final a a(b bVar) {
            AppMethodBeat.i(10283);
            this.SRk.put("platformBrightness", bVar.name);
            AppMethodBeat.o(10283);
            return this;
        }

        public final void send() {
            AppMethodBeat.i(10284);
            new StringBuilder("Sending message: \ntextScaleFactor: ").append(this.SRk.get("textScaleFactor")).append("\nalwaysUse24HourFormat: ").append(this.SRk.get("alwaysUse24HourFormat")).append("\nplatformBrightness: ").append(this.SRk.get("platformBrightness"));
            io.flutter.a.hwd();
            this.SPQ.eN(this.SRk);
            AppMethodBeat.o(10284);
        }
    }

    public enum b {
        light("light"),
        dark("dark");
        
        public String name;

        public static b valueOf(String str) {
            AppMethodBeat.i(10267);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(10267);
            return bVar;
        }

        static {
            AppMethodBeat.i(10268);
            AppMethodBeat.o(10268);
        }

        private b(String str) {
            this.name = str;
        }
    }
}
