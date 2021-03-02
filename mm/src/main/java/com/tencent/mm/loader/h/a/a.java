package com.tencent.mm.loader.h.a;

public final class a<T> {
    protected b icf;
    protected T value;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    public a(String str) {
        this.value = str;
        this.icf = b.URI;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.loader.h.a.c */
    /* JADX WARN: Multi-variable type inference failed */
    public a(c cVar) {
        this.value = cVar;
        this.icf = b.URI;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    private a(String str, b bVar) {
        this.value = str;
        this.icf = bVar;
    }

    public static <T extends String> a<T> a(T t, b bVar) {
        return new a<>(t, bVar);
    }

    public final T value() {
        return this.value;
    }

    public final b aKr() {
        return this.icf;
    }

    public final boolean isLegal() {
        return this.value != null;
    }

    public final String aKs() {
        return this.value.toString();
    }

    public final String toString() {
        if (this.value == null) {
            return "";
        }
        if (this.value instanceof c) {
            return this.value.auA();
        }
        return this.value.toString();
    }

    public final int hashCode() {
        if (this.value != null) {
            return this.value.hashCode();
        }
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this.value != null) {
            if ((this.value instanceof c) && (obj instanceof a) && (((a) obj).value instanceof c)) {
                return this.value.auA().equals(((a) obj).value.auA());
            }
            if (obj instanceof a) {
                return this.value.equals(((a) obj).value);
            }
        }
        return super.equals(obj);
    }

    public static a aKt() {
        return new a("");
    }
}
