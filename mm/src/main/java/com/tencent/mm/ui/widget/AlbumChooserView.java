package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class AlbumChooserView extends LinearLayout {
    public TextView QBA;
    public WeImageView QBB;
    public boolean QBC = false;
    private a QBD;

    public interface a {
        void dSb();
    }

    public AlbumChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159261);
        init(context);
        AppMethodBeat.o(159261);
    }

    public AlbumChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159262);
        init(context);
        AppMethodBeat.o(159262);
    }

    private void init(Context context) {
        AppMethodBeat.i(159263);
        View inflate = LayoutInflater.from(context).inflate(R.layout.cm, (ViewGroup) this, true);
        this.QBA = (TextView) inflate.findViewById(R.id.j6);
        this.QBB = (WeImageView) inflate.findViewById(R.id.j5);
        this.QBB.setRotation(90.0f);
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.widget.AlbumChooserView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(159258);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/AlbumChooserView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (AlbumChooserView.this.QBD != null) {
                    AlbumChooserView.this.QBD.dSb();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/AlbumChooserView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(159258);
            }
        });
        AppMethodBeat.o(159263);
    }

    public void setOnAlbumChooserViewClick(a aVar) {
        this.QBD = aVar;
    }
}
