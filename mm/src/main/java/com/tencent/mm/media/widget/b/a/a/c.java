package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0007J,\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\t\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/request/WCRequestKeyCreator;", "", "()V", "TAG", "", "requestConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/hardware/camera2/CaptureRequest$Key;", "resultConstructor", "Landroid/hardware/camera2/CaptureResult$Key;", "requestKey", "T", "name", "klass", "Ljava/lang/Class;", "resultKey", "plugin-mediaeditor_release"})
public final class c {
    private static final String TAG = TAG;
    private static Constructor<CaptureRequest.Key<?>> ipb;
    public static final c ipc = new c();

    static {
        AppMethodBeat.i(94202);
        AppMethodBeat.o(94202);
    }

    private c() {
    }

    public static final <T> CaptureRequest.Key<T> d(String str, Class<T> cls) {
        AppMethodBeat.i(94201);
        p.h(str, "name");
        p.h(cls, "klass");
        try {
            if (ipb == null) {
                Constructor<CaptureRequest.Key<?>> constructor = CaptureRequest.Key.class.getConstructor(String.class, cls.getClass());
                ipb = constructor;
                if (constructor == null) {
                    p.hyc();
                }
                constructor.setAccessible(true);
            }
            try {
                Constructor<CaptureRequest.Key<?>> constructor2 = ipb;
                if (constructor2 == null) {
                    p.hyc();
                }
                CaptureRequest.Key<T> key = (CaptureRequest.Key<T>) constructor2.newInstance(str, cls);
                AppMethodBeat.o(94201);
                return key;
            } catch (Exception e2) {
                new StringBuilder("cannot call captureRequest.Key constructor: ").append(e2.getMessage());
                AppMethodBeat.o(94201);
                return null;
            }
        } catch (NoSuchMethodException e3) {
            new StringBuilder("cannot find captureRequest.Key constructor: ").append(e3.getMessage());
            AppMethodBeat.o(94201);
            return null;
        }
    }
}
