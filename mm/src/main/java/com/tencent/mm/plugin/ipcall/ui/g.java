package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.e;
import com.tencent.mm.plugin.ipcall.model.e.m;
import com.tencent.mm.plugin.ipcall.model.f.d;
import com.tencent.mm.plugin.ipcall.model.h.f;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.ewh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g extends i {
    private CharSequence Hn;
    View jBN;
    private ScrollView lTw;
    private Activity mActivity;
    private Context mContext;
    private MMHandler mHandler = new MMHandler();
    private ArrayList<a> mItemList;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(25771);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view == g.this.yvO) {
                g.a(g.this, 1);
            } else if (view == g.this.yvP) {
                g.a(g.this, 2);
            } else if (view == g.this.yvQ) {
                g.a(g.this, 3);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25771);
        }
    };
    private int thx = R.color.pc;
    private int thy = R.drawable.wo;
    private int yvJ = 0;
    private int yvK;
    private long yvL;
    private LinearLayout yvM;
    private LinearLayout yvN;
    private RelativeLayout yvO;
    private RelativeLayout yvP;
    private RelativeLayout yvQ;
    private ImageView yvR;
    private ImageView yvS;
    private ImageView yvT;
    private int yvU;
    private FrameLayout yvV;
    private FlowLayout yvW;
    private Button yvX;
    private Button yvY;
    private PasterEditText yvZ;
    private Button ywa;
    private Button ywb;
    private TextView ywc;
    private Animation ywd;
    private int ywe = R.drawable.wl;
    private int ywf = R.color.ag2;

    public static class a {
        public String Id;
        public String xJH;
        public boolean ywh;
    }

    static /* synthetic */ void a(g gVar, int i2) {
        AppMethodBeat.i(25786);
        gVar.Pi(i2);
        AppMethodBeat.o(25786);
    }

    static /* synthetic */ String b(g gVar, int i2) {
        AppMethodBeat.i(25789);
        String Pj = gVar.Pj(i2);
        AppMethodBeat.o(25789);
        return Pj;
    }

    public g(Activity activity, Context context, int i2, long j2) {
        super(context, R.style.a66);
        f fVar;
        String str;
        String str2;
        AppMethodBeat.i(25778);
        setCancelable(false);
        this.mContext = context;
        this.yvK = i2;
        this.yvL = j2;
        this.mActivity = activity;
        this.jBN = View.inflate(this.mContext, R.layout.awv, null);
        this.yvM = (LinearLayout) this.jBN.findViewById(R.id.e9b);
        this.yvN = (LinearLayout) this.jBN.findViewById(R.id.e9c);
        this.ywd = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.n);
        this.ywd.setDuration(200);
        this.ywd.setStartOffset(100);
        this.yvV = (FrameLayout) this.jBN.findViewById(R.id.d6g);
        this.yvW = (FlowLayout) this.jBN.findViewById(R.id.d6f);
        this.yvX = (Button) this.jBN.findViewById(R.id.b_8);
        this.yvY = (Button) this.jBN.findViewById(R.id.b_9);
        this.yvZ = (PasterEditText) this.jBN.findViewById(R.id.b_h);
        this.yvX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(25772);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.dismiss();
                d.a(-1, 1, -1, "", 0, -1, -1, g.this.yvK, g.this.yvL);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25772);
            }
        });
        this.yvY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(25773);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.g(g.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25773);
            }
        });
        e eak = e.eak();
        if (eak.yoE == null) {
            Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
            com.tencent.mm.pluginsdk.j.a.a.b.gnC();
            String kC = com.tencent.mm.pluginsdk.j.a.a.b.kC(39, 1);
            if (!Util.isNullOrNil(kC)) {
                byte[] aW = s.aW(kC, 0, -1);
                if (aW != null) {
                    eak.bG(aW);
                } else {
                    Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
                }
            } else {
                Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
            }
        }
        if (eak.yoE != null) {
            String loadApplicationLanguageSettings = LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
            if (!LocaleUtil.LANGUAGE_DEFAULT.equalsIgnoreCase(loadApplicationLanguageSettings) || Locale.getDefault() == null) {
                str2 = loadApplicationLanguageSettings;
            } else {
                str2 = Locale.getDefault().toString();
            }
            Iterator<f> it = eak.yoE.iterator();
            while (it.hasNext()) {
                fVar = it.next();
                if (str2.equalsIgnoreCase(fVar.ysG)) {
                    Log.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", str2, Integer.valueOf(eak.yoE.size()));
                    break;
                }
            }
            Log.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", str2, Integer.valueOf(eak.yoE.size()));
        }
        fVar = null;
        if (fVar != null) {
            ArrayList<com.tencent.mm.plugin.ipcall.model.h.e> arrayList = fVar.ysH;
            ArrayList<a> arrayList2 = new ArrayList<>();
            Iterator<com.tencent.mm.plugin.ipcall.model.h.e> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.mm.plugin.ipcall.model.h.e next = it2.next();
                a aVar = new a();
                aVar.Id = next.Id;
                aVar.xJH = next.xJH;
                aVar.ywh = false;
                arrayList2.add(aVar);
            }
            this.mItemList = arrayList2;
            Iterator<a> it3 = this.mItemList.iterator();
            while (it3.hasNext()) {
                a next2 = it3.next();
                FlowLayout flowLayout = this.yvW;
                TextView textView = new TextView(getContext());
                textView.setTextSize(0, getContext().getResources().getDimension(R.dimen.a4g) * com.tencent.mm.cb.a.ez(getContext()));
                textView.setBackgroundResource(this.thy);
                textView.setTextColor(this.mContext.getResources().getColor(this.thx));
                textView.setTag(next2);
                textView.setGravity(17);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setSingleLine();
                textView.setText(next2.xJH);
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass6 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(25774);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        a aVar = (a) view.getTag();
                        if (!aVar.ywh) {
                            aVar.ywh = true;
                        } else {
                            aVar.ywh = false;
                        }
                        g.a(g.this, (TextView) view);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(25774);
                    }
                });
                flowLayout.addView(textView);
            }
        }
        this.yvO = (RelativeLayout) this.jBN.findViewById(R.id.e9g);
        this.yvP = (RelativeLayout) this.jBN.findViewById(R.id.e9h);
        this.yvQ = (RelativeLayout) this.jBN.findViewById(R.id.e9i);
        this.yvO.setOnClickListener(this.mOnClickListener);
        this.yvP.setOnClickListener(this.mOnClickListener);
        this.yvQ.setOnClickListener(this.mOnClickListener);
        this.yvR = (ImageView) this.jBN.findViewById(R.id.dx7);
        this.yvS = (ImageView) this.jBN.findViewById(R.id.dx8);
        this.yvT = (ImageView) this.jBN.findViewById(R.id.dx9);
        this.yvU = 0;
        Pi(this.yvU);
        this.ywa = (Button) this.jBN.findViewById(R.id.dzh);
        this.ywb = (Button) this.jBN.findViewById(R.id.dzi);
        this.ywc = (TextView) this.jBN.findViewById(R.id.dzk);
        byf ebR = c.ebR();
        if (ebR != null) {
            str = String.format(this.mContext.getString(R.string.e9b), ebR.MdN);
        } else {
            str = null;
        }
        if (Util.isNullOrNil(str)) {
            this.ywc.setVisibility(4);
        } else {
            this.ywc.setVisibility(0);
            this.ywc.setText(str);
        }
        this.ywa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(25775);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.dismiss();
                d.a(1, -1, g.this.yvU, g.b(g.this, g.this.yvU), 1, -1, 1, g.this.yvK, g.this.yvL);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25775);
            }
        });
        this.ywb.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(25776);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.dismiss();
                Intent intent = new Intent();
                intent.putExtra("IPCallShareCouponCardUI_KFrom", 2);
                intent.setClass(g.this.mContext, IPCallShareCouponCardUI.class);
                Context context = g.this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                d.a(1, -1, g.this.yvU, g.b(g.this, g.this.yvU), 1, 1, -1, g.this.yvK, g.this.yvL);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(25776);
            }
        });
        this.lTw = (ScrollView) this.jBN.findViewById(R.id.cfc);
        final View childAt = ((ViewGroup) this.mActivity.findViewById(16908290)).getChildAt(0);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(25769);
                Rect rect = new Rect();
                childAt.getWindowVisibleDisplayFrame(rect);
                if (childAt.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
                    g gVar = g.this;
                    gVar.jBN.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(25770);
                            g.this.lTw.fullScroll(130);
                            AppMethodBeat.o(25770);
                        }
                    }, 100);
                }
                AppMethodBeat.o(25769);
            }
        });
        AppMethodBeat.o(25778);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(25779);
        super.onCreate(bundle);
        setContentView(this.jBN);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        Pl(0);
        AppMethodBeat.o(25779);
    }

    private void Pi(int i2) {
        AppMethodBeat.i(25780);
        this.yvU = i2;
        if (i2 == 0) {
            this.yvR.setVisibility(4);
            this.yvS.setVisibility(4);
            this.yvT.setVisibility(4);
            this.yvY.setEnabled(false);
            Pl(0);
            AppMethodBeat.o(25780);
        } else if (i2 == 1) {
            this.yvR.setVisibility(0);
            this.yvS.setVisibility(4);
            this.yvT.setVisibility(4);
            this.yvY.setEnabled(true);
            Pl(1);
            AppMethodBeat.o(25780);
        } else if (i2 == 2) {
            this.yvR.setVisibility(0);
            this.yvS.setVisibility(0);
            this.yvT.setVisibility(4);
            this.yvY.setEnabled(true);
            Pl(1);
            AppMethodBeat.o(25780);
        } else {
            if (i2 == 3) {
                this.yvR.setVisibility(0);
                this.yvS.setVisibility(0);
                this.yvT.setVisibility(0);
                this.yvY.setEnabled(true);
                Pl(0);
            }
            AppMethodBeat.o(25780);
        }
    }

    private String Pj(int i2) {
        String str;
        AppMethodBeat.i(25781);
        String str2 = "";
        if (i2 == 3) {
            AppMethodBeat.o(25781);
            return "";
        }
        if (!Util.isNullOrNil(this.yvZ.getText().toString().trim())) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (this.mItemList != null) {
            Iterator<a> it = this.mItemList.iterator();
            while (true) {
                str = str2;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (!next.ywh) {
                    str2 = str;
                } else if (str.equals("")) {
                    str2 = next.Id;
                } else {
                    str2 = str + "_" + next.Id;
                }
            }
        } else {
            str = str2;
        }
        AppMethodBeat.o(25781);
        return str;
    }

    private LinkedList<ewh> Pk(int i2) {
        AppMethodBeat.i(25782);
        LinkedList<ewh> linkedList = new LinkedList<>();
        if (i2 == 3) {
            AppMethodBeat.o(25782);
            return linkedList;
        }
        String trim = this.yvZ.getText().toString().trim();
        if (!Util.isNullOrNil(trim)) {
            ewh ewh = new ewh();
            ewh.ID = 0;
            ewh.iAc = trim;
            linkedList.add(ewh);
        }
        if (this.mItemList != null) {
            Iterator<a> it = this.mItemList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.ywh) {
                    ewh ewh2 = new ewh();
                    try {
                        ewh2.ID = Util.getInt(next.Id, 0);
                        linkedList.add(ewh2);
                    } catch (NumberFormatException e2) {
                        Log.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + next.Id);
                    }
                }
            }
        }
        AppMethodBeat.o(25782);
        return linkedList;
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.Hn = charSequence;
        } else {
            this.Hn = null;
        }
    }

    @Override // com.tencent.mm.ui.base.i
    public final void show() {
        AppMethodBeat.i(25783);
        super.show();
        AppMethodBeat.o(25783);
    }

    @Override // com.tencent.mm.ui.base.i
    public final void dismiss() {
        AppMethodBeat.i(25784);
        try {
            super.dismiss();
            AppMethodBeat.o(25784);
        } catch (Exception e2) {
            Log.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(25784);
        }
    }

    private void Pl(int i2) {
        AppMethodBeat.i(25785);
        if (i2 == 0) {
            this.yvM.setVisibility(0);
            this.yvN.setVisibility(4);
            if (this.yvJ == 1) {
                ((LinearLayout.LayoutParams) this.yvV.getLayoutParams()).height = 0;
                this.yvV.requestLayout();
            }
            Util.hideVKB(this.jBN);
        } else if (i2 == 1) {
            this.yvM.setVisibility(0);
            this.yvN.setVisibility(4);
            if (this.yvJ == 0) {
                ((LinearLayout.LayoutParams) this.yvV.getLayoutParams()).height = -2;
                this.yvV.requestLayout();
                this.yvV.startAnimation(this.ywd);
            }
        } else if (i2 == 2) {
            this.yvM.setVisibility(4);
            this.yvN.setVisibility(0);
            Util.hideVKB(this.jBN);
        }
        this.yvJ = i2;
        AppMethodBeat.o(25785);
    }

    static /* synthetic */ void g(g gVar) {
        AppMethodBeat.i(25787);
        bg.azz().a(new m(gVar.yvK, gVar.yvU, gVar.Pk(gVar.yvU)), 0);
        if (gVar.yvU == 3) {
            gVar.Pl(2);
            AppMethodBeat.o(25787);
            return;
        }
        gVar.hide();
        gVar.mHandler.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.ipcall.ui.g.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(25777);
                g.this.dismiss();
                AppMethodBeat.o(25777);
            }
        }, 1800);
        com.tencent.mm.ui.widget.snackbar.b.r(gVar.mActivity, gVar.mContext.getString(R.string.e8f));
        d.a(1, -1, gVar.yvU, gVar.Pj(gVar.yvU), 0, -1, -1, gVar.yvK, gVar.yvL);
        AppMethodBeat.o(25787);
    }

    static /* synthetic */ void a(g gVar, TextView textView) {
        AppMethodBeat.i(25788);
        textView.setTextSize(0, gVar.getContext().getResources().getDimension(R.dimen.a4g) * com.tencent.mm.cb.a.ez(gVar.getContext()));
        if (((a) textView.getTag()).ywh) {
            textView.setBackgroundResource(gVar.ywe);
            textView.setTextColor(gVar.mContext.getResources().getColor(gVar.ywf));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            AppMethodBeat.o(25788);
            return;
        }
        textView.setBackgroundResource(gVar.thy);
        textView.setTextColor(gVar.mContext.getResources().getColor(gVar.thx));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        AppMethodBeat.o(25788);
    }
}
