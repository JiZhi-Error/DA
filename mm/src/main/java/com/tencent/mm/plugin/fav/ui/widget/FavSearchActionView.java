package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.ui.widget.FavTagPanel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView extends LinearLayout {
    private ImageButton hey;
    public FavTagPanel tfS;
    public List<Integer> thn = new LinkedList();
    public List<String> tmI = new LinkedList();
    public List<String> tmJ = new LinkedList();
    public a tmK;

    public interface a {
        void a(String str, List<Integer> list, List<String> list2, List<String> list3);

        void a(List<Integer> list, List<String> list2, List<String> list3, boolean z);

        void bnz();
    }

    static /* synthetic */ void a(FavSearchActionView favSearchActionView, String str) {
        AppMethodBeat.i(107542);
        favSearchActionView.asw(str);
        AppMethodBeat.o(107542);
    }

    static /* synthetic */ void c(FavSearchActionView favSearchActionView) {
        AppMethodBeat.i(107543);
        favSearchActionView.cWS();
        AppMethodBeat.o(107543);
    }

    public FavSearchActionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107534);
        AppMethodBeat.o(107534);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(107535);
        super.onFinishInflate();
        this.hey = (ImageButton) findViewById(R.id.hdi);
        this.tfS = (FavTagPanel) findViewById(R.id.cdh);
        if (this.tfS != null) {
            this.tfS.setEditTextColor(getResources().getColor(R.color.fr));
            this.tfS.setTagTipsDrawable(0);
            this.tfS.setTagHighlineBG(0);
            this.tfS.setTagSelectedBG(0);
            this.tfS.setTagSelectedTextColorRes(R.color.afp);
            this.tfS.setTagNormalBG(0);
            this.tfS.setTagNormalTextColorRes(R.color.afz);
            this.tfS.setEditHint(getResources().getString(R.string.yn));
            this.tfS.Bz(true);
            this.tfS.OTf = false;
            this.tfS.OTg = true;
            this.tfS.setCallBack((FavTagPanel.a) new FavTagPanel.a() {
                /* class com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anb(String str) {
                    AppMethodBeat.i(107527);
                    Log.d("MicroMsg.FavSearchActionView", "unselected tag %s", str);
                    FavSearchActionView.this.tfS.removeTag(str);
                    and(str);
                    AppMethodBeat.o(107527);
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anc(String str) {
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void and(String str) {
                    AppMethodBeat.i(107528);
                    FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.this.tfS.getEditText());
                    FavSearchActionView.this.tmI.remove(str);
                    FavSearchActionView.c(FavSearchActionView.this);
                    if (FavSearchActionView.this.tmK == null) {
                        AppMethodBeat.o(107528);
                        return;
                    }
                    FavSearchActionView.this.tmK.a(FavSearchActionView.this.thn, FavSearchActionView.this.tmJ, FavSearchActionView.this.tmI, true);
                    AppMethodBeat.o(107528);
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void ane(String str) {
                    AppMethodBeat.i(107529);
                    FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.this.tfS.getEditText());
                    FavSearchActionView.c(FavSearchActionView.this);
                    if (FavSearchActionView.this.tmK == null) {
                        AppMethodBeat.o(107529);
                        return;
                    }
                    FavSearchActionView.this.tmK.a(str, FavSearchActionView.this.thn, FavSearchActionView.this.tmJ, FavSearchActionView.this.tmI);
                    AppMethodBeat.o(107529);
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void anf(String str) {
                    AppMethodBeat.i(107530);
                    FavSearchActionView.a(FavSearchActionView.this, str);
                    FavSearchActionView.this.tmK.a(FavSearchActionView.this.thn, FavSearchActionView.this.tmJ, FavSearchActionView.this.tmI, false);
                    AppMethodBeat.o(107530);
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void cIk() {
                    AppMethodBeat.i(107531);
                    if (FavSearchActionView.this.tmK == null) {
                        AppMethodBeat.o(107531);
                        return;
                    }
                    FavSearchActionView.this.tmK.bnz();
                    AppMethodBeat.o(107531);
                }

                @Override // com.tencent.mm.plugin.fav.ui.widget.FavTagPanel.a
                public final void asx(String str) {
                    AppMethodBeat.i(107532);
                    Log.d("MicroMsg.FavSearchActionView", "unselected type %s", str);
                    FavTagPanel unused = FavSearchActionView.this.tfS;
                    FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.this.tfS.getEditText());
                    FavSearchActionView.this.thn.remove(FavSearchActionView.az(FavSearchActionView.this.getContext(), str));
                    FavSearchActionView.c(FavSearchActionView.this);
                    if (FavSearchActionView.this.tmK != null) {
                        FavSearchActionView.this.tmK.a(FavSearchActionView.this.thn, FavSearchActionView.this.tmJ, FavSearchActionView.this.tmI, true);
                    }
                    AppMethodBeat.o(107532);
                }

                @Override // com.tencent.mm.ui.base.MMTagPanel.a
                public final void E(boolean z, int i2) {
                }
            });
        }
        if (this.hey != null) {
            this.hey.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(107533);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (FavSearchActionView.this.tmK == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107533);
                        return;
                    }
                    FavSearchActionView.this.tfS.gLh();
                    FavSearchActionView.this.tfS.gLc();
                    FavSearchActionView.this.tmJ.clear();
                    FavSearchActionView.this.tmI.clear();
                    FavSearchActionView.this.tmK.a(FavSearchActionView.this.thn, FavSearchActionView.this.tmJ, FavSearchActionView.this.tmI, true);
                    FavSearchActionView.c(FavSearchActionView.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107533);
                }
            });
        }
        AppMethodBeat.o(107535);
    }

    public final void asw(String str) {
        AppMethodBeat.i(107536);
        this.tmJ.clear();
        String[] split = Util.nullAs(str, "").split(" ");
        for (String str2 : split) {
            if (!Util.isNullOrNil(str2)) {
                this.tmJ.add(str2);
            }
        }
        AppMethodBeat.o(107536);
    }

    public void setOnSearchChangedListener(a aVar) {
        this.tmK = aVar;
    }

    public List<String> getSearchKeys() {
        AppMethodBeat.i(107537);
        if (this.tfS != null) {
            asw(this.tfS.getEditText());
        }
        List<String> list = this.tmJ;
        AppMethodBeat.o(107537);
        return list;
    }

    public List<String> getSearchTags() {
        return this.tmI;
    }

    private void cWS() {
        AppMethodBeat.i(107538);
        if (!this.thn.isEmpty() || !this.tmI.isEmpty()) {
            this.tfS.setEditHint("");
            AppMethodBeat.o(107538);
            return;
        }
        this.tfS.setEditHint(getResources().getString(R.string.yn));
        AppMethodBeat.o(107538);
    }

    public final void aj(int i2, boolean z) {
        AppMethodBeat.i(107539);
        this.thn.clear();
        this.thn.add(Integer.valueOf(i2));
        if (this.tfS == null) {
            AppMethodBeat.o(107539);
            return;
        }
        cWS();
        this.tfS.setType(Y(getContext(), i2));
        if (this.tmK == null) {
            AppMethodBeat.o(107539);
            return;
        }
        asw(this.tfS.getEditText());
        if (z) {
            this.tmK.a(this.thn, this.tmJ, this.tmI, false);
        }
        h.INSTANCE.a(11126, 1);
        AppMethodBeat.o(107539);
    }

    public static String Y(Context context, int i2) {
        AppMethodBeat.i(107540);
        if (context == null) {
            AppMethodBeat.o(107540);
            return "";
        }
        switch (i2) {
            case 3:
                String string = context.getString(R.string.ccn);
                AppMethodBeat.o(107540);
                return string;
            case 4:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 19:
            case 20:
            default:
                AppMethodBeat.o(107540);
                return "";
            case 5:
                String string2 = context.getString(R.string.ccl);
                AppMethodBeat.o(107540);
                return string2;
            case 6:
                String string3 = context.getString(R.string.cch);
                AppMethodBeat.o(107540);
                return string3;
            case 7:
                String string4 = context.getString(R.string.cci);
                AppMethodBeat.o(107540);
                return string4;
            case 8:
                String string5 = context.getString(R.string.ccc);
                AppMethodBeat.o(107540);
                return string5;
            case 17:
                String string6 = context.getString(R.string.cck);
                AppMethodBeat.o(107540);
                return string6;
            case 18:
                String string7 = context.getString(R.string.ccj);
                AppMethodBeat.o(107540);
                return string7;
            case 21:
                String string8 = context.getString(R.string.ccg);
                AppMethodBeat.o(107540);
                return string8;
        }
    }

    public static Integer az(Context context, String str) {
        AppMethodBeat.i(107541);
        if (context == null) {
            AppMethodBeat.o(107541);
            return -1;
        } else if (context.getString(R.string.ccg).equals(str)) {
            AppMethodBeat.o(107541);
            return 21;
        } else if (context.getString(R.string.ccl).equals(str)) {
            AppMethodBeat.o(107541);
            return 5;
        } else if (context.getString(R.string.ccc).equals(str)) {
            AppMethodBeat.o(107541);
            return 8;
        } else if (context.getString(R.string.cci).equals(str)) {
            AppMethodBeat.o(107541);
            return 7;
        } else if (context.getString(R.string.cck).equals(str)) {
            AppMethodBeat.o(107541);
            return 17;
        } else if (context.getString(R.string.ccn).equals(str)) {
            AppMethodBeat.o(107541);
            return 3;
        } else if (context.getString(R.string.ccj).equals(str)) {
            AppMethodBeat.o(107541);
            return 18;
        } else if (context.getString(R.string.cch).equals(str)) {
            AppMethodBeat.o(107541);
            return 6;
        } else {
            AppMethodBeat.o(107541);
            return -1;
        }
    }
}
