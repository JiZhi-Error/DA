package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends h implements Iterable<b> {
    public final List<h> aIq = new ArrayList();
    public final List<String> aZK = new ArrayList();
    public transient a aZL = new a();

    public e() {
        AppMethodBeat.i(74726);
        AppMethodBeat.o(74726);
    }

    public final e g(String str, String str2) {
        AppMethodBeat.i(217567);
        a(str, a.aQ(str2));
        AppMethodBeat.o(217567);
        return this;
    }

    public final e a(String str, h hVar) {
        AppMethodBeat.i(74727);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.o(74727);
            throw nullPointerException;
        } else if (hVar == null) {
            NullPointerException nullPointerException2 = new NullPointerException("value is null");
            AppMethodBeat.o(74727);
            throw nullPointerException2;
        } else {
            this.aZL.i(str, this.aZK.size());
            this.aZK.add(str);
            this.aIq.add(hVar);
            AppMethodBeat.o(74727);
            return this;
        }
    }

    public final e h(String str, int i2) {
        AppMethodBeat.i(74728);
        b(str, a.dA(i2));
        AppMethodBeat.o(74728);
        return this;
    }

    public final e c(String str, long j2) {
        AppMethodBeat.i(74729);
        b(str, a.s(j2));
        AppMethodBeat.o(74729);
        return this;
    }

    public final e a(String str, float f2) {
        AppMethodBeat.i(74730);
        b(str, a.ab(f2));
        AppMethodBeat.o(74730);
        return this;
    }

    public final e a(String str, double d2) {
        AppMethodBeat.i(74731);
        b(str, a.d(d2));
        AppMethodBeat.o(74731);
        return this;
    }

    public final e c(String str, boolean z) {
        AppMethodBeat.i(74732);
        b(str, a.aL(z));
        AppMethodBeat.o(74732);
        return this;
    }

    public final e h(String str, String str2) {
        AppMethodBeat.i(74733);
        b(str, a.aQ(str2));
        AppMethodBeat.o(74733);
        return this;
    }

    public final e b(String str, h hVar) {
        AppMethodBeat.i(74734);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.o(74734);
            throw nullPointerException;
        } else if (hVar == null) {
            NullPointerException nullPointerException2 = new NullPointerException("value is null");
            AppMethodBeat.o(74734);
            throw nullPointerException2;
        } else {
            int indexOf = indexOf(str);
            if (indexOf != -1) {
                this.aIq.set(indexOf, hVar);
            } else {
                this.aZL.i(str, this.aZK.size());
                this.aZK.add(str);
                this.aIq.add(hVar);
            }
            AppMethodBeat.o(74734);
            return this;
        }
    }

    public final h aU(String str) {
        AppMethodBeat.i(74735);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.o(74735);
            throw nullPointerException;
        }
        int indexOf = indexOf(str);
        if (indexOf != -1) {
            h hVar = this.aIq.get(indexOf);
            AppMethodBeat.o(74735);
            return hVar;
        }
        AppMethodBeat.o(74735);
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<b> iterator() {
        AppMethodBeat.i(74736);
        final Iterator<String> it = this.aZK.iterator();
        final Iterator<h> it2 = this.aIq.iterator();
        AnonymousClass1 r2 = new Iterator<b>() {
            /* class com.eclipsesource.a.e.AnonymousClass1 */

            public final boolean hasNext() {
                AppMethodBeat.i(74717);
                boolean hasNext = it.hasNext();
                AppMethodBeat.o(74717);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.i(74718);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(74718);
                throw unsupportedOperationException;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.Iterator
            public final /* synthetic */ b next() {
                AppMethodBeat.i(74719);
                b bVar = new b((String) it.next(), (h) it2.next());
                AppMethodBeat.o(74719);
                return bVar;
            }
        };
        AppMethodBeat.o(74736);
        return r2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.eclipsesource.a.h
    public final void a(i iVar) {
        AppMethodBeat.i(74737);
        iVar.sK();
        Iterator<h> it = this.aIq.iterator();
        boolean z = true;
        for (String str : this.aZK) {
            if (!z) {
                iVar.sN();
            }
            iVar.aZ(str);
            iVar.sM();
            it.next().a(iVar);
            z = false;
        }
        iVar.sL();
        AppMethodBeat.o(74737);
    }

    @Override // com.eclipsesource.a.h
    public final boolean isObject() {
        return true;
    }

    @Override // com.eclipsesource.a.h
    public final e si() {
        return this;
    }

    @Override // com.eclipsesource.a.h
    public final int hashCode() {
        AppMethodBeat.i(74738);
        int hashCode = ((this.aZK.hashCode() + 31) * 31) + this.aIq.hashCode();
        AppMethodBeat.o(74738);
        return hashCode;
    }

    @Override // com.eclipsesource.a.h
    public final boolean equals(Object obj) {
        AppMethodBeat.i(74739);
        if (this == obj) {
            AppMethodBeat.o(74739);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(74739);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(74739);
            return false;
        } else {
            e eVar = (e) obj;
            if (!this.aZK.equals(eVar.aZK) || !this.aIq.equals(eVar.aIq)) {
                AppMethodBeat.o(74739);
                return false;
            }
            AppMethodBeat.o(74739);
            return true;
        }
    }

    public final int indexOf(String str) {
        AppMethodBeat.i(74740);
        int i2 = this.aZL.get(str);
        if (i2 == -1 || !str.equals(this.aZK.get(i2))) {
            int lastIndexOf = this.aZK.lastIndexOf(str);
            AppMethodBeat.o(74740);
            return lastIndexOf;
        }
        AppMethodBeat.o(74740);
        return i2;
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.i(74741);
        objectInputStream.defaultReadObject();
        this.aZL = new a();
        int size = this.aZK.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.aZL.i(this.aZK.get(i2), i2);
        }
        AppMethodBeat.o(74741);
    }

    public static class b {
        private final h aZQ;
        private final String name;

        b(String str, h hVar) {
            this.name = str;
            this.aZQ = hVar;
        }

        public final int hashCode() {
            AppMethodBeat.i(74724);
            int hashCode = ((this.name.hashCode() + 31) * 31) + this.aZQ.hashCode();
            AppMethodBeat.o(74724);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(74725);
            if (this == obj) {
                AppMethodBeat.o(74725);
                return true;
            } else if (obj == null) {
                AppMethodBeat.o(74725);
                return false;
            } else if (getClass() != obj.getClass()) {
                AppMethodBeat.o(74725);
                return false;
            } else {
                b bVar = (b) obj;
                if (!this.name.equals(bVar.name) || !this.aZQ.equals(bVar.aZQ)) {
                    AppMethodBeat.o(74725);
                    return false;
                }
                AppMethodBeat.o(74725);
                return true;
            }
        }
    }

    public static class a {
        private final byte[] aZP = new byte[32];

        public a() {
            AppMethodBeat.i(74720);
            AppMethodBeat.o(74720);
        }

        /* access modifiers changed from: package-private */
        public final void i(String str, int i2) {
            AppMethodBeat.i(74721);
            int ac = ac(str);
            if (i2 < 255) {
                this.aZP[ac] = (byte) (i2 + 1);
                AppMethodBeat.o(74721);
                return;
            }
            this.aZP[ac] = 0;
            AppMethodBeat.o(74721);
        }

        public final void remove(int i2) {
            for (int i3 = 0; i3 < this.aZP.length; i3++) {
                if (this.aZP[i3] == i2 + 1) {
                    this.aZP[i3] = 0;
                } else if (this.aZP[i3] > i2 + 1) {
                    byte[] bArr = this.aZP;
                    bArr[i3] = (byte) (bArr[i3] - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int get(Object obj) {
            AppMethodBeat.i(74722);
            int i2 = (this.aZP[ac(obj)] & 255) - 1;
            AppMethodBeat.o(74722);
            return i2;
        }

        private int ac(Object obj) {
            AppMethodBeat.i(74723);
            int hashCode = obj.hashCode() & (this.aZP.length - 1);
            AppMethodBeat.o(74723);
            return hashCode;
        }
    }
}
