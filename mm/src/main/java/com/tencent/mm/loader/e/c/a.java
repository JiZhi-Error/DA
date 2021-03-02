package com.tencent.mm.loader.e.c;

import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.e.c.b;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J@\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "T", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "transcoder", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "source", "when", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "asResourceName", "", "ishasTransCoderWhenDownload", "", "libimageloader_release"})
public final class a<T> extends b<T> {
    public a(b<T> bVar) {
        p.h(bVar, "transcoder");
        c(bVar);
    }

    public final e<T> a(g<?> gVar, f<?, T> fVar, e<T> eVar, b.EnumC0403b bVar) {
        e<T> eVar2;
        e<T> eVar3;
        e<T> eVar4;
        p.h(gVar, "targetView");
        p.h(fVar, "reaper");
        p.h(eVar, "source");
        p.h(bVar, "when");
        b bVar2 = this.iaI;
        if (!(bVar2 instanceof b)) {
            bVar2 = null;
        }
        if (bVar2 == null) {
            b bVar3 = this.iaI;
        } else {
            do {
                if (bVar2.iaJ == b.a.HIGH && bVar == bVar2.iaK) {
                    if (!(eVar instanceof e)) {
                        eVar2 = null;
                    } else {
                        eVar2 = eVar;
                    }
                    if (eVar2 == null) {
                        p.hyc();
                    }
                    e<T> a2 = bVar2.a(gVar, fVar, eVar2);
                    if (!(a2 instanceof e)) {
                        a2 = null;
                    }
                    if (a2 != null) {
                        eVar = a2;
                    }
                }
                bVar2 = bVar2.iaI;
                if (!(bVar2 instanceof b)) {
                    bVar2 = null;
                    continue;
                }
            } while (bVar2 != null);
        }
        b bVar32 = this.iaI;
        if (!(bVar32 instanceof b)) {
            bVar32 = null;
        }
        if (bVar32 == null) {
            b bVar4 = this.iaI;
        } else {
            do {
                if (bVar32.iaJ == b.a.NORMAL && bVar == bVar32.iaK) {
                    if (!(eVar instanceof e)) {
                        eVar3 = null;
                    } else {
                        eVar3 = eVar;
                    }
                    if (eVar3 == null) {
                        p.hyc();
                    }
                    e<T> a3 = bVar32.a(gVar, fVar, eVar3);
                    if (!(a3 instanceof e)) {
                        a3 = null;
                    }
                    if (a3 != null) {
                        eVar = a3;
                    }
                }
                bVar32 = bVar32.iaI;
                if (!(bVar32 instanceof b)) {
                    bVar32 = null;
                    continue;
                }
            } while (bVar32 != null);
        }
        b bVar42 = this.iaI;
        if (!(bVar42 instanceof b)) {
            bVar42 = null;
        }
        if (bVar42 == null) {
            return eVar;
        }
        do {
            if (bVar42.iaJ == b.a.LOW && bVar == bVar42.iaK) {
                if (!(eVar instanceof e)) {
                    eVar4 = null;
                } else {
                    eVar4 = eVar;
                }
                if (eVar4 == null) {
                    p.hyc();
                }
                e<T> a4 = bVar42.a(gVar, fVar, eVar4);
                if (!(a4 instanceof e)) {
                    a4 = null;
                }
                if (a4 != null) {
                    eVar = a4;
                }
            }
            bVar42 = bVar42.iaI;
            if (!(bVar42 instanceof b)) {
                bVar42 = null;
                continue;
            }
        } while (bVar42 != null);
        return eVar;
    }

    @Override // com.tencent.mm.loader.d.f
    public final e<? extends T> a(g<?> gVar, f<?, T> fVar, e<T> eVar) {
        p.h(gVar, "targetView");
        p.h(fVar, "reaper");
        p.h(eVar, "source");
        return eVar;
    }

    @Override // com.tencent.mm.loader.d.f
    public final String Hi(String str) {
        p.h(str, "source");
        b<?> bVar = this.iaI;
        if (bVar == null) {
            b<?> bVar2 = this.iaI;
        } else {
            do {
                if (bVar.iaJ == b.a.HIGH && b.EnumC0403b.DECODED == bVar.iaK) {
                    str = str + bVar.Hi(str);
                }
                bVar = bVar.iaI;
            } while (bVar != null);
        }
        b<?> bVar22 = this.iaI;
        if (bVar22 == null) {
            b<?> bVar3 = this.iaI;
        } else {
            do {
                if (bVar22.iaJ == b.a.NORMAL && b.EnumC0403b.DECODED == bVar22.iaK) {
                    str = str + bVar22.Hi(str);
                }
                bVar22 = bVar22.iaI;
            } while (bVar22 != null);
        }
        b<?> bVar32 = this.iaI;
        if (bVar32 == null) {
            return str;
        }
        do {
            if (bVar32.iaJ == b.a.LOW && b.EnumC0403b.DECODED == bVar32.iaK) {
                str = str + bVar32.Hi(str);
            }
            bVar32 = bVar32.iaI;
        } while (bVar32 != null);
        return str;
    }
}
