package com.tencent.mm.media.widget.b.a.a;

import android.hardware.camera2.CaptureRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u0006\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010H\u0007J(\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000eH\u0007J>\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/request/WCRequestKeyFinder;", "", "()V", "mCaptureRequest", "Landroid/hardware/camera2/CaptureRequest;", "requestKeyFinder", "Landroid/hardware/camera2/CaptureRequest$Key;", "resultKeyFinder", "Landroid/hardware/camera2/CaptureResult$Key;", "requestKey", "T", "effectRequestTag", "Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "list", "", "klass", "Ljava/lang/Class;", "resultKey", "name", "", "setRequestKey", "", "mRequest", "Landroid/hardware/camera2/CaptureRequest$Builder;", "kClass", "plugin-mediaeditor_release"})
public final class d {
    public static final d ipd = new d();

    static {
        AppMethodBeat.i(94204);
        AppMethodBeat.o(94204);
    }

    private d() {
    }

    public static final <T> CaptureRequest.Key<T> a(a aVar, List<CaptureRequest.Key<?>> list, Class<T> cls) {
        T t;
        AppMethodBeat.i(94203);
        p.h(aVar, "effectRequestTag");
        p.h(list, "list");
        p.h(cls, "klass");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(next.getName(), aVar.ioN)) {
                t = next;
                break;
            }
        }
        if (t == null) {
            t tVar = new t("null cannot be cast to non-null type android.hardware.camera2.CaptureRequest.Key<T>");
            AppMethodBeat.o(94203);
            throw tVar;
        }
        T t2 = t;
        AppMethodBeat.o(94203);
        return t2;
    }
}
