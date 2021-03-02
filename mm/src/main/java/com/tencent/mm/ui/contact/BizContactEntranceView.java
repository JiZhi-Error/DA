package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.api.q;
import com.tencent.mm.br.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView extends RelativeLayout {
    private View PTY;
    private TextView PTZ;
    private LinearLayout PUa;
    private boolean PUb = true;
    private boolean PUc;
    private Context mContext;
    private View qWL = null;

    public BizContactEntranceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(37661);
        this.mContext = context;
        init();
        gUu();
        AppMethodBeat.o(37661);
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37662);
        this.mContext = context;
        init();
        gUu();
        AppMethodBeat.o(37662);
    }

    public BizContactEntranceView(Context context) {
        super(context);
        AppMethodBeat.i(37663);
        this.mContext = context;
        init();
        gUu();
        AppMethodBeat.o(37663);
    }

    private void init() {
        AppMethodBeat.i(37664);
        this.PUc = false;
        View.inflate(getContext(), R.layout.jg, this);
        this.qWL = findViewById(R.id.be3);
        this.PTY = this.qWL.findViewById(R.id.a5b);
        this.PUa = (LinearLayout) this.qWL.findViewById(R.id.a99);
        ViewGroup.LayoutParams layoutParams = this.PTY.getLayoutParams();
        layoutParams.height = (int) (((float) a.aH(getContext(), R.dimen.az)) * a.jj(getContext()));
        this.PTY.setLayoutParams(layoutParams);
        this.qWL.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.contact.BizContactEntranceView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37657);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!WeChatBrands.Business.Entries.ContactOa.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37657);
                } else if (((q) g.af(q.class)).Vv()) {
                    ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(BizContactEntranceView.this.mContext);
                    ((q) g.af(q.class)).o(8, "");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37657);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("intent_service_type", 251658241);
                    c.b(view.getContext(), "brandservice", ".ui.BrandServiceIndexUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37657);
                }
            }
        });
        this.PTY.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.contact.BizContactEntranceView.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(37658);
                if (BizContactEntranceView.this.mContext instanceof MMActivity) {
                    ((MMActivity) BizContactEntranceView.this.mContext).hideVKB();
                }
                AppMethodBeat.o(37658);
                return false;
            }
        });
        MaskLayout maskLayout = (MaskLayout) this.PTY.findViewById(R.id.a5a);
        p.aYn();
        ((ImageView) maskLayout.getContentView()).setImageBitmap(e.Mp("service_officialaccounts"));
        this.PTZ = (TextView) maskLayout.findViewById(R.id.iot);
        AppMethodBeat.o(37664);
    }

    /* access modifiers changed from: package-private */
    public final void gUu() {
        AppMethodBeat.i(37665);
        long currentTimeMillis = System.currentTimeMillis();
        bg.aVF();
        int gCe = com.tencent.mm.model.c.aSN().gCe();
        if (gCe > 0) {
            this.PUb = true;
        } else {
            this.PUb = false;
        }
        this.PTY.setVisibility(this.PUb ? 0 : 8);
        if (this.PUb) {
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.ui.contact.BizContactEntranceView.AnonymousClass3 */

                public final void run() {
                    final long j2 = 0;
                    AppMethodBeat.i(37660);
                    f bah = ag.bah();
                    String str = "select updateTime from BizInfo where type = 1" + " and status = 1 ORDER BY updateTime DESC";
                    Log.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", str);
                    Cursor rawQuery = bah.rawQuery(str, new String[0]);
                    if (rawQuery != null) {
                        if (!rawQuery.moveToFirst()) {
                            rawQuery.close();
                        } else {
                            j2 = rawQuery.getLong(0);
                            rawQuery.close();
                        }
                    }
                    bg.aVF();
                    final long nullAsLong = Util.nullAsLong(com.tencent.mm.model.c.azQ().get(233473, (Object) null), 0);
                    Log.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", Long.valueOf(j2), Long.valueOf(nullAsLong));
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.ui.contact.BizContactEntranceView.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(37659);
                            BizContactEntranceView.this.PTZ.setVisibility((!BizContactEntranceView.this.PUc || j2 <= nullAsLong) ? 4 : 0);
                            AppMethodBeat.o(37659);
                        }
                    });
                    AppMethodBeat.o(37660);
                }
            });
        }
        Log.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", Integer.valueOf(gCe), Boolean.valueOf(this.PUb), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(37665);
    }

    public void setVisible(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(37666);
        Log.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", Boolean.valueOf(z), Boolean.valueOf(this.PUb));
        View view = this.qWL;
        if (!z || !this.PUb) {
            i2 = 8;
        }
        view.setVisibility(i2);
        AppMethodBeat.o(37666);
    }

    public final void Cn(boolean z) {
        AppMethodBeat.i(233995);
        if (this.PTY == null || this.PUa == null) {
            AppMethodBeat.o(233995);
        } else if (z) {
            int paddingLeft = this.PTY.getPaddingLeft();
            this.PTY.setBackground(at.aN(this.mContext, R.attr.sg));
            this.PTY.setPadding(paddingLeft, 0, 0, 0);
            this.PUa.setBackground(null);
            AppMethodBeat.o(233995);
        } else {
            this.PTY.setBackground(null);
            this.PUa.setBackground(at.aN(this.mContext, R.attr.sg));
            AppMethodBeat.o(233995);
        }
    }
}
