package com.tencent.mm.media.g;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\nX\u0004¢\u0006\u0002\n\u0000R8\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b`\n8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/media/globject/GLObjectFactory;", "", "()V", "TAG", "", "allocatedFramebuffer", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Lkotlin/collections/HashMap;", "allocatedTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "newFrameBuffer", "scene", "", "newTexture", "sampler2D", "", "printAllocatedGLObjectInfo", "", "plugin-mediaeditor_release"})
public final class c {
    private static final String TAG = TAG;
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, WeakReference<d>> igs = new HashMap<>();
    private static final HashMap<Integer, WeakReference<a>> igt = new HashMap<>();
    public static final c igu = new c();

    static {
        AppMethodBeat.i(93698);
        AppMethodBeat.o(93698);
    }

    private c() {
    }

    public static /* synthetic */ d eV(boolean z) {
        AppMethodBeat.i(93695);
        d a2 = a(z, -1);
        AppMethodBeat.o(93695);
        return a2;
    }

    public static final d a(boolean z, long j2) {
        AppMethodBeat.i(93694);
        d dVar = new d(z, j2);
        igs.put(Integer.valueOf(dVar.hashCode()), new WeakReference<>(dVar));
        AppMethodBeat.o(93694);
        return dVar;
    }

    public static a zI(long j2) {
        AppMethodBeat.i(93696);
        a aVar = new a(j2);
        igt.put(Integer.valueOf(aVar.hashCode()), new WeakReference<>(aVar));
        AppMethodBeat.o(93696);
        return aVar;
    }

    public final synchronized void aMA() {
        AppMethodBeat.i(93697);
        Log.i(TAG, "--------printAllocatedGLObjectInfo, current allocated tex size:" + igs.size() + ", frameBuffer size:" + igt.size() + " calledStack:" + b.getStack());
        Log.i(TAG, "--------------------------------------------");
        for (Map.Entry entry : new HashMap(igs).entrySet()) {
            Integer num = (Integer) entry.getKey();
            d dVar = (d) ((WeakReference) entry.getValue()).get();
            if (dVar == null) {
                Log.i(TAG, num + " tex recycled");
                igs.remove(num);
            } else if (!dVar.ign) {
                Log.i(TAG, num + " tex leak, texId:" + dVar.igv + ", external:" + dVar.aMD() + ", allocatedTid:" + dVar.tid);
            } else {
                igs.remove(num);
                Log.i(TAG, num + " tex released, texId:" + dVar.igv + ", external:" + dVar.aMD() + ", allocatedTid:" + dVar.tid);
            }
        }
        for (Map.Entry entry2 : new HashMap(igt).entrySet()) {
            Integer num2 = (Integer) entry2.getKey();
            a aVar = (a) ((WeakReference) entry2.getValue()).get();
            if (aVar == null) {
                Log.i(TAG, num2 + " fbo recycled");
                igt.remove(num2);
            } else if (!aVar.ign) {
                Log.i(TAG, num2 + " fbo leak, fbo:" + aVar.igo + ", allocatedTid:" + aVar.tid);
            } else {
                igt.remove(num2);
                Log.i(TAG, num2 + " fbo released, fbo:" + aVar.igo + ", allocatedTid:" + aVar.tid);
            }
        }
        Log.i(TAG, "--------finish printAllocatedGLObjectInfo--------");
        AppMethodBeat.o(93697);
    }
}
