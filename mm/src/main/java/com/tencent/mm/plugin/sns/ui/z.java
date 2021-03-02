package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;

public interface z {

    public static abstract class a {
        public View.OnClickListener Erh = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.z.a.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(97924);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97924);
                    return;
                }
                a.this.Lc(((Integer) view.getTag()).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/IPreviewImageView$PreviewImageClick$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97924);
            }
        };

        public abstract void Lc(int i2);
    }

    void clean();

    View getView();

    void setImageClick(a aVar);

    void setIsShowAddImage(boolean z);

    void setList$22875ea3(List<String> list);
}
