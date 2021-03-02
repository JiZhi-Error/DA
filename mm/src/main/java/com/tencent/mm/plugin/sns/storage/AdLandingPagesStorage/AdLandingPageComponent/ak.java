package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ak extends z {
    public LinkedList<r> DYI = new LinkedList<>();
    public int Eac = 0;
    public boolean autoCarousel = false;
    public boolean onr = true;

    public ak() {
        AppMethodBeat.i(96325);
        AppMethodBeat.o(96325);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z
    public final List<z> eXg() {
        AppMethodBeat.i(96326);
        ArrayList arrayList = new ArrayList(super.eXg());
        if (this.DYI != null) {
            Iterator<r> it = this.DYI.iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next.DYI != null) {
                    arrayList.addAll(next.DYI);
                }
            }
        }
        AppMethodBeat.o(96326);
        return arrayList;
    }
}
