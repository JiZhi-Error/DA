package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class g {
    protected final k.c SQd = new k.c() {
        /* class io.flutter.embedding.engine.c.g.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:102:0x02a6  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x027c  */
        @Override // io.flutter.plugin.a.k.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(io.flutter.plugin.a.j r9, io.flutter.plugin.a.k.d r10) {
            /*
            // Method dump skipped, instructions count: 806
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.c.g.AnonymousClass1.a(io.flutter.plugin.a.j, io.flutter.plugin.a.k$d):void");
        }
    };
    public f SQf;
    public final k bbv;

    public interface f {
        CharSequence a(c cVar);

        void a(a aVar);

        void a(e eVar);

        void a(EnumC2248g gVar);

        void a(h hVar);

        void ats(int i2);

        void btl(String str);

        void hxg();

        void hxh();

        void kn(List<i> list);
    }

    public g(DartExecutor dartExecutor) {
        AppMethodBeat.i(10242);
        this.bbv = new k(dartExecutor, "flutter/platform", io.flutter.plugin.a.g.SSl);
        this.bbv.a(this.SQd);
        AppMethodBeat.o(10242);
    }

    /* renamed from: io.flutter.embedding.engine.c.g$g  reason: collision with other inner class name */
    public enum EnumC2248g {
        CLICK;
        
        private final String SQl;

        public static EnumC2248g valueOf(String str) {
            AppMethodBeat.i(10287);
            EnumC2248g gVar = (EnumC2248g) Enum.valueOf(EnumC2248g.class, str);
            AppMethodBeat.o(10287);
            return gVar;
        }

        static {
            AppMethodBeat.i(10289);
            AppMethodBeat.o(10289);
        }

        static EnumC2248g btm(String str) {
            AppMethodBeat.i(10288);
            EnumC2248g[] values = values();
            for (EnumC2248g gVar : values) {
                if (gVar.SQl.equals(str)) {
                    AppMethodBeat.o(10288);
                    return gVar;
                }
            }
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such SoundType: ".concat(String.valueOf(str)));
            AppMethodBeat.o(10288);
            throw noSuchFieldException;
        }

        private EnumC2248g() {
            this.SQl = r3;
        }
    }

    public enum e {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        
        private final String SQl;

        public static e valueOf(String str) {
            AppMethodBeat.i(10250);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(10250);
            return eVar;
        }

        static {
            AppMethodBeat.i(10252);
            AppMethodBeat.o(10252);
        }

        static e btk(String str) {
            AppMethodBeat.i(10251);
            e[] values = values();
            for (e eVar : values) {
                if ((eVar.SQl == null && str == null) || (eVar.SQl != null && eVar.SQl.equals(str))) {
                    AppMethodBeat.o(10251);
                    return eVar;
                }
            }
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such HapticFeedbackType: ".concat(String.valueOf(str)));
            AppMethodBeat.o(10251);
            throw noSuchFieldException;
        }

        private e(String str) {
            this.SQl = str;
        }
    }

    public enum d {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        
        private String SQl;

        public static d valueOf(String str) {
            AppMethodBeat.i(10277);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(10277);
            return dVar;
        }

        static {
            AppMethodBeat.i(10279);
            AppMethodBeat.o(10279);
        }

        static d btj(String str) {
            AppMethodBeat.i(10278);
            d[] values = values();
            for (d dVar : values) {
                if (dVar.SQl.equals(str)) {
                    AppMethodBeat.o(10278);
                    return dVar;
                }
            }
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such DeviceOrientation: ".concat(String.valueOf(str)));
            AppMethodBeat.o(10278);
            throw noSuchFieldException;
        }

        private d(String str) {
            this.SQl = str;
        }
    }

    public enum i {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        
        private String SQl;

        public static i valueOf(String str) {
            AppMethodBeat.i(10230);
            i iVar = (i) Enum.valueOf(i.class, str);
            AppMethodBeat.o(10230);
            return iVar;
        }

        static {
            AppMethodBeat.i(10232);
            AppMethodBeat.o(10232);
        }

        static i btn(String str) {
            AppMethodBeat.i(10231);
            i[] values = values();
            for (i iVar : values) {
                if (iVar.SQl.equals(str)) {
                    AppMethodBeat.o(10231);
                    return iVar;
                }
            }
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such SystemUiOverlay: ".concat(String.valueOf(str)));
            AppMethodBeat.o(10231);
            throw noSuchFieldException;
        }

        private i(String str) {
            this.SQl = str;
        }
    }

    public static class a {
        public final int color;
        public final String label;

        public a(int i2, String str) {
            this.color = i2;
            this.label = str;
        }
    }

    public static class h {
        public final Integer SQC;
        public final b SQD;
        public final Integer SQE;
        public final b SQF;
        public final Integer SQG;

        public h(Integer num, b bVar, Integer num2, b bVar2, Integer num3) {
            this.SQC = num;
            this.SQD = bVar;
            this.SQE = num2;
            this.SQF = bVar2;
            this.SQG = num3;
        }
    }

    public enum b {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        
        private String SQl;

        public static b valueOf(String str) {
            AppMethodBeat.i(10226);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(10226);
            return bVar;
        }

        static {
            AppMethodBeat.i(10228);
            AppMethodBeat.o(10228);
        }

        static b bth(String str) {
            AppMethodBeat.i(10227);
            b[] values = values();
            for (b bVar : values) {
                if (bVar.SQl.equals(str)) {
                    AppMethodBeat.o(10227);
                    return bVar;
                }
            }
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such Brightness: ".concat(String.valueOf(str)));
            AppMethodBeat.o(10227);
            throw noSuchFieldException;
        }

        private b(String str) {
            this.SQl = str;
        }
    }

    public enum c {
        PLAIN_TEXT;
        
        private String SQl;

        public static c valueOf(String str) {
            AppMethodBeat.i(10273);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(10273);
            return cVar;
        }

        static {
            AppMethodBeat.i(10275);
            AppMethodBeat.o(10275);
        }

        static c bti(String str) {
            AppMethodBeat.i(10274);
            c[] values = values();
            for (c cVar : values) {
                if (cVar.SQl.equals(str)) {
                    AppMethodBeat.o(10274);
                    return cVar;
                }
            }
            NoSuchFieldException noSuchFieldException = new NoSuchFieldException("No such ClipboardContentFormat: ".concat(String.valueOf(str)));
            AppMethodBeat.o(10274);
            throw noSuchFieldException;
        }

        private c() {
            this.SQl = r3;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ int X(JSONArray jSONArray) {
        AppMethodBeat.i(10243);
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            switch (d.btj(jSONArray.getString(i2))) {
                case PORTRAIT_UP:
                    z2 |= true;
                    break;
                case PORTRAIT_DOWN:
                    z2 |= true;
                    break;
                case LANDSCAPE_LEFT:
                    z2 |= true;
                    break;
                case LANDSCAPE_RIGHT:
                    z2 |= true;
                    break;
            }
            if (!z) {
                z = z2;
            }
        }
        switch (z2) {
            case false:
                AppMethodBeat.o(10243);
                return -1;
            case true:
                AppMethodBeat.o(10243);
                return 1;
            case true:
                AppMethodBeat.o(10243);
                return 0;
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                switch (z) {
                    case true:
                        AppMethodBeat.o(10243);
                        return 1;
                    case true:
                        AppMethodBeat.o(10243);
                        return 0;
                    case true:
                        AppMethodBeat.o(10243);
                        return 9;
                    case true:
                        AppMethodBeat.o(10243);
                        return 8;
                }
            case true:
                AppMethodBeat.o(10243);
                return 9;
            case true:
                AppMethodBeat.o(10243);
                return 12;
            case true:
                AppMethodBeat.o(10243);
                return 8;
            case true:
                AppMethodBeat.o(10243);
                return 11;
            case true:
                AppMethodBeat.o(10243);
                return 2;
            case true:
                AppMethodBeat.o(10243);
                return 13;
        }
        AppMethodBeat.o(10243);
        return 1;
    }

    static /* synthetic */ List Y(JSONArray jSONArray) {
        AppMethodBeat.i(10244);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            switch (i.btn(jSONArray.getString(i2))) {
                case TOP_OVERLAYS:
                    arrayList.add(i.TOP_OVERLAYS);
                    break;
                case BOTTOM_OVERLAYS:
                    arrayList.add(i.BOTTOM_OVERLAYS);
                    break;
            }
        }
        AppMethodBeat.o(10244);
        return arrayList;
    }
}
