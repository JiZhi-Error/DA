package com.bumptech.glide.load.b;

import android.support.v4.e.l;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class t<Data, ResourceType, Transcode> {
    private final Class<Data> aGU;
    private final l.a<List<Throwable>> aGX;
    private final String aGY;
    private final List<? extends i<Data, ResourceType, Transcode>> aHV;

    public t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, l.a<List<Throwable>> aVar) {
        AppMethodBeat.i(77033);
        this.aGU = cls;
        this.aGX = aVar;
        this.aHV = (List) j.b(list);
        this.aGY = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
        AppMethodBeat.o(77033);
    }

    public final v<Transcode> a(e<Data> eVar, i iVar, int i2, int i3, i.a<ResourceType> aVar) {
        AppMethodBeat.i(77034);
        List<Throwable> list = (List) j.checkNotNull(this.aGX.acquire(), "Argument must not be null");
        try {
            return a(eVar, iVar, i2, i3, aVar, list);
        } finally {
            this.aGX.release(list);
            AppMethodBeat.o(77034);
        }
    }

    private v<Transcode> a(e<Data> eVar, com.bumptech.glide.load.i iVar, int i2, int i3, i.a<ResourceType> aVar, List<Throwable> list) {
        v<Transcode> vVar;
        AppMethodBeat.i(77035);
        v<Transcode> vVar2 = null;
        int size = this.aHV.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                vVar = vVar2;
                break;
            }
            i iVar2 = (i) this.aHV.get(i4);
            try {
                vVar = iVar2.aGW.a(aVar.a(iVar2.a(eVar, i2, i3, iVar)), iVar);
            } catch (q e2) {
                list.add(e2);
                vVar = vVar2;
            }
            if (vVar != null) {
                break;
            }
            i4++;
            vVar2 = vVar;
        }
        if (vVar == null) {
            q qVar = new q(this.aGY, new ArrayList(list));
            AppMethodBeat.o(77035);
            throw qVar;
        }
        AppMethodBeat.o(77035);
        return vVar;
    }

    public final String toString() {
        AppMethodBeat.i(77036);
        String str = "LoadPath{decodePaths=" + Arrays.toString(this.aHV.toArray()) + '}';
        AppMethodBeat.o(77036);
        return str;
    }
}
