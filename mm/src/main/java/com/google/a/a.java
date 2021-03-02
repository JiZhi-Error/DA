package com.google.a;

import com.google.a.ae;
import com.google.a.at;
import com.google.a.b;
import com.google.a.ba;
import com.google.a.cc;
import com.google.a.l;
import com.tencent.mm.plugin.appbrand.jsapi.share.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a extends b implements at {
    protected int bNa = -1;

    /* access modifiers changed from: protected */
    public interface b {
        void yH();
    }

    @Override // com.google.a.ax
    public boolean isInitialized() {
        for (l.f fVar : AS().getFields()) {
            if (fVar.FH() && !e(fVar)) {
                return false;
            }
        }
        for (Map.Entry<l.f, Object> entry : FS().entrySet()) {
            l.f key = entry.getKey();
            if (key.bSS.bTz == l.f.a.MESSAGE) {
                if (key.FJ()) {
                    for (at atVar : (List) entry.getValue()) {
                        if (!atVar.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((at) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public at.a a(b bVar) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    public final String toString() {
        return bx.a(this);
    }

    @Override // com.google.a.aw
    public void a(i iVar) {
        ba.a(this, FS(), iVar);
    }

    @Override // com.google.a.aw
    public int yC() {
        int i2 = this.bNa;
        if (i2 != -1) {
            return i2;
        }
        this.bNa = ba.a(this, FS());
        return this.bNa;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof at)) {
            return false;
        }
        at atVar = (at) obj;
        if (AS() != atVar.AS()) {
            return false;
        }
        Map<l.f, Object> FS = FS();
        Map<l.f, Object> FS2 = atVar.FS();
        if (FS.size() == FS2.size()) {
            Iterator<l.f> it = FS.keySet().iterator();
            loop0:
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                l.f next = it.next();
                if (!FS2.containsKey(next)) {
                    z = false;
                    break;
                }
                Object obj2 = FS.get(next);
                Object obj3 = FS2.get(next);
                if (next.bSS == l.f.b.BYTES) {
                    if (next.FJ()) {
                        List list = (List) obj2;
                        List list2 = (List) obj3;
                        if (list.size() != list2.size()) {
                            z = false;
                            break;
                        }
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (!k(list.get(i2), list2.get(i2))) {
                                z = false;
                                break loop0;
                            }
                        }
                        continue;
                    } else if (!k(obj2, obj3)) {
                        z = false;
                        break;
                    }
                } else if (next.FG()) {
                    if (!ao.b(A((List) obj2), A((List) obj3))) {
                        z = false;
                        break;
                    }
                } else if (!obj2.equals(obj3)) {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        return z && Ax().equals(atVar.Ax());
    }

    public int hashCode() {
        int i2 = this.bNb;
        if (i2 != 0) {
            return i2;
        }
        int b2 = (b(AS().hashCode() + q.CTRL_INDEX, FS()) * 29) + Ax().hashCode();
        this.bNb = b2;
        return b2;
    }

    private static g ak(Object obj) {
        if (obj instanceof byte[]) {
            return g.z((byte[]) obj);
        }
        return (g) obj;
    }

    private static boolean k(Object obj, Object obj2) {
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return ak(obj).equals(ak(obj2));
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    private static Map A(List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        at atVar = (at) it.next();
        l.a AS = atVar.AS();
        l.f ci = AS.ci("key");
        l.f ci2 = AS.ci("value");
        Object f2 = atVar.f(ci2);
        if (f2 instanceof l.e) {
            f2 = Integer.valueOf(((l.e) f2).bSM.bPE);
        }
        hashMap.put(atVar.f(ci), f2);
        while (it.hasNext()) {
            at atVar2 = (at) it.next();
            Object f3 = atVar2.f(ci2);
            if (f3 instanceof l.e) {
                f3 = Integer.valueOf(((l.e) f3).bSM.bPE);
            }
            hashMap.put(atVar2.f(ci), f3);
        }
        return hashMap;
    }

    private static int al(Object obj) {
        return ao.c(A((List) obj));
    }

    protected static int b(int i2, Map<l.f, Object> map) {
        for (Map.Entry<l.f, Object> entry : map.entrySet()) {
            l.f key = entry.getKey();
            Object value = entry.getValue();
            int i3 = (i2 * 37) + key.bSP.bPE;
            if (key.FG()) {
                i2 = (i3 * 53) + al(value);
            } else if (key.bSS != l.f.b.ENUM) {
                i2 = (i3 * 53) + value.hashCode();
            } else if (key.FJ()) {
                i2 = (i3 * 53) + ae.B((List) value);
            } else {
                i2 = (i3 * 53) + ae.a((ae.a) value);
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.a.b
    public final ca yD() {
        return AbstractC0085a.b(this);
    }

    /* renamed from: com.google.a.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0085a<BuilderType extends AbstractC0085a<BuilderType>> extends b.a implements at.a {
        /* renamed from: yE */
        public BuilderType yG() {
            throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
        }

        public boolean a(l.j jVar) {
            throw new UnsupportedOperationException("hasOneof() is not implemented.");
        }

        public l.f b(l.j jVar) {
            throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
        }

        /* renamed from: a */
        public BuilderType c(at atVar) {
            Map<l.f, Object> FS = atVar.FS();
            if (atVar.AS() != AS()) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            for (Map.Entry<l.f, Object> entry : FS.entrySet()) {
                l.f key = entry.getKey();
                if (key.FJ()) {
                    for (Object obj : (List) entry.getValue()) {
                        e(key, obj);
                    }
                } else if (key.bSS.bTz == l.f.a.MESSAGE) {
                    at atVar2 = (at) f(key);
                    if (atVar2 == atVar2.AQ()) {
                        f(key, entry.getValue());
                    } else {
                        f(key, atVar2.AM().c(atVar2).c((at) entry.getValue()).Bn());
                    }
                } else {
                    f(key, entry.getValue());
                }
            }
            a(atVar.Ax());
            return this;
        }

        public BuilderType a(cc ccVar) {
            f(cc.ac(Ax()).ae(ccVar).Bp());
            return this;
        }

        public String toString() {
            return bx.a(this);
        }

        protected static ca b(at atVar) {
            ArrayList arrayList = new ArrayList();
            ba.a(atVar, "", arrayList);
            return new ca(arrayList);
        }

        /* access modifiers changed from: package-private */
        public void yF() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public BuilderType c(g gVar, r rVar) {
            return (BuilderType) ((AbstractC0085a) super.b(gVar, rVar));
        }

        /* access modifiers changed from: private */
        /* renamed from: v */
        public BuilderType x(byte[] bArr) {
            return (BuilderType) ((AbstractC0085a) super.x(bArr));
        }

        /* renamed from: a */
        public BuilderType c(h hVar, r rVar) {
            cc.a aVar;
            int yT;
            if (hVar.bNr) {
                aVar = null;
            } else {
                aVar = cc.ac(Ax());
            }
            do {
                yT = hVar.yT();
                if (yT == 0) {
                    break;
                }
            } while (ba.a(hVar, aVar, rVar, AS(), new ba.a(this), yT));
            if (aVar != null) {
                f(aVar.Bp());
            }
            return this;
        }

        @Override // com.google.a.b.a
        public final /* bridge */ /* synthetic */ b.a n(byte[] bArr, int i2, int i3) {
            return (AbstractC0085a) super.n(bArr, i2, i3);
        }

        @Override // com.google.a.b.a
        public final /* synthetic */ b.a a(h hVar) {
            return c(hVar, p.FY());
        }
    }
}
