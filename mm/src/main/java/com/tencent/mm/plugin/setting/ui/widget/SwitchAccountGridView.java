package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView extends GridLayout {
    private static int Dga;
    private boolean Dgb;
    private boolean Dgc;
    private boolean Dgd;
    public String Dge;
    public AnimatorSet Dgf;
    public List<String> Dgg = new ArrayList();
    public List<d> Dgh = new ArrayList();
    public List<View> Dgi = new ArrayList();
    private b Dgj;
    private a Dgk;
    private c Dgl;
    public boolean jUE;
    private String klw;

    public interface a {
        void eTz();
    }

    public interface b {
        void aNg(String str);
    }

    public interface c {
        void aNh(String str);
    }

    public SwitchAccountGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(74644);
        Dga = getResources().getDimensionPixelOffset(R.dimen.f3063h) * 2;
        AppMethodBeat.o(74644);
    }

    public final void aG(Map<String, SwitchAccountModel> map) {
        Bitmap decodeByteArray;
        AppMethodBeat.i(74645);
        if (map != null && !map.isEmpty()) {
            this.Dgg.addAll(map.keySet());
            Collections.sort(this.Dgg);
        }
        Log.i("MicroMsg.SwitchAccountGridView", "account count %d", Integer.valueOf(this.Dgg.size()));
        for (int i2 = 0; i2 < this.Dgg.size(); i2++) {
            View inflate = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.bra, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.bn);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.bq);
            View findViewById = inflate.findViewById(R.id.bjd);
            final String str = this.Dgg.get(i2);
            TextView textView = (TextView) inflate.findViewById(R.id.by);
            d dVar = new d(this, (byte) 0);
            dVar.jWS = imageView;
            dVar.DeA = imageView2;
            dVar.xVW = textView;
            dVar.Dgp = findViewById;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            String str2 = map.get(str).tjJ;
            try {
                if (!Util.isNullOrNil(str2)) {
                    if (this.Dgd) {
                        Log.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
                        byte[] aW = s.aW(str2, 0, (int) s.boW(str2));
                        if (!(aW == null || (decodeByteArray = BitmapFactory.decodeByteArray(aW, 0, aW.length)) == null)) {
                            imageView.setImageBitmap(decodeByteArray);
                        }
                    } else {
                        Bitmap Mq = e.Mq(str2);
                        if (Mq != null) {
                            imageView.setImageBitmap(Mq);
                        } else {
                            a.b.c(dVar.jWS, str);
                        }
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SwitchAccountGridView", e2, "get avatar error", new Object[0]);
            }
            textView.setText(l.b(getContext(), map.get(str).username, textView.getTextSize()));
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74638);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.SwitchAccountGridView", "click %s", str);
                    if (!SwitchAccountGridView.this.Dgb && SwitchAccountGridView.this.Dgj != null) {
                        SwitchAccountGridView.this.Dgj.aNg(str);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74638);
                }
            });
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(74639);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (SwitchAccountGridView.this.Dgl != null) {
                        SwitchAccountGridView.this.Dgl.aNh(str);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(74639);
                }
            });
            this.Dgh.add(dVar);
            this.Dgi.add(inflate);
        }
        View inflate2 = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.bra, (ViewGroup) null);
        ImageView imageView3 = (ImageView) inflate2.findViewById(R.id.bn);
        TextView textView2 = (TextView) inflate2.findViewById(R.id.by);
        d dVar2 = new d(this, (byte) 0);
        dVar2.jWS = imageView3;
        dVar2.DeA = (ImageView) inflate2.findViewById(R.id.bq);
        dVar2.xVW = textView2;
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView3.setImageResource(R.drawable.gg);
        textView2.setText(getContext().getResources().getString(R.string.guu));
        imageView3.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(74640);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SwitchAccountGridView", "click addBtn");
                if (SwitchAccountGridView.this.Dgj != null) {
                    SwitchAccountGridView.this.Dgj.aNg(null);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74640);
            }
        });
        this.Dgh.add(dVar2);
        this.Dgi.add(inflate2);
        AppMethodBeat.o(74645);
    }

    public final void eTN() {
        AppMethodBeat.i(74646);
        if (this.jUE) {
            Log.i("MicroMsg.SwitchAccountGridView", "playing animation");
            AppMethodBeat.o(74646);
            return;
        }
        removeAllViews();
        int min = Math.min(2, this.Dgg.size());
        for (int i2 = 0; i2 < min; i2++) {
            if (!this.Dgb || this.Dgg.get(i2).equals(this.klw)) {
                this.Dgh.get(i2).DeA.setVisibility(4);
            } else {
                this.Dgh.get(i2).DeA.setVisibility(0);
            }
            this.Dgh.get(i2).Dgp.setVisibility(4);
            if (!Util.isNullOrNil(this.klw) && this.Dgg.get(i2).equals(this.klw)) {
                if (this.Dgc) {
                    ((ImageView) this.Dgh.get(i2).Dgp.findViewById(R.id.bje)).setImageResource(R.drawable.a76);
                } else {
                    ((ImageView) this.Dgh.get(i2).Dgp.findViewById(R.id.bje)).setImageResource(R.drawable.a72);
                }
                if (this.Dgc) {
                    ((TextView) this.Dgh.get(i2).Dgp.findViewById(R.id.bjg)).setText(getContext().getResources().getString(R.string.j5f));
                } else {
                    ((TextView) this.Dgh.get(i2).Dgp.findViewById(R.id.bjg)).setText(getContext().getResources().getString(R.string.gux));
                }
                this.Dgh.get(i2).Dgp.findViewById(R.id.bv).setVisibility(8);
                this.Dgh.get(i2).Dgp.findViewById(R.id.bje).setVisibility(0);
                this.Dgh.get(i2).Dgp.setVisibility(0);
            }
            if (!Util.isNullOrNil(this.Dge) && this.Dgg.get(i2).equals(this.Dge)) {
                ((TextView) this.Dgh.get(i2).Dgp.findViewById(R.id.bjg)).setText(getContext().getResources().getString(R.string.emm));
                this.Dgh.get(i2).Dgp.findViewById(R.id.bje).setVisibility(8);
                this.Dgh.get(i2).Dgp.findViewById(R.id.bv).setVisibility(0);
                this.Dgh.get(i2).Dgp.setVisibility(0);
            }
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = Dga;
            addView(this.Dgi.get(i2), layoutParams);
        }
        if (getChildCount() < 2) {
            this.Dgh.get(this.Dgh.size() - 1).DeA.setVisibility(4);
            GridLayout.LayoutParams layoutParams2 = new GridLayout.LayoutParams();
            layoutParams2.width = Dga;
            addView(this.Dgi.get(this.Dgi.size() - 1), layoutParams2);
        }
        AppMethodBeat.o(74646);
    }

    public void setDeleteState(boolean z) {
        this.Dgb = z;
    }

    public void setUseSystemDecoder(boolean z) {
        this.Dgd = z;
    }

    public int getAccountCount() {
        AppMethodBeat.i(74647);
        int size = this.Dgg.size();
        AppMethodBeat.o(74647);
        return size;
    }

    public void setSwitchToWxUsername(String str) {
        this.Dge = str;
    }

    public void setLastLoginWxUsername(String str) {
        this.klw = str;
    }

    public void setLogoutState(boolean z) {
        this.Dgc = z;
    }

    public void setOnClickAvatarListener(b bVar) {
        this.Dgj = bVar;
    }

    public void setOnAnimatorEndListener(a aVar) {
        this.Dgk = aVar;
    }

    public void setOnDeleteAvatarListener(c cVar) {
        this.Dgl = cVar;
    }

    /* access modifiers changed from: package-private */
    public class d {
        public ImageView DeA;
        public View Dgp;
        public ImageView jWS;
        public TextView xVW;

        private d() {
        }

        /* synthetic */ d(SwitchAccountGridView switchAccountGridView, byte b2) {
            this();
        }
    }
}
