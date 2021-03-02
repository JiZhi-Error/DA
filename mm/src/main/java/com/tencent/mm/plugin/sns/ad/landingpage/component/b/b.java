package com.tencent.mm.plugin.sns.ad.landingpage.component.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import java.util.ArrayList;
import java.util.List;

public final class b extends z {
    public String DtQ;
    public String DtR;
    public List<z> aQz = new ArrayList();

    public b() {
        AppMethodBeat.i(201999);
        AppMethodBeat.o(201999);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z
    public final List<z> eXg() {
        return this.aQz;
    }
}
