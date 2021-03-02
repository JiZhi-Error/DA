package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference extends Preference implements u.a {
    private ImageView DlJ;
    private ImageView DlK;
    private ImageView DlL;
    List<String> DlM;
    f nRm;

    public TVThumbPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(28608);
        this.DlM = null;
        setLayoutResource(R.layout.c4s);
        setWidgetLayoutResource(0);
        u.a(this);
        AppMethodBeat.o(28608);
    }

    public TVThumbPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TVThumbPreference(Context context) {
        this(context, null);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(28609);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(28609);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(28610);
        super.onBindView(view);
        this.DlJ = (ImageView) view.findViewById(R.id.im8);
        this.DlK = (ImageView) view.findViewById(R.id.im9);
        this.DlL = (ImageView) view.findViewById(R.id.im_);
        if (this.DlM != null) {
            if (this.DlM.size() <= 0) {
                AppMethodBeat.o(28610);
                return;
            }
            b bVar = new b(this.DlM.get(0));
            this.DlJ.setTag(bVar.blC());
            Bitmap a2 = u.a(bVar);
            if (a2 != null && !a2.isRecycled()) {
                this.DlJ.setImageBitmap(a2);
            }
            this.DlJ.setVisibility(0);
            if (1 >= this.DlM.size()) {
                AppMethodBeat.o(28610);
                return;
            }
            b bVar2 = new b(this.DlM.get(1));
            this.DlK.setTag(bVar2.blC());
            Bitmap a3 = u.a(bVar2);
            if (a3 != null && !a3.isRecycled()) {
                this.DlK.setImageBitmap(a3);
            }
            this.DlK.setVisibility(0);
            if (2 >= this.DlM.size()) {
                AppMethodBeat.o(28610);
                return;
            }
            b bVar3 = new b(this.DlM.get(2));
            this.DlL.setTag(bVar3.blC());
            Bitmap a4 = u.a(bVar3);
            if (a4 != null && !a4.isRecycled()) {
                this.DlL.setImageBitmap(a4);
            }
            this.DlL.setVisibility(0);
        }
        AppMethodBeat.o(28610);
    }

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(28611);
        if (str == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(28611);
        } else if (this.DlJ != null && this.DlJ.getTag() != null && str.equals((String) this.DlJ.getTag())) {
            this.DlJ.post(new Runnable() {
                /* class com.tencent.mm.plugin.shake.ui.TVThumbPreference.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(28605);
                    TVThumbPreference.this.DlJ.setImageBitmap(bitmap);
                    if (TVThumbPreference.this.nRm != null) {
                        TVThumbPreference.this.nRm.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(28605);
                }
            });
            AppMethodBeat.o(28611);
        } else if (this.DlK == null || this.DlK.getTag() == null || !str.equals((String) this.DlK.getTag())) {
            if (!(this.DlL == null || this.DlL.getTag() == null || !str.equals((String) this.DlL.getTag()))) {
                this.DlL.post(new Runnable() {
                    /* class com.tencent.mm.plugin.shake.ui.TVThumbPreference.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(28607);
                        TVThumbPreference.this.DlL.setImageBitmap(bitmap);
                        if (TVThumbPreference.this.nRm != null) {
                            TVThumbPreference.this.nRm.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(28607);
                    }
                });
            }
            AppMethodBeat.o(28611);
        } else {
            this.DlK.post(new Runnable() {
                /* class com.tencent.mm.plugin.shake.ui.TVThumbPreference.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(28606);
                    TVThumbPreference.this.DlK.setImageBitmap(bitmap);
                    if (TVThumbPreference.this.nRm != null) {
                        TVThumbPreference.this.nRm.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(28606);
                }
            });
            AppMethodBeat.o(28611);
        }
    }
}
