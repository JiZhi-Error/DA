package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.v;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget extends LinearLayout {
    private boolean EoA = false;
    private TextView Eow;
    private PreviewContactView Eox;
    SnsUploadConfigView Eoy;
    private List<String> Eoz = new LinkedList();
    private View contentView;
    private Activity mContext;
    private TextView pJV;
    private ImageView uzC;

    @TargetApi(11)
    public AtContactWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(97781);
        init(context);
        AppMethodBeat.o(97781);
    }

    public AtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97782);
        init(context);
        AppMethodBeat.o(97782);
    }

    public List<String> getAtList() {
        AppMethodBeat.i(97783);
        if (this.Eoz == null) {
            this.Eoz = new LinkedList();
        }
        List<String> list = this.Eoz;
        AppMethodBeat.o(97783);
        return list;
    }

    public final void ffm() {
        AppMethodBeat.i(97784);
        if (this.Eoz == null) {
            this.Eoz = new LinkedList();
        }
        this.Eoz.clear();
        if (this.Eox != null) {
            this.Eox.setList(this.Eoz);
        }
        ffn();
        if (this.Eow != null) {
            this.Eow.setVisibility(8);
        }
        if (this.pJV != null) {
            this.pJV.setTextColor(getResources().getColor(R.color.a2x));
        }
        AppMethodBeat.o(97784);
    }

    private void init(Context context) {
        AppMethodBeat.i(97785);
        this.mContext = (Activity) context;
        this.contentView = aa.jQ(context).inflate(getLayoutResource(), this);
        this.Eox = (PreviewContactView) this.contentView.findViewById(R.id.v1);
        this.uzC = (ImageView) this.contentView.findViewById(R.id.v2);
        this.Eow = (TextView) this.contentView.findViewById(R.id.v4);
        this.pJV = (TextView) this.contentView.findViewById(R.id.v5);
        this.contentView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.AtContactWidget.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(97779);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/AtContactWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AtContactWidget.a(AtContactWidget.this);
                a.a(this, "com/tencent/mm/plugin/sns/ui/AtContactWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97779);
            }
        });
        this.contentView.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.AtContactWidget.AnonymousClass2 */

            public final void run() {
                int width;
                AppMethodBeat.i(97780);
                int i2 = (int) (BitmapUtil.getDefaultDisplayMetrics().density * 36.0f);
                if (i2 != 0 && (width = (((AtContactWidget.this.contentView.getWidth() - AtContactWidget.this.uzC.getWidth()) - AtContactWidget.this.pJV.getWidth()) - ((int) (BitmapUtil.getDefaultDisplayMetrics().density * 32.0f))) / i2) > 0 && width < 5) {
                    AtContactWidget.this.Eox.setLineNum(width);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) AtContactWidget.this.Eox.getLayoutParams();
                    layoutParams.alignWithParent = true;
                    AtContactWidget.this.Eox.setLayoutParams(layoutParams);
                }
                AppMethodBeat.o(97780);
            }
        });
        AppMethodBeat.o(97785);
    }

    public final boolean aY(Intent intent) {
        List<String> list;
        AppMethodBeat.i(97786);
        String stringExtra = intent.getStringExtra("Select_Contact");
        new LinkedList();
        if (stringExtra == null || stringExtra.equals("")) {
            list = new LinkedList();
        } else {
            list = Util.stringsToList(stringExtra.split(","));
        }
        if (this.Eoz == null) {
            this.Eoz = new LinkedList();
        }
        this.Eoz.clear();
        for (String str : list) {
            if (!this.Eoz.contains(str)) {
                this.Eoz.add(str);
            }
        }
        if (this.Eox != null) {
            this.Eox.setList(this.Eoz);
        }
        if (this.pJV != null) {
            this.pJV.setTextColor(getResources().getColor(list.isEmpty() ? R.color.a2x : R.color.ts));
        }
        if (this.EoA) {
            Log.d("MicroMsg.AtContactWiget", "withList count " + this.Eoz.size());
            if (!this.EoA || this.Eow == null || this.Eoz.size() <= 0) {
                this.Eow.setVisibility(8);
            } else {
                this.Eow.setVisibility(0);
                if (this.Eoz.size() < 100) {
                    this.Eow.setText(new StringBuilder().append(this.Eoz.size()).toString());
                    this.Eow.setBackgroundResource(v.aQ(getContext(), this.Eoz.size()));
                } else {
                    this.Eow.setText("");
                    this.Eow.setBackgroundResource(R.raw.badge_count_more);
                }
            }
        }
        ffn();
        AppMethodBeat.o(97786);
        return true;
    }

    private void ffn() {
        AppMethodBeat.i(97787);
        if (this.Eoz.size() > 0) {
            this.uzC.setImageDrawable(ar.m(this.mContext, getWithDrawableId(), getContext().getResources().getColor(R.color.afp)));
            AppMethodBeat.o(97787);
            return;
        }
        this.uzC.setImageDrawable(ar.m(this.mContext, getWithEmptyDrawableId(), getContext().getResources().getColor(R.color.vm)));
        AppMethodBeat.o(97787);
    }

    public void setShowAtList(boolean z) {
        AppMethodBeat.i(97788);
        if (this.Eox != null) {
            this.Eox.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.o(97788);
    }

    public void setShowAtTips(boolean z) {
        AppMethodBeat.i(97789);
        if (!(this.contentView == null || this.pJV == null)) {
            this.pJV.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.o(97789);
    }

    public void setShowAtNum(boolean z) {
        this.EoA = z;
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.h7;
    }

    /* access modifiers changed from: protected */
    public int getWithDrawableId() {
        return R.raw.album_mention_icon_pressed;
    }

    /* access modifiers changed from: protected */
    public int getWithEmptyDrawableId() {
        return R.raw.album_mention_icon_normal;
    }

    static /* synthetic */ void a(AtContactWidget atContactWidget) {
        AppMethodBeat.i(97790);
        if (atContactWidget.Eoz == null) {
            atContactWidget.Eoz = new LinkedList();
        }
        if (atContactWidget.Eoy == null || atContactWidget.Eoy.getPrivated() <= 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Compose", true);
            intent.putExtra("List_Type", 1);
            intent.putExtra("Add_address_titile", atContactWidget.mContext.getString(R.string.hcc));
            intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
            intent.putExtra("Block_list", z.aTY());
            intent.putExtra("Select_Contact", Util.listToString(atContactWidget.Eoz, ","));
            intent.putExtra("sns_address_count", 0);
            com.tencent.mm.plugin.sns.c.a.jRt.a(intent, atContactWidget.mContext, 6);
            AppMethodBeat.o(97790);
            return;
        }
        h.n(atContactWidget.mContext, R.string.haq, R.string.zb);
        AppMethodBeat.o(97790);
    }
}
