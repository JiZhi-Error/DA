package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.d.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class d<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    private final a f2836a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2837b;

    /* renamed from: c  reason: collision with root package name */
    private List<T> f2838c;

    /* renamed from: d  reason: collision with root package name */
    private List<d<T>> f2839d;

    public interface a {
        b getPoint();
    }

    public d(double d2, double d3, double d4, double d5) {
        this(new a(d2, d3, d4, d5));
        AppMethodBeat.i(199646);
        AppMethodBeat.o(199646);
    }

    public d(a aVar) {
        this(aVar, 0);
    }

    private d(double d2, double d3, double d4, double d5, int i2) {
        this(new a(d2, d3, d4, d5), i2);
        AppMethodBeat.i(199647);
        AppMethodBeat.o(199647);
    }

    private d(a aVar, int i2) {
        this.f2839d = null;
        this.f2836a = aVar;
        this.f2837b = i2;
    }

    public void a(T t) {
        AppMethodBeat.i(199648);
        b point = t.getPoint();
        if (this.f2836a.a(point.f2832a, point.f2833b)) {
            a(point.f2832a, point.f2833b, t);
        }
        AppMethodBeat.o(199648);
    }

    private void a(double d2, double d3, T t) {
        AppMethodBeat.i(199649);
        d<T> dVar = this;
        while (dVar.f2839d != null) {
            if (d3 < dVar.f2836a.f2831f) {
                if (d2 < dVar.f2836a.f2830e) {
                    dVar = dVar.f2839d.get(0);
                } else {
                    dVar = dVar.f2839d.get(1);
                }
            } else if (d2 < dVar.f2836a.f2830e) {
                dVar = dVar.f2839d.get(2);
            } else {
                dVar = dVar.f2839d.get(3);
            }
        }
        if (dVar.f2838c == null) {
            dVar.f2838c = new ArrayList();
        }
        dVar.f2838c.add(t);
        if (dVar.f2838c.size() > 50 && dVar.f2837b < 40) {
            dVar.b();
        }
        AppMethodBeat.o(199649);
    }

    private void b() {
        AppMethodBeat.i(199650);
        this.f2839d = new ArrayList(4);
        this.f2839d.add(new d<>(this.f2836a.f2826a, this.f2836a.f2830e, this.f2836a.f2827b, this.f2836a.f2831f, this.f2837b + 1));
        this.f2839d.add(new d<>(this.f2836a.f2830e, this.f2836a.f2828c, this.f2836a.f2827b, this.f2836a.f2831f, this.f2837b + 1));
        this.f2839d.add(new d<>(this.f2836a.f2826a, this.f2836a.f2830e, this.f2836a.f2831f, this.f2836a.f2829d, this.f2837b + 1));
        this.f2839d.add(new d<>(this.f2836a.f2830e, this.f2836a.f2828c, this.f2836a.f2831f, this.f2836a.f2829d, this.f2837b + 1));
        List<T> list = this.f2838c;
        this.f2838c = null;
        for (T t : list) {
            a(t.getPoint().f2832a, t.getPoint().f2833b, t);
        }
        AppMethodBeat.o(199650);
    }

    public boolean b(T t) {
        AppMethodBeat.i(199651);
        b point = t.getPoint();
        if (this.f2836a.a(point.f2832a, point.f2833b)) {
            boolean b2 = b(point.f2832a, point.f2833b, t);
            AppMethodBeat.o(199651);
            return b2;
        }
        AppMethodBeat.o(199651);
        return false;
    }

    private boolean b(double d2, double d3, T t) {
        AppMethodBeat.i(199652);
        d<T> dVar = this;
        while (dVar.f2839d != null) {
            if (d3 < dVar.f2836a.f2831f) {
                if (d2 < dVar.f2836a.f2830e) {
                    dVar = dVar.f2839d.get(0);
                } else {
                    dVar = dVar.f2839d.get(1);
                }
            } else if (d2 < dVar.f2836a.f2830e) {
                dVar = dVar.f2839d.get(2);
            } else {
                dVar = dVar.f2839d.get(3);
            }
        }
        boolean remove = dVar.f2838c.remove(t);
        AppMethodBeat.o(199652);
        return remove;
    }

    public void a() {
        AppMethodBeat.i(199653);
        this.f2839d = null;
        if (this.f2838c != null) {
            this.f2838c.clear();
        }
        AppMethodBeat.o(199653);
    }

    public Collection<T> a(a aVar) {
        AppMethodBeat.i(199654);
        ArrayList arrayList = new ArrayList();
        a(aVar, arrayList);
        AppMethodBeat.o(199654);
        return arrayList;
    }

    private void a(a aVar, Collection<T> collection) {
        AppMethodBeat.i(199655);
        if (!this.f2836a.a(aVar)) {
            AppMethodBeat.o(199655);
        } else if (this.f2839d != null) {
            for (d<T> dVar : this.f2839d) {
                dVar.a(aVar, collection);
            }
            AppMethodBeat.o(199655);
        } else {
            if (this.f2838c != null) {
                if (aVar.b(this.f2836a)) {
                    collection.addAll(this.f2838c);
                    AppMethodBeat.o(199655);
                    return;
                }
                for (T t : this.f2838c) {
                    if (aVar.a(t.getPoint())) {
                        collection.add(t);
                    }
                }
            }
            AppMethodBeat.o(199655);
        }
    }
}
