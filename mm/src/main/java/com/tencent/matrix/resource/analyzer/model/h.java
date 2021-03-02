package com.tencent.matrix.resource.analyzer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class h implements Serializable {
    public final List<j> elements;

    public h(List<j> list) {
        this.elements = Collections.unmodifiableList(new ArrayList(list));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.elements.size(); i2++) {
            j jVar = this.elements.get(i2);
            sb.append("* ");
            if (i2 == 0) {
                sb.append("GC ROOT ");
            } else if (i2 == this.elements.size() - 1) {
                sb.append("leaks ");
            } else {
                sb.append("references ");
            }
            sb.append(jVar).append('\n');
        }
        return sb.toString();
    }
}
