package com.tencent.mm.plugin.textstatus.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.j.b;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/StatusThirdShare;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShare;", "()V", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "iconId", "", "setIconAvailable", "", "setTextStatus", "", "context", "Landroid/content/Context;", "statusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setTextStatusForResult", "Landroid/app/Activity;", "requestCode", "", "plugin-textstatus_release"})
public final class j implements i {
    @Override // com.tencent.mm.plugin.textstatus.a.i
    public final boolean a(Activity activity, int i2, m mVar) {
        AppMethodBeat.i(258403);
        if (activity == null) {
            AppMethodBeat.o(258403);
            return false;
        }
        if (mVar != null) {
            b bVar = b.GfZ;
            mVar.FZB = b.getName(mVar.Gae);
            mVar.VdK = 5;
        }
        TextStatusEditActivity.a aVar = TextStatusEditActivity.GeM;
        TextStatusEditActivity.a.a(activity, mVar, i2);
        AppMethodBeat.o(258403);
        return true;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.i
    public final boolean a(Context context, m mVar) {
        AppMethodBeat.i(216206);
        if (context == null) {
            AppMethodBeat.o(216206);
            return false;
        }
        if (mVar != null) {
            b bVar = b.GfZ;
            mVar.FZB = b.getName(mVar.Gae);
            mVar.VdK = 5;
        }
        TextStatusEditActivity.a aVar = TextStatusEditActivity.GeM;
        TextStatusEditActivity.a.b(context, mVar);
        AppMethodBeat.o(216206);
        return true;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.i
    public final Drawable byn(String str) {
        AppMethodBeat.i(258404);
        b bVar = b.GfZ;
        Drawable a2 = b.a(str, null, null, 6);
        AppMethodBeat.o(258404);
        return a2;
    }

    @Override // com.tencent.mm.plugin.textstatus.a.i
    public final void bym(String str) {
        AppMethodBeat.i(258405);
        b bVar = b.GfZ;
        b.byt(str);
        AppMethodBeat.o(258405);
    }
}
