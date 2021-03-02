package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.preference.a;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cl;
import com.tencent.mm.ui.base.h;

public class FMessageListView extends LinearLayout {
    private a.C2029a KoZ;
    private com.tencent.mm.pluginsdk.c.a Kpg;
    private MStorage.IOnStorageChange Kph;
    private MStorage.IOnStorageChange Kpi;
    private a Kpj;
    private a Kpk;
    private TextView Kpl;
    private Context context;
    private boolean eea;
    private final LinearLayout.LayoutParams xTw;

    public FMessageListView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public FMessageListView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet);
        AppMethodBeat.i(31829);
        this.Kpg = new com.tencent.mm.pluginsdk.c.a() {
            /* class com.tencent.mm.pluginsdk.ui.preference.FMessageListView.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.c.a
            public final void g(IEvent iEvent) {
                AppMethodBeat.i(31822);
                if ((iEvent instanceof lo) && !FMessageListView.this.eea) {
                    FMessageListView.a(FMessageListView.this, ((lo) iEvent).dQS.event);
                }
                AppMethodBeat.o(31822);
            }
        };
        this.Kph = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.pluginsdk.ui.preference.FMessageListView.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(31823);
                if (!FMessageListView.this.eea) {
                    FMessageListView.b(FMessageListView.this, str);
                }
                AppMethodBeat.o(31823);
            }
        };
        this.Kpi = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.pluginsdk.ui.preference.FMessageListView.AnonymousClass3 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(31824);
                if (!FMessageListView.this.eea) {
                    FMessageListView.c(FMessageListView.this, str);
                }
                AppMethodBeat.o(31824);
            }
        };
        this.xTw = new LinearLayout.LayoutParams(-1, -2);
        this.eea = false;
        this.context = context2;
        AppMethodBeat.o(31829);
    }

    public void setFMessageArgs(a.C2029a aVar) {
        AppMethodBeat.i(31830);
        this.KoZ = aVar;
        a.setFMessageArgs(aVar);
        AppMethodBeat.o(31830);
    }

    public void setHide(boolean z) {
        this.eea = z;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(31831);
        super.onDetachedFromWindow();
        detach();
        AppMethodBeat.o(31831);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(31832);
        super.onAttachedToWindow();
        d.bgM().add(this.Kph);
        com.tencent.mm.pluginsdk.c.a.a(lo.class.getName(), this.Kpg);
        d.bgO().add(this.Kph);
        d.bgP().add(this.Kpi);
        AppMethodBeat.o(31832);
    }

    public final void detach() {
        AppMethodBeat.i(31833);
        d.bgM().remove(this.Kph);
        d.bgO().remove(this.Kph);
        com.tencent.mm.pluginsdk.c.a.b(lo.class.getName(), this.Kpg);
        d.bgP().remove(this.Kpi);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof a) {
                ((a) childAt).detach();
            }
        }
        this.Kpj = null;
        this.Kpk = null;
        AppMethodBeat.o(31833);
    }

    public final void a(final b bVar) {
        String str;
        boolean z;
        String str2;
        AppMethodBeat.i(31834);
        if (bVar == null) {
            Log.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
            AppMethodBeat.o(31834);
        } else if (bVar.id <= 0) {
            Log.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + bVar.id);
            AppMethodBeat.o(31834);
        } else {
            int childCount = getChildCount();
            for (int i2 = 1; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if ((childAt instanceof a) && childAt.getTag() != null && childAt.getTag().equals(Long.valueOf(bVar.id))) {
                    Log.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + bVar.id);
                    AppMethodBeat.o(31834);
                    return;
                }
            }
            if (bVar.Kpp != null) {
                if (this.Kpl == null) {
                    this.Kpl = (TextView) findViewById(R.id.bar);
                }
                this.Kpl.setText(bVar.Kpp);
                this.Kpl.setVisibility(0);
            }
            Log.d("MicroMsg.FMessageListView", "addItem, current child count = ".concat(String.valueOf(childCount)));
            if (childCount == 6) {
                Log.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
                removeViewAt(1);
            }
            if (childCount == 1) {
                Log.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
                this.Kpj = new a(this.context);
                addView(this.Kpj);
                this.Kpk = new a(this.context);
                this.Kpk.setContentText("");
                this.Kpk.setBtnVisibility(0);
                addView(this.Kpk, this.xTw);
                bg.aVF();
                as Kn = c.aSN().Kn(bVar.username);
                if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    Log.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + bVar.username);
                    this.Kpj.setVisibility(0);
                    this.Kpk.setVisibility(0);
                } else {
                    Log.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + bVar.username);
                    this.Kpj.setVisibility(8);
                    this.Kpk.setVisibility(8);
                }
            }
            if (bVar.ehd) {
                z = false;
                str2 = this.context.getString(R.string.ddt, bVar.iAq);
            } else {
                if (bVar.nickname == null || bVar.nickname.length() <= 0) {
                    str = bVar.username;
                    bg.aVF();
                    as Kn2 = c.aSN().Kn(bVar.username);
                    if (Kn2 != null && ((int) Kn2.gMZ) > 0) {
                        str = Kn2.arJ();
                    }
                } else {
                    str = bVar.nickname;
                }
                String str3 = str + ": " + bVar.iAq;
                z = true;
                str2 = str3;
            }
            a aVar = new a(this.context);
            aVar.setTag(Long.valueOf(bVar.id));
            aVar.setContentText(str2);
            aVar.setBtnVisibility(8);
            if (z) {
                aVar.setOnLongClickListener(new View.OnLongClickListener() {
                    /* class com.tencent.mm.pluginsdk.ui.preference.FMessageListView.AnonymousClass4 */

                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(31826);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/preference/FMessageListView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                        Log.d("MicroMsg.FMessageListView", "jacks long click digest");
                        h.a(FMessageListView.this.getContext(), (String) null, new String[]{FMessageListView.this.getContext().getString(R.string.ay2)}, new h.d() {
                            /* class com.tencent.mm.pluginsdk.ui.preference.FMessageListView.AnonymousClass4.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.h.d
                            public final void oj(int i2) {
                                AppMethodBeat.i(31825);
                                switch (i2) {
                                    case 0:
                                        ClipboardHelper.setText(bVar.iAq);
                                        break;
                                }
                                AppMethodBeat.o(31825);
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/pluginsdk/ui/preference/FMessageListView$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(31826);
                        return true;
                    }
                });
            }
            addView(aVar, getChildCount() - 2, this.xTw);
            AppMethodBeat.o(31834);
        }
    }

    public void setReplyBtnVisible(boolean z) {
        int i2 = 0;
        AppMethodBeat.i(31835);
        int childCount = getChildCount();
        Log.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + z + ", current child count = " + childCount);
        if (childCount <= 2) {
            Log.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = ".concat(String.valueOf(childCount)));
            AppMethodBeat.o(31835);
            return;
        }
        if (this.Kpj != null) {
            this.Kpj.setVisibility(z ? 0 : 8);
        }
        if (this.Kpk != null) {
            a aVar = this.Kpk;
            if (!z) {
                i2 = 8;
            }
            aVar.setVisibility(i2);
        }
        AppMethodBeat.o(31835);
    }

    /* access modifiers changed from: package-private */
    public static class a extends View {
        public a(Context context) {
            super(context);
            AppMethodBeat.i(31827);
            setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            AppMethodBeat.o(31827);
        }
    }

    static /* synthetic */ void a(FMessageListView fMessageListView, String str) {
        long j2;
        AppMethodBeat.i(31836);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.FMessageListView", "updateLbs, id is null");
            AppMethodBeat.o(31836);
            return;
        }
        try {
            j2 = Util.getLong(str, 0);
        } catch (Exception e2) {
            Log.e("MicroMsg.FMessageListView", "updateLbs, id = " + str + ", ex = " + e2.getMessage());
            j2 = 0;
        }
        if (j2 == 0) {
            Log.e("MicroMsg.FMessageListView", "updateLbs fail, sysRowId is invalid");
            AppMethodBeat.o(31836);
            return;
        }
        Log.d("MicroMsg.FMessageListView", "updateLbs succ, sysRowId = ".concat(String.valueOf(j2)));
        bx bxVar = new bx();
        if (!d.bgO().get(j2, bxVar)) {
            Log.e("MicroMsg.FMessageListView", "updateLbs, get fail, id = ".concat(String.valueOf(j2)));
            AppMethodBeat.o(31836);
        } else if (fMessageListView.KoZ == null || !fMessageListView.KoZ.talker.equals(bxVar.field_sayhiuser)) {
            Log.d("MicroMsg.FMessageListView", "updateLbs, other talker, no need to process");
            AppMethodBeat.o(31836);
        } else {
            if (fMessageListView.KoZ.wZz != null && fMessageListView.KoZ.wZz.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, bxVar));
            AppMethodBeat.o(31836);
        }
    }

    static /* synthetic */ void b(FMessageListView fMessageListView, String str) {
        long j2;
        AppMethodBeat.i(31837);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.FMessageListView", "updateFMsg, id is null");
            AppMethodBeat.o(31837);
            return;
        }
        try {
            j2 = Util.getLong(str, 0);
        } catch (Exception e2) {
            Log.e("MicroMsg.FMessageListView", "updateFMsg, id = " + str + ", ex = " + e2.getMessage());
            j2 = 0;
        }
        if (j2 == 0) {
            Log.e("MicroMsg.FMessageListView", "updateFMsg fail, sysRowId is invalid");
            AppMethodBeat.o(31837);
            return;
        }
        Log.d("MicroMsg.FMessageListView", "updateFMsg succ, sysRowId = ".concat(String.valueOf(j2)));
        bn bnVar = new bn();
        if (!d.bgM().get(j2, bnVar)) {
            Log.e("MicroMsg.FMessageListView", "updateFMsg, get fail, id = ".concat(String.valueOf(j2)));
            AppMethodBeat.o(31837);
        } else if (fMessageListView.KoZ == null || !fMessageListView.KoZ.talker.equals(bnVar.field_talker)) {
            Log.d("MicroMsg.FMessageListView", "updateFMsg, other talker, no need to process");
            AppMethodBeat.o(31837);
        } else {
            if (fMessageListView.KoZ.wZz != null && fMessageListView.KoZ.wZz.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.c(fMessageListView.context, bnVar));
            AppMethodBeat.o(31837);
        }
    }

    static /* synthetic */ void c(FMessageListView fMessageListView, String str) {
        long j2;
        AppMethodBeat.i(31838);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.FMessageListView", "updateShake, id is null");
            AppMethodBeat.o(31838);
            return;
        }
        try {
            j2 = Util.getLong(str, 0);
        } catch (Exception e2) {
            Log.e("MicroMsg.FMessageListView", "updateShake, id = " + str + ", ex = " + e2.getMessage());
            j2 = 0;
        }
        if (j2 == 0) {
            Log.e("MicroMsg.FMessageListView", "updateShake fail, sysRowId is invalid");
            AppMethodBeat.o(31838);
            return;
        }
        Log.d("MicroMsg.FMessageListView", "updateShake succ, sysRowId = ".concat(String.valueOf(j2)));
        cl clVar = new cl();
        if (!d.bgP().get(j2, clVar)) {
            Log.e("MicroMsg.FMessageListView", "updateShake, get fail, id = ".concat(String.valueOf(j2)));
            AppMethodBeat.o(31838);
        } else if (fMessageListView.KoZ == null || !fMessageListView.KoZ.talker.equals(clVar.field_sayhiuser)) {
            Log.d("MicroMsg.FMessageListView", "updateShake, other talker, no need to process");
            AppMethodBeat.o(31838);
        } else {
            if (fMessageListView.KoZ.wZz != null && fMessageListView.KoZ.wZz.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, clVar));
            AppMethodBeat.o(31838);
        }
    }
}
