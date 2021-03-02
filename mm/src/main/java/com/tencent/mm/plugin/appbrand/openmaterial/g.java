package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.ui.widget.a.e;

public interface g extends com.tencent.mm.vending.e.a {
    public static final g nlh = new g() {
        /* class com.tencent.mm.plugin.appbrand.openmaterial.g.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.g
        public final void a(b bVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.g
        public final void show() {
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.g
        public final void bPY() {
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.g
        public final void hide() {
        }

        @Override // com.tencent.mm.vending.e.a
        public final void dead() {
        }
    };

    public interface a {
        g a(Context context, e eVar, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection);

        a b(com.tencent.mm.plugin.appbrand.openmaterial.model.b bVar);
    }

    public interface b {
        void bQd();
    }

    void a(b bVar);

    void bPY();

    void hide();

    void show();
}
