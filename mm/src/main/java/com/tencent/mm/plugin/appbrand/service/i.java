package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.j;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.ui.widget.a.e;

public interface i extends a {
    h a(b bVar, Context context, e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection, g gVar, j jVar);

    AppBrandOpenMaterialCollection a(MaterialModel materialModel);

    void a(MaterialModel materialModel, com.tencent.mm.plugin.appbrand.openmaterial.i iVar);

    boolean a(MaterialModel materialModel, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection);

    boolean adl(String str);

    AppBrandOpenMaterialCollection b(MaterialModel materialModel);

    g.a bQa();

    boolean c(b bVar);
}
