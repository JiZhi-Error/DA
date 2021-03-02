package com.tencent.mm.media.widget.b.a.b;

import android.hardware.camera2.CaptureResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u0007\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/result/WCResultKeyCreator;", "", "()V", "TAG", "", "resultConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/hardware/camera2/CaptureResult$Key;", "resultKey", "T", "name", "klass", "Ljava/lang/Class;", "plugin-mediaeditor_release"})
public final class c {
    private static final String TAG = TAG;
    private static Constructor<CaptureResult.Key<?>> ipk;
    public static final c ipl = new c();

    static {
        AppMethodBeat.i(94210);
        AppMethodBeat.o(94210);
    }

    private c() {
    }

    public static final <T> CaptureResult.Key<T> e(String str, Class<T> cls) {
        AppMethodBeat.i(94209);
        p.h(str, "name");
        p.h(cls, "klass");
        try {
            if (ipk == null) {
                Constructor<CaptureResult.Key<?>> constructor = CaptureResult.Key.class.getConstructor(String.class, cls.getClass());
                ipk = constructor;
                if (constructor == null) {
                    p.hyc();
                }
                constructor.setAccessible(true);
            }
            try {
                Constructor<CaptureResult.Key<?>> constructor2 = ipk;
                if (constructor2 == null) {
                    p.hyc();
                }
                CaptureResult.Key<?> newInstance = constructor2.newInstance(str, cls);
                if (newInstance == null) {
                    t tVar = new t("null cannot be cast to non-null type android.hardware.camera2.CaptureResult.Key<T>");
                    AppMethodBeat.o(94209);
                    throw tVar;
                }
                CaptureResult.Key<T> key = (CaptureResult.Key<T>) newInstance;
                AppMethodBeat.o(94209);
                return key;
            } catch (Exception e2) {
                new StringBuilder("cannot call captureResult.Key constructor: ").append(e2.getMessage());
                AppMethodBeat.o(94209);
                return null;
            }
        } catch (NoSuchMethodException e3) {
            new StringBuilder("cannot find captureResult.Key constructor: ").append(e3.getMessage());
            AppMethodBeat.o(94209);
            return null;
        }
    }
}
