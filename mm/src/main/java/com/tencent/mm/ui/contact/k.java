package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.o;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class k extends LinearLayout {
    private Context context;
    private String iNV;

    public k(Context context2, String str) {
        super(context2);
        AppMethodBeat.i(37829);
        this.context = context2;
        this.iNV = str;
        View inflate = View.inflate(getContext(), R.layout.a3t, this);
        View findViewById = findViewById(R.id.c45);
        inflate.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.k.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37827);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("enterprise_from_scene", 2);
                intent.putExtra("enterprise_biz_name", k.this.iNV);
                c.b(view.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
                a.a(this, "com/tencent/mm/ui/contact/EnterpriseBizViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37827);
            }
        });
        findViewById.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.contact.k.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(37828);
                if (k.this.context instanceof MMActivity) {
                    ((MMActivity) k.this.context).hideVKB();
                }
                AppMethodBeat.o(37828);
                return false;
            }
        });
        bg.aVF();
        as bjJ = com.tencent.mm.model.c.aSN().bjJ(this.iNV);
        if (bjJ == null || ((int) bjJ.gMZ) <= 0) {
            Log.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", this.iNV);
            AppMethodBeat.o(37829);
            return;
        }
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.id.a5a);
        a.b.c((ImageView) maskLayout.getContentView(), this.iNV);
        if (bjJ.field_verifyFlag == 0) {
            maskLayout.setMaskBitmap(null);
        } else if (ay.a.iDs != null) {
            String rW = ay.a.iDs.rW(bjJ.field_verifyFlag);
            if (rW != null) {
                maskLayout.a(o.Nw(rW), MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
            } else {
                maskLayout.setMaskBitmap(null);
            }
        } else {
            maskLayout.setMaskBitmap(null);
        }
        ((TextView) findViewById(R.id.c46)).setText(bjJ.arI());
        AppMethodBeat.o(37829);
    }
}
