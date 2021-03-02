package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.plugin.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.record.b.w;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.plugin.record.ui.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;

public final class d implements h.b {
    Context context;
    int ppd;
    int ppe;

    public d(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final View createView(Context context2) {
        AppMethodBeat.i(28038);
        View inflate = View.inflate(context2, R.layout.blo, null);
        AppMethodBeat.o(28038);
        return inflate;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void a(View view, int i2, b bVar, Object obj) {
        AppMethodBeat.i(28039);
        TextView textView = (TextView) view.findViewById(R.id.gx4);
        textView.setText(bVar.dKT.desc);
        Bundle bundle = null;
        if (bVar.BHS == 1) {
            bundle = t.b.CHATTING_RECORD_FROM_SINGLE_CHAT.grZ();
        } else if (bVar.BHS == 2) {
            bundle = t.b.CHATTING_RECORD_FROM_GROUP_CHAT.grZ();
        } else if (bVar.BHS == 15) {
            bundle = t.b.CHATTING_RECORD_FROM_FAV.grZ();
        }
        if (bundle != null) {
            bundle.putString("msgUsername", bVar.BHK);
            bundle.putString("serverMsgID", bVar.BIN);
            Log.i("MicroMsg.TextViewWrapper", "span extraData = ".concat(String.valueOf(bundle)));
        }
        l.a(textView, 1, 4, bundle, l.Krf);
        TextView textView2 = (TextView) view.findViewById(R.id.gxa);
        View findViewById = view.findViewById(R.id.gxb);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.gx8);
        textView2.setVisibility(8);
        findViewById.setVisibility(8);
        linearLayout.setVisibility(8);
        i iVar = (i) obj;
        w Vx = iVar != null ? iVar.Vx(i2) : null;
        if (Vx != null && Vx.status == 2) {
            textView2.setText(Vx.BHr);
            textView2.setVisibility(0);
            ((TextView) view.findViewById(R.id.gx_)).setText(Util.isNullOrNil(Vx.brand) ? view.getResources().getString(R.string.ho8) : Vx.brand);
            linearLayout.setVisibility(0);
        } else if (Vx != null && Vx.status == 1) {
            findViewById.setVisibility(0);
        }
        a(textView, i2, bVar, iVar, Vx, true);
        if (iVar != null) {
            a(textView2, i2, bVar, iVar, Vx, false);
        }
        view.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.record.ui.b.d.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(28033);
                if (motionEvent.getAction() == 0) {
                    d.this.ppd = (int) motionEvent.getRawX();
                    d.this.ppe = (int) motionEvent.getRawY();
                }
                AppMethodBeat.o(28033);
                return false;
            }
        });
        AppMethodBeat.o(28039);
    }

    private void a(View view, final int i2, final b bVar, final i iVar, final w wVar, final boolean z) {
        AppMethodBeat.i(28040);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.record.ui.b.d.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(28037);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                final TextView textView = (TextView) view;
                SpannableString spannableString = new SpannableString(textView.getText());
                spannableString.setSpan(new BackgroundColorSpan(d.this.context.getResources().getColor(R.color.FG_3)), 0, textView.getText().length(), 33);
                textView.setText(spannableString);
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(d.this.context, textView);
                aVar.QSv = true;
                aVar.QSt = new o.e() {
                    /* class com.tencent.mm.plugin.record.ui.b.d.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.e
                    public final void a(m mVar, View view) {
                        AppMethodBeat.i(232054);
                        mVar.a(0, 0, d.this.context.getString(R.string.t_), R.raw.icons_filled_copy);
                        if (!c.Xn() || iVar == null) {
                            AppMethodBeat.o(232054);
                            return;
                        }
                        if (!z) {
                            mVar.a(0, 2, d.this.context.getString(R.string.b0p), R.raw.icons_filled_eyes_off);
                            if (wVar.eeA == 1) {
                                mVar.a(0, 3, d.this.context.getString(R.string.b0h), R.raw.icons_filled_refresh);
                            }
                        } else if (wVar.status != 2) {
                            mVar.a(0, 1, d.this.context.getString(R.string.b0r), R.raw.icons_filled_translate);
                            AppMethodBeat.o(232054);
                            return;
                        }
                        AppMethodBeat.o(232054);
                    }
                };
                aVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.record.ui.b.d.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        boolean z = true;
                        AppMethodBeat.i(28035);
                        switch (menuItem.getItemId()) {
                            case 0:
                                ClipboardHelper.setText(textView.getText());
                                com.tencent.mm.ui.base.h.cC(d.this.context, d.this.context.getString(R.string.ta));
                                AppMethodBeat.o(28035);
                                return;
                            case 1:
                                if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(textView.getContext())) {
                                    i iVar = iVar;
                                    int i3 = i2;
                                    if (z) {
                                        z = false;
                                    }
                                    iVar.aK(i3, z);
                                    AppMethodBeat.o(28035);
                                    return;
                                }
                                break;
                            case 2:
                                i iVar2 = iVar;
                                w Vx = iVar2.Vx(i2);
                                if (Vx.status == 2) {
                                    Vx.status = 0;
                                    iVar2.BIB.notifyDataSetChanged();
                                }
                                AppMethodBeat.o(28035);
                                return;
                            case 3:
                                i iVar3 = iVar;
                                int i4 = i2;
                                if (z) {
                                    z = false;
                                }
                                iVar3.aK(i4, z);
                                break;
                        }
                        AppMethodBeat.o(28035);
                    }
                };
                aVar.QwU = new PopupWindow.OnDismissListener() {
                    /* class com.tencent.mm.plugin.record.ui.b.d.AnonymousClass2.AnonymousClass3 */

                    public final void onDismiss() {
                        String str;
                        AppMethodBeat.i(28036);
                        TextView textView = textView;
                        if (z) {
                            str = bVar.dKT.desc;
                        } else {
                            str = wVar.BHr;
                        }
                        textView.setText(str);
                        l.p(textView, 1);
                        AppMethodBeat.o(28036);
                    }
                };
                if (view.getTag(R.id.iu_) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(R.id.iu_);
                    aVar.ez(iArr[0], iArr[1]);
                } else {
                    aVar.ez(d.this.ppd, d.this.ppe);
                }
                a.a(true, (Object) this, "com/tencent/mm/plugin/record/ui/viewWrappers/TextViewWrapper$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(28037);
                return true;
            }
        });
        AppMethodBeat.o(28040);
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void destroy() {
        this.context = null;
    }

    @Override // com.tencent.mm.plugin.record.ui.h.b
    public final void pause() {
    }
}
