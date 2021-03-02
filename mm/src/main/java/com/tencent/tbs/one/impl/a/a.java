package com.tencent.tbs.one.impl.a;

import java.util.ArrayList;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2326a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f2327b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<l<T>> f2328c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f2329d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2330e;

    /* renamed from: f  reason: collision with root package name */
    private int f2331f;

    /* renamed from: g  reason: collision with root package name */
    private T f2332g;

    /* renamed from: h  reason: collision with root package name */
    private int f2333h;

    /* renamed from: i  reason: collision with root package name */
    private String f2334i;

    /* renamed from: j  reason: collision with root package name */
    private Throwable f2335j;

    public abstract void a();

    public final void a(int i2) {
        synchronized (this.f2327b) {
            if (i2 - this.f2331f > 2) {
                int i3 = this.f2331f;
                this.f2331f = i2;
                for (l lVar : (l[]) this.f2328c.toArray(new l[0])) {
                    lVar.a(i3, i2);
                }
            }
        }
    }

    public void a(int i2, String str, Throwable th) {
        synchronized (this.f2327b) {
            this.f2329d = false;
            this.f2331f = 0;
            this.f2333h = i2;
            this.f2334i = str;
            this.f2335j = th;
            l[] lVarArr = (l[]) this.f2328c.toArray(new l[0]);
            this.f2328c.clear();
            for (l lVar : lVarArr) {
                lVar.a(i2, str, th);
            }
        }
    }

    public final void a(l<T> lVar) {
        synchronized (this.f2327b) {
            if (this.f2330e) {
                if (lVar != null) {
                    lVar.a(0, 100);
                    lVar.a(this.f2332g);
                }
            } else if (this.f2333h != 0) {
                if (lVar != null) {
                    lVar.a(this.f2333h, this.f2334i, this.f2335j);
                }
            } else {
                if (lVar != null) {
                    lVar.a(0, this.f2331f);
                    this.f2328c.add(lVar);
                }
                if (!this.f2329d) {
                    this.f2329d = true;
                    a();
                }
            }
        }
    }

    public void a(T t) {
        synchronized (this.f2327b) {
            this.f2329d = false;
            this.f2330e = true;
            int i2 = this.f2331f;
            this.f2331f = 100;
            this.f2332g = t;
            l[] lVarArr = (l[]) this.f2328c.toArray(new l[0]);
            this.f2328c.clear();
            for (l lVar : lVarArr) {
                lVar.a(i2, 100);
                lVar.a(t);
            }
        }
    }

    public void b() {
        this.f2326a = true;
    }
}
