package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\rH\u0002¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/tools/AppBrandOpenMaterialUI;", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity;", "()V", "initActivityCloseAnimation", "", "initActivityOpenAnimation", "intent", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "parseFileInfo", "Lkotlin/Pair;", "", "postLogin", "loginResult", "Lcom/tencent/mm/pluginsdk/ui/AutoLoginActivity$LoginResult;", "preLogin", "", "tryShowOpenMaterial", "filePath", "fileExt", "verifyCaller", "verifyKey", "ui-appchooser_release"})
public final class AppBrandOpenMaterialUI extends AutoLoginActivity {
    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(204783);
        setTheme(R.style.q6);
        super.onCreate(bundle);
        ao.e(getWindow());
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        AppMethodBeat.o(204783);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final void initActivityOpenAnimation(Intent intent) {
        AppMethodBeat.i(204784);
        overridePendingTransition(0, 0);
        AppMethodBeat.o(204784);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final void initActivityCloseAnimation() {
        AppMethodBeat.i(204785);
        overridePendingTransition(0, 0);
        AppMethodBeat.o(204785);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent) {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final void a(AutoLoginActivity.a aVar, Intent intent) {
        boolean z;
        AppMethodBeat.i(204786);
        Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "postLogin, loginResult: " + aVar + ", intent: " + intent + ", extras: " + (intent != null ? intent.getExtras() : null));
        if (aVar == null || AutoLoginActivity.a.LOGIN_OK != aVar || intent == null) {
            finish();
            AppMethodBeat.o(204786);
            return;
        }
        o<String, String> bp = bp(intent);
        if (bp == null) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "onCreate, fileInfo is null");
            finish();
            AppMethodBeat.o(204786);
            return;
        }
        A a2 = bp.first;
        B b2 = bp.second;
        i iVar = (i) g.af(i.class);
        if (iVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "tryShowOpenMaterial, openMaterialService is null");
            z = false;
        } else {
            MaterialModel eC = MaterialModel.eC(a2, b2);
            if (eC == null) {
                Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "tryShowOpenMaterial, materialModel is null");
                z = false;
            } else {
                AppBrandOpenMaterialCollection b3 = iVar.b(eC);
                p.g(b3, "openMaterialService.rest…Collection(materialModel)");
                if (b3.nlF.isEmpty()) {
                    Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "tryShowOpenMaterial, openMaterialCollection is illegal");
                    z = false;
                } else {
                    com.tencent.mm.plugin.appbrand.openmaterial.g a3 = iVar.bQa().b(b.ATTACH).a(this, null, b3);
                    p.g(a3, "openMaterialService.open…MaterialCollection, null)");
                    a3.a(new a(this));
                    a3.show();
                    z = true;
                }
            }
        }
        if (!z) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "onCreate, try show open material fail");
            finish();
        }
        AppMethodBeat.o(204786);
    }

    private static o<String, String> bp(Intent intent) {
        AppMethodBeat.i(204787);
        if (5 != intent.getIntExtra("menuId", -1)) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, id is not match");
            AppMethodBeat.o(204787);
            return null;
        }
        String stringExtra = intent.getStringExtra("thirdCtx");
        String str = stringExtra;
        if (str == null || str.length() == 0) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, thirdContextJsonStr is empty");
            AppMethodBeat.o(204787);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            if (!p.j("qb", jSONObject.getString("type"))) {
                Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, type is illegal");
                AppMethodBeat.o(204787);
                return null;
            }
            String string = jSONObject.getString("verify");
            p.g(string, "verifyKey");
            if (!bfi(string)) {
                Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, verify caller failed");
                AppMethodBeat.o(204787);
                return null;
            }
            String string2 = jSONObject.getString("filePath");
            if (!new com.tencent.mm.vfs.o(string2).exists()) {
                Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo filePath not exist");
                AppMethodBeat.o(204787);
                return null;
            }
            o<String, String> U = s.U(string2, jSONObject.getString("fileExt"));
            AppMethodBeat.o(204787);
            return U;
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "parseFileInfo, fail since ".concat(String.valueOf(e2)));
            AppMethodBeat.o(204787);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onHidden"})
    static final class a implements g.b {
        final /* synthetic */ AppBrandOpenMaterialUI Ksu;

        a(AppBrandOpenMaterialUI appBrandOpenMaterialUI) {
            this.Ksu = appBrandOpenMaterialUI;
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.g.b
        public final void bQd() {
            AppMethodBeat.i(204782);
            Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "onHidden#tryShowOpenMaterial");
            this.Ksu.finish();
            AppMethodBeat.o(204782);
        }
    }

    private static boolean bfi(String str) {
        boolean z;
        AppMethodBeat.i(204788);
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object i2 = aAh.azQ().i(ar.a.USERINFO_FLOAT_BALL_FILES_QB_VERIFY_STRING_SYNC);
        if (!(i2 instanceof String)) {
            i2 = null;
        }
        String str2 = (String) i2;
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "verifyCaller, originVerifyKeys is empty");
            AppMethodBeat.o(204788);
            return false;
        }
        List<String> a2 = n.a(str2, new String[]{","});
        if (!(a2 instanceof Collection) || !a2.isEmpty()) {
            Iterator<T> it = a2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Util.isEqual((String) it.next(), str)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialUI", "verifyCaller, verify fail, verifyKey: " + str + ", originVerifyKeys: " + str2);
            AppMethodBeat.o(204788);
            return false;
        }
        AppMethodBeat.o(204788);
        return true;
    }
}
