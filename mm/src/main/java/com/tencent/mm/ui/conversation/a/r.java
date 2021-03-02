package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class r extends b {
    private boolean QiI = false;
    boolean QiW = false;
    private TextView jVO;
    private ImageView nnL;
    private IListener qnf;
    private View sc = null;

    public r(Context context) {
        super(context);
        AppMethodBeat.i(38859);
        if (!this.QiI && this.view != null) {
            this.sc = this.view.findViewById(R.id.ira);
            this.jVO = (TextView) this.view.findViewById(R.id.ir9);
            this.nnL = (ImageView) this.view.findViewById(R.id.ir_);
            this.QiI = true;
            this.qnf = new IListener<la>() {
                /* class com.tencent.mm.ui.conversation.a.r.AnonymousClass1 */

                {
                    AppMethodBeat.i(161579);
                    this.__eventId = la.class.getName().hashCode();
                    AppMethodBeat.o(161579);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(la laVar) {
                    AppMethodBeat.i(38857);
                    if (laVar.dQf.dOz) {
                        r.this.QiW = false;
                        r.this.bYa();
                    } else {
                        Log.i("MicroMsg.TryNewInitBanner", "summerinit onSceneEnd -1 show tryNewInitBanner[%s]", r.this);
                        r.this.QiW = true;
                        r.this.bYa();
                    }
                    AppMethodBeat.o(38857);
                    return false;
                }
            };
            EventCenter.instance.addListener(this.qnf);
        }
        AppMethodBeat.o(38859);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.c4o;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        boolean z;
        AppMethodBeat.i(38860);
        if (!this.QiW) {
            Log.i("MicroMsg.TryNewInitBanner", "summerinit update but initFailed[%b] just ret update false", Boolean.valueOf(this.QiW));
            this.sc.setVisibility(8);
            AppMethodBeat.o(38860);
            return false;
        } else if (!l.bdN()) {
            Log.i("MicroMsg.TryNewInitBanner", "summerinit update but not need init just update false");
            this.QiW = false;
            this.sc.setVisibility(8);
            AppMethodBeat.o(38860);
            return false;
        } else {
            this.jVO.setText(R.string.acn);
            this.nnL.setVisibility(0);
            this.sc.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.a.r.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38858);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
                    r.this.setVisibility(8);
                    EventCenter.instance.publish(new yf());
                    Log.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
                    a.a(this, "com/tencent/mm/ui/conversation/banner/TryNewInitBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38858);
                }
            });
            this.sc.setVisibility(0);
            Object[] objArr = new Object[1];
            if (this.sc.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.i("MicroMsg.TryNewInitBanner", "summerinit update set visible [%b]", objArr);
            AppMethodBeat.o(38860);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void setVisibility(int i2) {
        AppMethodBeat.i(38861);
        if (this.sc != null) {
            this.sc.setVisibility(i2);
        }
        AppMethodBeat.o(38861);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(38862);
        EventCenter.instance.removeListener(this.qnf);
        AppMethodBeat.o(38862);
    }
}
