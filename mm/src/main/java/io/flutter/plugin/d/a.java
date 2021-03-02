package io.flutter.plugin.d;

import android.annotation.TargetApi;
import android.view.PointerIcon;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI;
import io.flutter.embedding.engine.c.e;
import java.util.HashMap;

@TargetApi(24)
public final class a {
    static HashMap<String, Integer> SSZ;
    private final e SOb;
    final AbstractC2254a SSY;

    /* renamed from: io.flutter.plugin.d.a$a  reason: collision with other inner class name */
    public interface AbstractC2254a {
        PointerIcon atp(int i2);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public a(AbstractC2254a aVar, e eVar) {
        AppMethodBeat.i(214859);
        this.SSY = aVar;
        this.SOb = eVar;
        eVar.SQc = new e.a() {
            /* class io.flutter.plugin.d.a.AnonymousClass1 */

            @Override // io.flutter.embedding.engine.c.e.a
            public final void btg(String str) {
                AppMethodBeat.i(214857);
                AbstractC2254a aVar = a.this.SSY;
                a aVar2 = a.this;
                if (a.SSZ == null) {
                    a.SSZ = new HashMap<String, Integer>() {
                        /* class io.flutter.plugin.d.a.AnonymousClass2 */

                        {
                            AppMethodBeat.i(214858);
                            put("none", 0);
                            put("click", 1002);
                            put("text", 1008);
                            put("grab", 1020);
                            put("grabbing", 1021);
                            put("horizontalDoubleArrow", 1014);
                            put("verticalDoubleArrow", Integer.valueOf((int) HardCoderJNI.FUNC_REG_SYSTEM_EVENT_CALLBACK));
                            AppMethodBeat.o(214858);
                        }
                    };
                }
                aVar.setPointerIcon(aVar2.SSY.atp(a.SSZ.getOrDefault(str, 1000).intValue()));
                AppMethodBeat.o(214857);
            }
        };
        AppMethodBeat.o(214859);
    }
}
