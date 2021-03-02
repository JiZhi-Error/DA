package com.bumptech.glide.load.b;

import android.support.v4.e.l;
import android.util.Log;
import com.bumptech.glide.load.d.f.e;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class i<DataType, ResourceType, Transcode> {
    private final Class<DataType> aGU;
    private final List<? extends j<DataType, ResourceType>> aGV;
    final e<ResourceType, Transcode> aGW;
    private final l.a<List<Throwable>> aGX;
    private final String aGY;

    interface a<ResourceType> {
        v<ResourceType> a(v<ResourceType> vVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends j<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, l.a<List<Throwable>> aVar) {
        AppMethodBeat.i(76973);
        this.aGU = cls;
        this.aGV = list;
        this.aGW = eVar;
        this.aGX = aVar;
        this.aGY = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
        AppMethodBeat.o(76973);
    }

    /* access modifiers changed from: package-private */
    public final v<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i2, int i3, com.bumptech.glide.load.i iVar) {
        AppMethodBeat.i(76974);
        List<Throwable> list = (List) com.bumptech.glide.g.j.checkNotNull(this.aGX.acquire(), "Argument must not be null");
        try {
            return a(eVar, i2, i3, iVar, list);
        } finally {
            this.aGX.release(list);
            AppMethodBeat.o(76974);
        }
    }

    private v<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i2, int i3, com.bumptech.glide.load.i iVar, List<Throwable> list) {
        v<ResourceType> vVar;
        AppMethodBeat.i(76975);
        v<ResourceType> vVar2 = null;
        int size = this.aGV.size();
        for (int i4 = 0; i4 < size; i4++) {
            j jVar = (j) this.aGV.get(i4);
            try {
                if (jVar.a(eVar.ov(), iVar)) {
                    vVar = jVar.a(eVar.ov(), i2, i3, iVar);
                } else {
                    vVar = vVar2;
                }
                vVar2 = vVar;
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    new StringBuilder("Failed to decode data for ").append(jVar);
                }
                list.add(e2);
            }
            if (vVar2 != null) {
                break;
            }
        }
        if (vVar2 == null) {
            q qVar = new q(this.aGY, new ArrayList(list));
            AppMethodBeat.o(76975);
            throw qVar;
        }
        AppMethodBeat.o(76975);
        return vVar2;
    }

    public final String toString() {
        AppMethodBeat.i(76976);
        String str = "DecodePath{ dataClass=" + this.aGU + ", decoders=" + this.aGV + ", transcoder=" + this.aGW + '}';
        AppMethodBeat.o(76976);
        return str;
    }
}
