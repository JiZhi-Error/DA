package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.n;
import io.flutter.view.a;
import java.util.HashMap;

public final class a {
    public final FlutterJNI SNV;
    public final b<Object> SPQ;
    AbstractC2246a SPR;
    private final b.AbstractC2252b<Object> SPS = new b.AbstractC2252b<Object>() {
        /* class io.flutter.embedding.engine.c.a.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // io.flutter.plugin.a.b.AbstractC2252b
        public final void a(Object obj, b.c<Object> cVar) {
            char c2;
            AppMethodBeat.i(214983);
            if (a.this.SPR == null) {
                AppMethodBeat.o(214983);
                return;
            }
            HashMap hashMap = (HashMap) obj;
            String str = (String) hashMap.get("type");
            HashMap hashMap2 = (HashMap) hashMap.get("data");
            new StringBuilder("Received ").append(str).append(" message.");
            io.flutter.a.hwd();
            switch (str.hashCode()) {
                case -1140076541:
                    if (str.equals("tooltip")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -649620375:
                    if (str.equals("announce")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 114595:
                    if (str.equals("tap")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 114203431:
                    if (str.equals("longPress")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    String str2 = (String) hashMap2.get("message");
                    if (str2 != null) {
                        a.this.SPR.bte(str2);
                        AppMethodBeat.o(214983);
                        return;
                    }
                    break;
                case 1:
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        a.this.SPR.atq(num.intValue());
                        AppMethodBeat.o(214983);
                        return;
                    }
                    break;
                case 2:
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        a.this.SPR.atr(num2.intValue());
                        AppMethodBeat.o(214983);
                        return;
                    }
                    break;
                case 3:
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        a.this.SPR.btf(str3);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(214983);
        }
    };

    /* renamed from: io.flutter.embedding.engine.c.a$a  reason: collision with other inner class name */
    public interface AbstractC2246a extends FlutterJNI.AccessibilityDelegate {
        void atq(int i2);

        void atr(int i2);

        void bte(String str);

        void btf(String str);
    }

    public a(DartExecutor dartExecutor, FlutterJNI flutterJNI) {
        AppMethodBeat.i(10262);
        this.SPQ = new b<>(dartExecutor, "flutter/accessibility", n.SSp);
        this.SPQ.a(this.SPS);
        this.SNV = flutterJNI;
        AppMethodBeat.o(10262);
    }

    public final void dispatchSemanticsAction(int i2, a.b bVar) {
        AppMethodBeat.i(10263);
        this.SNV.dispatchSemanticsAction(i2, bVar);
        AppMethodBeat.o(10263);
    }

    public final void dispatchSemanticsAction(int i2, a.b bVar, Object obj) {
        AppMethodBeat.i(10264);
        this.SNV.dispatchSemanticsAction(i2, bVar, obj);
        AppMethodBeat.o(10264);
    }

    public final void a(AbstractC2246a aVar) {
        AppMethodBeat.i(10265);
        this.SPR = aVar;
        this.SNV.setAccessibilityDelegate(aVar);
        AppMethodBeat.o(10265);
    }
}
