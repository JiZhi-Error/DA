package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq {
    public float height;
    public String iconUrl;
    public float paddingBottom;
    public float width;

    public final boolean equals(Object obj) {
        AppMethodBeat.i(96332);
        if (obj == this) {
            AppMethodBeat.o(96332);
            return true;
        } else if (obj instanceof aq) {
            aq aqVar = (aq) obj;
            if (aqVar.iconUrl.equals(this.iconUrl) && aqVar.width == this.width && aqVar.height == this.height && aqVar.paddingBottom == this.paddingBottom) {
                AppMethodBeat.o(96332);
                return true;
            }
            AppMethodBeat.o(96332);
            return false;
        } else {
            AppMethodBeat.o(96332);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(96333);
        int hashCode = super.hashCode();
        AppMethodBeat.o(96333);
        return hashCode;
    }
}
