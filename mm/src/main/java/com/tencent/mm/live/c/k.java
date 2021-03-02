package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\u0018\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\"H\u0016J\u001a\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveBeforePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "hostString", "liveEditTopGroup", "liveRoomIdEdit", "Landroid/widget/EditText;", "liveTitleEdit", "liveTitleEditCancel", "Landroid/widget/TextView;", "liveTitleEditGroup", "liveTitleEditOk", "Landroid/widget/Button;", "liveTitleEditTextNumHint", "liveTitleTv", "mTopicName", "providerTip", "rootLayout", "startLiveBtn", "switchBtn", "titleEditBackground", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "topGroup", "Landroid/view/ViewGroup;", "checkLiveName", "", "liveName", "createLive", "", "enableTestRoomId", "keyboardChange", "show", "height", "", "onBackPress", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class k extends a {
    private final String TAG = "MicroMsg.LiveBeforePlugin";
    private final RelativeLayout hOX;
    final Button hOY;
    final TextView hOZ;
    final b hOp;
    final EditText hPa;
    private final WeImageView hPb;
    private final WeImageView hPc;
    private final ViewGroup hPd;
    final EditText hPe;
    final TextView hPf;
    private final TextView hPg;
    final Button hPh;
    final RelativeLayout hPi;
    private final RelativeLayout hPj;
    private final TextView hPk;
    String hPl;
    String hPm;
    private Drawable hPn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(final RelativeLayout relativeLayout, b bVar) {
        super(relativeLayout, bVar);
        String str;
        String string;
        p.h(relativeLayout, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(207947);
        this.hOp = bVar;
        View findViewById = relativeLayout.findViewById(R.id.eg4);
        p.g(findViewById, "root.findViewById(R.id.live_before_ui_root)");
        this.hOX = (RelativeLayout) findViewById;
        View findViewById2 = relativeLayout.findViewById(R.id.efv);
        p.g(findViewById2, "root.findViewById(R.id.l…before_content_start_btn)");
        this.hOY = (Button) findViewById2;
        View findViewById3 = relativeLayout.findViewById(R.id.efz);
        p.g(findViewById3, "root.findViewById(R.id.live_before_provider_tip)");
        this.hOZ = (TextView) findViewById3;
        View findViewById4 = relativeLayout.findViewById(R.id.efw);
        p.g(findViewById4, "root.findViewById(R.id.l…efore_content_title_edit)");
        this.hPa = (EditText) findViewById4;
        View findViewById5 = relativeLayout.findViewById(R.id.eg1);
        p.g(findViewById5, "root.findViewById(R.id.live_before_top_close)");
        this.hPb = (WeImageView) findViewById5;
        View findViewById6 = relativeLayout.findViewById(R.id.eg3);
        p.g(findViewById6, "root.findViewById(R.id.live_before_top_switch)");
        this.hPc = (WeImageView) findViewById6;
        View findViewById7 = relativeLayout.findViewById(R.id.eg2);
        p.g(findViewById7, "root.findViewById(R.id.live_before_top_group)");
        this.hPd = (ViewGroup) findViewById7;
        View findViewById8 = relativeLayout.findViewById(R.id.efu);
        p.g(findViewById8, "root.findViewById(R.id.l…fore_content_roomid_edit)");
        this.hPe = (EditText) findViewById8;
        View findViewById9 = relativeLayout.findViewById(R.id.iq9);
        p.g(findViewById9, "root.findViewById(R.id.title_edit_text_num_hint)");
        this.hPf = (TextView) findViewById9;
        View findViewById10 = relativeLayout.findViewById(R.id.emf);
        p.g(findViewById10, "root.findViewById(R.id.live_title_edit_cancel)");
        this.hPg = (TextView) findViewById10;
        View findViewById11 = relativeLayout.findViewById(R.id.emg);
        p.g(findViewById11, "root.findViewById(R.id.live_title_edit_ok)");
        this.hPh = (Button) findViewById11;
        View findViewById12 = relativeLayout.findViewById(R.id.efx);
        p.g(findViewById12, "root.findViewById(R.id.l…content_title_edit_group)");
        this.hPi = (RelativeLayout) findViewById12;
        View findViewById13 = relativeLayout.findViewById(R.id.efy);
        p.g(findViewById13, "root.findViewById(R.id.live_before_edit_top_group)");
        this.hPj = (RelativeLayout) findViewById13;
        View findViewById14 = relativeLayout.findViewById(R.id.eg0);
        p.g(findViewById14, "root.findViewById(R.id.live_before_title)");
        this.hPk = (TextView) findViewById14;
        this.hPl = "";
        this.hPm = "";
        this.hPn = this.hPa.getBackground();
        this.hOX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass1 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207931);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!Util.isNullOrNil(this.hPo.hPa.getText().toString())) {
                    Context context = relativeLayout.getContext();
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(207931);
                        throw tVar;
                    }
                    ((MMActivity) context).hideVKB();
                    this.hPo.hPa.clearFocus();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207931);
            }
        });
        as aUL = z.aUL();
        this.hPm = (aUL == null || (str = aUL.arJ()) == null) ? "" : str;
        this.hPa.setHint(com.tencent.mm.pluginsdk.ui.span.l.b(relativeLayout.getContext(), relativeLayout.getContext().getString(R.string.efc, this.hPm), this.hPa.getTextSize()));
        this.hPa.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass3 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
                if (r6.getAction() == 66) goto L_0x0017;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onEditorAction(android.widget.TextView r4, int r5, android.view.KeyEvent r6) {
                /*
                    r3 = this;
                    r2 = 207933(0x32c3d, float:2.91376E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    r0 = 6
                    if (r0 == r5) goto L_0x0017
                    java.lang.String r0 = "keyEvent"
                    kotlin.g.b.p.g(r6, r0)
                    int r0 = r6.getAction()
                    r1 = 66
                    if (r0 != r1) goto L_0x0037
                L_0x0017:
                    android.widget.RelativeLayout r0 = r9
                    android.content.Context r0 = r0.getContext()
                    if (r0 != 0) goto L_0x002b
                    kotlin.t r0 = new kotlin.t
                    java.lang.String r1 = "null cannot be cast to non-null type com.tencent.mm.ui.MMActivity"
                    r0.<init>(r1)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    throw r0
                L_0x002b:
                    com.tencent.mm.ui.MMActivity r0 = (com.tencent.mm.ui.MMActivity) r0
                    r0.hideVKB()
                    com.tencent.mm.live.c.k r0 = r3.hPo
                    android.widget.EditText r0 = r0.hPa
                    r0.clearFocus()
                L_0x0037:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.c.k.AnonymousClass3.onEditorAction(android.widget.TextView, int, android.view.KeyEvent):boolean");
            }
        });
        this.hPb.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass4 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207934);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.hPo.hOp, b.c.hLD);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207934);
            }
        });
        this.hPc.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass5 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207935);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hPo.hOp.statusChange(b.c.hLE, new Bundle());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207935);
            }
        });
        this.hOY.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass6 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            public final void onClick(View view) {
                String obj;
                AppMethodBeat.i(207936);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                k kVar = this.hPo;
                Editable text = kVar.hPa.getText();
                if (text == null || n.aL(text)) {
                    obj = "";
                } else {
                    obj = kVar.hPa.getText().toString();
                }
                int parseInt = k.aHv() ? Integer.parseInt(kVar.hPe.getText().toString()) : -1;
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_LIVE_TEST_ROOM_ID", parseInt);
                bundle.putString("PARAM_START_LIVE_TITLE", obj);
                x xVar = x.hJf;
                x.aGr().MnO = com.tencent.mm.pluginsdk.ui.span.l.b(kVar.hwr.getContext(), kVar.hwr.getContext().getString(R.string.efc, kVar.hPm), kVar.hPa.getTextSize()).toString();
                kVar.hOp.statusChange(b.c.hMx, bundle);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207936);
            }
        });
        this.hPe.setVisibility(aHv() ? 0 : 8);
        EditText editText = this.hPe;
        f.a aVar = f.hzy;
        editText.setText(String.valueOf(f.hzw.roomId));
        c.f(this.hPa).lv(0, 28).a((c.a) null);
        this.hPa.addTextChangedListener(new TextWatcher(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass7 */
            final /* synthetic */ k hPo;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.hPo = r1;
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(207937);
                if (editable != null) {
                    this.hPo.hPh.setEnabled(!Util.isNullOrNil(editable));
                    this.hPo.hPf.setText(String.valueOf(28 - com.tencent.mm.ui.tools.f.a(editable.toString(), f.a.MODE_CHINESE_AS_2)));
                    this.hPo.hPa.setSelection(this.hPo.hPa.getText().length());
                    x xVar = x.hJf;
                    x.aGr().LpF = this.hPo.hPa.getText().toString();
                    x xVar2 = x.hJf;
                    x.eH(true);
                    com.tencent.mm.live.d.a.aHW();
                    AppMethodBeat.o(207937);
                    return;
                }
                AppMethodBeat.o(207937);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.hPa.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass8 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207938);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hPo.hPl = this.hPo.hPa.getText().toString();
                if (Util.isNullOrNil(this.hPo.hPl)) {
                    this.hPo.hPh.setEnabled(false);
                } else {
                    this.hPo.hPh.setEnabled(true);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207938);
            }
        });
        this.hPg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass9 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207939);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (n.aL(this.hPo.hPl)) {
                    this.hPo.hPa.setHint(com.tencent.mm.pluginsdk.ui.span.l.b(relativeLayout.getContext(), relativeLayout.getContext().getString(R.string.efc, this.hPo.hPm), this.hPo.hPa.getTextSize()).toString());
                    this.hPo.hPa.setText((CharSequence) null);
                    x xVar = x.hJf;
                    x.aGr().LpF = com.tencent.mm.pluginsdk.ui.span.l.b(relativeLayout.getContext(), relativeLayout.getContext().getString(R.string.efc, this.hPo.hPm), this.hPo.hPa.getTextSize()).toString();
                } else {
                    this.hPo.hPa.setText(this.hPo.hPl);
                    x xVar2 = x.hJf;
                    x.aGr().LpF = this.hPo.hPa.getText().toString();
                }
                x xVar3 = x.hJf;
                x.eH(false);
                Context context = relativeLayout.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(207939);
                    throw tVar;
                }
                ((MMActivity) context).hideVKB();
                this.hPo.hPa.clearFocus();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207939);
            }
        });
        this.hPh.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass10 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(207940);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Context context = relativeLayout.getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(207940);
                    throw tVar;
                }
                ((MMActivity) context).hideVKB();
                this.hPo.hPa.clearFocus();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveBeforePlugin$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(207940);
            }
        });
        this.hPi.post(new Runnable(this) {
            /* class com.tencent.mm.live.c.k.AnonymousClass2 */
            final /* synthetic */ k hPo;

            {
                this.hPo = r1;
            }

            public final void run() {
                AppMethodBeat.i(207932);
                if (this.hPo.isLandscape()) {
                    ViewGroup.LayoutParams layoutParams = this.hPo.hPi.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(207932);
                        throw tVar;
                    }
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.tencent.mm.cb.a.aG(relativeLayout.getContext(), R.dimen.bu) + com.tencent.mm.cb.a.aG(relativeLayout.getContext(), R.dimen.a_t) + this.hPo.hOY.getHeight();
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.hPo.hOZ.getLayoutParams();
                    if (layoutParams2 != null) {
                        if (layoutParams2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            AppMethodBeat.o(207932);
                            throw tVar2;
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin += au.aD(relativeLayout.getContext());
                        this.hPo.hOZ.requestLayout();
                    }
                    ViewGroup.LayoutParams layoutParams3 = this.hPo.hOY.getLayoutParams();
                    if (layoutParams3 != null) {
                        if (layoutParams3 == null) {
                            t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            AppMethodBeat.o(207932);
                            throw tVar3;
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin += au.aD(relativeLayout.getContext());
                        this.hPo.hOY.requestLayout();
                    }
                    ViewGroup.LayoutParams layoutParams4 = this.hPo.hPi.getLayoutParams();
                    if (layoutParams4 == null) {
                        t tVar4 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        AppMethodBeat.o(207932);
                        throw tVar4;
                    }
                    ((RelativeLayout.LayoutParams) layoutParams4).bottomMargin = com.tencent.mm.cb.a.aG(relativeLayout.getContext(), R.dimen.bu) + com.tencent.mm.cb.a.aG(relativeLayout.getContext(), R.dimen.bx) + this.hPo.hOY.getHeight() + au.aD(relativeLayout.getContext());
                }
                this.hPo.hPi.requestLayout();
                AppMethodBeat.o(207932);
            }
        });
        if (!(!isLandscape() || this.hPd.getLayoutParams() == null || this.hPj.getLayoutParams() == null)) {
            ViewGroup.LayoutParams layoutParams = this.hPd.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(207947);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(au.aD(relativeLayout.getContext()));
            ViewGroup.LayoutParams layoutParams2 = this.hPj.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(207947);
                throw tVar2;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(au.aD(relativeLayout.getContext()));
            this.hPd.requestLayout();
            this.hPj.requestLayout();
        }
        try {
            Context context = relativeLayout.getContext();
            p.g(context, "root.context");
            String string2 = context.getResources().getString(R.string.ehy);
            p.g(string2, "root.context.resources.g…string.live_provider_tip)");
            i iVar = new i(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_live_start_tip, "{\"simple_chinese\":\"" + string2 + "\",\"xg_traditional_chinese\":\"" + string2 + "\",\"tw_traditional_chinese\":\"" + string2 + "\",\"english\":\"" + string2 + "\"}"));
            String applicationLanguage = LocaleUtil.getApplicationLanguage();
            if (p.j(LocaleUtil.CHINA, applicationLanguage)) {
                string = iVar.getString("simple_chinese");
            } else if (p.j(LocaleUtil.TAIWAN, applicationLanguage)) {
                string = iVar.getString("xg_traditional_chinese");
            } else if (p.j(LocaleUtil.HONGKONG, applicationLanguage)) {
                string = iVar.getString("tw_traditional_chinese");
            } else {
                string = iVar.getString("english");
            }
            if (!Util.isNullOrNil(string)) {
                this.hOZ.setText(string);
                AppMethodBeat.o(207947);
                return;
            }
        } catch (Exception e2) {
            Log.w(this.TAG, "Exception: " + e2.getMessage());
        }
        AppMethodBeat.o(207947);
    }

    static boolean aHv() {
        AppMethodBeat.i(207943);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getInt(ar.a.USERINFO_LIVE_ANCHOR_CUSTOM_ROOM_ID_INT_SYNC, 0) == 1) {
            AppMethodBeat.o(207943);
            return true;
        }
        AppMethodBeat.o(207943);
        return false;
    }

    @Override // com.tencent.mm.live.c.a
    public final void keyboardChange(boolean z, int i2) {
        int aD;
        String str;
        AppMethodBeat.i(207944);
        if (z) {
            this.hPk.setVisibility(8);
            this.hPd.setVisibility(8);
            this.hOY.setVisibility(8);
            if (isLandscape()) {
                aD = (au.az(this.hwr.getContext()).y - i2) - com.tencent.mm.cb.a.aG(this.hwr.getContext(), R.dimen.cb);
            } else {
                aD = ((au.az(this.hwr.getContext()).y - i2) - au.aD(this.hwr.getContext())) - com.tencent.mm.cb.a.aG(this.hwr.getContext(), R.dimen.cb);
            }
            int[] iArr = new int[2];
            this.hPi.getLocationOnScreen(iArr);
            this.hPi.animate().translationY((float) (aD - (iArr[1] + this.hPi.getHeight()))).start();
            EditText editText = this.hPa;
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            editText.setBackground(context.getResources().getDrawable(R.color.ac_));
            this.hPa.setPadding(0, 0, 0, 0);
            this.hPa.setHint(" ");
            this.hPa.setCursorVisible(true);
            this.hPf.setVisibility(0);
            Editable text = this.hPa.getText();
            if (text == null || (str = text.toString()) == null) {
                str = "";
            }
            this.hPf.setText(String.valueOf(28 - com.tencent.mm.ui.tools.f.a(str, f.a.MODE_CHINESE_AS_2)));
            this.hPg.setVisibility(0);
            this.hPh.setVisibility(0);
            AppMethodBeat.o(207944);
            return;
        }
        this.hPk.setVisibility(0);
        this.hPd.setVisibility(0);
        this.hOY.setVisibility(0);
        this.hPi.animate().translationY(0.0f).start();
        this.hPa.setBackground(this.hPn);
        com.tencent.mm.cb.a.aG(this.hwr.getContext(), R.dimen.ci);
        this.hPa.setPadding(0, 0, 0, com.tencent.mm.cb.a.aG(this.hwr.getContext(), R.dimen.ct));
        this.hPa.setHint(com.tencent.mm.pluginsdk.ui.span.l.b(this.hwr.getContext(), this.hwr.getContext().getString(R.string.efc, this.hPm), this.hPa.getTextSize()));
        this.hPa.setCursorVisible(false);
        this.hPf.setVisibility(8);
        this.hPg.setVisibility(8);
        this.hPh.setVisibility(8);
        AppMethodBeat.o(207944);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        int i2;
        boolean z;
        String obj;
        AppMethodBeat.i(207945);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (l.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(8);
                AppMethodBeat.o(207945);
                return;
            case 4:
                Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("PARAM_FACE_VERIFY_ERROR", -1)) : null;
                if (!(valueOf == null || valueOf.intValue() == -1)) {
                    new f.a(this.hwr.getContext()).hbu().bow(this.hwr.getContext().getString(valueOf.intValue())).boA(this.hwr.getContext().getString(R.string.w0)).b(a.hPp).show();
                }
                x xVar = x.hJf;
                civ aGr = x.aGr();
                Editable text = this.hPa.getText();
                if (text == null || n.aL(text)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    obj = com.tencent.mm.pluginsdk.ui.span.l.b(this.hwr.getContext(), this.hwr.getContext().getString(R.string.efc, this.hPm), this.hPa.getTextSize()).toString();
                } else {
                    obj = this.hPa.getText().toString();
                }
                aGr.LpF = obj;
                x xVar2 = x.hJf;
                x.eK(false);
                rg(0);
                AppMethodBeat.o(207945);
                return;
            case 5:
                x xVar3 = x.hJf;
                if (x.aGL()) {
                    i2 = 3;
                } else {
                    i2 = 2;
                }
                x xVar4 = x.hJf;
                String aGm = x.aGm();
                x xVar5 = x.hJf;
                boolean aGI = x.aGI();
                x xVar6 = x.hJf;
                boolean aGJ = x.aGJ();
                x xVar7 = x.hJf;
                String str = x.aGr().LpF;
                x xVar8 = x.hJf;
                boolean aGH = x.aGH();
                Resources resources = this.hwr.getResources();
                p.g(resources, "root.resources");
                com.tencent.mm.live.d.e.a(aGm, aGI, aGJ, str, aGH, resources.getConfiguration().orientation, i2);
                com.tencent.mm.live.d.a.aHV();
                x xVar9 = x.hJf;
                x.eK(false);
                AppMethodBeat.o(207945);
                return;
            case 6:
                com.tencent.mm.live.d.a.aHU();
                break;
        }
        AppMethodBeat.o(207945);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class a implements f.c {
        public static final a hPp = new a();

        static {
            AppMethodBeat.i(207942);
            AppMethodBeat.o(207942);
        }

        a() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(207946);
        if (this.hwr.getVisibility() == 0) {
            b.C0376b.a(this.hOp, b.c.hLD);
            AppMethodBeat.o(207946);
            return true;
        }
        AppMethodBeat.o(207946);
        return false;
    }
}
