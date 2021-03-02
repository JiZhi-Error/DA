package com.tencent.mm.memory.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b<V> extends a<String, V, V, com.tencent.mm.memory.a.a.a> {
    private static ConcurrentHashMap<Class<?>, a> itQ = new ConcurrentHashMap<>();
    String itO;
    f<String, Object> itP;
    private f.b<String, com.tencent.mm.memory.a.a.a> itR;
    private f.c<String, com.tencent.mm.memory.a.a.a> itS;

    public interface a<T> {
        int bX(T t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.memory.a.a.a.e
    public final /* synthetic */ Object A(Object obj, Object obj2) {
        AppMethodBeat.i(156486);
        com.tencent.mm.memory.a.a.a aVar = new com.tencent.mm.memory.a.a.a((String) obj, this.itO, obj2, bX(obj2), this.itR, this.itS);
        AppMethodBeat.o(156486);
        return aVar;
    }

    @Override // com.tencent.mm.b.f, com.tencent.mm.memory.a.a.a.e
    public final /* synthetic */ Object aT(Object obj) {
        Object obj2;
        AppMethodBeat.i(156481);
        String str = (String) obj;
        Object aT = this.iuv.aT(str);
        if (aT != null || this.itP == null) {
            obj2 = aT;
        } else {
            obj2 = this.itP.get(str);
        }
        com.tencent.mm.memory.a.a.a aVar = null;
        if (this.iuw != null) {
            aVar = (com.tencent.mm.memory.a.a.a) this.iuw.G(this.itO, str);
        }
        if (com.tencent.mm.memory.a.a.a.a.iuj) {
            Log.v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", str, obj2, aVar, Util.getStack().toString());
        }
        AppMethodBeat.o(156481);
        return obj2;
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final /* bridge */ /* synthetic */ Object ca(Object obj) {
        return obj;
    }

    @Override // com.tencent.mm.b.f, com.tencent.mm.memory.a.a.a.e
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        AppMethodBeat.i(156483);
        V v = get((String) obj);
        AppMethodBeat.o(156483);
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.b.f, com.tencent.mm.memory.a.a.a.e
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        AppMethodBeat.i(156482);
        V put = put((String) obj, obj2);
        AppMethodBeat.o(156482);
        return put;
    }

    @Override // com.tencent.mm.b.f, com.tencent.mm.memory.a.a.a.e
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        AppMethodBeat.i(156484);
        V remove = remove((String) obj);
        AppMethodBeat.o(156484);
        return remove;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.b.f, com.tencent.mm.memory.a.a.a.e
    public final /* synthetic */ void x(Object obj, Object obj2) {
        AppMethodBeat.i(156485);
        String str = (String) obj;
        if (!bZ(obj2) || this.itP == null) {
            super.x(str, obj2);
            AppMethodBeat.o(156485);
            return;
        }
        this.itP.put(str, obj2);
        AppMethodBeat.o(156485);
    }

    static {
        AppMethodBeat.i(156488);
        a(Bitmap.class, new a<Bitmap>() {
            /* class com.tencent.mm.memory.a.b.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.memory.a.b.a
            public final /* synthetic */ int bX(Bitmap bitmap) {
                AppMethodBeat.i(156464);
                Bitmap bitmap2 = bitmap;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    AppMethodBeat.o(156464);
                    return 0;
                } else if (d.oE(19)) {
                    int byteCount = bitmap2.getByteCount();
                    AppMethodBeat.o(156464);
                    return byteCount;
                } else {
                    int allocationByteCount = bitmap2.getAllocationByteCount();
                    AppMethodBeat.o(156464);
                    return allocationByteCount;
                }
            }
        });
        a(WeakReference.class, new a<WeakReference<Bitmap>>() {
            /* class com.tencent.mm.memory.a.b.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.memory.a.b.a
            public final /* synthetic */ int bX(WeakReference<Bitmap> weakReference) {
                AppMethodBeat.i(156465);
                WeakReference<Bitmap> weakReference2 = weakReference;
                if (weakReference2 == null) {
                    AppMethodBeat.o(156465);
                    return 0;
                }
                Bitmap bitmap = weakReference2.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(156465);
                    return 0;
                } else if (d.oE(19)) {
                    int byteCount = bitmap.getByteCount();
                    AppMethodBeat.o(156465);
                    return byteCount;
                } else {
                    int allocationByteCount = bitmap.getAllocationByteCount();
                    AppMethodBeat.o(156465);
                    return allocationByteCount;
                }
            }
        });
        AppMethodBeat.o(156488);
    }

    public static void a(Class<?> cls, a aVar) {
        AppMethodBeat.i(156468);
        itQ.put(cls, aVar);
        AppMethodBeat.o(156468);
    }

    public b(int i2, Class<?> cls) {
        this(i2, null, cls);
        AppMethodBeat.i(156469);
        ar(cls);
        AppMethodBeat.o(156469);
    }

    public b(int i2, f.b<String, V> bVar, Class<?> cls) {
        this(i2, bVar, com.tencent.mm.memory.a.a.a.a.aSp(), cls);
        AppMethodBeat.i(156470);
        ar(cls);
        AppMethodBeat.o(156470);
    }

    private b(int i2, f.b<String, V> bVar, com.tencent.mm.memory.a.a.a.a aVar, Class<?> cls) {
        super(i2, bVar, aVar);
        AppMethodBeat.i(156471);
        this.itO = "";
        this.itP = null;
        this.itR = new f.b<String, com.tencent.mm.memory.a.a.a>() {
            /* class com.tencent.mm.memory.a.b.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // com.tencent.mm.b.f.b
            public final /* synthetic */ void c(String str, com.tencent.mm.memory.a.a.a aVar, com.tencent.mm.memory.a.a.a aVar2) {
                String aVar3;
                String aVar4;
                AppMethodBeat.i(156467);
                String str2 = str;
                com.tencent.mm.memory.a.a.a aVar5 = aVar;
                com.tencent.mm.memory.a.a.a aVar6 = aVar2;
                if (aVar5 != null && aVar6 != null && aVar5.equals(aVar6)) {
                    if (com.tencent.mm.memory.a.a.a.a.iuj) {
                        Object[] objArr = new Object[5];
                        objArr[0] = str2;
                        objArr[1] = aVar5 == null ? " is null " : aVar5.toString();
                        objArr[2] = aVar6 == null ? " is null " : aVar6.toString();
                        objArr[3] = Integer.valueOf(b.this.iuw.size());
                        objArr[4] = Util.getStack().toString();
                        Log.v("MicroMsg.BitmapResource", "Proxy remove1 %s oldValue %s newValue %s size %s stack [%s]", objArr);
                    }
                    AppMethodBeat.o(156467);
                } else if (aVar6 == null || aVar5 == null || !aVar6.key.equals(aVar5.key)) {
                    if (com.tencent.mm.memory.a.a.a.a.iuj) {
                        Object[] objArr2 = new Object[5];
                        objArr2[0] = str2;
                        if (aVar5 == null) {
                            aVar3 = " is null ";
                        } else {
                            aVar3 = aVar5.toString();
                        }
                        objArr2[1] = aVar3;
                        if (aVar6 == null) {
                            aVar4 = " is null ";
                        } else {
                            aVar4 = aVar6.toString();
                        }
                        objArr2[2] = aVar4;
                        objArr2[3] = Integer.valueOf(b.this.iuw.size());
                        objArr2[4] = Util.getStack().toString();
                        Log.v("MicroMsg.BitmapResource", "Proxy remove3 %s oldValue %s newValue %s size %s stack [%s]", objArr2);
                    }
                    String str3 = aVar5.key;
                    if (str3 != null) {
                        b.this.iuv.remove(str3);
                    }
                    AppMethodBeat.o(156467);
                } else {
                    if (com.tencent.mm.memory.a.a.a.a.iuj) {
                        Object[] objArr3 = new Object[5];
                        objArr3[0] = str2;
                        objArr3[1] = aVar5 == null ? " is null " : aVar5.toString();
                        objArr3[2] = aVar6 == null ? " is null " : aVar6.toString();
                        objArr3[3] = Integer.valueOf(b.this.iuw.size());
                        objArr3[4] = Util.getStack().toString();
                        Log.v("MicroMsg.BitmapResource", "Proxy remove2 %s oldValue %s newValue %s size %s stack [%s]", objArr3);
                    }
                    AppMethodBeat.o(156467);
                }
            }
        };
        this.itS = new f.c<String, com.tencent.mm.memory.a.a.a>() {
            /* class com.tencent.mm.memory.a.b.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // com.tencent.mm.b.f.c
            public final /* bridge */ /* synthetic */ int y(String str, com.tencent.mm.memory.a.a.a aVar) {
                com.tencent.mm.memory.a.a.a aVar2 = aVar;
                if (aVar2 != null) {
                    return aVar2.itX;
                }
                return 524288;
            }
        };
        ar(cls);
        AppMethodBeat.o(156471);
    }

    private void ar(Class<?> cls) {
        AppMethodBeat.i(156472);
        this.itO = cls.getSimpleName();
        this.itP = com.tencent.mm.memory.a.a.b.d(this.iuq);
        AppMethodBeat.o(156472);
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final void init() {
        AppMethodBeat.i(156473);
        super.init();
        AppMethodBeat.o(156473);
    }

    private int bX(V v) {
        a aVar;
        AppMethodBeat.i(156474);
        if (v == null || (aVar = itQ.get(v.getClass())) == null) {
            int sizeOf = this.iuv.sizeOf("", v);
            AppMethodBeat.o(156474);
            return sizeOf;
        }
        int bX = aVar.bX(v);
        AppMethodBeat.o(156474);
        return bX;
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final com.tencent.mm.memory.a.a.a.d<String, com.tencent.mm.memory.a.a.a> a(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(156475);
        com.tencent.mm.memory.a.a.a.d<String, com.tencent.mm.memory.a.a.a> c2 = com.tencent.mm.memory.a.a.b.c(aVar);
        AppMethodBeat.o(156475);
        return c2;
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final V bY(V v) {
        return v;
    }

    @Override // com.tencent.mm.b.f
    public final Map<String, V> snapshot() {
        AppMethodBeat.i(156476);
        Map<String, V> snapshot = this.iuv.snapshot();
        AppMethodBeat.o(156476);
        return snapshot;
    }

    private boolean bZ(V v) {
        AppMethodBeat.i(156477);
        if (bX(v) * 2 >= com.tencent.mm.memory.a.a.b.e(this.iuq)) {
            AppMethodBeat.o(156477);
            return true;
        }
        AppMethodBeat.o(156477);
        return false;
    }

    public final V remove(String str) {
        AppMethodBeat.i(156478);
        if (this.itP != null) {
            this.itP.remove(str);
        }
        V v = (V) super.remove((Object) str);
        AppMethodBeat.o(156478);
        return v;
    }

    public final V get(String str) {
        AppMethodBeat.i(156479);
        Object obj = this.iuv.get(str);
        V v = (obj != null || this.itP == null) ? (V) obj : this.itP.get(str);
        com.tencent.mm.memory.a.a.a aVar = null;
        if (this.iuw != null) {
            aVar = (com.tencent.mm.memory.a.a.a) this.iuw.F(this.itO, str);
        }
        if (com.tencent.mm.memory.a.a.a.a.iuj) {
            Log.v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", str, v, aVar, Util.getStack().toString());
        }
        AppMethodBeat.o(156479);
        return v;
    }

    public final V put(String str, V v) {
        AppMethodBeat.i(156480);
        if (!bZ(v) || this.itP == null) {
            V v2 = (V) super.put((Object) str, (Object) v);
            AppMethodBeat.o(156480);
            return v2;
        }
        this.itP.put(str, v);
        AppMethodBeat.o(156480);
        return null;
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final /* bridge */ /* synthetic */ Object aSg() {
        return this.itO;
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final /* synthetic */ f aSh() {
        AppMethodBeat.i(156487);
        h hVar = new h(this.maxSize, new f.b<String, V>() {
            /* class com.tencent.mm.memory.a.b.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // com.tencent.mm.b.f.b
            public final /* synthetic */ void c(String str, Object obj, Object obj2) {
                AppMethodBeat.i(156466);
                String str2 = str;
                if (obj == null || obj2 == null || obj != obj2) {
                    if (com.tencent.mm.memory.a.a.a.a.iuj) {
                        Log.v("MicroMsg.BitmapResource", "BitmapResource MMLRUMap remove %s value newValue %s %s maxSize %s getfromKey %s stack [%s]", str2, obj, obj2, Integer.valueOf(b.this.maxSize), b.this.iuv.get(str2), Util.getStack().toString());
                    }
                    if (!(b.this.iux == null || obj == null || obj2 != null)) {
                        Log.i("MicroMsg.BitmapResource", "let me see see");
                        b.this.iux.c(str2, obj, obj2);
                    }
                    if (b.this.iuw != null) {
                        b.this.iuw.E(b.this.itO, str2);
                    }
                }
                AppMethodBeat.o(156466);
            }
        });
        AppMethodBeat.o(156487);
        return hVar;
    }
}
