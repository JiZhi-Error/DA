package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.analyzer.model.d;
import java.io.Serializable;

public final class e implements Serializable {
    public final String cXS;
    public final boolean cXT;
    public final String cXU;
    public final String name;

    e(d.c cVar) {
        this.name = cVar.name;
        this.cXS = cVar.cXS;
        this.cXT = cVar.cXT;
        this.cXU = cVar.cXU;
    }
}
