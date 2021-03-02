package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.List;

public class FavTagEntrance extends LinearLayout implements MStorage.IOnStorageChange {
    private long dUt = -1;
    private TextView tmM;
    private String tmN = String.valueOf(this.dUt);

    public FavTagEntrance(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107546);
        AppMethodBeat.o(107546);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(107547);
        super.onFinishInflate();
        this.tmM = (TextView) findViewById(R.id.igz);
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.widget.FavTagEntrance.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(107545);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/fav/ui/widget/FavTagEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("key_fav_scene", 1);
                intent.putExtra("key_fav_item_id", FavTagEntrance.this.dUt);
                com.tencent.mm.plugin.fav.a.b.b(FavTagEntrance.this.getContext(), ".ui.FavTagEditUI", intent);
                a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavTagEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107545);
            }
        });
        AppMethodBeat.o(107547);
    }

    public void setFavItemID(long j2) {
        AppMethodBeat.i(107548);
        this.dUt = j2;
        this.tmN = String.valueOf(j2);
        AppMethodBeat.o(107548);
    }

    public void setTagContent(List<String> list) {
        String str;
        AppMethodBeat.i(107549);
        if (this.tmM == null) {
            AppMethodBeat.o(107549);
            return;
        }
        Context context = getContext();
        if (context == null || list == null || list.isEmpty()) {
            str = "";
        } else {
            String string = context.getResources().getString(R.string.ccq);
            str = list.get(0);
            for (int i2 = 1; i2 < list.size(); i2++) {
                str = str + string + list.get(i2);
            }
        }
        if (Util.isNullOrNil(str)) {
            this.tmM.setText("");
            this.tmM.setHint(R.string.c9x);
            AppMethodBeat.o(107549);
            return;
        }
        this.tmM.setText(l.b(getContext(), str, this.tmM.getTextSize()));
        AppMethodBeat.o(107549);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(107550);
        Log.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", str, this.tmN);
        if (this.tmN.equals(str)) {
            g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.dUt);
            if (DY == null) {
                Log.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", Long.valueOf(this.dUt));
                AppMethodBeat.o(107550);
                return;
            }
            setTagContent(DY.field_tagProto.Lyo);
        }
        AppMethodBeat.o(107550);
    }
}
