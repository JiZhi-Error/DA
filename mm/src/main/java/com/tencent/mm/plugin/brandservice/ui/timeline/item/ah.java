package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;

public class ah extends aj {
    public View jBI;
    private Context mContext;
    public ImageView ptE;
    public View ptX;
    public TextView ptY;
    public TextView puD;
    public View puO;
    public View pxo;
    public MMNeat7extView pxp;
    public TextView pxq;
    public View pxr;
    public View pxs;
    public ImageView pxt;
    public ImageView pxu;
    public View pxv;
    public View pxw;
    private View.OnClickListener pxx = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.ah.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(6002);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            z R = ag.ban().R(((com.tencent.mm.plugin.brandservice.a.a) g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq(view), "msgId");
            if (R != null) {
                ah.this.pxE.pqZ.f(R, 4);
            } else {
                Log.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
            }
            a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(6002);
        }
    };

    public ah(com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context) {
        AppMethodBeat.i(6003);
        super.a(context, bVar);
        this.mContext = context;
        AppMethodBeat.o(6003);
    }

    public final void a(v vVar, z zVar, int i2, boolean z) {
        AppMethodBeat.i(6004);
        this.pxs.setVisibility(8);
        if (vVar.type == 5) {
            this.pxu.setVisibility(0);
            this.pxu.setImageResource(R.drawable.ic);
            this.pxu.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.item.ah.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ah.this.puO.performClick();
                    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
                }
            });
        } else if (vVar.type == 6) {
            this.pxu.setVisibility(0);
            if (z) {
                if ((zVar.field_msgId + "_" + i2).equals(c.crh())) {
                    this.pxu.setImageResource(R.drawable.nm);
                } else {
                    this.pxu.setImageResource(R.drawable.nn);
                }
            } else if ((zVar.field_msgId + "_" + i2).equals(c.crh())) {
                this.pxu.setImageResource(R.raw.chatting_item_biz_music_pause_loading_icon);
            } else {
                this.pxu.setImageResource(R.raw.chatting_item_biz_music_play_loading_icon);
            }
            a(this.pxu, zVar, i2, vVar.iAo);
        } else if (vVar.type == 7) {
            this.pxu.setVisibility(8);
            this.pxs.setVisibility(0);
            Drawable drawable = this.pxt.getDrawable();
            if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                ((AnimationDrawable) drawable).stop();
            }
            if ((zVar.field_msgId + "_" + i2).equals(c.crh())) {
                this.pxt.setImageResource(R.drawable.ie);
                if (this.pxu.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) this.pxu.getDrawable()).start();
                }
            } else {
                this.pxt.setImageResource(R.drawable.id);
            }
            a(this.pxt, zVar, i2, vVar.iAo);
        } else {
            this.pxu.setVisibility(8);
        }
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 28);
        if (vVar.type == 7) {
            fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 48);
        }
        ImageView imageView = this.pxu;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = fromDPToPix;
        layoutParams.height = fromDPToPix;
        imageView.setLayoutParams(layoutParams);
        AppMethodBeat.o(6004);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.aj
    public final void a(ImageView imageView, z zVar, int i2, String str) {
        AppMethodBeat.i(6006);
        ((com.tencent.mm.plugin.brandservice.a.a) g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(imageView, zVar.field_msgId, str, zVar.field_content, i2);
        imageView.setOnClickListener(this.pxx);
        AppMethodBeat.o(6006);
    }

    public void a(v vVar, boolean z) {
        AppMethodBeat.i(6007);
        if (vVar.type == 8) {
            this.pxv.setVisibility(0);
            if (vVar.iAC > 1) {
                this.puD.setVisibility(0);
                this.puD.setText(String.valueOf(vVar.iAC));
            } else {
                this.puD.setVisibility(8);
            }
            if (z) {
                this.pxw.setBackgroundResource(R.drawable.in);
                AppMethodBeat.o(6007);
                return;
            }
            this.pxw.setBackgroundResource(R.drawable.aij);
            AppMethodBeat.o(6007);
            return;
        }
        this.pxv.setVisibility(8);
        AppMethodBeat.o(6007);
    }
}
