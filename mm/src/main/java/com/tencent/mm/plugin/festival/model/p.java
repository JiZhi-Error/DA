package com.tencent.mm.plugin.festival.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.festival.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.l;
import kotlin.l.k;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u0019*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0019B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002¢\u0006\u0002\u0010\u0014J,\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0018R\u0010\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalMmkvProperty;", "T", "", "defaultValue", "key", "Lcom/tencent/mm/plugin/festival/util/FestivalProcessSharedMMKV$Key;", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/festival/util/FestivalProcessSharedMMKV$Key;)V", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "Ljava/lang/Object;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "propertyType", "Ljava/lang/Class;", "thisRef", "getValue", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Companion", "plugin-festival_release"})
public final class p<T> {
    @Deprecated
    public static final a Uyz = new a((byte) 0);
    private final Class<? extends T> Uyx;
    private Object Uyy;
    private final T aEX;
    private final String key;

    static {
        AppMethodBeat.i(263020);
        AppMethodBeat.o(263020);
    }

    private p(T t, String str) {
        kotlin.g.b.p.h(t, "defaultValue");
        kotlin.g.b.p.h(str, "key");
        AppMethodBeat.i(263018);
        this.aEX = t;
        this.key = str;
        this.Uyx = (Class<? extends T>) this.aEX.getClass();
        AppMethodBeat.o(263018);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public p(T t, f.a aVar) {
        this(t, aVar.name());
        kotlin.g.b.p.h(t, "defaultValue");
        kotlin.g.b.p.h(aVar, "key");
        AppMethodBeat.i(263019);
        AppMethodBeat.o(263019);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006*\u0006\u0012\u0002\b\u00030\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalMmkvProperty$Companion;", "", "()V", "TAG", "", "allSuperclasses", "", "Ljava/lang/Class;", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static Collection<Class<?>> bI(Class<?> cls) {
            AppMethodBeat.i(263014);
            ArrayList arrayList = new ArrayList();
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                arrayList.add(superclass);
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(263014);
            return arrayList2;
        }
    }

    private static MultiProcessMMKV aTI() {
        int intValue;
        AppMethodBeat.i(263015);
        f fVar = f.UGm;
        StringBuilder sb = new StringBuilder("FestivalProcessSharedMMKV_");
        if (g.aAc()) {
            kotlin.g.b.p.g(g.aAf(), "MMKernel.account()");
            intValue = com.tencent.mm.kernel.a.getUin();
        } else {
            intValue = ((Number) f.kIr.getValue()).intValue();
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(sb.append(intValue).toString());
        if (mmkv == null) {
            kotlin.g.b.p.hyc();
        }
        AppMethodBeat.o(263015);
        return mmkv;
    }

    public final T a(Object obj, k<?> kVar) {
        T t;
        AppMethodBeat.i(263016);
        kotlin.g.b.p.h(obj, "thisRef");
        kotlin.g.b.p.h(kVar, "property");
        this.Uyy = obj;
        Class<? extends T> cls = this.Uyx;
        if (kotlin.g.b.p.j(cls, Float.TYPE) || kotlin.g.b.p.j(cls, Float.class)) {
            MultiProcessMMKV aTI = aTI();
            String str = this.key;
            T t2 = this.aEX;
            if (t2 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(263016);
                throw tVar;
            }
            T t3 = (T) Float.valueOf(aTI.getFloat(str, t2.floatValue()));
            AppMethodBeat.o(263016);
            return t3;
        } else if (kotlin.g.b.p.j(cls, Integer.TYPE) || kotlin.g.b.p.j(cls, Integer.class)) {
            MultiProcessMMKV aTI2 = aTI();
            String str2 = this.key;
            T t4 = this.aEX;
            if (t4 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(263016);
                throw tVar2;
            }
            T t5 = (T) Integer.valueOf(aTI2.getInt(str2, t4.intValue()));
            AppMethodBeat.o(263016);
            return t5;
        } else if (kotlin.g.b.p.j(cls, String.class)) {
            MultiProcessMMKV aTI3 = aTI();
            String str3 = this.key;
            T t6 = this.aEX;
            if (t6 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(263016);
                throw tVar3;
            }
            String string = aTI3.getString(str3, t6);
            if (string == null) {
                t tVar4 = new t("null cannot be cast to non-null type T");
                AppMethodBeat.o(263016);
                throw tVar4;
            }
            T t7 = (T) string;
            AppMethodBeat.o(263016);
            return t7;
        } else if (kotlin.g.b.p.j(cls, Long.TYPE) || kotlin.g.b.p.j(cls, Long.class)) {
            MultiProcessMMKV aTI4 = aTI();
            String str4 = this.key;
            T t8 = this.aEX;
            if (t8 == null) {
                t tVar5 = new t("null cannot be cast to non-null type kotlin.Long");
                AppMethodBeat.o(263016);
                throw tVar5;
            }
            T t9 = (T) Long.valueOf(aTI4.getLong(str4, t8.longValue()));
            AppMethodBeat.o(263016);
            return t9;
        } else if (kotlin.g.b.p.j(cls, Boolean.TYPE) || kotlin.g.b.p.j(cls, Boolean.class)) {
            MultiProcessMMKV aTI5 = aTI();
            String str5 = this.key;
            T t10 = this.aEX;
            if (t10 == null) {
                t tVar6 = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(263016);
                throw tVar6;
            }
            T t11 = (T) Boolean.valueOf(aTI5.getBoolean(str5, t10.booleanValue()));
            AppMethodBeat.o(263016);
            return t11;
        } else {
            if (kotlin.g.b.p.j(cls, byte[].class)) {
                t = (T) aTI().decodeBytes(this.key);
                if (t == null) {
                    t = this.aEX;
                }
                if (t == null) {
                    t tVar7 = new t("null cannot be cast to non-null type T");
                    AppMethodBeat.o(263016);
                    throw tVar7;
                }
            } else if (kotlin.g.b.p.j(cls, b.class)) {
                byte[] decodeBytes = aTI().decodeBytes(this.key);
                t = decodeBytes != null ? (T) new b(decodeBytes) : this.aEX;
                if (t == null) {
                    t tVar8 = new t("null cannot be cast to non-null type T");
                    AppMethodBeat.o(263016);
                    throw tVar8;
                }
            } else if (a.bI(this.Uyx).contains(com.tencent.mm.bw.a.class)) {
                byte[] decodeBytes2 = aTI().decodeBytes(this.key);
                if (decodeBytes2 == null) {
                    T t12 = this.aEX;
                    AppMethodBeat.o(263016);
                    return t12;
                }
                try {
                    Object newInstance = this.Uyx.newInstance();
                    if (newInstance == null) {
                        t tVar9 = new t("null cannot be cast to non-null type com.tencent.mm.protobuf.BaseProtoBuf");
                        AppMethodBeat.o(263016);
                        throw tVar9;
                    }
                    com.tencent.mm.bw.a aVar = (com.tencent.mm.bw.a) newInstance;
                    aVar.parseFrom(decodeBytes2);
                    if (aVar == null) {
                        t tVar10 = new t("null cannot be cast to non-null type T");
                        AppMethodBeat.o(263016);
                        throw tVar10;
                    }
                    T t13 = (T) aVar;
                    AppMethodBeat.o(263016);
                    return t13;
                } catch (Exception e2) {
                    Log.e("Luggage.WxaMmkvProperty", "parse pb failed, class:" + this.Uyx.getCanonicalName());
                    T t14 = this.aEX;
                    AppMethodBeat.o(263016);
                    return t14;
                }
            } else {
                IllegalAccessError illegalAccessError = new IllegalAccessError("unsupported type:" + this.Uyx);
                AppMethodBeat.o(263016);
                throw illegalAccessError;
            }
            AppMethodBeat.o(263016);
            return t;
        }
    }

    public final void a(Object obj, k<?> kVar, T t) {
        AppMethodBeat.i(263017);
        kotlin.g.b.p.h(obj, "thisRef");
        kotlin.g.b.p.h(kVar, "property");
        this.Uyy = obj;
        if (t == null) {
            aTI().removeValueForKey(this.key);
            AppMethodBeat.o(263017);
            return;
        }
        Class<? extends T> cls = this.Uyx;
        if (kotlin.g.b.p.j(cls, Float.TYPE) || kotlin.g.b.p.j(cls, Float.class)) {
            aTI().putFloat(this.key, t.floatValue());
            AppMethodBeat.o(263017);
        } else if (kotlin.g.b.p.j(cls, Integer.TYPE) || kotlin.g.b.p.j(cls, Integer.class)) {
            aTI().putInt(this.key, t.intValue());
            AppMethodBeat.o(263017);
        } else if (kotlin.g.b.p.j(cls, String.class)) {
            aTI().putString(this.key, t);
            AppMethodBeat.o(263017);
        } else if (kotlin.g.b.p.j(cls, Long.TYPE) || kotlin.g.b.p.j(cls, Long.class)) {
            aTI().putLong(this.key, t.longValue());
            AppMethodBeat.o(263017);
        } else if (kotlin.g.b.p.j(cls, Boolean.TYPE) || kotlin.g.b.p.j(cls, Boolean.class)) {
            aTI().putBoolean(this.key, t.booleanValue());
            AppMethodBeat.o(263017);
        } else if (kotlin.g.b.p.j(cls, byte[].class)) {
            aTI().encode(this.key, (byte[]) t);
            AppMethodBeat.o(263017);
        } else if (kotlin.g.b.p.j(cls, b.class)) {
            aTI().encode(this.key, t.zy);
            AppMethodBeat.o(263017);
        } else if (a.bI(this.Uyx).contains(com.tencent.mm.bw.a.class)) {
            aTI().encode(this.key, t.toByteArray());
            AppMethodBeat.o(263017);
        } else {
            IllegalAccessError illegalAccessError = new IllegalAccessError("unsupported type:" + this.Uyx);
            AppMethodBeat.o(263017);
            throw illegalAccessError;
        }
    }
}
