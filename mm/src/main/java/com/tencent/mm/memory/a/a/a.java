package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.a.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a implements c<String> {
    String itU;
    WeakReference<f.b> itV;
    WeakReference<f.c> itW;
    public int itX = 0;
    long itY = 0;
    String itZ;
    public String key;
    Object object;

    public a(String str, String str2, Object obj, int i2, f.b bVar, f.c cVar) {
        AppMethodBeat.i(156490);
        this.key = str;
        this.itU = str2;
        this.object = obj;
        this.itX = i2;
        this.itV = new WeakReference<>(bVar);
        this.itW = new WeakReference<>(cVar);
        this.itY = System.currentTimeMillis();
        this.itZ = new SimpleDateFormat("HH:mm:ss").format(new Date(this.itY));
        if (com.tencent.mm.memory.a.a.a.a.iuj) {
            Log.i("MicroMsg.BusinessBitmap", "BusinessBitmap build key %s sizes: %s cacheTime %s object %s stack [%s]", str, Util.getSizeKB((long) i2), this.itZ, obj, Util.getStack().toString());
        }
        AppMethodBeat.o(156490);
    }

    public int hashCode() {
        AppMethodBeat.i(156491);
        if (this.object != null) {
            int hashCode = this.object.hashCode();
            AppMethodBeat.o(156491);
            return hashCode;
        }
        int hashCode2 = super.hashCode();
        AppMethodBeat.o(156491);
        return hashCode2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(156492);
        if (obj == null || !(obj instanceof a) || ((a) obj).object == null) {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(156492);
            return equals;
        }
        boolean equals2 = ((a) obj).object.equals(this.object);
        AppMethodBeat.o(156492);
        return equals2;
    }

    public String toString() {
        AppMethodBeat.i(156493);
        String format = String.format("StructBitmap %s key:%s size %s realObj %s cacheTime %s now %s", Integer.valueOf(hashCode()), this.key, Util.getSizeKB((long) this.itX), this.object, this.itZ, new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
        AppMethodBeat.o(156493);
        return format;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.memory.a.a.a.c
    public final /* bridge */ /* synthetic */ String aSi() {
        return this.itU;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.memory.a.a.a.c
    public final /* bridge */ /* synthetic */ String aSj() {
        return this.key;
    }
}
