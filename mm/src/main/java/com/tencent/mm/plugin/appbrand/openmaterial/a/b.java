package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.openmaterial.i;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsQuickly", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "prefetchOpenMaterialsOnLaunchAppBrand", "Companion", "plugin-appbrand-integration_release"})
public interface b {
    public static final a nlq = a.nlr;

    AppBrandOpenMaterialCollection a(MaterialModel materialModel);

    void a(MaterialModel materialModel, i iVar);

    void c(MaterialModel materialModel);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource$Companion;", "", "()V", "USE_FAKE_IMPL_KEY", "", "useFakeImpl", "", "getUseFakeImpl", "()Z", "invoke", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "plugin-appbrand-integration_release"})
    public static final class a {
        static final /* synthetic */ a nlr = new a();

        static {
            AppMethodBeat.i(229143);
            AppMethodBeat.o(229143);
        }

        private a() {
        }

        public static b bQe() {
            boolean z = false;
            AppMethodBeat.i(229142);
            MultiProcessMMKV VQ = f.kIs.VQ();
            if (VQ != null) {
                z = VQ.getBoolean("open_material_fake", false);
            }
            if (z) {
                Log.d("MicroMsg.AppBrand.OpenMaterialDataSource", "create OpenMaterialDataSource, use FakeOpenMaterialDataSource");
                a aVar = a.nln;
                AppMethodBeat.o(229142);
                return aVar;
            }
            Log.d("MicroMsg.AppBrand.OpenMaterialDataSource", "create OpenMaterialDataSource, use WeChatOpenMaterialDataSourceAnyProcess");
            g gVar = g.nlA;
            AppMethodBeat.o(229142);
            return gVar;
        }
    }
}
