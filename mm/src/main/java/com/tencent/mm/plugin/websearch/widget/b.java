package com.tencent.mm.plugin.websearch.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.widget.view.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public final class b implements f {
    @Override // com.tencent.mm.plugin.websearch.api.f
    public final d a(Context context, n nVar) {
        AppMethodBeat.i(116628);
        a aVar = new a(context, nVar);
        AppMethodBeat.o(116628);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.websearch.api.f
    public final int a(Activity activity, String str, String str2, List<af> list, ae aeVar) {
        AppMethodBeat.i(116629);
        a fYZ = a.fYZ();
        e eVar = new e((Context) activity, 2, true);
        int hashCode = eVar.hashCode();
        eVar.HMa = new o.b(list) {
            /* class com.tencent.mm.plugin.websearch.widget.view.a.AnonymousClass1 */
            final /* synthetic */ List tdE;

            {
                this.tdE = r2;
            }

            @Override // com.tencent.mm.ui.base.o.b
            public final void a(ImageView imageView, MenuItem menuItem) {
                AppMethodBeat.i(116668);
                com.tencent.mm.av.a.a.bdb().a(((af) this.tdE.get(menuItem.getItemId())).iconUrl, imageView, a.this.IIu);
                AppMethodBeat.o(116668);
            }
        };
        eVar.HLX = new o.f(list, eVar) {
            /* class com.tencent.mm.plugin.websearch.widget.view.a.AnonymousClass2 */
            final /* synthetic */ e kmu;
            final /* synthetic */ List tdE;

            {
                this.tdE = r2;
                this.kmu = r3;
            }

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(116669);
                for (int i2 = 0; i2 < this.tdE.size(); i2++) {
                    af afVar = (af) this.tdE.get(i2);
                    mVar.a(i2, afVar.title, afVar.desc, 0);
                    if (afVar.isSelected) {
                        this.kmu.jKz = i2;
                    }
                }
                AppMethodBeat.o(116669);
            }
        };
        eVar.HLY = new o.g(aeVar, hashCode) {
            /* class com.tencent.mm.plugin.websearch.widget.view.a.AnonymousClass3 */
            final /* synthetic */ ae IIx;
            final /* synthetic */ int val$id;

            {
                this.IIx = r2;
                this.val$id = r3;
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(116670);
                Log.v("FTSSearchActionSheetMgr", "selected pos %d", Integer.valueOf(i2));
                if (this.IIx != null) {
                    this.IIx.ka(i2, this.val$id);
                }
                a.this.IIt.remove(Integer.valueOf(this.val$id));
                AppMethodBeat.o(116670);
            }
        };
        eVar.PGl = new e.b(aeVar, hashCode) {
            /* class com.tencent.mm.plugin.websearch.widget.view.a.AnonymousClass4 */
            final /* synthetic */ ae IIx;
            final /* synthetic */ int val$id;

            {
                this.IIx = r2;
                this.val$id = r3;
            }

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(116671);
                Log.v("FTSSearchActionSheetMgr", "selected pos %d", -1);
                if (this.IIx != null) {
                    this.IIx.ka(-1, this.val$id);
                }
                a.this.IIt.remove(Integer.valueOf(this.val$id));
                AppMethodBeat.o(116671);
            }
        };
        View inflate = View.inflate(activity, R.layout.bot, null);
        if (!TextUtils.isEmpty(str)) {
            ((TextView) inflate.findViewById(R.id.ipm)).setText(str);
        } else {
            inflate.findViewById(R.id.ipm).setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            ((TextView) inflate.findViewById(R.id.id1)).setText(str2);
        } else {
            inflate.findViewById(R.id.id1).setVisibility(8);
        }
        eVar.HMg = true;
        eVar.V(inflate, false);
        eVar.dGm();
        fYZ.IIt.put(Integer.valueOf(hashCode), eVar);
        AppMethodBeat.o(116629);
        return hashCode;
    }
}
