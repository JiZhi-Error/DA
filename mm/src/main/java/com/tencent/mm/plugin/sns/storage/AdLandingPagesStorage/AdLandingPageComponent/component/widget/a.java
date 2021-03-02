package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public abstract class a extends m {
    public abstract List<m> eWU();

    public abstract void eXc();

    public a(Context context, z zVar, ViewGroup viewGroup) {
        super(context, zVar, viewGroup);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean fdm() {
        int fdl = fdl();
        Log.i("MicroMsg.AdLandingPageContainerComponent", "inScreenHeight %d", Integer.valueOf(fdl));
        return fdl > 0;
    }
}
