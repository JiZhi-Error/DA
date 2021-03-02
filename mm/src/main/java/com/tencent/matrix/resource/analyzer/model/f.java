package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.a.a.b;
import java.io.File;
import java.io.Serializable;

public final class f implements Serializable {
    public final String cWR;
    public final File cXV;
    public final String mActivityName;

    public f(File file, String str, String str2) {
        this.cXV = (File) b.checkNotNull(file, "hprofFile");
        this.cWR = (String) b.checkNotNull(str, "refKey");
        this.mActivityName = (String) b.checkNotNull(str2, "activityName");
    }
}
