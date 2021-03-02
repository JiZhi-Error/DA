package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.WWMediaMessage;

public class WWMediaLocation extends WWMediaMessage.WWMediaObject {
    public double Sxv;
    public String iUO;
    public double latitude;
    public double longitude;

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final boolean checkArgs() {
        AppMethodBeat.i(106544);
        if (!super.checkArgs()) {
            AppMethodBeat.o(106544);
            return false;
        } else if (this.iUO == null || this.iUO.length() == 0 || this.iUO.length() > 10240) {
            AppMethodBeat.o(106544);
            return false;
        } else {
            AppMethodBeat.o(106544);
            return true;
        }
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void toBundle(Bundle bundle) {
        AppMethodBeat.i(106545);
        bundle.putString("_wwlocobject_address", this.iUO);
        bundle.putDouble("_wwlocobject_longitude", this.longitude);
        bundle.putDouble("_wwlocobject_latitude", this.latitude);
        bundle.putDouble("_wwlocobject_zoom", this.Sxv);
        super.toBundle(bundle);
        AppMethodBeat.o(106545);
    }

    @Override // com.tencent.wework.api.model.WWMediaMessage, com.tencent.wework.api.model.BaseMessage, com.tencent.wework.api.model.WWBaseMessage
    public final void fromBundle(Bundle bundle) {
        AppMethodBeat.i(199008);
        this.iUO = bundle.getString("_wwlocobject_address");
        this.longitude = bundle.getDouble("_wwlocobject_longitude");
        this.latitude = bundle.getDouble("_wwlocobject_latitude");
        this.Sxv = bundle.getDouble("_wwlocobject_zoom");
        super.fromBundle(bundle);
        AppMethodBeat.o(199008);
    }
}
