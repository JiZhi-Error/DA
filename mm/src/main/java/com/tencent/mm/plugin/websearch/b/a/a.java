package com.tencent.mm.plugin.websearch.b.a;

import com.tencent.mm.plugin.fts.a.a.m;
import java.util.List;

public abstract class a<T> {
    protected int IGw = Integer.MAX_VALUE;
    protected String query;

    public abstract void ih(List<m> list);

    public a(String str, int i2) {
        this.query = str;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.query == aVar.query || (this.query != null && this.query.equalsIgnoreCase(aVar.query))) {
            z = true;
        } else {
            z = false;
        }
        return aVar.IGw == this.IGw && z;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
