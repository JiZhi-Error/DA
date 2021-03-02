package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.p;

public final class f implements b.k {
    private TextView EII = null;
    private TextView EIJ = null;
    p Kni;
    public boolean Knj = true;
    private long ONa = 10000;
    private ImageView ONb = null;
    private String ONc = null;
    private ChatFooter ONd;
    private boolean ONe = false;
    public a ONf;
    MMHandler ONg = null;
    private Bitmap bitmap = null;
    private View contentView = null;
    private Context context;
    private ImageView dPk = null;
    private ProgressBar dPm = null;
    private View gvQ;

    public interface a {
        void gKm();
    }

    @Override // com.tencent.mm.modelappbrand.a.b.k
    public final void aYg() {
        AppMethodBeat.i(33820);
        Log.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
        this.dPm.setVisibility(0);
        this.dPk.setVisibility(8);
        this.ONb.setVisibility(8);
        AppMethodBeat.o(33820);
    }

    @Override // com.tencent.mm.modelappbrand.a.b.k
    public final void I(Bitmap bitmap2) {
        AppMethodBeat.i(33821);
        Log.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
        if (bitmap2 == null) {
            Log.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
            AppMethodBeat.o(33821);
            return;
        }
        this.bitmap = bitmap2;
        this.dPm.setVisibility(8);
        if (bitmap2 == null || bitmap2.isRecycled()) {
            this.ONb.setVisibility(0);
            this.dPk.setVisibility(8);
            AppMethodBeat.o(33821);
            return;
        }
        this.dPk.setVisibility(0);
        this.dPk.setImageBitmap(bitmap2);
        this.ONb.setVisibility(8);
        AppMethodBeat.o(33821);
    }

    @Override // com.tencent.mm.modelappbrand.a.b.k
    public final void oD() {
        AppMethodBeat.i(33822);
        Log.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
        this.ONb.setVisibility(0);
        this.dPm.setVisibility(8);
        this.dPk.setVisibility(8);
        AppMethodBeat.o(33822);
    }

    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
    public final String Lb() {
        AppMethodBeat.i(33823);
        String cO = n.cO(this);
        AppMethodBeat.o(33823);
        return cO;
    }

    public f(Context context2, View view, ChatFooter chatFooter) {
        AppMethodBeat.i(33824);
        this.context = context2;
        this.gvQ = view;
        this.ONd = chatFooter;
        this.contentView = View.inflate(this.context, R.layout.q_, null);
        this.EII = (TextView) this.contentView.findViewById(R.id.dwo);
        this.EIJ = (TextView) this.contentView.findViewById(R.id.dwp);
        this.dPk = (ImageView) this.contentView.findViewById(R.id.dvz);
        this.ONb = (ImageView) this.contentView.findViewById(R.id.c4o);
        this.dPm = (ProgressBar) this.contentView.findViewById(R.id.dwg);
        this.Kni = new p(this.contentView, -2, -2, true);
        this.Kni.setBackgroundDrawable(new ColorDrawable(0));
        this.Kni.setOutsideTouchable(true);
        this.Kni.setFocusable(false);
        this.contentView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.appbrand.f.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(33815);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (f.this.ONf != null) {
                    f.this.ONf.gKm();
                }
                f.this.Kni.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/appbrand/AppBrandServiceImageBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33815);
            }
        });
        this.ONg = new MMHandler(this.context.getMainLooper()) {
            /* class com.tencent.mm.ui.appbrand.f.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(33816);
                f.a(f.this);
                AppMethodBeat.o(33816);
            }
        };
        AppMethodBeat.o(33824);
    }

    static /* synthetic */ void a(f fVar) {
        boolean z;
        AppMethodBeat.i(33825);
        if (fVar.dPk == null || fVar.Kni == null || fVar.gvQ == null || fVar.ONd == null) {
            Log.e("MicroMsg.AppBrandServiceImageBubble", "these references include null reference");
            AppMethodBeat.o(33825);
            return;
        }
        if (fVar.bitmap != null) {
            Log.d("MicroMsg.AppBrandServiceImageBubble", "bitmap is null,return");
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            fVar.aYg();
        } else {
            fVar.I(fVar.bitmap);
        }
        int i2 = fVar.Knj ? 83 : 85;
        int i3 = fVar.Knj ? 0 : 10;
        int yFromBottom = fVar.ONd.getYFromBottom();
        if (Build.VERSION.SDK_INT >= 21) {
            Rect gJG = ao.gJG();
            i3 = fVar.Knj ? 0 : i3 + gJG.right;
            yFromBottom += gJG.bottom;
            Log.i("MicroMsg.AppBrandServiceImageBubble", "bubble navbar height %s %s", Integer.valueOf(gJG.right), Integer.valueOf(gJG.bottom));
        }
        try {
            fVar.Kni.showAtLocation(fVar.gvQ, i2, i3, yFromBottom);
            if (fVar.ONa > 0) {
                new MTimerHandler(new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.ui.appbrand.f.AnonymousClass3 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(33817);
                        f fVar = f.this;
                        Log.d("MicroMsg.AppBrandServiceImageBubble", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
                        if (fVar.Kni != null) {
                            fVar.Kni.dismiss();
                        }
                        AppMethodBeat.o(33817);
                        return false;
                    }
                }, false).startTimer(fVar.ONa);
            }
            AppMethodBeat.o(33825);
        } catch (WindowManager.BadTokenException e2) {
            AppMethodBeat.o(33825);
        }
    }
}
